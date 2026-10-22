package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.api.d5;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f192042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f192043b;

    public b(c r100, ux7.d.C7943d r101) {
        this.f192042a = r100;
        this.f192043b = r101;
    }

    @Override // com.larus.platform.api.d5
    public final void a(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "clientKey");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "state");
        c r104 = this.f192042a;
        IvyBridgeMethod.a r105 = this.f192043b;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("is_authorized", Boolean.valueOf(r100));
        Unit r107 = Unit.INSTANCE;
        bx7.c.d(r104, r105, r106);
    }
}
