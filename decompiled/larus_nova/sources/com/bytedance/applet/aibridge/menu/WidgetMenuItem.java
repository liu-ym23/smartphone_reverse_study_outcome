package com.bytedance.applet.aibridge.menu;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fHÆ\u0003J\u0019\u00103\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J²\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R*\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lcom/bytedance/applet/aibridge/menu/WidgetMenuItem;", "", "text", "", "iconLight", "iconDark", "id", "textColorLight", "textColorDark", "itemStyle", "switchStatus", "", "forbiddenDismissAfterClick", "disableClick", "lineItems", "", "onTap", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getIconLight", "getIconDark", "getId", "getTextColorLight", "getTextColorDark", "getItemStyle", "getSwitchStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getForbiddenDismissAfterClick", "getDisableClick", "getLineItems", "()Ljava/util/List;", "getOnTap", "()Lkotlin/jvm/functions/Function1;", "setOnTap", "(Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/applet/aibridge/menu/WidgetMenuItem;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetMenuItem {

    @SerializedName("disableClick")
    private final Boolean disableClick;

    @SerializedName("forbiddenDismissAfterClick")
    private final Boolean forbiddenDismissAfterClick;

    @SerializedName("iconDark")
    private final String iconDark;

    @SerializedName("iconLight")
    private final String iconLight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f191201id;

    @SerializedName("itemStyle")
    private final String itemStyle;

    @SerializedName("lineItems")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetMenuItem> lineItems;
    private Function1<? super Boolean, Unit> onTap;

    @SerializedName("switchStatus")
    private final Boolean switchStatus;

    @SerializedName("text")
    private final String text;

    @SerializedName("textColorDark")
    private final String textColorDark;

    @SerializedName("textColorLight")
    private final String textColorLight;

    public WidgetMenuItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetMenuItem copy$default(WidgetMenuItem r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, Boolean r211, Boolean r212, Boolean r213, List r214, Function1 r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.text;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.iconLight;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.iconDark;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.f191201id;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.textColorLight;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r105 = r110.textColorDark;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r106 = r110.itemStyle;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r107 = r110.switchStatus;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r117 = r110.forbiddenDismissAfterClick;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r118 = r110.disableClick;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        List r119 = r110.lineItems;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Function1 r108 = r110.onTap;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
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

    public final String component1() {
        return this.text;
    }

    public final Boolean component10() {
        return this.disableClick;
    }

    public final List<WidgetMenuItem> component11() {
        return this.lineItems;
    }

    public final Function1<Boolean, Unit> component12() {
        return this.onTap;
    }

    public final String component2() {
        return this.iconLight;
    }

    public final String component3() {
        return this.iconDark;
    }

    public final String component4() {
        return this.f191201id;
    }

    public final String component5() {
        return this.textColorLight;
    }

    public final String component6() {
        return this.textColorDark;
    }

    public final String component7() {
        return this.itemStyle;
    }

    public final Boolean component8() {
        return this.switchStatus;
    }

    public final Boolean component9() {
        return this.forbiddenDismissAfterClick;
    }

    public final WidgetMenuItem copy(String r110, String r111, String r112, String r113, String r114, String r210, String r211, Boolean r212, Boolean r213, Boolean r214, List<WidgetMenuItem> r215, Function1<? super Boolean, Unit> r216) {
        return new WidgetMenuItem(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WidgetMenuItem) == true) goto L8;
        return false;
    L8:
        WidgetMenuItem r101 = (WidgetMenuItem) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconLight, r101.iconLight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconDark, r101.iconDark) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f191201id, r101.f191201id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textColorLight, r101.textColorLight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textColorDark, r101.textColorDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemStyle, r101.itemStyle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.switchStatus, r101.switchStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.forbiddenDismissAfterClick, r101.forbiddenDismissAfterClick) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.disableClick, r101.disableClick) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.lineItems, r101.lineItems) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.onTap, r101.onTap) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconLight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconDark;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f191201id;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.textColorLight;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.textColorDark;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.itemStyle;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.switchStatus;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.forbiddenDismissAfterClick;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.disableClick;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<WidgetMenuItem> r131 = this.lineItems;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Function1<? super Boolean, Unit> r134 = this.onTap;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetMenuItem(text=" + this.text + ", iconLight=" + this.iconLight + ", iconDark=" + this.iconDark + ", id=" + this.f191201id + ", textColorLight=" + this.textColorLight + ", textColorDark=" + this.textColorDark + ", itemStyle=" + this.itemStyle + ", switchStatus=" + this.switchStatus + ", forbiddenDismissAfterClick=" + this.forbiddenDismissAfterClick + ", disableClick=" + this.disableClick + ", lineItems=" + this.lineItems + ", onTap=" + this.onTap + ')';
    }

    public final Boolean getDisableClick() {
        return this.disableClick;
    }

    public final Boolean getForbiddenDismissAfterClick() {
        return this.forbiddenDismissAfterClick;
    }

    public final String getIconDark() {
        return this.iconDark;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getId() {
        return this.f191201id;
    }

    public final String getItemStyle() {
        return this.itemStyle;
    }

    public final List<WidgetMenuItem> getLineItems() {
        return this.lineItems;
    }

    public final Function1<Boolean, Unit> getOnTap() {
        return this.onTap;
    }

    public final Boolean getSwitchStatus() {
        return this.switchStatus;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColorDark() {
        return this.textColorDark;
    }

    public final String getTextColorLight() {
        return this.textColorLight;
    }

    public final void setOnTap(Function1<? super Boolean, Unit> r100) {
        this.onTap = r100;
    }

    public WidgetMenuItem(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Boolean r107, Boolean r108, Boolean r110, List<WidgetMenuItem> r111, Function1<? super Boolean, Unit> r112) {
        this.text = r100;
        this.iconLight = r101;
        this.iconDark = r102;
        this.f191201id = r103;
        this.textColorLight = r104;
        this.textColorDark = r105;
        this.itemStyle = r106;
        this.switchStatus = r107;
        this.forbiddenDismissAfterClick = r108;
        this.disableClick = r110;
        this.lineItems = r111;
        this.onTap = r112;
    }

    public /* synthetic */ WidgetMenuItem(String r110, String r111, String r112, String r113, String r114, String r115, String r210, Boolean r211, Boolean r212, Boolean r213, List r214, Function1 r215, int r216, DefaultConstructorMarker r217) {
        Function1 r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Boolean r108 = Boolean.FALSE;
    L35:
        if ((r216 & 256) == 0) goto L37;
        Boolean r116 = Boolean.FALSE;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Boolean r117 = Boolean.FALSE;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        List r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
}
