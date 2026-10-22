package com.obric.agent.intents.findphone;

import android.content.Context;
import android.content.res.Resources;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14695a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f14696e = null;
    private static final Object f = null;
    private static volatile b g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f14699d;

    /* JADX INFO: compiled from: RingManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(Context r3, int r4, boolean r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            Object r6 = b.a();
            monitor-enter(r6);
            b r0 = b.b();     // Catch: Throwable -> L16
            if (r0 != null) goto L7;
        L13:
            b r1 = new b(r2, r4, r5, null);     // Catch: Throwable -> L16
            a r7 = b.f14695a;     // Catch: Throwable -> L16
            b.a(r1);     // Catch: Throwable -> L16
            monitor-exit(r6);
            return r1;
        L7:
            if (b.b(r0) != r4) goto L13;
            if (b.c(r0) != r5) goto L13;
            monitor-exit(r6);
            return r0;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ b(Context r2, int r3, boolean r4, h r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    private b(Context r3, int r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f14697b = r4;
        this.f14698c = r5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "getApplicationContext(...)");
        this.f14699d = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Object a() {
        return f;
    }

    public static final /* synthetic */ void a(b r0) {
        g = r0;
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.f14697b;
    }

    public static final /* synthetic */ b b() {
        return g;
    }

    public static final /* synthetic */ boolean c(b r0) {
        return r0.f14698c;
    }

    public final int a(int r8) {
        Resources r9 = ZeusTransformUtils.getResources(this.f14699d, "com.obric.aiagent.plugin");
        String r7 = this.f14699d.getPackageName();
        String[] r1 = f14696e;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        String r5 = r1[r4];
        o.a(r5);
        int r6 = ZeusTransformUtils.getIdentifier(r9, r5, "raw", r7, "com.obric.aiagent.plugin");
        if (r6 != 0) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r6;
    L8:
        return 0;
    }

    static {
        f14695a = new a(null);
        f14696e = new String[]{"find_phone_ring"};
        f = new Object();
    }
}
