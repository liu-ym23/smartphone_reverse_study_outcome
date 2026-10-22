package com.smt.obric.appstore.domain.app.db;

import android.content.Context;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.n0;
import com.smt.obric.appstore.domain.app.entity.Converters;
import he.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
@TypeConverters({Converters.class})
@Database(autoMigrations = {@AutoMigration(from = 1, to = 2), @AutoMigration(from = 2, to = 3), @AutoMigration(from = 3, to = 4), @AutoMigration(from = 4, to = 5), @AutoMigration(from = 5, to = 6)}, entities = {com.smt.obric.appstore.domain.app.entity.a.class, c.class}, exportSchema = true, version = 6)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/smt/obric/appstore/domain/app/db/AppBD;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/smt/obric/appstore/domain/app/db/AppInstallTaskDAO;", "F", "()Lcom/smt/obric/appstore/domain/app/db/AppInstallTaskDAO;", "Lcom/smt/obric/appstore/domain/app/db/SysAppAutoUpdateTaskInfoDao;", "G", "()Lcom/smt/obric/appstore/domain/app/db/SysAppAutoUpdateTaskInfoDao;", "p", "a", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AppBD extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f17955p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static AppBD f17956q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final AppBD a(Context r10) {
            q.g(r10, "context");
            return (AppBD) n0.a(r10, AppBD.class, "app_db").d();
        }

        public final AppBD b() {
            AppBD r10 = AppBD.f17956q;
            if (r10 == null) goto L5;
            return r10;
        L5:
            q.y("instance");
            return null;
        }

        public final void c(AppBD r10) {
            q.g(r10, "<set-?>");
            AppBD.f17956q = r10;
        }

        public a() {
        }
    }

    static {
        f17955p = new a(null);
    }

    public AppBD() {
    }

    public abstract AppInstallTaskDAO F();

    public abstract SysAppAutoUpdateTaskInfoDao G();
}
