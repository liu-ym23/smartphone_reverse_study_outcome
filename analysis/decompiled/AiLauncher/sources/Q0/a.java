package Q0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f5387a;

    /* renamed from: b, reason: collision with root package name */
    public int f5388b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f5389c = 0;

    /* renamed from: Q0.a$a, reason: collision with other inner class name */
    public static class C0094a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f5390a;

        /* renamed from: b, reason: collision with root package name */
        public final g f5391b;

        public C0094a(EditText editText, boolean z10) {
            this.f5390a = editText;
            g gVar = new g(editText, z10);
            this.f5391b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(Q0.b.getInstance());
        }

        @Override // Q0.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // Q0.a.b
        public boolean b() {
            return this.f5391b.b();
        }

        @Override // Q0.a.b
        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f5390a, inputConnection, editorInfo);
        }

        @Override // Q0.a.b
        public void d(boolean z10) {
            this.f5391b.d(z10);
        }
    }

    public static class b {
        public KeyListener a(KeyListener keyListener) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        public void d(boolean z10) {
            throw null;
        }
    }

    public a(EditText editText, boolean z10) {
        B0.h.g(editText, "editText cannot be null");
        this.f5387a = new C0094a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f5387a.a(keyListener);
    }

    public boolean b() {
        return this.f5387a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f5387a.c(inputConnection, editorInfo);
    }

    public void d(boolean z10) {
        this.f5387a.d(z10);
    }
}
