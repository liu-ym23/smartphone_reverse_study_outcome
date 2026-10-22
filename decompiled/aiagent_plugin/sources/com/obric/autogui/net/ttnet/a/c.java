package com.obric.autogui.net.ttnet.a;

import d.h.b.o;
import java.io.IOException;

/* JADX INFO: compiled from: TTNetInvalidStateException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29215a;

    public final String getType() {
        return this.f29215a;
    }

    public c(String r2) {
        o.e(r2, "type");
        this.f29215a = r2;
    }
}
