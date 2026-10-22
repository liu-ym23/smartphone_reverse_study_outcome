package com.bytedance.android.ecom.arch.slice.render.elements;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.InterfaceC0864a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f50408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f50409b;

    @Override // com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.InterfaceC0864a
    public final void a(AccessibilityNodeInfoCompat r100) {
        if (this.f50408a == true) goto L7;
        if (r100 == null) goto L8;
        r100.setClassName(this.f50409b);
        return;
    L8:
        return;
    }

    public e(boolean r100, String r101) {
        this.f50408a = r100;
        this.f50409b = r101;
    }
}
