package r2;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* renamed from: r2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5198a extends CursorWrapper implements CrossProcessCursor {

    /* renamed from: a, reason: collision with root package name */
    public AbstractWindowedCursor f38751a;

    public C5198a(Cursor cursor) {
        super(cursor);
        for (int i10 = 0; i10 < 10 && (cursor instanceof CursorWrapper); i10++) {
            cursor = ((CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
        }
        this.f38751a = (AbstractWindowedCursor) cursor;
    }

    public void b(CursorWindow cursorWindow) {
        this.f38751a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i10, CursorWindow cursorWindow) {
        this.f38751a.fillWindow(i10, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @ResultIgnorabilityUnspecified
    public CursorWindow getWindow() {
        return this.f38751a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f38751a;
    }

    @Override // android.database.CrossProcessCursor
    @ResultIgnorabilityUnspecified
    public final boolean onMove(int i10, int i11) {
        return this.f38751a.onMove(i10, i11);
    }
}
