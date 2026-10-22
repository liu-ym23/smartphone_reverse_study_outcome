package c4;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    public EditText f2203c;

    /* renamed from: f, reason: collision with root package name */
    public h f2204f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2205g;

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            a4.j jVarA = a4.j.a();
            if (editableText == null) {
                length = 0;
            } else {
                jVarA.getClass();
                length = editableText.length();
            }
            jVarA.f(0, length, 0, editableText);
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
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i10) throws Throwable {
        EditText editText = this.f2203c;
        if (!editText.isInEditMode() && this.f2205g && a4.j.c() && i3 <= i10 && (charSequence instanceof Spannable)) {
            int iB = a4.j.a().b();
            if (iB != 0) {
                if (iB == 1) {
                    a4.j.a().f(i, i10 + i, 0, (Spannable) charSequence);
                    return;
                } else if (iB != 3) {
                    return;
                }
            }
            a4.j jVarA = a4.j.a();
            if (this.f2204f == null) {
                h hVar = new h();
                hVar.f2202c = new WeakReference(editText);
                VarHandle.storeStoreFence();
                this.f2204f = hVar;
            }
            jVarA.g(this.f2204f);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i10) {
    }
}
