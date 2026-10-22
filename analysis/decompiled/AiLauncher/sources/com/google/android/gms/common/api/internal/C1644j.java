package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.internal.C1669j;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.common.api.internal.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1644j {
    public static <L> C1643i<L> a(L l10, Looper looper, String str) {
        C1669j.l(l10, "Listener must not be null");
        C1669j.l(looper, "Looper must not be null");
        C1669j.l(str, "Listener type must not be null");
        return new C1643i<>(looper, l10, str);
    }

    public static <L> C1643i<L> b(L l10, Executor executor, String str) {
        C1669j.l(l10, "Listener must not be null");
        C1669j.l(executor, "Executor must not be null");
        C1669j.l(str, "Listener type must not be null");
        return new C1643i<>(executor, l10, str);
    }

    public static <L> C1643i.a<L> c(L l10, String str) {
        C1669j.l(l10, "Listener must not be null");
        C1669j.l(str, "Listener type must not be null");
        C1669j.f(str, "Listener type must not be empty");
        return new C1643i.a<>(l10, str);
    }
}
