package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final g f824a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f825b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f826c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f827d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f828e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f829f;

    public h(g gVar) {
        this.f824a = gVar;
    }

    public final void a() {
        g gVar = this.f824a;
        Drawable checkMarkDrawable = gVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f827d || this.f828e) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f827d) {
                    drawableMutate.setTintList(this.f825b);
                }
                if (this.f828e) {
                    drawableMutate.setTintMode(this.f826c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(gVar.getDrawableState());
                }
                gVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }
}
