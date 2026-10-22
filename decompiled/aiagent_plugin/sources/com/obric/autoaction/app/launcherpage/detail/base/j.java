package com.obric.autoaction.app.launcherpage.detail.base;

import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: Contract.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j implements com.obric.autoaction.app.launcherpage.detail.base.h {

    /* JADX INFO: compiled from: Contract.kt */
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23384a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23384a, r6.f23384a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23384a.hashCode();
        }

        public String toString() {
            return "DeleteTaskAction(taskId=" + this.f23384a + ')';
        }

        public a(String r2) {
            o.e(r2, DBDefinition.TASK_ID);
            super(null);
            this.f23384a = r2;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f23385a;

        public b() {
            this(false, 1, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f23385a == r6.f23385a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f23385a);
        }

        public String toString() {
            return "SaveTaskAction(needClosePage=" + this.f23385a + ')';
        }

        public b(boolean r2) {
            super(null);
            this.f23385a = r2;
        }

        public /* synthetic */ b(boolean r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            this(r1);
        }

        public final boolean a() {
            return this.f23385a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f23386a = null;

        static {
            f23386a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<AutoCondition> f23387a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23387a, r6.f23387a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23387a.hashCode();
        }

        public String toString() {
            return "UpdateConditionsAction(conditions=" + this.f23387a + ')';
        }

        public d(List<? extends AutoCondition> r3) {
            List<AutoCondition> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "conditions");
            super(null);
            this.f23387a = r4;
        }

        public final List<AutoCondition> a() {
            return this.f23387a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class e extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23389b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23388a, r6.f23388a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f23389b, r6.f23389b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f23388a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f23389b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "UpdateDateAction(startDate=" + this.f23388a + ", endDate=" + this.f23389b + ')';
        }

        public e(String r2, String r3) {
            super(null);
            this.f23388a = r2;
            this.f23389b = r3;
        }

        public final String a() {
            return this.f23388a;
        }

        public final String b() {
            return this.f23389b;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class f extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TriggerControlPolicy f23390a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23390a, r6.f23390a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23390a.hashCode();
        }

        public String toString() {
            return "UpdateFrequencyAction(policy=" + this.f23390a + ')';
        }

        public f(TriggerControlPolicy r2) {
            o.e(r2, "policy");
            super(null);
            this.f23390a = r2;
        }

        public final TriggerControlPolicy a() {
            return this.f23390a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class g extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23391a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23391a, r6.f23391a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23391a.hashCode();
        }

        public String toString() {
            return "UpdateModeAction(model=" + this.f23391a + ')';
        }

        public g(String r2) {
            o.e(r2, "model");
            super(null);
            this.f23391a = r2;
        }

        public final String a() {
            return this.f23391a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class h extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23392a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23392a, r6.f23392a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23392a.hashCode();
        }

        public String toString() {
            return "UpdateQueryAction(query=" + this.f23392a + ')';
        }

        public h(String r2) {
            o.e(r2, DownloadConstants.QUERY_KEY);
            super(null);
            this.f23392a = r2;
        }

        public final String a() {
            return this.f23392a;
        }
    }

    /* JADX INFO: compiled from: Contract.kt */
    public static final class i extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PeriodicPolicy f23393a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
            return false;
        L8:
            i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23393a, r6.f23393a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23393a.hashCode();
        }

        public String toString() {
            return "UpdateRepeatAction(policy=" + this.f23393a + ')';
        }

        public i(PeriodicPolicy r2) {
            o.e(r2, "policy");
            super(null);
            this.f23393a = r2;
        }

        public final PeriodicPolicy a() {
            return this.f23393a;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Contract.kt */
    public static final class C0509j extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23395b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0509j.class) == true) goto L8;
            return false;
        L8:
            C0509j r6 = (C0509j) ZeusTransformUtils.preCheckCast(r5, C0509j.class, "com.obric.aiagent.plugin");
            if (o.a(this.f23394a, r6.f23394a) == true) goto L12;
            return false;
        L12:
            if (this.f23395b == r6.f23395b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f23394a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f23395b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "UpdateShortInstructAction(instruct=" + this.f23394a + ", enable=" + this.f23395b + ')';
        }

        public C0509j(String r2, boolean r3) {
            super(null);
            this.f23394a = r2;
            this.f23395b = r3;
        }

        public final String a() {
            return this.f23394a;
        }

        public final boolean b() {
            return this.f23395b;
        }
    }

    public /* synthetic */ j(d.h.b.h r1) {
        this();
    }

    private j() {
    }
}
