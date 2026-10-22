package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import fna.g;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class AudioRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f33549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile AudioRecord f33550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f33555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f33556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f33557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f33558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Thread f33559k;

    public static class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            AudioRecorder r101 = ((c) r100.obj).f33561a;
            int r102 = r100.what;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L8;
            return;
        L8:
            if (AudioRecorder.a(r101) == false) goto L14;
            r101.onReadError();
            return;
        L14:
            return;
        L11:
            if (AudioRecorder.a(r101) == false) goto L16;
            c r103 = (c) r100.obj;
            r101.onReadData(r103.f33562b, r103.f33563c);
            return;
        }
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioRecorder f33560a;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com_baidu_vi_AudioRecorder$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_vi_AudioRecorder$b__run$___twin___() {
            Process.setThreadPriority(-19);
            INVOKEVIRTUAL_com_baidu_vi_AudioRecorder$b_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecorder.b(this.f33560a));
            int r100 = 0;
        L4:
            if (AudioRecorder.a(this.f33560a) == false) goto L18;
            byte[] r101 = new byte[AudioRecorder.c(this.f33560a)];
            if (AudioRecorder.b(this.f33560a) == null) goto L9;
            r100 = AudioRecorder.b(this.f33560a).read(r101, 0, AudioRecorder.c(this.f33560a));
        L9:
            if (r100 == (-3)) goto L17;
            if (r100 == (-2)) goto L17;
            if (r100 == (-1)) goto L17;
            if (r100 == 0) goto L17;
            AudioRecorder.a(this.f33560a, r101, r100);
        L17:
            AudioRecorder.d(this.f33560a);
            goto L4
        }

        public static void INVOKEVIRTUAL_com_baidu_vi_AudioRecorder$b_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r100) {
            if (g.d() == true) goto L6;
            com_baidu_vi_AudioRecorder$b_android_media_AudioRecord_startRecording(r100);
            return;
        L6:
            com_baidu_vi_AudioRecorder$b_android_media_AudioRecord_startRecording(r100);
            if ((r100 instanceof AudioRecord) == false) goto L10;
            hna.a.b(r100.hashCode());
            return;
        }

        private static void com_baidu_vi_AudioRecorder$b_android_media_AudioRecord_startRecording(AudioRecord r110) {
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

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_vi_AudioRecorder$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_vi_AudioRecorder$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(AudioRecorder r100, String r101) {
            this.f33560a = r100;
            super(r101);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AudioRecorder f33561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f33562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AudioRecorder f33564d;

        public c(AudioRecorder r100, AudioRecorder r101, byte[] r102, int r103) {
            this.f33564d = r100;
            this.f33561a = r101;
            this.f33562b = r102;
            this.f33563c = r103;
        }
    }

    public native void onReadData(byte[] r100, int r101);

    public native void onReadError();

    static {
        f33549a = new a();
    }

    private void a() {
        if (this.f33554f == false) goto L6;
        c r100 = new c(this, this, null, 0);
        Handler r101 = f33549a;
        r101.sendMessage(r101.obtainMessage(2, r100));
        return;
    L6:
        if (this.f33557i == false) goto L10;
        onReadError();
        return;
    }

    public static /* synthetic */ boolean a(AudioRecorder r100) {
        return r100.f33557i;
    }

    public static /* synthetic */ AudioRecord b(AudioRecorder r100) {
        return r100.f33550b;
    }

    public static /* synthetic */ int c(AudioRecorder r100) {
        return r100.f33555g;
    }

    public static /* synthetic */ void d(AudioRecorder r100) {
        r100.a();
    }

    private void a(byte[] r100, int r101) {
        if (this.f33554f == false) goto L6;
        c r102 = new c(this, this, r100, r101);
        Handler r103 = f33549a;
        r103.sendMessage(r103.obtainMessage(1, r102));
        return;
    L6:
        if (this.f33557i == false) goto L10;
        onReadData(r100, r101);
        return;
    }

    public static /* synthetic */ void a(AudioRecorder r100, byte[] r101, int r102) {
        r100.a(r101, r102);
    }

    public AudioRecorder(int r100, int r101, int r102, int r103, int r104, int r110, int r111) {
        boolean r105 = true;
        this.f33554f = true;
        this.f33557i = false;
        this.f33558j = new Object();
        this.f33559k = new b(this, "AudioRecorder-Record");
        if (r102 != 8) goto L5;
        this.f33553e = 3;
    L6:
        if (r103 != 2) goto L8;
        this.f33552d = 3;
    L9:
        if (r111 == 1) goto L12;
        r105 = false;
    L12:
        this.f33554f = r105;
        this.f33551c = r101;
        this.f33556h = r104;
        this.f33555g = r110;
        return;
    L8:
        this.f33552d = 2;
        goto L9
    L5:
        this.f33553e = 2;
        goto L6
    }
}
