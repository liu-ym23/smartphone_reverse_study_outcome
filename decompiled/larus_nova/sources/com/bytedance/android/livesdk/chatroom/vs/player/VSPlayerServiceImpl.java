package com.bytedance.android.livesdk.chatroom.vs.player;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.b;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jr1.c;
import kotlin.Metadata;
import pm1.h;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/player/VSPlayerServiceImpl;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/IVSPlayerService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/progress/service/IPlayerProgressService;", "provideVSProgressService", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/b;", "provideVSPlayerTipService", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/c;", "provideVSPlayerViewControlService", "", "releaseService", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSPlayerServiceImpl implements IVSPlayerService {
    public static final a Companion = null;
    public static final String TAG = "VSPlayerServiceImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public VSPlayerServiceImpl() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService
    public b provideVSPlayerTipService(DataCenter r100) {
        gr1.a r101 = c.a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.provideVSPlayerTipService(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService
    public com.bytedance.android.livesdk.chatroom.vsplayer.api.c provideVSPlayerViewControlService(DataCenter r100) {
        gr1.a r101 = c.a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.provideVSPlayerViewControlService(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService
    public IPlayerProgressService provideVSProgressService(DataCenter r100) {
        com.bytedance.android.livesdk.chatroom.vs_base.player.a r101 = (com.bytedance.android.livesdk.chatroom.vs_base.player.a) h.f529822d.c(com.bytedance.android.livesdk.chatroom.vs_base.player.a.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService
    public void releaseService(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.vs_base.player.a r101 = (com.bytedance.android.livesdk.chatroom.vs_base.player.a) h.f529822d.c(com.bytedance.android.livesdk.chatroom.vs_base.player.a.class);
        if (r101 == null) goto L7;
        r101.releaseService(r100);
    L7:
        gr1.a r102 = c.a();
        if (r102 == null) goto L11;
        r102.releaseService(r100);
        return;
    }
}
