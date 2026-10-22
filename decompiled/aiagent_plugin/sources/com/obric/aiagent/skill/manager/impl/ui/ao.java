package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20548c;

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ao a() {
            com.obric.aiagent.skill.manager.api.al r2 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
            return new ao(r2.c(), r2.d());
        }

        public final ao b() {
            com.obric.aiagent.skill.manager.api.al r2 = com.obric.aiagent.skill.manager.api.al.f19195a.a();
            return new ao(r2.e(), r2.f());
        }
    }

    static {
        f20546a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ao.class) == true) goto L8;
        return false;
    L8:
        ao r6 = (ao) ZeusTransformUtils.preCheckCast(r5, ao.class, "com.obric.aiagent.plugin");
        if (this.f20547b == r6.f20547b) goto L12;
        return false;
    L12:
        if (this.f20548c == r6.f20548c) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f20547b) * 31) + Integer.hashCode(this.f20548c);
    }

    public String toString() {
        return "SkillFormFieldLimits(maxNameLength=" + this.f20547b + ", maxDescriptionLength=" + this.f20548c + ')';
    }

    public ao(int r1, int r2) {
        this.f20547b = r1;
        this.f20548c = r2;
    }

    public final int a() {
        return this.f20547b;
    }

    public final int b() {
        return this.f20548c;
    }
}
