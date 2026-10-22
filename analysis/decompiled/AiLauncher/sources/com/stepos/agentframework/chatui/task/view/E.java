package com.stepos.agentframework.chatui.task.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.appui.AppUIGlobal;
import com.stepos.agentframework.chatui.appui.DisplayMode;
import com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView;
import com.stepos.agentframework.chatui.appui.web.WebAppUiView;
import h8.C4148a;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;
import u4.AgentTask;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\fR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082D¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/E;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/e;", "task", "LY8/t;", "setTaskData", "(Lu4/e;)V", "Landroid/widget/TextView;", "taskTitle", "Landroid/widget/TextView;", "getTaskTitle", "()Landroid/widget/TextView;", "setTaskTitle", "(Landroid/widget/TextView;)V", "Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "webAppView", "Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "getWebAppView", "()Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;", "setWebAppView", "(Lcom/stepos/agentframework/chatui/appui/web/WebAppUiView;)V", "taskDescription", "getTaskDescription", "setTaskDescription", "Lu4/e;", "getTask", "()Lu4/e;", "setTask", "Landroid/widget/Button;", "launchRobotBtn", "Landroid/widget/Button;", "getLaunchRobotBtn", "()Landroid/widget/Button;", "setLaunchRobotBtn", "(Landroid/widget/Button;)V", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "robotHostView", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "getRobotHostView", "()Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "setRobotHostView", "(Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;)V", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "taskPanel", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "getTaskPanel", "()Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "setTaskPanel", "(Lcom/stepos/agentframework/chatui/task/view/TaskPanel;)V", "", "hideGuiAgentCard", "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class E extends LinearLayout {
    private final boolean hideGuiAgentCard;
    private Button launchRobotBtn;
    private RobotAppUIHostView robotHostView;
    private AgentTask task;
    private TextView taskDescription;
    private TaskPanel taskPanel;
    private TextView taskTitle;
    private WebAppUiView webAppView;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/task/view/E$a", "Lcom/stepos/agentframework/chatui/appui/web/c;", "Lcom/stepos/agentframework/chatui/appui/g;", "displayMode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/appui/g;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.agentframework.chatui.appui.web.c {
        public a() {
        }

        @Override // com.stepos.agentframework.chatui.appui.web.c
        public void a(DisplayMode displayMode) {
            AgentTask task;
            kotlin.jvm.internal.p.i(displayMode, "displayMode");
            if (!kotlin.jvm.internal.p.d(displayMode.getMode(), AppUIGlobal.MODE_FULLSCREEN) || (task = E.this.getTask()) == null) {
                return;
            }
            Intent intent = new Intent("com.zyql.fwk.demo.APP_UI_TEST");
            intent.putExtra("app_ui_data", task.getAppUIData());
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ChatCoreSdk.INSTANCE.c().startActivity(intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.hideGuiAgentCard = true;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_task_view, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(R$id.task_title);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.taskTitle = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R$id.web_app_ui);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.webAppView = (WebAppUiView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R$id.task_description);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.taskDescription = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R$id.launch_robot_btn);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.launchRobotBtn = (Button) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R$id.task_robot_host_view);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.robotHostView = (RobotAppUIHostView) viewFindViewById5;
        this.webAppView.setListener(new a());
        this.launchRobotBtn.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.task.view.D
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                E.b(this.f23013a, context, view);
            }
        });
    }

    public static final void b(E e10, Context context, View view) {
        ExtKt.m(e10.launchRobotBtn);
        ExtKt.m(e10.webAppView);
        ExtKt.C(e10.robotHostView);
        RobotAppUIHostView robotAppUIHostView = e10.robotHostView;
        AgentTask agentTask = e10.task;
        kotlin.jvm.internal.p.f(agentTask);
        String id = agentTask.getId();
        AgentTask agentTask2 = e10.task;
        kotlin.jvm.internal.p.f(agentTask2);
        AppUIData appUIData = agentTask2.getAppUIData();
        kotlin.jvm.internal.p.f(appUIData);
        robotAppUIHostView.e(id, appUIData);
        e10.robotHostView.X(e10.getWidth() - O6.d.INSTANCE.a(context, 32.0f));
    }

    public final Button getLaunchRobotBtn() {
        return this.launchRobotBtn;
    }

    public final RobotAppUIHostView getRobotHostView() {
        return this.robotHostView;
    }

    public final AgentTask getTask() {
        return this.task;
    }

    public final TextView getTaskDescription() {
        return this.taskDescription;
    }

    public final TaskPanel getTaskPanel() {
        return this.taskPanel;
    }

    public final TextView getTaskTitle() {
        return this.taskTitle;
    }

    public final WebAppUiView getWebAppView() {
        return this.webAppView;
    }

    public final void setLaunchRobotBtn(Button button) {
        kotlin.jvm.internal.p.i(button, "<set-?>");
        this.launchRobotBtn = button;
    }

    public final void setRobotHostView(RobotAppUIHostView robotAppUIHostView) {
        kotlin.jvm.internal.p.i(robotAppUIHostView, "<set-?>");
        this.robotHostView = robotAppUIHostView;
    }

    public final void setTask(AgentTask agentTask) {
        this.task = agentTask;
    }

    public final void setTaskData(AgentTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        this.task = task;
        this.taskTitle.setText(task.getTitle());
        this.taskDescription.setText(task.getDescription());
        C4148a.k("TaskView", "setTaskData task:" + task, false, 4, null);
        if (task.getAppUIData() == null) {
            ExtKt.m(this.webAppView);
            return;
        }
        AppUIData appUIData = task.getAppUIData();
        kotlin.jvm.internal.p.f(appUIData);
        int uiType = appUIData.getUiType();
        AppUIData.Companion companion = AppUIData.INSTANCE;
        if (uiType == companion.c()) {
            if (!this.hideGuiAgentCard) {
                ExtKt.C(this.launchRobotBtn);
                return;
            }
            ExtKt.m(this.launchRobotBtn);
            ExtKt.m(this.robotHostView);
            ExtKt.m(this.webAppView);
            return;
        }
        AppUIData appUIData2 = task.getAppUIData();
        kotlin.jvm.internal.p.f(appUIData2);
        if (appUIData2.getUiType() == companion.d()) {
            AppUIData appUIData3 = task.getAppUIData();
            kotlin.jvm.internal.p.f(appUIData3);
            if (appUIData3.isReady()) {
                this.webAppView.setGlobal(new AppUIGlobal(null, null, null, null, 15, null));
                ExtKt.C(this.webAppView);
                WebAppUiView webAppUiView = this.webAppView;
                AppUIData appUIData4 = task.getAppUIData();
                kotlin.jvm.internal.p.f(appUIData4);
                webAppUiView.d(appUIData4);
                return;
            }
        }
        ExtKt.m(this.webAppView);
    }

    public final void setTaskDescription(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.taskDescription = textView;
    }

    public final void setTaskPanel(TaskPanel taskPanel) {
        this.taskPanel = taskPanel;
    }

    public final void setTaskTitle(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.taskTitle = textView;
    }

    public final void setWebAppView(WebAppUiView webAppUiView) {
        kotlin.jvm.internal.p.i(webAppUiView, "<set-?>");
        this.webAppView = webAppUiView;
    }
}
