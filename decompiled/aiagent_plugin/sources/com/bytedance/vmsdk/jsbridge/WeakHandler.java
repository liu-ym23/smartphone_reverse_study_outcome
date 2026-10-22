package com.bytedance.vmsdk.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class WeakHandler extends Handler {
    WeakReference<a> mRef;

    public interface a {
        void a(Message r1);
    }

    public WeakHandler(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        if (Looper.myLooper() != null) goto L5;
        Looper r0 = Looper.getMainLooper();
    L6:
        this(r0, r4);
        return;
    L5:
        r0 = Looper.myLooper();
        goto L6
    }

    public WeakHandler(Looper r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        super(r3);
        this.mRef = new WeakReference(r5);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.mRef.get(), a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r2.a(r3);
        return;
    L8:
        return;
    }
}
