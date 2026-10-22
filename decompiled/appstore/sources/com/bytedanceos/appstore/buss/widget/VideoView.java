package com.bytedanceos.appstore.buss.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.bytedanceos.common.toolbox.e0;
import com.obric.appstore.R;
import com.stone.playersdk.IPlayer;
import com.stone.playersdk.PlayerType;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x7.l1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0003-04B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\fJ'\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\n¢\u0006\u0004\b\"\u0010\fJ\r\u0010#\u001a\u00020\n¢\u0006\u0004\b#\u0010\fJ\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\fJ\u0019\u0010'\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010\fJ\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010\fJ\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\fR\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0018\u00010;R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010\u0014R\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010L\u001a\b\u0018\u00010IR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010GR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u00101R\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010GR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010d¨\u0006f"}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/VideoView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "", "A", "()V", "H", "", "mutePlay", "J", "(Z)V", "G", "s", "I", "K", "", "playType", "B", "(Ljava/lang/String;)V", "C", "url", SlardarSettingsConsts.SETTING_IMAGE, "pageTitle", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "u", "()Ljava/lang/Boolean;", "z", FixCard.FixStyle.KEY_Y, "r", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "F", "q", FixCard.FixStyle.KEY_X, "Lcom/stone/playersdk/a;", "a", "Lcom/stone/playersdk/a;", "mPlayer", "b", "Ljava/lang/String;", "mUrl", "Landroid/view/Surface;", "c", "Landroid/view/Surface;", "mSurface", "Ljava/util/Timer;", "d", "Ljava/util/Timer;", "mDismissControlViewTimer", "Lcom/bytedanceos/appstore/buss/widget/VideoView$b;", "e", "Lcom/bytedanceos/appstore/buss/widget/VideoView$b;", "mDismissControlViewTimerTask", "Landroid/media/AudioManager;", "f", "Landroid/media/AudioManager;", "mAudioManager", "", "g", "mSystemMusicVolume", "h", "Z", "mRegistered", "Lcom/bytedanceos/appstore/buss/widget/VideoView$c;", "i", "Lcom/bytedanceos/appstore/buss/widget/VideoView$c;", "mMusicVolumeContentObserver", "j", "mIsMuteEnabled", "", "k", "Ljava/lang/Long;", "mDuration", "l", "mPageTitle", "m", "mWifiTipDialogShowed", "Lx7/l1;", "n", "Lx7/l1;", "binding", "Landroid/os/Handler;", "o", "Landroid/os/Handler;", "mHandler", "Lcom/stone/playersdk/IPlayer$OnPreparedListener;", "p", "Lcom/stone/playersdk/IPlayer$OnPreparedListener;", "mPreparedListener", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "mSurfaceTextureListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VideoView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f9057r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.stone.playersdk.a f9058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f9060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Timer f9061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f9062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioManager f9063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f9066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f9068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9069l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9070m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l1 f9071n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Handler f9072o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final IPlayer.OnPreparedListener f9073p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TextureView.SurfaceTextureListener f9074q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public final class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f9075a;

        public b(VideoView r10) {
            this.f9075a = r10;
        }

        public static /* synthetic */ void a(VideoView r10) {
            b(r10);
        }

        public static final void b(VideoView r10) {
            q.g(r10, "this$0");
            VideoView.e(r10).f25666d.setVisibility(8);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (VideoView.e(this.f9075a).f25666d != null) goto L5;
            return;
        L5:
            if (VideoView.e(this.f9075a).f25666d.getVisibility() != 0) goto L9;
            final VideoView r10 = this.f9075a;
            r10.post(new k(r10));
            return;
        }
    }

    public final class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f9076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoView f9077b;

        public c(VideoView r10, Context r11, Handler r12) {
            q.g(r11, "context");
            this.f9077b = r10;
            super(r12);
            this.f9076a = new WeakReference(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            super.onChange(r10);
            if (((Context) this.f9076a.get()) == null) goto L17;
            AudioManager r11 = VideoView.f(this.f9077b);
            if (r11 == null) goto L7;
            Integer r12 = Integer.valueOf(r11.getStreamVolume(3));
        L8:
            if (r12 != null) goto L10;
            return;
        L10:
            if (r12.intValue() <= 0) goto L13;
            VideoView.l(this.f9077b, false);
        L15:
            VideoView.n(this.f9077b, r12.intValue());
            VideoView r13 = this.f9077b;
            VideoView.o(r13, VideoView.g(r13));
            return;
        L13:
            if (r12.intValue() != 0) goto L15;
            VideoView.l(this.f9077b, true);
            goto L15
        L7:
            r12 = null;
            goto L8
        }
    }

    public static final class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f9078a;

        public d(VideoView r10) {
            this.f9078a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            q.g(r10, "msg");
            if (r10.what != 1) goto L6;
            VideoView.p(this.f9078a);
            return;
        }
    }

    public static final class e implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f9079a;

        public e(VideoView r10) {
            this.f9079a = r10;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture r10, int r11, int r12) {
            q.g(r10, "surface");
            VideoView.m(this.f9079a, new Surface(r10));
            if (VideoView.h(this.f9079a) != null) goto L5;
            VideoView.j(this.f9079a);
            return;
        L5:
            com.stone.playersdk.a r13 = VideoView.h(this.f9079a);
            if (r13 == null) goto L9;
            r13.setSurface(VideoView.i(this.f9079a));
        L9:
            if (com.bytedanceos.common.toolbox.e.I0() == false) goto L13;
            this.f9079a.z();
            VideoView.k(this.f9079a, "auto_play");
            return;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture r10) {
            q.g(r10, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture r10, int r11, int r12) {
            q.g(r10, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture r10) {
            q.g(r10, "surface");
        }
    }

    static {
        f9057r = new a(null);
    }

    public VideoView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f9067j = true;
        this.f9068k = 0L;
        l1 r12 = l1.c(LayoutInflater.from(r10), this, true);
        q.f(r12, "inflate(...)");
        this.f9071n = r12;
        this.f9072o = new d(this);
        this.f9073p = new g(this);
        this.f9074q = new e(this);
    }

    public static final void D(VideoView r10, DialogInterface r11, int r12) {
        q.g(r10, "this$0");
        r11.dismiss();
        r10.z();
        r10.B("manual_play");
        r10.f9070m = true;
    }

    public static final void E(DialogInterface r10, int r11) {
        r10.dismiss();
    }

    public static /* synthetic */ void a(VideoView r10) {
        w(r10);
    }

    public static /* synthetic */ void b(VideoView r10, IPlayer r11) {
        v(r10, r11);
    }

    public static /* synthetic */ void c(VideoView r10, DialogInterface r11, int r12) {
        D(r10, r11, r12);
    }

    public static /* synthetic */ void d(DialogInterface r10, int r11) {
        E(r10, r11);
    }

    public static final /* synthetic */ l1 e(VideoView r10) {
        return r10.f9071n;
    }

    public static final /* synthetic */ AudioManager f(VideoView r10) {
        return r10.f9063f;
    }

    public static final /* synthetic */ boolean g(VideoView r10) {
        return r10.f9067j;
    }

    public static final /* synthetic */ com.stone.playersdk.a h(VideoView r10) {
        return r10.f9058a;
    }

    public static final /* synthetic */ Surface i(VideoView r10) {
        return r10.f9060c;
    }

    public static final /* synthetic */ void j(VideoView r10) {
        r10.s();
    }

    public static final /* synthetic */ void k(VideoView r10, String r11) {
        r10.B(r11);
    }

    public static final /* synthetic */ void l(VideoView r10, boolean r11) {
        r10.f9067j = r11;
    }

    public static final /* synthetic */ void m(VideoView r10, Surface r11) {
        r10.f9060c = r11;
    }

    public static final /* synthetic */ void n(VideoView r10, int r11) {
        r10.f9064g = r11;
    }

    public static final /* synthetic */ void o(VideoView r10, boolean r11) {
        r10.I(r11);
    }

    public static final /* synthetic */ void p(VideoView r10) {
        r10.K();
    }

    public static final void v(final VideoView r10, IPlayer r11) {
        q.g(r10, "this$0");
        com.stone.playersdk.a r12 = r10.f9058a;
        if (r12 == null) goto L5;
        r12.seekTo(0);
    L5:
        com.stone.playersdk.a r13 = r10.f9058a;
        if (r13 == null) goto L8;
        r13.setVolume(0.0f, 0.0f);
    L8:
        com.stone.playersdk.a r14 = r10.f9058a;
        if (r14 == null) goto L11;
        Long r15 = Long.valueOf(r14.getDuration());
    L12:
        r10.f9068k = r15;
        if (com.bytedanceos.common.toolbox.e.I0() == false) goto L19;
        com.stone.playersdk.a r16 = r10.f9058a;
        if (r16 == null) goto L17;
        r16.start();
    L17:
        r10.f9072o.sendEmptyMessage(1);
        r10.postDelayed(new j(r10), 700);
        r10.B("auto_play");
        return;
    L19:
        return;
    L11:
        r15 = null;
        goto L12
    }

    public static final void w(VideoView r10) {
        q.g(r10, "this$0");
        r10.f9071n.f25665c.setVisibility(4);
        r10.f9071n.f25666d.setVisibility(4);
    }

    public final void A() {
        if (this.f9065h == true) goto L6;
        Context r10 = getContext();
        q.f(r10, "getContext(...)");
        c r11 = new c(this, r10, new Handler());
        getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, r11);
        this.f9066i = r11;
        this.f9065h = true;
        return;
    }

    public final void B(String r10) {
        if (this.f9069l != null) goto L5;
        return;
    L5:
        Bundle r11 = new Bundle();
        r11.putString("play_type", r10);
        r11.putString("pages_secnavigation_title", this.f9069l);
        f9.b.b("videoplay_pages_secnavigation", r11);
    }

    public final void C() {
        if (com.bytedanceos.common.toolbox.e.A0(getContext()) == true) goto L6;
        e0.e(R.string.retry_connection);
        return;
    L6:
        AlertDialog.Builder r10 = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.AppStoreDialogTheme));
        r10.setMessage(getResources().getString(R.string.tips_not_wifi));
        r10.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new h(this));
        r10.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new i());
        r10.create().show();
    }

    public final void F() {
        q();
        this.f9061d = new Timer();
        b r10 = new b(this);
        this.f9062e = r10;
        Timer r11 = this.f9061d;
        if (r11 == null) goto L6;
        r11.schedule(r10, PerfConsts.DEFAULT_BLOCK_INTERVAL_MS);
        return;
    }

    public final void G() {
        boolean r10 = !this.f9067j;
        this.f9067j = r10;
        I(r10);
    }

    public final void H() {
        if (this.f9065h == false) goto L9;
        c r10 = this.f9066i;
        if (r10 == null) goto L7;
        getContext().getContentResolver().unregisterContentObserver(r10);
    L7:
        this.f9066i = null;
        this.f9065h = false;
        return;
    }

    public final void I(boolean r10) {
        AudioManager r11 = this.f9063f;
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.getStreamVolume(3));
    L6:
        q.d(r12);
        int r13 = r12.intValue();
        if (r13 == 0) goto L22;
        this.f9064g = r13;
    L22:
        com.stone.playersdk.a r14 = this.f9058a;     // Catch: IllegalStateException -> L16
        if (r14 != null) goto L12;
    L18:
        J(r10);     // Catch: IllegalStateException -> L16
        return;
    L12:
        if (r10 == false) goto L14;
        float r15 = 0.0f;
    L15:
        r14.setVolume(r15, 0.0f);     // Catch: IllegalStateException -> L16
        goto L18
    L14:
        r15 = this.f9064g;     // Catch: IllegalStateException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void J(boolean r10) {
        ImageView r11 = this.f9071n.f25667e;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = R.drawable.jz_mute;
    L7:
        r11.setImageResource(r12);
        return;
    L6:
        r12 = R.drawable.jz_unmute;
        goto L7
    }

    public final void K() {
        com.stone.playersdk.a r10 = this.f9058a;
        Boolean r11 = null;
        if (r10 == null) goto L8;
        if (r10 == null) goto L6;
        Long r12 = Long.valueOf(r10.getCurrentPosition());
    L7:
        ProgressBar r13 = this.f9071n.f25664b;
        q.d(r12);
        float r14 = (((long) 100) * r12.longValue()) * 1.0f;
        Long r15 = this.f9068k;
        q.d(r15);
        r13.setProgress((int) (r14 / r15.longValue()));
        goto L8
    L6:
        r12 = null;
    L8:
        com.stone.playersdk.a r16 = this.f9058a;
        if (r16 == null) goto L11;
        r11 = Boolean.valueOf(r16.isPlaying());
    L11:
        q.d(r11);
        if (r11.booleanValue() == false) goto L14;
        this.f9072o.sendEmptyMessageDelayed(1, 1000);
        return;
    L14:
        this.f9072o.removeMessages(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        q.d(r10);
        int r11 = r10.getId();
        Boolean r12 = null;
        if (r11 != R.id.iv_start) goto L5;
        com.stone.playersdk.a r13 = this.f9058a;
        if (r13 == null) goto L23;
        r12 = Boolean.valueOf(r13.isPlaying());
    L23:
        q.d(r12);
        if (r12.booleanValue() == false) goto L30;
        com.stone.playersdk.a r14 = this.f9058a;
        if (r14 == null) goto L28;
        r14.pause();
    L28:
        this.f9071n.f25666d.setBackgroundResource(R.drawable.lkp_paused_state);
        return;
    L30:
        if (com.bytedanceos.common.toolbox.e.I0() == false) goto L32;
    L34:
        z();
        B("manual_play");
        return;
    L32:
        if (this.f9070m == true) goto L34;
        C();
        return;
    L5:
        if (r11 != R.id.mute_view) goto L7;
        G();
        return;
    L7:
        if (r11 == R.id.surface_container) goto L10;
        return;
    L10:
        if (this.f9071n.f25666d.getVisibility() != 8) goto L18;
        F();
        this.f9071n.f25666d.setVisibility(0);
        com.stone.playersdk.a r15 = this.f9058a;
        if (r15 == null) goto L14;
        r12 = Boolean.valueOf(r15.isPlaying());
    L14:
        q.d(r12);
        if (r12.booleanValue() == false) goto L17;
        this.f9071n.f25666d.setBackgroundResource(R.drawable.lkp_played_state);
        return;
    L17:
        this.f9071n.f25666d.setBackgroundResource(R.drawable.lkp_paused_state);
        return;
    L18:
        q();
        this.f9071n.f25666d.setVisibility(8);
    }

    public final void q() {
        Timer r10 = this.f9061d;
        if (r10 == null) goto L6;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        b r11 = this.f9062e;
        if (r11 == null) goto L11;
        if (r11 == null) goto L12;
        r11.cancel();
        return;
    L12:
        return;
    }

    public final void r() {
        H();
        com.stone.playersdk.a r10 = this.f9058a;
        if (r10 == null) goto L5;
        r10.stop();
    L5:
        com.stone.playersdk.a r11 = this.f9058a;
        if (r11 == null) goto L8;
        r11.release();
    L8:
        this.f9058a = null;
    }

    public final void s() {
        gf.a r10 = new gf.a();
        r10.a(false);
        this.f9058a = new com.stone.playersdk.a(getContext(), PlayerType.MEDIA_PLAYER, r10);
        this.f9059b = p000if.b.b(getContext().getApplicationContext(), this.f9059b);
        com.bytedanceos.common.toolbox.j.a("initPlayer, mUrl:" + this.f9059b);
        Uri r11 = Uri.parse(this.f9059b);
        HashMap r12 = new HashMap();
        r12.put("x-cache-config", "-1/40960/-1");
        com.stone.playersdk.a r13 = this.f9058a;     // Catch: IOException -> L7
        if (r13 == null) goto L9;
        r13.setDataSource(getContext(), r11, r12);     // Catch: IOException -> L7
    L9:
        com.stone.playersdk.a r14 = this.f9058a;
        if (r14 == null) goto L12;
        r14.setSurface(this.f9060c);
    L12:
        com.stone.playersdk.a r15 = this.f9058a;
        if (r15 == null) goto L15;
        r15.setOnPreparedListener(this.f9073p);
    L15:
        com.stone.playersdk.a r16 = this.f9058a;
        if (r16 == null) goto L18;
        r16.prepareAsync();
    L18:
        com.bytedanceos.common.toolbox.j.a("initPlayer, after prepareAsync");
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public final void t(String r10, String r11, String r12) {
        q.g(r10, "url");
        q.g(r11, SlardarSettingsConsts.SETTING_IMAGE);
        this.f9069l = r12;
        this.f9059b = r10;
        ImageView r13 = this.f9071n.f25665c;
        q.f(r13, "imgView");
        ImageUtilKt.h(r13, r11, getContext().getResources().getDimensionPixelOffset(R.dimen.lkp_video_radius));
        this.f9071n.f25669g.setSurfaceTextureListener(this.f9074q);
        this.f9071n.f25669g.setOutlineProvider(new f(getContext().getResources().getDimensionPixelOffset(R.dimen.lkp_video_radius)));
        this.f9071n.f25669g.setClipToOutline(true);
        this.f9071n.f25668f.setOnClickListener(this);
        this.f9071n.f25666d.setOnClickListener(this);
        this.f9071n.f25667e.setOnClickListener(this);
        Object r14 = getContext().getSystemService("audio");
        q.e(r14, "null cannot be cast to non-null type android.media.AudioManager");
        this.f9063f = (AudioManager) r14;
        A();
    }

    public final Boolean u() {
        com.stone.playersdk.a r10 = this.f9058a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r10.isPlaying());
    }

    public final void x() {
        r();
        this.f9072o.removeCallbacksAndMessages(null);
    }

    public final void y() {
        com.stone.playersdk.a r10 = this.f9058a;
        if (r10 == null) goto L5;
        r10.pause();
    L5:
        this.f9071n.f25665c.setVisibility(0);
        this.f9071n.f25666d.setBackgroundResource(R.drawable.lkp_paused_state);
    }

    public final void z() {
        com.stone.playersdk.a r10 = this.f9058a;
        if (r10 == null) goto L5;
        r10.start();
    L5:
        this.f9072o.sendEmptyMessage(1);
        this.f9071n.f25665c.setVisibility(4);
        this.f9071n.f25666d.setBackgroundResource(R.drawable.lkp_played_state);
    }

    public VideoView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }
}
