package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.live.dynamicresource.client.ResourceClientContext;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t51.f;
import t51.g;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements com.bytedance.live.dynamicresource.producer.a<f, g, o51.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DefaultConfig f98595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDefaultConfig f98596b;

    public a() {
        this.f98595a = new DefaultConfig();
        this.f98596b = new MediaDefaultConfig();
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final g c(o51.f r100, ResourceClientContext<f, g, o51.f> r101) {
        o51.f r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "$this$isMedia");
        o51.f.i r103 = o51.f.i.f522067e;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L17;
        if (Intrinsics.areEqual(r102, r103) == false) goto L14;
        return (g) this.f98596b.f98593b.getValue();
    L14:
        if (Intrinsics.areEqual(r102, o51.f.h.f522066e) == true) goto L52;
    L49:
        return null;
    L52:
        return (g) this.f98596b.f98594c.getValue();
    L17:
        if (Intrinsics.areEqual(r102, o51.f.j.f522068e) == false) goto L20;
        return this.f98595a.c();
    L20:
        if (Intrinsics.areEqual(r102, o51.f.b.f522060e) == false) goto L23;
        return (g) this.f98595a.f98581c.getValue();
    L23:
        if (Intrinsics.areEqual(r102, o51.f.c.f522061e) == false) goto L26;
        return (g) this.f98595a.f98582d.getValue();
    L26:
        if (Intrinsics.areEqual(r102, o51.f.d.f522062e) == false) goto L29;
        return (g) this.f98595a.f98583e.getValue();
    L29:
        if (Intrinsics.areEqual(r102, o51.f.e.f522063e) == false) goto L32;
        return (g) this.f98595a.f98584f.getValue();
    L32:
        if (Intrinsics.areEqual(r102, o51.f.k.f522069e) == false) goto L35;
        return (g) this.f98595a.f98585g.getValue();
    L35:
        if (Intrinsics.areEqual(r102, o51.f.l.f522070e) == false) goto L38;
        return (g) this.f98595a.f98586h.getValue();
    L38:
        if (Intrinsics.areEqual(r102, o51.f.m.f522071e) == false) goto L41;
        return (g) this.f98595a.f98587i.getValue();
    L41:
        if (Intrinsics.areEqual(r102, o51.f.n.f522072e) == false) goto L44;
        return (g) this.f98595a.f98588j.getValue();
    L44:
        if (Intrinsics.areEqual(r102, o51.f.C7016f.f522064e) == false) goto L47;
        return (g) this.f98595a.f98589k.getValue();
    L47:
        if (Intrinsics.areEqual(r102, o51.f.g.f522065e) == false) goto L49;
        return (g) this.f98595a.f98590l.getValue();
    L5:
        if (Intrinsics.areEqual(r102, o51.f.h.f522066e) == true) goto L8;
        r104 = false;
        goto L9
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final void a(o51.f r100, ResourceClientContext<f, g, o51.f> r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "res");
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final Disposable b(o51.f r100, ResourceClientContext<f, g, o51.f> r101, Function1<? super g, Unit> r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        int r104 = h.f267513a;
        return h.a(DefaultResProducer$produceAsync$1.INSTANCE);
    }
}
