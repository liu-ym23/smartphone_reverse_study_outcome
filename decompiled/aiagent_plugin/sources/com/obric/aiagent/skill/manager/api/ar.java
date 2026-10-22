package com.obric.aiagent.skill.manager.api;

import com.obric.agent.omnimodel.OmniModelServiceImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: SkillSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum ar extends Enum<ar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ar f19223b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ar f19224c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ ar[] f19225e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19226d;

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ar a(String r6) {
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(ar.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L3:
            Object r2 = null;
            if (r5.hasNext() == false) goto L14;
            Object r0 = r5.next();
            String r3 = ((ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.aiagent.plugin")).a();
            if (r6 == null) goto L11;
            String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r4 == null) goto L11;
            r2 = r4.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r2, "toLowerCase(...)");
        L11:
            if (d.h.b.o.a(r3, r2) == false) goto L3;
            r2 = r0;
        L14:
            return (ar) ZeusTransformUtils.preCheckCast(r2, ar.class, "com.obric.aiagent.plugin");
        }
    }

    public static d.d.a<ar> b() {
        return f;
    }

    private static final /* synthetic */ ar[] c() {
        return new ar[]{f19223b, f19224c};
    }

    private ar(String r1, int r2, String r3) {
        super(r1, r2);
        this.f19226d = r3;
    }

    public final String a() {
        return this.f19226d;
    }

    static {
        f19223b = new ar("GUI", 0, "gui");
        f19224c = new ar("CHAT", 1, OmniModelServiceImpl.CURRENT_MODEL_CHAT);
        ar[] r0 = c();
        f19225e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f19222a = new a(null);
    }

    public static ar valueOf(String r2) {
        return (ar) ZeusTransformUtils.preCheckCast(Enum.valueOf(ar.class, r2), ar.class, "com.obric.aiagent.plugin");
    }

    public static ar[] values() {
        return (ar[]) ZeusTransformUtils.preCheckCast(f19225e.clone(), ar[].class, "com.obric.aiagent.plugin");
    }
}
