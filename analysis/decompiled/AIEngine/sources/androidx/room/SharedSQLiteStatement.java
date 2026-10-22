package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2522a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2523b;

    /* renamed from: c, reason: collision with root package name */
    public final lb.d f2524c;

    public SharedSQLiteStatement(RoomDatabase database) {
        kotlin.jvm.internal.g.f(database, "database");
        this.f2522a = database;
        this.f2523b = new AtomicBoolean(false);
        this.f2524c = kotlin.b.b(new zb.a<y1.f>() { // from class: androidx.room.SharedSQLiteStatement$stmt$2
            {
                super(0);
            }

            @Override // zb.a
            public final y1.f invoke() {
                return this.f2525a.b();
            }
        });
    }

    public final y1.f a() {
        this.f2522a.a();
        return this.f2523b.compareAndSet(false, true) ? (y1.f) this.f2524c.getValue() : b();
    }

    public final y1.f b() {
        String strC = c();
        RoomDatabase roomDatabase = this.f2522a;
        roomDatabase.getClass();
        roomDatabase.a();
        roomDatabase.b();
        return roomDatabase.h().n0().a0(strC);
    }

    public abstract String c();

    public final void d(y1.f statement) {
        kotlin.jvm.internal.g.f(statement, "statement");
        if (statement == ((y1.f) this.f2524c.getValue())) {
            this.f2523b.set(false);
        }
    }
}
