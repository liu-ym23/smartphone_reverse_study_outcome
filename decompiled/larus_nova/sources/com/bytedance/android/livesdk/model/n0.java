package com.bytedance.android.livesdk.model;

import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/model/n0;", "", "", "cropX", "I", "c", "()I", ce.f26395j, "(I)V", "cropY", "d", ce.f26396k, "cropW", "b", RXScreenCaptureService.KEY_INDEX, "cropH", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "h", "strideW", "f", "m", "strideH", "e", "l", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153942a = 0;

    @SerializedName("crop_h")
    private int cropH;

    @SerializedName("crop_w")
    private int cropW;

    @SerializedName("crop_x")
    private int cropX;

    @SerializedName("crop_y")
    private int cropY;

    @SerializedName("stride_h")
    private int strideH;

    @SerializedName("stride_w")
    private int strideW;

    public static final class a {
        public static n0 a(JSONObject r100) {
            if (r100 == null) goto L17;
            n0 r101 = new n0();
            if (r100.get("crop_x") == null) goto L19;
            r101.j(JSONObjectProtectorUtils.getInt(r100, "crop_x"));
            if (r100.get("crop_y") == null) goto L20;
            r101.k(JSONObjectProtectorUtils.getInt(r100, "crop_y"));
            if (r100.get("crop_w") == null) goto L21;
            r101.i(JSONObjectProtectorUtils.getInt(r100, "crop_w"));
            if (r100.get("crop_h") == null) goto L22;
            r101.h(JSONObjectProtectorUtils.getInt(r100, "crop_h"));
            if (r100.get("stride_w") == null) goto L23;
            r101.m(JSONObjectProtectorUtils.getInt(r100, "stride_w"));
            if (r100.get("stride_h") == null) goto L24;
            r101.l(JSONObjectProtectorUtils.getInt(r100, "stride_h"));
            return r101;
        L24:
            return null;
        L23:
            return null;
        L22:
            return null;
        L21:
            return null;
        L20:
            return null;
        L19:
            return null;
        L17:
            return null;
        }
    }

    static {
    }

    public n0() {
    }

    public final boolean g() {
        int r100 = this.cropH;
        if (r100 <= 0) goto L26;
        int r101 = this.cropW;
        if (r101 <= 0) goto L27;
        int r102 = this.strideW;
        if (r102 <= 0) goto L28;
        int r103 = this.strideH;
        if (r103 <= 0) goto L33;
        int r104 = this.cropX;
        if (r104 < 0) goto L29;
        if (r104 > r102) goto L34;
        int r105 = this.cropY;
        if (r105 < 0) goto L30;
        if (r105 > r103) goto L35;
        if (r101 > r102) goto L31;
        if (r100 > r103) goto L36;
        if (r100 < r103) goto L24;
        if (r101 < r102) goto L24;
        return false;
    L24:
        return true;
    L36:
        return false;
    L31:
        return false;
    L35:
        return false;
    L30:
        return false;
    L34:
        return false;
    L29:
        return false;
    L33:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    }

    public final int hashCode() {
        int r100 = ax.a.f16609a;
        return Arrays.hashCode(new int[]{this.cropX, this.cropY, this.cropW, this.cropH, this.strideW, this.strideH});
    }

    public final String toString() {
        return "RevCropSeiData{cropX=" + this.cropX + ", cropY=" + this.cropY + ", cropW=" + this.cropW + ", cropH=" + this.cropH + ", strideW=" + this.strideW + ", strideH=" + this.strideH + '}';
    }

    public final int a() {
        return this.cropH;
    }

    public final int b() {
        return this.cropW;
    }

    public final int c() {
        return this.cropX;
    }

    public final int d() {
        return this.cropY;
    }

    public final int e() {
        return this.strideH;
    }

    public final int f() {
        return this.strideW;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(n0.class), Reflection.getOrCreateKotlinClass(r100.getClass()))) == true) goto L25;
        n0 r101 = (n0) r100;
        if (this.cropX == r101.cropX) goto L13;
    L23:
        return false;
    L13:
        if (this.cropY != r101.cropY) goto L23;
        if (this.cropW != r101.cropW) goto L23;
        if (this.cropH != r101.cropH) goto L23;
        if (this.strideW != r101.strideW) goto L23;
        if (this.strideH != r101.strideH) goto L23;
        return true;
    }

    public final void h(int r100) {
        this.cropH = r100;
    }

    public final void i(int r100) {
        this.cropW = r100;
    }

    public final void j(int r100) {
        this.cropX = r100;
    }

    public final void k(int r100) {
        this.cropY = r100;
    }

    public final void l(int r100) {
        this.strideH = r100;
    }

    public final void m(int r100) {
        this.strideW = r100;
    }
}
