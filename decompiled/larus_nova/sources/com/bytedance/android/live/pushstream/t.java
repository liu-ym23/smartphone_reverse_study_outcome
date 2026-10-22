package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f89461a = null;

    static {
        int[] r100 = new int[LiveRequestSourceRole.values().length];
        f89461a = r100;
        r100[LiveRequestSourceRole.User.ordinal()] = 1;
        r100[LiveRequestSourceRole.Business.ordinal()] = 2;
        r100[LiveRequestSourceRole.RoomState.ordinal()] = 3;
    }
}
