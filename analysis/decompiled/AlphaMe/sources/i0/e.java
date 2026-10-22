package i0;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f13010a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13011b;

    /* renamed from: c, reason: collision with root package name */
    public final List f13012c;

    /* renamed from: d, reason: collision with root package name */
    public final List f13013d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public e(String name, boolean z4, List columns, List orders) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(orders, "orders");
        this.f13010a = name;
        this.f13011b = z4;
        this.f13012c = columns;
        this.f13013d = orders;
        List arrayList = orders;
        if (arrayList.isEmpty()) {
            int size = columns.size();
            arrayList = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add("ASC");
            }
        }
        this.f13013d = (List) arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f13011b != eVar.f13011b || !Intrinsics.areEqual(this.f13012c, eVar.f13012c) || !Intrinsics.areEqual(this.f13013d, eVar.f13013d)) {
            return false;
        }
        String str = this.f13010a;
        boolean zY = StringsKt.y(str, "index_");
        String str2 = eVar.f13010a;
        return zY ? StringsKt.y(str2, "index_") : Intrinsics.areEqual(str, str2);
    }

    public final int hashCode() {
        String str = this.f13010a;
        return this.f13013d.hashCode() + ((this.f13012c.hashCode() + ((((StringsKt.y(str, "index_") ? -1184239155 : str.hashCode()) * 31) + (this.f13011b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.f13010a + "', unique=" + this.f13011b + ", columns=" + this.f13012c + ", orders=" + this.f13013d + "'}";
    }
}
