package rb;

import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IMediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f23849a;

    public d(a r10) {
        this.f23849a = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer.OnPreparedListener
    public void onPrepared() {
        a r10 = this.f23849a;
        a.f(r10, a.d(r10, 3, null));
    }
}
