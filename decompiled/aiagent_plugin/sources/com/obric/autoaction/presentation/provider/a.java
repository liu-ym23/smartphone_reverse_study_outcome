package com.obric.autoaction.presentation.provider;

import android.net.Uri;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoStateProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final /* synthetic */ Uri a(String r0) {
        return b(r0);
    }

    private static final Uri b(String r1) {
        Uri r2 = Uri.parse(r1);
        o.c(r2, "parse(...)");
        return r2;
    }
}
