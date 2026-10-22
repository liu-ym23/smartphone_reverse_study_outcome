package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String name, String sql) {
        this.name = name;
        this.sql = sql;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof ViewInfo) == true) goto L8;
        return false;
    L8:
        ViewInfo r5 = (ViewInfo) o;
        String r1 = this.name;
        if (r1 == null) goto L14;
        if (r1.equals(r5.name) == false) goto L24;
    L15:
        String r4 = this.sql;
        if (r4 == null) goto L21;
        if (r4.equals(r5.sql) == false) goto L24;
        return true;
    L21:
        if (r5.sql != null) goto L24;
        return true;
    L24:
        return false;
    L14:
        if (r5.name != null) goto L24;
        goto L15
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.sql;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }

    public static ViewInfo read(SupportSQLiteDatabase database, String viewName) {
        Cursor r2 = database.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + "'");
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L8;
        ViewInfo r3 = new ViewInfo(r2.getString(0), r2.getString(1));     // Catch: Throwable -> L11
        r2.close();
        return r3;
    L8:
        ViewInfo r0 = new ViewInfo(viewName, null);     // Catch: Throwable -> L11
        r2.close();
        return r0;
    }
}
