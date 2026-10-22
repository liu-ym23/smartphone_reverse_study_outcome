package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f63351a;

    public e1(l1 r100) {
        this.f63351a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        l1 r101 = this.f63351a;
        r101.k((ICalendarManager.ErrorCode) r100, null);
    }
}
