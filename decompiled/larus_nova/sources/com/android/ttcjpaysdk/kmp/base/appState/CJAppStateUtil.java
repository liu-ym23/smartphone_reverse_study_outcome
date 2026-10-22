package com.android.ttcjpaysdk.kmp.base.appState;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/appState/CJAppStateUtil;", "", "<init>", "()V", "registerAppStateCallback", "", "callback", "Lcom/android/ttcjpaysdk/kmp/base/appState/IKmpCJAppStateServiceCallback;", "unregisterAppStateCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJAppStateUtil {
    public static final int $stable = 0;
    public static final CJAppStateUtil INSTANCE = null;

    static {
        INSTANCE = new CJAppStateUtil();
    }

    private CJAppStateUtil() {
    }

    public final void registerAppStateCallback(IKmpCJAppStateServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJAppStateService r102 = (IKmpCJAppStateService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAppStateService.class));
        if (r102 == null) goto L6;
        r102.registerAppStateCallback(r100, String.valueOf(r100.hashCode()));
        return;
    }

    public final void unregisterAppStateCallback(IKmpCJAppStateServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJAppStateService r102 = (IKmpCJAppStateService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJAppStateService.class));
        if (r102 == null) goto L6;
        r102.unregisterAppStateCallback(r100, String.valueOf(r100.hashCode()));
        return;
    }
}
