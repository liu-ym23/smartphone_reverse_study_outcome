package com.bytedanceos.appstore.buss.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8837a = null;

    static {
        f8837a = new e();
    }

    public e() {
    }

    public final String a(Date r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "date");
        kotlin.jvm.internal.q.g(r11, "formatStr");
        String r12 = new SimpleDateFormat(r11).format(r10);
        kotlin.jvm.internal.q.f(r12, "format(...)");
        return r12;
    }
}
