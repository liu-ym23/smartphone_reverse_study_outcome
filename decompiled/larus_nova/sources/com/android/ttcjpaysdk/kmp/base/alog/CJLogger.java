package com.android.ttcjpaysdk.kmp.base.alog;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import id6.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/alog/CJLogger;", "", "<init>", "()V", "CJ_TAG", "", "d", "", "tag", "msg", RXScreenCaptureService.KEY_INDEX, "e", "w", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLogger {
    public static final int $stable = 0;
    private static final String CJ_TAG = "cjsdk";
    public static final CJLogger INSTANCE = null;

    static {
        INSTANCE = new CJLogger();
    }

    private CJLogger() {
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.f489337c.Y2("cjsdk_" + r100, r101, true);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.f489337c.e("cjsdk_" + r100, r101);
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.f489337c.Q2("cjsdk_" + r100, r101, true);
    }

    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        b.f489337c.w("cjsdk_" + r100, r101);
    }
}
