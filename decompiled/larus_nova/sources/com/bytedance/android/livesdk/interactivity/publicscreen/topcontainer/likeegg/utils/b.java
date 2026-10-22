package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils;

import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.o;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f140046a = 0;

    static {
    }

    public static void b(String r100, Map r101) {
        o r102 = r.l();
        if (r101 == null) goto L5;
        Map<String, String> r103 = MapsKt.toMap(r101);
    L6:
        r102.sendLog(r100, r103, new Object[]{IRoom.class});
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void a(com.bytedance.android.livesdk.chatroom.likeegg.a r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r102, "photoType");
        b("livesdk_vs_photo_save", r.k().a(r100, r101, r102));
    }
}
