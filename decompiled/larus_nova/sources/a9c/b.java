package a9c;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;
import z5c.c2;
import z5c.p3;
import z5c.r;
import z5c.y3;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2313a = null;

    static {
        f2313a = new b();
    }

    public b() {
    }

    public final void q() {
        b(this, "setting_todo_default_alert_time_click", new JSONObject().put("click", "cancel").put(PickerReporterConstants.KEY.TARGET, "setting_todo_view"), 4);
    }

    public final void g(boolean r100) {
        JSONObject r101 = new JSONObject().put("click", "allow_badge").put(PickerReporterConstants.KEY.TARGET, "none");
        if (r100 == false) goto L5;
        String r102 = "off_to_on";
    L6:
        b(this, "setting_todo_badge_click", r101.put("status", r102), 4);
        return;
    L5:
        r102 = "on_to_off";
        goto L6
    }

    public final void h(boolean r100) {
        JSONObject r101 = new JSONObject().put("click", "badge_type").put(PickerReporterConstants.KEY.TARGET, "none");
        if (r100 == false) goto L5;
        String r102 = "overdue_or_due_today";
    L6:
        b(this, "setting_todo_badge_click", r101.put("status", r102), 4);
        return;
    L5:
        r102 = "overdue";
        goto L6
    }

    public final void p(boolean r100) {
        JSONObject r101 = new JSONObject().put("click", "task_alert").put(PickerReporterConstants.KEY.TARGET, "setting_todo_view");
        if (r100 == false) goto L5;
        String r102 = "off_to_on";
    L6:
        b(this, "setting_todo_click", r101.put("status", r102), 4);
        return;
    L5:
        r102 = "on_to_off";
        goto L6
    }

    public static void j(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        JSONObject r102 = new JSONObject().put("click", "done_all_task").put(PickerReporterConstants.KEY.TARGET, "none");
        if (r101 == false) goto L5;
        String r103 = "undone_to_done";
    L6:
        a("todo_task_detail_click", r102.put("status", r103), r100);
        return;
    L5:
        r103 = "done_to_undone";
        goto L6
    }

    public static void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        JSONObject r102 = new JSONObject().put("click", "done_my_task").put(PickerReporterConstants.KEY.TARGET, "none");
        if (r101 == false) goto L5;
        String r103 = "undone_to_done";
    L6:
        a("todo_task_detail_click", r102.put("status", r103), r100);
        return;
    L5:
        r103 = "done_to_undone";
        goto L6
    }

    public static void m(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        if (r101 == false) goto L6;
        String r103 = "mark_milestone";
    L7:
        a("todo_task_detail_click", r102.put("click", r103).put(PickerReporterConstants.KEY.TARGET, "none"), r100);     // Catch: Exception -> L9
        return;
    L6:
        r103 = "unmark_milestone";
    L9:
        e = move-exception;
        Log.e("TodoGeneralHitPoint", "sendEventTodoDetailSetMileStoneClick", e);
    }

    @JvmStatic
    public static final void u(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "clickStr");
        a("todo_task_detail_click", new JSONObject().put("click", r101).put(PickerReporterConstants.KEY.TARGET, "none"), r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("TodoGeneralHitPoint", "sendEventUpdateDependentClick error", e);
    }

    public static void a(String r100, JSONObject r101, String r102) {
        if (r102 != null) goto L17;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        r101.put("task_id", r102);     // Catch: Exception -> L8
    L13:
        TodoDependencyHolder.a().statisticsDependency().sendEvent(r100, r101);     // Catch: Exception -> L8
        Log.d("TodoGeneralHitPoint", "eventKey:" + r100 + " param:" + r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("TodoGeneralHitPoint", e.getMessage());
        return;
    L17:
        if (r102.length() == 0) goto L10;
        r103 = false;
        goto L11
    }

    public static void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r102, "typeStr");
        a("todo_card_click", new JSONObject().put("msg_id", r101).put("type", r102).put("click", "detail").put(PickerReporterConstants.KEY.TARGET, "todo_task_detail_view"), r100);
    }

    @JvmStatic
    public static final void l(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "clickValue");
        JSONObject r103 = new JSONObject().put("click", r101);
        switch(r101.hashCode()) {
            case -1370992390: goto L27;
            case -29935091: goto L24;
            case 3357525: goto L21;
            case 109400031: goto L17;
            case 911791335: goto L15;
            case 1292382592: goto L14;
            case 1645587490: goto L13;
            case 2074367340: goto L10;
            case 2074403919: goto L6;
            default: goto L30;
        };
    L13:
        r101.equals("done_task");
        goto L30
    L14:
        r101.equals("done_all_task");
        goto L30
    L15:
        String r104 = "delete_executor";
    L25:
        r101.equals(r104);
        goto L30
    L24:
        r104 = "leave_task";
    L30:
        String r105 = "none";
    L31:
        JSONObject r106 = r103.put(PickerReporterConstants.KEY.TARGET, r105);
        if (Intrinsics.areEqual(r101, "done_task") == false) goto L34;
    L35:
        if (r102 == false) goto L37;
        String r107 = "undone_to_done";
    L38:
        r106.put("status", r107);
    L39:
        a("todo_task_detail_click", r106, r100);
        return;
    L37:
        r107 = "done_to_undone";
        goto L38
    L34:
        if (Intrinsics.areEqual(r101, "done_all_task") == false) goto L39;
    L6:
        if (r101.equals("source_link_from_docs") == false) goto L30;
        r105 = "ccm_docs_page_view";
        goto L31
    L10:
        if (r101.equals("source_link_from_chat") == false) goto L30;
        r105 = "im_chat_main_view";
        goto L31
    L17:
        if (r101.equals("share") == false) goto L30;
        r105 = "public_share_view";
        goto L31
    L21:
        if (r101.equals("more") == false) goto L30;
        r105 = "todo_task_more_option_view";
        goto L31
    L27:
        if (r101.equals("view_history") == false) goto L30;
        r105 = "todo_task_history_view";
        goto L31
    }

    public static void o(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "clickParam");
        Intrinsics.checkNotNullParameter(r102, "selectType");
        a("todo_select_click", new JSONObject().put("click", r101).put(PickerReporterConstants.KEY.TYPE, r102), r100);
    }

    public static void s(String r100, boolean r101, boolean r102) {
        if (r101 == false) goto L6;
        if (r102 == false) goto L5;
        s5c.a r103 = c2.f570166d;
    L9:
        s5c.a r104 = r.E;
        r104.getClass();
        a("todo_task_owner_select_click", d.b.b(r104, r103).toJson(), r100);
        return;
    L5:
        r103 = c2.f570165c;
        goto L9
    L6:
        if (r102 == false) goto L8;
        r103 = c2.f570168f;
        goto L9
    L8:
        r103 = c2.f570167e;
        goto L9
    }

    public static void t(String r100, boolean r101, boolean r102) {
        if (r101 == false) goto L6;
        if (r102 == false) goto L5;
        s5c.a r103 = c2.f570166d;
    L9:
        s5c.a r104 = r.I2;
        r104.getClass();
        a("todo_task_owner_select_click", d.b.b(r104, r103).plus(p3.f570282c).toJson(), r100);
        return;
    L5:
        r103 = c2.f570165c;
        goto L9
    L6:
        if (r102 == false) goto L8;
        r103 = c2.f570168f;
        goto L9
    L8:
        r103 = c2.f570167e;
        goto L9
    }

    public static /* synthetic */ void b(b r100, String r101, JSONObject r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        if ((r103 & 4) == 0) goto L8;
        String r104 = "";
    L9:
        r100.getClass();
        a(r101, r102, r104);
        return;
    L8:
        r104 = null;
        goto L9
    }

    @JvmStatic
    public static final void c(String r100, TaskDependentSearchViewModel.Companion.TaskDependentType r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "taskType");
        Intrinsics.checkNotNullParameter(r102, "location");
        Intrinsics.checkNotNullParameter(r103, "clickType");
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L9
        if (r101 != TaskDependentSearchViewModel.Companion.TaskDependentType.PREV) goto L6;
        String r105 = "add_pre_requisite_task";
    L7:
        a("todo_task_detail_click", r104.put("click", r105).put("location", r102).put("click_type", r103).put(PickerReporterConstants.KEY.TARGET, "none"), r100);     // Catch: Exception -> L9
        return;
    L6:
        r105 = "add_subsequent_task";
    L9:
        e = move-exception;
        Log.e("TodoGeneralHitPoint", "sendEventAddDependentClick error", e);
    }

    public static void f(String r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r103, "targetValue");
        JSONObject r104 = new JSONObject().put("click", r103);
        if (r102 == false) goto L5;
        String r105 = "undone_to_done";
    L6:
        a("todo_im_chat_todo_list_click", r104.put("status", r105).put(PickerReporterConstants.KEY.TARGET, "none").put("chat_id", r101), r100);
        return;
    L5:
        r105 = "done_to_undone";
        goto L6
    }

    public static void n(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "selectType");
        a("todo_select_click", new JSONObject().put("click", "confirm").put(PickerReporterConstants.KEY.TYPE, r101).put("selected_member_count", r102).put("is_select_all", r103), r100);
    }

    public static void r(String r100, boolean r101, boolean r102, boolean r103) {
        if (r101 == false) goto L6;
        if (r102 == false) goto L5;
        s5c.a r104 = c2.f570166d;
    L9:
        if (r103 == false) goto L11;
        s5c.a r105 = y3.f570421m;
    L12:
        s5c.a r106 = r.J2;
        r106.getClass();
        a("todo_task_owner_select_click", d.b.b(r106, r105).plus(r104).plus(p3.f570282c).toJson(), r100);
        return;
    L11:
        r105 = y3.f570411c;
        goto L12
    L5:
        r104 = c2.f570165c;
        goto L9
    L6:
        if (r102 == false) goto L8;
        r104 = c2.f570168f;
        goto L9
    L8:
        r104 = c2.f570167e;
        goto L9
    }

    public static void d(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "statusValue");
        Intrinsics.checkNotNullParameter(r102, "targetValue");
        Intrinsics.checkNotNullParameter(r103, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r104, "typeStr");
        a("todo_card_click", new JSONObject().put("msg_id", r103).put("type", r104).put("click", r102).put(PickerReporterConstants.KEY.TARGET, "none").put("status", r101), r100);
    }

    public static void i(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        JSONObject r105 = new JSONObject().put("click", SVGRenderEngine.SAVE).put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L33
        if (r103 == false) goto L7;
        Object r106 = "true";
    L8:
        JSONObject r107 = r105.put("is_set_remind_time", r106);     // Catch: Exception -> L33
        if (r104 == false) goto L11;
        Object r108 = "true";
    L12:
        JSONObject r109 = r107.put("is_set_repeat_task", r108);     // Catch: Exception -> L33
        if (r102 == false) goto L16;
        r109.put("is_set_start_date", "true");     // Catch: Exception -> L33
    L18:
        if (r102 == false) goto L21;
        if (r110 == true) goto L21;
        r109.put("is_set_start_time", "true");     // Catch: Exception -> L33
    L23:
        if (r101 == false) goto L25;
        r109.put("is_set_due_date", "true");     // Catch: Exception -> L33
    L27:
        if (r101 == false) goto L30;
        if (r110 == true) goto L30;
        r109.put("is_set_due_time", "true");     // Catch: Exception -> L33
    L31:
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L33
        a("todo_date_select_click", r109, r100);     // Catch: Exception -> L33
        return;
    L30:
        r109.put("is_set_due_time", "false");     // Catch: Exception -> L33
        goto L31
    L25:
        r109.put("is_set_due_date", "false");     // Catch: Exception -> L33
    L21:
        r109.put("is_set_start_time", "false");     // Catch: Exception -> L33
        goto L23
    L16:
        r109.put("is_set_start_date", "false");     // Catch: Exception -> L33
        goto L18
    L11:
        r108 = "false";
        goto L12
    L7:
        r106 = "false";
    L33:
        e = move-exception;
        Log.e("TodoGeneralHitPoint", "sendEventTodoDateSelectClick", e);
    }
}
