package f2;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;

/* renamed from: f2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0699d extends CursorWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f16789a;

    public C0699d(Cursor cursor) {
        super(cursor);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public Bundle getExtras() {
        return this.f16789a;
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return super.getWrappedCursor();
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public void setExtras(Bundle bundle) {
        this.f16789a = bundle;
    }
}
