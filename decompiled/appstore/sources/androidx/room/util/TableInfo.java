package androidx.room.util;

import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.model.AppInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;

/* JADX INFO: loaded from: classes.dex */
public final class TableInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f4674e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f4677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f4678d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0047a f4679h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f4684e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f4685f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f4686g;

        /* JADX INFO: renamed from: androidx.room.util.TableInfo$a$a, reason: collision with other inner class name */
        public static final class C0047a {
            public /* synthetic */ C0047a(DefaultConstructorMarker r10) {
                this();
            }

            public final boolean a(String r10) {
                if (r10.length() != 0) goto L5;
                return false;
            L5:
                int r11 = 0;
                int r12 = 0;
                int r13 = 0;
            L7:
                if (r11 >= r10.length()) goto L22;
                char r14 = r10.charAt(r11);
                int r15 = r13 + 1;
                if (r13 != 0) goto L12;
                if (r14 == '(') goto L12;
                return false;
            L12:
                if (r14 != '(') goto L15;
                r12 = r12 + 1;
            L21:
                r11 = r11 + 1;
                r13 = r15;
                goto L7
            L15:
                if (r14 != ')') goto L21;
                r12 = r12 - 1;
                if (r12 != 0) goto L21;
                if (r13 == (r10.length() - 1)) goto L21;
                return false;
            L22:
                if (r12 == 0) goto L24;
                return false;
            L24:
                return true;
            }

            public final boolean b(String r10, String r11) {
                q.g(r10, PerfConsts.KEY_CURRENT_GALVANIC);
                if (q.b(r10, r11) == false) goto L6;
                return true;
            L6:
                if (a(r10) == false) goto L9;
                String r12 = r10.substring(1, r10.length() - 1);
                q.f(r12, "this as java.lang.String…ing(startIndex, endIndex)");
                return q.b(StringsKt__StringsKt.z0(r12).toString(), r11);
            L9:
                return false;
            }

            public C0047a() {
            }
        }

        static {
            f4679h = new C0047a(null);
        }

        public a(String r10, String r11, boolean r12, int r13, String r14, int r15) {
            q.g(r10, "name");
            q.g(r11, "type");
            this.f4680a = r10;
            this.f4681b = r11;
            this.f4682c = r12;
            this.f4683d = r13;
            this.f4684e = r14;
            this.f4685f = r15;
            this.f4686g = a(r11);
        }

        public final int a(String r10) {
            if (r10 != null) goto L5;
            return 5;
        L5:
            Locale r11 = Locale.US;
            q.f(r11, "US");
            String r12 = r10.toUpperCase(r11);
            q.f(r12, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt__StringsKt.E(r12, "INT", false, 2, null) == false) goto L10;
            return 3;
        L10:
            if (StringsKt__StringsKt.E(r12, "CHAR", false, 2, null) == false) goto L12;
        L30:
            return 2;
        L12:
            if (StringsKt__StringsKt.E(r12, "CLOB", false, 2, null) == true) goto L30;
            if (StringsKt__StringsKt.E(r12, "TEXT", false, 2, null) == true) goto L30;
            if (StringsKt__StringsKt.E(r12, "BLOB", false, 2, null) == false) goto L20;
            return 5;
        L20:
            if (StringsKt__StringsKt.E(r12, "REAL", false, 2, null) == false) goto L22;
            return 4;
        L22:
            if (StringsKt__StringsKt.E(r12, "FLOA", false, 2, null) == false) goto L24;
            return 4;
        L24:
            if (StringsKt__StringsKt.E(r12, "DOUB", false, 2, null) == true) goto L32;
            return 1;
        L32:
            return 4;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f4683d == ((a) r10).f4683d) goto L11;
            return false;
        L11:
            a r11 = (a) r10;
            if (q.b(this.f4680a, r11.f4680a) == true) goto L15;
            return false;
        L15:
            if (this.f4682c == r11.f4682c) goto L18;
            return false;
        L18:
            if (this.f4685f != 1) goto L27;
            if (r11.f4685f != 2) goto L27;
            String r12 = this.f4684e;
            if (r12 == null) goto L27;
            if (f4679h.b(r12, r11.f4684e) == true) goto L27;
            return false;
        L27:
            if (this.f4685f == 2) goto L29;
        L35:
            int r13 = this.f4685f;
            if (r13 == 0) goto L48;
            if (r13 != r11.f4685f) goto L48;
            String r14 = this.f4684e;
            if (r14 == null) goto L45;
            if (f4679h.b(r14, r11.f4684e) == true) goto L48;
        L46:
            return false;
        L45:
            if (r11.f4684e != null) goto L46;
        L48:
            if (this.f4686g != r11.f4686g) goto L51;
            return true;
        L51:
            return false;
        L29:
            if (r11.f4685f != 1) goto L35;
            String r15 = r11.f4684e;
            if (r15 == null) goto L35;
            if (f4679h.b(r15, this.f4684e) == true) goto L35;
            return false;
        }

        public int hashCode() {
            int r10 = ((this.f4680a.hashCode() * 31) + this.f4686g) * 31;
            if (this.f4682c == false) goto L5;
            int r11 = 1231;
        L7:
            return ((r10 + r11) * 31) + this.f4683d;
        L5:
            r11 = 1237;
            goto L7
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("Column{name='");
            r10.append(this.f4680a);
            r10.append("', type='");
            r10.append(this.f4681b);
            r10.append("', affinity='");
            r10.append(this.f4686g);
            r10.append("', notNull=");
            r10.append(this.f4682c);
            r10.append(", primaryKeyPosition=");
            r10.append(this.f4683d);
            r10.append(", defaultValue='");
            String r11 = this.f4684e;
            if (r11 != null) goto L5;
            r11 = "undefined";
        L5:
            r10.append(r11);
            r10.append("'}");
            return r10.toString();
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final TableInfo a(SupportSQLiteDatabase r10, String r11) {
            q.g(r10, "database");
            q.g(r11, "tableName");
            return androidx.room.util.a.f(r10, r11);
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f4690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f4691e;

        public c(String r10, String r11, String r12, List r13, List r14) {
            q.g(r10, "referenceTable");
            q.g(r11, "onDelete");
            q.g(r12, "onUpdate");
            q.g(r13, "columnNames");
            q.g(r14, "referenceColumnNames");
            this.f4687a = r10;
            this.f4688b = r11;
            this.f4689c = r12;
            this.f4690d = r13;
            this.f4691e = r14;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (q.b(this.f4687a, r11.f4687a) == true) goto L12;
            return false;
        L12:
            if (q.b(this.f4688b, r11.f4688b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f4689c, r11.f4689c) == true) goto L18;
            return false;
        L18:
            if (q.b(this.f4690d, r11.f4690d) == true) goto L21;
            return false;
        L21:
            return q.b(this.f4691e, r11.f4691e);
        }

        public int hashCode() {
            return (((((((this.f4687a.hashCode() * 31) + this.f4688b.hashCode()) * 31) + this.f4689c.hashCode()) * 31) + this.f4690d.hashCode()) * 31) + this.f4691e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f4687a + "', onDelete='" + this.f4688b + " +', onUpdate='" + this.f4689c + "', columnNames=" + this.f4690d + ", referenceColumnNames=" + this.f4691e + '}';
        }
    }

    public static final class d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f4695d;

        public d(int r10, int r11, String r12, String r13) {
            q.g(r12, "from");
            q.g(r13, "to");
            this.f4692a = r10;
            this.f4693b = r11;
            this.f4694c = r12;
            this.f4695d = r13;
        }

        public int a(d r10) {
            q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
            int r11 = this.f4692a - r10.f4692a;
            if (r11 == 0) goto L5;
            return r11;
        L5:
            return this.f4693b - r10.f4693b;
        }

        public final String b() {
            return this.f4694c;
        }

        public final int c() {
            return this.f4692a;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return a((d) r10);
        }

        public final String d() {
            return this.f4695d;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4696e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f4699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f4700d;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            f4696e = new a(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public e(String r10, boolean r11, List r12, List r13) {
            q.g(r10, "name");
            q.g(r12, "columns");
            q.g(r13, "orders");
            this.f4697a = r10;
            this.f4698b = r11;
            this.f4699c = r12;
            this.f4700d = r13;
            if (r13.isEmpty() == false) goto L7;
            int r14 = r12.size();
            r13 = new ArrayList(r14);
            int r15 = 0;
        L5:
            if (r15 >= r14) goto L7;
            r13.add(Index.Order.ASC.name());
            r15 = r15 + 1;
        L7:
            this.f4700d = r13;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (this.f4698b == r11.f4698b) goto L12;
            return false;
        L12:
            if (q.b(this.f4699c, r11.f4699c) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f4700d, r11.f4700d) == true) goto L18;
            return false;
        L18:
            if (o.B(this.f4697a, "index_", false, 2, null) == false) goto L21;
            return o.B(r11.f4697a, "index_", false, 2, null);
        L21:
            return q.b(this.f4697a, r11.f4697a);
        }

        public int hashCode() {
            if (o.B(this.f4697a, "index_", false, 2, null) == false) goto L5;
            int r10 = -1184239155;
        L7:
            return (((((r10 * 31) + (this.f4698b ? 1 : 0)) * 31) + this.f4699c.hashCode()) * 31) + this.f4700d.hashCode();
        L5:
            r10 = this.f4697a.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.f4697a + "', unique=" + this.f4698b + ", columns=" + this.f4699c + ", orders=" + this.f4700d + "'}";
        }
    }

    static {
        f4674e = new b(null);
    }

    public TableInfo(String r10, Map r11, Set r12, Set r13) {
        q.g(r10, "name");
        q.g(r11, "columns");
        q.g(r12, "foreignKeys");
        this.f4675a = r10;
        this.f4676b = r11;
        this.f4677c = r12;
        this.f4678d = r13;
    }

    public static final TableInfo a(SupportSQLiteDatabase r10, String r11) {
        return f4674e.a(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r11 = (TableInfo) r10;
        if (q.b(this.f4675a, r11.f4675a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f4676b, r11.f4676b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f4677c, r11.f4677c) == true) goto L17;
        return false;
    L17:
        Set r12 = this.f4678d;
        if (r12 == null) goto L24;
        Set r13 = r11.f4678d;
        if (r13 != null) goto L23;
        return true;
    L23:
        return q.b(r12, r13);
    L24:
        return true;
    }

    public int hashCode() {
        return (((this.f4675a.hashCode() * 31) + this.f4676b.hashCode()) * 31) + this.f4677c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.f4675a + "', columns=" + this.f4676b + ", foreignKeys=" + this.f4677c + ", indices=" + this.f4678d + '}';
    }
}
