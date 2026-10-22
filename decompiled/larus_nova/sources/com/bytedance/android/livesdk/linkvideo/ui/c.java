package com.bytedance.android.livesdk.linkvideo.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f147179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkVideoDialog f147180b;

    public c(View r100, LinkVideoDialog r101) {
        this.f147179a = r100;
        this.f147180b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkVideoDialog r100 = this.f147180b;     // Catch: Throwable -> L4
        r100.M = this.f147179a.getHeight();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
