package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class j extends h implements List {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzbr f19956f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(zzbr zzbrVar, Object obj, List list, h hVar) {
        super(zzbrVar, obj, list, hVar);
        this.f19956f = zzbrVar;
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        zzb();
        boolean zIsEmpty = this.f19951b.isEmpty();
        ((List) this.f19951b).add(i10, obj);
        this.f19956f.f19971d++;
        if (zIsEmpty) {
            b();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f19951b).addAll(i10, collection);
        if (zAddAll) {
            int size2 = this.f19951b.size();
            this.f19956f.f19971d += size2 - size;
            if (size == 0) {
                b();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zzb();
        return ((List) this.f19951b).get(i10);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.f19951b).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.f19951b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new i(this);
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        zzb();
        Object objRemove = ((List) this.f19951b).remove(i10);
        zzbr zzbrVar = this.f19956f;
        zzbrVar.f19971d--;
        c();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        zzb();
        return ((List) this.f19951b).set(i10, obj);
    }

    @Override // java.util.List
    public final List subList(int i10, int i11) {
        zzb();
        List listSubList = ((List) this.f19951b).subList(i10, i11);
        h hVar = this.f19952c;
        if (hVar == null) {
            hVar = this;
        }
        return this.f19956f.i(this.f19950a, listSubList, hVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i10) {
        zzb();
        return new i(this, i10);
    }
}
