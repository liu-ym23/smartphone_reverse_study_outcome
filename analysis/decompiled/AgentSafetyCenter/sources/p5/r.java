package p5;

import android.database.Cursor;
import androidx.room.x;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ x f9789c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ s f9790f;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Boolean boolValueOf;
        Cursor cursorD = td.h.D(this.f9790f.f9791a, this.f9789c, false);
        try {
            if (cursorD.moveToFirst()) {
                boolValueOf = Boolean.valueOf(cursorD.getInt(0) != 0);
            } else {
                boolValueOf = Boolean.FALSE;
            }
            cursorD.close();
            return boolValueOf;
        } catch (Throwable th) {
            cursorD.close();
            throw th;
        }
    }

    public final void finalize() {
        this.f9789c.e();
    }
}
