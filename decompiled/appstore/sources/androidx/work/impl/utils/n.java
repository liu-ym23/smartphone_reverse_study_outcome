package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Configuration;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5835a = null;

    static {
        String r10 = androidx.work.i.i("ProcessUtils");
        kotlin.jvm.internal.q.f(r10, "tagWithPrefix(\"ProcessUtils\")");
        f5835a = r10;
    }

    public static final String a(Context r10) {
        return a.f5791a.a();
    }

    public static final boolean b(Context r10, Configuration r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "configuration");
        String r12 = a(r10);
        String r13 = r11.c();
        if (r13 == null) goto L9;
        if (r13.length() == 0) goto L9;
        return kotlin.jvm.internal.q.b(r12, r11.c());
    L9:
        return kotlin.jvm.internal.q.b(r12, r10.getApplicationInfo().processName);
    }
}
