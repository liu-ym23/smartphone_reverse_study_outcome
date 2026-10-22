package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import s91.f;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleLikeDataMonitor f100013a;

    public e(DoubleLikeDataMonitor r100) {
        this.f100013a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        ALogger.d("DoubleLikeDataMonitor", "移除双赞轮播标签");
        DoubleLikeDataMonitor r102 = this.f100013a;
        r102.e((f) r102.f100007j.getValue());
    }
}
