package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActionsManager f122099e;

    public y(ActionsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "actionManager");
        super(r100);
        this.f122099e = r100;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Object r101 = r100.getTag();
        if ((r101 instanceof pt1.a) == true) goto L5;
        r101 = null;
    L5:
        pt1.a r102 = (pt1.a) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        xs2.b.a().post(new mt1.a(5, this.f122048b, this.f122099e.f121952e, r102, false, 16));
        Map<String, String> r103 = MapsKt.mapOf(TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follower_share", r103, new Object[]{am2.x.class, Room.class});
    }
}
