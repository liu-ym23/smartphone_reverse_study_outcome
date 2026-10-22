package ge;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.j;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.db.SysAppAutoUpdateTaskInfoDao;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements SysAppAutoUpdateTaskInfoDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f20127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f20128b;

    public class a extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f20129d;

        public a(h r10, RoomDatabase r11) {
            this.f20129d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `sys_app_auto_update_task_info` (`id`,`appId`,`taskId`,`updateModel`,`pkg`,`url`,`md5`,`size`,`localVersionCode`,`versionCode`,`versionName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (he.c) r11);
        }

        public void l(SupportSQLiteStatement r10, he.c r11) {
            r10.bindLong(1, r11.b());
            if (r11.a() != null) goto L5;
            r10.bindNull(2);
        L7:
            if (r11.g() != null) goto L9;
            r10.bindNull(3);
        L10:
            r10.bindLong(4, r11.h());
            if (r11.e() != null) goto L13;
            r10.bindNull(5);
        L15:
            if (r11.i() != null) goto L17;
            r10.bindNull(6);
        L19:
            if (r11.d() != null) goto L21;
            r10.bindNull(7);
        L22:
            r10.bindLong(8, r11.f());
            r10.bindLong(9, r11.c());
            r10.bindLong(10, r11.j());
            if (r11.k() != null) goto L25;
            r10.bindNull(11);
            return;
        L25:
            r10.bindString(11, r11.k());
            return;
        L21:
            r10.bindString(7, r11.d());
            goto L22
        L17:
            r10.bindString(6, r11.i());
            goto L19
        L13:
            r10.bindString(5, r11.e());
            goto L15
        L9:
            r10.bindString(3, r11.g());
            goto L10
        L5:
            r10.bindString(2, r11.a());
            goto L7
        }
    }

    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ he.c f20130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f20131b;

        public b(h r10, he.c r11) {
            this.f20131b = r10;
            this.f20130a = r11;
        }

        public Long a() {
            h.a(this.f20131b).e();
            Long r10 = Long.valueOf(h.b(this.f20131b).k(this.f20130a));     // Catch: Throwable -> L6
            h.a(this.f20131b).D();     // Catch: Throwable -> L6
            h.a(this.f20131b).i();
            return r10;
        L6:
            th = move-exception;
            h.a(this.f20131b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f20133b;

        public c(h r10, RoomSQLiteQuery r11) {
            this.f20133b = r10;
            this.f20132a = r11;
        }

        public he.c a() {
            he.c r10 = null;
            String r11 = null;
            Cursor r12 = b0.b.c(h.a(this.f20133b), this.f20132a, false, null);
            int r13 = b0.a.d(r12, "id");     // Catch: Throwable -> L31
            int r14 = b0.a.d(r12, "appId");     // Catch: Throwable -> L31
            int r15 = b0.a.d(r12, "taskId");     // Catch: Throwable -> L31
            int r16 = b0.a.d(r12, "updateModel");     // Catch: Throwable -> L31
            int r17 = b0.a.d(r12, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L31
            int r18 = b0.a.d(r12, "url");     // Catch: Throwable -> L31
            int r19 = b0.a.d(r12, ServerElements.MD5);     // Catch: Throwable -> L31
            int r110 = b0.a.d(r12, "size");     // Catch: Throwable -> L31
            int r111 = b0.a.d(r12, "localVersionCode");     // Catch: Throwable -> L31
            int r112 = b0.a.d(r12, "versionCode");     // Catch: Throwable -> L31
            int r113 = b0.a.d(r12, "versionName");     // Catch: Throwable -> L31
            if (r12.moveToFirst() == false) goto L33;
            long r114 = r12.getLong(r13);     // Catch: Throwable -> L31
            if (r12.isNull(r14) == false) goto L8;
            String r115 = null;
        L10:
            if (r12.isNull(r15) == false) goto L12;
            String r116 = null;
        L13:
            int r20 = r12.getInt(r16);     // Catch: Throwable -> L31
            if (r12.isNull(r17) == false) goto L16;
            String r21 = null;
        L18:
            if (r12.isNull(r18) == false) goto L20;
            String r22 = null;
        L22:
            if (r12.isNull(r19) == false) goto L24;
            String r23 = null;
        L25:
            long r24 = r12.getLong(r110);     // Catch: Throwable -> L31
            long r26 = r12.getLong(r111);     // Catch: Throwable -> L31
            long r28 = r12.getLong(r112);     // Catch: Throwable -> L31
            if (r12.isNull(r113) == true) goto L29;
            r11 = r12.getString(r113);     // Catch: Throwable -> L31
        L29:
            r10 = new he.c(r114, r115, r116, r20, r21, r22, r23, r24, r26, r28, r11);     // Catch: Throwable -> L31
            goto L33
        L24:
            r23 = r12.getString(r19);     // Catch: Throwable -> L31
            goto L25
        L20:
            r22 = r12.getString(r18);     // Catch: Throwable -> L31
            goto L22
        L16:
            r21 = r12.getString(r17);     // Catch: Throwable -> L31
            goto L18
        L12:
            r116 = r12.getString(r15);     // Catch: Throwable -> L31
            goto L13
        L8:
            r115 = r12.getString(r14);     // Catch: Throwable -> L31
        L33:
            r12.close();
            this.f20132a.c();
            return r10;
        L31:
            th = move-exception;
            r12.close();
            this.f20132a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public h(RoomDatabase r10) {
        this.f20127a = r10;
        this.f20128b = new a(this, r10);
    }

    public static /* synthetic */ RoomDatabase a(h r10) {
        return r10.f20127a;
    }

    public static /* synthetic */ j b(h r10) {
        return r10.f20128b;
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.smt.obric.appstore.domain.app.db.SysAppAutoUpdateTaskInfoDao
    public Object getByPkg(String r10, Continuation r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT * FROM sys_app_auto_update_task_info WHERE pkg = ? LIMIT 1", 1);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        CancellationSignal r13 = b0.b.a();
        return CoroutinesRoom.b(this.f20127a, false, r13, new c(this, r12), r11);
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // com.smt.obric.appstore.domain.app.db.SysAppAutoUpdateTaskInfoDao
    public Object upsert(he.c r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20127a, true, new b(this, r10), r11);
    }
}
