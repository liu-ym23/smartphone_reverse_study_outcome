package com.bytedance.android.live.openplatform.impl.miniappcommon.context;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
public interface OnMiniAppLifecycleChangeListener {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/OnMiniAppLifecycleChangeListener$MiniAppLifecycle;", "", "OnCreate", "OnResume", "OnStop", "OnDestroy", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MiniAppLifecycle extends Enum<MiniAppLifecycle> {
        public static final MiniAppLifecycle OnCreate = null;
        public static final MiniAppLifecycle OnDestroy = null;
        public static final MiniAppLifecycle OnResume = null;
        public static final MiniAppLifecycle OnStop = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MiniAppLifecycle[] f85011a = null;

        static {
            MiniAppLifecycle r100 = new MiniAppLifecycle("OnCreate", 0);
            OnCreate = r100;
            MiniAppLifecycle r101 = new MiniAppLifecycle("OnResume", 1);
            OnResume = r101;
            MiniAppLifecycle r102 = new MiniAppLifecycle("OnStop", 2);
            OnStop = r102;
            MiniAppLifecycle r103 = new MiniAppLifecycle("OnDestroy", 3);
            OnDestroy = r103;
            f85011a = new MiniAppLifecycle[]{r100, r101, r102, r103};
        }

        public static MiniAppLifecycle valueOf(String r100) {
            return (MiniAppLifecycle) r27.a.a(MiniAppLifecycle.class, r100);
        }

        public static MiniAppLifecycle[] values() {
            return (MiniAppLifecycle[]) f85011a.clone();
        }

        public MiniAppLifecycle(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    void b();

    void c();

    void d();
}
