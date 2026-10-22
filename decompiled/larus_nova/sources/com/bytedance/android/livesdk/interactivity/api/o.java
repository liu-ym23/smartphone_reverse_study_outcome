package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static final f b() {
        Object r100 = com.bytedance.live.datacontext.d.d(f.class);
        if ((r100 instanceof f) == true) goto L6;
        r100 = null;
    L6:
        return (f) r100;
    }

    public static final o32.b a() {
        f r100 = b();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<o32.b> r101 = r100.getHighlightDataContext();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$share");
        DataContext r101 = (DataContext) r100;
        com.bytedance.live.datacontext.b.a(r101, f.class);
        com.bytedance.live.datacontext.b.a(r101, h.class);
    }
}
