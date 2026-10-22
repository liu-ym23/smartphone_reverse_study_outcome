package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f5551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f5552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f5553d;

    public m(Context r11, TaskExecutor r12) {
        q.g(r11, "context");
        q.g(r12, "taskExecutor");
        g r10 = null;
        c r13 = null;
        g r14 = null;
        g r15 = null;
        this(r11, r12, r10, r13, r14, r15, 60, null);
    }

    public final g a() {
        return this.f5550a;
    }

    public final c b() {
        return this.f5551b;
    }

    public final g c() {
        return this.f5552c;
    }

    public final g d() {
        return this.f5553d;
    }

    public m(Context r10, TaskExecutor r11, g r12, c r13, g r14, g r15) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        q.g(r12, "batteryChargingTracker");
        q.g(r13, "batteryNotLowTracker");
        q.g(r14, "networkStateTracker");
        q.g(r15, "storageNotLowTracker");
        this.f5550a = r12;
        this.f5551b = r13;
        this.f5552c = r14;
        this.f5553d = r15;
    }

    public /* synthetic */ m(Context r10, TaskExecutor r11, g r12, c r13, g r14, g r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        Context r18 = r10.getApplicationContext();
        q.f(r18, "context.applicationContext");
        g r19 = new a(r18, r11);
    L7:
        if ((r16 & 8) == 0) goto L9;
        Context r20 = r10.getApplicationContext();
        q.f(r20, "context.applicationContext");
        c r21 = new c(r20, r11);
    L11:
        if ((r16 & 16) == 0) goto L13;
        Context r22 = r10.getApplicationContext();
        q.f(r22, "context.applicationContext");
        g r23 = j.a(r22, r11);
    L15:
        if ((r16 & 32) == 0) goto L17;
        Context r24 = r10.getApplicationContext();
        q.f(r24, "context.applicationContext");
        g r25 = new k(r24, r11);
    L18:
        this(r10, r11, r19, r21, r23, r25);
        return;
    L17:
        r25 = r15;
        goto L18
    L13:
        r23 = r14;
        goto L15
    L9:
        r21 = r13;
        goto L11
    L5:
        r19 = r12;
        goto L7
    }
}
