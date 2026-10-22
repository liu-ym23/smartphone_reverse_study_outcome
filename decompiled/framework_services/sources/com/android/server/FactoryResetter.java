package com.android.server;

import android.content.Context;
import com.android.internal.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class FactoryResetter {
    private static final AtomicBoolean sFactoryResetting = null;

    static {
        sFactoryResetting = new AtomicBoolean(false);
    }

    public static boolean isFactoryResetting() {
        return sFactoryResetting.get();
    }

    @Deprecated
    public static void setFactoryResetting(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.MASTER_CLEAR") != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkCallAuthorization(r0);
        sFactoryResetting.set(true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private FactoryResetter() {
        throw new UnsupportedOperationException("Provides only static methods");
    }
}
