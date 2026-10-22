package com.ttnet.org.chromium.base.compat;

import android.net.Uri;
import android.os.storage.StorageManager;
import java.io.File;

/* JADX INFO: compiled from: ApiHelperForR.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static File a(StorageManager r0, Uri r1) {
        return r0.getStorageVolume(r1).getDirectory();
    }
}
