package com.obric.aiagent.executionengine.capabilitymanager.matcher.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Impl {
    private final String implClassName;
    private final String logPb;
    private final String name;
    private final Map<String, String> params;
    private final String pkgName;
    private final String type;
    private final String uri;

    public static /* synthetic */ Impl copy$default(Impl r8, String r9, String r10, String r11, String r12, String r13, Map r14, String r15, int r16, Object r17) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        if ((r16 & 1) == 0) goto L5;
        String r2 = r8.name;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.type;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r4 = r8.pkgName;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r5 = r8.implClassName;
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r6 = r8.uri;
    L23:
        if ((r16 & 32) == 0) goto L26;
        r1 = r8.params;
    L26:
        if ((r16 & 64) == 0) goto L28;
        String r7 = r8.logPb;
    L30:
        return r8.copy(r2, r3, r4, r5, r6, r1, r7);
    L28:
        r7 = r15;
        goto L30
    L21:
        r6 = r13;
        goto L23
    L17:
        r5 = r12;
        goto L19
    L13:
        r4 = r11;
        goto L15
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.pkgName;
    }

    public final String component4() {
        return this.implClassName;
    }

    public final String component5() {
        return this.uri;
    }

    public final Map<String, String> component6() {
        return this.params;
    }

    public final String component7() {
        return this.logPb;
    }

    public final Impl copy(String r9, String r10, String r11, String r12, String r13, Map<String, String> r14, String r15) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        o.e(r9, "name");
        o.e(r10, "type");
        o.e(r11, "pkgName");
        return new Impl(r9, r10, r11, r12, r13, r6, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Impl.class) == true) goto L8;
        return false;
    L8:
        Impl r6 = (Impl) ZeusTransformUtils.preCheckCast(r5, Impl.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.pkgName, r6.pkgName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.implClassName, r6.implClassName) == true) goto L21;
        return false;
    L21:
        if (o.a(this.uri, r6.uri) == true) goto L24;
        return false;
    L24:
        if (o.a(this.params, r6.params) == true) goto L27;
        return false;
    L27:
        if (o.a(this.logPb, r6.logPb) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.pkgName.hashCode()) * 31;
        String r1 = this.implClassName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.uri;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.params;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.logPb;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "Impl(name=" + this.name + ", type=" + this.type + ", pkgName=" + this.pkgName + ", implClassName=" + this.implClassName + ", uri=" + this.uri + ", params=" + this.params + ", logPb=" + this.logPb + ')';
    }

    public Impl(String r3, String r4, String r5, String r6, String r7, Map<String, String> r8, String r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "name");
        o.e(r4, "type");
        o.e(r5, "pkgName");
        this.name = r3;
        this.type = r4;
        this.pkgName = r5;
        this.implClassName = r6;
        this.uri = r7;
        this.params = r10;
        this.logPb = r9;
    }

    public /* synthetic */ Impl(String r12, String r13, String r14, String r15, String r16, Map r17, String r18, int r19, h r20) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        if ((r19 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r19 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r19 & 32) == 0) goto L13;
        Map r9 = null;
    L15:
        if ((r19 & 64) == 0) goto L17;
        String r10 = null;
    L18:
        this(r12, r13, r14, r7, r8, r9, r10);
        return;
    L17:
        r10 = r18;
        goto L18
    L13:
        r9 = r0;
        goto L15
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getLogPb() {
        return this.logPb;
    }
}
