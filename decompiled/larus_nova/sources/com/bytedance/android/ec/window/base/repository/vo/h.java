package com.bytedance.android.ec.window.base.repository.vo;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/h;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "f", "setTextColor", "specialTextColor", "getSpecialTextColor", "setSpecialTextColor", "", "fontSize", "I", "b", "()I", "setFontSize", "(I)V", "fontType", "c", "fontWidth", "d", "bgColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBgColor", "specialBgColor", "getSpecialBgColor", "setSpecialBgColor", "textOverLengthStrategy", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "setTextOverLengthStrategy", "(Ljava/lang/Integer;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("font_type")
    private final int fontType;

    @SerializedName("font_width")
    private final int fontWidth;

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

    public h() {
        this.text = "";
        this.textColor = "";
        this.specialTextColor = "";
        this.bgColor = "";
        this.specialBgColor = "";
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
        return this.text;
    }

    public final String f() {
        return this.textColor;
    }

    public final Integer g() {
        return this.textOverLengthStrategy;
    }
}
