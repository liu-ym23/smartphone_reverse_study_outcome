package com.stepos.ailauncher.task.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.detail.TaskWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/task/widget/TaskAppUIView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/ailauncher/task/detail/TaskWebView;", "webAppView", "Lcom/stepos/ailauncher/task/detail/TaskWebView;", "Landroidx/cardview/widget/CardView;", "robotContainer", "Landroidx/cardview/widget/CardView;", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "robotAppUi", "Lcom/stepos/agentframework/chatui/appui/taskrobot/RobotAppUIHostView;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskAppUIView extends FrameLayout {
    private final RobotAppUIHostView robotAppUi;
    private final CardView robotContainer;
    private final TaskWebView webAppView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskAppUIView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskAppUIView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_task_app_ui, this);
        View viewFindViewById = findViewById(R$id.webAppView);
        p.h(viewFindViewById, "findViewById(...)");
        this.webAppView = (TaskWebView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.robotContainer);
        p.h(viewFindViewById2, "findViewById(...)");
        this.robotContainer = (CardView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.robotAppUi);
        p.h(viewFindViewById3, "findViewById(...)");
        this.robotAppUi = (RobotAppUIHostView) viewFindViewById3;
    }

    public /* synthetic */ TaskAppUIView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
