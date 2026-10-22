package androidx.window.core;

import android.util.Log;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5233a = null;

    static {
        f5233a = new a();
    }

    public a() {
    }

    @Override // androidx.window.core.Logger
    public void debug(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "message");
        Log.d(r10, r11);
    }
}
