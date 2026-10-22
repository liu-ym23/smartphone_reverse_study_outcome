package com.bytedance.android.annie.bridge.method.audio;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "不支持 LLM 能力，请使用 AsrCoreWithLLM 代替")
public final class a implements Handler.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final WeakHashMap<View, a> f38544k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSBridgeManager f38545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0724a f38546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CallContext f38547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f38548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.annie.bridge.method.audio.c f38549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PthreadHandlerThreadV2 f38550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f38551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f38552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f38553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f38554j;

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.audio.a$a, reason: collision with other inner class name */
    public interface InterfaceC0724a {
        void d(boolean r100);
    }

    public static final class b {
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d implements com.bytedance.android.annie.bridge.method.audio.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f38555a;

        public d(a r100) {
            this.f38555a = r100;
        }

        @Override // com.bytedance.android.annie.bridge.method.audio.c.b
        public final void a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "pcmData");
            Handler r101 = this.f38555a.f38551g;
            if (r101 == null) goto L6;
            r101.sendMessage(r101.obtainMessage(104, r100));
            return;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f38556a;

        public e(a r100) {
            this.f38556a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0724a r100 = this.f38556a.f38546b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.d(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        f38544k = new WeakHashMap();
    }

    public final void b() {
        AndroidSchedulers.mainThread().scheduleDirect(new e(this));
        if (this.f38549e != null) goto L5;
        com.bytedance.android.annie.bridge.method.audio.c r100 = new com.bytedance.android.annie.bridge.method.audio.c();
        r100.f38561d = this.f38553i;
        this.f38549e = r100;
        a("init audio recorder");
        Unit r101 = Unit.INSTANCE;
    L5:
        com.bytedance.android.annie.bridge.method.audio.c r102 = this.f38549e;
        if (r102 == null) goto L23;
        AudioRecord r103 = r102.f38560c;     // Catch: IllegalStateException -> L17
        if (r103 != null) goto L10;
    L13:
        r102.f38563f = 2;     // Catch: IllegalStateException -> L17
        Handler r104 = r102.f38562e;     // Catch: IllegalStateException -> L17
        if (r104 == null) goto L19;
        r104.post(r102.f38564g);     // Catch: IllegalStateException -> L17
    L19:
        a("start audio recorder");
        return;
    L10:
        if (g.d() == true) goto L12;
        com.bytedance.android.annie.bridge.method.audio.c.b(r103);     // Catch: IllegalStateException -> L17
        goto L13
    L12:
        com.bytedance.android.annie.bridge.method.audio.c.b(r103);     // Catch: IllegalStateException -> L17
        hna.a.b(r103.hashCode());     // Catch: IllegalStateException -> L17
    L17:
        e = move-exception;
        b8.a r105 = b8.a.f17992a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Start Record Exception: " + e.getMessage()), true);
        goto L19
    }

    public final CallContext getContext() {
        return this.f38547c;
    }

    public static void a(String r100) {
        b8.a r101 = b8.a.f17992a;
        b8.a.d(new b8.b("AsrCore", LogLevel.DEBUG, null, r100));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        switch(r110.what) {
            case 103: goto L48;
            case 104: goto L71;
            case 105: goto L5;
            default: goto L70;
        };
    L5:
        a("=========clear======");
        a("stop record");
        com.bytedance.android.annie.bridge.method.audio.c r100 = this.f38549e;
        if (r100 != null) goto L79;
    L24:
        this.f38549e = null;
        a("=========destroyHandle======");
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L27
        CallContext r101 = this.f38547c;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L27
        ((a9.d) Annie.getService(a9.d.class, r101.a())).H();     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L32;
        b8.a r102 = b8.a.f17992a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r113, "Failed to destroyHandle: IAnnieBridgeAsrService not implemented in host"), true);
    L32:
        PthreadHandlerThreadV2 r114 = this.f38550f;
        if (r114 == null) goto L35;
        r114.quit();
    L35:
        this.f38550f = null;
        this.f38551g = null;
        CallContext r115 = this.f38547c;
        if (r115 == null) goto L40;
        View r116 = r115.f249269d;
        if (r116 == null) goto L40;
        a("========remove instance======");
        f38544k.remove(r116);
    L40:
        this.f38547c = null;
        this.f38546b = null;
    L27:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L79:
        AudioRecord r104 = r100.f38560c;     // Catch: IllegalStateException -> L15
        if (r104 != null) goto L10;
    L13:
        r100.f38563f = 1;     // Catch: IllegalStateException -> L15
    L17:
        r100.f38561d = null;
        AudioRecord r105 = r100.f38560c;     // Catch: IllegalStateException -> L22
        if (r105 == null) goto L24;
        com.bytedance.android.annie.bridge.method.audio.c.a(r105);     // Catch: IllegalStateException -> L22
    L22:
        e = move-exception;
        b8.a r106 = b8.a.f17992a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Release Record Exception: " + e.getMessage()), true);
        goto L24
    L10:
        if (g.d() == true) goto L12;
        com.bytedance.android.annie.bridge.method.audio.c.c(r104);     // Catch: IllegalStateException -> L15
        goto L13
    L12:
        com.bytedance.android.annie.bridge.method.audio.c.c(r104);     // Catch: IllegalStateException -> L15
        hna.a.c(r104.hashCode());     // Catch: IllegalStateException -> L15
    L15:
        e = move-exception;
        b8.a r107 = b8.a.f17992a;
        b8.a.a(new b8.b("AudioRecorder", LogLevel.ERROR, e, "Stop Record Exception: " + e.getMessage()), true);
        goto L17
    L48:
        a("createHandle connectState: " + this.f38552h.get());
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L65
        this.f38552h.compareAndSet(0, 1);     // Catch: Throwable -> L65
        String r118 = this.f38548d;     // Catch: Throwable -> L65
        if (r118 != null) goto L52;
    L55:
        boolean r119 = true;
    L56:
        if (r119 == true) goto L58;
        String r120 = this.f38548d;     // Catch: Throwable -> L65
        Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L65
    L59:
        CallContext r108 = this.f38547c;     // Catch: Throwable -> L65
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L65
        if (((a9.d) Annie.getService(a9.d.class, r108.a())).t0(r120, this.f38554j) == false) goto L62;
        b();     // Catch: Throwable -> L65
    L63:
        Object r121 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L67:
        Throwable r122 = Result.m9452exceptionOrNullimpl(r121);
        if (r122 == null) goto L70;
        b8.a r109 = b8.a.f17992a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r122, "Failed to createHandle: IAnnieBridgeAsrService not implemented in host"), true);
        this.f38552h.set(0);
        AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.annie.bridge.method.audio.b(this));
        goto L70
    L62:
        this.f38552h.set(0);     // Catch: Throwable -> L65
        AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.annie.bridge.method.audio.b(this));     // Catch: Throwable -> L65
        goto L63
    L58:
        r120 = "KHBEDXeGDw";
        goto L59
    L52:
        if (r118.length() == 0) goto L55;
        r119 = false;
    L65:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L70:
        return false;
    L71:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L43
        CallContext r125 = this.f38547c;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r125);     // Catch: Throwable -> L43
        a9.d r126 = (a9.d) Annie.getService(a9.d.class, r125.a());     // Catch: Throwable -> L43
        Object r127 = r110.obj;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r127, "null cannot be cast to non-null type kotlin.ByteArray");     // Catch: Throwable -> L43
        r126.Y0((byte[]) r127);     // Catch: Throwable -> L43
        Object r128 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L70;
        b8.a r130 = b8.a.f17992a;
        b8.a.a(new b8.b("AsrCore", LogLevel.ERROR, r129, "Failed to process audio: IAnnieBridgeAsrService not implemented in host"), true);
    L43:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    }

    public a(JSBridgeManager r100, InterfaceC0724a r101, CallContext r102, String r103, int r104, int r105, int r106) {
        this.f38545a = r100;
        this.f38546b = r101;
        this.f38547c = r102;
        this.f38548d = r103;
        this.f38552h = new AtomicInteger(0);
        this.f38553i = new d(this);
        this.f38554j = new c();
    }
}
