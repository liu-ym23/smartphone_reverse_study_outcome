package com.bytedance.android.live.core.tetris.layer.core.element.container;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.e;
import k70.b;
import k70.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends b<j70.b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f65677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.data.b f65678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p70.b f65679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b80.a f65680e;

    public a() {
    }

    @Override // k70.b
    public final Element a(e r100) {
        j70.b r101 = (j70.b) r100;
        Intrinsics.checkNotNullParameter(r101, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        c r102 = this.f65677b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        h70.b r103 = b();
        b80.a r104 = this.f65680e;
        p70.b r105 = this.f65679d;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("processChains");
    L8:
        com.bytedance.android.live.core.tetris.layer.core.data.b r106 = this.f65678c;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L12:
        return new ContainerElement(r101, r102, r103, r104, r105, r106);
    }
}
