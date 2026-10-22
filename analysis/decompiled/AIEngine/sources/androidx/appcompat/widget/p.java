package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class p extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final d f906a;

    /* renamed from: b, reason: collision with root package name */
    public final o f907b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f908c;

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f906a;
        if (dVar != null) {
            dVar.a();
        }
        o oVar = this.f907b;
        if (oVar != null) {
            oVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f906a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f906a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        v0 v0Var;
        o oVar = this.f907b;
        if (oVar == null || (v0Var = oVar.f904b) == null) {
            return null;
        }
        return v0Var.f937a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        v0 v0Var;
        o oVar = this.f907b;
        if (oVar == null || (v0Var = oVar.f904b) == null) {
            return null;
        }
        return v0Var.f938b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(this.f907b.f903a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f906a;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f906a;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        o oVar = this.f907b;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        o oVar = this.f907b;
        if (oVar != null && drawable != null && !this.f908c) {
            oVar.f905c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (oVar != null) {
            oVar.a();
            if (this.f908c) {
                return;
            }
            ImageView imageView = oVar.f903a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(oVar.f905c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f908c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        o oVar = this.f907b;
        if (oVar != null) {
            ImageView imageView = oVar.f903a;
            if (i10 != 0) {
                Drawable drawableL = androidx.datastore.preferences.protobuf.b1.L(i10, imageView.getContext());
                if (drawableL != null) {
                    f0.a(drawableL);
                }
                imageView.setImageDrawable(drawableL);
            } else {
                imageView.setImageDrawable(null);
            }
            oVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o oVar = this.f907b;
        if (oVar != null) {
            oVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f906a;
        if (dVar != null) {
            dVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f906a;
        if (dVar != null) {
            dVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        o oVar = this.f907b;
        if (oVar != null) {
            if (oVar.f904b == null) {
                oVar.f904b = new v0();
            }
            v0 v0Var = oVar.f904b;
            v0Var.f937a = colorStateList;
            v0Var.f940d = true;
            oVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        o oVar = this.f907b;
        if (oVar != null) {
            if (oVar.f904b == null) {
                oVar.f904b = new v0();
            }
            v0 v0Var = oVar.f904b;
            v0Var.f938b = mode;
            v0Var.f939c = true;
            oVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        u0.a(context);
        this.f908c = false;
        s0.a(this, getContext());
        d dVar = new d(this);
        this.f906a = dVar;
        dVar.d(attributeSet, i10);
        o oVar = new o(this);
        this.f907b = oVar;
        oVar.b(attributeSet, i10);
    }
}
