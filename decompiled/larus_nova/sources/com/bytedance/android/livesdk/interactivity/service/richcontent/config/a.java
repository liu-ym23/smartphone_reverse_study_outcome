package com.bytedance.android.livesdk.interactivity.service.richcontent.config;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ck6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f140958a = null;

    public a() {
    }

    @Override // ck6.a
    public final void a() {
    }

    static {
        f140958a = new a();
    }

    @Override // ck6.a
    public final void info(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        ALogger.i("LiveRichContentTracer", r100);
    }

    @Override // ck6.a
    public final void error(String r100, Throwable r101) {
        ALogger.e("LiveRichContentTracer", r100, r101);
    }
}
