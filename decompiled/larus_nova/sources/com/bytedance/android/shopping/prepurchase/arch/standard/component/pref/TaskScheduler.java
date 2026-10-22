package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.view.Choreographer;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.j;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.r;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class TaskScheduler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f180995i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f180996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, List<r>> f180997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f180998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f180999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f181000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NFrameWatcher f181001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f181002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f181003h;

    public static final class NFrameWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f181004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PostNFrameTask f181005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f181006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Unit> f181007d;

        public final class PostNFrameTask implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NFrameWatcher f181008a;

            public PostNFrameTask(NFrameWatcher r100) {
                this.f181008a = r100;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r100) {
                NFrameWatcher r101 = this.f181008a;
                int r102 = r101.f181004a + 1;
                r101.f181004a = r102;
                if (r102 != r101.f181006c) goto L5;
                r101.f181004a = -1;
                r101.f181007d.invoke();
                return;
            L5:
                com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$NFrameWatcher$PostNFrameTask$doFrame$1(this));
            }
        }

        public NFrameWatcher(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "readyCallback");
            this.f181006c = 3;
            this.f181007d = r100;
            this.f181004a = -1;
            this.f181005b = new PostNFrameTask(this);
        }
    }

    public static final class a {
    }

    static {
    }

    public TaskScheduler(StandardPrefService$taskScheduler$2.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        Intrinsics.checkNotNullParameter(r101, "logAbility");
        this.f181002g = r100;
        this.f181003h = r101;
        this.f180997b = new LinkedHashMap();
        this.f180999d = new e(this);
    }

    public static final boolean a(TaskScheduler r100, int r101) {
        if (r100.f180996a < r101) goto L5;
        return false;
    L5:
        r100.f180996a = r101;
        List<r> r102 = r100.f180997b.remove(Integer.valueOf(r101));
        j r103 = r100.f181003h;
        StringBuilder r104 = new StringBuilder("stage = ");
        r104.append(r101);
        r104.append(",taskSize=");
        if (r102 == null) goto L8;
        Integer r105 = Integer.valueOf(r102.size());
    L9:
        r104.append(r105);
        r103.d("TaskScheduler", r104.toString());
        b r106 = r100.f181000e;
        if (r106 == null) goto L12;
        r106.a(r101);
    L12:
        if (r102 == null) goto L15;
        r100.f181002g.a(r101, r102);
    L15:
        b r107 = r100.f181000e;
        if (r107 == null) goto L18;
        r107.b();
    L18:
        return true;
    L8:
        r105 = null;
        goto L9
    }

    public final void b(final int r100, final com.bytedance.android.shopping.prepurchase.arch.container.ability.b r101, final Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "task");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$enqueue$1(this, r100, r101, r102));
    }
}
