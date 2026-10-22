package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f4510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f4512c;

    public SharedSQLiteStatement(RoomDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "database");
        this.f4510a = r10;
        this.f4511b = new AtomicBoolean(false);
        this.f4512c = kotlin.b.b(new SharedSQLiteStatement$stmt$2(this));
    }

    public static final /* synthetic */ SupportSQLiteStatement a(SharedSQLiteStatement r10) {
        return r10.d();
    }

    public SupportSQLiteStatement b() {
        c();
        return g(this.f4511b.compareAndSet(false, true));
    }

    public void c() {
        this.f4510a.c();
    }

    public final SupportSQLiteStatement d() {
        String r10 = e();
        return this.f4510a.f(r10);
    }

    public abstract String e();

    public final SupportSQLiteStatement f() {
        return (SupportSQLiteStatement) this.f4512c.getValue();
    }

    public final SupportSQLiteStatement g(boolean r10) {
        if (r10 == false) goto L5;
        return f();
    L5:
        return d();
    }

    public void h(SupportSQLiteStatement r10) {
        kotlin.jvm.internal.q.g(r10, "statement");
        if (r10 != f()) goto L6;
        this.f4511b.set(false);
        return;
    }
}
