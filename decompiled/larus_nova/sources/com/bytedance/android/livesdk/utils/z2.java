package com.bytedance.android.livesdk.utils;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Activity> f159232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z2 f159233b = null;

    public z2() {
    }

    static {
        f159233b = new z2();
    }

    public final Activity getActivity() {
        WeakReference<Activity> r100 = f159232a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }
}
