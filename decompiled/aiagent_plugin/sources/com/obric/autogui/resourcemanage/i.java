package com.obric.autogui.resourcemanage;

import d.a.ao;
import java.util.Map;

/* JADX INFO: compiled from: RequestHeaderBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final Map<String, String> a(String r3) {
        d.h.b.o.e(r3, "requestDeviceId");
        return ao.b(new d.m[]{d.s.a("Content-type", "application/json; charset=utf-8"), d.s.a("x-device-id", r3)});
    }
}
