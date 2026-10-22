package d9;

import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class d extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final String f3004c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3005d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2) {
        super(14);
        k.e(str, "name");
        k.e(str2, "desc");
        this.f3004c = str;
        this.f3005d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return k.a(this.f3004c, dVar.f3004c) && k.a(this.f3005d, dVar.f3005d);
    }

    @Override // w7.e0
    public final String f() {
        return this.f3004c + ':' + this.f3005d;
    }

    public final int hashCode() {
        return this.f3005d.hashCode() + (this.f3004c.hashCode() * 31);
    }
}
