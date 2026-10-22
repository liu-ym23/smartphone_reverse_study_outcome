package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: SupportSQLiteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends Closeable {
    g a(String r1);

    void a(int r1);

    void b();

    void b(String r1);

    void c();

    void d();

    int delete(String r1, String r2, Object[] r3);

    void e();

    boolean f();

    boolean g();

    String h();

    boolean i();

    long insert(String r1, int r2, ContentValues r3);

    List<Pair<String, String>> j();

    Cursor query(f r1);

    Cursor query(f r1, CancellationSignal r2);

    Cursor query(String r1);

    Cursor query(String r1, Object[] r2);

    int update(String r1, int r2, ContentValues r3, String r4, Object[] r5);
}
