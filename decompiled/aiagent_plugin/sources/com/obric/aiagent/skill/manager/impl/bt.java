package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFileFailure.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19589a;

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class a extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19590a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f19590a == r6.f19590a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f19590a);
        }

        public String toString() {
            return "AssistedMarkdownContentTooLong(maxChars=" + this.f19590a + ')';
        }

        public final int b() {
            return this.f19590a;
        }

        public a(int r3) {
            super("assisted_markdown_content_too_long", null);
            this.f19590a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class aa extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19591a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, aa.class) == true) goto L8;
            return false;
        L8:
            aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.aiagent.plugin");
            if (this.f19591a == r8.f19591a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f19591a);
        }

        public String toString() {
            return "ZipEntryTooLarge(maxBytes=" + this.f19591a + ')';
        }

        public final long b() {
            return this.f19591a;
        }

        public aa(long r3) {
            super("zip_entry_too_large", null);
            this.f19591a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class ab extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19592a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, ab.class) == true) goto L8;
            return false;
        L8:
            ab r8 = (ab) ZeusTransformUtils.preCheckCast(r7, ab.class, "com.obric.aiagent.plugin");
            if (this.f19592a == r8.f19592a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f19592a);
        }

        public String toString() {
            return "ZipPackageTooLarge(maxBytes=" + this.f19592a + ')';
        }

        public final long b() {
            return this.f19592a;
        }

        public ab(long r3) {
            super("zip_package_too_large", null);
            this.f19592a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class ac extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19593a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
            return false;
        L8:
            ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.aiagent.plugin");
            if (this.f19593a == r6.f19593a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f19593a);
        }

        public String toString() {
            return "ZipTooManyEntries(maxEntries=" + this.f19593a + ')';
        }

        public final int b() {
            return this.f19593a;
        }

        public ac(int r3) {
            super("zip_too_many_entries", null);
            this.f19593a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class b extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19594a = null;

        static {
            f19594a = new b();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1146653547;
        }

        public String toString() {
            return "BodyRequired";
        }

        private b() {
            super("body_required", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class c extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f19595a = null;

        static {
            f19595a = new c();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
            return false;
        L9:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1822124039;
        }

        public String toString() {
            return "DescriptionRequired";
        }

        private c() {
            super("description_required", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class d extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19596a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (this.f19596a == r6.f19596a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f19596a);
        }

        public String toString() {
            return "DescriptionTooLong(maxChars=" + this.f19596a + ')';
        }

        public final int b() {
            return this.f19596a;
        }

        public d(int r3) {
            super("description_too_long", null);
            this.f19596a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class e extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cc f19597a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f19597a == r6.f19597a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19597a.hashCode();
        }

        public String toString() {
            return "DuplicateFrontmatterField(field=" + this.f19597a + ')';
        }

        public final cc b() {
            return this.f19597a;
        }

        public e(cc r3) {
            d.h.b.o.e(r3, "field");
            super("duplicate_frontmatter_field", null);
            this.f19597a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class f extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f19598a = null;

        static {
            f19598a = new f();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L9;
            return false;
        L9:
            f r2 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 127579976;
        }

        public String toString() {
            return "DuplicateZipEntry";
        }

        private f() {
            super("duplicate_zip_entry", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class g extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f19599a = null;

        static {
            f19599a = new g();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, g.class) == true) goto L9;
            return false;
        L9:
            g r2 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1025284992;
        }

        public String toString() {
            return "FileUnavailable";
        }

        private g() {
            super("file_unavailable", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class h extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f19600a = null;

        static {
            f19600a = new h();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L9;
            return false;
        L9:
            h r2 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1290767856;
        }

        public String toString() {
            return "FrontmatterMissing";
        }

        private h() {
            super("frontmatter_missing", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class i extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f19601a = null;

        static {
            f19601a = new i();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, i.class) == true) goto L9;
            return false;
        L9:
            i r2 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -623313445;
        }

        public String toString() {
            return "FrontmatterUnclosed";
        }

        private i() {
            super("frontmatter_unclosed", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class j extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f19602a = null;

        static {
            f19602a = new j();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, j.class) == true) goto L9;
            return false;
        L9:
            j r2 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1530516445;
        }

        public String toString() {
            return "Generic";
        }

        private j() {
            super("generic", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class k extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f19603a = null;

        static {
            f19603a = new k();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, k.class) == true) goto L9;
            return false;
        L9:
            k r2 = (k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1082621518;
        }

        public String toString() {
            return "InvalidSkillMarkdownLocation";
        }

        private k() {
            super("invalid_skill_markdown_location", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class l extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f19604a = null;

        static {
            f19604a = new l();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, l.class) == true) goto L9;
            return false;
        L9:
            l r2 = (l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1908031454;
        }

        public String toString() {
            return "InvalidZip";
        }

        private l() {
            super("invalid_zip", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class m extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f19605a = null;

        static {
            f19605a = new m();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, m.class) == true) goto L9;
            return false;
        L9:
            m r2 = (m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -245778146;
        }

        public String toString() {
            return "MarkdownContentTypeMismatch";
        }

        private m() {
            super("markdown_content_type_mismatch", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class n extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f19606a = null;

        static {
            f19606a = new n();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, n.class) == true) goto L9;
            return false;
        L9:
            n r2 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1478551502;
        }

        public String toString() {
            return "MissingSkillMarkdown";
        }

        private n() {
            super("missing_skill_markdown", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class o extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f19607a = null;

        static {
            f19607a = new o();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, o.class) == true) goto L9;
            return false;
        L9:
            o r2 = (o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1722047356;
        }

        public String toString() {
            return "MultipleSkillMarkdown";
        }

        private o() {
            super("multiple_skill_markdown", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class p extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f19608a = null;

        static {
            f19608a = new p();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, p.class) == true) goto L9;
            return false;
        L9:
            p r2 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 2104903992;
        }

        public String toString() {
            return "NameInvalid";
        }

        private p() {
            super("name_invalid", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class q extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f19609a = null;

        static {
            f19609a = new q();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, q.class) == true) goto L9;
            return false;
        L9:
            q r2 = (q) ZeusTransformUtils.preCheckCast(r3, q.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -189416322;
        }

        public String toString() {
            return "NameRequired";
        }

        private q() {
            super("name_required", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class r extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19610a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
            return false;
        L8:
            r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
            if (this.f19610a == r6.f19610a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f19610a);
        }

        public String toString() {
            return "NameTooLong(maxChars=" + this.f19610a + ')';
        }

        public r(int r3) {
            super("name_too_long", null);
            this.f19610a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class s extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f19611a = null;

        static {
            f19611a = new s();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, s.class) == true) goto L9;
            return false;
        L9:
            s r2 = (s) ZeusTransformUtils.preCheckCast(r3, s.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 707716654;
        }

        public String toString() {
            return "PickerUnavailable";
        }

        private s() {
            super("picker_unavailable", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class t extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f19612a = null;

        static {
            f19612a = new t();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, t.class) == true) goto L9;
            return false;
        L9:
            t r2 = (t) ZeusTransformUtils.preCheckCast(r3, t.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -863795100;
        }

        public String toString() {
            return "ProcessingFailed";
        }

        private t() {
            super("processing_failed", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class u extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19613a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
            return false;
        L8:
            u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
            if (this.f19613a == r6.f19613a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f19613a);
        }

        public String toString() {
            return "SkillMarkdownContentTooLong(maxChars=" + this.f19613a + ')';
        }

        public final int b() {
            return this.f19613a;
        }

        public u(int r3) {
            super("skill_markdown_content_too_long", null);
            this.f19613a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class v extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19614a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, v.class) == true) goto L8;
            return false;
        L8:
            v r8 = (v) ZeusTransformUtils.preCheckCast(r7, v.class, "com.obric.aiagent.plugin");
            if (this.f19614a == r8.f19614a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f19614a);
        }

        public String toString() {
            return "SkillMarkdownTooLarge(maxBytes=" + this.f19614a + ')';
        }

        public final long b() {
            return this.f19614a;
        }

        public v(long r3) {
            super("skill_markdown_too_large", null);
            this.f19614a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class w extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f19615a;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, w.class) == true) goto L8;
            return false;
        L8:
            w r8 = (w) ZeusTransformUtils.preCheckCast(r7, w.class, "com.obric.aiagent.plugin");
            if (this.f19615a == r8.f19615a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.f19615a);
        }

        public String toString() {
            return "SourceFileTooLarge(maxBytes=" + this.f19615a + ')';
        }

        public final long b() {
            return this.f19615a;
        }

        public w(long r3) {
            super("source_file_too_large", null);
            this.f19615a = r3;
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class x extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f19616a = null;

        static {
            f19616a = new x();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, x.class) == true) goto L9;
            return false;
        L9:
            x r2 = (x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 167751309;
        }

        public String toString() {
            return "StoreOnlyPackage";
        }

        private x() {
            super("store_only_package", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class y extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f19617a = null;

        static {
            f19617a = new y();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, y.class) == true) goto L9;
            return false;
        L9:
            y r2 = (y) ZeusTransformUtils.preCheckCast(r3, y.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -128637012;
        }

        public String toString() {
            return "UnsafeZipPath";
        }

        private y() {
            super("unsafe_zip_path", null);
        }
    }

    /* JADX INFO: compiled from: SkillFileFailure.kt */
    public static final class z extends bt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bw f19618a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, z.class) == true) goto L8;
            return false;
        L8:
            z r6 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.aiagent.plugin");
            if (this.f19618a == r6.f19618a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f19618a.hashCode();
        }

        public String toString() {
            return "UnsupportedFileType(policy=" + this.f19618a + ')';
        }

        public final bw b() {
            return this.f19618a;
        }

        public z(bw r3) {
            d.h.b.o.e(r3, "policy");
            super("unsupported_file_type", null);
            this.f19618a = r3;
        }
    }

    public /* synthetic */ bt(String r1, d.h.b.h r2) {
        this(r1);
    }

    private bt(String r1) {
        this.f19589a = r1;
    }

    public final String a() {
        return this.f19589a;
    }
}
