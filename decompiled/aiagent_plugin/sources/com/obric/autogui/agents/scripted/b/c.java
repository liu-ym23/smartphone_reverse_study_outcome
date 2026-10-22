package com.obric.autogui.agents.scripted.b;

import d.h.b.o;

/* JADX INFO: compiled from: ScriptMemoryMeasurement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26906a = null;

    static {
        f26906a = new c();
    }

    private c() {
    }

    public final String a(String r2) {
        o.e(r2, "suffix");
        return "memory_total_pss_" + r2 + "_delta_kb";
    }

    public final String b(String r2) {
        o.e(r2, "suffix");
        return "memory_java_heap_" + r2 + "_delta_kb";
    }

    public final String c(String r2) {
        o.e(r2, "suffix");
        return "memory_native_heap_" + r2 + "_delta_kb";
    }

    public final String d(String r2) {
        o.e(r2, "suffix");
        return "memory_code_" + r2 + "_delta_kb";
    }

    public final String e(String r2) {
        o.e(r2, "suffix");
        return "memory_stack_" + r2 + "_delta_kb";
    }

    public final String f(String r2) {
        o.e(r2, "suffix");
        return "memory_graphics_" + r2 + "_delta_kb";
    }

    public final String g(String r2) {
        o.e(r2, "suffix");
        return "memory_private_other_" + r2 + "_delta_kb";
    }

    public final String h(String r2) {
        o.e(r2, "suffix");
        return "memory_system_" + r2 + "_delta_kb";
    }

    public final String i(String r2) {
        o.e(r2, "suffix");
        return "memory_total_swap_" + r2 + "_delta_kb";
    }
}
