package w1;

import H.h;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.frameworks.core.apm.contentprovider.MonitorContentProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import m0.C1669c;
import v1.d;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6829a;
    public final String b;
    public Uri c;
    public String d;
    public final HashMap e = new HashMap();

    public b() {
        Application application = h.f711a;
        this.f6829a = application;
        this.b = application.getPackageName() + ".apm";
        if (this instanceof y1.b) {
            return;
        }
        Application application2 = h.f711a;
        int i = Y5.b.c;
        String absolutePath = application2.getDatabasePath("apm_monitor_t1.db").getAbsolutePath();
        if (absolutePath == null) {
            HashMap map = d.f6766a;
            return;
        }
        HashMap map2 = d.f6766a;
        HashSet hashSet = (HashSet) map2.get(absolutePath);
        if (hashSet == null) {
            synchronized (map2) {
                try {
                    hashSet = (HashSet) map2.get(absolutePath);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map2.put(absolutePath, hashSet);
                    }
                } finally {
                }
            }
        }
        hashSet.add(this);
    }

    public static void g(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public final synchronized long b(ContentValues contentValues) {
        try {
            Uri uriInsert = h.f711a.getContentResolver().insert(j(), contentValues);
            if (uriInsert == null) {
                return -1L;
            }
            try {
                return Long.parseLong(uriInsert.getLastPathSegment());
            } catch (Exception unused) {
                return 1L;
            }
        } catch (Exception unused2) {
            return -1L;
        }
    }

    public final long c(String str) {
        String string;
        long j5 = -1;
        Cursor cursorQuery = null;
        try {
            try {
                Application application = h.f711a;
                Uri uriJ = j();
                if (str == null) {
                    if (this.d == null) {
                        this.d = "SELECT count(*) FROM ".concat(i());
                    }
                    string = this.d;
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (this.d == null) {
                        this.d = "SELECT count(*) FROM ".concat(i());
                    }
                    sb.append(this.d);
                    sb.append(" where ");
                    sb.append(str);
                    string = sb.toString();
                }
                String str2 = string;
                int i = MonitorContentProvider.b;
                try {
                    cursorQuery = application.getContentResolver().query(uriJ, null, str2, null, "rawQuery");
                } catch (Exception unused) {
                }
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    j5 = cursorQuery.getLong(0);
                }
                g(cursorQuery);
                return j5;
            } catch (Exception unused2) {
                g(cursorQuery);
                return -1L;
            }
        } catch (Throwable th) {
            g(cursorQuery);
            throw th;
        }
    }

    public abstract ContentValues d(C1669c c1669c);

    public final List e(String str, String[] strArr, String str2, a aVar) {
        Cursor cursorQuery;
        int iIntValue;
        int iIndexOf;
        try {
            cursorQuery = this.f6829a.getContentResolver().query(j(), h(), str, strArr, str2);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (TextUtils.isEmpty(str2) || (iIndexOf = str2.indexOf("LIMIT")) <= 0) {
                            iIntValue = Integer.MAX_VALUE;
                        } else {
                            int iIndexOf2 = str2.indexOf("OFF");
                            iIntValue = iIndexOf2 > 0 ? Integer.valueOf(str2.substring(iIndexOf + 5, iIndexOf2).trim()).intValue() : Integer.valueOf(str2.substring(iIndexOf + 5).trim()).intValue();
                        }
                        LinkedList linkedList = new LinkedList();
                        for (int i = 0; cursorQuery.moveToNext() && i < iIntValue; i++) {
                            linkedList.add(aVar.a(new O2.a(10, cursorQuery, this.e)));
                        }
                        g(cursorQuery);
                        return linkedList;
                    }
                } catch (Throwable unused) {
                    g(cursorQuery);
                    return Collections.EMPTY_LIST;
                }
            }
            List list = Collections.EMPTY_LIST;
            g(cursorQuery);
            return list;
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
    }

    public final void f(long j5) {
        try {
            this.f6829a.getContentResolver().delete(j(), "timestamp <=?", new String[]{String.valueOf(j5)});
        } catch (Exception unused) {
        }
    }

    public abstract String[] h();

    public abstract String i();

    public final Uri j() {
        if (this.c == null) {
            StringBuilder sb = new StringBuilder("content://");
            sb.append(this.b);
            sb.append("/apm_monitor_t1.db/");
            int i = Y5.b.c;
            sb.append(i());
            this.c = Uri.parse(sb.toString());
        }
        return this.c;
    }
}
