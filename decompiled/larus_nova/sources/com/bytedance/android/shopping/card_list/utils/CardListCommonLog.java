package com.bytedance.android.shopping.card_list.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListCommonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f171886a = null;

    static {
        f171886a = LazyKt.lazy(CardListCommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) f171886a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r102 = dm.a.f469202a;     // Catch: Exception -> L10
        dm.a.b r103 = dm.a.a("card_list_log_".concat(r100));     // Catch: Exception -> L10
        String r104 = (String) r101.invoke();     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.a(r104);     // Catch: Exception -> L10
        return;
    }
}
