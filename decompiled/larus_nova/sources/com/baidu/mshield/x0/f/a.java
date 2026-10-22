package com.baidu.mshield.x0.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f32506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0656a f32509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SQLiteDatabase f32510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f32511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f32512g;

    /* JADX INFO: renamed from: com.baidu.mshield.x0.f.a$a, reason: collision with other inner class name */
    public class C0656a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f32513a;

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            r100.execSQL(this.f32513a.f32512g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            d.a(th);
        }

        public C0656a(a r100, Context r101) {
            this.f32513a = r100;
            super(r101, a.a(r100), null, a.b(r100));
        }
    }

    public List<com.baidu.mshield.x0.d.a> a() {
        Cursor r100 = null;
        if (this.f32510e != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        r100 = this.f32510e.query(this.f32511f, null, null, null, null, null, "b DESC");     // Catch: Throwable -> L18
        if (r100 != null) goto L9;
    L14:
        if (r100 != null) goto L16;
    L24:
        return r101;
    L16:
        if (r100.isClosed() == true) goto L24;
    L23:
        r100.close();
        goto L24
    L9:
        if (r100.getCount() <= 0) goto L14;
    L11:
        if (r100.moveToNext() == false) goto L14;
        com.baidu.mshield.x0.d.a r102 = new com.baidu.mshield.x0.d.a();     // Catch: Throwable -> L18
        r102.f32475a = d.a(r100.getString(r100.getColumnIndex(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY)));     // Catch: Throwable -> L18
        r102.f32476b = r100.getInt(r100.getColumnIndex("b"));     // Catch: Throwable -> L18
        r102.f32477c = Long.parseLong(r100.getString(r100.getColumnIndex("c")));     // Catch: Throwable -> L18
        r101.add(r102);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L25
        if (r100 == null) goto L24;
        if (r100.isClosed() == true) goto L24;
    L25:
        th = move-exception;
        if (r100 != null) goto L28;
    L30:
        throw th;
    L28:
        if (r100.isClosed() == true) goto L30;
        r100.close();
        goto L30
    }

    public a(Context r100) {
        this.f32507b = "msvolcano.db";
        this.f32508c = 1;
        this.f32511f = "msal";
        this.f32512g = "CREATE TABLE IF NOT EXISTS " + this.f32511f + "(a TEXT PRIMARY KEY ON CONFLICT ABORT,b INTEGER,c TEXT)";
        r100.getApplicationContext();     // Catch: Throwable -> L5
        C0656a r101 = new C0656a(this, r100.getApplicationContext());     // Catch: Throwable -> L5
        this.f32509d = r101;     // Catch: Throwable -> L5
        this.f32510e = r101.getWritableDatabase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.a(th);
    }

    public com.baidu.mshield.x0.d.a a(String r110) {
        com.baidu.mshield.x0.d.a r100 = null;
        if (this.f32510e != null) goto L48;
        return null;
    L48:
        String r111 = d.b(r110);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r111) == false) goto L10;
        return null;
    L10:
        Cursor r112 = this.f32510e.query(this.f32511f, null, "a=?", new String[]{r111}, null, null, null);     // Catch: Throwable -> L27
        if (r112 != null) goto L50;
    L23:
        if (r112 != null) goto L25;
        return r100;
    L25:
        if (r112.isClosed() == true) goto L54;
    L35:
        r112.close();
        return r100;
    L54:
        return r100;
    L50:
    L21:
        th = move-exception;
        Cursor r101 = r112;
        com.baidu.mshield.x0.d.a r113 = r100;
        Throwable th10 = th;
    L29:
        Cursor r114 = r101;
        com.baidu.mshield.x0.d.a r102 = r113;
        r112 = r114;
    L44:
        d.a(th10);     // Catch: Throwable -> L38
        if (r112 == null) goto L37;
        if (r112.isClosed() == true) goto L37;
        r100 = r102;
    L37:
        return r102;
    L38:
        th = move-exception;
        if (r112 != null) goto L41;
    L43:
        throw th;
    L41:
        if (r112.isClosed() == true) goto L43;
        r112.close();
        goto L43
    L13:
        if (r112.getCount() <= 0) goto L23;
    L15:
        if (r112.moveToNext() == false) goto L23;
        r102 = new com.baidu.mshield.x0.d.a();     // Catch: Throwable -> L21
        r102.f32475a = d.a(r112.getString(r112.getColumnIndex(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY)));     // Catch: Throwable -> L19
        r102.f32476b = r112.getInt(r112.getColumnIndex("b"));     // Catch: Throwable -> L19
        r102.f32477c = Long.parseLong(r112.getString(r112.getColumnIndex("c")));     // Catch: Throwable -> L19
        r100 = r102;
    L19:
        th10 = th;
    L27:
        th = move-exception;
        r101 = null;
        th10 = th;
        r113 = null;
        goto L29
    }

    public final boolean b(String r110) {
        SQLiteDatabase r100 = this.f32510e;
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Cursor r102 = null;
    L17:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L24
        if (r102 != null) goto L21;
    L23:
        return r101;
    L21:
        if (r102.isClosed() == true) goto L23;
    L22:
        r102.close();
    L24:
        th = move-exception;
        if (r102 != null) goto L27;
    L29:
        throw th;
    L27:
        if (r102.isClosed() == true) goto L29;
        r102.close();
        goto L29
    L8:
        r102 = r100.query(this.f32511f, null, "a=?", new String[]{r110}, null, null, null);     // Catch: Throwable -> L17
        if (r102 == null) goto L13;
        if (r102.getCount() <= 0) goto L13;
        r101 = true;
    L13:
        if (r102 == null) goto L23;
        if (r102.isClosed() == true) goto L23;
        goto L23
    }

    public static /* synthetic */ int b(a r100) {
        return r100.f32508c;
    }

    public int a(com.baidu.mshield.x0.d.a r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L23:
        return r101;
    L5:
        if (this.f32510e == null) goto L23;
        String r102 = d.b(r100.f32475a);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return 0;
    L10:
        ContentValues r103 = new ContentValues();     // Catch: Throwable -> L21
        r103.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, r102);     // Catch: Throwable -> L21
        r103.put("b", Integer.valueOf(r100.f32476b));     // Catch: Throwable -> L21
        r103.put("c", Long.valueOf(r100.f32477c));     // Catch: Throwable -> L21
        if (b(r102) == false) goto L20;
        r101 = this.f32510e.update(this.f32511f, r103, "a= ?", new String[]{r102});     // Catch: Throwable -> L21
    L24:
        goto L23
    L20:
        r101 = (int) this.f32510e.insert(this.f32511f, null, r103);
    L21:
        th = move-exception;
        d.a(th);
        goto L23
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32506a != null) goto L7;
        f32506a = new a(r100);     // Catch: Throwable -> L10
    L7:
        a r101 = f32506a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public static /* synthetic */ String a(a r100) {
        return r100.f32507b;
    }
}
