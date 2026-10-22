package y1;

import H.h;
import android.content.ContentValues;
import android.database.Cursor;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import m0.C1668b;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2127a extends w1.b implements w1.a {
    public static volatile C2127a f;
    public static final String[] g = {"_id", "front", "type", "timestamp", "accumulation", "version_id", AgentBusWakeContract.EXTRA_SOURCE, "status", "scene", "process", "main_process", "sid"};

    @Override // w1.a
    public final Object a(O2.a aVar) {
        int i;
        long j5 = aVar.j("_id");
        long j6 = aVar.j("front");
        String strK = aVar.k("type");
        long j10 = aVar.j("timestamp");
        long j11 = aVar.j("accumulation");
        long j12 = aVar.j("version_id");
        String strK2 = aVar.k(AgentBusWakeContract.EXTRA_SOURCE);
        long j13 = aVar.j("status");
        String strK3 = aVar.k("scene");
        try {
            i = ((Cursor) aVar.b).getInt(aVar.i("main_process"));
        } catch (Throwable unused) {
            i = -1;
        }
        String strK4 = aVar.k("process");
        boolean z10 = j6 != 0;
        boolean z11 = j13 != 0;
        C1668b c1668b = new C1668b();
        c1668b.b = z10;
        c1668b.c = j10;
        c1668b.d = strK;
        c1668b.e = z11;
        c1668b.f = strK3;
        c1668b.g = j11;
        c1668b.h = strK2;
        c1668b.f5293j = strK4;
        c1668b.f5292a = j5;
        c1668b.i = j12;
        c1668b.k = i == 1;
        c1668b.l = aVar.k("sid");
        return c1668b;
    }

    @Override // w1.b
    public final String[] h() {
        return g;
    }

    @Override // w1.b
    public final String i() {
        return "t_battery";
    }

    public final synchronized void k(C1668b c1668b) {
        if (c1668b == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("front", Integer.valueOf(c1668b.b ? 1 : 0));
            contentValues.put(AgentBusWakeContract.EXTRA_SOURCE, c1668b.h);
            contentValues.put("type", c1668b.d);
            contentValues.put("timestamp", Long.valueOf(c1668b.c));
            contentValues.put("accumulation", Long.valueOf(c1668b.g));
            contentValues.put("version_id", Long.valueOf(c1668b.i));
            contentValues.put("status", Integer.valueOf(c1668b.e ? 1 : 0));
            contentValues.put("scene", c1668b.f);
            contentValues.put("main_process", Integer.valueOf(c1668b.k ? 1 : 0));
            contentValues.put("process", c1668b.f5293j);
            contentValues.put("sid", c1668b.l);
            b(contentValues);
        } catch (Exception unused) {
        }
    }

    public final synchronized void l(long j5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("delete_flag", (Integer) 1);
        try {
            h.f711a.getContentResolver().update(j(), contentValues, "_id <= ? ", new String[]{String.valueOf(j5)});
        } catch (Exception unused) {
        }
    }
}
