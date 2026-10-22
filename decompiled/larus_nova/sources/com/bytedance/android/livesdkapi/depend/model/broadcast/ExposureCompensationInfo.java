package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ExposureCompensationInfo;", "", "()V", "exposure", "", "getExposure", "()I", "setExposure", "(I)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "setMin", "step", "", "getStep", "()F", "setStep", "(F)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExposureCompensationInfo {
    private int exposure;
    private int max;
    private int min;
    private float step;

    public ExposureCompensationInfo() {
    }

    public final int getExposure() {
        return this.exposure;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final float getStep() {
        return this.step;
    }

    public final void setExposure(int r100) {
        this.exposure = r100;
    }

    public final void setMax(int r100) {
        this.max = r100;
    }

    public final void setMin(int r100) {
        this.min = r100;
    }

    public final void setStep(float r100) {
        this.step = r100;
    }
}
