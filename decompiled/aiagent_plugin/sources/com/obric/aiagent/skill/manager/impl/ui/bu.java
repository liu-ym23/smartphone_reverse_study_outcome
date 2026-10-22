package com.obric.aiagent.skill.manager.impl.ui;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20674a = null;

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class a extends bu {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f20677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f20678e;
        private final long f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20675b, r6.f20675b) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20676c, r6.f20676c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f20675b.hashCode() * 31) + this.f20676c.hashCode();
        }

        public String toString() {
            return "Category(categoryId=" + this.f20675b + ", title=" + this.f20676c + ')';
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String c() {
            return this.f20675b;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String b() {
            return this.f20676c;
        }

        public a(String r2, String r3) {
            d.h.b.o.e(r2, "categoryId");
            d.h.b.o.e(r3, DBDefinition.TITLE);
            super(null);
            this.f20675b = r2;
            this.f20676c = r3;
            this.f20677d = "category:" + c();
            this.f20678e = "mall_category";
            this.f = b.a(bu.f20674a, a());
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String a() {
            return this.f20677d;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String d() {
            return this.f20678e;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public long e() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ long a(b r0, String r1) {
            return r0.a(r1);
        }

        private final long a(String r6) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
            long r0 = 1125899906842597L;
            int r7 = 0;
        L4:
            if (r7 >= r5.length()) goto L6;
            r0 = (r0 * 31) + ((long) r5.charAt(r7));
            r7 = r7 + 1;
            goto L4
        L6:
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillShopViewModel.kt */
    public static final class c extends bu {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f20681d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f20682e;
        private final long f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20679b, r6.f20679b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20679b.hashCode();
        }

        public String toString() {
            return "Recommended(title=" + this.f20679b + ')';
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String b() {
            return this.f20679b;
        }

        public c(String r3) {
            d.h.b.o.e(r3, DBDefinition.TITLE);
            super(null);
            this.f20679b = r3;
            this.f20680c = "recommended";
            this.f20682e = "mall_recommended";
            this.f = Long.MIN_VALUE;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String a() {
            return this.f20680c;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String c() {
            return this.f20681d;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public String d() {
            return this.f20682e;
        }

        @Override // com.obric.aiagent.skill.manager.impl.ui.bu
        public long e() {
            return this.f;
        }
    }

    static {
        f20674a = new b(null);
    }

    public /* synthetic */ bu(d.h.b.h r1) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract long e();

    private bu() {
    }

    public final boolean f() {
        return ZeusTransformUtils.instanceOf(this, c.class);
    }
}
