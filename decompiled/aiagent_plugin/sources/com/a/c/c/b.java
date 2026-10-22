package com.a.c.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: ExecutionTime.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: renamed from: com.a.c.c.b$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExecutionTime.java */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3163a = null;

        static {
            int[] r0 = new int[com.a.c.b.b.values().length];
            f3163a = r0;
            r0[com.a.c.b.b.f3104a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f3163a[com.a.c.b.b.f3105b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f3163a[com.a.c.b.b.f3106c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f3163a[com.a.c.b.b.f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f3163a[com.a.c.b.b.f3107d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f3163a[com.a.c.b.b.f3108e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f3163a[com.a.c.b.b.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f3163a[com.a.c.b.b.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    Optional<ZonedDateTime> a(ZonedDateTime r1);

    static b a(com.a.c.b r8) {
        com.a.c.b r9 = (com.a.c.b) ZeusTransformUtils.wrapperContextForParams(r8, com.a.c.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.a.c.e.class) == false) goto L23;
        Map<com.a.c.b.b, com.a.c.b.a> r0 = r9.b();
        c r2 = new c(r9);
        com.a.c.b.b[] r10 = com.a.c.b.b.values();
        int r3 = r10.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L21;
        com.a.c.b.b r5 = r10[r4];
        if (r0.get(r5) == null) goto L19;
        switch(AnonymousClass2.f3163a[r5.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L19;
        };
    L11:
        r2.h((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L12:
        r2.e((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L13:
        r2.d((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L14:
        r2.g((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L15:
        r2.f((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L16:
        r2.c((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L17:
        r2.b((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
        goto L19
    L18:
        r2.a((com.a.c.b.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.a.c.b.a.class, "com.obric.aiagent.plugin"));
    L19:
        r4 = r4 + 1;
        goto L5
    L21:
        return r2.a();
    L23:
        if (ZeusTransformUtils.instanceOf(r9, com.a.c.a.class) == false) goto L27;
        return new a((List) ZeusTransformUtils.preCheckCast(((com.a.c.a) ZeusTransformUtils.preCheckCast(r9, com.a.c.a.class, "com.obric.aiagent.plugin")).a().parallelStream().map($$Lambda$EZxY2mJ5GYVYoTNNYtEtc7RGyEw.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin"));
    L27:
        return new AnonymousClass1();
    }
}
