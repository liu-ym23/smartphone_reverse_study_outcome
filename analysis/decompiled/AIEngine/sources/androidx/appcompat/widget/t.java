package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class t extends RadioButton implements androidx.core.widget.g {

    /* renamed from: a, reason: collision with root package name */
    public final i f931a;

    /* renamed from: b, reason: collision with root package name */
    public final d f932b;

    /* renamed from: c, reason: collision with root package name */
    public final z f933c;

    /* renamed from: d, reason: collision with root package name */
    public m f934d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.radioButtonStyle);
        u0.a(context);
        s0.a(this, getContext());
        i iVar = new i(this);
        this.f931a = iVar;
        iVar.b(attributeSet, R.attr.radioButtonStyle);
        d dVar = new d(this);
        this.f932b = dVar;
        dVar.d(attributeSet, R.attr.radioButtonStyle);
        z zVar = new z(this);
        this.f933c = zVar;
        zVar.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    private m getEmojiTextViewHelper() {
        if (this.f934d == null) {
            this.f934d = new m(this);
        }
        return this.f934d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f932b;
        if (dVar != null) {
            dVar.a();
        }
        z zVar = this.f933c;
        if (zVar != null) {
            zVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f932b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f932b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.g
    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f931a;
        if (iVar != null) {
            return iVar.f831b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f931a;
        if (iVar != null) {
            return iVar.f832c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f933c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f933c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f932b;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f932b;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f931a;
        if (iVar != null) {
            if (iVar.f835f) {
                iVar.f835f = false;
            } else {
                iVar.f835f = true;
                iVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f933c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f933c;
        if (zVar != null) {
            zVar.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f932b;
        if (dVar != null) {
            dVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f932b;
        if (dVar != null) {
            dVar.i(mode);
        }
    }

    @Override // androidx.core.widget.g
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f931a;
        if (iVar != null) {
            iVar.f831b = colorStateList;
            iVar.f833d = true;
            iVar.a();
        }
    }

    @Override // androidx.core.widget.g
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f931a;
        if (iVar != null) {
            iVar.f832c = mode;
            iVar.f834e = true;
            iVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        z zVar = this.f933c;
        zVar.h(colorStateList);
        zVar.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        z zVar = this.f933c;
        zVar.i(mode);
        zVar.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }
}
