package za;

import java.util.Map;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiagent.model.TakeoverReasonType;

/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f7018a;
    public final String b;
    public final SessionState c;
    public final long d;
    public final Long e;
    public final int f;
    public final int g;
    public final c h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7019j;
    public final String k;
    public final TakeoverReasonType l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final Map p;

    public i(String sessionId, String taskDescription, SessionState state, long j5, Long l, int i, int i6, c progress, long j6, String str, String str2, TakeoverReasonType takeoverReasonType, boolean z10, boolean z11, boolean z12, Map metadata) {
        k.f(sessionId, "sessionId");
        k.f(taskDescription, "taskDescription");
        k.f(state, "state");
        k.f(progress, "progress");
        k.f(metadata, "metadata");
        this.f7018a = sessionId;
        this.b = taskDescription;
        this.c = state;
        this.d = j5;
        this.e = l;
        this.f = i;
        this.g = i6;
        this.h = progress;
        this.i = j6;
        this.f7019j = str;
        this.k = str2;
        this.l = takeoverReasonType;
        this.m = z10;
        this.n = z11;
        this.o = z12;
        this.p = metadata;
    }

    public static i a(i iVar, SessionState sessionState, Long l, int i, int i6, c cVar, long j5, String str, String str2, TakeoverReasonType takeoverReasonType, boolean z10, int i10) {
        String sessionId = iVar.f7018a;
        String taskDescription = iVar.b;
        SessionState state = (i10 & 4) != 0 ? iVar.c : sessionState;
        long j6 = iVar.d;
        Long l5 = (i10 & 16) != 0 ? iVar.e : l;
        int i11 = (i10 & 32) != 0 ? iVar.f : i;
        int i12 = (i10 & 64) != 0 ? iVar.g : i6;
        c progress = (i10 & 128) != 0 ? iVar.h : cVar;
        long j10 = (i10 & 256) != 0 ? iVar.i : j5;
        String str3 = (i10 & 512) != 0 ? iVar.f7019j : str;
        String str4 = (i10 & 1024) != 0 ? iVar.k : str2;
        TakeoverReasonType takeoverReasonType2 = (i10 & 2048) != 0 ? iVar.l : takeoverReasonType;
        boolean z11 = (i10 & 4096) != 0 ? iVar.m : z10;
        boolean z12 = iVar.n;
        boolean z13 = iVar.o;
        Map metadata = iVar.p;
        iVar.getClass();
        k.f(sessionId, "sessionId");
        k.f(taskDescription, "taskDescription");
        k.f(state, "state");
        k.f(progress, "progress");
        k.f(metadata, "metadata");
        return new i(sessionId, taskDescription, state, j6, l5, i11, i12, progress, j10, str3, str4, takeoverReasonType2, z11, z12, z13, metadata);
    }

    public final i b(SessionState sessionState) {
        return a(this, sessionState, sessionState.a() ? Long.valueOf(System.currentTimeMillis()) : this.e, 0, 0, null, System.currentTimeMillis(), null, null, null, false, 65259);
    }

    public final long c() {
        return this.d;
    }

    public final SessionState d() {
        return this.c;
    }

    public final i e(c cVar) {
        return a(this, null, null, cVar.f7000a, cVar.b, cVar, System.currentTimeMillis(), null, null, null, false, 65055);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return k.b(this.f7018a, iVar.f7018a) && k.b(this.b, iVar.b) && this.c == iVar.c && this.d == iVar.d && k.b(this.e, iVar.e) && this.f == iVar.f && this.g == iVar.g && k.b(this.h, iVar.h) && this.i == iVar.i && k.b(this.f7019j, iVar.f7019j) && k.b(this.k, iVar.k) && this.l == iVar.l && this.m == iVar.m && this.n == iVar.n && this.o == iVar.o && k.b(this.p, iVar.p);
    }

    public final int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c((this.c.hashCode() + B7.a.c(this.f7018a.hashCode() * 31, 31, this.b)) * 31, 31, this.d);
        Long l = this.e;
        int iC2 = androidx.appfunctions.metadata.a.c((this.h.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.g, androidx.constraintlayout.core.dsl.a.a(this.f, (iC + (l == null ? 0 : l.hashCode())) * 31, 31), 31)) * 31, 31, this.i);
        String str = this.f7019j;
        int iHashCode = (iC2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.k;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        TakeoverReasonType takeoverReasonType = this.l;
        return this.p.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((iHashCode2 + (takeoverReasonType != null ? takeoverReasonType.hashCode() : 0)) * 31, 31, this.m), 31, this.n), 31, this.o);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("TaskExecutionInfo(sessionId=", this.f7018a, ", taskDescription=", this.b, ", state=");
        sbW.append(this.c);
        sbW.append(", startTime=");
        sbW.append(this.d);
        sbW.append(", endTime=");
        sbW.append(this.e);
        sbW.append(", currentStep=");
        sbW.append(this.f);
        sbW.append(", totalSteps=");
        sbW.append(this.g);
        sbW.append(", progress=");
        sbW.append(this.h);
        androidx.compose.foundation.b.y(this.i, ", lastUpdateTime=", ", errorMessage=", sbW);
        androidx.constraintlayout.core.dsl.a.A(sbW, this.f7019j, ", takeoverReason=", this.k, ", takeoverReasonType=");
        sbW.append(this.l);
        sbW.append(", isRecovering=");
        sbW.append(this.m);
        sbW.append(", takeoverEverHappened=");
        sbW.append(this.n);
        sbW.append(", infoEverHappened=");
        sbW.append(this.o);
        sbW.append(", metadata=");
        sbW.append(this.p);
        sbW.append(")");
        return sbW.toString();
    }
}
