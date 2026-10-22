package com.bytedance.android.accessibilityLib_Core.engine;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.base.largertoucharea.LargeTouchAreaScope;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f38247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f38248b = null;

    static {
        int[] r100 = new int[LargeTouchAreaScope.values().length];
        f38247a = r100;
        r100[LargeTouchAreaScope.ALL.ordinal()] = 1;
        int[] r101 = new int[AccessiblityScope.values().length];
        f38248b = r101;
        r101[AccessiblityScope.View.ordinal()] = 1;
    }
}
