package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f888a;

    /* renamed from: b, reason: collision with root package name */
    public final k1.f f889b;

    public m(TextView textView) {
        this.f888a = textView;
        this.f889b = new k1.f(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f889b.f9848a.a(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f888a.getContext().obtainStyledAttributes(attributeSet, g.a.f8928i, i10, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            d(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z) {
        this.f889b.f9848a.c(z);
    }

    public final void d(boolean z) {
        this.f889b.f9848a.d(z);
    }
}
