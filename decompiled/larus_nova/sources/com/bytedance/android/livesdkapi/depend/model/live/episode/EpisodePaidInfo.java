package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002<=B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0005J\b\u00103\u001a\u0004\u0018\u000104J\u0010\u00105\u001a\u0004\u0018\u00010\u000f2\u0006\u00106\u001a\u00020\u0005J\u0006\u00107\u001a\u00020\u0015J\u0006\u00108\u001a\u00020\u0015J\u0006\u00109\u001a\u00020\u0015J\u000e\u0010:\u001a\u00020;2\u0006\u00106\u001a\u00020\u0005R\u001e\u0010\u0004\u001a\u00020\u00058V@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020#8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePaidInfo;", "()V", "feedFreeDuration", "", "getFeedFreeDuration", "()J", "setFeedFreeDuration", "(J)V", "freeDuration", "getFreeDuration", "setFreeDuration", "freeViewRanges", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;", "getFreeViewRanges", "()Ljava/util/List;", "setFreeViewRanges", "(Ljava/util/List;)V", "isDelivery", "", "()Z", "setDelivery", "(Z)V", "itemsDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IItemDetail;", "getItemsDetail", "setItemsDetail", "mCurrentFreeViewRange", "getMCurrentFreeViewRange", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;", "setMCurrentFreeViewRange", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;)V", "paidType", "", "getPaidType", "()I", "setPaidType", "(I)V", "videoInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "getVideoInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "setVideoInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;)V", "viewRight", "getViewRight", "setViewRight", "canFreeViewByCurrent", "current", "getPaidStatus", "", "getTargetFreeViewRange", "process", "hasCurrentFreeViewRange", "isPaidEpisode", "isViewRight", "updateCurrentFreeViewRange", "", "PaidType", "ViewRight", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodePaidInfo extends FlexModelBase<IEpisodePaidInfo> implements IEpisodePaidInfo, h {

    @SerializedName("feed_duration")
    @IgnoreProtoDecode
    private long feedFreeDuration;

    @SerializedName("duration")
    protected long freeDuration;

    @SerializedName("free_view_ranges")
    protected List<? extends IVSFreeViewRange> freeViewRanges;

    @SerializedName("IsDelivery")
    protected boolean isDelivery;

    @SerializedName("goods_infos_v2")
    protected List<? extends IItemDetail> itemsDetail;
    private IVSFreeViewRange mCurrentFreeViewRange;

    @SerializedName("paid_type")
    protected int paidType;

    @SerializedName(a.KEY_VIDEO_INFO)
    protected IEpisodeVideo videoInfo;

    @SerializedName("view_right")
    protected int viewRight;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo$PaidType;", "", "()V", "FREE_EPISODE", "", "PAID_CAMERA", "PAID_EPISODE", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PaidType {
        public static final int FREE_EPISODE = 0;
        public static final PaidType INSTANCE = null;
        public static final int PAID_CAMERA = 3;
        public static final int PAID_EPISODE = 1;

        private PaidType() {
        }

        static {
            INSTANCE = new PaidType();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePaidInfo$ViewRight;", "", "()V", "HAS_RIGHT", "", "NO_RIGHT", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewRight {
        public static final int HAS_RIGHT = 1;
        public static final ViewRight INSTANCE = null;
        public static final int NO_RIGHT = 0;

        private ViewRight() {
        }

        static {
            INSTANCE = new ViewRight();
        }
    }

    public EpisodePaidInfo() {
        super(IEpisodePaidInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public long getFeedFreeDuration() {
        IVSFreeViewRange r100 = this.mCurrentFreeViewRange;
        if (r100 != null) goto L6;
        return 0;
    L6:
        Intrinsics.checkNotNull(r100);
        long r101 = r100.getEndTime();
        IVSFreeViewRange r102 = this.mCurrentFreeViewRange;
        Intrinsics.checkNotNull(r102);
        return r101 - r102.getStartTime();
    }

    public final boolean hasCurrentFreeViewRange() {
        if (this.mCurrentFreeViewRange == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getPaidStatus() {
        if (getPaidType() == 1) goto L5;
        return null;
    L5:
        if (getViewRight() != 1) goto L8;
        return "paid";
    L8:
        return "unpaid";
    }

    public final boolean isPaidEpisode() {
        if (getPaidType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isViewRight() {
        if (getViewRight() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public long getFreeDuration() {
        return this.freeDuration;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public List<IVSFreeViewRange> getFreeViewRanges() {
        return this.freeViewRanges;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public List<IItemDetail> getItemsDetail() {
        return this.itemsDetail;
    }

    public final IVSFreeViewRange getMCurrentFreeViewRange() {
        return this.mCurrentFreeViewRange;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public int getPaidType() {
        return this.paidType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public IEpisodeVideo getVideoInfo() {
        return this.videoInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public int getViewRight() {
        return this.viewRight;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public boolean isDelivery() {
        return this.isDelivery;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeVideo, java.lang.Object] */
    public EpisodePaidInfo(g r100) {
        super(IEpisodePaidInfo.class);
        this.itemsDetail = new ArrayList();
        this.freeViewRanges = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.paidType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.viewRight = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.freeDuration = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.videoInfo = f.a(r100, IEpisodeVideo.class);
        goto L3
    L13:
        switch(r102) {
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L15;
            default: goto L14;
        };
    L15:
        List r104 = this.freeViewRanges;
        Class r105 = IVSFreeViewRange.class;
    L17:
        r104.add(f.a(r100, r105));
        goto L3
    L16:
        r104 = this.itemsDetail;
        r105 = IItemDetail.class;
        goto L17
    L18:
        this.isDelivery = am3.h.a(r100);
        goto L3
    L14:
        am3.h.d(r103, r100);
        goto L3
    L23:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final boolean canFreeViewByCurrent(long r100) {
        IVSFreeViewRange r101 = this.mCurrentFreeViewRange;
        if (r101 == null) goto L14;
        Intrinsics.checkNotNull(r101);
        long r102 = r101.getStartTime();
        IVSFreeViewRange r103 = this.mCurrentFreeViewRange;
        Intrinsics.checkNotNull(r103);
        if (r102 > r103.getEndTime()) goto L14;
        IVSFreeViewRange r104 = this.mCurrentFreeViewRange;
        Intrinsics.checkNotNull(r104);
        if (r100 < r104.getStartTime()) goto L12;
        IVSFreeViewRange r105 = this.mCurrentFreeViewRange;
        Intrinsics.checkNotNull(r105);
        if (r100 >= r105.getEndTime()) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    L14:
        return true;
    }

    public final IVSFreeViewRange getTargetFreeViewRange(long r100) {
        if (CollectionUtils.isEmpty(getFreeViewRanges()) == false) goto L6;
        VSFreeViewRange r101 = new VSFreeViewRange();
        r101.setStartTime(0);
        r101.setEndTime(getFreeDuration());
        return r101;
    L6:
        List<IVSFreeViewRange> r102 = getFreeViewRanges();
        Intrinsics.checkNotNull(r102);
        IVSFreeViewRange r103 = (IVSFreeViewRange) ListProtector.get(r102, 0);
        long r104 = Integer.MAX_VALUE;
        List<IVSFreeViewRange> r105 = getFreeViewRanges();
        Intrinsics.checkNotNull(r105);
        Iterator<IVSFreeViewRange> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L16;
        IVSFreeViewRange r107 = r106.next();
        Intrinsics.checkNotNull(r107);
        if (r100 < r107.getStartTime()) goto L8;
        if (r100 > r107.getEndTime()) goto L8;
        if ((r100 - r107.getStartTime()) >= r104) goto L8;
        r104 = r100 - r107.getStartTime();
        r103 = r107;
        goto L8
    L16:
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setDelivery(boolean r100) {
        this.isDelivery = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setFeedFreeDuration(long r100) {
        this.feedFreeDuration = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setFreeDuration(long r100) {
        this.freeDuration = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setFreeViewRanges(List<? extends IVSFreeViewRange> r100) {
        this.freeViewRanges = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setItemsDetail(List<? extends IItemDetail> r100) {
        this.itemsDetail = r100;
    }

    public final void setMCurrentFreeViewRange(IVSFreeViewRange r100) {
        this.mCurrentFreeViewRange = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setPaidType(int r100) {
        this.paidType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setVideoInfo(IEpisodeVideo r100) {
        this.videoInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePaidInfo
    public void setViewRight(int r100) {
        this.viewRight = r100;
    }

    public final void updateCurrentFreeViewRange(long r100) {
        this.mCurrentFreeViewRange = getTargetFreeViewRange(r100);
    }
}
