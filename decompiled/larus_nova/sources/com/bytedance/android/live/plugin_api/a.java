package com.bytedance.android.live.plugin_api;

/* JADX INFO: loaded from: classes46.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1324a f85857a = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.plugin_api.a$a, reason: collision with other inner class name */
    public static final class C1324a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final com.bytedance.android.live.plugin_impl.service.a f85858a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C1324a f85859b = null;

        public C1324a() {
        }

        static {
            f85859b = new C1324a();
            f85858a = new com.bytedance.android.live.plugin_impl.service.a();
        }
    }

    static {
        f85857a = C1324a.f85859b;
    }

    a addOnFail(js0.a r100);

    a addOnSuccess(js0.b r100);

    a callbackOnMainThread();

    void justPrepare();

    void justPrepare(String r100);

    void requireByUser(String r100);

    a syncCallbackIfReady(boolean r100);

    a update(int r100);
}
