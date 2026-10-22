package com.stepos.core.cta;

import android.content.Context;
import com.stepos.core.ota.OtaContainer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7404a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7405b;

    public /* synthetic */ c(Context context, int i10) {
        this.f7404a = i10;
        this.f7405b = context;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7404a;
        Context context = this.f7405b;
        switch (i10) {
            case 0:
                return CtaGatedInitManager.bootstrap$lambda$2$lambda$1(context);
            default:
                return OtaContainer.init$lambda$2(context);
        }
    }
}
