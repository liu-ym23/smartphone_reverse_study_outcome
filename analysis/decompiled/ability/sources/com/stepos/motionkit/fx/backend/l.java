package com.stepos.motionkit.fx.backend;

import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3857a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(Object obj, int i) {
        this.f3857a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f3857a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return SurfaceInstance.release$lambda$5((SurfaceInstance) obj);
            default:
                return SurfaceBackend.createInstance$lambda$0((Ref$ObjectRef) obj);
        }
    }
}
