package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.stepos.aiengine.R;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    public final h f802a;

    /* renamed from: b, reason: collision with root package name */
    public final d f803b;

    /* renamed from: c, reason: collision with root package name */
    public final z f804c;

    /* renamed from: d, reason: collision with root package name */
    public m f805d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        u0.a(context);
        s0.a(this, getContext());
        z zVar = new z(this);
        this.f804c = zVar;
        zVar.f(attributeSet, R.attr.checkedTextViewStyle);
        zVar.b();
        d dVar = new d(this);
        this.f803b = dVar;
        dVar.d(attributeSet, R.attr.checkedTextViewStyle);
        this.f802a = new h(this);
        Context context2 = getContext();
        int[] iArr = g.a.f8931l;
        x0 x0VarE = x0.e(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = x0VarE.f948b;
        Context context3 = getContext();
        TypedArray typedArray2 = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(this, context3, iArr, attributeSet, typedArray2, R.attr.checkedTextViewStyle, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(androidx.datastore.preferences.protobuf.b1.L(resourceId2, getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(androidx.datastore.preferences.protobuf.b1.L(resourceId, getContext()));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(x0VarE.a(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(f0.c(typedArray.getInt(3, -1), null));
            }
            x0VarE.f();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            x0VarE.f();
            throw th;
        }
    }

    private m getEmojiTextViewHelper() {
        if (this.f805d == null) {
            this.f805d = new m(this);
        }
        return this.f805d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        z zVar = this.f804c;
        if (zVar != null) {
            zVar.b();
        }
        d dVar = this.f803b;
        if (dVar != null) {
            dVar.a();
        }
        h hVar = this.f802a;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.e.c(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f803b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f803b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        h hVar = this.f802a;
        if (hVar != null) {
            return hVar.f825b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        h hVar = this.f802a;
        if (hVar != null) {
            return hVar.f826c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f804c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f804c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a4.a.q(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f803b;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f803b;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        h hVar = this.f802a;
        if (hVar != null) {
            if (hVar.f829f) {
                hVar.f829f = false;
            } else {
                hVar.f829f = true;
                hVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f804c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f804c;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f803b;
        if (dVar != null) {
            dVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f803b;
        if (dVar != null) {
            dVar.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        h hVar = this.f802a;
        if (hVar != null) {
            hVar.f825b = colorStateList;
            hVar.f827d = true;
            hVar.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        h hVar = this.f802a;
        if (hVar != null) {
            hVar.f826c = mode;
            hVar.f828e = true;
            hVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        z zVar = this.f804c;
        zVar.h(colorStateList);
        zVar.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        z zVar = this.f804c;
        zVar.i(mode);
        zVar.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i10) throws Resources.NotFoundException {
        super.setTextAppearance(context, i10);
        z zVar = this.f804c;
        if (zVar != null) {
            zVar.g(i10, context);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }
}
