package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes45.dex */
public final class r7<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r7 f63629a = null;

    static {
        f63629a = new r7();
    }

    public r7() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final ICalendarManager.ErrorCode call() {
        return ICalendarManager.ErrorCode.NoPermission;
    }
}
