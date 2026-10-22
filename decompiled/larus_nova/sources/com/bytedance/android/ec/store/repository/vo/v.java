package com.bytedance.android.ec.store.repository.vo;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/v;", "", "", "text", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "h", "setTextColor", "specialTextColor", "f", "setSpecialTextColor", "", "fontSize", "I", "b", "()I", "setFontSize", "(I)V", "fontType", "c", "setFontType", "fontWidth", "d", "setFontWidth", "bgColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBgColor", "specialBgColor", "e", "setSpecialBgColor", "textOverLengthStrategy", "Ljava/lang/Integer;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Integer;", "setTextOverLengthStrategy", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f48501b;

    @SerializedName("bg_color")
    private String bgColor;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f48502c;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("font_type")
    private int fontType;

    @SerializedName("font_width")
    private int fontWidth;

    @SerializedName("special_bg_color")
    private String specialBgColor;

    @SerializedName("special_text_color")
    private String specialTextColor;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("text_over_length_strategy")
    private Integer textOverLengthStrategy;

    public v() {
        this.text = "";
        this.textColor = "";
        this.specialTextColor = "";
        this.bgColor = "";
        this.specialBgColor = "";
        this.f48500a = "";
        this.f48501b = "";
    }

    public final String a() {
        return this.bgColor;
    }

    public final int b() {
        return this.fontSize;
    }

    public final int c() {
        return this.fontType;
    }

    public final int d() {
        return this.fontWidth;
    }

    public final String e() {
        return this.specialBgColor;
    }

    public final String f() {
        return this.specialTextColor;
    }

    public final String g() {
        return this.text;
    }

    public final String h() {
        return this.textColor;
    }

    public final Integer i() {
        return this.textOverLengthStrategy;
    }

    public v(Map<String, ? extends Object> r100) {
        String r101 = "";
        this.text = "";
        this.textColor = "";
        this.specialTextColor = "";
        this.bgColor = "";
        this.specialBgColor = "";
        this.f48500a = "";
        this.f48501b = "";
        if (r100 != null) goto L5;
        return;
    L5:
        Object r102 = r100.get("text");
        Object r103 = null;
        if ((r102 instanceof String) == true) goto L8;
        r102 = null;
    L8:
        String r104 = (String) r102;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.text = r104;
        Object r105 = r100.get("text_color");
        if ((r105 instanceof String) == true) goto L14;
        r105 = null;
    L14:
        String r106 = (String) r105;
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        this.textColor = r106;
        Object r107 = r100.get("special_text_color");
        if ((r107 instanceof String) == true) goto L20;
        r107 = null;
    L20:
        this.specialTextColor = (String) r107;
        Object r108 = r100.get("font_size");
        if ((r108 instanceof Number) == true) goto L23;
        r108 = null;
    L23:
        Number r109 = (Number) r108;
        int r110 = 0;
        if (r109 == null) goto L26;
        int r111 = r109.intValue();
    L27:
        this.fontSize = r111;
        Object r112 = r100.get("font_type");
        if ((r112 instanceof Number) == true) goto L30;
        r112 = null;
    L30:
        Number r113 = (Number) r112;
        if (r113 == null) goto L33;
        int r114 = r113.intValue();
    L34:
        this.fontType = r114;
        Object r115 = r100.get("font_width");
        if ((r115 instanceof Number) == true) goto L37;
        r115 = null;
    L37:
        Number r116 = (Number) r115;
        if (r116 == null) goto L40;
        int r117 = r116.intValue();
    L41:
        this.fontWidth = r117;
        Object r118 = r100.get("background_color");
        if ((r118 instanceof String) == true) goto L44;
        r118 = null;
    L44:
        String r119 = (String) r118;
        if (r119 == null) goto L48;
        r101 = r119;
    L48:
        this.bgColor = r101;
        Object r120 = r100.get("special_bg_color");
        if ((r120 instanceof String) == true) goto L51;
        r120 = null;
    L51:
        this.specialBgColor = (String) r120;
        Object r121 = r100.get("text_over_length_strategy");
        if ((r121 instanceof Number) == false) goto L55;
        r103 = r121;
    L55:
        Number r122 = (Number) r103;
        if (r122 == null) goto L58;
        r110 = r122.intValue();
    L58:
        this.textOverLengthStrategy = Integer.valueOf(r110);
        return;
    L40:
        r117 = 0;
        goto L41
    L33:
        r114 = 0;
        goto L34
    L26:
        r111 = 0;
        goto L27
    }

    public final void j(v r100, float r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.textColor;
    L6:
        this.f48500a = r103;
        if (r100 == null) goto L9;
        r102 = r100.bgColor;
    L9:
        this.f48501b = r102;
        this.f48502c = r101;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
