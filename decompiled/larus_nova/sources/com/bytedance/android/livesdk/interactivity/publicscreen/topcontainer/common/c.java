package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static final ConflictStrategy a(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return ConflictStrategy.QUEUE;
    L13:
        return ConflictStrategy.INTERRUPT;
    L14:
        return ConflictStrategy.QUEUE;
    L11:
        return ConflictStrategy.DISCARD;
    }
}
