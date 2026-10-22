package com.bytedance.android.livesdk.room.utils;

import am2.x;
import com.bytedance.android.livesdk.chatroom.room.r0;
import com.bytedance.android.livesdk.log.e0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.t;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class RoomEnterInfoExtKt {
    public static final String a(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$makeEnterRoomSource");
        RoomEnterInfoExtKt$makeEnterRoomSource$1 r101 = RoomEnterInfoExtKt$makeEnterRoomSource$1.INSTANCE;
        String r102 = r100.f111128d;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L21;
        String r105 = r100.f111130f;
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        String r107 = r100.f111128d;
    L26:
        if (r107 == null) goto L36;
        if (r107.length() <= 0) goto L30;
        r103 = true;
    L30:
        if (r103 != true) goto L36;
        if (Intrinsics.areEqual(r107, "null-null") == true) goto L36;
        if (Intrinsics.areEqual(r107, "-") == true) goto L36;
        return r107;
    L36:
        if (Intrinsics.areEqual(r100.f111143s, "ad_union") == true) goto L42;
        if (Intrinsics.areEqual(r100.f111143s, "ad_link_search") == true) goto L42;
        return "null-null";
    L42:
        return r100.f111143s + "-h5";
    L20:
        r107 = r100.f111128d + '-' + r100.f111130f;
        goto L26
    L14:
        if (StringsKt.isBlank(r105) == true) goto L17;
        r106 = false;
        goto L18
    L21:
        o<?> r108 = r101.invoke(x.class);
        if ((r108 instanceof t) == false) goto L24;
        t r109 = (t) r108;
        String r110 = r109.getMap().get("enter_from");
        String r111 = r109.getMap().get("source");
        Map<String, String> r112 = r109.getMap();
        Map<String, String> r113 = e0.f153286a;
        r107 = r112.get("enter_from_merge") + '-' + r112.get("enter_method");
        goto L26
    L24:
        r107 = "";
        goto L26
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L10
    }
}
