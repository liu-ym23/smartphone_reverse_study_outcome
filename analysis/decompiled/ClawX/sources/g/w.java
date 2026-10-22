package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.widget.ImageView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class w extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final n f2849a;

    /* renamed from: b, reason: collision with root package name */
    public final d8.m f2850b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2851c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, int i8) {
        super(context, null, i8);
        r1.a(context);
        this.f2851c = false;
        q1.a(this, getContext());
        n nVar = new n(this);
        this.f2849a = nVar;
        nVar.d(null, i8);
        d8.m mVar = new d8.m(this);
        this.f2850b = mVar;
        mVar.c(null, i8);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f2849a;
        if (nVar != null) {
            nVar.a();
        }
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.f2849a;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.f2849a;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        s1 s1Var;
        d8.m mVar = this.f2850b;
        if (mVar == null || (s1Var = (s1) mVar.d) == null) {
            return null;
        }
        return (ColorStateList) s1Var.f2824c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        s1 s1Var;
        d8.m mVar = this.f2850b;
        if (mVar == null || (s1Var = (s1) mVar.d) == null) {
            return null;
        }
        return (PorterDuff.Mode) s1Var.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f2850b.f2077c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        n nVar = this.f2849a;
        if (nVar != null) {
            nVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        n nVar = this.f2849a;
        if (nVar != null) {
            nVar.f(i8);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        d8.m mVar = this.f2850b;
        if (mVar != null && drawable != null && !this.f2851c) {
            mVar.f2076b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (mVar != null) {
            mVar.a();
            if (this.f2851c) {
                return;
            }
            ImageView imageView = (ImageView) mVar.f2077c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(mVar.f2076b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i8) {
        super.setImageLevel(i8);
        this.f2851c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i8) {
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            ImageView imageView = (ImageView) mVar.f2077c;
            if (i8 != 0) {
                Drawable drawableP = b8.h.p(imageView.getContext(), i8);
                if (drawableP != null) {
                    int i9 = n0.f2786a;
                }
                imageView.setImageDrawable(drawableP);
            } else {
                imageView.setImageDrawable(null);
            }
            mVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.f2849a;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2849a;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            if (((s1) mVar.d) == null) {
                mVar.d = new s1();
            }
            s1 s1Var = (s1) mVar.d;
            s1Var.f2824c = colorStateList;
            s1Var.f2823b = true;
            mVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        d8.m mVar = this.f2850b;
        if (mVar != null) {
            if (((s1) mVar.d) == null) {
                mVar.d = new s1();
            }
            s1 s1Var = (s1) mVar.d;
            s1Var.d = mode;
            s1Var.f2822a = true;
            mVar.a();
        }
    }
}
