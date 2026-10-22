package za;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.model.StepExecutionState;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f7015a;
    public final int b;
    public final String c;
    public final ActionType d;
    public final StepExecutionState e;
    public final long f;
    public final Long g;
    public final long h;
    public final Object i;

    /* renamed from: j, reason: collision with root package name */
    public final String f7016j;
    public final Throwable k;
    public final String l;
    public final String m;
    public final Map n;

    public g(String str, int i, String str2, ActionType actionType, StepExecutionState stepExecutionState, long j5, Long l, long j6, Object obj, String str3, Throwable th, String str4, String str5, Map map) {
        this.f7015a = str;
        this.b = i;
        this.c = str2;
        this.d = actionType;
        this.e = stepExecutionState;
        this.f = j5;
        this.g = l;
        this.h = j6;
        this.i = obj;
        this.f7016j = str3;
        this.k = th;
        this.l = str4;
        this.m = str5;
        this.n = map;
    }

    public static g a(g gVar, String str, ActionType actionType, StepExecutionState stepExecutionState, Long l, long j5, Object obj, String str2, Throwable th, String str3, String str4, LinkedHashMap linkedHashMap, int i) {
        String str5 = gVar.f7015a;
        int i6 = gVar.b;
        String str6 = (i & 4) != 0 ? gVar.c : str;
        ActionType actionType2 = (i & 8) != 0 ? gVar.d : actionType;
        StepExecutionState stepExecutionState2 = (i & 16) != 0 ? gVar.e : stepExecutionState;
        long j6 = gVar.f;
        Long l5 = (i & 64) != 0 ? gVar.g : l;
        long j10 = (i & 128) != 0 ? gVar.h : j5;
        gVar.getClass();
        gVar.getClass();
        Object obj2 = (i & 1024) != 0 ? gVar.i : obj;
        String str7 = (i & 2048) != 0 ? gVar.f7016j : str2;
        Throwable th2 = (i & 4096) != 0 ? gVar.k : th;
        String str8 = (i & 8192) != 0 ? gVar.l : str3;
        String str9 = (i & 16384) != 0 ? gVar.m : str4;
        Map map = (i & 32768) != 0 ? gVar.n : linkedHashMap;
        gVar.getClass();
        return new g(str5, i6, str6, actionType2, stepExecutionState2, j6, l5, j10, obj2, str7, th2, str8, str9, map);
    }

    public final long b() {
        long j5 = this.h;
        if (j5 > 0) {
            return j5;
        }
        Long l = this.g;
        return (l != null ? l.longValue() : System.currentTimeMillis()) - this.f;
    }

    public final g c(String errorMessage, Throwable th) {
        k.f(errorMessage, "errorMessage");
        StepExecutionState stepExecutionState = StepExecutionState.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        return a(this, null, null, stepExecutionState, Long.valueOf(jCurrentTimeMillis), b(), null, errorMessage, th, null, null, null, 59183);
    }

    public final g d(StepExecutionState stepExecutionState) {
        return a(this, null, null, stepExecutionState, stepExecutionState.a() ? Long.valueOf(System.currentTimeMillis()) : this.g, stepExecutionState.a() ? b() : this.h, null, null, null, null, null, null, 65327);
    }

    public final g e(Object obj) {
        StepExecutionState stepExecutionState = StepExecutionState.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        return a(this, null, null, stepExecutionState, Long.valueOf(jCurrentTimeMillis), b(), obj, null, null, null, null, null, 64303);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7015a.equals(gVar.f7015a) && this.b == gVar.b && k.b(this.c, gVar.c) && this.d == gVar.d && this.e == gVar.e && this.f == gVar.f && k.b(this.g, gVar.g) && this.h == gVar.h && k.b(this.i, gVar.i) && k.b(this.f7016j, gVar.f7016j) && k.b(this.k, gVar.k) && k.b(this.l, gVar.l) && k.b(this.m, gVar.m) && this.n.equals(gVar.n);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.b, this.f7015a.hashCode() * 31, 31);
        String str = this.c;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        ActionType actionType = this.d;
        int iC = androidx.appfunctions.metadata.a.c((this.e.hashCode() + ((iHashCode + (actionType == null ? 0 : actionType.hashCode())) * 31)) * 31, 31, this.f);
        Long l = this.g;
        int iA2 = androidx.constraintlayout.core.dsl.a.a(3, androidx.constraintlayout.core.dsl.a.a(0, androidx.appfunctions.metadata.a.c((iC + (l == null ? 0 : l.hashCode())) * 31, 31, this.h), 31), 31);
        Object obj = this.i;
        int iHashCode2 = (iA2 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str2 = this.f7016j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Throwable th = this.k;
        int iHashCode4 = (iHashCode3 + (th == null ? 0 : th.hashCode())) * 31;
        String str3 = this.l;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.m;
        return this.n.hashCode() + ((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(this.b, "StepExecutionInfo(stepId=", this.f7015a, ", stepIndex=", ", actionId=");
        sbT.append(this.c);
        sbT.append(", actionType=");
        sbT.append(this.d);
        sbT.append(", state=");
        sbT.append(this.e);
        sbT.append(", startTime=");
        sbT.append(this.f);
        sbT.append(", endTime=");
        sbT.append(this.g);
        sbT.append(", executionTime=");
        sbT.append(this.h);
        sbT.append(", retryCount=0, maxRetries=3, result=");
        sbT.append(this.i);
        sbT.append(", error=");
        sbT.append(this.f7016j);
        sbT.append(", exception=");
        sbT.append(this.k);
        androidx.constraintlayout.core.dsl.a.A(sbT, ", explain=", this.l, ", source=", this.m);
        sbT.append(", metadata=");
        sbT.append(this.n);
        sbT.append(")");
        return sbT.toString();
    }
}
