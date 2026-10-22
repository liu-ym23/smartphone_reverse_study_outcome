package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes45.dex */
public final class m7<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m7 f63556a = null;

    static {
        f63556a = new m7();
    }

    public m7() {
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
