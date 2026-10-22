package com.bytedance.android.ec.window.base.repository.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;J\u0018\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R\u001c\u0010+\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R0\u00102\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010/\u001a\u0004\b3\u00101\"\u0004\b4\u00105R.\u00107\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010/\u001a\u0004\b8\u00101\"\u0004\b9\u00105¨\u0006<"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagContainerDTO;", "Ljava/io/Serializable;", "other", "", "factor", "", "setUpdateColor", "", "type", "I", "getType", "()I", "", "tagType", "Ljava/lang/String;", "getTagType", "()Ljava/lang/String;", "setTagType", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/ec/window/base/repository/vo/f;", "subTagList", "Ljava/util/List;", "getSubTagList", "()Ljava/util/List;", "setSubTagList", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;", "tagContainerUI", "Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;", "getTagContainerUI", "()Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;", "setTagContainerUI", "(Lcom/bytedance/android/ec/window/base/repository/vo/TagContainerUI;)V", "priority", "getPriority", "Lcom/bytedance/android/ec/window/base/repository/vo/ClickAction;", "clickAction", "Lcom/bytedance/android/ec/window/base/repository/vo/ClickAction;", "getClickAction", "()Lcom/bytedance/android/ec/window/base/repository/vo/ClickAction;", "showEventName", "getShowEventName", "clickEventName", "getClickEventName", "", "showParams", "Ljava/util/Map;", "getShowParams", "()Ljava/util/Map;", "clickParams", "getClickParams", "setClickParams", "(Ljava/util/Map;)V", "", "extraInfo", "getExtraInfo", "setExtraInfo", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTagContainerDTO implements Serializable {

    @SerializedName("click_action")
    private final ClickAction clickAction;

    @SerializedName("click_event_name")
    private final String clickEventName;

    @SerializedName("click_event_params")
    private Map<String, String> clickParams;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("show_event_name")
    private final String showEventName;

    @SerializedName("show_event_params")
    private final Map<String, String> showParams;

    @SerializedName("sub_tag_list")
    private List<f> subTagList;

    @SerializedName("container_ui")
    private TagContainerUI tagContainerUI;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private String tagType;

    @SerializedName("type")
    private final int type;

    public ECWindowTagContainerDTO() {
        this.type = -1;
        this.subTagList = CollectionsKt.emptyList();
        this.tagContainerUI = new TagContainerUI();
        this.showParams = new LinkedHashMap();
        this.clickParams = new LinkedHashMap();
        this.extraInfo = MapsKt.emptyMap();
    }

    public final ClickAction getClickAction() {
        return this.clickAction;
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final Map<String, String> getClickParams() {
        return this.clickParams;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final Map<String, String> getShowParams() {
        return this.showParams;
    }

    public final List<f> getSubTagList() {
        return this.subTagList;
    }

    public final TagContainerUI getTagContainerUI() {
        return this.tagContainerUI;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public final int getType() {
        return this.type;
    }

    public final void setClickParams(Map<String, String> r100) {
        this.clickParams = r100;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraInfo = r100;
    }

    public final void setSubTagList(List<f> r100) {
        this.subTagList = r100;
    }

    public final void setTagContainerUI(TagContainerUI r100) {
        this.tagContainerUI = r100;
    }

    public final void setTagType(String r100) {
        this.tagType = r100;
    }

    public final void setUpdateColor(ECWindowTagContainerDTO r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TagContainerUI r102 = this.tagContainerUI;
        if (r102 == null) goto L7;
        r102.setUpdateColor(r100.tagContainerUI, r101);
    L7:
        List<f> r103 = this.subTagList;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return;
    L16:
        List<f> r105 = this.subTagList;
        Integer r106 = null;
        if (r105 == null) goto L19;
        Integer r107 = Integer.valueOf(r105.size());
    L20:
        List<f> r108 = r100.subTagList;
        if (r108 == null) goto L24;
        r106 = Integer.valueOf(r108.size());
    L24:
        if ((!Intrinsics.areEqual(r107, r106)) == false) goto L26;
        return;
    L26:
        List<f> r109 = this.subTagList;
        if (r109 == null) goto L29;
        int r110 = r109.size();
    L30:
        int r111 = 0;
    L31:
        if (r111 >= r110) goto L41;
        List<f> r112 = this.subTagList;
        if (r112 == null) goto L40;
        f r113 = (f) CollectionsKt.getOrNull(r112, 0);
        if (r113 == null) goto L40;
        List<f> r114 = r100.subTagList;
        if (r114 == null) goto L39;
        f r115 = (f) CollectionsKt.getOrNull(r114, r111);
    L39:
        r113.h();
    L40:
        r111 = r111 + 1;
        goto L31
    L41:
        return;
    L29:
        r110 = 0;
        goto L30
    L19:
        r107 = null;
        goto L20
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
        goto L14
    }
}
