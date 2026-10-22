package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static final com.bytedance.android.livesdk.chatroom.ui.framework.a a(h70.b r100) {
        if (r100 == null) goto L6;
        IAbilityCenter r101 = r100.a();
        if (r101 == null) goto L6;
        return (com.bytedance.android.livesdk.chatroom.ui.framework.a) r101.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
    L6:
        return null;
    }

    public static final boolean b(h70.b r100) {
        if ((r100 instanceof d90.d) == true) goto L5;
        r100 = null;
    L5:
        d90.d r101 = (d90.d) r100;
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.f467476d;
    }

    public static final <T extends IAbility> void d(h70.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 == null) goto L8;
        IAbilityCenter r102 = r100.a();
        if (r102 == null) goto L9;
        r102.unregisterAbility(r101);
        return;
    L9:
        return;
    }

    public static final <T extends IAbility> void c(h70.b r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "ability");
        if (r100 == null) goto L8;
        IAbilityCenter r103 = r100.a();
        if (r103 == null) goto L9;
        r103.registerAbility(r101, r102);
        return;
    L9:
        return;
    }
}
