package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u00002\u0006\u00108\u001a\u000209J\r\u0010:\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010;R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000eR&\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006<"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagListDTO;", "Ljava/io/Serializable;", "()V", "clickAction", "Lcom/bytedance/android/ec/window/base/repository/vo/ClickAction;", "getClickAction", "()Lcom/bytedance/android/ec/window/base/repository/vo/ClickAction;", "clickEventName", "", "getClickEventName", "()Ljava/lang/String;", "clickEventParams", "", "getClickEventParams", "()Ljava/util/Map;", "containerShowMax", "", "getContainerShowMax", "()I", "extraInfo", "", "getExtraInfo", "hasReportShow", "", "getHasReportShow", "()Z", "setHasReportShow", "(Z)V", "overLengthStrategy", "getOverLengthStrategy", "setOverLengthStrategy", "(I)V", "scene", "getScene", "setScene", "(Ljava/lang/String;)V", "showEventName", "getShowEventName", "showEventParams", "getShowEventParams", "tagContainers", "", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagContainerDTO;", "getTagContainers", "()Ljava/util/List;", "setTagContainers", "(Ljava/util/List;)V", "tagListUI", "Lcom/bytedance/android/ec/window/base/repository/vo/TagListUI;", "getTagListUI", "()Lcom/bytedance/android/ec/window/base/repository/vo/TagListUI;", "setTagListUI", "(Lcom/bytedance/android/ec/window/base/repository/vo/TagListUI;)V", "setUpdateColor", "", "other", "factor", "", "singleFormWidth", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTagListDTO implements Serializable {

    @SerializedName("click_action")
    private final ClickAction clickAction;

    @SerializedName("click_event_name")
    private final String clickEventName;

    @SerializedName("click_event_params")
    private final Map<String, String> clickEventParams;

    @SerializedName("container_show_max")
    private final int containerShowMax;

    @SerializedName("extra_info")
    private final Map<String, String> extraInfo;
    private boolean hasReportShow;

    @SerializedName("over_length_strategy")
    private int overLengthStrategy;
    private String scene;

    @SerializedName("show_event_name")
    private final String showEventName;

    @SerializedName("show_event_params")
    private final Map<String, String> showEventParams;

    @SerializedName("tag_containers")
    private List<ECWindowTagContainerDTO> tagContainers;

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

    public ECWindowTagListDTO() {
        this.tagContainers = CollectionsKt.emptyList();
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

    public final List<ECWindowTagContainerDTO> getTagContainers() {
        return this.tagContainers;
    }

    public final TagListUI getTagListUI() {
        return this.tagListUI;
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

    public final void setTagContainers(List<ECWindowTagContainerDTO> r100) {
        this.tagContainers = r100;
    }

    public final void setTagListUI(TagListUI r100) {
        this.tagListUI = r100;
    }

    public final void setUpdateColor(ECWindowTagListDTO r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TagListUI r102 = this.tagListUI;
        if (r102 == null) goto L7;
        r102.setUpdateColor(r100.tagListUI, r101);
    L7:
        List<ECWindowTagContainerDTO> r103 = this.tagContainers;
        if (r103 == null) goto L10;
        int r104 = r103.size();
    L11:
        List<ECWindowTagContainerDTO> r105 = r100.tagContainers;
        if (r105 == null) goto L14;
        int r106 = r105.size();
    L15:
        if (r104 == r106) goto L17;
        return;
    L17:
        List<ECWindowTagContainerDTO> r107 = this.tagContainers;
        if (r107 == null) goto L20;
        int r108 = r107.size();
    L21:
        int r109 = 0;
    L22:
        if (r109 >= r108) goto L38;
        List<ECWindowTagContainerDTO> r110 = r100.tagContainers;
        if (r110 == null) goto L26;
        int r111 = r110.size();
    L27:
        if (r109 >= r111) goto L44;
        List<ECWindowTagContainerDTO> r112 = this.tagContainers;
        if (r112 == null) goto L37;
        ECWindowTagContainerDTO r113 = (ECWindowTagContainerDTO) CollectionsKt.getOrNull(r112, r109);
        if (r113 == null) goto L37;
        List<ECWindowTagContainerDTO> r114 = r100.tagContainers;
        if (r114 == null) goto L35;
        ECWindowTagContainerDTO r115 = (ECWindowTagContainerDTO) CollectionsKt.getOrNull(r114, r109);
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
