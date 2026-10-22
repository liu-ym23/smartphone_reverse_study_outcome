package Z;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.widget.U0;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class a extends y1.f {

    /* renamed from: c, reason: collision with root package name */
    public final EditText f2124c;

    /* renamed from: d, reason: collision with root package name */
    public final j f2125d;

    public a(EditText editText) {
        this.f2124c = editText;
        j jVar = new j(editText);
        this.f2125d = jVar;
        editText.addTextChangedListener(jVar);
        if (c.f2128b == null) {
            synchronized (c.f2127a) {
                try {
                    if (c.f2128b == null) {
                        c cVar = new c();
                        try {
                            c.f2129c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, c.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        c.f2128b = cVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(c.f2128b);
    }

    @Override // y1.f
    public final void n(boolean z4) {
        j jVar = this.f2125d;
        if (jVar.f2145d != z4) {
            if (jVar.f2144c != null) {
                X.j jVarA = X.j.a();
                U0 u02 = jVar.f2144c;
                jVarA.getClass();
                com.airbnb.lottie.h.h(u02, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = jVarA.f2055a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    jVarA.f2056b.remove(u02);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            jVar.f2145d = z4;
            if (z4) {
                j.a(jVar.f2142a, X.j.a().b());
            }
        }
    }

    public final KeyListener r(KeyListener keyListener) {
        if (keyListener instanceof g) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new g(keyListener);
    }

    public final InputConnection s(InputConnection inputConnection, EditorInfo editorInfo) {
        return inputConnection instanceof d ? inputConnection : new d(this.f2124c, inputConnection, editorInfo);
    }
}
