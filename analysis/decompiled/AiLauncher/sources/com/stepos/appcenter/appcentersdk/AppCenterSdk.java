package com.stepos.appcenter.appcentersdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.appcenter.aidl.BaseAidlMsg;
import com.stepos.appcenter.aidl.ICommonCallback;
import com.stepos.appcenter.appcentersdk.a;
import com.stepos.appcenter.appcentersdk.data.SdkAppItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class AppCenterSdk {
    public static final String ACTION_STEPOS_APPCENTER_LAUNCH = "com.stepos.appstore.launch";
    public static final String TAG = "AppCenterSdk";

    /* renamed from: j, reason: collision with root package name */
    public static volatile AppCenterSdk f29439j;

    /* renamed from: a, reason: collision with root package name */
    public Context f29440a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<Listener, DownloadCallback> f29441b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final Object f29442c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f29443d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f29444e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29445f = false;
    public final List<Pair<BaseAidlMsg, DownloadCallback>> mNeedReSendAction = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public int f29446g = 1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f29447h = false;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver f29448i = new b();

    public static class DownloadCallback extends ICommonCallback.Stub {
        private Object lock = new Object();
        public Listener mListener;

        public DownloadCallback(Listener listener) {
            this.mListener = listener;
        }

        private void callback(int i10, String str) {
            synchronized (this.lock) {
                try {
                    Listener listener = this.mListener;
                    if (listener != null) {
                        listener.onCallback(i10, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean equals(Object obj) {
            boolean zEquals = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DownloadCallback downloadCallback = (DownloadCallback) obj;
            synchronized (this.lock) {
                try {
                    Listener listener = this.mListener;
                    if (listener != null) {
                        zEquals = listener.equals(downloadCallback.mListener);
                    } else if (downloadCallback.mListener != null) {
                        zEquals = false;
                    }
                } finally {
                }
            }
            return zEquals;
        }

        public int hashCode() {
            int iHashCode;
            synchronized (this.lock) {
                try {
                    Listener listener = this.mListener;
                    iHashCode = listener != null ? listener.hashCode() : 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iHashCode;
        }

        @Override // com.stepos.appcenter.aidl.ICommonCallback
        public void onCallback(BaseAidlMsg baseAidlMsg) throws RemoteException {
            int i10 = baseAidlMsg.code;
            if (i10 != 0 || baseAidlMsg.action <= 9000) {
                if (i10 != 0) {
                    callback(i10, baseAidlMsg.data);
                    return;
                }
                JSONObject jSONObjectV = G1.a.v(baseAidlMsg.data);
                int iQ = jSONObjectV.Q("code");
                jSONObjectV.remove("code");
                if (jSONObjectV.containsKey("mstore_data")) {
                    jSONObjectV.remove("mstore_data");
                }
                callback(iQ, jSONObjectV.toString());
            }
        }

        public void reset() {
            synchronized (this.lock) {
                this.mListener = null;
            }
        }
    }

    public interface Listener {
        void onCallback(int i10, String str);
    }

    public class a implements a.b {
        public a() {
        }

        @Override // com.stepos.appcenter.appcentersdk.a.b
        public void a() {
            Log.e(AppCenterSdk.TAG, "onDisConnected: ");
            AppCenterSdk.this.f29443d = true;
            AppCenterSdk.this.n();
        }

        @Override // com.stepos.appcenter.appcentersdk.a.b
        public void onConnected() {
            Log.d(AppCenterSdk.TAG, "onConnected: ");
            if (AppCenterSdk.this.q()) {
                AppCenterSdk.this.p();
            }
            AppCenterSdk.this.f29443d = false;
            AppCenterSdk.this.t();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AppCenterSdk.this.f29444e && AppCenterSdk.ACTION_STEPOS_APPCENTER_LAUNCH.equals(intent.getAction()) && AppCenterSdk.this.q()) {
                Log.d(AppCenterSdk.TAG, "onReceive: action = com.stepos.appstore.launch");
                if (!AppCenterSdk.this.q() || AppCenterSdk.this.f29440a == null) {
                    return;
                }
                Log.d(AppCenterSdk.TAG, "onReceive: start rebind aidl service");
                com.stepos.appcenter.appcentersdk.a.k().n(AppCenterSdk.this.f29440a, AppCenterSdk.this.f29445f);
            }
        }
    }

    public interface d {
    }

    public static AppCenterSdk getInstance() {
        if (f29439j == null) {
            synchronized (AppCenterSdk.class) {
                try {
                    if (f29439j == null) {
                        f29439j = new AppCenterSdk();
                    }
                } finally {
                }
            }
        }
        return f29439j;
    }

    public void batchInstallApps(String str, List<SdkAppItem> list) {
        if (list == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 1004;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageName", str);
        jSONObject.put("apps", G1.a.N(list));
        jSONObject.put("sdkVersionCode", Integer.valueOf(J6.b.a()));
        baseAidlMsg.data = jSONObject.toString();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, null);
    }

    public void deleteDownloadTask(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 8;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packageNames", list);
        baseAidlMsg.data = jSONObject.toString();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, null);
    }

    public List<Pair<String, Integer>> getAllDownloadTasks() {
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 10;
        final ArrayList arrayList = new ArrayList();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub() { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.7
            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
                JSONArray jSONArrayU = G1.a.u(baseAidlMsg2.data);
                for (int i10 = 0; i10 < jSONArrayU.size(); i10++) {
                    JSONObject jSONObjectQ = jSONArrayU.Q(i10);
                    arrayList.add(new Pair(jSONObjectQ.T("pkg"), jSONObjectQ.R("version")));
                }
                synchronized (AppCenterSdk.this.f29442c) {
                    AppCenterSdk.this.f29442c.notify();
                }
            }
        });
        if (arrayList.size() <= 0) {
            synchronized (this.f29442c) {
                try {
                    this.f29442c.wait(1000L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public int getInstallType() {
        return this.f29446g;
    }

    public void getRecommendApps(boolean z10, String str, String str2, int i10, long j10, d dVar) {
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 1002;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isFromStepOSPhone", Boolean.valueOf(z10));
        jSONObject.put("oldImei", str);
        jSONObject.put("max", Integer.valueOf(i10));
        jSONObject.put("timeout", Long.valueOf(j10));
        jSONObject.put("oldSn", str2);
        jSONObject.put("sdkVersionCode", Integer.valueOf(J6.b.a()));
        baseAidlMsg.data = jSONObject.toString();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub(dVar) { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.5
            final /* synthetic */ d val$listener;

            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
            }
        });
    }

    public int hasPrivacyAgreed() {
        return com.stepos.appcenter.appcentersdk.a.k().m();
    }

    public void init(Context context) {
        Log.i(TAG, "调用 init(context)");
        init(context, false);
    }

    public void isLauncherRecommendOpen(final Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 12;
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub() { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.2
            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
                Log.d(AppCenterSdk.TAG, "12：msg.code = " + baseAidlMsg2.code + "，msg.data = " + baseAidlMsg2.data);
                listener.onCallback(baseAidlMsg2.code, baseAidlMsg2.data);
            }
        });
    }

    public void isPersonAdRecommendOpen(final Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 13;
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub() { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.3
            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
                Log.d(AppCenterSdk.TAG, "13：msg.code = " + baseAidlMsg2.code + "，msg.data = " + baseAidlMsg2.data);
                listener.onCallback(baseAidlMsg2.code, baseAidlMsg2.data);
            }
        });
    }

    public void isPrivacyAgreed(final Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 11;
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub() { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.4
            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
                Log.d(AppCenterSdk.TAG, "11：msg.code = " + baseAidlMsg2.code + "，msg.data = " + baseAidlMsg2.data);
                listener.onCallback(baseAidlMsg2.code, baseAidlMsg2.data);
            }
        });
    }

    public final void j(BaseAidlMsg baseAidlMsg, DownloadCallback downloadCallback) {
        synchronized (this.mNeedReSendAction) {
            this.mNeedReSendAction.add(new Pair<>(baseAidlMsg, downloadCallback));
        }
    }

    public final String k(long j10) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", Long.valueOf(j10));
        jSONObject.put("installType", Integer.valueOf(this.f29446g));
        jSONObject.put("sdkVersionCode", Integer.valueOf(J6.b.a()));
        return jSONObject.toString();
    }

    public final String l(String str, int i10, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packageName", str);
        jSONObject.put("versionCode", Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("requestId", str2);
        }
        jSONObject.put("installType", Integer.valueOf(this.f29446g));
        jSONObject.put("sdkVersionCode", Integer.valueOf(J6.b.a()));
        return jSONObject.toString();
    }

    public final JSONObject m(JSONObject jSONObject) {
        Set<String> setKeySet;
        if (jSONObject != null && (setKeySet = jSONObject.keySet()) != null) {
            for (String str : setKeySet) {
                Object obj = jSONObject.get(str);
                if (!(obj instanceof String)) {
                    jSONObject.put(str, String.valueOf(obj));
                }
            }
        }
        return jSONObject;
    }

    public final void n() {
        if (this.f29447h || !this.f29444e) {
            return;
        }
        this.f29447h = true;
        r(new IntentFilter(ACTION_STEPOS_APPCENTER_LAUNCH));
        Log.d(TAG, "registerAppCenterLaunchReciever: ");
    }

    public final void o(BaseAidlMsg baseAidlMsg, DownloadCallback downloadCallback) {
        synchronized (this.mNeedReSendAction) {
            try {
                int size = this.mNeedReSendAction.size() - 1;
                while (true) {
                    if (size <= -1) {
                        break;
                    }
                    Pair<BaseAidlMsg, DownloadCallback> pair = this.mNeedReSendAction.get(size);
                    if (((BaseAidlMsg) pair.first).equals(baseAidlMsg) && ((DownloadCallback) pair.second).equals(downloadCallback)) {
                        this.mNeedReSendAction.remove(size);
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onDestroy() {
        com.stepos.appcenter.appcentersdk.a.k().q();
        t();
        this.f29441b.clear();
        this.mNeedReSendAction.clear();
        this.f29444e = false;
        this.f29440a = null;
        Log.e(TAG, "onDestroy :");
    }

    public void onMovedAppReceived(boolean z10, List<Pair<String, Integer>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 1005;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isFromStepOSPhone", Boolean.valueOf(z10));
        jSONObject.put("packageInfos", list);
        baseAidlMsg.data = G1.a.N(jSONObject);
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, null);
    }

    public void onRecommendAppExposure(String str, List<SdkAppItem> list) {
        if (list == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 1003;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageName", str);
        jSONObject.put("apps", G1.a.N(list));
        baseAidlMsg.data = jSONObject.toString();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, null);
    }

    public final void p() {
        synchronized (this.mNeedReSendAction) {
            try {
                for (Pair<BaseAidlMsg, DownloadCallback> pair : this.mNeedReSendAction) {
                    Log.d(TAG, "sendNeedReSendAction: msg : " + pair.first);
                    com.stepos.appcenter.appcentersdk.a.k().h((BaseAidlMsg) pair.first, (ICommonCallback) pair.second);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void performDownloadClick(c cVar, Listener listener) {
        if (cVar == null) {
            throw new IllegalArgumentException("downloadParams must not null");
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 1;
        baseAidlMsg.data = l(cVar.f29451a, cVar.f29452b, cVar.f29453c);
        baseAidlMsg.sourceApkInfo = cVar.f29454d;
        if (listener != null && !this.f29441b.containsKey(listener)) {
            this.f29441b.put(listener, new DownloadCallback(listener));
            BaseAidlMsg baseAidlMsg2 = new BaseAidlMsg();
            baseAidlMsg2.action = 3;
            baseAidlMsg2.data = l(cVar.f29451a, cVar.f29452b, cVar.f29453c);
            j(baseAidlMsg2, this.f29441b.get(listener));
        }
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, this.f29441b.get(listener));
    }

    public void performDownloadClickByAppId(long j10, String str, Listener listener) {
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = BaseAidlMsg.Action.ACTION_INSTALL_APP_BY_ID;
        baseAidlMsg.data = k(j10);
        baseAidlMsg.sourceApkInfo = str;
        if (listener != null && !this.f29441b.containsKey(listener)) {
            this.f29441b.put(listener, new DownloadCallback(listener));
            BaseAidlMsg baseAidlMsg2 = new BaseAidlMsg();
            baseAidlMsg2.action = BaseAidlMsg.Action.ACTION_INSTALL_APP_BY_ID_CALLBACK;
            baseAidlMsg2.data = k(j10);
            j(baseAidlMsg2, this.f29441b.get(listener));
        }
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, this.f29441b.get(listener));
    }

    public final boolean q() {
        boolean z10;
        List<Pair<BaseAidlMsg, DownloadCallback>> list;
        synchronized (this.mNeedReSendAction) {
            try {
                z10 = this.f29443d && (list = this.mNeedReSendAction) != null && list.size() > 0;
            } finally {
            }
        }
        return z10;
    }

    public final void r(IntentFilter intentFilter) {
        try {
            Context context = this.f29440a;
            if (context != null) {
                context.registerReceiver(this.f29448i, intentFilter);
            }
        } catch (Exception e10) {
            Log.e(TAG, "tryRegisterReceiver:" + e10.toString());
        }
    }

    public void registerGlobalListener(Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 5;
        if (!this.f29441b.containsKey(listener)) {
            this.f29441b.put(listener, new DownloadCallback(listener));
            j(baseAidlMsg, this.f29441b.get(listener));
        }
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, this.f29441b.get(listener));
    }

    public void registerListener(String str, int i10, Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 3;
        baseAidlMsg.data = l(str, i10, null);
        if (!this.f29441b.containsKey(listener)) {
            this.f29441b.put(listener, new DownloadCallback(listener));
            j(baseAidlMsg, this.f29441b.get(listener));
        }
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, this.f29441b.get(listener));
    }

    public void requestApi(String str, Map<String, String> map, final Listener listener) {
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 9;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api", str);
        jSONObject.put("params", map);
        baseAidlMsg.data = jSONObject.j();
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, new ICommonCallback.Stub() { // from class: com.stepos.appcenter.appcentersdk.AppCenterSdk.6
            @Override // com.stepos.appcenter.aidl.ICommonCallback
            public void onCallback(BaseAidlMsg baseAidlMsg2) throws RemoteException {
                Listener listener2 = listener;
                if (listener2 != null) {
                    listener2.onCallback(baseAidlMsg2.code, baseAidlMsg2.data);
                }
            }
        });
    }

    public final void s() {
        try {
            Context context = this.f29440a;
            if (context != null) {
                context.unregisterReceiver(this.f29448i);
            }
        } catch (Exception e10) {
            Log.e(TAG, "tryUnRegisterReceiver" + e10.toString());
        }
    }

    public void setInstallType(int i10) {
        this.f29446g = i10;
    }

    public void statistics(String str, String str2, JSONObject jSONObject) {
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 7;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("actionName", str);
        jSONObject2.put("pageName", str2);
        jSONObject2.put(PropertiesValidator.PROPERTY, G1.a.N(m(jSONObject)));
        baseAidlMsg.data = G1.a.N(jSONObject2);
        com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, null);
    }

    public final void t() {
        if (this.f29447h) {
            this.f29447h = false;
            s();
            Log.d(TAG, "unregisterAppCenterLauncherReciever: ");
        }
    }

    public void unRegisterGlobalListener(Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 6;
        if (this.f29441b.containsKey(listener)) {
            DownloadCallback downloadCallback = this.f29441b.get(listener);
            com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, downloadCallback);
            downloadCallback.reset();
            o(baseAidlMsg, downloadCallback);
            this.f29441b.remove(listener);
        }
    }

    public void unRegisterListener(String str, int i10, Listener listener) {
        if (listener == null) {
            return;
        }
        BaseAidlMsg baseAidlMsg = new BaseAidlMsg();
        baseAidlMsg.action = 4;
        baseAidlMsg.data = l(str, i10, null);
        if (this.f29441b.containsKey(listener)) {
            com.stepos.appcenter.appcentersdk.a.k().h(baseAidlMsg, this.f29441b.get(listener));
            DownloadCallback downloadCallback = this.f29441b.get(listener);
            downloadCallback.reset();
            o(baseAidlMsg, downloadCallback);
            this.f29441b.remove(listener);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f29451a;

        /* renamed from: b, reason: collision with root package name */
        public int f29452b;

        /* renamed from: c, reason: collision with root package name */
        public String f29453c;

        /* renamed from: d, reason: collision with root package name */
        public String f29454d;

        public c(String str) {
            this.f29451a = str;
        }

        public c a(String str) {
            this.f29453c = str;
            return this;
        }

        public c(String str, int i10) {
            this.f29451a = str;
            this.f29452b = i10;
        }
    }

    public void init(Context context, boolean z10) {
        Log.i(TAG, "调用 init(context, bindWaivePriority)");
        this.f29445f = z10;
        if (context != null) {
            if (this.f29444e && context.getApplicationContext().equals(this.f29440a)) {
                Log.i(TAG, "防止重复 init");
                return;
            }
            this.f29440a = context.getApplicationContext();
            this.f29444e = com.stepos.appcenter.appcentersdk.a.k().n(this.f29440a, z10);
            com.stepos.appcenter.appcentersdk.a.k().g(new a());
            return;
        }
        throw new IllegalArgumentException("context can not be null!");
    }
}
