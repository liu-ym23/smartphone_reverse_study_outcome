package com.baidu.mshield.x0.f;

import B0.g;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f8407a;

    /* renamed from: d, reason: collision with root package name */
    public C0039a f8410d;

    /* renamed from: e, reason: collision with root package name */
    public SQLiteDatabase f8411e;

    /* renamed from: b, reason: collision with root package name */
    public String f8408b = "msvolcano.db";

    /* renamed from: c, reason: collision with root package name */
    public int f8409c = 1;

    /* renamed from: f, reason: collision with root package name */
    public String f8412f = "msal";

    /* renamed from: g, reason: collision with root package name */
    public String f8413g = g.r(new StringBuilder("CREATE TABLE IF NOT EXISTS "), this.f8412f, "(a TEXT PRIMARY KEY ON CONFLICT ABORT,b INTEGER,c TEXT)");

    /* renamed from: com.baidu.mshield.x0.f.a$a, reason: collision with other inner class name */
    public class C0039a extends SQLiteOpenHelper {
        public C0039a(Context context) {
            super(context, a.this.f8408b, (SQLiteDatabase.CursorFactory) null, a.this.f8409c);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f8413g);
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        }
    }

    public a(Context context) {
        try {
            context.getApplicationContext();
            C0039a c0039a = new C0039a(context.getApplicationContext());
            this.f8410d = c0039a;
            this.f8411e = c0039a.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        try {
            if (f8407a == null) {
                f8407a = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8407a;
    }

    public final boolean b(String str) {
        SQLiteDatabase sQLiteDatabase = this.f8411e;
        boolean z4 = false;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query(this.f8412f, null, "a=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0) {
                    z4 = true;
                }
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
        }
        return z4;
    }

    public int a(com.baidu.mshield.x0.d.a aVar) {
        int iInsert = 0;
        if (aVar != null && this.f8411e != null) {
            try {
                String strB = d.b(aVar.f8376a);
                if (TextUtils.isEmpty(strB)) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("a", strB);
                contentValues.put("b", Integer.valueOf(aVar.f8377b));
                contentValues.put("c", Long.valueOf(aVar.f8378c));
                if (b(strB)) {
                    iInsert = this.f8411e.update(this.f8412f, contentValues, "a= ?", new String[]{strB});
                } else {
                    iInsert = (int) this.f8411e.insert(this.f8412f, null, contentValues);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return iInsert;
    }

    public com.baidu.mshield.x0.d.a a(String str) {
        Throwable th;
        Cursor cursorQuery;
        com.baidu.mshield.x0.d.a aVar;
        String strB;
        boolean zIsClosed;
        com.baidu.mshield.x0.d.a aVar2 = null;
        if (this.f8411e == null) {
            return null;
        }
        try {
            strB = d.b(str);
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        cursorQuery = this.f8411e.query(this.f8412f, null, "a=?", new String[]{strB}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        aVar = new com.baidu.mshield.x0.d.a();
                        try {
                            aVar.f8376a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                            aVar.f8377b = cursorQuery.getInt(cursorQuery.getColumnIndex("b"));
                            aVar.f8378c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                            aVar2 = aVar;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                d.a(th);
                                if (cursorQuery != null || cursorQuery.isClosed()) {
                                    return aVar;
                                }
                                aVar2 = aVar;
                                return aVar2;
                            } finally {
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = aVar2;
                d.a(th);
                if (cursorQuery != null) {
                }
                return aVar;
            }
        }
        if (cursorQuery == null) {
            return aVar2;
        }
        if (zIsClosed) {
            return aVar2;
        }
        return aVar2;
    }

    public List<com.baidu.mshield.x0.d.a> a() {
        Cursor cursorQuery = null;
        if (this.f8411e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursorQuery = this.f8411e.query(this.f8412f, null, null, null, null, null, "b DESC");
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                while (cursorQuery.moveToNext()) {
                    com.baidu.mshield.x0.d.a aVar = new com.baidu.mshield.x0.d.a();
                    aVar.f8376a = d.a(cursorQuery.getString(cursorQuery.getColumnIndex("a")));
                    aVar.f8377b = cursorQuery.getInt(cursorQuery.getColumnIndex("b"));
                    aVar.f8378c = Long.parseLong(cursorQuery.getString(cursorQuery.getColumnIndex("c")));
                    arrayList.add(aVar);
                }
            }
        } catch (Throwable th) {
            try {
                d.a(th);
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null && !cursorQuery.isClosed()) {
        }
        return arrayList;
    }
}
