package com.stepos.core.device.awareness;

import android.content.Context;
import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.inference.data.BackendType;
import com.stepos.base.task.data.TaskPriority;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import q6.a;
import r6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SceneAwarenessManager {
    public static final Companion Companion = new Companion(null);
    private static volatile a globalProvider;
    private final Context context;
    private a provider;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void initializeGlobal$default(Companion companion, a aVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                aVar = null;
            }
            companion.initializeGlobal(aVar);
        }

        public final a getGlobalProvider() {
            a aVar;
            a aVar2 = SceneAwarenessManager.globalProvider;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (this) {
                aVar = SceneAwarenessManager.globalProvider;
                if (aVar == null) {
                    DefaultSceneAwareness defaultSceneAwareness = new DefaultSceneAwareness(null, null, null, 7, null);
                    SceneAwarenessManager.globalProvider = defaultSceneAwareness;
                    aVar = defaultSceneAwareness;
                }
            }
            return aVar;
        }

        public final void initializeGlobal(a aVar) {
            if (SceneAwarenessManager.globalProvider == null) {
                synchronized (this) {
                    try {
                        if (SceneAwarenessManager.globalProvider == null) {
                            if (aVar == null) {
                                aVar = new DefaultSceneAwareness(null, null, null, 7, null);
                            }
                            SceneAwarenessManager.globalProvider = aVar;
                        }
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskPriority.values().length];
            try {
                TaskPriority.a aVar = TaskPriority.f6396b;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                TaskPriority.a aVar2 = TaskPriority.f6396b;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                TaskPriority.a aVar3 = TaskPriority.f6396b;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                TaskPriority.a aVar4 = TaskPriority.f6396b;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SceneAwarenessManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void addSceneChangeListener(a.InterfaceC0129a listener) {
        g.f(listener, "listener");
        getProvider().addSceneChangeListener(listener);
    }

    public final SceneType getCurrentScene() {
        return getProvider().getCurrentScene();
    }

    public final a getProvider() {
        a aVar;
        a aVar2 = this.provider;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this) {
            aVar = this.provider;
            if (aVar == null) {
                DefaultSceneAwareness defaultSceneAwareness = new DefaultSceneAwareness(null, null, null, 7, null);
                this.provider = defaultSceneAwareness;
                aVar = defaultSceneAwareness;
            }
        }
        return aVar;
    }

    public final r6.a getScheduleDecision() {
        return getProvider().getScheduleDecision();
    }

    public final b getSystemLoad() {
        return getProvider().getSystemLoad();
    }

    public final void refreshScene() {
        getProvider().refreshScene();
    }

    public final void removeSceneChangeListener(a.InterfaceC0129a listener) {
        g.f(listener, "listener");
        getProvider().removeSceneChangeListener(listener);
    }

    public final void reset$performance_release() {
        this.provider = null;
    }

    public SceneAwarenessManager(Context context) {
        this.context = context;
    }

    public final r6.a getScheduleDecision(j7.b task) {
        g.f(task, "task");
        r6.a scheduleDecision = getProvider().getScheduleDecision();
        int iOrdinal = task.getPriority().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return r6.a.a(scheduleDecision, BackendType.f6254d, 6, 0L, 100, 3573);
        }
        if (iOrdinal == 2) {
            return scheduleDecision;
        }
        if (iOrdinal == 3) {
            return r6.a.a(scheduleDecision, BackendType.f6256j, 2, 0L, 30, 3573);
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ SceneAwarenessManager(Context context, int i10, e eVar) {
        this((i10 & 1) != 0 ? null : context);
    }
}
