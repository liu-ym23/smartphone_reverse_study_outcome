package com.android.server.am;

import android.os.DebugSmtEx;
import com.android.server.pm.PackageManagerService;

/* JADX INFO: loaded from: classes.dex */
public interface IServiceHolder {
    default void initPms(PackageManagerService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
