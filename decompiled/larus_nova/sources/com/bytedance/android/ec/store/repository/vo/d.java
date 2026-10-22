package com.bytedance.android.ec.store.repository.vo;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/d;", "", "", "lineType", "I", "c", "()I", "setLineType", "(I)V", "", "lineColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setLineColor", "(Ljava/lang/String;)V", "specialLineColor", "e", "setSpecialLineColor", "", "lineWidth", "Ljava/lang/Double;", "d", "()Ljava/lang/Double;", "setLineWidth", "(Ljava/lang/Double;)V", "", "lineStyle", "Ljava/util/List;", "b", "()Ljava/util/List;", "setLineStyle", "(Ljava/util/List;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("line_color")
    private String lineColor;

    @SerializedName("line_style")
    private List<Double> lineStyle;

    @SerializedName("line_type")
    private int lineType;

    @SerializedName("line_width")
    private Double lineWidth;

    @SerializedName("special_line_color")
    private String specialLineColor;

    public d() {
        this.lineType = DividerLineType.DASHED_LINE.getType();
        this.lineColor = "";
        this.specialLineColor = "";
        this.lineStyle = CollectionsKt.emptyList();
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

    public final String e() {
        return this.specialLineColor;
    }

    public d(Map<String, ? extends Object> r100) {
        DividerLineType r101 = DividerLineType.DASHED_LINE;
        this.lineType = r101.getType();
        String r102 = "";
        this.lineColor = "";
        this.specialLineColor = "";
        this.lineStyle = CollectionsKt.emptyList();
        if (r100 != null) goto L5;
        return;
    L5:
        Object r103 = r100.get("line_type");
        Object r104 = null;
        if ((r103 instanceof Number) == true) goto L8;
        r103 = null;
    L8:
        Number r105 = (Number) r103;
        if (r105 == null) goto L11;
        int r106 = r105.intValue();
    L12:
        this.lineType = r106;
        Object r107 = r100.get("line_color");
        if (r107 == null) goto L18;
        String r108 = r107.toString();
        if (r108 == null) goto L18;
        r102 = r108;
    L18:
        this.lineColor = r102;
        Object r109 = r100.get("special_line_color");
        if (r109 == null) goto L21;
        String r110 = r109.toString();
    L22:
        this.specialLineColor = r110;
        Object r111 = r100.get("line_width");
        if ((r111 instanceof Double) == true) goto L25;
        r111 = null;
    L25:
        Double r112 = (Double) r111;
        if (r112 == null) goto L28;
        double r113 = r112.doubleValue();
    L29:
        this.lineWidth = Double.valueOf(r113);
        Object r114 = r100.get("line_style");
        if ((r114 instanceof List) == false) goto L33;
        r104 = r114;
    L33:
        List<Double> r115 = (List) r104;
        if (r115 != null) goto L36;
        r115 = CollectionsKt.emptyList();
    L36:
        this.lineStyle = r115;
        return;
    L28:
        r113 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L29
    L21:
        r110 = null;
        goto L22
    L11:
        r106 = r101.getType();
        goto L12
    }
}
