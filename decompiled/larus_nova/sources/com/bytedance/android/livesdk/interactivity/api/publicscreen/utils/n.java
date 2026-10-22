package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.i7;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133645a = false;

    static {
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f133645a = r100;
        return;
    L5:
        if (i7.f132644a.getValue().booleanValue() == false) goto L7;
        r100 = true;
        goto L8
    }

    @JvmStatic
    public static final String a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        IPublicAreaCommon r101 = r100.v();
        if (r101 == null) goto L7;
        PersonalizedDisplayInfo r102 = r101.getPersonalizedInfo();
        if (r102 == null) goto L7;
        Boolean r103 = r102.isPersonalized();
    L9:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L12;
        return "个性化";
    L12:
        return "非个性化";
    L7:
        r103 = null;
        goto L9
    }

    @JvmStatic
    public static final void b(Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        if (f133645a == false) goto L6;
        String r101 = r100.invoke();
        return;
    }
}
