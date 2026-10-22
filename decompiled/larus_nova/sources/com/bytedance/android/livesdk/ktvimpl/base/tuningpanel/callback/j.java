package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.utils.k1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements fc0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f143490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f143491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec0.a f143492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TuningMusicControlContainer f143493d;

    public final void c() {
        ec0.a r100 = this.f143492c;
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.o();
    L6:
        SimpleDateFormat r103 = new SimpleDateFormat("mm:ss", Locale.US);
        ec0.a r104 = this.f143492c;
        if (r104 == null) goto L9;
        r101 = r104.c();
    L9:
        String r105 = s1.C(R.string.ttlive_ktv_song_progress_format, new Object[]{r103.format(Long.valueOf(r102)), r103.format(Long.valueOf(r101))});
        SpannableString r106 = new SpannableString(r105);
        r106.setSpan(new ForegroundColorSpan(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70216y)), 0, StringsKt.indexOf$default(r105, HTTP.URL_DEFAULT, 0, false, 6, null), 34);
        TuningMusicControlContainer r107 = this.f143493d;
        if (r107 == null) goto L15;
        TextView r108 = r107.getCurPlayTime();
        if (r108 == null) goto L16;
        r108.setText(r106);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void d() {
        ec0.a r100 = this.f143492c;
        if (r100 != null) goto L5;
    L16:
        TuningMusicControlContainer r101 = this.f143493d;
        if (r101 == null) goto L21;
        TextView r102 = r101.getPauseRestartTv();
        if (r102 == null) goto L21;
        r102.setText(s1.B(R.string.ttlive_ktv_sing_pause));
    L21:
        TuningMusicControlContainer r103 = this.f143493d;
        if (r103 == null) goto L30;
        View r104 = r103.getPauseRestartImg();
        if (r104 == null) goto L31;
        r104.setSelected(true);
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (r100.a() != true) goto L16;
        TuningMusicControlContainer r105 = this.f143493d;
        if (r105 == null) goto L11;
        TextView r106 = r105.getPauseRestartTv();
        if (r106 == null) goto L11;
        r106.setText(s1.B(R.string.ttlive_ktv_sing_start));
    L11:
        TuningMusicControlContainer r107 = this.f143493d;
        if (r107 == null) goto L27;
        View r108 = r107.getPauseRestartImg();
        if (r108 == null) goto L28;
        r108.setSelected(false);
        return;
    L28:
        return;
    }

    @Override // fc0.a
    public final void onClear() {
        this.f143490a.clear();
        Disposable r100 = this.f143491b;
        if (r100 != null) goto L5;
    L7:
        this.f143493d = null;
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r100.dispose();
        goto L7
    }

    public j() {
        this.f143490a = new CompositeDisposable();
        this.f143492c = KSongTuningPanelHelperKt.e();
    }

    @Override // fc0.a
    public final void a(TuningMusicControlContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningMusicControlContainer");
        this.f143493d = r100;
        if (r100 == null) goto L7;
        TextView r101 = r100.getCurPlayTime();
        if (r101 == null) goto L7;
        r101.setTextColor(ColorProtector.parseColor("#B2B2B2"));
    L7:
        TuningMusicControlContainer r102 = this.f143493d;
        if (r102 == null) goto L13;
        View r103 = r102.getPauseRestartImg();
        if (r103 == null) goto L13;
        KtvOrderSongThemeManager.c(r103, KtvOrderSongThemeManager.f70217z);
    L13:
        if (gh0.a.d() == true) goto L19;
        RealTimeChorusBusinessContext.a r104 = RealTimeChorusBusinessContext.Companion;
        r104.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L19;
        if (r104.j() == false) goto L19;
        boolean r105 = KtvUtilsKt.j();
    L20:
        if (r105 == false) goto L31;
        TuningMusicControlContainer r106 = this.f143493d;
        if (r106 == null) goto L26;
        ConstraintLayout r107 = r106.getCutSongContainer();
        if (r107 == null) goto L26;
        r107.setVisibility(0);
    L26:
        TuningMusicControlContainer r108 = this.f143493d;
        if (r108 == null) goto L42;
        ConstraintLayout r109 = r108.getPauseRestartContainer();
        if (r109 == null) goto L43;
        r109.setVisibility(0);
        return;
    L43:
        return;
    L42:
        return;
    L31:
        TuningMusicControlContainer r110 = this.f143493d;
        if (r110 == null) goto L36;
        ConstraintLayout r111 = r110.getCutSongContainer();
        if (r111 == null) goto L36;
        r111.setVisibility(8);
    L36:
        TuningMusicControlContainer r112 = this.f143493d;
        if (r112 == null) goto L45;
        ConstraintLayout r113 = r112.getPauseRestartContainer();
        if (r113 == null) goto L46;
        r113.setVisibility(8);
        return;
    L46:
        return;
    L45:
        return;
    L19:
        r105 = true;
        goto L20
    }

    @Override // fc0.a
    public final void b(TuningMusicControlContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningMusicControlContainer");
        ec0.a r101 = this.f143492c;
        if (r101 == null) goto L5;
        r101.k();
    L5:
        d();
        TuningMusicControlContainer r102 = this.f143493d;
        if (r102 == null) goto L10;
        ec0.a r103 = this.f143492c;
        if (r103 == null) goto L10;
        r103.p(r102, new e(this));
    L10:
        TuningMusicControlContainer r104 = this.f143493d;
        if (r104 == null) goto L15;
        ConstraintLayout r105 = r104.getCutSongContainer();
        if (r105 == null) goto L15;
        r105.setOnClickListener(new f(this));
    L15:
        TuningMusicControlContainer r106 = this.f143493d;
        if (r106 == null) goto L20;
        ConstraintLayout r107 = r106.getPauseRestartContainer();
        if (r107 == null) goto L20;
        r107.setOnClickListener(new k1(new KSongTuningMusicControlOuterCallback$addTuningMusicControlObserver$3(this), KSongTuningMusicControlOuterCallback$addTuningMusicControlObserver$4.INSTANCE));
    L20:
        TuningMusicControlContainer r108 = this.f143493d;
        if (r108 == null) goto L25;
        Button r109 = r108.getGoKtvDialog();
        if (r109 == null) goto L25;
        r109.setOnClickListener(new g(this));
    L25:
        c();
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r110 = KtvContext.a.g().getKtvCoreController();
        if (r110 == null) goto L32;
        Observable<sh6.b<com.bytedance.android.livesdk.ktvimpl.base.i>> r111 = r110.a();
        if (r111 == null) goto L32;
        Disposable r112 = r111.subscribe(new h(this));
        if (r112 == null) goto L32;
        RxUtilKt.c(r112, this.f143490a);
    L32:
        Disposable r113 = this.f143491b;
        if (r113 != null) goto L35;
    L37:
        ALogger.d("ttlive_ktv_realTimeChorus_KSongTuningMusicControlOuterCallback", "observePlayProgressEvent");
        ec0.a r114 = this.f143492c;
        if (r114 == null) goto L40;
        Disposable r115 = r114.n(new i(this));
    L41:
        this.f143491b = r115;
        return;
    L40:
        r115 = null;
        goto L41
    L35:
        if (r113.isDisposed() == true) goto L37;
        r113.dispose();
        goto L37
    }
}
