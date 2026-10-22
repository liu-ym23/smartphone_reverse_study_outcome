package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0444n {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f8590a;

    /* renamed from: b, reason: collision with root package name */
    private final R.f f8591b;

    C0444n(TextView textView) {
        this.f8590a = textView;
        this.f8591b = new R.f(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f8591b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f8591b.b();
    }

    void c(AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = this.f8590a.getContext().obtainStyledAttributes(attributeSet, g.j.f17125g0, i5, 0);
        try {
            int i6 = g.j.f17195u0;
            boolean z5 = typedArrayObtainStyledAttributes.hasValue(i6) ? typedArrayObtainStyledAttributes.getBoolean(i6, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z5);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z5) {
        this.f8591b.c(z5);
    }

    void e(boolean z5) {
        this.f8591b.d(z5);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f8591b.e(transformationMethod);
    }
}
