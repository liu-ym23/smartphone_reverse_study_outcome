package com.bytedance.android.ec.window.base.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/a;", "", "", "lineType", "I", "c", "()I", "setLineType", "(I)V", "", "lineColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setLineColor", "(Ljava/lang/String;)V", "specialLineColor", "getSpecialLineColor", "setSpecialLineColor", "", "lineWidth", "Ljava/lang/Double;", "d", "()Ljava/lang/Double;", "setLineWidth", "(Ljava/lang/Double;)V", "", "lineStyle", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("line_color")
    private String lineColor;

    @SerializedName("line_style")
    private final List<Double> lineStyle;

    @SerializedName("line_type")
    private int lineType;

    @SerializedName("line_width")
    private Double lineWidth;

    @SerializedName("special_line_color")
    private String specialLineColor;

    public a() {
        this.lineType = DividerLineType.DASHED_LINE.getType();
        this.lineColor = "";
        this.specialLineColor = "";
    }

    public final String a() {
        return this.lineColor;
    }

    public final List<Double> b() {
        return this.lineStyle;
    }

    public final int c() {
        return this.lineType;
    }

    public final Double d() {
        return this.lineWidth;
    }
}
