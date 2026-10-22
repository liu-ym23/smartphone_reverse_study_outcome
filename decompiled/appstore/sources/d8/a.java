package d8;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.AccountAppsColumns;
import com.bytedanceos.common.model.database.columns.AccountCollectionsColumns;
import com.bytedanceos.common.model.database.columns.AdsReportRecordColumns;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.model.database.columns.InstalledAppsColumns;
import com.bytedanceos.common.model.database.columns.MyAppsColumns;
import com.bytedanceos.common.model.database.columns.ReservedAppsColumns;
import com.bytedanceos.common.model.database.columns.SearchHistoryColums;
import com.bytedanceos.common.model.database.columns.WifiDownloadAppsColumns;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f19121b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19122a;

    public a(Context r10, String r11) {
        super(r10, r11, null, 40);
        this.f19122a = r10;
    }

    public static a h(Context r10) {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f19121b != null) goto L9;
        f19121b = new a(r10, "appstore.db");     // Catch: Throwable -> L7
    L9:
        a r11 = f19121b;     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return r11;
    }

    public final void a(SQLiteDatabase r10, String r11) {
        r10.execSQL(r11);
        j.a(r11);
    }

    public final void b(SQLiteDatabase r10) {
        Cursor r11 = r10.query(InstalledAppsColumns.TABLE, null, null, null, null, null, null);
        ArrayList r12 = new ArrayList();
        if (r11 != null) goto L5;
    L9:
        g(r10, InstalledAppsColumns.DROP_SQL);
        e(r10, InstalledAppsColumns.CREATE_SQL);
        i(r10, r12);
        return;
    L5:
        if (r11.moveToFirst() == false) goto L8;
    L6:
        r12.add(InstalledAppsColumns.convertDBToAppInfo(r11));
        if (r11.moveToNext() == true) goto L6;
    L8:
        r11.close();
        goto L9
    }

    public final void c(SQLiteDatabase r10) {
        Cursor r11 = r10.query(AccountAppsColumns.TABLE, null, null, null, null, null, null);
        ArrayList r12 = new ArrayList();
        if (r11 != null) goto L5;
    L9:
        g(r10, AccountAppsColumns.DROP_SQL);
        e(r10, AccountAppsColumns.CREATE_SQL);
        j(r10, r12);
        return;
    L5:
        if (r11.moveToFirst() == false) goto L8;
    L6:
        r12.add(AccountAppsColumns.convertDBToAppInfo(r11));
        if (r11.moveToNext() == true) goto L6;
    L8:
        r11.close();
        goto L9
    }

    public final void d(SQLiteDatabase r10) {
        Cursor r11 = r10.query(AccountCollectionsColumns.TABLE, null, null, null, null, null, null);
        ArrayList r12 = new ArrayList();
        if (r11 != null) goto L5;
    L9:
        g(r10, AccountCollectionsColumns.DROP_SQL);
        e(r10, AccountCollectionsColumns.CREATE_SQL);
        k(r10, r12);
        return;
    L5:
        if (r11.moveToFirst() == false) goto L8;
    L6:
        r12.add(AccountCollectionsColumns.convertDBToAppInfo(r11));
        if (r11.moveToNext() == true) goto L6;
    L8:
        r11.close();
        goto L9
    }

    public final void e(SQLiteDatabase r10, String r11) {
        r10.execSQL(r11);
        j.a(r11);
    }

    public final void f(SQLiteDatabase r10) {
        g(r10, DownloadInfoColumns.DROP_SQL);
        g(r10, SearchHistoryColums.DROP_SQL);
        g(r10, MyAppsColumns.DROP_SQL);
        g(r10, AccountCollectionsColumns.DROP_SQL);
        g(r10, InstalledAppsColumns.DROP_SQL);
        g(r10, AccountAppsColumns.DROP_SQL);
        g(r10, WifiDownloadAppsColumns.DROP_SQL);
        g(r10, AdsReportRecordColumns.DROP_SQL);
        g(r10, ReservedAppsColumns.DROP_SQL);
        onCreate(r10);
        m();
    }

    public final void g(SQLiteDatabase r10, String r11) {
        r10.execSQL(r11);
        j.a(r11);
    }

    public final void i(SQLiteDatabase r10, List r11) {
        if (r10 == null) goto L11;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() == 0) goto L14;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        r10.insert(InstalledAppsColumns.TABLE, "", InstalledAppsColumns.convertAppInfoToValues((AppInfo) r12.next()));
        goto L9
    L15:
        return;
    L14:
        return;
    }

    public final void j(SQLiteDatabase r10, List r11) {
        if (r10 == null) goto L11;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() == 0) goto L14;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        r10.insert(AccountAppsColumns.TABLE, "", AccountAppsColumns.convertAppInfoToValues((AppInfo) r12.next()));
        goto L9
    L15:
        return;
    L14:
        return;
    }

    public final void k(SQLiteDatabase r10, List r11) {
        if (r10 == null) goto L11;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() == 0) goto L14;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        r10.insert(AccountCollectionsColumns.TABLE, "", AccountCollectionsColumns.convertAppInfoToValues((AppInfo) r12.next()));
        goto L9
    L15:
        return;
    L14:
        return;
    }

    public boolean l(SQLiteDatabase r10, String r11, String r12) {
        boolean r13 = false;
        Cursor r14 = null;
        r14 = r10.rawQuery("select sql from sqlite_master where name = ? and sql like ?", new String[]{r11, "%" + r12 + "%"});     // Catch: Exception -> L8 Throwable -> L21
        if (r14 == null) goto L10;
        if (r14.moveToFirst() == false) goto L10;
        r13 = true;
        goto L10
    L10:
        if (r14 != null) goto L12;
    L14:
        return r13;
    L12:
        if (r14.isClosed() == true) goto L14;
        r14.close();
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r14 != null) goto L18;
    L20:
        return false;
    L18:
        if (r14.isClosed() == true) goto L20;
        r14.close();
    L21:
        if (r14 != null) goto L23;
    L25:
        return false;
    L23:
        if (r14.isClosed() == true) goto L25;
        r14.close();
        goto L25
    }

    public final void m() {
        com.bytedanceos.appstore.datacache.a.N0().w0("DOWNLOAD");
        com.bytedanceos.appstore.datacache.a.N0().w0("UPDATE");
        com.bytedanceos.appstore.datacache.a.N0().w0("MYAPPS");
        com.bytedanceos.appstore.datacache.a.N0().w0("COLLECT");
    }

    public final void n(SQLiteDatabase r10) {
        r10.execSQL(MyAppsColumns.RESET_UPDATE_FLAG_FOR_SIGN);
        j.a(MyAppsColumns.RESET_UPDATE_FLAG_FOR_SIGN);
    }

    public final void o(SQLiteDatabase r10) {
        g(r10, SearchHistoryColums.DROP_SQL);
        e(r10, SearchHistoryColums.CREATE_SQL);
        ArrayList r11 = new ArrayList();
        String r12 = b0.n().s("history", "com.bytedanceos.appstore.search", this.f19122a);
        j.a(r12);
        if (TextUtils.isEmpty(r12) == true) goto L10;
        String[] r13 = r12.split(";");
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        String r16 = r13[r15];
        if (TextUtils.isEmpty(r16.trim()) == true) goto L9;
        r11.add(r16);
    L9:
        r15 = r15 + 1;
    L10:
        b0.n().I("history", "com.bytedanceos.appstore.search", this.f19122a);
        Iterator r17 = r11.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        String r18 = "INSERT INTO search_history (keyword,use_count,create_time) values ('" + ((String) r17.next()) + "',1," + System.currentTimeMillis() + ");";
        r10.execSQL(r18);
        j.a(r18);
        goto L12
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
        e(r10, DownloadInfoColumns.CREATE_SQL);
        e(r10, SearchHistoryColums.CREATE_SQL);
        e(r10, MyAppsColumns.CREATE_SQL);
        e(r10, AccountCollectionsColumns.CREATE_SQL);
        e(r10, InstalledAppsColumns.CREATE_SQL);
        e(r10, AccountAppsColumns.CREATE_SQL);
        e(r10, WifiDownloadAppsColumns.CREATE_SQL);
        e(r10, AdsReportRecordColumns.CREATE_SQL);
        e(r10, ReservedAppsColumns.CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
        f(r10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        switch(r11) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            case 13: goto L5;
            case 14: goto L86;
            case 15: goto L41;
            case 16: goto L42;
            case 17: goto L43;
            case 18: goto L44;
            case 19: goto L45;
            case 20: goto L46;
            case 21: goto L47;
            case 22: goto L48;
            case 23: goto L49;
            case 24: goto L50;
            case 25: goto L51;
            case 26: goto L52;
            case 27: goto L53;
            case 28: goto L54;
            case 29: goto L55;
            case 30: goto L56;
            case 31: goto L58;
            case 32: goto L65;
            case 33: goto L66;
            case 34: goto L67;
            case 35: goto L68;
            case 36: goto L69;
            case 37: goto L70;
            case 38: goto L71;
            case 39: goto L72;
            default: goto L73;
        };
    L5:
        int r13 = r11;
    L32:
        if (r11 < 12) goto L39;
        s(r10);     // Catch: Throwable -> L35 Exception -> L37
    L37:
        Exception e10 = e;
    L76:
        e10.printStackTrace();     // Catch: Throwable -> L35
        if (r13 == 40) goto L89;
    L75:
        f(r10);
        return;
    L89:
        return;
    L39:
        r11 = r13 + 1;
        goto L86
    L6:
        int r14 = r11;
    L30:
        r(r10);     // Catch: Throwable -> L35 Exception -> L37
        r13 = r14 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L32
    L7:
        int r15 = r11;
    L29:
        q(r10);     // Catch: Throwable -> L35 Exception -> L37
        r14 = r15 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L30
    L8:
        int r16 = r11;
    L28:
        m();     // Catch: Throwable -> L35 Exception -> L37
        r15 = r16 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L29
    L9:
        int r17 = r11;
    L27:
        m();     // Catch: Throwable -> L35 Exception -> L37
        r16 = r17 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L28
    L10:
        int r18 = r11;
    L26:
        u(r10);     // Catch: Throwable -> L35 Exception -> L37
        r17 = r18 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L27
    L11:
        int r19 = r11;
    L25:
        r18 = r19 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L26
    L12:
        int r20 = r11;
    L24:
        r19 = r20 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L25
    L13:
        int r21 = r11;
    L23:
        p(r10);     // Catch: Throwable -> L35 Exception -> L37
        r20 = r21 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L24
    L14:
        int r22 = r11;
    L22:
        r21 = r22 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L23
    L15:
        int r23 = r11;
    L21:
        r22 = r23 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L22
    L16:
        int r24 = r11;
    L20:
        r23 = r24 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L21
    L17:
        r13 = r11;
    L84:
        o(r10);     // Catch: Throwable -> L35 Exception -> L37
        r24 = r13 + 1;     // Catch: Throwable -> L35 Exception -> L37
        goto L20
    L18:
        r13 = r11 + 1;
    L41:
        a(r10, InstalledAppsColumns.ADD_COLUMN_SQL_SYNC);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L42:
        e(r10, WifiDownloadAppsColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L43:
        e(r10, InstalledAppsColumns.ADD_COLUMN_SQL_HIDE);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L44:
        a(r10, AccountAppsColumns.ADD_MARK_DELETED_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L45:
        a(r10, MyAppsColumns.ADD_COLUMN_SQL_UPDATE);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, MyAppsColumns.ADD_COLUMN_SQL_HIDE);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L46:
        g(r10, DownloadInfoColumns.DROP_SQL);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, DownloadInfoColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L47:
        e(r10, "ALTER TABLE account_apps ADD COLUMN app_mark TEXT");     // Catch: Throwable -> L60 Exception -> L62
        e(r10, MyAppsColumns.ADD_MARK_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, AccountCollectionsColumns.ADD_MARK_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L48:
        g(r10, "DROP TABLE IF EXISTS api;");     // Catch: Throwable -> L60 Exception -> L62
        g(r10, "DROP TABLE IF EXISTS apk_log;");     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L49:
        g(r10, DownloadInfoColumns.DROP_SQL);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, DownloadInfoColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L50:
        e(r10, MyAppsColumns.ADD_DIFF_MD5_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, MyAppsColumns.ADD_RETRY_DOWNLOAD_URL_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L51:
        g(r10, InstalledAppsColumns.DROP_COLUMN_SQL_HIDE);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, InstalledAppsColumns.ADD_COLUMN_SQL_MD5);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L52:
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_BYTE);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_SCORE);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_CATEGORY);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_BRIEF_RECMD);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_APP_TYPE);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L53:
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_APP_STATE);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_DIFFMD5);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_DIFF_DOWNLOAD_URL);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_APP_FROM);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_AUTO_DOWNLOAD);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_API_URL);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_PAGE_TITLE);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L54:
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_TIME_DOWNLOAD_ENQUEUE);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L55:
        g(r10, DownloadInfoColumns.DROP_COLUMN_SQL_APP_FILE_PATH);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_TASK_OWNER);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L56:
        e(r10, AdsReportRecordColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_ADS_DATA);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L65:
        e(r10, ReservedAppsColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L66:
        t(r10);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L67:
        a(r10, DownloadInfoColumns.ADD_COLUMN_SQL_RETRY_NUM);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L68:
        a(r10, MyAppsColumns.APP_MEM_URL);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, MyAppsColumns.APP_DM_URL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L69:
        a(r10, DownloadInfoColumns.ADD_COLUMN_MD5_FILE_DATA);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, "ALTER TABLE account_apps ADD COLUMN app_mark TEXT");     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L70:
        a(r10, DownloadInfoColumns.ADD_COLUMN_APP_ID);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_UPDATE_MODE);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, DownloadInfoColumns.ADD_COLUMN_SYS_APP_AUTO_UPDATE_TASK_ID);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L71:
        a(r10, MyAppsColumns.ADD_DOWNLOAD_URL_BACKUPS_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L72:
        n(r10);     // Catch: Throwable -> L60 Exception -> L62
        a(r10, MyAppsColumns.ADD_APK_SIGN_SHA256_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L73:
        r10.setVersion(r11);     // Catch: Throwable -> L60 Exception -> L62
        if (r11 != 40) goto L75;
        return;
    L62:
        e = move-exception;
        r13 = r11;
        e10 = e;
    L60:
        th = move-exception;
        int r25 = r11;
        th = th;
    L80:
        if (r25 == 40) goto L82;
        f(r10);
    L82:
        throw th;
    L86:
        a(r10, AccountAppsColumns.ADD_VERSION_NAME_COLUMN_SQL);     // Catch: Throwable -> L60 Exception -> L62
        e(r10, MyAppsColumns.CREATE_SQL);     // Catch: Throwable -> L60 Exception -> L62
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L58:
        if (l(r10, AdsReportRecordColumns.TABLE, AdsReportRecordColumns.ADS_REPORT_MD5) == true) goto L64;
        a(r10, "ALTER TABLE ads_report_record ADD COLUMN url_md5 TEXT");     // Catch: Throwable -> L60 Exception -> L62
    L64:
        r11 = r11 + 1;     // Catch: Throwable -> L60 Exception -> L62
    L35:
        th = th;
        goto L80
    }

    public final void p(SQLiteDatabase r10) {
        Cursor r11 = null;
        r11 = r10.query(SearchHistoryColums.TABLE, null, null, null, null, null, null);     // Catch: Throwable -> L9 Exception -> L11
        if (r11 == null) goto L18;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L9 Exception -> L11
    L7:
        if (r11.moveToNext() == false) goto L13;
        r12.add(r11.getString(1).replace("REPLACE_THE_DOUBLE_QUOTES_WITH_THIS_TAG_FOR_BYTEDANCE_APPSTORE", "''"));     // Catch: Throwable -> L9 Exception -> L11
        goto L7
    L13:
        r10.execSQL("delete from search_history");     // Catch: Throwable -> L9 Exception -> L11
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L9 Exception -> L11
    L14:
        if (r13.hasNext() == false) goto L18;
        String r14 = "INSERT INTO search_history (keyword,use_count,create_time) values ('" + ((String) r13.next()) + "',1," + System.currentTimeMillis() + ");";     // Catch: Throwable -> L9 Exception -> L11
        r10.execSQL(r14);     // Catch: Throwable -> L9 Exception -> L11
        j.a(r14);     // Catch: Throwable -> L9 Exception -> L11
        goto L14
    L18:
        if (r11 == null) goto L23;
    L19:
        r11.close();
        return;
    L23:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        if (r11 != null) goto L19;
        return;
    L9:
        th = move-exception;
        if (r11 == null) goto L26;
        r11.close();
    L26:
        throw th;
    }

    public final void q(SQLiteDatabase r10) {
        c(r10);
        d(r10);
        b(r10);
    }

    public final void r(SQLiteDatabase r10) {
        boolean r11 = b0.n().k(this.f19122a, "com.bytedanceos.appstore.account", "isAutoUpdate");
        if (b0.n().k(this.f19122a, "com.bytedanceos.appstore.setting", "isAutoUpdate") == true) goto L6;
        if (r11 == false) goto L6;
        boolean r12 = b0.n().l("isAutoUpdate", "com.bytedanceos.appstore.account", this.f19122a).booleanValue();
        s.r(this.f19122a, r12);
        b0.n().I("isAutoUpdate", "com.bytedanceos.appstore.account", this.f19122a);
    L6:
        boolean r13 = b0.n().k(this.f19122a, "com.bytedanceos.appstore.account", "isShowUpdateCount");
        if (b0.n().k(this.f19122a, "com.bytedanceos.appstore.setting", "isShowUpdateCount") == true) goto L11;
        if (r13 == false) goto L12;
        boolean r14 = b0.n().l("isShowUpdateCount", "com.bytedanceos.appstore.account", this.f19122a).booleanValue();
        s.A(this.f19122a, r14);
        b0.n().I("isShowUpdateCount", "com.bytedanceos.appstore.account", this.f19122a);
        return;
    L12:
        return;
    }

    public final void s(SQLiteDatabase r10) {
        a(r10, AccountAppsColumns.ADD_COLUMN_SQL);
        a(r10, AccountCollectionsColumns.ADD_COLUMN_SQL);
        a(r10, InstalledAppsColumns.ADD_COLUMN_SQL);
    }

    public final void t(SQLiteDatabase r10) {
        a(r10, AdsReportRecordColumns.ADD_COLUMN_SQL_ADS_RETRY_COUNT);
    }

    public final void u(SQLiteDatabase r10) {
        e(r10, AccountAppsColumns.CREATE_SQL);
        e(r10, AccountCollectionsColumns.CREATE_SQL);
        e(r10, InstalledAppsColumns.CREATE_SQL);
    }
}
