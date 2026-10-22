package c0;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class a implements SupportSQLiteQuery {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0068a f6020c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f6022b;

    /* JADX INFO: renamed from: c0.a$a, reason: collision with other inner class name */
    public static final class C0068a {
        public /* synthetic */ C0068a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(SupportSQLiteProgram r10, int r11, Object r12) {
            if (r12 != null) goto L5;
            r10.bindNull(r11);
            return;
        L5:
            if ((r12 instanceof byte[]) == false) goto L8;
            r10.bindBlob(r11, (byte[]) r12);
            return;
        L8:
            if ((r12 instanceof Float) == false) goto L11;
            r10.bindDouble(r11, ((Number) r12).floatValue());
            return;
        L11:
            if ((r12 instanceof Double) == false) goto L14;
            r10.bindDouble(r11, ((Number) r12).doubleValue());
            return;
        L14:
            if ((r12 instanceof Long) == false) goto L17;
            r10.bindLong(r11, ((Number) r12).longValue());
            return;
        L17:
            if ((r12 instanceof Integer) == false) goto L20;
            r10.bindLong(r11, ((Number) r12).intValue());
            return;
        L20:
            if ((r12 instanceof Short) == false) goto L23;
            r10.bindLong(r11, ((Number) r12).shortValue());
            return;
        L23:
            if ((r12 instanceof Byte) == false) goto L26;
            r10.bindLong(r11, ((Number) r12).byteValue());
            return;
        L26:
            if ((r12 instanceof String) == false) goto L29;
            r10.bindString(r11, (String) r12);
            return;
        L29:
            if ((r12 instanceof Boolean) == false) goto L37;
            if (((Boolean) r12).booleanValue() == false) goto L33;
            long r13 = 1;
        L34:
            r10.bindLong(r11, r13);
            return;
        L33:
            r13 = 0;
            goto L34
        L37:
            throw new IllegalArgumentException("Cannot bind " + r12 + " at index " + r11 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(SupportSQLiteProgram r10, Object[] r11) {
            q.g(r10, "statement");
            if (r11 != null) goto L5;
            return;
        L5:
            int r12 = r11.length;
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            Object r14 = r11[r13];
            r13 = r13 + 1;
            a(r10, r13, r14);
            goto L6
        }

        public C0068a() {
        }
    }

    static {
        f6020c = new C0068a(null);
    }

    public a(String r10, Object[] r11) {
        q.g(r10, "query");
        this.f6021a = r10;
        this.f6022b = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r10) {
        q.g(r10, "statement");
        f6020c.b(r10, this.f6022b);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] r10 = this.f6022b;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.f6021a;
    }

    public a(String r10) {
        q.g(r10, "query");
        this(r10, null);
    }
}
