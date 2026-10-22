package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomChangeSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;

/* JADX INFO: loaded from: classes9.dex */
public final class p {
    public static final boolean a() {
        IntercomSyncDataModel r100 = q.h();
        if (r100 == null) goto L11;
        dc2.c<IntercomChangeSyncData> r101 = r100.getIntercomStatus();
        if (r101 == null) goto L11;
        IntercomChangeSyncData r102 = r101.c();
        if (r102 == null) goto L11;
        if (r102.isInIntercom() != true) goto L11;
        return true;
    L11:
        return false;
    }
}
