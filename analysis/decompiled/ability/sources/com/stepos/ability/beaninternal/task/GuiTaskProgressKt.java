package com.stepos.ability.beaninternal.task;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"GuiTaskProgress_KEY_METHOD", "", "GuiTaskProgress_KEY_TASK_ID", "GuiTaskProgress_KEY_TASK_NAME", "GuiTaskProgress_KEY_ACTION", "GuiTaskProgress_KEY_BITMAP_ID", "GuiTaskProgress_KEY_BITMAP", "GuiTaskProgress_KEY_BITMAP_URL", "GuiTaskProgress_KEY_MESSAGE", "GuiTaskProgress_KEY_EXTRAS", "GuiTaskProgress_KEY_STATUS", "GuiTaskProgress_VALUE_METHOD_ONPRGRESS", "toBundle", "Landroid/os/Bundle;", "Lcom/stepos/ability/beaninternal/task/GuiTaskProgress;", "beanInternal_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiTaskProgressKt {
    public static final String GuiTaskProgress_KEY_ACTION = "action";
    public static final String GuiTaskProgress_KEY_BITMAP = "bitmap";
    public static final String GuiTaskProgress_KEY_BITMAP_ID = "bitmapId";
    public static final String GuiTaskProgress_KEY_BITMAP_URL = "bitmapUrl";
    public static final String GuiTaskProgress_KEY_EXTRAS = "extras";
    public static final String GuiTaskProgress_KEY_MESSAGE = "message";
    public static final String GuiTaskProgress_KEY_METHOD = "method";
    public static final String GuiTaskProgress_KEY_STATUS = "status";
    public static final String GuiTaskProgress_KEY_TASK_ID = "taskId";
    public static final String GuiTaskProgress_KEY_TASK_NAME = "taskName";
    public static final String GuiTaskProgress_VALUE_METHOD_ONPRGRESS = "onProgress";

    public static final Bundle toBundle(GuiTaskProgress guiTaskProgress) {
        k.f(guiTaskProgress, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString(GuiTaskProgress_KEY_METHOD, GuiTaskProgress_VALUE_METHOD_ONPRGRESS);
        bundle.putString(GuiTaskProgress_KEY_TASK_ID, guiTaskProgress.getTaskId());
        bundle.putString(GuiTaskProgress_KEY_TASK_NAME, guiTaskProgress.getTaskName());
        Integer status = guiTaskProgress.getStatus();
        bundle.putInt("status", status != null ? status.intValue() : -1);
        bundle.putString(GuiTaskProgress_KEY_ACTION, guiTaskProgress.getAction());
        bundle.putString(GuiTaskProgress_KEY_BITMAP_ID, guiTaskProgress.getBitmapId());
        bundle.putParcelable("bitmap", guiTaskProgress.getBitmap());
        bundle.putString(GuiTaskProgress_KEY_BITMAP_URL, guiTaskProgress.getBitmapUri());
        bundle.putString("message", guiTaskProgress.getMessage());
        return bundle;
    }
}
