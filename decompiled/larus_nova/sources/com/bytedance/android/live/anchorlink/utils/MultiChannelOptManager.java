package com.bytedance.android.live.anchorlink.utils;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.anchorlink.network.model.MultiChannelData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.n8;
import com.bytedance.android.livesdk.o8;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import ey.g;
import gy.f;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class MultiChannelOptManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f58567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f58569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f58570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f58571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<MultiChannelInfo> f58572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f58573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f58574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f58575i;

    public MultiChannelOptManager(f r100) {
        this.f58575i = r100;
        this.f58567a = o8.f154131a.getValue();
        this.f58568b = 1;
        this.f58569c = 2;
        this.f58570d = new CompositeDisposable();
        MutableLiveData<MultiChannelInfo> r101 = new MutableLiveData();
        this.f58572f = r101;
        this.f58573g = r101;
        a r102 = new a(this);
        this.f58574h = r102;
        if (r100 == null) goto L6;
        r100.m(r102);
        return;
    }

    public static void c(MultiChannelOptManager r100) {
        Integer r101 = r100.f58567a;
        if (r101 != null) goto L6;
    L8:
        Disposable r102 = r100.f58571e;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        Disposable r103 = Observable.timer(n8.f154000a.getValue().intValue(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r100, null));
        RxUtilKt.c(r103, r100.f58570d);
        r100.f58571e = r103;
        return;
    L6:
        if (r101.intValue() != 0) goto L8;
    }

    public static final void a(MultiChannelOptManager r100, String r101) {
        f r102 = r100.f58575i;
        boolean r103 = false;
        if (r102 == null) goto L14;
        List<ui6.a> r104 = r102.L0();
        if (r104 == null) goto L14;
        Iterator<ui6.a> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L14;
        ui6.a r106 = r105.next();
        if (r101 == null) goto L8;
        if (StringsKt.contains$default(r101, r106.f550209a, false, 2, null) != true) goto L8;
        r103 = true;
    L14:
        if (r103 == true) goto L33;
        Integer r107 = r100.f58567a;
        if (r107 != null) goto L19;
    L20:
        Integer r108 = r100.f58567a;
        if (r108 != null) goto L24;
        return;
    L24:
        if (r108.intValue() != 3) goto L34;
    L25:
        r100.b(r100.f58568b, "firstFrameRender");
        return;
    L34:
        return;
    L19:
        if (r107.intValue() == 1) goto L25;
    }

    public final void b(int r100, String r110) {
        Integer r101 = this.f58567a;
        if (r101 != null) goto L6;
    L8:
        ALogger.e("ttlive_anchor_link_MultiChannelOpt", "fetchMultiChannelInfo " + r100 + ' ' + r110);
        g.f474778a.getClass();
        nc0.b r102 = g.a.a();
        if (r102 == null) goto L12;
        Function1<MultiChannelData, Unit> r103 = new MultiChannelOptManager$fetchMultiChannelInfo$1(this);
        MultiChannelOptManager$fetchMultiChannelInfo$2 r104 = MultiChannelOptManager$fetchMultiChannelInfo$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        Intrinsics.checkNotNullParameter(r104, LynxVideoManagerLite.EVENT_ON_ERROR);
        r102.f518605d.fetchMultiChannelInfo(r100, true, r110, "unknown", new nc0.a(r103), r104);
        return;
    L12:
        return;
    L6:
        if (r101.intValue() != 0) goto L8;
    }
}
