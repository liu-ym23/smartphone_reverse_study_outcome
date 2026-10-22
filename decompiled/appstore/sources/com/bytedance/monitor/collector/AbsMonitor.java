package com.bytedance.monitor.collector;

import android.util.Pair;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f7708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IAsyncTaskManager f7709e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RunMode {
        public static final int ASCRIBE = 3;
        public static final int NORMAL = 1;
        public static final int OFFLINE = 2;
        public static final int TURNOFF = 0;
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsMonitor f7711b;

        public a(AbsMonitor r10, int r11) {
            this.f7711b = r10;
            this.f7710a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsMonitor r10 = this.f7711b;
            int r11 = r10.f7706b;
            if (r11 > (-1)) goto L6;
            return;
        L6:
            if (r11 != 2) goto L11;
            int r12 = r10.f7707c;
            int r13 = this.f7710a;
            if (r12 == r13) goto L12;
            r10.f7707c = r13;
            r10.f(r13);
            return;
        L12:
            return;
        }
    }

    public AbsMonitor(int r10, String r11) {
        this.f7706b = 0;
        this.f7707c = 1;
        this.f7708d = false;
        this.f7705a = r11;
        this.f7707c = r10;
        PerfMonitorManager.o().a(this);
        this.f7709e = k5.a.a();
    }

    public abstract Pair a();

    public abstract Pair b(long r10, long r11);

    public final void c(int r10) {
        TaskRunnable r11 = k5.a.d("refreshConfig", new a(this, r10));
        IAsyncTaskManager r12 = this.f7709e;
        if (r12 == null) goto L6;
        r12.post(r11);
        return;
    }

    public void d() {
        if (this.f7706b < 0) goto L7;
        this.f7706b = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    public void e() {
        this.f7706b = 1;
    }

    public abstract void f(int r10);
}
