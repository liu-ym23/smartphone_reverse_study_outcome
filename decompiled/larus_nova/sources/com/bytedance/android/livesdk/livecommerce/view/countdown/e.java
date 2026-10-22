package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f153223a;

    public interface a {
        void handleMsg(Message r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        a r101 = this.f153223a.get();
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.handleMsg(r100);
        return;
    L8:
        return;
    }

    public e(Looper r100, a r101) {
        super(r100);
        this.f153223a = new WeakReference(r101);
    }
}
