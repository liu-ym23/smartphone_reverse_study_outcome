package a9c;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoSceneType;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Deprecated(message = "Old hit points will be deleted!", replaceWith = @ReplaceWith(expression = "TodoGeneralHitPoint", imports = {}))
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2314a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2315a = null;

        static {
            int[] r100 = new int[TodoSceneType.values().length];
            r100[TodoSceneType.TODO_ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[TodoSceneType.TODO_ASSIGIN_FROM_ME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[TodoSceneType.TODO_COMPLETED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[TodoSceneType.TODO_FOLLOWED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[TodoSceneType.MESSAGE_TOOLBAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[TodoSceneType.INPUT_BOX.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[TodoSceneType.SINGLE_MESSAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[TodoSceneType.MULTIPLE_MESSAGES.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[TodoSceneType.MESSAGE_AFTER_FORWARDING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[TodoSceneType.CHAT_TODO_LIST.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f2315a = r100;
        }
    }

    static {
    }

    public static void a(String r100) {
        TodoDependencyHolder.a().statisticsDependency().sendEvent(r100);     // Catch: Exception -> L5
        Log.d("GeneralHitPoint", "eventKey:".concat(r100));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(e.getMessage());
    }

    public static void h(boolean r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == false) goto L5;
        String r102 = BdpAppEventConstant.YES;
    L6:
        b("todo_input_box_expand_click", r101.put("type", r102));
        return;
    L5:
        r102 = BdpAppEventConstant.NO;
        goto L6
    }

    public static void b(String r100, JSONObject r101) {
        TodoDependencyHolder.a().statisticsDependency().sendEvent(r100, r101);     // Catch: Exception -> L5
        Log.d("GeneralHitPoint", "eventKey:" + r100 + " param:" + r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(e.getMessage());
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "typeStr");
        Intrinsics.checkNotNullParameter(r101, "sourceStr");
        b("todo_add_performer", new JSONObject().put("type", r100).put("source", r101));
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        b("todo_task_follow", new JSONObject().put("task_id", r101).put("source", r100));
    }

    public static void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b("todo_comment", new JSONObject().put("action", r100).put("source", "task_detail").put("task_id", r101));
    }

    @JvmStatic
    public static final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceValue");
        Intrinsics.checkNotNullParameter(r101, "todoGuid");
        b("todo_task_click", new JSONObject().put("source", r100).put("task_id", r101));
    }

    @JvmStatic
    public static final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r102, "userId");
        b("todo_task_follow_cancel", new JSONObject().put("task_id", r101).put("type", r100).put("select_user_id", r102));
    }

    public static void i(boolean r100, String r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L5;
        String r104 = "create";
    L6:
        JSONObject r105 = r103.put("source", r104).put("task_id", r101);
        if (r102 == false) goto L9;
        String r106 = BdpAppEventConstant.YES;
    L10:
        b("todo_person_click", r105.put("state", r106));
        return;
    L9:
        r106 = BdpAppEventConstant.NO;
        goto L10
    L5:
        r104 = "detail";
        goto L6
    }

    @JvmStatic
    public static final void g(boolean r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "timeType");
        JSONObject r104 = new JSONObject();
        if (r100 == false) goto L5;
        String r105 = "create";
    L6:
        JSONObject r106 = r104.put("source", r105).put("task_id", r101);
        if (r102 == false) goto L9;
        String r107 = BdpAppEventConstant.YES;
    L10:
        b("todo_date_click", r106.put("state", r107).put("time_type", r103));
        return;
    L9:
        r107 = BdpAppEventConstant.NO;
        goto L10
    L5:
        r105 = "detail";
        goto L6
    }
}
