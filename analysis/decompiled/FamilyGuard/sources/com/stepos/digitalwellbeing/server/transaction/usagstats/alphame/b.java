package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.AlphaMeEntities;
import f2.C0702g;
import f2.C0711p;

/* loaded from: classes.dex */
public class b {

    class a extends com.google.gson.reflect.a<AlphaMeEntities.Response<AlphaMeEntities.Result>> {
        a() {
        }
    }

    public AlphaMeEntities.Result a(Context context) throws Throwable {
        Cursor cursor;
        AlphaMeEntities.Result result;
        Cursor cursorQuery;
        AlphaMeEntities.Result result2;
        String string;
        C0702g.b("AlphaMeSource", "fetchData START");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jMax = Math.max(C0711p.g(jCurrentTimeMillis2) - 604800000, c.k());
        ContentResolver contentResolver = context.getContentResolver();
        int length = 0;
        int i5 = Settings.Secure.getInt(contentResolver, "minors_mode_enabled", 0);
        long j5 = Settings.Secure.getLong(contentResolver, "active_minor_id", -1L);
        String[] strArr = {String.valueOf(i5), String.valueOf(j5), String.valueOf(jMax), String.valueOf(jCurrentTimeMillis2), String.valueOf(jCurrentTimeMillis2)};
        try {
            C0702g.b("AlphaMeSource", "fetchData from provider db");
            cursorQuery = contentResolver.query(g.f14672f, null, null, strArr, null);
            try {
                try {
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    C0702g.b("AlphaMeSource", "fetchData query time = " + C0711p.t(jCurrentTimeMillis3 - jCurrentTimeMillis));
                    try {
                        if (cursorQuery == null) {
                            C0702g.p("AlphaMeSource", "db cursor == null load file path");
                            result2 = null;
                            cursorQuery = contentResolver.query(g.f14673g, null, null, strArr, null);
                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                            C0702g.b("AlphaMeSource", "fetchData query file time = " + C0711p.t(jCurrentTimeMillis4 - jCurrentTimeMillis3));
                            if (cursorQuery == null) {
                                C0702g.p("AlphaMeSource", "file path cursor == null");
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return null;
                            }
                            cursorQuery.moveToFirst();
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("result_json"));
                            C0702g.p("AlphaMeSource", "cursor before query return path = " + string2);
                            string = c.l(context, string2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("resultString length = ");
                            if (string != null) {
                                length = string.length();
                            }
                            sb.append(length);
                            C0702g.b("AlphaMeSource", sb.toString());
                            long jCurrentTimeMillis5 = System.currentTimeMillis();
                            C0702g.b("AlphaMeSource", "fetchData query file content time = " + C0711p.t(jCurrentTimeMillis5 - jCurrentTimeMillis4));
                            C0702g.b("AlphaMeSource", "fetchData total time = " + C0711p.t(jCurrentTimeMillis5 - jCurrentTimeMillis));
                        } else {
                            result2 = null;
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("result_json"));
                        }
                        if (TextUtils.isEmpty(string)) {
                            C0702g.O("AlphaMeSource", "result error");
                            C0702g.b("AlphaMeSource", "fetchData END");
                            cursorQuery.close();
                            return result2;
                        }
                        AlphaMeEntities.Response response = (AlphaMeEntities.Response) new A1.e().j(string, new a().getType());
                        AlphaMeEntities.TimeEventData timeEventDataM = c.m(i5, j5);
                        AlphaMeEntities.Result result3 = (AlphaMeEntities.Result) response.getResult();
                        if (timeEventDataM != null) {
                            result3.setTimeEvents(timeEventDataM.getResult());
                        } else {
                            C0702g.p("AlphaMeSource", "timeEventData == null");
                        }
                        C0702g.b("AlphaMeSource", "fetchData END");
                        cursorQuery.close();
                        return result3;
                    } catch (Exception e6) {
                        e = e6;
                        C0702g.b("AlphaMeSource", C0702g.o(e));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return result;
                    }
                } catch (Exception e7) {
                    e = e7;
                    result = null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            result = null;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
