package com.bytedance.bdtracker;

import android.os.Process;
import com.bytedance.applog.exception.AppCrashType;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import java.lang.Thread;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class m0 implements Thread.UncaughtExceptionHandler {
    public static volatile m0 b;
    public final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();

    public class a implements b.g {
        public a(m0 m0Var) {
        }

        @Override // com.bytedance.bdtracker.b.g
        public boolean a(d dVar) {
            return dVar.getInitConfig() != null && AppCrashType.hasJavaCrashType(dVar.getInitConfig().getTrackCrashType());
        }
    }

    public class b implements b.f {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ b.g b;
        public final /* synthetic */ l4 c;

        public b(m0 m0Var, Throwable th, b.g gVar, l4 l4Var) {
            this.a = th;
            this.b = gVar;
            this.c = l4Var;
        }

        @Override // com.bytedance.bdtracker.b.f
        public void a(d dVar) {
            if (dVar.getInitConfig() != null && dVar.getInitConfig().isMonitorEnabled()) {
                o2.b(dVar.getMonitor(), this.a);
            }
            if (this.b.a(dVar)) {
                dVar.receive(this.c);
                dVar.flush();
            }
        }
    }

    public m0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized void a() {
        if (b == null) {
            b = new m0();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a aVar = new a(this);
        try {
            if (!com.bytedance.bdtracker.b.b(aVar)) {
                com.bytedance.bdtracker.b.a(new n0(this, th));
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                } else {
                    Process.killProcess(Process.myPid());
                    System.exit(10);
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$is_backstage", !w.b);
                jSONObject.put("$event_time", jCurrentTimeMillis);
                jSONObject.put("$crash_thread", thread.getName());
                jSONObject.put("$crash_process", r.b());
                StringBuilder sb = new StringBuilder();
                for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                    sb.append(cause.toString());
                    for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                        sb.append("\n\tat ");
                        sb.append(stackTraceElement);
                    }
                }
                jSONObject.put("$detailed_stack", sb.length() > 2000 ? sb.substring(0, 2000) : sb.toString());
            } catch (Throwable th2) {
                LoggerImpl.global().error(Collections.singletonList("ExceptionHandler"), "Collect crash params failed", th2, new Object[0]);
            }
            com.bytedance.bdtracker.b.a(new b(this, th, aVar, new l4("$crash", jSONObject)));
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.a;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            } else {
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        } catch (Throwable unused) {
        }
    }
}
