package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends v0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CheckableImageButton f5053a;

    public a(CheckableImageButton checkableImageButton) {
        this.f5053a = checkableImageButton;
    }

    @Override // v0.a
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f5053a.f5035d);
    }

    @Override // v0.a
    public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        CheckableImageButton checkableImageButton = this.f5053a;
        bVar.f13532a.setCheckable(checkableImageButton.f5036e);
        bVar.f13532a.setChecked(checkableImageButton.f5035d);
    }
}
