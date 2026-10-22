package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public final class m {
    public static final com.bytedance.live.datacontext.j<l> a(DataCenter r100) {
        com.bytedance.android.livesdk.interactivity.api.h r101 = com.bytedance.android.livesdk.interactivity.api.i.b(r100, 1);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPublicScreenContext();
    }
}
