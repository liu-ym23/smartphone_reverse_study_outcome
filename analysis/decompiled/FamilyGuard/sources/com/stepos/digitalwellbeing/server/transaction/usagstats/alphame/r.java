package com.stepos.digitalwellbeing.server.transaction.usagstats.alphame;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/* loaded from: classes.dex */
public class r extends l<Cursor> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Cursor b(Context context) {
        Exception exc;
        Cursor cursorQuery;
        Log.d("TodaySimpleDataSource", "fetchData");
        if (context == null) {
            Log.e("TodaySimpleDataSource", "fetchData context = null return null");
            return null;
        }
        try {
            cursorQuery = context.getContentResolver().query(g.f14669c, null, null, null, null);
            if (cursorQuery != null) {
                return cursorQuery;
            }
            try {
                return context.getContentResolver().query(g.f14667a, null, null, null, null);
            } catch (Exception e6) {
                exc = e6;
                Log.e("TodaySimpleDataSource", "exception = " + exc);
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
