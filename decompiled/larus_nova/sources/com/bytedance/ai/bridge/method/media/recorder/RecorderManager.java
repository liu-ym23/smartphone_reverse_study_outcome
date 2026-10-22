package com.bytedance.ai.bridge.method.media.recorder;

import android.app.Activity;
import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Base64;
import androidx.collection.SieveCacheKt;
import androidx.core.content.PermissionChecker;
import com.bytedance.ai.bridge.doubao.recorder.AbsOperateRecorderMethodIDL;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class RecorderManager implements e3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<e3.d> f35575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f35576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public State f35577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f35578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f35579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaRecorder f35580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f35581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f35582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AudioRecord f35583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PthreadThreadV2 f35584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f35585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f35586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f35588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile Function0<Unit> f35589o;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/recorder/RecorderManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "STARTED", "PAUSED", "STOPPING", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State IDLE = null;
        public static final State PAUSED = null;
        public static final State STARTED = null;
        public static final State STARTING = null;
        public static final State STOPPING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f35590a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f35591b = null;

        public static EnumEntries<State> getEntries() {
            return f35591b;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("STARTING", 1);
            STARTING = r101;
            State r102 = new State("STARTED", 2);
            STARTED = r102;
            State r103 = new State("PAUSED", 3);
            PAUSED = r103;
            State r104 = new State("STOPPING", 4);
            STOPPING = r104;
            State[] r105 = {r100, r101, r102, r103, r104};
            f35590a = r105;
            f35591b = EnumEntriesKt.enumEntries(r105);
        }

        public static State[] values() {
            return (State[]) f35590a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        g.f37637a.i("AISDK_JSB_RecorderManager", "context released, cleaning up recorder");
        Object r100 = this.f35576b;
        monitor-enter(r100);
        this.f35578d = true;     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        q();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final f3.a k() {
        g r100 = g.f37637a;
        r100.i("AISDK_JSB_RecorderManager", "pause called");
        if (this.f35585k == 0) goto L5;
    L8:
        Object r101 = this.f35576b;
        monitor-enter(r101);
    L36:
        th = move-exception;
        throw th;
    L11:
        if (this.f35577c == State.STARTED) goto L40;
        StringBuilder r102 = new StringBuilder("pause failed, errNo=");     // Catch: Throwable -> L36
        f3.a.C5852a r103 = f3.a.f475262c;     // Catch: Throwable -> L36
        f3.a r104 = f3.b.f475287a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L36
        f3.a r105 = f3.b.f475302p;     // Catch: Throwable -> L36
        r102.append(r105.f475285a);     // Catch: Throwable -> L36
        r102.append(", msg=recorder not started");     // Catch: Throwable -> L36
        r100.e("AISDK_JSB_RecorderManager", r102.toString());     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L36
        monitor-exit(r101);
        return r105;
    L40:
    L22:
        e = move-exception;
        g r106 = g.f37637a;     // Catch: Throwable -> L36
        StringBuilder r107 = new StringBuilder("pause failed, errNo=");     // Catch: Throwable -> L36
        f3.a r108 = f3.a.f475265f;     // Catch: Throwable -> L36
        r107.append(r108.f475285a);     // Catch: Throwable -> L36
        r107.append(", msg=");     // Catch: Throwable -> L36
        r107.append(e.getMessage());     // Catch: Throwable -> L36
        r106.e("AISDK_JSB_RecorderManager", r107.toString());     // Catch: Throwable -> L36
        return r108;
    L16:
        if (this.f35585k <= 0) goto L25;
        AudioRecord r109 = this.f35583i;     // Catch: Exception -> L22 Throwable -> L36
        if (r109 != null) goto L20;
    L28:
        this.f35577c = State.PAUSED;     // Catch: Exception -> L22 Throwable -> L36
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r101);
        r100.i("AISDK_JSB_RecorderManager", "recorder paused successfully");
        JsonObject r111 = new JsonObject();
        r111.addProperty("state", "pause");
        l(r111);
        return null;
    L20:
        if (fna.g.d() == true) goto L24;
        e(r109);     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L24:
        e(r109);     // Catch: Exception -> L22 Throwable -> L36
        hna.a.c(r109.hashCode());     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L25:
        MediaRecorder r112 = this.f35580f;     // Catch: Exception -> L22 Throwable -> L36
        if (r112 == null) goto L28;
        r112.pause();     // Catch: Exception -> L22 Throwable -> L36
        goto L28
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        StringBuilder r113 = new StringBuilder("pause failed, errNo=");
        f3.a r114 = f3.a.f475266g;
        r113.append(r114.f475285a);
        r113.append(", msg=pause not supported below Android N");
        r100.e("AISDK_JSB_RecorderManager", r113.toString());
        return r114;
    }

    public final f3.a p() {
        g r100 = g.f37637a;
        r100.i("AISDK_JSB_RecorderManager", "stop called");
        Object r101 = this.f35576b;
        monitor-enter(r101);
        State r102 = this.f35577c;     // Catch: Throwable -> L17
        if (r102 == State.STARTED) goto L10;
        if (r102 == State.PAUSED) goto L10;
        boolean r103 = false;
    L11:
        monitor-exit(r101);
        if (r103 == true) goto L15;
        StringBuilder r104 = new StringBuilder("stop failed, errNo=");
        f3.a.C5852a r105 = f3.a.f475262c;
        f3.a r106 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        f3.a r107 = f3.b.f475302p;
        r104.append(r107.f475285a);
        r104.append(", msg=recorder not started");
        r100.e("AISDK_JSB_RecorderManager", r104.toString());
        Intrinsics.checkNotNullParameter(r105, "<this>");
        return r107;
    L15:
        q();
        return null;
    L10:
        r103 = true;
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    public final void q() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        final Ref.LongRef r102 = new Ref.LongRef();
        Object r103 = this.f35576b;
        monitor-enter(r103);
        State r104 = this.f35577c;     // Catch: Throwable -> L102
        State r105 = State.IDLE;     // Catch: Throwable -> L102
        if (r104 == r105) goto L100;
        State r106 = State.STOPPING;     // Catch: Throwable -> L102
        if (r104 == r106) goto L100;
        ?? r107 = this.f35581g;     // Catch: Throwable -> L102
        if (r107 != 0) goto L14;
        this.f35577c = r105;     // Catch: Throwable -> L102
        monitor-exit(r103);
        return;
    L14:
        r100.element = r107;     // Catch: Throwable -> L102
        this.f35577c = r106;     // Catch: Throwable -> L102
        r101.element = this.f35582h;     // Catch: Throwable -> L102
        if (this.f35579e <= 0) goto L17;
        long r108 = System.currentTimeMillis() - this.f35579e;     // Catch: Throwable -> L102
    L18:
        r102.element = r108;     // Catch: Throwable -> L102
        boolean r109 = true;
        if (this.f35585k <= 0) goto L21;
        boolean r110 = true;
    L22:
        MediaRecorder r111 = this.f35580f;     // Catch: Throwable -> L102
        this.f35580f = null;     // Catch: Throwable -> L102
        AudioRecord r112 = this.f35583i;     // Catch: Throwable -> L102
        this.f35583i = null;     // Catch: Throwable -> L102
        PthreadThreadV2 r113 = this.f35584j;     // Catch: Throwable -> L102
        this.f35584j = null;     // Catch: Throwable -> L102
        if (ThreadMethodProxy.currentThread() != r113) goto L25;
        boolean r114 = true;
    L26:
        this.f35581g = null;     // Catch: Throwable -> L102
        this.f35582h = null;     // Catch: Throwable -> L102
        this.f35585k = 0;     // Catch: Throwable -> L102
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L102
        monitor-exit(r103);
        if (r110 == false) goto L61;
        if (r112 != null) goto L106;
    L43:
        if (r112 == null) goto L45;
    L44:
        c(r112);
    L45:
        if (r114 == false) goto L48;
        this.f35589o = new d(r100, r102, this, r101);
        return;
    L48:
        if (r113 != null) goto L110;
    L53:
        if (r113 != null) goto L55;
    L57:
        boolean r116 = false;
    L58:
        if (r116 == false) goto L74;
        g.f37637a.w("AISDK_JSB_RecorderManager", "frame thread did not exit within 5s join timeout; deferring stop event + IDLE transition");
        this.f35589o = new e(r100, r102, this, r101);
        return;
    L74:
        if (r113 != null) goto L76;
    L78:
        r109 = false;
    L79:
        if (r109 == true) goto L91;
        Object r117 = this.f35576b;
        monitor-enter(r117);
    L88:
        th = move-exception;
        throw th;
    L83:
        if (this.f35577c != State.STOPPING) goto L85;
        this.f35577c = State.IDLE;     // Catch: Throwable -> L88
    L85:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r117);
    L91:
        PolarisFileWrapper r119 = new PolarisFileWrapper((String) r100.element);
        if (r119.exists() == false) goto L94;
        long r120 = r119.length();
    L95:
        g.f37637a.i("AISDK_JSB_RecorderManager", "recorder stopped, filePath=" + ((String) r100.element) + ", duration=" + r102.element + " ms, fileSize=" + r120 + " B");
        JsonObject r121 = new JsonObject();
        r121.addProperty("state", "stop");
        String r122 = (String) r101.element;
        if (r122 != null) goto L98;
        r122 = (String) r100.element;
    L98:
        r121.addProperty("tempFilePath", r122);
        r121.addProperty("duration", Long.valueOf(r102.element));
        r121.addProperty("fileSize", Long.valueOf(r120));
        l(r121);
        return;
    L94:
        r120 = 0;
        goto L95
    L76:
        if (ThreadMethodProxy.isAlive(r113) != true) goto L78;
    L55:
        if (ThreadMethodProxy.isAlive(r113) != true) goto L57;
        r116 = true;
        goto L58
    L110:
        ThreadMethodProxy.join(r113, 5000);     // Catch: InterruptedException -> L52
    L52:
        ThreadMethodProxy.currentThread().interrupt();
        goto L53
    L106:
    L35:
        e = move-exception;
        g.f37637a.e("AISDK_JSB_RecorderManager", "AudioRecord stop threw: " + e.getMessage());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        c(r112);
        throw th;
    L31:
        if (fna.g.d() == true) goto L37;
        e(r112);     // Catch: Throwable -> L33 Exception -> L35
    L105:
    L37:
        e(r112);     // Catch: Throwable -> L33 Exception -> L35
        hna.a.c(r112.hashCode());     // Catch: Throwable -> L33 Exception -> L35
        goto L105
    L61:
        if (r111 != null) goto L108;
    L72:
        if (r111 == null) goto L74;
    L73:
        g(r111);
        goto L74
    L108:
        i(r111);     // Catch: Throwable -> L64 Exception -> L66
    L66:
        e = move-exception;
        g.f37637a.e("AISDK_JSB_RecorderManager", "mediaRecorder stop threw: " + e.getMessage());     // Catch: Throwable -> L64
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        g(r111);
        throw th;
    L25:
        r114 = false;
        goto L26
    L21:
        r110 = false;
        goto L22
    L17:
        r108 = 0;
    L100:
        monitor-exit(r103);
        return;
    L102:
        th = move-exception;
        throw th;
    }

    public RecorderManager(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        this.f35575a = new WeakReference(r100);
        this.f35576b = new Object();
        this.f35577c = State.IDLE;
        this.f35586l = 44100;
        this.f35587m = 1;
    }

    public static void c(AudioRecord r110) {
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

    public static void d(AudioRecord r110) {
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

    public static void e(AudioRecord r110) {
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

    public static void f(MediaRecorder r110) {
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

    public static void g(MediaRecorder r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100501, "android/media/MediaRecorder", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100501, "android/media/MediaRecorder", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100501, "android/media/MediaRecorder", "release", r110, r101, null, r111, true);
    }

    public static void h(MediaRecorder r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100502, "android/media/MediaRecorder", "start", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100502, "android/media/MediaRecorder", "start", r110, r101, null, r111, false);
        return;
    L6:
        r110.start();
        r100.a(100502, "android/media/MediaRecorder", "start", r110, r101, null, r111, true);
    }

    public static void i(MediaRecorder r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100503, "android/media/MediaRecorder", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100503, "android/media/MediaRecorder", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100503, "android/media/MediaRecorder", "stop", r110, r101, null, r111, true);
    }

    public final void l(JsonObject r100) {
        e3.d r101 = this.f35575a.get();
        if (r101 == null) goto L6;
        r101.a("doubao.onRecorderStateChange", r100);
        return;
    }

    public final f3.a m(AbsOperateRecorderMethodIDL.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        g r101 = g.f37637a;
        r101.i("AISDK_JSB_RecorderManager", "start called, format=" + r100.getFormat() + ", sampleRate=" + r100.getSampleRate() + ", frameSize=" + r100.getFrameSize());
        Object r102 = this.f35576b;
        monitor-enter(r102);
    L75:
        th = move-exception;
        throw th;
    L5:
        if (this.f35578d == false) goto L9;
        r101.e("AISDK_JSB_RecorderManager", "start failed, context already released");     // Catch: Throwable -> L75
        f3.a r103 = f3.a.f475265f;     // Catch: Throwable -> L75
        monitor-exit(r102);
        return r103;
    L9:
        State r104 = this.f35577c;     // Catch: Throwable -> L75
        State r105 = State.IDLE;     // Catch: Throwable -> L75
        if (r104 == r105) goto L14;
        StringBuilder r106 = new StringBuilder("start failed, errNo=");     // Catch: Throwable -> L75
        f3.a.C5852a r107 = f3.a.f475262c;     // Catch: Throwable -> L75
        f3.a r108 = f3.b.f475287a;     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Throwable -> L75
        f3.a r109 = f3.b.f475301o;     // Catch: Throwable -> L75
        r106.append(r109.f475285a);     // Catch: Throwable -> L75
        r106.append(", msg=recorder already recording");     // Catch: Throwable -> L75
        r101.e("AISDK_JSB_RecorderManager", r106.toString());     // Catch: Throwable -> L75
        Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Throwable -> L75
        monitor-exit(r102);
        return r109;
    L14:
        State r110 = State.STARTING;     // Catch: Throwable -> L75
        this.f35577c = r110;     // Catch: Throwable -> L75
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L75
        monitor-exit(r102);
        e3.d r112 = this.f35575a.get();
        if (r112 == null) goto L21;
        Activity r113 = r112.getOwnerActivity();
        if (r113 == null) goto L21;
        Context r114 = r113.getApplicationContext();
    L22:
        if (r114 != null) goto L33;
        StringBuilder r115 = new StringBuilder("start failed, errNo=");
        f3.a r116 = f3.a.f475265f;
        r115.append(r116.f475285a);
        r115.append(", msg=context is null");
        r101.e("AISDK_JSB_RecorderManager", r115.toString());
        Object r117 = this.f35576b;
        monitor-enter(r117);
    L30:
        th = move-exception;
        throw th;
    L26:
        if (this.f35577c != r110) goto L28;
        this.f35577c = r105;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r117);
        return r116;
    L33:
        int r118 = 0;
        if (PermissionChecker.checkSelfPermission(r114, "android.permission.RECORD_AUDIO") != 0) goto L36;
        boolean r119 = true;
    L37:
        if (r119 == true) goto L48;
        StringBuilder r120 = new StringBuilder("start failed, errNo=");
        f3.a r121 = f3.a.f475269j;
        r120.append(r121.f475285a);
        r120.append(", msg=RECORD_AUDIO permission denied");
        r101.e("AISDK_JSB_RecorderManager", r120.toString());
        Object r122 = this.f35576b;
        monitor-enter(r122);
    L45:
        th = move-exception;
        throw th;
    L41:
        if (this.f35577c != r110) goto L43;
        this.f35577c = r105;     // Catch: Throwable -> L45
    L43:
        monitor-exit(r122);
        return r121;
    L48:
        Integer r123 = r100.getFrameSize();
        if (r123 == null) goto L51;
        r118 = r123.intValue();
    L51:
        String r124 = r100.getFormat();
        if (r124 != null) goto L54;
        r124 = "aac";
    L54:
        if (r118 <= 0) goto L57;
        f3.a r125 = n(r100, r114, r118);
    L63:
        if (r125 == null) goto L74;
        Object r126 = this.f35576b;
        monitor-enter(r126);
    L71:
        th = move-exception;
        throw th;
    L67:
        if (this.f35577c != r110) goto L69;
        this.f35577c = r105;     // Catch: Throwable -> L71
    L69:
        monitor-exit(r126);
    L74:
        return r125;
    L57:
        if (Intrinsics.areEqual(r124, "pcm") == false) goto L59;
    L62:
        StringBuilder r127 = new StringBuilder("start failed, errNo=");
        f3.a r128 = f3.a.f475266g;
        r127.append(r128.f475285a);
        r127.append(", msg=format=");
        r127.append(r124);
        r127.append(" requires frameSize on Android");
        r101.e("AISDK_JSB_RecorderManager", r127.toString());
        r125 = r128;
        goto L63
    L59:
        if (Intrinsics.areEqual(r124, "wav") == true) goto L62;
        r125 = o(r100, r114);
        goto L63
    L36:
        r119 = false;
    L21:
        r114 = null;
        goto L22
    }

    public final void b(MediaRecorder r100, PolarisFileWrapper r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        g(r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Object r104 = this.f35576b;
        monitor-enter(r104);
    L26:
        th = move-exception;
        throw th;
    L14:
        if (this.f35580f != r100) goto L16;
        this.f35580f = null;     // Catch: Throwable -> L26
    L16:
        this.f35577c = State.IDLE;     // Catch: Throwable -> L26
        this.f35581g = null;     // Catch: Throwable -> L26
        this.f35582h = null;     // Catch: Throwable -> L26
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r104);
    L23:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L19:
        if (r101.exists() == false) goto L21;
        r101.delete();     // Catch: Throwable -> L23
    L21:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final f3.a o(AbsOperateRecorderMethodIDL.b r210, Context r211) {
        Integer r100 = r210.getSampleRate();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        Integer r102 = r210.getNumberOfChannels();
        boolean r103 = true;
        if (r102 == null) goto L9;
        int r104 = r102.intValue();
    L10:
        Integer r105 = r210.getEncodeBitRate();
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
    L14:
        Integer r107 = r210.getDuration();
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        e3.d r109 = this.f35575a.get();
        MediaRecorder r110 = null;
        if (r109 == null) goto L21;
        AppletFileManager r111 = x3.a.d(r109);
    L22:
        if (r111 == null) goto L27;
        PolarisFileWrapper r112 = r111.f36579e;
        if (r112.exists() == true) goto L26;
        r112.mkdirs();
    L26:
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112, "recorder_" + System.currentTimeMillis() + ".m4a");
    L31:
        this.f35581g = r113.getAbsolutePath();
        if (r111 != null) goto L102;
        String r114 = null;
    L42:
        this.f35582h = r114;
    L97:
        e = e;
    L98:
        b(r110, r113);
        g r115 = g.f37637a;
        StringBuilder r116 = new StringBuilder("start failed, errNo=");
        f3.a r117 = f3.a.f475269j;
        r116.append(r117.f475285a);
        r116.append(", msg=");
        r116.append(e.getMessage());
        r115.e("AISDK_JSB_RecorderManager", r116.toString());
        return r117;
    L88:
        e = e;
    L89:
        b(r110, r113);
        if (PermissionChecker.checkSelfPermission(r211, "android.permission.RECORD_AUDIO") == 0) goto L93;
        r103 = false;
    L93:
        if (r103 == true) goto L95;
        f3.a r118 = f3.a.f475269j;
    L96:
        f3.a r119 = r118;
        g.f37637a.e("AISDK_JSB_RecorderManager", "start failed, errNo=" + r119.f475285a + ", msg=" + e.getMessage());
        return r119;
    L95:
        f3.a.C5852a r120 = f3.a.f475262c;
        f3.a r121 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        r118 = f3.b.f475300n;
    L86:
        e = e;
    L87:
        b(r110, r113);
        g r122 = g.f37637a;
        StringBuilder r123 = new StringBuilder("start failed, errNo=");
        f3.a.C5852a r124 = f3.a.f475262c;
        f3.a r125 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        f3.a r126 = f3.b.f475300n;
        r123.append(r126.f475285a);
        r123.append(", msg=");
        r123.append(e.getMessage());
        r122.e("AISDK_JSB_RecorderManager", r123.toString());
        Intrinsics.checkNotNullParameter(r124, "<this>");
        return r126;
    L44:
        if (Build.VERSION.SDK_INT < 31) goto L46;
        MediaRecorder r127 = new MediaRecorder(r211);     // Catch: Exception -> L86 RuntimeException -> L88 SecurityException -> L97
    L47:
        MediaRecorder r128 = r127;
        r128.setAudioSource(1);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setOutputFormat(2);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setAudioEncoder(3);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setAudioSamplingRate(r101);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setAudioChannels(r104);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setAudioEncodingBitRate(r106);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setOutputFile(this.f35581g);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        if (r108 <= 0) goto L51;
        r128.setMaxDuration(r108);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L51:
        r128.setOnInfoListener(new b(this));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r128.setOnErrorListener(new c(this));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f(r128);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        h(r128);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Object r129 = this.f35576b;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        monitor-enter(r129);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L77:
        th = move-exception;
        throw th;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L54:
        if (this.f35577c != State.STARTING) goto L56;
        this.f35580f = r128;     // Catch: Throwable -> L77
        this.f35577c = State.STARTED;     // Catch: Throwable -> L77
        this.f35579e = System.currentTimeMillis();     // Catch: Throwable -> L77
        boolean r130 = false;
    L57:
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r129);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        if (r130 == true) goto L104;
        g.f37637a.i("AISDK_JSB_RecorderManager", "recorder started successfully (MediaRecorder), filePath=" + this.f35581g);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        JsonObject r132 = new JsonObject();     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        r132.addProperty("state", "start");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        l(r132);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        return null;
    L104:
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L62
        g(r128);     // Catch: Throwable -> L62
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L64:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new RecorderManager$startWithMediaRecorder$6(r113, null), 3, null);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Object r134 = this.f35576b;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        monitor-enter(r134);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L73:
        th = move-exception;
        throw th;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
    L67:
        if (this.f35577c != State.STOPPING) goto L69;
        this.f35577c = State.IDLE;     // Catch: Throwable -> L73
    L69:
        this.f35581g = null;     // Catch: Throwable -> L73
        this.f35582h = null;     // Catch: Throwable -> L73
        Unit r135 = Unit.INSTANCE;     // Catch: Throwable -> L73
        monitor-exit(r134);     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        g.f37637a.w("AISDK_JSB_RecorderManager", "start aborted by concurrent stop during initialization (MediaRecorder)");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f3.a.C5852a r136 = f3.a.f475262c;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        f3.a r137 = f3.b.f475287a;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Intrinsics.checkNotNullParameter(r136, "<this>");     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        return f3.b.f475300n;
    L62:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L80 RuntimeException -> L82 SecurityException -> L84
        goto L64
    L56:
        r130 = true;
    L84:
        e = e;
        r110 = r128;
    L82:
        e = e;
        r110 = r128;
    L80:
        e = e;
        r110 = r128;
        goto L87
    L46:
        r127 = new MediaRecorder();     // Catch: Exception -> L86 RuntimeException -> L88 SecurityException -> L97
        goto L47
    L102:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L35
        Object r140 = Result.m9449constructorimpl(r111.e(r113).a());     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r140) == false) goto L40;
        r140 = null;
    L40:
        r114 = (String) r140;
    L35:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L27:
        File r142 = r211.getExternalCacheDir();
        if (r142 != null) goto L30;
        r142 = r211.getCacheDir();
    L30:
        r113 = new PolarisFileWrapper(r142, "recorder_" + System.currentTimeMillis() + ".m4a");
        goto L31
    L21:
        r111 = null;
        goto L22
    L17:
        r108 = 60000;
        goto L18
    L13:
        r106 = 128000;
        goto L14
    L9:
        r104 = 1;
        goto L10
    L5:
        r101 = 44100;
        goto L6
    }

    public final void j(ByteArrayOutputStream r100, int r110, RandomAccessFile r111) {
    L3:
        if (r100.size() < r110) goto L19;
        byte[] r101 = r100.toByteArray();
        Intrinsics.checkNotNull(r101);
        byte[] r102 = Arrays.copyOf(r101, r110);
        byte[] r103 = ArraysKt.copyOfRange(r101, r110, r101.length);
        r100.reset();
        if (r103.length != 0) goto L7;
        boolean r104 = true;
    L9:
        if ((!r104) == false) goto L11;
        r100.write(r103);
    L11:
        Object r105 = this.f35576b;
        monitor-enter(r105);
        r111.write(r102);     // Catch: Throwable -> L16
        this.f35588n += (long) r102.length;     // Catch: Throwable -> L16
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r105);
        String r107 = Base64.encodeToString(r102, 2);
        JsonObject r108 = new JsonObject();
        r108.addProperty("state", "frameRecorded");
        r108.addProperty("frameBuffer", r107);
        r108.addProperty("isLastFrame", false);
        l(r108);
    L16:
        th = move-exception;
        throw th;
    L7:
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v10, types: [android.media.AudioRecord] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.media.AudioRecord] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.media.AudioRecord] */
    public final f3.a n(AbsOperateRecorderMethodIDL.b r110, Context r111, int r112) {
        Integer r100 = r110.getSampleRate();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        Integer r102 = r110.getNumberOfChannels();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        Integer r104 = r110.getDuration();
        if (r104 == null) goto L13;
        final int r105 = r104.intValue();
    L15:
        if (r112 <= 4096) goto L18;
        g.f37637a.e("AISDK_JSB_RecorderManager", "start failed, frameSize=" + r112 + " KB exceeds maximum 4096 KB");
        f3.a.C5852a r106 = f3.a.f475262c;
        f3.a r107 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        return f3.b.f475300n;
    L18:
        final int r108 = r112 * 1024;
        if (r103 < 2) goto L21;
        int r113 = 12;
    L22:
        if (r113 != 12) goto L24;
        int r109 = 2;
    L25:
        int r114 = AudioRecord.getMinBufferSize(r101, r113, 2);
        if (r114 != (-2)) goto L28;
    L131:
        g.f37637a.e("AISDK_JSB_RecorderManager", "start failed, AudioRecord.getMinBufferSize returned error=" + r114);
        f3.a.C5852a r115 = f3.a.f475262c;
        f3.a r116 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        return f3.b.f475300n;
    L28:
        if (r114 == (-1)) goto L131;
        final int r117 = Math.max(r114, r108);
        ?? r118 = r117;
        AudioRecord r119 = new AudioRecord(1, r101, r113, 2, r118);
        if (r119.getState() == 1) goto L33;
        c(r119);
        g.f37637a.e("AISDK_JSB_RecorderManager", "start failed, AudioRecord failed to initialize");
        f3.a.C5852a r120 = f3.a.f475262c;
        f3.a r121 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        return f3.b.f475300n;
    L33:
        e3.d r122 = this.f35575a.get();
        Unit r123 = null;
        if (r122 == null) goto L36;
        AppletFileManager r124 = x3.a.d(r122);
    L37:
        if (r124 == null) goto L42;
        PolarisFileWrapper r125 = r124.f36579e;
        if (r125.exists() == true) goto L41;
        r125.mkdirs();
    L41:
        PolarisFileWrapper r126 = new PolarisFileWrapper(r125, "recorder_" + System.currentTimeMillis() + Global.SUFFIX_WAV_FILE);
    L46:
        if (r124 != null) goto L156;
        String r127 = null;
    L150:
        final RandomAccessFile r128 = new RandomAccessFile(r126, "rw");     // Catch: Exception -> L112
        r(r128, 44100, 1, 0);     // Catch: Exception -> L109
        if (fna.g.d() == true) goto L61;
        d(r119);     // Catch: Exception -> L109
    L62:
        Object r129 = this.f35576b;     // Catch: Exception -> L109
        monitor-enter(r129);     // Catch: Exception -> L109
        if (this.f35577c != State.STARTING) goto L70;
        AudioRecord r130 = r119;
        this.f35583i = r130;     // Catch: Throwable -> L68
        this.f35585k = r108;     // Catch: Throwable -> L68
        this.f35586l = r101;     // Catch: Throwable -> L68
        this.f35587m = r109;     // Catch: Throwable -> L68
        this.f35581g = r126.getAbsolutePath();     // Catch: Throwable -> L68
        this.f35582h = r127;     // Catch: Throwable -> L68
        this.f35588n = 0;     // Catch: Throwable -> L68
        this.f35577c = State.STARTED;     // Catch: Throwable -> L68
        this.f35579e = System.currentTimeMillis();     // Catch: Throwable -> L68
        boolean r131 = false;
        r118 = r130;
    L71:
        Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L68
        monitor-exit(r129);     // Catch: Exception -> L107
        if (r131 == true) goto L148;
        g.f37637a.i("AISDK_JSB_RecorderManager", "recorder started successfully (AudioRecord), filePath=" + r126.getAbsolutePath());     // Catch: Exception -> L107
        JsonObject r133 = new JsonObject();     // Catch: Exception -> L107
        r133.addProperty("state", "start");     // Catch: Exception -> L107
        l(r133);     // Catch: Exception -> L107
        final ?? r134 = r118;
        PthreadThreadV2 r135 = new PthreadThreadV2(null, new com.bytedance.ai.bridge.method.media.recorder.a(this, r134, r128, r108, r117, r105), "RecorderFrameThread");     // Catch: Exception -> L107
        Object r136 = this.f35576b;     // Catch: Exception -> L107
        monitor-enter(r136);     // Catch: Exception -> L107
        this.f35584j = r135;     // Catch: Throwable -> L99
        monitor-exit(r136);     // Catch: Exception -> L107
        ThreadMethodProxy.start(r135);     // Catch: Exception -> L107
        return null;
    L99:
        th = move-exception;
        throw th;     // Catch: Exception -> L107
    L148:
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L76
        r128.close();     // Catch: Throwable -> L76
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L76
    L135:
        c(r118);     // Catch: Throwable -> L80
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L82:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new RecorderManager$startWithAudioRecord$4(r126, null), 3, null);     // Catch: Exception -> L107
        Object r138 = this.f35576b;     // Catch: Exception -> L107
        monitor-enter(r138);     // Catch: Exception -> L107
    L91:
        th = move-exception;
        throw th;     // Catch: Exception -> L107
    L85:
        if (this.f35577c != State.STOPPING) goto L87;
        this.f35577c = State.IDLE;     // Catch: Throwable -> L91
    L87:
        Unit r139 = Unit.INSTANCE;     // Catch: Throwable -> L91
        monitor-exit(r138);     // Catch: Exception -> L107
        g.f37637a.w("AISDK_JSB_RecorderManager", "start aborted by concurrent stop during initialization (AudioRecord)");     // Catch: Exception -> L107
        f3.a.C5852a r140 = f3.a.f475262c;     // Catch: Exception -> L107
        f3.a r141 = f3.b.f475287a;     // Catch: Exception -> L107
        Intrinsics.checkNotNullParameter(r140, "<this>");     // Catch: Exception -> L107
        return f3.b.f475300n;
    L80:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Exception -> L107
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L107
        goto L82
    L76:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Exception -> L107
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L107
    L68:
        th = th;
    L105:
        monitor-exit(r129);     // Catch: Exception -> L107
        throw th;     // Catch: Exception -> L107
    L70:
        r118 = r119;
        r131 = true;
    L103:
        th = th;
    L107:
        e = e;
    L111:
        Exception r144 = e;
        ?? r145 = r118;
    L144:
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L119
        if (r128 == null) goto L117;
        r128.close();     // Catch: Throwable -> L119
        r123 = Unit.INSTANCE;     // Catch: Throwable -> L119
    L117:
        Result.m9449constructorimpl(r123);     // Catch: Throwable -> L119
    L133:
        c(r145);     // Catch: Throwable -> L123
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L123
    L152:
        Result.m9449constructorimpl(Boolean.valueOf(r126.delete()));     // Catch: Throwable -> L127
    L129:
        g r147 = g.f37637a;
        StringBuilder r148 = new StringBuilder("start failed (AudioRecord), errNo=");
        f3.a.C5852a r149 = f3.a.f475262c;
        f3.a r150 = f3.b.f475287a;
        Intrinsics.checkNotNullParameter(r149, "<this>");
        f3.a r151 = f3.b.f475300n;
        r148.append(r151.f475285a);
        r148.append(", msg=");
        r148.append(r144.getMessage());
        r147.e("AISDK_JSB_RecorderManager", r148.toString());
        Intrinsics.checkNotNullParameter(r149, "<this>");
        return r151;
    L127:
        th = move-exception;
        Result.Companion r152 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L123:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L119:
        th = move-exception;
        Result.Companion r154 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L133
    L61:
        d(r119);     // Catch: Exception -> L109
        hna.a.b(r119.hashCode());     // Catch: Exception -> L109
    L109:
        e = e;
        r118 = r119;
    L112:
        e = move-exception;
        r145 = r119;
        r144 = e;
        r128 = null;
        goto L144
    L156:
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L49
        Object r156 = Result.m9449constructorimpl(r124.e(r126).a());     // Catch: Throwable -> L49
    L52:
        if (Result.m9455isFailureimpl(r156) == false) goto L54;
        r156 = null;
    L54:
        r127 = (String) r156;
    L49:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r156 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L42:
        File r158 = r111.getExternalCacheDir();
        if (r158 != null) goto L45;
        r158 = r111.getCacheDir();
    L45:
        r126 = new PolarisFileWrapper(r158, "recorder_" + System.currentTimeMillis() + Global.SUFFIX_WAV_FILE);
        goto L46
    L36:
        r124 = null;
        goto L37
    L24:
        r109 = 1;
        goto L25
    L21:
        r113 = 16;
        goto L22
    L13:
        r105 = 60000;
        goto L15
    L9:
        r103 = 1;
        goto L10
    L5:
        r101 = 44100;
        goto L6
    }

    public static void r(RandomAccessFile r100, int r110, int r111, long r112) {
        long r101 = ((long) (r110 * r111)) * 2;
        short r102 = (short) (r111 * 2);
        ByteBuffer r103 = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN);
        Charset r104 = Charsets.US_ASCII;
        r103.put("RIFF".getBytes(r104));
        r103.putInt((int) RangesKt.coerceAtMost(((long) 36) + r112, SieveCacheKt.NodeLinkMask));
        r103.put("WAVE".getBytes(r104));
        r103.put("fmt ".getBytes(r104));
        r103.putInt(16);
        r103.putShort(1);
        r103.putShort((short) r111);
        r103.putInt(r110);
        r103.putInt((int) RangesKt.coerceAtMost(r101, SieveCacheKt.NodeLinkMask));
        r103.putShort(r102);
        r103.putShort(16);
        r103.put("data".getBytes(r104));
        r103.putInt((int) RangesKt.coerceAtMost(r112, SieveCacheKt.NodeLinkMask));
        r100.write(r103.array());
    }
}
