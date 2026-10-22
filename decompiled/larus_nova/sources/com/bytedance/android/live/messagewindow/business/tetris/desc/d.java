package com.bytedance.android.live.messagewindow.business.tetris.desc;

import com.bytedance.android.live.messagewindow.business.widget.VideoOrLinkShellCardWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import j70.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends i<d90.d> {
    public d() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return VideoOrLinkShellCardWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((d90.d) r100, "layerContext");
        return true;
    }

    @Override // j70.d
    public final f C(h70.b r100) {
        d90.d r101 = (d90.d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467491b2;
    }
}
