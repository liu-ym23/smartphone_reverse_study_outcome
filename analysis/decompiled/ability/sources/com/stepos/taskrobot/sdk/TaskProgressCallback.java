package com.stepos.taskrobot.sdk;

import android.graphics.Bitmap;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/sdk/TaskProgressCallback;", "", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Landroid/graphics/Bitmap;", "bitmap", "LC7/r;", "onProgressChanged", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskProgressCallback {
    void onProgressChanged(String taskId, String taskName, String action, Bitmap bitmap);
}
