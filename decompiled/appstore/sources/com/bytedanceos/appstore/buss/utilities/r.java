package com.bytedanceos.appstore.buss.utilities;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f8876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f8877b;

    static {
        f8876a = new r();
    }

    public r() {
    }

    public static /* synthetic */ void a(Context r10, String r11) {
        c(r10, r11);
    }

    public static final void c(Context r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "$context");
        kotlin.jvm.internal.q.g(r11, "$msg");
        Toast r12 = f8877b;
        if (r12 == null) goto L6;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        Toast r13 = Toast.makeText(r10.getApplicationContext(), r11, 0);
        f8877b = r13;
        if (r13 == null) goto L10;
        r13.show();
        return;
    }

    public final void b(final Context r10, final String r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "msg");
        com.obric.appstore.util.k.f11081a.b(new q(r10, r11));
    }
}
