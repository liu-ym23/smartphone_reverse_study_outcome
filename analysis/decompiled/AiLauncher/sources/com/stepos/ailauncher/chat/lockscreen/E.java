package com.stepos.ailauncher.chat.lockscreen;

import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/E;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "taskId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "ACTION_OPEN_TASK_DETAIL", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E {
    private static final String ACTION_OPEN_TASK_DETAIL = "com.stepos.ailauncher.task.DETAIL_ACTION";
    public static final E INSTANCE = new E();

    public final void a(Context context, String taskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.stepos.ailauncher.task.DETAIL_ACTION");
        intent.setPackage(applicationContext.getPackageName());
        intent.putExtra("taskId", taskId);
        intent.putExtra("fromChatView", true);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        applicationContext.startActivity(intent);
    }
}
