package Q0;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f5408a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5409b;

    /* renamed from: c, reason: collision with root package name */
    public c.f f5410c;

    /* renamed from: d, reason: collision with root package name */
    public int f5411d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f5412e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5413f = true;

    public static class a extends c.f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Reference<EditText> f5414a;

        public a(EditText editText) {
            this.f5414a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            Handler handler;
            super.b();
            EditText editText = this.f5414a.get();
            if (editText == null || (handler = editText.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            g.c(this.f5414a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f5408a = editText;
        this.f5409b = z10;
    }

    public static void c(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public c.f a() {
        if (this.f5410c == null) {
            this.f5410c = new a(this.f5408a);
        }
        return this.f5410c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f5413f;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void d(boolean z10) {
        if (this.f5413f != z10) {
            if (this.f5410c != null) {
                androidx.emoji2.text.c.c().u(this.f5410c);
            }
            this.f5413f = z10;
            if (z10) {
                c(this.f5408a, androidx.emoji2.text.c.c().e());
            }
        }
    }

    public final boolean e() {
        if (this.f5413f) {
            return (this.f5409b || androidx.emoji2.text.c.i()) ? false : true;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f5408a.isInEditMode() || e() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = androidx.emoji2.text.c.c().e();
        if (iE != 0) {
            if (iE == 1) {
                androidx.emoji2.text.c.c().s((Spannable) charSequence, i10, i10 + i12, this.f5411d, this.f5412e);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        androidx.emoji2.text.c.c().t(a());
    }
}
