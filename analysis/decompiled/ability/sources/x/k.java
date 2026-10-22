package x;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;

/* loaded from: classes2.dex */
public final class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6865a = new d(4);

    public static /* synthetic */ String a() {
        try {
            return SystemProperties.get("persist.sys.identifierid.supported", "0");
        } catch (Throwable unused) {
            return "0";
        }
    }

    @Override // x.j
    public final D9.n c(Context context) {
        Cursor cursorQuery;
        D9.n nVar = new D9.n();
        Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String string = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            w.h.a("", th);
                            U7.a.h(cursorQuery);
                            nVar.f443a = string;
                            return nVar;
                        } finally {
                            U7.a.h(cursorQuery);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
        nVar.f443a = string;
        return nVar;
    }

    @Override // x.j
    public final boolean g(Context context) {
        return ((Boolean) f6865a.b(new Object[0])).booleanValue();
    }
}
