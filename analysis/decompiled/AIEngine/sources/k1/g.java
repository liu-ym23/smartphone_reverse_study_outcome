package k1;

import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.d;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f9853a;

    /* renamed from: b, reason: collision with root package name */
    public a f9854b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9855c = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends d.f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f9856a;

        public a(EditText editText) {
            this.f9856a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.d.f
        public final void b() {
            Handler handler;
            EditText editText = (EditText) this.f9856a.get();
            if (editText == null || (handler = editText.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            g.a((EditText) this.f9856a.get(), 1);
        }
    }

    public g(EditText editText) {
        this.f9853a = editText;
    }

    public static void a(EditText editText, int i10) throws Throwable {
        int length;
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.d dVarA = androidx.emoji2.text.d.a();
            if (editableText == null) {
                length = 0;
            } else {
                dVarA.getClass();
                length = editableText.length();
            }
            dVarA.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws Throwable {
        EditText editText = this.f9853a;
        if (editText.isInEditMode() || !this.f9855c || androidx.emoji2.text.d.f1927k == null || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = androidx.emoji2.text.d.a().b();
        if (iB != 0) {
            if (iB == 1) {
                androidx.emoji2.text.d.a().e((Spannable) charSequence, i10, i12 + i10);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        androidx.emoji2.text.d dVarA = androidx.emoji2.text.d.a();
        if (this.f9854b == null) {
            this.f9854b = new a(editText);
        }
        dVarA.f(this.f9854b);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
