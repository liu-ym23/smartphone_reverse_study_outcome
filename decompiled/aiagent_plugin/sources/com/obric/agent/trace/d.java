package com.obric.agent.trace;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: CountdownTask.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Timer f15441c;

    /* JADX INFO: compiled from: CountdownTask.kt */
    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f15442a;

        a(d r1) {
            this.f15442a = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            q.f15713a.a(d.a(this.f15442a), false);
            ILogDepend.Companion.d("IntentTracer", d.a(this.f15442a) + " countdown task finish");
        }
    }

    public d(String r2, long r3) {
        d.h.b.o.e(r2, DbHelper.COL_ID);
        this.f15439a = r2;
        this.f15440b = r3;
    }

    public static final /* synthetic */ String a(d r0) {
        return r0.f15439a;
    }

    public final void a() {
        Timer r0 = new Timer("AppIntentState", false);
        r0.schedule((TimerTask) ZeusTransformUtils.preCheckCast(c(), TimerTask.class, "com.obric.aiagent.plugin"), this.f15440b);
        this.f15441c = r0;
    }

    private final a c() {
        return new a(this);
    }

    public final void b() {
        Timer r0 = this.f15441c;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }
}
