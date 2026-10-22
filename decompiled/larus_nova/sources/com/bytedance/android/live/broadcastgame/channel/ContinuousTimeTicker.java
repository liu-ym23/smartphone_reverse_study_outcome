package com.bytedance.android.live.broadcastgame.channel;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ContinuousTimeTicker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Long, Unit> f59560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f59561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f59562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f59563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f59564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59565f;

    public static final class a {
    }

    static {
    }

    public ContinuousTimeTicker() {
        Intrinsics.checkNotNullParameter("heart-beat", "key");
        this.f59565f = "heart-beat";
        this.f59562c = System.currentTimeMillis();
        this.f59563d = true;
        this.f59564e = 1000;
    }

    public final void b() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L7;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f59565f + "]@{" + hashCode() + "} stop, isStop: " + this.f59563d);
        this.f59563d = true;
        this.f59560a = null;
        Disposable r100 = this.f59561b;
        if (r100 == null) goto L9;
        r100.dispose();
        return;
    L9:
        return;
    L7:
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.f59565f + "] only invoke by main thread");
        UtilityKotlinExtentionsKt.s(0, false, false, new ContinuousTimeTicker$stop$1(this), 7);
    }

    public final void a(long r110, final Function1<? super Long, Unit> r111) {
        final long r100 = r110;
        Intrinsics.checkNotNullParameter(r111, "action");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L25;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f59565f + "]@{" + hashCode() + "} continuous with: " + r100 + " | " + this.f59564e);
        if (r100 != 0) goto L8;
        r100 = 1000;
    L8:
        if (this.f59563d == false) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L15;
    L17:
        this.f59564e = r100;
        this.f59560a = r111;
        if (this.f59563d == false) goto L20;
    L22:
        boolean r112 = false;
    L23:
        if (r112 == true) goto L27;
        ALogger.i("AAM.ContinuousTimeTicker", "[" + this.f59565f + "]@{" + hashCode() + "} start");
        this.f59563d = false;
        j.a r102 = j.f66356a;
        this.f59561b = j.a(0, this.f59564e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.broadcastgame.channel.a(this), new b(this));
        return;
    L27:
        return;
    L20:
        if ((System.currentTimeMillis() - this.f59562c) >= (((long) 2) * this.f59564e)) goto L22;
        r112 = true;
        goto L23
    L15:
        if (r100 == this.f59564e) goto L17;
        b();
        goto L17
    L10:
        if ((System.currentTimeMillis() - this.f59562c) >= (((long) 2) * this.f59564e)) goto L12;
        r101 = true;
        goto L13
    L25:
        ALogger.e("AAM.ContinuousTimeTicker", "[" + this.f59565f + "] only invoke by main thread");
        UtilityKotlinExtentionsKt.s(0, false, false, new ContinuousTimeTicker$changeMessage$1(this, r100, r111), 7);
    }
}
