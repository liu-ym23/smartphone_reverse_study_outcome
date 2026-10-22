package com.obric.autogui.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import d.h.b.o;

/* JADX INFO: compiled from: AutoGUIJsonUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f31495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f31496b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Gson f31497c = null;

    private b() {
    }

    static {
        f31495a = new b();
        f31496b = new GsonBuilder().create();
        f31497c = new GsonBuilder().setPrettyPrinting().create();
    }

    public final Gson a() {
        return f31496b;
    }

    public final Gson b() {
        return f31497c;
    }

    public final String a(Object r1) {
        o.e(r1, "<this>");
        String r0 = f31497c.toJson(r1);
        o.c(r0, "toJson(...)");
        return r0;
    }
}
