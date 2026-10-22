package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.f;
import androidx.sqlite.db.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FrameworkSQLiteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
class a implements androidx.sqlite.db.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f2747b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SQLiteDatabase f2748c;

    static {
        f2746a = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        f2747b = new String[0];
    }

    a(SQLiteDatabase r1) {
        this.f2748c = r1;
    }

    @Override // androidx.sqlite.db.c
    public g a(String r2) {
        return new d(this.f2748c.compileStatement(r2));
    }

    @Override // androidx.sqlite.db.c
    public void b() {
        this.f2748c.beginTransaction();
    }

    @Override // androidx.sqlite.db.c
    public void c() {
        this.f2748c.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.c
    public void d() {
        this.f2748c.endTransaction();
    }

    @Override // androidx.sqlite.db.c
    public void e() {
        this.f2748c.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.c
    public boolean f() {
        return this.f2748c.inTransaction();
    }

    @Override // androidx.sqlite.db.c
    public void a(int r1) {
        this.f2748c.setVersion(r1);
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(String r2) {
        return query(new androidx.sqlite.db.a(r2));
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(String r2, Object[] r3) {
        return query(new androidx.sqlite.db.a(r2, r3));
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(f r4) {
        final f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        return this.f2748c.rawQueryWithFactory(new FrameworkSQLiteDatabase$1(this, r5), r5.b(), f2747b, null);
    }

    @Override // androidx.sqlite.db.c
    public Cursor query(f r7, CancellationSignal r8) {
        final f r9 = (f) ZeusTransformUtils.wrapperContextForParams(r7, f.class, "com.obric.aiagent.plugin");
        return androidx.sqlite.db.b.a.a(this.f2748c, r9.b(), f2747b, null, r8, new FrameworkSQLiteDatabase$2(this, r9));
    }

    @Override // androidx.sqlite.db.c
    public long insert(String r2, int r3, ContentValues r4) {
        return this.f2748c.insertWithOnConflict(r2, null, r4, r3);
    }

    @Override // androidx.sqlite.db.c
    public int delete(String r3, String r4, Object[] r5) {
        StringBuilder r6 = new StringBuilder().append("DELETE FROM ").append(r3);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        String r7 = "";
    L6:
        g r2 = a(r6.append(r7).toString());
        androidx.sqlite.db.a.a(r2, r5);
        return r2.a();
    L5:
        r7 = " WHERE " + r4;
        goto L6
    }

    @Override // androidx.sqlite.db.c
    public int update(String r8, int r9, ContentValues r10, String r11, Object[] r12) {
        if (r10 == null) goto L27;
        if (r10.size() == 0) goto L27;
        StringBuilder r0 = new StringBuilder(120);
        r0.append("UPDATE ");
        r0.append(f2746a[r9]);
        r0.append(r8);
        r0.append(" SET ");
        int r13 = r10.size();
        if (r12 != null) goto L8;
        int r14 = r13;
    L9:
        Object[] r1 = new Object[r14];
        int r2 = 0;
        Iterator<String> r3 = r10.keySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (r2 <= 0) goto L15;
        String r5 = ",";
    L16:
        r0.append(r5);
        r0.append(r4);
        r1[r2] = r10.get(r4);
        r0.append("=?");
        r2 = r2 + 1;
        goto L11
    L15:
        r5 = "";
        goto L16
    L17:
        if (r12 == null) goto L22;
        int r15 = r13;
    L19:
        if (r15 >= r14) goto L22;
        r1[r15] = r12[r15 - r13];
        r15 = r15 + 1;
    L22:
        if (TextUtils.isEmpty(r11) == true) goto L24;
        r0.append(" WHERE ");
        r0.append(r11);
    L24:
        g r7 = a(r0.toString());
        androidx.sqlite.db.a.a(r7, r1);
        return r7.a();
    L8:
        r14 = r12.length + r13;
    L27:
        throw new IllegalArgumentException("Empty values");
    }

    @Override // androidx.sqlite.db.c
    public void b(String r1) {
        this.f2748c.execSQL(r1);
    }

    @Override // androidx.sqlite.db.c
    public boolean g() {
        return this.f2748c.isOpen();
    }

    @Override // androidx.sqlite.db.c
    public String h() {
        return this.f2748c.getPath();
    }

    @Override // androidx.sqlite.db.c
    public boolean i() {
        return androidx.sqlite.db.b.a.a(this.f2748c);
    }

    @Override // androidx.sqlite.db.c
    public List<Pair<String, String>> j() {
        return this.f2748c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2748c.close();
    }

    boolean a(SQLiteDatabase r1) {
        if (this.f2748c != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
