package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillUsageExampleAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d.l.j> f20773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f20774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20775d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20772a, r6.f20772a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20773b, r6.f20773b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20774c, r6.f20774c) == true) goto L18;
        return false;
    L18:
        if (this.f20775d == r6.f20775d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20772a.hashCode() * 31) + this.f20773b.hashCode()) * 31) + this.f20774c.hashCode()) * 31) + Boolean.hashCode(this.f20775d);
    }

    public String toString() {
        return "FormattedUsageExample(text=" + this.f20772a + ", highlightRanges=" + this.f20773b + ", skillMentionDisplayNames=" + this.f20774c + ", hasMalformedPlaceholder=" + this.f20775d + ')';
    }

    public e(String r3, List<d.l.j> r4, List<String> r5, boolean r6) {
        List<d.l.j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "text");
        d.h.b.o.e(r7, "highlightRanges");
        d.h.b.o.e(r8, "skillMentionDisplayNames");
        this.f20772a = r3;
        this.f20773b = r7;
        this.f20774c = r8;
        this.f20775d = r6;
    }

    public final String a() {
        return this.f20772a;
    }

    public final List<d.l.j> b() {
        return this.f20773b;
    }

    public final List<String> c() {
        return this.f20774c;
    }

    public final boolean d() {
        return this.f20775d;
    }
}
