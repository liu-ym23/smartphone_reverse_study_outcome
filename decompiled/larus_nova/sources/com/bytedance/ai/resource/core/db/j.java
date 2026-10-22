package com.bytedance.ai.resource.core.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes43.dex */
public final class j extends AIPackageDao {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase f37376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.db.n f37377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h5.h f37378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.db.q f37379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.db.t f37380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f37381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f37382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y f37383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f37384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f37385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.db.e f37386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.db.g f37387m;

    public class a implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Widget f37388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37389b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.f37389b.f37376b.beginTransaction();
            this.f37389b.f37380f.handle(this.f37388a);     // Catch: Throwable -> L6
            this.f37389b.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L6
            Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
            this.f37389b.f37376b.endTransaction();
            return r100;
        L6:
            th = move-exception;
            this.f37389b.f37376b.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public a(j r100, Widget r101) {
            this.f37389b = r100;
            this.f37388a = r101;
        }
    }

    public class b implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Applet f37390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37391b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.f37391b.f37376b.beginTransaction();
            this.f37391b.f37381g.handle(this.f37390a);     // Catch: Throwable -> L6
            this.f37391b.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L6
            Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
            this.f37391b.f37376b.endTransaction();
            return r100;
        L6:
            th = move-exception;
            this.f37391b.f37376b.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public b(j r100, Applet r101) {
            this.f37391b = r100;
            this.f37390a = r101;
        }
    }

    public class c implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f37394c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r100 = this.f37394c.f37384j.acquire();
            String r101 = this.f37392a;
            if (r101 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r102 = this.f37393b;
            if (r102 != null) goto L9;
            r100.bindNull(2);
        L10:
            this.f37394c.f37376b.beginTransaction();
            r100.executeUpdateDelete();     // Catch: Throwable -> L14
            this.f37394c.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.f37394c.f37376b.endTransaction();
            this.f37394c.f37384j.release(r100);
            return r103;
        L14:
            th = move-exception;
            this.f37394c.f37376b.endTransaction();
            this.f37394c.f37384j.release(r100);
            throw th;
        L9:
            r100.bindString(2, r102);
            goto L10
        L5:
            r100.bindString(1, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public c(j r100, String r101, String r102) {
            this.f37394c = r100;
            this.f37392a = r101;
            this.f37393b = r102;
        }
    }

    public class d implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f37397c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r100 = this.f37397c.f37385k.acquire();
            String r101 = this.f37395a;
            if (r101 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r102 = this.f37396b;
            if (r102 != null) goto L9;
            r100.bindNull(2);
        L10:
            this.f37397c.f37376b.beginTransaction();
            r100.executeUpdateDelete();     // Catch: Throwable -> L14
            this.f37397c.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.f37397c.f37376b.endTransaction();
            this.f37397c.f37385k.release(r100);
            return r103;
        L14:
            th = move-exception;
            this.f37397c.f37376b.endTransaction();
            this.f37397c.f37385k.release(r100);
            throw th;
        L9:
            r100.bindString(2, r102);
            goto L10
        L5:
            r100.bindString(1, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public d(j r100, String r101, String r102) {
            this.f37397c = r100;
            this.f37395a = r101;
            this.f37396b = r102;
        }
    }

    public class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f37400c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r100 = this.f37400c.f37386l.acquire();
            String r101 = this.f37398a;
            if (r101 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r102 = this.f37399b;
            if (r102 != null) goto L9;
            r100.bindNull(2);
        L10:
            this.f37400c.f37376b.beginTransaction();
            r100.executeUpdateDelete();     // Catch: Throwable -> L14
            this.f37400c.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.f37400c.f37376b.endTransaction();
            this.f37400c.f37386l.release(r100);
            return r103;
        L14:
            th = move-exception;
            this.f37400c.f37376b.endTransaction();
            this.f37400c.f37386l.release(r100);
            throw th;
        L9:
            r100.bindString(2, r102);
            goto L10
        L5:
            r100.bindString(1, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public e(j r100, String r101, String r102) {
            this.f37400c = r100;
            this.f37398a = r101;
            this.f37399b = r102;
        }
    }

    public class f implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f37401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f37403c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r100 = this.f37403c.f37387m.acquire();
            String r101 = this.f37401a;
            if (r101 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r102 = this.f37402b;
            if (r102 != null) goto L9;
            r100.bindNull(2);
        L10:
            this.f37403c.f37376b.beginTransaction();
            r100.executeUpdateDelete();     // Catch: Throwable -> L14
            this.f37403c.f37376b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.f37403c.f37376b.endTransaction();
            this.f37403c.f37387m.release(r100);
            return r103;
        L14:
            th = move-exception;
            this.f37403c.f37376b.endTransaction();
            this.f37403c.f37387m.release(r100);
            throw th;
        L9:
            r100.bindString(2, r102);
            goto L10
        L5:
            r100.bindString(1, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public f(j r100, String r101, String r102) {
            this.f37403c = r100;
            this.f37401a = r101;
            this.f37402b = r102;
        }
    }

    public class g implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37405b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37405b.f37376b, this.f37404a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            g r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37405b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37404a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37405b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37404a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public g(j r100, RoomSQLiteQuery r101) {
            this.f37405b = r100;
            this.f37404a = r101;
        }
    }

    public class h implements Callable<Widget> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37407b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Widget call() throws Exception {
            Cursor r100 = DBUtil.query(this.f37407b.f37376b, this.f37406a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L110
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L110
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L110
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L110
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L110
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L110
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L110
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L110
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L110
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L110
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L110
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L110
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L110
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L110
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L108
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L108
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L108
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L108
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L108
            int r120 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L108
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L108
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L108
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L108
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L108
            int r125 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L108
            int r126 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L108
            int r127 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L108
            int r128 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L108
            int r129 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L108
            int r130 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L108
            int r131 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L108
            int r132 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L108
            int r133 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L108
            int r134 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L108
            int r135 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L108
            if (r100.moveToFirst() == true) goto L7;
            h r136 = this;
            Widget r137 = null;
        L106:
            r100.close();
            r136.f37406a.release();
            return r137;
        L7:
            if (r100.isNull(r101) == false) goto L9;
            String r510 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r511 = null;
        L15:
            if (r100.isNull(r103) == false) goto L17;
            String r512 = null;
        L19:
            if (r100.isNull(r104) == false) goto L21;
            String r513 = null;
        L23:
            if (r100.getInt(r105) == 0) goto L25;
            boolean r514 = true;
        L26:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L108
            if (r100.isNull(r110) == false) goto L29;
            Integer r516 = null;
        L31:
            if (r100.isNull(r111) == false) goto L33;
            String r310 = null;
        L35:
            if (r100.isNull(r112) == false) goto L37;
            String r311 = null;
        L38:
            long r312 = r100.getLong(r113);     // Catch: Throwable -> L108
            if (r100.isNull(r114) == false) goto L41;
            String r410 = null;
        L43:
            if (r100.isNull(r115) == false) goto L45;
            String r411 = null;
        L47:
            if (r100.isNull(r107) == false) goto L49;
            String r412 = null;
        L51:
            if (r100.isNull(r108) == false) goto L53;
            String r138 = null;
        L54:
            if (r138 != null) goto L56;
            Icons r413 = null;
            r136 = this;
        L59:
            if (r100.isNull(r109) == false) goto L61;
            String r414 = null;
        L63:
            if (r100.isNull(r17) == false) goto L65;
            String r415 = null;
        L67:
            if (r100.isNull(r18) == false) goto L69;
            String r416 = null;
        L71:
            if (r100.isNull(r19) == false) goto L73;
            String r139 = null;
        L74:
            if (r139 != null) goto L76;
            List r417 = null;
        L78:
            if (r100.isNull(r20) == false) goto L80;
            String r418 = null;
        L82:
            if (r100.isNull(r32) == false) goto L84;
            String r517 = null;
        L85:
            Widget r140 = new Widget(r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517);     // Catch: Throwable -> L103
            r140.f36906m = r100.getLong(r120);     // Catch: Throwable -> L103
            if (r100.isNull(r121) == false) goto L88;
            String r141 = null;
        L89:
            r140.i(r141);     // Catch: Throwable -> L103
            if (r100.isNull(r122) == false) goto L92;
            String r142 = null;
        L93:
            r140.k(r142);     // Catch: Throwable -> L103
            r140.f36909p = r100.getLong(r123);     // Catch: Throwable -> L103
            r140.f36910q = r100.getLong(r124);     // Catch: Throwable -> L103
            r140.f36911r = r100.getLong(r125);     // Catch: Throwable -> L103
            r140.f36912s = r100.getLong(r126);     // Catch: Throwable -> L103
            r140.f36913t = r100.getLong(r127);     // Catch: Throwable -> L103
            r140.f36914u = r100.getLong(r128);     // Catch: Throwable -> L103
            if (r100.isNull(r129) == false) goto L96;
            String r143 = null;
        L97:
            r140.j(r143);     // Catch: Throwable -> L103
            if (r100.isNull(r130) == false) goto L100;
            Integer r144 = null;
        L101:
            r140.f36916w = r144;     // Catch: Throwable -> L103
            r140.D = r100.getInt(r132);     // Catch: Throwable -> L103
            r140.E = r100.getInt(r133);     // Catch: Throwable -> L103
            r140.F = r100.getInt(r134);     // Catch: Throwable -> L103
            r140.G = r100.getInt(r135);     // Catch: Throwable -> L103
            r137 = r140;
        L103:
            th = th;
        L112:
            r100.close();
            r136.f37406a.release();
            throw th;
        L100:
            r144 = Integer.valueOf(r100.getInt(r130));     // Catch: Throwable -> L103
            goto L101
        L96:
            r143 = r100.getString(r129);     // Catch: Throwable -> L103
            goto L97
        L92:
            r142 = r100.getString(r122);     // Catch: Throwable -> L103
            goto L93
        L88:
            r141 = r100.getString(r121);     // Catch: Throwable -> L103
            goto L89
        L84:
            r517 = r100.getString(r131);     // Catch: Throwable -> L103
            goto L85
        L80:
            r418 = r100.getString(r119);     // Catch: Throwable -> L103
            goto L82
        L76:
            r136.f37407b.f37378d.getClass();     // Catch: Throwable -> L103
            r417 = h5.h.b(r139);     // Catch: Throwable -> L103
            goto L78
        L73:
            r139 = r100.getString(r118);     // Catch: Throwable -> L103
            goto L74
        L69:
            r416 = r100.getString(r117);     // Catch: Throwable -> L103
            goto L71
        L65:
            r415 = r100.getString(r116);     // Catch: Throwable -> L103
            goto L67
        L61:
            r414 = r100.getString(r109);     // Catch: Throwable -> L103
            goto L63
        L56:
            r136 = this;
            r136.f37407b.f37378d.getClass();     // Catch: Throwable -> L103
            r413 = h5.h.a(r138);     // Catch: Throwable -> L103
            goto L59
        L53:
            r138 = r100.getString(r108);     // Catch: Throwable -> L108
            goto L54
        L49:
            r412 = r100.getString(r107);     // Catch: Throwable -> L108
            goto L51
        L45:
            r411 = r100.getString(r115);     // Catch: Throwable -> L108
            goto L47
        L41:
            r410 = r100.getString(r114);     // Catch: Throwable -> L108
            goto L43
        L37:
            r311 = r100.getString(r112);     // Catch: Throwable -> L108
            goto L38
        L33:
            r310 = r100.getString(r111);     // Catch: Throwable -> L108
            goto L35
        L29:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L108
            goto L31
        L25:
            r514 = false;
            goto L26
        L21:
            r513 = r100.getString(r104);     // Catch: Throwable -> L108
            goto L23
        L17:
            r512 = r100.getString(r103);     // Catch: Throwable -> L108
            goto L19
        L13:
            r511 = r100.getString(r102);     // Catch: Throwable -> L108
            goto L15
        L9:
            r510 = r100.getString(r101);     // Catch: Throwable -> L108
        L108:
            th = th;
            r136 = this;
        L110:
            th = th;
            r136 = this;
            goto L112
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Widget call() throws Exception {
            return call();
        }

        public h(j r100, RoomSQLiteQuery r101) {
            this.f37407b = r100;
            this.f37406a = r101;
        }
    }

    public class i implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37409b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37409b.f37376b, this.f37408a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            i r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37409b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37408a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37409b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37408a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public i(j r100, RoomSQLiteQuery r101) {
            this.f37409b = r100;
            this.f37408a = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.resource.core.db.j$j, reason: collision with other inner class name */
    public class CallableC0712j implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37411b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37411b.f37376b, this.f37410a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            CallableC0712j r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37411b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37410a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37411b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37410a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public CallableC0712j(j r100, RoomSQLiteQuery r101) {
            this.f37411b = r100;
            this.f37410a = r101;
        }
    }

    public class k implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37413b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37413b.f37376b, this.f37412a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            k r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37413b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37412a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37413b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37412a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public k(j r100, RoomSQLiteQuery r101) {
            this.f37413b = r100;
            this.f37412a = r101;
        }
    }

    public class l implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37415b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37415b.f37376b, this.f37414a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            l r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37415b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37414a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37415b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37414a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public l(j r100, RoomSQLiteQuery r101) {
            this.f37415b = r100;
            this.f37414a = r101;
        }
    }

    public class m implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37417b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37417b.f37376b, this.f37416a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            m r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37417b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37416a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37417b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37416a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public m(j r100, RoomSQLiteQuery r101) {
            this.f37417b = r100;
            this.f37416a = r101;
        }
    }

    public class n implements Callable<List<Widget>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37419b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Widget> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37419b.f37376b, this.f37418a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "widget_id");     // Catch: Throwable -> L111
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "entry");     // Catch: Throwable -> L111
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "input");     // Catch: Throwable -> L111
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, BdpAppEventConstant.PARAMS_OUTPUT);     // Catch: Throwable -> L111
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "border");     // Catch: Throwable -> L111
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "box_type");     // Catch: Throwable -> L111
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "title_type");     // Catch: Throwable -> L111
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L111
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L111
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L111
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L111
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L111
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L111
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L111
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L109
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L109
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L109
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L109
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L109
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L109
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L109
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L109
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L109
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L109
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L109
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L109
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L109
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L109
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L109
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L109
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L109
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L109
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L109
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L109
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L109
            int r317 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L109
        L5:
            if (r100.moveToNext() == false) goto L107;
            if (r100.isNull(r101) == false) goto L10;
            String r510 = null;
        L12:
            if (r100.isNull(r102) == false) goto L14;
            String r511 = null;
        L16:
            if (r100.isNull(r103) == false) goto L18;
            String r512 = null;
        L20:
            if (r100.isNull(r104) == false) goto L22;
            String r513 = null;
        L24:
            if (r100.getInt(r105) == 0) goto L26;
            boolean r514 = true;
        L27:
            int r515 = r100.getInt(r106);     // Catch: Throwable -> L109
            if (r100.isNull(r110) == false) goto L30;
            Integer r516 = null;
        L32:
            if (r100.isNull(r111) == false) goto L34;
            String r318 = null;
        L36:
            if (r100.isNull(r112) == false) goto L38;
            String r410 = null;
        L39:
            long r411 = r100.getLong(r113);     // Catch: Throwable -> L109
            if (r100.isNull(r114) == false) goto L42;
            String r412 = null;
        L44:
            if (r100.isNull(r115) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r107) == false) goto L50;
            String r414 = null;
        L52:
            if (r100.isNull(r317) == false) goto L54;
            String r319 = null;
        L55:
            int r610 = r101;
            int r611 = r107;
            if (r319 != null) goto L58;
            Icons r415 = null;
            n r120 = this;
        L115:
            if (r100.isNull(r116) == false) goto L63;
            String r416 = null;
        L65:
            if (r100.isNull(r117) == false) goto L67;
            String r417 = null;
        L69:
            if (r100.isNull(r118) == false) goto L71;
            String r418 = null;
        L73:
            if (r100.isNull(r119) == false) goto L75;
            String r121 = null;
        L76:
            if (r121 != null) goto L78;
            List r517 = null;
        L80:
            if (r100.isNull(r210) == false) goto L82;
            String r518 = null;
        L84:
            if (r100.isNull(r312) == false) goto L86;
            String r519 = null;
        L87:
            Widget r122 = new Widget(r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r517, r518, r510, r511, r512, r513, r514, r515, r516, r519);     // Catch: Throwable -> L105
            int r123 = r317;
            int r320 = r103;
            int r124 = r211;
            int r220 = r102;
            r122.f36906m = r100.getLong(r124);     // Catch: Throwable -> L105
            int r125 = r212;
            if (r100.isNull(r125) == false) goto L90;
            String r126 = null;
        L91:
            r122.i(r126);     // Catch: Throwable -> L105
            int r127 = r213;
            if (r100.isNull(r127) == false) goto L94;
            String r128 = null;
        L95:
            r122.k(r128);     // Catch: Throwable -> L105
            r212 = r125;
            int r129 = r214;
            r122.f36909p = r100.getLong(r129);     // Catch: Throwable -> L105
            int r130 = r215;
            int r221 = r104;
            r122.f36910q = r100.getLong(r130);     // Catch: Throwable -> L105
            int r131 = r216;
            r122.f36911r = r100.getLong(r131);     // Catch: Throwable -> L105
            int r132 = r217;
            r122.f36912s = r100.getLong(r132);     // Catch: Throwable -> L105
            int r133 = r218;
            r122.f36913t = r100.getLong(r133);     // Catch: Throwable -> L105
            int r134 = r219;
            r122.f36914u = r100.getLong(r134);     // Catch: Throwable -> L105
            int r135 = r310;
            if (r100.isNull(r135) == false) goto L98;
            String r136 = null;
        L99:
            r122.j(r136);     // Catch: Throwable -> L105
            int r137 = r311;
            if (r100.isNull(r137) == false) goto L102;
            Integer r138 = null;
        L103:
            r122.f36916w = r138;     // Catch: Throwable -> L105
            int r139 = r313;
            r122.D = r100.getInt(r139);     // Catch: Throwable -> L105
            r313 = r139;
            int r140 = r314;
            r122.E = r100.getInt(r140);     // Catch: Throwable -> L105
            r314 = r140;
            int r141 = r315;
            r122.F = r100.getInt(r141);     // Catch: Throwable -> L105
            r315 = r141;
            int r142 = r316;
            r122.G = r100.getInt(r142);     // Catch: Throwable -> L105
            r109.add(r122);     // Catch: Throwable -> L105
            r316 = r142;
            r102 = r220;
            r211 = r124;
            r213 = r127;
            r214 = r129;
            r218 = r133;
            r107 = r611;
            r101 = r610;
            r219 = r134;
            r103 = r320;
            r217 = r132;
            r104 = r221;
            r215 = r130;
            r216 = r131;
            r317 = r123;
            r119 = r119;
            r311 = r137;
            r310 = r135;
            goto L5
        L102:
            r138 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L105
            goto L103
        L98:
            r136 = r100.getString(r135);     // Catch: Throwable -> L105
            goto L99
        L94:
            r128 = r100.getString(r127);     // Catch: Throwable -> L105
            goto L95
        L90:
            r126 = r100.getString(r125);     // Catch: Throwable -> L105
            goto L91
        L86:
            r519 = r100.getString(r312);     // Catch: Throwable -> L105
            goto L87
        L82:
            r518 = r100.getString(r210);     // Catch: Throwable -> L105
            goto L84
        L78:
            r120.f37419b.f37378d.getClass();     // Catch: Throwable -> L105
            r517 = h5.h.b(r121);     // Catch: Throwable -> L105
            goto L80
        L75:
            r121 = r100.getString(r119);     // Catch: Throwable -> L105
            goto L76
        L71:
            r418 = r100.getString(r118);     // Catch: Throwable -> L105
            goto L73
        L67:
            r417 = r100.getString(r117);     // Catch: Throwable -> L105
            goto L69
        L63:
            r416 = r100.getString(r116);     // Catch: Throwable -> L105
        L105:
            th = th;
        L113:
            r100.close();
            r120.f37418a.release();
            throw th;
        L58:
            r120 = this;
            r120.f37419b.f37378d.getClass();     // Catch: Throwable -> L105
            r415 = h5.h.a(r319);     // Catch: Throwable -> L105
            goto L115
        L54:
            r319 = r100.getString(r317);     // Catch: Throwable -> L109
            goto L55
        L50:
            r414 = r100.getString(r107);     // Catch: Throwable -> L109
            goto L52
        L46:
            r413 = r100.getString(r115);     // Catch: Throwable -> L109
            goto L48
        L42:
            r412 = r100.getString(r114);     // Catch: Throwable -> L109
            goto L44
        L38:
            r410 = r100.getString(r112);     // Catch: Throwable -> L109
            goto L39
        L34:
            r318 = r100.getString(r111);     // Catch: Throwable -> L109
            goto L36
        L30:
            r516 = Integer.valueOf(r100.getInt(r110));     // Catch: Throwable -> L109
            goto L32
        L26:
            r514 = false;
            goto L27
        L22:
            r513 = r100.getString(r104);     // Catch: Throwable -> L109
            goto L24
        L18:
            r512 = r100.getString(r103);     // Catch: Throwable -> L109
            goto L20
        L14:
            r511 = r100.getString(r102);     // Catch: Throwable -> L109
            goto L16
        L10:
            r510 = r100.getString(r101);     // Catch: Throwable -> L109
            goto L12
        L107:
            r100.close();
            this.f37418a.release();
            return r109;
        L109:
            th = th;
            r120 = this;
        L111:
            th = th;
            r120 = this;
            goto L113
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
            return call2();
        }

        public n(j r100, RoomSQLiteQuery r101) {
            this.f37419b = r100;
            this.f37418a = r101;
        }
    }

    public class o implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37421b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37421b.f37376b, this.f37420a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37421b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37420a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37420a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public o(j r100, RoomSQLiteQuery r101) {
            this.f37421b = r100;
            this.f37420a = r101;
        }
    }

    public class p implements Callable<Applet> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37423b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Applet call() throws Exception {
            Cursor r100 = DBUtil.query(this.f37423b.f37376b, this.f37422a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r120 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r125 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r126 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r127 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r128 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r129 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r130 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r131 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r132 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r133 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r134 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r135 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r136 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r137 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r138 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r139 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r140 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r141 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r142 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            if (r100.moveToFirst() == true) goto L6;
            Applet r143 = null;
        L140:
            r100.close();
            this.f37422a.release();
            return r143;
        L6:
            if (r100.isNull(r101) == false) goto L8;
            String r510 = null;
        L10:
            if (r100.isNull(r102) == false) goto L12;
            String r144 = null;
        L13:
            if (r144 != null) goto L15;
            List r511 = null;
        L17:
            if (r100.isNull(r103) == false) goto L19;
            String r145 = null;
        L20:
            if (r145 != null) goto L22;
            List r610 = null;
        L24:
            if (r100.isNull(r104) == false) goto L26;
            String r611 = null;
        L28:
            if (r100.isNull(r105) == false) goto L30;
            String r612 = null;
        L32:
            if (r100.isNull(r106) == false) goto L34;
            String r613 = null;
        L36:
            if (r100.isNull(r109) == false) goto L38;
            String r410 = null;
        L40:
            if (r100.isNull(r116) == false) goto L42;
            String r411 = null;
        L43:
            long r412 = r100.getLong(r117);     // Catch: Throwable -> L142
            if (r100.isNull(r118) == false) goto L46;
            String r413 = null;
        L48:
            if (r100.isNull(r119) == false) goto L50;
            String r512 = null;
        L52:
            if (r100.isNull(r120) == false) goto L54;
            String r513 = null;
        L56:
            if (r100.isNull(r121) == false) goto L58;
            String r146 = null;
        L59:
            if (r146 != null) goto L61;
            Icons r514 = null;
        L63:
            if (r100.isNull(r24) == false) goto L65;
            String r515 = null;
        L67:
            if (r100.isNull(r25) == false) goto L69;
            String r516 = null;
        L71:
            if (r100.isNull(r26) == false) goto L73;
            String r517 = null;
        L75:
            if (r100.isNull(r27) == false) goto L77;
            String r147 = null;
        L78:
            if (r147 != null) goto L80;
            List r518 = null;
        L82:
            if (r100.isNull(r28) == false) goto L84;
            String r519 = null;
        L86:
            if (r100.isNull(r40) == false) goto L88;
            String r614 = null;
        L89:
            Applet r148 = new Applet(r410, r411, r412, r413, r512, r513, r514, r515, r516, r517, r518, r519, r510, r511, r610, r611, r612, r613, r614);     // Catch: Throwable -> L142
            if (r100.isNull(r110) == false) goto L92;
            String r149 = null;
        L93:
            r148.r(r149);     // Catch: Throwable -> L142
            if (r100.isNull(r111) == false) goto L96;
            String r150 = null;
        L97:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r148.U = h5.h.c(r150);     // Catch: Throwable -> L142
            if (r100.isNull(r112) == false) goto L100;
            String r151 = null;
        L101:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r148.V = h5.h.g(r151);     // Catch: Throwable -> L142
            if (r100.isNull(r113) == false) goto L104;
            String r152 = null;
        L105:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r148.W = h5.h.e(r152);     // Catch: Throwable -> L142
            if (r100.getInt(r114) == 0) goto L108;
            boolean r153 = true;
        L109:
            r148.X = r153;     // Catch: Throwable -> L142
            if (r100.isNull(r115) == false) goto L112;
            String r154 = null;
        L113:
            r148.Y = r154;     // Catch: Throwable -> L142
            if (r100.isNull(r107) == false) goto L116;
            String r155 = null;
        L117:
            r148.Z = r155;     // Catch: Throwable -> L142
            if (r100.isNull(r108) == false) goto L120;
            String r156 = null;
        L121:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r148.f36924k0 = h5.h.h(r156);     // Catch: Throwable -> L142
            r148.f36906m = r100.getLong(r127);     // Catch: Throwable -> L142
            if (r100.isNull(r128) == false) goto L124;
            String r157 = null;
        L125:
            r148.i(r157);     // Catch: Throwable -> L142
            if (r100.isNull(r129) == false) goto L128;
            String r158 = null;
        L129:
            r148.k(r158);     // Catch: Throwable -> L142
            r148.f36909p = r100.getLong(r130);     // Catch: Throwable -> L142
            r148.f36910q = r100.getLong(r131);     // Catch: Throwable -> L142
            r148.f36911r = r100.getLong(r132);     // Catch: Throwable -> L142
            r148.f36912s = r100.getLong(r133);     // Catch: Throwable -> L142
            r148.f36913t = r100.getLong(r134);     // Catch: Throwable -> L142
            r148.f36914u = r100.getLong(r135);     // Catch: Throwable -> L142
            if (r100.isNull(r136) == false) goto L132;
            String r159 = null;
        L133:
            r148.j(r159);     // Catch: Throwable -> L142
            if (r100.isNull(r137) == false) goto L136;
            Integer r160 = null;
        L137:
            r148.f36916w = r160;     // Catch: Throwable -> L142
            r148.D = r100.getInt(r139);     // Catch: Throwable -> L142
            r148.E = r100.getInt(r140);     // Catch: Throwable -> L142
            r148.F = r100.getInt(r141);     // Catch: Throwable -> L142
            r148.G = r100.getInt(r142);     // Catch: Throwable -> L142
            r143 = r148;
            goto L140
        L136:
            r160 = Integer.valueOf(r100.getInt(r137));     // Catch: Throwable -> L142
            goto L137
        L132:
            r159 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L133
        L128:
            r158 = r100.getString(r129);     // Catch: Throwable -> L142
            goto L129
        L124:
            r157 = r100.getString(r128);     // Catch: Throwable -> L142
            goto L125
        L120:
            r156 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L121
        L116:
            r155 = r100.getString(r107);     // Catch: Throwable -> L142
            goto L117
        L112:
            r154 = r100.getString(r115);     // Catch: Throwable -> L142
            goto L113
        L108:
            r153 = false;
            goto L109
        L104:
            r152 = r100.getString(r113);     // Catch: Throwable -> L142
            goto L105
        L100:
            r151 = r100.getString(r112);     // Catch: Throwable -> L142
            goto L101
        L96:
            r150 = r100.getString(r111);     // Catch: Throwable -> L142
            goto L97
        L92:
            r149 = r100.getString(r110);     // Catch: Throwable -> L142
            goto L93
        L88:
            r614 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L89
        L84:
            r519 = r100.getString(r126);     // Catch: Throwable -> L142
            goto L86
        L80:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r518 = h5.h.b(r147);     // Catch: Throwable -> L142
            goto L82
        L77:
            r147 = r100.getString(r125);     // Catch: Throwable -> L142
            goto L78
        L73:
            r517 = r100.getString(r124);     // Catch: Throwable -> L142
            goto L75
        L69:
            r516 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L71
        L65:
            r515 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L67
        L61:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r514 = h5.h.a(r146);     // Catch: Throwable -> L142
            goto L63
        L58:
            r146 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L59
        L54:
            r513 = r100.getString(r120);     // Catch: Throwable -> L142
            goto L56
        L50:
            r512 = r100.getString(r119);     // Catch: Throwable -> L142
            goto L52
        L46:
            r413 = r100.getString(r118);     // Catch: Throwable -> L142
            goto L48
        L42:
            r411 = r100.getString(r116);     // Catch: Throwable -> L142
            goto L43
        L38:
            r410 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L40
        L34:
            r613 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L36
        L30:
            r612 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L32
        L26:
            r611 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L28
        L22:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r610 = h5.h.f(r145);     // Catch: Throwable -> L142
            goto L24
        L19:
            r145 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L20
        L15:
            this.f37423b.f37378d.getClass();     // Catch: Throwable -> L142
            r511 = h5.h.d(r144);     // Catch: Throwable -> L142
            goto L17
        L12:
            r144 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L13
        L8:
            r510 = r100.getString(r101);     // Catch: Throwable -> L142
        L142:
            th = move-exception;
            r100.close();
            this.f37422a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Applet call() throws Exception {
            return call();
        }

        public p(j r100, RoomSQLiteQuery r101) {
            this.f37423b = r100;
            this.f37422a = r101;
        }
    }

    public class q implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37425b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37425b.f37376b, this.f37424a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37425b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37424a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37424a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public q(j r100, RoomSQLiteQuery r101) {
            this.f37425b = r100;
            this.f37424a = r101;
        }
    }

    public class r implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37427b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37427b.f37376b, this.f37426a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37427b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37426a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37426a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public r(j r100, RoomSQLiteQuery r101) {
            this.f37427b = r100;
            this.f37426a = r101;
        }
    }

    public class s implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37429b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37429b.f37376b, this.f37428a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37429b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37428a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37428a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public s(j r100, RoomSQLiteQuery r101) {
            this.f37429b = r100;
            this.f37428a = r101;
        }
    }

    public class t implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37431b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37431b.f37376b, this.f37430a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37431b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37430a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37430a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public t(j r100, RoomSQLiteQuery r101) {
            this.f37431b = r100;
            this.f37430a = r101;
        }
    }

    public class u implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37433b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37433b.f37376b, this.f37432a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37433b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37432a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37432a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public u(j r100, RoomSQLiteQuery r101) {
            this.f37433b = r100;
            this.f37432a = r101;
        }
    }

    public class v implements Callable<List<Applet>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f37434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37435b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Applet> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f37435b.f37376b, this.f37434a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "applet_id");     // Catch: Throwable -> L142
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, "pages");     // Catch: Throwable -> L142
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);     // Catch: Throwable -> L142
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "bot_id");     // Catch: Throwable -> L142
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "applet_entry");     // Catch: Throwable -> L142
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_entry");     // Catch: Throwable -> L142
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "botDevMode");     // Catch: Throwable -> L142
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "main_init");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, PromotionProductPrivilegesStruct.SERVICES);     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, ComplianceResult.JsonKey.PERMISSIONS);     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "dark_mode");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "chat");     // Catch: Throwable -> L142
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "tool_runtime_entry");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "settings");     // Catch: Throwable -> L142
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "name");     // Catch: Throwable -> L142
            int r117 = r107;
            int r109 = CursorUtil.getColumnIndexOrThrow(r100, "package_name");     // Catch: Throwable -> L142
            int r118 = r115;
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "version_code");     // Catch: Throwable -> L142
            int r120 = r114;
            int r121 = CursorUtil.getColumnIndexOrThrow(r100, "scm_version");     // Catch: Throwable -> L142
            int r210 = r113;
            int r122 = CursorUtil.getColumnIndexOrThrow(r100, "version_name");     // Catch: Throwable -> L142
            int r211 = r112;
            int r123 = CursorUtil.getColumnIndexOrThrow(r100, "description");     // Catch: Throwable -> L142
            int r212 = r111;
            int r124 = CursorUtil.getColumnIndexOrThrow(r100, "icons");     // Catch: Throwable -> L142
            int r213 = r110;
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "manifest_version");     // Catch: Throwable -> L142
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "prop");     // Catch: Throwable -> L142
            int r216 = CursorUtil.getColumnIndexOrThrow(r100, "recommend");     // Catch: Throwable -> L142
            int r217 = CursorUtil.getColumnIndexOrThrow(r100, "keywords");     // Catch: Throwable -> L142
            int r218 = CursorUtil.getColumnIndexOrThrow(r100, "app_group");     // Catch: Throwable -> L142
            int r219 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L142
            int r310 = CursorUtil.getColumnIndexOrThrow(r100, "digest");     // Catch: Throwable -> L142
            int r311 = CursorUtil.getColumnIndexOrThrow(r100, "render_type");     // Catch: Throwable -> L142
            int r312 = CursorUtil.getColumnIndexOrThrow(r100, "size");     // Catch: Throwable -> L142
            int r313 = CursorUtil.getColumnIndexOrThrow(r100, "ft");     // Catch: Throwable -> L142
            int r314 = CursorUtil.getColumnIndexOrThrow(r100, "it");     // Catch: Throwable -> L142
            int r315 = CursorUtil.getColumnIndexOrThrow(r100, "ut");     // Catch: Throwable -> L142
            int r316 = CursorUtil.getColumnIndexOrThrow(r100, "update_time");     // Catch: Throwable -> L142
            int r317 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L142
            int r318 = CursorUtil.getColumnIndexOrThrow(r100, "status");     // Catch: Throwable -> L142
            int r319 = CursorUtil.getColumnIndexOrThrow(r100, "ready_for_deleting");     // Catch: Throwable -> L142
            int r410 = CursorUtil.getColumnIndexOrThrow(r100, "runtime_version");     // Catch: Throwable -> L142
            int r411 = CursorUtil.getColumnIndexOrThrow(r100, "has_key_store");     // Catch: Throwable -> L142
            int r412 = CursorUtil.getColumnIndexOrThrow(r100, "sign_verify_switch");     // Catch: Throwable -> L142
            int r413 = CursorUtil.getColumnIndexOrThrow(r100, "app_type");     // Catch: Throwable -> L142
            int r414 = CursorUtil.getColumnIndexOrThrow(r100, "source_type");     // Catch: Throwable -> L142
            int r415 = r124;
            ArrayList r125 = new ArrayList(r100.getCount());     // Catch: Throwable -> L142
        L4:
            if (r100.moveToNext() == false) goto L140;
            if (r100.isNull(r101) == false) goto L9;
            String r610 = null;
        L11:
            if (r100.isNull(r102) == false) goto L13;
            String r126 = null;
        L14:
            if (r126 != null) goto L16;
            List r611 = null;
        L18:
            if (r100.isNull(r103) == false) goto L20;
            String r127 = null;
        L21:
            if (r127 != null) goto L23;
            List r612 = null;
        L25:
            if (r100.isNull(r104) == false) goto L27;
            String r613 = null;
        L29:
            if (r100.isNull(r105) == false) goto L31;
            String r614 = null;
        L33:
            if (r100.isNull(r106) == false) goto L35;
            String r615 = null;
        L37:
            if (r100.isNull(r108) == false) goto L39;
            String r416 = null;
        L41:
            if (r100.isNull(r109) == false) goto L43;
            String r417 = null;
        L44:
            long r418 = r100.getLong(r119);     // Catch: Throwable -> L142
            if (r100.isNull(r121) == false) goto L47;
            String r510 = null;
        L49:
            if (r100.isNull(r122) == false) goto L51;
            String r511 = null;
        L53:
            if (r100.isNull(r123) == false) goto L55;
            String r512 = null;
        L57:
            if (r100.isNull(r415) == false) goto L59;
            String r128 = null;
        L60:
            if (r128 != null) goto L62;
            Icons r513 = null;
        L64:
            if (r100.isNull(r214) == false) goto L66;
            String r514 = null;
        L68:
            if (r100.isNull(r215) == false) goto L70;
            String r515 = null;
        L72:
            if (r100.isNull(r216) == false) goto L74;
            String r516 = null;
        L76:
            if (r100.isNull(r217) == false) goto L78;
            String r220 = null;
        L79:
            if (r220 != null) goto L81;
            List r517 = null;
        L83:
            if (r100.isNull(r218) == false) goto L85;
            String r518 = null;
        L87:
            if (r100.isNull(r410) == false) goto L89;
            String r616 = null;
        L90:
            Applet r129 = new Applet(r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616);     // Catch: Throwable -> L142
            int r221 = r109;
            int r130 = r213;
            if (r100.isNull(r130) == false) goto L93;
            String r131 = null;
        L94:
            r129.r(r131);     // Catch: Throwable -> L142
            int r132 = r212;
            if (r100.isNull(r132) == false) goto L97;
            String r222 = null;
        L98:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.U = h5.h.c(r222);     // Catch: Throwable -> L142
            int r133 = r211;
            if (r100.isNull(r133) == false) goto L101;
            String r223 = null;
        L102:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.V = h5.h.g(r223);     // Catch: Throwable -> L142
            int r134 = r210;
            if (r100.isNull(r134) == false) goto L105;
            String r224 = null;
        L106:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.W = h5.h.e(r224);     // Catch: Throwable -> L142
            r120 = r120;
            if (r100.getInt(r120) == 0) goto L109;
            boolean r135 = true;
        L110:
            r129.X = r135;     // Catch: Throwable -> L142
            int r136 = r118;
            if (r100.isNull(r136) == false) goto L113;
            String r137 = null;
        L114:
            r129.Y = r137;     // Catch: Throwable -> L142
            int r138 = r117;
            if (r100.isNull(r138) == false) goto L117;
            String r139 = null;
        L118:
            r129.Z = r139;     // Catch: Throwable -> L142
            int r140 = r116;
            if (r100.isNull(r140) == false) goto L121;
            String r141 = null;
        L122:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r129.f36924k0 = h5.h.h(r141);     // Catch: Throwable -> L142
            int r142 = r102;
            int r143 = r219;
            int r225 = r108;
            r129.f36906m = r100.getLong(r143);     // Catch: Throwable -> L142
            int r144 = r310;
            if (r100.isNull(r144) == false) goto L125;
            String r145 = null;
        L126:
            r129.i(r145);     // Catch: Throwable -> L142
            int r146 = r311;
            if (r100.isNull(r146) == false) goto L129;
            String r147 = null;
        L130:
            r129.k(r147);     // Catch: Throwable -> L142
            r310 = r144;
            int r148 = r312;
            r129.f36909p = r100.getLong(r148);     // Catch: Throwable -> L142
            int r149 = r313;
            int r320 = r103;
            r129.f36910q = r100.getLong(r149);     // Catch: Throwable -> L142
            int r150 = r314;
            r129.f36911r = r100.getLong(r150);     // Catch: Throwable -> L142
            int r151 = r315;
            r129.f36912s = r100.getLong(r151);     // Catch: Throwable -> L142
            int r152 = r316;
            r129.f36913t = r100.getLong(r152);     // Catch: Throwable -> L142
            int r153 = r317;
            r129.f36914u = r100.getLong(r153);     // Catch: Throwable -> L142
            int r154 = r318;
            if (r100.isNull(r154) == false) goto L133;
            String r155 = null;
        L134:
            r129.j(r155);     // Catch: Throwable -> L142
            int r156 = r319;
            if (r100.isNull(r156) == false) goto L137;
            Integer r157 = null;
        L138:
            r129.f36916w = r157;     // Catch: Throwable -> L142
            int r158 = r411;
            r129.D = r100.getInt(r158);     // Catch: Throwable -> L142
            r411 = r158;
            int r159 = r412;
            r129.E = r100.getInt(r159);     // Catch: Throwable -> L142
            r412 = r159;
            int r160 = r413;
            r129.F = r100.getInt(r160);     // Catch: Throwable -> L142
            r413 = r160;
            int r161 = r414;
            r129.G = r100.getInt(r161);     // Catch: Throwable -> L142
            r125.add(r129);     // Catch: Throwable -> L142
            r414 = r161;
            r109 = r221;
            r108 = r225;
            r219 = r143;
            r311 = r146;
            r312 = r148;
            r316 = r152;
            r101 = r101;
            r317 = r153;
            r215 = r215;
            r102 = r142;
            r116 = r140;
            r117 = r138;
            r118 = r136;
            r210 = r134;
            r211 = r133;
            r212 = r132;
            r213 = r130;
            r315 = r151;
            r103 = r320;
            r313 = r149;
            r314 = r150;
            r319 = r156;
            r318 = r154;
            goto L4
        L137:
            r157 = Integer.valueOf(r100.getInt(r156));     // Catch: Throwable -> L142
            goto L138
        L133:
            r155 = r100.getString(r154);     // Catch: Throwable -> L142
            goto L134
        L129:
            r147 = r100.getString(r146);     // Catch: Throwable -> L142
            goto L130
        L125:
            r145 = r100.getString(r144);     // Catch: Throwable -> L142
            goto L126
        L121:
            r141 = r100.getString(r140);     // Catch: Throwable -> L142
            goto L122
        L117:
            r139 = r100.getString(r138);     // Catch: Throwable -> L142
            goto L118
        L113:
            r137 = r100.getString(r136);     // Catch: Throwable -> L142
            goto L114
        L109:
            r135 = false;
            goto L110
        L105:
            r224 = r100.getString(r134);     // Catch: Throwable -> L142
            goto L106
        L101:
            r223 = r100.getString(r133);     // Catch: Throwable -> L142
            goto L102
        L97:
            r222 = r100.getString(r132);     // Catch: Throwable -> L142
            goto L98
        L93:
            r131 = r100.getString(r130);     // Catch: Throwable -> L142
            goto L94
        L89:
            r616 = r100.getString(r410);     // Catch: Throwable -> L142
            goto L90
        L85:
            r518 = r100.getString(r218);     // Catch: Throwable -> L142
            goto L87
        L81:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r517 = h5.h.b(r220);     // Catch: Throwable -> L142
            goto L83
        L78:
            r220 = r100.getString(r217);     // Catch: Throwable -> L142
            goto L79
        L74:
            r516 = r100.getString(r216);     // Catch: Throwable -> L142
            goto L76
        L70:
            r515 = r100.getString(r215);     // Catch: Throwable -> L142
            goto L72
        L66:
            r514 = r100.getString(r214);     // Catch: Throwable -> L142
            goto L68
        L62:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r513 = h5.h.a(r128);     // Catch: Throwable -> L142
            goto L64
        L59:
            r128 = r100.getString(r415);     // Catch: Throwable -> L142
            goto L60
        L55:
            r512 = r100.getString(r123);     // Catch: Throwable -> L142
            goto L57
        L51:
            r511 = r100.getString(r122);     // Catch: Throwable -> L142
            goto L53
        L47:
            r510 = r100.getString(r121);     // Catch: Throwable -> L142
            goto L49
        L43:
            r417 = r100.getString(r109);     // Catch: Throwable -> L142
            goto L44
        L39:
            r416 = r100.getString(r108);     // Catch: Throwable -> L142
            goto L41
        L35:
            r615 = r100.getString(r106);     // Catch: Throwable -> L142
            goto L37
        L31:
            r614 = r100.getString(r105);     // Catch: Throwable -> L142
            goto L33
        L27:
            r613 = r100.getString(r104);     // Catch: Throwable -> L142
            goto L29
        L23:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r612 = h5.h.f(r127);     // Catch: Throwable -> L142
            goto L25
        L20:
            r127 = r100.getString(r103);     // Catch: Throwable -> L142
            goto L21
        L16:
            this.f37435b.f37378d.getClass();     // Catch: Throwable -> L142
            r611 = h5.h.d(r126);     // Catch: Throwable -> L142
            goto L18
        L13:
            r126 = r100.getString(r102);     // Catch: Throwable -> L142
            goto L14
        L9:
            r610 = r100.getString(r101);     // Catch: Throwable -> L142
            goto L11
        L140:
            r100.close();
            this.f37434a.release();
            return r125;
        L142:
            th = move-exception;
            r100.close();
            this.f37434a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
            return call2();
        }

        public v(j r100, RoomSQLiteQuery r101) {
            this.f37435b = r100;
            this.f37434a = r101;
        }
    }

    public j(AIPackageDatabase r100) {
        this.f37378d = new h5.h();
        this.f37376b = r100;
        this.f37377c = new com.bytedance.ai.resource.core.db.n(this, r100);
        this.f37379e = new com.bytedance.ai.resource.core.db.q(this, r100);
        this.f37380f = new com.bytedance.ai.resource.core.db.t(r100);
        this.f37381g = new w(r100);
        this.f37382h = new x(this, r100);
        this.f37383i = new y(this, r100);
        this.f37384j = new z(r100);
        new a0(r100);
        this.f37385k = new b0(r100);
        this.f37386l = new com.bytedance.ai.resource.core.db.e(r100);
        new com.bytedance.ai.resource.core.db.f(r100);
        this.f37387m = new com.bytedance.ai.resource.core.db.g(r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object A(Continuation<? super List<Applet>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new u(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object D(Continuation<? super List<? extends Widget>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new m(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object L(Continuation<? super List<? extends Widget>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new n(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object o(Continuation<? super List<Applet>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new r(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object p(Continuation<? super List<? extends Widget>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new CallableC0712j(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object q(Continuation r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND bot_id = ?", 1);
        r101.bindNull(1);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new com.bytedance.ai.resource.core.db.v(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object u(Continuation<? super List<Applet>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new v(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object w(Continuation<? super List<Applet>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'inactive'", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new s(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object y(Continuation<? super List<? extends Widget>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'inactive'", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r102, new k(this, r101), r100);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object B(String r100, Continuation<? super List<Applet>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r103, new q(this, r102), r101);
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object E(String r100, Continuation<? super List<? extends Widget>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r103, new i(this, r102), r101);
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object N(Applet[] r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.o(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object O(Widget[] r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.m(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object b(Applet r100, Continuation<? super Unit> r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new b(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object d(List r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.l(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object e(Widget r100, Continuation<? super Unit> r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new a(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object g(List r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.k(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object h(Applet r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.i(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object i(final Applet r100, Continuation<? super Unit> r101) {
        return RoomDatabaseKt.withTransaction(this.f37376b, new com.bytedance.ai.resource.core.db.c(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object k(final Widget r100, Continuation<? super Unit> r101) {
        return RoomDatabaseKt.withTransaction(this.f37376b, new com.bytedance.ai.resource.core.db.a(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object l(Widget r100, ContinuationImpl r101) {
        return CoroutinesRoom.execute(this.f37376b, true, new com.bytedance.ai.resource.core.db.h(this, r100), r101);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object v(String r100, Continuation<? super List<Applet>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r103, new t(this, r102), r101);
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object x(String r100, Continuation<? super List<? extends Widget>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r103, new l(this, r102), r101);
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    public static /* synthetic */ Object P(j r100, Widget r101, Continuation r102) {
        return super.k(r101, r102);
    }

    public static /* synthetic */ Object Q(j r100, Applet r101, Continuation r102) {
        return super.i(r101, r102);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object C(String r100, long r101, ContinuationImpl r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L6:
        r103.bindLong(2, r101);
        CancellationSignal r104 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r104, new com.bytedance.ai.resource.core.db.r(this, r103), r102);
    L5:
        r103.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object K(String r100, String r101, Continuation<? super List<? extends Widget>> r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L6:
        if (r101 != null) goto L8;
        r103.bindNull(2);
    L9:
        CancellationSignal r104 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r104, new g(this, r103), r102);
    L8:
        r103.bindString(2, r101);
        goto L9
    L5:
        r103.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object c(String r100, String r101, Continuation<? super Unit> r102) {
        return CoroutinesRoom.execute(this.f37376b, true, new e(this, r100, r101), r102);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object f(String r100, String r101, Continuation<? super Unit> r102) {
        return CoroutinesRoom.execute(this.f37376b, true, new c(this, r100, r101), r102);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object m(String r100, String r101, Continuation<? super Unit> r102) {
        return CoroutinesRoom.execute(this.f37376b, true, new f(this, r100, r101), r102);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object n(String r100, String r101, Continuation<? super Unit> r102) {
        return CoroutinesRoom.execute(this.f37376b, true, new d(this, r100, r101), r102);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object t(String r100, String r101, Continuation<? super List<Applet>> r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L6:
        if (r101 != null) goto L8;
        r103.bindNull(2);
    L9:
        CancellationSignal r104 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r104, new o(this, r103), r102);
    L8:
        r103.bindString(2, r101);
        goto L9
    L5:
        r103.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object z(String r100, long r101, ContinuationImpl r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r100 != null) goto L5;
        r103.bindNull(1);
    L6:
        r103.bindLong(2, r101);
        CancellationSignal r104 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r104, new com.bytedance.ai.resource.core.db.u(this, r103), r102);
    L5:
        r103.bindString(1, r100);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object G(final String r100, final String r110, final long r111, Continuation<? super Applet> r112) {
        return RoomDatabaseKt.withTransaction(this.f37376b, new com.bytedance.ai.resource.core.db.b(this, r100, r110, r111), r112);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object H(final String r100, final String r110, final long r111, Continuation<? super Widget> r112) {
        return RoomDatabaseKt.withTransaction(this.f37376b, new com.bytedance.ai.resource.core.db.d(this, r100, r110, r111), r112);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object J(String r100, String r101, String r102, ContinuationImpl r103) {
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r100 != null) goto L5;
        r104.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r104.bindNull(2);
    L10:
        if (r102 != null) goto L12;
        r104.bindNull(3);
    L13:
        CancellationSignal r105 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r105, new com.bytedance.ai.resource.core.db.p(this, r104), r103);
    L12:
        r104.bindString(3, r102);
        goto L13
    L9:
        r104.bindString(2, r101);
        goto L10
    L5:
        r104.bindString(1, r100);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object s(String r100, String r101, String r102, ContinuationImpl r103) {
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r100 != null) goto L5;
        r104.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r104.bindNull(2);
    L10:
        if (r102 != null) goto L12;
        r104.bindNull(3);
    L13:
        CancellationSignal r105 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r105, new com.bytedance.ai.resource.core.db.s(this, r104), r103);
    L12:
        r104.bindString(3, r102);
        goto L13
    L9:
        r104.bindString(2, r101);
        goto L10
    L5:
        r104.bindString(1, r100);
        goto L7
    }

    public static /* synthetic */ Object R(j r100, String r101, String r102, long r103, Continuation r104) {
        return super.H(r101, r102, r103, r104);
    }

    public static /* synthetic */ Object S(j r100, String r101, String r102, long r103, Continuation r104) {
        return super.G(r101, r102, r103, r104);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object I(String r100, String r101, String r102, long r103, Continuation<? super Widget> r104) {
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r100 != null) goto L5;
        r105.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r105.bindNull(2);
    L11:
        if (r102 != null) goto L13;
        r105.bindNull(3);
    L14:
        r105.bindLong(4, r103);
        CancellationSignal r106 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r106, new h(this, r105), r104);
    L13:
        r105.bindString(3, r102);
        goto L14
    L9:
        r105.bindString(2, r101);
        goto L11
    L5:
        r105.bindString(1, r100);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object r(String r100, String r101, String r102, long r103, Continuation<? super Applet> r104) {
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r100 != null) goto L5;
        r105.bindNull(1);
    L7:
        if (r101 != null) goto L9;
        r105.bindNull(2);
    L11:
        if (r102 != null) goto L13;
        r105.bindNull(3);
    L14:
        r105.bindLong(4, r103);
        CancellationSignal r106 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f37376b, false, r106, new p(this, r105), r104);
    L13:
        r105.bindString(3, r102);
        goto L14
    L9:
        r105.bindString(2, r101);
        goto L11
    L5:
        r105.bindString(1, r100);
        goto L7
    }
}
