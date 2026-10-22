package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.stepos.alphame.R;

/* renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0213m extends G implements InterfaceC0219p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0217o f3124a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0213m(C0217o c0217o, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f3124a = c0217o;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        h1.a(this, getContentDescription());
        setOnTouchListener(new C0211l(0, this, this, c0217o));
    }

    @Override // androidx.appcompat.widget.InterfaceC0219p
    public final boolean a() {
        return false;
    }

    @Override // androidx.appcompat.widget.InterfaceC0219p
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f3124a.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i4, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i4, i5, i6, i7);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            E.a.f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
