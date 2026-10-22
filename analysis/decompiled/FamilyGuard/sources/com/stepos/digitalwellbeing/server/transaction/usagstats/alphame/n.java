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
public class n {

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
        C0702g.b("TodayAlphaMeSource", "fetchData START");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long jY = C0711p.y();
        long jK = c.k();
        long jMax = Math.max(jY, jK);
        C0702g.b("TodayAlphaMeSource", "fetchData todayStart=" + C0711p.j(jY) + " lastCloseTime=" + C0711p.j(jK) + " startTime=" + C0711p.j(jMax));
        ContentResolver contentResolver = context.getContentResolver();
        int length = 0;
        int i5 = Settings.Secure.getInt(contentResolver, "minors_mode_enabled", 0);
        long j5 = Settings.Secure.getLong(contentResolver, "active_minor_id", -1L);
        String[] strArr = {String.valueOf(i5), String.valueOf(j5), String.valueOf(jMax), String.valueOf(jCurrentTimeMillis2), String.valueOf(jCurrentTimeMillis2)};
        try {
            C0702g.b("TodayAlphaMeSource", "fetchData from provider db");
            result = null;
            cursorQuery = contentResolver.query(g.f14672f, null, null, strArr, null);
            try {
                try {
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    C0702g.b("TodayAlphaMeSource", "fetchData query time = " + C0711p.t(jCurrentTimeMillis3 - jCurrentTimeMillis));
                    try {
                        if (cursorQuery == null) {
                            C0702g.p("TodayAlphaMeSource", "db cursor == null load file path");
                            cursorQuery = contentResolver.query(g.f14673g, null, null, strArr, null);
                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                            StringBuilder sb = new StringBuilder();
                            result2 = null;
                            sb.append("fetchData query file time = ");
                            sb.append(C0711p.t(jCurrentTimeMillis4 - jCurrentTimeMillis3));
                            C0702g.b("TodayAlphaMeSource", sb.toString());
                            if (cursorQuery == null) {
                                C0702g.p("TodayAlphaMeSource", "file path cursor == null");
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return null;
                            }
                            cursorQuery.moveToFirst();
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("result_json"));
                            C0702g.p("TodayAlphaMeSource", "cursor before query return path = " + string2);
                            string = c.l(context, string2);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("resultString length = ");
                            if (string != null) {
                                length = string.length();
                            }
                            sb2.append(length);
                            C0702g.b("TodayAlphaMeSource", sb2.toString());
                            long jCurrentTimeMillis5 = System.currentTimeMillis();
                            C0702g.b("TodayAlphaMeSource", "fetchData query file content time = " + C0711p.t(jCurrentTimeMillis5 - jCurrentTimeMillis4));
                            C0702g.b("TodayAlphaMeSource", "fetchData total time = " + C0711p.t(jCurrentTimeMillis5 - jCurrentTimeMillis));
                        } else {
                            result2 = null;
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("result_json"));
                        }
                        if (TextUtils.isEmpty(string)) {
                            C0702g.O("TodayAlphaMeSource", "result error");
                            C0702g.b("TodayAlphaMeSource", "fetchData END");
                            cursorQuery.close();
                            return result2;
                        }
                        AlphaMeEntities.Response response = (AlphaMeEntities.Response) new A1.e().j(string, new a().getType());
                        AlphaMeEntities.TimeEventData timeEventDataM = c.m(i5, j5);
                        AlphaMeEntities.Result result3 = (AlphaMeEntities.Result) response.getResult();
                        if (timeEventDataM != null) {
                            result3.setTimeEvents(timeEventDataM.getResult());
                        } else {
                            C0702g.p("TodayAlphaMeSource", "timeEventData == null");
                        }
                        C0702g.b("TodayAlphaMeSource", "fetchData END");
                        cursorQuery.close();
                        return result3;
                    } catch (Exception e6) {
                        e = e6;
                        C0702g.b("TodayAlphaMeSource", C0702g.o(e));
                        C0702g.b("TodayAlphaMeSource", "fetchData END");
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return result;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                result = null;
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
