package com.android.server.backup.params;

import android.app.backup.IFullBackupRestoreObserver;
import android.os.ParcelFileDescriptor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class AdbParams {
    public String curPassword;
    public String encryptPassword;
    public ParcelFileDescriptor fd;
    public final AtomicBoolean latch;
    public IFullBackupRestoreObserver observer;

    AdbParams() {
        this.latch = new AtomicBoolean(false);
    }
}
