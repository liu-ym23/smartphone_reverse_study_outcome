package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.a f147798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f147799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f147800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f147801d;

    public w(com.bytedance.android.ec.common.api.jump.model.a r100, String r101, Map r102, String r103) {
        this.f147798a = r100;
        this.f147799b = r101;
        this.f147800c = r102;
        this.f147801d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r100 = new sg2.v(this.f147799b, this.f147798a);     // Catch: Throwable -> L4
        r100.d(this.f147800c);     // Catch: Throwable -> L4
        r100.i(this.f147801d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
