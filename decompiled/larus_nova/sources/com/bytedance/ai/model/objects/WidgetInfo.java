package com.bytedance.ai.model.objects;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bB\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u00107\u001a\u00020\t2\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0007H\u0016J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0016\"\u0004\b\u0019\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u001aR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b2\u0010\"\"\u0004\b3\u00104R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u001a¨\u0006K"}, d2 = {"Lcom/bytedance/ai/model/objects/WidgetInfo;", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "widgetId", "widgetData", "boxType", "", "border", "", "archiveText", "responseForModel", "mixtureCardId", "mcpName", "fullScreenRefresh", "appType", "entityId", "soloCard", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getWidgetData", "setWidgetData", "(Ljava/lang/String;)V", "getBoxType$annotations", "()V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBorder$annotations", "getBorder", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getArchiveText", "setArchiveText", "getResponseForModel", "setResponseForModel", "getMixtureCardId", "setMixtureCardId", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "getAppType", "setAppType", "getEntityId", "setEntityId", "getSoloCard", "setSoloCard", "(Ljava/lang/Boolean;)V", "getVersionTag", "setVersionTag", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/ai/model/objects/WidgetInfo;", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetInfo {

    @SerializedName("app_type")
    private String appType;

    @SerializedName("applet_id")
    private final String appletId;

    @SerializedName("archive_text")
    private String archiveText;

    @SerializedName("border")
    private final Boolean border;

    @SerializedName("box_type")
    private final Integer boxType;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private String entityId;

    @SerializedName("fullScreenRefresh")
    private String fullScreenRefresh;

    @SerializedName("mcpName")
    private String mcpName;

    @SerializedName("mixture_card_id")
    private String mixtureCardId;

    @SerializedName("response_for_model")
    private String responseForModel;

    @SerializedName("solo_card")
    private Boolean soloCard;

    @SerializedName("version_tag")
    private String versionTag;

    @SerializedName("widget_data")
    private String widgetData;

    @SerializedName("widget_id")
    private final String widgetId;

    public WidgetInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static /* synthetic */ WidgetInfo copy$default(WidgetInfo r110, String r111, String r112, String r113, Integer r114, Boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Boolean r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.appletId;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.widgetId;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.widgetData;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r103 = r110.boxType;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Boolean r104 = r110.border;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.archiveText;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.responseForModel;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r107 = r110.mixtureCardId;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r115 = r110.mcpName;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.fullScreenRefresh;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.appType;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r118 = r110.entityId;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r119 = r110.soloCard;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.versionTag;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "will be removed, use Widget.border instead")
    public static /* synthetic */ void getBorder$annotations() {
    }

    @Deprecated(message = "will be removed, use Widget.boxType instead")
    public static /* synthetic */ void getBoxType$annotations() {
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component10() {
        return this.fullScreenRefresh;
    }

    public final String component11() {
        return this.appType;
    }

    public final String component12() {
        return this.entityId;
    }

    public final Boolean component13() {
        return this.soloCard;
    }

    public final String component14() {
        return this.versionTag;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.widgetData;
    }

    public final Integer component4() {
        return this.boxType;
    }

    public final Boolean component5() {
        return this.border;
    }

    public final String component6() {
        return this.archiveText;
    }

    public final String component7() {
        return this.responseForModel;
    }

    public final String component8() {
        return this.mixtureCardId;
    }

    public final String component9() {
        return this.mcpName;
    }

    public final WidgetInfo copy(String r110, String r111, String r112, Integer r210, Boolean r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Boolean r219, String r310) {
        return new WidgetInfo(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public String toString() {
        return "WidgetInfo(appletId=" + this.appletId + ", widgetId=" + this.widgetId + ", widgetData=" + this.widgetData + ", boxType=" + this.boxType + ", border=" + this.border + ", archiveText=" + this.archiveText + ", responseForModel=" + this.responseForModel + ", mixtureCardId=" + this.mixtureCardId + ", mcpName=" + this.mcpName + ", fullScreenRefresh=" + this.fullScreenRefresh + ", appType=" + this.appType + ", entityId=" + this.entityId + ", soloCard=" + this.soloCard + ", versionTag=" + this.versionTag + ')';
    }

    public int hashCode() {
        String r100 = this.appletId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.widgetId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.widgetData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.boxType;
        if (r110 == null) goto L17;
        int r111 = r110.intValue();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.border;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public final String getAppType() {
        return this.appType;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final String getArchiveText() {
        return this.archiveText;
    }

    public final Boolean getBorder() {
        return this.border;
    }

    public final Integer getBoxType() {
        return this.boxType;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getFullScreenRefresh() {
        return this.fullScreenRefresh;
    }

    public final String getMcpName() {
        return this.mcpName;
    }

    public final String getMixtureCardId() {
        return this.mixtureCardId;
    }

    public final String getResponseForModel() {
        return this.responseForModel;
    }

    public final Boolean getSoloCard() {
        return this.soloCard;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final String getWidgetData() {
        return this.widgetData;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof WidgetInfo) == false) goto L16;
        WidgetInfo r101 = (WidgetInfo) r100;
        if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.widgetData, r101.widgetData) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.boxType, r101.boxType) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.border, r101.border) == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        return false;
    }

    public final void setAppType(String r100) {
        this.appType = r100;
    }

    public final void setArchiveText(String r100) {
        this.archiveText = r100;
    }

    public final void setEntityId(String r100) {
        this.entityId = r100;
    }

    public final void setFullScreenRefresh(String r100) {
        this.fullScreenRefresh = r100;
    }

    public final void setMcpName(String r100) {
        this.mcpName = r100;
    }

    public final void setMixtureCardId(String r100) {
        this.mixtureCardId = r100;
    }

    public final void setResponseForModel(String r100) {
        this.responseForModel = r100;
    }

    public final void setSoloCard(Boolean r100) {
        this.soloCard = r100;
    }

    public final void setVersionTag(String r100) {
        this.versionTag = r100;
    }

    public final void setWidgetData(String r100) {
        this.widgetData = r100;
    }

    public WidgetInfo(String r100, String r101, String r102, Integer r103, Boolean r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, Boolean r113, String r114) {
        this.appletId = r100;
        this.widgetId = r101;
        this.widgetData = r102;
        this.boxType = r103;
        this.border = r104;
        this.archiveText = r105;
        this.responseForModel = r106;
        this.mixtureCardId = r107;
        this.mcpName = r108;
        this.fullScreenRefresh = r110;
        this.appType = r111;
        this.entityId = r112;
        this.soloCard = r113;
        this.versionTag = r114;
    }

    public /* synthetic */ WidgetInfo(String r110, String r111, String r112, Integer r113, Boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, Boolean r218, String r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        String r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        String r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r118 = Boolean.FALSE;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
}
