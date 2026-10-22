package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.api.c5;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class s0 implements c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f192067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f192068b;

    public s0(t0 r100, ux7.d.C7943d r101) {
        this.f192067a = r100;
        this.f192068b = r101;
    }

    @Override // com.larus.platform.api.c5
    public final void a(boolean r100, Integer r101, String r102, String r103) {
        t0 r104 = this.f192067a;
        IvyBridgeMethod.a r105 = this.f192068b;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("is_authorized", Boolean.valueOf(r100));
        Unit r107 = Unit.INSTANCE;
        bx7.c.d(r104, r105, r106);
    }
}
