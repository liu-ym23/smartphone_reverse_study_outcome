package v;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f24952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f24953b;

    public static class a {
        public a() {
        }

        public boolean a(Editable r10, int r11, KeyEvent r12) {
            return EmojiCompat.f(r10, r11, r12);
        }
    }

    public e(KeyListener r10) {
        this(r10, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View r10, Editable r11, int r12) {
        this.f24952a.clearMetaKeyState(r10, r11, r12);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f24952a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View r10, Editable r11, int r12, KeyEvent r13) {
        if (this.f24953b.a(r11, r12, r13) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f24952a.onKeyDown(r10, r11, r12, r13) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View r10, Editable r11, KeyEvent r12) {
        return this.f24952a.onKeyOther(r10, r11, r12);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View r10, Editable r11, int r12, KeyEvent r13) {
        return this.f24952a.onKeyUp(r10, r11, r12, r13);
    }

    public e(KeyListener r10, a r11) {
        this.f24952a = r10;
        this.f24953b = r11;
    }
}
