package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.n0;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@TypeConverters({androidx.work.c.class, androidx.work.impl.model.t.class})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/work/impl/WorkDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Landroidx/work/impl/model/WorkSpecDao;", "L", "()Landroidx/work/impl/model/WorkSpecDao;", "Landroidx/work/impl/model/DependencyDao;", "G", "()Landroidx/work/impl/model/DependencyDao;", "Landroidx/work/impl/model/WorkTagDao;", "M", "()Landroidx/work/impl/model/WorkTagDao;", "Landroidx/work/impl/model/SystemIdInfoDao;", "I", "()Landroidx/work/impl/model/SystemIdInfoDao;", "Landroidx/work/impl/model/WorkNameDao;", "J", "()Landroidx/work/impl/model/WorkNameDao;", "Landroidx/work/impl/model/WorkProgressDao;", "K", "()Landroidx/work/impl/model/WorkProgressDao;", "Landroidx/work/impl/model/PreferenceDao;", "H", "()Landroidx/work/impl/model/PreferenceDao;", "p", "a", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = b.class, to = 15)}, entities = {androidx.work.impl.model.a.class, androidx.work.impl.model.o.class, androidx.work.impl.model.r.class, androidx.work.impl.model.f.class, androidx.work.impl.model.j.class, androidx.work.impl.model.l.class, androidx.work.impl.model.c.class}, version = 16)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class WorkDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f5425p = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ SupportSQLiteOpenHelper a(Context r10, SupportSQLiteOpenHelper.b r11) {
            return c(r10, r11);
        }

        public static final SupportSQLiteOpenHelper c(Context r10, SupportSQLiteOpenHelper.b r11) {
            kotlin.jvm.internal.q.g(r10, "$context");
            kotlin.jvm.internal.q.g(r11, "configuration");
            SupportSQLiteOpenHelper.b.a r12 = SupportSQLiteOpenHelper.b.f4781f.a(r10);
            r12.d(r11.f4783b).c(r11.f4784c).e(true).a(true);
            return new androidx.sqlite.db.framework.d().create(r12.b());
        }

        public final WorkDatabase b(final Context r10, Executor r11, boolean r12) {
            kotlin.jvm.internal.q.g(r10, "context");
            kotlin.jvm.internal.q.g(r11, "queryExecutor");
            if (r12 == false) goto L5;
            RoomDatabase.a r13 = n0.c(r10, WorkDatabase.class).c();
        L7:
            return (WorkDatabase) r13.g(r11).a(c.f5500a).b(new a0.a[]{h.f5623c}).b(new a0.a[]{new r(r10, 2, 3)}).b(new a0.a[]{i.f5624c}).b(new a0.a[]{j.f5625c}).b(new a0.a[]{new r(r10, 5, 6)}).b(new a0.a[]{k.f5626c}).b(new a0.a[]{l.f5627c}).b(new a0.a[]{m.f5628c}).b(new a0.a[]{new d0(r10)}).b(new a0.a[]{new r(r10, 10, 11)}).b(new a0.a[]{e.f5557c}).b(new a0.a[]{f.f5560c}).b(new a0.a[]{g.f5622c}).e().d();
        L5:
            r13 = n0.a(r10, WorkDatabase.class, "androidx.work.workdb").f(new w(r10));
            goto L7
        }

        public a() {
        }
    }

    static {
        f5425p = new a(null);
    }

    public WorkDatabase() {
    }

    public static final WorkDatabase F(Context r10, Executor r11, boolean r12) {
        return f5425p.b(r10, r11, r12);
    }

    public abstract DependencyDao G();

    public abstract PreferenceDao H();

    public abstract SystemIdInfoDao I();

    public abstract WorkNameDao J();

    public abstract WorkProgressDao K();

    public abstract WorkSpecDao L();

    public abstract WorkTagDao M();
}
