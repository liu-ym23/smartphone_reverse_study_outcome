package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import d.C0527a;
import g.AbstractC0560a;

/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2808a;

    /* renamed from: b, reason: collision with root package name */
    public final C0527a f2809b;

    public D(TextView textView) {
        this.f2808a = textView;
        this.f2809b = new C0527a(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((y1.f) this.f2809b.f12410b).h(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i4) {
        TypedArray typedArrayObtainStyledAttributes = this.f2808a.getContext().obtainStyledAttributes(attributeSet, AbstractC0560a.f12596i, i4, 0);
        try {
            boolean z4 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z4);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z4) {
        ((y1.f) this.f2809b.f12410b).m(z4);
    }

    public final void d(boolean z4) {
        ((y1.f) this.f2809b.f12410b).n(z4);
    }
}
