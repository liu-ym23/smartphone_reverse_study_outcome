package com.bytedance.android.shopping.store.tabkit.events;

import com.bytedance.android.ec.store.api.ITabKitEventListener;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class TabKitEventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f186747a = null;

    static {
        f186747a = LazyKt.lazy(TabKitEventCenter$listeners$2.INSTANCE);
    }

    public static ITabKitEventListener a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if ((!StringsKt.isBlank(r100)) == false) goto L5;
        String r101 = r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return (ITabKitEventListener) ((ConcurrentHashMap) f186747a.getValue()).get(r100);
    L5:
        r101 = null;
        goto L6
    }
}
