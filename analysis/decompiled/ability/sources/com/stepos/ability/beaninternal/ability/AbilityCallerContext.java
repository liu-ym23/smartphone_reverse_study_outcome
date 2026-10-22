package com.stepos.ability.beaninternal.ability;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/AbilityCallerContext;", "", "fromPkg", "", "fromSign", "toPkg", "toSign", "taskStartTime", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getFromPkg", "()Ljava/lang/String;", "getFromSign", "getToPkg", "getToSign", "getTaskStartTime", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityCallerContext {
    private final String fromPkg;
    private final String fromSign;
    private final long taskStartTime;
    private final String toPkg;
    private final String toSign;

    public AbilityCallerContext(String fromPkg, String fromSign, String toPkg, String toSign, long j5) {
        k.f(fromPkg, "fromPkg");
        k.f(fromSign, "fromSign");
        k.f(toPkg, "toPkg");
        k.f(toSign, "toSign");
        this.fromPkg = fromPkg;
        this.fromSign = fromSign;
        this.toPkg = toPkg;
        this.toSign = toSign;
        this.taskStartTime = j5;
    }

    public static /* synthetic */ AbilityCallerContext copy$default(AbilityCallerContext abilityCallerContext, String str, String str2, String str3, String str4, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abilityCallerContext.fromPkg;
        }
        if ((i & 2) != 0) {
            str2 = abilityCallerContext.fromSign;
        }
        if ((i & 4) != 0) {
            str3 = abilityCallerContext.toPkg;
        }
        if ((i & 8) != 0) {
            str4 = abilityCallerContext.toSign;
        }
        if ((i & 16) != 0) {
            j5 = abilityCallerContext.taskStartTime;
        }
        long j6 = j5;
        return abilityCallerContext.copy(str, str2, str3, str4, j6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFromPkg() {
        return this.fromPkg;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFromSign() {
        return this.fromSign;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToPkg() {
        return this.toPkg;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToSign() {
        return this.toSign;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTaskStartTime() {
        return this.taskStartTime;
    }

    public final AbilityCallerContext copy(String fromPkg, String fromSign, String toPkg, String toSign, long taskStartTime) {
        k.f(fromPkg, "fromPkg");
        k.f(fromSign, "fromSign");
        k.f(toPkg, "toPkg");
        k.f(toSign, "toSign");
        return new AbilityCallerContext(fromPkg, fromSign, toPkg, toSign, taskStartTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityCallerContext)) {
            return false;
        }
        AbilityCallerContext abilityCallerContext = (AbilityCallerContext) other;
        return k.b(this.fromPkg, abilityCallerContext.fromPkg) && k.b(this.fromSign, abilityCallerContext.fromSign) && k.b(this.toPkg, abilityCallerContext.toPkg) && k.b(this.toSign, abilityCallerContext.toSign) && this.taskStartTime == abilityCallerContext.taskStartTime;
    }

    public final String getFromPkg() {
        return this.fromPkg;
    }

    public final String getFromSign() {
        return this.fromSign;
    }

    public final long getTaskStartTime() {
        return this.taskStartTime;
    }

    public final String getToPkg() {
        return this.toPkg;
    }

    public final String getToSign() {
        return this.toSign;
    }

    public int hashCode() {
        return Long.hashCode(this.taskStartTime) + a.c(a.c(a.c(this.fromPkg.hashCode() * 31, 31, this.fromSign), 31, this.toPkg), 31, this.toSign);
    }

    public String toString() {
        String str = this.fromPkg;
        String str2 = this.fromSign;
        String str3 = this.toPkg;
        String str4 = this.toSign;
        long j5 = this.taskStartTime;
        StringBuilder sbW = a.w("AbilityCallerContext(fromPkg=", str, ", fromSign=", str2, ", toPkg=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", toSign=", str4, ", taskStartTime=");
        return androidx.constraintlayout.core.dsl.a.e(j5, ")", sbW);
    }
}
