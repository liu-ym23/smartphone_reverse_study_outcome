package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ProxyFrame.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f9833b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f9834c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f9835d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f9836e = null;
    public static final h f = null;
    public static final h g = null;
    public static final h h = null;
    public static final h i = null;
    public static final h j = null;
    public static final h k = null;
    private static final /* synthetic */ h[] m = null;
    private static final /* synthetic */ d.d.a n = null;
    private final int l;

    /* JADX INFO: compiled from: ProxyFrame.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final h a(int r5) {
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(h.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L11;
            Object r0 = r4.next();
            if (((h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.aiagent.plugin")).a() != r5) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L4;
        L12:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            return r6;
        L16:
            throw new k("Unknown frame type: " + r5, null, 2, null);
        L8:
            r3 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static d.d.a<h> b() {
        return n;
    }

    private static final /* synthetic */ h[] c() {
        return new h[]{f9833b, f9834c, f9835d, f9836e, f, g, h, i, j, k};
    }

    public static h valueOf(String r2) {
        return (h) ZeusTransformUtils.preCheckCast(Enum.valueOf(h.class, r2), h.class, "com.obric.aiagent.plugin");
    }

    public static h[] values() {
        return (h[]) ZeusTransformUtils.preCheckCast(m.clone(), h[].class, "com.obric.aiagent.plugin");
    }

    private h(String r1, int r2, int r3) {
        super(r1, r2);
        this.l = r3;
    }

    public final int a() {
        return this.l;
    }

    static {
        f9833b = new h("HELLO", 0, 1);
        f9834c = new h("HELLO_ACK", 1, 2);
        f9835d = new h("GOAWAY", 2, 5);
        f9836e = new h("OPEN_TCP", 3, 16);
        f = new h("OPEN_RESULT", 4, 17);
        g = new h("DATA", 5, 18);
        h = new h("HALF_CLOSE", 6, 19);
        i = new h("CLOSE", 7, 20);
        j = new h("RESET", 8, 21);
        k = new h("WINDOW_UPDATE", 9, 22);
        h[] r0 = c();
        m = r0;
        n = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f9832a = new a(null);
    }
}
