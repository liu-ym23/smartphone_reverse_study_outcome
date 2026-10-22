package rb;

import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IMediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f23848a;

    public c(a r10) {
        this.f23848a = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer.OnErrorListener
    public void onError(int r10, int r11, String r12) {
        q.g(r12, "desc");
        a.e(this.f23848a, false, r10, r11, "mediaPlayer error, info: " + r12);
        a.a(this.f23848a);
    }
}
