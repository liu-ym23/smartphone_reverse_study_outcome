package com.android.server.wm;

import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricRecentTasks extends IObricBase {
    default boolean isTrimmable(Task task) {
        return false;
    }
}
