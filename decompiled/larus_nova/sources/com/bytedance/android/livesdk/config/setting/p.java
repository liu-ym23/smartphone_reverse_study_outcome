package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.lt0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121215a = 0;

    @JvmStatic
    public static final boolean a() {
        Integer r100 = lt0.f120707a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    static {
    }
}
