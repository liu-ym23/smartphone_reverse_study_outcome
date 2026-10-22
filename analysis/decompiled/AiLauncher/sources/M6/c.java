package M6;

import La.H;
import O6.l;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001w\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0003J)\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ5\u0010%\u001a\u00020\t2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0013¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\t¢\u0006\u0004\b'\u0010\u0003J\u0017\u0010)\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u000bJ\u0017\u0010+\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\t¢\u0006\u0004\b-\u0010\u0003J\r\u0010.\u001a\u00020\t¢\u0006\u0004\b.\u0010\u0003J\r\u0010/\u001a\u00020\t¢\u0006\u0004\b/\u0010\u0003J\r\u00100\u001a\u00020\t¢\u0006\u0004\b0\u0010\u0003J\u001d\u00103\u001a\u00020\t2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\t¢\u0006\u0004\b5\u0010\u0003J\r\u00106\u001a\u00020\t¢\u0006\u0004\b6\u0010\u0003J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u0010\u0003J\r\u00108\u001a\u00020\t¢\u0006\u0004\b8\u0010\u0003J\r\u00109\u001a\u00020\t¢\u0006\u0004\b9\u0010\u0003J\u001f\u0010<\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u00072\b\b\u0002\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0007¢\u0006\u0004\b?\u0010\u000bJ\u0017\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\tH\u0002¢\u0006\u0004\bF\u0010\u0003J\u0017\u0010G\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\u000bJ\u001f\u0010I\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u0013H\u0002¢\u0006\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010LR\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010LR\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010LR\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010LR\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010LR\u0016\u0010a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010LR\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010LR\u0016\u0010c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010LR\u0016\u0010d\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010OR\u0016\u0010e\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010OR\u0014\u0010f\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010WR\u0014\u0010g\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010WR\u0014\u0010h\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010WR\u0014\u0010i\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010WR\u0014\u0010j\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010WR\u0014\u0010k\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010WR\u0014\u0010l\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010WR\u0014\u0010m\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010WR\u0014\u0010n\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010WR\u0014\u0010o\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010WR\u0014\u0010p\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010WR\u0014\u0010q\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010WR\u0014\u0010r\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010WR\u0014\u0010s\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010WR\u001e\u0010u\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006z"}, d2 = {"LM6/c;", "", "<init>", "()V", "", "f", "()Z", "", "extra", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "", "count", "w", "(I)V", "z", "y", "x", "", "hz", "maxHz", "host", "u", "(FFLjava/lang/String;)V", "lpType", "D", "(Ljava/lang/String;I)V", "Landroid/view/View;", Parameters.ROOT, ExifInterface.LONGITUDE_EAST, "(Landroid/view/View;)V", "layerType", "width", "height", "hardwareCanvas", "displayHz", "o", "(IIIZF)V", "p", "reason", "q", "percent", "t", "(Ljava/lang/Integer;)V", "s", "l", "k", "m", "taskId", "status", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "n", "C", "v", "r", "mode", "waitActive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Z)V", "event", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/atomic/AtomicInteger;", "counter", Const.INTENT_KEY_UMID, "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "H", "()Ljava/lang/String;", "G", "e", "sec", "F", "(IF)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "", "TICK_MS", "J", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "active", "Ljava/util/concurrent/atomic/AtomicBoolean;", "waitCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicLong;", "startedAt", "Ljava/util/concurrent/atomic/AtomicLong;", "extraSnapshot", "lastRefreshHz", "lastHalftoneSize", "lastProgress", "lastLayer", "lastHost", "lastDisplayHz", "lastHwCanvas", "lastChatLoading", "liveSinceMs", "thinkMs", "inbound", "inboundSkip", "progressEmit", "progressDrop", "dbWritten", "dbUnchanged", "directPush", "bindRender", "bindSkip", "halftoneDraw", "windowDraw", "sweepFrame", "loadingWaitFrame", "waitFlap", "Ljava/lang/ref/WeakReference;", "windowRootRef", "Ljava/lang/ref/WeakReference;", "M6/c$a", "tick", "LM6/c$a;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String TAG = "TtiPower";
    private static final long TICK_MS = 2000;
    private static volatile long liveSinceMs;
    private static volatile WeakReference<View> windowRootRef;
    public static final c INSTANCE = new c();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean active = new AtomicBoolean(false);
    private static final AtomicInteger waitCount = new AtomicInteger(0);
    private static final AtomicLong startedAt = new AtomicLong(0);
    private static volatile String extraSnapshot = "";
    private static volatile String lastRefreshHz = "?";
    private static volatile String lastHalftoneSize = "?";
    private static volatile String lastProgress = l.DATE_SEPARATOR;
    private static volatile String lastLayer = "?";
    private static volatile String lastHost = "?";
    private static volatile String lastDisplayHz = "?";
    private static volatile String lastHwCanvas = "?";
    private static volatile String lastChatLoading = l.DATE_SEPARATOR;
    private static volatile long thinkMs = -1;
    private static final AtomicInteger inbound = new AtomicInteger();
    private static final AtomicInteger inboundSkip = new AtomicInteger();
    private static final AtomicInteger progressEmit = new AtomicInteger();
    private static final AtomicInteger progressDrop = new AtomicInteger();
    private static final AtomicInteger dbWritten = new AtomicInteger();
    private static final AtomicInteger dbUnchanged = new AtomicInteger();
    private static final AtomicInteger directPush = new AtomicInteger();
    private static final AtomicInteger bindRender = new AtomicInteger();
    private static final AtomicInteger bindSkip = new AtomicInteger();
    private static final AtomicInteger halftoneDraw = new AtomicInteger();
    private static final AtomicInteger windowDraw = new AtomicInteger();
    private static final AtomicInteger sweepFrame = new AtomicInteger();
    private static final AtomicInteger loadingWaitFrame = new AtomicInteger();
    private static final AtomicInteger waitFlap = new AtomicInteger();
    private static final a tick = new a();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"M6/c$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.INSTANCE;
            if (cVar.f()) {
                cVar.e("tick");
                b bVar = b.INSTANCE;
                WeakReference weakReference = c.windowRootRef;
                bVar.f(weakReference != null ? (View) weakReference.get() : null);
                c.handler.postDelayed(this, 2000L);
            }
        }
    }

    public static /* synthetic */ void B(c cVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        cVar.A(str);
    }

    public final void A(String extra) {
        p.i(extra, "extra");
        active.set(true);
        waitCount.set(1);
        G();
        extraSnapshot = extra;
        startedAt.set(SystemClock.elapsedRealtime());
        Handler handler2 = handler;
        a aVar = tick;
        handler2.removeCallbacks(aVar);
        handler2.post(aVar);
        C4148a.k(TAG, "wait 0→1 " + extra + " think=" + H(), false, 4, null);
    }

    public final void C() {
        d(windowDraw);
    }

    public final void D(String host, int lpType) {
        p.i(host, "host");
        if (H.x0(host) || p.d(host, lastHost)) {
            return;
        }
        lastHost = host;
        if (f()) {
            C4148a.k(TAG, "windowHost=" + host + " lpType=" + lpType, false, 4, null);
        }
    }

    public final void E(View root) {
        p.i(root, "root");
        windowRootRef = new WeakReference<>(root);
        b.INSTANCE.g(root);
    }

    public final String F(int count, float sec) {
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(count / C5685n.e(sec, 0.001f))}, 1));
        p.h(str, "format(...)");
        return str;
    }

    public final void G() {
        inbound.set(0);
        inboundSkip.set(0);
        progressEmit.set(0);
        progressDrop.set(0);
        dbWritten.set(0);
        dbUnchanged.set(0);
        directPush.set(0);
        bindRender.set(0);
        bindSkip.set(0);
        halftoneDraw.set(0);
        windowDraw.set(0);
        sweepFrame.set(0);
        loadingWaitFrame.set(0);
        waitFlap.set(0);
        lastProgress = l.DATE_SEPARATOR;
        lastHost = "?";
    }

    public final String H() {
        if (thinkMs < 0) {
            return "?";
        }
        String str = String.format(Locale.US, "%.1fs", Arrays.copyOf(new Object[]{Float.valueOf(thinkMs / 1000.0f)}, 1));
        p.h(str, "format(...)");
        return str;
    }

    public final void d(AtomicInteger counter) {
        if (f()) {
            counter.incrementAndGet();
        }
    }

    public final void e(String reason) {
        float fG = C5685n.g(SystemClock.elapsedRealtime() - startedAt.get(), 1L) / 1000.0f;
        int i10 = windowDraw.get();
        int i11 = halftoneDraw.get();
        int i12 = sweepFrame.get();
        int i13 = loadingWaitFrame.get();
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(fG)}, 1));
        p.h(str, "format(...)");
        C4148a.k(TAG, reason + " elapsed=" + str + "s waitCount=" + waitCount.get() + " hz=" + lastRefreshHz + " host=" + lastHost + " displayHz=" + lastDisplayHz + " layer=" + lastLayer + " hwCanvas=" + lastHwCanvas + " chatLoading=" + lastChatLoading + " halftone=" + lastHalftoneSize + " think=" + H() + " flap=" + waitFlap.get() + " progress=" + lastProgress + " " + extraSnapshot + " | windowDraw=" + i10 + " (" + F(i10, fG) + "/s) halftoneDraw=" + i11 + " (" + F(i11, fG) + "/s) sweep=" + i12 + " (" + F(i12, fG) + "/s) loading=" + i13 + " (" + F(i13, fG) + "/s) bindRender=" + bindRender.get() + " bindSkip=" + bindSkip.get() + " progressEmit=" + progressEmit.get() + " progressDrop=" + progressDrop.get() + " inbound=" + inbound.get() + " inboundSkip=" + inboundSkip.get() + " dbWritten=" + dbWritten.get() + " dbUnchanged=" + dbUnchanged.get() + " push=" + directPush.get(), false, 4, null);
    }

    public final boolean f() {
        return active.get();
    }

    public final void g(String event) {
        p.i(event, "event");
        if (f()) {
            C4148a.k(TAG, event, false, 4, null);
        }
    }

    public final void h(String taskId, String status) {
        p.i(taskId, "taskId");
        p.i(status, "status");
        if (f()) {
            d(bindRender);
            C4148a.k(TAG, "bindRender taskId=" + taskId + " status=" + status, false, 4, null);
        }
    }

    public final void i() {
        d(bindSkip);
    }

    public final void j(String mode, boolean waitActive) {
        p.i(mode, "mode");
        String str = mode + " waitActive=" + (waitActive ? 1 : 0);
        if (p.d(str, lastChatLoading)) {
            return;
        }
        lastChatLoading = str;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (p.d(mode, "live60")) {
            liveSinceMs = jElapsedRealtime;
        } else if (liveSinceMs > 0) {
            thinkMs = jElapsedRealtime - liveSinceMs;
            liveSinceMs = 0L;
        }
        C4148a.k(TAG, "chatLoading=" + str, false, 4, null);
    }

    public final void k() {
        d(dbUnchanged);
    }

    public final void l() {
        d(dbWritten);
    }

    public final void m() {
        d(directPush);
    }

    public final void n() {
        d(halftoneDraw);
    }

    public final void o(int layerType, int width, int height, boolean hardwareCanvas, float displayHz) {
        String str;
        lastHalftoneSize = width + "x" + height;
        lastLayer = layerType != 0 ? layerType != 1 ? layerType != 2 ? String.valueOf(layerType) : "hw" : "sw" : "none";
        lastHwCanvas = hardwareCanvas ? "1" : "0";
        if (displayHz <= 0.0f) {
            str = "?";
        } else {
            str = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(displayHz)}, 1));
            p.h(str, "format(...)");
        }
        lastDisplayHz = str;
    }

    public final void p() {
        d(inbound);
    }

    public final void q(String reason) {
        p.i(reason, "reason");
        if (f() && inboundSkip.incrementAndGet() == 1) {
            C4148a.k(TAG, "inboundSkip=" + reason, false, 4, null);
        }
    }

    public final void r() {
        d(loadingWaitFrame);
    }

    public final void s() {
        d(progressDrop);
    }

    public final void t(Integer percent) {
        d(progressEmit);
        if (percent != null) {
            lastProgress = percent + "%";
        }
    }

    public final void u(float hz, float maxHz, String host) {
        p.i(host, "host");
        lastRefreshHz = (hz <= 0.0f ? "sys" : String.valueOf((int) hz)) + " max=" + (maxHz > 0.0f ? String.valueOf((int) maxHz) : "sys");
        if (!H.x0(host)) {
            lastHost = host;
        }
        if (f()) {
            C4148a.k(TAG, "refreshHz=" + lastRefreshHz + " host=" + lastHost, false, 4, null);
        }
    }

    public final void v() {
        d(sweepFrame);
    }

    public final void w(int count) {
        waitCount.set(count);
        C4148a.k(TAG, "wait count=" + count, false, 4, null);
    }

    public final void x() {
        waitCount.set(0);
        handler.removeCallbacks(tick);
        e("wait 1→0");
        active.set(false);
    }

    public final void y() {
        C4148a.k(TAG, "wait flap n=" + waitFlap.incrementAndGet(), false, 4, null);
    }

    public final void z() {
        waitCount.set(0);
        C4148a.k(TAG, "wait grace", false, 4, null);
    }
}
