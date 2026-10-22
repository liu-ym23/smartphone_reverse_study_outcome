package com.bytedance.android.livesdk.calendar;

import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes7.dex */
public final class j<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f104444a = null;

    static {
        f104444a = new j();
    }

    public j() {
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
