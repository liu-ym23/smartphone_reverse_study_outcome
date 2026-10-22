package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadFile implements IDownloadFileOp {
    public static final int TYPE_AUDIO = 4;
    public static final int TYPE_DOWNLOADS = 5;
    public static final int TYPE_ERROR = -1;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_VIDEO = 3;
    public IDownloadFileOp downloadFileOp;

    public DownloadFile(File r2) {
        this.downloadFileOp = new FileOpImpl(r2);
    }

    public DownloadFile(String r2, String r3) {
        this(r2, r3, true, true);
    }

    public DownloadFile(String r3, String r4, boolean r5, boolean r6) {
        int r0 = DownloadFileUtils.getTypeByUri(r3);
        if (r0 != 1) goto L10;
        this.downloadFileOp = new FileOpImpl(r3, r4, r5);
        return;
    L10:
        Uri r7 = Uri.parse(r3);     // Catch: Throwable -> L7
        DownloadFileUtils.checkUri(r7, r0);     // Catch: Throwable -> L7
        this.downloadFileOp = new MediaStoreOpImpl(r7, r0, r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.downloadFileOp = new ErrorOpImpl(th.toString());
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return this.downloadFileOp.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return this.downloadFileOp.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        return this.downloadFileOp.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return this.downloadFileOp.mkdirs();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
        return this.downloadFileOp.delete();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return this.downloadFileOp.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return this.downloadFileOp.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.downloadFileOp.getFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r1) {
        return this.downloadFileOp.setLastModified(r1);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        return this.downloadFileOp.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() {
        return this.downloadFileOp.obtainInputStream();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() {
        return this.downloadFileOp.obtainOutputStream();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        return this.downloadFileOp.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        return this.downloadFileOp.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() {
        return this.downloadFileOp.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r1) {
        return this.downloadFileOp.renameTo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return this.downloadFileOp.getFileType();
    }

    public boolean isTypeFile() {
        if (this.downloadFileOp.getFileType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTypeMediaStore() {
        int r1 = this.downloadFileOp.getFileType();
        if (r1 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 3) goto L12;
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L12;
        return false;
    }

    public boolean isTypeError() {
        if (this.downloadFileOp.getFileType() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return this.downloadFileOp.getExtraMsg();
    }
}
