package com.bytedance.android.gamecp.common.utils.rx.autodispose.lifecycle;

import com.bytedance.android.gamecp.common.utils.rx.autodispose.OutsideScopeException;

/* JADX INFO: loaded from: classes44.dex */
public class LifecycleNotStartedException extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String r100) {
        super(r100);
    }
}
