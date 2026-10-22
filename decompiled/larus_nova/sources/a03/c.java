package a03;

import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;

/* JADX INFO: loaded from: classes12.dex */
public class c implements ILivePlatformPlayerManagerAdapter {
    public c() {
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public ILivePlatformPlayerProxy curRoomPlayer() {
        return LivePlatformPlayerManager.b();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public ILivePlayerClient getCurrentClient() {
        return LivePlatformPlayerManager.f();
    }

    @Override // com.bytedance.android.live.player.ILivePlatformPlayerManagerAdapter
    public View getCurrentLivePlayerParent() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        Object r101 = null;
        if (r100 == null) goto L9;
        IRenderView r102 = r100.getRenderView();
        if (r102 == null) goto L9;
        ViewParent r103 = r102.getParent();
        if (r103 == null) goto L9;
        ViewParent r104 = r103.getParent();
    L11:
        if ((r104 instanceof View) == false) goto L15;
        r101 = r104;
    L15:
        return (View) r101;
    L9:
        r104 = null;
        goto L11
    }
}
