package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f103354a;

    public b1(String r100) {
        this.f103354a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x0.f103638a;
        ALogger.i("AudienceAnnounceCalendarUtil", "delete " + this.f103354a + " failed, reason " + ((Throwable) r100).getMessage());
    }
}
