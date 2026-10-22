package com.bytedance.android.livesdk.widget;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public final class q0 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f161941a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        p0 r100 = this.f161941a;
        r100.f161909c = 0;
        r100.b(0);
        p0 r101 = this.f161941a;
        p0.a r102 = r101.f161911e;
        if (r102.f161917f == false) goto L5;
        p0.a(r101);
        return;
    L5:
        Function0<Unit> r103 = r102.f161918g;
        if (r103 == null) goto L10;
        Unit r104 = r103.invoke();
        return;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        p0 r101 = this.f161941a;
        int r102 = (int) (r100 / 1000);
        r101.f161909c = r102;
        r101.b(r102);
    }

    public q0(p0 r100, long r101) {
        this.f161941a = r100;
        super(r101, 1000);
    }
}
