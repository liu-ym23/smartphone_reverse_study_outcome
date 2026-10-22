package com.ss.android.socialbase.downloader.file;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
class FileOpImpl implements IDownloadFileOp {
    private File file;
    private boolean isSecurity;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return 1;
    }

    public FileOpImpl(File r2) {
        this.isSecurity = true;
        this.file = r2;
        this.isSecurity = DownloadDirUtils.isSavePathSecurity(r2.getPath());
    }

    public FileOpImpl(String r2, String r3, boolean r4) {
        this.isSecurity = true;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.file = new File(r2, r3);
    L6:
        if (r4 == false) goto L9;
        this.isSecurity = DownloadDirUtils.isSavePathSecurity(r2);
        return;
    L9:
        return;
    L5:
        this.file = new File(r2);
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return this.file.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return this.file.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        return this.file.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return this.file.mkdirs();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
        if (this.isSecurity == true) goto L7;
        return true;
    L7:
        return this.file.delete();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return this.file.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.file;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return this.file.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r1) {
        return this.file.setLastModified(r1);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        return this.file.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() {
        if (this.file.isFile() == false) goto L7;
        return new FileInputStream(this.file);
    L7:
        throw new IOException(this.file.getAbsolutePath() + " Fail to obtain InputStream, file type error");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() {
        return new FileOutputStream(this.file);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        return this.file.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        return this.file.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() {
        return this.file.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r1) {
        return this.file.renameTo(r1.getFile());
    }
}
