package com.bytedance.dr.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.w5;
import com.bytedance.dr.OaidApi;

/* loaded from: classes.dex */
public final class k implements OaidApi {
    public static final w5<Boolean> a = new a();

    public static class a extends w5<Boolean> {
        @Override // com.bytedance.bdtracker.w5
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf("1".equals(k.a("persist.sys.identifierid.supported", "0")));
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Vivo";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        OaidApi.a aVar = new OaidApi.a();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        string = null;
        string = null;
        string = null;
        Cursor cursor = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToNext()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                            }
                        } catch (Exception e) {
                            e = e;
                            LoggerImpl.global().error(1, "Query oaid failed", e, new Object[0]);
                            r.a(cursorQuery);
                            aVar.a = string;
                            return aVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        r.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                r.a(cursor);
                throw th;
            }
            r.a(cursorQuery);
        }
        aVar.a = string;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return a.b(new Object[0]).booleanValue();
    }
}
