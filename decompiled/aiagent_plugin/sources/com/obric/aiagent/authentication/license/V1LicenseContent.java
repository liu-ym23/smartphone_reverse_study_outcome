package com.obric.aiagent.authentication.license;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: V1LicenseContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class V1LicenseContent {

    @SerializedName("actions")
    private final Map<String, List<String>> actions;

    @SerializedName("execute_policies")
    private final Map<String, LicenseExecutePolicy> executePolicies;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("signatures")
    private final Map<String, Map<String, String>> signatures;

    public static /* synthetic */ V1LicenseContent copy$default(V1LicenseContent r1, Map r2, String r3, Map r4, Map r5, int r6, Object r7) {
        Map<String, List<String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, LicenseExecutePolicy> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.actions;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.packageName;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.signatures;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r10 = r1.executePolicies;
    L15:
        return r1.copy(r8, r3, r9, r10);
    }

    public final Map<String, List<String>> component1() {
        return this.actions;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Map<String, Map<String, String>> component3() {
        return this.signatures;
    }

    public final Map<String, LicenseExecutePolicy> component4() {
        return this.executePolicies;
    }

    public final V1LicenseContent copy(Map<String, ? extends List<String>> r2, String r3, Map<String, ? extends Map<String, String>> r4, Map<String, LicenseExecutePolicy> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "actions");
        o.e(r3, "packageName");
        o.e(r6, "signatures");
        return new V1LicenseContent(r1, r3, r6, r7);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, V1LicenseContent.class) == true) goto L8;
        return false;
    L8:
        V1LicenseContent r6 = (V1LicenseContent) ZeusTransformUtils.preCheckCast(r5, V1LicenseContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.actions, r6.actions) == true) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.signatures, r6.signatures) == true) goto L18;
        return false;
    L18:
        if (o.a(this.executePolicies, r6.executePolicies) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.actions.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.signatures.hashCode()) * 31;
        Map<String, LicenseExecutePolicy> r2 = this.executePolicies;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "V1LicenseContent(actions=" + this.actions + ", packageName=" + this.packageName + ", signatures=" + this.signatures + ", executePolicies=" + this.executePolicies + ')';
    }

    public V1LicenseContent(Map<String, ? extends List<String>> r3, String r4, Map<String, ? extends Map<String, String>> r5, Map<String, LicenseExecutePolicy> r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<String, LicenseExecutePolicy> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r7, "actions");
        o.e(r4, "packageName");
        o.e(r8, "signatures");
        this.actions = r7;
        this.packageName = r4;
        this.signatures = r8;
        this.executePolicies = r9;
    }

    public /* synthetic */ V1LicenseContent(Map r2, String r3, Map r4, Map r5, int r6, h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r8, r3, r9, r10);
    }

    public final Map<String, List<String>> getActions() {
        return this.actions;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Map<String, Map<String, String>> getSignatures() {
        return this.signatures;
    }

    public final Map<String, LicenseExecutePolicy> getExecutePolicies() {
        return this.executePolicies;
    }
}
