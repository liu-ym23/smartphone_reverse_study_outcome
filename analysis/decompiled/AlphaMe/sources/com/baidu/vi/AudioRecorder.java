package com.baidu.vi;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

/* loaded from: classes.dex */
public class AudioRecorder {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private static Handler f9460a = new a();

    /* renamed from: b, reason: collision with root package name */
    private volatile AudioRecord f9461b;

    /* renamed from: c, reason: collision with root package name */
    private int f9462c;

    /* renamed from: d, reason: collision with root package name */
    private int f9463d;

    /* renamed from: e, reason: collision with root package name */
    private int f9464e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9465f;

    /* renamed from: g, reason: collision with root package name */
    private int f9466g;

    /* renamed from: h, reason: collision with root package name */
    private int f9467h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f9468i = false;

    /* renamed from: j, reason: collision with root package name */
    private Object f9469j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private Thread f9470k = new b("AudioRecorder-Record");

    public static class a extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AudioRecorder audioRecorder = ((c) message.obj).f9472a;
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 == 2 && audioRecorder.f9468i) {
                    audioRecorder.onReadError();
                    return;
                }
                return;
            }
            if (audioRecorder.f9468i) {
                c cVar = (c) message.obj;
                audioRecorder.onReadData(cVar.f9473b, cVar.f9474c);
            }
        }
    }

    public class b extends Thread {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            AudioRecorder.this.f9461b.startRecording();
            int i4 = 0;
            while (AudioRecorder.this.f9468i) {
                byte[] bArr = new byte[AudioRecorder.this.f9466g];
                if (AudioRecorder.this.f9461b != null) {
                    i4 = AudioRecorder.this.f9461b.read(bArr, 0, AudioRecorder.this.f9466g);
                }
                if (i4 == -3 || i4 == -2 || i4 == -1 || i4 == 0) {
                    AudioRecorder.this.a();
                } else {
                    AudioRecorder.this.a(bArr, i4);
                }
            }
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        AudioRecorder f9472a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f9473b;

        /* renamed from: c, reason: collision with root package name */
        int f9474c;

        public c(AudioRecorder audioRecorder, byte[] bArr, int i4) {
            this.f9472a = audioRecorder;
            this.f9473b = bArr;
            this.f9474c = i4;
        }
    }

    public AudioRecorder(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f9465f = true;
        if (i6 == 8) {
            this.f9464e = 3;
        } else {
            this.f9464e = 2;
        }
        if (i7 == 2) {
            this.f9463d = 3;
        } else {
            this.f9463d = 2;
        }
        this.f9465f = i10 == 1;
        this.f9462c = i5;
        this.f9467h = i8;
        this.f9466g = i9;
    }

    public native void onReadData(byte[] bArr, int i4);

    public native void onReadError();

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f9465f) {
            c cVar = new c(this, null, 0);
            Handler handler = f9460a;
            handler.sendMessage(handler.obtainMessage(2, cVar));
        } else if (this.f9468i) {
            onReadError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i4) {
        if (this.f9465f) {
            c cVar = new c(this, bArr, i4);
            Handler handler = f9460a;
            handler.sendMessage(handler.obtainMessage(1, cVar));
        } else if (this.f9468i) {
            onReadData(bArr, i4);
        }
    }
}
