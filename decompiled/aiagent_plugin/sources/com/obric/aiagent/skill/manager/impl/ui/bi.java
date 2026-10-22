package com.obric.aiagent.skill.manager.impl.ui;

import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: compiled from: SkillCoverBinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bi f20643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f20644b = null;

    private bi() {
    }

    static {
        f20643a = new bi();
        f20644b = new d.o.k("^p\\d+-skills-store-sign\\.byteimg\\.com$", d.o.m.f38652a);
    }

    public final String a(String r7) {
        d.h.b.o.e(r7, "url");
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        bi r6 = (bi) ZeusTransformUtils.preCheckCast(this, bi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r8 = d.n.f(Uri.parse(r7));     // Catch: Throwable -> L5
    L7:
        String r2 = null;
        if (d.n.b(r8) == false) goto L10;
        r8 = null;
    L10:
        Uri r9 = (Uri) ZeusTransformUtils.preCheckCast(r8, Uri.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L13;
        return r7;
    L13:
        String r3 = r9.getScheme();
        boolean r4 = true;
        if (d.o.o.a(r3, "http", true) == false) goto L16;
    L18:
        if (r3 == null) goto L46;
        String r5 = r3.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r5, "toLowerCase(...)");
        if (r5 == null) goto L46;
        String r10 = r9.getHost();
        if (r10 == null) goto L25;
        r2 = r10.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r2, "toLowerCase(...)");
    L25:
        String r11 = "";
        if (r2 != null) goto L29;
        r2 = "";
    L29:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() == 0) goto L32;
        r4 = false;
    L32:
        if (r4 == false) goto L35;
        return r7;
    L35:
        if (f20644b.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L37;
        r2 = "skills-store-sign.byteimg.com";
    L37:
        StringBuilder r12 = new StringBuilder();
        r12.append(r5);
        r12.append("://");
        r12.append(r2);
        if (r9.getPort() < 0) goto L40;
        r12.append(':');
        r12.append(r9.getPort());
    L40:
        String r13 = r9.getEncodedPath();
        if (r13 == null) goto L44;
        r11 = r13;
    L44:
        r12.append(r11);
        String r14 = r12.toString();
        d.h.b.o.c(r14, "toString(...)");
        return r14;
    L46:
        return r7;
    L16:
        if (d.o.o.a(r3, "https", true) == true) goto L18;
        return r7;
    L5:
        th = move-exception;
        d.n.a r15 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L7
    }
}
