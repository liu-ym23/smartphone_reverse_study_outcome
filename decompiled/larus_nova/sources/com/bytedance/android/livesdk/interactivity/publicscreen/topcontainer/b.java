package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.larus.apm.impl.protector.RunnableProtector;
import f52.i;
import f52.j;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PSTopContainer f139703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f52.c f139704b;

    public b(PSTopContainer r100, j r101) {
        this.f139703a = r100;
        this.f139704b = r101;
    }

    public final void a() {
        PSTopContainer r100 = this.f139703a;
        f52.c r101 = this.f139704b;
        if (r100.f139672b == true) goto L6;
        PSTopContainer.p("request show after destroy. " + PSTopContainer.m(r101));
        return;
    L6:
        if (r101.f() != ConflictStrategy.INTERRUPT) goto L9;
        PSTopContainer.p("priorityLowerStrategy cannot be INTERRUPT. " + PSTopContainer.m(r101));
    L23:
        boolean r102 = false;
    L24:
        if (r102 == true) goto L27;
        r101.a(DiscardReason.INVALID);
        return;
    L27:
        if (r100.g(r101) == false) goto L32;
        f52.c r103 = r100.f139671a;
        if (r103 == null) goto L47;
        r103.e(r101, r100);
        return;
    L47:
        return;
    L32:
        if (r101.getStartTimestamp() <= 0) goto L41;
        long r104 = r101.getStartTimestamp() - System.currentTimeMillis();
        if (r104 <= 0) goto L37;
        r100.i(r101, r101.getStartTimestamp(), r104);
        return;
    L37:
        if (((-r104) / ((long) 1000)) > r101.l()) goto L39;
        r100.w(new PSTopContainer.a(r101, r101.getStartTimestamp()));
        return;
    L39:
        i.a("view is expired. " + PSTopContainer.m(r101));
        r101.a(DiscardReason.EXPIRED);
        return;
    L41:
        if (r101.getDelayTime() <= 0) goto L43;
        long r105 = 1000 * ((long) r101.getDelayTime());
        r100.i(r101, System.currentTimeMillis() + r105, r105);
        return;
    L43:
        r100.w(new PSTopContainer.a(r101, System.currentTimeMillis()));
        return;
    L9:
        if (r101.d() != ConflictStrategy.DISCARD) goto L12;
        PSTopContainer.p("priorityHigherStrategy cannot be DISCARD. " + PSTopContainer.m(r101));
        goto L23
    L12:
        if (r101.getEndTimestamp() <= 0) goto L14;
    L16:
        int r106 = r101.getType().getPriority();
        if (r106 >= 0) goto L19;
    L22:
        PSTopContainer.p("invalid priority " + r101.getType().getPriority() + ". " + PSTopContainer.m(r101));
        goto L23
    L19:
        if (100 < r106) goto L22;
        r102 = true;
        goto L24
    L14:
        if (r101.getDuration() >= 0) goto L16;
        PSTopContainer.p("neither endTimestamp nor duration is provided. " + PSTopContainer.m(r101));
        goto L23
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
