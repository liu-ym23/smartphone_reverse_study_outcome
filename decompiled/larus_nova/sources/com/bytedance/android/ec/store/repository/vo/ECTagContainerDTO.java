package com.bytedance.android.ec.store.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bP\u0010QB!\b\u0016\u0012\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010R\u0018\u00010E¢\u0006\u0004\bP\u0010AJ\u0018\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tR\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R$\u00108\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R0\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR.\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010=\u001a\u0004\bG\u0010?\"\u0004\bH\u0010AR\"\u0010O\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006T"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ECTagContainerDTO;", "Ljava/io/Serializable;", "other", "", "factor", "", "setUpdateColor", "", "index", "", "canDropSubTag", "hasDroppableSubTag", "type", "I", "getType", "()I", "setType", "(I)V", "", "tagType", "Ljava/lang/String;", "getTagType", "()Ljava/lang/String;", "setTagType", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/ec/store/repository/vo/s;", "subTagList", "Ljava/util/List;", "getSubTagList", "()Ljava/util/List;", "setSubTagList", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;", "tagContainerUI", "Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;", "getTagContainerUI", "()Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;", "setTagContainerUI", "(Lcom/bytedance/android/ec/store/repository/vo/TagContainerUI;)V", "priority", "getPriority", "setPriority", "droppableSubTagIndexes", "getDroppableSubTagIndexes", "setDroppableSubTagIndexes", "Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "clickAction", "Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "getClickAction", "()Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "setClickAction", "(Lcom/bytedance/android/ec/store/repository/vo/ClickAction;)V", "showEventName", "getShowEventName", "setShowEventName", "clickEventName", "getClickEventName", "setClickEventName", "", "showParams", "Ljava/util/Map;", "getShowParams", "()Ljava/util/Map;", "setShowParams", "(Ljava/util/Map;)V", "clickParams", "getClickParams", "setClickParams", "", "extraInfo", "getExtraInfo", "setExtraInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getShouldDropOverflowSubTags", "()Z", "setShouldDropOverflowSubTags", "(Z)V", "shouldDropOverflowSubTags", "<init>", "()V", "", "sliceData", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTagContainerDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f48397a;

    @SerializedName("click_action")
    private ClickAction clickAction;

    @SerializedName("click_event_name")
    private String clickEventName;

    @SerializedName("click_event_params")
    private Map<String, String> clickParams;

    @SerializedName("droppable_sub_tag_indexes")
    private List<Integer> droppableSubTagIndexes;

    @SerializedName("extra_info")
    private Map<String, String> extraInfo;

    @SerializedName("priority")
    private int priority;

    @SerializedName("show_event_name")
    private String showEventName;

    @SerializedName("show_event_params")
    private Map<String, String> showParams;

    @SerializedName("sub_tag_list")
    private List<s> subTagList;

    @SerializedName("container_ui")
    private TagContainerUI tagContainerUI;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private String tagType;

    @SerializedName("type")
    private int type;

    public final boolean hasDroppableSubTag() {
        List<s> r100 = this.subTagList;
        if (r100 == null) goto L20;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L14;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        s r105 = (s) r103;
        if (canDropSubTag(r102) == true) goto L12;
        r102 = r104;
        goto L6
    L12:
        boolean r106 = true;
    L15:
        if (r106 != true) goto L21;
        return true;
    L21:
        return false;
    L14:
        r106 = false;
        goto L15
    L20:
        return false;
    }

    public ECTagContainerDTO() {
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

    public final List<Integer> getDroppableSubTagIndexes() {
        return this.droppableSubTagIndexes;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getShouldDropOverflowSubTags() {
        return this.f48397a;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final Map<String, String> getShowParams() {
        return this.showParams;
    }

    public final List<s> getSubTagList() {
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

    public ECTagContainerDTO(Map<String, ? extends Object> r100) {
        int r101 = -1;
        this.type = -1;
        this.subTagList = CollectionsKt.emptyList();
        this.tagContainerUI = new TagContainerUI();
        this.showParams = new LinkedHashMap();
        this.clickParams = new LinkedHashMap();
        this.extraInfo = MapsKt.emptyMap();
        if (r100 != null) goto L5;
        return;
    L5:
        Object r102 = r100.get("type");
        Object r103 = null;
        if ((r102 instanceof Number) == true) goto L8;
        r102 = null;
    L8:
        Number r104 = (Number) r102;
        if (r104 == null) goto L11;
        r101 = r104.intValue();
    L11:
        this.type = r101;
        Object r105 = r100.get(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE);
        if (r105 == null) goto L14;
        String r106 = r105.toString();
    L15:
        this.tagType = r106;
        Object r107 = r100.get("sub_tag_list");
        if ((r107 instanceof List) == true) goto L18;
        r107 = null;
    L18:
        List r108 = (List) r107;
        if (r108 == null) goto L24;
        List r109 = r108;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = r109.iterator();
    L22:
        if (r111.hasNext() == false) goto L25;
        r110.add(new s((Map) r111.next()));
    L25:
        this.subTagList = r110;
        Object r112 = r100.get("container_ui");
        if ((r112 instanceof Map) == true) goto L28;
        r112 = null;
    L28:
        this.tagContainerUI = new TagContainerUI((Map) r112);
        Object r113 = r100.get("priority");
        if ((r113 instanceof Number) == true) goto L31;
        r113 = null;
    L31:
        Number r114 = (Number) r113;
        if (r114 == null) goto L34;
        int r115 = r114.intValue();
    L35:
        this.priority = r115;
        Object r116 = r100.get("droppable_sub_tag_indexes");
        if ((r116 instanceof List) == true) goto L38;
        r116 = null;
    L38:
        List r117 = (List) r116;
        if (r117 == null) goto L52;
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L42:
        if (r119.hasNext() == false) goto L53;
        Object r120 = r119.next();
        if ((r120 instanceof Number) == true) goto L46;
        r120 = null;
    L46:
        Number r121 = (Number) r120;
        if (r121 == null) goto L49;
        Integer r122 = Integer.valueOf(r121.intValue());
    L50:
        if (r122 == null) goto L42;
        r118.add(r122);
        goto L42
    L49:
        r122 = null;
    L53:
        this.droppableSubTagIndexes = r118;
        Object r123 = r100.get("click_action");
        if ((r123 instanceof Map) == true) goto L56;
        r123 = null;
    L56:
        this.clickAction = new ClickAction((Map) r123);
        Object r124 = r100.get("show_event_name");
        if (r124 == null) goto L59;
        String r125 = r124.toString();
    L60:
        this.showEventName = r125;
        Object r126 = r100.get("click_event_name");
        if (r126 == null) goto L63;
        String r127 = r126.toString();
    L64:
        this.clickEventName = r127;
        Object r128 = r100.get("show_event_params");
        if (TypeIntrinsics.isMutableMap(r128) == true) goto L67;
        r128 = null;
    L67:
        this.showParams = (Map) r128;
        Object r129 = r100.get("click_event_params");
        if (TypeIntrinsics.isMutableMap(r129) == true) goto L70;
        r129 = null;
    L70:
        this.clickParams = (Map) r129;
        Object r130 = r100.get("extra_info");
        if ((r130 instanceof Map) == false) goto L74;
        r103 = r130;
    L74:
        Map<String, String> r131 = (Map) r103;
        if (r131 != null) goto L77;
        r131 = MapsKt.emptyMap();
    L77:
        this.extraInfo = r131;
        return;
    L63:
        r127 = null;
        goto L64
    L59:
        r125 = null;
        goto L60
    L52:
        r118 = null;
        goto L53
    L34:
        r115 = 0;
        goto L35
    L24:
        r110 = null;
        goto L25
    L14:
        r106 = null;
        goto L15
    }

    public final boolean canDropSubTag(int r100) {
        List<Integer> r101 = this.droppableSubTagIndexes;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains(Integer.valueOf(r100));
    }

    public final void setClickAction(ClickAction r100) {
        this.clickAction = r100;
    }

    public final void setClickEventName(String r100) {
        this.clickEventName = r100;
    }

    public final void setClickParams(Map<String, String> r100) {
        this.clickParams = r100;
    }

    public final void setDroppableSubTagIndexes(List<Integer> r100) {
        this.droppableSubTagIndexes = r100;
    }

    public final void setExtraInfo(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraInfo = r100;
    }

    public final void setPriority(int r100) {
        this.priority = r100;
    }

    public final void setShouldDropOverflowSubTags(boolean r100) {
        this.f48397a = r100;
    }

    public final void setShowEventName(String r100) {
        this.showEventName = r100;
    }

    public final void setShowParams(Map<String, String> r100) {
        this.showParams = r100;
    }

    public final void setSubTagList(List<s> r100) {
        this.subTagList = r100;
    }

    public final void setTagContainerUI(TagContainerUI r100) {
        this.tagContainerUI = r100;
    }

    public final void setTagType(String r100) {
        this.tagType = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUpdateColor(ECTagContainerDTO r100, float r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TagContainerUI r102 = this.tagContainerUI;
        if (r102 == null) goto L7;
        r102.setUpdateColor(r100.tagContainerUI, r101);
    L7:
        List<s> r103 = this.subTagList;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return;
    L16:
        List<s> r105 = this.subTagList;
        if (r105 == null) goto L19;
        Integer r106 = Integer.valueOf(r105.size());
    L20:
        List<s> r107 = r100.subTagList;
        if (r107 == null) goto L23;
        Integer r108 = Integer.valueOf(r107.size());
    L25:
        if ((!Intrinsics.areEqual(r106, r108)) == false) goto L27;
        return;
    L27:
        List<s> r109 = this.subTagList;
        if (r109 == null) goto L30;
        int r110 = r109.size();
    L31:
        int r111 = 0;
    L32:
        if (r111 >= r110) goto L43;
        List<s> r112 = this.subTagList;
        if (r112 == null) goto L42;
        s r113 = (s) CollectionsKt.getOrNull(r112, 0);
        if (r113 == null) goto L42;
        List<s> r114 = r100.subTagList;
        if (r114 == null) goto L40;
        s r115 = (s) CollectionsKt.getOrNull(r114, r111);
    L41:
        r113.o(r115, r101);
        goto L42
    L40:
        r115 = null;
    L42:
        r111 = r111 + 1;
        goto L32
    L43:
        return;
    L30:
        r110 = 0;
        goto L31
    L23:
        r108 = null;
        goto L25
    L19:
        r106 = null;
        goto L20
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
        goto L14
    }
}
