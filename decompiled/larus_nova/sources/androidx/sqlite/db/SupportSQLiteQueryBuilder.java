package androidx.sqlite.db;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.trace.CopyContentTypeString;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00002\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J)\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0002J%\u0010\u001b\u001a\u00020\u0016*\u00060\u0017j\u0002`\u00182\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "", CopyContentTypeString.TABLE, "", "(Ljava/lang/String;)V", "bindArgs", "", "[Ljava/lang/Object;", "columns", "[Ljava/lang/String;", "distinct", "", "groupBy", "having", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "orderBy", "selection", "([Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "create", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "appendClause", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "appendColumns", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = null;
    private static final Pattern limitPattern = null;
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteQueryBuilder$Companion;", "", "()V", "limitPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "builder", "Landroidx/sqlite/db/SupportSQLiteQueryBuilder;", "tableName", "", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final SupportSQLiteQueryBuilder builder(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tableName");
            return new SupportSQLiteQueryBuilder(r100, null);
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @JvmStatic
    public static final SupportSQLiteQueryBuilder builder(String r100) {
        return Companion.builder(r100);
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    static {
        Companion = new Companion(null);
        limitPattern = PatternProtector.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public final SupportSQLiteQuery create() {
        String r100 = this.groupBy;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        String r103 = this.having;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L20;
        boolean r105 = false;
    L21:
        if (r105 == false) goto L39;
        StringBuilder r106 = new StringBuilder(120);
        r106.append("SELECT ");
        if (this.distinct == false) goto L25;
        r106.append("DISTINCT ");
    L25:
        String[] r107 = this.columns;
        if (r107 != null) goto L28;
    L32:
        r101 = true;
    L33:
        if (r101 == true) goto L35;
        Intrinsics.checkNotNull(r107);
        appendColumns(r106, r107);
    L36:
        r106.append("FROM ");
        r106.append(this.table);
        appendClause(r106, " WHERE ", this.selection);
        appendClause(r106, " GROUP BY ", this.groupBy);
        appendClause(r106, " HAVING ", this.having);
        appendClause(r106, " ORDER BY ", this.orderBy);
        appendClause(r106, " LIMIT ", this.limit);
        return new SimpleSQLiteQuery(r106.toString(), this.bindArgs);
    L35:
        r106.append(c.IMAGE_DEFAULT_TEXT);
        goto L36
    L28:
        if (r107.length != 0) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == false) goto L33;
    L30:
        r108 = false;
        goto L31
    L39:
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause".toString());
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L20:
        r105 = true;
        goto L21
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    private SupportSQLiteQueryBuilder(String r100) {
        this.table = r100;
    }

    public final SupportSQLiteQueryBuilder columns(String[] r100) {
        this.columns = r100;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String r100) {
        this.groupBy = r100;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String r100) {
        this.having = r100;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String r100) {
        Intrinsics.checkNotNullParameter(r100, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);
        boolean r101 = limitPattern.matcher(r100).matches();
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        if (r101 == true) goto L10;
        r102 = false;
    L10:
        if (r102 == false) goto L14;
        this.limit = r100;
        return this;
    L14:
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + r100).toString());
    L5:
        r103 = false;
        goto L6
    }

    public final SupportSQLiteQueryBuilder orderBy(String r100) {
        this.orderBy = r100;
        return this;
    }

    private final void appendColumns(StringBuilder r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = r101[r103];
        if (r103 <= 0) goto L7;
        r100.append(", ");
    L7:
        r100.append(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        r100.append(' ');
    }

    public final SupportSQLiteQueryBuilder selection(String r100, Object[] r101) {
        this.selection = r100;
        this.bindArgs = r101;
        return this;
    }

    private final void appendClause(StringBuilder r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100.append(r101);
        r100.append(r102);
        return;
    L11:
        return;
    L4:
        if (r102.length() == 0) goto L7;
        r103 = false;
        goto L8
    }
}
