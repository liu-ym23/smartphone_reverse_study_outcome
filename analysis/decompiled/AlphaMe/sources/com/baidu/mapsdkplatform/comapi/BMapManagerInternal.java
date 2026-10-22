package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.c;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.tools.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class BMapManagerInternal implements PermissionCheck.d {

    /* renamed from: a, reason: collision with root package name */
    private static BMapManagerInternal f7815a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7816b;

    /* renamed from: c, reason: collision with root package name */
    private NetworkListener f7817c;

    /* renamed from: d, reason: collision with root package name */
    private int f7818d;

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<MapAuthListener> f7819e = new CopyOnWriteArrayList<>();

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        a.a();
    }

    private BMapManagerInternal() {
    }

    private void b() {
        Context context;
        NetworkListener networkListener = this.f7817c;
        if (networkListener == null || (context = this.f7816b) == null) {
            return;
        }
        context.unregisterReceiver(networkListener);
    }

    public static BMapManagerInternal getInstance() {
        if (f7815a == null) {
            f7815a = new BMapManagerInternal();
        }
        return f7815a;
    }

    public void a(Context context) {
        this.f7816b = context;
    }

    public void c() {
        int i4 = this.f7818d - 1;
        this.f7818d = i4;
        if (i4 == 0) {
            b();
            Iterator<MapAuthListener> it = this.f7819e.iterator();
            while (it.hasNext()) {
                this.f7819e.remove(it.next());
            }
            f.u();
        }
    }

    public Context d() {
        if (this.f7816b == null) {
            this.f7816b = JNIInitializer.getCachedContext();
        }
        return this.f7816b;
    }

    public void e() {
        if (this.f7818d == 0) {
            if (this.f7816b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                this.f7816b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
            }
            this.f7817c = new NetworkListener();
            a();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f7816b);
        }
        this.f7818d++;
    }

    public boolean permcheck() {
        if (this.f7816b == null) {
            Context cachedContext = JNIInitializer.getCachedContext();
            this.f7816b = cachedContext;
            if (cachedContext == null) {
                Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                return false;
            }
        }
        f.e(this.f7816b);
        if (Initializer.isAgreePrivacyMode()) {
            PermissionCheck.setPrivacyMode(true);
        } else {
            PermissionCheck.setPrivacyMode(false);
        }
        f.b(this.f7816b);
        c.a().a(this.f7816b);
        f.v();
        PermissionCheck.init(this.f7816b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        if (Initializer.isAgreePrivacyMode()) {
            return true;
        }
        throw new BaiduMapSDKException("not agree privacyMode, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
    }

    public void removeMapAuthListener(MapAuthListener mapAuthListener) {
        if (mapAuthListener != null) {
            this.f7819e.remove(mapAuthListener);
        }
    }

    public void setMapAuthListener(MapAuthListener mapAuthListener) {
        if (mapAuthListener != null) {
            this.f7819e.add(mapAuthListener);
        }
    }

    private void a() {
        NetworkListener networkListener;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        Context context = this.f7816b;
        if (context == null || (networkListener = this.f7817c) == null) {
            return;
        }
        context.registerReceiver(networkListener, intentFilter);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.d
    public void a(PermissionCheck.c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.f8179a == 0) {
            f.f8229F = cVar.f8183e;
            Iterator<MapAuthListener> it = this.f7819e.iterator();
            while (it.hasNext()) {
                MapAuthListener next = it.next();
                if (next != null) {
                    next.setAuthParam(f.f8229F);
                }
            }
            f.a(cVar.f8180b, cVar.f8181c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + cVar.toString());
        }
        int i4 = cVar.f8179a;
        if (i4 == PermissionCheck.f8177k || i4 == PermissionCheck.f8176j || i4 == PermissionCheck.f8178l) {
            return;
        }
        c.a().c(cVar.f8184f);
        c.a().d(cVar.f8185g);
    }
}
