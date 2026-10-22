package com.stepos.ailauncher.taskstore.chat;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/D;", "", "<init>", "()V", "", "sessionId", "toolName", "", "isFinished", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Z)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class D {
    public static final D INSTANCE = new D();

    public static final void c(TaskInfoCardMediumView taskInfoCardMediumView, String str, String str2, boolean z10) {
        taskInfoCardMediumView.w(str, str2, z10);
    }

    public final void b(final String sessionId, final String toolName, final boolean isFinished) {
        if (sessionId == null || La.H.x0(sessionId)) {
            return;
        }
        List<TaskInfoCardMediumView> listB = C3699b.INSTANCE.b();
        if (listB.isEmpty()) {
            return;
        }
        for (final TaskInfoCardMediumView taskInfoCardMediumView : listB) {
            taskInfoCardMediumView.post(new Runnable() { // from class: com.stepos.ailauncher.taskstore.chat.C
                @Override // java.lang.Runnable
                public final void run() {
                    D.c(taskInfoCardMediumView, sessionId, toolName, isFinished);
                }
            });
        }
    }
}
