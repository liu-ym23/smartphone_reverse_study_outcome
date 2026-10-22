package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LiveBatteryStrategyConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Consumer<LiveBatteryStrategyConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f154539a;

    public b(c r100) {
        this.f154539a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(LiveBatteryStrategyConfig r100) {
        LiveBatteryStrategyConfig r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "config");
        c r102 = this.f154539a;
        r102.f154546g = r101;
        if (r101 == null) goto L13;
        ArrayList<tn2.a> r103 = r101.getMBatteryDegradeList();
        if (r103 == null) goto L13;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        tn2.a r105 = (tn2.a) r104.next();
        if (r105.b() != 12) goto L8;
        r102.f154547h = r105;
    L13:
        Disposable r106 = this.f154539a.f154541b;
        if (r106 == null) goto L16;
        r106.dispose();
    L16:
        this.f154539a.f154540a = true;
    }
}
