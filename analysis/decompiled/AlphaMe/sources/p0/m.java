package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class m extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f13901a;

    /* renamed from: b, reason: collision with root package name */
    public l f13902b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f13903c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f13904d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13905e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f13906f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f13907g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f13908h;

    /* renamed from: i, reason: collision with root package name */
    public int f13909i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13910j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13911k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f13912l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f13901a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new o(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new o(this);
    }
}
