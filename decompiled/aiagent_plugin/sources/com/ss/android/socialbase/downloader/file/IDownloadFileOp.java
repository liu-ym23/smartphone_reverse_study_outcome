package com.ss.android.socialbase.downloader.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes4.dex */
interface IDownloadFileOp {
    boolean canWrite();

    boolean delete();

    boolean exists();

    String getAbsolutePath();

    String getCanonicalPath();

    String getExtraMsg();

    File getFile();

    int getFileType();

    File getParentFile();

    String getPath();

    boolean isDirectory();

    long lastModified();

    long length();

    boolean mkdirs();

    FileInputStream obtainInputStream();

    FileOutputStream obtainOutputStream();

    boolean renameTo(DownloadFile r1);

    boolean setLastModified(long r1);
}
