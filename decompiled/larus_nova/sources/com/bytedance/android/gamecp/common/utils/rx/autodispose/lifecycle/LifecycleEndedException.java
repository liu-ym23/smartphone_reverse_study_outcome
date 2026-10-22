package com.bytedance.android.gamecp.common.utils.rx.autodispose.lifecycle;

import com.bytedance.android.gamecp.common.utils.rx.autodispose.OutsideScopeException;

/* JADX INFO: loaded from: classes44.dex */
public class LifecycleEndedException extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String r100) {
        super(r100);
    }
}
