package net.sqlcipher;

import android.database.CrossProcessCursor;

/* loaded from: classes5.dex */
public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i10, android.database.CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i10, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public android.database.CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i10, int i11) {
        return true;
    }
}
