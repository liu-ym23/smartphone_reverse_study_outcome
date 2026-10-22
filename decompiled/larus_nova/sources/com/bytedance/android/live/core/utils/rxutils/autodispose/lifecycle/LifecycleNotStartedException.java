package com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;

/* JADX INFO: loaded from: classes45.dex */
public class LifecycleNotStartedException extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String r100) {
        super(r100);
    }
}
