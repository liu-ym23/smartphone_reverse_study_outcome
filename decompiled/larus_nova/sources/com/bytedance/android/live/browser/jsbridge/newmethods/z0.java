package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z0<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f63736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63737b;

    public z0(l1 r100, String r101) {
        this.f63736a = r100;
        this.f63737b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<ICalendarManager.ErrorCode, ICalendarManager.EventRecord> call() {
        ICalendarManager r100 = this.f63736a.f63538b;
        Intrinsics.checkNotNull(r100);
        return r100.get(this.f63737b);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
