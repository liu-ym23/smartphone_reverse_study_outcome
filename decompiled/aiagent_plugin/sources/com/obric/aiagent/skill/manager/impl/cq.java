package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillLoadHook.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cq {

    /* JADX INFO: compiled from: SkillLoadHook.kt */
    public static final class a extends cq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19694a = null;

        static {
            f19694a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SkillLoadHook.kt */
    public static final class b extends cq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f19695a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19695a, r6.f19695a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19695a.hashCode();
        }

        public String toString() {
            return "Continue(skill=" + this.f19695a + ')';
        }

        public b(com.obric.aiagent.skill.manager.api.e r2) {
            d.h.b.o.e(r2, "skill");
            super(null);
            this.f19695a = r2;
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f19695a;
        }
    }

    public /* synthetic */ cq(d.h.b.h r1) {
        this();
    }

    private cq() {
    }
}
