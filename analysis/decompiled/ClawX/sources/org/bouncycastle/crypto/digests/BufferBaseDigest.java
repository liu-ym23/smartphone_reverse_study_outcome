package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
abstract class BufferBaseDigest implements ExtendedDigest {
    protected int BlockSize;
    protected int DigestSize;
    protected String algorithmName;
    protected byte[] m_buf;
    protected int m_bufPos;
    protected ProcessingBuffer processor;

    public class BufferedProcessor implements ProcessingBuffer {
        private BufferedProcessor() {
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i8, int i9) {
            return i8 > i9;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i8, int i9) {
            return i8 <= i9;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public void update(byte b9) {
            BufferBaseDigest bufferBaseDigest = BufferBaseDigest.this;
            if (bufferBaseDigest.m_bufPos == bufferBaseDigest.BlockSize) {
                bufferBaseDigest.processBytes(bufferBaseDigest.m_buf, 0);
                BufferBaseDigest.this.m_bufPos = 0;
            }
            BufferBaseDigest bufferBaseDigest2 = BufferBaseDigest.this;
            byte[] bArr = bufferBaseDigest2.m_buf;
            int i8 = bufferBaseDigest2.m_bufPos;
            bufferBaseDigest2.m_bufPos = i8 + 1;
            bArr[i8] = b9;
        }
    }

    public class ImmediateProcessor implements ProcessingBuffer {
        private ImmediateProcessor() {
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthExceedingBlockSize(int i8, int i9) {
            return i8 >= i9;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public boolean isLengthWithinAvailableSpace(int i8, int i9) {
            return i8 < i9;
        }

        @Override // org.bouncycastle.crypto.digests.BufferBaseDigest.ProcessingBuffer
        public void update(byte b9) {
            BufferBaseDigest bufferBaseDigest = BufferBaseDigest.this;
            byte[] bArr = bufferBaseDigest.m_buf;
            int i8 = bufferBaseDigest.m_bufPos;
            bArr[i8] = b9;
            int i9 = i8 + 1;
            bufferBaseDigest.m_bufPos = i9;
            if (i9 == bufferBaseDigest.BlockSize) {
                bufferBaseDigest.processBytes(bArr, 0);
                BufferBaseDigest.this.m_bufPos = 0;
            }
        }
    }

    public interface ProcessingBuffer {
        boolean isLengthExceedingBlockSize(int i8, int i9);

        boolean isLengthWithinAvailableSpace(int i8, int i9);

        void update(byte b9);
    }

    public static class ProcessingBufferType {
        public static final int BUFFERED = 0;
        public static final int IMMEDIATE = 1;
        private final int ord;
        public static final ProcessingBufferType Buffered = new ProcessingBufferType(0);
        public static final ProcessingBufferType Immediate = new ProcessingBufferType(1);

        public ProcessingBufferType(int i8) {
            this.ord = i8;
        }
    }

    public BufferBaseDigest(ProcessingBufferType processingBufferType, int i8) {
        ProcessingBuffer bufferedProcessor;
        this.BlockSize = i8;
        this.m_buf = new byte[i8];
        int i9 = processingBufferType.ord;
        if (i9 == 0) {
            bufferedProcessor = new BufferedProcessor();
        } else if (i9 != 1) {
            return;
        } else {
            bufferedProcessor = new ImmediateProcessor();
        }
        this.processor = bufferedProcessor;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        ensureSufficientOutputBuffer(bArr, i8);
        finish(bArr, i8);
        reset();
        return this.DigestSize;
    }

    public void ensureSufficientInputBuffer(byte[] bArr, int i8, int i9) {
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
    }

    public void ensureSufficientOutputBuffer(byte[] bArr, int i8) {
        if (this.DigestSize + i8 > bArr.length) {
            throw new OutputLengthException("output buffer is too short");
        }
    }

    public abstract void finish(byte[] bArr, int i8);

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.BlockSize;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.DigestSize;
    }

    public abstract void processBytes(byte[] bArr, int i8);

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        Arrays.clear(this.m_buf);
        this.m_bufPos = 0;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        this.processor.update(b9);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        ensureSufficientInputBuffer(bArr, i8, i9);
        int i10 = this.BlockSize - this.m_bufPos;
        if (this.processor.isLengthWithinAvailableSpace(i9, i10)) {
            System.arraycopy(bArr, i8, this.m_buf, this.m_bufPos, i9);
            this.m_bufPos += i9;
            return;
        }
        int i11 = this.m_bufPos;
        if (i11 > 0) {
            System.arraycopy(bArr, i8, this.m_buf, i11, i10);
            i8 += i10;
            i9 -= i10;
            processBytes(this.m_buf, 0);
        }
        while (this.processor.isLengthExceedingBlockSize(i9, this.BlockSize)) {
            processBytes(bArr, i8);
            int i12 = this.BlockSize;
            i8 += i12;
            i9 -= i12;
        }
        System.arraycopy(bArr, i8, this.m_buf, 0, i9);
        this.m_bufPos = i9;
    }
}
