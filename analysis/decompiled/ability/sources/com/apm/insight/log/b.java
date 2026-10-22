package com.apm.insight.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.apm.insight.log.a;
import com.apm.insight.log.a.f;

/* loaded from: classes2.dex */
final class b extends Handler {
    public b(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            f.b();
        } else {
            Object obj = message.obj;
            if (obj == null || !(obj instanceof a.C0144a)) {
                return;
            }
            a.a((a.C0144a) obj);
        }
    }
}
