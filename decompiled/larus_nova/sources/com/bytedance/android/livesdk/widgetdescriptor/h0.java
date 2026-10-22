package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.viewmodule.LiveWaterMaskWidget;
import com.bytedance.android.livesdk.config.gy0;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h0 extends j70.n<e0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f162379c;

    @Override // j70.o
    public final boolean h() {
        return true;
    }

    public h0() {
        this.f162379c = gy0.f120323a.getValue().a();
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return LiveWaterMaskWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        if (gh0.a.d() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f162379c == false) goto L7;
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467484a0;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        return LayerIndex.INDEX_0;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r100) {
        Intrinsics.checkNotNullParameter((e0) r100, "layerContext");
        ElementConstraint r101 = new ElementConstraint(-1.0f, -1.0f);
        ElementConstraint.Side r102 = ElementConstraint.Side.BOTTOM;
        r101.d(r102, r102, 0.0f);
        return r101;
    }
}
