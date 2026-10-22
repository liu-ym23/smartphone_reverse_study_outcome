package com.stepos.ailauncher.taskstore.chat;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.lockscreen.LockScreenChatAction;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.read.TaskReadStateManager;
import com.stepos.ailauncher.taskstore.widget.InterfaceC3745k;
import com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/a;", "Lcom/stepos/agentframework/chatui/appui/a;", "Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;", "", "<init>", "()V", "tId", "LY8/t;", "m", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "k", "(Landroid/content/Context;)Lcom/stepos/ailauncher/taskstore/widget/TaskInfoCardMediumView;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/view/View;", "view", "taskId", "o", "(Landroid/view/View;Ljava/lang/String;)V", "", "l", "()Z", "n", "(Landroid/content/Context;Ljava/lang/String;)V", "Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3698a extends com.stepos.agentframework.chatui.appui.a<TaskInfoCardMediumView, String> {
    private static final String ACTION_OPEN_TASK_DETAIL = "com.stepos.ailauncher.task.DETAIL_ACTION";
    private static final String SOUND_RECORDER_MAIN_ACTIVITY = "com.android.soundrecorder.feature.main.StepOSRecorderActivity";
    private static final String SOUND_RECORDER_PACKAGE = "com.android.soundrecorder";
    private static final String TAG = "ChatTaskInfoCardBridge";
    private String taskId;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/chat/a$b", "Lcom/stepos/ailauncher/taskstore/widget/k;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.chat.a$b */
    public static final class b implements InterfaceC3745k {
        final /* synthetic */ TaskInfoCardMediumView $view;

        public b(TaskInfoCardMediumView taskInfoCardMediumView) {
            this.$view = taskInfoCardMediumView;
        }

        @Override // com.stepos.ailauncher.taskstore.widget.InterfaceC3745k
        public void a(TaskInfoCard card) {
            if (card == null) {
                return;
            }
            if (!com.stepos.ailauncher.taskstore.provider.a.INSTANCE.a(card.getType())) {
                C3698a.this.o(this.$view, card.getTaskId());
                return;
            }
            C3698a c3698a = C3698a.this;
            Context context = this.$view.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c3698a.n(context, card.getTaskId());
            WakeService.Companion companion = WakeService.INSTANCE;
            Context context2 = this.$view.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            WakeService.Companion.a0(companion, context2, false, 2, null);
        }
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    public void g() {
        String str = this.taskId;
        if (str != null) {
            C3699b c3699b = C3699b.INSTANCE;
            String str2 = null;
            if (str == null) {
                kotlin.jvm.internal.p.A("taskId");
                str = null;
            }
            TaskInfoCardMediumView taskInfoCardMediumViewA = c3699b.a(str);
            if (taskInfoCardMediumViewA == null || taskInfoCardMediumViewA != c()) {
                return;
            }
            String str3 = this.taskId;
            if (str3 == null) {
                kotlin.jvm.internal.p.A("taskId");
            } else {
                str2 = str3;
            }
            c3699b.d(str2);
        }
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public TaskInfoCardMediumView b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        String str = this.taskId;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.p.A("taskId");
            str = null;
        }
        TaskInfoCardMediumView taskInfoCardMediumView = new TaskInfoCardMediumView(context, str);
        taskInfoCardMediumView.setActionListener(new b(taskInfoCardMediumView));
        C3699b c3699b = C3699b.INSTANCE;
        String str3 = this.taskId;
        if (str3 == null) {
            kotlin.jvm.internal.p.A("taskId");
        } else {
            str2 = str3;
        }
        c3699b.c(str2, taskInfoCardMediumView);
        return taskInfoCardMediumView;
    }

    public final boolean l() {
        return InputViewManager.INSTANCE.r0() instanceof FloatInputView;
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void f(String tId) {
        kotlin.jvm.internal.p.i(tId, "tId");
        this.taskId = tId;
        if (tId == null) {
            kotlin.jvm.internal.p.A("taskId");
            tId = null;
        }
        Log.i("TestAppUIBridge", "onInitData: " + tId);
    }

    public final void n(Context context, String taskId) {
        if (!La.H.x0(taskId)) {
            TaskReadStateManager.INSTANCE.a(taskId, "ChatTaskInfoCardBridge.openSoundRecorder");
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(SOUND_RECORDER_PACKAGE, SOUND_RECORDER_MAIN_ACTIVITY));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            context.startActivity(intent);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to open Sound Recorder: " + e10.getMessage());
        }
    }

    public final void o(View view, String taskId) {
        TaskReadStateManager.INSTANCE.a(taskId, "ChatTaskInfoCardBridge.openTaskDetail");
        com.stepos.ailauncher.chat.lockscreen.x xVar = com.stepos.ailauncher.chat.lockscreen.x.INSTANCE;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (com.stepos.ailauncher.chat.lockscreen.x.j(xVar, context, LockScreenChatAction.OPEN_TASK_DETAIL, null, taskId, 4, null)) {
            return;
        }
        Intent intent = new Intent("com.stepos.ailauncher.task.DETAIL_ACTION");
        intent.setPackage(view.getContext().getPackageName());
        intent.putExtra("taskId", taskId);
        intent.putExtra("fromChatView", l());
        if (!(view.getContext() instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        view.getContext().startActivity(intent);
        WakeService.Companion companion = WakeService.INSTANCE;
        Context context2 = view.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        WakeService.Companion.a0(companion, context2, false, 2, null);
    }
}
