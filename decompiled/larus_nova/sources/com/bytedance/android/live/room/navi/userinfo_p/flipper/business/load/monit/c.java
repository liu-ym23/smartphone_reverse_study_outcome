package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import s91.f;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f100011a;

    public c(d r100) {
        this.f100011a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        ALogger.d("DiggTemporaryDataMonitor", "notify remove diggTemporary");
        DiggTemporaryDataMonitor r102 = this.f100011a.f100012a;
        r102.e((f) r102.f100004k.getValue());
    }
}
