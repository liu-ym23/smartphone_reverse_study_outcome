package tb;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends tb.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaPlayer f24771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MediaMetadataRetriever f24772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f24773g;

    public static final class a implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f24774a;

        public a(b r10) {
            this.f24774a = r10;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r10) {
            IMediaPlayer.OnCompletionListener r11 = this.f24774a.a();
            if (r11 == null) goto L6;
            r11.onCompletion();
            return;
        }
    }

    /* JADX INFO: renamed from: tb.b$b, reason: collision with other inner class name */
    public static final class C0383b implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f24775a;

        public C0383b(b r10) {
            this.f24775a = r10;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r10) {
            IMediaPlayer.OnPreparedListener r11 = this.f24775a.d();
            if (r11 == null) goto L6;
            r11.onPrepared();
            return;
        }
    }

    public static final class c implements MediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f24776a;

        public c(b r10) {
            this.f24776a = r10;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r10, int r11, int r12) {
            IMediaPlayer.OnErrorListener r13 = this.f24776a.b();
            if (r13 == null) goto L7;
            r13.onError(r11, r12, "");
            return false;
        L7:
            return false;
        }
    }

    public static final class d implements MediaPlayer.OnInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f24777a;

        public d(b r10) {
            this.f24777a = r10;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer r10, int r11, int r12) {
            if (r11 != 3) goto L9;
            IMediaPlayer.OnFirstFrameListener r13 = this.f24777a.c();
            if (r13 == null) goto L10;
            r13.onFirstFrame();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public b() {
        super(null, 1, null);
        this.f24772f = new MediaMetadataRetriever();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public String getPlayerType() {
        return "DefaultSystemPlayer";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public sb.c getVideoInfo() {
        String r10 = this.f24773g;
        if (r10 != null) goto L6;
        q.y("dataPath");
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L19;
        MediaMetadataRetriever r11 = this.f24772f;
        String r12 = this.f24773g;
        if (r12 != null) goto L10;
        q.y("dataPath");
    L10:
        r11.setDataSource(r12);
        String r13 = this.f24772f.extractMetadata(18);
        String r14 = this.f24772f.extractMetadata(19);
        if (TextUtils.isEmpty(r13) == true) goto L17;
        if (TextUtils.isEmpty(r14) == true) goto L17;
        String r15 = this.f24772f.extractMetadata(18);
        q.d(r15);
        q.f(r15, "retriever.extractMetadat…TADATA_KEY_VIDEO_WIDTH)!!");
        int r16 = Integer.parseInt(r15);
        String r17 = this.f24772f.extractMetadata(19);
        q.d(r17);
        q.f(r17, "retriever.extractMetadat…ADATA_KEY_VIDEO_HEIGHT)!!");
        return new sb.c(r16, Integer.parseInt(r17));
    L17:
        throw new Exception("DefaultSystemPlayer get metadata failure!");
    L19:
        throw new Exception("dataPath is null, please set setDataSource firstly!");
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void initMediaPlayer() {
        MediaPlayer r10 = new MediaPlayer();
        this.f24771e = r10;
        r10.setOnCompletionListener(new a(this));
        MediaPlayer r11 = this.f24771e;
        if (r11 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r11.setOnPreparedListener(new C0383b(this));
        MediaPlayer r12 = this.f24771e;
        if (r12 != null) goto L8;
        q.y("mediaPlayer");
    L8:
        r12.setOnErrorListener(new c(this));
        MediaPlayer r13 = this.f24771e;
        if (r13 != null) goto L11;
        q.y("mediaPlayer");
    L11:
        r13.setOnInfoListener(new d(this));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void pause() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.pause();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void prepareAsync() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.prepareAsync();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void release() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.release();
        this.f24773g = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void reset() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.reset();
        this.f24773g = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setDataSource(String r10) {
        q.g(r10, "dataPath");
        this.f24773g = r10;
        MediaPlayer r11 = this.f24771e;
        if (r11 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r11.setDataSource(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setLooping(boolean r10) {
        MediaPlayer r11 = this.f24771e;
        if (r11 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r11.setLooping(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean r10) {
        MediaPlayer r11 = this.f24771e;
        if (r11 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r11.setScreenOnWhilePlaying(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setSurface(Surface r10) {
        q.g(r10, "surface");
        MediaPlayer r11 = this.f24771e;
        if (r11 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r11.setSurface(r10);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void start() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.start();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void stop() {
        MediaPlayer r10 = this.f24771e;
        if (r10 != null) goto L5;
        q.y("mediaPlayer");
    L5:
        r10.stop();
    }
}
