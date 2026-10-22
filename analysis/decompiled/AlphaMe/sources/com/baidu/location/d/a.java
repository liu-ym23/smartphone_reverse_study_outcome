package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.aa;
import com.baidu.location.b.ab;
import com.baidu.location.b.b;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import com.baidu.location.b.l;
import com.baidu.location.b.p;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.b.z;
import com.baidu.location.c.d;
import com.baidu.location.e.h;
import com.baidu.location.f;
import com.baidu.mshield.x6.EngineImpl;
import com.stepos.activeview.utils.Constants;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class a extends Service implements LLSInterface {

    /* renamed from: a, reason: collision with root package name */
    static HandlerC0013a f5762a;

    /* renamed from: c, reason: collision with root package name */
    public static long f5763c;

    /* renamed from: g, reason: collision with root package name */
    private static long f5764g;

    /* renamed from: b, reason: collision with root package name */
    Messenger f5765b = null;

    /* renamed from: d, reason: collision with root package name */
    private Looper f5766d = null;

    /* renamed from: e, reason: collision with root package name */
    private HandlerThread f5767e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5768f = true;

    /* renamed from: h, reason: collision with root package name */
    private int f5769h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5770i = true;

    /* renamed from: com.baidu.location.d.a$a, reason: collision with other inner class name */
    public static class HandlerC0013a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f5773a;

        public HandlerC0013a(Looper looper, a aVar) {
            super(looper);
            this.f5773a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f5773a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i4 = message.what;
                if (i4 == 11) {
                    aVar.a(message);
                } else if (i4 == 12) {
                    aVar.b(message);
                } else if (i4 == 15) {
                    aVar.c(message);
                } else if (i4 == 22) {
                    p.c().b(message);
                } else if (i4 == 41) {
                    p.c().i();
                } else if (i4 == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i4 == 406) {
                    k.a().e();
                } else if (i4 == 705) {
                    b.a().a(message.getData().getBoolean("foreground"));
                }
            }
            if (message.what == 1) {
                aVar.b();
            }
            if (message.what == 0) {
                aVar.a();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d.a().e();
        aa.a().f();
        com.baidu.location.c.f.a().d();
        p.c().e();
        k.a().c();
        if (this.f5770i) {
            z.d();
        }
        b.a().b();
        try {
            x.a().d();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f5769h = 4;
        if (this.f5768f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        b.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 9.642999649047852d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        String string;
        String string2;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.e.b.f5801h = extras.getString(Action.KEY_ATTRIBUTE);
            com.baidu.location.e.b.f5800g = extras.getString(Constants.PARAM_SIGN);
            this.f5768f = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
            string = extras.getString("auth_key");
            string2 = extras.getString(EngineImpl.KEY_CUID);
            h.aZ = extras.getString("proxyHost");
            h.ba = extras.getInt("proxyPort");
            h.bb = extras.getString("username");
            h.bc = extras.getString("password");
        } else {
            string = null;
            string2 = null;
        }
        if (string != null) {
            com.baidu.location.a.a.a().a(f.getServiceContext(), string);
        }
        if (!TextUtils.isEmpty(h.aZ) && h.ba != -1) {
            LBSAuthManager.getInstance(f.getServiceContext()).setProxy(h.aZ, h.ba);
        }
        if (!TextUtils.isEmpty(h.bb) && !TextUtils.isEmpty(h.bc)) {
            LBSAuthManager.getInstance(f.getServiceContext()).setHttpProxyUsernameAndPassword(h.bb, h.bc);
        }
        com.baidu.location.a.a.a().a(f.getServiceContext());
        com.baidu.location.e.b.a().a(string2);
        return this.f5765b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) throws IOException {
        ab.a().a(context);
        LBSAuthManager.getInstance(f.getServiceContext()).setPrivacyMode(true);
        try {
            h.aw = context.getPackageName();
        } catch (Exception unused) {
        }
        f5764g = System.currentTimeMillis();
        HandlerThread handlerThreadA = w.a();
        this.f5767e = handlerThreadA;
        if (handlerThreadA != null) {
            this.f5766d = handlerThreadA.getLooper();
        }
        f5762a = this.f5766d == null ? new HandlerC0013a(Looper.getMainLooper(), this) : new HandlerC0013a(this.f5766d, this);
        f5763c = System.currentTimeMillis();
        this.f5765b = new Messenger(f5762a);
        f5762a.sendEmptyMessage(0);
        this.f5769h = 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f5762a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.f5770i = false;
            b();
            Process.killProcess(Process.myPid());
        }
        this.f5769h = 3;
        Handler handler = new Handler(Looper.getMainLooper());
        final WeakReference weakReference = new WeakReference(this);
        handler.postDelayed(new Runnable() { // from class: com.baidu.location.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = (a) weakReference.get();
                if (aVar == null || aVar.f5769h != 3) {
                    return;
                }
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.f5770i = false;
                aVar.b();
            }
        }, 1000L);
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i4, int i5) {
        return 2;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.location.e.a.a.a().b();
        com.baidu.location.e.b.a();
        e.a().a(f.getServiceContext());
        c.b().b(false);
        c.b().c();
        try {
            aa.a().e();
        } catch (Exception unused) {
        }
        l.a().a(f.getServiceContext());
        k.a().b();
        d.a().b();
        com.baidu.location.c.f.a().b();
        com.baidu.location.c.f.a().a(f.getServiceContext());
        p.c().d();
        this.f5769h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        b.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        b.a().a(message);
    }
}
