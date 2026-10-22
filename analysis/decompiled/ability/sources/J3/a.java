package J3;

import androidx.compose.foundation.b;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f868a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final String f869j;
    public final String k;
    public final String l;

    public a(String packageName, String toolName, String functionName, int i, String description, String callType, String callingMethod, Integer num, String str, String str2, String str3, String str4) {
        k.f(packageName, "packageName");
        k.f(toolName, "toolName");
        k.f(functionName, "functionName");
        k.f(description, "description");
        k.f(callType, "callType");
        k.f(callingMethod, "callingMethod");
        this.f868a = packageName;
        this.b = toolName;
        this.c = functionName;
        this.d = i;
        this.e = description;
        this.f = callType;
        this.g = callingMethod;
        this.h = num;
        this.i = str;
        this.f869j = str2;
        this.k = str3;
        this.l = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f868a, aVar.f868a) && k.b(this.b, aVar.b) && k.b(this.c, aVar.c) && this.d == aVar.d && k.b(this.e, aVar.e) && k.b(this.f, aVar.f) && k.b(this.g, aVar.g) && k.b(this.h, aVar.h) && k.b(this.i, aVar.i) && k.b(this.f869j, aVar.f869j) && k.b(this.k, aVar.k) && k.b(this.l, aVar.l);
    }

    public final int hashCode() {
        int iC = B7.a.c(B7.a.c(B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.d, B7.a.c(B7.a.c(this.f868a.hashCode() * 31, 31, this.b), 31, this.c), 31), 31, this.e), 31, this.f), 31, this.g);
        Integer num = this.h;
        int iHashCode = (iC + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.i;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f869j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.k;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.l;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("AtomicAbilityInfo(packageName=", this.f868a, ", toolName=", this.b, ", functionName=");
        b.B(sbW, this.c, ", abilityId=", this.d, ", description=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.e, ", callType=", this.f, ", callingMethod=");
        sbW.append(this.g);
        sbW.append(", timeout=");
        sbW.append(this.h);
        sbW.append(", permission=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.i, ", inputSchemaJson=", this.f869j, ", outputSchemaJson=");
        return androidx.appfunctions.metadata.a.p(sbW, this.k, ", extraJson=", this.l, ")");
    }
}
