package com.stepos.core.ota.push;

import android.content.Context;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class OtaPushRegistrar$ctaInitializer$2 extends FunctionReferenceImpl implements l<Context, n> {
    public OtaPushRegistrar$ctaInitializer$2(Object obj) {
        super(1, obj, OtaPushRegistrar.class, "unregister", "unregister(Landroid/content/Context;)V", 0);
    }

    @Override // zb.l
    public /* bridge */ /* synthetic */ n invoke(Context context) {
        invoke2(context);
        return n.f10413a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Context p02) {
        g.f(p02, "p0");
        ((OtaPushRegistrar) this.receiver).unregister(p02);
    }
}
