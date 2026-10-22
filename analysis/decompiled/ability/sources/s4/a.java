package s4;

import com.stepos.ability.permission.rules.LedgerRules$Resolution;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements LedgerRules$Resolution {

    /* renamed from: a, reason: collision with root package name */
    public final String f5980a;
    public final String b;
    public final boolean c;
    public final String d;

    public a(String str, String groupId, boolean z10, String str2) {
        k.f(groupId, "groupId");
        this.f5980a = str;
        this.b = groupId;
        this.c = z10;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f5980a, aVar.f5980a) && k.b(this.b, aVar.b) && this.c == aVar.c && k.b(this.d, aVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + androidx.appfunctions.metadata.a.d(B7.a.c(this.f5980a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("Ok(scope=", this.f5980a, ", groupId=", this.b, ", redline=");
        sbW.append(this.c);
        sbW.append(", dataLevel=");
        sbW.append(this.d);
        sbW.append(")");
        return sbW.toString();
    }
}
