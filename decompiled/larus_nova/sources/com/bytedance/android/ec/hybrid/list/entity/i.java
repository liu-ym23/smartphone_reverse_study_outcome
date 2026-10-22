package com.bytedance.android.ec.hybrid.list.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f47107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECSectionOperationType f47108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f47109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f47110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f47111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f47114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<ECHybridListItemVO> f47115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f47116j;

    public final i a() {
        i r100 = new i();
        r100.f47107a = this.f47107a;
        r100.f47108b = this.f47108b;
        r100.f47109c = this.f47109c;
        r100.f47110d = this.f47110d;
        r100.f47111e = this.f47111e;
        r100.f47112f = this.f47112f;
        r100.f47113g = this.f47113g;
        j r101 = this.f47114h;
        if (r101 == null) goto L5;
        j r102 = r101.a();
    L6:
        r100.f47114h = r102;
        ArrayList<ECHybridListItemVO> r103 = new ArrayList();
        ArrayList<ECHybridListItemVO> r104 = this.f47115i;
        if (r104 == null) goto L12;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r103.add(((ECHybridListItemVO) r105.next()).a());
    L12:
        Unit r106 = Unit.INSTANCE;
        r100.f47115i = r103;
        HashMap r107 = new HashMap();
        Map<String, String> r108 = this.f47116j;
        if (r108 == null) goto L18;
        Iterator<Map.Entry<String, String>> r109 = r108.entrySet().iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        Map.Entry<String, String> r110 = r109.next();
        r107.put(r110.getKey(), r110.getValue());
    L18:
        Unit r111 = Unit.INSTANCE;
        r100.f47116j = r107;
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public final List<ECHybridListItemVO> b() {
        ArrayList<ECHybridListItemVO> r100 = this.f47115i;
        if (r100 == null) goto L10;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        if ((!((ECHybridListItemVO) r103).l()) == false) goto L6;
        r101.add(r103);
        goto L6
    L17:
        return r101;
    L10:
        return null;
    }

    public final int hashCode() {
        String r100 = this.f47107a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f47112f) * 31) + this.f47113g) * 31;
        j r104 = this.f47114h;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public i() {
        this.f47108b = ECSectionOperationType.NONE;
        this.f47109c = Boolean.FALSE;
        this.f47110d = 0;
        this.f47111e = 0;
        this.f47112f = 1;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final int getType() {
        return this.f47113g;
    }

    public final void c(ECSectionOperationType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f47108b = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(i.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.f47107a, ((i) r100).f47107a)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.entity.ECHybridListSectionVO");
    L8:
        r101 = null;
        goto L10
    }
}
