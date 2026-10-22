package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.amap.api.col.s.ce;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.k1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\tR\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u000eR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\u0012R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\tR\u001d\u0010\"\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\u000eR\u001d\u0010'\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningmusiccontrol/view/TuningMusicControlContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroid/view/View;", "b", "Lkotlin/Lazy;", "getDivider2", "()Landroid/view/View;", "divider2", "Landroid/widget/TextView;", "c", "getCurPlayTime", "()Landroid/widget/TextView;", "curPlayTime", "d", "getCutSongContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "cutSongContainer", "e", "getCutSongImg", "cutSongImg", "f", "getCutMusicTv", "cutMusicTv", ce.f26391f, "getPauseRestartContainer", "pauseRestartContainer", "h", "getPauseRestartImg", "pauseRestartImg", RXScreenCaptureService.KEY_INDEX, "getPauseRestartTv", "pauseRestartTv", "Landroid/widget/Button;", ce.f26395j, "getGoKtvDialog", "()Landroid/widget/Button;", "goKtvDialog", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningMusicControlContainer extends ConstraintLayout implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f70546n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ec0.a f70547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f70551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f70552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f70553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f70554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f70555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f70556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LifecycleRegistry f70557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f70558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ac0.b f70559m;

    public final TextView getCurPlayTime() {
        return (TextView) this.f70549c.getValue();
    }

    public final TextView getCutMusicTv() {
        return (TextView) this.f70552f.getValue();
    }

    public final ConstraintLayout getCutSongContainer() {
        return (ConstraintLayout) this.f70550d.getValue();
    }

    public final View getCutSongImg() {
        return (View) this.f70551e.getValue();
    }

    public final View getDivider2() {
        return (View) this.f70548b.getValue();
    }

    public final Button getGoKtvDialog() {
        return (Button) this.f70556j.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final ConstraintLayout getPauseRestartContainer() {
        return (ConstraintLayout) this.f70553g.getValue();
    }

    public final View getPauseRestartImg() {
        return (View) this.f70554h.getValue();
    }

    public final TextView getPauseRestartTv() {
        return (TextView) this.f70555i.getValue();
    }

    public final void R5() {
        ec0.a r100 = this.f70547a;
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.o();
    L6:
        SimpleDateFormat r103 = new SimpleDateFormat("mm:ss", Locale.US);
        ec0.a r104 = this.f70547a;
        if (r104 == null) goto L9;
        r101 = r104.c();
    L9:
        String r105 = s1.C(R.string.ttlive_ktv_song_progress_format, new Object[]{r103.format(Long.valueOf(r102)), r103.format(Long.valueOf(r101))});
        SpannableString r106 = new SpannableString(r105);
        r106.setSpan(new ForegroundColorSpan(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70216y)), 0, StringsKt.indexOf$default(r105, HTTP.URL_DEFAULT, 0, false, 6, null), 34);
        TextView r107 = getCurPlayTime();
        if (r107 == null) goto L13;
        r107.setText(r106);
        return;
    L13:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void S5() {
        ec0.a r100 = this.f70547a;
        if (r100 != null) goto L5;
    L12:
        TextView r101 = getPauseRestartTv();
        if (r101 == null) goto L15;
        r101.setText(s1.B(R.string.ttlive_ktv_sing_pause));
    L15:
        View r102 = getPauseRestartImg();
        if (r102 == null) goto L21;
        r102.setSelected(true);
        return;
    L21:
        return;
    L5:
        if (r100.a() != true) goto L12;
        TextView r103 = getPauseRestartTv();
        if (r103 == null) goto L9;
        r103.setText(s1.B(R.string.ttlive_ktv_sing_start));
    L9:
        View r104 = getPauseRestartImg();
        if (r104 == null) goto L19;
        r104.setSelected(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f70557k.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f70557k.setCurrentState(Lifecycle.State.DESTROYED);
        fc0.a r100 = this.f70559m.f2541h;
        if (r100 == null) goto L5;
        r100.onClear();
    L5:
        this.f70558l.clear();
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f70557k;
    }

    public TuningMusicControlContainer(ac0.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f70559m = r100;
        ec0.a r102 = r100.f2545l;
        this.f70547a = r102;
        this.f70548b = LazyKt.lazy(new TuningMusicControlContainer$divider2$2(this));
        this.f70549c = LazyKt.lazy(new TuningMusicControlContainer$curPlayTime$2(this));
        this.f70550d = LazyKt.lazy(new TuningMusicControlContainer$cutSongContainer$2(this));
        this.f70551e = LazyKt.lazy(new TuningMusicControlContainer$cutSongImg$2(this));
        this.f70552f = LazyKt.lazy(new TuningMusicControlContainer$cutMusicTv$2(this));
        this.f70553g = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartContainer$2(this));
        this.f70554h = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartImg$2(this));
        this.f70555i = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartTv$2(this));
        this.f70556j = LazyKt.lazy(new TuningMusicControlContainer$goKtvDialog$2(this));
        LifecycleRegistry r103 = new LifecycleRegistry(this);
        this.f70557k = r103;
        CompositeDisposable r104 = new CompositeDisposable();
        this.f70558l = r104;
        r103.setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_tuning_music_control_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(s1.f(16.0f), s1.f(5.0f), s1.f(16.0f), s1.f(15.0f));
        fc0.a r105 = r100.f2541h;
        if (r105 == null) goto L5;
        r105.a(this);
    L17:
        fc0.a r106 = r100.f2541h;
        if (r106 == null) goto L20;
        r106.b(this);
        return;
    L20:
        if (r102 == null) goto L22;
        r102.k();
    L22:
        S5();
        if (r102 == null) goto L25;
        r102.p(this, new a(this));
    L25:
        ConstraintLayout r107 = getCutSongContainer();
        if (r107 == null) goto L28;
        r107.setOnClickListener(new b(this));
    L28:
        ConstraintLayout r108 = getPauseRestartContainer();
        if (r108 == null) goto L31;
        r108.setOnClickListener(new k1(new TuningMusicControlContainer$addObserver$3(this), TuningMusicControlContainer$addObserver$4.INSTANCE));
    L31:
        Button r109 = getGoKtvDialog();
        if (r109 == null) goto L34;
        r109.setOnClickListener(new c(this));
    L34:
        R5();
        if (r102 == null) goto L41;
        Disposable r110 = r102.n(new d(this));
        if (r110 == null) goto L42;
        RxUtilKt.c(r110, r104);
        return;
    L42:
        return;
    L41:
        return;
    L5:
        TextView r111 = getCurPlayTime();
        if (r111 == null) goto L8;
        r111.setTextColor(ColorProtector.parseColor("#B2B2B2"));
    L8:
        View r112 = getPauseRestartImg();
        if (r112 == null) goto L11;
        KtvOrderSongThemeManager.c(r112, KtvOrderSongThemeManager.f70217z);
    L11:
        ConstraintLayout r113 = getCutSongContainer();
        if (r113 == null) goto L14;
        r113.setVisibility(0);
    L14:
        ConstraintLayout r114 = getPauseRestartContainer();
        if (r114 == null) goto L17;
        r114.setVisibility(0);
        goto L17
    }
}
