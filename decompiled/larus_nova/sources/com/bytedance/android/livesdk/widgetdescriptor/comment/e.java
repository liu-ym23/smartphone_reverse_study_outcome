package com.bytedance.android.livesdk.widgetdescriptor.comment;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import kotlin.jvm.internal.Intrinsics;
import r52.i0;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162297a = 0;

    static {
    }

    public static boolean a(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        if (d90.c.f(r100) == false) goto L5;
    L17:
        return false;
    L5:
        if (jr1.b.b(r100) == true) goto L17;
        if (d90.c.k(r100) == true) goto L17;
        if (d90.c.c(r100) == false) goto L13;
        return false;
    L13:
        if (i0.f536194a.getValue().booleanValue() == true) goto L16;
        return false;
    L16:
        return d90.c.i(r100);
    }
}
