package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewComponentConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewComponentConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewComponentConfig;", "()V", "pollDuration", "", "getPollDuration", "()Ljava/lang/Long;", "setPollDuration", "(J)V", "randomTime", "getRandomTime", "setRandomTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "showDuration", "getShowDuration", "setShowDuration", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewComponentConfig extends FlexModelBase<IPreviewComponentConfig> implements IPreviewComponentConfig, h {

    @SerializedName("poll_duration")
    protected long pollDuration;

    @SerializedName("random_time")
    protected Long randomTime;

    @SerializedName("show_duration")
    protected long showDuration;

    public PreviewComponentConfig() {
        super(IPreviewComponentConfig.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewComponentConfig
    public Long getPollDuration() {
        return Long.valueOf(this.pollDuration);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewComponentConfig
    public Long getShowDuration() {
        return Long.valueOf(this.showDuration);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewComponentConfig
    public Long getRandomTime() {
        return this.randomTime;
    }

    public PreviewComponentConfig(g r100) {
        super(IPreviewComponentConfig.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.randomTime = Long.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pollDuration = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.showDuration = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setPollDuration(long r100) {
        this.pollDuration = r100;
    }

    public void setRandomTime(Long r100) {
        this.randomTime = r100;
    }

    public void setShowDuration(long r100) {
        this.showDuration = r100;
    }
}
