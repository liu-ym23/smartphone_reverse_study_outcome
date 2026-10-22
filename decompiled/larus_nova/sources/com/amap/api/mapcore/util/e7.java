package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes28.dex */
public final class e7 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private r1 f27216a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        this.f27216a.getClass();
        if (r100 == null) goto L12;
        r100.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");     // Catch: Throwable -> L7
        r100.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");     // Catch: Throwable -> L7
        r100.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        t6.a(th, "DB", WidgetCostModule.TYPE_ON_CREATE);
        th.printStackTrace();
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r110, int r111) {
        this.f27216a.getClass();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r110 != 1) goto L20;
        r100.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
        Cursor r112 = r100.query("update_item", null, null, null, null, null, null);
        if (r112 != null) goto L11;
        r100.close();
        r100 = null;
    L11:
        if (r112 != null) goto L13;
        return;
    L13:
        if (r112.moveToNext() == false) goto L15;
        String r101 = r112.getString(r112.getColumnIndex("url"));
        String r102 = r101.substring(r101.lastIndexOf(HTTP.URL_DEFAULT) + 1);
        r100.execSQL("update update_item set mPinyin=? where url =?", new String[]{r102.substring(0, r102.lastIndexOf(".")), r101});
        goto L13
    L15:
        r112.close();
        return;
    }

    public e7(Context r100, String r101, int r102, r1 r103) {
        super(r100, r101, null, r102);
        this.f27216a = r103;
    }
}
