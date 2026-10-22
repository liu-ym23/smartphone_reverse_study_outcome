package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.media.AudioRecord;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f80490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f80491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioRecord f80492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC1245b f80493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f80494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f80495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f80496g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.radio.asr.b$b, reason: collision with other inner class name */
    public interface InterfaceC1245b {
        void onPCMDataReceived(byte[] r100, int r101);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f80497a;

        public c(b r100) {
            this.f80497a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] r100 = this.f80497a.f80491b;     // Catch: Throwable -> L16
            if (r100 == null) goto L19;
        L4:
            if (this.f80497a.f80495f != 2) goto L31;
            b r101 = this.f80497a;     // Catch: Throwable -> L16
            AudioRecord r102 = r101.f80492c;     // Catch: Throwable -> L16
            if (r102 == null) goto L9;
            int r103 = r102.read(r100, 0, r101.f80490a);     // Catch: Throwable -> L16
        L11:
            if (r103 != r100.length) goto L4;
            InterfaceC1245b r104 = this.f80497a.f80493d;     // Catch: Throwable -> L16
            if (r104 == null) goto L4;
            r104.onPCMDataReceived(r100, r103);     // Catch: Throwable -> L16
            goto L4
        L9:
            r103 = -10086;
            goto L11
        L31:
            return;
        L19:
            return;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L30;
            throw th;
        }
    }

    static {
    }

    public b() {
        this.f80496g = new c(this);
        int r100 = AudioRecord.getMinBufferSize(16000, 16, 2);     // Catch: IllegalArgumentException -> L8
        this.f80490a = r100;     // Catch: IllegalArgumentException -> L8
        if (r100 <= 0) goto L6;
        this.f80491b = new byte[r100];     // Catch: IllegalArgumentException -> L8
        this.f80492c = new AudioRecord(1, 16000, 16, 2, this.f80490a);     // Catch: IllegalArgumentException -> L8
        this.f80495f = 1;     // Catch: IllegalArgumentException -> L8
    L12:
    L10:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("Audio_Recorder");
        ThreadMethodProxy.start(r101);
        this.f80494e = new Handler(r101.getLooper());
        Unit r102 = Unit.INSTANCE;
        return;
    L6:
        this.f80495f = 0;     // Catch: IllegalArgumentException -> L8
    L8:
        e = move-exception;
        f72.a.b("Create Record Exception: " + e.getMessage());
        goto L10
    }
}
