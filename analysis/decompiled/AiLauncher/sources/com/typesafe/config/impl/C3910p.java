package com.typesafe.config.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.typesafe.config.impl.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3910p extends AbstractC3895a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<AbstractC3895a> f31886a;

    /* renamed from: b, reason: collision with root package name */
    public final ConfigIncludeKind f31887b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31888c;

    public C3910p(Collection<AbstractC3895a> collection, ConfigIncludeKind configIncludeKind, boolean z10) {
        this.f31886a = new ArrayList<>(collection);
        this.f31887b = configIncludeKind;
        this.f31888c = z10;
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC3895a> it = this.f31886a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().b());
        }
        return arrayList;
    }

    public boolean c() {
        return this.f31888c;
    }

    public ConfigIncludeKind d() {
        return this.f31887b;
    }

    public String e() {
        Iterator<AbstractC3895a> it = this.f31886a.iterator();
        while (it.hasNext()) {
            AbstractC3895a next = it.next();
            if (next instanceof C3913t) {
                return (String) S.e(((C3913t) next).c()).a();
            }
        }
        return null;
    }
}
