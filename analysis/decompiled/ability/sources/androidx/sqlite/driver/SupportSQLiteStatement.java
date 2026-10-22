package androidx.sqlite.driver;

import K7.a;
import android.database.Cursor;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import j9.m;
import j9.t;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00172\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0082\u0001\u0004\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "sql", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "LC7/r;", "throwIfClosed", "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDb", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "Ljava/lang/String;", "getSql", "()Ljava/lang/String;", "", "isClosed", "Z", "()Z", "setClosed", "(Z)V", "Companion", "TransactionSQLiteStatement", "JournalModeSetStatement", "RowSQLiteStatement", "OtherSQLiteStatement", "Landroidx/sqlite/driver/SupportSQLiteStatement$JournalModeSetStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$OtherSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$TransactionSQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SupportSQLiteStatement implements SQLiteStatement {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SupportSQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002¨\u0006\u0018"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion;", "", AppAgent.CONSTRUCT, "()V", "create", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "getTransactionOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "prefix", "getSpecialOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", "isRowStatement", "", "getStatementPrefix", "getStatementPrefix$sqlite_framework", "getStatementPrefixIndex", "", "s", "TransactionOperation", "SpecialOperation", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", "", AppAgent.CONSTRUCT, "()V", "JournalModeOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static abstract class SpecialOperation {

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation;", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", AppAgent.CONSTRUCT, "()V", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class JournalModeOperation extends SpecialOperation {
                public static final JournalModeOperation INSTANCE = new JournalModeOperation();

                private JournalModeOperation() {
                    super(null);
                }
            }

            public /* synthetic */ SpecialOperation(e eVar) {
                this();
            }

            private SpecialOperation() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "END", "ROLLBACK", "BEGIN_EXCLUSIVE", "BEGIN_IMMEDIATE", "BEGIN_DEFERRED", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class TransactionOperation {
            private static final /* synthetic */ a $ENTRIES;
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

            private TransactionOperation(String str, int i) {
            }

            public static a getEntries() {
                return $ENTRIES;
            }

            public static TransactionOperation valueOf(String str) {
                return (TransactionOperation) Enum.valueOf(TransactionOperation.class, str);
            }

            public static TransactionOperation[] values() {
                return (TransactionOperation[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final SpecialOperation getSpecialOperation(String prefix, String sql) {
            if (!k.b(prefix, "PRA")) {
                return null;
            }
            String lowerCase = sql.toLowerCase(Locale.ROOT);
            k.e(lowerCase, "toLowerCase(...)");
            if (m.h0(m.H0(lowerCase, "journal_mode", ""), "=", false)) {
                return SpecialOperation.JournalModeOperation.INSTANCE;
            }
            return null;
        }

        private final int getStatementPrefixIndex(String s5) {
            int i;
            int length = s5.length() - 2;
            if (length < 0) {
                return -1;
            }
            int iP0 = 0;
            while (iP0 < length) {
                char cCharAt = s5.charAt(iP0);
                if (k.g(cCharAt, 32) > 0) {
                    if (cCharAt == '-') {
                        if (s5.charAt(iP0 + 1) == '-') {
                            iP0 = m.p0(s5, '\n', iP0 + 2, 4);
                            if (iP0 < 0) {
                                return -1;
                            }
                        }
                    } else if (cCharAt == '/') {
                        int iP02 = iP0 + 1;
                        if (s5.charAt(iP02) == '*') {
                            do {
                                iP02 = m.p0(s5, '*', iP02 + 1, 4);
                                if (iP02 >= 0) {
                                    i = iP02 + 1;
                                    if (i >= length) {
                                        break;
                                    }
                                } else {
                                    return -1;
                                }
                            } while (s5.charAt(i) != '/');
                            iP0 = iP02 + 2;
                        }
                    }
                    return iP0;
                }
                iP0++;
            }
            return -1;
        }

        private final TransactionOperation getTransactionOperation(String prefix, String sql) {
            switch (prefix.hashCode()) {
                case 65636:
                    if (prefix.equals("BEG")) {
                        return m.h0(sql, "EXCLUSIVE", false) ? TransactionOperation.BEGIN_EXCLUSIVE : m.h0(sql, "IMMEDIATE", false) ? TransactionOperation.BEGIN_IMMEDIATE : TransactionOperation.BEGIN_DEFERRED;
                    }
                    return null;
                case 66913:
                    if (!prefix.equals("COM")) {
                        return null;
                    }
                    break;
                case 68795:
                    if (!prefix.equals("END")) {
                        return null;
                    }
                    break;
                case 81327:
                    if (prefix.equals("ROL") && !m.h0(sql, " TO ", false)) {
                        return TransactionOperation.ROLLBACK;
                    }
                    return null;
                default:
                    return null;
            }
            return TransactionOperation.END;
        }

        private final boolean isRowStatement(String prefix) {
            int iHashCode = prefix.hashCode();
            return iHashCode != 79487 ? iHashCode != 81978 ? iHashCode == 85954 && prefix.equals("WIT") : prefix.equals("SEL") : prefix.equals("PRA");
        }

        public final SupportSQLiteStatement create(SupportSQLiteDatabase db, String sql) {
            k.f(db, "db");
            k.f(sql, "sql");
            String upperCase = m.R0(sql).toString().toUpperCase(Locale.ROOT);
            k.e(upperCase, "toUpperCase(...)");
            String statementPrefix$sqlite_framework = getStatementPrefix$sqlite_framework(upperCase);
            if (statementPrefix$sqlite_framework == null) {
                return new OtherSQLiteStatement(db, sql);
            }
            TransactionOperation transactionOperation = getTransactionOperation(statementPrefix$sqlite_framework, upperCase);
            return transactionOperation != null ? new TransactionSQLiteStatement(db, sql, transactionOperation) : getSpecialOperation(statementPrefix$sqlite_framework, upperCase) instanceof SpecialOperation.JournalModeOperation ? new JournalModeSetStatement(db, sql, new RowSQLiteStatement(db, sql)) : isRowStatement(statementPrefix$sqlite_framework) ? new RowSQLiteStatement(db, sql) : new OtherSQLiteStatement(db, sql);
        }

        @VisibleForTesting
        public final String getStatementPrefix$sqlite_framework(String sql) {
            k.f(sql, "sql");
            int statementPrefixIndex = getStatementPrefixIndex(sql);
            if (statementPrefixIndex < 0 || statementPrefixIndex > sql.length()) {
                return null;
            }
            String strSubstring = sql.substring(statementPrefixIndex, Math.min(statementPrefixIndex + 3, sql.length()));
            k.e(strSubstring, "substring(...)");
            return strSubstring;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0018\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\"\u0010!\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010'\u001a\u00020\u00142\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010)\u001a\u00020\u00172\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010+\u001a\u00020\u001a2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b-\u0010.J\u001a\u0010/\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b3\u00100J\u0010\u00104\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b4\u00105J\u001a\u00106\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b6\u00102J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0096\u0001¢\u0006\u0004\b8\u00109J\u001a\u0010:\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b:\u0010.J\u0010\u0010;\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b=\u0010<J\u0010\u0010>\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b>\u0010<R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010?¨\u0006@"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$JournalModeSetStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "sql", "delegate", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement;)V", "", "step", "()Z", "", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindFloat", "(IF)V", "", "bindLong", "(IJ)V", "bindInt", "(II)V", "bindBoolean", "(IZ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getFloat", "(I)F", "getLong", "(I)J", "getInt", "(I)I", "getBoolean", "(I)Z", "getText", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "", "getColumnNames", "()Ljava/util/List;", "getColumnType", "reset", "()V", "clearBindings", "close", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class JournalModeSetStatement extends SupportSQLiteStatement implements SQLiteStatement {
        private final SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JournalModeSetStatement(SupportSQLiteDatabase db, String sql, SupportSQLiteStatement delegate) {
            super(db, sql, null);
            k.f(db, "db");
            k.f(sql, "sql");
            k.f(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7168bindBlob(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, byte[] value) {
            k.f(value, "value");
            this.delegate.mo7168bindBlob(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindBoolean(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, boolean value) {
            this.delegate.bindBoolean(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7169bindDouble(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, double value) {
            this.delegate.mo7169bindDouble(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindFloat(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, float value) {
            this.delegate.bindFloat(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindInt(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, int value) {
            this.delegate.bindInt(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7170bindLong(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, long value) {
            this.delegate.mo7170bindLong(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7171bindNull(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index) {
            this.delegate.mo7171bindNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7172bindText(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, String value) {
            k.f(value, "value");
            this.delegate.mo7172bindText(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7173clearBindings() {
            this.delegate.mo7173clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getBlob(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean getBoolean(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getBoolean(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getColumnName(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public List<String> getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getColumnType(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getDouble(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public float getFloat(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getFloat(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getInt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getInt(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getLong(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.getText(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
            return this.delegate.isNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            this.delegate.reset();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            boolean zStep = this.delegate.step();
            if (t.X(getText(0), "wal")) {
                getDb().enableWriteAheadLogging();
                return zStep;
            }
            getDb().disableWriteAheadLogging();
            return zStep;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010 J\u0017\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020!H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\fH\u0016¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010,R\u0018\u00101\u001a\u00060/j\u0002`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$OtherSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "sql", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindLong", "(IJ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getLong", "(I)J", "getText", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "getColumnType", "(I)I", "step", "()Z", "reset", "()V", "clearBindings", "close", "Landroidx/sqlite/db/SupportSQLiteStatement;", "Landroidx/sqlite/driver/SupportStatement;", "delegate", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OtherSQLiteStatement extends SupportSQLiteStatement {
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            k.f(db, "db");
            k.f(sql, "sql");
            this.delegate = db.compileStatement(sql);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7168bindBlob(int index, byte[] value) {
            k.f(value, "value");
            throwIfClosed();
            this.delegate.bindBlob(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7169bindDouble(int index, double value) {
            throwIfClosed();
            this.delegate.bindDouble(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7170bindLong(int index, long value) {
            throwIfClosed();
            this.delegate.bindLong(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7171bindNull(int index) {
            throwIfClosed();
            this.delegate.bindNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7172bindText(int index, String value) {
            k.f(value, "value");
            throwIfClosed();
            this.delegate.bindString(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7173clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() throws IOException {
            this.delegate.close();
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u0000 I2\u00020\u0001:\u0001IB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010+J\u0017\u00102\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020,H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010\u000fJ\u000f\u00107\u001a\u00020\u000bH\u0016¢\u0006\u0004\b7\u0010\u000fJ\u000f\u00108\u001a\u00020\u000bH\u0016¢\u0006\u0004\b8\u0010\u000fR\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006J"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "sql", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "", "columnType", "index", "LC7/r;", "ensureCapacity", "(II)V", "ensureCursor", "()V", "Landroid/database/Cursor;", "throwIfNoRow", "()Landroid/database/Cursor;", "c", "throwIfInvalidColumn", "(Landroid/database/Cursor;I)V", "", "value", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindLong", "(IJ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getLong", "(I)J", "getText", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "getColumnType", "(I)I", "step", "()Z", "reset", "clearBindings", "close", "", "bindingTypes", "[I", "", "longBindings", "[J", "", "doubleBindings", "[D", "", "stringBindings", "[Ljava/lang/String;", "blobBindings", "[[B", "cursor", "Landroid/database/Cursor;", "Companion", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RowSQLiteStatement extends SupportSQLiteStatement {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int[] bindingTypes;
        private byte[][] blobBindings;
        private Cursor cursor;
        private double[] doubleBindings;
        private long[] longBindings;
        private String[] stringBindings;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement$Companion;", "", AppAgent.CONSTRUCT, "()V", "getDataType", "", "Landroid/database/Cursor;", "index", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int getDataType(Cursor cursor, int i) {
                int type = cursor.getType(i);
                int type2 = cursor.getType(i);
                if (type2 == 0) {
                    return 5;
                }
                int i6 = 1;
                if (type2 != 1) {
                    i6 = 2;
                    if (type2 != 2) {
                        i6 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            throw new IllegalStateException(("Unknown field type: " + type).toString());
                        }
                    }
                }
                return i6;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RowSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            k.f(db, "db");
            k.f(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void ensureCapacity(int columnType, int index) {
            int i = index + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i);
                k.e(iArrCopyOf, "copyOf(...)");
                this.bindingTypes = iArrCopyOf;
            }
            if (columnType == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i);
                    k.e(jArrCopyOf, "copyOf(...)");
                    this.longBindings = jArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i);
                    k.e(dArrCopyOf, "copyOf(...)");
                    this.doubleBindings = dArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i);
                    k.e(objArrCopyOf, "copyOf(...)");
                    this.stringBindings = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i);
                k.e(objArrCopyOf2, "copyOf(...)");
                this.blobBindings = (byte[][]) objArrCopyOf2;
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.sqlite.driver.SupportSQLiteStatement$RowSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram statement) {
                        k.f(statement, "statement");
                        int length = this.this$0.bindingTypes.length;
                        for (int i = 1; i < length; i++) {
                            int i6 = this.this$0.bindingTypes[i];
                            if (i6 == 1) {
                                statement.bindLong(i, this.this$0.longBindings[i]);
                            } else if (i6 == 2) {
                                statement.bindDouble(i, this.this$0.doubleBindings[i]);
                            } else if (i6 == 3) {
                                String str = this.this$0.stringBindings[i];
                                k.c(str);
                                statement.bindString(i, str);
                            } else if (i6 == 4) {
                                byte[] bArr = this.this$0.blobBindings[i];
                                k.c(bArr);
                                statement.bindBlob(i, bArr);
                            } else if (i6 == 5) {
                                statement.bindNull(i);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        return this.this$0.bindingTypes.length;
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    /* renamed from: getSql */
                    public String getQuery() {
                        return this.this$0.getSql();
                    }
                });
            }
        }

        private final void throwIfInvalidColumn(Cursor c, int index) {
            if (index < 0 || index >= c.getColumnCount()) {
                throw androidx.constraintlayout.core.dsl.a.m(25, "column index out of range");
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            throw androidx.constraintlayout.core.dsl.a.m(21, "no row");
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7168bindBlob(int index, byte[] value) {
            k.f(value, "value");
            throwIfClosed();
            ensureCapacity(4, index);
            this.bindingTypes[index] = 4;
            this.blobBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7169bindDouble(int index, double value) {
            throwIfClosed();
            ensureCapacity(2, index);
            this.bindingTypes[index] = 2;
            this.doubleBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7170bindLong(int index, long value) {
            throwIfClosed();
            ensureCapacity(1, index);
            this.bindingTypes[index] = 1;
            this.longBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7171bindNull(int index) {
            throwIfClosed();
            ensureCapacity(5, index);
            this.bindingTypes[index] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7172bindText(int index, String value) {
            k.f(value, "value");
            throwIfClosed();
            ensureCapacity(3, index);
            this.bindingTypes[index] = 3;
            this.stringBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7173clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!getIsClosed()) {
                mo7173clearBindings();
                reset();
            }
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            byte[] blob = cursorThrowIfNoRow.getBlob(index);
            k.e(blob, "getBlob(...)");
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            throwIfInvalidColumn(cursor, index);
            String columnName = cursor.getColumnName(index);
            k.e(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            throwIfInvalidColumn(cursor, index);
            return INSTANCE.getDataType(cursor, index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.getDouble(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.getLong(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            String string = cursorThrowIfNoRow.getString(index);
            k.e(string, "getString(...)");
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.isNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\"J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\u000eH\u0016¢\u0006\u0004\b0\u0010.R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$TransactionSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "sql", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "operation", AppAgent.CONSTRUCT, "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;)V", "", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindLong", "(IJ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getLong", "(I)J", "getText", "(I)Ljava/lang/String;", "", "isNull", "(I)Z", "getColumnCount", "()I", "getColumnName", "getColumnType", "(I)I", "step", "()Z", "reset", "()V", "clearBindings", "close", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "getOperation", "()Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TransactionSQLiteStatement extends SupportSQLiteStatement {
        private final Companion.TransactionOperation operation;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionSQLiteStatement(SupportSQLiteDatabase db, String sql, Companion.TransactionOperation operation) {
            super(db, sql, null);
            k.f(db, "db");
            k.f(sql, "sql");
            k.f(operation, "operation");
            this.operation = operation;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo7168bindBlob(int index, byte[] value) {
            k.f(value, "value");
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo7169bindDouble(int index, double value) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo7170bindLong(int index, long value) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo7171bindNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo7172bindText(int index, String value) {
            k.f(value, "value");
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo7173clearBindings() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            setClosed(true);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        public final Companion.TransactionOperation getOperation() {
            return this.operation;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            int i = WhenMappings.$EnumSwitchMapping$0[this.operation.ordinal()];
            if (i == 1) {
                getDb().setTransactionSuccessful();
                getDb().endTransaction();
                return false;
            }
            if (i == 2) {
                getDb().endTransaction();
                return false;
            }
            if (i == 3) {
                getDb().beginTransaction();
                return false;
            }
            if (i == 4) {
                getDb().beginTransactionNonExclusive();
                return false;
            }
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            getDb().beginTransactionReadOnly();
            return false;
        }
    }

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, e eVar) {
        this(supportSQLiteDatabase, str);
    }

    public final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    public final String getSql() {
        return this.sql;
    }

    /* renamed from: isClosed, reason: from getter */
    public final boolean getIsClosed() {
        return this.isClosed;
    }

    public final void setClosed(boolean z10) {
        this.isClosed = z10;
    }

    public final void throwIfClosed() {
        if (this.isClosed) {
            throw androidx.constraintlayout.core.dsl.a.m(21, "statement is closed");
        }
    }

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }
}
