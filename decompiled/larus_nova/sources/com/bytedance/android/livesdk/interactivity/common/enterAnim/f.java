package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.livesdk.message.model.pg;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136558a = 0;

    static {
    }

    public static Long a(k32.d r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        h3 r101 = r100.f501712t;
        if (r101 == null) goto L9;
        com.bytedance.android.live.base.model.message.d r102 = r101.I0();
        if (r102 == null) goto L9;
        com.bytedance.android.live.base.model.message.e r103 = r102.a();
        if (r103 == null) goto L9;
        return r103.b();
    L9:
        return null;
    }

    public static boolean b(k32.a r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof k32.d) == false) goto L13;
        g4.f58859e0.getClass();
        List<String> r101 = g4.a.f58863d;
        h3 r102 = ((k32.d) r100).f501712t;
        if (r102 == null) goto L9;
        pg.c r103 = r102.M();
        if (r103 == null) goto L9;
        String r104 = r103.getScene();
    L11:
        if (CollectionsKt.contains(r101, r104) == false) goto L13;
        return true;
    L9:
        r104 = null;
    L13:
        return false;
    }
}
