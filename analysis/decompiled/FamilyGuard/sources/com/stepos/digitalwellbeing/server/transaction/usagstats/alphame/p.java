package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import e2.C0684b;
import f2.C0711p;

/* loaded from: classes.dex */
public class p extends l<Cursor> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Cursor b(Context context) {
        String str;
        String[] strArr;
        Exception exc;
        Cursor cursorQuery;
        Log.d("TodayDetailDataSource", "fetchData");
        if (context == null) {
            Log.e("TodayDetailDataSource", "fetchData context = null return null");
            return null;
        }
        if (C0684b.A()) {
            strArr = new String[]{String.valueOf(Math.max(C0711p.y(), c.k()))};
            str = "date>? ";
        } else {
            str = null;
            strArr = null;
        }
        try {
            cursorQuery = context.getContentResolver().query(g.f14670d, null, str, strArr, null);
            if (cursorQuery != null) {
                return cursorQuery;
            }
            try {
                return context.getContentResolver().query(g.f14668b, null, str, strArr, null);
            } catch (Exception e6) {
                exc = e6;
                Log.e("TodayDetailDataSource", "exception = " + exc);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Exception e7) {
            exc = e7;
            cursorQuery = null;
        }
    }
}
