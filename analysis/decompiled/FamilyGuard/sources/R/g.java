package R;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f4956a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4957b;

    /* renamed from: c, reason: collision with root package name */
    private e.f f4958c;

    /* renamed from: d, reason: collision with root package name */
    private int f4959d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f4960e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f4961f = true;

    private static class a extends e.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<EditText> f4962a;

        a(EditText editText) {
            this.f4962a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            super.b();
            g.b(this.f4962a.get(), 1);
        }
    }

    g(EditText editText, boolean z5) {
        this.f4956a = editText;
        this.f4957b = z5;
    }

    private e.f a() {
        if (this.f4958c == null) {
            this.f4958c = new a(this.f4956a);
        }
        return this.f4958c;
    }

    static void b(EditText editText, int i5) {
        if (i5 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.e.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        if (this.f4961f) {
            return (this.f4957b || androidx.emoji2.text.e.i()) ? false : true;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
    }

    public void c(boolean z5) {
        if (this.f4961f != z5) {
            if (this.f4958c != null) {
                androidx.emoji2.text.e.c().u(this.f4958c);
            }
            this.f4961f = z5;
            if (z5) {
                b(this.f4956a, androidx.emoji2.text.e.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        if (this.f4956a.isInEditMode() || d() || i6 > i7 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.e.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.e.c().s((Spannable) charSequence, i5, i5 + i7, this.f4959d, this.f4960e);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        androidx.emoji2.text.e.c().t(a());
    }
}
