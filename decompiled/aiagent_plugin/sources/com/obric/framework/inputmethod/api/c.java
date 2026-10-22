package com.obric.framework.inputmethod.api;

import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.n;
import d.o;

/* JADX INFO: compiled from: ObricInjectTextResponseCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33238a = null;

    static {
        f33238a = new c();
    }

    private c() {
    }

    public final d a(Bundle r4) {
        Integer r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        Object r5 = r4.get("obric.inject_text.type");     // Catch: Throwable -> L9
    L7:
        Object r6 = n.f(r5);     // Catch: Throwable -> L9
    L12:
        if (n.b(r6) == false) goto L15;
        r6 = null;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L17;
        r1 = (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.aiagent.plugin");
    L17:
        if (r1 == null) goto L30;
        int r7 = r1.intValue();
        if (r7 == 0) goto L28;
        if (r7 == 1) goto L35;
        if (r7 == 2) goto L34;
        return d.f33242d;
    L34:
        return d.f33241c;
    L35:
        return d.f33240b;
    L28:
        return d.f33239a;
    L30:
        return d.f33242d;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L12
    }

    public final AssistStructure a(Bundle r6, d r7) {
        d.h.b.o.e(r7, "type");
        Object r2 = null;
        if (r7 != d.f33239a) goto L5;
    L7:
        boolean r8 = true;
        if (r6 != null) goto L10;
    L12:
        r8 = false;
    L13:
        if (r8 == true) goto L32;
        return null;
    L32:
        n.a r9 = n.f38560a;     // Catch: Throwable -> L24
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (Build.VERSION.SDK_INT < 33) goto L18;
        AssistStructure r10 = (AssistStructure) ZeusTransformUtils.preCheckCast(r6.getParcelable("obric.inject_text.view_tree", AssistStructure.class), AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L22:
        Object r11 = n.f(r10);     // Catch: Throwable -> L24
    L27:
        if (n.b(r11) == true) goto L31;
        r2 = r11;
    L31:
        return (AssistStructure) ZeusTransformUtils.preCheckCast(r2, AssistStructure.class, "com.obric.aiagent.plugin");
    L18:
        Parcelable r12 = r6.getParcelable("obric.inject_text.view_tree");     // Catch: Throwable -> L24
        if (ZeusTransformUtils.instanceOf(r12, AssistStructure.class) == false) goto L21;
        r10 = (AssistStructure) ZeusTransformUtils.preCheckCast(r12, AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        goto L22
    L21:
        r10 = null;
    L24:
        th = move-exception;
        n.a r13 = n.f38560a;
        r11 = n.f(o.a(th));
        goto L27
    L10:
        if (r6.containsKey("obric.inject_text.view_tree") != true) goto L12;
    L5:
        if (r7 == d.f33240b) goto L7;
        return null;
    }
}
