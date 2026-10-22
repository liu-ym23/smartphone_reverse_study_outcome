package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionValueMapping {
    private final List<AppFunctionValueMapping> args;
    private final AppFunctionValueMapping cond;
    private final JsonElement defaultValue;
    private final Map<String, AppFunctionValueMapping> fields;
    private final String op;
    private final String ref;
    private final String targetType;
    private final String template;
    private final JsonElement value;
    private final AppFunctionValueMapping whenFalse;
    private final AppFunctionValueMapping whenTrue;

    public AppFunctionValueMapping() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ AppFunctionValueMapping copy$default(AppFunctionValueMapping r12, JsonElement r13, String r14, JsonElement r15, String r16, List r17, String r18, String r19, Map r20, AppFunctionValueMapping r21, AppFunctionValueMapping r22, AppFunctionValueMapping r23, int r24, Object r25) {
        List<AppFunctionValueMapping> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionValueMapping> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 1) == 0) goto L5;
        JsonElement r4 = r12.value;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = r12.ref;
    L11:
        if ((r24 & 4) == 0) goto L13;
        JsonElement r6 = r12.defaultValue;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = r12.op;
    L19:
        if ((r24 & 16) == 0) goto L22;
        r2 = r12.args;
    L22:
        if ((r24 & 32) == 0) goto L24;
        String r8 = r12.template;
    L26:
        if ((r24 & 64) == 0) goto L28;
        String r9 = r12.targetType;
    L30:
        if ((r24 & 128) == 0) goto L33;
        r3 = r12.fields;
    L33:
        if ((r24 & 256) == 0) goto L35;
        AppFunctionValueMapping r10 = r12.cond;
    L37:
        if ((r24 & 512) == 0) goto L39;
        AppFunctionValueMapping r11 = r12.whenTrue;
    L41:
        if ((r24 & 1024) == 0) goto L43;
        AppFunctionValueMapping r1 = r12.whenFalse;
    L45:
        return r12.copy(r4, r5, r6, r7, r2, r8, r9, r3, r10, r11, r1);
    L43:
        r1 = r23;
        goto L45
    L39:
        r11 = r22;
        goto L41
    L35:
        r10 = r21;
        goto L37
    L28:
        r9 = r19;
        goto L30
    L24:
        r8 = r18;
        goto L26
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public final JsonElement component1() {
        return this.value;
    }

    public final AppFunctionValueMapping component10() {
        return this.whenTrue;
    }

    public final AppFunctionValueMapping component11() {
        return this.whenFalse;
    }

    public final String component2() {
        return this.ref;
    }

    public final JsonElement component3() {
        return this.defaultValue;
    }

    public final String component4() {
        return this.op;
    }

    public final List<AppFunctionValueMapping> component5() {
        return this.args;
    }

    public final String component6() {
        return this.template;
    }

    public final String component7() {
        return this.targetType;
    }

    public final Map<String, AppFunctionValueMapping> component8() {
        return this.fields;
    }

    public final AppFunctionValueMapping component9() {
        return this.cond;
    }

    public final AppFunctionValueMapping copy(JsonElement r15, String r16, JsonElement r17, String r18, List<AppFunctionValueMapping> r19, String r20, String r21, Map<String, AppFunctionValueMapping> r22, AppFunctionValueMapping r23, AppFunctionValueMapping r24, AppFunctionValueMapping r25) {
        return new AppFunctionValueMapping(r15, r16, r17, r18, (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin"), r20, r21, (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin"), r23, r24, r25);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionValueMapping.class) == true) goto L8;
        return false;
    L8:
        AppFunctionValueMapping r6 = (AppFunctionValueMapping) ZeusTransformUtils.preCheckCast(r5, AppFunctionValueMapping.class, "com.obric.aiagent.plugin");
        if (o.a(this.value, r6.value) == true) goto L12;
        return false;
    L12:
        if (o.a(this.ref, r6.ref) == true) goto L15;
        return false;
    L15:
        if (o.a(this.defaultValue, r6.defaultValue) == true) goto L18;
        return false;
    L18:
        if (o.a(this.op, r6.op) == true) goto L21;
        return false;
    L21:
        if (o.a(this.args, r6.args) == true) goto L24;
        return false;
    L24:
        if (o.a(this.template, r6.template) == true) goto L27;
        return false;
    L27:
        if (o.a(this.targetType, r6.targetType) == true) goto L30;
        return false;
    L30:
        if (o.a(this.fields, r6.fields) == true) goto L33;
        return false;
    L33:
        if (o.a(this.cond, r6.cond) == true) goto L36;
        return false;
    L36:
        if (o.a(this.whenTrue, r6.whenTrue) == true) goto L39;
        return false;
    L39:
        if (o.a(this.whenFalse, r6.whenFalse) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        JsonElement r0 = this.value;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.ref;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonElement r7 = this.defaultValue;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.op;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<AppFunctionValueMapping> r13 = this.args;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.template;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.targetType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, AppFunctionValueMapping> r22 = this.fields;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        AppFunctionValueMapping r25 = this.cond;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        AppFunctionValueMapping r28 = this.whenTrue;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        AppFunctionValueMapping r31 = this.whenFalse;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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
        StringBuilder r0 = new StringBuilder();
        r0.append("AppFunctionValueMapping(value=").append(this.value).append(", ref=").append(this.ref).append(", defaultValue=").append(this.defaultValue).append(", op=").append(this.op).append(", args=").append(this.args).append(", template=").append(this.template).append(", targetType=").append(this.targetType).append(", fields=").append(this.fields).append(", cond=").append(this.cond).append(", whenTrue=").append(this.whenTrue).append(", whenFalse=").append(this.whenFalse).append(')');
        return r0.toString();
    }

    public AppFunctionValueMapping(JsonElement r3, String r4, JsonElement r5, String r6, List<AppFunctionValueMapping> r7, String r8, String r9, Map<String, AppFunctionValueMapping> r10, AppFunctionValueMapping r11, AppFunctionValueMapping r12, AppFunctionValueMapping r13) {
        List<AppFunctionValueMapping> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionValueMapping> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        this.value = r3;
        this.ref = r4;
        this.defaultValue = r5;
        this.op = r6;
        this.args = r14;
        this.template = r8;
        this.targetType = r9;
        this.fields = r15;
        this.cond = r11;
        this.whenTrue = r12;
        this.whenFalse = r13;
    }

    public /* synthetic */ AppFunctionValueMapping(JsonElement r13, String r14, JsonElement r15, String r16, List r17, String r18, String r19, Map r20, AppFunctionValueMapping r21, AppFunctionValueMapping r22, AppFunctionValueMapping r23, int r24, h r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        AppFunctionValueMapping r4 = null;
        if ((r24 & 1) == 0) goto L5;
        JsonElement r3 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        JsonElement r6 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r24 & 16) == 0) goto L22;
        r1 = null;
    L22:
        if ((r24 & 32) == 0) goto L24;
        String r8 = null;
    L26:
        if ((r24 & 64) == 0) goto L28;
        String r9 = null;
    L30:
        if ((r24 & 128) == 0) goto L33;
        r2 = null;
    L33:
        if ((r24 & 256) == 0) goto L35;
        AppFunctionValueMapping r10 = null;
    L37:
        if ((r24 & 512) == 0) goto L39;
        AppFunctionValueMapping r11 = null;
    L41:
        if ((r24 & 1024) != 0) goto L44;
        r4 = r23;
    L44:
        this(r3, r5, r6, r7, r1, r8, r9, r2, r10, r11, r4);
        return;
    L39:
        r11 = r22;
        goto L41
    L35:
        r10 = r21;
        goto L37
    L28:
        r9 = r19;
        goto L30
    L24:
        r8 = r18;
        goto L26
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final JsonElement getValue() {
        return this.value;
    }

    public final String getRef() {
        return this.ref;
    }

    public final JsonElement getDefaultValue() {
        return this.defaultValue;
    }

    public final String getOp() {
        return this.op;
    }

    public final List<AppFunctionValueMapping> getArgs() {
        return this.args;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final Map<String, AppFunctionValueMapping> getFields() {
        return this.fields;
    }

    public final AppFunctionValueMapping getCond() {
        return this.cond;
    }

    public final AppFunctionValueMapping getWhenTrue() {
        return this.whenTrue;
    }

    public final AppFunctionValueMapping getWhenFalse() {
        return this.whenFalse;
    }
}
