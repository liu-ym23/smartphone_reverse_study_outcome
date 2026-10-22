package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0016\u0018\u00002\u00020\u0001B·\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b\u001a\u0010/\"\u0004\b0\u00101R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(¨\u0006>"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "headButtons", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "headCouponButtons", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiCouponButtonComponent;", "headLabels", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiGradientTextWithIconsComponent;", "tailButtons", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "alignStrategy", "", "statusId", "", "states", "", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "lynxCard", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "lynxAirCard", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxAirCardComponent;", "tag", "isHide", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiCouponButtonComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiGradientTextWithIconsComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxAirCardComponent;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "setAction", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;)V", "getAlignStrategy", "()I", "setAlignStrategy", "(I)V", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getHeadButtons", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "setHeadButtons", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;)V", "getHeadCouponButtons", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiCouponButtonComponent;", "getHeadLabels", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MultiGradientTextWithIconsComponent;", "()Ljava/lang/Boolean;", "setHide", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLynxAirCard", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxAirCardComponent;", "getLynxCard", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LynxCardComponent;", "getShowEvent", "()Ljava/util/List;", "getStates", "getStatusId", "()Ljava/lang/String;", "getTag", "getTailButtons", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LongContentLabelComponent implements Serializable {

    @SerializedName("action")
    private Action action;

    @SerializedName("align_strategy")
    private int alignStrategy;

    @SerializedName("background")
    private final Background background;

    @SerializedName("head_buttons")
    private TagsScrollBoxComponent headButtons;

    @SerializedName("head_coupon_buttons")
    private final MultiCouponButtonComponent headCouponButtons;

    @SerializedName("head_labels")
    private final MultiGradientTextWithIconsComponent headLabels;

    @SerializedName("is_hide")
    private Boolean isHide;

    @SerializedName("lynx_air_card")
    private final LynxAirCardComponent lynxAirCard;

    @SerializedName("lynx_card")
    private final LynxCardComponent lynxCard;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    @SerializedName("states")
    private final List<LongContentLabelComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("tail_buttons")
    private final TagsScrollBoxComponent tailButtons;

    public LongContentLabelComponent() {
        this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16383, null);
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final TagsScrollBoxComponent getHeadButtons() {
        return this.headButtons;
    }

    public final MultiCouponButtonComponent getHeadCouponButtons() {
        return this.headCouponButtons;
    }

    public final MultiGradientTextWithIconsComponent getHeadLabels() {
        return this.headLabels;
    }

    public final LynxAirCardComponent getLynxAirCard() {
        return this.lynxAirCard;
    }

    public final LynxCardComponent getLynxCard() {
        return this.lynxCard;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final List<LongContentLabelComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final TagsScrollBoxComponent getTailButtons() {
        return this.tailButtons;
    }

    public final Boolean isHide() {
        return this.isHide;
    }

    public final void setAction(Action r100) {
        this.action = r100;
    }

    public final void setAlignStrategy(int r100) {
        this.alignStrategy = r100;
    }

    public final void setHeadButtons(TagsScrollBoxComponent r100) {
        this.headButtons = r100;
    }

    public final void setHide(Boolean r100) {
        this.isHide = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LongContentLabelComponent(Action r100, TagsScrollBoxComponent r101, MultiCouponButtonComponent r102, MultiGradientTextWithIconsComponent r103, TagsScrollBoxComponent r104, Background r105, int r106, String r107, List<? extends LongContentLabelComponent> r108, List<ShowEvent> r110, LynxCardComponent r111, LynxAirCardComponent r112, String r113, Boolean r114) {
        this.action = r100;
        this.headButtons = r101;
        this.headCouponButtons = r102;
        this.headLabels = r103;
        this.tailButtons = r104;
        this.background = r105;
        this.alignStrategy = r106;
        this.statusId = r107;
        this.states = r108;
        this.showEvent = r110;
        this.lynxCard = r111;
        this.lynxAirCard = r112;
        this.tag = r113;
        this.isHide = r114;
    }

    public /* synthetic */ LongContentLabelComponent(Action r110, TagsScrollBoxComponent r111, MultiCouponButtonComponent r112, MultiGradientTextWithIconsComponent r113, TagsScrollBoxComponent r210, Background r211, int r212, String r213, List r214, List r215, LynxCardComponent r216, LynxAirCardComponent r217, String r218, Boolean r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        TagsScrollBoxComponent r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        MultiCouponButtonComponent r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        MultiGradientTextWithIconsComponent r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        TagsScrollBoxComponent r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Background r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        List r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        List r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        LynxCardComponent r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        LynxAirCardComponent r117 = null;
    L51:
        if ((r310 & 4096) != 0) goto L55;
        r100 = r218;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        Boolean r109 = Boolean.FALSE;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r100, r109);
        return;
    L57:
        r109 = r219;
        goto L58
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
