package a9c;

import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;
import z5c.c2;
import z5c.i1;
import z5c.o3;
import z5c.p3;
import z5c.r;
import z5c.r3;
import z5c.u;
import z5c.v;
import z5c.w;
import z5c.x;
import z5c.y3;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2310a = 0;

    /* JADX INFO: renamed from: a9c.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0035a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2311a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2312b = null;

        static {
            int[] r100 = new int[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.values().length];
            r100[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f2311a = r100;
            int[] r101 = new int[TaskContainerFilter.TabFilter.TaskContainerTabCategory.values().length];
            r101[TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_CREATED_BY_ME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_COLLABORATED_WITH_ME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_FROM_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_FROM_CHAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f2312b = r101;
        }
    }

    static {
    }

    public a() {
    }

    public static d a(TaskContainer r100) {
        d r101 = d.b.b(x.f570398c.a(r100.key), v.f570386c.a(String.valueOf(r100.category.getValue()))).plus(w.f570392c.a(r100.guid));     // Catch: Exception -> L10
        if (r100.category == TaskContainer.Category.TASK_LIST) goto L5;
        return r101;
    L5:
        if (r100.archived_milli_time.longValue() <= 0) goto L7;
        s5c.a r102 = i1.f570219c;     // Catch: Exception -> L10
    L8:
        return r101.plus(r102);
    L7:
        r102 = i1.f570220d;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.w("TodoCenterHitPoint", "getTaskContainerPublicParams", e);
        return x.f570398c.a("");
    }

    public static s5c.a b(TaskContainerFilter.TabFilter.TaskContainerTabCategory r100) {
        int r101 = C0035a.f2312b[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return o3.f570271c;
    L17:
        return o3.f570275g;
    L18:
        return o3.f570274f;
    L19:
        return o3.f570273e;
    L15:
        return o3.f570272d;
    }

    public static void e(boolean r100) {
        s5c.a r101 = r.f570347v1;
        s5c.a r102 = u.f570377c;
        r101.getClass();
        d r103 = d.b.b(r101, r102).plus(p3.f570282c);
        if (r100 == false) goto L5;
        s5c.a r104 = c2.f570176n;
    L6:
        c("todo_mobile_container_menu_click", r103.plus(r104).toJson());
        return;
    L5:
        r104 = c2.f570174l;
        goto L6
    }

    public static void f(boolean r100) {
        s5c.a r101 = r.Q2;
        s5c.a r102 = p3.f570282c;
        r101.getClass();
        d r103 = d.b.b(r101, r102);
        if (r100 == false) goto L5;
        s5c.a r104 = c2.f570175m;
    L6:
        c("todo_mobile_container_menu_click", r103.plus(r104).toJson());
        return;
    L5:
        r104 = c2.f570174l;
        goto L6
    }

    public static void c(String r100, JSONObject r101) {
        TodoDependencyHolder.a().statisticsDependency().sendEvent(r100, r101);     // Catch: Exception -> L5
        Log.d("TodoGeneralHitPoint", "eventKey:" + r100 + " param:" + r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("TodoCenterHitPoint", e);
    }

    public static void g(String r100, TaskContainer r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskContainer");
        s5c.a r102 = r.B;
        s5c.a r103 = r3.f570361c.a(r100);
        r102.getClass();
        c("todo_center_task_list_click", d.b.b(r102, r103).plus(p3.f570282c).plus(a(r101)).toJson());
    }

    public static void d(ContainerType r100, TaskContainer.Category r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        Intrinsics.checkNotNullParameter(r101, "category");
        s5c.a r103 = r.T;
        s5c.a r104 = p3.f570287h;
        r103.getClass();
        d r105 = d.b.b(r103, r104);
        x r106 = x.f570398c;
        ContainerType.Companion.getClass();
        d r107 = r105.plus(r106.a(ContainerType.a.a(r100))).plus(v.f570386c.a(String.valueOf(r101.getValue())));
        w r108 = w.f570392c;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        c("todo_mobile_container_menu_click", r107.plus(r108.a(r102)).toJson());
    }

    public static void h(TaskContainer r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "taskContainer");
        s5c.a r103 = r.f570340p2;
        s5c.a r104 = p3.f570282c;
        r103.getClass();
        d r105 = d.b.b(r103, r104);
        if (r101 == false) goto L5;
        s5c.a r106 = y3.f570412d;
    L6:
        d r107 = r105.plus(r106);
        if (r102 == false) goto L9;
        s5c.a r108 = c2.f570171i;
    L10:
        c("todo_center_task_list_click", r107.plus(r108).plus(a(r100)).toJson());
        return;
    L9:
        r108 = c2.f570169g;
        goto L10
    L5:
        r106 = y3.f570420l;
        goto L6
    }

    public static void i(String r100, ContainerType r101, TaskContainer.Category r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "containerType");
        Intrinsics.checkNotNullParameter(r102, "category");
        if (r103 == false) goto L5;
        s5c.a r105 = c2.f570172j;
    L6:
        x r106 = x.f570398c;
        ContainerType.Companion.getClass();
        d r107 = d.b.b(r106.a(ContainerType.a.a(r101)), v.f570386c.a(String.valueOf(r102.getValue()))).plus(w.f570392c.a(r100)).plus(r105);
        if (r102 != TaskContainer.Category.TASK_LIST) goto L12;
        if (r104 == false) goto L10;
        s5c.a r108 = i1.f570219c;
    L11:
        r107 = r107.plus(r108);
        goto L12
    L10:
        r108 = i1.f570220d;
    L12:
        c("todo_task_list_detail_view", r107.toJson());
        return;
    L5:
        r105 = c2.f570173k;
        goto L6
    }
}
