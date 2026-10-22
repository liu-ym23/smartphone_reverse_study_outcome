package com.obric.agent.dm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ECA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputParams {

    @SerializedName("candidate")
    private final a candidate;

    @SerializedName("target")
    private final c target;

    @SerializedName("type")
    private final d type;

    public InputParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InputParams copy$default(InputParams r0, a r1, d r2, c r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.candidate;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.target;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final a component1() {
        return this.candidate;
    }

    public final d component2() {
        return this.type;
    }

    public final c component3() {
        return this.target;
    }

    public final InputParams copy(a r1, d r2, c r3) {
        return new InputParams(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputParams.class) == true) goto L8;
        return false;
    L8:
        InputParams r6 = (InputParams) ZeusTransformUtils.preCheckCast(r5, InputParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.candidate, r6.candidate) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.target, r6.target) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        a r0 = this.candidate;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        d r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        c r7 = this.target;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InputParams(candidate=" + this.candidate + ", type=" + this.type + ", target=" + this.target + ')';
    }

    public InputParams(a r1, d r2, c r3) {
        this.candidate = r1;
        this.type = r2;
        this.target = r3;
    }

    public /* synthetic */ InputParams(a r2, d r3, c r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final a getCandidate() {
        return this.candidate;
    }

    public final d getType() {
        return this.type;
    }

    public final c getTarget() {
        return this.target;
    }
}
