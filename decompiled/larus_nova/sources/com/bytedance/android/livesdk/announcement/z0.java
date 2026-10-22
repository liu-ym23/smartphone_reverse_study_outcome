package com.bytedance.android.livesdk.announcement;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class z0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f103661a;

    public z0(String r100) {
        this.f103661a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x0.f103638a;
        ALogger.i("AudienceAnnounceCalendarUtil", "add " + this.f103661a + " failed, reason : " + ((Throwable) r100).getMessage());
    }
}
