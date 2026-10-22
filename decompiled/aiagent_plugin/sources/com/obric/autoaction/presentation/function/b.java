package com.obric.autoaction.presentation.function;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: FunctionControllers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f24938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f24939c;

    private b() {
    }

    static {
        f24937a = new b();
        f24938b = ao.a(new m[]{s.a("ManualOperating", new a("ManualOperating")), s.a("CallUser", new a("CallUser"))});
    }

    public final String a() {
        return f24939c;
    }

    public final void a(String r1) {
        f24939c = r1;
    }

    public final a b(String r2) {
        o.e(r2, "funcName");
        return (a) ZeusTransformUtils.preCheckCast(f24938b.get(r2), a.class, "com.obric.aiagent.plugin");
    }
}
