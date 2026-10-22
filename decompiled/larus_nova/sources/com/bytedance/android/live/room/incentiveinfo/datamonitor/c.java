package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import com.bytedance.android.live.base.model.message.s0;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import vh7.f;
import zg1.x;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DouPlusDataChangeMonitor f99675a;

    public c(DouPlusDataChangeMonitor r100) {
        this.f99675a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        s0 r101 = (s0) f.c(s0.class);
        DouPlusDataChangeMonitor r102 = this.f99675a;
        ((x) r100).getClass();
        r101.setStatus(Long.valueOf(-1));
        r101.setNumber(Long.valueOf(0));
        r101.setToast("");
        Unit r103 = Unit.INSTANCE;
        r102.onMessage(r101);
    }
}
