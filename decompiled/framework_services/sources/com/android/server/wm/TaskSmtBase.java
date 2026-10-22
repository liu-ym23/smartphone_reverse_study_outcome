package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class TaskSmtBase {
    public boolean isPrefetch;
    private Task mTask;
    private boolean taskInVisible;

    public TaskSmtBase(Task task) {
        this.isPrefetch = false;
        this.mTask = task;
    }

    public boolean isTaskInVisible() {
        return this.taskInVisible;
    }

    public void setTaskInVisible(boolean isVisible) {
        this.taskInVisible = isVisible;
    }

    public boolean isSystemTask() {
        if (this.mTask != null) goto L5;
    L13:
        return false;
    L5:
        if (this.mTask.getRootActivity() == null) goto L13;
        if (this.mTask.getRootActivity().info == null) goto L13;
        if (this.mTask.getRootActivity().info.applicationInfo == null) goto L13;
        if ((this.mTask.getRootActivity().info.applicationInfo.flags & 129) == 0) goto L13;
        return true;
    }
}
