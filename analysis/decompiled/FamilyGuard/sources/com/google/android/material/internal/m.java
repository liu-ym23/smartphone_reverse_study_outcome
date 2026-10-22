package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import q1.C0982d;

/* loaded from: classes.dex */
public class m {

    /* renamed from: c, reason: collision with root package name */
    private float f13034c;

    /* renamed from: d, reason: collision with root package name */
    private float f13035d;

    /* renamed from: g, reason: collision with root package name */
    private C0982d f13038g;

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f13032a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final q1.f f13033b = new a();

    /* renamed from: e, reason: collision with root package name */
    private boolean f13036e = true;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<b> f13037f = new WeakReference<>(null);

    class a extends q1.f {
        a() {
        }

        @Override // q1.f
        public void a(int i5) {
            m.this.f13036e = true;
            b bVar = (b) m.this.f13037f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // q1.f
        public void b(Typeface typeface, boolean z5) {
            if (z5) {
                return;
            }
            m.this.f13036e = true;
            b bVar = (b) m.this.f13037f.get();
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

    public m(b bVar) {
        i(bVar);
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f13032a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f13032a.measureText(charSequence, 0, charSequence.length());
    }

    private void h(String str) {
        this.f13034c = d(str);
        this.f13035d = c(str);
        this.f13036e = false;
    }

    public C0982d e() {
        return this.f13038g;
    }

    public TextPaint f() {
        return this.f13032a;
    }

    public float g(String str) {
        if (!this.f13036e) {
            return this.f13034c;
        }
        h(str);
        return this.f13034c;
    }

    public void i(b bVar) {
        this.f13037f = new WeakReference<>(bVar);
    }

    public void j(C0982d c0982d, Context context) {
        if (this.f13038g != c0982d) {
            this.f13038g = c0982d;
            if (c0982d != null) {
                c0982d.q(context, this.f13032a, this.f13033b);
                b bVar = this.f13037f.get();
                if (bVar != null) {
                    this.f13032a.drawableState = bVar.getState();
                }
                c0982d.p(context, this.f13032a, this.f13033b);
                this.f13036e = true;
            }
            b bVar2 = this.f13037f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void k(boolean z5) {
        this.f13036e = z5;
    }

    public void l(Context context) {
        this.f13038g.p(context, this.f13032a, this.f13033b);
    }
}
