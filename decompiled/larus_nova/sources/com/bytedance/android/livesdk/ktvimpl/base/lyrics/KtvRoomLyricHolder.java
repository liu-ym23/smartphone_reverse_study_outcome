package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvRoomLyricHolder;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lub0/a;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomLyricHolder implements Observer<ub0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f143127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KtvListenerLyricPresenter f143128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f143129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f143130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f143131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f143132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f143133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Long, Unit> f143134h;

    public final Function1<LyricsDisplayConfig, Unit> a() {
        if (this.f143131e == false) goto L5;
        this.f143127a.getClass();
        Function1<LyricsDisplayConfig, Unit> r100 = KtvSingerLyricPresenter$configDisplay$1.INSTANCE;
    L6:
        KeyEvent.Callback r101 = this.f143129c;
        if ((r101 instanceof a) == true) goto L9;
        r101 = null;
    L9:
        a r102 = (a) r101;
        if (r102 == null) goto L14;
        LyricsDisplayConfig r103 = r102.getDisplayConfig();
        if (r103 == null) goto L14;
        r100.invoke(r103);
        ((a) this.f143129c).onConfigComplete();
    L14:
        return r100;
    L5:
        this.f143128b.getClass();
        r100 = KtvListenerLyricPresenter$configDisplay$1.INSTANCE;
        goto L6
    }

    public final void b() {
        View r100 = this.f143129c;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.getVisibility());
    L7:
        if (r101.intValue() != 0) goto L12;
        View r102 = this.f143129c;
        if (r102 == null) goto L13;
        r102.setVisibility(8);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final void c() {
        LyricsDisplayConfig r100 = this.f143133g.getDisplayConfig();
        KtvRoomLyricHolder$defaultConfigDisplayOpt$1.INSTANCE.invoke(r100);
        this.f143133g.onConfigComplete();
        this.f143132f = true;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ub0.a r101 = (ub0.a) r100;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "lyricsChangeEvent");
        String r102 = "onLyricsChange current Is Singer:" + this.f143131e + "， songid：" + r101.f549304a;
        ALogger.i(bb0.b.b().concat("-lyric"), r102 + ", invoke class :KtvRoomLyricHolder");
        if (this.f143131e == false) goto L7;
        this.f143127a.a(r101);
        return;
    L7:
        this.f143128b.a(r101);
        return;
    }

    public KtvRoomLyricHolder(KtvSingAndListenerLyricViewV2 r110, Function1 r111) {
        Intrinsics.checkNotNullParameter(r110, "lyricView");
        this.f143133g = r110;
        this.f143134h = r111;
        d r100 = new d(r110);
        this.f143127a = r100;
        KtvListenerLyricPresenter r101 = new KtvListenerLyricPresenter(r110, r111);
        this.f143128b = r101;
        this.f143129c = r110;
        CompositeDisposable r112 = new CompositeDisposable();
        this.f143130d = r112;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getLyricsChangeLiveData().observeForever(this);
        Disposable r102 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new c(this), 3, null);
        if (r102 == null) goto L5;
        RxUtilKt.c(r102, r112);
    L5:
        Intrinsics.checkNotNullParameter(r110, "lyricView");
        r100.f143093a = r110;
        Intrinsics.checkNotNullParameter(r110, "lyricView");
        r101.f143093a = r110;
        a();
    }
}
