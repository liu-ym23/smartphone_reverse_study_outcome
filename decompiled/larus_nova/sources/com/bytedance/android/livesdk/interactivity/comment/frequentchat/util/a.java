package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.search.dto.UserGroupScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f134925a = 0;

    static {
    }

    public static void a(String r100, Boolean r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LinkedHashMap r103 = new LinkedHashMap();
        if (r101 == null) goto L5;
        boolean r104 = r101.booleanValue();
    L6:
        if (r104 == false) goto L8;
        String r105 = "anchor";
    L9:
        r103.put("role", r105);
        if (r102 == null) goto L12;
        r103.putAll(r102);
    L12:
        j0.l().sendLog(r100, r103, new Object[]{IRoom.class, x.class});
        return;
    L8:
        r105 = UserGroupScene.DEFAULT_NAME_SPACE;
        goto L9
    L5:
        r104 = false;
        goto L6
    }
}
