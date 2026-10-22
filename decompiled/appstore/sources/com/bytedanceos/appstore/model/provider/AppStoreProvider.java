package com.bytedanceos.appstore.model.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import com.bytedanceos.appstore.utils.d;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.database.columns.AccountAppsColumns;
import com.bytedanceos.common.model.database.columns.AccountCollectionsColumns;
import com.bytedanceos.common.model.database.columns.AdsReportRecordColumns;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.model.database.columns.InstalledAppsColumns;
import com.bytedanceos.common.model.database.columns.MyAppsColumns;
import com.bytedanceos.common.model.database.columns.ReservedAppsColumns;
import com.bytedanceos.common.model.database.columns.SearchHistoryColums;
import com.bytedanceos.common.model.database.columns.WifiDownloadAppsColumns;

/* JADX INFO: loaded from: classes2.dex */
public class AppStoreProvider extends BaseDBContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final UriMatcher f9417e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f9418d;

    static {
        f9417e = new UriMatcher(-1);
    }

    public AppStoreProvider() {
    }

    public static int h(Uri r10, String r11) {
        int r12 = f9417e.match(r10);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        throw new IllegalArgumentException("Unknown uri: " + r10);
    }

    public static String k(String r10, String r11) {
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r10 + " AND (" + r11 + ")";
    }

    public static String l(String r10, String r11) {
        StringBuilder r12 = new StringBuilder(256);
        r12.append("_id=");
        r12.append(r10);
        if (r11 == null) goto L6;
        r12.append(" AND (");
        r12.append(r11);
        r12.append(")");
    L6:
        return r12.toString();
    }

    @Override // com.bytedanceos.appstore.model.provider.BaseDBContentProvider
    public int b(Uri r10, String r11, String[] r12) {
        int r13 = h(r10, "delete");
        SQLiteDatabase r14 = this.f9421c.getWritableDatabase();
        String r15 = i(r13);
        switch(r13) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L9;
            case 18: goto L5;
            case 19: goto L9;
            case 20: goto L7;
            default: goto L5;
        };
    L6:
        int r16 = 0;
    L10:
        f(CommonColumns.CONTENT_URI, null);
        return r16;
    L7:
        r16 = r14.delete(r15, k("app_packagename='" + r10.getPathSegments().get(1) + "'", r11), r12);
        goto L10
    L8:
        r16 = r14.delete(r15, l(r10.getPathSegments().get(1), r11), r12);
        goto L10
    L9:
        r16 = r14.delete(r15, r11, r12);
        goto L10
    L5:
        throw new IllegalArgumentException("Unknown URI " + r10);
    }

    @Override // com.bytedanceos.appstore.model.provider.BaseDBContentProvider
    public SQLiteOpenHelper c() {
        if (this.f9421c != null) goto L6;
        this.f9421c = d8.a.h(getContext());
    L6:
        return this.f9421c;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        return this.f9418d.a(r10, r11, r12);
    }

    @Override // com.bytedanceos.appstore.model.provider.BaseDBContentProvider
    public Uri d(Uri r10, ContentValues r11) {
        int r12 = h(r10, "insert");
        SQLiteDatabase r13 = this.f9421c.getWritableDatabase();
        String r14 = i(r12);
        if (r12 != 1) goto L5;
    L23:
        long r15 = r13.insert(r14, "", r11);
        if (r15 <= 0) goto L28;
        Uri r16 = ContentUris.withAppendedId(r10, r15);
        f(r16, null);
        return r16;
    L28:
        throw new SQLiteException("Failed to insert row into " + r10);
    L5:
        if (r12 == 4) goto L23;
        if (r12 == 7) goto L23;
        if (r12 == 9) goto L23;
        if (r12 == 11) goto L23;
        if (r12 == 13) goto L23;
        if (r12 == 15) goto L23;
        if (r12 == 17) goto L23;
        if (r12 == 19) goto L23;
        throw new IllegalArgumentException("Unknown URI " + r10);
    }

    @Override // com.bytedanceos.appstore.model.provider.BaseDBContentProvider
    public int g(Uri r10, ContentValues r11, String r12, String[] r13) {
        int r14 = h(r10, "update");
        SQLiteDatabase r15 = this.f9421c.getWritableDatabase();
        String r16 = i(r14);
        switch(r14) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L9;
            case 18: goto L5;
            case 19: goto L9;
            case 20: goto L7;
            default: goto L5;
        };
    L6:
        int r17 = r15.update(r16, r11, k("keyword='" + r10.getPathSegments().get(1) + "'", r12), r13);
    L10:
        f(r10, null);
        return r17;
    L7:
        r17 = r15.update(r16, r11, k("app_packagename='" + r10.getPathSegments().get(1) + "'", r12), r13);
        goto L10
    L8:
        r17 = r15.update(r16, r11, l(r10.getPathSegments().get(1), r12), r13);
        goto L10
    L9:
        r17 = r15.update(r16, r11, r12, r13);
        goto L10
    L5:
        throw new IllegalArgumentException("Unknown URI " + r10);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        int r11 = h(r10, "getType");
        String r12 = i(r11);
        switch(r11) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L9;
            case 16: goto L7;
            case 17: goto L9;
            case 18: goto L4;
            case 19: goto L9;
            case 20: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return "vnd.android.cursor.item/" + r12;
    L9:
        return "vnd.android.cursor.dir/" + r12;
    }

    public final String i(int r10) {
        switch(r10) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L11;
            case 14: goto L11;
            case 15: goto L9;
            case 16: goto L9;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L5;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return ReservedAppsColumns.TABLE;
    L7:
        return AdsReportRecordColumns.TABLE;
    L9:
        return WifiDownloadAppsColumns.TABLE;
    L11:
        return MyAppsColumns.TABLE;
    L13:
        return InstalledAppsColumns.TABLE;
    L15:
        return AccountCollectionsColumns.TABLE;
    L17:
        return AccountAppsColumns.TABLE;
    L19:
        return SearchHistoryColums.TABLE;
    L21:
        return DownloadInfoColumns.TABLE;
    }

    public final void j() {
        this.f9421c = c();
        UriMatcher r10 = f9417e;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (d.a() == false) goto L9;
        String r11 = "com.obric.appstore";
    L10:
        r10.addURI(r11, DownloadInfoColumns.PATH, 1);     // Catch: Throwable -> L7
        r10.addURI(r11, DownloadInfoColumns.PATH_ID, 2);     // Catch: Throwable -> L7
        r10.addURI(r11, DownloadInfoColumns.PATH_PACKAGENAME, 3);     // Catch: Throwable -> L7
        r10.addURI(r11, SearchHistoryColums.PATH, 4);     // Catch: Throwable -> L7
        r10.addURI(r11, SearchHistoryColums.PATH_KEYWORD, 6);     // Catch: Throwable -> L7
        r10.addURI(r11, MyAppsColumns.PATH, 13);     // Catch: Throwable -> L7
        r10.addURI(r11, MyAppsColumns.PATH_PACKAGENAME, 14);     // Catch: Throwable -> L7
        r10.addURI(r11, AccountAppsColumns.PATH, 7);     // Catch: Throwable -> L7
        r10.addURI(r11, AccountAppsColumns.PATH_PACKAGENAME, 8);     // Catch: Throwable -> L7
        r10.addURI(r11, AccountCollectionsColumns.PATH, 9);     // Catch: Throwable -> L7
        r10.addURI(r11, AccountCollectionsColumns.PATH_PACKAGENAME, 10);     // Catch: Throwable -> L7
        r10.addURI(r11, InstalledAppsColumns.PATH, 11);     // Catch: Throwable -> L7
        r10.addURI(r11, InstalledAppsColumns.PATH_PACKAGENAME, 12);     // Catch: Throwable -> L7
        r10.addURI(r11, WifiDownloadAppsColumns.PATH, 15);     // Catch: Throwable -> L7
        r10.addURI(r11, WifiDownloadAppsColumns.PATH_PACKAGENAME, 16);     // Catch: Throwable -> L7
        r10.addURI(r11, AdsReportRecordColumns.PATH, 17);     // Catch: Throwable -> L7
        r10.addURI(r11, AdsReportRecordColumns.PATH_PACKAGENAME, 17);     // Catch: Throwable -> L7
        r10.addURI(r11, ReservedAppsColumns.PATH, 19);     // Catch: Throwable -> L7
        r10.addURI(r11, ReservedAppsColumns.PATH_PACKAGENAME, 20);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L9:
        r11 = "com.bytedanceos.gamestore";
        goto L10
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f9418d = new a(getContext());
        j();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r15, String[] r16, String r17, String[] r18, String r19) {
        int r10 = h(r15, "query");     // Catch: IllegalArgumentException -> L13
        SQLiteDatabase r11 = this.f9421c.getReadableDatabase();
        String r12 = i(r10);
        String r13 = r15.getQueryParameter(CommonColumns.PARAMETER_LIMIT);
        switch(r10) {
            case 1: goto L12;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L12;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L12;
            case 8: goto L23;
            case 9: goto L12;
            case 10: goto L23;
            case 11: goto L12;
            case 12: goto L23;
            case 13: goto L12;
            case 14: goto L23;
            case 15: goto L12;
            case 16: goto L23;
            case 17: goto L12;
            case 18: goto L7;
            case 19: goto L12;
            case 20: goto L23;
            default: goto L7;
        };
    L7:
        throw new IllegalArgumentException("Unknown URI " + r15);
    L22:
        return r11.query(r12, r16, k("keyword='" + r15.getPathSegments().get(1) + "'", r17), r18, null, null, r19, r13);
    L23:
        return r11.query(r12, r16, k("app_packagename='" + r15.getPathSegments().get(1) + "'", r17), r18, null, null, r19, r13);
    L24:
        return r11.query(r12, r16, l(r15.getPathSegments().get(1), r17), r18, null, null, r19, r13);
    L12:
        return r11.query(r12, r16, r17, r18, null, null, r19, r13);
    L13:
        e = move-exception;
        String r14 = r15.toString();
        if (r14 != null) goto L17;
        throw e;
    L17:
        if (r14.endsWith("/-1") == false) goto L26;
        h(Uri.parse(r14.substring(0, r14.length() - 2) + AdReportParam.ClickPosType.SKIP), "query");
        throw e;
    L26:
        throw e;
    }
}
