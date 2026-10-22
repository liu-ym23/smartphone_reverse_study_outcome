package com.bytedance.android.shopping.api.mall.common.dialog;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jt\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/dialog/NativeDialogConfig;", "", "enablePageName", "", "", "disableComponent", "disablePlanId", "", "needAdaptiveParentType", "", "defaultTaskConfig", "defaultPopupConfig", "appendSchemaParams", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppendSchemaParams", "()Ljava/lang/String;", "getDefaultPopupConfig", "getDefaultTaskConfig", "getDisableComponent", "()Ljava/util/List;", "getDisablePlanId", "getEnablePageName", "getNeedAdaptiveParentType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/dialog/NativeDialogConfig;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativeDialogConfig {

    @SerializedName("append_schema_params")
    private final String appendSchemaParams;

    @SerializedName("default_popup_config")
    private final String defaultPopupConfig;

    @SerializedName("default_task_config")
    private final String defaultTaskConfig;

    @SerializedName("disable_component")
    private final List<String> disableComponent;

    @SerializedName("disable_plan_id")
    private final List<Integer> disablePlanId;

    @SerializedName("enable_page_name")
    private final List<String> enablePageName;

    @SerializedName("need_adaptive_parent_type")
    private final Boolean needAdaptiveParentType;

    public NativeDialogConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeDialogConfig copy$default(NativeDialogConfig r100, List r101, List r102, List r103, Boolean r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.enablePageName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.disableComponent;
    L8:
        List r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.disablePlanId;
    L11:
        List r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.needAdaptiveParentType;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.defaultTaskConfig;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.defaultPopupConfig;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.appendSchemaParams;
    L23:
        List r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final List<String> component1() {
        return this.enablePageName;
    }

    public final List<String> component2() {
        return this.disableComponent;
    }

    public final List<Integer> component3() {
        return this.disablePlanId;
    }

    public final Boolean component4() {
        return this.needAdaptiveParentType;
    }

    public final String component5() {
        return this.defaultTaskConfig;
    }

    public final String component6() {
        return this.defaultPopupConfig;
    }

    public final String component7() {
        return this.appendSchemaParams;
    }

    public final NativeDialogConfig copy(List<String> r110, List<String> r111, List<Integer> r112, Boolean r113, String r114, String r115, String r116) {
        return new NativeDialogConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NativeDialogConfig) == false) goto L20;
        NativeDialogConfig r101 = (NativeDialogConfig) r100;
        if (Intrinsics.areEqual(this.enablePageName, r101.enablePageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.disableComponent, r101.disableComponent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.disablePlanId, r101.disablePlanId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needAdaptiveParentType, r101.needAdaptiveParentType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.defaultTaskConfig, r101.defaultTaskConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultPopupConfig, r101.defaultPopupConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appendSchemaParams, r101.appendSchemaParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.enablePageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.disableComponent;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.disablePlanId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.needAdaptiveParentType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.defaultTaskConfig;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.defaultPopupConfig;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.appendSchemaParams;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "NativeDialogConfig(enablePageName=" + this.enablePageName + ", disableComponent=" + this.disableComponent + ", disablePlanId=" + this.disablePlanId + ", needAdaptiveParentType=" + this.needAdaptiveParentType + ", defaultTaskConfig=" + this.defaultTaskConfig + ", defaultPopupConfig=" + this.defaultPopupConfig + ", appendSchemaParams=" + this.appendSchemaParams + ")";
    }

    public final String getAppendSchemaParams() {
        return this.appendSchemaParams;
    }

    public final String getDefaultPopupConfig() {
        return this.defaultPopupConfig;
    }

    public final String getDefaultTaskConfig() {
        return this.defaultTaskConfig;
    }

    public final List<String> getDisableComponent() {
        return this.disableComponent;
    }

    public final List<Integer> getDisablePlanId() {
        return this.disablePlanId;
    }

    public final List<String> getEnablePageName() {
        return this.enablePageName;
    }

    public final Boolean getNeedAdaptiveParentType() {
        return this.needAdaptiveParentType;
    }

    public NativeDialogConfig(List<String> r100, List<String> r101, List<Integer> r102, Boolean r103, String r104, String r105, String r106) {
        this.enablePageName = r100;
        this.disableComponent = r101;
        this.disablePlanId = r102;
        this.needAdaptiveParentType = r103;
        this.defaultTaskConfig = r104;
        this.defaultPopupConfig = r105;
        this.appendSchemaParams = r106;
    }

    public /* synthetic */ NativeDialogConfig(List r100, List r101, List r102, Boolean r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        List r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
