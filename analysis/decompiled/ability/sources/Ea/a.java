package Ea;

import java.util.List;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f500a;
    public final int b;
    public final String c;
    public final List d;
    public final String e;
    public final String f;
    public final long g;

    public a(String sessionId, int i, String str, List actionHistory, String str2, String taskDescription) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k.f(sessionId, "sessionId");
        k.f(actionHistory, "actionHistory");
        k.f(taskDescription, "taskDescription");
        this.f500a = sessionId;
        this.b = i;
        this.c = str;
        this.d = actionHistory;
        this.e = str2;
        this.f = taskDescription;
        this.g = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f500a, aVar.f500a) && this.b == aVar.b && k.b(this.c, aVar.c) && k.b(this.d, aVar.d) && k.b(this.e, aVar.e) && k.b(this.f, aVar.f) && this.g == aVar.g;
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, this.f500a.hashCode() * 31, 31);
        String str = this.c;
        int iE = androidx.appfunctions.metadata.a.e(this.d, (iA + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.e;
        return Long.hashCode(this.g) + B7.a.c((iE + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.f);
    }

    public final String toString() {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(this.b, "ExecutionContext(sessionId=", this.f500a, ", currentStep=", ", lastScreenshotBase64=");
        sbT.append(this.c);
        sbT.append(", actionHistory=");
        sbT.append(this.d);
        sbT.append(", interruptedActionId=");
        androidx.constraintlayout.core.dsl.a.A(sbT, this.e, ", taskDescription=", this.f, ", savedTimestamp=");
        return androidx.constraintlayout.core.dsl.a.e(this.g, ")", sbT);
    }
}
