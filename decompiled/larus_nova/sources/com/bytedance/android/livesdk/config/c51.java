package com.bytedance.android.livesdk.config;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/c51;", "", "", "digHoleOpt", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", GXTemplateKey.FLEXBOX_MARGIN, "I", "b", "()I", "", "maskAlpha", FaceService.girlLabel, "c", "()F", "cutoutShortEdges", "getCutoutShortEdges", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c51 {

    @SerializedName("cutout_short_edges")
    private final boolean cutoutShortEdges;

    @SerializedName("dig_hole_opt")
    private final boolean digHoleOpt;

    @SerializedName("margin_min")
    private final int margin;

    @SerializedName("mask_alpha")
    private final float maskAlpha;

    public c51() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c51) == false) goto L14;
        c51 r101 = (c51) r100;
        if (this.digHoleOpt == r101.digHoleOpt) goto L8;
        return false;
    L8:
        if (this.margin == r101.margin) goto L10;
        return false;
    L10:
        if (Float.compare(this.maskAlpha, r101.maskAlpha) == 0) goto L12;
        return false;
    L12:
        if (this.cutoutShortEdges == r101.cutoutShortEdges) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.digHoleOpt;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((((r102 * 31) + this.margin) * 31) + Float.floatToIntBits(this.maskAlpha)) * 31;
        boolean r104 = this.cutoutShortEdges;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "LiveLandscapeMarginConfig(digHoleOpt=" + this.digHoleOpt + ", margin=" + this.margin + ", maskAlpha=" + this.maskAlpha + ", cutoutShortEdges=" + this.cutoutShortEdges + ")";
    }

    public final boolean a() {
        return this.digHoleOpt;
    }

    public final int b() {
        return this.margin;
    }

    public final float c() {
        return this.maskAlpha;
    }

    public c51(int r100) {
        this.digHoleOpt = false;
        this.margin = 20;
        this.maskAlpha = 1.0f;
        this.cutoutShortEdges = false;
    }
}
