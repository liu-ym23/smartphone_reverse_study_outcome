package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f947a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f948b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f949c;

    public x0(Context context, TypedArray typedArray) {
        this.f947a = context;
        this.f948b = typedArray;
    }

    public static x0 e(Context context, AttributeSet attributeSet, int[] iArr, int i10) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, 0));
    }

    public final ColorStateList a(int i10) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = this.f948b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateListB = androidx.core.content.a.b(resourceId, this.f947a)) == null) ? typedArray.getColorStateList(i10) : colorStateListB;
    }

    public final Drawable b(int i10) {
        int resourceId;
        TypedArray typedArray = this.f948b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) ? typedArray.getDrawable(i10) : androidx.datastore.preferences.protobuf.b1.L(resourceId, this.f947a);
    }

    public final Drawable c(int i10) {
        int resourceId;
        Drawable drawableD;
        if (!this.f948b.hasValue(i10) || (resourceId = this.f948b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        j jVarA = j.a();
        Context context = this.f947a;
        synchronized (jVarA) {
            drawableD = jVarA.f848a.d(context, resourceId, true);
        }
        return drawableD;
    }

    public final Typeface d(int i10, int i11, z.a aVar) {
        int resourceId = this.f948b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f949c == null) {
            this.f949c = new TypedValue();
        }
        TypedValue typedValue = this.f949c;
        ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
        Context context = this.f947a;
        if (context.isRestricted()) {
            return null;
        }
        return m0.f.b(context, resourceId, typedValue, i11, aVar, true, false);
    }

    public final void f() {
        this.f948b.recycle();
    }
}
