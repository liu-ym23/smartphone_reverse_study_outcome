package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements MainDispatcherFactory {
    public a() {
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public o1 createDispatcher(List r10) {
        Looper r11 = Looper.getMainLooper();
        if (r11 == null) goto L7;
        return new HandlerContext(e.a(r11, true), null, 2, null);
    L7:
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
