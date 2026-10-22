package P;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.x;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface n extends x {

    /* renamed from: d, reason: collision with root package name */
    public static final Config.a<Executor> f5355d = Config.a.a("camerax.core.thread.backgroundExecutor", Executor.class);

    default Executor d0(Executor executor) {
        return (Executor) g(f5355d, executor);
    }
}
