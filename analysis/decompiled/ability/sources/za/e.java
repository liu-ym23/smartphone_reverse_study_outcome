package za;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiagent.model.TakeoverReasonType;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: A, reason: collision with root package name */
    public final List f7002A;

    /* renamed from: B, reason: collision with root package name */
    public final List f7003B;

    /* renamed from: a, reason: collision with root package name */
    public final String f7004a;
    public final String b;
    public final String c;
    public final Integer d;
    public SessionState e;
    public final long f;
    public long g;
    public Long h;
    public final List i;

    /* renamed from: j, reason: collision with root package name */
    public final List f7005j;
    public final Map k;
    public String l;
    public Long m;
    public String n;
    public TakeoverReasonType o;
    public SessionState p;

    /* renamed from: q, reason: collision with root package name */
    public String f7006q;

    /* renamed from: r, reason: collision with root package name */
    public h f7007r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7008s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7009t;
    public boolean u;

    /* renamed from: v, reason: collision with root package name */
    public int f7010v;

    /* renamed from: w, reason: collision with root package name */
    public int f7011w;

    /* renamed from: x, reason: collision with root package name */
    public c f7012x;
    public final List y;

    /* renamed from: z, reason: collision with root package name */
    public final j f7013z;

    public e(String id, String task, String str, Integer num, Map metadata, j jVar, List preOpenAppNames, List list) {
        SessionState sessionState = SessionState.f6031a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        c cVar = new c(i, i6, i10, FastDoubleMath.DOUBLE_EXPONENT_BIAS, 0L);
        ArrayList arrayList3 = new ArrayList();
        k.f(id, "id");
        k.f(task, "task");
        k.f(metadata, "metadata");
        k.f(preOpenAppNames, "preOpenAppNames");
        this.f7004a = id;
        this.b = task;
        this.c = str;
        this.d = num;
        this.e = sessionState;
        this.f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis2;
        this.h = null;
        this.i = arrayList;
        this.f7005j = arrayList2;
        this.k = metadata;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f7006q = null;
        this.f7007r = null;
        this.f7008s = false;
        this.f7009t = false;
        this.u = false;
        this.f7010v = 0;
        this.f7011w = 0;
        this.f7012x = cVar;
        this.y = arrayList3;
        this.f7013z = jVar;
        this.f7002A = preOpenAppNames;
        this.f7003B = list;
    }

    public final String a() {
        return this.f7004a;
    }

    public final List b() {
        return this.f7002A;
    }

    public final String c() {
        return this.b;
    }

    public final void d(String reason, h context, TakeoverReasonType reasonType) {
        k.f(reason, "reason");
        k.f(context, "context");
        k.f(reasonType, "reasonType");
        if (this.e.a()) {
            return;
        }
        this.p = this.e;
        this.n = reason;
        this.o = reasonType;
        this.m = Long.valueOf(System.currentTimeMillis());
        this.f7007r = context;
        this.f7008s = false;
        this.f7009t = true;
        f(SessionState.f);
    }

    public final i e() {
        return new i(this.f7004a, this.b, this.e, this.f, this.h, this.f7010v, this.f7011w, this.f7012x, this.g, this.l, this.n, this.o, this.f7008s, this.f7009t, this.u, this.k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return k.b(this.f7004a, eVar.f7004a) && k.b(this.b, eVar.b) && k.b(this.c, eVar.c) && k.b(this.d, eVar.d) && this.e == eVar.e && this.f == eVar.f && this.g == eVar.g && k.b(this.h, eVar.h) && k.b(this.i, eVar.i) && k.b(this.f7005j, eVar.f7005j) && k.b(this.k, eVar.k) && k.b(this.l, eVar.l) && k.b(this.m, eVar.m) && k.b(this.n, eVar.n) && this.o == eVar.o && this.p == eVar.p && k.b(this.f7006q, eVar.f7006q) && k.b(this.f7007r, eVar.f7007r) && this.f7008s == eVar.f7008s && this.f7009t == eVar.f7009t && this.u == eVar.u && this.f7010v == eVar.f7010v && this.f7011w == eVar.f7011w && k.b(this.f7012x, eVar.f7012x) && k.b(this.y, eVar.y) && k.b(this.f7013z, eVar.f7013z) && k.b(this.f7002A, eVar.f7002A) && k.b(this.f7003B, eVar.f7003B);
    }

    public final void f(SessionState newState) {
        k.f(newState, "newState");
        SessionState sessionState = this.e;
        if (!sessionState.a() || newState == sessionState) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.e = newState;
            this.g = jCurrentTimeMillis;
            if (newState.a()) {
                this.f7008s = false;
                if (this.h == null || !sessionState.a()) {
                    this.h = Long.valueOf(jCurrentTimeMillis);
                }
            }
        }
    }

    public final int hashCode() {
        int iC = B7.a.c(this.f7004a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.d;
        int iC2 = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((this.e.hashCode() + ((iHashCode + (num == null ? 0 : num.hashCode())) * 31)) * 31, 31, this.f), 31, this.g);
        Long l = this.h;
        int iF = androidx.appfunctions.metadata.a.f(this.k, androidx.appfunctions.metadata.a.e(this.f7005j, androidx.appfunctions.metadata.a.e(this.i, (iC2 + (l == null ? 0 : l.hashCode())) * 31, 31), 31), 31);
        String str2 = this.l;
        int iHashCode2 = (iF + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l5 = this.m;
        int iHashCode3 = (iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str3 = this.n;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        TakeoverReasonType takeoverReasonType = this.o;
        int iHashCode5 = (iHashCode4 + (takeoverReasonType == null ? 0 : takeoverReasonType.hashCode())) * 31;
        SessionState sessionState = this.p;
        int iHashCode6 = (iHashCode5 + (sessionState == null ? 0 : sessionState.hashCode())) * 31;
        String str4 = this.f7006q;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        h hVar = this.f7007r;
        int iE = androidx.appfunctions.metadata.a.e(this.y, (this.f7012x.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.f7011w, androidx.constraintlayout.core.dsl.a.a(this.f7010v, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d((iHashCode7 + (hVar == null ? 0 : hVar.hashCode())) * 31, 31, this.f7008s), 31, this.f7009t), 31, this.u), 31), 31)) * 31, 923521);
        j jVar = this.f7013z;
        int iE2 = androidx.appfunctions.metadata.a.e(this.f7002A, (iE + (jVar == null ? 0 : jVar.hashCode())) * 31, 31);
        List list = this.f7003B;
        return Boolean.hashCode(false) + androidx.constraintlayout.core.dsl.a.a(0, (iE2 + (list == null ? 0 : list.hashCode())) * 31, 31);
    }

    public final String toString() {
        SessionState sessionState = this.e;
        long j5 = this.g;
        Long l = this.h;
        String str = this.l;
        Long l5 = this.m;
        String str2 = this.n;
        TakeoverReasonType takeoverReasonType = this.o;
        SessionState sessionState2 = this.p;
        String str3 = this.f7006q;
        h hVar = this.f7007r;
        boolean z10 = this.f7008s;
        boolean z11 = this.f7009t;
        boolean z12 = this.u;
        int i = this.f7010v;
        int i6 = this.f7011w;
        c cVar = this.f7012x;
        StringBuilder sbW = B7.a.w("Session(id=", this.f7004a, ", task=", this.b, ", openApp=");
        sbW.append(this.c);
        sbW.append(", displayId=");
        sbW.append(this.d);
        sbW.append(", state=");
        sbW.append(sessionState);
        sbW.append(", createdAt=");
        sbW.append(this.f);
        androidx.compose.foundation.b.y(j5, ", updatedAt=", ", completedAt=", sbW);
        sbW.append(l);
        sbW.append(", _actions=");
        sbW.append(this.i);
        sbW.append(", _actionPathList=");
        sbW.append(this.f7005j);
        sbW.append(", metadata=");
        sbW.append(this.k);
        sbW.append(", errorMessage=");
        sbW.append(str);
        sbW.append(", takeoverTimestamp=");
        sbW.append(l5);
        sbW.append(", takeoverReason=");
        sbW.append(str2);
        sbW.append(", takeoverReasonType=");
        sbW.append(takeoverReasonType);
        sbW.append(", preTakeoverState=");
        sbW.append(sessionState2);
        sbW.append(", currentActionId=");
        sbW.append(str3);
        sbW.append(", takeoverContext=");
        sbW.append(hVar);
        sbW.append(", isRecovering=");
        sbW.append(z10);
        sbW.append(", takeoverEverHappened=");
        sbW.append(z11);
        sbW.append(", infoEverHappened=");
        sbW.append(z12);
        sbW.append(", currentStepIndex=");
        androidx.constraintlayout.core.dsl.a.y(sbW, i, ", totalSteps=", i6, ", executionProgress=");
        sbW.append(cVar);
        sbW.append(", _userInputs=");
        sbW.append(this.y);
        sbW.append(", currentInputRequestId=null, node=null, slotMap=null, taskTreeContext=");
        sbW.append(this.f7013z);
        sbW.append(", preOpenAppNames=");
        sbW.append(this.f7002A);
        sbW.append(", experienceActions=");
        return androidx.appfunctions.metadata.a.q(sbW, this.f7003B, ", experienceIndex=0, enableExperience=false)");
    }
}
