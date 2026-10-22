package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.bytedance.android.ecom.arch.slice.render.widget.background.SlcBackgroundDrawable;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f51011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uq.a f51012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f51013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SlcBackgroundDrawable f51014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f51015e;

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
    }

    public j(boolean r100, uq.a r101, float r102, SlcBackgroundDrawable r103, String r104) {
        this.f51011a = r100;
        this.f51012b = r101;
        this.f51013c = r102;
        this.f51014d = r103;
        this.f51015e = r104;
    }
}
