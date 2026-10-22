package com.stepos.deepbinder.core.tools;

import D6.b;
import android.view.Lifecycle;
import android.view.LifecycleEventObserver;
import android.view.LifecycleOwner;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.handler.BaseInvocationHandler;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.utils.TypeUtils;
import java.lang.ref.Cleaner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/deepbinder/core/tools/IPCRecycle;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", IPCRecycle.TIME_STAMP_KEY, "LC7/r;", "observeLifecycle", "(Landroidx/lifecycle/LifecycleOwner;J)V", "obj", "register", "(Ljava/lang/Object;)V", "registerLifeCycle", "(Ljava/lang/Object;J)V", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IPCRecycle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "IPCRecycle";
    private static final String TIME_STAMP_KEY = "timeStamp";
    private static final Cleaner cleaner;
    private static volatile IPCRecycle instance;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/deepbinder/core/tools/IPCRecycle$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "TIME_STAMP_KEY", "cleaner", "Ljava/lang/ref/Cleaner;", "instance", "Lcom/stepos/deepbinder/core/tools/IPCRecycle;", "getInstance", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final IPCRecycle getInstance() {
            IPCRecycle iPCRecycle;
            IPCRecycle iPCRecycle2 = IPCRecycle.instance;
            if (iPCRecycle2 != null) {
                return iPCRecycle2;
            }
            synchronized (this) {
                iPCRecycle = IPCRecycle.instance;
                if (iPCRecycle == null) {
                    iPCRecycle = new IPCRecycle(null);
                    IPCRecycle.instance = iPCRecycle;
                }
            }
            return iPCRecycle;
        }

        private Companion() {
        }
    }

    static {
        Cleaner cleanerCreate = Cleaner.create();
        k.e(cleanerCreate, "create(...)");
        cleaner = cleanerCreate;
    }

    public /* synthetic */ IPCRecycle(e eVar) {
        this();
    }

    public static final IPCRecycle getInstance() {
        return INSTANCE.getInstance();
    }

    private final void observeLifecycle(LifecycleOwner lifecycleOwner, final long timeStamp) {
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.stepos.deepbinder.core.tools.IPCRecycle.observeLifecycle.1
            @Override // android.view.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                k.f(source, "source");
                k.f(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    IPCLog.INSTANCE.d(IPCRecycle.TAG, "[onStateChanged][onDestroy]", IPCRecycle.TIME_STAMP_KEY, Long.valueOf(timeStamp));
                    CallbackCache.INSTANCE.removeCallback(timeStamp);
                    source.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLifeCycle$lambda$1(IPCRecycle iPCRecycle, Object obj, long j5) {
        iPCRecycle.observeLifecycle((LifecycleOwner) obj, j5);
    }

    public final void register(Object obj) throws IllegalArgumentException {
        k.f(obj, "obj");
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        BaseInvocationHandler baseInvocationHandler = invocationHandler instanceof BaseInvocationHandler ? (BaseInvocationHandler) invocationHandler : null;
        if (baseInvocationHandler == null) {
            return;
        }
        baseInvocationHandler.updateCleanable(cleaner.register(obj, new b(baseInvocationHandler, 24)));
    }

    public final void registerLifeCycle(Object obj, final long timeStamp) {
        k.f(obj, "obj");
        Object externalClass = TypeUtils.INSTANCE.getExternalClass(obj);
        if (externalClass instanceof LifecycleOwner) {
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) externalClass;
            IPCThreadCaller.INSTANCE.post(true, false, new Runnable() { // from class: com.stepos.deepbinder.core.tools.a
                @Override // java.lang.Runnable
                public final void run() {
                    IPCRecycle.registerLifeCycle$lambda$1(this.f3830a, lifecycleOwner, timeStamp);
                }
            });
        }
    }

    private IPCRecycle() {
    }
}
