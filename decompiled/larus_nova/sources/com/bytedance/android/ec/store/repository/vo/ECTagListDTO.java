package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u00002\u0006\u0010C\u001a\u00020DJ\r\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010FR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R,\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0007R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0007R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R \u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R,\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0007R&\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010:\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006G"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "Ljava/io/Serializable;", "()V", "sliceData", "", "", "", "(Ljava/util/Map;)V", "clickAction", "Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "getClickAction", "()Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "setClickAction", "(Lcom/bytedance/android/ec/store/repository/vo/ClickAction;)V", "clickEventName", "getClickEventName", "()Ljava/lang/String;", "setClickEventName", "(Ljava/lang/String;)V", "clickEventParams", "", "getClickEventParams", "()Ljava/util/Map;", "setClickEventParams", "containerShowMax", "", "getContainerShowMax", "()I", "setContainerShowMax", "(I)V", "extraInfo", "getExtraInfo", "setExtraInfo", "hasReportShow", "", "getHasReportShow", "()Z", "setHasReportShow", "(Z)V", "overLengthStrategy", "getOverLengthStrategy", "setOverLengthStrategy", "scene", "getScene", "setScene", "showEventName", "getShowEventName", "setShowEventName", "showEventParams", "getShowEventParams", "setShowEventParams", "tagContainers", "", "Lcom/bytedance/android/ec/store/repository/vo/ECTagContainerDTO;", "getTagContainers", "()Ljava/util/List;", "setTagContainers", "(Ljava/util/List;)V", "tagListUI", "Lcom/bytedance/android/ec/store/repository/vo/TagListUI;", "getTagListUI", "()Lcom/bytedance/android/ec/store/repository/vo/TagListUI;", "setTagListUI", "(Lcom/bytedance/android/ec/store/repository/vo/TagListUI;)V", "setUpdateColor", "", "other", "factor", "", "singleFormWidth", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagListDTO implements Serializable {

    @SerializedName("click_action")
    private ClickAction clickAction;

    @SerializedName("click_event_name")
    private String clickEventName;

    @SerializedName("click_event_params")
    private Map<String, String> clickEventParams;

    @SerializedName("container_show_max")
    private int containerShowMax;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;
    private boolean hasReportShow;

    @SerializedName("over_length_strategy")
    private int overLengthStrategy;
    private String scene;

    @SerializedName("show_event_name")
    private String showEventName;

    @SerializedName("show_event_params")
    private Map<String, String> showEventParams;

    @SerializedName("tag_containers")
    private List<ECTagContainerDTO> tagContainers;

    @SerializedName("tag_list_ui")
    private TagListUI tagListUI;

    public final Integer singleFormWidth() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        String r102 = this.extraInfo.get("single_form_width");     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        Integer r103 = Integer.valueOf(CastIntegerProtector.parseInt(r102));     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L16;
        r100 = r104;
    L16:
        return (Integer) r100;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public ECTagListDTO() {
        this.tagListUI = new TagListUI();
        this.showEventParams = new LinkedHashMap();
        this.clickEventParams = new LinkedHashMap();
        this.containerShowMax = Integer.MAX_VALUE;
        this.extraInfo = MapsKt.emptyMap();
        this.clickAction = new ClickAction();
    }

    public final ClickAction getClickAction() {
        return this.clickAction;
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final Map<String, String> getClickEventParams() {
        return this.clickEventParams;
    }

    public final int getContainerShowMax() {
        return this.containerShowMax;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final boolean getHasReportShow() {
        return this.hasReportShow;
    }

    public final int getOverLengthStrategy() {
        return this.overLengthStrategy;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final Map<String, String> getShowEventParams() {
        return this.showEventParams;
    }

    public final List<ECTagContainerDTO> getTagContainers() {
        return this.tagContainers;
    }

    public final TagListUI getTagListUI() {
        return this.tagListUI;
    }

    public ECTagListDTO(Map<String, ? extends Object> r100) {
        this.tagListUI = new TagListUI();
        this.showEventParams = new LinkedHashMap();
        this.clickEventParams = new LinkedHashMap();
        int r101 = Integer.MAX_VALUE;
        this.containerShowMax = Integer.MAX_VALUE;
        this.extraInfo = MapsKt.emptyMap();
        this.clickAction = new ClickAction();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        Object r103 = r100.get("tag_containers");
        Object r104 = null;
        if ((r103 instanceof List) == true) goto L8;
        r103 = null;
    L8:
        List r105 = (List) r103;
        if (r105 == null) goto L14;
        Iterator r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r102.add(new ECTagContainerDTO((Map) r106.next()));
    L14:
        Unit r107 = Unit.INSTANCE;
        this.tagContainers = r102;
        Object r108 = r100.get("tag_list_ui");
        if ((r108 instanceof Map) == true) goto L17;
        r108 = null;
    L17:
        this.tagListUI = new TagListUI((Map) r108);
        Object r109 = r100.get("over_length_strategy");
        if ((r109 instanceof Number) == true) goto L20;
        r109 = null;
    L20:
        Number r110 = (Number) r109;
        if (r110 == null) goto L23;
        int r111 = r110.intValue();
    L24:
        this.overLengthStrategy = r111;
        Object r112 = r100.get("show_event_name");
        if ((r112 instanceof String) == true) goto L27;
        r112 = null;
    L27:
        String r113 = (String) r112;
        String r114 = "";
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        this.showEventName = r113;
        Object r115 = r100.get("click_event_name");
        if ((r115 instanceof String) == true) goto L33;
        r115 = null;
    L33:
        String r116 = (String) r115;
        if (r116 == null) goto L37;
        r114 = r116;
    L37:
        this.clickEventName = r114;
        Object r117 = r100.get("show_event_params");
        if (TypeIntrinsics.isMutableMap(r117) == true) goto L40;
        r117 = null;
    L40:
        this.showEventParams = (Map) r117;
        Object r118 = r100.get("click_event_params");
        if (TypeIntrinsics.isMutableMap(r118) == true) goto L43;
        r118 = null;
    L43:
        this.clickEventParams = (Map) r118;
        Object r119 = r100.get("container_show_max");
        if ((r119 instanceof Number) == true) goto L46;
        r119 = null;
    L46:
        Number r120 = (Number) r119;
        if (r120 == null) goto L49;
        r101 = r120.intValue();
    L49:
        this.containerShowMax = r101;
        Object r121 = r100.get("extra_info");
        if ((r121 instanceof Map) == true) goto L52;
        r121 = null;
    L52:
        Map<String, String> r122 = (Map) r121;
        if (r122 != null) goto L55;
        r122 = MapsKt.emptyMap();
    L55:
        this.extraInfo = r122;
        Object r123 = r100.get("click_action");
        if ((r123 instanceof Map) == false) goto L59;
        r104 = r123;
    L59:
        this.clickAction = new ClickAction((Map) r104);
        return;
    L23:
        r111 = 0;
        goto L24
    }

    public final void setClickAction(ClickAction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.clickAction = r100;
    }

    public final void setClickEventName(String r100) {
        this.clickEventName = r100;
    }

    public final void setClickEventParams(Map<String, String> r100) {
        this.clickEventParams = r100;
    }

    public final void setContainerShowMax(int r100) {
        this.containerShowMax = r100;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraInfo = r100;
    }

    public final void setHasReportShow(boolean r100) {
        this.hasReportShow = r100;
    }

    public final void setOverLengthStrategy(int r100) {
        this.overLengthStrategy = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setShowEventName(String r100) {
        this.showEventName = r100;
    }

    public final void setShowEventParams(Map<String, String> r100) {
        this.showEventParams = r100;
    }

    public final void setTagContainers(List<ECTagContainerDTO> r100) {
        this.tagContainers = r100;
    }

    public final void setTagListUI(TagListUI r100) {
        this.tagListUI = r100;
    }

    public final void setUpdateColor(ECTagListDTO r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TagListUI r102 = this.tagListUI;
        if (r102 == null) goto L7;
        r102.setUpdateColor(r100.tagListUI, r101);
    L7:
        List<ECTagContainerDTO> r103 = this.tagContainers;
        if (r103 == null) goto L10;
        int r104 = r103.size();
    L11:
        List<ECTagContainerDTO> r105 = r100.tagContainers;
        if (r105 == null) goto L14;
        int r106 = r105.size();
    L15:
        if (r104 == r106) goto L17;
        return;
    L17:
        List<ECTagContainerDTO> r107 = this.tagContainers;
        if (r107 == null) goto L20;
        int r108 = r107.size();
    L21:
        int r109 = 0;
    L22:
        if (r109 >= r108) goto L38;
        List<ECTagContainerDTO> r110 = r100.tagContainers;
        if (r110 == null) goto L26;
        int r111 = r110.size();
    L27:
        if (r109 >= r111) goto L44;
        List<ECTagContainerDTO> r112 = this.tagContainers;
        if (r112 == null) goto L37;
        ECTagContainerDTO r113 = (ECTagContainerDTO) CollectionsKt.getOrNull(r112, r109);
        if (r113 == null) goto L37;
        List<ECTagContainerDTO> r114 = r100.tagContainers;
        if (r114 == null) goto L35;
        ECTagContainerDTO r115 = (ECTagContainerDTO) CollectionsKt.getOrNull(r114, r109);
    L36:
        r113.setUpdateColor(r115, r101);
        goto L37
    L35:
        r115 = null;
    L37:
        r109 = r109 + 1;
        goto L22
    L44:
        return;
    L26:
        r111 = 0;
        goto L27
    L38:
        return;
    L20:
        r108 = 0;
        goto L21
    L14:
        r106 = 0;
        goto L15
    L10:
        r104 = 0;
        goto L11
    }
}
