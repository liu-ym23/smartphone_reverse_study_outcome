package R;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: classes.dex */
final class e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    private final KeyListener f4949a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4950b;

    public static class a {
        public boolean a(Editable editable, int i5, KeyEvent keyEvent) {
            return androidx.emoji2.text.e.g(editable, i5, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i5) {
        this.f4949a.clearMetaKeyState(view, editable, i5);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f4949a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i5, KeyEvent keyEvent) {
        return this.f4950b.a(editable, i5, keyEvent) || this.f4949a.onKeyDown(view, editable, i5, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f4949a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i5, KeyEvent keyEvent) {
        return this.f4949a.onKeyUp(view, editable, i5, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f4949a = keyListener;
        this.f4950b = aVar;
    }
}
