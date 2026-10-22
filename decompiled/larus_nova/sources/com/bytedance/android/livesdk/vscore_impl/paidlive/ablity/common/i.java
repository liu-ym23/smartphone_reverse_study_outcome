package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import com.bytedance.android.livesdkapi.replay.PaidReplayCallback;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f160196a;

    public i(h r100) {
        this.f160196a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Triple r101 = (Triple) r100;
        PaidReplayCallback r102 = this.f160196a.f160194a;
        if (r102 == null) goto L6;
        r102.onFreePlayCountDown(((Number) r101.getThird()).longValue() * ((long) 1000));
        return;
    }
}
