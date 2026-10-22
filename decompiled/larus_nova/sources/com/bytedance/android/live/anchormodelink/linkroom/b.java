package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f58740a = null;

    static {
        int[] r100 = new int[DynamicCenterUpdateType.values().length];
        f58740a = r100;
        r100[DynamicCenterUpdateType.inviteMore.ordinal()] = 1;
        r100[DynamicCenterUpdateType.check_media_permission.ordinal()] = 2;
        r100[DynamicCenterUpdateType.send_private_invite.ordinal()] = 3;
        r100[DynamicCenterUpdateType.updatePublicScreenAvoidOffset.ordinal()] = 4;
    }
}
