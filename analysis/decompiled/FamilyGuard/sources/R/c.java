package R;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* loaded from: classes.dex */
final class c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4943a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4944b;

    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
            return androidx.emoji2.text.e.f(inputConnection, editable, i5, i6, z5);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.e.i()) {
                androidx.emoji2.text.e.c().v(editorInfo);
            }
        }
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f4943a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i5, int i6) {
        return this.f4944b.a(this, a(), i5, i6, false) || super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        return this.f4944b.a(this, a(), i5, i6, true) || super.deleteSurroundingTextInCodePoints(i5, i6);
    }

    c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f4943a = textView;
        this.f4944b = aVar;
        aVar.b(editorInfo);
    }
}
