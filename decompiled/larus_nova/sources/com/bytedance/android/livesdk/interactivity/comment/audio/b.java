package com.bytedance.android.livesdk.interactivity.comment.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f134807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f134808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioRecord f134809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC2125b f134810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f134811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f134812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f134813g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.audio.b$b, reason: collision with other inner class name */
    public interface InterfaceC2125b {
        void a(byte[] r100);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f134814a;

        public c(b r100) {
            this.f134814a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte[] r100 = this.f134814a.f134808b;     // Catch: Throwable -> L16
            if (r100 == null) goto L19;
        L4:
            if (this.f134814a.f134812f != 2) goto L31;
            b r101 = this.f134814a;     // Catch: Throwable -> L16
            AudioRecord r102 = r101.f134809c;     // Catch: Throwable -> L16
            if (r102 == null) goto L9;
            int r103 = r102.read(r100, 0, r101.f134807a);     // Catch: Throwable -> L16
        L11:
            if (r103 != r100.length) goto L4;
            InterfaceC2125b r104 = this.f134814a.f134810d;     // Catch: Throwable -> L16
            if (r104 == null) goto L4;
            r104.a(r100);     // Catch: Throwable -> L16
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
        this.f134813g = new c(this);
        int r100 = AudioRecord.getMinBufferSize(16000, 16, 2);     // Catch: IllegalArgumentException -> L8
        this.f134807a = r100;     // Catch: IllegalArgumentException -> L8
        if (r100 <= 0) goto L6;
        this.f134808b = new byte[r100];     // Catch: IllegalArgumentException -> L8
        this.f134809c = new AudioRecord(1, 16000, 16, 2, this.f134807a);     // Catch: IllegalArgumentException -> L8
        this.f134812f = 1;     // Catch: IllegalArgumentException -> L8
    L12:
    L10:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("Audio_Recorder");
        ThreadMethodProxy.start(r101);
        this.f134811e = new Handler(r101.getLooper());
        Unit r102 = Unit.INSTANCE;
        return;
    L6:
        this.f134812f = 0;     // Catch: IllegalArgumentException -> L8
    L8:
        e = move-exception;
        f72.a.b("Create Record Exception: " + e.getMessage());
        goto L10
    }

    public final void a(TokenCert r100) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_IS_CERT);
        AudioRecord r101 = this.f134809c;     // Catch: BPEAException -> L10 IllegalStateException -> L12
        if (r101 == null) goto L6;
        g80.a.d(r101, r100);     // Catch: BPEAException -> L10 IllegalStateException -> L12
    L6:
        this.f134812f = 2;     // Catch: BPEAException -> L10 IllegalStateException -> L12
        Handler r102 = this.f134811e;     // Catch: BPEAException -> L10 IllegalStateException -> L12
        if (r102 == null) goto L17;
        r102.post(this.f134813g);     // Catch: BPEAException -> L10 IllegalStateException -> L12
    L19:
        return;
    L17:
        return;
    L10:
        e = move-exception;
        f72.a.b("Start Record BPEAException: " + e.getMessage());
        return;
    L12:
        e = move-exception;
        f72.a.b("Start Record Exception: " + e.getMessage());
    }

    public final void b(TokenCert r100) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_IS_CERT);
        AudioRecord r101 = this.f134809c;     // Catch: BPEAException -> L8 IllegalStateException -> L10
        if (r101 == null) goto L6;
        g80.a.e(r101, r100);     // Catch: BPEAException -> L8 IllegalStateException -> L10
    L6:
        this.f134812f = 1;     // Catch: BPEAException -> L8 IllegalStateException -> L10
    L16:
        return;
    L8:
        e = move-exception;
        f72.a.b("Stop Record BPEAException: " + e.getMessage());
        return;
    L10:
        e = move-exception;
        f72.a.b("Stop Record Exception: " + e.getMessage());
    }
}
