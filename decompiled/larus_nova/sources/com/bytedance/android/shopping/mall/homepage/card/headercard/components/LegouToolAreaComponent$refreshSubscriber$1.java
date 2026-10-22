package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class LegouToolAreaComponent$refreshSubscriber$1 implements com.bytedance.android.ec.hybrid.card.event.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LegouToolAreaComponent f177794a;

    public LegouToolAreaComponent$refreshSubscriber$1(LegouToolAreaComponent r100) {
        this.f177794a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.event.e
    public final void a(com.bytedance.android.ec.hybrid.card.event.d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = "";
        Map<String, Object> r102 = r100.f46490b;
        if (r102 == null) goto L5;
        final Object r103 = r102.get("tool_list");
    L6:
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = null;
        kk.d.c(new LegouToolAreaComponent$refreshSubscriber$1$onReceiveJsEvent$1(r103, r101, r104));
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$refreshSubscriber$1$onReceiveJsEvent$2(this, r104));
        return;
    L5:
        r103 = null;
        goto L6
    }
}
