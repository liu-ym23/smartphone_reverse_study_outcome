package com.obric.agent;

import d.a.ao;
import d.a.ax;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AgentConstants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f14410b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f14411c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f14412d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f14413e = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;
    private static final String h = null;
    private static final int i = 0;
    private static final String j = null;
    private static final String k = null;
    private static final int l = 0;
    private static final String m = null;

    private d() {
    }

    static {
        f14409a = new d();
        f14410b = ax.a("obric");
        f14411c = ao.a(new d.m[]{d.s.a("dialogue_relation_samsung", "1.0"), d.s.a("query_understanding_samsung", "1.0"), d.s.a("query_rewrite_samsung", "1.0"), d.s.a("reference_qa_samsung", "1.0"), d.s.a("reference_resolution_samsung", "1.0"), d.s.a("dialogue_rewriter_samsung", "1.0"), d.s.a("function_call_samsung_online", "1.0"), d.s.a("intent_detection_samsung", "1.0")});
        f14412d = ax.a(new String[]{"PC_SearchAppEntity", "PC_AppFcEntitySearch", "PC_GlobalSearch", "PC_PersonalContextSearch", "Contacts_Search", "Phone_Search"});
        f14413e = ax.a(new String[]{"PC_SearchAppEntity", "PC_AppFcEntitySearch", "PC_GlobalSearch", "PC_PersonalContextSearch"});
        f = ax.a(new String[]{"Contacts_Search", "Phone_Search"});
        g = ax.a("System_SwitchMode");
        h = "seed";
        i = 500;
        j = "confirm";
        k = "disagree";
        l = -2;
        m = "Office_CheckLogin";
    }

    public final boolean a(String r1) {
        d.h.b.o.e(r1, "value");
        return f14410b.contains(r1);
    }

    public final Set<String> a() {
        return f14412d;
    }

    public final Set<String> b() {
        return f14413e;
    }

    public final Set<String> c() {
        return f;
    }

    public final String d() {
        return h;
    }

    public final int e() {
        return i;
    }

    public final String f() {
        return j;
    }

    public final int g() {
        return l;
    }

    public final String h() {
        return m;
    }
}
