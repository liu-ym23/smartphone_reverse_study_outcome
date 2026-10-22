package com.bytedance.android.livesdk.chatroom.backtrack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.end.LandscapeFullPlayVideoActivity;
import com.bytedance.android.livesdk.chatroom.record.x;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import zf1.g0;

/* JADX INFO: loaded from: classes7.dex */
public class LiveVideoPreviewView extends ConstraintLayout {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceView f105160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f105161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f105162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f105163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f105164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f105165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SeekBar f105166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaPlayer f105167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f105168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f105169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f105170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f105171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f105172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f105173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f105174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f105175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f105176q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public e f105177r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f105178s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View.OnClickListener f105179t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LandscapeFullPlayVideoActivity.e f105180u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f105181v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WeakHandler f105182w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f105183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f105184y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f105185z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105186a;

        public final void a() {
            MediaPlayer r100 = this.f105186a.f105167h;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isPlaying() == false) goto L9;
            LiveVideoPreviewView r101 = this.f105186a;
            r101.R5(r101.f105167h.getCurrentPosition());
            LiveVideoPreviewView r102 = this.f105186a;
            r102.f105166g.setProgress(Math.round(((r102.f105167h.getCurrentPosition() * 1.0f) / this.f105186a.f105176q) * 100.0f));
            this.f105186a.f105182w.postDelayed(this, 1000);
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

        public a(LiveVideoPreviewView r100) {
            this.f105186a = r100;
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105187a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        }

        public b(LiveVideoPreviewView r100) {
            this.f105187a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            this.f105187a.T5();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            LiveVideoPreviewView r101 = this.f105187a;
            int r102 = LiveVideoPreviewView.A;
            r101.V5();
            this.f105187a.U5();
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105188a;

        public c(LiveVideoPreviewView r100) {
            this.f105188a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveVideoPreviewView r101 = this.f105188a;
            if (r101.f105184y != 2) goto L5;
            return;
        L5:
            MediaPlayer r102 = r101.f105167h;
            if (r102 != null) goto L8;
            return;
        L8:
            if (r101.f105174o == true) goto L11;
            return;
        L11:
            if (r102.isPlaying() == false) goto L16;
            View.OnClickListener r103 = this.f105188a.f105179t;
            if (r103 == null) goto L15;
            r103.onClick(r100);
        L15:
            this.f105188a.T5();
            return;
        L16:
            this.f105188a.f105164e.setVisibility(8);
            this.f105188a.U5();
        }
    }

    public class d implements SurfaceHolder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveVideoPreviewView f105189a;

        public class a implements MediaPlayer.OnCompletionListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105190a;

            public a(d r100) {
                this.f105190a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer r100) {
                if (r100 != null) goto L4;
                return;
            L4:
                LiveVideoPreviewView r101 = this.f105190a.f105189a;
                if (r101.f105171l == false) goto L7;
                r101.U5();
                return;
            L7:
                r101.R5(r101.f105176q);
                this.f105190a.f105189a.f105166g.setProgress(100);
                this.f105190a.f105189a.f105162c.setVisibility(0);
            }
        }

        public class b implements MediaPlayer.OnPreparedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105191a;

            public b(d r100) {
                this.f105191a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer r100) {
                if (r100 != null) goto L4;
                return;
            L4:
                LiveVideoPreviewView r101 = this.f105191a.f105189a;
                r101.f105174o = true;
                r101.f105176q = r100.getDuration();
                LiveVideoPreviewView r102 = this.f105191a.f105189a;
                if (r102.f105172m == false) goto L7;
                r102.R5(0);
            L7:
                LiveVideoPreviewView r103 = this.f105191a.f105189a;
                if (r103.f105178s == false) goto L10;
                r103.U5();
            L10:
                LandscapeFullPlayVideoActivity.e r104 = this.f105191a.f105189a.f105180u;
                if (r104 == null) goto L18;
                int r105 = r104.f105896a;
                if (r105 <= 0) goto L19;
                MediaPlayer r106 = r104.f105897b.f105167h;
                if (r106 == null) goto L20;
                r106.seekTo(r105);
                return;
            L20:
                return;
            L19:
                return;
            }
        }

        public class c implements MediaPlayer.OnErrorListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f105192a;

            public c(d r100) {
                this.f105192a = r100;
            }

            @Override // com.ss.ttm.player.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer r100, int r101, int r102) {
                if (r100 == null) goto L4;
                r100.release();
            L4:
                f2.b(R.string.ttlive_live_record_video_play_failed, 0);
                this.f105192a.f105189a.f105162c.setVisibility(0);
                if (this.f105192a.f105189a.f105180u == null) goto L7;
                Intrinsics.checkNotNullParameter(String.valueOf(r101), "reason");
            L7:
                return false;
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r100) {
        }

        public d(LiveVideoPreviewView r100) {
            this.f105189a = r100;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r100) {
            MediaPlayer r101 = this.f105189a.f105167h;
            if (r101 == null) goto L6;
            r101.stop();
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
            if (r100 == null) goto L30;
            LiveVideoPreviewView r104 = this.f105189a;
            if (r104.f105177r == null) goto L31;
            MediaPlayer r105 = r104.f105167h;
            if (r105 != null) goto L9;
            r104.f105167h = x.b(r104.getContext());
        L13:
            this.f105189a.f105167h.setSurface(r100.getSurface());
            this.f105189a.f105167h.setIntOption(36, 1);     // Catch: IOException -> L23
            this.f105189a.f105167h.setOnCompletionListener(new a(this));     // Catch: IOException -> L23
            this.f105189a.f105167h.setOnPreparedListener(new b(this));     // Catch: IOException -> L23
            this.f105189a.f105167h.setOnErrorListener(new c(this));     // Catch: IOException -> L23
            if (TextUtils.isEmpty(this.f105189a.f105177r.f105193a) == true) goto L17;
            this.f105189a.f105177r.getClass();     // Catch: IOException -> L23
            LiveVideoPreviewView r106 = this.f105189a;     // Catch: IOException -> L23
            r106.f105167h.setDataSource(r106.getContext(), UriProtector.parse(this.f105189a.f105177r.f105193a));     // Catch: IOException -> L23
            this.f105189a.f105167h.prepareAsync();     // Catch: IOException -> L23
        L17:
            LiveVideoPreviewView r107 = this.f105189a;     // Catch: IOException -> L23
            if (r107.f105184y != 2) goto L20;
            r107.f105162c.setVisibility(8);     // Catch: IOException -> L23
        L21:
            r107.f105165f.setText("");     // Catch: IOException -> L23
            return;
        L20:
            r107.f105162c.setVisibility(0);     // Catch: IOException -> L23
        L23:
            LiveVideoPreviewView r108 = this.f105189a;
            r108.f105167h = null;
            if (r108.f105180u == null) goto L26;
            Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "reason");
        L26:
            f2.b(R.string.ttlive_live_record_video_play_failed, 0);
            return;
        L9:
            if (r104.f105181v == false) goto L11;
            r105.reset();
            goto L13
        L11:
            r104.T5();
            goto L13
        L31:
            return;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f105193a;

        public e(String r100) {
            this.f105193a = r100;
        }
    }

    public final void T5() {
        if (this.f105167h.isPlaying() == true) goto L5;
        return;
    L5:
        this.f105167h.pause();
        this.f105162c.setVisibility(0);
    }

    public final void U5() {
        this.f105167h.start();
        this.f105162c.setVisibility(8);
        this.f105182w.removeCallbacks(this.f105183x);
        this.f105182w.post(this.f105183x);
    }

    public final void V5() {
        int r100 = Math.round(this.f105176q * ((this.f105166g.getProgress() * 1.0f) / 100.0f));
        this.f105167h.seekTo(r100);
        R5(r100);
    }

    public int getPosition() {
        MediaPlayer r100 = this.f105167h;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentPosition();
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_backtrack_preview, this, true);
        this.f105161b = findViewById(R.id.video_time_layout);
        this.f105160a = (SurfaceView) findViewById(R.id.video);
        this.f105162c = findViewById(R.id.video_player_btn);
        this.f105165f = (TextView) findViewById(R.id.video_time);
        this.f105164e = (ImageView) findViewById(R.id.first_frame);
        this.f105163d = findViewById(R.id.video_background);
        SeekBar r100 = (SeekBar) findViewById(R.id.seek_bar);
        this.f105166g = r100;
        r100.setOnSeekBarChangeListener(new b(this));
        this.f105160a.setOnClickListener(new c(this));
        this.f105160a.getHolder().addCallback(new d(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MediaPlayer r100 = this.f105167h;
        if (r100 == null) goto L6;
        r100.stop();
        this.f105167h.release();
        this.f105167h = null;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public LiveVideoPreviewView(Context r100) {
        super(r100);
        this.f105168i = 0.0f;
        this.f105169j = 0.0f;
        this.f105170k = false;
        this.f105171l = true;
        this.f105172m = false;
        this.f105173n = 0;
        this.f105174o = false;
        this.f105175p = null;
        this.f105176q = 0;
        this.f105178s = false;
        this.f105181v = true;
        this.f105182w = new WeakHandler(new g0());
        this.f105183x = new a(this);
        this.f105184y = 1;
        this.f105185z = false;
        initView();
    }

    public final void R5(int r100) {
        String r101 = p6.a(((long) r100) / 1000);
        String r102 = p6.a(((long) this.f105176q) / 1000);
        TextView r103 = this.f105165f;
        if (r103 == null) goto L6;
        r103.setText(r101 + HTTP.URL_DEFAULT + r102);
        return;
    }

    public final void S5(boolean r100) {
        if (r100 == false) goto L4;
        this.f105166g.setVisibility(0);
        return;
    L4:
        this.f105166g.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.f105170k == false) goto L5;
        SeekBar r100 = this.f105166g;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        if (new RectF(r102, r101[1], r102 + r100.getWidth(), r101[1] + r100.getHeight()).contains(r110.getRawX(), r110.getRawY()) == true) goto L9;
        this.f105185z = false;
        float r103 = r110.getY() - this.f105168i;
        float r104 = r110.getX() - this.f105169j;
        this.f105169j = r110.getX();
        this.f105168i = r110.getY();
        float r105 = Math.abs(r104);
        float r106 = Math.abs(r103);
        if (r105 <= r106) goto L17;
        if ((r105 - r106) < 4.0f) goto L17;
        this.f105185z = this.f105167h.isPlaying();
        T5();
        this.f105173n = this.f105166g.getProgress();
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
        if (this.f105170k == false) goto L5;
        int r101 = r100.getAction();
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L18;
        int r102 = getWidth();
        float r103 = r100.getX() - this.f105169j;
        this.f105169j = r100.getX();
        this.f105168i = r100.getY();
        SeekBar r104 = this.f105166g;
        r104.setProgress(Math.round(r104.getProgress() + ((r103 / r102) * 100.0f)));
    L18:
        return true;
    L13:
        if (this.f105166g.getProgress() != this.f105173n) goto L15;
        performClick();
        goto L18
    L15:
        V5();
        if (this.f105185z == false) goto L18;
        U5();
        goto L18
    L5:
        return super.onTouchEvent(r100);
    }

    public void setDataSource(e r100) {
        this.f105177r = r100;
        if (r100 == null) goto L11;
        if (TextUtils.isEmpty(r100.f105193a) == true) goto L12;
        this.f105177r.getClass();     // Catch: Exception -> L8
        this.f105167h.setDataSource(getContext(), UriProtector.parse(this.f105177r.f105193a));     // Catch: Exception -> L8
        this.f105167h.prepareAsync();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public void setFirstFrameBitmap(Bitmap r100) {
        this.f105175p = r100;
        MediaPlayer r101 = this.f105167h;
        if (r101 != null) goto L5;
    L6:
        BitmapDrawable r102 = new BitmapDrawable(getContext().getResources(), this.f105175p);
        this.f105164e.setImageDrawable(r102);
        this.f105164e.setVisibility(0);
        return;
    L5:
        if (r101.isPlaying() == false) goto L6;
    }

    public void setMute(boolean r100) {
        MediaPlayer r101 = this.f105167h;
        if (r101 == null) goto L6;
        r101.setIsMute(r100);
        return;
    }

    public void setOrientation(boolean r100) {
        if (r100 == false) goto L5;
        ViewGroup.LayoutParams r101 = this.f105163d.getLayoutParams();
        r101.height = s1.f(136.0f);
        r101.width = s1.f(245.0f);
        this.f105163d.setLayoutParams(r101);
        setPadding(0, s1.f(30.0f), 0, s1.f(30.0f));
        return;
    L5:
        ViewGroup.LayoutParams r102 = this.f105163d.getLayoutParams();
        r102.height = s1.f(192.0f);
        r102.width = s1.f(108.0f);
        this.f105163d.setLayoutParams(r102);
        setPadding(0, 0, 0, 0);
    }

    public void setRadius(int r100) {
        SurfaceView r101 = this.f105160a;
        if (r101 == null) goto L6;
        r2.a(r101, r100);
        return;
    }

    public void setTimeVisible(int r100) {
        UIUtils.setViewVisibility(this.f105161b, r100);
    }

    public void setViewBg(Drawable r100) {
        View r101 = this.f105163d;
        if (r101 == null) goto L6;
        r101.setBackground(r100);
        return;
    }

    public void setDataSource(String r100) {
        this.f105177r = new e(r100);
    }

    public LiveVideoPreviewView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f105168i = 0.0f;
        this.f105169j = 0.0f;
        this.f105170k = false;
        this.f105171l = true;
        this.f105172m = false;
        this.f105173n = 0;
        this.f105174o = false;
        this.f105175p = null;
        this.f105176q = 0;
        this.f105178s = false;
        this.f105181v = true;
        this.f105182w = new WeakHandler(new g0());
        this.f105183x = new a(this);
        this.f105184y = 1;
        this.f105185z = false;
        initView();
    }

    public LiveVideoPreviewView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f105168i = 0.0f;
        this.f105169j = 0.0f;
        this.f105170k = false;
        this.f105171l = true;
        this.f105172m = false;
        this.f105173n = 0;
        this.f105174o = false;
        this.f105175p = null;
        this.f105176q = 0;
        this.f105178s = false;
        this.f105181v = true;
        this.f105182w = new WeakHandler(new g0());
        this.f105183x = new a(this);
        this.f105184y = 1;
        this.f105185z = false;
        initView();
    }
}
