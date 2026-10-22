package ak1;

import com.bytedance.android.livesdk.config.ms;
import com.bytedance.android.livesdk.config.wq;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "PrepareSmoothBitmapInitTask";
    }

    @Override // gs2.a
    public final void run() {
        if (h().f510520i.booleanValue() == true) goto L5;
        return;
    L5:
        if (ms.f120779a.getValue().booleanValue() == true) goto L7;
        return;
    L7:
        if (wq.f121545a.getValue().c() == true) goto L9;
        return;
    L9:
        if (h().f510526o == null) goto L15;
        final long r100 = h().f510526o.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, 0);
        com.bytedance.android.livesdk.summer.a.f158439b.attachToRoom("SmoothEnterFrameBitmap", new a(r100));
        return;
    }

    public b() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
