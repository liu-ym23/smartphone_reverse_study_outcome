package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class w extends ImageButton {

    /* renamed from: c, reason: collision with root package name */
    public final ed.o f8111c;

    /* renamed from: f, reason: collision with root package name */
    public final b2.a f8112f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8113g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2.a(context);
        this.f8113g = false;
        l2.a(this, getContext());
        ed.o oVar = new ed.o(this);
        this.f8111c = oVar;
        oVar.e(attributeSet, i);
        b2.a aVar = new b2.a(this);
        this.f8112f = aVar;
        aVar.j(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            oVar.a();
        }
        b2.a aVar = this.f8112f;
        if (aVar != null) {
            aVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        ad.h hVar;
        b2.a aVar = this.f8112f;
        if (aVar == null || (hVar = (ad.h) aVar.f1862d) == null) {
            return null;
        }
        return (ColorStateList) hVar.f509c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        ad.h hVar;
        b2.a aVar = this.f8112f;
        if (aVar == null || (hVar = (ad.h) aVar.f1862d) == null) {
            return null;
        }
        return (PorterDuff.Mode) hVar.f510d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f8112f.f1861c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            oVar.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        b2.a aVar = this.f8112f;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        b2.a aVar = this.f8112f;
        if (aVar != null && drawable != null && !this.f8113g) {
            aVar.f1860b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (aVar != null) {
            aVar.c();
            if (this.f8113g) {
                return;
            }
            ImageView imageView = (ImageView) aVar.f1861c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(aVar.f1860b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f8113g = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        b2.a aVar = this.f8112f;
        ImageView imageView = (ImageView) aVar.f1861c;
        if (i != 0) {
            Drawable drawableV = id.k.v(i, imageView.getContext());
            if (drawableV != null) {
                Rect rect = e1.f7901a;
            }
            imageView.setImageDrawable(drawableV);
        } else {
            imageView.setImageDrawable(null);
        }
        aVar.c();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b2.a aVar = this.f8112f;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            oVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ed.o oVar = this.f8111c;
        if (oVar != null) {
            oVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        b2.a aVar = this.f8112f;
        if (aVar != null) {
            if (((ad.h) aVar.f1862d) == null) {
                aVar.f1862d = new ad.h();
            }
            ad.h hVar = (ad.h) aVar.f1862d;
            hVar.f509c = colorStateList;
            hVar.f508b = true;
            aVar.c();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        b2.a aVar = this.f8112f;
        if (aVar != null) {
            if (((ad.h) aVar.f1862d) == null) {
                aVar.f1862d = new ad.h();
            }
            ad.h hVar = (ad.h) aVar.f1862d;
            hVar.f510d = mode;
            hVar.f507a = true;
            aVar.c();
        }
    }
}
