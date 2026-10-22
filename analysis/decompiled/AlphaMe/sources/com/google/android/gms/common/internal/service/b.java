package com.google.android.gms.common.internal.service;

import Z0.f;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.A;
import com.google.android.gms.common.api.internal.C0407e;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.common.api.internal.y;
import com.google.android.gms.common.internal.TelemetryData;
import g1.AbstractC0574b;
import g1.HandlerC0575c;
import l1.C0758c;
import l1.h;
import y0.e;

/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: i, reason: collision with root package name */
    public static final android.support.v4.media.session.c f9845i = new android.support.v4.media.session.c(new a(0), new e());

    public final h b(TelemetryData telemetryData) {
        k kVar = new k();
        Feature[] featureArr = {AbstractC0574b.f12657a};
        kVar.f9656b = featureArr;
        kVar.f9657c = false;
        kVar.f9659e = new p(1, telemetryData);
        k kVar2 = new k(kVar, featureArr, false, kVar.f9658d);
        C0758c c0758c = new C0758c();
        C0407e c0407e = this.f2157h;
        c0407e.getClass();
        c0407e.e(c0758c, kVar2.f9658d, this);
        A a4 = new A(kVar2, c0758c, this.f2156g);
        HandlerC0575c handlerC0575c = c0407e.f9653m;
        handlerC0575c.sendMessage(handlerC0575c.obtainMessage(4, new y(a4, c0407e.f9649i.get(), this)));
        return c0758c.f13454a;
    }
}
