package com.bytedance.android.live.soloktv.util;

import android.os.Bundle;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.remove("android:fragments");
        r100.remove("android:support:fragments");
        Bundle r101 = r100.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r101 == null) goto L8;
        r101.remove("android:support:fragments");
        return;
    }
}
