package Z;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class d extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2130a;

    /* renamed from: b, reason: collision with root package name */
    public final y1.f f2131b;

    public d(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        y1.f fVar = new y1.f();
        super(inputConnection, false);
        this.f2130a = editText;
        this.f2131b = fVar;
        if (X.j.f2054k != null) {
            X.j jVarA = X.j.a();
            if (jVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            jVarA.f2059e.J(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i4, int i5) {
        Editable editableText = this.f2130a.getEditableText();
        this.f2131b.getClass();
        return y1.f.i(this, editableText, i4, i5, false) || super.deleteSurroundingText(i4, i5);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i4, int i5) {
        Editable editableText = this.f2130a.getEditableText();
        this.f2131b.getClass();
        return y1.f.i(this, editableText, i4, i5, true) || super.deleteSurroundingTextInCodePoints(i4, i5);
    }
}
