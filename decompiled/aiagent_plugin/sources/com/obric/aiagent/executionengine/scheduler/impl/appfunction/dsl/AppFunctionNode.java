package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionNode {
    private final List<String> authorizedSignatures;
    private final String converterClassName;
    private final Map<String, String> extras;
    private final String functionId;
    private final String id;
    private final String packageName;
    private final Map<String, AppFunctionValueMapping> params;
    private final String schemaCategory;
    private final String schemaName;
    private final String type;

    public static /* synthetic */ AppFunctionNode copy$default(AppFunctionNode r13, String r14, String r15, String r16, String r17, String r18, String r19, List r20, String r21, Map r22, Map r23, int r24, Object r25) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionValueMapping> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        if ((r24 & 1) == 0) goto L5;
        String r5 = r13.id;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r6 = r13.type;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r7 = r13.schemaCategory;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r8 = r13.schemaName;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r9 = r13.packageName;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r10 = r13.functionId;
    L27:
        if ((r24 & 64) == 0) goto L30;
        r2 = r13.authorizedSignatures;
    L30:
        if ((r24 & 128) == 0) goto L32;
        String r11 = r13.converterClassName;
    L34:
        if ((r24 & 256) == 0) goto L37;
        r4 = r13.params;
    L37:
        if ((r24 & 512) == 0) goto L40;
        r3 = r13.extras;
    L40:
        return r13.copy(r5, r6, r7, r8, r9, r10, r2, r11, r4, r3);
    L32:
        r11 = r21;
        goto L34
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final Map<String, String> component10() {
        return this.extras;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.schemaCategory;
    }

    public final String component4() {
        return this.schemaName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.functionId;
    }

    public final List<String> component7() {
        return this.authorizedSignatures;
    }

    public final String component8() {
        return this.converterClassName;
    }

    public final Map<String, AppFunctionValueMapping> component9() {
        return this.params;
    }

    public final AppFunctionNode copy(String r14, String r15, String r16, String r17, String r18, String r19, List<String> r20, String r21, Map<String, AppFunctionValueMapping> r22, Map<String, String> r23) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        o.e(r14, DbHelper.COL_ID);
        o.e(r15, "type");
        return new AppFunctionNode(r14, r15, r16, r17, r18, r19, r9, r21, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionNode.class) == true) goto L8;
        return false;
    L8:
        AppFunctionNode r6 = (AppFunctionNode) ZeusTransformUtils.preCheckCast(r5, AppFunctionNode.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.schemaCategory, r6.schemaCategory) == true) goto L18;
        return false;
    L18:
        if (o.a(this.schemaName, r6.schemaName) == true) goto L21;
        return false;
    L21:
        if (o.a(this.packageName, r6.packageName) == true) goto L24;
        return false;
    L24:
        if (o.a(this.functionId, r6.functionId) == true) goto L27;
        return false;
    L27:
        if (o.a(this.authorizedSignatures, r6.authorizedSignatures) == true) goto L30;
        return false;
    L30:
        if (o.a(this.converterClassName, r6.converterClassName) == true) goto L33;
        return false;
    L33:
        if (o.a(this.params, r6.params) == true) goto L36;
        return false;
    L36:
        if (o.a(this.extras, r6.extras) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String r1 = this.schemaCategory;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.schemaName;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.packageName;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.functionId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<String> r14 = this.authorizedSignatures;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.converterClassName;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Map<String, AppFunctionValueMapping> r20 = this.params;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Map<String, String> r23 = this.extras;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFunctionNode(id=" + this.id + ", type=" + this.type + ", schemaCategory=" + this.schemaCategory + ", schemaName=" + this.schemaName + ", packageName=" + this.packageName + ", functionId=" + this.functionId + ", authorizedSignatures=" + this.authorizedSignatures + ", converterClassName=" + this.converterClassName + ", params=" + this.params + ", extras=" + this.extras + ')';
    }

    public AppFunctionNode(String r3, String r4, String r5, String r6, String r7, String r8, List<String> r9, String r10, Map<String, AppFunctionValueMapping> r11, Map<String, String> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionValueMapping> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r4, "type");
        this.id = r3;
        this.type = r4;
        this.schemaCategory = r5;
        this.schemaName = r6;
        this.packageName = r7;
        this.functionId = r8;
        this.authorizedSignatures = r13;
        this.converterClassName = r10;
        this.params = r14;
        this.extras = r15;
    }

    public /* synthetic */ AppFunctionNode(String r18, String r19, String r20, String r21, String r22, String r23, List r24, String r25, Map r26, Map r27, int r28, h r29) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.aiagent.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r27, Map.class, "com.obric.aiagent.plugin");
        if ((r28 & 4) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r28 & 8) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r28 & 16) == 0) goto L13;
        String r11 = null;
    L15:
        if ((r28 & 32) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r28 & 64) == 0) goto L21;
        List r13 = null;
    L23:
        if ((r28 & 128) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r28 & 256) == 0) goto L29;
        Map r15 = null;
    L31:
        if ((r28 & 512) == 0) goto L33;
        Map r16 = null;
    L34:
        this(r18, r19, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
    L33:
        r16 = r2;
        goto L34
    L29:
        r15 = r3;
        goto L31
    L25:
        r14 = r25;
        goto L27
    L21:
        r13 = r1;
        goto L23
    L17:
        r12 = r23;
        goto L19
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getFunctionId() {
        return this.functionId;
    }

    public final List<String> getAuthorizedSignatures() {
        return this.authorizedSignatures;
    }

    public final String getConverterClassName() {
        return this.converterClassName;
    }

    public final Map<String, AppFunctionValueMapping> getParams() {
        return this.params;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }
}
