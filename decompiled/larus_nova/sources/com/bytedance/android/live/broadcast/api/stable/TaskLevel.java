package com.bytedance.android.live.broadcast.api.stable;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/stable/TaskLevel;", "", "", "level", "I", "getLevel", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "P_UNKNOWN", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskLevel extends Enum<TaskLevel> {
    public static final a Companion = null;
    public static final TaskLevel P0 = null;
    public static final TaskLevel P1 = null;
    public static final TaskLevel P2 = null;
    public static final TaskLevel P3 = null;
    public static final TaskLevel P_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskLevel[] f59077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59078b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f59079c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f59080d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f59081e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f59082f = null;
    private final int level;

    public static final class a {
        public a() {
        }

        public static final List a(a r100, int r101) {
            r100.getClass();
            List r102 = (List) TaskLevel.access$getLevelAll$cp().getValue();
            ArrayList r103 = new ArrayList();
            Iterator r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L11;
            Object r105 = r104.next();
            if (((TaskLevel) r105).getLevel() < r101) goto L8;
            boolean r106 = true;
        L9:
            if (r106 == false) goto L4;
            r103.add(r105);
            goto L4
        L8:
            r106 = false;
            goto L9
        L11:
            return r103;
        }
    }

    static {
        TaskLevel r100 = new TaskLevel("P_UNKNOWN", 0, -999);
        P_UNKNOWN = r100;
        TaskLevel r101 = new TaskLevel(DiagnoseResult.DIAGNOSE_LEVEL_P0, 1, 0);
        P0 = r101;
        TaskLevel r102 = new TaskLevel(DiagnoseResult.DIAGNOSE_LEVEL_P1, 2, 1);
        P1 = r102;
        TaskLevel r103 = new TaskLevel(DiagnoseResult.DIAGNOSE_LEVEL_P2, 3, 2);
        P2 = r103;
        TaskLevel r104 = new TaskLevel("P3", 4, 3);
        P3 = r104;
        f59077a = new TaskLevel[]{r100, r101, r102, r103, r104};
        Companion = new a();
        f59078b = LazyKt.lazy(TaskLevel$Companion$levelList$2.INSTANCE);
        f59079c = LazyKt.lazy(TaskLevel$Companion$levelAll$2.INSTANCE);
        f59080d = LazyKt.lazy(TaskLevel$Companion$aboveP1$2.INSTANCE);
        f59081e = LazyKt.lazy(TaskLevel$Companion$aboveP2$2.INSTANCE);
        f59082f = LazyKt.lazy(TaskLevel$Companion$aboveP3$2.INSTANCE);
    }

    public static TaskLevel valueOf(String r100) {
        return (TaskLevel) r27.a.a(TaskLevel.class, r100);
    }

    public static TaskLevel[] values() {
        return (TaskLevel[]) f59077a.clone();
    }

    public static final /* synthetic */ Lazy access$getAboveP1$cp() {
        return f59080d;
    }

    public static final /* synthetic */ Lazy access$getAboveP2$cp() {
        return f59081e;
    }

    public static final /* synthetic */ Lazy access$getAboveP3$cp() {
        return f59082f;
    }

    public static final /* synthetic */ Lazy access$getLevelAll$cp() {
        return f59079c;
    }

    public static final /* synthetic */ Lazy access$getLevelList$cp() {
        return f59078b;
    }

    public final int getLevel() {
        return this.level;
    }

    public TaskLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
