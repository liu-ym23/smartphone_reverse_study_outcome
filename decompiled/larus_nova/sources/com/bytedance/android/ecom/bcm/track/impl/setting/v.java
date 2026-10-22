package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.bytedance.android.btm.api.BtmSDK;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements zc.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f51151a;

    /* JADX INFO: loaded from: classes44.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f51152a;

        public a(v r100) {
            this.f51152a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Setting.a();     // Catch: Throwable -> L6
            Function0 r100 = this.f51152a.f51151a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.invoke();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // zc.i
    public final void callback() {
        BtmSDK.INSTANCE.getThreadExecutor().a(new a(this), true);
    }

    public v(Function0 r100) {
        this.f51151a = r100;
    }
}
