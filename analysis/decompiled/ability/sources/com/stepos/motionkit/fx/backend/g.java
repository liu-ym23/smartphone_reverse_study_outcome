package com.stepos.motionkit.fx.backend;

import com.stepos.motionkit.FxBackend;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3852a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ FxBackend c;

    public /* synthetic */ g(Object obj, FxBackend fxBackend, int i) {
        this.f3852a = i;
        this.b = obj;
        this.c = fxBackend;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f3852a) {
            case 0:
                return RuntimeShaderBackend.createInstance$lambda$3((RuntimeShaderInstance) this.b, (RuntimeShaderBackend) this.c);
            default:
                return SurfaceBackend.createInstance$lambda$2((SurfaceInstance) this.b, (SurfaceBackend) this.c);
        }
    }
}
