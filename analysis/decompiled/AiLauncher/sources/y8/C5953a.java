package y8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import v8.C5671a;

/* renamed from: y8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5953a extends io.noties.markwon.image.e {

    /* renamed from: a, reason: collision with root package name */
    public final C5963k f43943a;

    /* renamed from: b, reason: collision with root package name */
    public final int f43944b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f43945c;

    public C5953a(C5671a c5671a, C5963k c5963k, int i10) {
        super(c5671a, c5963k, 2, false);
        this.f43943a = c5963k;
        this.f43944b = i10;
        this.f43945c = i10 != 0;
    }

    @Override // io.noties.markwon.image.e, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        if (!this.f43945c && this.f43943a.h()) {
            Drawable drawableG = this.f43943a.g();
            if (drawableG instanceof Bc.b) {
                ((Bc.b) drawableG).b().d(new Cc.c(paint.getColor()));
                this.f43945c = true;
            }
        }
        super.draw(canvas, charSequence, i10, i11, f10, i12, i13, i14, paint);
    }
}
