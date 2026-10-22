package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class MediaStoreOpImpl implements IDownloadFileOp {
    private boolean enableMediaStoreSecurityStrategy;
    private File file;
    private int type;
    private Uri uri;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r1) {
        return false;
    }

    public MediaStoreOpImpl(Uri r1, int r2, boolean r3) {
        this.uri = r1;
        this.type = r2;
        this.enableMediaStoreSecurityStrategy = r3;
        String r4 = getPath();
        if (TextUtils.isEmpty(r4) == true) goto L6;
        this.file = new File(r4);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return DownloadFileUtils.getLength(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return DownloadFileUtils.exists(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return DownloadFileUtils.getFilePathFromUri(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.file;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() {
        if (this.uri == null) goto L7;
        return new FileInputStream(DownloadFileUtils.getFileDescriptor(this.uri, DownloadFileUtils.MODE_READ));
    L7:
        throw new IOException("Fail to obtain InputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() {
        if (this.uri == null) goto L7;
        return new FileOutputStream(DownloadFileUtils.getFileDescriptor(this.uri, DownloadFileUtils.MODE_WRITE));
    L7:
        throw new IOException("Fail to obtain OutputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return this.type;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (this.enableMediaStoreSecurityStrategy == true) goto L5;
        DownloadFileUtils.deleteUri(this.uri);     // Catch: Throwable -> L8
        return false;
    L5:
        return DownloadFileUtils.emptyFile(obtainOutputStream());
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r2) {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return this.file.setLastModified(r2);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        File r0 = this.file;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.exists() == true) goto L7;
        return 0;
    L7:
        return this.file.lastModified();
    }
}
