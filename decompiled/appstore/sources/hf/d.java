package hf;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.stone.playersdk.IPlayer;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d implements IPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPlayer.OnPreparedListener f20458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IPlayer.OnVideoSizeChangedListener f20459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IPlayer.OnErrorListener f20460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer.OnLocalProxyCacheListener f20461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p000if.a f20462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f20463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f20464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f20465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n0.a f20467j;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20468a;

        public a(d r10) {
            this.f20468a = r10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r10) {
            return true;
        }
    }

    public d(Context r10, gf.a r11) {
        this.f20466i = false;
        this.f20467j = new n0.a(new a(this));
        this.f20463f = r10;
        if (r11 == null) goto L6;
        this.f20466i = r11.b();
    L6:
        if (this.f20466i == false) goto L9;
        this.f20462e = new p000if.a(this);
        return;
    }

    public void a(int r10, String r11) {
        IPlayer.OnErrorListener r12 = this.f20460c;
        if (r12 == null) goto L6;
        r12.onError(this, r10, r11);
        return;
    }

    public void b() {
        IPlayer.OnPreparedListener r10 = this.f20458a;
        if (r10 == null) goto L6;
        r10.onPrepared(this);
        return;
    }

    public void c(int r10, int r11, int r12, float r13, float r14) {
        IPlayer.OnVideoSizeChangedListener r15 = this.f20459b;
        if (r15 == null) goto L6;
        r15.onVideoSizeChanged(this, r10, r11, r12, r13, r14);
        return;
    }

    public void d() {
        IPlayer.OnLocalProxyCacheListener r10 = this.f20461d;
        if (r10 == null) goto L6;
        r10.onCacheFinished(this);
        return;
    }

    public void e(String r10) {
        IPlayer.OnLocalProxyCacheListener r11 = this.f20461d;
        if (r11 == null) goto L6;
        r11.onCacheForbidden(this, r10);
        return;
    }

    public void f(int r10, long r11) {
        IPlayer.OnLocalProxyCacheListener r12 = this.f20461d;
        if (r12 == null) goto L6;
        r12.onCacheProgressChanged(this, r10, r11);
        return;
    }

    public void g(String r10) {
        IPlayer.OnLocalProxyCacheListener r11 = this.f20461d;
        if (r11 == null) goto L6;
        r11.onCacheReady(this, r10);
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public long getCurrentPosition() {
        return 0;
    }

    @Override // com.stone.playersdk.IPlayer
    public long getDuration() {
        return 0;
    }

    public void h(float r10) {
        IPlayer.OnLocalProxyCacheListener r11 = this.f20461d;
        if (r11 == null) goto L6;
        r11.onCacheSpeedChanged(this, r10);
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.stone.playersdk.IPlayer
    public void pause() {
        if (this.f20466i == false) goto L8;
        p000if.a r10 = this.f20462e;
        if (r10 == null) goto L9;
        r10.k();
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void prepareAsync() {
    }

    @Override // com.stone.playersdk.IPlayer
    public void release() {
        if (this.f20466i == false) goto L8;
        p000if.a r10 = this.f20462e;
        if (r10 == null) goto L9;
        r10.l();
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void seekTo(long r10) {
        if (this.f20466i == false) goto L8;
        p000if.a r11 = this.f20462e;
        if (r11 == null) goto L9;
        r11.m(r10);
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener r10) {
        this.f20460c = r10;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnLocalProxyCacheListener(IPlayer.OnLocalProxyCacheListener r10) {
        this.f20461d = r10;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener r10) {
        this.f20458a = r10;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener r10) {
        this.f20459b = r10;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setOriginUrl(String r10) {
        this.f20465h = r10;
        if (this.f20466i == false) goto L8;
        p000if.a r11 = this.f20462e;
        if (r11 == null) goto L9;
        r11.r(r10);
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void setSpeed(float r10) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setSurface(Surface r10) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setVolume(float r10, float r11) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void start() {
        if (this.f20466i == false) goto L8;
        p000if.a r10 = this.f20462e;
        if (r10 == null) goto L9;
        r10.n();
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void startLocalProxy(String r10, HashMap r11) {
        if (this.f20466i == false) goto L8;
        p000if.a r12 = this.f20462e;
        if (r12 == null) goto L9;
        r12.s(r10, r11);
        return;
    L9:
        return;
    }

    @Override // com.stone.playersdk.IPlayer
    public void stop() {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(String r10) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11, Map r12) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10) {
    }

    @Override // com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10, long r11, long r12) {
    }
}
