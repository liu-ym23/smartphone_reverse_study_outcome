package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51675a = 0;

    static {
    }

    public static y a(ConvertButtonViewStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStyle");
        switch(v.f51663a[r100.ordinal()]) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L25:
        return new u();
    L26:
        return new a0();
    L27:
        return new q0();
    L28:
        return new p0();
    L29:
        return new r0();
    L30:
        return new t(4.0f);
    L31:
        return new t(8.0f);
    L14:
        return new z(4.0f);
    L16:
        return new z(8.0f);
    L18:
        return new t0();
    L20:
        return new d1();
    L22:
        return new x0(4.0f);
    L24:
        return new x0(8.0f);
    }
}
