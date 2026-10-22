package com.typesafe.config.impl;

import com.typesafe.config.ConfigException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.typesafe.config.impl.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3909o extends AbstractC3895a {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<AbstractC3895a> f31885a;

    public C3909o(Collection<AbstractC3895a> collection) {
        this.f31885a = new ArrayList<>(collection);
    }

    @Override // com.typesafe.config.impl.AbstractC3895a
    public Collection<Q> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC3895a> it = this.f31885a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().b());
        }
        return arrayList;
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractC3895a> it = this.f31885a.iterator();
        while (it.hasNext()) {
            AbstractC3895a next = it.next();
            if (next instanceof C3906l) {
                arrayList.add(((C3906l) next).d());
            }
        }
        return arrayList;
    }

    public r d() {
        for (int i10 = 0; i10 < this.f31885a.size(); i10++) {
            if (this.f31885a.get(i10) instanceof r) {
                return (r) this.f31885a.get(i10);
            }
        }
        throw new ConfigException.BugOrBroken("Field node doesn't have a path");
    }

    public Q e() {
        Q qC;
        Iterator<AbstractC3895a> it = this.f31885a.iterator();
        while (it.hasNext()) {
            AbstractC3895a next = it.next();
            if ((next instanceof u) && ((qC = ((u) next).c()) == S.f31796j || qC == S.f31791e || qC == S.f31790d)) {
                return qC;
            }
        }
        return null;
    }

    public AbstractC3896b f() {
        for (int i10 = 0; i10 < this.f31885a.size(); i10++) {
            if (this.f31885a.get(i10) instanceof AbstractC3896b) {
                return (AbstractC3896b) this.f31885a.get(i10);
            }
        }
        throw new ConfigException.BugOrBroken("Field node doesn't have a value");
    }
}
