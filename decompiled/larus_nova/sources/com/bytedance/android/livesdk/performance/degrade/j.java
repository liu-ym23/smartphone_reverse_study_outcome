package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LiveShellTemperatureStrategyConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements Consumer<LiveShellTemperatureStrategyConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f154563a;

    public j(k r100) {
        this.f154563a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(LiveShellTemperatureStrategyConfig r100) {
        LiveShellTemperatureStrategyConfig r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "config");
        k r102 = this.f154563a;
        r102.f154570g = r101;
        if (r101 == null) goto L16;
        ArrayList<tn2.b> r103 = r101.getMShellTemperatureDegradeList();
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        tn2.b r105 = (tn2.b) r104.next();
        int r106 = r105.b();
        if (r106 != 22) goto L12;
        r102.f154571h = r105;
        goto L8
    L12:
        if (r106 != 23) goto L8;
        r102.f154572i = r105;
    L16:
        Disposable r107 = this.f154563a.f154565b;
        if (r107 == null) goto L19;
        r107.dispose();
    L19:
        this.f154563a.f154564a = true;
    }
}
