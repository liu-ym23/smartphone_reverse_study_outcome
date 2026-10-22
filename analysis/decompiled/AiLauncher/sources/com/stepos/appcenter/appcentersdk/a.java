package com.stepos.appcenter.appcentersdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.stepos.appcenter.aidl.BaseAidlMsg;
import com.stepos.appcenter.aidl.IAidlCommonService;
import com.stepos.appcenter.aidl.ICommonCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    public static volatile a f29455m;

    /* renamed from: c, reason: collision with root package name */
    public IAidlCommonService f29458c;

    /* renamed from: g, reason: collision with root package name */
    public Context f29462g;

    /* renamed from: a, reason: collision with root package name */
    public final String f29456a = "AppCenterAidlClient";

    /* renamed from: b, reason: collision with root package name */
    public final Object f29457b = new Object();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f29459d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f29460e = false;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f29461f = null;

    /* renamed from: h, reason: collision with root package name */
    public String f29463h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f29464i = "";

    /* renamed from: j, reason: collision with root package name */
    public final List<Pair<BaseAidlMsg, ICommonCallback>> f29465j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ServiceConnection f29466k = new ServiceConnectionC0344a();

    /* renamed from: l, reason: collision with root package name */
    public final List<b> f29467l = new ArrayList();

    /* renamed from: com.stepos.appcenter.appcentersdk.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0344a implements ServiceConnection {
        public ServiceConnectionC0344a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f29457b) {
                try {
                    Log.i("AppCenterAidlClient", "onServiceConnected: ComponentName=" + componentName);
                    a.this.f29459d = false;
                    a.this.f29458c = IAidlCommonService.Stub.asInterface(iBinder);
                    a.this.i();
                    Iterator it = a.this.f29467l.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).onConnected();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f29457b) {
                try {
                    Log.i("AppCenterAidlClient", "onServiceDisconnected: ComponentName=" + componentName);
                    a.this.f29459d = false;
                    if (a.this.f29458c != null) {
                        a.this.f29458c = null;
                    }
                    Iterator it = a.this.f29467l.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface b {
        void a();

        void onConnected();
    }

    public static a k() {
        if (f29455m == null) {
            synchronized (a.class) {
                try {
                    if (f29455m == null) {
                        f29455m = new a();
                    }
                } finally {
                }
            }
        }
        return f29455m;
    }

    public void g(b bVar) {
        synchronized (this.f29457b) {
            try {
                if (bVar == null) {
                    return;
                }
                this.f29467l.add(bVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(BaseAidlMsg baseAidlMsg, ICommonCallback iCommonCallback) {
        synchronized (this.f29457b) {
            try {
                baseAidlMsg.sourceApk = this.f29463h;
                if (TextUtils.isEmpty(baseAidlMsg.sourceApkInfo)) {
                    baseAidlMsg.sourceApkInfo = this.f29464i;
                }
                IAidlCommonService iAidlCommonService = this.f29458c;
                if (iAidlCommonService != null) {
                    try {
                        iAidlCommonService.doAction(baseAidlMsg, iCommonCallback);
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                } else {
                    Log.i("AppCenterAidlClient", "doAction: aidl service is not connected and try reconnect and cached current msg ");
                    if (!o()) {
                        Log.e("AppCenterAidlClient", "aidl not support");
                        p(iCommonCallback);
                        return;
                    }
                    this.f29459d = false;
                    if (!n(this.f29462g, this.f29460e)) {
                        Log.e("AppCenterAidlClient", "init aidl fail");
                        p(iCommonCallback);
                    } else {
                        Log.i("AppCenterAidlClient", "doAction: add msg to mRequestCache");
                        this.f29465j.add(Pair.create(baseAidlMsg, iCommonCallback));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        Log.i("AppCenterAidlClient", "doCachedRequest: mRequestCache'size = " + this.f29465j.size());
        for (Pair<BaseAidlMsg, ICommonCallback> pair : this.f29465j) {
            try {
                this.f29458c.doAction((BaseAidlMsg) pair.first, (ICommonCallback) pair.second);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        this.f29465j.clear();
    }

    public Intent j() {
        Intent intent = new Intent("com.stepos.appcenter.AidlCommonService");
        ComponentName componentName = new ComponentName(c.a(), "com.stepos.appcenter.aidl.AidlCommonService");
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public String l() {
        return this.f29464i;
    }

    public int m() {
        synchronized (this.f29457b) {
            try {
                IAidlCommonService iAidlCommonService = this.f29458c;
                if (iAidlCommonService != null) {
                    try {
                        return iAidlCommonService.hasPrivacyAgreed();
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean n(Context context, boolean z10) {
        Log.d("AppCenterAidlClient", "init aidl,bindWaivePriority:" + z10);
        synchronized (this.f29457b) {
            try {
                this.f29460e = z10;
                if (context == null) {
                    throw new IllegalArgumentException("context can not be null!");
                }
                if (this.f29458c != null && context.getApplicationContext().equals(this.f29462g)) {
                    Log.d("AppCenterAidlClient", "client:" + this.f29458c);
                    return true;
                }
                this.f29462g = context.getApplicationContext();
                if (TextUtils.isEmpty(this.f29463h)) {
                    this.f29463h = this.f29462g.getPackageName();
                    Log.d("AppCenterAidlClient", "init: packageName = " + this.f29463h);
                }
                boolean zBindService = false;
                if (!o()) {
                    Log.e("AppCenterAidlClient", "init fail: aidl isn't supported");
                    return false;
                }
                if (this.f29458c == null && !this.f29459d) {
                    Intent intentJ = j();
                    this.f29459d = true;
                    try {
                        Intent intent = new Intent();
                        try {
                            intent.setComponent(new ComponentName("com.stepos.appstore", "com.stepos.appcenter.aidl.AidlCommonService"));
                            this.f29462g.startService(intent);
                        } catch (Exception unused) {
                        }
                        zBindService = this.f29462g.bindService(intentJ, this.f29466k, 1);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        this.f29459d = false;
                    }
                    Log.d("AppCenterAidlClient", "bind result:" + zBindService);
                    return zBindService;
                }
                Log.d("AppCenterAidlClient", "client:" + this.f29458c + "is binding:" + this.f29459d);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean o() {
        if (this.f29461f == null) {
            this.f29461f = Boolean.valueOf(c.c(this.f29462g));
        }
        return this.f29461f.booleanValue();
    }

    public final void p(ICommonCallback iCommonCallback) {
        if (iCommonCallback == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.code = -1;
        baseAidlMsg.data = "appcenter's version is too lower,so it can not support this function";
        try {
            iCommonCallback.onCallback(baseAidlMsg);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void q() {
        this.f29459d = false;
        if (this.f29458c != null) {
            this.f29462g.unbindService(this.f29466k);
            this.f29458c = null;
        }
        this.f29467l.clear();
        this.f29465j.clear();
    }

    public void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f29464i = str;
    }
}
