package v;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f24938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24940c;

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    public static class C0391a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f24941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f24942b;

        public C0391a(EditText r10, boolean r11) {
            this.f24941a = r10;
            g r12 = new g(r10, r11);
            this.f24942b = r12;
            r10.addTextChangedListener(r12);
            r10.setEditableFactory(v.b.getInstance());
        }

        @Override // v.a.b
        public KeyListener a(KeyListener r10) {
            if ((r10 instanceof e) == false) goto L5;
            return r10;
        L5:
            if (r10 != null) goto L9;
            return null;
        L9:
            if ((r10 instanceof NumberKeyListener) == false) goto L12;
            return r10;
        L12:
            return new e(r10);
        }

        @Override // v.a.b
        public boolean b() {
            return this.f24942b.b();
        }

        @Override // v.a.b
        public InputConnection c(InputConnection r10, EditorInfo r11) {
            if ((r10 instanceof c) == false) goto L6;
            return r10;
        L6:
            return new c(this.f24941a, r10, r11);
        }

        @Override // v.a.b
        public void d(boolean r10) {
            this.f24942b.d(r10);
        }
    }

    public static class b {
        public b() {
        }

        public abstract KeyListener a(KeyListener r10);

        public abstract boolean b();

        public abstract InputConnection c(InputConnection r10, EditorInfo r11);

        public abstract void d(boolean r10);
    }

    public a(EditText r10, boolean r11) {
        this.f24939b = Channel.UNLIMITED;
        this.f24940c = 0;
        androidx.core.util.e.h(r10, "editText cannot be null");
        this.f24938a = new C0391a(r10, r11);
    }

    public KeyListener a(KeyListener r10) {
        return this.f24938a.a(r10);
    }

    public boolean b() {
        return this.f24938a.b();
    }

    public InputConnection c(InputConnection r10, EditorInfo r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return this.f24938a.c(r10, r11);
    }

    public void d(boolean r10) {
        this.f24938a.d(r10);
    }
}
