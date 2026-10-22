package Z;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.widget.U0;

/* loaded from: classes.dex */
public final class j implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f2142a;

    /* renamed from: c, reason: collision with root package name */
    public U0 f2144c;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2143b = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2145d = true;

    public j(EditText editText) {
        this.f2142a = editText;
    }

    public static void a(EditText editText, int i4) {
        int length;
        if (i4 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            X.j jVarA = X.j.a();
            if (editableText == null) {
                length = 0;
            } else {
                jVarA.getClass();
                length = editableText.length();
            }
            jVarA.f(0, length, editableText);
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
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        EditText editText = this.f2142a;
        if (editText.isInEditMode() || !this.f2145d) {
            return;
        }
        if ((this.f2143b || X.j.f2054k != null) && i5 <= i6 && (charSequence instanceof Spannable)) {
            int iB = X.j.a().b();
            if (iB != 0) {
                if (iB == 1) {
                    X.j.a().f(i4, i6 + i4, (Spannable) charSequence);
                    return;
                } else if (iB != 3) {
                    return;
                }
            }
            X.j jVarA = X.j.a();
            if (this.f2144c == null) {
                this.f2144c = new U0(editText);
            }
            jVarA.g(this.f2144c);
        }
    }
}
