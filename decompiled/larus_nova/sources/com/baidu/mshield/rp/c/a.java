package com.baidu.mshield.rp.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.amap.api.col.s.ce;
import com.baidu.mshield.ac.F;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.conig.Constants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f32397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0653a f32398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f32399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f32400d;

    /* JADX INFO: renamed from: com.baidu.mshield.rp.c.a$a, reason: collision with other inner class name */
    public class C0653a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r100) {
            r100.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            r100.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        public C0653a(a r100, Context r101) {
            super(r101, "msre.db", null, 1);
        }
    }

    public int b() {
        Cursor r100 = null;
        int r101 = 0;
        r100 = this.f32399c.query("r", null, null, null, null, null, null, null);     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r101 = r100.getCount();     // Catch: Throwable -> L9
    L6:
        if (r100 == null) goto L16;
        r100.close();     // Catch: Throwable -> L14
    L16:
        return r101;
    L14:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L9:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L17
        if (r100 == null) goto L16;
        r100.close();     // Catch: Throwable -> L14
    L17:
        th = move-exception;
        if (r100 != null) goto L24;
    L23:
        throw th;
    L24:
        r100.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L23
    }

    public int a() {
        com.baidu.mshield.sharedpreferences.a r100 = com.baidu.mshield.sharedpreferences.a.a(this.f32400d);
        long r101 = System.currentTimeMillis();
        return this.f32399c.delete("r", "(d <= ? or (d < (" + r101 + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(r101 - ((long) (r100.I() * BaseConstants.Time.DAY)))});
    L5:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return -1;
    }

    public List<com.baidu.mshield.rp.d.a> c() {
        ArrayList r100 = new ArrayList();
        Cursor r110 = null;
        r110 = this.f32399c.query("r", null, "i=5", null, null, null, "d desc", "100");     // Catch: Throwable -> L17
        if (r110 == null) goto L14;
    L5:
        if (r110.moveToNext() == false) goto L14;
        com.baidu.mshield.rp.d.a r101 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L17
        r101.f32401a = r110.getInt(r110.getColumnIndex(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY));     // Catch: Throwable -> L17
        r101.f32402b = r110.getString(r110.getColumnIndex("b"));     // Catch: Throwable -> L17
        r101.f32403c = r110.getInt(r110.getColumnIndex("c"));     // Catch: Throwable -> L17
        r101.f32405e = r110.getLong(r110.getColumnIndex("d"));     // Catch: Throwable -> L17
        r101.f32406f = r110.getInt(r110.getColumnIndex(ce.f26391f));     // Catch: Throwable -> L17
        r101.f32407g = r110.getInt(r110.getColumnIndex("e"));     // Catch: Throwable -> L17
        r101.f32408h = r110.getInt(r110.getColumnIndex("f"));     // Catch: Throwable -> L17
        r101.f32409i = r110.getInt(r110.getColumnIndex(RXScreenCaptureService.KEY_INDEX));     // Catch: Throwable -> L17
        r101.f32410j = r110.getString(r110.getColumnIndex(ce.f26395j));     // Catch: Throwable -> L17
        String r102 = r110.getString(r110.getColumnIndex("h"));     // Catch: Throwable -> L17
        r102 = new String(F.getInstance().ad(Base64.decode(r102, 0), "xVOTuxgN3lkRN2v4".getBytes(XML.CHARSET_UTF8)));     // Catch: Exception -> L10 Throwable -> L17
    L12:
        r101.f32404d = r102;     // Catch: Throwable -> L17
        r100.add(r101);     // Catch: Throwable -> L17
        goto L5
    L10:
        e = move-exception;
        com.baidu.mshield.utility.a.a(e);     // Catch: Throwable -> L17
        goto L12
    L14:
        if (r110 == null) goto L24;
        r110.close();     // Catch: Throwable -> L22
    L24:
        return r100;
    L22:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L25
        if (r110 == null) goto L24;
        r110.close();     // Catch: Throwable -> L22
    L25:
        th = move-exception;
        if (r110 != null) goto L32;
    L31:
        throw th;
    L32:
        r110.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L31
    }

    public final void d() {
        this.f32399c = this.f32398b.getWritableDatabase();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public a(Context r100) {
        this.f32400d = r100;
        this.f32398b = new C0653a(this, r100);
        com.baidu.mshield.sharedpreferences.a.a(r100);
        d();
    }

    public long a(com.baidu.mshield.rp.d.a r100) {
        ContentValues r101 = new ContentValues();     // Catch: Throwable -> L29
        r101.put("b", r100.f32402b);     // Catch: Throwable -> L29
        r101.put("c", Integer.valueOf(r100.f32403c));     // Catch: Throwable -> L29
        r101.put("d", Long.valueOf(r100.f32405e));     // Catch: Throwable -> L29
        r101.put("e", Integer.valueOf(r100.f32407g));     // Catch: Throwable -> L29
        r101.put(ce.f26391f, Integer.valueOf(r100.f32406f));     // Catch: Throwable -> L29
        r101.put("f", Integer.valueOf(r100.f32408h));     // Catch: Throwable -> L29
        r101.put(RXScreenCaptureService.KEY_INDEX, Integer.valueOf(r100.f32409i));     // Catch: Throwable -> L29
        r101.put(ce.f26395j, r100.f32410j);     // Catch: Throwable -> L29
        String r102 = r100.f32404d;     // Catch: Throwable -> L29
        r102 = Base64.encodeToString(F.getInstance().ae(r102.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(XML.CHARSET_UTF8)), 0);     // Catch: Exception -> L21 Throwable -> L29
    L23:
        r101.put("h", r102);     // Catch: Throwable -> L29
    L39:
        return this.f32399c.insert("r", null, r101);
    L26:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L29
    L31:
        return -1;
    L21:
        e = move-exception;
        com.baidu.mshield.utility.a.a(e);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L31
    }

    public List<com.baidu.mshield.rp.d.a> b(int r210) {
        ArrayList r100 = new ArrayList();
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L53
        com.baidu.mshield.sharedpreferences.a r102 = com.baidu.mshield.sharedpreferences.a.a(this.f32400d);     // Catch: Throwable -> L53
        int r103 = r102.F() * BaseConstants.Time.HOUR;
        if (r210 != 2) goto L8;
        String r104 = "(d <= (" + r101 + "-e*3600000) or e=0 )";     // Catch: Throwable -> L53
    L7:
        String r110 = r104;
        if (r210 == 2) goto L14;
        int r105 = r102.h();     // Catch: Throwable -> L35
        Cursor r106 = this.f32399c.query("r", null, r110, null, null, null, "d desc", Integer.toString(r105));     // Catch: Throwable -> L35
    L15:
        Cursor r107 = r106;
        if (r107 != null) goto L65;
    L32:
        if (r107 == null) goto L55;
        r107.close();     // Catch: Throwable -> L41
    L67:
    L55:
        return r100;
    L65:
        if (r107.moveToNext() == false) goto L32;
        com.baidu.mshield.rp.d.a r108 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L30
        r108.f32401a = r107.getInt(r107.getColumnIndex(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY));     // Catch: Throwable -> L30
        r108.f32402b = r107.getString(r107.getColumnIndex("b"));     // Catch: Throwable -> L30
        r108.f32403c = r107.getInt(r107.getColumnIndex("c"));     // Catch: Throwable -> L30
        r108.f32405e = r107.getLong(r107.getColumnIndex("d"));     // Catch: Throwable -> L30
        r108.f32406f = r107.getInt(r107.getColumnIndex(ce.f26391f));     // Catch: Throwable -> L30
        r108.f32407g = r107.getInt(r107.getColumnIndex("e"));     // Catch: Throwable -> L30
        r108.f32408h = r107.getInt(r107.getColumnIndex("f"));     // Catch: Throwable -> L30
        r108.f32409i = r107.getInt(r107.getColumnIndex(RXScreenCaptureService.KEY_INDEX));     // Catch: Throwable -> L30
        r108.f32410j = r107.getString(r107.getColumnIndex(ce.f26395j));     // Catch: Throwable -> L30
        String r109 = r107.getString(r107.getColumnIndex("h"));     // Catch: Throwable -> L30
        r109 = new String(F.getInstance().ad(Base64.decode(r109, 0), "xVOTuxgN3lkRN2v4".getBytes(XML.CHARSET_UTF8)));     // Catch: Exception -> L26 Throwable -> L30
    L28:
        r108.f32404d = r109;     // Catch: Throwable -> L30
        r100.add(r108);     // Catch: Throwable -> L30
        goto L65
    L26:
        e = move-exception;
        com.baidu.mshield.utility.a.a(e);     // Catch: Throwable -> L30
    L30:
        th = th;
    L59:
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L44
        if (r107 == null) goto L55;
        r107.close();     // Catch: Throwable -> L41
        goto L67
    L44:
        th = move-exception;
        if (r107 == null) goto L72;
        r107.close();     // Catch: Throwable -> L49
    L73:
        throw th;     // Catch: Throwable -> L53
    L49:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L72:
        throw th;     // Catch: Throwable -> L53
    L14:
        r106 = this.f32399c.query("r", null, r110, null, null, null, "d desc", Integer.toString(100));     // Catch: Throwable -> L35
    L35:
        th = th;
        r107 = null;
    L41:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L53
        goto L55
    L8:
        r104 = "(d <= (" + r101 + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (r101 - ((long) r103)) + ")";     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L55
    }

    public int a(List<Integer> r100) {
        int r101 = -1;
        this.f32399c.beginTransaction();     // Catch: Throwable -> L14
        Iterator<Integer> r102 = r100.iterator();     // Catch: Throwable -> L14
    L5:
        if (r102.hasNext() == false) goto L9;
        r101 = a(r102.next().intValue());     // Catch: Throwable -> L14
        if (r101 > 0) goto L5;
        com.baidu.mshield.rp.f.a.f32415a = System.currentTimeMillis();     // Catch: Throwable -> L14
        goto L5
    L9:
        this.f32399c.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f32399c.endTransaction();     // Catch: Throwable -> L12
    L20:
        return r101;
    L12:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        com.baidu.mshield.rp.f.a.f32415a = System.currentTimeMillis();
    L14:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L21
        com.baidu.mshield.rp.f.a.f32415a = System.currentTimeMillis();     // Catch: Throwable -> L21
        this.f32399c.endTransaction();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        com.baidu.mshield.rp.f.a.f32415a = System.currentTimeMillis();
    L21:
        th = move-exception;
        this.f32399c.endTransaction();     // Catch: Throwable -> L24
    L26:
        throw th;
    L24:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        com.baidu.mshield.rp.f.a.f32415a = System.currentTimeMillis();
        goto L26
    }

    public boolean b(String r110) {
        boolean r100 = true;
        Cursor r101 = null;
        r101 = this.f32399c.query("c", null, "b=?", new String[]{r110}, null, null, null);     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        if (r101.getCount() <= 0) goto L8;
        r100 = false;
        goto L8
    L8:
        if (r101 == null) goto L18;
        r101.close();     // Catch: Throwable -> L16
    L18:
        return r100;
    L11:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L19
        if (r101 == null) goto L18;
        r101.close();     // Catch: Throwable -> L16
    L19:
        th = move-exception;
        if (r101 != null) goto L30;
    L25:
        throw th;
    L30:
        r101.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    L16:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L18
    }

    public int a(int r100) {
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return -1;
    L4:
        return this.f32399c.delete("r", "a=?", new String[]{r100 + ""});
    }

    public long a(String r100) {
        ContentValues r101 = new ContentValues();
        r101.put("b", r100);
        return this.f32399c.insert("c", null, r101);
    L5:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return -1;
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32397a != null) goto L7;
        f32397a = new a(r100);     // Catch: Throwable -> L10
    L7:
        a r101 = f32397a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public List<com.baidu.mshield.rp.d.a> a(boolean r110, int r111) {
        ArrayList r100 = new ArrayList();
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L48
        if (r110 == false) goto L6;
        String r102 = "(d < (" + r101 + "-f*3600000) and f!= 0)";     // Catch: Throwable -> L48
    L7:
        String r103 = r102;
        if (r111 != 2) goto L11;
        Cursor r104 = this.f32399c.query("r", null, r103, null, null, null, "d desc", "100");     // Catch: Throwable -> L30
    L10:
        Cursor r105 = r104;
        if (r105 != null) goto L55;
    L27:
        if (r105 == null) goto L50;
        r105.close();     // Catch: Throwable -> L36
    L57:
    L50:
        return r100;
    L55:
        if (r105.moveToNext() == false) goto L27;
        com.baidu.mshield.rp.d.a r106 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L25
        r106.f32401a = r105.getInt(r105.getColumnIndex(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY));     // Catch: Throwable -> L25
        r106.f32402b = r105.getString(r105.getColumnIndex("b"));     // Catch: Throwable -> L25
        r106.f32403c = r105.getInt(r105.getColumnIndex("c"));     // Catch: Throwable -> L25
        r106.f32405e = r105.getLong(r105.getColumnIndex("d"));     // Catch: Throwable -> L25
        r106.f32406f = r105.getInt(r105.getColumnIndex(ce.f26391f));     // Catch: Throwable -> L25
        r106.f32407g = r105.getInt(r105.getColumnIndex("e"));     // Catch: Throwable -> L25
        r106.f32408h = r105.getInt(r105.getColumnIndex("f"));     // Catch: Throwable -> L25
        r106.f32409i = r105.getInt(r105.getColumnIndex(RXScreenCaptureService.KEY_INDEX));     // Catch: Throwable -> L25
        r106.f32410j = r105.getString(r105.getColumnIndex(ce.f26395j));     // Catch: Throwable -> L25
        String r107 = r105.getString(r105.getColumnIndex("h"));     // Catch: Throwable -> L25
        r107 = new String(F.getInstance().ad(Base64.decode(r107, 0), "xVOTuxgN3lkRN2v4".getBytes(XML.CHARSET_UTF8)));     // Catch: Exception -> L21 Throwable -> L25
    L23:
        r106.f32404d = r107;     // Catch: Throwable -> L25
        r100.add(r106);     // Catch: Throwable -> L25
        goto L55
    L21:
        e = move-exception;
        com.baidu.mshield.utility.a.a(e);     // Catch: Throwable -> L25
    L25:
        th = th;
    L61:
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L39
        if (r105 == null) goto L50;
        r105.close();     // Catch: Throwable -> L36
        goto L57
    L39:
        th = move-exception;
        if (r105 == null) goto L67;
        r105.close();     // Catch: Throwable -> L44
    L68:
        throw th;     // Catch: Throwable -> L48
    L44:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L67:
        throw th;     // Catch: Throwable -> L48
    L11:
        int r108 = com.baidu.mshield.sharedpreferences.a.a(this.f32400d).h();     // Catch: Throwable -> L30
        com.baidu.mshield.b.c.a.b("sj-trigger report 3g limit" + Integer.toString(r108));     // Catch: Throwable -> L30
        r104 = this.f32399c.query("r", null, r103, null, null, null, "d desc", Integer.toString(r108));     // Catch: Throwable -> L30
    L36:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L48
    L30:
        th = th;
        r105 = null;
        goto L61
    L6:
        r102 = "d<=" + (r101 - Constants.DOWNLOAD_TEMP_FILE_PAST_TIME);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        goto L50
    }
}
