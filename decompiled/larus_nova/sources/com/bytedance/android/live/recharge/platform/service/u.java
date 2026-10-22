package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f90331a;

    public u(v r100) {
        this.f90331a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("ShowPayCancelChargePanelEvent", ExceptionsKt.stackTraceToString((Throwable) r100));
        this.f90331a.f90332a = false;
    }
}
