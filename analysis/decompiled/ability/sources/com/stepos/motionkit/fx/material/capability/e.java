package com.stepos.motionkit.fx.material.capability;

import S7.k;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3874a;
    public final /* synthetic */ Serializable b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(Serializable serializable, Object obj, int i) {
        this.f3874a = i;
        this.b = serializable;
        this.c = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f3874a) {
            case 0:
                return CrossBlendBinding.update$lambda$0((int[]) this.b, (int[]) this.c, obj);
            default:
                return GlassTextBinding.release$lambda$3((Class) this.b, (GlassTextBinding) this.c, obj);
        }
    }
}
