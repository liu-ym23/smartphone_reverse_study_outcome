package com.danikula.videocache.file;

import com.danikula.videocache.KLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class Files {

    /* JADX INFO: renamed from: com.danikula.videocache.file.Files$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class LastModifiedComparator implements Comparator<File> {
        private LastModifiedComparator() {
        }

        private int compareLong(long r10, long r11) {
            if (r10 >= r11) goto L5;
            return -1;
        L5:
            if (r10 != r11) goto L7;
            return 0;
        L7:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r10, File r11) {
            return compare2(r10, r11);
        }

        public /* synthetic */ LastModifiedComparator(AnonymousClass1 r10) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(File r10, File r11) {
            return compareLong(r10.lastModified(), r11.lastModified());
        }
    }

    public Files() {
    }

    public static List<File> getLruListFiles(File r10) {
        LinkedList r11 = new LinkedList();
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L6;
        List<File> r13 = Arrays.asList(r12);
        Collections.sort(r13, new LastModifiedComparator(null));
        return r13;
    L6:
        return r11;
    }

    public static void makeDir(File r10) throws IOException {
        if (r10.exists() == false) goto L10;
        if (r10.isDirectory() == false) goto L8;
        return;
    L8:
        throw new IOException("File " + r10 + " is not directory!");
    L10:
        if (r10.mkdirs() == false) goto L13;
        return;
    L13:
        throw new IOException(String.format("Directory %s can't be created", new Object[]{r10.getAbsolutePath()}));
    }

    public static void modify(File r10) throws IOException {
        long r11 = r10.length();
        if (r11 != 0) goto L6;
        recreateZeroSizeFile(r10);
        return;
    L6:
        RandomAccessFile r12 = new RandomAccessFile(r10, "rwd");
        long r13 = r11 - 1;
        r12.seek(r13);
        byte r14 = r12.readByte();
        r12.seek(r13);
        r12.write(r14);
        r12.close();
    }

    private static void recreateZeroSizeFile(File r10) throws IOException {
        if (r10.delete() == false) goto L8;
        if (r10.createNewFile() == false) goto L8;
        return;
    L8:
        throw new IOException("Error recreate zero-size file " + r10);
    }

    public static void setLastModifiedNow(File r10) throws IOException {
        if (r10.exists() == false) goto L10;
        long r11 = System.currentTimeMillis();
        if (r10.setLastModified(r11) == true) goto L11;
        modify(r10);
        if (r10.lastModified() >= r11) goto L12;
        KLog.w("Last modified date {} is not set for file {}", new Object[]{new Date(r10.lastModified()), r10.getAbsolutePath()});
        return;
    L12:
        return;
    L11:
        return;
    }
}
