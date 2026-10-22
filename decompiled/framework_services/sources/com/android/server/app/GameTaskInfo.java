package com.android.server.app;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class GameTaskInfo {
    final ComponentName mComponentName;
    final boolean mIsGameTask;
    final int mTaskId;

    GameTaskInfo(int taskId, boolean isGameTask, ComponentName componentName) {
        this.mTaskId = taskId;
        this.mIsGameTask = isGameTask;
        this.mComponentName = componentName;
    }

    public String toString() {
        return "GameTaskInfo{mTaskId=" + this.mTaskId + ", mIsGameTask=" + this.mIsGameTask + ", mComponentName=" + this.mComponentName + '}';
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof GameTaskInfo) == true) goto L8;
        return false;
    L8:
        GameTaskInfo that = (GameTaskInfo) o;
        if (this.mTaskId != that.mTaskId) goto L16;
        if (this.mIsGameTask != that.mIsGameTask) goto L16;
        if (this.mComponentName.equals(that.mComponentName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mTaskId), Boolean.valueOf(this.mIsGameTask), this.mComponentName});
    }
}
