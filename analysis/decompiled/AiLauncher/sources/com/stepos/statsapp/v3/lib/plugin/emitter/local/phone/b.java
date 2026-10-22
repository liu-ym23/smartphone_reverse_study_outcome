package com.stepos.statsapp.v3.lib.plugin.emitter.local.phone;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmittableEvent;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterConfig;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterWorker;
import com.stepos.statsapp.v3.lib.plugin.emitter.EventBean;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.NetRequestUtil;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.Utils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class b extends EmitterWorker implements EnvironmentReceiver.IEnvListener {

    /* renamed from: q, reason: collision with root package name */
    private static final String f30695q = "LocalEmitterWorker";

    /* renamed from: a, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.a f30696a;

    /* renamed from: b, reason: collision with root package name */
    private ScheduledExecutorService f30697b;

    /* renamed from: c, reason: collision with root package name */
    private EmitterConfig f30698c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f30699d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f30700e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f30701f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f30702g;

    /* renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList<Long> f30703h;

    /* renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<Long> f30704i;

    /* renamed from: j, reason: collision with root package name */
    private final int f30705j;

    /* renamed from: k, reason: collision with root package name */
    private final int f30706k;

    /* renamed from: l, reason: collision with root package name */
    private final int f30707l;

    /* renamed from: m, reason: collision with root package name */
    private final int f30708m;

    /* renamed from: n, reason: collision with root package name */
    private final int f30709n;

    /* renamed from: o, reason: collision with root package name */
    private final int f30710o;

    /* renamed from: p, reason: collision with root package name */
    private final int f30711p;

    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f30712a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, Context context) {
            super(looper);
            this.f30712a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            b.this.f30696a.a();
            if (!StepOSUtils.bootWizardIsCompleted(this.f30712a)) {
                Logger.d(b.f30695q, "EmitterWorker NORMASEND --> 还未完成开机向导");
                return;
            }
            if (!NetInfoUtils.isOnline(this.f30712a)) {
                Logger.d(b.f30695q, "EmitterWorker NORMASEND no network");
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                ArrayList<EmittableEvent> arrayListC = b.this.f30696a.c();
                if (arrayListC.size() >= 6) {
                    b.this.a(arrayListC);
                    Logger.d(b.f30695q, "EmitterWorker NORMASEND_" + message.what);
                }
            } else if (i10 == 2) {
                if (b.this.a()) {
                    b.this.a(b.this.f30696a.c());
                    Logger.d(b.f30695q, "EmitterWorker NORMASEND_" + message.what);
                }
            } else if (i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6) {
                b.this.a(b.this.f30696a.c());
                Logger.d(b.f30695q, "EmitterWorker NORMASEND_" + message.what);
            }
            b.this.f30700e.removeMessages(5);
            if (b.this.f30698c.getFlushDelayInterval() > 0) {
                b.this.f30700e.sendEmptyMessageDelayed(5, b.this.f30698c.getFlushDelayInterval());
            }
        }
    }

    /* renamed from: com.stepos.statsapp.v3.lib.plugin.emitter.local.phone.b$b, reason: collision with other inner class name */
    public class HandlerC0366b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f30714a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0366b(Looper looper, Context context) {
            super(looper);
            this.f30714a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            TrackerPayload payload;
            if (!StepOSUtils.bootWizardIsCompleted(this.f30714a)) {
                Logger.d(b.f30695q, "EmitterWorker NEARTIME SEND --> 还未完成开机向导");
                return;
            }
            if (message.what == 1) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = b.this.f30704i.iterator();
                while (it.hasNext()) {
                    Long l10 = (Long) it.next();
                    long jLongValue = l10.longValue();
                    EventBean eventBeanA = b.this.f30696a.a(jLongValue);
                    if (eventBeanA != null && (payload = EventBean.toPayload(eventBeanA)) != null) {
                        arrayList.add(new EmittableEvent("", jLongValue, payload));
                        arrayList2.add(l10);
                    }
                }
                b.this.b(arrayList, false, UxipConstants.f30671j);
                b.this.f30704i.removeAll(arrayList2);
                Logger.d(b.f30695q, "EmitterWorker NEARTIME SEND");
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f30698c.isFlushOnStart()) {
                b.this.f30700e.sendEmptyMessage(1);
            }
            if (b.this.f30698c.getFlushDelayInterval() > 0) {
                b.this.f30700e.sendEmptyMessageDelayed(5, b.this.f30698c.getFlushDelayInterval());
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmitterConfig f30717a;

        public d(EmitterConfig emitterConfig) {
            this.f30717a = emitterConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f30698c = this.f30717a;
            b.this.f30700e.removeMessages(5);
            if (b.this.f30698c.getFlushDelayInterval() > 0) {
                b.this.f30700e.sendEmptyMessageDelayed(5, b.this.f30698c.getFlushDelayInterval());
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrackerPayload f30719a;

        public e(TrackerPayload trackerPayload) {
            this.f30719a = trackerPayload;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f30696a.a(this.f30719a);
            b.this.f30700e.sendEmptyMessage(2);
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrackerPayload f30721a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Iterator it = b.this.f30703h.iterator();
                while (it.hasNext()) {
                    Long l10 = (Long) it.next();
                    long jLongValue = l10.longValue();
                    ArrayList arrayList = new ArrayList();
                    EventBean eventBeanA = b.this.f30696a.a(jLongValue);
                    if (eventBeanA != null) {
                        arrayList.add(new EmittableEvent("", eventBeanA.getId(), f.this.f30721a));
                        Logger.d(b.f30695q, "realtime send");
                        b.this.b(arrayList, false, UxipConstants.f30671j);
                        b.this.f30703h.remove(l10);
                    }
                }
            }
        }

        public f(TrackerPayload trackerPayload) {
            this.f30721a = trackerPayload;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jA = b.this.f30696a.a(this.f30721a);
            b.this.f30703h.add(Long.valueOf(jA));
            Logger.d(b.f30695q, "insert realtime event id:" + jA);
            if (StepOSUtils.bootWizardIsCompleted(((EmitterWorker) b.this).context)) {
                b.this.f30701f.post(new a());
            } else {
                Logger.d(b.f30695q, "EmitterWorker REALTIME SEND --> 还未完成开机向导");
            }
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TrackerPayload f30724a;

        public g(TrackerPayload trackerPayload) {
            this.f30724a = trackerPayload;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f30704i.add(Long.valueOf(b.this.f30696a.a(this.f30724a)));
            if (b.this.f30702g.hasMessages(1)) {
                return;
            }
            b.this.f30702g.sendEmptyMessageDelayed(1, b.this.f30698c.getNeartimeInterval() * 1000);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f30700e.sendEmptyMessage(6);
        }
    }

    public b(Context context, EmitterConfig emitterConfig) {
        super(context);
        this.f30705j = 1;
        this.f30706k = 2;
        this.f30707l = 3;
        this.f30708m = 4;
        this.f30709n = 5;
        this.f30710o = 6;
        this.f30711p = 1;
        this.f30698c = emitterConfig;
        this.f30697b = Executors.newScheduledThreadPool(1);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f30696a = new com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.a(context);
        Logger.d(f30695q, "##### LocalEmitterWorker, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f30699d = new AtomicBoolean(false);
        this.f30703h = new CopyOnWriteArrayList<>(new ArrayList());
        this.f30704i = new CopyOnWriteArrayList<>(new ArrayList());
        HandlerThread handlerThread = new HandlerThread("LocalEmitterWorker.normaSend");
        handlerThread.start();
        this.f30700e = new a(handlerThread.getLooper(), context);
        HandlerThread handlerThread2 = new HandlerThread("LocalEmitterWorker.realtimeSend");
        handlerThread2.start();
        this.f30701f = new Handler(handlerThread2.getLooper());
        HandlerThread handlerThread3 = new HandlerThread("LocalEmitterWorker.neartimeSend");
        handlerThread3.start();
        this.f30702g = new HandlerC0366b(handlerThread3.getLooper(), context);
        EnvironmentReceiver.getInstance(context).addEnvListener(this);
        d();
        Logger.d(f30695q, "##### LocalEmitterWorker 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver.IEnvListener
    public void environmentChanged(String str) {
        Logger.d(f30695q, "environmentChanged. changeName: " + str);
        if (EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT.equals(str)) {
            if (this.f30698c.isFlushOnReconnect()) {
                this.f30700e.sendEmptyMessage(3);
            }
        } else if (EnvironmentReceiver.CHANGE_NAME_POWER.equals(str) && this.f30698c.isFlushOnCharge()) {
            this.f30700e.sendEmptyMessage(4);
        }
    }

    private void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jE = this.f30696a.e();
        long jAbs = Math.abs(jCurrentTimeMillis - jE);
        Logger.d(f30695q, "beforeFlush ------------------ now:" + jCurrentTimeMillis + ", lastResetTime:" + jE + ", intervalTime:" + jAbs + ", resetTrafficInterval:86400000");
        if (jAbs >= 86400000) {
            Logger.d(f30695q, "do reset traffic");
            this.f30696a.a(0);
            this.f30696a.c(jCurrentTimeMillis);
        }
    }

    public void b(TrackerPayload trackerPayload) {
        this.f30697b.execute(new g(trackerPayload));
    }

    public void c() {
        Logger.d(f30695q, "EmitterWorker init");
        this.f30697b.execute(new c());
    }

    public void b() {
        this.f30697b.execute(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<EmittableEvent> arrayList, boolean z10, String str) throws Throwable {
        if (this.f30699d.compareAndSet(false, true)) {
            a(arrayList, z10, str);
            this.f30699d.compareAndSet(true, false);
        }
    }

    public void c(TrackerPayload trackerPayload) {
        this.f30697b.execute(new f(trackerPayload));
    }

    public void a(EmitterConfig emitterConfig) {
        this.f30697b.execute(new d(emitterConfig));
    }

    public void a(TrackerPayload trackerPayload) {
        this.f30697b.execute(new e(trackerPayload));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<EmittableEvent> arrayList) throws Throwable {
        Iterator<EmittableEvent> it = arrayList.iterator();
        while (it.hasNext()) {
            EmittableEvent next = it.next();
            if (this.f30703h.contains(Long.valueOf(next.getId())) || this.f30704i.contains(Long.valueOf(next.getId()))) {
                it.remove();
            }
        }
        Logger.d(f30695q, "normalSend");
        b(arrayList, true, UxipConstants.f30670i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.util.ArrayList<com.stepos.statsapp.v3.lib.plugin.emitter.EmittableEvent> r12, boolean r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsapp.v3.lib.plugin.emitter.local.phone.b.a(java.util.ArrayList, boolean, java.lang.String):void");
    }

    private String a(String str, byte[] bArr) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        HashMap map = new HashMap();
        String md5 = Utils.getMD5(bArr);
        builderBuildUpon.appendQueryParameter(Parameters.UPLOAD_REQUEST_PARAM_MD5, md5);
        map.put(Parameters.UPLOAD_REQUEST_PARAM_MD5, md5);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strValueOf = String.valueOf(jCurrentTimeMillis);
        builderBuildUpon.appendQueryParameter("ts", strValueOf);
        String strValueOf2 = String.valueOf(jCurrentTimeMillis + new Random().nextInt());
        builderBuildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_NONCE, strValueOf2);
        map.put("ts", strValueOf);
        map.put(Parameters.UXIP_REQUEST_PARAM_NONCE, strValueOf2);
        builderBuildUpon.appendQueryParameter(Parameters.UXIP_REQUEST_PARAM_SIGN, NetRequestUtil.sign("POST", str, map, null));
        return builderBuildUpon.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        long jA = this.f30696a.a((String) null);
        int flushCacheLimit = this.f30698c.getFlushCacheLimit();
        Logger.d(f30695q, "cacheCheck ------------------ eventSize:" + jA + ", flushCacheLimit:" + flushCacheLimit);
        return jA >= ((long) flushCacheLimit);
    }

    private boolean a(byte[] bArr) {
        int length = bArr.length;
        Logger.d(f30695q, "mobileTrafficCheck ------------------ flushSize:" + length);
        if (length == 0) {
            Logger.d(f30695q, "Not flushing data to Server because no flush data");
            return false;
        }
        boolean zIsWiFiWorking = NetInfoUtils.isWiFiWorking(this.context);
        int iF = this.f30696a.f();
        long flushMobileTrafficLimit = this.f30698c.getFlushMobileTrafficLimit();
        Logger.d(f30695q, "mobileTrafficCheck ------------------ isWifi:" + zIsWiFiWorking + ", currentTraffic:" + iF + ", mobileTrafficLimit:" + flushMobileTrafficLimit);
        if (zIsWiFiWorking) {
            Logger.d(f30695q, "flushing data to server in WiFi mode");
        } else {
            if (flushMobileTrafficLimit < 0) {
                return true;
            }
            int i10 = iF + length;
            if (i10 > flushMobileTrafficLimit) {
                Logger.d(f30695q, "Not flushing data to server because exceed mobileTrafficLimit");
                return false;
            }
            this.f30696a.a(i10);
            Logger.d(f30695q, "flushing data to server currentTraffic:" + iF + ", flushSize:" + length);
        }
        return true;
    }

    public boolean a(String str, String str2) {
        return this.f30696a.b(str, str2);
    }

    public void a(boolean z10) {
        this.f30696a.a(z10);
    }
}
