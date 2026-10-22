package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements PreferenceDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5637b;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f5638d;

        public a(d r10, RoomDatabase r11) {
            this.f5638d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (c) r11);
        }

        public void l(SupportSQLiteStatement r10, c r11) {
            if (r11.a() != null) goto L5;
            r10.bindNull(1);
        L7:
            if (r11.b() != null) goto L9;
            r10.bindNull(2);
            return;
        L9:
            r10.bindLong(2, r11.b().longValue());
            return;
        L5:
            r10.bindString(1, r11.a());
            goto L7
        }
    }

    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f5640b;

        public b(d r10, RoomSQLiteQuery r11) {
            this.f5640b = r10;
            this.f5639a = r11;
        }

        public Long a() {
            Long r10 = null;
            Cursor r11 = b0.b.c(d.a(this.f5640b), this.f5639a, false, null);
        L10:
            th = move-exception;
            r11.close();
            throw th;
        L4:
            if (r11.moveToFirst() == true) goto L6;
        L12:
            r11.close();
            return r10;
        L6:
            if (r11.isNull(0) == true) goto L12;
            r10 = Long.valueOf(r11.getLong(0));     // Catch: Throwable -> L10
            goto L12
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5639a.c();
        }
    }

    public d(RoomDatabase r10) {
        this.f5636a = r10;
        this.f5637b = new a(this, r10);
    }

    public static /* synthetic */ RoomDatabase a(d r10) {
        return r10.f5636a;
    }

    public static List b() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT long_value FROM Preference where `key`=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5636a.d();
        Long r12 = null;
        Cursor r13 = b0.b.c(this.f5636a, r11, false, null);
    L14:
        th = move-exception;
        r13.close();
        r11.c();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L16:
        r13.close();
        r11.c();
        return r12;
    L10:
        if (r13.isNull(0) == true) goto L16;
        r12 = Long.valueOf(r13.getLong(0));     // Catch: Throwable -> L14
        goto L16
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData getObservableLongValue(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT long_value FROM Preference where `key`=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.f5636a.m().e(new String[]{"Preference"}, false, new b(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(c r10) {
        this.f5636a.d();
        this.f5636a.e();
        this.f5637b.j(r10);     // Catch: Throwable -> L6
        this.f5636a.D();     // Catch: Throwable -> L6
        this.f5636a.i();
        return;
    L6:
        th = move-exception;
        this.f5636a.i();
        throw th;
    }
}
