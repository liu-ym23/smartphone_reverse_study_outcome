package androidx.sqlite.driver;

import La.D;
import La.H;
import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import i1.C4159a;
import i1.InterfaceC4162d;
import io.ktor.util.date.GMTDateParser;
import j1.InterfaceC4756c;
import j1.InterfaceC4758e;
import j1.InterfaceC4759f;
import j1.h;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00192\u00020\u0001:\u0005\u001a\u0019\u000b\u0013\rB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0001\u0004\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement;", "Li1/d;", "Lj1/c;", "db", "", "sql", "<init>", "(Lj1/c;Ljava/lang/String;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", Const.INTENT_KEY_APIKEY, "Lj1/c;", Const.INTENT_KEY_PKGNAME, "()Lj1/c;", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "c", "Z", "isClosed", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", Const.INTENT_KEY_UMID, "Companion", "Landroidx/sqlite/driver/SupportSQLiteStatement$a;", "Landroidx/sqlite/driver/SupportSQLiteStatement$b;", "Landroidx/sqlite/driver/SupportSQLiteStatement$c;", "Landroidx/sqlite/driver/SupportSQLiteStatement$d;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SupportSQLiteStatement implements InterfaceC4162d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4756c db;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String sql;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isClosed;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u001b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion;", "", "<init>", "()V", "Lj1/c;", "db", "", "sql", "Landroidx/sqlite/driver/SupportSQLiteStatement;", Const.INTENT_KEY_APIKEY, "(Lj1/c;Ljava/lang/String;)Landroidx/sqlite/driver/SupportSQLiteStatement;", "c", "(Ljava/lang/String;)Ljava/lang/String;", "prefix", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "e", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a;", "", "f", "(Ljava/lang/String;)Z", "s", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)I", "TransactionOperation", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "", "<init>", "(Ljava/lang/String;I)V", "END", "ROLLBACK", "BEGIN_EXCLUSIVE", "BEGIN_IMMEDIATE", "BEGIN_DEFERRED", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class TransactionOperation {
            private static final /* synthetic */ InterfaceC4149a $ENTRIES;
            private static final /* synthetic */ TransactionOperation[] $VALUES;
            public static final TransactionOperation END = new TransactionOperation("END", 0);
            public static final TransactionOperation ROLLBACK = new TransactionOperation("ROLLBACK", 1);
            public static final TransactionOperation BEGIN_EXCLUSIVE = new TransactionOperation("BEGIN_EXCLUSIVE", 2);
            public static final TransactionOperation BEGIN_IMMEDIATE = new TransactionOperation("BEGIN_IMMEDIATE", 3);
            public static final TransactionOperation BEGIN_DEFERRED = new TransactionOperation("BEGIN_DEFERRED", 4);

            private static final /* synthetic */ TransactionOperation[] $values() {
                return new TransactionOperation[]{END, ROLLBACK, BEGIN_EXCLUSIVE, BEGIN_IMMEDIATE, BEGIN_DEFERRED};
            }

            static {
                TransactionOperation[] transactionOperationArr$values = $values();
                $VALUES = transactionOperationArr$values;
                $ENTRIES = kotlin.enums.a.a(transactionOperationArr$values);
            }

            private TransactionOperation(String str, int i10) {
            }

            public static InterfaceC4149a<TransactionOperation> getEntries() {
                return $ENTRIES;
            }

            public static TransactionOperation valueOf(String str) {
                return (TransactionOperation) Enum.valueOf(TransactionOperation.class, str);
            }

            public static TransactionOperation[] values() {
                return (TransactionOperation[]) $VALUES.clone();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a$a;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static abstract class a {

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a$a;", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$a;", "<init>", "()V", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* renamed from: androidx.sqlite.driver.SupportSQLiteStatement$Companion$a$a, reason: collision with other inner class name */
            public static final class C0182a extends a {

                /* renamed from: a, reason: collision with root package name */
                public static final C0182a f14951a = new C0182a();

                public C0182a() {
                    super(null);
                }
            }

            public /* synthetic */ a(i iVar) {
                this();
            }

            public a() {
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SupportSQLiteStatement a(InterfaceC4756c db2, String sql) {
            p.i(db2, "db");
            p.i(sql, "sql");
            String upperCase = H.D1(sql).toString().toUpperCase(Locale.ROOT);
            p.h(upperCase, "toUpperCase(...)");
            String strC = c(upperCase);
            if (strC == null) {
                return new b(db2, sql);
            }
            TransactionOperation transactionOperationE = e(strC, upperCase);
            return transactionOperationE != null ? new d(db2, sql, transactionOperationE) : b(strC, upperCase) instanceof a.C0182a ? new a(db2, sql, new c(db2, sql)) : f(strC) ? new c(db2, sql) : new b(db2, sql);
        }

        public final a b(String prefix, String sql) {
            if (p.d(prefix, "PRA")) {
                String lowerCase = sql.toLowerCase(Locale.ROOT);
                p.h(lowerCase, "toLowerCase(...)");
                if (H.g0(H.n1(lowerCase, "journal_mode", ""), "=", false, 2, null)) {
                    return a.C0182a.f14951a;
                }
            }
            return null;
        }

        public final String c(String sql) {
            p.i(sql, "sql");
            int iD = d(sql);
            if (iD < 0 || iD > sql.length()) {
                return null;
            }
            String strSubstring = sql.substring(iD, Math.min(iD + 3, sql.length()));
            p.h(strSubstring, "substring(...)");
            return strSubstring;
        }

        public final int d(String s10) {
            String str;
            int i10;
            int length = s10.length() - 2;
            if (length < 0) {
                return -1;
            }
            int i11 = 0;
            while (i11 < length) {
                char cCharAt = s10.charAt(i11);
                if (p.k(cCharAt, 32) <= 0) {
                    i11++;
                } else {
                    if (cCharAt != '-') {
                        str = s10;
                        if (cCharAt == '/') {
                            int iT0 = i11 + 1;
                            if (str.charAt(iT0) == '*') {
                                do {
                                    String str2 = str;
                                    iT0 = H.t0(str2, GMTDateParser.ANY, iT0 + 1, false, 4, null);
                                    str = str2;
                                    if (iT0 >= 0) {
                                        i10 = iT0 + 1;
                                        if (i10 >= length) {
                                            break;
                                        }
                                    } else {
                                        return -1;
                                    }
                                } while (str.charAt(i10) != '/');
                                i11 = iT0 + 2;
                                s10 = str;
                            }
                        }
                        return i11;
                    }
                    if (s10.charAt(i11 + 1) != '-') {
                        return i11;
                    }
                    str = s10;
                    int iT02 = H.t0(str, '\n', i11 + 2, false, 4, null);
                    if (iT02 < 0) {
                        return -1;
                    }
                    i11 = iT02 + 1;
                    s10 = str;
                }
            }
            return -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        
            if (r4.equals("END") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r4.equals("COM") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        
            return androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.END;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation e(java.lang.String r4, java.lang.String r5) {
            /*
                r3 = this;
                int r3 = r4.hashCode()
                r0 = 2
                r1 = 0
                r2 = 0
                switch(r3) {
                    case 65636: goto L35;
                    case 66913: goto L29;
                    case 68795: goto L20;
                    case 81327: goto Lb;
                    default: goto La;
                }
            La:
                goto L3d
            Lb:
                java.lang.String r3 = "ROL"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L14
                goto L3d
            L14:
                java.lang.String r3 = " TO "
                boolean r3 = La.H.g0(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L1d
                return r2
            L1d:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.ROLLBACK
                return r3
            L20:
                java.lang.String r3 = "END"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L32
                goto L3d
            L29:
                java.lang.String r3 = "COM"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L32
                goto L3d
            L32:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.END
                return r3
            L35:
                java.lang.String r3 = "BEG"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L3e
            L3d:
                return r2
            L3e:
                java.lang.String r3 = "EXCLUSIVE"
                boolean r3 = La.H.g0(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L49
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_EXCLUSIVE
                return r3
            L49:
                java.lang.String r3 = "IMMEDIATE"
                boolean r3 = La.H.g0(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L54
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_IMMEDIATE
                return r3
            L54:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_DEFERRED
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.driver.SupportSQLiteStatement.Companion.e(java.lang.String, java.lang.String):androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation");
        }

        public final boolean f(String prefix) {
            int iHashCode = prefix.hashCode();
            return iHashCode != 79487 ? iHashCode != 81978 ? iHashCode == 85954 && prefix.equals("WIT") : prefix.equals("SEL") : prefix.equals("PRA");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0010\u0010\"\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b$\u0010#J\u0010\u0010%\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b%\u0010#R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$a;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Li1/d;", "Lj1/c;", "db", "", "sql", "delegate", "<init>", "(Lj1/c;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement;)V", "", "n1", "()Z", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "getBoolean", "(I)Z", "X0", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "reset", "()V", "clearBindings", "close", "e", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends SupportSQLiteStatement implements InterfaceC4162d {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC4756c db2, String sql, SupportSQLiteStatement delegate) {
            super(db2, sql, null);
            p.i(db2, "db");
            p.i(sql, "sql");
            p.i(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            this.delegate.H(index, value);
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            return this.delegate.X0(index);
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            this.delegate.bindLong(index, value);
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            this.delegate.bindNull(index);
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            this.delegate.clearBindings();
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // i1.InterfaceC4162d
        public boolean getBoolean(int index) {
            return this.delegate.getBoolean(index);
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            return this.delegate.getColumnName(index);
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            return this.delegate.getLong(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            return this.delegate.isNull(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            boolean zN1 = this.delegate.n1();
            if (D.L(X0(0), "wal", true)) {
                getDb().enableWriteAheadLogging();
                return zN1;
            }
            getDb().disableWriteAheadLogging();
            return zN1;
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            this.delegate.reset();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010 R\u0018\u0010'\u001a\u00060#j\u0002`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$b;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Lj1/c;", "db", "", "sql", "<init>", "(Lj1/c;Ljava/lang/String;)V", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "X0", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", "Lj1/h;", "Landroidx/sqlite/driver/SupportStatement;", "e", "Lj1/h;", "delegate", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends SupportSQLiteStatement {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final h delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC4756c db2, String sql) {
            super(db2, sql, null);
            p.i(db2, "db");
            p.i(sql, "sql");
            this.delegate = db2.compileStatement(sql);
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            i();
            this.delegate.bindString(index, value);
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            i();
            this.delegate.bindLong(index, value);
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            i();
            this.delegate.bindNull(index);
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            i();
            this.delegate.clearBindings();
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() throws IOException {
            this.delegate.close();
            g(true);
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            i();
            return 0;
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            i();
            this.delegate.execute();
            return false;
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            i();
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\b\u0002\u0018\u0000 D2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010 J\u001f\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010 J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020'2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006F"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$c;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Lj1/c;", "db", "", "sql", "<init>", "(Lj1/c;Ljava/lang/String;)V", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "X0", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", "columnType", "J", "(II)V", "U", "Landroid/database/Cursor;", "Y", "()Landroid/database/Cursor;", "c", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/database/Cursor;I)V", "", "e", "[I", "bindingTypes", "", "f", "[J", "longBindings", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "[D", "doubleBindings", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "[Ljava/lang/String;", "stringBindings", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "[[B", "blobBindings", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroid/database/Cursor;", "cursor", "k", Const.INTENT_KEY_APIKEY, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends SupportSQLiteStatement {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int[] bindingTypes;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public long[] longBindings;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public double[] doubleBindings;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public String[] stringBindings;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public byte[][] blobBindings;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public Cursor cursor;

        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"androidx/sqlite/driver/SupportSQLiteStatement$c$b", "Lj1/f;", "Lj1/e;", "statement", "LY8/t;", "c", "(Lj1/e;)V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "sql", "", Const.INTENT_KEY_APIKEY, "()I", "argCount", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b implements InterfaceC4759f {
            public b() {
            }

            @Override // j1.InterfaceC4759f
            public int a() {
                return c.this.bindingTypes.length;
            }

            @Override // j1.InterfaceC4759f
            /* renamed from: b */
            public String getQuery() {
                return c.this.getSql();
            }

            @Override // j1.InterfaceC4759f
            public void c(InterfaceC4758e statement) {
                p.i(statement, "statement");
                int length = c.this.bindingTypes.length;
                for (int i10 = 1; i10 < length; i10++) {
                    int i11 = c.this.bindingTypes[i10];
                    if (i11 == 1) {
                        statement.bindLong(i10, c.this.longBindings[i10]);
                    } else if (i11 == 2) {
                        statement.bindDouble(i10, c.this.doubleBindings[i10]);
                    } else if (i11 == 3) {
                        String str = c.this.stringBindings[i10];
                        p.f(str);
                        statement.bindString(i10, str);
                    } else if (i11 == 4) {
                        byte[] bArr = c.this.blobBindings[i10];
                        p.f(bArr);
                        statement.bindBlob(i10, bArr);
                    } else if (i11 == 5) {
                        statement.bindNull(i10);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC4756c db2, String sql) {
            super(db2, sql, null);
            p.i(db2, "db");
            p.i(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            i();
            J(3, index);
            this.bindingTypes[index] = 3;
            this.stringBindings[index] = value;
        }

        public final void J(int columnType, int index) {
            int i10 = index + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i10) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
                p.h(iArrCopyOf, "copyOf(...)");
                this.bindingTypes = iArrCopyOf;
            }
            if (columnType == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i10) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
                    p.h(jArrCopyOf, "copyOf(...)");
                    this.longBindings = jArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i10) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i10);
                    p.h(dArrCopyOf, "copyOf(...)");
                    this.doubleBindings = dArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i10) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i10);
                    p.h(objArrCopyOf, "copyOf(...)");
                    this.stringBindings = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i10) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i10);
                p.h(objArrCopyOf2, "copyOf(...)");
                this.blobBindings = (byte[][]) objArrCopyOf2;
            }
        }

        public final void U() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new b());
            }
        }

        public final void V(Cursor c10, int index) {
            if (index < 0 || index >= c10.getColumnCount()) {
                C4159a.b(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            i();
            Cursor cursorY = Y();
            V(cursorY, index);
            String string = cursorY.getString(index);
            p.h(string, "getString(...)");
            return string;
        }

        public final Cursor Y() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            i();
            J(1, index);
            this.bindingTypes[index] = 1;
            this.longBindings[index] = value;
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            i();
            J(5, index);
            this.bindingTypes[index] = 5;
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            i();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() {
            if (!getIsClosed()) {
                clearBindings();
                reset();
            }
            g(true);
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            i();
            U();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            i();
            U();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            V(cursor, index);
            String columnName = cursor.getColumnName(index);
            p.h(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            i();
            Cursor cursorY = Y();
            V(cursorY, index);
            return cursorY.getLong(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            i();
            Cursor cursorY = Y();
            V(cursorY, index);
            return cursorY.isNull(index);
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            i();
            U();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            i();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$d;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Lj1/c;", "db", "", "sql", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "operation", "<init>", "(Lj1/c;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;)V", "", "index", "", UxipConstants.f30680s, "LY8/t;", "bindLong", "(IJ)V", "H", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getLong", "(I)J", "X0", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "n1", "()Z", "reset", "()V", "clearBindings", "close", "e", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "getOperation", "()Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends SupportSQLiteStatement {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Companion.TransactionOperation operation;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14963a;

            static {
                int[] iArr = new int[Companion.TransactionOperation.values().length];
                try {
                    iArr[Companion.TransactionOperation.END.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Companion.TransactionOperation.ROLLBACK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_EXCLUSIVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_IMMEDIATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_DEFERRED.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f14963a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC4756c db2, String sql, Companion.TransactionOperation operation) {
            super(db2, sql, null);
            p.i(db2, "db");
            p.i(sql, "sql");
            p.i(operation, "operation");
            this.operation = operation;
        }

        @Override // i1.InterfaceC4162d
        public void H(int index, String value) {
            p.i(value, "value");
            i();
            C4159a.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public String X0(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void bindLong(int index, long value) {
            i();
            C4159a.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void bindNull(int index) {
            i();
            C4159a.b(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public void clearBindings() {
            i();
        }

        @Override // i1.InterfaceC4162d, java.lang.AutoCloseable
        public void close() {
            g(true);
        }

        @Override // i1.InterfaceC4162d
        public int getColumnCount() {
            i();
            return 0;
        }

        @Override // i1.InterfaceC4162d
        public String getColumnName(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public long getLong(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean isNull(int index) {
            i();
            C4159a.b(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // i1.InterfaceC4162d
        public boolean n1() {
            int i10 = a.f14963a[this.operation.ordinal()];
            if (i10 == 1) {
                getDb().setTransactionSuccessful();
                getDb().endTransaction();
                return false;
            }
            if (i10 == 2) {
                getDb().endTransaction();
                return false;
            }
            if (i10 == 3) {
                getDb().beginTransaction();
                return false;
            }
            if (i10 == 4) {
                getDb().beginTransactionNonExclusive();
                return false;
            }
            if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            getDb().beginTransactionReadOnly();
            return false;
        }

        @Override // i1.InterfaceC4162d
        public void reset() {
            i();
        }
    }

    public /* synthetic */ SupportSQLiteStatement(InterfaceC4756c interfaceC4756c, String str, i iVar) {
        this(interfaceC4756c, str);
    }

    /* renamed from: b, reason: from getter */
    public final InterfaceC4756c getDb() {
        return this.db;
    }

    /* renamed from: e, reason: from getter */
    public final String getSql() {
        return this.sql;
    }

    public final void g(boolean z10) {
        this.isClosed = z10;
    }

    public final void i() {
        if (this.isClosed) {
            C4159a.b(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public SupportSQLiteStatement(InterfaceC4756c interfaceC4756c, String str) {
        this.db = interfaceC4756c;
        this.sql = str;
    }
}
