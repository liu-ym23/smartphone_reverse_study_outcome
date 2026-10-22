package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.business.module.ecommerce.EcommerceTag;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.card.util.a$a, reason: collision with other inner class name */
    public static final class RunnableC0817a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f46592a;

        public RunnableC0817a(Runnable r100) {
            this.f46592a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f46592a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            LocalTestManager.a(new Class[]{EcommerceTag.class});     // Catch: Throwable -> L8
            EnsureManager.ensureNotReachHere(th, "EC_SDK ");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public static final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Schedulers.single().scheduleDirect(new RunnableC0817a(r100));
    }
}
