package com.bytedance.applet.task;

import com.google.gson.JsonObject;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kl9.l0;
import kl9.p0;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f192246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static q f192247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f192248c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f192249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f192250e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f192253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f192254d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f192251a, r101.f192251a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f192252b, r101.f192252b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f192253c, r101.f192253c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f192254d, r101.f192254d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f192251a.hashCode() * 31;
            String r101 = this.f192252b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f192253c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f192254d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "UpdateData(title=" + this.f192251a + ", content=" + this.f192252b + ", customIconId=" + this.f192253c + ", iconUrl=" + this.f192254d + ')';
        }

        public a(String r100, String r101, Integer r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f192251a = r100;
            this.f192252b = r101;
            this.f192253c = r102;
            this.f192254d = r103;
        }
    }

    public static final class b implements il9.d {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f192255a = null;

            static {
                int[] r100 = new int[TaskStatus.values().length];
                r100[TaskStatus.CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                f192255a = r100;
            }
        }

        public b() {
        }

        @Override // il9.d
        public final void a(String r100, TaskDisplayStatus r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "taskDisplayStatus");
            FLogger.f375446a.i("NavigationControlTask", "onRequestTaskDisplayStatusChange: " + r100 + ", " + r101);
        }

        @Override // il9.d
        public final void b(String r100, TaskStatus r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "taskStatus");
            FLogger r102 = FLogger.f375446a;
            r102.i("NavigationControlTask", "onRequestTaskStatusChange: " + r100 + ", " + r101);
            if (Intrinsics.areEqual(r100, p.f192246a) == true) goto L7;
            r102.i("NavigationControlTask", "onRequestTaskStatusChange: " + r100 + " is not our task");
            return;
        L7:
            if (a.f192255a[r101.ordinal()] != 1) goto L9;
            r102.i("NavigationControlTask", "cancelNavigation");
            Lazy r103 = l3.d.f507201a;
            l3.d.c(new l3.a("flow.onNavigationCanceled", null, 6));
            return;
        L9:
            r102.e("NavigationControlTask", "onRequestTaskStatusChange: Unknown status " + r101);
        }

        @Override // il9.d
        public final boolean c(kl9.u r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "currentPage");
            FLogger r102 = FLogger.f375446a;
            r102.i("NavigationControlTask", "onInterceptTaskClick: " + r100);
            if (Intrinsics.areEqual(r100.f503979a, p.f192246a) == true) goto L6;
            r102.i("NavigationControlTask", "onInterceptTaskClick: " + r100 + " is not our task");
            return false;
        L6:
            r102.i("NavigationControlTask", "openNavigationDetail");
            Lazy r103 = l3.d.f507201a;
            JsonObject r104 = new JsonObject();
            r104.addProperty("pageId", "ll_nav_detail");
            JsonObject r105 = new JsonObject();
            r105.addProperty("from", "multi_task");
            Unit r106 = Unit.INSTANCE;
            r104.add("pageData", r105);
            l3.d.c(new l3.a("flow.onOpenPageDemand", r104, 4));
            return true;
        }
    }

    public p() {
    }

    static {
        f192248c = new b();
        f192250e = true;
    }

    public static void c() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NavigationControlTask$updateNavigationToStop$1(null), 3, null);
    }

    public static final void a(boolean r110) {
        if (f192250e == r110) goto L23;
        f192250e = r110;
        String r100 = f192246a;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L24;
        FLogger.f375446a.i("NavigationControlTask", "visible changed to " + r110);
        il9.a r111 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r111 == null) goto L25;
        String r102 = f192246a;
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        TaskStatus r103 = null;
        if (f192250e == false) goto L20;
        TaskDisplayStatus r104 = TaskDisplayStatus.DISPLAYED;
    L21:
        r111.P(new p0(r102, null, new l0(r103, r104, null, null, 4093)), false);
        return;
    L20:
        r104 = TaskDisplayStatus.HIDDEN;
        goto L21
    L25:
        return;
    L24:
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public static void b(String r110, String r111, Integer r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "title");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NavigationControlTask$updateNavigation$1(r110, r111, r112, r113, null), 3, null);
    }
}
