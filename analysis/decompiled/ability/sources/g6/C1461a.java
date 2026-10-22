package g6;

import kotlin.jvm.internal.k;

/* renamed from: g6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1461a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4484a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final long g;

    public C1461a(String taskId, String taskName, String state, String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k.f(taskId, "taskId");
        k.f(taskName, "taskName");
        k.f(state, "state");
        this.f4484a = taskId;
        this.b = taskName;
        this.c = state;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1461a)) {
            return false;
        }
        C1461a c1461a = (C1461a) obj;
        return k.b(this.f4484a, c1461a.f4484a) && k.b(this.b, c1461a.b) && k.b(this.c, c1461a.c) && k.b(this.d, c1461a.d) && k.b(this.e, c1461a.e) && k.b(this.f, c1461a.f) && this.g == c1461a.g;
    }

    public final int hashCode() {
        return Long.hashCode(this.g) + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(this.f4484a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("DebugInfo(taskId=", this.f4484a, ", taskName=", this.b, ", state=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.c, ", modelId=", this.d, ", explain=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.e, ", lastAction=", this.f, ", updatedAtMs=");
        return androidx.constraintlayout.core.dsl.a.e(this.g, ")", sbW);
    }
}
