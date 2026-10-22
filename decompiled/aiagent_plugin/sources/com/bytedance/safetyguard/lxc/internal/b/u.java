package com.bytedance.safetyguard.lxc.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: TargetParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f9803a = null;

    /* JADX INFO: compiled from: TargetParser.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9804a = null;

        static {
            int[] r0 = new int[com.bytedance.safetyguard.lxc.internal.c.m.values().length];
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9853b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9854c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[com.bytedance.safetyguard.lxc.internal.c.m.f9855d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f9804a = r0;
        }
    }

    static {
        f9803a = new u();
    }

    private u() {
    }

    public final o a(com.bytedance.safetyguard.lxc.internal.c.m r5, byte[] r6, int r7) {
        d.h.b.o.e(r5, "targetType");
        d.h.b.o.e(r6, "addressBytes");
        boolean r0 = false;
        if (1 > r7) goto L8;
        if (r7 >= 65536) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L21;
        int r1 = a.f9804a[r5.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L23;
        if (r1 != 3) goto L16;
        return (o) ZeusTransformUtils.preCheckCast(new o.b(r5, a(r6, 16), r7), o.class, "com.obric.aiagent.plugin");
    L16:
        throw new d.k();
    L23:
        return (o) ZeusTransformUtils.preCheckCast(new o.b(r5, a(r6, 4), r7), o.class, "com.obric.aiagent.plugin");
    L19:
        return (o) ZeusTransformUtils.preCheckCast(new o.a(a(r6), r7), o.class, "com.obric.aiagent.plugin");
    L21:
        throw new t("Target port must be between 1 and 65535", null, 2, null);
    }

    private final String a(byte[] r3) {
        if (r3.length != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L15;
        if (r3.length > 253) goto L15;
        String r4 = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r3)).toString();     // Catch: Exception -> L11
        d.h.b.o.a(r4);     // Catch: Exception -> L11
        return r4;
    L11:
        e = move-exception;
        throw new t("Domain is not valid UTF-8", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L15:
        throw new t("Domain byte length must be between 1 and 253", null, 2, null);
    L5:
        r2 = false;
        goto L6
    }

    private final byte[] a(byte[] r3, int r4) {
        if (r3.length != r4) goto L7;
        byte[] r2 = Arrays.copyOf(r3, r3.length);
        d.h.b.o.c(r2, "copyOf(...)");
        return r2;
    L7:
        throw new t("IP address length " + r3.length + " does not match " + r4 + "-byte target type", null, 2, null);
    }
}
