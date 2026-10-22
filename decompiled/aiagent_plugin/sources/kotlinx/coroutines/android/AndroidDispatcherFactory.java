package kotlinx.coroutines.android;

import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public AndroidDispatcherFactory() {
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public cm createDispatcher(List<? extends MainDispatcherFactory> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Looper r5 = Looper.getMainLooper();
        if (r5 == null) goto L7;
        return (cm) ZeusTransformUtils.preCheckCast(new a(c.a(r5, true), null, 2, null), cm.class, "com.obric.aiagent.plugin");
    L7:
        throw new IllegalStateException("The main looper is not available");
    }
}
