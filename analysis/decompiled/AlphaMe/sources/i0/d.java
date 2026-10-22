package i0;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class d implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f13006a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13007b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13008c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13009d;

    public d(int i4, int i5, String from, String to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.f13006a = i4;
        this.f13007b = i5;
        this.f13008c = from;
        this.f13009d = to;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        d other = (d) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        int i4 = this.f13006a - other.f13006a;
        return i4 == 0 ? this.f13007b - other.f13007b : i4;
    }
}
