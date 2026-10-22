package com.bytedance.android.livesdk;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class b9 implements f9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xg1.k f104238a;

    public b9() {
        this.f104238a = new xg1.k();
    }

    @Override // com.bytedance.android.livesdk.f9.a
    public final boolean intercept(Map<String, String> r110) {
        xg1.k r100 = this.f104238a;
        r100.getClass();
        long r101 = SystemClock.elapsedRealtime();
        long r102 = System.currentTimeMillis();
        boolean r111 = false;
        r100.f563590d = false;
        boolean r103 = true;
        if (r100.f563589c == true) goto L13;
        r100.f563589c = true;
        r100.f563591e.l();
        r103 = r100.f563587a.d(r110, new xg1.j(r100, r110, r101, r102));
        if (r103 == true) goto L8;
        r100.f563589c = false;
        goto L13
    L8:
        if (r100.f563588b == null) goto L11;
        Bundle r112 = new Bundle();
        r112.putString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, ILiveRoomPlayFragmentConstant.ENTER_ROOM_TYPE_WITH_FEED_REQUEST);
        r112.putLong("anchor_id", 0);
        gl0.c r104 = ((IPullStreamService) jc1.k.f(IPullStreamService.class)).getLivePlayerOptimizer();
        com.bytedance.android.live.livepullstream.service.c r105 = (com.bytedance.android.live.livepullstream.service.c) r104;
        r111 = r105.b(r100.f563588b, 0, r112);
    L11:
        r100.f563590d = r111;
        xg1.k.b(r101, -3);
    L13:
        return r103;
    }
}
