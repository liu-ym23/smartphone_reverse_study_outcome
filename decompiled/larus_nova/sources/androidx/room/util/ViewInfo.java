package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes17.dex */
public final class ViewInfo {
    public final String name;
    public final String sql;

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.sql;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ViewInfo) == true) goto L8;
        return false;
    L8:
        ViewInfo r101 = (ViewInfo) r100;
        String r102 = this.name;
        if (r102 == null) goto L14;
        if (r102.equals(r101.name) == true) goto L15;
    L23:
        return false;
    L15:
        String r103 = this.sql;
        if (r103 == null) goto L21;
        if (r103.equals(r101.sql) == false) goto L23;
        return true;
    L21:
        if (r101.sql != null) goto L23;
        return true;
    L14:
        if (r101.name != null) goto L23;
        goto L15
    }

    public ViewInfo(String r100, String r101) {
        this.name = r100;
        this.sql = r101;
    }

    public static ViewInfo read(SupportSQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r101 + "'");
    L11:
        th = move-exception;
        r102.close();
        throw th;
    L4:
        if (r102.moveToFirst() == false) goto L8;
        ViewInfo r103 = new ViewInfo(r102.getString(0), r102.getString(1));     // Catch: Throwable -> L11
        r102.close();
        return r103;
    L8:
        ViewInfo r104 = new ViewInfo(r101, null);     // Catch: Throwable -> L11
        r102.close();
        return r104;
    }
}
