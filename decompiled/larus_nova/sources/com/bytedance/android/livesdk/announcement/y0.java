package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class y0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f103659a;

    public y0(String r100) {
        this.f103659a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ICalendarManager.ErrorCode r101 = (ICalendarManager.ErrorCode) r100;
        int r102 = x0.f103638a;
        ALogger.i("AudienceAnnounceCalendarUtil", r101.name());
        int r103 = w0.f103634a[r101.ordinal()];
        if (r103 != 1) goto L5;
        f2.b(R.string.ttlive_annocement_link_calendar_success_toast_opt, 0);
        ALogger.i("AudienceAnnounceCalendarUtil", "add " + this.f103659a + " success");
        return;
    L5:
        if (r103 != 2) goto L11;
        f2.b(R.string.ttlive_annocement_request_calendar_toast, 0);
        ALogger.i("AudienceAnnounceCalendarUtil", "add " + this.f103659a + " failed, without permission");
        return;
    }
}
