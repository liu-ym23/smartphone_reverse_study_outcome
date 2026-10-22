package com.bytedance.android.anniex.scene.next;

import android.os.Build;
import com.bytedance.android.anniex.scene.handler.idle.TaskStatus;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.handler.idle.i;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f41254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f41255b = null;

    public static final class a implements i {

        /* JADX INFO: renamed from: com.bytedance.android.anniex.scene.next.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0763a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f41256a = null;

            static {
                int[] r100 = new int[TaskStatus.values().length];
                r100[TaskStatus.FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[TaskStatus.TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[TaskStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f41256a = r100;
            }
        }

        public a() {
        }

        @Override // com.bytedance.android.anniex.scene.handler.idle.i
        public final void a(TaskType r100, String r101, String r102, String r103, TaskStatus r104) {
            Intrinsics.checkNotNullParameter(r100, "taskType");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r104, "status");
            int r105 = C0763a.f41256a[r104.ordinal()];
            if (r105 != 1) goto L5;
        L9:
            if (r102 == null) goto L20;
            b r106 = b.f41254a;
            monitor-enter(r106);
            long r107 = System.currentTimeMillis();     // Catch: Throwable -> L17
            if (Intrinsics.areEqual(r103, "view_pre_create") == false) goto L15;
            Long r108 = Long.valueOf(r107);     // Catch: Throwable -> L17
            ((ConcurrentHashMap) b.f41255b).put(r102, r108);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r106);
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            return;
        L5:
            if (r105 == 2) goto L9;
            if (r105 == 3) goto L9;
        }
    }

    public b() {
    }

    static {
        f41254a = new b();
        f41255b = new ConcurrentHashMap();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        com.bytedance.android.anniex.scene.handler.idle.h r100 = com.bytedance.android.anniex.scene.handler.idle.h.f41220a;
        TaskType r101 = TaskType.NEXT_THRESHOLD_PREDICT;
        a r102 = new a();
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "listener");
        com.bytedance.android.anniex.scene.handler.idle.h.f41227h.computeIfAbsent(r101, com.bytedance.android.anniex.scene.handler.idle.g.f41219a).add(r102);
        return;
    }
}
