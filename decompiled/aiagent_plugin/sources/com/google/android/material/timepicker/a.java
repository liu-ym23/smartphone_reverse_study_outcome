package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ClickActionDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.core.view.accessibility.b.a f13669a;

    public a(Context r3, int r4) {
        this.f13669a = new androidx.core.view.accessibility.b.a(16, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getString(r4));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void a(View r1, androidx.core.view.accessibility.b r2) {
        super.a(r1, r2);
        r2.a(this.f13669a);
    }
}
