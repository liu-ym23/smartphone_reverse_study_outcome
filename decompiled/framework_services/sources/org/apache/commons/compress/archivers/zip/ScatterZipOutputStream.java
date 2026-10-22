package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.utils.BoundedInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ScatterZipOutputStream implements Closeable {
    private final ScatterGatherBackingStore backingStore;
    private final Queue<CompressedEntry> items;
    private final StreamCompressor streamCompressor;

    private static class CompressedEntry {
        final long compressedSize;
        final long crc;
        final long size;
        final ZipArchiveEntryRequest zipArchiveEntryRequest;

        public CompressedEntry(ZipArchiveEntryRequest zipArchiveEntryRequest, long crc, long compressedSize, long size) {
            this.zipArchiveEntryRequest = zipArchiveEntryRequest;
            this.crc = crc;
            this.compressedSize = compressedSize;
            this.size = size;
        }

        public ZipArchiveEntry transferToArchiveEntry() {
            ZipArchiveEntry entry = this.zipArchiveEntryRequest.getZipArchiveEntry();
            entry.setCompressedSize(this.compressedSize);
            entry.setSize(this.size);
            entry.setCrc(this.crc);
            entry.setMethod(this.zipArchiveEntryRequest.getMethod());
            return entry;
        }
    }

    public ScatterZipOutputStream(ScatterGatherBackingStore backingStore, StreamCompressor streamCompressor) {
        this.items = new ConcurrentLinkedQueue();
        this.backingStore = backingStore;
        this.streamCompressor = streamCompressor;
    }

    public void addArchiveEntry(ZipArchiveEntryRequest zipArchiveEntryRequest) throws IOException {
        InputStream payloadStream = zipArchiveEntryRequest.getPayloadStream();
        this.streamCompressor.deflate(payloadStream, zipArchiveEntryRequest.getMethod());     // Catch: Throwable -> L8
        if (payloadStream == null) goto L6;
        payloadStream.close();
    L6:
        this.items.add(new CompressedEntry(zipArchiveEntryRequest, this.streamCompressor.getCrc32(), this.streamCompressor.getBytesWrittenForLastEntry(), this.streamCompressor.getBytesRead()));
        return;
    L8:
        th = move-exception;
        if (payloadStream == null) goto L20;
        payloadStream.close();     // Catch: Throwable -> L13
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L20:
        throw th;
    }

    public void writeTo(ZipArchiveOutputStream target) throws IOException {
        this.backingStore.closeForWriting();
        InputStream data = this.backingStore.getInputStream();
        Iterator<CompressedEntry> r1 = this.items.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L18;
        CompressedEntry compressedEntry = r1.next();     // Catch: Throwable -> L10
        BoundedInputStream rawStream = new BoundedInputStream(data, compressedEntry.compressedSize);     // Catch: Throwable -> L10
        target.addRawArchiveEntry(compressedEntry.transferToArchiveEntry(), rawStream);     // Catch: Throwable -> L12
        rawStream.close();     // Catch: Throwable -> L10
        goto L5
    L12:
        th = move-exception;
        rawStream.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L10
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10
        goto L17
    L18:
        if (data == null) goto L36;
        data.close();
        return;
    L36:
        return;
    L10:
        th = move-exception;
        if (data != null) goto L31;
    L26:
        throw th;
    L31:
        data.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.backingStore.close();     // Catch: Throwable -> L5
        this.streamCompressor.close();
        return;
    L5:
        th = move-exception;
        this.streamCompressor.close();
        throw th;
    }

    public static ScatterZipOutputStream fileBased(File file) throws FileNotFoundException {
        return fileBased(file, -1);
    }

    public static ScatterZipOutputStream fileBased(File file, int compressionLevel) throws FileNotFoundException {
        ScatterGatherBackingStore bs = new FileBasedScatterGatherBackingStore(file);
        StreamCompressor sc = StreamCompressor.create(compressionLevel, bs);
        return new ScatterZipOutputStream(bs, sc);
    }
}
