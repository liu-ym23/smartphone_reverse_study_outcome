package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f147769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f147770b;

    public b0(String r100, Map r101) {
        this.f147769a = r100;
        this.f147770b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f147769a;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        com.bytedance.android.livesdk.livecommerce.event.c r101 = new com.bytedance.android.livesdk.livecommerce.event.c(r100);     // Catch: Throwable -> L7
        r101.g(this.f147770b);     // Catch: Throwable -> L7
        r101.k();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
