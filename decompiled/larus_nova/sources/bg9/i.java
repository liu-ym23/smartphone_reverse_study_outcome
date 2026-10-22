package bg9;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.util.u;
import com.larus.init.task.base.TaskDurationCollector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface i extends Runnable {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
        public static void a(final i r210) {
            String r110 = r210.getScene();
            String r111 = r210.v();
            Function0 r100 = new g(r210);
            Lazy r101 = com.larus.init.task.base.a.f351189a;
            Intrinsics.checkNotNullParameter(r110, "scene");
            Intrinsics.checkNotNullParameter(r111, "style");
            Intrinsics.checkNotNullParameter(r210, "task");
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            String r102 = r210.getClass().getSimpleName();
            String r103 = ThreadMethodProxy.currentThread().getName();
            String r104 = com.bytedance.apm.d.c();
            long r112 = System.currentTimeMillis();
            boolean r113 = u.a();
            TaskDurationCollector r105 = TaskDurationCollector.f351177a;
            if (TaskDurationCollector.f351184h == true) goto L7;
            TaskDurationCollector.AppInitStage r106 = TaskDurationCollector.AppInitStage.FIRST_FRAME;
        L5:
            TaskDurationCollector.AppInitStage r114 = r106;
            FLogger r107 = FLogger.f375446a;     // Catch: Throwable -> L23
            r107.d("flow_init", "[" + r102 + "] start, thread:" + r103 + ", process:" + r104);     // Catch: Throwable -> L23
            r100.invoke();     // Catch: Throwable -> L23
            long r108 = System.currentTimeMillis() - r112;     // Catch: Throwable -> L23
            r107.d("flow_init", "[" + r102 + "] end success, duration:" + r108 + "ms, thread:" + r103 + ", process:" + r104);     // Catch: Throwable -> L23
            TaskDurationCollector.f351177a.a(r110, r113, r114, r102, r108);     // Catch: Throwable -> L23
            com.larus.init.task.base.a.b(r110, r111, r113, r114, r102, r104, r103, r108, true);     // Catch: Throwable -> L21
            return;
        L21:
            th = th;
        L25:
            Throwable r211 = th;
            long r109 = System.currentTimeMillis() - r112;
            FLogger.f375446a.e("flow_init", "[" + r102 + "] end failure, duration:" + r109 + "ms, thread:" + r103 + ", process:" + r104 + ", err:" + r211.getMessage());
            TaskDurationCollector.f351177a.a(r110, r113, r114, r102, r109);
            com.larus.init.task.base.a.b(r110, r111, r113, r114, r102, r104, r103, r109, false);
            throw r211;
        L23:
            th = th;
            goto L25
        L7:
            if (TaskDurationCollector.f351184h == false) goto L12;
            if (TaskDurationCollector.f351185i == true) goto L12;
            r106 = TaskDurationCollector.AppInitStage.FIRST_FEED;
        L12:
            if (TaskDurationCollector.f351184h == true) goto L14;
        L16:
            r106 = TaskDurationCollector.AppInitStage.DEFAULT;
            goto L5
        L14:
            if (TaskDurationCollector.f351185i == false) goto L16;
            r106 = TaskDurationCollector.AppInitStage.OTHER;
            goto L5
        }
    }

    String getScene();

    @Override // java.lang.Runnable
    void run();

    void runInternal();

    String v();
}
