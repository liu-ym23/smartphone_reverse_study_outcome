package h3;

import ga.r;
import java.util.ArrayList;
import java.util.List;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f4091a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4092b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4093c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4094d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public d(String str, boolean z4, List list, List list2) {
        this.f4091a = str;
        this.f4092b = z4;
        this.f4093c = list;
        this.f4094d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                list2.add("ASC");
            }
        }
        this.f4094d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f4091a;
            if (this.f4092b == dVar.f4092b && this.f4093c.equals(dVar.f4093c) && k.a(this.f4094d, dVar.f4094d)) {
                String str2 = this.f4091a;
                return r.g0(str2, "index_", false) ? r.g0(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f4091a;
        return this.f4094d.hashCode() + x.h(this.f4093c, (((r.g0(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f4092b ? 1 : 0)) * 31, 31);
    }

    public final String toString() {
        return "Index{name='" + this.f4091a + "', unique=" + this.f4092b + ", columns=" + this.f4093c + ", orders=" + this.f4094d + "'}";
    }
}
