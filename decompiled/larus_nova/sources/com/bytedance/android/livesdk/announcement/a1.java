package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f103351a;

    public a1(String r100) {
        this.f103351a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ICalendarManager.ErrorCode r101 = (ICalendarManager.ErrorCode) r100;
        int r102 = x0.f103638a;
        ALogger.i("AudienceAnnounceCalendarUtil", "delete " + this.f103351a + " success");
    }
}
