package R;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f4935a;

    /* renamed from: b, reason: collision with root package name */
    private int f4936b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f4937c = 0;

    /* renamed from: R.a$a, reason: collision with other inner class name */
    private static class C0074a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f4938a;

        /* renamed from: b, reason: collision with root package name */
        private final g f4939b;

        C0074a(EditText editText, boolean z5) {
            this.f4938a = editText;
            g gVar = new g(editText, z5);
            this.f4939b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(R.b.getInstance());
        }

        @Override // R.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // R.a.b
        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f4938a, inputConnection, editorInfo);
        }

        @Override // R.a.b
        void c(boolean z5) {
            this.f4939b.c(z5);
        }
    }

    static class b {
        b() {
        }

        KeyListener a(KeyListener keyListener) {
            throw null;
        }

        InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        void c(boolean z5) {
            throw null;
        }
    }

    public a(EditText editText, boolean z5) {
        D.h.f(editText, "editText cannot be null");
        this.f4935a = new C0074a(editText, z5);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f4935a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f4935a.b(inputConnection, editorInfo);
    }

    public void c(boolean z5) {
        this.f4935a.c(z5);
    }
}
