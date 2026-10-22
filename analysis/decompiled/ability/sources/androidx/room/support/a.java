package androidx.room.support;

import android.os.SystemClock;
import androidx.room.support.AutoCloser;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements AutoCloser.Watch {
    @Override // androidx.room.support.AutoCloser.Watch
    public final long getMillis() {
        return SystemClock.uptimeMillis();
    }
}
