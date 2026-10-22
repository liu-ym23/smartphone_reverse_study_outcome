package com.bytedance.android.livesdk.widgetdescriptor;

import com.bytedance.android.livesdk.chatroom.viewmodule.CommerceAnchorServiceWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j extends j70.i<e0> {
    public j() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return CommerceAnchorServiceWidget.class;
    }

    @Override // j70.d
    public final boolean B(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (jr1.b.a(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L7;
        return true;
    }

    @Override // j70.d
    public final j70.f C(h70.b r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d90.d.a.f467533k;
    }
}
