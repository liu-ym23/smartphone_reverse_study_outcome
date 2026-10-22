package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayStreamUrl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IReplayStreamUrl;", "()V", "defaultResolutionKey", "", "getDefaultResolutionKey", "()Ljava/lang/String;", "setDefaultResolutionKey", "(Ljava/lang/String;)V", "playAlignOffset", "", "getPlayAlignOffset", "()J", "setPlayAlignOffset", "(J)V", "streamAddrList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStreamAddr;", "getStreamAddrList", "()Ljava/util/List;", "setStreamAddrList", "(Ljava/util/List;)V", "StreamAddr", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayStreamUrl extends FlexModelBase<IReplayStreamUrl> implements IReplayStreamUrl, h {

    @SerializedName("default_resolution_key")
    protected String defaultResolutionKey;

    @SerializedName("play_align_offset")
    protected long playAlignOffset;

    @SerializedName("stream_addr_list")
    protected List<? extends IStreamAddr> streamAddrList;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayStreamUrl$StreamAddr;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStreamAddr;", "()V", "resolutionKey", "", "getResolutionKey", "()Ljava/lang/String;", "setResolutionKey", "(Ljava/lang/String;)V", "resolutionName", "getResolutionName", "setResolutionName", "tslPullUrl", "getTslPullUrl", "setTslPullUrl", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StreamAddr extends FlexModelBase<IStreamAddr> implements IStreamAddr, h {

        @SerializedName("resolution_key")
        protected String resolutionKey;

        @SerializedName("resolution_name")
        protected String resolutionName;

        @SerializedName("tsl_pull_url")
        protected String tslPullUrl;

        public StreamAddr() {
            super(IStreamAddr.class);
        }

        public StreamAddr(g r100) {
            super(IStreamAddr.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.resolutionKey = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.resolutionName = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.tslPullUrl = am3.h.c(r100);
            goto L3
        L11:
            am3.h.d(r103, r100);
            goto L3
        L15:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public String getResolutionKey() {
            return this.resolutionKey;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public String getResolutionName() {
            return this.resolutionName;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public String getTslPullUrl() {
            return this.tslPullUrl;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public void setResolutionKey(String r100) {
            this.resolutionKey = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public void setResolutionName(String r100) {
            this.resolutionName = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IStreamAddr
        public void setTslPullUrl(String r100) {
            this.tslPullUrl = r100;
        }
    }

    public ReplayStreamUrl() {
        super(IReplayStreamUrl.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public String getDefaultResolutionKey() {
        return this.defaultResolutionKey;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public long getPlayAlignOffset() {
        return this.playAlignOffset;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public List<IStreamAddr> getStreamAddrList() {
        return this.streamAddrList;
    }

    public ReplayStreamUrl(g r100) {
        super(IReplayStreamUrl.class);
        this.streamAddrList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 3) goto L8;
        this.defaultResolutionKey = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 4) goto L10;
        this.playAlignOffset = r100.j();
        goto L3
    L10:
        if (r102 != 5) goto L11;
        this.streamAddrList.add(f.a(r100, IStreamAddr.class));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public void setDefaultResolutionKey(String r100) {
        this.defaultResolutionKey = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public void setPlayAlignOffset(long r100) {
        this.playAlignOffset = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IReplayStreamUrl
    public void setStreamAddrList(List<? extends IStreamAddr> r100) {
        this.streamAddrList = r100;
    }
}
