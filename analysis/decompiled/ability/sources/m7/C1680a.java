package m7;

import android.util.Log;
import kotlin.jvm.internal.k;

/* renamed from: m7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1680a {
    public final void a(String str, String msg, Throwable th) {
        k.f(msg, "msg");
        if (th != null) {
            Log.e(str, msg, th);
        } else {
            Log.e(str, msg);
        }
    }

    public final void b(String str, String msg) {
        k.f(msg, "msg");
        Log.i("AgentFrontClient", msg);
    }
}
