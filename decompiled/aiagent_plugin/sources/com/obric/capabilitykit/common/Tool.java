package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Tool {
    private final String desc;
    private final String name;
    private final List<Parameter> params;
    private final boolean register2cloud;

    public Tool(String r3, String r4, boolean r5, List<Parameter> r6) {
        List<Parameter> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "name");
        d.h.b.o.e(r4, "desc");
        d.h.b.o.e(r7, "params");
        this.name = r3;
        this.desc = r4;
        this.register2cloud = r5;
        this.params = r7;
    }

    public /* synthetic */ Tool(String r2, String r3, boolean r4, List r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r8 = new ArrayList();
    L8:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ Tool copy$default(Tool r1, String r2, String r3, boolean r4, List r5, int r6, Object r7) {
        List<Parameter> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.name;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.desc;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.register2cloud;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.params;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.desc;
    }

    public final boolean component3() {
        return this.register2cloud;
    }

    public final List<Parameter> component4() {
        return this.params;
    }

    public final Tool copy(String r2, String r3, boolean r4, List<Parameter> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "name");
        d.h.b.o.e(r3, "desc");
        d.h.b.o.e(r1, "params");
        return new Tool(r2, r3, r4, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Tool.class) == true) goto L8;
        return false;
    L8:
        Tool r6 = (Tool) ZeusTransformUtils.preCheckCast(r5, Tool.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (this.register2cloud == r6.register2cloud) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.params, r6.params) == true) goto L20;
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

    public final List<Parameter> getParams() {
        return this.params;
    }

    public final boolean getRegister2cloud() {
        return this.register2cloud;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean r1 = this.register2cloud;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((r0 + r2) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "Tool(name=" + this.name + ", desc=" + this.desc + ", register2cloud=" + this.register2cloud + ", params=" + this.params + ')';
    }
}
