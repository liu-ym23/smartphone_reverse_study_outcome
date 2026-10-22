package com.bytedance.android.live.browser.container;

import com.bytedance.android.anniex.assemble.a;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class HybridContainerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f62592a = null;

    static {
        f62592a = LazyKt.lazy(LazyThreadSafetyMode.NONE, HybridContainerManager$containerMap$2.INSTANCE);
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        WeakReference r101 = (WeakReference) ((HashMap) f62592a.getValue()).get(r100);
        if (r101 == null) goto L8;
        ILiveHybridContainer r102 = (ILiveHybridContainer) r101.get();
        if (r102 == null) goto L8;
        r102.close();
        return true;
    L8:
        a r103 = a.f40251a;
        if (a.a(r100) == false) goto L11;
        return true;
    L11:
        return false;
    }
}
