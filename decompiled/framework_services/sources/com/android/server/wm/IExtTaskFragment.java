package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtTaskFragment extends IExtBase {
    public static final int SPLIT_REPLACE_TASK_FRAGMENT_VISIBILITY_UNDEFINED = -1;

    default int getSplitReplaceTaskFragmentVisibility(Task task, WindowContainer<?> parent) {
        return -1;
    }

    default boolean shouldSkipProvidesOrientation(TaskFragment taskFragment) {
        return false;
    }
}
