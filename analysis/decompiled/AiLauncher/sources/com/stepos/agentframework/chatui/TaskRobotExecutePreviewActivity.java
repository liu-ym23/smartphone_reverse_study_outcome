package com.stepos.agentframework.chatui;

import Z8.C1173v;
import android.os.Bundle;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.view.TaskRobotExecuteLayout;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatui/TaskRobotExecutePreviewActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskRobotExecutePreviewActivity extends androidx.appcompat.app.d {
    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_task_robot_execute_preview);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
        List<String> listP = C1173v.p("https://picsum.photos/200/300", "https://placedog.net/400/300", "https://picsum.photos/400/600", "https://picsum.photos/id/1015/400/300", "https://picsum.photos/id/1018/400/300", "https://picsum.photos/id/1031/400/300", "https://picsum.photos/id/1039/400/300");
        TaskRobotExecuteLayout taskRobotExecuteLayout = (TaskRobotExecuteLayout) findViewById(R$id.task_robot_execute_view);
        ExtKt.C(taskRobotExecuteLayout.getExecuteImagesViewPager());
        ExtKt.m(taskRobotExecuteLayout.getRobotContainer());
        taskRobotExecuteLayout.setExecuteImages(listP);
        O6.d dVar = O6.d.INSTANCE;
        taskRobotExecuteLayout.H(dVar.a(this, 130.0f), dVar.a(this, 282.0f));
    }
}
