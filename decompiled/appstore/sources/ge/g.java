package ge;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.app.entity.Converters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements AppInstallTaskDAO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f20046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f20047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Converters f20048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f20049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f20050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f20051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f20052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f20053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedSQLiteStatement f20054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SharedSQLiteStatement f20055j;

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f20056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f20057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f20058c;

        public a(g r10, long r11, long r12) {
            this.f20058c = r10;
            this.f20056a = r11;
            this.f20057b = r12;
        }

        public Unit a() {
            SupportSQLiteStatement r10 = g.d(this.f20058c).b();
            r10.bindLong(1, this.f20056a);
            r10.bindLong(2, this.f20057b);
            g.b(this.f20058c).e();     // Catch: Throwable -> L8
            r10.executeUpdateDelete();     // Catch: Throwable -> L10
            g.b(this.f20058c).D();     // Catch: Throwable -> L10
            Unit r11 = Unit.f21064a;     // Catch: Throwable -> L10
            g.b(this.f20058c).i();     // Catch: Throwable -> L8
            g.d(this.f20058c).h(r10);
            return r11;
        L10:
            th = move-exception;
            g.b(this.f20058c).i();     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            g.d(this.f20058c).h(r10);
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class a0 implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.smt.obric.appstore.domain.app.entity.a f20059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20060b;

        public a0(g r10, com.smt.obric.appstore.domain.app.entity.a r11) {
            this.f20060b = r10;
            this.f20059a = r11;
        }

        public Long a() {
            g.b(this.f20060b).e();
            Long r10 = Long.valueOf(g.c(this.f20060b).k(this.f20059a));     // Catch: Throwable -> L6
            g.b(this.f20060b).D();     // Catch: Throwable -> L6
            g.b(this.f20060b).i();
            return r10;
        L6:
            th = move-exception;
            g.b(this.f20060b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20062b;

        public b(g r10, String r11) {
            this.f20062b = r10;
            this.f20061a = r11;
        }

        public Unit a() {
            SupportSQLiteStatement r10 = g.e(this.f20062b).b();
            String r11 = this.f20061a;
            if (r11 != null) goto L5;
            r10.bindNull(1);
        L18:
            g.b(this.f20062b).e();     // Catch: Throwable -> L11
            r10.executeUpdateDelete();     // Catch: Throwable -> L13
            g.b(this.f20062b).D();     // Catch: Throwable -> L13
            Unit r12 = Unit.f21064a;     // Catch: Throwable -> L13
            g.b(this.f20062b).i();     // Catch: Throwable -> L11
            g.e(this.f20062b).h(r10);
            return r12;
        L13:
            th = move-exception;
            g.b(this.f20062b).i();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            g.e(this.f20062b).h(r10);
            throw th;
        L5:
            r10.bindString(1, r11);
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f20064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f20065c;

        public c(g r10, boolean r11, String r12) {
            this.f20065c = r10;
            this.f20063a = r11;
            this.f20064b = r12;
        }

        public Unit a() {
            SupportSQLiteStatement r10 = g.f(this.f20065c).b();
            r10.bindLong(1, this.f20063a ? 1 : 0);
            String r11 = this.f20064b;
            if (r11 != null) goto L5;
            r10.bindNull(2);
        L18:
            g.b(this.f20065c).e();     // Catch: Throwable -> L11
            r10.executeUpdateDelete();     // Catch: Throwable -> L13
            g.b(this.f20065c).D();     // Catch: Throwable -> L13
            Unit r12 = Unit.f21064a;     // Catch: Throwable -> L13
            g.b(this.f20065c).i();     // Catch: Throwable -> L11
            g.f(this.f20065c).h(r10);
            return r12;
        L13:
            th = move-exception;
            g.b(this.f20065c).i();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            g.f(this.f20065c).h(r10);
            throw th;
        L5:
            r10.bindString(2, r11);
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class d implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20067b;

        public d(g r10, String r11) {
            this.f20067b = r10;
            this.f20066a = r11;
        }

        public Integer a() {
            SupportSQLiteStatement r10 = g.g(this.f20067b).b();
            String r11 = this.f20066a;
            if (r11 != null) goto L5;
            r10.bindNull(1);
        L18:
            g.b(this.f20067b).e();     // Catch: Throwable -> L11
            Integer r12 = Integer.valueOf(r10.executeUpdateDelete());     // Catch: Throwable -> L13
            g.b(this.f20067b).D();     // Catch: Throwable -> L13
            g.b(this.f20067b).i();     // Catch: Throwable -> L11
            g.g(this.f20067b).h(r10);
            return r12;
        L13:
            th = move-exception;
            g.b(this.f20067b).i();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            g.g(this.f20067b).h(r10);
            throw th;
        L5:
            r10.bindString(1, r11);
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class e implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStatus f20068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f20069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f20070c;

        public e(g r10, AppStatus r11, String r12) {
            this.f20070c = r10;
            this.f20068a = r11;
            this.f20069b = r12;
        }

        public Integer a() {
            SupportSQLiteStatement r10 = g.h(this.f20070c).b();
            r10.bindLong(1, g.a(this.f20070c).e(this.f20068a));
            String r11 = this.f20069b;
            if (r11 != null) goto L5;
            r10.bindNull(2);
        L18:
            g.b(this.f20070c).e();     // Catch: Throwable -> L11
            Integer r12 = Integer.valueOf(r10.executeUpdateDelete());     // Catch: Throwable -> L13
            g.b(this.f20070c).D();     // Catch: Throwable -> L13
            g.b(this.f20070c).i();     // Catch: Throwable -> L11
            g.h(this.f20070c).h(r10);
            return r12;
        L13:
            th = move-exception;
            g.b(this.f20070c).i();     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            g.h(this.f20070c).h(r10);
            throw th;
        L5:
            r10.bindString(2, r11);
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class f implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppStatus f20071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f20072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f20073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f20074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f20075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f20076f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f20077g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f20078h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Float f20079i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f20080j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f20081k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ g f20082l;

        public f(g r10, AppStatus r11, Long r12, Long r13, String r14, float r15, String r16, long r17, long r18, Float r19, String r110, long r111) {
            this.f20082l = r10;
            this.f20071a = r11;
            this.f20072b = r12;
            this.f20073c = r13;
            this.f20074d = r14;
            this.f20075e = r15;
            this.f20076f = r16;
            this.f20077g = r17;
            this.f20078h = r18;
            this.f20079i = r19;
            this.f20080j = r110;
            this.f20081k = r111;
        }

        public Integer a() {
            SupportSQLiteStatement r10 = g.i(this.f20082l).b();
            r10.bindLong(1, g.a(this.f20082l).e(this.f20071a));
            Long r11 = this.f20072b;
            if (r11 != null) goto L5;
            r10.bindNull(2);
        L6:
            Long r12 = this.f20073c;
            if (r12 != null) goto L9;
            r10.bindNull(3);
        L10:
            String r13 = this.f20074d;
            if (r13 != null) goto L13;
            r10.bindNull(4);
        L14:
            r10.bindDouble(5, this.f20075e);
            String r14 = this.f20076f;
            if (r14 != null) goto L17;
            r10.bindNull(6);
        L18:
            r10.bindLong(7, this.f20077g);
            r10.bindLong(8, this.f20078h);
            Float r15 = this.f20079i;
            if (r15 != null) goto L21;
            r10.bindNull(9);
        L22:
            String r16 = this.f20080j;
            if (r16 != null) goto L25;
            r10.bindNull(10);
        L26:
            r10.bindLong(11, this.f20081k);
            g.b(this.f20082l).e();     // Catch: Throwable -> L32
            Integer r17 = Integer.valueOf(r10.executeUpdateDelete());     // Catch: Throwable -> L34
            g.b(this.f20082l).D();     // Catch: Throwable -> L34
            g.b(this.f20082l).i();     // Catch: Throwable -> L32
            g.i(this.f20082l).h(r10);
            return r17;
        L34:
            th = move-exception;
            g.b(this.f20082l).i();     // Catch: Throwable -> L32
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            g.i(this.f20082l).h(r10);
            throw th;
        L25:
            r10.bindString(10, r16);
            goto L26
        L21:
            r10.bindDouble(9, r15.floatValue());
            goto L22
        L17:
            r10.bindString(6, r14);
            goto L18
        L13:
            r10.bindString(4, r13);
            goto L14
        L9:
            r10.bindLong(3, r12.longValue());
            goto L10
        L5:
            r10.bindLong(2, r11.longValue());
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    /* JADX INFO: renamed from: ge.g$g, reason: collision with other inner class name */
    public class CallableC0260g implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f20083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppStatus f20084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f20085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f20086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f20087e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f20088f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20089g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f20090h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f20091i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Float f20092j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f20093k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f20094l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f20095m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g f20096n;

        public CallableC0260g(g r10, long r11, AppStatus r12, Long r13, Long r14, String r15, float r16, String r17, long r18, long r19, Float r110, String r111, String r112, long r20) {
            this.f20096n = r10;
            this.f20083a = r11;
            this.f20084b = r12;
            this.f20085c = r13;
            this.f20086d = r14;
            this.f20087e = r15;
            this.f20088f = r16;
            this.f20089g = r17;
            this.f20090h = r18;
            this.f20091i = r19;
            this.f20092j = r110;
            this.f20093k = r111;
            this.f20094l = r112;
            this.f20095m = r20;
        }

        public Integer a() {
            SupportSQLiteStatement r10 = g.j(this.f20096n).b();
            r10.bindLong(1, this.f20083a);
            r10.bindLong(2, g.a(this.f20096n).e(this.f20084b));
            Long r11 = this.f20085c;
            if (r11 != null) goto L5;
            r10.bindNull(3);
        L6:
            Long r12 = this.f20086d;
            if (r12 != null) goto L9;
            r10.bindNull(4);
        L10:
            String r13 = this.f20087e;
            if (r13 != null) goto L13;
            r10.bindNull(5);
        L14:
            r10.bindDouble(6, this.f20088f);
            String r14 = this.f20089g;
            if (r14 != null) goto L17;
            r10.bindNull(7);
        L18:
            r10.bindLong(8, this.f20090h);
            r10.bindLong(9, this.f20091i);
            Float r15 = this.f20092j;
            if (r15 != null) goto L21;
            r10.bindNull(10);
        L22:
            String r16 = this.f20093k;
            if (r16 != null) goto L25;
            r10.bindNull(11);
        L26:
            String r17 = this.f20094l;
            if (r17 != null) goto L29;
            r10.bindNull(12);
        L30:
            r10.bindLong(13, this.f20095m);
            g.b(this.f20096n).e();     // Catch: Throwable -> L36
            Integer r18 = Integer.valueOf(r10.executeUpdateDelete());     // Catch: Throwable -> L38
            g.b(this.f20096n).D();     // Catch: Throwable -> L38
            g.b(this.f20096n).i();     // Catch: Throwable -> L36
            g.j(this.f20096n).h(r10);
            return r18;
        L38:
            th = move-exception;
            g.b(this.f20096n).i();     // Catch: Throwable -> L36
            throw th;     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            g.j(this.f20096n).h(r10);
            throw th;
        L29:
            r10.bindString(12, r17);
            goto L30
        L25:
            r10.bindString(11, r16);
            goto L26
        L21:
            r10.bindDouble(10, r15.floatValue());
            goto L22
        L17:
            r10.bindString(7, r14);
            goto L18
        L13:
            r10.bindString(5, r13);
            goto L14
        L9:
            r10.bindLong(4, r12.longValue());
            goto L10
        L5:
            r10.bindLong(3, r11.longValue());
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class h implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20098b;

        public h(g r10, RoomSQLiteQuery r11) {
            this.f20098b = r10;
            this.f20097a = r11;
        }

        public com.smt.obric.appstore.domain.app.entity.a a() {
            Cursor r10 = b0.b.c(g.b(this.f20098b), this.f20097a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L99
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L99
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L99
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L99
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L99
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L99
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L99
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L99
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L99
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L99
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L99
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L99
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L99
            int r21 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L99
            int r22 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L99
            int r23 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L99
            int r24 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L99
            int r25 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L99
            int r26 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L99
            int r27 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L99
            int r28 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L99
            int r29 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L99
            int r30 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L99
            int r31 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L99
            int r32 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L99
            int r33 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L99
            int r34 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L99
            int r35 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L99
            int r36 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L99
            int r37 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L99
            int r38 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L99
            int r39 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L99
            int r40 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L99
            int r41 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L99
            if (r10.moveToFirst() == false) goto L101;
            long r310 = r10.getLong(r11);     // Catch: Throwable -> L99
            if (r10.isNull(r12) == false) goto L8;
            String r42 = null;
        L9:
            long r43 = r10.getLong(r13);     // Catch: Throwable -> L99
            if (r10.isNull(r14) == false) goto L12;
            String r44 = null;
        L14:
            if (r10.isNull(r15) == false) goto L16;
            String r45 = null;
        L17:
            AppStatus r46 = g.a(this.f20098b).b(r10.getInt(r16));     // Catch: Throwable -> L99
            if (r10.isNull(r17) == false) goto L20;
            String r47 = null;
        L22:
            if (r10.isNull(r18) == false) goto L24;
            String r48 = null;
        L26:
            if (r10.getInt(r19) == 0) goto L28;
            boolean r49 = true;
        L30:
            if (r10.getInt(r110) == 0) goto L32;
            boolean r410 = true;
        L34:
            if (r10.getInt(r111) == 0) goto L36;
            boolean r50 = true;
        L38:
            if (r10.getInt(r112) == 0) goto L40;
            boolean r51 = true;
        L42:
            if (r10.isNull(r20) == false) goto L44;
            String r52 = null;
        L46:
            if (r10.isNull(r16) == false) goto L48;
            String r53 = null;
        L49:
            List r54 = g.a(this.f20098b).c(r53);     // Catch: Throwable -> L99
            if (r10.isNull(r22) == false) goto L52;
            Long r55 = null;
        L54:
            if (r10.isNull(r18) == false) goto L56;
            Long r56 = null;
        L58:
            if (r10.isNull(r19) == false) goto L60;
            Long r57 = null;
        L62:
            if (r10.isNull(r20) == false) goto L64;
            String r58 = null;
        L65:
            float r59 = r10.getFloat(r26);     // Catch: Throwable -> L99
            if (r10.isNull(r27) == false) goto L68;
            String r510 = null;
        L69:
            long r60 = r10.getLong(r28);     // Catch: Throwable -> L99
            long r62 = r10.getLong(r29);     // Catch: Throwable -> L99
            if (r10.isNull(r30) == false) goto L72;
            Float r64 = null;
        L74:
            if (r10.isNull(r26) == false) goto L76;
            String r65 = null;
        L77:
            int r66 = r10.getInt(r32);     // Catch: Throwable -> L99
            int r67 = r10.getInt(r33);     // Catch: Throwable -> L99
            int r68 = r10.getInt(r34);     // Catch: Throwable -> L99
            AppInstallMode r69 = g.a(this.f20098b).a(r10.getInt(r35));     // Catch: Throwable -> L99
            if (r10.isNull(r36) == false) goto L80;
            Integer r70 = null;
        L82:
            if (r10.isNull(r32) == false) goto L84;
            String r71 = null;
        L86:
            if (r10.isNull(r33) == false) goto L88;
            String r72 = null;
        L89:
            long r73 = r10.getLong(r39);     // Catch: Throwable -> L99
            if (r10.getInt(r40) == 0) goto L92;
            boolean r75 = true;
        L94:
            if (r10.isNull(r41) == false) goto L96;
            String r76 = null;
        L97:
            com.smt.obric.appstore.domain.app.entity.a r61 = new com.smt.obric.appstore.domain.app.entity.a(r310, r42, r43, r44, r45, r46, r47, r48, r49, r410, r50, r51, r52, r54, r55, r56, r57, r58, r59, r510, r60, r62, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r76);     // Catch: Throwable -> L99
        L102:
            r10.close();
            this.f20097a.c();
            return r61;
        L96:
            r76 = r10.getString(r41);     // Catch: Throwable -> L99
            goto L97
        L92:
            r75 = false;
            goto L94
        L88:
            r72 = r10.getString(r38);     // Catch: Throwable -> L99
            goto L89
        L84:
            r71 = r10.getString(r37);     // Catch: Throwable -> L99
            goto L86
        L80:
            r70 = Integer.valueOf(r10.getInt(r36));     // Catch: Throwable -> L99
            goto L82
        L76:
            r65 = r10.getString(r31);     // Catch: Throwable -> L99
            goto L77
        L72:
            r64 = Float.valueOf(r10.getFloat(r30));     // Catch: Throwable -> L99
            goto L74
        L68:
            r510 = r10.getString(r27);     // Catch: Throwable -> L99
            goto L69
        L64:
            r58 = r10.getString(r25);     // Catch: Throwable -> L99
            goto L65
        L60:
            r57 = Long.valueOf(r10.getLong(r24));     // Catch: Throwable -> L99
            goto L62
        L56:
            r56 = Long.valueOf(r10.getLong(r23));     // Catch: Throwable -> L99
            goto L58
        L52:
            r55 = Long.valueOf(r10.getLong(r22));     // Catch: Throwable -> L99
            goto L54
        L48:
            r53 = r10.getString(r21);     // Catch: Throwable -> L99
            goto L49
        L44:
            r52 = r10.getString(r20);     // Catch: Throwable -> L99
            goto L46
        L40:
            r51 = false;
            goto L42
        L36:
            r50 = false;
            goto L38
        L32:
            r410 = false;
            goto L34
        L28:
            r49 = false;
            goto L30
        L24:
            r48 = r10.getString(r18);     // Catch: Throwable -> L99
            goto L26
        L20:
            r47 = r10.getString(r17);     // Catch: Throwable -> L99
            goto L22
        L16:
            r45 = r10.getString(r15);     // Catch: Throwable -> L99
            goto L17
        L12:
            r44 = r10.getString(r14);     // Catch: Throwable -> L99
            goto L14
        L8:
            r42 = r10.getString(r12);     // Catch: Throwable -> L99
            goto L9
        L101:
            r61 = null;
        L99:
            th = move-exception;
            r10.close();
            this.f20097a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class i implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20100b;

        public i(g r10, RoomSQLiteQuery r11) {
            this.f20100b = r10;
            this.f20099a = r11;
        }

        public List a() {
            i r10 = this;
            Cursor r11 = b0.b.c(g.b(r10.f20100b), r10.f20099a, false, null);
            int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L100
            int r13 = b0.a.d(r11, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r14 = b0.a.d(r11, "version_code");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r11, "app_name");     // Catch: Throwable -> L100
            int r16 = b0.a.d(r11, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r17 = b0.a.d(r11, "status");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r11, "apk_file_path");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r11, "expected_md5");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r11, "is_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r11, "is_auto_update");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r11, "download_wifi_required");     // Catch: Throwable -> L100
            int r113 = b0.a.d(r11, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r11, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r11, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r115 = b0.a.d(r11, "download_id");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r11, "download_status");     // Catch: Throwable -> L100
            int r117 = b0.a.d(r11, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r11, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r11, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r11, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r11, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r11, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r11, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r11, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r11, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r11, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r11, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r11, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r11, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r11, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r11, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r11, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r11, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r11, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r11.getCount());     // Catch: Throwable -> L100
        L4:
            if (r11.moveToNext() == false) goto L102;
            long r39 = r11.getLong(r12);     // Catch: Throwable -> L100
            if (r11.isNull(r13) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r11.getLong(r14);     // Catch: Throwable -> L100
            if (r11.isNull(r15) == false) goto L13;
            String r44 = null;
        L15:
            if (r11.isNull(r16) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r11.getInt(r17);     // Catch: Throwable -> L100
            int r78 = r12;
            AppStatus r46 = g.a(r10.f20100b).b(r40);     // Catch: Throwable -> L100
            if (r11.isNull(r18) == false) goto L21;
            String r47 = null;
        L23:
            if (r11.isNull(r19) == false) goto L25;
            String r48 = null;
        L27:
            if (r11.getInt(r110) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r11.getInt(r111) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r11.getInt(r112) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r11.getInt(r113) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r11.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r11.isNull(r114) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(r10.f20100b).c(r43);     // Catch: Throwable -> L100
            r115 = r115;
            if (r11.isNull(r115) == false) goto L53;
            Long r55 = null;
        L55:
            if (r11.isNull(r116) == false) goto L57;
            Long r56 = null;
        L59:
            if (r11.isNull(r117) == false) goto L61;
            Long r57 = null;
        L63:
            if (r11.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r11.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r11.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r11.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r11.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r11.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r11.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r11.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r11.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r11.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r116 = r116;
            int r70 = r30;
            int r71 = r11.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(r10.f20100b).a(r71);     // Catch: Throwable -> L100
            int r73 = r31;
            if (r11.isNull(r73) == false) goto L81;
            Integer r74 = null;
        L83:
            if (r11.isNull(r32) == false) goto L85;
            String r75 = null;
        L87:
            if (r11.isNull(r33) == false) goto L89;
            String r76 = null;
        L90:
            long r77 = r11.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r79 = r35;
            int r310 = r11.getInt(r79);     // Catch: Throwable -> L100
            r35 = r79;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r710 = true;
        L95:
            if (r11.isNull(r36) == false) goto L97;
            String r711 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r74, r75, r76, r77, r710, r711));     // Catch: Throwable -> L100
            r10 = this;
            r31 = r73;
            r32 = r32;
            r114 = r114;
            r12 = r78;
            r37 = r37;
            goto L4
        L97:
            r711 = r11.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r710 = false;
            goto L95
        L89:
            r76 = r11.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r75 = r11.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r74 = Integer.valueOf(r11.getInt(r73));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r11.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r11.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r11.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r11.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r11.getLong(r117));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r11.getLong(r116));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r11.getLong(r115));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r11.getString(r114);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r11.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r11.getString(r19);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r11.getString(r18);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r11.getString(r16);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r11.getString(r15);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r11.getString(r13);     // Catch: Throwable -> L100
            goto L10
        L102:
            r11.close();
            return r38;
        L100:
            th = move-exception;
            r11.close();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f20099a.c();
        }
    }

    public class j implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20102b;

        public j(g r10, RoomSQLiteQuery r11) {
            this.f20102b = r10;
            this.f20101a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(g.b(this.f20102b), this.f20101a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L100
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L100
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L100
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r113 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L100
            int r115 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r10.getCount());     // Catch: Throwable -> L100
        L4:
            if (r10.moveToNext() == false) goto L102;
            long r39 = r10.getLong(r11);     // Catch: Throwable -> L100
            if (r10.isNull(r12) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r10.getLong(r13);     // Catch: Throwable -> L100
            if (r10.isNull(r14) == false) goto L13;
            String r44 = null;
        L15:
            if (r10.isNull(r15) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r10.getInt(r16);     // Catch: Throwable -> L100
            int r78 = r11;
            AppStatus r46 = g.a(this.f20102b).b(r40);     // Catch: Throwable -> L100
            if (r10.isNull(r17) == false) goto L21;
            String r47 = null;
        L23:
            if (r10.isNull(r18) == false) goto L25;
            String r48 = null;
        L27:
            if (r10.getInt(r19) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r10.getInt(r110) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r10.getInt(r111) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r10.getInt(r112) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r10.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r10.isNull(r113) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(this.f20102b).c(r43);     // Catch: Throwable -> L100
            r114 = r114;
            if (r10.isNull(r114) == false) goto L53;
            Long r55 = null;
        L55:
            if (r10.isNull(r115) == false) goto L57;
            Long r56 = null;
        L59:
            if (r10.isNull(r116) == false) goto L61;
            Long r57 = null;
        L63:
            if (r10.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r10.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r10.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r10.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r10.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r10.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r10.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r10.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r10.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r115 = r115;
            int r70 = r30;
            int r71 = r10.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(this.f20102b).a(r71);     // Catch: Throwable -> L100
            r31 = r31;
            if (r10.isNull(r31) == false) goto L81;
            Integer r73 = null;
        L83:
            if (r10.isNull(r32) == false) goto L85;
            String r74 = null;
        L87:
            if (r10.isNull(r33) == false) goto L89;
            String r75 = null;
        L90:
            long r76 = r10.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r77 = r35;
            int r310 = r10.getInt(r77);     // Catch: Throwable -> L100
            r35 = r77;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r79 = true;
        L95:
            if (r10.isNull(r36) == false) goto L97;
            String r710 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r73, r74, r75, r76, r79, r710));     // Catch: Throwable -> L100
            r32 = r32;
            r113 = r113;
            r11 = r78;
            r37 = r37;
            goto L4
        L97:
            r710 = r10.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r79 = false;
            goto L95
        L89:
            r75 = r10.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r74 = r10.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r73 = Integer.valueOf(r10.getInt(r31));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r10.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r10.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r10.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r10.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r10.getLong(r116));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r10.getLong(r115));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r10.getLong(r114));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r10.getString(r113);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r10.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r10.getString(r18);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r10.getString(r17);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r10.getString(r15);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r10.getString(r14);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r10.getString(r12);     // Catch: Throwable -> L100
            goto L10
        L102:
            r10.close();
            this.f20101a.c();
            return r38;
        L100:
            th = move-exception;
            r10.close();
            this.f20101a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class k extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20103d;

        public k(g r10, RoomDatabase r11) {
            this.f20103d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `app_install_task` (`id`,`pkg`,`version_code`,`app_name`,`icon_url`,`status`,`apk_file_path`,`expected_md5`,`is_update`,`is_auto_update`,`download_wifi_required`,`download_wait_wifi`,`download_url`,`download_url_backups`,`download_id`,`download_status`,`download_error_code`,`download_error_message`,`download_progress`,`download_file_path`,`cur_bytes`,`total_bytes`,`download_speed`,`download_modified_time`,`update_mode`,`compliance_mode`,`install_flag`,`install_mode`,`install_result_code`,`business_extra`,`debug_extra`,`created_at`,`force_install`,`sha256`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (com.smt.obric.appstore.domain.app.entity.a) r11);
        }

        public void l(SupportSQLiteStatement r10, com.smt.obric.appstore.domain.app.entity.a r11) {
            r10.bindLong(1, r11.A());
            if (r11.E() != null) goto L5;
            r10.bindNull(2);
        L6:
            r10.bindLong(3, r11.J());
            if (r11.f() != null) goto L9;
            r10.bindNull(4);
        L11:
            if (r11.z() != null) goto L13;
            r10.bindNull(5);
        L14:
            r10.bindLong(6, g.a(this.f20103d).e(r11.G()));
            if (r11.e() != null) goto L17;
            r10.bindNull(7);
        L19:
            if (r11.x() != null) goto L21;
            r10.bindNull(8);
        L22:
            r10.bindLong(9, r11.O() ? 1 : 0);
            r10.bindLong(10, r11.L() ? 1 : 0);
            r10.bindLong(11, r11.w() ? 1 : 0);
            r10.bindLong(12, r11.v() ? 1 : 0);
            if (r11.t() != null) goto L25;
            r10.bindNull(13);
        L26:
            String r12 = g.a(this.f20103d).f(r11.u());
            if (r12 != null) goto L29;
            r10.bindNull(14);
        L31:
            if (r11.o() != null) goto L33;
            r10.bindNull(15);
        L35:
            if (r11.s() != null) goto L37;
            r10.bindNull(16);
        L39:
            if (r11.l() != null) goto L41;
            r10.bindNull(17);
        L43:
            if (r11.m() != null) goto L45;
            r10.bindNull(18);
        L46:
            r10.bindDouble(19, r11.q());
            if (r11.n() != null) goto L49;
            r10.bindNull(20);
        L50:
            r10.bindLong(21, r11.j());
            r10.bindLong(22, r11.H());
            if (r11.r() != null) goto L53;
            r10.bindNull(23);
        L55:
            if (r11.p() != null) goto L57;
            r10.bindNull(24);
        L58:
            r10.bindLong(25, r11.I());
            r10.bindLong(26, r11.h());
            r10.bindLong(27, r11.B());
            r10.bindLong(28, g.a(this.f20103d).d(r11.C()));
            if (r11.D() != null) goto L61;
            r10.bindNull(29);
        L63:
            if (r11.g() != null) goto L65;
            r10.bindNull(30);
        L67:
            if (r11.k() != null) goto L69;
            r10.bindNull(31);
        L70:
            r10.bindLong(32, r11.i());
            r10.bindLong(33, r11.y() ? 1 : 0);
            if (r11.F() != null) goto L73;
            r10.bindNull(34);
            return;
        L73:
            r10.bindString(34, r11.F());
            return;
        L69:
            r10.bindString(31, r11.k());
            goto L70
        L65:
            r10.bindString(30, r11.g());
            goto L67
        L61:
            r10.bindLong(29, r11.D().intValue());
            goto L63
        L57:
            r10.bindString(24, r11.p());
            goto L58
        L53:
            r10.bindDouble(23, r11.r().floatValue());
            goto L55
        L49:
            r10.bindString(20, r11.n());
            goto L50
        L45:
            r10.bindString(18, r11.m());
            goto L46
        L41:
            r10.bindLong(17, r11.l().longValue());
            goto L43
        L37:
            r10.bindLong(16, r11.s().longValue());
            goto L39
        L33:
            r10.bindLong(15, r11.o().longValue());
            goto L35
        L29:
            r10.bindString(14, r12);
            goto L31
        L25:
            r10.bindString(13, r11.t());
            goto L26
        L21:
            r10.bindString(8, r11.x());
            goto L22
        L17:
            r10.bindString(7, r11.e());
            goto L19
        L13:
            r10.bindString(5, r11.z());
            goto L14
        L9:
            r10.bindString(4, r11.f());
            goto L11
        L5:
            r10.bindString(2, r11.E());
            goto L6
        }
    }

    public class l implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20105b;

        public l(g r10, RoomSQLiteQuery r11) {
            this.f20105b = r10;
            this.f20104a = r11;
        }

        public com.smt.obric.appstore.domain.app.entity.a a() {
            Cursor r10 = b0.b.c(g.b(this.f20105b), this.f20104a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L99
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L99
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L99
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L99
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L99
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L99
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L99
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L99
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L99
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L99
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L99
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L99
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L99
            int r21 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L99
            int r22 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L99
            int r23 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L99
            int r24 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L99
            int r25 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L99
            int r26 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L99
            int r27 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L99
            int r28 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L99
            int r29 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L99
            int r30 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L99
            int r31 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L99
            int r32 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L99
            int r33 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L99
            int r34 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L99
            int r35 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L99
            int r36 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L99
            int r37 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L99
            int r38 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L99
            int r39 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L99
            int r40 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L99
            int r41 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L99
            if (r10.moveToFirst() == false) goto L101;
            long r310 = r10.getLong(r11);     // Catch: Throwable -> L99
            if (r10.isNull(r12) == false) goto L8;
            String r42 = null;
        L9:
            long r43 = r10.getLong(r13);     // Catch: Throwable -> L99
            if (r10.isNull(r14) == false) goto L12;
            String r44 = null;
        L14:
            if (r10.isNull(r15) == false) goto L16;
            String r45 = null;
        L17:
            AppStatus r46 = g.a(this.f20105b).b(r10.getInt(r16));     // Catch: Throwable -> L99
            if (r10.isNull(r17) == false) goto L20;
            String r47 = null;
        L22:
            if (r10.isNull(r18) == false) goto L24;
            String r48 = null;
        L26:
            if (r10.getInt(r19) == 0) goto L28;
            boolean r49 = true;
        L30:
            if (r10.getInt(r110) == 0) goto L32;
            boolean r410 = true;
        L34:
            if (r10.getInt(r111) == 0) goto L36;
            boolean r50 = true;
        L38:
            if (r10.getInt(r112) == 0) goto L40;
            boolean r51 = true;
        L42:
            if (r10.isNull(r20) == false) goto L44;
            String r52 = null;
        L46:
            if (r10.isNull(r16) == false) goto L48;
            String r53 = null;
        L49:
            List r54 = g.a(this.f20105b).c(r53);     // Catch: Throwable -> L99
            if (r10.isNull(r22) == false) goto L52;
            Long r55 = null;
        L54:
            if (r10.isNull(r18) == false) goto L56;
            Long r56 = null;
        L58:
            if (r10.isNull(r19) == false) goto L60;
            Long r57 = null;
        L62:
            if (r10.isNull(r20) == false) goto L64;
            String r58 = null;
        L65:
            float r59 = r10.getFloat(r26);     // Catch: Throwable -> L99
            if (r10.isNull(r27) == false) goto L68;
            String r510 = null;
        L69:
            long r60 = r10.getLong(r28);     // Catch: Throwable -> L99
            long r62 = r10.getLong(r29);     // Catch: Throwable -> L99
            if (r10.isNull(r30) == false) goto L72;
            Float r64 = null;
        L74:
            if (r10.isNull(r26) == false) goto L76;
            String r65 = null;
        L77:
            int r66 = r10.getInt(r32);     // Catch: Throwable -> L99
            int r67 = r10.getInt(r33);     // Catch: Throwable -> L99
            int r68 = r10.getInt(r34);     // Catch: Throwable -> L99
            AppInstallMode r69 = g.a(this.f20105b).a(r10.getInt(r35));     // Catch: Throwable -> L99
            if (r10.isNull(r36) == false) goto L80;
            Integer r70 = null;
        L82:
            if (r10.isNull(r32) == false) goto L84;
            String r71 = null;
        L86:
            if (r10.isNull(r33) == false) goto L88;
            String r72 = null;
        L89:
            long r73 = r10.getLong(r39);     // Catch: Throwable -> L99
            if (r10.getInt(r40) == 0) goto L92;
            boolean r75 = true;
        L94:
            if (r10.isNull(r41) == false) goto L96;
            String r76 = null;
        L97:
            com.smt.obric.appstore.domain.app.entity.a r61 = new com.smt.obric.appstore.domain.app.entity.a(r310, r42, r43, r44, r45, r46, r47, r48, r49, r410, r50, r51, r52, r54, r55, r56, r57, r58, r59, r510, r60, r62, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r76);     // Catch: Throwable -> L99
        L102:
            r10.close();
            return r61;
        L96:
            r76 = r10.getString(r41);     // Catch: Throwable -> L99
            goto L97
        L92:
            r75 = false;
            goto L94
        L88:
            r72 = r10.getString(r38);     // Catch: Throwable -> L99
            goto L89
        L84:
            r71 = r10.getString(r37);     // Catch: Throwable -> L99
            goto L86
        L80:
            r70 = Integer.valueOf(r10.getInt(r36));     // Catch: Throwable -> L99
            goto L82
        L76:
            r65 = r10.getString(r31);     // Catch: Throwable -> L99
            goto L77
        L72:
            r64 = Float.valueOf(r10.getFloat(r30));     // Catch: Throwable -> L99
            goto L74
        L68:
            r510 = r10.getString(r27);     // Catch: Throwable -> L99
            goto L69
        L64:
            r58 = r10.getString(r25);     // Catch: Throwable -> L99
            goto L65
        L60:
            r57 = Long.valueOf(r10.getLong(r24));     // Catch: Throwable -> L99
            goto L62
        L56:
            r56 = Long.valueOf(r10.getLong(r23));     // Catch: Throwable -> L99
            goto L58
        L52:
            r55 = Long.valueOf(r10.getLong(r22));     // Catch: Throwable -> L99
            goto L54
        L48:
            r53 = r10.getString(r21);     // Catch: Throwable -> L99
            goto L49
        L44:
            r52 = r10.getString(r20);     // Catch: Throwable -> L99
            goto L46
        L40:
            r51 = false;
            goto L42
        L36:
            r50 = false;
            goto L38
        L32:
            r410 = false;
            goto L34
        L28:
            r49 = false;
            goto L30
        L24:
            r48 = r10.getString(r18);     // Catch: Throwable -> L99
            goto L26
        L20:
            r47 = r10.getString(r17);     // Catch: Throwable -> L99
            goto L22
        L16:
            r45 = r10.getString(r15);     // Catch: Throwable -> L99
            goto L17
        L12:
            r44 = r10.getString(r14);     // Catch: Throwable -> L99
            goto L14
        L8:
            r42 = r10.getString(r12);     // Catch: Throwable -> L99
            goto L9
        L101:
            r61 = null;
        L99:
            th = move-exception;
            r10.close();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f20104a.c();
        }
    }

    public class m implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20107b;

        public m(g r10, RoomSQLiteQuery r11) {
            this.f20107b = r10;
            this.f20106a = r11;
        }

        public com.smt.obric.appstore.domain.app.entity.a a() {
            Cursor r10 = b0.b.c(g.b(this.f20107b), this.f20106a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L99
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L99
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L99
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L99
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L99
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L99
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L99
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L99
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L99
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L99
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L99
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L99
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L99
            int r21 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L99
            int r22 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L99
            int r23 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L99
            int r24 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L99
            int r25 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L99
            int r26 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L99
            int r27 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L99
            int r28 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L99
            int r29 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L99
            int r30 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L99
            int r31 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L99
            int r32 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L99
            int r33 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L99
            int r34 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L99
            int r35 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L99
            int r36 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L99
            int r37 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L99
            int r38 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L99
            int r39 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L99
            int r40 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L99
            int r41 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L99
            if (r10.moveToFirst() == false) goto L101;
            long r310 = r10.getLong(r11);     // Catch: Throwable -> L99
            if (r10.isNull(r12) == false) goto L8;
            String r42 = null;
        L9:
            long r43 = r10.getLong(r13);     // Catch: Throwable -> L99
            if (r10.isNull(r14) == false) goto L12;
            String r44 = null;
        L14:
            if (r10.isNull(r15) == false) goto L16;
            String r45 = null;
        L17:
            AppStatus r46 = g.a(this.f20107b).b(r10.getInt(r16));     // Catch: Throwable -> L99
            if (r10.isNull(r17) == false) goto L20;
            String r47 = null;
        L22:
            if (r10.isNull(r18) == false) goto L24;
            String r48 = null;
        L26:
            if (r10.getInt(r19) == 0) goto L28;
            boolean r49 = true;
        L30:
            if (r10.getInt(r110) == 0) goto L32;
            boolean r410 = true;
        L34:
            if (r10.getInt(r111) == 0) goto L36;
            boolean r50 = true;
        L38:
            if (r10.getInt(r112) == 0) goto L40;
            boolean r51 = true;
        L42:
            if (r10.isNull(r20) == false) goto L44;
            String r52 = null;
        L46:
            if (r10.isNull(r16) == false) goto L48;
            String r53 = null;
        L49:
            List r54 = g.a(this.f20107b).c(r53);     // Catch: Throwable -> L99
            if (r10.isNull(r22) == false) goto L52;
            Long r55 = null;
        L54:
            if (r10.isNull(r18) == false) goto L56;
            Long r56 = null;
        L58:
            if (r10.isNull(r19) == false) goto L60;
            Long r57 = null;
        L62:
            if (r10.isNull(r20) == false) goto L64;
            String r58 = null;
        L65:
            float r59 = r10.getFloat(r26);     // Catch: Throwable -> L99
            if (r10.isNull(r27) == false) goto L68;
            String r510 = null;
        L69:
            long r60 = r10.getLong(r28);     // Catch: Throwable -> L99
            long r62 = r10.getLong(r29);     // Catch: Throwable -> L99
            if (r10.isNull(r30) == false) goto L72;
            Float r64 = null;
        L74:
            if (r10.isNull(r26) == false) goto L76;
            String r65 = null;
        L77:
            int r66 = r10.getInt(r32);     // Catch: Throwable -> L99
            int r67 = r10.getInt(r33);     // Catch: Throwable -> L99
            int r68 = r10.getInt(r34);     // Catch: Throwable -> L99
            AppInstallMode r69 = g.a(this.f20107b).a(r10.getInt(r35));     // Catch: Throwable -> L99
            if (r10.isNull(r36) == false) goto L80;
            Integer r70 = null;
        L82:
            if (r10.isNull(r32) == false) goto L84;
            String r71 = null;
        L86:
            if (r10.isNull(r33) == false) goto L88;
            String r72 = null;
        L89:
            long r73 = r10.getLong(r39);     // Catch: Throwable -> L99
            if (r10.getInt(r40) == 0) goto L92;
            boolean r75 = true;
        L94:
            if (r10.isNull(r41) == false) goto L96;
            String r76 = null;
        L97:
            com.smt.obric.appstore.domain.app.entity.a r61 = new com.smt.obric.appstore.domain.app.entity.a(r310, r42, r43, r44, r45, r46, r47, r48, r49, r410, r50, r51, r52, r54, r55, r56, r57, r58, r59, r510, r60, r62, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r76);     // Catch: Throwable -> L99
        L102:
            r10.close();
            return r61;
        L96:
            r76 = r10.getString(r41);     // Catch: Throwable -> L99
            goto L97
        L92:
            r75 = false;
            goto L94
        L88:
            r72 = r10.getString(r38);     // Catch: Throwable -> L99
            goto L89
        L84:
            r71 = r10.getString(r37);     // Catch: Throwable -> L99
            goto L86
        L80:
            r70 = Integer.valueOf(r10.getInt(r36));     // Catch: Throwable -> L99
            goto L82
        L76:
            r65 = r10.getString(r31);     // Catch: Throwable -> L99
            goto L77
        L72:
            r64 = Float.valueOf(r10.getFloat(r30));     // Catch: Throwable -> L99
            goto L74
        L68:
            r510 = r10.getString(r27);     // Catch: Throwable -> L99
            goto L69
        L64:
            r58 = r10.getString(r25);     // Catch: Throwable -> L99
            goto L65
        L60:
            r57 = Long.valueOf(r10.getLong(r24));     // Catch: Throwable -> L99
            goto L62
        L56:
            r56 = Long.valueOf(r10.getLong(r23));     // Catch: Throwable -> L99
            goto L58
        L52:
            r55 = Long.valueOf(r10.getLong(r22));     // Catch: Throwable -> L99
            goto L54
        L48:
            r53 = r10.getString(r21);     // Catch: Throwable -> L99
            goto L49
        L44:
            r52 = r10.getString(r20);     // Catch: Throwable -> L99
            goto L46
        L40:
            r51 = false;
            goto L42
        L36:
            r50 = false;
            goto L38
        L32:
            r410 = false;
            goto L34
        L28:
            r49 = false;
            goto L30
        L24:
            r48 = r10.getString(r18);     // Catch: Throwable -> L99
            goto L26
        L20:
            r47 = r10.getString(r17);     // Catch: Throwable -> L99
            goto L22
        L16:
            r45 = r10.getString(r15);     // Catch: Throwable -> L99
            goto L17
        L12:
            r44 = r10.getString(r14);     // Catch: Throwable -> L99
            goto L14
        L8:
            r42 = r10.getString(r12);     // Catch: Throwable -> L99
            goto L9
        L101:
            r61 = null;
        L99:
            th = move-exception;
            r10.close();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f20106a.c();
        }
    }

    public class n implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20109b;

        public n(g r10, RoomSQLiteQuery r11) {
            this.f20109b = r10;
            this.f20108a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(g.b(this.f20109b), this.f20108a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L100
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L100
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L100
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r113 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L100
            int r115 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r10.getCount());     // Catch: Throwable -> L100
        L4:
            if (r10.moveToNext() == false) goto L102;
            long r39 = r10.getLong(r11);     // Catch: Throwable -> L100
            if (r10.isNull(r12) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r10.getLong(r13);     // Catch: Throwable -> L100
            if (r10.isNull(r14) == false) goto L13;
            String r44 = null;
        L15:
            if (r10.isNull(r15) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r10.getInt(r16);     // Catch: Throwable -> L100
            int r78 = r11;
            AppStatus r46 = g.a(this.f20109b).b(r40);     // Catch: Throwable -> L100
            if (r10.isNull(r17) == false) goto L21;
            String r47 = null;
        L23:
            if (r10.isNull(r18) == false) goto L25;
            String r48 = null;
        L27:
            if (r10.getInt(r19) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r10.getInt(r110) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r10.getInt(r111) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r10.getInt(r112) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r10.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r10.isNull(r113) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(this.f20109b).c(r43);     // Catch: Throwable -> L100
            r114 = r114;
            if (r10.isNull(r114) == false) goto L53;
            Long r55 = null;
        L55:
            if (r10.isNull(r115) == false) goto L57;
            Long r56 = null;
        L59:
            if (r10.isNull(r116) == false) goto L61;
            Long r57 = null;
        L63:
            if (r10.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r10.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r10.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r10.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r10.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r10.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r10.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r10.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r10.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r115 = r115;
            int r70 = r30;
            int r71 = r10.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(this.f20109b).a(r71);     // Catch: Throwable -> L100
            r31 = r31;
            if (r10.isNull(r31) == false) goto L81;
            Integer r73 = null;
        L83:
            if (r10.isNull(r32) == false) goto L85;
            String r74 = null;
        L87:
            if (r10.isNull(r33) == false) goto L89;
            String r75 = null;
        L90:
            long r76 = r10.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r77 = r35;
            int r310 = r10.getInt(r77);     // Catch: Throwable -> L100
            r35 = r77;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r79 = true;
        L95:
            if (r10.isNull(r36) == false) goto L97;
            String r710 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r73, r74, r75, r76, r79, r710));     // Catch: Throwable -> L100
            r32 = r32;
            r113 = r113;
            r11 = r78;
            r37 = r37;
            goto L4
        L97:
            r710 = r10.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r79 = false;
            goto L95
        L89:
            r75 = r10.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r74 = r10.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r73 = Integer.valueOf(r10.getInt(r31));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r10.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r10.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r10.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r10.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r10.getLong(r116));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r10.getLong(r115));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r10.getLong(r114));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r10.getString(r113);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r10.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r10.getString(r18);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r10.getString(r17);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r10.getString(r15);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r10.getString(r14);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r10.getString(r12);     // Catch: Throwable -> L100
            goto L10
        L102:
            r10.close();
            this.f20108a.c();
            return r38;
        L100:
            th = move-exception;
            r10.close();
            this.f20108a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class o implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20111b;

        public o(g r10, RoomSQLiteQuery r11) {
            this.f20111b = r10;
            this.f20110a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(g.b(this.f20111b), this.f20110a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L100
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L100
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L100
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r113 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L100
            int r115 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r10.getCount());     // Catch: Throwable -> L100
        L4:
            if (r10.moveToNext() == false) goto L102;
            long r39 = r10.getLong(r11);     // Catch: Throwable -> L100
            if (r10.isNull(r12) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r10.getLong(r13);     // Catch: Throwable -> L100
            if (r10.isNull(r14) == false) goto L13;
            String r44 = null;
        L15:
            if (r10.isNull(r15) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r10.getInt(r16);     // Catch: Throwable -> L100
            int r78 = r11;
            AppStatus r46 = g.a(this.f20111b).b(r40);     // Catch: Throwable -> L100
            if (r10.isNull(r17) == false) goto L21;
            String r47 = null;
        L23:
            if (r10.isNull(r18) == false) goto L25;
            String r48 = null;
        L27:
            if (r10.getInt(r19) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r10.getInt(r110) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r10.getInt(r111) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r10.getInt(r112) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r10.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r10.isNull(r113) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(this.f20111b).c(r43);     // Catch: Throwable -> L100
            r114 = r114;
            if (r10.isNull(r114) == false) goto L53;
            Long r55 = null;
        L55:
            if (r10.isNull(r115) == false) goto L57;
            Long r56 = null;
        L59:
            if (r10.isNull(r116) == false) goto L61;
            Long r57 = null;
        L63:
            if (r10.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r10.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r10.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r10.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r10.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r10.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r10.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r10.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r10.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r115 = r115;
            int r70 = r30;
            int r71 = r10.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(this.f20111b).a(r71);     // Catch: Throwable -> L100
            r31 = r31;
            if (r10.isNull(r31) == false) goto L81;
            Integer r73 = null;
        L83:
            if (r10.isNull(r32) == false) goto L85;
            String r74 = null;
        L87:
            if (r10.isNull(r33) == false) goto L89;
            String r75 = null;
        L90:
            long r76 = r10.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r77 = r35;
            int r310 = r10.getInt(r77);     // Catch: Throwable -> L100
            r35 = r77;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r79 = true;
        L95:
            if (r10.isNull(r36) == false) goto L97;
            String r710 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r73, r74, r75, r76, r79, r710));     // Catch: Throwable -> L100
            r32 = r32;
            r113 = r113;
            r11 = r78;
            r37 = r37;
            goto L4
        L97:
            r710 = r10.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r79 = false;
            goto L95
        L89:
            r75 = r10.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r74 = r10.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r73 = Integer.valueOf(r10.getInt(r31));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r10.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r10.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r10.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r10.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r10.getLong(r116));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r10.getLong(r115));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r10.getLong(r114));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r10.getString(r113);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r10.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r10.getString(r18);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r10.getString(r17);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r10.getString(r15);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r10.getString(r14);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r10.getString(r12);     // Catch: Throwable -> L100
            goto L10
        L102:
            r10.close();
            this.f20110a.c();
            return r38;
        L100:
            th = move-exception;
            r10.close();
            this.f20110a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class p implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20113b;

        public p(g r10, RoomSQLiteQuery r11) {
            this.f20113b = r10;
            this.f20112a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(g.b(this.f20113b), this.f20112a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L100
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L100
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L100
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r113 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L100
            int r115 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r10.getCount());     // Catch: Throwable -> L100
        L4:
            if (r10.moveToNext() == false) goto L102;
            long r39 = r10.getLong(r11);     // Catch: Throwable -> L100
            if (r10.isNull(r12) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r10.getLong(r13);     // Catch: Throwable -> L100
            if (r10.isNull(r14) == false) goto L13;
            String r44 = null;
        L15:
            if (r10.isNull(r15) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r10.getInt(r16);     // Catch: Throwable -> L100
            int r78 = r11;
            AppStatus r46 = g.a(this.f20113b).b(r40);     // Catch: Throwable -> L100
            if (r10.isNull(r17) == false) goto L21;
            String r47 = null;
        L23:
            if (r10.isNull(r18) == false) goto L25;
            String r48 = null;
        L27:
            if (r10.getInt(r19) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r10.getInt(r110) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r10.getInt(r111) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r10.getInt(r112) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r10.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r10.isNull(r113) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(this.f20113b).c(r43);     // Catch: Throwable -> L100
            r114 = r114;
            if (r10.isNull(r114) == false) goto L53;
            Long r55 = null;
        L55:
            if (r10.isNull(r115) == false) goto L57;
            Long r56 = null;
        L59:
            if (r10.isNull(r116) == false) goto L61;
            Long r57 = null;
        L63:
            if (r10.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r10.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r10.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r10.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r10.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r10.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r10.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r10.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r10.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r115 = r115;
            int r70 = r30;
            int r71 = r10.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(this.f20113b).a(r71);     // Catch: Throwable -> L100
            r31 = r31;
            if (r10.isNull(r31) == false) goto L81;
            Integer r73 = null;
        L83:
            if (r10.isNull(r32) == false) goto L85;
            String r74 = null;
        L87:
            if (r10.isNull(r33) == false) goto L89;
            String r75 = null;
        L90:
            long r76 = r10.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r77 = r35;
            int r310 = r10.getInt(r77);     // Catch: Throwable -> L100
            r35 = r77;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r79 = true;
        L95:
            if (r10.isNull(r36) == false) goto L97;
            String r710 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r73, r74, r75, r76, r79, r710));     // Catch: Throwable -> L100
            r32 = r32;
            r113 = r113;
            r11 = r78;
            r37 = r37;
            goto L4
        L97:
            r710 = r10.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r79 = false;
            goto L95
        L89:
            r75 = r10.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r74 = r10.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r73 = Integer.valueOf(r10.getInt(r31));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r10.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r10.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r10.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r10.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r10.getLong(r116));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r10.getLong(r115));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r10.getLong(r114));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r10.getString(r113);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r10.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r10.getString(r18);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r10.getString(r17);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r10.getString(r15);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r10.getString(r14);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r10.getString(r12);     // Catch: Throwable -> L100
            goto L10
        L102:
            r10.close();
            this.f20112a.c();
            return r38;
        L100:
            th = move-exception;
            r10.close();
            this.f20112a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class q implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f20114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20115b;

        public q(g r10, RoomSQLiteQuery r11) {
            this.f20115b = r10;
            this.f20114a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(g.b(this.f20115b), this.f20114a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L100
            int r12 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_PKG);     // Catch: Throwable -> L100
            int r13 = b0.a.d(r10, "version_code");     // Catch: Throwable -> L100
            int r14 = b0.a.d(r10, "app_name");     // Catch: Throwable -> L100
            int r15 = b0.a.d(r10, AppPermissionActivity.EXTRA_APP_ICON_URL);     // Catch: Throwable -> L100
            int r16 = b0.a.d(r10, "status");     // Catch: Throwable -> L100
            int r17 = b0.a.d(r10, "apk_file_path");     // Catch: Throwable -> L100
            int r18 = b0.a.d(r10, "expected_md5");     // Catch: Throwable -> L100
            int r19 = b0.a.d(r10, "is_update");     // Catch: Throwable -> L100
            int r110 = b0.a.d(r10, "is_auto_update");     // Catch: Throwable -> L100
            int r111 = b0.a.d(r10, "download_wifi_required");     // Catch: Throwable -> L100
            int r112 = b0.a.d(r10, "download_wait_wifi");     // Catch: Throwable -> L100
            int r20 = b0.a.d(r10, ServerElements.DOWNLOAD_URL);     // Catch: Throwable -> L100
            int r113 = b0.a.d(r10, ServerElements.DOWNLOAD_URL_BACKUPS);     // Catch: Throwable -> L100
            int r114 = b0.a.d(r10, "download_id");     // Catch: Throwable -> L100
            int r115 = b0.a.d(r10, "download_status");     // Catch: Throwable -> L100
            int r116 = b0.a.d(r10, "download_error_code");     // Catch: Throwable -> L100
            int r21 = b0.a.d(r10, "download_error_message");     // Catch: Throwable -> L100
            int r22 = b0.a.d(r10, "download_progress");     // Catch: Throwable -> L100
            int r23 = b0.a.d(r10, "download_file_path");     // Catch: Throwable -> L100
            int r24 = b0.a.d(r10, "cur_bytes");     // Catch: Throwable -> L100
            int r25 = b0.a.d(r10, "total_bytes");     // Catch: Throwable -> L100
            int r26 = b0.a.d(r10, "download_speed");     // Catch: Throwable -> L100
            int r27 = b0.a.d(r10, "download_modified_time");     // Catch: Throwable -> L100
            int r28 = b0.a.d(r10, DownloadInfoColumns.COLUMN_UPDATE_MODE);     // Catch: Throwable -> L100
            int r29 = b0.a.d(r10, "compliance_mode");     // Catch: Throwable -> L100
            int r210 = b0.a.d(r10, "install_flag");     // Catch: Throwable -> L100
            int r30 = b0.a.d(r10, "install_mode");     // Catch: Throwable -> L100
            int r31 = b0.a.d(r10, "install_result_code");     // Catch: Throwable -> L100
            int r32 = b0.a.d(r10, "business_extra");     // Catch: Throwable -> L100
            int r33 = b0.a.d(r10, "debug_extra");     // Catch: Throwable -> L100
            int r34 = b0.a.d(r10, "created_at");     // Catch: Throwable -> L100
            int r35 = b0.a.d(r10, "force_install");     // Catch: Throwable -> L100
            int r36 = b0.a.d(r10, "sha256");     // Catch: Throwable -> L100
            int r37 = r20;
            ArrayList r38 = new ArrayList(r10.getCount());     // Catch: Throwable -> L100
        L4:
            if (r10.moveToNext() == false) goto L102;
            long r39 = r10.getLong(r11);     // Catch: Throwable -> L100
            if (r10.isNull(r12) == false) goto L9;
            String r41 = null;
        L10:
            long r42 = r10.getLong(r13);     // Catch: Throwable -> L100
            if (r10.isNull(r14) == false) goto L13;
            String r44 = null;
        L15:
            if (r10.isNull(r15) == false) goto L17;
            String r45 = null;
        L18:
            int r40 = r10.getInt(r16);     // Catch: Throwable -> L100
            int r78 = r11;
            AppStatus r46 = g.a(this.f20115b).b(r40);     // Catch: Throwable -> L100
            if (r10.isNull(r17) == false) goto L21;
            String r47 = null;
        L23:
            if (r10.isNull(r18) == false) goto L25;
            String r48 = null;
        L27:
            if (r10.getInt(r19) == 0) goto L29;
            boolean r49 = true;
        L31:
            if (r10.getInt(r110) == 0) goto L33;
            boolean r50 = true;
        L35:
            if (r10.getInt(r111) == 0) goto L37;
            boolean r51 = true;
        L39:
            if (r10.getInt(r112) == 0) goto L41;
            boolean r52 = true;
        L43:
            if (r10.isNull(r37) == false) goto L45;
            String r53 = null;
        L47:
            if (r10.isNull(r113) == false) goto L49;
            String r43 = null;
        L50:
            List r54 = g.a(this.f20115b).c(r43);     // Catch: Throwable -> L100
            r114 = r114;
            if (r10.isNull(r114) == false) goto L53;
            Long r55 = null;
        L55:
            if (r10.isNull(r115) == false) goto L57;
            Long r56 = null;
        L59:
            if (r10.isNull(r116) == false) goto L61;
            Long r57 = null;
        L63:
            if (r10.isNull(r21) == false) goto L65;
            String r58 = null;
        L66:
            float r59 = r10.getFloat(r22);     // Catch: Throwable -> L100
            r22 = r22;
            r23 = r23;
            if (r10.isNull(r23) == false) goto L69;
            String r60 = null;
        L70:
            long r61 = r10.getLong(r24);     // Catch: Throwable -> L100
            r24 = r24;
            int r62 = r25;
            long r63 = r10.getLong(r62);     // Catch: Throwable -> L100
            r25 = r62;
            r26 = r26;
            if (r10.isNull(r26) == false) goto L73;
            Float r65 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r66 = null;
        L78:
            int r67 = r10.getInt(r28);     // Catch: Throwable -> L100
            r28 = r28;
            int r64 = r29;
            int r68 = r10.getInt(r64);     // Catch: Throwable -> L100
            r29 = r64;
            int r69 = r210;
            int r610 = r10.getInt(r69);     // Catch: Throwable -> L100
            r210 = r69;
            r115 = r115;
            int r70 = r30;
            int r71 = r10.getInt(r70);     // Catch: Throwable -> L100
            r30 = r70;
            AppInstallMode r72 = g.a(this.f20115b).a(r71);     // Catch: Throwable -> L100
            r31 = r31;
            if (r10.isNull(r31) == false) goto L81;
            Integer r73 = null;
        L83:
            if (r10.isNull(r32) == false) goto L85;
            String r74 = null;
        L87:
            if (r10.isNull(r33) == false) goto L89;
            String r75 = null;
        L90:
            long r76 = r10.getLong(r34);     // Catch: Throwable -> L100
            r34 = r34;
            int r77 = r35;
            int r310 = r10.getInt(r77);     // Catch: Throwable -> L100
            r35 = r77;
            r36 = r36;
            if (r310 == 0) goto L93;
            boolean r79 = true;
        L95:
            if (r10.isNull(r36) == false) goto L97;
            String r710 = null;
        L98:
            r38.add(new com.smt.obric.appstore.domain.app.entity.a(r39, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r68, r610, r72, r73, r74, r75, r76, r79, r710));     // Catch: Throwable -> L100
            r32 = r32;
            r113 = r113;
            r11 = r78;
            r37 = r37;
            goto L4
        L97:
            r710 = r10.getString(r36);     // Catch: Throwable -> L100
            goto L98
        L93:
            r79 = false;
            goto L95
        L89:
            r75 = r10.getString(r33);     // Catch: Throwable -> L100
            goto L90
        L85:
            r74 = r10.getString(r32);     // Catch: Throwable -> L100
            goto L87
        L81:
            r73 = Integer.valueOf(r10.getInt(r31));     // Catch: Throwable -> L100
            goto L83
        L77:
            r66 = r10.getString(r27);     // Catch: Throwable -> L100
            goto L78
        L73:
            r65 = Float.valueOf(r10.getFloat(r26));     // Catch: Throwable -> L100
            goto L75
        L69:
            r60 = r10.getString(r23);     // Catch: Throwable -> L100
            goto L70
        L65:
            r58 = r10.getString(r21);     // Catch: Throwable -> L100
            goto L66
        L61:
            r57 = Long.valueOf(r10.getLong(r116));     // Catch: Throwable -> L100
            goto L63
        L57:
            r56 = Long.valueOf(r10.getLong(r115));     // Catch: Throwable -> L100
            goto L59
        L53:
            r55 = Long.valueOf(r10.getLong(r114));     // Catch: Throwable -> L100
            goto L55
        L49:
            r43 = r10.getString(r113);     // Catch: Throwable -> L100
            goto L50
        L45:
            r53 = r10.getString(r37);     // Catch: Throwable -> L100
            goto L47
        L41:
            r52 = false;
            goto L43
        L37:
            r51 = false;
            goto L39
        L33:
            r50 = false;
            goto L35
        L29:
            r49 = false;
            goto L31
        L25:
            r48 = r10.getString(r18);     // Catch: Throwable -> L100
            goto L27
        L21:
            r47 = r10.getString(r17);     // Catch: Throwable -> L100
            goto L23
        L17:
            r45 = r10.getString(r15);     // Catch: Throwable -> L100
            goto L18
        L13:
            r44 = r10.getString(r14);     // Catch: Throwable -> L100
            goto L15
        L9:
            r41 = r10.getString(r12);     // Catch: Throwable -> L100
            goto L10
        L102:
            r10.close();
            this.f20114a.c();
            return r38;
        L100:
            th = move-exception;
            r10.close();
            this.f20114a.c();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class r implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f20116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20117b;

        public r(g r10, List r11) {
            this.f20117b = r10;
            this.f20116a = r11;
        }

        public Integer a() {
            StringBuilder r10 = b0.d.b();
            r10.append("DELETE FROM app_install_task WHERE download_id IN (");
            b0.d.a(r10, this.f20116a.size());
            r10.append(")");
            String r11 = r10.toString();
            SupportSQLiteStatement r12 = g.b(this.f20117b).f(r11);
            Iterator r13 = this.f20116a.iterator();
            int r14 = 1;
        L4:
            if (r13.hasNext() == false) goto L10;
            Long r15 = (Long) r13.next();
            if (r15 != null) goto L8;
            r12.bindNull(r14);
        L9:
            r14 = r14 + 1;
            goto L4
        L8:
            r12.bindLong(r14, r15.longValue());
            goto L9
        L10:
            g.b(this.f20117b).e();
            Integer r16 = Integer.valueOf(r12.executeUpdateDelete());     // Catch: Throwable -> L14
            g.b(this.f20117b).D();     // Catch: Throwable -> L14
            g.b(this.f20117b).i();
            return r16;
        L14:
            th = move-exception;
            g.b(this.f20117b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class s implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f20118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f20119b;

        public s(g r10, List r11) {
            this.f20119b = r10;
            this.f20118a = r11;
        }

        public Integer a() {
            StringBuilder r10 = b0.d.b();
            r10.append("DELETE FROM app_install_task WHERE download_id IS NOT NULL and download_id NOT IN (");
            b0.d.a(r10, this.f20118a.size());
            r10.append(")");
            String r11 = r10.toString();
            SupportSQLiteStatement r12 = g.b(this.f20119b).f(r11);
            Iterator r13 = this.f20118a.iterator();
            int r14 = 1;
        L4:
            if (r13.hasNext() == false) goto L10;
            Long r15 = (Long) r13.next();
            if (r15 != null) goto L8;
            r12.bindNull(r14);
        L9:
            r14 = r14 + 1;
            goto L4
        L8:
            r12.bindLong(r14, r15.longValue());
            goto L9
        L10:
            g.b(this.f20119b).e();
            Integer r16 = Integer.valueOf(r12.executeUpdateDelete());     // Catch: Throwable -> L14
            g.b(this.f20119b).D();     // Catch: Throwable -> L14
            g.b(this.f20119b).i();
            return r16;
        L14:
            th = move-exception;
            g.b(this.f20119b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class t extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20120d;

        public t(g r10, RoomDatabase r11) {
            this.f20120d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE app_install_task SET download_id = ? WHERE id = ?";
        }
    }

    public class u extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20121d;

        public u(g r10, RoomDatabase r11) {
            this.f20121d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE app_install_task SET download_wifi_required = false WHERE pkg = ?";
        }
    }

    public class v extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20122d;

        public v(g r10, RoomDatabase r11) {
            this.f20122d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE app_install_task SET download_wifi_required = ? WHERE pkg = ?";
        }
    }

    public class w extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20123d;

        public w(g r10, RoomDatabase r11) {
            this.f20123d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM app_install_task WHERE pkg = ?";
        }
    }

    public class x extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20124d;

        public x(g r10, RoomDatabase r11) {
            this.f20124d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE app_install_task SET status = ? WHERE pkg = ?";
        }
    }

    public class y extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20125d;

        public y(g r10, RoomDatabase r11) {
            this.f20125d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "\n        UPDATE app_install_task SET \n            status = ?,\n            download_status = ?,\n            download_error_code = ?,\n            download_error_message = ?,\n            download_progress = ?,\n            download_file_path = ?,\n            cur_bytes = ?,\n            total_bytes = ?,\n            download_speed = ?,\n            download_modified_time = ?\n        WHERE download_id = ? \n        ";
        }
    }

    public class z extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f20126d;

        public z(g r10, RoomDatabase r11) {
            this.f20126d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "\n        UPDATE app_install_task SET \n            download_id = ?,\n            status = ?,\n            download_status = ?,\n            download_error_code = ?,\n            download_error_message = ?,\n            download_progress = ?,\n            download_file_path = ?,\n            cur_bytes = ?,\n            total_bytes = ?,\n            download_speed = ?,\n            download_modified_time = ?\n        WHERE pkg = ? AND version_code = ? \n        ";
        }
    }

    public g(RoomDatabase r10) {
        this.f20048c = new Converters();
        this.f20046a = r10;
        this.f20047b = new k(this, r10);
        this.f20049d = new t(this, r10);
        this.f20050e = new u(this, r10);
        this.f20051f = new v(this, r10);
        this.f20052g = new w(this, r10);
        this.f20053h = new x(this, r10);
        this.f20054i = new y(this, r10);
        this.f20055j = new z(this, r10);
    }

    public static /* synthetic */ Converters a(g r10) {
        return r10.f20048c;
    }

    public static /* synthetic */ RoomDatabase b(g r10) {
        return r10.f20046a;
    }

    public static /* synthetic */ androidx.room.j c(g r10) {
        return r10.f20047b;
    }

    public static /* synthetic */ SharedSQLiteStatement d(g r10) {
        return r10.f20049d;
    }

    public static /* synthetic */ SharedSQLiteStatement e(g r10) {
        return r10.f20050e;
    }

    public static /* synthetic */ SharedSQLiteStatement f(g r10) {
        return r10.f20051f;
    }

    public static /* synthetic */ SharedSQLiteStatement g(g r10) {
        return r10.f20052g;
    }

    public static /* synthetic */ SharedSQLiteStatement h(g r10) {
        return r10.f20053h;
    }

    public static /* synthetic */ SharedSQLiteStatement i(g r10) {
        return r10.f20054i;
    }

    public static /* synthetic */ SharedSQLiteStatement j(g r10) {
        return r10.f20055j;
    }

    public static List k() {
        return Collections.emptyList();
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object deleteByDownloadId(List r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20046a, true, new r(this, r10), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object deleteByPkg(String r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20046a, true, new d(this, r10), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Flow getAll() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM app_install_task ORDER by created_at DESC", 0);
        return CoroutinesRoom.a(this.f20046a, false, new String[]{"app_install_task"}, new i(this, r10));
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getAllTasksByUpdateMode(int r10, Continuation r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT * FROM app_install_task WHERE update_mode = ?", 1);
        r12.bindLong(1, r10);
        return CoroutinesRoom.b(this.f20046a, false, b0.b.a(), new p(this, r12), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getAllTasksByUpdateModeAndComplianceMode(int r10, int r11, Continuation r12) {
        RoomSQLiteQuery r13 = RoomSQLiteQuery.a("SELECT * FROM app_install_task WHERE update_mode = ? AND compliance_mode = ?", 2);
        r13.bindLong(1, r10);
        r13.bindLong(2, r11);
        return CoroutinesRoom.b(this.f20046a, false, b0.b.a(), new q(this, r13), r12);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getAllWifiDownloadTasks(List r10, Continuation r11) {
        StringBuilder r12 = b0.d.b();
        r12.append("SELECT * FROM app_install_task WHERE download_wifi_required = true AND status NOT IN (");
        int r13 = r10.size();
        b0.d.a(r12, r13);
        r12.append(")");
        RoomSQLiteQuery r14 = RoomSQLiteQuery.a(r12.toString(), r13);
        Iterator r15 = r10.iterator();
        int r16 = 1;
    L4:
        if (r15.hasNext() == false) goto L7;
        r14.bindLong(r16, this.f20048c.e((AppStatus) r15.next()));
        r16 = r16 + 1;
        goto L4
    L7:
        return CoroutinesRoom.b(this.f20046a, false, b0.b.a(), new n(this, r14), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getByDownloadId(long r10, Continuation r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT * FROM app_install_task WHERE download_id = ? LIMIT 1", 1);
        r12.bindLong(1, r10);
        CancellationSignal r13 = b0.b.a();
        return CoroutinesRoom.b(this.f20046a, false, r13, new h(this, r12), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Flow getByPkg(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT * FROM app_install_task WHERE pkg = ? ORDER by created_at DESC LIMIT 1", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return CoroutinesRoom.a(this.f20046a, false, new String[]{"app_install_task"}, new l(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Flow getByPkgVer(String r10, long r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT * FROM app_install_task WHERE pkg = ? AND version_code = ? ORDER by created_at DESC LIMIT 1", 2);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r11);
        return CoroutinesRoom.a(this.f20046a, false, new String[]{"app_install_task"}, new m(this, r12));
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getTasksByState(List r10, Continuation r11) {
        StringBuilder r12 = b0.d.b();
        r12.append("SELECT * FROM app_install_task WHERE status IN (");
        int r13 = r10.size();
        b0.d.a(r12, r13);
        r12.append(") ORDER by created_at DESC");
        RoomSQLiteQuery r14 = RoomSQLiteQuery.a(r12.toString(), r13);
        Iterator r15 = r10.iterator();
        int r16 = 1;
    L4:
        if (r15.hasNext() == false) goto L7;
        r14.bindLong(r16, this.f20048c.e((AppStatus) r15.next()));
        r16 = r16 + 1;
        goto L4
    L7:
        return CoroutinesRoom.b(this.f20046a, false, b0.b.a(), new j(this, r14), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object getWaitWiFiDownloadTasks(List r10, Continuation r11) {
        StringBuilder r12 = b0.d.b();
        r12.append("SELECT * FROM app_install_task WHERE download_wifi_required = true AND status IN (");
        int r13 = r10.size();
        b0.d.a(r12, r13);
        r12.append(")");
        RoomSQLiteQuery r14 = RoomSQLiteQuery.a(r12.toString(), r13);
        Iterator r15 = r10.iterator();
        int r16 = 1;
    L4:
        if (r15.hasNext() == false) goto L7;
        r14.bindLong(r16, this.f20048c.e((AppStatus) r15.next()));
        r16 = r16 + 1;
        goto L4
    L7:
        return CoroutinesRoom.b(this.f20046a, false, b0.b.a(), new o(this, r14), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object pruneByDownloadIds(List r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20046a, true, new s(this, r10), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateAppStatus(String r10, AppStatus r11, Continuation r12) {
        return CoroutinesRoom.c(this.f20046a, true, new e(this, r11, r10), r12);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateDownloadId(long r10, long r11, Continuation r13) {
        return CoroutinesRoom.c(this.f20046a, true, new a(this, r11, r10), r13);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateDownloadStatus(long r19, AppStatus r21, Long r22, Long r23, String r24, float r25, String r26, long r27, long r29, Float r31, String r32, Continuation r33) {
        return CoroutinesRoom.c(this.f20046a, true, new f(this, r21, r22, r23, r24, r25, r26, r27, r29, r31, r32, r19), r33);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateDownloadStatusByAppPkg(String r23, long r24, long r26, AppStatus r28, Long r29, Long r30, String r31, float r32, String r33, long r34, long r36, Float r38, String r39, Continuation r40) {
        return CoroutinesRoom.c(this.f20046a, true, new CallableC0260g(this, r26, r28, r29, r30, r31, r32, r33, r34, r36, r38, r39, r23, r24), r40);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateDownloadWiFiRequired(String r10, boolean r11, Continuation r12) {
        return CoroutinesRoom.c(this.f20046a, true, new c(this, r11, r10), r12);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object updateTaskToUseCellarData(String r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20046a, true, new b(this, r10), r11);
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppInstallTaskDAO
    public Object upsert(com.smt.obric.appstore.domain.app.entity.a r10, Continuation r11) {
        return CoroutinesRoom.c(this.f20046a, true, new a0(this, r10), r11);
    }
}
