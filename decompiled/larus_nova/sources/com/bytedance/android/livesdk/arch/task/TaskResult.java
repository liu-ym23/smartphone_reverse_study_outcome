package com.bytedance.android.livesdk.arch.task;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TaskResult {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f103870c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskId f103872b;

    public static final class a {
    }

    public static final class b extends TaskResult {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TaskFailureException f103873d;

        public b(TaskId r100, TaskFailureException r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "error");
            super(r100);
            this.f103873d = r101;
        }
    }

    public static final class c extends TaskResult {
        public c(TaskId r100) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            super(r100);
        }
    }

    static {
    }

    public TaskResult(TaskId r100) {
        this.f103872b = r100;
        this.f103871a = LazyKt.lazy(TaskResult$payload$2.INSTANCE);
    }
}
