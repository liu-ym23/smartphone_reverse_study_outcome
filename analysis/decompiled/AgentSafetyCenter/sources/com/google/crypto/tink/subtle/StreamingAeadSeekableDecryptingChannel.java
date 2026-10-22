package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {
    private static final int PLAINTEXT_SEGMENT_EXTRA_SIZE = 16;
    private final byte[] aad;
    private final SeekableByteChannel ciphertextChannel;
    private final long ciphertextChannelSize;
    private final int ciphertextOffset;
    private final ByteBuffer ciphertextSegment;
    private final int ciphertextSegmentSize;
    private int currentSegmentNr;
    private final StreamSegmentDecrypter decrypter;
    private final int firstSegmentOffset;
    private final ByteBuffer header;
    private boolean headerRead;
    private boolean isCurrentSegmentDecrypted;
    private boolean isopen;
    private final int lastCiphertextSegmentSize;
    private final int numberOfSegments;
    private long plaintextPosition;
    private final ByteBuffer plaintextSegment;
    private final int plaintextSegmentSize;
    private long plaintextSize;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this.decrypter = nonceBasedStreamingAead.newStreamSegmentDecrypter();
        this.ciphertextChannel = seekableByteChannel;
        this.header = ByteBuffer.allocate(nonceBasedStreamingAead.getHeaderLength());
        int ciphertextSegmentSize = nonceBasedStreamingAead.getCiphertextSegmentSize();
        this.ciphertextSegmentSize = ciphertextSegmentSize;
        this.ciphertextSegment = ByteBuffer.allocate(ciphertextSegmentSize);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.plaintextSegment = ByteBuffer.allocate(plaintextSegmentSize + 16);
        this.plaintextPosition = 0L;
        this.headerRead = false;
        this.currentSegmentNr = -1;
        this.isCurrentSegmentDecrypted = false;
        long size = seekableByteChannel.size();
        this.ciphertextChannelSize = size;
        this.aad = Arrays.copyOf(bArr, bArr.length);
        this.isopen = seekableByteChannel.isOpen();
        int i = (int) (size / ciphertextSegmentSize);
        int i3 = (int) (size % ciphertextSegmentSize);
        int ciphertextOverhead = nonceBasedStreamingAead.getCiphertextOverhead();
        if (i3 > 0) {
            this.numberOfSegments = i + 1;
            if (i3 < ciphertextOverhead) {
                f.l("Invalid ciphertext size");
                throw null;
            }
            this.lastCiphertextSegmentSize = i3;
        } else {
            this.numberOfSegments = i;
            this.lastCiphertextSegmentSize = ciphertextSegmentSize;
        }
        int ciphertextOffset = nonceBasedStreamingAead.getCiphertextOffset();
        this.ciphertextOffset = ciphertextOffset;
        int headerLength = ciphertextOffset - nonceBasedStreamingAead.getHeaderLength();
        this.firstSegmentOffset = headerLength;
        if (headerLength < 0) {
            f.l("Invalid ciphertext offset or header length");
            throw null;
        }
        long j10 = (this.numberOfSegments * ciphertextOverhead) + ciphertextOffset;
        if (j10 <= size) {
            this.plaintextSize = size - j10;
        } else {
            f.l("Ciphertext is too short");
            throw null;
        }
    }

    private int getSegmentNr(long j10) {
        return (int) ((j10 + this.ciphertextOffset) / this.plaintextSegmentSize);
    }

    private boolean reachedEnd() {
        return this.isCurrentSegmentDecrypted && this.currentSegmentNr == this.numberOfSegments - 1 && this.plaintextSegment.remaining() == 0;
    }

    private boolean tryLoadSegment(int i) throws IOException {
        int i3;
        if (i < 0 || i >= (i3 = this.numberOfSegments)) {
            f.l("Invalid position");
            return false;
        }
        boolean z10 = i == i3 - 1;
        if (i != this.currentSegmentNr) {
            int i10 = this.ciphertextSegmentSize;
            long j10 = i * i10;
            if (z10) {
                i10 = this.lastCiphertextSegmentSize;
            }
            if (i == 0) {
                int i11 = this.ciphertextOffset;
                i10 -= i11;
                j10 = i11;
            }
            this.ciphertextChannel.position(j10);
            this.ciphertextSegment.clear();
            this.ciphertextSegment.limit(i10);
            this.currentSegmentNr = i;
            this.isCurrentSegmentDecrypted = false;
        } else if (this.isCurrentSegmentDecrypted) {
            return true;
        }
        if (this.ciphertextSegment.remaining() > 0) {
            this.ciphertextChannel.read(this.ciphertextSegment);
        }
        if (this.ciphertextSegment.remaining() > 0) {
            return false;
        }
        this.ciphertextSegment.flip();
        this.plaintextSegment.clear();
        try {
            this.decrypter.decryptSegment(this.ciphertextSegment, i, z10, this.plaintextSegment);
            this.plaintextSegment.flip();
            this.isCurrentSegmentDecrypted = true;
            return true;
        } catch (GeneralSecurityException e10) {
            this.currentSegmentNr = -1;
            throw new IOException("Failed to decrypt", e10);
        }
    }

    private boolean tryReadHeader() throws IOException {
        this.ciphertextChannel.position(this.header.position() + this.firstSegmentOffset);
        this.ciphertextChannel.read(this.header);
        if (this.header.remaining() > 0) {
            return false;
        }
        this.header.flip();
        try {
            this.decrypter.init(this.header, this.aad);
            this.headerRead = true;
            return true;
        } catch (GeneralSecurityException e10) {
            throw new IOException(e10);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
        this.isopen = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.isopen;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.plaintextPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (!this.isopen) {
            throw new ClosedChannelException();
        }
        if (!this.headerRead && !tryReadHeader()) {
            return 0;
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.remaining() > 0) {
            long j10 = this.plaintextPosition;
            if (j10 >= this.plaintextSize) {
                break;
            }
            int segmentNr = getSegmentNr(j10);
            long j11 = this.plaintextPosition;
            if (segmentNr != 0) {
                j11 = (j11 + this.ciphertextOffset) % this.plaintextSegmentSize;
            }
            int i = (int) j11;
            if (!tryLoadSegment(segmentNr)) {
                break;
            }
            this.plaintextSegment.position(i);
            if (this.plaintextSegment.remaining() <= byteBuffer.remaining()) {
                this.plaintextPosition += this.plaintextSegment.remaining();
                byteBuffer.put(this.plaintextSegment);
            } else {
                int iRemaining = byteBuffer.remaining();
                ByteBuffer byteBufferDuplicate = this.plaintextSegment.duplicate();
                byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                byteBuffer.put(byteBufferDuplicate);
                this.plaintextPosition += iRemaining;
                ByteBuffer byteBuffer2 = this.plaintextSegment;
                byteBuffer2.position(byteBuffer2.position() + iRemaining);
            }
        }
        int iPosition2 = byteBuffer.position() - iPosition;
        if (iPosition2 == 0 && reachedEnd()) {
            return -1;
        }
        return iPosition2;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.plaintextSize;
    }

    public synchronized String toString() {
        StringBuilder sb2;
        String str;
        sb2 = new StringBuilder();
        try {
            str = "position:" + this.ciphertextChannel.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb2.append("StreamingAeadSeekableDecryptingChannel\nciphertextChannel");
        sb2.append(str);
        sb2.append("\nciphertextChannelSize:");
        sb2.append(this.ciphertextChannelSize);
        sb2.append("\nplaintextSize:");
        sb2.append(this.plaintextSize);
        sb2.append("\nciphertextSegmentSize:");
        sb2.append(this.ciphertextSegmentSize);
        sb2.append("\nnumberOfSegments:");
        sb2.append(this.numberOfSegments);
        sb2.append("\nheaderRead:");
        sb2.append(this.headerRead);
        sb2.append("\nplaintextPosition:");
        sb2.append(this.plaintextPosition);
        sb2.append("\nHeader position:");
        sb2.append(this.header.position());
        sb2.append(" limit:");
        sb2.append(this.header.position());
        sb2.append("\ncurrentSegmentNr:");
        sb2.append(this.currentSegmentNr);
        sb2.append("\nciphertextSgement position:");
        sb2.append(this.ciphertextSegment.position());
        sb2.append(" limit:");
        sb2.append(this.ciphertextSegment.limit());
        sb2.append("\nisCurrentSegmentDecrypted:");
        sb2.append(this.isCurrentSegmentDecrypted);
        sb2.append("\nplaintextSegment position:");
        sb2.append(this.plaintextSegment.position());
        sb2.append(" limit:");
        sb2.append(this.plaintextSegment.limit());
        return sb2.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j10) {
        throw new NonWritableChannelException();
    }

    public synchronized long verifiedSize() {
        if (!tryLoadSegment(this.numberOfSegments - 1)) {
            throw new IOException("could not verify the size");
        }
        return this.plaintextSize;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j10) {
        this.plaintextPosition = j10;
        return this;
    }

    public synchronized int read(ByteBuffer byteBuffer, long j10) {
        long jPosition = position();
        try {
            position(j10);
        } finally {
            position(jPosition);
        }
        return read(byteBuffer);
    }
}
