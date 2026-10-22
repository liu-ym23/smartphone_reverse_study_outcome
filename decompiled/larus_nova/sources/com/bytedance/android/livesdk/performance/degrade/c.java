package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LiveBatteryStrategyConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f154541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f154542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f154543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f154544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f154545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveBatteryStrategyConfig f154546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public tn2.a f154547h;

    public c() {
        this.f154542c = -1;
        this.f154543d = -1;
        this.f154544e = 11;
        if (this.f154540a == false) goto L5;
        return;
    L5:
        if (this.f154541b != null) goto L9;
        this.f154541b = Observable.create(new a()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.computation()).subscribe(new b(this));
        return;
    }

    public final void a(int r100, boolean r110, final e r111) {
        Intrinsics.checkNotNullParameter(r111, "performanceCallback");
        if (this.f154540a == false) goto L10;
        if (r100 < 0) goto L10;
        if (r100 > 100) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        return;
    L13:
        tn2.a r102 = this.f154547h;
        if (r102 != null) goto L16;
    L19:
        int r103 = 11;
    L20:
        Function1<Integer, Integer> r112 = new BatteryLevelStrategy$onBatteryReady$1(r111);
        if (r103 != 11) goto L23;
        this.f154542c = -1;
        if (this.f154543d >= 0) goto L41;
        this.f154543d = System.currentTimeMillis();
    L41:
        if (this.f154545f == false) goto L54;
        long r104 = System.currentTimeMillis() - this.f154543d;
        LiveBatteryStrategyConfig r113 = this.f154546g;
        if (r113 == null) goto L45;
        long r105 = r113.getMRecoverDuration();
    L47:
        if (r104 < r105) goto L55;
        this.f154544e = r103;
        r112.invoke(Integer.valueOf(r103));
        this.f154545f = false;
        return;
    L55:
        return;
    L45:
        r105 = 2400000;
        goto L47
    L54:
        return;
    L23:
        if (r103 != this.f154544e) goto L26;
        this.f154542c = -1;
        return;
    L26:
        if (this.f154542c > 0) goto L29;
        this.f154542c = System.currentTimeMillis();
    L29:
        if (this.f154542c <= 0) goto L51;
        long r106 = System.currentTimeMillis() - this.f154542c;
        LiveBatteryStrategyConfig r114 = this.f154546g;
        if (r114 == null) goto L33;
        long r107 = r114.getMDuration();
    L35:
        if (r106 < r107) goto L52;
        this.f154544e = r103;
        r112.invoke(Integer.valueOf(r103));
        this.f154545f = true;
        this.f154543d = -1;
        return;
    L52:
        return;
    L33:
        r107 = 600000;
        goto L35
    L51:
        return;
    L16:
        if (r100 > r102.a()) goto L19;
        if (r110 == true) goto L19;
        r103 = 12;
    L10:
        r101 = false;
        goto L11
    }
}
