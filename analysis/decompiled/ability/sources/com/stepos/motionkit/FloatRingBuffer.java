package com.stepos.motionkit;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/stepos/motionkit/FloatRingBuffer;", "", "", "capacity", AppAgent.CONSTRUCT, "(I)V", "", "value", "LC7/r;", "push", "(F)V", "average", "()F", "max", "clear", "()V", "I", "", SettingsConfig.KEY_DATA, "[F", "head", "count", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatRingBuffer {
    private final int capacity;
    private int count;
    private final float[] data;
    private int head;

    public FloatRingBuffer(int i) {
        this.capacity = i;
        this.data = new float[i];
    }

    public final float average() {
        int i = this.count;
        float f = 0.0f;
        if (i == 0) {
            return 0.0f;
        }
        for (int i6 = 0; i6 < i; i6++) {
            f += this.data[i6];
        }
        return f / this.count;
    }

    public final void clear() {
        this.head = 0;
        this.count = 0;
    }

    public final float max() {
        int i = this.count;
        if (i == 0) {
            return 0.0f;
        }
        float f = this.data[0];
        for (int i6 = 1; i6 < i; i6++) {
            float f7 = this.data[i6];
            if (f7 > f) {
                f = f7;
            }
        }
        return f;
    }

    public final void push(float value) {
        float[] fArr = this.data;
        int i = this.head;
        fArr[i] = value;
        int i6 = this.capacity;
        this.head = (i + 1) % i6;
        int i10 = this.count;
        if (i10 < i6) {
            this.count = i10 + 1;
        }
    }
}
