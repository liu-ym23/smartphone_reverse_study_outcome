package com.typesafe.config.impl;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes4.dex */
public class u extends AbstractC3895a {

    /* renamed from: a, reason: collision with root package name */
    public final Q f31893a;

    public u(Q q10) {
        this.f31893a = q10;
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        return Collections.singletonList(this.f31893a);
    }

    public Q c() {
        return this.f31893a;
    }
}
