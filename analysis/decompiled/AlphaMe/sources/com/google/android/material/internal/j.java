package com.google.android.material.internal;

import android.text.TextPaint;
import com.stepos.alphame.utils.Property;
import java.lang.ref.WeakReference;
import w1.C0973d;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public float f10855c;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f10857e;

    /* renamed from: f, reason: collision with root package name */
    public C0973d f10858f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f10853a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final r1.b f10854b = new r1.b(1, this);

    /* renamed from: d, reason: collision with root package name */
    public boolean f10856d = true;

    public j(i iVar) {
        this.f10857e = new WeakReference(null);
        this.f10857e = new WeakReference(iVar);
    }

    public final float a(String str) {
        if (!this.f10856d) {
            return this.f10855c;
        }
        TextPaint textPaint = this.f10853a;
        this.f10855c = str == null ? Property.DEFAULT_FLOAT_VALUE : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f10856d = false;
        return this.f10855c;
    }
}
