package Ba;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import m9.c0;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f272a;
    public final String b;
    public final String c;
    public final String d;
    public final AtomicBoolean e;
    public final boolean f;
    public final long g;
    public final c0 h;

    public h(String actionId, String sessionId, String commandId, String actionType, AtomicBoolean atomicBoolean, c0 c0Var) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k.f(actionId, "actionId");
        k.f(sessionId, "sessionId");
        k.f(commandId, "commandId");
        k.f(actionType, "actionType");
        this.f272a = actionId;
        this.b = sessionId;
        this.c = commandId;
        this.d = actionType;
        this.e = atomicBoolean;
        this.f = true;
        this.g = jCurrentTimeMillis;
        this.h = c0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return k.b(this.f272a, hVar.f272a) && k.b(this.b, hVar.b) && k.b(this.c, hVar.c) && k.b(this.d, hVar.d) && k.b(this.e, hVar.e) && this.f == hVar.f && this.g == hVar.g && k.b(this.h, hVar.h);
    }

    public final int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.d((this.e.hashCode() + B7.a.c(B7.a.c(B7.a.c(this.f272a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d)) * 31, 31, this.f), 31, this.g);
        c0 c0Var = this.h;
        return iC + (c0Var == null ? 0 : c0Var.hashCode());
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("GuiExecutionState(actionId=", this.f272a, ", sessionId=", this.b, ", commandId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.c, ", actionType=", this.d, ", isExecuting=");
        sbW.append(this.e);
        sbW.append(", canBeInterrupted=");
        sbW.append(this.f);
        sbW.append(", startTime=");
        sbW.append(this.g);
        sbW.append(", job=");
        sbW.append(this.h);
        sbW.append(")");
        return sbW.toString();
    }
}
