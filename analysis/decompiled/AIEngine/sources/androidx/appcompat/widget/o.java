package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f903a;

    /* renamed from: b, reason: collision with root package name */
    public v0 f904b;

    /* renamed from: c, reason: collision with root package name */
    public int f905c = 0;

    public o(ImageView imageView) {
        this.f903a = imageView;
    }

    public final void a() {
        v0 v0Var;
        ImageView imageView = this.f903a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            f0.a(drawable);
        }
        if (drawable == null || (v0Var = this.f904b) == null) {
            return;
        }
        j.e(drawable, v0Var, imageView.getDrawableState());
    }

    public final void b(AttributeSet attributeSet, int i10) {
        int resourceId;
        ImageView imageView = this.f903a;
        Context context = imageView.getContext();
        int[] iArr = g.a.f8926f;
        x0 x0VarE = x0.e(context, attributeSet, iArr, i10);
        TypedArray typedArray = x0VarE.f948b;
        Context context2 = imageView.getContext();
        TypedArray typedArray2 = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(imageView, context2, iArr, attributeSet, typedArray2, i10, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = androidx.datastore.preferences.protobuf.b1.L(resourceId, imageView.getContext())) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                f0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(x0VarE.a(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(f0.c(typedArray.getInt(3, -1), null));
            }
            x0VarE.f();
        } catch (Throwable th) {
            x0VarE.f();
            throw th;
        }
    }
}
