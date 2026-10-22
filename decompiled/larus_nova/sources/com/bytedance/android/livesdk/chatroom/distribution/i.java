package com.bytedance.android.livesdk.chatroom.distribution;

import com.bytedance.android.livesdkapi.distribution.RoomExitAction;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105779b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f105780c = null;

    static {
        int[] r100 = new int[RoomExitAction.values().length];
        f105778a = r100;
        RoomExitAction r101 = RoomExitAction.MOVE_TO_NEXT;
        r100[r101.ordinal()] = 1;
        RoomExitAction r102 = RoomExitAction.BACK_TO_FIRST;
        r100[r102.ordinal()] = 2;
        RoomExitAction r103 = RoomExitAction.REMOVE_CONTAINER;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[RoomExitAction.values().length];
        f105779b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        int[] r105 = new int[RoomExitAction.values().length];
        f105780c = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
    }
}
