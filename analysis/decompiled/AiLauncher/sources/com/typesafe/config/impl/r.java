package com.typesafe.config.impl;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class r extends AbstractC3895a {

    /* renamed from: a, reason: collision with root package name */
    public final D f31889a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Q> f31890b;

    public r(D d10, Collection<Q> collection) {
        this.f31889a = d10;
        this.f31890b = new ArrayList<>(collection);
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        return this.f31890b;
    }

    public D c() {
        return this.f31889a;
    }
}
