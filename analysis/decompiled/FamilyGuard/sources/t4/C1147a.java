package t4;

import android.os.Looper;
import java.util.List;
import s4.x0;
import x4.t;

/* renamed from: t4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1147a implements t {
    @Override // x4.t
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // x4.t
    public x0 b(List<? extends t> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C1149c(e.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // x4.t
    public int c() {
        return 1073741823;
    }
}
