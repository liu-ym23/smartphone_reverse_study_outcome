package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSystemPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f32518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaMetadataRetriever f32520c;

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public String m() {
        return "DefaultSystemPlayer";
    }

    public b() {
        super(null, 1, null);
        this.f32520c = new MediaMetadataRetriever();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void e() {
        MediaPlayer r0 = new MediaPlayer();
        this.f32518a = r0;
        if (r0 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r0.setOnCompletionListener((MediaPlayer.OnCompletionListener) ZeusTransformUtils.preCheckCast(new DefaultSystemPlayer$initMediaPlayer$1(this), MediaPlayer.OnCompletionListener.class, "com.obric.aiagent.plugin"));
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L8;
        o.c("mediaPlayer");
    L8:
        r1.setOnPreparedListener((MediaPlayer.OnPreparedListener) ZeusTransformUtils.preCheckCast(new DefaultSystemPlayer$initMediaPlayer$2(this), MediaPlayer.OnPreparedListener.class, "com.obric.aiagent.plugin"));
        MediaPlayer r2 = this.f32518a;
        if (r2 != null) goto L11;
        o.c("mediaPlayer");
    L11:
        r2.setOnErrorListener((MediaPlayer.OnErrorListener) ZeusTransformUtils.preCheckCast(new DefaultSystemPlayer$initMediaPlayer$3(this), MediaPlayer.OnErrorListener.class, "com.obric.aiagent.plugin"));
        MediaPlayer r3 = this.f32518a;
        if (r3 != null) goto L14;
        o.c("mediaPlayer");
    L14:
        r3.setOnInfoListener((MediaPlayer.OnInfoListener) ZeusTransformUtils.preCheckCast(new DefaultSystemPlayer$initMediaPlayer$4(this), MediaPlayer.OnInfoListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(Surface r2) {
        o.e(r2, "surface");
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r1.setSurface(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(String r2) {
        o.e(r2, "dataPath");
        this.f32519b = r2;
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r1.setDataSource(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void f() {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r1.prepareAsync();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void g() {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        a(r1);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void h() {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        b(r1);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void i() {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        c(r1);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void j() {
        MediaPlayer r0 = this.f32518a;
        if (r0 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r0.reset();
        this.f32519b = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void k() {
        MediaPlayer r0 = this.f32518a;
        if (r0 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r0.release();
        this.f32519b = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(boolean r2) {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r1.setLooping(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void b(boolean r2) {
        MediaPlayer r1 = this.f32518a;
        if (r1 != null) goto L5;
        o.c("mediaPlayer");
    L5:
        r1.setScreenOnWhilePlaying(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public e l() {
        String r0 = this.f32519b;
        if (r0 != null) goto L6;
        o.c("dataPath");
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L19;
        MediaMetadataRetriever r1 = this.f32520c;
        String r2 = this.f32519b;
        if (r2 != null) goto L10;
        o.c("dataPath");
    L10:
        r1.setDataSource(r2);
        String r3 = this.f32520c.extractMetadata(18);
        String r4 = this.f32520c.extractMetadata(19);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        String r5 = this.f32520c.extractMetadata(18);
        o.a(r5);
        o.c(r5, "retriever.extractMetadat…TADATA_KEY_VIDEO_WIDTH)!!");
        int r6 = Integer.parseInt(r5);
        String r7 = this.f32520c.extractMetadata(19);
        o.a(r7);
        o.c(r7, "retriever.extractMetadat…ADATA_KEY_VIDEO_HEIGHT)!!");
        return new e(r6, Integer.parseInt(r7));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new Exception("DefaultSystemPlayer get metadata failure!"), Throwable.class, "com.obric.aiagent.plugin"));
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new Exception("dataPath is null, please set setDataSource firstly!"), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public static void a(MediaPlayer r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.start();
        return;
    L6:
        r1.start();
        if (ZeusTransformUtils.instanceOf(r1, MediaPlayer.class) == false) goto L10;
        com.obric.performance.power.monitor.a.a.a(r1.hashCode());
        return;
    }

    public static void b(MediaPlayer r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.pause();
        return;
    L6:
        r1.pause();
        if (ZeusTransformUtils.instanceOf(r1, MediaPlayer.class) == false) goto L10;
        com.obric.performance.power.monitor.a.a.b(r1.hashCode());
        return;
    }

    public static void c(MediaPlayer r1) {
        if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
        r1.stop();
        return;
    L6:
        r1.stop();
        if (ZeusTransformUtils.instanceOf(r1, MediaPlayer.class) == false) goto L10;
        com.obric.performance.power.monitor.a.a.b(r1.hashCode());
        return;
    }
}
