package com.bytedanceos.appstore.datacache;

import android.app.job.JobInfo;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.appstore.download.service.AppsInstallService;
import com.bytedanceos.appstore.utils.d;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.eventbus.AccountAppsEvent;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import com.bytedanceos.common.eventbus.CollectEvent;
import com.bytedanceos.common.eventbus.LocalAppsLoadedEvent;
import com.bytedanceos.common.eventbus.PackageChangeEvent;
import com.bytedanceos.common.island.IIslandTaskProvider;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.utils.ReflectTool;
import com.bytedanceos.common.utils.n;
import com.bytedanceos.common.utils.r;
import com.obric.appstore.buss.apps.AppsManager;
import com.smt.obric.appstore.domain.analytics.autoupdate.SysAppAutoUpdateAnalytics;
import com.smt.obric.appstore.domain.sysapp.autoupdate.GetSysAppAutoUpdateWhitelistUseCase;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import com.ss.android.ugc.quota.tag.BDNetworkTagLaunchType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class a extends CommonCache {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile a f9352u;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HandlerThread f9353q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9354r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9355s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AppStoreCacheKtx f9356t;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$a, reason: collision with other inner class name */
    public static class HandlerC0109a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f9357a;

        public HandlerC0109a(Looper r10, a r11) {
            super(r10);
            this.f9357a = new WeakReference(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 700) goto L5;
            j.a("HANDLER_WHAT_SUBSCRIPT_INIT");
            WeakReference r12 = this.f9357a;
            if (r12 == null) goto L11;
            a r13 = (a) r12.get();
        L12:
            if (r13 != null) goto L14;
            return;
        L14:
            if (r13.f9563e.f9576a.isEmpty() == false) goto L16;
            r13.f9563e.f9576a.putAll(r13.r());
        L16:
            r13.k();
            EventBus.getDefault().post(new AddUpdateEvent());
            return;
        L11:
            r13 = null;
            goto L12
        L5:
            if (r11 != 702) goto L20;
            e.W0(BaseApplication.c(), r10.arg1);
            return;
        }
    }

    public class b extends CommonCache.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f9358d;

        /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$a, reason: collision with other inner class name */
        public class C0110a implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9359a;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$a$a, reason: collision with other inner class name */
            public class RunnableC0111a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C0110a f9360a;

                public RunnableC0111a(C0110a r10) {
                    this.f9360a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9360a.f9359a.f9358d.w0("COLLECT");
                    this.f9360a.f9359a.f9358d.f0();
                }
            }

            public C0110a(b r10) {
                this.f9359a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9359a.f9358d.f9565g.f9578c.post(new RunnableC0111a(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                b.i(this.f9359a);
            }
        }

        /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$b, reason: collision with other inner class name */
        public class C0112b implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9361a;

            public C0112b(b r10) {
                this.f9361a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), false);
                if (n.a(BaseApplication.c(), r11, r12).getErrorCode() != 1000004) goto L6;
                com.bytedanceos.appstore.utils.a.A();
            L6:
                if (this.f9361a.f9358d.f9564f.f9578c.hasMessages(406) == false) goto L8;
                this.f9361a.f9358d.f9564f.f9578c.removeMessages(406);
            L8:
                Handler r14 = this.f9361a.f9358d.f9564f.f9578c;
                r14.sendMessageDelayed(r14.obtainMessage(406), 180000);
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), true);
            }
        }

        public class c implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9362a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f9363b;

            public c(b r10, ArrayList r11) {
                this.f9363b = r10;
                this.f9362a = r11;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                if (n.a(BaseApplication.c(), r11, r12).getErrorCode() != 1000004) goto L10;
                com.bytedanceos.appstore.utils.a.A();
                Iterator r14 = this.f9362a.iterator();
            L6:
                if (r14.hasNext() == false) goto L8;
                AppInfo r15 = (AppInfo) r14.next();
                this.f9363b.f9358d.f9564f.f9576a.put(r15.appPackageName, r15);
                goto L6
            L8:
                this.f9363b.f9358d.f0();
                return;
            L10:
                this.f9363b.f9358d.T0(false);
                b.m(this.f9363b, this.f9362a);
                com.bytedanceos.common.toolbox.j.a("deleteMyAppsCache Failed:" + r12);
                t8.a.a(c8.a.n());
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                Handler r15 = this.f9363b.f9358d.f9564f.f9578c;
                r15.sendMessage(r15.obtainMessage(401, this.f9362a));
            }
        }

        public class d implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9364a;

            public d(b r10) {
                this.f9364a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), false);
                if (n.a(BaseApplication.c(), r11, r12).getErrorCode() != 1000004) goto L6;
                com.bytedanceos.appstore.utils.a.A();
            L6:
                if (this.f9364a.f9358d.f9565g.f9578c.hasMessages(505) == false) goto L8;
                this.f9364a.f9358d.f9565g.f9578c.removeMessages(505);
            L8:
                Handler r14 = this.f9364a.f9358d.f9565g.f9578c;
                r14.sendMessageDelayed(r14.obtainMessage(505), 180000);
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), true);
            }
        }

        public class e implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9365a;

            public e(b r10) {
                this.f9365a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9365a.f9358d.w0("COLLECT");
                DataBaseManager.AccountCollectionsTable.updateCollectionsReportState(BaseApplication.c(), true);
                EventBus.getDefault().post(new CollectEvent(2));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                Map r15 = this.f9365a.f9358d.f9565g.f9576a;
                monitor-enter(r15);
                this.f9365a.f9358d.f9565g.f9576a.clear();     // Catch: Throwable -> L7
                this.f9365a.f9358d.f9565g.f9576a.putAll(com.bytedanceos.appstore.utils.b.a0(r10, r12, r14));     // Catch: Throwable -> L7
                e8.a.o(this.f9365a.f9358d.f9565g.f9576a, BaseApplication.c());     // Catch: Throwable -> L7
                this.f9365a.f9358d.U0("COLLECT");     // Catch: Throwable -> L7
                EventBus.getDefault().post(new CollectEvent(1));     // Catch: Throwable -> L7
                monitor-exit(r15);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public class f implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9366a;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$f$a, reason: collision with other inner class name */
            public class RunnableC0113a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ f f9367a;

                public RunnableC0113a(f r10) {
                    this.f9367a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9367a.f9366a.f9358d.w0("MYAPPS");
                    this.f9367a.f9366a.f9358d.f0();
                }
            }

            public f(b r10) {
                this.f9366a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9366a.f9358d.f9564f.f9578c.post(new RunnableC0113a(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                DataBaseManager.AccountTable.updateMyAppsReportState(BaseApplication.c(), true);
                b.j(this.f9366a);
            }
        }

        public class g implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9368a;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$g$a, reason: collision with other inner class name */
            public class RunnableC0114a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f9369a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f9370b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f9371c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ g f9372d;

                public RunnableC0114a(g r10, int r11, String r12, String r13) {
                    this.f9372d = r10;
                    this.f9369a = r11;
                    this.f9370b = r12;
                    this.f9371c = r13;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9372d.f9368a.f9358d.f9564f.f9576a.clear();
                    this.f9372d.f9368a.f9358d.f9564f.f9576a.putAll(com.bytedanceos.appstore.utils.b.a0(this.f9369a, this.f9370b, this.f9371c));
                    if (this.f9372d.f9368a.f9358d.f9564f.f9576a.containsKey("com.bytedanceos.googleinstaller") == false) goto L5;
                    ArrayList r10 = new ArrayList();
                    r10.add((AppInfo) this.f9372d.f9368a.f9358d.f9564f.f9576a.get("com.bytedanceos.googleinstaller"));
                    b.k(this.f9372d.f9368a, r10);
                L5:
                    e8.a.q(this.f9372d.f9368a.f9358d.f9564f.f9576a, BaseApplication.c(), true);
                    this.f9372d.f9368a.f9358d.U0("MYAPPS");
                    this.f9372d.f9368a.f9358d.f0();
                    EventBus.getDefault().post(new AccountAppsEvent(Boolean.TRUE));
                }
            }

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$g$b, reason: collision with other inner class name */
            public class RunnableC0115b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g f9373a;

                public RunnableC0115b(g r10) {
                    this.f9373a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9373a.f9368a.f9358d.w0("MYAPPS");
                    this.f9373a.f9368a.f9358d.f0();
                }
            }

            public g(b r10) {
                this.f9368a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9368a.f9358d.f9564f.f9578c.post(new RunnableC0115b(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                this.f9368a.f9358d.f9564f.f9578c.post(new RunnableC0114a(this, r10, r12, r14));
            }
        }

        public class h implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9374a;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$h$a, reason: collision with other inner class name */
            public class RunnableC0116a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f9375a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f9376b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f9377c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ h f9378d;

                public RunnableC0116a(h r10, int r11, String r12, String r13) {
                    this.f9378d = r10;
                    this.f9375a = r11;
                    this.f9376b = r12;
                    this.f9377c = r13;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map r10 = com.bytedanceos.appstore.utils.b.a0(this.f9375a, this.f9376b, this.f9377c);
                    Map<String, AppInfo> r11 = DataBaseManager.AccountTable.getMyAppsToReport(BaseApplication.c());
                    this.f9378d.f9374a.f9358d.f9564f.f9576a.clear();
                    this.f9378d.f9374a.f9358d.f9564f.f9576a.putAll(r10);
                    Iterator<AppInfo> r12 = r11.values().iterator();
                    boolean r13 = false;
                L4:
                    if (r12.hasNext() == false) goto L8;
                    AppInfo r14 = r12.next();
                    if (this.f9378d.f9374a.f9358d.f9564f.f9576a.containsKey(r14.appPackageName) == true) goto L4;
                    this.f9378d.f9374a.f9358d.f9564f.f9576a.put(r14.appPackageName, r14);
                    r13 = true;
                    goto L4
                L8:
                    if (r13 == false) goto L14;
                    if (this.f9378d.f9374a.f9358d.f9564f.f9578c.hasMessages(406) == false) goto L12;
                    this.f9378d.f9374a.f9358d.f9564f.f9578c.removeMessages(406);
                L12:
                    Handler r15 = this.f9378d.f9374a.f9358d.f9564f.f9578c;
                    r15.sendMessageDelayed(r15.obtainMessage(406), 180000);
                L14:
                    if (this.f9378d.f9374a.f9358d.f9564f.f9576a.containsKey("com.bytedanceos.googleinstaller") == false) goto L16;
                    ArrayList r16 = new ArrayList();
                    r16.add((AppInfo) this.f9378d.f9374a.f9358d.f9564f.f9576a.get("com.bytedanceos.googleinstaller"));
                    b.k(this.f9378d.f9374a, r16);
                L16:
                    e8.a.q(this.f9378d.f9374a.f9358d.f9564f.f9576a, BaseApplication.c(), true);
                    this.f9378d.f9374a.f9358d.U0("MYAPPS");
                    this.f9378d.f9374a.f9358d.f0();
                    EventBus.getDefault().post(new AccountAppsEvent(Boolean.TRUE));
                }
            }

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$h$b, reason: collision with other inner class name */
            public class RunnableC0117b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ h f9379a;

                public RunnableC0117b(h r10) {
                    this.f9379a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9379a.f9374a.f9358d.w0("MYAPPS");
                    this.f9379a.f9374a.f9358d.f9564f.f9576a.clear();
                    this.f9379a.f9374a.f9358d.f9564f.f9576a.putAll(e8.a.l(BaseApplication.c()));
                    this.f9379a.f9374a.f9358d.f0();
                }
            }

            public h(b r10) {
                this.f9374a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9374a.f9358d.f9564f.f9578c.post(new RunnableC0117b(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                this.f9374a.f9358d.f9564f.f9578c.post(new RunnableC0116a(this, r10, r12, r14));
            }
        }

        public class i implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f9380a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f9381b;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$i$a, reason: collision with other inner class name */
            public class RunnableC0118a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f9382a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f9383b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f9384c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ i f9385d;

                public RunnableC0118a(i r10, int r11, String r12, String r13) {
                    this.f9385d = r10;
                    this.f9382a = r11;
                    this.f9383b = r12;
                    this.f9384c = r13;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map r10 = com.bytedanceos.appstore.utils.b.a0(this.f9382a, this.f9383b, this.f9384c);
                    if (r10 != null) goto L6;
                    return;
                L6:
                    if (r10.isEmpty() == true) goto L8;
                    b.l(this.f9385d.f9381b, r10);
                    this.f9385d.f9381b.f9358d.e(r10);
                    this.f9385d.f9381b.f9358d.f0();
                L8:
                    e8.a.v(BaseApplication.c(), this.f9385d.f9380a, true);
                }
            }

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$i$b, reason: collision with other inner class name */
            public class RunnableC0119b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ i f9386a;

                public RunnableC0119b(i r10) {
                    this.f9386a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9386a.f9381b.f9358d.w0("LOCAL_APPS_ONLINE");
                    com.bytedanceos.common.toolbox.j.a("sync apps failed");
                }
            }

            public i(b r10, ArrayList r11) {
                this.f9381b = r10;
                this.f9380a = r11;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9381b.f9358d.f9567i.f9578c.post(new RunnableC0119b(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                this.f9381b.f9358d.f9567i.f9578c.post(new RunnableC0118a(this, r10, r12, r14));
            }
        }

        public class j implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f9387a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f9388b;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$j$a, reason: collision with other inner class name */
            public class RunnableC0120a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f9389a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f9390b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ String f9391c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ j f9392d;

                public RunnableC0120a(j r10, int r11, String r12, String r13) {
                    this.f9392d = r10;
                    this.f9389a = r11;
                    this.f9390b = r12;
                    this.f9391c = r13;
                }

                public final void a(AppInfo r10, AppInfo r11) {
                    r11.appName = r10.appName;
                    r11.appCategoryName = r10.appCategoryName;
                    r11.recmd_brief = r10.recmd_brief;
                }

                public final void b(Map r10) {
                    ArrayList r11 = new ArrayList();
                    ArrayList r12 = new ArrayList();
                    ArrayList r13 = new ArrayList();
                    ArrayList r14 = new ArrayList(this.f9392d.f9388b.f9358d.f9561c.f9576a.values());
                    r14.addAll(this.f9392d.f9388b.f9358d.f9569k.f9576a.values());
                    Iterator r15 = r14.iterator();
                L4:
                    if (r15.hasNext() == false) goto L29;
                    AppInfo r16 = (AppInfo) r15.next();
                    AppInfo r17 = (AppInfo) r10.get(r16.appPackageName);
                    if (r17 != null) goto L7;
                    r13.add(r16);
                    com.bytedanceos.common.toolbox.j.a("no app data in server matched local download data: " + r16);
                    goto L4
                L7:
                    AppInfo r18 = (AppInfo) this.f9392d.f9388b.f9358d.f9561c.f9576a.get(r17.appPackageName);
                    if (r18 == null) goto L10;
                    a(r17, r18);
                    r11.add(r18);
                L10:
                    AppInfo r19 = (AppInfo) a.H0(this.f9392d.f9388b.f9358d).get(r17.appPackageName);
                    if (r19 == null) goto L13;
                    a(r17, r19);
                    r12.add(r19);
                L13:
                    AppInfo r20 = (AppInfo) this.f9392d.f9388b.f9358d.f9569k.f9576a.get(r17.appPackageName);
                    if (r20 == null) goto L4;
                    a(r17, r20);
                    r12.add(r20);
                    goto L4
                L29:
                L20:
                    e = move-exception;
                    e.printStackTrace();
                    return;
                L22:
                    e = move-exception;
                    e.printStackTrace();
                    return;
                L18:
                    if (r13.isEmpty() == true) goto L24;
                    this.f9392d.f9388b.f9358d.o0(r13);     // Catch: OperationApplicationException -> L20 RemoteException -> L22
                L24:
                    DataBaseManager.DownloadInfoTable.updateDownloadTask(r12);     // Catch: OperationApplicationException -> L20 RemoteException -> L22
                    q8.a.k(r11);     // Catch: OperationApplicationException -> L20 RemoteException -> L22
                }

                public final void c(Map r10) {
                    HashMap r11 = new HashMap();
                    Iterator r12 = this.f9392d.f9388b.f9358d.f9562d.f9576a.values().iterator();
                L4:
                    if (r12.hasNext() == false) goto L8;
                    AppInfo r13 = (AppInfo) r12.next();
                    AppInfo r14 = (AppInfo) r10.get(r13.appPackageName);
                    if (r14 == null) goto L4;
                    r14.appState = r13.appState;
                    r11.put(r13.appPackageName, r14);
                    goto L4
                L8:
                    this.f9392d.f9388b.f9358d.f9567i.f9576a.clear();
                    this.f9392d.f9388b.f9358d.f9567i.f9576a.putAll(r11);
                    b.l(this.f9392d.f9388b, r11);
                    this.f9392d.f9388b.f9358d.M(r11);
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map r10 = com.bytedanceos.appstore.utils.b.a0(this.f9389a, this.f9390b, this.f9391c);
                    if (r10 == null) goto L5;
                    c(r10);
                    b(r10);
                L5:
                    this.f9392d.f9388b.f9358d.k();
                    this.f9392d.f9388b.f9358d.U0("LOCAL_APPS_ONLINE");
                    EventBus.getDefault().post(new LocalAppsLoadedEvent());
                    this.f9392d.f9388b.f9358d.f0();
                    if (this.f9392d.f9387a == false) goto L8;
                    com.bytedanceos.appstore.utils.a.B();
                L8:
                    AppsManager.f10585a.i();
                }
            }

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$j$b, reason: collision with other inner class name */
            public class RunnableC0121b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ j f9393a;

                public RunnableC0121b(j r10) {
                    this.f9393a = r10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f9393a.f9388b.f9358d.w0("LOCAL_APPS_ONLINE");
                    this.f9393a.f9388b.f9358d.f9563e.f9576a.clear();
                    a r10 = this.f9393a.f9388b.f9358d;
                    r10.f9563e.f9576a.putAll(r10.r());
                    this.f9393a.f9388b.f9358d.f9567i.f9576a.clear();
                    this.f9393a.f9388b.f9358d.f9567i.f9576a.putAll(DataBaseManager.MyAppsTable.query(null));
                    this.f9393a.f9388b.f9358d.f0();
                    EventBus.getDefault().post(new AddUpdateEvent());
                    this.f9393a.f9388b.f9358d.k();
                    if (this.f9393a.f9387a == false) goto L5;
                    com.bytedanceos.appstore.utils.a.B();
                L5:
                    AppsManager.f10585a.i();
                }
            }

            public j(b r10, boolean r11) {
                this.f9388b = r10;
                this.f9387a = r11;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9388b.f9358d.f9567i.f9578c.post(new RunnableC0121b(this));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                this.f9388b.f9358d.f9567i.f9578c.post(new RunnableC0120a(this, r10, r12, r14));
            }
        }

        public class k implements FetchDataCallBack {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9394a;

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$k$a, reason: collision with other inner class name */
            public class RunnableC0122a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f9395a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f9396b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ int f9397c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f9398d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ k f9399e;

                public RunnableC0122a(k r10, int r11, String r12, int r13, String r14) {
                    this.f9399e = r10;
                    this.f9395a = r11;
                    this.f9396b = r12;
                    this.f9397c = r13;
                    this.f9398d = r14;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedanceos.common.toolbox.j.n("[AutoUpdate] check update API response. update data--->" + this.f9395a + " | " + this.f9396b);
                    if (this.f9395a != 1006007) goto L5;
                    this.f9399e.f9394a.f9358d.f9563e.f9576a.clear();
                    a r10 = this.f9399e.f9394a.f9358d;
                    r10.f9563e.f9576a.putAll(r10.r());
                L26:
                    this.f9399e.f9394a.f9358d.k();
                    com.bytedanceos.appstore.utils.a.B();
                    this.f9399e.f9394a.f9358d.U0("UPDATE");
                    EventBus.getDefault().post(new AddUpdateEvent());
                    com.bytedanceos.appstore.utils.a.a();
                    this.f9399e.f9394a.f9358d.f0();
                    AppsManager.f10585a.n();
                    return;
                L5:
                    Map r11 = com.bytedanceos.appstore.utils.b.a0(this.f9397c, this.f9396b, this.f9398d);
                    if (r11 != null) goto L8;
                L11:
                    com.bytedanceos.common.toolbox.j.n("update data--->" + this.f9396b);
                L12:
                    ArrayList r12 = com.bytedanceos.appstore.utils.b.b0(this.f9397c, this.f9396b, this.f9398d);
                    com.bytedanceos.common.toolbox.j.n("[AutoUpdate] check update API response. getAutoUpdateAppList SysApp size=" + r12.size());
                    SysAppAutoUpdateAnalytics.getImpl().onGetUpdateInfo(r12);
                    Iterator r13 = r12.iterator();
                    boolean r14 = false;
                    ArrayList r15 = null;
                L14:
                    if (r13.hasNext() == false) goto L25;
                    AppInfo r16 = (AppInfo) r13.next();
                    com.bytedanceos.common.toolbox.j.n("[AutoUpdate] check update API response. SysApp AutoUpdate autoUpdateList appName :" + r16.appName + " appPackageName " + r16.appPackageName + " appVersionCode :" + r16.appVersionCode + " updateModel :" + r16.mUpdateModel + " complianceMode :" + r16.mSysAppAutoUpdateComplianceMode);
                    int r17 = r16.mUpdateModel;
                    if (r17 != 4) goto L19;
                    a.I0(this.f9399e.f9394a.f9358d).d(r16);
                L23:
                    if (r14 == false) goto L14;
                    Handler r18 = this.f9399e.f9394a.f9358d.f9566h.f9578c;
                    r18.sendMessage(r18.obtainMessage(903, r15));
                    JobInfo r19 = c8.a.q();
                    t8.a.b(r19, "[AutoUpdate] check update API response. schedule wifi download job, id=" + r19.getId());
                    goto L14
                L19:
                    if (r17 != 3) goto L23;
                    if (r15 != null) goto L22;
                    r15 = new ArrayList();
                    r14 = true;
                L22:
                    r15.add(r16);
                    goto L23
                L25:
                    this.f9399e.f9394a.f9358d.Q(r11);
                    goto L26
                L8:
                    if (r11.isEmpty() == true) goto L11;
                    com.bytedanceos.common.toolbox.j.n("update size--->" + r11.size());
                    goto L12
                }
            }

            /* JADX INFO: renamed from: com.bytedanceos.appstore.datacache.a$b$k$b, reason: collision with other inner class name */
            public class RunnableC0123b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f9400a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k f9401b;

                public RunnableC0123b(k r10, String r11) {
                    this.f9401b = r10;
                    this.f9400a = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.bytedanceos.common.toolbox.j.n("[AutoUpdate] check update API error. onFetchDataFailed data--->" + this.f9400a);
                    this.f9401b.f9394a.f9358d.w0("UPDATE");
                    this.f9401b.f9394a.f9358d.f9563e.f9576a.clear();
                    a r10 = this.f9401b.f9394a.f9358d;
                    r10.f9563e.f9576a.putAll(r10.r());
                    this.f9401b.f9394a.f9358d.k();
                    com.bytedanceos.appstore.utils.a.a();
                    AppsManager.f10585a.n();
                }
            }

            public k(b r10) {
                this.f9394a = r10;
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
                this.f9394a.f9358d.f9563e.f9578c.post(new RunnableC0123b(this, r12));
            }

            @Override // com.bytedanceos.common.network.FetchDataCallBack
            public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
                this.f9394a.f9358d.f9563e.f9578c.post(new RunnableC0122a(this, r11, r12, r10, r14));
            }
        }

        public class l implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f9402a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f9403b;

            public l(b r10, String r11) {
                this.f9403b = r10;
                this.f9402a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                e8.a.e(BaseApplication.c(), this.f9402a);
                DataBaseManager.MyAppsTable.deleteApp(this.f9402a);
                a8.a.N().a(this.f9402a);
            }
        }

        public b(a r10) {
            this.f9358d = r10;
        }

        public static /* synthetic */ void i(b r10) {
            r10.y();
        }

        public static /* synthetic */ void j(b r10) {
            r10.x();
        }

        public static /* synthetic */ void k(b r10, ArrayList r11) {
            r10.u(r11);
        }

        public static /* synthetic */ void l(b r10, Map r11) {
            r10.n(r11);
        }

        public static /* synthetic */ void m(b r10, ArrayList r11) {
            r10.A(r11);
        }

        public final void A(ArrayList r10) {
            if (r10 != null) goto L4;
        L8:
            com.bytedanceos.common.toolbox.j.e("no local apps");
            return;
        L4:
            if (r10.isEmpty() == true) goto L8;
            D(r10);
            e8.a.f(BaseApplication.c(), r10, false, true);
        }

        public final void B(AppInfo r10) {
            String r11 = r10.appPackageName;
            AppInfo r12 = (AppInfo) this.f9358d.f9565g.f9576a.remove(r11);
            if (r12 == null) goto L8;
            r12.isCollected = false;
            if (r10.isNeededSync == false) goto L7;
            r12.isNeededSync = true;
            goto L8
        L7:
            r12.isNeededSync = false;
        L8:
            this.f9358d.f0();
            e8.a.r(BaseApplication.c(), r12);
            if (this.f9358d.f9565g.f9578c.hasMessages(505) == false) goto L11;
            this.f9358d.f9565g.f9578c.removeMessages(505);
        L11:
            Handler r13 = this.f9358d.f9565g.f9578c;
            r13.sendMessageDelayed(r13.obtainMessage(505), 180000);
        }

        public final void C(AppInfo r10) {
            Map r11 = this.f9358d.f9566h.f9576a;
            monitor-enter(r11);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.f9358d.f9566h.f9576a.containsKey(r10.appPackageName) == false) goto L9;
            this.f9358d.f9566h.f9576a.remove(r10.appPackageName);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r11);     // Catch: Throwable -> L7
            e8.a.h(r10, BaseApplication.c());
        }

        public final void D(ArrayList r10) {
            Map r11 = this.f9358d.f9566h.f9576a;
            monitor-enter(r11);
            Iterator r12 = r10.iterator();     // Catch: Throwable -> L8
        L6:
            if (r12.hasNext() == false) goto L10;
            AppInfo r13 = (AppInfo) r12.next();     // Catch: Throwable -> L8
            this.f9358d.f9566h.f9576a.remove(r13.appPackageName);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r11);     // Catch: Throwable -> L8
            e8.a.g(r10, BaseApplication.c());
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final void E() {
            CommonAPIHelper.e0(new C0112b(this));
        }

        public final void F() {
            CommonAPIHelper.f0(new d(this));
        }

        public final void G(List r10, List r11, List r12) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isEmpty() == true) goto L24;
            if (r11 != null) goto L8;
            r11 = new ArrayList();
        L8:
            if (r12 != null) goto L10;
            r12 = new ArrayList();
        L10:
            Map<String, AppInfo> r13 = DataBaseManager.AccountTable.getMyAppsToReport(BaseApplication.c());
            Iterator r14 = r10.iterator();
        L12:
            if (r14.hasNext() == false) goto L25;
            AppInfo r15 = (AppInfo) r14.next();
            if (r13.containsKey(r15.appPackageName) == true) goto L15;
            r12.add(r15);
            goto L12
        L15:
            r11.add(r15);
            goto L12
        L25:
            return;
        }

        public final void H(AppInfo r10) {
            boolean r11 = true;
            if (this.f9358d.f9563e.f9576a.containsKey(r10.appPackageName) == true) goto L5;
        L7:
            boolean r12 = false;
        L9:
            if (this.f9358d.f9564f.f9576a.containsKey(r10.appPackageName) == false) goto L11;
            ((AppInfo) this.f9358d.f9564f.f9576a.get(r10.appPackageName)).appScores = r10.appScores;
            boolean r13 = true;
        L13:
            if (this.f9358d.f9565g.f9576a.containsKey(r10.appPackageName) == false) goto L15;
            ((AppInfo) this.f9358d.f9565g.f9576a.get(r10.appPackageName)).appScores = r10.appScores;
        L16:
            if (r12 == true) goto L19;
            if (r13 == true) goto L19;
            if (r11 == true) goto L19;
        L20:
            if (r12 == true) goto L22;
            if (r13 == true) goto L22;
        L23:
            if (r11 == false) goto L26;
            e8.a.s(BaseApplication.c(), r10.appPackageName, r10.appScores);
            return;
        L26:
            return;
        L22:
            e8.a.u(BaseApplication.c(), r10.appPackageName, r10.appScores);
        L19:
            this.f9358d.f0();
            goto L20
        L15:
            r11 = false;
            goto L16
        L11:
            r13 = false;
            goto L13
        L5:
            if (((AppInfo) this.f9358d.f9563e.f9576a.get(r10.appPackageName)).appScores == r10.appScores) goto L7;
            ((AppInfo) this.f9358d.f9563e.f9576a.get(r10.appPackageName)).appScores = r10.appScores;
            r12 = true;
            goto L9
        }

        public final void I() {
            ArrayList r10 = e8.a.m(BaseApplication.c());
            if (r10.isEmpty() == false) goto L6;
            com.bytedanceos.common.toolbox.j.a("sync Installed empty");
            return;
        L6:
            CommonAPIHelper.D(r10, new i(this, r10));
        }

        public final void J() {
            CommonAPIHelper.e0(new f(this));
        }

        public final void K(String r13, int r14) {
            com.bytedanceos.common.toolbox.j.n("[AutoUpdate] syncUpdateCacheAndCheckUpdateAndSubscript invoke, from=" + r13 + ", isPush=" + r14);
            if (TextUtils.isEmpty(r13) == false) goto L5;
            r13 = "AppStoreGlobalReceiver";
        L5:
            Set r10 = new GetSysAppAutoUpdateWhitelistUseCase(BaseApplication.c()).d();
            if (oe.b.a() == true) goto L8;
            Map r11 = e8.a.j(BaseApplication.c());
        L15:
            Map r12 = w(r11);
            ArrayList r15 = new ArrayList(r12.values());
            PackageManager r16 = BaseApplication.c().getPackageManager();
            if (r16 != null) goto L19;
            com.bytedanceos.common.toolbox.j.b("packageManager is null");
            return;
        L19:
            Iterator r17 = r10.iterator();
        L20:
            boolean r18 = false;
            if (r17.hasNext() == false) goto L27;
            String r19 = (String) r17.next();
            if (r12.containsKey(r19) == true) goto L20;
            PackageInfo r20 = r16.getPackageInfo(r19, 0);     // Catch: PackageManager.NameNotFoundException -> L36
            AppInfo r21 = new AppInfo();     // Catch: PackageManager.NameNotFoundException -> L36
            r21.appVersionCode = r20.versionCode;     // Catch: PackageManager.NameNotFoundException -> L36
            r21.appPackageName = r20.packageName;     // Catch: PackageManager.NameNotFoundException -> L36
            r15.add(r21);     // Catch: PackageManager.NameNotFoundException -> L36
            goto L20
        L27:
            b0.n().F("last_update_sync_time", System.currentTimeMillis(), null, BaseApplication.c());
            if (BaseApplication.c().o() == false) goto L30;
            int r22 = 2;
        L31:
            b0.n().F("last_update_sync_time", System.currentTimeMillis(), null, BaseApplication.c());
            com.bytedanceos.common.toolbox.j.n("[AutoUpdate] set UPDATE_SYNC_LAST_TIME_KEY");
            com.bytedanceos.common.toolbox.j.n("[AutoUpdate] check update API invoke");
            k r23 = new k(this);
            if (r14 != 1) goto L34;
            r18 = true;
        L34:
            CommonAPIHelper.W(r22, r15, r23, r13, r18);
            return;
        L30:
            r22 = 3;
            goto L31
        L8:
            com.bytedanceos.common.toolbox.j.n("[AutoUpdate] isSysAppUpdate, query system auto update apps");
            Map r24 = e8.a.j(BaseApplication.c());
            HashMap r25 = new HashMap();
            Iterator r26 = r10.iterator();
        L10:
            if (r26.hasNext() == false) goto L14;
            String r27 = (String) r26.next();
            AppInfo r28 = (AppInfo) r24.get(r27);
            if (r28 == null) goto L10;
            r25.put(r27, r28);
            goto L10
        L14:
            r11 = r25;
            goto L15
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void a(String r11) {
            PackageManager r10 = BaseApplication.c().getPackageManager();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            if (r10 != null) goto L9;
            com.bytedanceos.common.toolbox.j.b("pm is null!");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            return;
        L9:
            PackageInfo r12 = r10.getPackageInfo(r11, 0);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            if (r12 != null) goto L12;
            com.bytedanceos.common.toolbox.j.b("packageInfo is null!");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
        L12:
            AtomicBoolean r13 = new AtomicBoolean();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            AppInfo r14 = new AppInfo();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appState = 128;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appPackageName = r12.packageName;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appVersionName = r12.versionName;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appVersionCode = r12.versionCode;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appFirstInstallTime = r12.firstInstallTime;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r14.appLastUpdateTime = r12.lastUpdateTime;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            if (this.f9358d.f9561c.f9576a.containsKey(r11) == false) goto L16;
            AppInfo r15 = (AppInfo) this.f9358d.f9561c.f9576a.get(r11);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
        L19:
            this.f9358d.f9561c.f9576a.remove(r11);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.f9563e.f9576a.remove(r11);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.f9562d.f9576a.put(r11, r14);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            if (r13.get() == true) goto L23;
            if (r15 != null) goto L26;
            r14.isNeededSync = true;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.f0();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
        L30:
            Handler r16 = this.f9358d.f9562d.f9578c;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r16.sendMessage(r16.obtainMessage(105, 1, 0, r11));     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            if ((r12.applicationInfo.flags & 128) == 0) goto L35;
            Intent r17 = new Intent("com.appstore.app.update.complete");     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r17.setPackage(r11);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            BaseApplication.c().sendBroadcast(r17);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            com.bytedanceos.common.toolbox.j.a("send Broadcast:" + r11 + ", appInfo: " + r14.appVersionCode);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            return;
        L35:
            return;
        L26:
            if (TextUtils.equals(r15.appSource, "local") == true) goto L28;
            return;
        L28:
            r15.isNeededSync = false;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r15.mDiffMD5 = "";     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r15.mDiffDownloadUrl = "";     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            r18.put(r15.appPackageName, r15);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            n(r18);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.e(r18);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.f0();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            goto L30
        L23:
            r14.mAppType = 3;     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            this.f9358d.f0();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            com.bytedanceos.common.toolbox.j.a("add system app:" + r14.appPackageName + ", appInfo: " + r14.appVersionCode);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            goto L30
        L16:
            if (this.f9358d.f9563e.f9576a.containsKey(r11) == false) goto L18;
            r15 = (AppInfo) this.f9358d.f9563e.f9576a.get(r11);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L36
            goto L19
        L18:
            r15 = null;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void b(ArrayList r10) {
            if (r10 != null) goto L4;
        L19:
            com.bytedanceos.common.toolbox.j.a("deleteMyAppsCache return" + r10);
            return;
        L4:
            if (r10.isEmpty() == true) goto L19;
            Map r11 = this.f9358d.f9564f.f9576a;
            monitor-enter(r11);
            Iterator r12 = r10.iterator();     // Catch: Throwable -> L12
        L10:
            if (r12.hasNext() == false) goto L14;
            this.f9358d.f9564f.f9576a.remove(((AppInfo) r12.next()).appPackageName);     // Catch: Throwable -> L12
            goto L10
        L14:
            monitor-exit(r11);     // Catch: Throwable -> L12
            this.f9358d.f0();
            D(r10);
            e8.a.f(BaseApplication.c(), r10, true, false);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void c(Message r10) {
            int r11 = r10.what;
            if (r11 != 300) goto L5;
            AppInfo r12 = (AppInfo) r10.obj;
            if (this.f9358d.f9567i.f9576a.containsKey(r12.appPackageName) == true) goto L72;
            this.f9358d.f9567i.f9576a.put(r12.appPackageName, r12);
            e8.a.t(BaseApplication.c(), r12);
            DataBaseManager.MyAppsTable.insert(r12);
        L72:
            DataBaseManager.MyAppsTable.update(r12);
            this.f9358d.k();
            EventBus.getDefault().post(new AddUpdateEvent(r12.appPackageName));
            return;
        L5:
            if (r11 != 302) goto L7;
            K((String) r10.obj, r10.arg1);
            return;
        L7:
            if (r11 != 409) goto L9;
            Object r13 = r10.obj;
            if ((r13 instanceof ArrayList) == false) goto L100;
            u((ArrayList) r13);
            return;
        L100:
            return;
        L9:
            if (r11 != 600) goto L11;
            H((AppInfo) r10.obj);
            return;
        L11:
            if (r11 != 406) goto L13;
            E();
            return;
        L13:
            if (r11 != 407) goto L15;
            J();
            return;
        L15:
            if (r11 != 801) goto L17;
            e(true, false);
            return;
        L17:
            if (r11 == 802) goto L60;
            switch(r11) {
                case 100: goto L59;
                case 101: goto L58;
                case 102: goto L57;
                case 103: goto L56;
                case 104: goto L50;
                case 105: goto L37;
                default: goto L19;
            };
        L19:
            switch(r11) {
                case 400: goto L36;
                case 401: goto L33;
                case 402: goto L32;
                default: goto L20;
            };
        L20:
            switch(r11) {
                case 502: goto L31;
                case 503: goto L30;
                case 504: goto L29;
                case 505: goto L28;
                case 506: goto L27;
                default: goto L21;
            };
        L21:
            switch(r11) {
                case 900: goto L26;
                case 901: goto L25;
                case 902: goto L24;
                case 903: goto L23;
                default: goto L103;
            };
        L23:
            p((List) r10.obj);
            return;
        L24:
            C((AppInfo) r10.obj);
            return;
        L25:
            q((AppInfo) r10.obj);
            return;
        L26:
            z();
            return;
        L103:
            return;
        L27:
            h();
            return;
        L28:
            F();
            return;
        L29:
            B((AppInfo) r10.obj);
            return;
        L30:
            o((AppInfo) r10.obj);
            return;
        L31:
            s();
            return;
        L32:
            r();
            return;
        L33:
            Object r14 = r10.obj;
            if ((r14 instanceof ArrayList) == false) goto L84;
            t((ArrayList) r14, false);
            this.f9358d.T0(false);
            return;
        L84:
            return;
        L36:
            f();
            return;
        L37:
            Object r15 = r10.obj;
            if (r15 != null) goto L40;
        L48:
            com.bytedanceos.common.toolbox.j.e("HANDLER_WHAT_ADD_APP_INSTALLED_DB,params error");
            return;
        L40:
            if ((r15 instanceof String) == false) goto L48;
            AppInfo r16 = (AppInfo) this.f9358d.f9562d.f9576a.get((String) r15);
            if (r16 == null) goto L47;
            e8.a.t(BaseApplication.c(), r16);
            if (r10.arg1 != 1) goto L87;
            com.bytedanceos.common.toolbox.j.a("sync app:" + r16.appPackageName + ", appInfo: " + r16.appVersionCode);
            this.f9358d.W0(true);
            return;
        L87:
            return;
        L47:
            com.bytedanceos.common.toolbox.j.e("HANDLER_WHAT_ADD_APP_INSTALLED_DB,app is not exist.");
            return;
        L50:
            AppInfo r17 = (AppInfo) r10.obj;
            AppInfo r18 = this.f9358d.t(r17.appPackageName);
            if (r18 == null) goto L55;
            int r19 = r17.downloadStatus;
            if (r19 == r18.downloadStatus) goto L55;
            r18.downloadStatus = r19;
        L55:
            com.bytedanceos.common.utils.j.g();
            return;
        L56:
            this.f9358d.o0((ArrayList) r10.obj);
            return;
        L57:
            com.bytedanceos.common.utils.j.g();
            return;
        L58:
            this.f9358d.C0();
            return;
        L59:
            this.f9358d.y0();
            return;
        L60:
            I();
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void e(boolean r10, boolean r11) {
            if (r10 == false) goto L5;
        L13:
            this.f9358d.v0("LOCAL_APPS_ONLINE");
            HashMap r12 = new HashMap();
            r12.putAll(new HashMap(this.f9358d.f9562d.f9576a));
            r12.putAll(new HashMap(this.f9358d.f9561c.f9576a));
            r12.putAll(new HashMap(this.f9358d.f9569k.f9576a));
            List r13 = com.bytedanceos.appstore.utils.a.g(r12, false);
            com.bytedanceos.common.toolbox.j.n("fetch local installed apps faled.isReload = " + r10 + "/size = " + r13.size());
            CommonAPIHelper.D(r13, new j(this, r11));
            return;
        L5:
            if (this.f9358d.T("LOCAL_APPS_ONLINE") == true) goto L13;
            if (this.f9358d.S("LOCAL_APPS_ONLINE") == true) goto L13;
            this.f9358d.f9563e.f9576a.clear();
            a r14 = this.f9358d;
            r14.f9563e.f9576a.putAll(r14.r());
            this.f9358d.f9567i.f9576a.clear();
            this.f9358d.f9567i.f9576a.putAll(DataBaseManager.MyAppsTable.query(null));
            this.f9358d.f0();
            EventBus.getDefault().post(new AddUpdateEvent());
            this.f9358d.k();
            if (r11 == false) goto L12;
            com.bytedanceos.appstore.utils.a.B();
        L12:
            AppsManager.f10585a.i();
            com.bytedanceos.common.toolbox.j.m("use local cache data:" + r10);
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void f() {
            CommonAPIHelper.E(new h(this));
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void g(String r10) {
            if (this.f9358d.f9563e.f9576a.containsKey(r10) == false) goto L6;
            this.f9358d.s0(r10);
            com.bytedanceos.common.toolbox.j.a("removeInstalledCache contained in UpdateDataCache with pkgName:" + r10);
        L6:
            if (this.f9358d.f9561c.f9576a.containsKey(r10) == false) goto L8;
            a r11 = this.f9358d;
            r11.p0((AppInfo) r11.f9561c.f9576a.get(r10));
            com.bytedanceos.common.toolbox.j.a("removeInstalledCache contained in mDownloadDataCache with pkgName:" + r10);
        L8:
            AppInfo r12 = (AppInfo) this.f9358d.f9566h.f9576a.get(r10);
            if (r12 == null) goto L12;
            C(r12);
        L12:
            if (this.f9358d.f9562d.f9576a.remove(r10) == null) goto L14;
            com.bytedanceos.common.toolbox.j.a("removeInstalledCache contained in mInstalledDataCache with pkgName:" + r10);
        L14:
            Map r13 = this.f9358d.f9567i.f9576a;
            monitor-enter(r13);
        L19:
            th = move-exception;
            throw th;
        L17:
            if (this.f9358d.f9567i.f9576a.remove(r10) == null) goto L21;
            com.bytedanceos.common.toolbox.j.a("removeInstalledCache in mLocalAppsOnLineDataCache :" + r10);     // Catch: Throwable -> L19
        L21:
            monitor-exit(r13);     // Catch: Throwable -> L19
            this.f9358d.k();
            this.f9358d.f0();
            new Thread(new l(this, r10)).start();
        }

        @Override // com.bytedanceos.common.CommonCache.b
        public void h() {
            CommonAPIHelper.f0(new C0110a(this));
        }

        public final void n(Map r10) {
            if (AccountDataCache.b().n() == false) goto L26;
            if (r10 != null) goto L6;
            return;
        L6:
            if (r10.isEmpty() == true) goto L35;
            LinkedHashMap r11 = new LinkedHashMap();
            Map r12 = e8.a.l(BaseApplication.c());
            LinkedHashMap r13 = new LinkedHashMap();
            Iterator r14 = r10.values().iterator();
        L10:
            if (r14.hasNext() == false) goto L14;
            AppInfo r15 = (AppInfo) r14.next();
            if (r12.containsKey(r15.appPackageName) == true) goto L10;
            r15.isNeededSync = true;
            r13.put(r15.appPackageName, r15);
            r11.put(r15.appPackageName, r15);
            goto L10
        L14:
            Map r16 = this.f9358d.f9564f.f9576a;
            monitor-enter(r16);
            r13.putAll(this.f9358d.f9564f.f9576a);     // Catch: Throwable -> L23
            this.f9358d.f9564f.f9576a.clear();     // Catch: Throwable -> L23
            this.f9358d.f9564f.f9576a.putAll(r13);     // Catch: Throwable -> L23
            monitor-exit(r16);     // Catch: Throwable -> L23
            e8.a.q(r11, BaseApplication.c(), false);
            if (this.f9358d.f9564f.f9578c.hasMessages(406) == false) goto L21;
            this.f9358d.f9564f.f9578c.removeMessages(406);
        L21:
            Handler r17 = this.f9358d.f9564f.f9578c;
            r17.sendMessageDelayed(r17.obtainMessage(406), 180000);
            return;
        L23:
            th = move-exception;
            throw th;
        L35:
            return;
        }

        public final void o(AppInfo r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r10.isCollected = true;
            Map r11 = this.f9358d.f9565g.f9576a;
            monitor-enter(r11);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.f9358d.f9565g.f9576a.containsKey(r10.appPackageName) == true) goto L11;
            LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L9
            r12.put(r10.appPackageName, r10);     // Catch: Throwable -> L9
            r12.putAll(this.f9358d.f9565g.f9576a);     // Catch: Throwable -> L9
            this.f9358d.f9565g.f9576a.clear();     // Catch: Throwable -> L9
            this.f9358d.f9565g.f9576a.putAll(r12);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r11);     // Catch: Throwable -> L9
            this.f9358d.f0();
            e8.a.r(BaseApplication.c(), r10);
            if (this.f9358d.f9565g.f9578c.hasMessages(505) == false) goto L15;
            this.f9358d.f9565g.f9578c.removeMessages(505);
        L15:
            Handler r13 = this.f9358d.f9565g.f9578c;
            r13.sendMessageDelayed(r13.obtainMessage(505), 180000);
        }

        public final void p(List r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.size() == 0) goto L29;
            Map r11 = this.f9358d.f9566h.f9576a;
            monitor-enter(r11);
            Iterator r12 = r10.iterator();     // Catch: Throwable -> L14
        L10:
            if (r12.hasNext() == false) goto L16;
            AppInfo r13 = (AppInfo) r12.next();     // Catch: Throwable -> L14
            if (this.f9358d.f9566h.f9576a.containsKey(r13.appPackageName) == true) goto L10;
            this.f9358d.f9566h.f9576a.put(r13.appPackageName, r13);     // Catch: Throwable -> L14
            goto L10
        L16:
            monitor-exit(r11);     // Catch: Throwable -> L14
            this.f9358d.f0();
            e8.a.a(r10, BaseApplication.c());
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public final void q(AppInfo r10) {
            Map r11 = this.f9358d.f9566h.f9576a;
            monitor-enter(r11);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.f9358d.f9566h.f9576a.containsKey(r10.appPackageName) == true) goto L9;
            this.f9358d.f9566h.f9576a.put(r10.appPackageName, r10);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r11);     // Catch: Throwable -> L7
            ArrayList r12 = new ArrayList(1);
            r12.add(r10);
            this.f9358d.e0(r12);
            e8.a.b(r10, BaseApplication.c());
        }

        public final void r() {
            this.f9358d.f9564f.f9576a.clear();
            this.f9358d.w0("MYAPPS");
            this.f9358d.f0();
            e8.a.d(BaseApplication.c());
        }

        public final void s() {
            Map r10 = this.f9358d.f9565g.f9576a;
            monitor-enter(r10);
            this.f9358d.f9565g.f9576a.clear();     // Catch: Throwable -> L8
            this.f9358d.w0("COLLECT");     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            this.f9358d.f0();
            e8.a.c(BaseApplication.c());
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final void t(ArrayList r10, boolean r11) {
            if (r10 != null) goto L4;
        L14:
            com.bytedanceos.common.toolbox.j.e("no local apps");
            return;
        L4:
            if (r10.isEmpty() == true) goto L14;
            Iterator r12 = r10.iterator();
        L8:
            if (r12.hasNext() == false) goto L12;
            AppInfo r13 = (AppInfo) r12.next();
            AppInfo r14 = a.N0().t(r13.appPackageName);
            if (r14 == null) goto L8;
            r13.downloadId = r14.downloadId;
            goto L8
        L12:
            com.bytedanceos.common.utils.j.b(BaseApplication.c(), r10);
            D(r10);
            e8.a.f(BaseApplication.c(), r10, false, r11);
        }

        public final void u(ArrayList r10) {
            if (r10 != null) goto L4;
        L19:
            com.bytedanceos.common.toolbox.j.a("deleteMyAppsCache return");
            return;
        L4:
            if (r10.isEmpty() == true) goto L19;
            Map r11 = this.f9358d.f9564f.f9576a;
            monitor-enter(r11);
            Iterator r12 = r10.iterator();     // Catch: Throwable -> L12
        L10:
            if (r12.hasNext() == false) goto L14;
            AppInfo r13 = (AppInfo) r12.next();     // Catch: Throwable -> L12
            this.f9358d.f9564f.f9576a.remove(r13.appPackageName);     // Catch: Throwable -> L12
            goto L10
        L14:
            monitor-exit(r11);     // Catch: Throwable -> L12
            ArrayList r14 = new ArrayList();
            ArrayList r15 = new ArrayList();
            G(r10, r14, r15);
            t(r14, true);
            v(r15);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public final void v(ArrayList r10) {
            if (r10 != null) goto L4;
        L8:
            com.bytedanceos.common.toolbox.j.e("no remote apps");
            return;
        L4:
            if (r10.isEmpty() == true) goto L8;
            this.f9358d.T0(true);
            CommonAPIHelper.p(new c(this, r10), r10);
        }

        public final Map w(Map r10) {
            PackageManager r11 = BaseApplication.c().getPackageManager();     // Catch: Exception -> L6
            if (r11 != null) goto L8;
            com.bytedanceos.common.toolbox.j.b("pm is null!");     // Catch: Exception -> L6
            return r10;
        L8:
            ArrayList r12 = r.a();     // Catch: Exception -> L6
            if (r12 != null) goto L11;
        L25:
            return r10;
        L11:
            if (r12.size() <= 0) goto L25;
            if (r10 == null) goto L25;
            if (r10.keySet().size() <= 0) goto L25;
            Iterator r13 = r12.iterator();     // Catch: Exception -> L6
        L17:
            if (r13.hasNext() == false) goto L25;
            String r14 = (String) r13.next();     // Catch: Exception -> L6
            if (r10.containsKey(r14) == false) goto L17;
            if (ReflectTool.isAppActive(r11, r14) == true) goto L17;
            r10.remove(r14);     // Catch: Exception -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L25
        }

        public final void x() {
            CommonAPIHelper.E(new g(this));
        }

        public final void y() {
            CommonAPIHelper.F(2, new e(this));
        }

        public final void z() {
            this.f9358d.f9566h.f9576a.clear();
            this.f9358d.f9566h.f9576a.putAll(e8.a.n(BaseApplication.c()));
        }
    }

    static {
    }

    public a() {
        this.f9353q = null;
        this.f9354r = -1;
        this.f9355s = 0;
        this.f9356t = new AppStoreCacheKtx();
        b r10 = new b(this);
        this.f9561c = r10;
        r10.d("DOWNLOAD_THREAD");
        b r11 = new b(this);
        this.f9562d = r11;
        r11.d("INSTALLED_THREAD");
        b r12 = new b(this);
        this.f9563e = r12;
        r12.d("UPDATE_THREAD");
        b r13 = new b(this);
        this.f9564f = r13;
        r13.d("MYAPPS_THREAD");
        b r14 = new b(this);
        this.f9565g = r14;
        r14.d("COLLECT_THREAD");
        b r15 = new b(this);
        this.f9566h = r15;
        r15.d("COLLECT_THREAD");
        b r16 = new b(this);
        this.f9567i = r16;
        r16.d("LOCAL_APPS_ONLINE_THREAD");
        b r17 = new b(this);
        this.f9568j = r17;
        r17.d("REINSTALL_APP_THREAD");
        b r18 = new b(this);
        this.f9569k = r18;
        r18.d("DOWNLOAD_FAILED_THREAD");
        b r19 = new b(this);
        this.f9570l = r19;
        r19.d("DOWNLOAD_FILE_THREAD");
        HandlerThread r20 = new HandlerThread("SUBSCRIPT_THREAD");
        this.f9353q = r20;
        r20.start();
        this.f9571m = new HandlerC0109a(this.f9353q.getLooper(), this);
    }

    public static /* synthetic */ Map H0(a r10) {
        return r10.f9559a;
    }

    public static /* synthetic */ AppStoreCacheKtx I0(a r10) {
        return r10.f9356t;
    }

    public static a N0() {
        if (f9352u != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f9352u != null) goto L11;
        f9352u = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f9352u;
    }

    @Override // com.bytedanceos.common.CommonCache
    public long F() {
        HashMap r10 = new HashMap(this.f9561c.f9576a);
        HashMap r11 = new HashMap();
        Iterator r12 = this.f9563e.f9576a.values().iterator();
        Map r13 = this.f9563e.f9576a;
        monitor-enter(r13);
    L39:
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r12.hasNext() == false) goto L19;
        AppInfo r14 = (AppInfo) r12.next();     // Catch: Throwable -> L17
        if (r14.appVersionCode <= r14.hideVersionCode) goto L39;
        if (r14.mAppUpdateType == 0) goto L39;
        if (PackageInfoKTxKt.d(BaseApplication.c(), r14.appPackageName, r14.sha256) == true) goto L39;
        if (r.c(r14.appPackageName) == false) goto L39;
        if (r.b(r14.appPackageName) == false) goto L39;
        r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L17
        goto L39
    L19:
        monitor-exit(r13);     // Catch: Throwable -> L17
        Iterator r15 = r11.values().iterator();
        long r16 = 0;
    L22:
        if (r15.hasNext() == false) goto L34;
        AppInfo r17 = (AppInfo) r15.next();
        if (r10.containsKey(r17.appPackageName) == false) goto L25;
        AppInfo r18 = (AppInfo) r10.get(r17.appPackageName);
        if (r18.downloadStatus != 4) goto L22;
        long r19 = r18.downloadTotalBytes;
        if (r19 <= 0) goto L31;
        r16 = r16 + (r19 - r18.downloadCurrentBytes);
        goto L22
    L31:
        long r20 = r17.appBytes;
    L26:
        r16 = r16 + r20;
        goto L22
    L25:
        r20 = r17.appBytes;
        goto L26
    L34:
        if (r16 > 0) goto L36;
        return 0;
    L36:
        return r16;
    }

    public void J0(AppInfo r10, int r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        j.e("add failed cache, code: " + r11 + " app.downloadId  " + r10.downloadId + "packageName: " + r10.appPackageName);
        com.bytedanceos.common.download.b.l().q(true, new long[]{r10.downloadId});     // Catch: Exception -> L8
    L10:
        r10.downloadProgress = 0.0d;
        r10.downloadId = 0;
        r10.downloadStatus = 16;
        r10.pauseCode = r11;
        this.f9559a.remove(r10.appPackageName);
        this.f9561c.f9576a.remove(r10.appPackageName);
        this.f9569k.f9576a.put(r10.appPackageName, r10);
        if (r10.appState != 64) goto L13;
        this.f9563e.f9576a.put(r10.appPackageName, r10);
    L13:
        u0();
        ArrayList r12 = new ArrayList(1);
        r12.add(r10);
        e0(r12);
        DataBaseManager.DownloadInfoTable.addDownloadTask(r10);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public void K0(AppInfo r10) {
        this.f9561c.f9578c.obtainMessage(104, r10).sendToTarget();
    }

    @Override // com.bytedanceos.common.CommonCache
    public void L() {
        monitor-enter(this);
        int r10 = this.f9355s + 1;     // Catch: Throwable -> L8
        this.f9355s = r10;     // Catch: Throwable -> L8
        if (r10 <= 1) goto L10;
        i.b("AppStore", "initCache called " + this.f9355s + ", build=fab1af5f,a80d3b82,2bd8f26b,85579b36,5ad573e1");     // Catch: Throwable -> L8
        j.b("[offline] initCache called " + this.f9355s + ", build=fab1af5f,a80d3b82,2bd8f26b,85579b36,5ad573e1");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        com.bytedanceos.common.e.f9820a.onInitCacheStart();
        this.f9559a.clear();
        boolean r11 = false;
        this.f9559a.putAll(DataBaseManager.DownloadInfoTable.getAllDownloadTask(false));
        Map r12 = q8.a.b().c();
        p(r12);
        this.f9561c.f9576a.clear();
        this.f9561c.f9576a.putAll(r12);
        q(PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS);
        S0();
        Map r13 = e8.a.j(BaseApplication.c());
        ArrayList r14 = new ArrayList();
        le.a.c(BaseApplication.c());
        this.f9562d.f9576a.clear();     // Catch: RuntimeException -> L16
        PackageManager r15 = BaseApplication.c().getPackageManager();     // Catch: RuntimeException -> L16
        if (r15 != null) goto L18;
        j.b("PackageManager is null");     // Catch: RuntimeException -> L16
        return;
    L18:
        Iterator<PackageInfo> r16 = r15.getInstalledPackages(0).iterator();     // Catch: RuntimeException -> L16
        boolean r17 = false;
    L51:
        if (r16.hasNext() == false) goto L40;
        PackageInfo r18 = r16.next();     // Catch: RuntimeException -> L29
        AtomicBoolean r19 = new AtomicBoolean();     // Catch: RuntimeException -> L29
        AppInfo r20 = new AppInfo();     // Catch: RuntimeException -> L29
        r20.appState = 128;     // Catch: RuntimeException -> L29
        String r21 = r18.packageName;     // Catch: RuntimeException -> L29
        r20.appPackageName = r21;     // Catch: RuntimeException -> L29
        r20.appVersionName = r18.versionName;     // Catch: RuntimeException -> L29
        r20.appVersionCode = r18.versionCode;     // Catch: RuntimeException -> L29
        r20.appFirstInstallTime = r18.firstInstallTime;     // Catch: RuntimeException -> L29
        r20.appLastUpdateTime = r18.lastUpdateTime;     // Catch: RuntimeException -> L29
        r20.isNeededSync = false;     // Catch: RuntimeException -> L29
        AppInfo r22 = (AppInfo) r13.remove(r21);     // Catch: RuntimeException -> L29
        if (r22 == null) goto L32;
        if (r22.appVersionCode != r20.appVersionCode) goto L32;
        if (TextUtils.isEmpty(r22.mBaseApkMd5) == true) goto L32;
        this.f9562d.f9576a.put(r20.appPackageName, r22);     // Catch: RuntimeException -> L29
    L32:
        if (r19.get() == false) goto L34;
        r20.mAppType = 3;     // Catch: RuntimeException -> L29
    L48:
        this.f9562d.f9576a.put(r20.appPackageName, r20);     // Catch: RuntimeException -> L37
        r17 = true;
    L37:
        e = e;
        r11 = true;
    L39:
        e.printStackTrace();
        r17 = r11;
        goto L40
    L34:
        r14.add(r18);     // Catch: RuntimeException -> L29
    L40:
        this.f9566h.f9576a.putAll(e8.a.n(BaseApplication.c()));
        this.f9563e.f9576a.putAll(r());
        this.f9569k.f9576a.putAll(DataBaseManager.DownloadInfoTable.getAllFailedDownloads());
        f0();
        EventBus.getDefault().post(new AddUpdateEvent());
        k();
        if (r17 == false) goto L43;
        e8.a.p(BaseApplication.c(), this.f9562d.f9576a);
    L44:
        this.f9560b = true;
        ta.a.f24766a.a();
        IIslandTaskProvider.handleCachedIslandTask();
        com.bytedanceos.common.e.f9820a.onInitCacheFinish();
        return;
    L43:
        j.m("no new apps.");
    L29:
        e = e;
        r11 = r17;
    L16:
        e = e;
    L8:
        th = move-exception;
        throw th;
    }

    public Bundle L0(Bundle r10) {
        if (r10 != null) goto L5;
    L15:
        j.a("Bundle is null:" + r10);
        return null;
    L5:
        if (r10.isEmpty() == true) goto L15;
        String r11 = r10.getString("auto_update_pkg");
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return null;
    L10:
        Bundle r12 = new Bundle();
        com.smt.obric.appstore.domain.app.entity.a r13 = this.f9356t.e(r11, true);
        if (r13 == null) goto L13;
        r12.putAll(com.bytedanceos.appstore.datacache.b.a(r13));
    L14:
        return r12;
    L13:
        r12.putInt("auto_update_progress", -1);
        goto L14
    }

    public int M0(String r10) {
        AppInfo r11 = (AppInfo) this.f9562d.f9576a.get(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.appVersionCode;
    }

    @Override // com.bytedanceos.common.CommonCache
    public void O() {
        if (AccountDataCache.b().n() == true) goto L5;
        return;
    L5:
        if (this.f9564f.f9578c.hasMessages(400) == false) goto L7;
        this.f9564f.f9578c.removeMessages(400);
    L7:
        Handler r10 = this.f9564f.f9578c;
        r10.sendMessage(r10.obtainMessage(400));
        j.a("HANDLER_WHAT_INIT_MYAPPS");
        X0();
        j.a("HANDLER_WHAT_INIT_COLLECT");
    }

    public boolean O0() {
        return this.f9560b;
    }

    public void P0(ArrayList r10) {
        Handler r11 = this.f9561c.f9578c;
        r11.sendMessage(r11.obtainMessage(103, r10));
    }

    public void Q0(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L12;
        Map r11 = this.f9564f.f9576a;
        monitor-enter(r11);
        this.f9564f.f9576a.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void R0(Context r10, AppInfo r11) {
        Intent r12 = new Intent(r10, AppsInstallService.class);
        r12.putExtra(DownloadInfoColumns.TABLE, r11);
        r12.putExtra(WsConstants.ERROR_CODE, BDNetworkTagLaunchType.UNSPECIFIED);
        r10.startService(r12);
    }

    public void S0() {
        BaseApplication r10 = BaseApplication.c();
        boolean r11 = e.v0(r10);
        if (com.bytedanceos.appstore.utils.a.o() == false) goto L18;
        if (r11 == true) goto L26;
        Iterator r12 = this.f9561c.f9576a.values().iterator();
        Map r13 = this.f9561c.f9576a;
        monitor-enter(r13);
    L19:
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r12.hasNext() == false) goto L14;
        AppInfo r14 = (AppInfo) r12.next();     // Catch: Throwable -> L12
        if (r14.mIsNeedGms == false) goto L19;
        R0(r10, r14);     // Catch: Throwable -> L12
        goto L19
    L14:
        monitor-exit(r13);     // Catch: Throwable -> L12
        com.bytedanceos.appstore.utils.a.l();
        return;
    L26:
        return;
    }

    public void T0(boolean r10) {
        b0.n().C("DELETE_HISTORY", r10, null, BaseApplication.c());
    }

    @Override // com.bytedanceos.common.CommonCache
    public boolean U(String r10) {
        return this.f9563e.f9576a.containsKey(r10);
    }

    public void U0(String r10) {
        b0.n().H(r10, "LOADED", null, BaseApplication.c());
    }

    public void V0(AppInfo r10) {
        Handler r11 = this.f9565g.f9578c;
        r11.sendMessage(r11.obtainMessage(600, r10));
    }

    public void W0(boolean r10) {
        if (this.f9567i.f9578c.hasMessages(802) == false) goto L5;
        this.f9567i.f9578c.removeMessages(802);
    L5:
        if (r10 == false) goto L7;
        Handler r11 = this.f9567i.f9578c;
        r11.sendMessage(r11.obtainMessage(802));
        return;
    L7:
        Handler r12 = this.f9567i.f9578c;
        r12.sendMessageDelayed(r12.obtainMessage(802), 180000);
    }

    @Override // com.bytedanceos.common.CommonCache
    public boolean X(String r10) {
        AppInfo r11 = (AppInfo) this.f9561c.f9576a.get(r10);
        if (r11 == null) goto L10;
        int r12 = r11.downloadStatus;
        if (r12 != 4) goto L7;
        return false;
    L7:
        if (r12 == 16) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public void X0() {
        if (this.f9565g.f9578c.hasMessages(506) == false) goto L5;
        this.f9565g.f9578c.removeMessages(506);
    L5:
        Handler r10 = this.f9565g.f9578c;
        r10.sendMessage(r10.obtainMessage(506));
    }

    public void Y0(String r10, boolean r11) {
        if (this.f9563e.f9578c.hasMessages(302) == false) goto L5;
        this.f9563e.f9578c.removeMessages(302);
    L5:
        Message r12 = Message.obtain();
        r12.what = 302;
        r12.obj = r10;
        r12.arg1 = r11 ? 1 : 0;
        this.f9563e.f9578c.sendMessage(r12);
    }

    public final void Z0(int r10) {
        j.e("updateCache size:" + this.f9563e.f9576a.size() + "| count:" + r10 + LibrarianImpl.Constants.SEPARATOR + this.f9354r);
        if (s.n(BaseApplication.c()) == false) goto L6;
        Message r11 = Message.obtain();
        r11.what = 702;
        r11.arg1 = r10;
        this.f9571m.sendMessageDelayed(r11, 1000);
    L6:
        if (r10 == this.f9354r) goto L9;
        this.f9354r = r10;
        e.c1();
        return;
    }

    @Override // com.bytedanceos.common.CommonCache
    public boolean b0(String r10) {
        return this.f9562d.f9576a.containsKey(r10);
    }

    @Override // com.bytedanceos.common.CommonCache
    public void g0(List r10) {
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        AppInfo r12 = (AppInfo) r11.next();
        Intent r13 = new Intent("bytedanceos.appstore.download.remove");
        r13.putExtra(DownloadInfoColumns.TABLE, r12);
        a8.b.e().h(r13);
        goto L4
    }

    @Override // com.bytedanceos.common.CommonCache
    public void h(AppInfo r10) {
        t8.a.a(c8.a.q());
        Handler r11 = this.f9566h.f9578c;
        r11.sendMessage(r11.obtainMessage(901, r10));
    }

    @Override // com.bytedanceos.common.CommonCache
    public void h0(String r10) {
        super.h0(r10);
        EventBus.getDefault().post(new PackageChangeEvent(r10, 1));
        d9.a.e().C(r10, 0);
    }

    @Override // com.bytedanceos.common.CommonCache
    public void i() {
        if (this.f9564f.f9578c.hasMessages(402) == false) goto L5;
        this.f9564f.f9578c.removeMessages(402);
    L5:
        Handler r10 = this.f9564f.f9578c;
        r10.sendMessage(r10.obtainMessage(402));
        j.a("HANDLER_WHAT_CLEAR_MYAPPS");
        if (this.f9565g.f9578c.hasMessages(502) == false) goto L8;
        this.f9565g.f9578c.removeMessages(502);
    L8:
        Handler r11 = this.f9565g.f9578c;
        r11.sendMessage(r11.obtainMessage(502));
        j.a("HANDLER_WHAT_CLEAR_COLLECT");
    }

    @Override // com.bytedanceos.common.CommonCache
    public void i0(String r10) {
        super.i0(r10);
        EventBus.getDefault().post(new PackageChangeEvent(r10, 2));
        d9.a.e().C(r10, 1);
    }

    @Override // com.bytedanceos.common.CommonCache
    public void k() {
        if (this.f9571m.hasMessages(702) == false) goto L6;
        this.f9571m.removeMessages(702);
    L6:
        if (this.f9563e.f9576a.isEmpty() == false) goto L8;
        Z0(0);
        return;
    L8:
        Z0(com.bytedanceos.appstore.utils.a.h(this.f9563e.f9576a, "UPDATE").size());
    }

    @Override // com.bytedanceos.common.CommonCache
    public void k0(AppInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        j.n("remove download app: " + r10.appPackageName);
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        P0(r11);
    }

    @Override // com.bytedanceos.common.CommonCache
    public ArrayList o0(List r10) {
        ArrayList r11 = super.o0(r10);
        if (r11 == null) goto L8;
        if (r11.size() <= 0) goto L8;
        DataBaseManager.DownloadInfoTable.removeDownloadTask(r11);
    L8:
        if (R(false, true) == false) goto L12;
        l(0);
        return null;
    L12:
        return null;
    }

    @Override // com.bytedanceos.common.CommonCache
    public void s0(String r10) {
        AppInfo r11 = (AppInfo) this.f9563e.f9576a.remove(r10);
        if (r11 == null) goto L5;
        DataBaseManager.MyAppsTable.deleteApp(r10);
    L5:
        j.a(r10 + "|" + r11);
        if (r11 == null) goto L9;
        j.n("NtfAppUpdate cancel update notification on app update");
        a8.a.N().c(false);
        return;
    }

    @Override // com.bytedanceos.common.CommonCache
    public void t0(AppInfo r10) {
        Handler r11 = this.f9566h.f9578c;
        r11.sendMessage(r11.obtainMessage(902, r10));
    }

    @Override // com.bytedanceos.common.CommonCache
    public void u0() {
        Intent r10 = new Intent("bytedanceos.appstore.download.downloading");
        a8.b.e().h(r10);
    }

    @Override // com.bytedanceos.common.CommonCache
    public List v(String r10) {
        if (TextUtils.equals(r10, "DOWNLOAD_TASK") == false) goto L7;
        return new ArrayList(this.f9559a.values());
    L7:
        if (TextUtils.equals(r10, "DOWNLOAD") == false) goto L11;
        return n(this.f9561c.f9576a, !d.a() ? 1 : 0);
    L11:
        if (TextUtils.equals(r10, "DOWNLOAD_FAILED") == false) goto L15;
        return m(this.f9569k.f9576a, !d.a() ? 1 : 0);
    L15:
        if (TextUtils.equals(r10, "INSTALLED") == false) goto L19;
        return new ArrayList(this.f9562d.f9576a.values());
    L19:
        if (TextUtils.equals(r10, "UPDATE") == true) goto L69;
        if (TextUtils.equals(r10, "HIDE") == true) goto L69;
        if (TextUtils.equals(r10, "MYAPPS") == false) goto L42;
        ArrayList r11 = new ArrayList();
        Map r12 = this.f9564f.f9576a;
        monitor-enter(r12);
        Iterator r13 = new ArrayList(this.f9564f.f9576a.values()).iterator();     // Catch: Throwable -> L35
    L29:
        if (r13.hasNext() == false) goto L37;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: Throwable -> L35
        if (this.f9562d.f9576a.containsKey(r14.appPackageName) == true) goto L29;
        if (r.b(r14.appPackageName) == false) goto L29;
        r11.add(r14);     // Catch: Throwable -> L35
        goto L29
    L37:
        monitor-exit(r12);     // Catch: Throwable -> L35
        return r11;
    L35:
        th = move-exception;
        throw th;
    L42:
        if (TextUtils.equals(r10, "LOCAL_APPS_ONLINE") == false) goto L63;
        ArrayList r15 = new ArrayList();
        Map r16 = this.f9567i.f9576a;
        monitor-enter(r16);
        boolean r17 = !d.a();     // Catch: Throwable -> L53
        Iterator r18 = new ArrayList(this.f9567i.f9576a.values()).iterator();     // Catch: Throwable -> L53
    L47:
        if (r18.hasNext() == false) goto L58;
        AppInfo r19 = (AppInfo) r18.next();     // Catch: Throwable -> L53
        AppInfo r20 = u(r19.appPackageName);     // Catch: Throwable -> L53
        if (r20 == null) goto L56;
        if (r20.mTaskOwner != r17) goto L47;
    L56:
        if (r.b(r19.appPackageName) == false) goto L47;
        r15.add(r19);     // Catch: Throwable -> L53
        goto L47
    L58:
        monitor-exit(r16);     // Catch: Throwable -> L53
        return r15;
    L53:
        th = move-exception;
        throw th;
    L63:
        if (TextUtils.equals(r10, "WIFIAPPS") == false) goto L67;
        return new ArrayList(this.f9566h.f9576a.values());
    L67:
        return new ArrayList(this.f9565g.f9576a.values());
    L69:
        return com.bytedanceos.appstore.utils.a.h(this.f9563e.f9576a, r10);
    }
}
