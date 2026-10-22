package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import f2.C0699d;
import f2.C0702g;
import f2.C0711p;

/* loaded from: classes.dex */
public class h {
    public Cursor[] a(Context context) {
        if (context == null) {
            Log.d("DaysDetailDataSource", "fetchData context = null return null");
            return null;
        }
        Cursor[] cursorArr = new Cursor[2];
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            bundle.putLong("requestTime", jCurrentTimeMillis);
            long jMax = Math.max(C0711p.g(System.currentTimeMillis()) - 604800000, c.k());
            C0702g.b("DaysDetailDataSource", "startTime = " + C0711p.j(jMax));
            cursorArr[0] = context.getContentResolver().query(g.f14671e, null, "date>=? ", new String[]{String.valueOf(jMax)}, "date ASC, total_used_time DESC");
            Log.d("DaysDetailDataSource", "fetchData cursor[0] = " + cursorArr[0]);
            if (cursorArr[0] == null) {
                Log.e("DaysDetailDataSource", "fetchData cursor[0] = null return null");
            }
            Cursor cursorA = new p().a(context);
            cursorArr[1] = cursorA;
            if (cursorA != null) {
                C0699d c0699d = new C0699d(cursorArr[1]);
                c0699d.setExtras(bundle);
                cursorArr[1] = c0699d;
            }
            Log.d("DaysDetailDataSource", "fetchData cursor[1] = " + cursorArr[1]);
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
