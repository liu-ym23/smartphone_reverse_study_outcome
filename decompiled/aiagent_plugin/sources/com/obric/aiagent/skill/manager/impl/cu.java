package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.Normalizer;

/* JADX INFO: compiled from: SkillLocalIdentityPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cu f19706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.o.k f19707b = null;

    private cu() {
    }

    static {
        f19706a = new cu();
        f19707b = new d.o.k("^[\\p{L}\\p{N}]+(?:[-_][\\p{L}\\p{N}]+)*$");
    }

    public final boolean a(String r4) {
        d.h.b.o.e(r4, "value");
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L9:
        return false;
    L5:
        if (d.h.b.o.a(Normalizer.normalize((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), Normalizer.Form.NFKC), r4) == false) goto L9;
        if (f19707b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return true;
    }

    public final String b(String r2) {
        d.h.b.o.e(r2, "value");
        String r1 = Normalizer.normalize((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), Normalizer.Form.NFKC);
        d.h.b.o.c(r1, "normalize(...)");
        return r1;
    }
}
