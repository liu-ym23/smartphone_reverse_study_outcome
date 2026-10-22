package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.h;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import defpackage.KaraokeLyricTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.a f142422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KaraokeLyricTimer f142423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LyricComponentImplManager f142424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Long, Unit> f142425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String[]> f142426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f142427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final KtvComponentCountDownView f142428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a f142429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super Long, Unit> f142430i;

    public static final class a {
    }

    static {
        KtvSettingHelper.j();
    }

    public b(ConstraintLayout r100, KtvComponentCountDownView r101, ViewPainter r102, h r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, "lyricContainer");
        Intrinsics.checkNotNullParameter(r101, "countDownView");
        Intrinsics.checkNotNullParameter(r102, "viewPainter");
        this.f142427f = r100;
        this.f142428g = r101;
        this.f142429h = r103;
        this.f142430i = r104;
        LyricsDisplayConfig r105 = new LyricsDisplayConfig();
        r105.a();
        Intrinsics.checkNotNullParameter(r105, "config");
        Intrinsics.checkNotNullParameter(r102, "painter");
        Context r106 = r102.getContext();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        LyricComponentImplManager r107 = new LyricComponentImplManager(r106, r105, new com.bytedance.component.lyric.a(r106, r102));
        this.f142424c = r107;
        MutableLiveData<String[]> r108 = new MutableLiveData();
        r108.setValue(null);
        Unit r109 = Unit.INSTANCE;
        this.f142426e = r108;
        Function1<Long, Unit> r110 = new KaraokeLyricPresenter$1(this);
        this.f142425d = r110;
        this.f142423b = new KaraokeLyricTimer(r110);
        KaraokeLyricPresenter$2 r111 = new KaraokeLyricPresenter$2(this);
        Intrinsics.checkNotNullParameter(r111, "factory");
        r107.f202969d = r111;
    }
}
