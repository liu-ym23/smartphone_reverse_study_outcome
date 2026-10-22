package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f147776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f147777b;

    public d0(String r100, Map r101) {
        this.f147776a = r100;
        this.f147777b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f147776a;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        com.bytedance.android.livesdk.livecommerce.event.e r101 = new com.bytedance.android.livesdk.livecommerce.event.e(r100);     // Catch: Throwable -> L7
        r101.g(this.f147777b);     // Catch: Throwable -> L7
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
