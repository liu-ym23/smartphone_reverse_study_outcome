package com.bytedance.android.annie.bridge.method.audio;

import android.media.AudioRecord;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f38559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioRecord f38560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f38561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f38562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f38563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RunnableC0725c f38564g;

    public static final class a {
    }

    public interface b {
        void a(byte[] r100);
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.audio.c$c, reason: collision with other inner class name */
    public static final class RunnableC0725c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f38565a;

        public RunnableC0725c(c r100) {
            this.f38565a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f38565a;     // Catch: Throwable -> L16
            byte[] r101 = r100.f38559b;     // Catch: Throwable -> L16
            if (r101 == null) goto L19;
        L4:
            if (r100.f38563f != 2) goto L31;
            AudioRecord r102 = r100.f38560c;     // Catch: Throwable -> L16
            if (r102 == null) goto L9;
            int r103 = r102.read(r101, 0, r100.f38558a);     // Catch: Throwable -> L16
        L11:
            if (r103 != r101.length) goto L4;
            b r104 = r100.f38561d;     // Catch: Throwable -> L16
            if (r104 == null) goto L4;
            r104.a(r101);     // Catch: Throwable -> L16
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

    public c() {
        this.f38564g = new RunnableC0725c(this);
        int r100 = AudioRecord.getMinBufferSize(16000, 16, 2);
        this.f38558a = r100;
        if (r100 <= 0) goto L5;
        this.f38559b = new byte[r100];
        this.f38560c = new AudioRecord(1, 16000, 16, 2, this.f38558a);
        this.f38563f = 1;
    L6:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("Audio_Recorder");
        ThreadMethodProxy.start(r101);
        this.f38562e = new Handler(r101.getLooper());
        return;
    L5:
        this.f38563f = 0;
        goto L6
    }

    public static void a(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    public static void b(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    public static void c(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }
}
