package Z7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public static V f7384a = null;

    /* renamed from: b, reason: collision with root package name */
    public static W f7385b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7386c = false;

    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public int f7387a = 4;

        /* renamed from: b, reason: collision with root package name */
        public String f7388b;

        /* renamed from: c, reason: collision with root package name */
        public ContentValues f7389c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7390d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f7391e;

        /* renamed from: f, reason: collision with root package name */
        public String f7392f;

        /* renamed from: g, reason: collision with root package name */
        public String[] f7393g;

        /* renamed from: h, reason: collision with root package name */
        public String f7394h;

        /* renamed from: i, reason: collision with root package name */
        public String f7395i;

        /* renamed from: j, reason: collision with root package name */
        public String f7396j;

        /* renamed from: k, reason: collision with root package name */
        public String f7397k;

        /* renamed from: l, reason: collision with root package name */
        public String f7398l;

        /* renamed from: m, reason: collision with root package name */
        public String[] f7399m;

        /* renamed from: n, reason: collision with root package name */
        public int f7400n;

        /* renamed from: o, reason: collision with root package name */
        public String f7401o;

        /* renamed from: p, reason: collision with root package name */
        public byte[] f7402p;

        public a() {
        }

        public final void a(int i10, String str, byte[] bArr) {
            this.f7400n = i10;
            this.f7401o = str;
            this.f7402p = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f7387a) {
                case 1:
                    V.this.e(this.f7388b, this.f7389c, null);
                    break;
                case 2:
                    V.this.c(this.f7388b, this.f7398l, this.f7399m, null);
                    break;
                case 3:
                    Cursor cursorL = V.this.l(this.f7390d, this.f7388b, this.f7391e, this.f7392f, this.f7393g, this.f7394h, this.f7395i, this.f7396j, this.f7397k, null);
                    if (cursorL != null) {
                        cursorL.close();
                        break;
                    }
                    break;
                case 4:
                    V.this.r(this.f7400n, this.f7401o, this.f7402p, null);
                    break;
                case 5:
                    V.this.n(this.f7400n, null);
                    break;
                case 6:
                    V.this.q(this.f7400n, this.f7401o, null);
                    break;
            }
        }
    }

    public V(Context context, List<N> list) {
        f7385b = new W(context, list);
    }

    public static ContentValues B(X x10) {
        if (x10 != null && !C1143o.G(x10.f7413f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j10 = x10.f7408a;
                if (j10 > 0) {
                    contentValues.put(StepOSRecipientEmailHistory._ID, Long.valueOf(j10));
                }
                contentValues.put("_tp", x10.f7413f);
                contentValues.put("_tm", Long.valueOf(x10.f7412e));
                byte[] bArr = x10.f7414g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized V f() {
        return f7384a;
    }

    public static synchronized V g(Context context, List<N> list) {
        try {
            if (f7384a == null) {
                f7384a = new V(context, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7384a;
    }

    public static X h(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            X x10 = new X();
            x10.f7408a = cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            x10.f7409b = cursor.getInt(cursor.getColumnIndex("_tp"));
            x10.f7410c = cursor.getString(cursor.getColumnIndex("_pc"));
            x10.f7411d = cursor.getString(cursor.getColumnIndex("_th"));
            x10.f7412e = cursor.getLong(cursor.getColumnIndex("_tm"));
            x10.f7414g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return x10;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static X w(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            X x10 = new X();
            x10.f7408a = cursor.getLong(cursor.getColumnIndex(StepOSRecipientEmailHistory._ID));
            x10.f7412e = cursor.getLong(cursor.getColumnIndex("_tm"));
            x10.f7413f = cursor.getString(cursor.getColumnIndex("_tp"));
            x10.f7414g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return x10;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static ContentValues z(X x10) {
        if (x10 == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = x10.f7408a;
            if (j10 > 0) {
                contentValues.put(StepOSRecipientEmailHistory._ID, Long.valueOf(j10));
            }
            contentValues.put("_tp", Integer.valueOf(x10.f7409b));
            contentValues.put("_pc", x10.f7410c);
            contentValues.put("_th", x10.f7411d);
            contentValues.put("_tm", Long.valueOf(x10.f7412e));
            byte[] bArr = x10.f7414g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab A[Catch: all -> 0x0027, PHI: r2
      0x00ab: PHI (r2v2 android.database.sqlite.SQLiteDatabase) = (r2v1 android.database.sqlite.SQLiteDatabase), (r2v3 android.database.sqlite.SQLiteDatabase) binds: [B:56:0x00c9, B:41:0x00a9] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0027, blocks: (B:9:0x0023, B:12:0x002b, B:14:0x002f, B:32:0x0095, B:34:0x009c, B:53:0x00c2, B:54:0x00c5, B:42:0x00ab, B:61:0x00d0, B:62:0x00d3, B:65:0x00d9, B:66:0x00dc, B:39:0x00a5, B:46:0x00b3, B:48:0x00b9), top: B:73:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<Z7.X> A(int r11) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.V.A(int):java.util.List");
    }

    public final int b(String str, String str2) {
        return c(str, str2, null, null);
    }

    public final synchronized int c(String str, String str2, String[] strArr, U u10) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7385b.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th) {
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                if (f7386c && writableDatabase != null) {
                }
            } finally {
                if (f7386c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    public final synchronized long e(String str, ContentValues contentValues, U u10) {
        long j10;
        j10 = -1;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7385b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, StepOSRecipientEmailHistory._ID, contentValues);
                if (jReplace >= 0) {
                    C1139k.h("[Database] insert %s success.", str);
                } else {
                    C1139k.i("[Database] replace %s error.", str);
                }
                j10 = jReplace;
            }
        } catch (Throwable th) {
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                if (f7386c && 0 != 0) {
                }
            } finally {
                if (f7386c && 0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        return j10;
    }

    public final Cursor j(String str, String[] strArr, String str2) {
        return k(str, strArr, str2, null, null);
    }

    public final Cursor k(String str, String[] strArr, String str2, String str3, String str4) {
        return l(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final synchronized Cursor l(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, U u10) {
        Cursor cursorQuery;
        cursorQuery = null;
        try {
            SQLiteDatabase writableDatabase = f7385b.getWritableDatabase();
            if (writableDatabase != null) {
                cursorQuery = writableDatabase.query(z10, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursorQuery;
            } finally {
            }
        }
        return cursorQuery;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #1 {all -> 0x00b2, blocks: (B:42:0x00a8, B:44:0x00ae), top: B:64:0x00a8, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:3:0x0001, B:14:0x002d, B:17:0x0035, B:19:0x0039, B:37:0x009c, B:39:0x00a3, B:49:0x00b7, B:50:0x00ba, B:52:0x00be, B:54:0x00c4, B:55:0x00c7, B:57:0x00cb, B:58:0x00ce, B:42:0x00a8, B:44:0x00ae), top: B:63:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00be A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:3:0x0001, B:14:0x002d, B:17:0x0035, B:19:0x0039, B:37:0x009c, B:39:0x00a3, B:49:0x00b7, B:50:0x00ba, B:52:0x00be, B:54:0x00c4, B:55:0x00c7, B:57:0x00cb, B:58:0x00ce, B:42:0x00a8, B:44:0x00ae), top: B:63:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.List<Z7.X> m(int r11) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.V.m(int):java.util.List");
    }

    public final Map<String, byte[]> n(int i10, U u10) {
        HashMap map = null;
        try {
            List<X> listA = A(i10);
            if (listA == null) {
                return null;
            }
            HashMap map2 = new HashMap();
            try {
                for (X x10 : listA) {
                    byte[] bArr = x10.f7414g;
                    if (bArr != null) {
                        map2.put(x10.f7413f, bArr);
                    }
                }
                return map2;
            } catch (Throwable th) {
                th = th;
                map = map2;
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                return map;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized void p(List<X> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    SQLiteDatabase writableDatabase = f7385b.getWritableDatabase();
                    if (writableDatabase != null) {
                        StringBuilder sb2 = new StringBuilder();
                        for (X x10 : list) {
                            sb2.append(" or _id = ");
                            sb2.append(x10.f7408a);
                        }
                        String string = sb2.toString();
                        if (string.length() > 0) {
                            string = string.substring(4);
                        }
                        sb2.setLength(0);
                        try {
                            C1139k.h("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                        } catch (Throwable th) {
                            try {
                                if (!C1139k.e(th)) {
                                    th.printStackTrace();
                                }
                                if (f7386c) {
                                    writableDatabase.close();
                                }
                            } finally {
                                if (f7386c) {
                                    writableDatabase.close();
                                }
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public final synchronized boolean q(int i10, String str, U u10) {
        boolean z10;
        String strConcat;
        z10 = false;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = f7385b.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (C1143o.G(str)) {
                        strConcat = "_id = ".concat(String.valueOf(i10));
                    } else {
                        strConcat = "_id = " + i10 + " and _tp = \"" + str + "\"";
                    }
                    int iDelete = writableDatabase.delete("t_pf", strConcat, null);
                    C1139k.h("[Database] deleted %s data %d", "t_pf", Integer.valueOf(iDelete));
                    if (iDelete > 0) {
                        z10 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    try {
                        if (!C1139k.e(th)) {
                            th.printStackTrace();
                        }
                        return z10;
                    } finally {
                        if (f7386c && sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                }
            }
            if (f7386c && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z10;
    }

    public final boolean r(int i10, String str, byte[] bArr, U u10) {
        try {
            X x10 = new X();
            x10.f7408a = i10;
            x10.f7413f = str;
            x10.f7412e = System.currentTimeMillis();
            x10.f7414g = bArr;
            return y(x10);
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final boolean s(int i10, String str, byte[] bArr, boolean z10) {
        if (z10) {
            return r(i10, str, bArr, null);
        }
        a aVar = new a();
        aVar.a(i10, str, bArr);
        C1138j.a().b(aVar);
        return true;
    }

    public final synchronized boolean v(X x10) {
        ContentValues contentValuesZ;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7385b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesZ = z(x10)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_lr", StepOSRecipientEmailHistory._ID, contentValuesZ);
            if (jReplace < 0) {
                if (f7386c) {
                    writableDatabase.close();
                }
                return false;
            }
            C1139k.h("[Database] insert %s success.", "t_lr");
            x10.f7408a = jReplace;
            if (f7386c) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                if (f7386c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f7386c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public final synchronized void x(int i10) {
        String strConcat;
        SQLiteDatabase writableDatabase = f7385b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i10 >= 0) {
                try {
                    strConcat = "_tp = ".concat(String.valueOf(i10));
                } catch (Throwable th) {
                    try {
                        if (!C1139k.e(th)) {
                            th.printStackTrace();
                        }
                        if (f7386c) {
                            writableDatabase.close();
                            return;
                        }
                    } finally {
                        if (f7386c) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                strConcat = null;
            }
            C1139k.h("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", strConcat, null)));
        }
    }

    public final synchronized boolean y(X x10) {
        ContentValues contentValuesB;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f7385b.getWritableDatabase();
            if (writableDatabase == null || (contentValuesB = B(x10)) == null) {
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", StepOSRecipientEmailHistory._ID, contentValuesB);
            if (jReplace < 0) {
                if (f7386c) {
                    writableDatabase.close();
                }
                return false;
            }
            C1139k.h("[Database] insert %s success.", "t_pf");
            x10.f7408a = jReplace;
            if (f7386c) {
                writableDatabase.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                if (f7386c && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f7386c && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }
}
