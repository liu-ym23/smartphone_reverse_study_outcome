package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f1027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v.a f1028b;

    public g(EditText r10) {
        this.f1027a = r10;
        this.f1028b = new v.a(r10, false);
    }

    public KeyListener a(KeyListener r10) {
        if (b(r10) == true) goto L5;
        return r10;
    L5:
        return this.f1028b.a(r10);
    }

    public boolean b(KeyListener r10) {
        return !(r10 instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.f1028b.b();
    }

    public void d(AttributeSet r10, int r11) {
        TypedArray r12 = this.f1027a.getContext().obtainStyledAttributes(r10, R$styleable.AppCompatTextView, r11, 0);
        int r13 = R$styleable.AppCompatTextView_emojiCompatEnabled;     // Catch: Throwable -> L7
        boolean r14 = true;
        if (r12.hasValue(r13) == false) goto L9;
        r14 = r12.getBoolean(r13, true);     // Catch: Throwable -> L7
    L9:
        r12.recycle();
        f(r14);
        return;
    L7:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public InputConnection e(InputConnection r10, EditorInfo r11) {
        return this.f1028b.c(r10, r11);
    }

    public void f(boolean r10) {
        this.f1028b.d(r10);
    }
}
