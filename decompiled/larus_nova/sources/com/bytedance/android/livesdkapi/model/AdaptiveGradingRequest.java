package com.bytedance.android.livesdkapi.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\b\u0010$\u001a\u00020%H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;", "", "enable", "", "targetBrightness", "", "targetContrast", "targetSaturation", "thresholdBrightness", "", "thresholdContrast", "thresholdSaturation", "gopTime", "(ZIII[F[F[FI)V", "getEnable", "()Z", "setEnable", "(Z)V", "getGopTime", "()I", "setGopTime", "(I)V", "getTargetBrightness", "setTargetBrightness", "getTargetContrast", "setTargetContrast", "getTargetSaturation", "setTargetSaturation", "getThresholdBrightness", "()[F", "setThresholdBrightness", "([F)V", "getThresholdContrast", "setThresholdContrast", "getThresholdSaturation", "setThresholdSaturation", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdaptiveGradingRequest {
    private boolean enable;
    private int gopTime;
    private int targetBrightness;
    private int targetContrast;
    private int targetSaturation;
    private float[] thresholdBrightness;
    private float[] thresholdContrast;
    private float[] thresholdSaturation;

    public AdaptiveGradingRequest() {
        this(false, 0, 0, 0, null, null, null, 0, 255, null);
    }

    public String toString() {
        return "enable: " + this.enable + "; targetBrightness: " + this.targetBrightness + "; targetContrast: " + this.targetContrast + "; targetSaturation: " + this.targetSaturation + "; thresholdBrightness: " + Arrays.toString(this.thresholdBrightness) + "; thresholdContrast: " + Arrays.toString(this.thresholdContrast) + "; thresholdSaturation: " + Arrays.toString(this.thresholdSaturation) + ';';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getGopTime() {
        return this.gopTime;
    }

    public final int getTargetBrightness() {
        return this.targetBrightness;
    }

    public final int getTargetContrast() {
        return this.targetContrast;
    }

    public final int getTargetSaturation() {
        return this.targetSaturation;
    }

    public final float[] getThresholdBrightness() {
        return this.thresholdBrightness;
    }

    public final float[] getThresholdContrast() {
        return this.thresholdContrast;
    }

    public final float[] getThresholdSaturation() {
        return this.thresholdSaturation;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setGopTime(int r100) {
        this.gopTime = r100;
    }

    public final void setTargetBrightness(int r100) {
        this.targetBrightness = r100;
    }

    public final void setTargetContrast(int r100) {
        this.targetContrast = r100;
    }

    public final void setTargetSaturation(int r100) {
        this.targetSaturation = r100;
    }

    public final void setThresholdBrightness(float[] r100) {
        this.thresholdBrightness = r100;
    }

    public final void setThresholdContrast(float[] r100) {
        this.thresholdContrast = r100;
    }

    public final void setThresholdSaturation(float[] r100) {
        this.thresholdSaturation = r100;
    }

    public AdaptiveGradingRequest(boolean r100, int r101, int r102, int r103, float[] r104, float[] r105, float[] r106, int r107) {
        this.enable = r100;
        this.targetBrightness = r101;
        this.targetContrast = r102;
        this.targetSaturation = r103;
        this.thresholdBrightness = r104;
        this.thresholdContrast = r105;
        this.thresholdSaturation = r106;
        this.gopTime = r107;
    }

    public /* synthetic */ AdaptiveGradingRequest(boolean r110, int r111, int r112, int r113, float[] r114, float[] r115, float[] r116, int r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r100 = false;
    L6:
        int r101 = -1;
        if ((r118 & 2) == 0) goto L9;
        int r102 = -1;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = -1;
    L15:
        if ((r118 & 8) != 0) goto L18;
        r101 = r113;
    L18:
        float[] r104 = null;
        if ((r118 & 16) == 0) goto L21;
        float[] r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        float[] r106 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r104 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r107 = 2000;
    L34:
        this(r100, r102, r103, r101, r105, r106, r104, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
