package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011R\u0011\u0010\u0016\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/widget/SeekBarWithProgress;", "Landroid/widget/FrameLayout;", "", "color", "", "setSeekBarProgressTvColor", "drawable", "setThumbColor", "Landroid/graphics/drawable/Drawable;", "setProgressBarDrawable", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "getRealProgress", "Lcom/bytedance/android/livesdk/widget/SeekBarWithProgress$b;", "cb", "setInterceptCallBack", "", "enable", "setSeekEnable", "getProgress", "()I", "progress", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeekBarWithProgress extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f161294g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f161295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SeekBar.OnSeekBarChangeListener f161296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f161297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f161298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f161299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f161300f;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarWithProgress f161301a;

        public a(SeekBarWithProgress r100) {
            this.f161301a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f161301a.f161296b;
            if (r101 == null) goto L6;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f161301a.f161296b;
            if (r101 == null) goto L6;
            r101.onStopTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            SeekBarWithProgress r103 = this.f161301a;
            int r104 = SeekBarWithProgress.f161294g;
            r103.d(r101);
            SeekBar.OnSeekBarChangeListener r105 = this.f161301a.f161296b;
            if (r105 == null) goto L6;
            r105.onProgressChanged(r100, r101, r102);
            return;
        }
    }

    public interface b {
        boolean a();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBarWithProgress f161302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f161303b;

        public c(SeekBarWithProgress r100, int r101) {
            this.f161302a = r100;
            this.f161303b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SeekBarWithProgress r100 = this.f161302a;     // Catch: Throwable -> L4
            int r101 = this.f161303b;     // Catch: Throwable -> L4
            int r102 = SeekBarWithProgress.f161294g;     // Catch: Throwable -> L4
            r100.b(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public SeekBarWithProgress(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeekBarWithProgress(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getRealProgress() {
        if (this.f161300f == false) goto L6;
        return (int) ((getProgress() / this.f161299e) * 100);
    L6:
        return getProgress();
    }

    public final int getProgress() {
        return ((SeekBar) a(R.id.seek_bar_with_progress)).getProgress();
    }

    public final View a(int r100) {
        if (this.f161295a != null) goto L5;
        this.f161295a = new LinkedHashMap();
    L5:
        View r101 = this.f161295a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f161295a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(int r100) {
        float r101 = UIUtils.dip2Px(getContext(), 21.0f);
        ((TextView) a(R.id.seek_bar_progress_tv)).setX(((((SeekBar) a(R.id.seek_bar_with_progress)).getX() + r101) + ((((SeekBar) a(R.id.seek_bar_with_progress)).getWidth() - (2 * r101)) * (r100 / 100.0f))) - (((TextView) a(R.id.seek_bar_progress_tv)).getWidth() / 2.0f));
    }

    public final void c(int r100) {
        ((SeekBar) a(R.id.seek_bar_with_progress)).setProgress(r100);
        d(r100);
    }

    public final void d(int r100) {
        TextView r101 = (TextView) a(R.id.seek_bar_progress_tv);
        if (this.f161300f == true) goto L5;
        String r102 = String.valueOf(r100);
    L6:
        r101.setText(r102);
        if (this.f161298d == false) goto L10;
        return;
    L10:
        if (((TextView) a(R.id.seek_bar_progress_tv)).getWidth() != 0) goto L12;
        ((TextView) a(R.id.seek_bar_progress_tv)).post(new c(this, r100));
        return;
    L12:
        b(r100);
        return;
    L5:
        r102 = String.valueOf((int) ((r100 / this.f161299e) * 100));
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        b r101 = this.f161297c;
        if (r101 == null) goto L7;
        return r101.a();
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setInterceptCallBack(b r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f161297c = r100;
    }

    public final void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f161296b = r100;
    }

    public final void setProgressBarDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ((SeekBar) a(R.id.seek_bar_with_progress)).setProgressDrawable(r100);
    }

    public final void setSeekBarProgressTvColor(int r100) {
        ((TextView) a(R.id.seek_bar_progress_tv)).setTextColor(r100);
    }

    public final void setSeekEnable(boolean r100) {
        SeekBar r101 = (SeekBar) a(R.id.seek_bar_with_progress);
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
        return;
    }

    public final void setThumbColor(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ((SeekBar) a(R.id.seek_bar_with_progress)).setThumb(r100);
    }

    public final void setThumbColor(int r100) {
        ((SeekBar) a(R.id.seek_bar_with_progress)).setThumb(com.bytedance.android.live.core.utils.s1.m(r100));
    }

    public SeekBarWithProgress(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f161295a = new LinkedHashMap();
        this.f161298d = true;
        this.f161299e = 100;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_seekbar_with_progress_horizontal, this);
        ((SeekBar) a(R.id.seek_bar_with_progress)).setOnSeekBarChangeListener(new a(this));
        c(((SeekBar) a(R.id.seek_bar_with_progress)).getProgress());
    }

    public /* synthetic */ SeekBarWithProgress(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
