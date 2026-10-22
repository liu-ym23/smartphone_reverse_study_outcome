package h3;

import java.util.ArrayList;
import m.x;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f4082a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4083b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4084c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4085d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4086e;

    public b(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2) {
        this.f4082a = str;
        this.f4083b = str2;
        this.f4084c = str3;
        this.f4085d = arrayList;
        this.f4086e = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4082a.equals(bVar.f4082a) && this.f4083b.equals(bVar.f4083b) && this.f4084c.equals(bVar.f4084c) && this.f4085d.equals(bVar.f4085d)) {
            return this.f4086e.equals(bVar.f4086e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4086e.hashCode() + ((this.f4085d.hashCode() + x.g(this.f4084c, x.g(this.f4083b, this.f4082a.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f4082a + "', onDelete='" + this.f4083b + " +', onUpdate='" + this.f4084c + "', columnNames=" + this.f4085d + ", referenceColumnNames=" + this.f4086e + '}';
    }
}
