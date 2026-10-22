package com.obric.aiagent.skill.manager.api;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface aj {

    /* JADX INFO: compiled from: SkillModels.kt */
    public static final class a implements aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ak f19183b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19182a, r6.f19182a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19183b, r6.f19183b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f19182a.hashCode() * 31) + this.f19183b.hashCode();
        }

        public String toString() {
            return "Completed(taskId=" + this.f19182a + ", result=" + this.f19183b + ')';
        }

        public a(String r2, ak r3) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            d.h.b.o.e(r3, "result");
            this.f19182a = r2;
            this.f19183b = r3;
        }

        @Override // com.obric.aiagent.skill.manager.api.aj
        public String a() {
            return this.f19182a;
        }

        public final ak b() {
            return this.f19183b;
        }
    }

    /* JADX INFO: compiled from: SkillModels.kt */
    public static final class b implements aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f19186c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19184a, r6.f19184a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f19185b, r6.f19185b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f19186c, r6.f19186c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r0 = this.f19184a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f19185b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f19186c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Error(taskId=" + this.f19184a + ", errorCode=" + this.f19185b + ", errorMessage=" + this.f19186c + ')';
        }

        public b(String r1, String r2, String r3) {
            this.f19184a = r1;
            this.f19185b = r2;
            this.f19186c = r3;
        }

        public /* synthetic */ b(String r2, String r3, String r4, int r5, d.h.b.h r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }

        @Override // com.obric.aiagent.skill.manager.api.aj
        public String a() {
            return this.f19184a;
        }

        public final String b() {
            return this.f19185b;
        }
    }

    /* JADX INFO: compiled from: SkillModels.kt */
    public static final class c implements aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f19187a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f19188b = null;

        static {
            f19187a = new c();
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
            return -93626224;
        }

        public String toString() {
            return "NotRequired";
        }

        private c() {
        }

        @Override // com.obric.aiagent.skill.manager.api.aj
        public String a() {
            return f19188b;
        }
    }

    /* JADX INFO: compiled from: SkillModels.kt */
    public static final class d implements aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f19189a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f19190b = null;

        static {
            f19189a = new d();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
            return false;
        L9:
            d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1299065200;
        }

        public String toString() {
            return "NotStarted";
        }

        private d() {
        }

        @Override // com.obric.aiagent.skill.manager.api.aj
        public String a() {
            return f19190b;
        }
    }

    /* JADX INFO: compiled from: SkillModels.kt */
    public static final class e implements aj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19191a;

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f19191a, r6.f19191a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.f19191a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Scanning(taskId=" + this.f19191a + ')';
        }

        public e(String r1) {
            this.f19191a = r1;
        }

        public /* synthetic */ e(String r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        @Override // com.obric.aiagent.skill.manager.api.aj
        public String a() {
            return this.f19191a;
        }
    }

    String a();
}
