package com.bytedance.safetyguard.lxc.internal.e.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: SidecarWireProtocol.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0243a f10829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10830b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10831c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ a[] f10832e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10833d;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SidecarWireProtocol.kt */
    public static final class C0243a {
        public /* synthetic */ C0243a(h r1) {
            this();
        }

        private C0243a() {
        }

        public final a a(String r5) {
            o.e(r5, "value");
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(a.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            Object r0 = r4.next();
            if (d.o.o.a(((a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin")).a(), r5, true) == false) goto L4;
        L10:
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    public static d.d.a<a> b() {
        return f;
    }

    private static final /* synthetic */ a[] c() {
        return new a[]{f10830b, f10831c};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(f10832e.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2, String r3) {
        super(r1, r2);
        this.f10833d = r3;
    }

    public final String a() {
        return this.f10833d;
    }

    static {
        f10830b = new a("USER", 0, "user");
        f10831c = new a("BOT", 1, "bot");
        a[] r0 = c();
        f10832e = r0;
        f = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f10829a = new C0243a(null);
    }
}
