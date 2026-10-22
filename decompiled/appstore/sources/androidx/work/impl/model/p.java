package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements WorkSpecDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.room.i f5701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f5702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f5703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f5704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SharedSQLiteStatement f5705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SharedSQLiteStatement f5706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SharedSQLiteStatement f5707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SharedSQLiteStatement f5708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SharedSQLiteStatement f5709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SharedSQLiteStatement f5710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SharedSQLiteStatement f5711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SharedSQLiteStatement f5712n;

    public class a extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5713d;

        public a(p r10, RoomDatabase r11) {
            this.f5713d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class b extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5714d;

        public b(p r10, RoomDatabase r11) {
            this.f5714d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class c extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5715d;

        public c(p r10, RoomDatabase r11) {
            this.f5715d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public class d extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5716d;

        public d(p r10, RoomDatabase r11) {
            this.f5716d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    public class e implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f5718b;

        public e(p r10, RoomSQLiteQuery r11) {
            this.f5718b = r10;
            this.f5717a = r11;
        }

        public List a() {
            p.c(this.f5718b).e();
            Cursor r10 = b0.b.c(p.c(this.f5718b), this.f5717a, false, null);     // Catch: Throwable -> L18
            ArrayList r11 = new ArrayList(r10.getCount());     // Catch: Throwable -> L12
        L6:
            if (r10.moveToNext() == false) goto L14;
            if (r10.isNull(0) == false) goto L10;
            String r12 = null;
        L11:
            r11.add(r12);     // Catch: Throwable -> L12
            goto L6
        L10:
            r12 = r10.getString(0);     // Catch: Throwable -> L12
            goto L11
        L14:
            p.c(this.f5718b).D();     // Catch: Throwable -> L12
            r10.close();     // Catch: Throwable -> L18
            p.c(this.f5718b).i();
            return r11;
        L12:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L18
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            p.c(this.f5718b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5717a.c();
        }
    }

    public class f implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f5720b;

        public f(p r10, RoomSQLiteQuery r11) {
            this.f5720b = r10;
            this.f5719a = r11;
        }

        public List a() {
            p.c(this.f5720b).e();
            Cursor r10 = b0.b.c(p.c(this.f5720b), this.f5719a, true, null);     // Catch: Throwable -> L37
            ArrayMap r11 = new ArrayMap();     // Catch: Throwable -> L10
            ArrayMap r12 = new ArrayMap();     // Catch: Throwable -> L10
        L6:
            if (r10.moveToNext() == false) goto L15;
            String r13 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r11.get(r13)) != null) goto L12;
            r11.put(r13, new ArrayList());     // Catch: Throwable -> L10
        L12:
            String r14 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r12.get(r14)) != null) goto L6;
            r12.put(r14, new ArrayList());     // Catch: Throwable -> L10
            goto L6
        L15:
            r10.moveToPosition(-1);     // Catch: Throwable -> L10
            p.d(this.f5720b, r11);     // Catch: Throwable -> L10
            p.e(this.f5720b, r12);     // Catch: Throwable -> L10
            ArrayList r15 = new ArrayList(r10.getCount());     // Catch: Throwable -> L10
        L17:
            if (r10.moveToNext() == false) goto L33;
            if (r10.isNull(0) == false) goto L21;
            String r16 = null;
        L22:
            WorkInfo.State r17 = t.f(r10.getInt(1));     // Catch: Throwable -> L10
            if (r10.isNull(2) == false) goto L25;
            byte[] r18 = null;
        L26:
            androidx.work.c r19 = androidx.work.c.g(r18);     // Catch: Throwable -> L10
            int r110 = r10.getInt(3);     // Catch: Throwable -> L10
            int r111 = r10.getInt(4);     // Catch: Throwable -> L10
            ArrayList r20 = (ArrayList) r11.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r20 != null) goto L29;
            r20 = new ArrayList();     // Catch: Throwable -> L10
        L29:
            ArrayList r112 = r20;
            ArrayList r21 = (ArrayList) r12.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r21 != null) goto L32;
            r21 = new ArrayList();     // Catch: Throwable -> L10
        L32:
            r15.add(new androidx.work.impl.model.o.c(r16, r17, r19, r110, r111, r112, r21));     // Catch: Throwable -> L10
            goto L17
        L25:
            r18 = r10.getBlob(2);     // Catch: Throwable -> L10
            goto L26
        L21:
            r16 = r10.getString(0);     // Catch: Throwable -> L10
            goto L22
        L33:
            p.c(this.f5720b).D();     // Catch: Throwable -> L10
            r10.close();     // Catch: Throwable -> L37
            p.c(this.f5720b).i();
            return r15;
        L10:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L37
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            p.c(this.f5720b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5719a.c();
        }
    }

    public class g implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f5722b;

        public g(p r10, RoomSQLiteQuery r11) {
            this.f5722b = r10;
            this.f5721a = r11;
        }

        public List a() {
            p.c(this.f5722b).e();
            Cursor r10 = b0.b.c(p.c(this.f5722b), this.f5721a, true, null);     // Catch: Throwable -> L37
            ArrayMap r11 = new ArrayMap();     // Catch: Throwable -> L10
            ArrayMap r12 = new ArrayMap();     // Catch: Throwable -> L10
        L6:
            if (r10.moveToNext() == false) goto L15;
            String r13 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r11.get(r13)) != null) goto L12;
            r11.put(r13, new ArrayList());     // Catch: Throwable -> L10
        L12:
            String r14 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r12.get(r14)) != null) goto L6;
            r12.put(r14, new ArrayList());     // Catch: Throwable -> L10
            goto L6
        L15:
            r10.moveToPosition(-1);     // Catch: Throwable -> L10
            p.d(this.f5722b, r11);     // Catch: Throwable -> L10
            p.e(this.f5722b, r12);     // Catch: Throwable -> L10
            ArrayList r15 = new ArrayList(r10.getCount());     // Catch: Throwable -> L10
        L17:
            if (r10.moveToNext() == false) goto L33;
            if (r10.isNull(0) == false) goto L21;
            String r16 = null;
        L22:
            WorkInfo.State r17 = t.f(r10.getInt(1));     // Catch: Throwable -> L10
            if (r10.isNull(2) == false) goto L25;
            byte[] r18 = null;
        L26:
            androidx.work.c r19 = androidx.work.c.g(r18);     // Catch: Throwable -> L10
            int r110 = r10.getInt(3);     // Catch: Throwable -> L10
            int r111 = r10.getInt(4);     // Catch: Throwable -> L10
            ArrayList r20 = (ArrayList) r11.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r20 != null) goto L29;
            r20 = new ArrayList();     // Catch: Throwable -> L10
        L29:
            ArrayList r112 = r20;
            ArrayList r21 = (ArrayList) r12.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r21 != null) goto L32;
            r21 = new ArrayList();     // Catch: Throwable -> L10
        L32:
            r15.add(new androidx.work.impl.model.o.c(r16, r17, r19, r110, r111, r112, r21));     // Catch: Throwable -> L10
            goto L17
        L25:
            r18 = r10.getBlob(2);     // Catch: Throwable -> L10
            goto L26
        L21:
            r16 = r10.getString(0);     // Catch: Throwable -> L10
            goto L22
        L33:
            p.c(this.f5722b).D();     // Catch: Throwable -> L10
            r10.close();     // Catch: Throwable -> L37
            p.c(this.f5722b).i();
            return r15;
        L10:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L37
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            p.c(this.f5722b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5721a.c();
        }
    }

    public class h implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f5724b;

        public h(p r10, RoomSQLiteQuery r11) {
            this.f5724b = r10;
            this.f5723a = r11;
        }

        public List a() {
            p.c(this.f5724b).e();
            Cursor r10 = b0.b.c(p.c(this.f5724b), this.f5723a, true, null);     // Catch: Throwable -> L37
            ArrayMap r11 = new ArrayMap();     // Catch: Throwable -> L10
            ArrayMap r12 = new ArrayMap();     // Catch: Throwable -> L10
        L6:
            if (r10.moveToNext() == false) goto L15;
            String r13 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r11.get(r13)) != null) goto L12;
            r11.put(r13, new ArrayList());     // Catch: Throwable -> L10
        L12:
            String r14 = r10.getString(0);     // Catch: Throwable -> L10
            if (((ArrayList) r12.get(r14)) != null) goto L6;
            r12.put(r14, new ArrayList());     // Catch: Throwable -> L10
            goto L6
        L15:
            r10.moveToPosition(-1);     // Catch: Throwable -> L10
            p.d(this.f5724b, r11);     // Catch: Throwable -> L10
            p.e(this.f5724b, r12);     // Catch: Throwable -> L10
            ArrayList r15 = new ArrayList(r10.getCount());     // Catch: Throwable -> L10
        L17:
            if (r10.moveToNext() == false) goto L33;
            if (r10.isNull(0) == false) goto L21;
            String r16 = null;
        L22:
            WorkInfo.State r17 = t.f(r10.getInt(1));     // Catch: Throwable -> L10
            if (r10.isNull(2) == false) goto L25;
            byte[] r18 = null;
        L26:
            androidx.work.c r19 = androidx.work.c.g(r18);     // Catch: Throwable -> L10
            int r110 = r10.getInt(3);     // Catch: Throwable -> L10
            int r111 = r10.getInt(4);     // Catch: Throwable -> L10
            ArrayList r20 = (ArrayList) r11.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r20 != null) goto L29;
            r20 = new ArrayList();     // Catch: Throwable -> L10
        L29:
            ArrayList r112 = r20;
            ArrayList r21 = (ArrayList) r12.get(r10.getString(0));     // Catch: Throwable -> L10
            if (r21 != null) goto L32;
            r21 = new ArrayList();     // Catch: Throwable -> L10
        L32:
            r15.add(new androidx.work.impl.model.o.c(r16, r17, r19, r110, r111, r112, r21));     // Catch: Throwable -> L10
            goto L17
        L25:
            r18 = r10.getBlob(2);     // Catch: Throwable -> L10
            goto L26
        L21:
            r16 = r10.getString(0);     // Catch: Throwable -> L10
            goto L22
        L33:
            p.c(this.f5724b).D();     // Catch: Throwable -> L10
            r10.close();     // Catch: Throwable -> L37
            p.c(this.f5724b).i();
            return r15;
        L10:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L37
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            p.c(this.f5724b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5723a.c();
        }
    }

    public class i implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f5725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f5726b;

        public i(p r10, RoomSQLiteQuery r11) {
            this.f5726b = r10;
            this.f5725a = r11;
        }

        public Long a() {
            Cursor r10 = b0.b.c(p.c(this.f5726b), this.f5725a, false, null);
        L6:
            th = move-exception;
            r10.close();
            throw th;
        L4:
            if (r10.moveToFirst() == false) goto L8;
            long r11 = r10.getLong(0);     // Catch: Throwable -> L6
        L9:
            Long r12 = Long.valueOf(r11);     // Catch: Throwable -> L6
            r10.close();
            return r12;
        L8:
            r11 = 0;
            goto L9
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f5725a.c();
        }
    }

    public class j extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5727d;

        public j(p r10, RoomDatabase r11) {
            this.f5727d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (androidx.work.impl.model.o) r11);
        }

        public void l(SupportSQLiteStatement r10, androidx.work.impl.model.o r11) {
            String r12 = r11.f5670a;
            if (r12 != null) goto L5;
            r10.bindNull(1);
        L6:
            t r13 = t.f5743a;
            r10.bindLong(2, t.j(r11.f5671b));
            String r14 = r11.f5672c;
            if (r14 != null) goto L9;
            r10.bindNull(3);
        L10:
            String r15 = r11.f5673d;
            if (r15 != null) goto L13;
            r10.bindNull(4);
        L14:
            byte[] r16 = androidx.work.c.k(r11.f5674e);
            if (r16 != null) goto L17;
            r10.bindNull(5);
        L18:
            byte[] r17 = androidx.work.c.k(r11.f5675f);
            if (r17 != null) goto L21;
            r10.bindNull(6);
        L22:
            r10.bindLong(7, r11.f5676g);
            r10.bindLong(8, r11.f5677h);
            r10.bindLong(9, r11.f5678i);
            r10.bindLong(10, r11.f5680k);
            r10.bindLong(11, t.a(r11.f5681l));
            r10.bindLong(12, r11.f5682m);
            r10.bindLong(13, r11.f5683n);
            r10.bindLong(14, r11.f5684o);
            r10.bindLong(15, r11.f5685p);
            r10.bindLong(16, r11.f5686q ? 1 : 0);
            r10.bindLong(17, t.h(r11.f5687r));
            r10.bindLong(18, r11.e());
            r10.bindLong(19, r11.d());
            androidx.work.a r18 = r11.f5679j;
            if (r18 == null) goto L28;
            r10.bindLong(20, t.g(r18.d()));
            r10.bindLong(21, r18.g() ? 1 : 0);
            r10.bindLong(22, r18.h() ? 1 : 0);
            r10.bindLong(23, r18.f() ? 1 : 0);
            r10.bindLong(24, r18.i() ? 1 : 0);
            r10.bindLong(25, r18.b());
            r10.bindLong(26, r18.a());
            byte[] r19 = t.i(r18.c());
            if (r19 != null) goto L27;
            r10.bindNull(27);
            return;
        L27:
            r10.bindBlob(27, r19);
            return;
        L28:
            r10.bindNull(20);
            r10.bindNull(21);
            r10.bindNull(22);
            r10.bindNull(23);
            r10.bindNull(24);
            r10.bindNull(25);
            r10.bindNull(26);
            r10.bindNull(27);
            return;
        L21:
            r10.bindBlob(6, r17);
            goto L22
        L17:
            r10.bindBlob(5, r16);
            goto L18
        L13:
            r10.bindString(4, r15);
            goto L14
        L9:
            r10.bindString(3, r14);
            goto L10
        L5:
            r10.bindString(1, r12);
            goto L6
        }
    }

    public class k extends androidx.room.i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5728d;

        public k(p r10, RoomDatabase r11) {
            this.f5728d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        @Override // androidx.room.i
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            k(r10, (androidx.work.impl.model.o) r11);
        }

        public void k(SupportSQLiteStatement r11, androidx.work.impl.model.o r12) {
            String r10 = r12.f5670a;
            if (r10 != null) goto L5;
            r11.bindNull(1);
        L6:
            t r13 = t.f5743a;
            r11.bindLong(2, t.j(r12.f5671b));
            String r14 = r12.f5672c;
            if (r14 != null) goto L9;
            r11.bindNull(3);
        L10:
            String r15 = r12.f5673d;
            if (r15 != null) goto L13;
            r11.bindNull(4);
        L14:
            byte[] r16 = androidx.work.c.k(r12.f5674e);
            if (r16 != null) goto L17;
            r11.bindNull(5);
        L18:
            byte[] r17 = androidx.work.c.k(r12.f5675f);
            if (r17 != null) goto L21;
            r11.bindNull(6);
        L22:
            r11.bindLong(7, r12.f5676g);
            r11.bindLong(8, r12.f5677h);
            r11.bindLong(9, r12.f5678i);
            r11.bindLong(10, r12.f5680k);
            r11.bindLong(11, t.a(r12.f5681l));
            r11.bindLong(12, r12.f5682m);
            r11.bindLong(13, r12.f5683n);
            r11.bindLong(14, r12.f5684o);
            r11.bindLong(15, r12.f5685p);
            r11.bindLong(16, r12.f5686q ? 1 : 0);
            r11.bindLong(17, t.h(r12.f5687r));
            r11.bindLong(18, r12.e());
            r11.bindLong(19, r12.d());
            androidx.work.a r18 = r12.f5679j;
            if (r18 == null) goto L28;
            r11.bindLong(20, t.g(r18.d()));
            r11.bindLong(21, r18.g() ? 1 : 0);
            r11.bindLong(22, r18.h() ? 1 : 0);
            r11.bindLong(23, r18.f() ? 1 : 0);
            r11.bindLong(24, r18.i() ? 1 : 0);
            r11.bindLong(25, r18.b());
            r11.bindLong(26, r18.a());
            byte[] r19 = t.i(r18.c());
            if (r19 != null) goto L27;
            r11.bindNull(27);
        L29:
            String r110 = r12.f5670a;
            if (r110 != null) goto L32;
            r11.bindNull(28);
            return;
        L32:
            r11.bindString(28, r110);
            return;
        L27:
            r11.bindBlob(27, r19);
            goto L29
        L28:
            r11.bindNull(20);
            r11.bindNull(21);
            r11.bindNull(22);
            r11.bindNull(23);
            r11.bindNull(24);
            r11.bindNull(25);
            r11.bindNull(26);
            r11.bindNull(27);
            goto L29
        L21:
            r11.bindBlob(6, r17);
            goto L22
        L17:
            r11.bindBlob(5, r16);
            goto L18
        L13:
            r11.bindString(4, r15);
            goto L14
        L9:
            r11.bindString(3, r14);
            goto L10
        L5:
            r11.bindString(1, r10);
            goto L6
        }
    }

    public class l extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5729d;

        public l(p r10, RoomDatabase r11) {
            this.f5729d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class m extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5730d;

        public m(p r10, RoomDatabase r11) {
            this.f5730d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    public class n extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5731d;

        public n(p r10, RoomDatabase r11) {
            this.f5731d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    public class o extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5732d;

        public o(p r10, RoomDatabase r11) {
            this.f5732d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.p$p, reason: collision with other inner class name */
    public class C0060p extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5733d;

        public C0060p(p r10, RoomDatabase r11) {
            this.f5733d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    public class q extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5734d;

        public q(p r10, RoomDatabase r11) {
            this.f5734d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class r extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f5735d;

        public r(p r10, RoomDatabase r11) {
            this.f5735d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public p(RoomDatabase r10) {
        this.f5699a = r10;
        this.f5700b = new j(this, r10);
        this.f5701c = new k(this, r10);
        this.f5702d = new l(this, r10);
        this.f5703e = new m(this, r10);
        this.f5704f = new n(this, r10);
        this.f5705g = new o(this, r10);
        this.f5706h = new C0060p(this, r10);
        this.f5707i = new q(this, r10);
        this.f5708j = new r(this, r10);
        this.f5709k = new a(this, r10);
        this.f5710l = new b(this, r10);
        this.f5711m = new c(this, r10);
        this.f5712n = new d(this, r10);
    }

    public static /* synthetic */ RoomDatabase c(p r10) {
        return r10.f5699a;
    }

    public static /* synthetic */ void d(p r10, ArrayMap r11) {
        r10.b(r11);
    }

    public static /* synthetic */ void e(p r10, ArrayMap r11) {
        r10.a(r11);
    }

    public static List f() {
        return Collections.emptyList();
    }

    public final void a(ArrayMap r10) {
        Set<Object> r11 = r10.keySet();
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() <= 999) goto L15;
        ArrayMap r12 = new ArrayMap(999);
        int r13 = r10.size();
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L12;
        r12.put((String) r10.keyAt(r14), (ArrayList) r10.valueAt(r14));
        r14 = r14 + 1;
        r15 = r15 + 1;
        if (r15 != 999) goto L8;
        a(r12);
        r12 = new ArrayMap(999);
        r15 = 0;
        goto L8
    L12:
        if (r15 <= 0) goto L60;
        a(r12);
        return;
    L60:
        return;
    L15:
        StringBuilder r16 = b0.d.b();
        r16.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int r17 = r11.size();
        b0.d.a(r16, r17);
        r16.append(")");
        RoomSQLiteQuery r18 = RoomSQLiteQuery.a(r16.toString(), r17);
        Iterator<Object> r19 = r11.iterator();
        int r20 = 1;
    L17:
        if (r19.hasNext() == false) goto L23;
        String r21 = (String) r19.next();
        if (r21 != null) goto L21;
        r18.bindNull(r20);
    L22:
        r20 = r20 + 1;
        goto L17
    L21:
        r18.bindString(r20, r21);
        goto L22
    L23:
        Cursor r22 = b0.b.c(this.f5699a, r18, false, null);
        int r23 = b0.a.c(r22, "work_spec_id");     // Catch: Throwable -> L39
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L41;
        ArrayList r24 = (ArrayList) r10.get(r22.getString(r23));     // Catch: Throwable -> L39
        if (r24 == null) goto L29;
        if (r22.isNull(0) == false) goto L36;
        byte[] r25 = null;
    L37:
        r24.add(androidx.work.c.g(r25));     // Catch: Throwable -> L39
        goto L29
    L36:
        r25 = r22.getBlob(0);     // Catch: Throwable -> L39
        goto L37
    L41:
        r22.close();
        return;
    L39:
        th = move-exception;
        r22.close();
        throw th;
    }

    public final void b(ArrayMap r10) {
        Set<Object> r11 = r10.keySet();
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() <= 999) goto L15;
        ArrayMap r12 = new ArrayMap(999);
        int r13 = r10.size();
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L12;
        r12.put((String) r10.keyAt(r14), (ArrayList) r10.valueAt(r14));
        r14 = r14 + 1;
        r15 = r15 + 1;
        if (r15 != 999) goto L8;
        b(r12);
        r12 = new ArrayMap(999);
        r15 = 0;
        goto L8
    L12:
        if (r15 <= 0) goto L60;
        b(r12);
        return;
    L60:
        return;
    L15:
        StringBuilder r16 = b0.d.b();
        r16.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int r17 = r11.size();
        b0.d.a(r16, r17);
        r16.append(")");
        RoomSQLiteQuery r18 = RoomSQLiteQuery.a(r16.toString(), r17);
        Iterator<Object> r19 = r11.iterator();
        int r20 = 1;
    L17:
        if (r19.hasNext() == false) goto L23;
        String r21 = (String) r19.next();
        if (r21 != null) goto L21;
        r18.bindNull(r20);
    L22:
        r20 = r20 + 1;
        goto L17
    L21:
        r18.bindString(r20, r21);
        goto L22
    L23:
        Cursor r22 = b0.b.c(this.f5699a, r18, false, null);
        int r23 = b0.a.c(r22, "work_spec_id");     // Catch: Throwable -> L39
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L41;
        ArrayList r24 = (ArrayList) r10.get(r22.getString(r23));     // Catch: Throwable -> L39
        if (r24 == null) goto L29;
        if (r22.isNull(0) == false) goto L36;
        String r25 = null;
    L37:
        r24.add(r25);     // Catch: Throwable -> L39
        goto L29
    L36:
        r25 = r22.getString(0);     // Catch: Throwable -> L39
        goto L37
    L41:
        r22.close();
        return;
    L39:
        th = move-exception;
        r22.close();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String r10) {
        this.f5699a.d();
        SupportSQLiteStatement r11 = this.f5702d.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5702d.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5702d.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getAllEligibleWorkSpecsForScheduling(int r71) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        r10.bindLong(1, r71);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L58
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L58
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L58
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L58
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r114 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L54
        int r115 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L54
        int r116 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L54
        int r23 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L54
        int r24 = b0.a.d(r11, "generation");     // Catch: Throwable -> L54
        int r25 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L54
        int r26 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L54
        int r27 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L54
        int r28 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L54
        int r29 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L54
        int r210 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L54
        int r211 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L54
        int r212 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L54
        int r30 = r22;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L54
    L6:
        if (r11.moveToNext() == false) goto L56;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        WorkInfo.State r33 = t.f(r11.getInt(r13));     // Catch: Throwable -> L54
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.c r37 = androidx.work.c.g(r36);     // Catch: Throwable -> L54
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.c r39 = androidx.work.c.g(r38);     // Catch: Throwable -> L54
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L54
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L54
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L54
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L54
        BackoffPolicy r46 = t.c(r11.getInt(r112));     // Catch: Throwable -> L54
        long r47 = r11.getLong(r20);     // Catch: Throwable -> L54
        long r49 = r11.getLong(r21);     // Catch: Throwable -> L54
        int r41 = r30;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L54
        int r311 = r12;
        int r43 = r114;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L54
        r114 = r43;
        r115 = r115;
        if (r11.getInt(r115) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = t.e(r11.getInt(r116));     // Catch: Throwable -> L54
        r116 = r116;
        int r44 = r23;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L54
        r23 = r44;
        int r48 = r24;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L54
        r24 = r48;
        int r50 = r25;
        NetworkType r60 = t.d(r11.getInt(r50));     // Catch: Throwable -> L54
        r25 = r50;
        r26 = r26;
        if (r11.getInt(r26) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r27) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r28) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r29) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r210);     // Catch: Throwable -> L54
        r210 = r210;
        int r52 = r211;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L54
        r211 = r52;
        int r54 = r212;
        if (r11.isNull(r54) == false) goto L51;
        byte[] r213 = null;
    L52:
        androidx.work.a r410 = new androidx.work.a(r60, r61, r62, r63, r64, r65, r67, t.b(r213));     // Catch: Throwable -> L54
        r212 = r54;
        r31.add(new androidx.work.impl.model.o(r32, r33, r34, r35, r37, r39, r310, r40, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L54
        r12 = r311;
        r30 = r41;
        goto L6
    L51:
        r213 = r11.getBlob(r54);     // Catch: Throwable -> L54
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L54
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L54
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L54
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L54
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L54
        goto L12
    L56:
        r11.close();
        r113.c();
        return r31;
    L54:
        th = th;
    L60:
        r11.close();
        r113.c();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getAllUnfinishedWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L12
    L4:
        if (r11.moveToNext() == false) goto L14;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L12
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L12
        goto L10
    L14:
        r11.close();
        r10.c();
        return r12;
    L12:
        th = move-exception;
        r11.close();
        r10.c();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getAllWorkSpecIds() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id FROM workspec", 0);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L12
    L4:
        if (r11.moveToNext() == false) goto L14;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L12
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L12
        goto L10
    L14:
        r11.close();
        r10.c();
        return r12;
    L12:
        th = move-exception;
        r11.close();
        r10.c();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData getAllWorkSpecIdsLiveData() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id FROM workspec", 0);
        return this.f5699a.m().e(new String[]{"workspec"}, true, new e(this, r10));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getEligibleWorkForScheduling(int r71) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        r10.bindLong(1, r71);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L58
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L58
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L58
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L58
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r114 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L54
        int r115 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L54
        int r116 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L54
        int r23 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L54
        int r24 = b0.a.d(r11, "generation");     // Catch: Throwable -> L54
        int r25 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L54
        int r26 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L54
        int r27 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L54
        int r28 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L54
        int r29 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L54
        int r210 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L54
        int r211 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L54
        int r212 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L54
        int r30 = r22;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L54
    L6:
        if (r11.moveToNext() == false) goto L56;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        WorkInfo.State r33 = t.f(r11.getInt(r13));     // Catch: Throwable -> L54
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.c r37 = androidx.work.c.g(r36);     // Catch: Throwable -> L54
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.c r39 = androidx.work.c.g(r38);     // Catch: Throwable -> L54
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L54
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L54
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L54
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L54
        BackoffPolicy r46 = t.c(r11.getInt(r112));     // Catch: Throwable -> L54
        long r47 = r11.getLong(r20);     // Catch: Throwable -> L54
        long r49 = r11.getLong(r21);     // Catch: Throwable -> L54
        int r41 = r30;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L54
        int r311 = r12;
        int r43 = r114;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L54
        r114 = r43;
        r115 = r115;
        if (r11.getInt(r115) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = t.e(r11.getInt(r116));     // Catch: Throwable -> L54
        r116 = r116;
        int r44 = r23;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L54
        r23 = r44;
        int r48 = r24;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L54
        r24 = r48;
        int r50 = r25;
        NetworkType r60 = t.d(r11.getInt(r50));     // Catch: Throwable -> L54
        r25 = r50;
        r26 = r26;
        if (r11.getInt(r26) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r27) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r28) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r29) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r210);     // Catch: Throwable -> L54
        r210 = r210;
        int r52 = r211;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L54
        r211 = r52;
        int r54 = r212;
        if (r11.isNull(r54) == false) goto L51;
        byte[] r213 = null;
    L52:
        androidx.work.a r410 = new androidx.work.a(r60, r61, r62, r63, r64, r65, r67, t.b(r213));     // Catch: Throwable -> L54
        r212 = r54;
        r31.add(new androidx.work.impl.model.o(r32, r33, r34, r35, r37, r39, r310, r40, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L54
        r12 = r311;
        r30 = r41;
        goto L6
    L51:
        r213 = r11.getBlob(r54);     // Catch: Throwable -> L54
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L54
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L54
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L54
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L54
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L54
        goto L12
    L56:
        r11.close();
        r113.c();
        return r31;
    L54:
        th = th;
    L60:
        r11.close();
        r113.c();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getInputsFromPrerequisites(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.d();
        Cursor r12 = b0.b.c(this.f5699a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        byte[] r14 = null;
    L14:
        r13.add(androidx.work.c.g(r14));     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getBlob(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getRecentlyCompletedWork(long r70) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        r10.bindLong(1, r70);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L58
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L58
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L58
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L58
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r71 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L54
        int r114 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L54
        int r115 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L54
        int r116 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L54
        int r23 = b0.a.d(r11, "generation");     // Catch: Throwable -> L54
        int r24 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L54
        int r25 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L54
        int r26 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L54
        int r27 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L54
        int r28 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L54
        int r29 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L54
        int r210 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L54
        int r211 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L54
        int r212 = r22;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L54
    L6:
        if (r11.moveToNext() == false) goto L56;
        if (r11.isNull(r12) == false) goto L11;
        String r31 = null;
    L12:
        WorkInfo.State r32 = t.f(r11.getInt(r13));     // Catch: Throwable -> L54
        if (r11.isNull(r14) == false) goto L15;
        String r33 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r34 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r35 = null;
    L24:
        androidx.work.c r36 = androidx.work.c.g(r35);     // Catch: Throwable -> L54
        if (r11.isNull(r17) == false) goto L27;
        byte[] r37 = null;
    L28:
        androidx.work.c r38 = androidx.work.c.g(r37);     // Catch: Throwable -> L54
        long r39 = r11.getLong(r18);     // Catch: Throwable -> L54
        long r310 = r11.getLong(r19);     // Catch: Throwable -> L54
        long r41 = r11.getLong(r110);     // Catch: Throwable -> L54
        int r44 = r11.getInt(r111);     // Catch: Throwable -> L54
        BackoffPolicy r45 = t.c(r11.getInt(r112));     // Catch: Throwable -> L54
        long r46 = r11.getLong(r20);     // Catch: Throwable -> L54
        long r48 = r11.getLong(r21);     // Catch: Throwable -> L54
        int r40 = r212;
        long r50 = r11.getLong(r40);     // Catch: Throwable -> L54
        int r213 = r12;
        int r42 = r71;
        long r52 = r11.getLong(r42);     // Catch: Throwable -> L54
        r71 = r42;
        r114 = r114;
        if (r11.getInt(r114) == 0) goto L31;
        boolean r54 = true;
    L32:
        OutOfQuotaPolicy r55 = t.e(r11.getInt(r115));     // Catch: Throwable -> L54
        r115 = r115;
        int r43 = r116;
        int r56 = r11.getInt(r43);     // Catch: Throwable -> L54
        r116 = r43;
        int r47 = r23;
        int r57 = r11.getInt(r47);     // Catch: Throwable -> L54
        r23 = r47;
        int r49 = r24;
        NetworkType r59 = t.d(r11.getInt(r49));     // Catch: Throwable -> L54
        r24 = r49;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r60 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r61 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r62 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r63 = true;
    L48:
        long r64 = r11.getLong(r29);     // Catch: Throwable -> L54
        r29 = r29;
        int r51 = r210;
        long r66 = r11.getLong(r51);     // Catch: Throwable -> L54
        r210 = r51;
        int r53 = r211;
        if (r11.isNull(r53) == false) goto L51;
        byte[] r214 = null;
    L52:
        androidx.work.a r410 = new androidx.work.a(r59, r60, r61, r62, r63, r64, r66, t.b(r214));     // Catch: Throwable -> L54
        r211 = r53;
        r30.add(new androidx.work.impl.model.o(r31, r32, r33, r34, r36, r38, r39, r310, r41, r410, r44, r45, r46, r48, r50, r52, r54, r55, r56, r57));     // Catch: Throwable -> L54
        r12 = r213;
        r212 = r40;
        goto L6
    L51:
        r214 = r11.getBlob(r53);     // Catch: Throwable -> L54
        goto L52
    L47:
        r63 = false;
        goto L48
    L43:
        r62 = false;
        goto L45
    L39:
        r61 = false;
        goto L41
    L35:
        r60 = false;
        goto L37
    L31:
        r54 = false;
        goto L32
    L27:
        r37 = r11.getBlob(r17);     // Catch: Throwable -> L54
        goto L28
    L23:
        r35 = r11.getBlob(r16);     // Catch: Throwable -> L54
        goto L24
    L19:
        r34 = r11.getString(r15);     // Catch: Throwable -> L54
        goto L21
    L15:
        r33 = r11.getString(r14);     // Catch: Throwable -> L54
        goto L17
    L11:
        r31 = r11.getString(r12);     // Catch: Throwable -> L54
        goto L12
    L56:
        r11.close();
        r113.c();
        return r30;
    L54:
        th = th;
    L60:
        r11.close();
        r113.c();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getRunningWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE state=1", 0);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L58
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L58
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L58
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L58
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r114 = r10;
        int r115 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L54
        int r116 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L54
        int r117 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L54
        int r22 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L54
        int r23 = b0.a.d(r11, "generation");     // Catch: Throwable -> L54
        int r24 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L54
        int r25 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L54
        int r26 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L54
        int r27 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L54
        int r28 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L54
        int r29 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L54
        int r210 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L54
        int r211 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L54
        int r30 = r21;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L54
    L6:
        if (r11.moveToNext() == false) goto L56;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        WorkInfo.State r33 = t.f(r11.getInt(r13));     // Catch: Throwable -> L54
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.c r37 = androidx.work.c.g(r36);     // Catch: Throwable -> L54
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.c r39 = androidx.work.c.g(r38);     // Catch: Throwable -> L54
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L54
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L54
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L54
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L54
        BackoffPolicy r46 = t.c(r11.getInt(r112));     // Catch: Throwable -> L54
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L54
        long r49 = r11.getLong(r20);     // Catch: Throwable -> L54
        int r41 = r30;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L54
        int r311 = r12;
        int r43 = r115;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L54
        r115 = r43;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = t.e(r11.getInt(r117));     // Catch: Throwable -> L54
        r117 = r117;
        int r44 = r22;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L54
        r22 = r44;
        int r48 = r23;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L54
        r23 = r48;
        int r50 = r24;
        NetworkType r60 = t.d(r11.getInt(r50));     // Catch: Throwable -> L54
        r24 = r50;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r29);     // Catch: Throwable -> L54
        r29 = r29;
        int r52 = r210;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L54
        r210 = r52;
        int r54 = r211;
        if (r11.isNull(r54) == false) goto L51;
        byte[] r212 = null;
    L52:
        androidx.work.a r410 = new androidx.work.a(r60, r61, r62, r63, r64, r65, r67, t.b(r212));     // Catch: Throwable -> L54
        r211 = r54;
        r31.add(new androidx.work.impl.model.o(r32, r33, r34, r35, r37, r39, r310, r40, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L54
        r12 = r311;
        r30 = r41;
        goto L6
    L51:
        r212 = r11.getBlob(r54);     // Catch: Throwable -> L54
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L54
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L54
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L54
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L54
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L54
        goto L12
    L56:
        r11.close();
        r114.c();
        return r31;
    L54:
        th = th;
    L60:
        r11.close();
        r114.c();
        throw th;
    L58:
        th = th;
        r114 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData getScheduleRequestedAtLiveData(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.f5699a.m().e(new String[]{"workspec"}, false, new i(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getScheduledWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L58
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L58
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L58
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L58
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r114 = r10;
        int r115 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L54
        int r116 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L54
        int r117 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L54
        int r22 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L54
        int r23 = b0.a.d(r11, "generation");     // Catch: Throwable -> L54
        int r24 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L54
        int r25 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L54
        int r26 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L54
        int r27 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L54
        int r28 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L54
        int r29 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L54
        int r210 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L54
        int r211 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L54
        int r30 = r21;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L54
    L6:
        if (r11.moveToNext() == false) goto L56;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        WorkInfo.State r33 = t.f(r11.getInt(r13));     // Catch: Throwable -> L54
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.c r37 = androidx.work.c.g(r36);     // Catch: Throwable -> L54
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.c r39 = androidx.work.c.g(r38);     // Catch: Throwable -> L54
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L54
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L54
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L54
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L54
        BackoffPolicy r46 = t.c(r11.getInt(r112));     // Catch: Throwable -> L54
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L54
        long r49 = r11.getLong(r20);     // Catch: Throwable -> L54
        int r41 = r30;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L54
        int r311 = r12;
        int r43 = r115;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L54
        r115 = r43;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = t.e(r11.getInt(r117));     // Catch: Throwable -> L54
        r117 = r117;
        int r44 = r22;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L54
        r22 = r44;
        int r48 = r23;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L54
        r23 = r48;
        int r50 = r24;
        NetworkType r60 = t.d(r11.getInt(r50));     // Catch: Throwable -> L54
        r24 = r50;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r29);     // Catch: Throwable -> L54
        r29 = r29;
        int r52 = r210;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L54
        r210 = r52;
        int r54 = r211;
        if (r11.isNull(r54) == false) goto L51;
        byte[] r212 = null;
    L52:
        androidx.work.a r410 = new androidx.work.a(r60, r61, r62, r63, r64, r65, r67, t.b(r212));     // Catch: Throwable -> L54
        r211 = r54;
        r31.add(new androidx.work.impl.model.o(r32, r33, r34, r35, r37, r39, r310, r40, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L54
        r12 = r311;
        r30 = r41;
        goto L6
    L51:
        r212 = r11.getBlob(r54);     // Catch: Throwable -> L54
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L54
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L54
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L54
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L54
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L54
        goto L12
    L56:
        r11.close();
        r114.c();
        return r31;
    L54:
        th = th;
    L60:
        r11.close();
        r114.c();
        throw th;
    L58:
        th = th;
        r114 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT state FROM workspec WHERE id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.d();
        WorkInfo.State r12 = null;
        Cursor r13 = b0.b.c(this.f5699a, r11, false, null);
    L17:
        th = move-exception;
        r13.close();
        r11.c();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L19:
        r13.close();
        r11.c();
        return r12;
    L10:
        if (r13.isNull(0) == false) goto L12;
        Integer r14 = null;
    L13:
        if (r14 == null) goto L19;
        t r15 = t.f5743a;     // Catch: Throwable -> L17
        r12 = t.f(r14.intValue());     // Catch: Throwable -> L17
        goto L19
    L12:
        r14 = Integer.valueOf(r13.getInt(0));     // Catch: Throwable -> L17
        goto L13
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getUnfinishedWorkWithName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.d();
        Cursor r12 = b0.b.c(this.f5699a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getUnfinishedWorkWithTag(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.d();
        Cursor r12 = b0.b.c(this.f5699a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public androidx.work.impl.model.o getWorkSpec(String r69) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT * FROM workspec WHERE id=?", 1);
        if (r69 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.f5699a.d();
        Cursor r11 = b0.b.c(this.f5699a, r10, false, null);
        int r12 = b0.a.d(r11, "id");     // Catch: Throwable -> L62
        int r13 = b0.a.d(r11, WsConstants.KEY_CONNECTION_STATE);     // Catch: Throwable -> L62
        int r14 = b0.a.d(r11, "worker_class_name");     // Catch: Throwable -> L62
        int r15 = b0.a.d(r11, "input_merger_class_name");     // Catch: Throwable -> L62
        int r16 = b0.a.d(r11, "input");     // Catch: Throwable -> L62
        int r17 = b0.a.d(r11, "output");     // Catch: Throwable -> L62
        int r18 = b0.a.d(r11, "initial_delay");     // Catch: Throwable -> L62
        int r19 = b0.a.d(r11, "interval_duration");     // Catch: Throwable -> L62
        int r110 = b0.a.d(r11, "flex_duration");     // Catch: Throwable -> L62
        int r111 = b0.a.d(r11, "run_attempt_count");     // Catch: Throwable -> L62
        int r112 = b0.a.d(r11, "backoff_policy");     // Catch: Throwable -> L62
        int r20 = b0.a.d(r11, "backoff_delay_duration");     // Catch: Throwable -> L62
        int r21 = b0.a.d(r11, "last_enqueue_time");     // Catch: Throwable -> L62
        int r22 = b0.a.d(r11, "minimum_retention_duration");     // Catch: Throwable -> L62
        RoomSQLiteQuery r113 = r10;
        int r23 = b0.a.d(r11, "schedule_requested_at");     // Catch: Throwable -> L57
        int r24 = b0.a.d(r11, "run_in_foreground");     // Catch: Throwable -> L57
        int r25 = b0.a.d(r11, "out_of_quota_policy");     // Catch: Throwable -> L57
        int r26 = b0.a.d(r11, "period_count");     // Catch: Throwable -> L57
        int r27 = b0.a.d(r11, "generation");     // Catch: Throwable -> L57
        int r28 = b0.a.d(r11, "required_network_type");     // Catch: Throwable -> L57
        int r29 = b0.a.d(r11, "requires_charging");     // Catch: Throwable -> L57
        int r30 = b0.a.d(r11, "requires_device_idle");     // Catch: Throwable -> L57
        int r31 = b0.a.d(r11, "requires_battery_not_low");     // Catch: Throwable -> L57
        int r32 = b0.a.d(r11, "requires_storage_not_low");     // Catch: Throwable -> L57
        int r33 = b0.a.d(r11, "trigger_content_update_delay");     // Catch: Throwable -> L57
        int r34 = b0.a.d(r11, "trigger_max_content_delay");     // Catch: Throwable -> L57
        int r35 = b0.a.d(r11, "content_uri_triggers");     // Catch: Throwable -> L57
        if (r11.moveToFirst() == true) goto L12;
        androidx.work.impl.model.o r36 = null;
    L60:
        r11.close();
        r113.c();
        return r36;
    L12:
        if (r11.isNull(r12) == false) goto L14;
        String r37 = null;
    L15:
        WorkInfo.State r38 = t.f(r11.getInt(r13));     // Catch: Throwable -> L57
        if (r11.isNull(r14) == false) goto L18;
        String r39 = null;
    L20:
        if (r11.isNull(r15) == false) goto L22;
        String r310 = null;
    L24:
        if (r11.isNull(r16) == false) goto L26;
        byte[] r40 = null;
    L27:
        androidx.work.c r311 = androidx.work.c.g(r40);     // Catch: Throwable -> L57
        if (r11.isNull(r17) == false) goto L30;
        byte[] r41 = null;
    L31:
        androidx.work.c r312 = androidx.work.c.g(r41);     // Catch: Throwable -> L57
        long r313 = r11.getLong(r18);     // Catch: Throwable -> L57
        long r314 = r11.getLong(r19);     // Catch: Throwable -> L57
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L57
        int r43 = r11.getInt(r111);     // Catch: Throwable -> L57
        BackoffPolicy r44 = t.c(r11.getInt(r112));     // Catch: Throwable -> L57
        long r45 = r11.getLong(r20);     // Catch: Throwable -> L57
        long r47 = r11.getLong(r21);     // Catch: Throwable -> L57
        long r49 = r11.getLong(r22);     // Catch: Throwable -> L57
        long r51 = r11.getLong(r23);     // Catch: Throwable -> L57
        if (r11.getInt(r24) == 0) goto L34;
        boolean r53 = true;
    L35:
        OutOfQuotaPolicy r54 = t.e(r11.getInt(r25));     // Catch: Throwable -> L57
        int r55 = r11.getInt(r26);     // Catch: Throwable -> L57
        int r56 = r11.getInt(r27);     // Catch: Throwable -> L57
        NetworkType r58 = t.d(r11.getInt(r28));     // Catch: Throwable -> L57
        if (r11.getInt(r29) == 0) goto L38;
        boolean r59 = true;
    L40:
        if (r11.getInt(r30) == 0) goto L42;
        boolean r60 = true;
    L44:
        if (r11.getInt(r31) == 0) goto L46;
        boolean r61 = true;
    L48:
        if (r11.getInt(r32) == 0) goto L50;
        boolean r62 = true;
    L51:
        long r63 = r11.getLong(r33);     // Catch: Throwable -> L57
        long r65 = r11.getLong(r34);     // Catch: Throwable -> L57
        if (r11.isNull(r35) == false) goto L54;
        byte[] r46 = null;
    L55:
        r36 = new androidx.work.impl.model.o(r37, r38, r39, r310, r311, r312, r313, r314, r42, new androidx.work.a(r58, r59, r60, r61, r62, r63, r65, t.b(r46)), r43, r44, r45, r47, r49, r51, r53, r54, r55, r56);     // Catch: Throwable -> L57
        goto L60
    L54:
        r46 = r11.getBlob(r35);     // Catch: Throwable -> L57
        goto L55
    L50:
        r62 = false;
        goto L51
    L46:
        r61 = false;
        goto L48
    L42:
        r60 = false;
        goto L44
    L38:
        r59 = false;
        goto L40
    L34:
        r53 = false;
        goto L35
    L30:
        r41 = r11.getBlob(r17);     // Catch: Throwable -> L57
        goto L31
    L26:
        r40 = r11.getBlob(r16);     // Catch: Throwable -> L57
        goto L27
    L22:
        r310 = r11.getString(r15);     // Catch: Throwable -> L57
        goto L24
    L18:
        r39 = r11.getString(r14);     // Catch: Throwable -> L57
        goto L20
    L14:
        r37 = r11.getString(r12);     // Catch: Throwable -> L57
    L57:
        th = th;
    L64:
        r11.close();
        r113.c();
        throw th;
    L62:
        th = th;
        r113 = r10;
        goto L64
    L5:
        r10.bindString(1, r69);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getWorkSpecIdAndStatesForName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.d();
        Cursor r12 = b0.b.c(this.f5699a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(new androidx.work.impl.model.o.b(r14, t.f(r12.getInt(1))));     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public androidx.work.impl.model.o.c getWorkStatusPojoForId(String r18) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?", 1);
        if (r18 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.f5699a.d();
        this.f5699a.e();
        androidx.work.impl.model.o.c r11 = null;
        byte[] r12 = null;
        Cursor r13 = b0.b.c(this.f5699a, r10, true, null);     // Catch: Throwable -> L40
        ArrayMap r14 = new ArrayMap();     // Catch: Throwable -> L14
        ArrayMap r15 = new ArrayMap();     // Catch: Throwable -> L14
    L10:
        if (r13.moveToNext() == false) goto L19;
        String r16 = r13.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r14.get(r16)) != null) goto L16;
        r14.put(r16, new ArrayList());     // Catch: Throwable -> L14
    L16:
        String r17 = r13.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r15.get(r17)) != null) goto L10;
        r15.put(r17, new ArrayList());     // Catch: Throwable -> L14
        goto L10
    L19:
        r13.moveToPosition(-1);     // Catch: Throwable -> L14
        b(r14);     // Catch: Throwable -> L14
        a(r15);     // Catch: Throwable -> L14
        if (r13.moveToFirst() == true) goto L22;
    L36:
        this.f5699a.D();     // Catch: Throwable -> L14
        r13.close();     // Catch: Throwable -> L40
        r10.c();     // Catch: Throwable -> L40
        this.f5699a.i();
        return r11;
    L22:
        if (r13.isNull(0) == false) goto L24;
        String r19 = null;
    L25:
        WorkInfo.State r110 = t.f(r13.getInt(1));     // Catch: Throwable -> L14
        if (r13.isNull(2) == true) goto L29;
        r12 = r13.getBlob(2);     // Catch: Throwable -> L14
    L29:
        androidx.work.c r111 = androidx.work.c.g(r12);     // Catch: Throwable -> L14
        int r112 = r13.getInt(3);     // Catch: Throwable -> L14
        int r113 = r13.getInt(4);     // Catch: Throwable -> L14
        ArrayList r20 = (ArrayList) r14.get(r13.getString(0));     // Catch: Throwable -> L14
        if (r20 != null) goto L32;
        r20 = new ArrayList();     // Catch: Throwable -> L14
    L32:
        ArrayList r114 = r20;
        ArrayList r21 = (ArrayList) r15.get(r13.getString(0));     // Catch: Throwable -> L14
        if (r21 != null) goto L35;
        r21 = new ArrayList();     // Catch: Throwable -> L14
    L35:
        r11 = new androidx.work.impl.model.o.c(r19, r110, r111, r112, r113, r114, r21);     // Catch: Throwable -> L14
        goto L36
    L24:
        r19 = r13.getString(0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L40
        r10.c();     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        this.f5699a.i();
        throw th;
    L5:
        r10.bindString(1, r18);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForIds(List r19) {
        StringBuilder r10 = b0.d.b();
        r10.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r11 = r19.size();
        b0.d.a(r10, r11);
        r10.append(")");
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a(r10.toString(), r11);
        Iterator r13 = r19.iterator();
        int r14 = 1;
    L4:
        if (r13.hasNext() == false) goto L10;
        String r15 = (String) r13.next();
        if (r15 != null) goto L8;
        r12.bindNull(r14);
    L9:
        r14 = r14 + 1;
        goto L4
    L8:
        r12.bindString(r14, r15);
        goto L9
    L10:
        this.f5699a.d();
        this.f5699a.e();
        Cursor r16 = b0.b.c(this.f5699a, r12, true, null);     // Catch: Throwable -> L45
        ArrayMap r17 = new ArrayMap();     // Catch: Throwable -> L18
        ArrayMap r18 = new ArrayMap();     // Catch: Throwable -> L18
    L14:
        if (r16.moveToNext() == false) goto L23;
        String r20 = r16.getString(0);     // Catch: Throwable -> L18
        if (((ArrayList) r17.get(r20)) != null) goto L20;
        r17.put(r20, new ArrayList());     // Catch: Throwable -> L18
    L20:
        String r21 = r16.getString(0);     // Catch: Throwable -> L18
        if (((ArrayList) r18.get(r21)) != null) goto L14;
        r18.put(r21, new ArrayList());     // Catch: Throwable -> L18
        goto L14
    L23:
        r16.moveToPosition(-1);     // Catch: Throwable -> L18
        b(r17);     // Catch: Throwable -> L18
        a(r18);     // Catch: Throwable -> L18
        ArrayList r22 = new ArrayList(r16.getCount());     // Catch: Throwable -> L18
    L25:
        if (r16.moveToNext() == false) goto L41;
        if (r16.isNull(0) == false) goto L29;
        String r110 = null;
    L30:
        WorkInfo.State r111 = t.f(r16.getInt(1));     // Catch: Throwable -> L18
        if (r16.isNull(2) == false) goto L33;
        byte[] r23 = null;
    L34:
        androidx.work.c r112 = androidx.work.c.g(r23);     // Catch: Throwable -> L18
        int r113 = r16.getInt(3);     // Catch: Throwable -> L18
        int r114 = r16.getInt(4);     // Catch: Throwable -> L18
        ArrayList r24 = (ArrayList) r17.get(r16.getString(0));     // Catch: Throwable -> L18
        if (r24 != null) goto L37;
        r24 = new ArrayList();     // Catch: Throwable -> L18
    L37:
        ArrayList r115 = r24;
        ArrayList r25 = (ArrayList) r18.get(r16.getString(0));     // Catch: Throwable -> L18
        if (r25 != null) goto L40;
        r25 = new ArrayList();     // Catch: Throwable -> L18
    L40:
        r22.add(new androidx.work.impl.model.o.c(r110, r111, r112, r113, r114, r115, r25));     // Catch: Throwable -> L18
        goto L25
    L33:
        r23 = r16.getBlob(2);     // Catch: Throwable -> L18
        goto L34
    L29:
        r110 = r16.getString(0);     // Catch: Throwable -> L18
        goto L30
    L41:
        this.f5699a.D();     // Catch: Throwable -> L18
        r16.close();     // Catch: Throwable -> L45
        r12.c();     // Catch: Throwable -> L45
        this.f5699a.i();
        return r22;
    L18:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L45
        r12.c();     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        this.f5699a.i();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForName(String r19) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r19 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.f5699a.d();
        this.f5699a.e();
        Cursor r11 = b0.b.c(this.f5699a, r10, true, null);     // Catch: Throwable -> L41
        ArrayMap r12 = new ArrayMap();     // Catch: Throwable -> L14
        ArrayMap r13 = new ArrayMap();     // Catch: Throwable -> L14
    L10:
        if (r11.moveToNext() == false) goto L19;
        String r14 = r11.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r12.get(r14)) != null) goto L16;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L14
    L16:
        String r15 = r11.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r13.get(r15)) != null) goto L10;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L14
        goto L10
    L19:
        r11.moveToPosition(-1);     // Catch: Throwable -> L14
        b(r12);     // Catch: Throwable -> L14
        a(r13);     // Catch: Throwable -> L14
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L21:
        if (r11.moveToNext() == false) goto L37;
        if (r11.isNull(0) == false) goto L25;
        String r17 = null;
    L26:
        WorkInfo.State r18 = t.f(r11.getInt(1));     // Catch: Throwable -> L14
        if (r11.isNull(2) == false) goto L29;
        byte[] r20 = null;
    L30:
        androidx.work.c r110 = androidx.work.c.g(r20);     // Catch: Throwable -> L14
        int r111 = r11.getInt(3);     // Catch: Throwable -> L14
        int r112 = r11.getInt(4);     // Catch: Throwable -> L14
        ArrayList r21 = (ArrayList) r12.get(r11.getString(0));     // Catch: Throwable -> L14
        if (r21 != null) goto L33;
        r21 = new ArrayList();     // Catch: Throwable -> L14
    L33:
        ArrayList r113 = r21;
        ArrayList r22 = (ArrayList) r13.get(r11.getString(0));     // Catch: Throwable -> L14
        if (r22 != null) goto L36;
        r22 = new ArrayList();     // Catch: Throwable -> L14
    L36:
        r16.add(new androidx.work.impl.model.o.c(r17, r18, r110, r111, r112, r113, r22));     // Catch: Throwable -> L14
        goto L21
    L29:
        r20 = r11.getBlob(2);     // Catch: Throwable -> L14
        goto L30
    L25:
        r17 = r11.getString(0);     // Catch: Throwable -> L14
        goto L26
    L37:
        this.f5699a.D();     // Catch: Throwable -> L14
        r11.close();     // Catch: Throwable -> L41
        r10.c();     // Catch: Throwable -> L41
        this.f5699a.i();
        return r16;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L41
        r10.c();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.f5699a.i();
        throw th;
    L5:
        r10.bindString(1, r19);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForTag(String r19) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r19 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.f5699a.d();
        this.f5699a.e();
        Cursor r11 = b0.b.c(this.f5699a, r10, true, null);     // Catch: Throwable -> L41
        ArrayMap r12 = new ArrayMap();     // Catch: Throwable -> L14
        ArrayMap r13 = new ArrayMap();     // Catch: Throwable -> L14
    L10:
        if (r11.moveToNext() == false) goto L19;
        String r14 = r11.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r12.get(r14)) != null) goto L16;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L14
    L16:
        String r15 = r11.getString(0);     // Catch: Throwable -> L14
        if (((ArrayList) r13.get(r15)) != null) goto L10;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L14
        goto L10
    L19:
        r11.moveToPosition(-1);     // Catch: Throwable -> L14
        b(r12);     // Catch: Throwable -> L14
        a(r13);     // Catch: Throwable -> L14
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L21:
        if (r11.moveToNext() == false) goto L37;
        if (r11.isNull(0) == false) goto L25;
        String r17 = null;
    L26:
        WorkInfo.State r18 = t.f(r11.getInt(1));     // Catch: Throwable -> L14
        if (r11.isNull(2) == false) goto L29;
        byte[] r20 = null;
    L30:
        androidx.work.c r110 = androidx.work.c.g(r20);     // Catch: Throwable -> L14
        int r111 = r11.getInt(3);     // Catch: Throwable -> L14
        int r112 = r11.getInt(4);     // Catch: Throwable -> L14
        ArrayList r21 = (ArrayList) r12.get(r11.getString(0));     // Catch: Throwable -> L14
        if (r21 != null) goto L33;
        r21 = new ArrayList();     // Catch: Throwable -> L14
    L33:
        ArrayList r113 = r21;
        ArrayList r22 = (ArrayList) r13.get(r11.getString(0));     // Catch: Throwable -> L14
        if (r22 != null) goto L36;
        r22 = new ArrayList();     // Catch: Throwable -> L14
    L36:
        r16.add(new androidx.work.impl.model.o.c(r17, r18, r110, r111, r112, r113, r22));     // Catch: Throwable -> L14
        goto L21
    L29:
        r20 = r11.getBlob(2);     // Catch: Throwable -> L14
        goto L30
    L25:
        r17 = r11.getString(0);     // Catch: Throwable -> L14
        goto L26
    L37:
        this.f5699a.D();     // Catch: Throwable -> L14
        r11.close();     // Catch: Throwable -> L41
        r10.c();     // Catch: Throwable -> L41
        this.f5699a.i();
        return r16;
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L41
        r10.c();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.f5699a.i();
        throw th;
    L5:
        r10.bindString(1, r19);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForIds(List r10) {
        StringBuilder r11 = b0.d.b();
        r11.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r12 = r10.size();
        b0.d.a(r11, r12);
        r11.append(")");
        RoomSQLiteQuery r13 = RoomSQLiteQuery.a(r11.toString(), r12);
        Iterator r14 = r10.iterator();
        int r15 = 1;
    L4:
        if (r14.hasNext() == false) goto L11;
        String r16 = (String) r14.next();
        if (r16 != null) goto L8;
        r13.bindNull(r15);
    L9:
        r15 = r15 + 1;
        goto L4
    L8:
        r13.bindString(r15, r16);
        goto L9
    L11:
        return this.f5699a.m().e(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new f(this, r13));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.f5699a.m().e(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new h(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForTag(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.f5699a.m().e(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new g(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean hasUnfinishedWork() {
        boolean r10 = false;
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f5699a.d();
        Cursor r12 = b0.b.c(this.f5699a, r11, false, null);
    L8:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L4:
        if (r12.moveToFirst() == false) goto L10;
        if (r12.getInt(0) == 0) goto L10;
        r10 = true;
    L10:
        r12.close();
        r11.c();
        return r10;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(String r10) {
        this.f5699a.d();
        SupportSQLiteStatement r11 = this.f5712n.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5712n.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5712n.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(String r10) {
        this.f5699a.d();
        SupportSQLiteStatement r11 = this.f5704f.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5704f.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5704f.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String r10) {
        this.f5699a.d();
        SupportSQLiteStatement r11 = this.f5707i.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.e();
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5707i.h(r11);
        return r12;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5707i.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(androidx.work.impl.model.o r10) {
        this.f5699a.d();
        this.f5699a.e();
        this.f5700b.j(r10);     // Catch: Throwable -> L6
        this.f5699a.D();     // Catch: Throwable -> L6
        this.f5699a.i();
        return;
    L6:
        th = move-exception;
        this.f5699a.i();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String r10, long r11) {
        this.f5699a.d();
        SupportSQLiteStatement r12 = this.f5709k.b();
        r12.bindLong(1, r11);
        if (r10 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.f5699a.e();
        int r13 = r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5709k.h(r12);
        return r13;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5709k.h(r12);
        throw th;
    L5:
        r12.bindString(2, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.f5699a.d();
        SupportSQLiteStatement r10 = this.f5711m.b();
        this.f5699a.e();
        r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f5699a.D();     // Catch: Throwable -> L6
        this.f5699a.i();
        this.f5711m.h(r10);
        return;
    L6:
        th = move-exception;
        this.f5699a.i();
        this.f5711m.h(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.f5699a.d();
        SupportSQLiteStatement r10 = this.f5710l.b();
        this.f5699a.e();
        int r11 = r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f5699a.D();     // Catch: Throwable -> L6
        this.f5699a.i();
        this.f5710l.h(r10);
        return r11;
    L6:
        th = move-exception;
        this.f5699a.i();
        this.f5710l.h(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String r10) {
        this.f5699a.d();
        SupportSQLiteStatement r11 = this.f5708j.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5699a.e();
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5708j.h(r11);
        return r12;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5708j.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueuedTime(String r10, long r11) {
        this.f5699a.d();
        SupportSQLiteStatement r12 = this.f5706h.b();
        r12.bindLong(1, r11);
        if (r10 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.f5699a.e();
        r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5706h.h(r12);
        return;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5706h.h(r12);
        throw th;
    L5:
        r12.bindString(2, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String r10, androidx.work.c r11) {
        this.f5699a.d();
        SupportSQLiteStatement r12 = this.f5705g.b();
        byte[] r13 = androidx.work.c.k(r11);
        if (r13 != null) goto L5;
        r12.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r12.bindNull(2);
    L10:
        this.f5699a.e();
        r12.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f5699a.D();     // Catch: Throwable -> L14
        this.f5699a.i();
        this.f5705g.h(r12);
        return;
    L14:
        th = move-exception;
        this.f5699a.i();
        this.f5705g.h(r12);
        throw th;
    L9:
        r12.bindString(2, r10);
        goto L10
    L5:
        r12.bindBlob(1, r13);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State r10, String r11) {
        this.f5699a.d();
        SupportSQLiteStatement r12 = this.f5703e.b();
        r12.bindLong(1, t.j(r10));
        if (r11 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.f5699a.e();
        int r13 = r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5699a.D();     // Catch: Throwable -> L10
        this.f5699a.i();
        this.f5703e.h(r12);
        return r13;
    L10:
        th = move-exception;
        this.f5699a.i();
        this.f5703e.h(r12);
        throw th;
    L5:
        r12.bindString(2, r11);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(androidx.work.impl.model.o r10) {
        this.f5699a.d();
        this.f5699a.e();
        this.f5701c.j(r10);     // Catch: Throwable -> L6
        this.f5699a.D();     // Catch: Throwable -> L6
        this.f5699a.i();
        return;
    L6:
        th = move-exception;
        this.f5699a.i();
        throw th;
    }
}
