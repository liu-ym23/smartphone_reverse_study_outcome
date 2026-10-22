package com.bytedance.android.ec.store.repository.vo;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/u;", "", "", "left", "D", "b", "()D", "setLeft", "(D)V", "right", "c", "setRight", "top", "d", "setTop", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBottom", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("bottom")
    private double bottom;

    @SerializedName("left")
    private double left;

    @SerializedName("right")
    private double right;

    @SerializedName("top")
    private double top;

    public u() {
    }

    public final double a() {
        return this.bottom;
    }

    public final double b() {
        return this.left;
    }

    public final double c() {
        return this.right;
    }

    public final double d() {
        return this.top;
    }

    public u(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.get("left");
        Object r102 = null;
        if ((r101 instanceof Double) == true) goto L8;
        r101 = null;
    L8:
        Double r103 = (Double) r101;
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r103 == null) goto L11;
        double r105 = r103.doubleValue();
    L12:
        this.left = r105;
        Object r106 = r100.get("right");
        if ((r106 instanceof Double) == true) goto L15;
        r106 = null;
    L15:
        Double r107 = (Double) r106;
        if (r107 == null) goto L18;
        double r108 = r107.doubleValue();
    L19:
        this.right = r108;
        Object r109 = r100.get("top");
        if ((r109 instanceof Double) == true) goto L22;
        r109 = null;
    L22:
        Double r110 = (Double) r109;
        if (r110 == null) goto L25;
        double r111 = r110.doubleValue();
    L26:
        this.top = r111;
        Object r112 = r100.get("bottom");
        if ((r112 instanceof Double) == false) goto L30;
        r102 = r112;
    L30:
        Double r113 = (Double) r102;
        if (r113 == null) goto L33;
        r104 = r113.doubleValue();
    L33:
        this.bottom = r104;
        return;
    L25:
        r111 = 0.0d;
        goto L26
    L18:
        r108 = 0.0d;
        goto L19
    L11:
        r105 = 0.0d;
        goto L12
    }
}
