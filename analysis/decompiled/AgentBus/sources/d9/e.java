package d9;

import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class e extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final String f3006c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3007d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2) {
        super(14);
        k.e(str, "name");
        k.e(str2, "desc");
        this.f3006c = str;
        this.f3007d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.a(this.f3006c, eVar.f3006c) && k.a(this.f3007d, eVar.f3007d);
    }

    @Override // w7.e0
    public final String f() {
        return this.f3006c + this.f3007d;
    }

    public final int hashCode() {
        return this.f3007d.hashCode() + (this.f3006c.hashCode() * 31);
    }
}
