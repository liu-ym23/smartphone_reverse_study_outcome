package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Parameter {
    private final String desc;
    private final boolean is_required;
    private final String name;
    private final int type;

    public Parameter(String r2, String r3, boolean r4, int r5) {
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "desc");
        this.name = r2;
        this.desc = r3;
        this.is_required = r4;
        this.type = r5;
    }

    public /* synthetic */ Parameter(String r1, String r2, boolean r3, int r4, int r5, d.h.b.h r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = 1;
    L8:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ Parameter copy$default(Parameter r0, String r1, String r2, boolean r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.desc;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.is_required;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.type;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.is_required;
    }

    public final int component4() {
        return this.type;
    }

    public final Parameter copy(String r1, String r2, boolean r3, int r4) {
        d.h.b.o.e(r1, "name");
        d.h.b.o.e(r2, "desc");
        return new Parameter(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Parameter.class) == true) goto L8;
        return false;
    L8:
        Parameter r6 = (Parameter) ZeusTransformUtils.preCheckCast(r5, Parameter.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (this.is_required == r6.is_required) goto L18;
        return false;
    L18:
        if (this.type == r6.type) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r1 = this.is_required;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((r0 + r2) * 31) + Integer.hashCode(this.type);
    }

    public final boolean is_required() {
        return this.is_required;
    }

    public String toString() {
        return "Parameter(name=" + this.name + ", desc=" + this.desc + ", is_required=" + this.is_required + ", type=" + this.type + ')';
    }
}
