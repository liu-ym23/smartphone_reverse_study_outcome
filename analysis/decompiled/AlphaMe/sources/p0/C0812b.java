package p0;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* renamed from: p0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0812b extends Animatable2.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.checkbox.a f13846a;

    public C0812b(com.google.android.material.checkbox.a aVar) {
        this.f13846a = aVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f13846a.f10546b.f10561o;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        com.google.android.material.checkbox.c cVar = this.f13846a.f10546b;
        ColorStateList colorStateList = cVar.f10561o;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(cVar.f10565s, colorStateList.getDefaultColor()));
        }
    }
}
