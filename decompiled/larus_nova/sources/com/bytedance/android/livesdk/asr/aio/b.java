package com.bytedance.android.livesdk.asr.aio;

import com.bytedance.android.livesdk.asr.LogLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ASRManagerService f103966a;

    public final void a() {
        com.bytedance.android.livesdk.asr.b r100 = this.f103966a.f103963h;
        r100.getClass();
        Intrinsics.checkNotNullParameter("setupTimeOutTimer", "tag");
        Intrinsics.checkNotNullParameter("ASR Engine timeout！", "message");
        r100.a(LogLevel.WARNING, "[setupTimeOutTimer] ASR Engine timeout！", null);
        this.f103966a.stopASREngine();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(ASRManagerService r100) {
        this.f103966a = r100;
    }
}
