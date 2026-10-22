package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bs {

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class a extends bs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.impl.aj f20666a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20666a, r6.f20666a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20666a.hashCode();
        }

        public String toString() {
            return "Content(value=" + this.f20666a + ')';
        }

        public a(com.obric.aiagent.skill.manager.impl.aj r2) {
            d.h.b.o.e(r2, "value");
            super(null);
            this.f20666a = r2;
        }

        public final com.obric.aiagent.skill.manager.impl.aj a() {
            return this.f20666a;
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class b extends bs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20667a = null;

        static {
            f20667a = new b();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class c extends bs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20668a = null;

        static {
            f20668a = new c();
        }

        private c() {
            super(null);
        }
    }

    public /* synthetic */ bs(d.h.b.h r1) {
        this();
    }

    private bs() {
    }
}
