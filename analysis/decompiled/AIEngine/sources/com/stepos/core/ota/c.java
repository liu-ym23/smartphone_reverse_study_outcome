package com.stepos.core.ota;

import android.content.Context;
import com.stepos.core.ota.crypto.AtRestDecryptorBootstrap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7487b;

    public /* synthetic */ c(Context context, int i10) {
        this.f7486a = i10;
        this.f7487b = context;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7486a;
        Context context = this.f7487b;
        switch (i10) {
            case 0:
                return OtaContainer.init$lambda$1(context);
            case 1:
                return OtaContainer.init$lambda$3(context);
            default:
                return AtRestDecryptorBootstrap.install$lambda$3$lambda$0(context);
        }
    }
}
