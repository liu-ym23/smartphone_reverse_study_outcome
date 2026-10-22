package com.obric.aiagent.assistant_card.provider_core.a;

import android.net.Uri;
import d.h.b.o;

/* JADX INFO: compiled from: CardUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16335a = null;

    static {
        f16335a = new c();
    }

    private c() {
    }

    public final Uri a(String r3, String r4, String r5) {
        o.e(r3, "pkgName");
        o.e(r4, "cardType");
        if (r5 != null) goto L5;
        String r2 = "assistant_card://" + r3 + '/' + r4;
    L6:
        Uri r6 = Uri.parse(r2);
        o.c(r6, "parse(...)");
        return r6;
    L5:
        r2 = "assistant_card://" + r3 + '/' + r4 + "?card_id=" + r5;
        goto L6
    }
}
