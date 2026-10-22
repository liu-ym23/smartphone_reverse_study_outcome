package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface j {

    /* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f27421b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f27420a == r6.f27420a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27421b, r6.f27421b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f27420a) * 31;
            Set<String> r1 = this.f27421b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "FullResult(success=" + this.f27420a + ", appBlackListItems=" + this.f27421b + ')';
        }

        public a(boolean r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            this.f27420a = r3;
            this.f27421b = r5;
        }

        public /* synthetic */ a(boolean r2, Set r3, int r4, d.h.b.h r5) {
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            this(r2, r6);
        }

        public final boolean a() {
            return this.f27420a;
        }

        public final Set<String> b() {
            return this.f27421b;
        }
    }

    /* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, e> f27423b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ b a(b r1, boolean r2, Map r3, int r4, Object r5) {
            Map<String, e> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.f27422a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.f27423b;
        L9:
            return r1.a(r2, r6);
        }

        public final b a(boolean r2, Map<String, ? extends e> r3) {
            return new b(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f27422a == r6.f27422a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27423b, r6.f27423b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f27422a) * 31;
            Map<String, e> r1 = this.f27423b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "FullStateResult(success=" + this.f27422a + ", states=" + this.f27423b + ')';
        }

        public b(boolean r3, Map<String, ? extends e> r4) {
            Map<String, e> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.f27422a = r3;
            this.f27423b = r5;
        }

        public /* synthetic */ b(boolean r2, Map r3, int r4, d.h.b.h r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            this(r2, r6);
        }

        public final boolean a() {
            return this.f27422a;
        }

        public final Map<String, e> b() {
            return this.f27423b;
        }
    }

    /* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.applist.black.e f27425b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f27424a == r6.f27424a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27425b, r6.f27425b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f27424a) * 31;
            com.obric.autogui.agents.vlm.models.impl.applist.black.e r1 = this.f27425b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Result(success=" + this.f27424a + ", appBlackListItem=" + this.f27425b + ')';
        }

        public c(boolean r3, com.obric.autogui.agents.vlm.models.impl.applist.black.e r4) {
            com.obric.autogui.agents.vlm.models.impl.applist.black.e r5 = (com.obric.autogui.agents.vlm.models.impl.applist.black.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.applist.black.e.class, "com.obric.aiagent.plugin");
            this.f27424a = r3;
            this.f27425b = r5;
        }

        public /* synthetic */ c(boolean r2, com.obric.autogui.agents.vlm.models.impl.applist.black.e r3, int r4, d.h.b.h r5) {
            com.obric.autogui.agents.vlm.models.impl.applist.black.e r6 = (com.obric.autogui.agents.vlm.models.impl.applist.black.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.impl.applist.black.e.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = true;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            this(r2, r6);
        }

        public final boolean a() {
            return this.f27424a;
        }

        public final com.obric.autogui.agents.vlm.models.impl.applist.black.e b() {
            return this.f27425b;
        }
    }

    /* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f27427b;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (this.f27426a == r6.f27426a) goto L12;
            return false;
        L12:
            if (this.f27427b == r6.f27427b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f27426a) * 31;
            e r1 = this.f27427b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "StateResult(success=" + this.f27426a + ", state=" + this.f27427b + ')';
        }

        public d(boolean r1, e r2) {
            this.f27426a = r1;
            this.f27427b = r2;
        }

        public /* synthetic */ d(boolean r1, e r2, int r3, d.h.b.h r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = true;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }

        public final boolean a() {
            return this.f27426a;
        }

        public final e b() {
            return this.f27427b;
        }
    }

    /* JADX INFO: compiled from: UserDefinedBlackListDataSource.kt */
    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f27428a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f27429b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ e[] f27430c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f27431d = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f27428a, f27429b};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f27428a = new e("Enabled", 0);
            f27429b = new e("Disabled", 1);
            e[] r0 = a();
            f27430c = r0;
            f27431d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f27430c.clone(), e[].class, "com.obric.aiagent.plugin");
        }
    }

    Object a(d.c.d<? super a> r1);

    Object a(String r1, d.c.d<? super d> r2);

    Object b(d.c.d<? super b> r1);

    Object query(String r1, d.c.d<? super c> r2);

    Object update(String r1, e r2, d.c.d<? super Boolean> r3);
}
