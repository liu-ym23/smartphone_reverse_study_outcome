package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1297j {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f9213a;

    /* renamed from: b, reason: collision with root package name */
    public final Q0.f f9214b;

    public C1297j(TextView textView) {
        this.f9213a = textView;
        this.f9214b = new Q0.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f9214b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f9214b.b();
    }

    public void c(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f9213a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(i11) ? typedArrayObtainStyledAttributes.getBoolean(i11, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z10) {
        this.f9214b.c(z10);
    }

    public void e(boolean z10) {
        this.f9214b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f9214b.e(transformationMethod);
    }
}
