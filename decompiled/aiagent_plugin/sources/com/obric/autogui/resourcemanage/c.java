package com.obric.autogui.resourcemanage;

import d.a.ao;
import java.util.Map;

/* JADX INFO: compiled from: DefaultResourceRequestFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final Map<String, String> a(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        d.h.b.o.e(r2, "versionCode");
        d.h.b.o.e(r3, "updateVersionCode");
        d.h.b.o.e(r4, "osBuildDate");
        d.h.b.o.e(r5, "frameworkApiVersion");
        d.h.b.o.e(r6, "shortOsVersion");
        d.h.b.o.e(r7, "osDeviceId");
        d.h.b.o.e(r8, "isUtRom");
        return ao.a(new d.m[]{d.s.a("version_code", r2), d.s.a("update_version_code", r3), d.s.a("os_build_date", r4), d.s.a("obric_fwk_api_version", r5), d.s.a("short_os_version", r6), d.s.a("os_device_id", r7), d.s.a("o_is_ut_rom", r8)});
    }
}
