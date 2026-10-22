package com.bytedanceos.common.utils;

import android.os.SystemProperties;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10206a = null;

    static {
        f10206a = new i();
    }

    public i() {
    }

    public final String a() {
        String r10 = SystemProperties.get("ro.system_ext.product.type", "unknown");
        kotlin.jvm.internal.q.f(r10, "get(...)");
        return r10;
    }

    public final boolean b() {
        Locale r10 = Locale.ROOT;
        String r11 = "nerida".toLowerCase(r10);
        kotlin.jvm.internal.q.f(r11, "toLowerCase(...)");
        String r12 = a().toLowerCase(r10);
        kotlin.jvm.internal.q.f(r12, "toLowerCase(...)");
        return kotlin.jvm.internal.q.b(r11, r12);
    }
}
