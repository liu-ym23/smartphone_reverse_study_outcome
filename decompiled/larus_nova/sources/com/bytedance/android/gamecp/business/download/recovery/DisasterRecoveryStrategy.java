package com.bytedance.android.gamecp.business.download.recovery;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.gamecp.business.download.GamePromoteDownloaderOld;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.common.setting.config.q0;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DisasterRecoveryStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f52905c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f52906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f52907b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f52908a;

        public b(p r100) {
            this.f52908a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y0 r100 = y0.f52963a;     // Catch: Throwable -> L4
            Context r101 = (Context) DisasterRecoveryManager.f52892a.getValue();     // Catch: Throwable -> L4
            p r102 = this.f52908a;     // Catch: Throwable -> L4
            y0.f(r102);     // Catch: Throwable -> L4
            GamePromoteDownloaderOld.f52422f.g(r101, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public DisasterRecoveryStrategy(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f52907b = r100;
        this.f52906a = LazyKt.lazy(DisasterRecoveryStrategy$taskStatus$2.INSTANCE);
    }

    public final c b(p r100) {
        c r101 = (c) ((Map) this.f52906a.getValue()).get(r100.f52840c0);
        if (r101 != null) goto L6;
        c r102 = new c(this.f52907b);
        ((Map) this.f52906a.getValue()).put(r100.f52840c0, r102);
        return r102;
    L6:
        return r101;
    }

    public final void a(p r100, c r101) {
        yr.c.a("DisasterRecoveryManager", "标记已经执行");
        r101.f52913a = true;
        r101.f52914b.clear();
        if (TextUtils.isEmpty(this.f52907b.m()) == true) goto L6;
        ToastUtil.b(this.f52907b.m(), 0);
    L6:
        if (this.f52907b.k() != 1) goto L9;
        DisasterRecoveryManager.f52893b.post(new b(r100));
        return;
    }
}
