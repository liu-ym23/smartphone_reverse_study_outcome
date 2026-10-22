package com.obric.autogui.common.api.agent.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FunctionParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ClarifyFunctionParams {
    private final String content;
    private final List<String> options;
    private final List<Boolean> positiveness;
    private final String securityLevel;
    private final Map<Integer, String> specialStyleOptions;

    public static /* synthetic */ ClarifyFunctionParams copy$default(ClarifyFunctionParams r6, String r7, List r8, List r9, String r10, Map r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<Boolean> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.content;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r14 = r6.options;
    L8:
        List<String> r2 = r14;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.positiveness;
    L11:
        List<Boolean> r3 = r15;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.securityLevel;
    L14:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r16 = r6.specialStyleOptions;
    L18:
        return r6.copy(r1, r2, r3, r4, r16);
    }

    public final String component1() {
        return this.content;
    }

    public final List<String> component2() {
        return this.options;
    }

    public final List<Boolean> component3() {
        return this.positiveness;
    }

    public final String component4() {
        return this.securityLevel;
    }

    public final Map<Integer, String> component5() {
        return this.specialStyleOptions;
    }

    public final ClarifyFunctionParams copy(String r8, List<String> r9, List<Boolean> r10, String r11, Map<Integer, String> r12) {
        return new ClarifyFunctionParams(r8, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), r11, (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ClarifyFunctionParams.class) == true) goto L8;
        return false;
    L8:
        ClarifyFunctionParams r6 = (ClarifyFunctionParams) ZeusTransformUtils.preCheckCast(r5, ClarifyFunctionParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (o.a(this.options, r6.options) == true) goto L15;
        return false;
    L15:
        if (o.a(this.positiveness, r6.positiveness) == true) goto L18;
        return false;
    L18:
        if (o.a(this.securityLevel, r6.securityLevel) == true) goto L21;
        return false;
    L21:
        if (o.a(this.specialStyleOptions, r6.specialStyleOptions) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.options;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Boolean> r7 = this.positiveness;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.securityLevel;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<Integer, String> r13 = this.specialStyleOptions;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClarifyFunctionParams(content=" + this.content + ", options=" + this.options + ", positiveness=" + this.positiveness + ", securityLevel=" + this.securityLevel + ", specialStyleOptions=" + this.specialStyleOptions + ')';
    }

    public ClarifyFunctionParams(String r3, List<String> r4, List<Boolean> r5, String r6, Map<Integer, String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<Boolean> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        this.content = r3;
        this.options = r8;
        this.positiveness = r9;
        this.securityLevel = r6;
        this.specialStyleOptions = r10;
    }

    public /* synthetic */ ClarifyFunctionParams(String r8, List r9, List r10, String r11, Map r12, int r13, h r14) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Map r6 = null;
    L10:
        this(r8, r3, r4, r5, r6);
        return;
    L9:
        r6 = r15;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final String getContent() {
        return this.content;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final List<Boolean> getPositiveness() {
        return this.positiveness;
    }

    public final String getSecurityLevel() {
        return this.securityLevel;
    }

    public final Map<Integer, String> getSpecialStyleOptions() {
        return this.specialStyleOptions;
    }
}
