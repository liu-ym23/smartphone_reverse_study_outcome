package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends ViewGroup {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends ConstraintLayout.a {
        public float A0;
        public float B0;
        public float C0;
        public float D0;

        /* renamed from: r0, reason: collision with root package name */
        public float f1422r0;

        /* renamed from: s0, reason: collision with root package name */
        public boolean f1423s0;

        /* renamed from: t0, reason: collision with root package name */
        public float f1424t0;

        /* renamed from: u0, reason: collision with root package name */
        public float f1425u0;

        /* renamed from: v0, reason: collision with root package name */
        public float f1426v0;

        /* renamed from: w0, reason: collision with root package name */
        public float f1427w0;

        /* renamed from: x0, reason: collision with root package name */
        public float f1428x0;

        /* renamed from: y0, reason: collision with root package name */
        public float f1429y0;
        public float z0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        a aVar = new a();
        aVar.f1422r0 = 1.0f;
        aVar.f1423s0 = false;
        aVar.f1424t0 = 0.0f;
        aVar.f1425u0 = 0.0f;
        aVar.f1426v0 = 0.0f;
        aVar.f1427w0 = 0.0f;
        aVar.f1428x0 = 1.0f;
        aVar.f1429y0 = 1.0f;
        aVar.z0 = 0.0f;
        aVar.A0 = 0.0f;
        aVar.B0 = 0.0f;
        aVar.C0 = 0.0f;
        aVar.D0 = 0.0f;
        return aVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        a aVar = new a(context, attributeSet);
        aVar.f1422r0 = 1.0f;
        aVar.f1423s0 = false;
        aVar.f1424t0 = 0.0f;
        aVar.f1425u0 = 0.0f;
        aVar.f1426v0 = 0.0f;
        aVar.f1427w0 = 0.0f;
        aVar.f1428x0 = 1.0f;
        aVar.f1429y0 = 1.0f;
        aVar.z0 = 0.0f;
        aVar.A0 = 0.0f;
        aVar.B0 = 0.0f;
        aVar.C0 = 0.0f;
        aVar.D0 = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9642d);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == 15) {
                aVar.f1422r0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1422r0);
            } else if (index == 28) {
                aVar.f1424t0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1424t0);
                aVar.f1423s0 = true;
            } else if (index == 23) {
                aVar.f1426v0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1426v0);
            } else if (index == 24) {
                aVar.f1427w0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1427w0);
            } else if (index == 22) {
                aVar.f1425u0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1425u0);
            } else if (index == 20) {
                aVar.f1428x0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1428x0);
            } else if (index == 21) {
                aVar.f1429y0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.f1429y0);
            } else if (index == 16) {
                aVar.z0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.z0);
            } else if (index == 17) {
                aVar.A0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.A0);
            } else if (index == 18) {
                aVar.B0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.B0);
            } else if (index == 19) {
                aVar.C0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.C0);
            } else if (index == 27) {
                aVar.D0 = typedArrayObtainStyledAttributes.getFloat(index, aVar.D0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public c getConstraintSet() {
        getChildCount();
        throw null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
    }
}
