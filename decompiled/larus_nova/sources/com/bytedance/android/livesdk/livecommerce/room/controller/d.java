package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f151687a = 0;

    public d() {
    }

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        b(null);
    }

    public static void b(String r100) {
        if (ECAppInfoService.f48114e.isDebug() == true) goto L7;
        return;
    L7:
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L18;
        StackTraceElement[] r102 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r102.length < 5) goto L19;
        List r103 = StringsKt.split$default(r102[5].getClassName(), new String[]{"."}, false, 0, 6, null);
        String r104 = (String) ListProtector.get(r103, r103.size() - 1);
        r102[5].getMethodName();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        if (StringsKt.isBlank(r100) == true) goto L12;
        r101 = false;
        goto L13
    }
}
