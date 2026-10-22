package z4;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import n3.r0;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements DatabaseErrorHandler {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ r0 f16386a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ stepos.support.v7.app.f f16387b;

    @Override // android.database.DatabaseErrorHandler
    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        r0 r0Var = this.f16386a;
        stepos.support.v7.app.f fVar = this.f16387b;
        int i = g.f16395l;
        sQLiteDatabase.getClass();
        c cVarH = i1.h(fVar, sQLiteDatabase);
        r0Var.getClass();
        Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + cVarH + ".path");
        SQLiteDatabase sQLiteDatabase2 = cVarH.f16385c;
        if (!sQLiteDatabase2.isOpen()) {
            String path = sQLiteDatabase2.getPath();
            if (path != null) {
                r0.a(path);
                return;
            }
            return;
        }
        List<Pair<String, String>> attachedDbs = null;
        try {
            try {
                attachedDbs = sQLiteDatabase2.getAttachedDbs();
            } finally {
                if (attachedDbs != null) {
                    Iterator<T> it = attachedDbs.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        obj.getClass();
                        r0.a((String) obj);
                    }
                } else {
                    String path2 = sQLiteDatabase2.getPath();
                    if (path2 != null) {
                        r0.a(path2);
                    }
                }
            }
        } catch (SQLiteException unused) {
        }
        try {
            cVarH.close();
        } catch (IOException unused2) {
        }
        if (attachedDbs != null) {
            return;
        }
    }
}
