package com.bytedance.android.live.room.navi.userinfo_p.widget;

import io.reactivex.functions.Consumer;
import zg1.x0;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomUserInfoPlatformWidget f100204a;

    public a(LiveRoomUserInfoPlatformWidget r100) {
        this.f100204a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveRoomUserInfoPlatformWidget r101 = this.f100204a;
        r101.onEvent((x0) r100);
    }
}
