package com.bytedance.android.ec.core.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.g;
import com.larus.apm.impl.protector.RunnableProtector;
import et3.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class RealFpsMonitor implements jh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f45148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f45149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f45150c;

    public static final class a implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealFpsMonitor f45151a;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor$a$a, reason: collision with other inner class name */
        public static final class RunnableC0806a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f45152a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ double f45153b;

            public RunnableC0806a(a r100, double r101) {
                this.f45152a = r100;
                this.f45153b = r101;
            }

            public final void a() {
                System.out.println("Django: " + this.f45152a.f45151a.f45150c.f45192a + " fps: " + this.f45153b);
                g r100 = g.f48122a;
                String r101 = this.f45152a.f45151a.f45150c.f45192a;
                JSONObject r102 = new JSONObject();
                r102.put("FPS", this.f45153b);
                r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
                r102.put("EVENT_FUNCTION_FEATURE", "TEMAI_MONITOR");
                JSONObject r103 = this.f45152a.f45151a.f45150c.f45193b;
                if (r103 == null) goto L5;
                String r104 = String.valueOf(r103);
            L6:
                z1.c(r102, r104);
                Unit r105 = Unit.INSTANCE;
                r100.logV3(r101, r102);
                return;
            L5:
                r104 = "";
                goto L6
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

        public a(RealFpsMonitor r100) {
            this.f45151a = r100;
        }

        @Override // et3.c.d
        public final void fpsCallBack(double r100) {
            oh.a.d(this.f45151a.f45150c.f45192a, new RunnableC0806a(this, r100));
        }
    }

    public final void a() {
        this.f45148a.d();
    }

    @Override // jh.a
    public final void stop() {
        this.f45148a.f();
    }

    public RealFpsMonitor(q r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
        this.f45150c = r100;
        c r101 = new c(r100.f45192a);
        r101.c(new a(this));
        Unit r102 = Unit.INSTANCE;
        this.f45148a = r101;
    }

    public final void b(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.addOnScrollListener(new RealFpsMonitor$startRecyclerView$1(this));
    }
}
