package com.stepos.statsrpk.service;

import android.content.Context;
import android.net.Uri;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.emitter.EmitterWorker;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.NetRequestUtil;
import com.stepos.statsapp.v3.lib.plugin.utils.Utils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class a extends EmitterWorker implements EnvironmentReceiver.IEnvListener {

    /* renamed from: t, reason: collision with root package name */
    public static final String f31067t = "a";

    /* renamed from: r, reason: collision with root package name */
    public M7.a f31068r;

    /* renamed from: s, reason: collision with root package name */
    public ScheduledExecutorService f31069s;

    /* renamed from: com.stepos.statsrpk.service.a$a, reason: collision with other inner class name */
    public class RunnableC0375a implements Runnable {
        public RunnableC0375a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.e();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31071a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f31072b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TrackerPayload f31073c;

        public b(String str, String str2, TrackerPayload trackerPayload) {
            this.f31071a = str;
            this.f31072b = str2;
            this.f31073c = trackerPayload;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.m(this.f31071a, this.f31072b, this.f31073c);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31075a;

        public c(String str) {
            this.f31075a = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.l(this.f31075a);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            a.this.e();
        }
    }

    public a(Context context, int i10) {
        super(context);
        this.f31069s = Executors.newScheduledThreadPool(i10);
        this.f31068r = new M7.a(context);
        EnvironmentReceiver.getInstance(context).addEnvListener(this);
        this.f31069s.schedule(new RunnableC0375a(), Z5.b.IDLE_AGENT_PERIOD, TimeUnit.MILLISECONDS);
    }

    public final String a(String str, byte[] bArr) {
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

    public final void e() throws Throwable {
        Logger.d(f31067t, "flushQueueInternalByTimer");
        for (String str : this.f31068r.i()) {
            this.f31068r.f();
            j(str, this.f31068r.c(str));
        }
        this.f31069s.schedule(new d(), Z5.b.IDLE_AGENT_PERIOD, TimeUnit.MILLISECONDS);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver.IEnvListener
    public void environmentChanged(String str) {
        this.f31069s.execute(new c(str));
    }

    public void i(String str, String str2, TrackerPayload trackerPayload) {
        this.f31069s.execute(new b(str, str2, trackerPayload));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.String r10, java.util.ArrayList<com.stepos.statsapp.v3.lib.plugin.emitter.EmittableEvent> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.statsrpk.service.a.j(java.lang.String, java.util.ArrayList):void");
    }

    public final boolean k(String str) {
        long jH = this.f31068r.h(str);
        boolean zIsOnline = NetInfoUtils.isOnline(this.context);
        Logger.d(f31067t, "cacheCheck appKey:" + str + " ------------------ eventSize:" + jH + ", flushCacheLimit:5, networkAvailable:" + zIsOnline);
        return jH >= ((long) 5) && zIsOnline;
    }

    public final void l(String str) throws Throwable {
        Logger.d(f31067t, "environmentChanged. changeName: " + str);
        List<String> listI = this.f31068r.i();
        if (EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT.equals(str)) {
            Iterator<String> it = listI.iterator();
            while (it.hasNext()) {
                n(it.next());
            }
        } else if (EnvironmentReceiver.CHANGE_NAME_POWER.equals(str)) {
            Iterator<String> it2 = listI.iterator();
            while (it2.hasNext()) {
                n(it2.next());
            }
        }
    }

    public final void m(String str, String str2, TrackerPayload trackerPayload) throws Throwable {
        if (str == null || trackerPayload == null) {
            return;
        }
        Logger.d(f31067t, "Queuing event for sending later, appKey:" + str + ", payload:" + trackerPayload);
        this.f31068r.f();
        if (this.f31068r.b(str, str2, trackerPayload) <= 0 || !k(str)) {
            return;
        }
        j(str, this.f31068r.c(str));
    }

    public final void n(String str) throws Throwable {
        Logger.d(f31067t, "flushQueueInternalWhenEnvChanged, appKey: " + str);
        this.f31068r.f();
        j(str, this.f31068r.c(str));
    }
}
