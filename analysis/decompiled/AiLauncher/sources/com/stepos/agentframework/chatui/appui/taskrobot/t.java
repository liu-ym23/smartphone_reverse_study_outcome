package com.stepos.agentframework.chatui.appui.taskrobot;

import android.content.ContentValues;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/taskrobot/t;", "", "<init>", "()V", "", "taskId", "", "uiForeground", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class t {
    public static final t INSTANCE = new t();

    public final void a(String taskId, int uiForeground) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        ContentValues contentValues = new ContentValues();
        contentValues.put("ui_foreground", Integer.valueOf(uiForeground));
        C4148a.k("StatusNotify", "updateTaskUIForeground rowsUpdated: " + ChatCoreSdk.INSTANCE.c().getContentResolver().update(Uri.withAppendedPath(Uri.parse("content://com.zyql.taskmanager.taskmanagercontentprovider/tasks"), taskId), contentValues, null, null), false, 4, null);
    }
}
