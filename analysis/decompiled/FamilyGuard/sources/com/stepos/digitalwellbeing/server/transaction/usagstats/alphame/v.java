package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import e2.C0684b;
import f2.C0699d;

/* loaded from: classes.dex */
public class v {
    public Cursor[] a(Context context) {
        String str;
        String[] strArr;
        if (context == null) {
            Log.d("WeekDetailDataSource", "fetchData context = null return null");
            return null;
        }
        Cursor[] cursorArr = new Cursor[2];
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            bundle.putLong("requestTime", jCurrentTimeMillis);
            if (C0684b.A()) {
                strArr = new String[]{String.valueOf(Math.max(System.currentTimeMillis() - 604800000, c.k()))};
                str = "date>? ";
            } else {
                str = null;
                strArr = null;
            }
            cursorArr[0] = context.getContentResolver().query(g.f14671e, null, str, strArr, "date DESC, total_used_time DESC");
            Log.d("WeekDetailDataSource", "fetchData cursor[0] = " + cursorArr[0]);
            if (cursorArr[0] == null) {
                Log.e("WeekDetailDataSource", "fetchData cursor[0] = null return null");
            }
            Cursor cursorA = new r().a(context);
            cursorArr[1] = cursorA;
            if (cursorA != null) {
                C0699d c0699d = new C0699d(cursorArr[1]);
                c0699d.setExtras(bundle);
                cursorArr[1] = c0699d;
            }
            Log.d("WeekDetailDataSource", "fetchData cursor[1] = " + cursorArr[1]);
            return cursorArr;
        } catch (Exception unused) {
            Cursor cursor = cursorArr[0];
            if (cursor != null) {
                cursor.close();
            }
            Cursor cursor2 = cursorArr[1];
            if (cursor2 != null) {
                cursor2.close();
            }
            return null;
        }
    }
}
