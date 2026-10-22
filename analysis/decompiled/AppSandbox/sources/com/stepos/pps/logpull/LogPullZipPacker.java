package com.stepos.pps.logpull;

import android.util.Log;
import com.stepos.logreport.sdk.LogPullQueryClient;
import com.stepos.pps.data.util.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public class LogPullZipPacker {
    private static final int BUFFER_SIZE = 65536;
    private static final String FULLDUMP_NAME_PREFIX = "Fulldump";
    private static final String FULLDUMP_NAME_SUFFIX = ".tar.gz";
    private static final String FULLDUMP_PREFIX = "fulldump/";
    private static final String KERNEL_PREFIX = "kernel/";
    private static final String TAG = "LogPull.Packer";

    public static class PackResult {
        public boolean cancelled;
        public int entryCount;
        public String error;
        public int failedCount;
        public final List<String> failedEntries = new ArrayList();
        public long sizeBytes;
        public boolean success;
        public String zipPath;
    }

    public interface Progress {
        void onProgress(int i, int i2);

        boolean shouldContinue();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.pps.logpull.LogPullZipPacker.PackResult pack(java.util.List<com.stepos.logreport.sdk.LogPullQueryClient.LogdFileInfo> r17, java.io.File r18, java.lang.String r19, com.stepos.pps.logpull.LogPullZipPacker.Progress r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.logpull.LogPullZipPacker.pack(java.util.List, java.io.File, java.lang.String, com.stepos.pps.logpull.LogPullZipPacker$Progress):com.stepos.pps.logpull.LogPullZipPacker$PackResult");
    }

    private void addEntry(ZipOutputStream zipOutputStream, File file, String str, long j, PackResult packResult) throws IOException {
        if (!file.isFile()) {
            Log.w(TAG, "条目已不存在(轮转?): " + file.getAbsolutePath());
            packResult.failedCount = packResult.failedCount + 1;
            packResult.failedEntries.add(str);
            return;
        }
        if (file.getName().endsWith(Constants.ZIP_FILE_SUFFIX)) {
            CrcAndLength crcAndLengthPrecomputeCrc = precomputeCrc(file, j);
            if (crcAndLengthPrecomputeCrc == null) {
                packResult.failedCount++;
                packResult.failedEntries.add(str);
                return;
            }
            if (crcAndLengthPrecomputeCrc.length == 0) {
                return;
            }
            ZipEntry zipEntry = new ZipEntry(str);
            zipEntry.setMethod(0);
            zipEntry.setSize(crcAndLengthPrecomputeCrc.length);
            zipEntry.setCompressedSize(crcAndLengthPrecomputeCrc.length);
            zipEntry.setCrc(crcAndLengthPrecomputeCrc.crc);
            zipOutputStream.putNextEntry(zipEntry);
            long jCopyBounded = copyBounded(file, zipOutputStream, crcAndLengthPrecomputeCrc.length);
            zipOutputStream.closeEntry();
            if (jCopyBounded != crcAndLengthPrecomputeCrc.length) {
                Log.e(TAG, "STORED 两遍读长度不一致 " + str + " expect=" + crcAndLengthPrecomputeCrc.length + " actual=" + jCopyBounded);
                packResult.failedCount = packResult.failedCount + 1;
                packResult.failedEntries.add(str);
                return;
            }
        } else {
            ZipEntry zipEntry2 = new ZipEntry(str);
            zipEntry2.setMethod(8);
            zipOutputStream.putNextEntry(zipEntry2);
            long jCopyBounded2 = copyBounded(file, zipOutputStream, j);
            zipOutputStream.closeEntry();
            if (jCopyBounded2 == 0) {
                return;
            }
            if (j >= 0 && jCopyBounded2 < j) {
                Log.e(TAG, "短读 " + str + " expect=" + j + " actual=" + jCopyBounded2);
                packResult.failedCount = packResult.failedCount + 1;
                packResult.failedEntries.add(str);
                return;
            }
        }
        packResult.entryCount++;
    }

    private static final class CrcAndLength {
        long crc;
        long length;

        private CrcAndLength() {
        }
    }

    private CrcAndLength precomputeCrc(File file, long j) throws IOException {
        int iMin;
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[BUFFER_SIZE];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            long j2 = 0;
            while (true) {
                if (j >= 0 && j2 >= j) {
                    break;
                }
                if (j >= 0) {
                    try {
                        iMin = (int) Math.min(BUFFER_SIZE, j - j2);
                    } finally {
                    }
                } else {
                    iMin = BUFFER_SIZE;
                }
                int i = fileInputStream.read(bArr, 0, iMin);
                if (i < 0) {
                    break;
                }
                crc32.update(bArr, 0, i);
                j2 += i;
            }
            fileInputStream.close();
            CrcAndLength crcAndLength = new CrcAndLength();
            crcAndLength.crc = crc32.getValue();
            crcAndLength.length = j2;
            return crcAndLength;
        } catch (IOException e) {
            Log.e(TAG, "预读算 CRC 失败: " + file.getAbsolutePath(), e);
            return null;
        }
    }

    private long copyBounded(File file, ZipOutputStream zipOutputStream, long j) throws IOException {
        int iMin;
        byte[] bArr = new byte[BUFFER_SIZE];
        FileInputStream fileInputStream = new FileInputStream(file);
        long j2 = 0;
        while (true) {
            if (j >= 0 && j2 >= j) {
                break;
            }
            if (j >= 0) {
                try {
                    iMin = (int) Math.min(BUFFER_SIZE, j - j2);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                iMin = BUFFER_SIZE;
            }
            int i = fileInputStream.read(bArr, 0, iMin);
            if (i < 0) {
                break;
            }
            zipOutputStream.write(bArr, 0, i);
            j2 += i;
        }
        fileInputStream.close();
        return j2;
    }

    private static String entryNameOf(LogPullQueryClient.LogdFileInfo logdFileInfo) {
        String name = new File(logdFileInfo.path).getName();
        if (logdFileInfo.isActive) {
            name = activeCopyName(name);
        }
        if (!logdFileInfo.isKernel()) {
            return name;
        }
        return KERNEL_PREFIX + name;
    }

    static String activeCopyName(String str) {
        if (str.length() > 4 && str.endsWith(".log")) {
            return str.substring(0, str.length() - 4) + ".active.log";
        }
        return str + ".active";
    }

    private static List<File> listFulldumpFiles(File file) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && isFulldumpFile(file2.getName())) {
                    arrayList.add(file2);
                }
            }
            arrayList.sort(new Comparator() { // from class: com.stepos.pps.logpull.LogPullZipPacker$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((File) obj).getName().compareTo(((File) obj2).getName());
                }
            });
        }
        return arrayList;
    }

    private static boolean isFulldumpFile(String str) {
        return str.startsWith(FULLDUMP_NAME_PREFIX) && str.endsWith(FULLDUMP_NAME_SUFFIX);
    }

    private void reportProgress(Progress progress, PackResult packResult, int i) {
        if (progress != null) {
            progress.onProgress(packResult.entryCount + packResult.failedCount, i);
        }
    }
}
