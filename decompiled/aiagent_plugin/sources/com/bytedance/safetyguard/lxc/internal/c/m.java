package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ProxyTlv.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f9853b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f9854c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f9855d = null;
    private static final /* synthetic */ m[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9856e;

    /* JADX INFO: compiled from: ProxyTlv.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final m a(int r5) {
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(m.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L11;
            Object r0 = r4.next();
            if (((m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin")).a() != r5) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L4;
        L12:
            m r6 = (m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L16;
            return r6;
        L16:
            throw new k("Unsupported target type: " + r5, null, 2, null);
        L8:
            r3 = false;
            goto L9
        L11:
            r0 = null;
            goto L12
        }
    }

    public static d.d.a<m> b() {
        return g;
    }

    private static final /* synthetic */ m[] c() {
        return new m[]{f9853b, f9854c, f9855d};
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f.clone(), m[].class, "com.obric.aiagent.plugin");
    }

    private m(String r1, int r2, int r3) {
        super(r1, r2);
        this.f9856e = r3;
    }

    public final int a() {
        return this.f9856e;
    }

    static {
        f9853b = new m("DOMAIN", 0, 1);
        f9854c = new m("IPV4", 1, 2);
        f9855d = new m("IPV6", 2, 3);
        m[] r0 = c();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f9852a = new a(null);
    }
}
