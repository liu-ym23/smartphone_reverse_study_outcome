package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
abstract class by {

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public static final class a extends by {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.impl.aj f20697a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20697a, r6.f20697a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            com.obric.aiagent.skill.manager.impl.aj r0 = this.f20697a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Banner(value=" + this.f20697a + ')';
        }

        public a(com.obric.aiagent.skill.manager.impl.aj r2) {
            super(null);
            this.f20697a = r2;
        }

        public final com.obric.aiagent.skill.manager.impl.aj a() {
            return this.f20697a;
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public static final class b extends by {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f20698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final bt f20700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final bv f20701d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20698a, r6.f20698a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20699b, r6.f20699b) == true) goto L15;
            return false;
        L15:
            if (this.f20700c == r6.f20700c) goto L18;
            return false;
        L18:
            if (this.f20701d == r6.f20701d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f20698a.hashCode() * 31) + this.f20699b.hashCode()) * 31) + this.f20700c.hashCode()) * 31) + this.f20701d.hashCode();
        }

        public String toString() {
            return "SkillItem(remote=" + this.f20698a + ", listDescription=" + this.f20699b + ", cardPosition=" + this.f20700c + ", actionState=" + this.f20701d + ')';
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f20698a;
        }

        public final String b() {
            return this.f20699b;
        }

        public final bt c() {
            return this.f20700c;
        }

        public final bv d() {
            return this.f20701d;
        }

        public b(com.obric.aiagent.skill.manager.api.e r2, String r3, bt r4, bv r5) {
            d.h.b.o.e(r2, "remote");
            d.h.b.o.e(r3, "listDescription");
            d.h.b.o.e(r4, "cardPosition");
            d.h.b.o.e(r5, "actionState");
            super(null);
            this.f20698a = r2;
            this.f20699b = r3;
            this.f20700c = r4;
            this.f20701d = r5;
        }
    }

    public /* synthetic */ by(d.h.b.h r1) {
        this();
    }

    private by() {
    }
}
