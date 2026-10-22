package c4;

import android.text.Editable;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public TextView f2192a;

    /* renamed from: b, reason: collision with root package name */
    public f7.f f2193b;

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i3) {
        f7.f fVar = this.f2193b;
        Editable editableText = this.f2192a.getEditableText();
        fVar.getClass();
        return f7.f.p(this, editableText, i, i3, false) || super.deleteSurroundingText(i, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i3) {
        f7.f fVar = this.f2193b;
        Editable editableText = this.f2192a.getEditableText();
        fVar.getClass();
        return f7.f.p(this, editableText, i, i3, true) || super.deleteSurroundingTextInCodePoints(i, i3);
    }
}
