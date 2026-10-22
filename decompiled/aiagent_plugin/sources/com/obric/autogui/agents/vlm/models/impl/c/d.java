package com.obric.autogui.agents.vlm.models.impl.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: PageStateDigest.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final /* synthetic */ String a(String r0, byte[] r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$NbsEDGO_HCRXwI_-YxQJjdxVeTY, reason: not valid java name */
    public static /* synthetic */ CharSequence m750lambda$NbsEDGO_HCRXwI_YxQJjdxVeTY(byte r0) {
        return a(r0);
    }

    private static final String b(String r10, byte[] r11) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        Charset r1 = StandardCharsets.UTF_8;
        o.c(r1, "UTF_8");
        byte[] r12 = r10.getBytes(r1);
        o.c(r12, "getBytes(...)");
        r0.update(r12);
        r0.update((byte) 0);
        r0.update(r11);
        byte[] r13 = r0.digest();
        o.a(r13);
        return p.a((Iterable) ZeusTransformUtils.preCheckCast(i.a(r13, 16), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$d$NbsEDGO_HCRXwI_YxQJjdxVeTY.INSTANCE, 30, null);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }
}
