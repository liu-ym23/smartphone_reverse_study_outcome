package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IEffectDownloadProgressListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 implements IEffectDownloadProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.c f68342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f68343b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f68344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExceptionResult f68345b;

        public a(l0 r100, ExceptionResult r101) {
            this.f68344a = r100;
            this.f68345b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.c r100 = this.f68344a.f68342a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f68345b.getErrorCode();     // Catch: Throwable -> L6
            r100.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f68346a;

        public b(l0 r100) {
            this.f68346a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.c r100 = this.f68346a.f68342a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onDownloadStart();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IEffectDownloadProgressListener
    public final void onProgress(Effect r100, int r101, long r102) {
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onStart(Effect r100) {
        AndroidSchedulers.mainThread().scheduleDirect(new b(this));
    }

    @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
    public final void onSuccess(Effect r100) {
        Effect r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        AndroidSchedulers.mainThread().scheduleDirect(new k0(this, r101));
    }

    @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener
    public final void onFail(Effect r100, ExceptionResult r101) {
        Intrinsics.checkNotNullParameter(r101, "e");
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r101));
    }

    public l0(o.c r100, String r101, Sticker r102) {
        this.f68342a = r100;
        this.f68343b = r101;
    }
}
