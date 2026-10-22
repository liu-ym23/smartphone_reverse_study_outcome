package com.bytedance.android.livesdkapi.lifecycle;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveLifecycleForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addInterceptor(ILiveLifecycleForSaas r100, ILiveLifecycleInterceptor r101) {
        }

        public static void $default$removeInterceptor(ILiveLifecycleForSaas r100, ILiveLifecycleInterceptor r101) {
        }
    }

    void addInterceptor(ILiveLifecycleInterceptor r100);

    void removeInterceptor(ILiveLifecycleInterceptor r100);
}
