package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
public interface OnMiniGameLifecycleChangeListener {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener$MiniGameLifecycle;", "", "OnCreate", "OnResume", "OnStop", "OnExit", "OnDestroy", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MiniGameLifecycle extends Enum<MiniGameLifecycle> {
        public static final MiniGameLifecycle OnCreate = null;
        public static final MiniGameLifecycle OnDestroy = null;
        public static final MiniGameLifecycle OnExit = null;
        public static final MiniGameLifecycle OnResume = null;
        public static final MiniGameLifecycle OnStop = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MiniGameLifecycle[] f85360a = null;

        static {
            MiniGameLifecycle r100 = new MiniGameLifecycle("OnCreate", 0);
            OnCreate = r100;
            MiniGameLifecycle r101 = new MiniGameLifecycle("OnResume", 1);
            OnResume = r101;
            MiniGameLifecycle r102 = new MiniGameLifecycle("OnStop", 2);
            OnStop = r102;
            MiniGameLifecycle r103 = new MiniGameLifecycle("OnExit", 3);
            OnExit = r103;
            MiniGameLifecycle r104 = new MiniGameLifecycle("OnDestroy", 4);
            OnDestroy = r104;
            f85360a = new MiniGameLifecycle[]{r100, r101, r102, r103, r104};
        }

        public static MiniGameLifecycle valueOf(String r100) {
            return (MiniGameLifecycle) r27.a.a(MiniGameLifecycle.class, r100);
        }

        public static MiniGameLifecycle[] values() {
            return (MiniGameLifecycle[]) f85360a.clone();
        }

        public MiniGameLifecycle(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    void b();

    void c();

    void d();

    void e();
}
