package com.baidu.mshield.rp.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.baidu.mshield.ac.F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f8298a;

    /* renamed from: b, reason: collision with root package name */
    public C0036a f8299b;

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f8300c;

    /* renamed from: d, reason: collision with root package name */
    public Context f8301d;

    /* renamed from: com.baidu.mshield.rp.c.a$a, reason: collision with other inner class name */
    public class C0036a extends SQLiteOpenHelper {
        public C0036a(a aVar, Context context) {
            super(context, "msre.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        }
    }

    public a(Context context) {
        this.f8301d = context;
        this.f8299b = new C0036a(this, context);
        com.baidu.mshield.sharedpreferences.a.a(context);
        d();
    }

    public static synchronized a a(Context context) {
        try {
            if (f8298a == null) {
                f8298a = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8298a;
    }

    public boolean b(String str) {
        boolean z4 = true;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f8300c.query("c", null, "b=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z4 = false;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return z4;
    }

    public List<com.baidu.mshield.rp.d.a> c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f8300c.query("r", null, "i=5", null, null, null, "d desc", "100");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                        aVar.f8302a = cursorQuery.getInt(cursorQuery.getColumnIndex("a"));
                        aVar.f8303b = cursorQuery.getString(cursorQuery.getColumnIndex("b"));
                        aVar.f8304c = cursorQuery.getInt(cursorQuery.getColumnIndex("c"));
                        aVar.f8306e = cursorQuery.getLong(cursorQuery.getColumnIndex(DateTokenConverter.CONVERTER_KEY));
                        aVar.f8307f = cursorQuery.getInt(cursorQuery.getColumnIndex("g"));
                        aVar.f8308g = cursorQuery.getInt(cursorQuery.getColumnIndex("e"));
                        aVar.f8309h = cursorQuery.getInt(cursorQuery.getColumnIndex("f"));
                        aVar.f8310i = cursorQuery.getInt(cursorQuery.getColumnIndex(IntegerTokenConverter.CONVERTER_KEY));
                        aVar.f8311j = cursorQuery.getString(cursorQuery.getColumnIndex("j"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception e4) {
                            com.baidu.mshield.utility.a.a(e4);
                        }
                        aVar.f8305d = string;
                        arrayList.add(aVar);
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                try {
                    com.baidu.mshield.utility.a.a(th);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th3) {
                            com.baidu.mshield.utility.a.a(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public final void d() {
        try {
            this.f8300c = this.f8299b.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public long a(com.baidu.mshield.rp.d.a aVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", aVar.f8303b);
            contentValues.put("c", Integer.valueOf(aVar.f8304c));
            contentValues.put(DateTokenConverter.CONVERTER_KEY, Long.valueOf(aVar.f8306e));
            contentValues.put("e", Integer.valueOf(aVar.f8308g));
            contentValues.put("g", Integer.valueOf(aVar.f8307f));
            contentValues.put("f", Integer.valueOf(aVar.f8309h));
            contentValues.put(IntegerTokenConverter.CONVERTER_KEY, Integer.valueOf(aVar.f8310i));
            contentValues.put("j", aVar.f8311j);
            String strEncodeToString = aVar.f8305d;
            try {
                strEncodeToString = Base64.encodeToString(F.getInstance().ae(strEncodeToString.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception e4) {
                com.baidu.mshield.utility.a.a(e4);
            }
            contentValues.put("h", strEncodeToString);
            try {
                return this.f8300c.insert("r", null, contentValues);
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                return -1L;
            }
        } catch (Throwable th2) {
            com.baidu.mshield.utility.a.a(th2);
        }
    }

    public List<com.baidu.mshield.rp.d.a> b(int i4) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.f8301d);
            int iF = aVarA.F() * CoreConstants.MILLIS_IN_ONE_HOUR;
            if (i4 == 2) {
                str = "(d <= (" + jCurrentTimeMillis + "-e*3600000) or e=0 )";
            } else {
                str = "(d <= (" + jCurrentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (jCurrentTimeMillis - iF) + ")";
            }
            String str2 = str;
            try {
                try {
                    if (i4 == 2) {
                        cursorQuery = this.f8300c.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                    } else {
                        cursorQuery = this.f8300c.query("r", null, str2, null, null, null, "d desc", Integer.toString(aVarA.h()));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f8302a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.f8303b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.f8304c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.f8306e = cursor.getLong(cursor.getColumnIndex(DateTokenConverter.CONVERTER_KEY));
                                aVar.f8307f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.f8308g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.f8309h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.f8310i = cursor.getInt(cursor.getColumnIndex(IntegerTokenConverter.CONVERTER_KEY));
                                aVar.f8311j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e4) {
                                    com.baidu.mshield.utility.a.a(e4);
                                }
                                aVar.f8305d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    com.baidu.mshield.utility.a.a(th2);
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.f8300c.insert("c", null, contentValues);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1L;
        }
    }

    public int a(int i4) {
        try {
            return this.f8300c.delete("r", "a=?", new String[]{i4 + ""});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }

    public int a(List<Integer> list) {
        int iA = -1;
        try {
            this.f8300c.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iA = a(it.next().intValue());
                if (iA <= 0) {
                    com.baidu.mshield.rp.f.a.f8316a = System.currentTimeMillis();
                }
            }
            this.f8300c.setTransactionSuccessful();
            try {
                this.f8300c.endTransaction();
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
                com.baidu.mshield.rp.f.a.f8316a = System.currentTimeMillis();
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                com.baidu.mshield.rp.f.a.f8316a = System.currentTimeMillis();
            } finally {
                try {
                    this.f8300c.endTransaction();
                } catch (Throwable th3) {
                    com.baidu.mshield.utility.a.a(th3);
                    com.baidu.mshield.rp.f.a.f8316a = System.currentTimeMillis();
                }
            }
        }
        return iA;
    }

    public List<com.baidu.mshield.rp.d.a> a(boolean z4, int i4) {
        String str;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z4) {
                str = "(d < (" + jCurrentTimeMillis + "-f*3600000) and f!= 0)";
            } else {
                str = "d<=" + (jCurrentTimeMillis - 259200000);
            }
            String str2 = str;
            try {
                try {
                    if (i4 == 2) {
                        cursorQuery = this.f8300c.query("r", null, str2, null, null, null, "d desc", "100");
                    } else {
                        int iH = com.baidu.mshield.sharedpreferences.a.a(this.f8301d).h();
                        com.baidu.mshield.b.c.a.b("sj-trigger report 3g limit" + Integer.toString(iH));
                        cursorQuery = this.f8300c.query("r", null, str2, null, null, null, "d desc", Integer.toString(iH));
                    }
                    cursor = cursorQuery;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
                                aVar.f8302a = cursor.getInt(cursor.getColumnIndex("a"));
                                aVar.f8303b = cursor.getString(cursor.getColumnIndex("b"));
                                aVar.f8304c = cursor.getInt(cursor.getColumnIndex("c"));
                                aVar.f8306e = cursor.getLong(cursor.getColumnIndex(DateTokenConverter.CONVERTER_KEY));
                                aVar.f8307f = cursor.getInt(cursor.getColumnIndex("g"));
                                aVar.f8308g = cursor.getInt(cursor.getColumnIndex("e"));
                                aVar.f8309h = cursor.getInt(cursor.getColumnIndex("f"));
                                aVar.f8310i = cursor.getInt(cursor.getColumnIndex(IntegerTokenConverter.CONVERTER_KEY));
                                aVar.f8311j = cursor.getString(cursor.getColumnIndex("j"));
                                String string = cursor.getString(cursor.getColumnIndex("h"));
                                try {
                                    string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                                } catch (Exception e4) {
                                    com.baidu.mshield.utility.a.a(e4);
                                }
                                aVar.f8305d = string;
                                arrayList.add(aVar);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.baidu.mshield.utility.a.a(th);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                com.baidu.mshield.utility.a.a(th3);
            }
        } catch (Throwable th4) {
            com.baidu.mshield.utility.a.a(th4);
        }
        return arrayList;
    }

    public int b() {
        Cursor cursorQuery = null;
        int count = 0;
        try {
            try {
                cursorQuery = this.f8300c.query("r", null, null, null, null, null, null, null);
                if (cursorQuery != null) {
                    count = cursorQuery.getCount();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        } catch (Throwable th2) {
            try {
                com.baidu.mshield.utility.a.a(th2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th4) {
                        com.baidu.mshield.utility.a.a(th4);
                    }
                }
                throw th3;
            }
        }
        return count;
    }

    public int a() {
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(this.f8301d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            return this.f8300c.delete("r", "(d <= ? or (d < (" + jCurrentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(jCurrentTimeMillis - (aVarA.I() * 86400000))});
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return -1;
        }
    }
}
