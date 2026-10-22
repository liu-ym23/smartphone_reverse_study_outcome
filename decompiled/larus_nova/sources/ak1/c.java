package ak1;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "SessionEffectPrepareTask";
    }

    @Override // gs2.a
    public final void run() {
        com.bytedance.android.live.platformplayer.service.a r100 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r100 == null) goto L8;
        com.bytedance.android.live.platformplayer.effect.b r101 = r100.c4();
        if (r101 == null) goto L9;
        r101.prepare();
        return;
    L9:
        return;
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
