package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends CharacterStyle implements UpdateAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f51007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f51008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f51009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51010d;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        float r101 = this.f51007a;
        if (r101 < 0.0f) goto L5;
        r100.setShadowLayer(r101, this.f51008b, this.f51009c, this.f51010d);
        return;
    L5:
        r100.clearShadowLayer();
    }

    public i(float r100, float r101, float r102, int r103) {
        this.f51007a = r100;
        this.f51008b = r101;
        this.f51009c = r102;
        this.f51010d = r103;
    }
}
