package com.google.android.material.internal;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public float f5100c;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference<b> f5102e;

    /* renamed from: f, reason: collision with root package name */
    public w4.d f5103f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f5098a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final a f5099b = new a();

    /* renamed from: d, reason: collision with root package name */
    public boolean f5101d = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.datastore.preferences.protobuf.f {
        public a() {
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void g(int i10) {
            g gVar = g.this;
            gVar.f5101d = true;
            b bVar = gVar.f5102e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void h(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            g gVar = g.this;
            gVar.f5101d = true;
            b bVar = gVar.f5102e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public g(com.google.android.material.chip.a aVar) {
        this.f5102e = new WeakReference<>(null);
        this.f5102e = new WeakReference<>(aVar);
    }

    public final float a(String str) {
        if (!this.f5101d) {
            return this.f5100c;
        }
        TextPaint textPaint = this.f5098a;
        this.f5100c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f5101d = false;
        return this.f5100c;
    }
}
