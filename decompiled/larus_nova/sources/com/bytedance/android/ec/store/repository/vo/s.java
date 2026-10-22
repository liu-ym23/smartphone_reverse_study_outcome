package com.bytedance.android.ec.store.repository.vo;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b[\u0010\\R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010F\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010IR(\u0010M\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E\u0018\u00010L8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR0\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020E\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010N\u001a\u0004\bR\u0010P\"\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/s;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "Lcom/bytedance/android/ec/store/repository/vo/v;", "text", "Lcom/bytedance/android/ec/store/repository/vo/v;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lcom/bytedance/android/ec/store/repository/vo/v;", "setText", "(Lcom/bytedance/android/ec/store/repository/vo/v;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "specialImage", "m", "setSpecialImage", "Lcom/bytedance/android/ec/store/repository/vo/d;", "dividerLine", "Lcom/bytedance/android/ec/store/repository/vo/d;", "e", "()Lcom/bytedance/android/ec/store/repository/vo/d;", "setDividerLine", "(Lcom/bytedance/android/ec/store/repository/vo/d;)V", "Lcom/bytedance/android/ec/store/repository/vo/c;", "countDownConfig", "Lcom/bytedance/android/ec/store/repository/vo/c;", "d", "()Lcom/bytedance/android/ec/store/repository/vo/c;", "setCountDownConfig", "(Lcom/bytedance/android/ec/store/repository/vo/c;)V", "", "marginLeft", "D", ce.f26391f, "()D", "setMarginLeft", "(D)V", "marginRight", "h", "setMarginRight", "Lcom/bytedance/android/ec/store/repository/vo/u;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/ec/store/repository/vo/u;", ce.f26395j, "()Lcom/bytedance/android/ec/store/repository/vo/u;", "setPadding", "(Lcom/bytedance/android/ec/store/repository/vo/u;)V", "", "notIncludeFontPadding", "Ljava/lang/Boolean;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Boolean;", "setNotIncludeFontPadding", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "clickAction", "Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "", "showEventName", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "clickEventName", "b", "", "showParams", "Ljava/util/Map;", "getShowParams", "()Ljava/util/Map;", "clickParams", "c", "setClickParams", "(Ljava/util/Map;)V", "priority", "Ljava/lang/Integer;", ce.f26396k, "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("click_action")
    private final ClickAction clickAction;

    @SerializedName("click_event_name")
    private final String clickEventName;

    @SerializedName("click_event_params")
    private Map<String, String> clickParams;

    @SerializedName("count_down_config")
    private c countDownConfig;

    @SerializedName("divider_line")
    private d dividerLine;

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("margin_left")
    private double marginLeft;

    @SerializedName("margin_right")
    private double marginRight;

    @SerializedName("not_include_font_padding")
    private Boolean notIncludeFontPadding;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private u padding;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("show_event_name")
    private final String showEventName;

    @SerializedName("show_event_params")
    private final Map<String, String> showParams;

    @SerializedName("special_image")
    private ECUrlModel specialImage;

    @SerializedName("text")
    private v text;

    @SerializedName("type")
    private int type;

    public s() {
        this.type = SubTagType.TEXT.getType();
        this.text = new v();
        this.dividerLine = new d();
        this.notIncludeFontPadding = Boolean.FALSE;
        this.showParams = new LinkedHashMap();
        this.clickParams = new LinkedHashMap();
    }

    public final ClickAction a() {
        return this.clickAction;
    }

    public final String b() {
        return this.clickEventName;
    }

    public final Map<String, String> c() {
        return this.clickParams;
    }

    public final c d() {
        return this.countDownConfig;
    }

    public final d e() {
        return this.dividerLine;
    }

    public final ECUrlModel f() {
        return this.image;
    }

    public final double g() {
        return this.marginLeft;
    }

    public final int getType() {
        return this.type;
    }

    public final double h() {
        return this.marginRight;
    }

    public final Boolean i() {
        return this.notIncludeFontPadding;
    }

    public final u j() {
        return this.padding;
    }

    public final Integer k() {
        return this.priority;
    }

    public final String l() {
        return this.showEventName;
    }

    public final ECUrlModel m() {
        return this.specialImage;
    }

    public final v n() {
        return this.text;
    }

    public s(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceData");
        SubTagType r101 = SubTagType.TEXT;
        this.type = r101.getType();
        this.text = new v();
        this.dividerLine = new d();
        this.notIncludeFontPadding = Boolean.FALSE;
        this.showParams = new LinkedHashMap();
        this.clickParams = new LinkedHashMap();
        Object r102 = r100.get("type");
        Object r103 = null;
        if ((r102 instanceof Number) == true) goto L5;
        r102 = null;
    L5:
        Number r104 = (Number) r102;
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
    L9:
        this.type = r105;
        Object r106 = r100.get("text");
        if ((r106 instanceof Map) == true) goto L12;
        r106 = null;
    L12:
        this.text = new v((Map) r106);
        Object r107 = r100.get("priority");
        if ((r107 instanceof Number) == true) goto L15;
        r107 = null;
    L15:
        Number r108 = (Number) r107;
        if (r108 == null) goto L18;
        int r109 = r108.intValue();
    L19:
        this.priority = Integer.valueOf(r109);
        Object r110 = r100.get("image");
        if ((r110 instanceof Map) == true) goto L22;
        r110 = null;
    L22:
        this.image = com.bytedance.android.shopping.store.slicecard.i.d((Map) r110);
        Object r111 = r100.get("special_image");
        if ((r111 instanceof Map) == true) goto L25;
        r111 = null;
    L25:
        this.specialImage = com.bytedance.android.shopping.store.slicecard.i.d((Map) r111);
        Object r112 = r100.get("divider_line");
        if ((r112 instanceof Map) == true) goto L28;
        r112 = null;
    L28:
        this.dividerLine = new d((Map) r112);
        Object r113 = r100.get("count_down");
        if ((r113 instanceof Map) == true) goto L31;
        r113 = null;
    L31:
        this.countDownConfig = new c((Map) r113);
        Object r114 = r100.get("margin_left");
        if ((r114 instanceof Double) == true) goto L34;
        r114 = null;
    L34:
        Double r115 = (Double) r114;
        double r116 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r115 == null) goto L37;
        double r117 = r115.doubleValue();
    L38:
        this.marginLeft = r117;
        Object r118 = r100.get("margin_right");
        if ((r118 instanceof Double) == true) goto L41;
        r118 = null;
    L41:
        Double r119 = (Double) r118;
        if (r119 == null) goto L44;
        r116 = r119.doubleValue();
    L44:
        this.marginRight = r116;
        Object r120 = r100.get(GXTemplateKey.FLEXBOX_PADDING);
        if ((r120 instanceof Map) == false) goto L48;
        r103 = r120;
    L48:
        this.padding = new u((Map) r103);
        return;
    L37:
        r117 = 0.0d;
        goto L38
    L18:
        r109 = 0;
        goto L19
    L8:
        r105 = r101.getType();
        goto L9
    }

    public final void o(s r100, float r101) {
        v r102 = this.text;
        if (r100 == null) goto L5;
        v r103 = r100.text;
    L6:
        r102.j(r103, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
