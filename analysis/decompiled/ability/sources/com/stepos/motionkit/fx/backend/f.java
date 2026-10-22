package com.stepos.motionkit.fx.backend;

import S7.n;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3851a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i) {
        this.f3851a = i;
        this.b = obj;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f3851a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                return RuntimeShaderBackend.createInstance$lambda$2((RuntimeShaderInstance) obj3, ((Long) obj).longValue(), ((Float) obj2).floatValue());
            case 1:
                return SfBackend.createInstance$lambda$0((SfInstance) obj3, ((Long) obj).longValue(), ((Float) obj2).floatValue());
            default:
                return SurfaceBackend.createInstance$lambda$1((SurfaceInstance) obj3, ((Long) obj).longValue(), ((Float) obj2).floatValue());
        }
    }
}
