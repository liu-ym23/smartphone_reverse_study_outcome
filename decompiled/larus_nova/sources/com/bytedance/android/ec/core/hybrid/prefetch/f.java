package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/f;", "", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", SlashMentionConfig.SLASH_CONTENT_PROJECT, "getProject", "Lorg/json/JSONObject;", "rules", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "prefetchApis", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("prefetch_apis")
    private final JSONObject prefetchApis;

    @SerializedName(SlashMentionConfig.SLASH_CONTENT_PROJECT)
    private final String project;

    @SerializedName("rules")
    private final JSONObject rules;

    @SerializedName("version")
    private final String version;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.project, r101.project) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rules, r101.rules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefetchApis, r101.prefetchApis) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.version;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.project;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.rules;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.prefetchApis;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePreFetchConfig(version=" + this.version + ", project=" + this.project + ", rules=" + this.rules + ", prefetchApis=" + this.prefetchApis + ")";
    }

    public final JSONObject a() {
        return this.prefetchApis;
    }

    public final JSONObject b() {
        return this.rules;
    }

    public f(String r100, String r101, JSONObject r102, JSONObject r103) {
        this.version = r100;
        this.project = r101;
        this.rules = r102;
        this.prefetchApis = r103;
    }
}
