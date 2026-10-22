package com.bytedance.android.livesdk.chatroom.backroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final String a(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getBackSource");
        String r101 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_NEW_ROOM_BACK_SOURCE);
        String r102 = r100.getString("enter_from_merge");
        String r103 = null;
        if (r102 != null) goto L8;
        Bundle r104 = m0.a(r100);
        if (r104 == null) goto L7;
        r102 = r104.getString("enter_from_merge");
        goto L8
    L7:
        r102 = null;
    L8:
        String r105 = r100.getString("enter_method");
        if (r105 != null) goto L13;
        Bundle r106 = m0.a(r100);
        if (r106 == null) goto L14;
        r103 = r106.getString("enter_method");
    L14:
        if (r101 == null) goto L16;
        return r101;
    L16:
        return r102 + '-' + r103;
    L13:
        r103 = r105;
        goto L14
    }
}
