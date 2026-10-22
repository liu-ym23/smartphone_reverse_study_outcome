package ta;

import com.bytedanceos.common.eventbus.IgnoreAppEvent;
import kotlin.jvm.internal.q;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24766a = null;

    static {
        f24766a = new a();
    }

    public a() {
    }

    public final void a() {
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull IgnoreAppEvent r10) {
        q.g(r10, "event");
        com.bytedanceos.appstore.utils.a.B();
    }
}
