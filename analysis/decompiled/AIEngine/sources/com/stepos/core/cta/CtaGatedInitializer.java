package com.stepos.core.cta;

import android.content.Context;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaGatedInitializer {
    private final CtaGate gate;
    private final String name;
    private final l<Context, n> onGrant;
    private final l<Context, n> onRevoke;
    private final l<Context, n> onServiceDisabled;

    /* JADX WARN: Multi-variable type inference failed */
    public CtaGatedInitializer(String name, CtaGate gate, l<? super Context, n> onGrant, l<? super Context, n> lVar, l<? super Context, n> lVar2) {
        g.f(name, "name");
        g.f(gate, "gate");
        g.f(onGrant, "onGrant");
        this.name = name;
        this.gate = gate;
        this.onGrant = onGrant;
        this.onRevoke = lVar;
        this.onServiceDisabled = lVar2;
    }

    public final CtaGate getGate() {
        return this.gate;
    }

    public final String getName() {
        return this.name;
    }

    public final l<Context, n> getOnGrant() {
        return this.onGrant;
    }

    public final l<Context, n> getOnRevoke() {
        return this.onRevoke;
    }

    public final l<Context, n> getOnServiceDisabled() {
        return this.onServiceDisabled;
    }

    public /* synthetic */ CtaGatedInitializer(String str, CtaGate ctaGate, l lVar, l lVar2, l lVar3, int i10, e eVar) {
        this(str, ctaGate, lVar, (i10 & 8) != 0 ? null : lVar2, (i10 & 16) != 0 ? null : lVar3);
    }
}
