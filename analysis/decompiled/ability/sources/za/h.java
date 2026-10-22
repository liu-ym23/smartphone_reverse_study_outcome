package za;

import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f7017a;
    public final String b;
    public final List c;
    public final String d;
    public final long e;

    public h(int i, String str, String str2, List actionHistory) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k.f(actionHistory, "actionHistory");
        this.f7017a = i;
        this.b = str;
        this.c = actionHistory;
        this.d = str2;
        this.e = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f7017a == hVar.f7017a && k.b(this.b, hVar.b) && k.b(this.c, hVar.c) && k.b(this.d, hVar.d) && this.e == hVar.e;
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f7017a) * 31;
        String str = this.b;
        int iE = androidx.appfunctions.metadata.a.e(this.c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.d;
        return Long.hashCode(this.e) + ((iE + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(this.f7017a, "TakeoverContext(currentStep=", ", lastScreenshotBase64=", this.b, ", actionHistory=");
        sbK.append(this.c);
        sbK.append(", interruptedActionId=");
        sbK.append(this.d);
        sbK.append(", takeoverTimestamp=");
        return androidx.constraintlayout.core.dsl.a.e(this.e, ")", sbK);
    }
}
