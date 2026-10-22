package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class p0 implements com.larus.platform.api.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f192065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f192066b;

    @Override // com.larus.platform.api.l0
    public final void onCompletion(boolean r100) {
        bx7.c.d(this.f192065a, this.f192066b, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r100))}));
    }

    public p0(q0 r100, ux7.d.C7943d r101) {
        this.f192065a = r100;
        this.f192066b = r101;
    }
}
