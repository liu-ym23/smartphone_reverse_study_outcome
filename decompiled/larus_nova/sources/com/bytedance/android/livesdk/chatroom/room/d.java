package com.bytedance.android.livesdk.chatroom.room;

import android.os.SystemClock;
import io.reactivex.functions.Consumer;
import zg1.s1;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f111083a;

    public d(c r100) {
        this.f111083a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        s1 r101 = (s1) r100;
        c r102 = this.f111083a;
        r102.getClass();
        if (r101 == null) goto L22;
        int r103 = r101.f571936a;
        if (r103 == 2) goto L16;
        if (r103 == 3) goto L13;
        if (r103 == 6) goto L16;
        return;
    L13:
        if (r102.f110979c <= 0) goto L19;
        r102.f110978b += SystemClock.elapsedRealtime() - r102.f110979c;
        r102.f110979c = -1;
        return;
    L19:
        return;
    L16:
        if (r102.f110979c >= 0) goto L21;
        r102.f110979c = SystemClock.elapsedRealtime();
        return;
    L21:
        return;
    }
}
