package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import z2.AbstractC6235q;
import z2.C6195m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class zzbr extends AbstractC6235q implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final transient Map f19970c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f19971d;

    public zzbr(Map map) {
        C6195m.c(map.isEmpty());
        this.f19970c = map;
    }

    public static /* bridge */ /* synthetic */ void l(zzbr zzbrVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzbrVar.f19970c.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzbrVar.f19971d -= size;
        }
    }

    @Override // z2.InterfaceC6066J
    public final boolean b(Object obj, Object obj2) {
        Collection collection = (Collection) this.f19970c.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f19971d++;
            return true;
        }
        Collection collectionE = e();
        if (!collectionE.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f19971d++;
        this.f19970c.put(obj, collectionE);
        return true;
    }

    @Override // z2.AbstractC6235q
    public final Map c() {
        return new c(this, this.f19970c);
    }

    @Override // z2.AbstractC6235q
    public final Set d() {
        return new e(this, this.f19970c);
    }

    public abstract Collection e();

    public abstract Collection f(Object obj, Collection collection);

    public final Collection h(Object obj) {
        Collection collectionE = (Collection) this.f19970c.get(obj);
        if (collectionE == null) {
            collectionE = e();
        }
        return f(obj, collectionE);
    }

    public final List i(Object obj, List list, h hVar) {
        return list instanceof RandomAccess ? new f(this, obj, list, hVar) : new j(this, obj, list, hVar);
    }

    public final void m() {
        Iterator it = this.f19970c.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f19970c.clear();
        this.f19971d = 0;
    }
}
