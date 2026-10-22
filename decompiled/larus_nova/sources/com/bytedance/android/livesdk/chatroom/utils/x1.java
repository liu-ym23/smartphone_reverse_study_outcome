package com.bytedance.android.livesdk.chatroom.utils;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class x1 {
    public static final boolean a() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = r100.getVideoTalkRoomSubScene();
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L11;
        Integer r104 = Integer.valueOf(r103.f114798a);
    L12:
        if (r100 == null) goto L18;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r105 = r100.getVideoTalkRoomSubScene();
        if (r105 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r106 = r105.getValue();
        if (r106 == null) goto L18;
        r106.t();
    L18:
        if (r104 != null) goto L21;
        return false;
    L21:
        if (r104.intValue() == 8) goto L23;
        return false;
    L23:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == false) goto L28;
        return true;
    L28:
        return false;
    L11:
        r104 = null;
        goto L12
    }

    public static final boolean b() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        List<Integer> r101 = null;
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r102 = r100.getVideoTalkRoomSubScene();
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r103 = r102.getValue();
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r104 = r103.t();
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf(r104.f114798a);
    L12:
        if (r100 == null) goto L20;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r106 = r100.getVideoTalkRoomSubScene();
        if (r106 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r107 = r106.getValue();
        if (r107 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r108 = r107.t();
        if (r108 == null) goto L20;
        r101 = r108.f114799b;
    L20:
        if (r105 != null) goto L23;
        return false;
    L23:
        if (r105.intValue() == 8) goto L25;
        return false;
    L25:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.g(r101) == false) goto L30;
        return true;
    L30:
        return false;
    L11:
        r105 = null;
        goto L12
    }

    public static final boolean c() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = r100.getVideoTalkRoomSubScene();
        if (r101 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L13;
        if (r103.f114798a != 12) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean d() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = r100.getVideoTalkRoomSubScene();
        if (r101 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L13;
        if (r103.f114798a != 16) goto L13;
        return true;
    L13:
        return false;
    }

    public static final boolean e() {
        com.bytedance.android.livesdk.chatroom.o r100 = o3.f();
        if (r100 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = r100.getVideoTalkRoomSubScene();
        if (r101 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L12;
        if (r103.f114798a != 8) goto L12;
    L21:
        return true;
    L12:
        if (r100 == null) goto L22;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r104 = r100.getVideoTalkRoomSubScene();
        if (r104 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r105 = r104.getValue();
        if (r105 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r106 = r105.t();
        if (r106 == null) goto L22;
        if (r106.f114798a == 12) goto L21;
    L22:
        return false;
    }
}
