package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e1 extends j70.i<d90.a> {
    @Override // j70.o
    public final Class<? extends Widget> c() {
        qh1.a r100 = pm1.f.n();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveElementClass();
    }

    public e1() {
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        qh1.a r102 = pm1.f.n();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.canShowMsgBoard(r101.f467480h) != true) goto L7;
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        d90.a r101 = (d90.a) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467531j2;
    }

    @Override // j70.h
    public final double H(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.a) r100, "layerContext");
        return 0.1d;
    }
}
