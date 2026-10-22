package j1;

import com.autonavi.aps.amapapi.config.Const;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00002\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0019\u001a\u00020\u0018*\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\u0018*\u00060\u0014j\u0002`\u00152\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR \u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\"\u0010\u000b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001d¨\u0006*"}, d2 = {"Lj1/g;", "", "", "table", "<init>", "(Ljava/lang/String;)V", "", "columns", "c", "([Ljava/lang/String;)Lj1/g;", "selection", "bindArgs", "f", "(Ljava/lang/String;[Ljava/lang/Object;)Lj1/g;", "orderBy", "e", "(Ljava/lang/String;)Lj1/g;", "Lj1/f;", Const.INTENT_KEY_UMID, "()Lj1/f;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "clause", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/StringBuilder;[Ljava/lang/String;)V", "Ljava/lang/String;", "", "Z", "distinct", "[Ljava/lang/String;", "[Ljava/lang/Object;", "groupBy", Const.INTENT_KEY_BACKGROUND_COMMAND, "having", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "limit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: j1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4760g {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f34482k = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String table;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean distinct;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String[] columns;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public String selection;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Object[] bindArgs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public String groupBy;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public String having;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String orderBy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public String limit;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lj1/g$a;", "", "<init>", "()V", "", "tableName", "Lj1/g;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lj1/g;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "limitPattern", "Ljava/util/regex/Pattern;", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: j1.g$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C4760g a(String tableName) {
            p.i(tableName, "tableName");
            return new C4760g(tableName, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ C4760g(String str, i iVar) {
        this(str);
    }

    public final void a(StringBuilder sb2, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        sb2.append(str);
        sb2.append(str2);
    }

    public final void b(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(' ');
    }

    public final C4760g c(String[] columns) {
        this.columns = columns;
        return this;
    }

    public final InterfaceC4759f d() {
        String str;
        String str2 = this.groupBy;
        if ((str2 == null || str2.length() == 0) && (str = this.having) != null && str.length() != 0) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("SELECT ");
        if (this.distinct) {
            sb2.append("DISTINCT ");
        }
        String[] strArr = this.columns;
        if (strArr == null || strArr.length == 0) {
            sb2.append("* ");
        } else {
            p.f(strArr);
            b(sb2, strArr);
        }
        sb2.append("FROM ");
        sb2.append(this.table);
        a(sb2, " WHERE ", this.selection);
        a(sb2, " GROUP BY ", this.groupBy);
        a(sb2, " HAVING ", this.having);
        a(sb2, " ORDER BY ", this.orderBy);
        a(sb2, " LIMIT ", this.limit);
        return new C4754a(sb2.toString(), this.bindArgs);
    }

    public final C4760g e(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public final C4760g f(String selection, Object[] bindArgs) {
        this.selection = selection;
        this.bindArgs = bindArgs;
        return this;
    }

    public C4760g(String str) {
        this.table = str;
    }
}
