package com.stepos.digitalwellbeing.server.data;

import f2.C0711p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    long f14534a;

    /* renamed from: b, reason: collision with root package name */
    long f14535b;

    public k(long j5, long j6) {
        this.f14534a = j5;
        this.f14535b = j6;
        if (j5 <= j6) {
            return;
        }
        throw new IllegalArgumentException("error start : " + j5 + " > end : " + j6);
    }

    public static k c(k kVar, k kVar2) {
        if (kVar == null) {
            return kVar2;
        }
        if (kVar2 == null || kVar.equals(kVar2)) {
            return kVar;
        }
        k kVar3 = kVar.f14534a < kVar2.f14534a ? kVar : kVar2;
        if (kVar3 == kVar) {
            kVar = kVar2;
        }
        long j5 = kVar3.f14535b;
        if (j5 < kVar.f14534a) {
            return null;
        }
        return new k(kVar3.f14534a, Math.max(j5, kVar.f14535b));
    }

    public static List<k> d(List<k> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator() { // from class: com.stepos.digitalwellbeing.server.data.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((k) obj).f14534a, ((k) obj2).f14534a);
            }
        });
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((k) arrayList.get(0));
        for (int i5 = 1; i5 < arrayList.size(); i5++) {
            k kVar = (k) arrayList.get(i5);
            k kVarC = c((k) arrayList2.get(arrayList2.size() - 1), kVar);
            if (kVarC != null) {
                arrayList2.set(arrayList2.size() - 1, kVarC);
            } else {
                arrayList2.add(kVar);
            }
        }
        return arrayList2;
    }

    public long b() {
        return this.f14535b - this.f14534a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f14534a == kVar.f14534a && this.f14535b == kVar.f14535b;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f14534a), Long.valueOf(this.f14535b));
    }

    public String toString() {
        return "UsagePeriod{start=" + C0711p.j(this.f14534a) + ", end=" + C0711p.j(this.f14535b) + '}';
    }
}
