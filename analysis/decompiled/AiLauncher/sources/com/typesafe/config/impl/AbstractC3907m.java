package com.typesafe.config.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.typesafe.config.impl.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3907m extends AbstractC3896b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<AbstractC3895a> f31884a;

    public AbstractC3907m(Collection<AbstractC3895a> collection) {
        this.f31884a = new ArrayList<>(collection);
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC3895a> it = this.f31884a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().b());
        }
        return arrayList;
    }

    public final Collection<AbstractC3895a> c() {
        return this.f31884a;
    }
}
