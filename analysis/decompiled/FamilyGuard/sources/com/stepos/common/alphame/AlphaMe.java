package com.stepos.common.alphame;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.LongSparseArray;
import java.util.ArrayList;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class AlphaMe {

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<e> f13537a;

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<b> f13538b;

    /* renamed from: c, reason: collision with root package name */
    private final LongSparseArray<b> f13539c;

    /* renamed from: d, reason: collision with root package name */
    private IAlphaMe f13540d;

    /* renamed from: e, reason: collision with root package name */
    private AlphaMeClient f13541e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f13542f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f13543g;

    private class AlphaMeClient extends AlphaMeClientNative {
        private AlphaMeClient() {
        }

        @Override // com.stepos.common.alphame.IAlphaMeClient
        public void onReceiver(com.stepos.common.alphame.a aVar) {
            if (aVar.A()) {
                Log.e("AlphaMe", "onReceiver return empty value");
                return;
            }
            String str = (String) aVar.f()[0];
            Object obj = aVar.f()[1];
            b bVarO = AlphaMe.this.o(((Integer) aVar.f()[2]).intValue());
            if (bVarO != null) {
                bVarO.d(str, obj);
            }
        }

        @Override // com.stepos.common.alphame.IAlphaMeClient
        public void onResult(com.stepos.common.alphame.a aVar) {
            if (aVar.A()) {
                Log.e("AlphaMe", "onResult return empty value");
                return;
            }
            Object obj = aVar.f()[0];
            int iIntValue = ((Integer) aVar.f()[1]).intValue();
            e eVarQ = AlphaMe.this.q(iIntValue);
            if (eVarQ != null) {
                eVarQ.c(obj);
                AlphaMe.this.v(iIntValue);
            }
        }

        /* synthetic */ AlphaMeClient(AlphaMe alphaMe, a aVar) {
            this();
        }
    }

    class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        int f13544a;

        a(Looper looper) {
            super(looper);
            this.f13544a = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (this) {
                if (message.what == 0) {
                    synchronized (AlphaMe.this.f13539c) {
                        if (AlphaMe.this.f13539c.size() == 0) {
                            return;
                        }
                        Log.w("AlphaMe", "Client handle binder died ");
                        for (int i5 = 0; i5 < AlphaMe.this.f13539c.size(); i5++) {
                            AlphaMe alphaMe = AlphaMe.this;
                            alphaMe.t((b) alphaMe.f13539c.valueAt(i5));
                        }
                        if (AlphaMe.this.f13542f) {
                            this.f13544a = 0;
                            AlphaMe.this.f13539c.clear();
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("mRetryCount = ");
                            int i6 = this.f13544a + 1;
                            this.f13544a = i6;
                            sb.append(i6);
                            Log.w("AlphaMe", sb.toString());
                            if (this.f13544a <= 30) {
                                AlphaMe.this.f13543g.removeMessages(0);
                                AlphaMe.this.f13543g.sendEmptyMessageDelayed(0, 500L);
                            } else {
                                Log.e("AlphaMe", "Restore actions fail, size = " + AlphaMe.this.f13539c.size());
                                AlphaMe.this.f13539c.clear();
                                this.f13544a = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public static abstract class b extends com.stepos.common.alphame.b {

        /* renamed from: c, reason: collision with root package name */
        private ArrayList<String> f13546c = new ArrayList<>();

        @Override // com.stepos.common.alphame.b
        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        public abstract void d(String str, Object obj);
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static AlphaMe f13547a = new AlphaMe(null);
    }

    private static class d extends e {

        /* renamed from: c, reason: collision with root package name */
        private Object f13548c;

        private d() {
        }

        @Override // com.stepos.common.alphame.AlphaMe.e
        public void c(Object obj) {
            this.f13548c = obj;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static abstract class e extends com.stepos.common.alphame.b {
        @Override // com.stepos.common.alphame.b
        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        public abstract void c(Object obj);
    }

    private final class f implements IBinder.DeathRecipient {
        private f() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (AlphaMe.this) {
                AlphaMe.this.f13540d.asBinder().unlinkToDeath(this, 0);
                AlphaMe.this.f13540d = null;
                AlphaMe.this.f13542f = false;
                AlphaMe.this.f13537a.clear();
                synchronized (AlphaMe.this.f13538b) {
                    try {
                        if (AlphaMe.this.f13543g != null && AlphaMe.this.f13538b.size() >= 0) {
                            for (int i5 = 0; i5 < AlphaMe.this.f13538b.size(); i5++) {
                                AlphaMe.this.f13539c.put(((b) AlphaMe.this.f13538b.valueAt(i5)).a(), (b) AlphaMe.this.f13538b.valueAt(i5));
                            }
                            AlphaMe.this.f13543g.removeMessages(0);
                            AlphaMe.this.f13543g.sendEmptyMessageDelayed(0, 500L);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                AlphaMe.this.f13538b.clear();
            }
        }

        /* synthetic */ f(AlphaMe alphaMe, a aVar) {
            this();
        }
    }

    /* synthetic */ AlphaMe(a aVar) {
        this();
    }

    private boolean l(b bVar) {
        synchronized (this) {
            try {
                if (this.f13538b.size() <= 24) {
                    this.f13538b.put(bVar.a(), bVar);
                    return true;
                }
                Log.e("AlphaMe", "Register too many receivers");
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean m(e eVar) {
        synchronized (this) {
            try {
                if (this.f13537a.size() <= 32) {
                    this.f13537a.put(eVar.a(), eVar);
                    return true;
                }
                Log.e("AlphaMe", "Invoke too much");
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n(e eVar, boolean z5, String str, Object... objArr) {
        r();
        if (this.f13542f) {
            try {
                if (m(eVar)) {
                    this.f13540d.exec(this.f13541e.asBinder(), str, new com.stepos.common.alphame.a(objArr), z5 ? 1 : 0, eVar.a());
                }
            } catch (Exception e6) {
                Log.e("AlphaMe", "Execute exception " + e6.getMessage());
                v(eVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b o(int i5) {
        b bVar;
        synchronized (this) {
            bVar = this.f13538b.get(i5);
        }
        return bVar;
    }

    public static AlphaMe p() {
        return c.f13547a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e q(int i5) {
        e eVar;
        synchronized (this) {
            eVar = this.f13537a.get(i5);
        }
        return eVar;
    }

    private void r() {
        synchronized (this) {
            try {
                if (!this.f13542f) {
                    if (this.f13540d == null) {
                        this.f13540d = AlphaMeNative.asInterface(com.stepos.common.alphame.c.a("alphame_server"));
                    }
                    IAlphaMe iAlphaMe = this.f13540d;
                    if (iAlphaMe == null) {
                        Log.e("AlphaMe", String.format("Can't find %s", "alphame_server"));
                        return;
                    }
                    try {
                        a aVar = null;
                        iAlphaMe.asBinder().linkToDeath(new f(this, aVar), 0);
                        AlphaMeClient alphaMeClient = new AlphaMeClient(this, aVar);
                        this.f13541e = alphaMeClient;
                        this.f13540d.addClient(alphaMeClient.asBinder());
                        this.f13542f = true;
                    } catch (RemoteException e6) {
                        Log.e("AlphaMe", BuildConfig.FLAVOR + e6.getMessage());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void u(int i5) {
        synchronized (this) {
            long j5 = i5;
            this.f13538b.remove(j5);
            this.f13539c.remove(j5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i5) {
        synchronized (this) {
            this.f13537a.remove(i5);
        }
    }

    public Object s(String str, Object... objArr) {
        d dVar = new d(null);
        n(dVar, true, str, objArr);
        return dVar.f13548c;
    }

    public void t(b bVar) {
        if (bVar == null || bVar.f13546c.isEmpty()) {
            return;
        }
        r();
        if (this.f13540d == null) {
            synchronized (this.f13539c) {
                try {
                    if (this.f13539c.get(bVar.a()) == null) {
                        this.f13539c.put(bVar.a(), bVar);
                        this.f13543g.removeMessages(0);
                        this.f13543g.sendEmptyMessageDelayed(0, 1000L);
                    }
                } finally {
                }
            }
            return;
        }
        if (this.f13542f) {
            try {
                if (o(bVar.a()) != null) {
                    Log.e("AlphaMe", "Receiver is registered before");
                } else if (l(bVar)) {
                    this.f13540d.registerActionReceiver(this.f13541e.asBinder(), bVar.f13546c, bVar.a());
                }
            } catch (Exception e6) {
                Log.e("AlphaMe", "registerReceiver exception " + e6.getMessage());
                u(bVar.a());
            }
        }
    }

    private AlphaMe() {
        this.f13537a = new LongSparseArray<>();
        this.f13538b = new LongSparseArray<>();
        this.f13539c = new LongSparseArray<>();
        r();
        if (Looper.getMainLooper() != null) {
            this.f13543g = new a(Looper.getMainLooper());
        }
    }
}
