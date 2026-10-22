package com.android.server.art;

import android.os.DebugSmtEx;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public interface IArtManagerLocalEx {
    default ParcelFileDescriptor createHprofFile(String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }
}
