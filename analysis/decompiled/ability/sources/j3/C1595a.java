package j3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import e3.C1418g;
import e3.k;
import e3.l;
import e3.o;

/* renamed from: j3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1595a extends k implements h {

    /* renamed from: L, reason: collision with root package name */
    public CharSequence f4755L;

    /* renamed from: M, reason: collision with root package name */
    public final Context f4756M;

    /* renamed from: N, reason: collision with root package name */
    public final Paint.FontMetrics f4757N;

    /* renamed from: O, reason: collision with root package name */
    public final i f4758O;

    /* renamed from: P, reason: collision with root package name */
    public final Sa.a f4759P;

    /* renamed from: Q, reason: collision with root package name */
    public final Rect f4760Q;

    /* renamed from: R, reason: collision with root package name */
    public int f4761R;

    /* renamed from: S, reason: collision with root package name */
    public int f4762S;

    /* renamed from: T, reason: collision with root package name */
    public int f4763T;

    /* renamed from: U, reason: collision with root package name */
    public int f4764U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f4765V;

    /* renamed from: W, reason: collision with root package name */
    public int f4766W;

    /* renamed from: X, reason: collision with root package name */
    public int f4767X;

    /* renamed from: Y, reason: collision with root package name */
    public float f4768Y;

    /* renamed from: Z, reason: collision with root package name */
    public float f4769Z;

    /* renamed from: a0, reason: collision with root package name */
    public float f4770a0;
    public float b0;

    /* renamed from: c0, reason: collision with root package name */
    public float f4771c0;

    public C1595a(Context context, int i) {
        super(context, null, 0, i);
        this.f4757N = new Paint.FontMetrics();
        i iVar = new i(this);
        this.f4758O = iVar;
        this.f4759P = new Sa.a(this, 1);
        this.f4760Q = new Rect();
        this.f4768Y = 1.0f;
        this.f4769Z = 1.0f;
        this.f4770a0 = 0.5f;
        this.b0 = 0.5f;
        this.f4771c0 = 1.0f;
        this.f4756M = context;
        float f = context.getResources().getDisplayMetrics().density;
        TextPaint textPaint = iVar.f2501a;
        textPaint.density = f;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public final float A() {
        int i;
        Rect rect = this.f4760Q;
        if (((rect.right - getBounds().right) - this.f4767X) - this.f4764U < 0) {
            i = ((rect.right - getBounds().right) - this.f4767X) - this.f4764U;
        } else {
            if (((rect.left - getBounds().left) - this.f4767X) + this.f4764U <= 0) {
                return 0.0f;
            }
            i = ((rect.left - getBounds().left) - this.f4767X) + this.f4764U;
        }
        return i;
    }

    public final l B() {
        float f = -A();
        float fWidth = (float) ((getBounds().width() - (Math.sqrt(2.0d) * this.f4766W)) / 2.0d);
        return new l(new C1418g(this.f4766W), Math.min(Math.max(f, -fWidth), fWidth));
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float fA = A();
        float f = (float) (-((Math.sqrt(2.0d) * this.f4766W) - this.f4766W));
        canvas.scale(this.f4768Y, this.f4769Z, (getBounds().width() * this.f4770a0) + getBounds().left, (getBounds().height() * this.b0) + getBounds().top);
        canvas.translate(fA, f);
        super.draw(canvas);
        if (this.f4755L == null) {
            canvas2 = canvas;
        } else {
            float fCenterY = getBounds().centerY();
            i iVar = this.f4758O;
            TextPaint textPaint = iVar.f2501a;
            Paint.FontMetrics fontMetrics = this.f4757N;
            textPaint.getFontMetrics(fontMetrics);
            int i = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            if (iVar.f != null) {
                textPaint.drawableState = getState();
                iVar.f.d(this.f4756M, iVar.f2501a, iVar.b);
                textPaint.setAlpha((int) (this.f4771c0 * 255.0f));
            }
            CharSequence charSequence = this.f4755L;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i, textPaint);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.f4758O.f2501a.getTextSize(), this.f4763T);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f = this.f4761R * 2;
        CharSequence charSequence = this.f4755L;
        return (int) Math.max(f + (charSequence == null ? 0.0f : this.f4758O.a(charSequence.toString())), this.f4762S);
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f4765V) {
            o oVarF = this.b.f4345a.f();
            oVarF.k = B();
            setShapeAppearanceModel(oVarF.a());
        }
    }
}
