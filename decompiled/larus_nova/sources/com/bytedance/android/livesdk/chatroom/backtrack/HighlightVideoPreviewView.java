package com.bytedance.android.livesdk.chatroom.backtrack;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.record.x;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import zf1.h;
import zf1.i;

/* JADX INFO: loaded from: classes7.dex */
public class HighlightVideoPreviewView extends RelativeLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f105116v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureView f105117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f105118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f105119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f105120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f105121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SeekBar f105122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaPlayer f105123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f105124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f105125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f105126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f105127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f105128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f105129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f105130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f105131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f105132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f105133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final WeakHandler f105134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a f105135s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f105136t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f105137u;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightVideoPreviewView f105138a;

        public final void a() {
            MediaPlayer r100 = this.f105138a.f105123g;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isPlaying() == false) goto L9;
            HighlightVideoPreviewView r101 = this.f105138a;
            r101.a(r101.f105123g.getCurrentPosition());
            HighlightVideoPreviewView r102 = this.f105138a;
            r102.f105122f.setProgress(Math.round(((r102.f105123g.getCurrentPosition() * 1.0f) / this.f105138a.f105130n) * 100.0f));
            this.f105138a.f105134r.postDelayed(this, 1000);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(HighlightVideoPreviewView r100) {
            this.f105138a = r100;
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightVideoPreviewView f105139a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        }

        public b(HighlightVideoPreviewView r100) {
            this.f105139a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            this.f105139a.c();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            HighlightVideoPreviewView r101 = this.f105139a;
            int r102 = HighlightVideoPreviewView.f105116v;
            r101.e();
            this.f105139a.d();
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightVideoPreviewView f105140a;

        public c(HighlightVideoPreviewView r100) {
            this.f105140a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HighlightVideoPreviewView r101 = this.f105140a;
            if (r101.f105136t != 2) goto L5;
            return;
        L5:
            MediaPlayer r102 = r101.f105123g;
            if (r102 != null) goto L8;
            return;
        L8:
            if (r101.f105129m == true) goto L11;
            return;
        L11:
            if (r102.isPlaying() == false) goto L13;
            this.f105140a.c();
            return;
        L13:
            this.f105140a.d();
        }
    }

    public class d implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightVideoPreviewView f105141a;

        public class a implements MediaPlayer.OnCompletionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105142a;

            public a(d r100) {
                this.f105142a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer r100) {
                if (r100 != null) goto L4;
                return;
            L4:
                HighlightVideoPreviewView r101 = this.f105142a.f105141a;
                if (r101.f105127k == false) goto L7;
                r101.d();
                return;
            L7:
                r101.a(r101.f105130n);
                this.f105142a.f105141a.f105122f.setProgress(100);
                this.f105142a.f105141a.f105118b.setVisibility(0);
            }
        }

        public class b implements MediaPlayer.OnPreparedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105143a;

            public b(d r100) {
                this.f105143a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer r100) {
                if (r100 != null) goto L4;
                return;
            L4:
                HighlightVideoPreviewView r101 = this.f105143a.f105141a;
                r101.f105129m = true;
                r101.f105130n = r100.getDuration();
                HighlightVideoPreviewView r102 = this.f105143a.f105141a;
                int r103 = r102.f105123g.getVideoWidth();
                int r104 = r102.f105123g.getVideoHeight();
                if (r103 <= 0) goto L7;
                float r105 = r104 / r103;
            L8:
                int r106 = (int) (r102.f105117a.getWidth() * r105);
                ViewGroup.LayoutParams r107 = r102.f105117a.getLayoutParams();
                r107.height = r106;
                r102.f105117a.setLayoutParams(r107);
                HighlightVideoPreviewView r108 = this.f105143a.f105141a;
                if (r108.f105132p == false) goto L11;
                r108.d();
            L11:
                this.f105143a.f105141a.getClass();
                return;
            L7:
                r105 = 1.0f;
                goto L8
            }
        }

        public class c implements MediaPlayer.OnErrorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105144a;

            public c(d r100) {
                this.f105144a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer r100, int r101, int r102) {
                if (r100 == null) goto L4;
                r100.release();
            L4:
                f2.b(R.string.ttlive_live_record_video_play_failed, 0);
                this.f105144a.f105141a.f105118b.setVisibility(0);
                this.f105144a.f105141a.getClass();
                return false;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        }

        public d(HighlightVideoPreviewView r100) {
            this.f105141a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            MediaPlayer r101 = this.f105141a.f105123g;
            if (r101 == null) goto L7;
            r101.stop();
            return true;
        L7:
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            HighlightVideoPreviewView r103 = this.f105141a;
            if (r103.f105131o != null) goto L5;
            return;
        L5:
            MediaPlayer r104 = r103.f105123g;
            if (r104 != null) goto L8;
            r103.f105123g = x.b(r103.getContext());
        L12:
            this.f105141a.f105123g.setSurface(new Surface(r100));
            this.f105141a.f105123g.setIntOption(36, 1);     // Catch: IOException -> L22
            this.f105141a.f105123g.setOnCompletionListener(new a(this));     // Catch: IOException -> L22
            this.f105141a.f105123g.setOnPreparedListener(new b(this));     // Catch: IOException -> L22
            this.f105141a.f105123g.setOnErrorListener(new c(this));     // Catch: IOException -> L22
            if (TextUtils.isEmpty(this.f105141a.f105131o.f105145a) == true) goto L16;
            this.f105141a.f105131o.getClass();     // Catch: IOException -> L22
            HighlightVideoPreviewView r105 = this.f105141a;     // Catch: IOException -> L22
            r105.f105123g.setDataSource(r105.getContext(), UriProtector.parse(this.f105141a.f105131o.f105145a));     // Catch: IOException -> L22
            this.f105141a.f105123g.prepareAsync();     // Catch: IOException -> L22
        L16:
            HighlightVideoPreviewView r106 = this.f105141a;     // Catch: IOException -> L22
            if (r106.f105136t != 2) goto L19;
            r106.f105118b.setVisibility(8);     // Catch: IOException -> L22
        L20:
            r106.f105119c.setText("");     // Catch: IOException -> L22
            return;
        L19:
            r106.f105118b.setVisibility(0);     // Catch: IOException -> L22
        L22:
            this.f105141a.f105123g = null;
            f2.b(R.string.ttlive_live_record_video_play_failed, 0);
            return;
        L8:
            if (r103.f105133q == false) goto L10;
            r104.reset();
            goto L12
        L10:
            r103.c();
            goto L12
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f105145a;

        public e(String r100) {
            this.f105145a = r100;
        }
    }

    public final void c() {
        if (this.f105123g.isPlaying() == true) goto L5;
        return;
    L5:
        this.f105123g.pause();
        this.f105118b.setVisibility(0);
    }

    public final void d() {
        this.f105123g.start();
        this.f105118b.setVisibility(8);
        this.f105134r.removeCallbacks(this.f105135s);
        this.f105134r.post(this.f105135s);
    }

    public final void e() {
        int r100 = Math.round(this.f105130n * ((this.f105122f.getProgress() * 1.0f) / 100.0f));
        this.f105123g.seekTo(r100);
        a(r100);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_highlight_preview, this, true);
        this.f105117a = (TextureView) findViewById(R.id.video);
        this.f105118b = findViewById(R.id.video_player_btn);
        this.f105119c = (TextView) findViewById(R.id.video_time);
        this.f105122f = (SeekBar) findViewById(R.id.seek_bar);
        this.f105120d = (TextView) findViewById(R.id.preview_main_title);
        this.f105121e = (TextView) findViewById(R.id.preview_sub_title);
        this.f105122f.setOnSeekBarChangeListener(new b(this));
        this.f105117a.setOnClickListener(new c(this));
        this.f105117a.setSurfaceTextureListener(new d(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MediaPlayer r100 = this.f105123g;
        if (r100 == null) goto L5;
        r100.stop();
        this.f105123g.release();
        this.f105123g = null;
    L5:
        this.f105134r.removeCallbacks(this.f105135s);
    }

    public HighlightVideoPreviewView(Context r100) {
        super(r100);
        this.f105124h = 0.0f;
        this.f105125i = 0.0f;
        this.f105126j = true;
        this.f105127k = true;
        this.f105128l = 0;
        this.f105129m = false;
        this.f105130n = 0;
        this.f105132p = true;
        this.f105133q = true;
        this.f105134r = new WeakHandler(new i());
        this.f105135s = new a(this);
        this.f105136t = 1;
        this.f105137u = false;
        b();
    }

    public final void a(int r100) {
        String r101 = p6.a(((long) r100) / 1000);
        String r102 = p6.a(((long) this.f105130n) / 1000);
        TextView r103 = this.f105119c;
        if (r103 == null) goto L6;
        r103.setText(r101 + HTTP.URL_DEFAULT + r102);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f105126j == false) goto L5;
        SeekBar r100 = this.f105122f;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        if (new RectF(r102, r101[1] - 20, r102 + r100.getWidth(), (r101[1] + r100.getHeight()) + 20).contains(r110.getRawX(), r110.getRawY()) == true) goto L9;
        this.f105137u = false;
        float r103 = r110.getY() - this.f105124h;
        float r104 = r110.getX() - this.f105125i;
        this.f105125i = r110.getX();
        this.f105124h = r110.getY();
        float r105 = Math.abs(r104);
        float r106 = Math.abs(r103);
        if (r105 <= r106) goto L17;
        if ((r105 - r106) < 20.0f) goto L17;
        this.f105137u = this.f105123g.isPlaying();
        c();
        this.f105128l = this.f105122f.getProgress();
        return true;
    L17:
        return super.onInterceptTouchEvent(r110);
    L9:
        return super.onInterceptTouchEvent(r110);
    L5:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f105126j == false) goto L5;
        int r101 = r100.getAction();
        if (r101 != 1) goto L9;
        this.f105125i = 0.0f;
        this.f105124h = 0.0f;
        if (this.f105122f.getProgress() != this.f105128l) goto L15;
        performClick();
    L18:
        return true;
    L15:
        e();
        if (this.f105137u == false) goto L18;
        d();
        goto L18
    L9:
        if (r101 != 2) goto L18;
        int r102 = getWidth();
        float r103 = r100.getX() - this.f105125i;
        this.f105125i = r100.getX();
        this.f105124h = r100.getY();
        SeekBar r104 = this.f105122f;
        r104.setProgress(Math.round(r104.getProgress() + ((r103 / r102) * 100.0f)));
        goto L18
    L5:
        return super.onTouchEvent(r100);
    }

    public void setPreviewData(h r100) {
        this.f105131o = new e(r100.f571659c);
        this.f105120d.setText(r100.f571657a);
        this.f105121e.setText(r100.f571658b);
    }

    public HighlightVideoPreviewView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f105124h = 0.0f;
        this.f105125i = 0.0f;
        this.f105126j = true;
        this.f105127k = true;
        this.f105128l = 0;
        this.f105129m = false;
        this.f105130n = 0;
        this.f105132p = true;
        this.f105133q = true;
        this.f105134r = new WeakHandler(new i());
        this.f105135s = new a(this);
        this.f105136t = 1;
        this.f105137u = false;
        b();
    }

    public HighlightVideoPreviewView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f105124h = 0.0f;
        this.f105125i = 0.0f;
        this.f105126j = true;
        this.f105127k = true;
        this.f105128l = 0;
        this.f105129m = false;
        this.f105130n = 0;
        this.f105132p = true;
        this.f105133q = true;
        this.f105134r = new WeakHandler(new i());
        this.f105135s = new a(this);
        this.f105136t = 1;
        this.f105137u = false;
        b();
    }
}
