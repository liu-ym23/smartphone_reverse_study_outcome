package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class w0<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f63695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f63697c;

    public w0(l1 r100, String r101, String r102) {
        this.f63695a = r100;
        this.f63696b = r101;
        this.f63697c = r102;
    }

    @Override // java.util.concurrent.Callable
    public final ICalendarManager.ErrorCode call() {
        ICalendarManager r100 = this.f63695a.f63538b;
        Intrinsics.checkNotNull(r100);
        return r100.remove(this.f63696b, this.f63697c);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
