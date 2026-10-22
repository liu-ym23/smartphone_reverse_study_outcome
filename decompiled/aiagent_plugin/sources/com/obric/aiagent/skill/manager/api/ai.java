package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19179a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<ah> f19180c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ah> f19181b;

    /* JADX INFO: compiled from: SkillSettings.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ai() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ai.class) == true) goto L8;
        return false;
    L8:
        ai r6 = (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19181b, r6.f19181b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f19181b.hashCode();
    }

    public String toString() {
        return "SkillPurgeSettings(rules=" + this.f19181b + ')';
    }

    public ai(List<ah> r3) {
        List<ah> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "rules");
        this.f19181b = r4;
    }

    public /* synthetic */ ai(List r2, int r3, d.h.b.h r4) {
        List<ah> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = f19180c;
    L5:
        this(r5);
    }

    public final List<ah> a() {
        return this.f19181b;
    }

    static {
        f19179a = new a(null);
        f19180c = d.a.p.b(new ah[]{new ah("ovirt-skills", ag.f19170a, ".agents/skills", af.f19167b, null, 16, null), new ah("runtime-import-files", ag.f19170a, ".cache/imports", af.f19167b, null, 16, null)});
    }
}
