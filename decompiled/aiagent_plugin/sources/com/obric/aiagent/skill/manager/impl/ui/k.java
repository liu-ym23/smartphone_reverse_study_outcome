package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface k {

    /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20794a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20794a, r6.f20794a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.f20794a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "AppFunctionPackage(packageName=" + this.f20794a + ')';
        }

        public a(String r1) {
            this.f20794a = r1;
        }

        public final String a() {
            return this.f20794a;
        }
    }

    /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20795a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20795a, r6.f20795a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20795a.hashCode();
        }

        public String toString() {
            return "SkillCover(url=" + this.f20795a + ')';
        }

        public b(String r2) {
            d.h.b.o.e(r2, "url");
            this.f20795a = r2;
        }

        public final String a() {
            return this.f20795a;
        }
    }
}
