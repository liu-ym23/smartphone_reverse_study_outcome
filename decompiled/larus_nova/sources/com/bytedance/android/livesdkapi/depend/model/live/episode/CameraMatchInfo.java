package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/CameraMatchInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ICameraMatchInfo;", "()V", "contentId", "", "getContentId", "()J", "setContentId", "(J)V", b.f276361k, "", "getEventId", "()Ljava/util/List;", "setEventId", "(Ljava/util/List;)V", "hideTabIds", "getHideTabIds", "setHideTabIds", "matchId", "getMatchId", "setMatchId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CameraMatchInfo extends FlexModelBase<ICameraMatchInfo> implements ICameraMatchInfo, h {

    @SerializedName(a.KEY_CONTENT_ID)
    protected long contentId;

    @SerializedName("event_ids")
    protected List<Long> eventId;

    @SerializedName("hide_tab_ids")
    protected List<Long> hideTabIds;

    @SerializedName(VSConstants.VS_MATCH_ID)
    protected long matchId;

    public CameraMatchInfo() {
        super(ICameraMatchInfo.class);
        this.eventId = new ArrayList();
        this.hideTabIds = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public long getContentId() {
        return this.contentId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public List<Long> getEventId() {
        return this.eventId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public List<Long> getHideTabIds() {
        return this.hideTabIds;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public long getMatchId() {
        return this.matchId;
    }

    public CameraMatchInfo(g r100) {
        super(ICameraMatchInfo.class);
        this.eventId = new ArrayList();
        this.hideTabIds = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.matchId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.contentId = r100.j();
        goto L3
    L10:
        if (r102 == 3) goto L15;
        if (r102 != 4) goto L13;
        List<Long> r104 = this.hideTabIds;
    L16:
        r104.add(Long.valueOf(r100.j()));
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r104 = this.eventId;
        goto L16
    L19:
        r100.d(r101);
        setThreadSafe(true);
        if (this.eventId.isEmpty() == false) goto L23;
        this.eventId = new ArrayList();
    L23:
        if (this.hideTabIds.isEmpty() == false) goto L39;
        this.hideTabIds = new ArrayList();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public void setContentId(long r100) {
        this.contentId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public void setEventId(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public void setHideTabIds(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hideTabIds = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.ICameraMatchInfo
    public void setMatchId(long r100) {
        this.matchId = r100;
    }
}
