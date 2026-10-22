package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: SkillSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f19284b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f19285c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ n[] f19286e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19287d;

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final n a(String r6) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(n.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L3:
            Object r2 = null;
            if (r5.hasNext() == false) goto L14;
            Object r0 = r5.next();
            String r3 = ((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin")).a();
            if (r6 == null) goto L11;
            String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r4 == null) goto L11;
            r2 = r4.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r2, "toLowerCase(...)");
        L11:
            if (d.h.b.o.a(r3, r2) == false) goto L3;
            r2 = r0;
        L14:
            return (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin");
        }
    }

    public static d.d.a<n> b() {
        return f;
    }

    private static final /* synthetic */ n[] c() {
        return new n[]{f19284b, f19285c};
    }

    private n(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19287d = r3;
    }

    public final String a() {
        return this.f19287d;
    }

    static {
        f19284b = new n("FILE", 0, "file");
        f19285c = new n("LINK", 1, "link");
        n[] r0 = c();
        f19286e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f19283a = new a(null);
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f19286e.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
