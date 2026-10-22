package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import c3.C0876f;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class i {
    public float c;
    public final WeakReference e;
    public C0876f f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f2501a = new TextPaint(1);
    public final V2.a b = new V2.a(this, 1);
    public boolean d = true;

    public i(h hVar) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(hVar);
    }

    public final float a(String str) {
        if (!this.d) {
            return this.c;
        }
        TextPaint textPaint = this.f2501a;
        this.c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.d = false;
        return this.c;
    }

    public final void b(C0876f c0876f, Context context) {
        if (this.f != c0876f) {
            this.f = c0876f;
            if (c0876f != null) {
                TextPaint textPaint = this.f2501a;
                V2.a aVar = this.b;
                c0876f.e(context, textPaint, aVar);
                h hVar = (h) this.e.get();
                if (hVar != null) {
                    textPaint.drawableState = hVar.getState();
                }
                c0876f.d(context, textPaint, aVar);
                this.d = true;
            }
            h hVar2 = (h) this.e.get();
            if (hVar2 != null) {
                hVar2.a();
                hVar2.onStateChange(hVar2.getState());
            }
        }
    }
}
