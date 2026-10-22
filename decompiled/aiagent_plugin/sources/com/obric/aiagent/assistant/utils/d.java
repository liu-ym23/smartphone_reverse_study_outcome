package com.obric.aiagent.assistant.utils;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAppStatusHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16317a = null;

    static {
        f16317a = new d();
    }

    private d() {
    }

    public final c a(Context r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return null;
    L5:
        c r8 = new c(null, null, false, false, 15, null);
        r8.a(e.f16318a.a(r12, "com.larus.nova"));
        if (r8.a() == a.f16305c) goto L8;
        return r8;
    L8:
        if (r11 == false) goto L11;
        r8.a(e.f16318a.a(r12, null));
        r8.b(e.f16318a.a(r12));
    L11:
        if (a(r12) != b.f16309b) goto L13;
        boolean r9 = true;
    L14:
        r8.a(r9);
        return r8;
    L13:
        r9 = false;
        goto L14
    }

    public final b a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        String r3 = e.f16318a.b(r1);
        if (r3 != null) goto L11;
        return b.f16308a;
    L11:
        if (o.a(r3, "com.larus.nova") == false) goto L15;
        return b.f16309b;
    L15:
        return b.f16310c;
    L5:
        return b.f16308a;
    }
}
