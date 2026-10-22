package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MusicInterval;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/wa;", "", "toString", "", "startMs", "J", "getStartMs", "()J", "setStartMs", "(J)V", "durationMs", "getDurationMs", "setDurationMs", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MusicInterval extends FlexModelBase<wa> implements wa, vh7.h {

    @SerializedName("DurationMillisecond")
    protected long durationMs;

    @SerializedName("StartTimeMillisecond")
    protected long startMs;

    public MusicInterval() {
        super(wa.class);
    }

    public String toString() {
        return "[" + getStartMs() + ", " + (getStartMs() + getDurationMs()) + "]";
    }

    @Override // com.bytedance.android.livesdk.message.model.wa
    public long getDurationMs() {
        return this.durationMs;
    }

    @Override // com.bytedance.android.livesdk.message.model.wa
    public long getStartMs() {
        return this.startMs;
    }

    public MusicInterval(am3.g r100) {
        super(wa.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.startMs = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.durationMs = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setDurationMs(long r100) {
        this.durationMs = r100;
    }

    public void setStartMs(long r100) {
        this.startMs = r100;
    }
}
