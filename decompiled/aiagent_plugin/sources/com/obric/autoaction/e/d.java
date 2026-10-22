package com.obric.autoaction.e;

import com.obric.autogui.common.api.threading.AOThreadingTools;

/* JADX INFO: compiled from: PresentationUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper f24683b = null;

    private d() {
    }

    static {
        f24682a = new d();
        f24683b = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "ao-ui-working-th", false, 2, null);
    }

    public final AOThreadingTools.SingleThreadCoroutineScopeWrapper a() {
        return f24683b;
    }
}
