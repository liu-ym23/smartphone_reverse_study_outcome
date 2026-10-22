package com.bytedance.android.shopping.mall.feed.help;

import android.os.Debug;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f176979a;

    public b(a r100) {
        this.f176979a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        a r100 = this.f176979a;
        Runtime.getRuntime().totalMemory();
        int r101 = a.f176973e;
        r100.getClass();
        a r102 = this.f176979a;
        Integer r103 = StringsKt.toIntOrNull(Debug.getRuntimeStat("art.gc.gc-count"));
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        r102.f176974a = r104;
        this.f176979a.a();
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
