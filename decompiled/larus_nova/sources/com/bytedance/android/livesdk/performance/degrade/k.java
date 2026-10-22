package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LiveShellTemperatureStrategyConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f154565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f154566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f154567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f154568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f154569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveShellTemperatureStrategyConfig f154570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public tn2.b f154571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public tn2.b f154572i;

    public k() {
        this.f154566c = -1;
        this.f154567d = -1;
        this.f154568e = 21;
        if (this.f154564a == false) goto L5;
        return;
    L5:
        if (this.f154565b != null) goto L9;
        this.f154565b = Observable.create(new i()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.computation()).subscribe(new j(this));
        return;
    }

    public final void a(float r100, final d r110) {
        Intrinsics.checkNotNullParameter(r110, "performanceCallback");
        if (this.f154564a == true) goto L6;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L11;
        return;
    L11:
        tn2.b r102 = this.f154571h;
        if (r102 != null) goto L14;
    L16:
        int r103 = 21;
    L17:
        tn2.b r104 = this.f154572i;
        if (r104 != null) goto L20;
    L22:
        Function1<Integer, Integer> r105 = new ShellTemperatureLevelStrategy$onShellTemperatureReady$1(r110);
        if (r103 != 21) goto L25;
        this.f154566c = -1;
        if (this.f154567d >= 0) goto L43;
        this.f154567d = System.currentTimeMillis();
    L43:
        if (this.f154569f == false) goto L56;
        long r106 = System.currentTimeMillis() - this.f154567d;
        LiveShellTemperatureStrategyConfig r111 = this.f154570g;
        if (r111 == null) goto L47;
        long r107 = r111.getMRecoverDuration();
    L49:
        if (r106 < r107) goto L57;
        this.f154568e = r103;
        r105.invoke(Integer.valueOf(r103));
        this.f154569f = false;
        return;
    L57:
        return;
    L47:
        r107 = 2400000;
        goto L49
    L56:
        return;
    L25:
        if (r103 != this.f154568e) goto L28;
        this.f154567d = -1;
        return;
    L28:
        if (this.f154566c > 0) goto L31;
        this.f154566c = System.currentTimeMillis();
    L31:
        if (this.f154566c <= 0) goto L53;
        long r108 = System.currentTimeMillis() - this.f154566c;
        LiveShellTemperatureStrategyConfig r112 = this.f154570g;
        if (r112 == null) goto L35;
        long r109 = r112.getMDuration();
    L37:
        if (r108 < r109) goto L54;
        this.f154568e = r103;
        r105.invoke(Integer.valueOf(r103));
        this.f154569f = true;
        this.f154567d = -1;
        return;
    L54:
        return;
    L35:
        r109 = 600000;
        goto L37
    L53:
        return;
    L20:
        if (r100 <= r104.a()) goto L22;
        r103 = 23;
        goto L22
    L14:
        if (r100 <= r102.a()) goto L16;
        r103 = 22;
        goto L17
    L6:
        if (r100 < 0) goto L7;
        r101 = true;
        goto L9
    }
}
