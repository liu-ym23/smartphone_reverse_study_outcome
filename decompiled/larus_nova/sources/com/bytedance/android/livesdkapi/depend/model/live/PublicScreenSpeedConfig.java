package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PublicScreenSpeedConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "()V", VideoThumbInfo.KEY_INTERVAL, "", "getInterval", "()J", "setInterval", "(J)V", "scrollSpeed", "", "getScrollSpeed", "()I", "setScrollSpeed", "(I)V", "updateFoldSize", "getUpdateFoldSize", "setUpdateFoldSize", "updateScrollSize", "getUpdateScrollSize", "setUpdateScrollSize", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PublicScreenSpeedConfig extends FlexModelBase<IPublicScreenSpeedConfig> implements IPublicScreenSpeedConfig, h {

    @SerializedName("update_interval")
    protected long interval;

    @SerializedName("scroll_speed")
    protected int scrollSpeed;

    @SerializedName("fold_size")
    protected int updateFoldSize;

    @SerializedName("scroll_size")
    protected int updateScrollSize;

    public PublicScreenSpeedConfig() {
        super(IPublicScreenSpeedConfig.class);
        this.interval = 600;
        this.updateScrollSize = 2;
        this.updateFoldSize = 1;
        this.scrollSpeed = 550;
    }

    public String toString() {
        return "PublicScreenSpeedConfig{interval=" + getInterval() + ", updateScrollSize=" + getUpdateScrollSize() + ", updateFoldSize=" + getUpdateFoldSize() + ", scrollSpeed=" + getScrollSpeed() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public long getInterval() {
        return this.interval;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public int getScrollSpeed() {
        return this.scrollSpeed;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public int getUpdateFoldSize() {
        return this.updateFoldSize;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public int getUpdateScrollSize() {
        return this.updateScrollSize;
    }

    public PublicScreenSpeedConfig(g r100) {
        super(IPublicScreenSpeedConfig.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this.interval = r100.j();
        r101 = r101 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.updateScrollSize = r100.i();
        r101 = r101 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.updateFoldSize = r100.i();
        r101 = r101 | 4;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.scrollSpeed = r100.i();
        r101 = r101 | 8;
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L17:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L21;
        this.interval = 600;
    L21:
        if ((r101 & 2) != 0) goto L24;
        this.updateScrollSize = 2;
    L24:
        if ((r101 & 4) != 0) goto L27;
        this.updateFoldSize = 1;
    L27:
        if ((r101 & 8) != 0) goto L45;
        this.scrollSpeed = 550;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public void setInterval(long r100) {
        this.interval = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public void setScrollSpeed(int r100) {
        this.scrollSpeed = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public void setUpdateFoldSize(int r100) {
        this.updateFoldSize = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig
    public void setUpdateScrollSize(int r100) {
        this.updateScrollSize = r100;
    }
}
