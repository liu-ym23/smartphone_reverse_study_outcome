package p0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f4658a;

    /* renamed from: b, reason: collision with root package name */
    public i f4659b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4660c = true;

    public j(EditText editText) {
        this.f4658a = editText;
    }

    public static void a(EditText editText, int i8) {
        int length;
        if (i8 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
            if (editableText == null) {
                length = 0;
            } else {
                jVarA.getClass();
                length = editableText.length();
            }
            jVarA.e(editableText, 0, length);
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
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) throws Throwable {
        EditText editText = this.f4658a;
        if (editText.isInEditMode() || !this.f4660c || androidx.emoji2.text.j.f608k == null || i9 > i10 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = androidx.emoji2.text.j.a().b();
        if (iB != 0) {
            if (iB == 1) {
                androidx.emoji2.text.j.a().e((Spannable) charSequence, i8, i10 + i8);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
        if (this.f4659b == null) {
            this.f4659b = new i(editText);
        }
        jVarA.f(this.f4659b);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
    }
}
