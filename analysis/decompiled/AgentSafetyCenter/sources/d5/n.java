package d5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f3248a;

    /* renamed from: b, reason: collision with root package name */
    public m f3249b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f3250c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f3251d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3252e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f3253f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f3254g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f3255h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3256j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3257k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f3258l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f3248a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new p(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new p(this);
    }
}
