package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class p {

    /* renamed from: c, reason: collision with root package name */
    public float f21141c;

    /* renamed from: d, reason: collision with root package name */
    public float f21142d;

    /* renamed from: g, reason: collision with root package name */
    public W2.d f21145g;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f21139a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final W2.f f21140b = new a();

    /* renamed from: e, reason: collision with root package name */
    public boolean f21143e = true;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<b> f21144f = new WeakReference<>(null);

    public class a extends W2.f {
        public a() {
        }

        @Override // W2.f
        public void a(int i10) {
            p.this.f21143e = true;
            b bVar = (b) p.this.f21144f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // W2.f
        public void b(Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            p.this.f21143e = true;
            b bVar = (b) p.this.f21144f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public p(b bVar) {
        j(bVar);
    }

    public final float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f21139a.getFontMetrics().ascent);
    }

    public final float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f21139a.measureText(charSequence, 0, charSequence.length());
    }

    public W2.d e() {
        return this.f21145g;
    }

    public float f(String str) {
        if (!this.f21143e) {
            return this.f21142d;
        }
        i(str);
        return this.f21142d;
    }

    public TextPaint g() {
        return this.f21139a;
    }

    public float h(String str) {
        if (!this.f21143e) {
            return this.f21141c;
        }
        i(str);
        return this.f21141c;
    }

    public final void i(String str) {
        this.f21141c = d(str);
        this.f21142d = c(str);
        this.f21143e = false;
    }

    public void j(b bVar) {
        this.f21144f = new WeakReference<>(bVar);
    }

    public void k(W2.d dVar, Context context) {
        if (this.f21145g != dVar) {
            this.f21145g = dVar;
            if (dVar != null) {
                dVar.q(context, this.f21139a, this.f21140b);
                b bVar = this.f21144f.get();
                if (bVar != null) {
                    this.f21139a.drawableState = bVar.getState();
                }
                dVar.p(context, this.f21139a, this.f21140b);
                this.f21143e = true;
            }
            b bVar2 = this.f21144f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z10) {
        this.f21143e = z10;
    }

    public void m(boolean z10) {
        this.f21143e = z10;
    }

    public void n(Context context) {
        this.f21145g.p(context, this.f21139a, this.f21140b);
    }
}
