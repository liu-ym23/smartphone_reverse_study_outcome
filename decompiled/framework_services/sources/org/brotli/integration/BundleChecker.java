package org.brotli.integration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.brotli.dec.BrotliInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BundleChecker implements Runnable {
    private final InputStream input;
    private final AtomicInteger nextJob;
    private final boolean sanityCheck;

    public BundleChecker(InputStream input, AtomicInteger nextJob, boolean sanityCheck) {
        this.input = input;
        this.nextJob = nextJob;
        this.sanityCheck = sanityCheck;
    }

    private long decompressAndCalculateCrc(final ZipInputStream input) throws IOException {
        FilterInputStream entryStream = new AnonymousClass1(this, input);
        BrotliInputStream decompressedStream = new BrotliInputStream(entryStream);
        long crc = BundleHelper.fingerprintStream(decompressedStream);     // Catch: Throwable -> L6
        decompressedStream.close();
        return crc;
    L6:
        th = move-exception;
        decompressedStream.close();
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        String entryName = "";
        ZipInputStream zis = new ZipInputStream(this.input);
        int entryIndex = 0;
        int jobIndex = this.nextJob.getAndIncrement();     // Catch: Throwable -> L12
    L4:
        ZipEntry entry = zis.getNextEntry();     // Catch: Throwable -> L12
        if (entry == null) goto L31;
        if (entry.isDirectory() == true) goto L4;
        int entryIndex2 = entryIndex + 1;     // Catch: Throwable -> L12
        if (entryIndex != jobIndex) goto L11;
        entryName = entry.getName();     // Catch: Throwable -> L12
        long entryCrc = BundleHelper.getExpectedFingerprint(entryName);     // Catch: Throwable -> L12
    L22:
        iox = move-exception;
        if (this.sanityCheck == false) goto L30;
    L28:
        zis.closeEntry();     // Catch: Throwable -> L12
        jobIndex = this.nextJob.getAndIncrement();     // Catch: Throwable -> L12
        entryIndex = entryIndex2;
        goto L4
    L30:
        throw new RuntimeException("Decompression failed", iox);     // Catch: Throwable -> L12
    L16:
        if (entryCrc == decompressAndCalculateCrc(zis)) goto L28;
        if (this.sanityCheck == true) goto L28;
        throw new RuntimeException("CRC mismatch");     // Catch: Throwable -> L12 IOException -> L22
    L11:
        zis.closeEntry();     // Catch: Throwable -> L12
        entryIndex = entryIndex2;
        goto L4
    L31:
        zis.close();     // Catch: Throwable -> L12
        this.input.close();     // Catch: Throwable -> L12
        return;
    L12:
        ex = move-exception;
        throw new RuntimeException(entryName, ex);
    }

    public static void main(String[] args) throws FileNotFoundException {
        int argsOffset = 0;
        boolean sanityCheck = false;
        if (args.length == 0) goto L8;
        if (args[0].equals("-s") == false) goto L8;
        sanityCheck = true;
        argsOffset = 1;
    L8:
        if (args.length == argsOffset) goto L16;
        int i = argsOffset;
    L11:
        if (i >= args.length) goto L14;
        new BundleChecker(new FileInputStream(args[i]), new AtomicInteger(0), sanityCheck).run();
        i = i + 1;
        goto L11
    L14:
        return;
    L16:
        throw new RuntimeException("Usage: BundleChecker [-s] <fileX.zip> ...");
    }
}
