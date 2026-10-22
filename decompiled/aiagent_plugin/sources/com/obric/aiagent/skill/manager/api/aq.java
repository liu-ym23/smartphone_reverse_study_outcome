package com.obric.aiagent.skill.manager.api;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface aq {

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class a implements aq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19212a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f19213b = null;

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
            return false;
        L9:
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1284967794;
        }

        public String toString() {
            return "AppFunction";
        }

        private a() {
        }

        static {
            f19212a = new a();
            f19213b = "app_function";
        }

        @Override // com.obric.aiagent.skill.manager.api.aq
        public String a() {
            return f19213b;
        }
    }

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ar f19214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19215b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f19214a == r6.f19214a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19215b, r6.f19215b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19214a.hashCode() * 31) + this.f19215b.hashCode();
        }

        public String toString() {
            return "Created(channel=" + this.f19214a + ", attributionName=" + this.f19215b + ')';
        }

        public b(ar r2, String r3) {
            d.h.b.o.e(r2, "channel");
            d.h.b.o.e(r3, "attributionName");
            this.f19214a = r2;
            this.f19215b = r3;
        }

        public ar b() {
            return this.f19214a;
        }

        @Override // com.obric.aiagent.skill.manager.api.aq.d
        public String c() {
            return this.f19215b;
        }

        @Override // com.obric.aiagent.skill.manager.api.aq
        public String a() {
            return "created_" + b().a();
        }
    }

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ar f19216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n f19217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f19218c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f19216a == r6.f19216a) goto L12;
            return false;
        L12:
            if (this.f19217b == r6.f19217b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19218c, r6.f19218c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f19216a.hashCode() * 31) + this.f19217b.hashCode()) * 31) + this.f19218c.hashCode();
        }

        public String toString() {
            return "Imported(channel=" + this.f19216a + ", importKind=" + this.f19217b + ", attributionName=" + this.f19218c + ')';
        }

        public c(ar r2, n r3, String r4) {
            d.h.b.o.e(r2, "channel");
            d.h.b.o.e(r3, "importKind");
            d.h.b.o.e(r4, "attributionName");
            this.f19216a = r2;
            this.f19217b = r3;
            this.f19218c = r4;
        }

        public ar b() {
            return this.f19216a;
        }

        public final n d() {
            return this.f19217b;
        }

        @Override // com.obric.aiagent.skill.manager.api.aq.d
        public String c() {
            return this.f19218c;
        }

        @Override // com.obric.aiagent.skill.manager.api.aq
        public String a() {
            return "imported_" + b().a();
        }
    }

    /* JADX INFO: compiled from: SkillSource.kt */
    public interface d extends aq {
        String c();
    }

    /* JADX INFO: compiled from: SkillSource.kt */
    public static final class e implements aq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f19221c;

        public e() {
            this(null, null, null, 7, null);
        }

        @Override // com.obric.aiagent.skill.manager.api.aq
        public String a() {
            return "store";
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19219a, r6.f19219a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19220b, r6.f19220b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19221c, r6.f19221c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f19219a.hashCode() * 31) + this.f19220b.hashCode()) * 31) + this.f19221c.hashCode();
        }

        public String toString() {
            return "Store(id=" + this.f19219a + ", name=" + this.f19220b + ", iconUrl=" + this.f19221c + ')';
        }

        public e(String r2, String r3, String r4) {
            d.h.b.o.e(r2, DbHelper.COL_ID);
            d.h.b.o.e(r3, "name");
            d.h.b.o.e(r4, DBDefinition.ICON_URL);
            this.f19219a = r2;
            this.f19220b = r3;
            this.f19221c = r4;
        }

        public /* synthetic */ e(String r2, String r3, String r4, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            this(r2, r3, r4);
        }

        public final String b() {
            return this.f19219a;
        }

        public final String c() {
            return this.f19220b;
        }

        public final String d() {
            return this.f19221c;
        }
    }

    String a();
}
