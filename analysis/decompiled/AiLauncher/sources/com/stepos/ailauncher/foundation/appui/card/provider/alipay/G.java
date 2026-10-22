package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.app.ActivityManager;
import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017RT\u0010\u001a\u001aB\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u000b0\u000b \u0019* \u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/G;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/G$a;", "tasks", "", "alipayPkg", "", "defaultDisplayId", "", "e", "(Ljava/util/List;Ljava/lang/String;I)Z", Const.INTENT_KEY_UMID, "()Z", "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Ljava/util/List;", "Landroid/app/ActivityManager$RunningTaskInfo;", "task", Const.INTENT_KEY_PKGNAME, "(Landroid/app/ActivityManager$RunningTaskInfo;)I", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "virtualPreviews", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "DEFAULT_DISPLAY_ID", "I", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final int DEFAULT_DISPLAY_ID = 0;
    public static final G INSTANCE = new G();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> virtualPreviews = ConcurrentHashMap.newKeySet();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/G$a;", "", "", "packageName", "", "displayId", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.G$a, reason: from toString */
    public static final /* data */ class TaskSnap {
        private final int displayId;
        private final String packageName;

        public TaskSnap(String packageName, int i10) {
            kotlin.jvm.internal.p.i(packageName, "packageName");
            this.packageName = packageName;
            this.displayId = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getDisplayId() {
            return this.displayId;
        }

        /* renamed from: b, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskSnap)) {
                return false;
            }
            TaskSnap taskSnap = (TaskSnap) other;
            return kotlin.jvm.internal.p.d(this.packageName, taskSnap.packageName) && this.displayId == taskSnap.displayId;
        }

        public int hashCode() {
            return (this.packageName.hashCode() * 31) + Integer.hashCode(this.displayId);
        }

        public String toString() {
            return "TaskSnap(packageName=" + this.packageName + ", displayId=" + this.displayId + ")";
        }
    }

    public static final Class c(Class it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSuperclass();
    }

    public static /* synthetic */ boolean f(G g10, List list, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = C3236a.PKG_ALIPAY;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return g10.e(list, str, i10);
    }

    public final int b(ActivityManager.RunningTaskInfo task) {
        Object objB;
        Integer num;
        Field field;
        Object obj;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = task.getClass();
            kotlin.jvm.internal.p.g(cls, "null cannot be cast to non-null type java.lang.Class<*>");
            Iterator it = Ka.t.q(cls, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.F
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return G.c((Class) obj2);
                }
            }).iterator();
            while (true) {
                if (!it.hasNext()) {
                    num = null;
                    break;
                }
                Field[] declaredFields = ((Class) it.next()).getDeclaredFields();
                kotlin.jvm.internal.p.h(declaredFields, "getDeclaredFields(...)");
                int length = declaredFields.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i10];
                    if (kotlin.jvm.internal.p.d(field.getName(), "displayId")) {
                        break;
                    }
                    i10++;
                }
                if (field != null) {
                    field.setAccessible(true);
                    obj = field.get(task);
                } else {
                    obj = null;
                }
                num = obj instanceof Integer ? (Integer) obj : null;
                if (num != null) {
                    break;
                }
            }
            objB = Result.b(num);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Integer num2 = (Integer) (Result.g(objB) ? null : objB);
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    public final boolean d() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Application application = (Application) objB;
        if (application == null) {
            return false;
        }
        return f(this, g(application), null, 0, 6, null);
    }

    public final boolean e(List<TaskSnap> tasks, String alipayPkg, int defaultDisplayId) {
        Object next;
        kotlin.jvm.internal.p.i(tasks, "tasks");
        kotlin.jvm.internal.p.i(alipayPkg, "alipayPkg");
        Iterator<T> it = tasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((TaskSnap) next).getDisplayId() == defaultDisplayId) {
                break;
            }
        }
        TaskSnap taskSnap = (TaskSnap) next;
        if (taskSnap == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(taskSnap.getPackageName(), alipayPkg);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[Catch: all -> 0x0068, PHI: r2
      0x0051: PHI (r2v5 java.lang.String) = (r2v3 java.lang.String), (r2v6 java.lang.String) binds: [B:20:0x004e, B:15:0x0041] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0068, blocks: (B:6:0x0014, B:8:0x001e, B:9:0x0022, B:10:0x002d, B:12:0x0033, B:14:0x003d, B:22:0x0051, B:24:0x005f, B:16:0x0043, B:18:0x0048, B:25:0x0063), top: B:34:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.ailauncher.foundation.appui.card.provider.alipay.G.TaskSnap> g(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r5, r0)
            java.lang.Class<android.app.ActivityManager> r0 = android.app.ActivityManager.class
            java.lang.Object r5 = r5.getSystemService(r0)
            android.app.ActivityManager r5 = (android.app.ActivityManager) r5
            if (r5 != 0) goto L14
            java.util.List r4 = Z8.C1173v.m()
            return r4
        L14:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L68
            r0 = 8
            java.util.List r5 = r5.getRunningTasks(r0)     // Catch: java.lang.Throwable -> L68
            if (r5 != 0) goto L22
            java.util.List r5 = Z8.C1173v.m()     // Catch: java.lang.Throwable -> L68
        L22:
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L68
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L68
            r0.<init>()     // Catch: java.lang.Throwable -> L68
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L68
        L2d:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L63
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L68
            android.app.ActivityManager$RunningTaskInfo r1 = (android.app.ActivityManager.RunningTaskInfo) r1     // Catch: java.lang.Throwable -> L68
            android.content.ComponentName r2 = r1.topActivity     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto L43
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> L68
            if (r2 != 0) goto L51
        L43:
            android.content.ComponentName r2 = r1.baseActivity     // Catch: java.lang.Throwable -> L68
            r3 = 0
            if (r2 == 0) goto L4d
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> L68
            goto L4e
        L4d:
            r2 = r3
        L4e:
            if (r2 != 0) goto L51
            goto L5d
        L51:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.G$a r3 = new com.stepos.ailauncher.foundation.appui.card.provider.alipay.G$a     // Catch: java.lang.Throwable -> L68
            kotlin.jvm.internal.p.f(r1)     // Catch: java.lang.Throwable -> L68
            int r1 = r4.b(r1)     // Catch: java.lang.Throwable -> L68
            r3.<init>(r2, r1)     // Catch: java.lang.Throwable -> L68
        L5d:
            if (r3 == 0) goto L2d
            r0.add(r3)     // Catch: java.lang.Throwable -> L68
            goto L2d
        L63:
            java.lang.Object r4 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L68
            goto L73
        L68:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L73:
            java.util.List r5 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r4)
            if (r0 == 0) goto L7e
            r4 = r5
        L7e:
            java.util.List r4 = (java.util.List) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.G.g(android.content.Context):java.util.List");
    }
}
