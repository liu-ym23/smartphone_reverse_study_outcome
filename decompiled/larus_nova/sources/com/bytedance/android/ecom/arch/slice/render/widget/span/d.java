package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends CharacterStyle implements UpdateAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50986a;

    public d(int r100) {
        this.f50986a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100.getShader() != null) goto L6;
        r100.setColor(this.f50986a);
        return;
    L6:
        if (r100.getAlpha() == 255) goto L10;
        r100.setAlpha(255);
        return;
    }
}
