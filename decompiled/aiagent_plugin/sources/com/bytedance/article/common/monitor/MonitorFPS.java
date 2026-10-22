package com.bytedance.article.common.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MonitorFPS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Long f6051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Long f6052b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Long f6053c = null;
    private static int k;
    private static com.bytedance.apm.thread.b.InterfaceC0118b l;
    private static HashMap<String, a> m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FPSRecordView f6054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindowManager f6055e;
    private volatile boolean f;
    private b g;
    private c h;
    private String i;
    private Choreographer.FrameCallback j;

    /* JADX INFO: renamed from: com.bytedance.article.common.monitor.MonitorFPS$2, reason: invalid class name */
    class AnonymousClass2 implements Choreographer.FrameCallback {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ MonitorFPS this$0;

        AnonymousClass2(MonitorFPS r3) {
            this.this$0 = r3;
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r5) {
            if (this.mStartTime != (-1)) goto L6;
            this.mStartTime = r5;
        L6:
            if (MonitorFPS.a(this.this$0) == null) goto L8;
            MonitorFPS.a(this.this$0).a(r5 / 1000000);
        L8:
            long r6 = r5 - this.mStartTime;
            if (r6 <= MonitorFPS.b().longValue()) goto L14;
            double r0 = (((((long) this.mCounter) * 1000) * 1000) / r6) * MonitorFPS.c().longValue();
            if (MonitorFPS.b(this.this$0) == null) goto L13;
            MonitorFPS.b(this.this$0).a(r0);
        L13:
            MonitorFPS.a(MonitorFPS.c(this.this$0), (float) r0);
            MonitorFPS.a(this.this$0, false);
            return;
        L14:
            this.mCounter++;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    private class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ MonitorFPS this$0;

        static /* synthetic */ long access$002(FPSRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$102(FPSRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FPSRecordView(MonitorFPS r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.View
        public void onDraw(Canvas r5) {
            if (this.mStartTime != (-1)) goto L6;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mCounter = 0;
        L6:
            if (MonitorFPS.a(this.this$0) == null) goto L8;
            MonitorFPS.a(this.this$0).a(SystemClock.elapsedRealtime());
        L8:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= MonitorFPS.d().longValue()) goto L14;
            double r2 = (((double) this.mCounter) / r0) * MonitorFPS.c().longValue();
            if (MonitorFPS.b(this.this$0) == null) goto L13;
            MonitorFPS.b(this.this$0).a(r2);
        L13:
            MonitorFPS.a(MonitorFPS.c(this.this$0), (float) r2);
            this.this$0.a();
        L14:
            this.mCounter++;
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6060c;

        public a(int r1, float r2, long r3) {
            this.f6058a = r1;
            this.f6059b = r2;
            this.f6060c = r3;
        }
    }

    public interface b {
        void a(double r1);
    }

    public interface c {
        void a(long r1);
    }

    static /* synthetic */ c a(MonitorFPS r0) {
        return r0.h;
    }

    static /* synthetic */ void a(String r0, float r1) {
        b(r0, r1);
    }

    static /* synthetic */ boolean a(MonitorFPS r0, boolean r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ b b(MonitorFPS r0) {
        return r0.g;
    }

    static /* synthetic */ Long b() {
        return f6052b;
    }

    static /* synthetic */ Long c() {
        return f6053c;
    }

    static /* synthetic */ String c(MonitorFPS r0) {
        return r0.i;
    }

    static /* synthetic */ Long d() {
        return f6051a;
    }

    static /* synthetic */ HashMap e() {
        return m;
    }

    static /* synthetic */ int f() {
        return k;
    }

    static {
        Long r0 = 200L;
        f6051a = r0;
        f6052b = Long.valueOf((r0.longValue() * 1000) * 1000);
        f6053c = 1000L;
        k = 120;
        l = new AnonymousClass1();
        com.bytedance.apm.thread.b.a().a(l);
        m = new HashMap();
    }

    public synchronized void a() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f == false) goto L13;
        this.f = false;     // Catch: Throwable -> L15
        if (Build.VERSION.SDK_INT >= 16) goto L11;
        this.f6055e.removeView(this.f6054d);     // Catch: Exception -> L18 Throwable -> L15
        FPSRecordView.access$002(this.f6054d, -1);     // Catch: Exception -> L18 Throwable -> L15
        FPSRecordView.access$102(this.f6054d, 0);     // Catch: Exception -> L18 Throwable -> L15
        goto L13
    L11:
        if (this.j == null) goto L13;
        Choreographer.getInstance().removeFrameCallback(this.j);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    private static void b(final String r2, final float r3) {
        com.bytedance.apm.thread.b.a().a(new AnonymousClass3(r2, r3));
    }
}
