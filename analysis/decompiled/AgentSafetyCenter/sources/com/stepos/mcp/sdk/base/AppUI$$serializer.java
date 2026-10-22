package com.stepos.mcp.sdk.base;

import jb.a;
import t.i1;
import vc.e;
import wc.b;
import wc.d;
import xc.a0;
import xc.c;
import xc.c0;
import xc.l0;
import xc.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@a
/* loaded from: classes.dex */
public final class AppUI$$serializer implements n {
    public static final AppUI$$serializer INSTANCE;
    private static final /* synthetic */ c0 descriptor;

    static {
        AppUI$$serializer appUI$$serializer = new AppUI$$serializer();
        INSTANCE = appUI$$serializer;
        c0 c0Var = new c0("com.stepos.mcp.sdk.base.AppUI", appUI$$serializer, 6);
        c0Var.g("type", false);
        c0Var.g("packageName", false);
        c0Var.g("appUIName", true);
        c0Var.g("widgetName", true);
        c0Var.g("widgetAction", true);
        c0Var.g("isFix", true);
        descriptor = c0Var;
    }

    private AppUI$$serializer() {
    }

    @Override // xc.n
    public tc.a[] childSerializers() {
        l0 l0Var = l0.f15644a;
        return new tc.a[]{l0Var, l0Var, i1.e(l0Var), i1.e(l0Var), i1.e(l0Var), c.f15609a};
    }

    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public AppUI m2deserialize(wc.c cVar) {
        cVar.getClass();
        getDescriptor();
        cVar.a();
        throw null;
    }

    @Override // tc.a
    public e getDescriptor() {
        return descriptor;
    }

    public void serialize(d dVar, AppUI appUI) {
        dVar.getClass();
        appUI.getClass();
        e descriptor2 = getDescriptor();
        b bVarA = dVar.a(descriptor2);
        AppUI.write$Self(appUI, bVarA, descriptor2);
        bVarA.d(descriptor2);
    }

    @Override // xc.n
    public tc.a[] typeParametersSerializers() {
        return a0.f15605b;
    }
}
