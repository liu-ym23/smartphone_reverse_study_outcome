package v;

import android.text.Editable;
import androidx.emoji2.text.k;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f24943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f24944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f24945c;

    static {
        f24943a = new Object();
    }

    public b() {
        f24945c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());     // Catch: Throwable -> L5
        return;
    }

    public static Editable.Factory getInstance() {
        if (f24944b != null) goto L16;
        Object r10 = f24943a;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f24944b != null) goto L11;
        f24944b = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return f24944b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence r10) {
        Class r11 = f24945c;
        if (r11 == null) goto L7;
        return k.c(r11, r10);
    L7:
        return super.newEditable(r10);
    }
}
