package aw5;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: aw5.a$a, reason: collision with other inner class name */
    public static final class C0240a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0240a f16522a = null;

        static {
            f16522a = new C0240a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0240a) == true) goto L9;
            return false;
        L9:
            C0240a r101 = (C0240a) r100;
            return true;
        }

        public final int hashCode() {
            return 1303888087;
        }

        public final String toString() {
            return "ClickSearchButton";
        }

        public C0240a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowSearchData f16523a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f16523a, ((b) r100).f16523a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f16523a.hashCode();
        }

        public final String toString() {
            return "ClickSearchResult(data=" + this.f16523a + ')';
        }

        public b(FlowSearchData r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f16523a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f16524a = null;

        static {
            f16524a = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -173544036;
        }

        public final String toString() {
            return "CollapseHistory";
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowQuery f16525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16526b;

        public d() {
            this(null, false, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f16525a, r101.f16525a) == true) goto L12;
            return false;
        L12:
            if (this.f16526b == r101.f16526b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            FlowQuery r100 = this.f16525a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.f16526b == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "DeleteHistory(query=" + this.f16525a + ", deleteAll=" + this.f16526b + ')';
        }

        public d(FlowQuery r100, boolean r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = false;
        L8:
            this.f16525a = r100;
            this.f16526b = r101;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f16527a = null;

        static {
            f16527a = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 1232557903;
        }

        public final String toString() {
            return "ExpandHistory";
        }

        public e() {
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f16528a = null;

        static {
            f16528a = new f();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            f r101 = (f) r100;
            return true;
        }

        public final int hashCode() {
            return -425452898;
        }

        public final String toString() {
            return "Launch";
        }

        public f() {
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SearchCursor f16530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f16531c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f16529a, r101.f16529a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f16530b, r101.f16530b) == true) goto L15;
            return false;
        L15:
            if (this.f16531c == r101.f16531c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f16529a.hashCode() * 31;
            SearchCursor r101 = this.f16530b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f16531c == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "LoadMore(domain=" + this.f16529a + ", cursor=" + this.f16530b + ", halfYearLoad=" + this.f16531c + ')';
        }

        public g(String r100, SearchCursor r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "domain");
            this.f16529a = r100;
            this.f16530b = r101;
            this.f16531c = r102;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f16532a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f16532a == ((h) r100).f16532a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f16532a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "UpdateHistoryManageState(isManaging=" + this.f16532a + ')';
        }

        public h(boolean r100) {
            this.f16532a = r100;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowQuery f16533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f16534b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f16533a, r101.f16533a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f16534b, r101.f16534b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f16533a.hashCode() * 31) + this.f16534b.hashCode();
        }

        public final String toString() {
            return "UpdateQuery(query=" + this.f16533a + ", actionType=" + this.f16534b + ')';
        }

        public i(FlowQuery r100, j r101) {
            Intrinsics.checkNotNullParameter(r100, "query");
            Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
            this.f16533a = r100;
            this.f16534b = r101;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f16535b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f16536c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j f16537d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final j f16538e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16539a;

        /* JADX INFO: renamed from: aw5.a$j$a, reason: collision with other inner class name */
        public static final class C0241a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f16539a, ((j) r100).f16539a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f16539a.hashCode();
        }

        public final String toString() {
            return "UpdateQueryActionType(value=" + this.f16539a + ')';
        }

        static {
            f16535b = new j("userInput");
            f16536c = new j("replayHistory");
            f16537d = new j("clickFilter");
            f16538e = new j("refresh");
        }

        public j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f16539a = r100;
        }
    }

    public a() {
    }
}
