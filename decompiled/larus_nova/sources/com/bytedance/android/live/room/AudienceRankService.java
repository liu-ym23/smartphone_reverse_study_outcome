package com.bytedance.android.live.room;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.IAudienceRankService;
import com.bytedance.android.live.room.api.rank.IAudienceRankType;
import com.bytedance.android.live.room.context.AudienceRankContext;
import com.bytedance.android.live.room.util.AudienceViewInfo;
import com.bytedance.android.live.room.widget.DefaultWidget;
import com.bytedance.android.live.room.widget.LandscapeRankInfoWidget;
import com.bytedance.android.live.room.widget.LiveRoomAudienceWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/room/AudienceRankService;", "Lcom/bytedance/android/live/room/api/IAudienceRankService;", "Lcom/bytedance/android/live/room/api/rank/IAudienceRankType;", "type", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAudienceRankWidget", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lw71/b;", "createAudienceRankContext", "", "roomId", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getRoomPCU", "getDynamicRoomMemberCount", "", "getShareCountText", "", "Lzo2/a;", "getAudienceRankNitaViewList", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceRankService implements IAudienceRankService {
    public AudienceRankService() {
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public List<zo2.a> getAudienceRankNitaViewList() {
        return ArraysKt.toList(AudienceViewInfo.values());
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public w71.b createAudienceRankContext(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        return new AudienceRankContext(r100);
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public Class<? extends LiveRecyclableWidget> getAudienceRankWidget(IAudienceRankType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = a.f98862a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return LiveRoomAudienceWidget.class;
    L5:
        if (r101 == 2) goto L7;
        return DefaultWidget.class;
    L7:
        return LandscapeRankInfoWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public com.bytedance.android.live.core.arch.mvvm.d<Long> getDynamicRoomMemberCount(DataCenter r100, long r101) {
        w71.b r102 = z51.a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getDynamicRoomMemberCount();
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public com.bytedance.android.live.core.arch.mvvm.d<Long> getRoomPCU(DataCenter r100, long r101) {
        w71.b r102 = z51.a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getRoomPCU();
    }

    @Override // com.bytedance.android.live.room.api.IAudienceRankService
    public String getShareCountText(DataCenter r100, long r101) {
        w71.b r102 = z51.a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getShareCountText();
    }
}
