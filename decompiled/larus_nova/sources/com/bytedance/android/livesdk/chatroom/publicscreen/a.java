package com.bytedance.android.livesdk.chatroom.publicscreen;

import com.bytedance.android.live.liveinteract.plantform.model.UserType;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f107977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f107978b = null;

    static {
        int[] r100 = new int[UserType.values().length];
        f107977a = r100;
        UserType r101 = UserType.UNKNOWN;
        r100[r101.ordinal()] = 1;
        UserType r102 = UserType.ANCHOR;
        r100[r102.ordinal()] = 2;
        UserType r103 = UserType.AUDIENCE;
        r100[r103.ordinal()] = 3;
        UserType r104 = UserType.GUEST;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[UserType.values().length];
        f107978b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
    }
}
