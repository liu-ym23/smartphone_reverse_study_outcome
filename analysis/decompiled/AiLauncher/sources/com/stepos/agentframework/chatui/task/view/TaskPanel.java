package com.stepos.agentframework.chatui.task.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import u4.AgentTask;
import u4.AgentTaskPlan;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001-B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\fR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lu4/i;", "tasks", "LY8/t;", "setPanTasks", "(Lu4/i;)V", "Lu4/e;", "task", "c", "(Lu4/e;)V", "Landroid/widget/ImageButton;", "closeButton", "Landroid/widget/ImageButton;", "getCloseButton", "()Landroid/widget/ImageButton;", "panelContentContainer", "Landroid/widget/LinearLayout;", "getPanelContentContainer", "()Landroid/widget/LinearLayout;", "Lu4/i;", "getTasks", "()Lu4/i;", "setTasks", "", "Lcom/stepos/agentframework/chatui/task/view/E;", "taskViews", "Ljava/util/List;", "getTaskViews", "()Ljava/util/List;", "setTaskViews", "(Ljava/util/List;)V", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;", "listener", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;", "getListener", "()Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;", "setListener", "(Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;)V", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskPanel extends LinearLayout {
    private final ImageButton closeButton;
    private a listener;
    private final LinearLayout panelContentContainer;
    private List<E> taskViews;
    private AgentTaskPlan tasks;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;", "", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_task_panel, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(R$id.btn_close_panel);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        ImageButton imageButton = (ImageButton) viewFindViewById;
        this.closeButton = imageButton;
        View viewFindViewById2 = viewInflate.findViewById(R$id.panel_content_container);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.panelContentContainer = (LinearLayout) viewFindViewById2;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.task.view.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskPanel.b(this.f23012a, view);
            }
        });
    }

    public static final void b(TaskPanel taskPanel, View view) {
        taskPanel.animate().translationX(taskPanel.panelContentContainer.getWidth());
        taskPanel.setVisibility(8);
    }

    public final void c(AgentTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        List<E> list = this.taskViews;
        if (list != null) {
            for (E e10 : list) {
                AgentTask task2 = e10.getTask();
                if (kotlin.jvm.internal.p.d(task2 != null ? task2.getId() : null, task.getId())) {
                    e10.setTaskData(task);
                }
            }
        }
    }

    public final ImageButton getCloseButton() {
        return this.closeButton;
    }

    public final a getListener() {
        return this.listener;
    }

    public final LinearLayout getPanelContentContainer() {
        return this.panelContentContainer;
    }

    public final List<E> getTaskViews() {
        return this.taskViews;
    }

    public final AgentTaskPlan getTasks() {
        return this.tasks;
    }

    public final void setListener(a aVar) {
        this.listener = aVar;
    }

    public final void setPanTasks(AgentTaskPlan tasks) {
        kotlin.jvm.internal.p.i(tasks, "tasks");
        this.tasks = tasks;
        this.panelContentContainer.removeAllViews();
        if (this.taskViews == null) {
            this.taskViews = new ArrayList();
        }
        List<E> list = this.taskViews;
        if (list != null) {
            list.clear();
        }
        List<AgentTask> listA = tasks.a();
        kotlin.jvm.internal.p.f(listA);
        for (AgentTask agentTask : listA) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            E e10 = new E(context, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            O6.d dVar = O6.d.INSTANCE;
            Context context2 = getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            layoutParams.setMargins(0, dVar.a(context2, 10.0f), 0, 0);
            e10.setLayoutParams(layoutParams);
            e10.setTaskPanel(this);
            e10.setTaskData(agentTask);
            List<E> list2 = this.taskViews;
            kotlin.jvm.internal.p.f(list2);
            list2.add(e10);
            this.panelContentContainer.addView(e10);
        }
    }

    public final void setTaskViews(List<E> list) {
        this.taskViews = list;
    }

    public final void setTasks(AgentTaskPlan agentTaskPlan) {
        this.tasks = agentTaskPlan;
    }
}
