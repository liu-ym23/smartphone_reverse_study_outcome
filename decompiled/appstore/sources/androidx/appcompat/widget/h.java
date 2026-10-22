package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v.f f1030b;

    public h(TextView r10) {
        this.f1029a = r10;
        this.f1030b = new v.f(r10, false);
    }

    public InputFilter[] a(InputFilter[] r10) {
        return this.f1030b.a(r10);
    }

    public boolean b() {
        return this.f1030b.b();
    }

    public void c(AttributeSet r10, int r11) {
        TypedArray r12 = this.f1029a.getContext().obtainStyledAttributes(r10, R$styleable.AppCompatTextView, r11, 0);
        int r13 = R$styleable.AppCompatTextView_emojiCompatEnabled;     // Catch: Throwable -> L7
        boolean r14 = true;
        if (r12.hasValue(r13) == false) goto L9;
        r14 = r12.getBoolean(r13, true);     // Catch: Throwable -> L7
    L9:
        r12.recycle();
        e(r14);
        return;
    L7:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public void d(boolean r10) {
        this.f1030b.c(r10);
    }

    public void e(boolean r10) {
        this.f1030b.d(r10);
    }

    public TransformationMethod f(TransformationMethod r10) {
        return this.f1030b.e(r10);
    }
}
