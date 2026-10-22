package c4;

import android.os.Handler;
import android.widget.EditText;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends a4.g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f2202c;

    @Override // a4.g
    public final void b() {
        Handler handler;
        EditText editText = (EditText) this.f2202c.get();
        if (editText == null || (handler = editText.getHandler()) == null) {
            return;
        }
        handler.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a((EditText) this.f2202c.get(), 1);
    }
}
