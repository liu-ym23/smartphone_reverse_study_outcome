package com.bytedance.android.ec.host.api.core.api;

import com.facebook.imagepipeline.common.Priority;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/android/ec/host/api/core/api/ImagePreloadConfig;", "", "bizTag", "", "sceneTag", "needSaveConfig", "", "configCache", "Lorg/json/JSONObject;", "saveConfigPageTag", "configUrlTag", "monitorParams", "", "priority", "Lcom/facebook/imagepipeline/common/Priority;", "(Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/facebook/imagepipeline/common/Priority;)V", "getBizTag", "()Ljava/lang/String;", "getConfigCache", "()Lorg/json/JSONObject;", "getConfigUrlTag", "getMonitorParams", "()Ljava/util/Map;", "getNeedSaveConfig", "()Z", "getPriority", "()Lcom/facebook/imagepipeline/common/Priority;", "getSaveConfigPageTag", "getSceneTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImagePreloadConfig {
    private final String bizTag;
    private final JSONObject configCache;
    private final String configUrlTag;
    private final Map<String, Object> monitorParams;
    private final boolean needSaveConfig;
    private final Priority priority;
    private final String saveConfigPageTag;
    private final String sceneTag;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImagePreloadConfig copy$default(ImagePreloadConfig r100, String r110, String r111, boolean r112, JSONObject r113, String r114, String r115, Map r116, Priority r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.bizTag;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.sceneTag;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.needSaveConfig;
    L15:
        if ((r118 & 8) == 0) goto L17;
        JSONObject r104 = r100.configCache;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.saveConfigPageTag;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.configUrlTag;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Map r107 = r100.monitorParams;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Priority r108 = r100.priority;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.bizTag;
    }

    public final String component2() {
        return this.sceneTag;
    }

    public final boolean component3() {
        return this.needSaveConfig;
    }

    public final JSONObject component4() {
        return this.configCache;
    }

    public final String component5() {
        return this.saveConfigPageTag;
    }

    public final String component6() {
        return this.configUrlTag;
    }

    public final Map<String, Object> component7() {
        return this.monitorParams;
    }

    public final Priority component8() {
        return this.priority;
    }

    public final ImagePreloadConfig copy(String r110, String r111, boolean r112, JSONObject r113, String r114, String r115, Map<String, ? extends Object> r116, Priority r117) {
        Intrinsics.checkNotNullParameter(r110, "bizTag");
        Intrinsics.checkNotNullParameter(r111, "sceneTag");
        Intrinsics.checkNotNullParameter(r117, "priority");
        return new ImagePreloadConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImagePreloadConfig) == false) goto L22;
        ImagePreloadConfig r101 = (ImagePreloadConfig) r100;
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sceneTag, r101.sceneTag) == true) goto L10;
        return false;
    L10:
        if (this.needSaveConfig == r101.needSaveConfig) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.configCache, r101.configCache) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.saveConfigPageTag, r101.saveConfigPageTag) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.configUrlTag, r101.configUrlTag) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.monitorParams, r101.monitorParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        String r100 = this.bizTag;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.sceneTag;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.needSaveConfig;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.configCache;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.saveConfigPageTag;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.configUrlTag;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.monitorParams;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Priority r122 = this.priority;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ImagePreloadConfig(bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ", needSaveConfig=" + this.needSaveConfig + ", configCache=" + this.configCache + ", saveConfigPageTag=" + this.saveConfigPageTag + ", configUrlTag=" + this.configUrlTag + ", monitorParams=" + this.monitorParams + ", priority=" + this.priority + ")";
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final JSONObject getConfigCache() {
        return this.configCache;
    }

    public final String getConfigUrlTag() {
        return this.configUrlTag;
    }

    public final Map<String, Object> getMonitorParams() {
        return this.monitorParams;
    }

    public final boolean getNeedSaveConfig() {
        return this.needSaveConfig;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final String getSaveConfigPageTag() {
        return this.saveConfigPageTag;
    }

    public final String getSceneTag() {
        return this.sceneTag;
    }

    public ImagePreloadConfig(String r100, String r101, boolean r102, JSONObject r103, String r104, String r105, Map<String, ? extends Object> r106, Priority r107) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        Intrinsics.checkNotNullParameter(r107, "priority");
        this.bizTag = r100;
        this.sceneTag = r101;
        this.needSaveConfig = r102;
        this.configCache = r103;
        this.saveConfigPageTag = r104;
        this.configUrlTag = r105;
        this.monitorParams = r106;
        this.priority = r107;
    }

    public /* synthetic */ ImagePreloadConfig(String r110, String r111, boolean r112, JSONObject r113, String r114, String r115, Map r116, Priority r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r211 & 64) == 0) goto L17;
        Map r117 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        Priority r118 = Priority.MEDIUM;
    L22:
        this(r100, r101, r102, r113, r114, r115, r117, r118);
        return;
    L21:
        r118 = r210;
        goto L22
    L17:
        r117 = r116;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
