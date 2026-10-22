package w1;

import m.x;
import n.f;
import q7.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f10638e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10639a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10640b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10641c;

    /* renamed from: d, reason: collision with root package name */
    public final y1.b f10642d;

    static {
        new b();
    }

    public b() {
        y1.b bVar = y1.b.f11542h;
        this.f10639a = true;
        this.f10640b = 1;
        this.f10641c = 1;
        this.f10642d = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10639a == bVar.f10639a && this.f10640b == bVar.f10640b && this.f10641c == bVar.f10641c && k.a(this.f10642d, bVar.f10642d);
    }

    public final int hashCode() {
        return this.f10642d.f11543f.hashCode() + f.b(this.f10641c, f.b(this.f10640b, x.e(f.b(0, Boolean.hashCode(false) * 31, 31), 31, this.f10639a), 31), 961);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ImeOptions(singleLine=false, capitalization=");
        String str = "None";
        sb2.append((Object) "None");
        sb2.append(", autoCorrect=");
        sb2.append(this.f10639a);
        sb2.append(", keyboardType=");
        int i2 = this.f10640b;
        sb2.append((Object) (i2 == 0 ? "Unspecified" : i2 == 1 ? "Text" : i2 == 2 ? "Ascii" : i2 == 3 ? "Number" : i2 == 4 ? "Phone" : i2 == 5 ? "Uri" : i2 == 6 ? "Email" : i2 == 7 ? "Password" : i2 == 8 ? "NumberPassword" : i2 == 9 ? "Decimal" : "Invalid"));
        sb2.append(", imeAction=");
        int i10 = this.f10641c;
        if (i10 == -1) {
            str = "Unspecified";
        } else if (i10 != 0) {
            str = i10 == 1 ? "Default" : i10 == 2 ? "Go" : i10 == 3 ? "Search" : i10 == 4 ? "Send" : i10 == 5 ? "Previous" : i10 == 6 ? "Next" : i10 == 7 ? "Done" : "Invalid";
        }
        sb2.append((Object) str);
        sb2.append(", platformImeOptions=null, hintLocales=");
        sb2.append(this.f10642d);
        sb2.append(')');
        return sb2.toString();
    }
}
