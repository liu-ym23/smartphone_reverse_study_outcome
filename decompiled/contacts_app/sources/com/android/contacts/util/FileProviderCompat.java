package com.android.contacts.util;

import android.content.Context;
import android.os.Environment;
import com.GlobalProxyLancet;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileProviderCompat {
    public static final int SDK_VERSION_R = 30;
    private static final String TAG = "FileProviderCompat";

    static {
    }

    public FileProviderCompat() {
    }

    public static File getConfigDir(Context r0) {
        return getOrCreateOnExternalStorage("obric/contact/");
    }

    private static File getOrCreateOnExternalStorage(String r4) {
        File r0 = new File(Environment.getExternalStorageDirectory(), r4);
        if (r0.exists() == false) goto L5;
    L7:
        return r0;
    L5:
        if (r0.mkdirs() == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "create write dir FAILED: " + r4);
        goto L7
    }
}
