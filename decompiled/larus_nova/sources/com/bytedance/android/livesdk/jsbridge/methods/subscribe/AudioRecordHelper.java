package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.media.MediaRecorder;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public final class AudioRecordHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f142183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f142184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static MediaRecorder f142185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f142186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PolarisFileWrapper f142187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f142188f = null;

    static {
        f142183a = TokenCert.Companion.with("bpea-vip_request_record_permission");
        f142188f = LazyKt.lazy(AudioRecordHelper$outputPath$2.INSTANCE);
    }

    public static void a(MediaRecorder r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100500, "android/media/MediaRecorder", "prepare", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100500, "android/media/MediaRecorder", "prepare", r110, r101, null, r111, false);
        return;
    L6:
        r110.prepare();
        r100.a(100500, "android/media/MediaRecorder", "prepare", r110, r101, null, r111, true);
    }
}
