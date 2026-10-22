package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.aiagent.skill.manager.impl.dt;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillPageTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bp {

    /* JADX INFO: compiled from: SkillPageTracking.kt */
    public static final class a extends bp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20659a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20659a, r6.f20659a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20659a.hashCode();
        }

        public String toString() {
            return "Invalid(reason=" + this.f20659a + ')';
        }

        public a(String r2) {
            d.h.b.o.e(r2, "reason");
            super(null);
            this.f20659a = r2;
        }

        public final String a() {
            return this.f20659a;
        }
    }

    /* JADX INFO: compiled from: SkillPageTracking.kt */
    public static final class b extends bp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final dt f20660a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20660a, r6.f20660a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20660a.hashCode();
        }

        public String toString() {
            return "Valid(context=" + this.f20660a + ')';
        }

        public b(dt r2) {
            d.h.b.o.e(r2, "context");
            super(null);
            this.f20660a = r2;
        }

        public final dt getContext() {
            return this.f20660a;
        }
    }

    public /* synthetic */ bp(d.h.b.h r1) {
        this();
    }

    private bp() {
    }
}
