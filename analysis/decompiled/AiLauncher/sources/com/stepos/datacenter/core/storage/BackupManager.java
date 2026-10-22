package com.stepos.datacenter.core.storage;

import La.C;
import La.C0953c;
import La.D;
import La.m;
import La.w;
import Y8.t;
import Z8.F;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.core.storage.BackupManager;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import l9.C4877a;
import l9.j;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010%\u001a\u00020\u0015*\u00020$H\u0002¢\u0006\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/stepos/datacenter/core/storage/BackupManager;", "", "<init>", "()V", "Ljava/io/File;", "rootDir", "destZip", "", "currentDataCenterVersion", "Lcom/stepos/datacenter/core/result/DataCenterResult;", "Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", Const.INTENT_KEY_PKGNAME, "(Ljava/io/File;Ljava/io/File;I)Lcom/stepos/datacenter/core/result/DataCenterResult;", "srcZip", "Lv9/i;", "acceptedVersionRange", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/io/File;Ljava/io/File;Lv9/i;)Lcom/stepos/datacenter/core/result/DataCenterResult;", Parameters.ROOT, "", "Lkotlin/Pair;", "", "c", "(Ljava/io/File;)Ljava/util/List;", "Ljava/util/zip/ZipOutputStream;", "zos", "m", "LY8/t;", "l", "(Ljava/util/zip/ZipOutputStream;Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;)V", "zip", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/io/File;)Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", "s", "e", "(Ljava/lang/String;)Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", "", "k", "([B)Ljava/lang/String;", "BackupManifest", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackupManager {

    /* renamed from: a, reason: collision with root package name */
    public static final BackupManager f29992a = new BackupManager();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lcom/stepos/datacenter/core/storage/BackupManager$BackupManifest;", "", "formatVersion", "", "dataCenterVersion", "fileCount", "totalBytes", "", "sha256", "", "timestampMillis", "<init>", "(IIIJLjava/lang/String;J)V", "getFormatVersion", "()I", "getDataCenterVersion", "getFileCount", "getTotalBytes", "()J", "getSha256", "()Ljava/lang/String;", "getTimestampMillis", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class BackupManifest {
        private final int dataCenterVersion;
        private final int fileCount;
        private final int formatVersion;
        private final String sha256;
        private final long timestampMillis;
        private final long totalBytes;

        public BackupManifest(int i10, int i11, int i12, long j10, String sha256, long j11) {
            p.i(sha256, "sha256");
            this.formatVersion = i10;
            this.dataCenterVersion = i11;
            this.fileCount = i12;
            this.totalBytes = j10;
            this.sha256 = sha256;
            this.timestampMillis = j11;
        }

        public static /* synthetic */ BackupManifest copy$default(BackupManifest backupManifest, int i10, int i11, int i12, long j10, String str, long j11, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = backupManifest.formatVersion;
            }
            if ((i13 & 2) != 0) {
                i11 = backupManifest.dataCenterVersion;
            }
            if ((i13 & 4) != 0) {
                i12 = backupManifest.fileCount;
            }
            if ((i13 & 8) != 0) {
                j10 = backupManifest.totalBytes;
            }
            if ((i13 & 16) != 0) {
                str = backupManifest.sha256;
            }
            if ((i13 & 32) != 0) {
                j11 = backupManifest.timestampMillis;
            }
            String str2 = str;
            long j12 = j10;
            int i14 = i12;
            return backupManifest.copy(i10, i11, i14, j12, str2, j11);
        }

        /* renamed from: component1, reason: from getter */
        public final int getFormatVersion() {
            return this.formatVersion;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDataCenterVersion() {
            return this.dataCenterVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final int getFileCount() {
            return this.fileCount;
        }

        /* renamed from: component4, reason: from getter */
        public final long getTotalBytes() {
            return this.totalBytes;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSha256() {
            return this.sha256;
        }

        /* renamed from: component6, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final BackupManifest copy(int formatVersion, int dataCenterVersion, int fileCount, long totalBytes, String sha256, long timestampMillis) {
            p.i(sha256, "sha256");
            return new BackupManifest(formatVersion, dataCenterVersion, fileCount, totalBytes, sha256, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BackupManifest)) {
                return false;
            }
            BackupManifest backupManifest = (BackupManifest) other;
            return this.formatVersion == backupManifest.formatVersion && this.dataCenterVersion == backupManifest.dataCenterVersion && this.fileCount == backupManifest.fileCount && this.totalBytes == backupManifest.totalBytes && p.d(this.sha256, backupManifest.sha256) && this.timestampMillis == backupManifest.timestampMillis;
        }

        public final int getDataCenterVersion() {
            return this.dataCenterVersion;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final int getFormatVersion() {
            return this.formatVersion;
        }

        public final String getSha256() {
            return this.sha256;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.formatVersion) * 31) + Integer.hashCode(this.dataCenterVersion)) * 31) + Integer.hashCode(this.fileCount)) * 31) + Long.hashCode(this.totalBytes)) * 31) + this.sha256.hashCode()) * 31) + Long.hashCode(this.timestampMillis);
        }

        public String toString() {
            return "BackupManifest(formatVersion=" + this.formatVersion + ", dataCenterVersion=" + this.dataCenterVersion + ", fileCount=" + this.fileCount + ", totalBytes=" + this.totalBytes + ", sha256=" + this.sha256 + ", timestampMillis=" + this.timestampMillis + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((String) ((Pair) t10).e(), (String) ((Pair) t11).e());
        }
    }

    public static final boolean d(File it) {
        p.i(it, "it");
        return it.isFile();
    }

    public static final Integer f(String str, String str2) {
        List<String> listC;
        String str3;
        m mVarD = Regex.d(new Regex("\"" + str2 + "\"\\s*:\\s*(\\d+)"), str, 0, 2, null);
        if (mVarD == null || (listC = mVarD.c()) == null || (str3 = listC.get(1)) == null) {
            return null;
        }
        return C.w(str3);
    }

    public static final Long g(String str, String str2) {
        List<String> listC;
        String str3;
        m mVarD = Regex.d(new Regex("\"" + str2 + "\"\\s*:\\s*(\\d+)"), str, 0, 2, null);
        if (mVarD == null || (listC = mVarD.c()) == null || (str3 = listC.get(1)) == null) {
            return null;
        }
        return C.y(str3);
    }

    public static final String h(String str, String str2) {
        List<String> listC;
        m mVarD = Regex.d(new Regex("\"" + str2 + "\"\\s*:\\s*\"([^\"]*)\""), str, 0, 2, null);
        if (mVarD == null || (listC = mVarD.c()) == null) {
            return null;
        }
        return listC.get(1);
    }

    public final DataCenterResult<BackupManifest> b(File rootDir, File destZip, int currentDataCenterVersion) throws NoSuchAlgorithmException {
        p.i(rootDir, "rootDir");
        p.i(destZip, "destZip");
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            return DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.NOT_INITIALIZED, "rootDir does not exist or is not a dir: " + rootDir, null, 4, null);
        }
        File parentFile = destZip.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        List<Pair<String, File>> listC = c(rootDir);
        if (listC.isEmpty()) {
            return DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.EMPTY_INPUT, "rootDir has no files to back up: " + rootDir, null, 4, null);
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        File file = new File(destZip.getParentFile(), destZip.getName() + ".tmp");
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                long j10 = 0;
                for (Pair<String, File> pair : listC) {
                    String strA = pair.a();
                    File fileB = pair.b();
                    zipOutputStream.putNextEntry(new ZipEntry(strA));
                    FileInputStream fileInputStream = new FileInputStream(fileB);
                    try {
                        byte[] bArr = new byte[65536];
                        while (true) {
                            int i10 = fileInputStream.read(bArr);
                            if (i10 <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, i10);
                            messageDigest.update(bArr, 0, i10);
                            j10 += i10;
                        }
                        t tVar = t.f7040a;
                        l9.b.a(fileInputStream, null);
                        byte[] bytes = strA.getBytes(C0953c.UTF_8);
                        p.h(bytes, "getBytes(...)");
                        messageDigest.update(bytes);
                        zipOutputStream.closeEntry();
                    } finally {
                    }
                }
                int size = listC.size();
                BackupManager backupManager = f29992a;
                byte[] bArrDigest = messageDigest.digest();
                p.h(bArrDigest, "digest(...)");
                BackupManifest backupManifest = new BackupManifest(1, currentDataCenterVersion, size, j10, backupManager.k(bArrDigest), System.currentTimeMillis());
                backupManager.l(zipOutputStream, backupManifest);
                t tVar2 = t.f7040a;
                l9.b.a(zipOutputStream, null);
                if (destZip.exists()) {
                    destZip.delete();
                }
                if (!file.renameTo(destZip)) {
                    file.delete();
                    return DataCenterResult.Companion.failure$default(DataCenterResult.INSTANCE, DataCenterError.INTERNAL_ERROR, "failed to rename " + file + " → " + destZip, null, 4, null);
                }
                Log.i("BackupManager", "backup wrote " + listC.size() + " files / " + j10 + " bytes → " + destZip);
                return DataCenterResult.INSTANCE.ok(backupManifest);
            } finally {
            }
        } catch (Throwable th) {
            file.delete();
            return DataCenterResult.INSTANCE.failure(DataCenterError.INTERNAL_ERROR, "backup failed: " + th.getMessage(), th);
        }
    }

    public final List<Pair<String, File>> c(File root) {
        ArrayList arrayList = new ArrayList();
        int length = root.getAbsolutePath().length() + 1;
        for (File file : SequencesKt___SequencesKt.F(j.u(root), new InterfaceC5074l() { // from class: Y6.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BackupManager.d((File) obj));
            }
        })) {
            String absolutePath = file.getAbsolutePath();
            p.h(absolutePath, "getAbsolutePath(...)");
            String strSubstring = absolutePath.substring(length);
            p.h(strSubstring, "substring(...)");
            arrayList.add(Y8.j.a(D.S(strSubstring, File.separatorChar, JsonPointer.SEPARATOR, false, 4, null), file));
        }
        return F.c1(arrayList, new a());
    }

    public final BackupManifest e(String s10) {
        Long lG;
        try {
            Integer numF = f(s10, "formatVersion");
            if (numF != null) {
                int iIntValue = numF.intValue();
                Integer numF2 = f(s10, "dataCenterVersion");
                if (numF2 != null) {
                    int iIntValue2 = numF2.intValue();
                    Integer numF3 = f(s10, "fileCount");
                    if (numF3 != null) {
                        int iIntValue3 = numF3.intValue();
                        Long lG2 = g(s10, "totalBytes");
                        if (lG2 != null) {
                            long jLongValue = lG2.longValue();
                            String strH = h(s10, "sha256");
                            if (strH != null && (lG = g(s10, "timestampMillis")) != null) {
                                return new BackupManifest(iIntValue, iIntValue2, iIntValue3, jLongValue, strH, lG.longValue());
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final BackupManifest i(File zip) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zip));
        BackupManifest backupManifestE = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    t tVar = t.f7040a;
                    l9.b.a(zipInputStream, null);
                    return backupManifestE;
                }
                if (p.d(nextEntry.getName(), "backup_manifest.json")) {
                    backupManifestE = f29992a.e(new String(C4877a.c(zipInputStream), C0953c.UTF_8));
                }
                zipInputStream.closeEntry();
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
    
        r9 = Y8.t.f7040a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
    
        l9.b.a(r5, null);
        r3 = r3.digest();
        kotlin.jvm.internal.p.h(r3, "digest(...)");
        r3 = k(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f3, code lost:
    
        if (kotlin.jvm.internal.p.d(r3, r2.getSha256()) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        l9.k.v(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0122, code lost:
    
        return com.stepos.datacenter.core.result.DataCenterResult.Companion.failure$default(com.stepos.datacenter.core.result.DataCenterResult.INSTANCE, com.stepos.datacenter.core.result.DataCenterError.CORRUPT_DATA, "sha256 mismatch: calc=" + r3 + " manifest=" + r2.getSha256(), null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012a, code lost:
    
        if (r8 != r2.getFileCount()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0132, code lost:
    
        if (r6 == r2.getTotalBytes()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x013a, code lost:
    
        if (r19.exists() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013c, code lost:
    
        l9.k.v(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x013f, code lost:
    
        java.nio.file.Files.move(r4.toPath(), r19.toPath(), java.nio.file.StandardCopyOption.ATOMIC_MOVE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0152, code lost:
    
        java.nio.file.Files.move(r4.toPath(), r19.toPath(), new java.nio.file.CopyOption[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0195, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0196, code lost:
    
        l9.k.v(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b6, code lost:
    
        return com.stepos.datacenter.core.result.DataCenterResult.INSTANCE.failure(com.stepos.datacenter.core.result.DataCenterError.INTERNAL_ERROR, "failed to move stage → rootDir: " + r0.getMessage(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b7, code lost:
    
        l9.k.v(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01f8, code lost:
    
        return com.stepos.datacenter.core.result.DataCenterResult.Companion.failure$default(com.stepos.datacenter.core.result.DataCenterResult.INSTANCE, com.stepos.datacenter.core.result.DataCenterError.CORRUPT_DATA, "count/bytes mismatch: calc=(" + r8 + "/" + r6 + ") manifest=(" + r2.getFileCount() + "/" + r2.getTotalBytes() + ")", null, 4, null);
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.datacenter.core.result.DataCenterResult<com.stepos.datacenter.core.storage.BackupManager.BackupManifest> j(java.io.File r18, java.io.File r19, v9.C5680i r20) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.core.storage.BackupManager.j(java.io.File, java.io.File, v9.i):com.stepos.datacenter.core.result.DataCenterResult");
    }

    public final String k(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append("0123456789abcdef".charAt((b10 & 255) >>> 4));
            sb2.append("0123456789abcdef".charAt(b10 & 15));
        }
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final void l(ZipOutputStream zos, BackupManifest m10) throws IOException {
        zos.putNextEntry(new ZipEntry("backup_manifest.json"));
        byte[] bytes = D.T(D.T(w.n("\n            {\"formatVersion\":" + m10.getFormatVersion() + ",\"dataCenterVersion\":" + m10.getDataCenterVersion() + ",\n             \"fileCount\":" + m10.getFileCount() + ",\"totalBytes\":" + m10.getTotalBytes() + ",\n             \"sha256\":\"" + m10.getSha256() + "\",\"timestampMillis\":" + m10.getTimestampMillis() + "}\n        "), "\n", "", false, 4, null), "\r", "", false, 4, null).getBytes(C0953c.UTF_8);
        p.h(bytes, "getBytes(...)");
        zos.write(bytes);
        zos.closeEntry();
    }
}
