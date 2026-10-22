package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f830a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f831b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f832c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f833d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f834e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f835f;

    public i(CompoundButton compoundButton) {
        this.f830a = compoundButton;
    }

    public final void a() {
        CompoundButton compoundButton = this.f830a;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f833d || this.f834e) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.f833d) {
                    drawableMutate.setTintList(this.f831b);
                }
                if (this.f834e) {
                    drawableMutate.setTintMode(this.f832c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i10) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = this.f830a;
        Context context = compoundButton.getContext();
        int[] iArr = g.a.f8932m;
        x0 x0VarE = x0.e(context, attributeSet, iArr, i10);
        TypedArray typedArray = x0VarE.f948b;
        Context context2 = compoundButton.getContext();
        TypedArray typedArray2 = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(compoundButton, context2, iArr, attributeSet, typedArray2, i10, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(androidx.datastore.preferences.protobuf.b1.L(resourceId2, compoundButton.getContext()));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(androidx.datastore.preferences.protobuf.b1.L(resourceId, compoundButton.getContext()));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(x0VarE.a(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(f0.c(typedArray.getInt(3, -1), null));
            }
            x0VarE.f();
        } catch (Throwable th) {
            x0VarE.f();
            throw th;
        }
    }
}
