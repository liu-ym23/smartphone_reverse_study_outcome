package ah6;

import android.content.Context;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import qg6.f;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends xg6.a {
    public final tc0.b A;
    public final bn0.b B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f3431x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final cg6.a f3432y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f3433z;

    @Override // tg6.a, sf6.a
    public final BizLinkServiceType j() {
        return BizLinkServiceType.VoiceAnchor;
    }

    public a(g r100, cg6.a r101, f r102, tc0.b r103, bn0.b r104, Context r105) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "multiLinkComponentService");
        Intrinsics.checkNotNullParameter(r102, "hostService");
        Intrinsics.checkNotNullParameter(r103, "linkInRoomDataHolderKt");
        Intrinsics.checkNotNullParameter(r104, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103, r104, r105);
        this.f3431x = r100;
        this.f3432y = r101;
        this.f3433z = r102;
        this.A = r103;
        this.B = r104;
    }
}
