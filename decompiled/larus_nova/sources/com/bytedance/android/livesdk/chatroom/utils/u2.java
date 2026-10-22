package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f114640a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        Keva r102 = Keva.getRepo("need_delete_room_after_report");
        String[] r103 = r102.getStringArray("room_list", new String[0]);
        if (r103 != null) goto L11;
        r103 = new String[0];
    L11:
        List r104 = ArraysKt.toMutableList(r103);
        if (r104.contains(r100) == false) goto L14;
    L17:
        Object[] r105 = r104.toArray(new String[0]);
        if (r105 == null) goto L22;
        r102.storeStringArray("room_list", (String[]) r105);
        ALogger.d("ReportRoomHelper", "record need deleted room " + r100 + " in keva");
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L14:
        if (r104.size() < 10) goto L16;
        ListProtector.remove(r104, 0);
    L16:
        r104.add(r100);
        goto L17
    L5:
        r101 = false;
        goto L6
    }
}
