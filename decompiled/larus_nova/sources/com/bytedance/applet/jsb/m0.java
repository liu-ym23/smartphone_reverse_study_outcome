package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class m0 implements com.larus.platform.api.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f192063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f192064b;

    @Override // com.larus.platform.api.l0
    public final void onCompletion(boolean r100) {
        bx7.c.d(this.f192063a, this.f192064b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r100))}));
    }

    public m0(n0 r100, ux7.d.C7943d r101) {
        this.f192063a = r100;
        this.f192064b = r101;
    }
}
