package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes45.dex */
public final class n7<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n7 f63566a = null;

    static {
        f63566a = new n7();
    }

    public n7() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final ICalendarManager.ErrorCode call() {
        return ICalendarManager.ErrorCode.AlreadyExists;
    }
}
