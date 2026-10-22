package com.bytedance.android.livesdk.calendar;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes7.dex */
public final class d<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f104435a = null;

    static {
        f104435a = new d();
    }

    public d() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final ICalendarManager.ErrorCode call() {
        return ICalendarManager.ErrorCode.ArgumentError;
    }
}
