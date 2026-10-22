package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class WeakDownloadHandler extends Handler {
    private final WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMsg(Message r1);
    }

    public WeakDownloadHandler(IHandler r3) {
        this.mRef = new WeakReference((IHandler) ZeusTransformUtils.wrapperContextForParams(r3, IHandler.class, "com.obric.aiagent.plugin"));
    }

    public WeakDownloadHandler(Looper r3, IHandler r4) {
        IHandler r5 = (IHandler) ZeusTransformUtils.wrapperContextForParams(r4, IHandler.class, "com.obric.aiagent.plugin");
        super(r3);
        this.mRef = new WeakReference(r5);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        IHandler r2 = (IHandler) ZeusTransformUtils.preCheckCast(this.mRef.get(), IHandler.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r2.handleMsg(r3);
        return;
    L8:
        return;
    }
}
