package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0443m {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f8588a;

    /* renamed from: b, reason: collision with root package name */
    private final R.a f8589b;

    C0443m(EditText editText) {
        this.f8588a = editText;
        this.f8589b = new R.a(editText, false);
    }

    KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f8589b.a(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    void c(AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = this.f8588a.getContext().obtainStyledAttributes(attributeSet, g.j.f17125g0, i5, 0);
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

    InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f8589b.b(inputConnection, editorInfo);
    }

    void e(boolean z5) {
        this.f8589b.c(z5);
    }
}
