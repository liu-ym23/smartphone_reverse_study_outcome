package com.bytedanceos.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import com.bytedanceos.common.eventbus.CollectEvent;
import com.bytedanceos.common.eventbus.MyAppsEvent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.obric.capabilitykit.entity.app.EntityType;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.channels.Channel;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommonCache extends Observable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ConcurrentHashMap f9558p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f9559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f9561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f9562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f9563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f9564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f9565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f9566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f9567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f9568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f9569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f9570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Handler f9571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f9572n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CommonCacheKtx f9573o;

    public class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f9574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonCache f9575b;

        public a(CommonCache r10, String r11) {
            this.f9575b = r10;
            this.f9574a = r11;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            if (r11.contains(this.f9574a) == true) goto L5;
            return false;
        L5:
            String[] r12 = r11.substring(0, r11.lastIndexOf(LibrarianImpl.Constants.DOT)).split("_");
            String r13 = r11.substring(r11.lastIndexOf(LibrarianImpl.Constants.DOT) + 1);
            if ("dm".equals(r13) == true) goto L8;
            return false;
        L8:
            j.n("removeDmFile fileStyle [" + r13 + "]");
            if (r12 != null) goto L11;
        L21:
            j.n("removeDmFile appstore split file failed,[" + r11 + "]");
            return false;
        L11:
            if (r12.length == 0) goto L21;
            String r14 = r12[0];
            int r15 = r12.length - 4;
            int r16 = 1;
        L14:
            if (r16 > r15) goto L17;
            r14 = r14 + "_" + r12[r16];
            r16 = r16 + 1;
            goto L14
        L17:
            if (TextUtils.equals(r14, this.f9574a) == false) goto L20;
            j.n("removeDmFile appstore delete file [" + r11 + "]" + new File(r10, r11).delete());
            return true;
        L20:
            return false;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f9576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HandlerThread f9577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f9578c;

        public class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9579a;

            public a(b r10, Looper r11) {
                this.f9579a = r10;
                super(r11);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                this.f9579a.c(r10);
            }
        }

        public b() {
            this.f9576a = null;
            this.f9577b = null;
            this.f9578c = null;
        }

        public abstract void a(String r10);

        public abstract void b(ArrayList r10);

        public abstract void c(Message r10);

        public void d(String r10) {
            this.f9576a = Collections.synchronizedMap(new AppInfoCache(r10));
            HandlerThread r11 = new HandlerThread(r10);
            this.f9577b = r11;
            r11.start();
            this.f9578c = new a(this, this.f9577b.getLooper());
        }

        public abstract void e(boolean r10, boolean r11);

        public abstract void f();

        public abstract void g(String r10);

        public abstract void h();
    }

    static {
        f9558p = new ConcurrentHashMap();
    }

    public CommonCache() {
        this.f9559a = Collections.synchronizedMap(new LinkedHashMap());
        this.f9560b = false;
        this.f9561c = null;
        this.f9562d = null;
        this.f9563e = null;
        this.f9564f = null;
        this.f9565g = null;
        this.f9566h = null;
        this.f9567i = null;
        this.f9568j = null;
        this.f9569k = null;
        this.f9570l = null;
        this.f9571m = null;
        this.f9572n = new Object();
        this.f9573o = new CommonCacheKtx();
    }

    public static /* synthetic */ boolean a(AppInfo r10) {
        return d0(r10);
    }

    public static /* synthetic */ boolean d0(AppInfo r10) {
        if (r10.downloadStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public synchronized AppInfo A(String r10) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        b r11 = this.f9570l;     // Catch: Throwable -> L14
        if (r11 == null) goto L16;
        Map r12 = r11.f9576a;     // Catch: Throwable -> L14
        if (r12 == null) goto L16;
        if (r12.containsKey(r10) == false) goto L16;
        AppInfo r13 = (AppInfo) this.f9570l.f9576a.get(r10);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r13;
    L16:
        monitor-exit(this);
        return null;
    }

    public void A0() {
        if (this.f9567i.f9578c.hasMessages(EntityType.FILE) == false) goto L5;
        this.f9567i.f9578c.removeMessages(EntityType.FILE);
    L5:
        Handler r10 = this.f9567i.f9578c;
        r10.sendMessage(r10.obtainMessage(EntityType.FILE));
    }

    public int B(String r10) {
        AppInfo r11 = s(r10);
        if (r11 != null) goto L6;
        r11 = new AppInfo();
    L6:
        if (Y(r10) == false) goto L12;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r11.downloadId)) == false) goto L12;
        return r11.downloadStatus;
    L12:
        if (a0(r10) == false) goto L16;
        return 16;
    L16:
        return r11.appState;
    }

    public void B0() {
        if (this.f9564f.f9578c.hasMessages(407) == false) goto L5;
        this.f9564f.f9578c.removeMessages(407);
    L5:
        Handler r10 = this.f9564f.f9578c;
        r10.sendMessage(r10.obtainMessage(407));
    }

    public ArrayList C() {
        ArrayList r10 = new ArrayList();
        b r11 = this.f9561c;
        if (r11 != null) goto L5;
    L15:
        return r10;
    L5:
        if (r11.f9576a.isEmpty() == true) goto L15;
        Iterator r12 = this.f9561c.f9576a.values().iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        AppInfo r13 = (AppInfo) r12.next();
        if (r13.downloadStatus != 8) goto L9;
        if (TextUtils.equals(r13.notifyPkgName, BaseApplication.c().getPackageName()) == false) goto L9;
        r10.add(r13);
        goto L9
    }

    public void C0() {
        Object r10 = this.f9572n;
        monitor-enter(r10);
        this.f9561c.f9578c.removeMessages(101);     // Catch: Throwable -> L9
        Map r11 = q8.a.b().g();     // Catch: Throwable -> L9
        if (r11.isEmpty() == true) goto L7;
    L11:
        this.f9561c.f9576a = r11;     // Catch: Throwable -> L9
        q(0);     // Catch: Throwable -> L9
        e0(r11.values());     // Catch: Throwable -> L9
        u0();     // Catch: Throwable -> L9
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.f9561c.f9576a.isEmpty() == true) goto L12;
    L9:
        th = move-exception;
        throw th;
    }

    public AppInfo D(String r10) {
        return (AppInfo) this.f9562d.f9576a.get(r10);
    }

    public void D0(AppInfo r10, int r11) {
        ArrayList r12 = new ArrayList();
        r12.add(r10);
        E0(r12, r11);
    }

    public AppInfo E() {
        AppInfo r10 = null;
        if (this.f9559a.isEmpty() == false) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList(this.f9559a.values());
        int r12 = r11.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L42;
        AppInfo r14 = (AppInfo) r11.get(r13);
        if (BaseApplication.c().o() == false) goto L13;
        if (r14.mTaskOwner != 0) goto L31;
    L15:
        AppInfo r15 = t(r14.appPackageName);
        if (r15 != null) goto L18;
    L22:
        if (r15 == null) goto L27;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r15.downloadId)) == true) goto L31;
    L27:
        if (r14.isAutoDownload == false) goto L32;
        if (r10 != null) goto L31;
        r10 = r14;
        goto L31
    L32:
        return r14;
    L18:
        if (1006 == r15.appState) goto L31;
        if ((-4) != r15.appState) goto L22;
    L31:
        r13 = r13 + 1;
        goto L6
    L13:
        if (r14.mTaskOwner == 1) goto L15;
    L42:
        return r10;
    }

    public void E0(List r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L27;
        StringBuilder r12 = new StringBuilder();
        r12.append("[");
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L20;
        AppInfo r14 = (AppInfo) r13.next();
        r14.downloadStatus = r11;
        AppInfo r15 = (AppInfo) this.f9559a.get(r14.appPackageName);
        if (r15 == null) goto L12;
        r14.mJsonData = r15.mJsonData;
        r15.downloadStatus = r11;
    L12:
        AppInfo r16 = (AppInfo) this.f9561c.f9576a.get(r14.appPackageName);
        if (r16 == null) goto L16;
        r16.downloadStatus = r11;
        this.f9561c.f9576a.put(r14.appPackageName, r16);
        r14.mTaskOwner = r16.mTaskOwner;
    L19:
        this.f9559a.put(r14.appPackageName, r14);
        r12.append(r14.appName + ",");
        goto L8
    L16:
        if (BaseApplication.c().o() == false) goto L18;
        r14.mTaskOwner = 0;
        goto L19
    L18:
        r14.mTaskOwner = 1;
        goto L19
    L20:
        r12.append("status = " + r11 + "]");
        j.n(r12.toString());
        e0(r10);
        DataBaseManager.DownloadInfoTable.updateDownloadTask(r10);
        return;
    }

    public abstract long F();

    public void F0() {
        Map<String, AppInfo> r10 = DataBaseManager.MyAppsTable.query(null);
        this.f9567i.f9576a.clear();
        this.f9567i.f9576a.putAll(r10);
        Iterator<AppInfo> r11 = r10.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        AppInfo r12 = r11.next();
        if (r12.mAppUpdateType <= 0) goto L4;
        AppInfo r13 = (AppInfo) this.f9562d.f9576a.get(r12.appPackageName);
        if (r13 == null) goto L9;
        if (r12.appVersionCode <= r13.appVersionCode) goto L12;
        if (r12.sha256 == null) goto L4;
        this.f9563e.f9576a.put(r12.appPackageName, r12);
        goto L4
    L12:
        r12.mAppUpdateType = 0;
        goto L4
    L9:
        r12.mAppUpdateType = 0;
        goto L4
    L16:
        f0();
    }

    public AppInfo G(String r10) {
        return (AppInfo) this.f9563e.f9576a.get(r10);
    }

    public final void G0(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        int r11 = B(r10);
        ConcurrentHashMap r12 = f9558p;
        if (((Integer) ((Pair) r12.getOrDefault(r10, Pair.create(Integer.MIN_VALUE, 0L))).first).intValue() == r11) goto L9;
        r12.put(r10, Pair.create(Integer.valueOf(r11), 0L));
        return;
    }

    public boolean H() {
        if (this.f9563e.f9576a.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator r10 = this.f9563e.f9576a.values().iterator();
    L8:
        if (r10.hasNext() == false) goto L14;
        AppInfo r11 = (AppInfo) r10.next();
        if (r11.appVersionCode == r11.hideVersionCode) goto L8;
        if (r11.mAppUpdateType != 2) goto L8;
    L14:
        return true;
    }

    public boolean I() {
        Map r10 = this.f9559a;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.isEmpty() == true) goto L7;
        return true;
    L7:
        if (this.f9561c.f9576a.isEmpty() == true) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean J() {
        return this.f9559a.values().stream().anyMatch(new com.bytedanceos.common.b());
    }

    public void K(AppInfo r10, boolean r11) {
        AppInfo r12 = (AppInfo) this.f9563e.f9576a.get(r10.appPackageName);
        if (r11 == false) goto L5;
        this.f9573o.a(r10);
    L5:
        if (r12 == null) goto L9;
        if (r11 == false) goto L8;
        r12.hideVersionCode = Channel.UNLIMITED;
        r12.mAppUpdateType = 1;
        t(r10.appPackageName);
        goto L9
    L8:
        r12.hideVersionCode = 0;
    L9:
        DataBaseManager.MyAppsTable.update(r12);
        k();
    }

    public abstract void L();

    public void M(Map r10) {
        if (r10 != null) goto L5;
    L41:
        j.m("no update apps:");
        DataBaseManager.MyAppsTable.deleteApps(null);
        return;
    L5:
        if (r10.isEmpty() == true) goto L41;
        HashMap r11 = new HashMap();
        HashMap r12 = new HashMap();
        Map<String, AppInfo> r13 = DataBaseManager.MyAppsTable.query(null);
        Iterator r14 = r10.values().iterator();
    L9:
        if (r14.hasNext() == false) goto L34;
        AppInfo r15 = (AppInfo) r14.next();
        AppInfo r16 = r13.get(r15.appPackageName);
        if (r16 == null) goto L12;
        if (r15.appVersionCode != r16.appVersionCode) goto L20;
        if (TextUtils.equals(r15.appDownloadUrl, r16.appDownloadUrl) == false) goto L20;
        if (TextUtils.equals(r15.appCategoryName, r16.appCategoryName) == true) goto L9;
    L20:
        int r17 = r15.appVersionCode;
        int r18 = r16.appVersionCode;
        if (r17 >= r18) goto L23;
        r15.mAppUpdateType = 0;
    L28:
        int r19 = r15.appVersionCode;
        int r20 = r16.hideVersionCode;
        if (r19 <= r20) goto L31;
        r15.hideVersionCode = 0;
    L32:
        r11.put(r15.appPackageName, r15);
        goto L9
    L31:
        r15.hideVersionCode = r20;
        goto L32
    L23:
        if (r17 <= r18) goto L25;
        r15.mAppUpdateType = 1;
        goto L28
    L25:
        r15.mAppUpdateType = r16.mAppUpdateType;
        if (TextUtils.equals(r15.appDownloadUrl, r16.appDownloadUrl) == false) goto L28;
        r15.mDiffMD5 = r16.mDiffMD5;
        r15.mDiffDownloadUrl = r16.mDiffDownloadUrl;
        goto L28
    L12:
        r12.put(r15.appPackageName, r15);
        goto L9
    L34:
        if (r12.size() <= 0) goto L37;
        DataBaseManager.MyAppsTable.insert(r12);
    L37:
        if (r11.size() <= 0) goto L39;
        DataBaseManager.MyAppsTable.update(r11);
        this.f9563e.f9576a.putAll(r());
        EventBus.getDefault().post(new AddUpdateEvent());
    L39:
        j.n("insertLocalDB: " + r12.size() + " | " + r11.size());
    }

    public void N(boolean r10) {
        if (this.f9562d.f9576a.size() > 0) goto L5;
        j.m("no local installed apps");
    L12:
        if (AccountDataCache.b().n() == true) goto L14;
        return;
    L14:
        if (this.f9564f.f9576a.isEmpty() == false) goto L17;
        this.f9564f.f();
    L17:
        if (s.j("sync_collect_last_time") == false) goto L21;
        this.f9565g.h();
        s.t("sync_collect_last_time");
        return;
    L21:
        return;
    L5:
        if (this.f9567i.f9576a.isEmpty() == false) goto L7;
        this.f9567i.e(true, r10);
        goto L12
    L7:
        this.f9567i.e(false, r10);
        List r11 = com.bytedanceos.common.toolbox.e.q(this.f9562d.f9576a, this.f9567i.f9576a);
        if (r11.size() <= 0) goto L12;
        DataBaseManager.MyAppsTable.deleteApps(r11);
        j.n("clear uninstaled app data:" + r11.size());
        goto L12
    }

    public abstract void O();

    public void P() {
        Handler r10 = this.f9571m;
        if (r10 == null) goto L6;
        r10.sendEmptyMessage(700);
        return;
    }

    public void Q(Map r10) {
        Map<String, AppInfo> r11 = DataBaseManager.MyAppsTable.query(null);
        LinkedHashMap r12 = new LinkedHashMap();
        this.f9563e.f9576a.clear();
        Iterator<AppInfo> r13 = r11.values().iterator();
    L4:
        if (r13.hasNext() == false) goto L39;
        AppInfo r14 = r13.next();
        if (r10 == null) goto L31;
        if (r10.containsKey(r14.appPackageName) == false) goto L31;
        AppInfo r15 = (AppInfo) r10.remove(r14.appPackageName);
        r15.isAppUpdate = true;
        int r16 = r15.appVersionCode;
        int r17 = r14.hideVersionCode;
        if (r16 <= r17) goto L12;
        r15.hideVersionCode = 0;
    L14:
        if (r16 != r15.hideVersionCode) goto L16;
        r15.mAppUpdateType = 1;
    L16:
        r15.appState = 64;
        r15.mApiUrl = BaseApplication.c().j();
        if (r15.appVersionCode == r14.appVersionCode) goto L19;
    L28:
        r12.put(r15.appPackageName, r15);
    L29:
        this.f9563e.f9576a.put(r15.appPackageName, r15);
        goto L4
    L19:
        if (r15.mAppUpdateType != r14.mAppUpdateType) goto L28;
        if (TextUtils.equals(r15.appCategoryName, r14.appCategoryName) == false) goto L28;
        if (TextUtils.equals(r15.appDownloadUrl, r14.appDownloadUrl) == false) goto L28;
        if (TextUtils.equals(r15.mMemUrl, r14.mMemUrl) == false) goto L28;
        if (TextUtils.equals(r15.mDmUrl, r14.mDmUrl) == true) goto L29;
    L12:
        r15.hideVersionCode = r17;
    L31:
        if (r14.mAppUpdateType <= 0) goto L4;
        AppInfo r18 = D(r14.appPackageName);
        if (r18 != null) goto L35;
    L37:
        r14.mAppUpdateType = 0;
        r14.appState = 128;
        r14.hideVersionCode = 0;
    L38:
        r12.put(r14.appPackageName, r14);
        goto L4
    L35:
        if (r18.appVersionCode >= r14.hideVersionCode) goto L37;
        r14.mAppUpdateType = 1;
        r14.mApiUrl = BaseApplication.c().j();
        this.f9563e.f9576a.put(r14.appPackageName, r14);
        goto L38
    L39:
        if (r10 != null) goto L41;
    L47:
        DataBaseManager.MyAppsTable.update(r12);
        return;
    L41:
        if (r10.size() <= 0) goto L47;
        j.n("[AutoUpdate][AppStatus] new update 3rd-app available, size:" + r10.size());
        Iterator r19 = r10.values().iterator();
    L44:
        if (r19.hasNext() == false) goto L46;
        AppInfo r20 = (AppInfo) r19.next();
        r20.isAppUpdate = true;
        r20.appState = 64;
        r20.mApiUrl = BaseApplication.c().j();
        this.f9563e.f9576a.put(r20.appPackageName, r20);
        goto L44
    L46:
        DataBaseManager.MyAppsTable.insert(r10);
    }

    public boolean R(boolean r10, boolean r11) {
        Map r12 = this.f9561c.f9576a;
        monitor-enter(r12);
        String r13 = BaseApplication.c().getPackageName();     // Catch: Throwable -> L15
        Iterator r14 = this.f9561c.f9576a.values().iterator();     // Catch: Throwable -> L15
        boolean r15 = false;
        int r16 = 0;
    L6:
        if (r14.hasNext() == false) goto L46;
        AppInfo r17 = (AppInfo) r14.next();     // Catch: Throwable -> L15
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r17.downloadId)) == false) goto L10;
        if (r11 == true) goto L24;
        if (r17.isAutoDownload == true) goto L6;
    L24:
        String r18 = r17.notifyPkgName;     // Catch: Throwable -> L15
        if (r18 == null) goto L32;
        if (r18.trim().length() <= 0) goto L32;
        if (TextUtils.equals(r17.notifyPkgName, r13) == false) goto L6;
    L32:
        if (TextUtils.equals(r17.appPackageName, "com.bytedance.gms") == true) goto L6;
        if (BaseApplication.c().o() == false) goto L41;
        if (com.bytedanceos.common.toolbox.d.f10011c.contains(r17.appSource) == true) goto L6;
        if (r17.isSystemApp() == true) goto L6;
    L41:
        j.l("isAllowDownloadApp" + r17.appPackageName + ", " + r17.downloadStatus + ", " + r17.pauseCode);     // Catch: Throwable -> L15
        int r19 = r17.downloadStatus;     // Catch: Throwable -> L15
        if (r19 == 1) goto L45;
        if (r19 != 2) goto L6;
    L45:
        j.l("isAllowDownloadApp download" + r17.appPackageName);     // Catch: Throwable -> L15
        r16 = r16 + 1;     // Catch: Throwable -> L15
        goto L6
    L10:
        if (BaseApplication.c().o() == false) goto L18;
        if (r17.mTaskOwner == 0) goto L13;
    L14:
        r10 = false;
    L13:
        r10 = true;
        goto L6
    L18:
        if (r17.mTaskOwner != 1) goto L14;
    L46:
        if (r10 == true) goto L48;
    L50:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return r15;
    L48:
        if (r16 >= 200) goto L50;
        r15 = true;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean S(String r10) {
        return TextUtils.equals("LOADING", b0.n().t(r10, null, BaseApplication.c(), "UNLOAD"));
    }

    public boolean T(String r10) {
        return TextUtils.equals("UNLOAD", b0.n().t(r10, null, BaseApplication.c(), "UNLOAD"));
    }

    public abstract boolean U(String r10);

    public boolean V(String r10) {
        return this.f9565g.f9576a.containsKey(r10);
    }

    public boolean W(String r10) {
        return this.f9561c.f9576a.containsKey(r10);
    }

    public boolean X(String r10) {
        AppInfo r11 = (AppInfo) this.f9561c.f9576a.get(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.downloadStatus == 4) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean Y(String r10) {
        return this.f9561c.f9576a.containsKey(r10);
    }

    public boolean Z(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L12;
        b r11 = this.f9568j;
        if (r11 == null) goto L14;
        Map r12 = r11.f9576a;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.containsKey(r10) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L12:
        return false;
    }

    public boolean a0(String r10) {
        return this.f9569k.f9576a.containsKey(r10);
    }

    public void b(AppInfo r10) {
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        c(r11, r10.downloadStatus);
    }

    public abstract boolean b0(String r10);

    public void c(List r10, int r11) {
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        StringBuilder r14 = new StringBuilder();
        Iterator r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L21;
        AppInfo r16 = (AppInfo) r15.next();
        if (r16.downloadStatus != 2) goto L8;
        r16.notifyPkgName = BaseApplication.c().getPackageName();
    L10:
        if (r16.timeDownloadEnqueue > 0) goto L13;
        r16.timeDownloadEnqueue = System.currentTimeMillis();
        j.a("update time download enqueue [" + r16.timeDownloadEnqueue + "], pgk: " + r16.appPackageName);
    L13:
        if (BaseApplication.c().o() == true) goto L15;
        r16.mAppType = 1;
        r16.mTaskOwner = 1;
    L15:
        r16.downloadStatus = r11;
        if (this.f9559a.containsKey(r16.appPackageName) == false) goto L18;
        r12.add(r16);
        r14.append("[update:" + r16.appName + ",id =" + r16.downloadId + "]");
    L19:
        this.f9561c.f9576a.put(r16.appPackageName, r16);
        this.f9559a.put(r16.appPackageName, r16);
        this.f9569k.f9576a.remove(r16.appPackageName);
        goto L4
    L18:
        r13.add(r16);
        r14.append("[insert" + r16.appName + ",id =" + r16.downloadId + "]");
        goto L19
    L8:
        r16.notifyPkgName = "";
        goto L10
    L21:
        if (r13.size() <= 0) goto L24;
        DataBaseManager.DownloadInfoTable.addDownloadTask(r13);
    L24:
        if (r12.size() <= 0) goto L26;
        DataBaseManager.DownloadInfoTable.updateDownloadTask(r12);
    L26:
        j.n("addDownloadCache:" + r14.toString() + ",status =" + r11);
        EventBus.getDefault().post(new MyAppsEvent());
        e0(r10);
    }

    public boolean c0(String r10) {
        AppInfo r11 = (AppInfo) this.f9561c.f9576a.get(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.downloadStatus != 4) goto L9;
        return true;
    L9:
        return false;
    }

    public synchronized void d(String r10, AppInfo r11) {
        monitor-enter(this);
        this.f9570l.f9576a.put(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void e(Map r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r10.values().iterator();
    L4:
        if (r13.hasNext() == false) goto L35;
        AppInfo r14 = (AppInfo) r13.next();
        AppInfo r15 = (AppInfo) this.f9562d.f9576a.get(r14.appPackageName);
        if (r15 == null) goto L7;
        AppInfo r16 = (AppInfo) this.f9567i.f9576a.get(r14.appPackageName);
        if (r16 != null) goto L17;
        if (r14.appVersionCode <= r15.appVersionCode) goto L14;
        r14.mAppUpdateType = 1;
    L15:
        r12.put(r14.appPackageName, r14);
    L26:
        if (r14.mAppUpdateType <= 0) goto L28;
        r14.isAppUpdate = true;
        r14.appState = 64;
        this.f9563e.f9576a.put(r14.appPackageName, r14);
    L28:
        this.f9567i.f9576a.put(r14.appPackageName, r14);
        if (r11.size() <= 0) goto L32;
        DataBaseManager.MyAppsTable.update(r11);
    L32:
        if (r12.size() <= 0) goto L34;
        DataBaseManager.MyAppsTable.insert(r12);
    L34:
        k();
        j.a("update local cache:" + r11.size() + " | " + r12.size());
        goto L4
    L14:
        r14.mAppUpdateType = 0;
        goto L15
    L17:
        if (r14.appVersionCode <= r16.appVersionCode) goto L19;
        r14.mAppUpdateType = 1;
    L20:
        int r17 = r14.appVersionCode;
        int r18 = r16.hideVersionCode;
        if (r17 != r18) goto L23;
        r14.hideVersionCode = r18;
    L24:
        r11.put(r14.appPackageName, r14);
        goto L26
    L23:
        r14.hideVersionCode = 0;
        goto L24
    L19:
        r14.mAppUpdateType = 0;
        goto L20
    L7:
        j.n("no installed." + r14.appPackageName);
        return;
    }

    public void e0(Collection r10) {
        if (com.bytedanceos.common.toolbox.c.a(r10) == true) goto L11;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        G0(((AppInfo) r11.next()).appPackageName);
        goto L6
    L8:
        f0();
        return;
    }

    public synchronized void f(AppInfo r10) {
        monitor-enter(this);
        Handler r11 = this.f9565g.f9578c;     // Catch: Throwable -> L6
        r11.sendMessage(r11.obtainMessage(503, r10));     // Catch: Throwable -> L6
        EventBus.getDefault().post(new CollectEvent(3, r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void f0() {
        setChanged();
        notifyObservers();
    }

    public void g(AppInfo r10, AppInfo r11) {
        r10.appState = 64;
        r10.isAppUpdate = true;
        r10.isNeededSync = false;
        r10.mAppUpdateType = 1;
        this.f9563e.f9576a.put(r10.appPackageName, r10);
        AppInfo r12 = r10.clone();
        r11.isAppUpdate = true;
        r11.isNeededSync = false;
        r11.mAppUpdateType = 1;
        Handler r13 = this.f9563e.f9578c;
        r13.sendMessage(r13.obtainMessage(300, r12));
        f0();
    }

    public abstract void g0(List r10);

    public abstract void h(AppInfo r10);

    public void h0(String r10) {
        this.f9562d.a(r10);
        AppInfo r11 = s(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        ArrayList r12 = new ArrayList(1);
        r12.add(r11);
        e0(r12);
        u0();
    }

    public abstract void i();

    public void i0(String r10) {
        this.f9562d.g(r10);
        ArrayList r11 = new ArrayList(1);
        AppInfo r12 = new AppInfo();
        r12.appPackageName = r10;
        r11.add(r12);
        e0(r11);
    }

    public int j(List r10) {
        return this.f9573o.b(r10);
    }

    public final void j0(String r10) {
        com.bytedanceos.common.toolbox.e.H().listFiles(new a(this, r10));
    }

    public abstract void k();

    public abstract void k0(AppInfo r10);

    public synchronized void l(long r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f9561c.f9578c.hasMessages(102) == false) goto L8;
        this.f9561c.f9578c.removeMessages(102);     // Catch: Throwable -> L6
    L8:
        Message r11 = this.f9561c.f9578c.obtainMessage(102);     // Catch: Throwable -> L6
        if (r10 <= 0) goto L11;
        this.f9561c.f9578c.sendMessageDelayed(r11, r10);     // Catch: Throwable -> L6
    L12:
        j.n("download next:" + r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L11:
        this.f9561c.f9578c.sendMessage(r11);     // Catch: Throwable -> L6
        goto L12
    }

    public synchronized void l0(String r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        b r11 = this.f9561c;     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        Map r12 = r11.f9576a;     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        if (r12.containsKey(r10) == false) goto L15;
        this.f9561c.f9576a.remove(r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
    }

    public ArrayList m(Map r10, int r11) {
        monitor-enter(r10);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r13 = r10.values().iterator();     // Catch: Throwable -> L11
    L5:
        if (r13.hasNext() == false) goto L13;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: Throwable -> L11
        if (r14 == null) goto L5;
        if (r14.mTaskOwner != r11) goto L5;
        r12.add(r14);     // Catch: Throwable -> L11
        goto L5
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void m0(String r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        b r11 = this.f9569k;     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        Map r12 = r11.f9576a;     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        if (r12.containsKey(r10) == false) goto L15;
        this.f9569k.f9576a.remove(r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
    }

    public ArrayList n(Map r10, int r11) {
        monitor-enter(r10);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L11
        Iterator r13 = r10.values().iterator();     // Catch: Throwable -> L11
    L5:
        if (r13.hasNext() == false) goto L13;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: Throwable -> L11
        AppInfo r15 = u(r14.appPackageName);     // Catch: Throwable -> L11
        if (r15 == null) goto L5;
        if (r15.mTaskOwner != r11) goto L5;
        r12.add(r14);     // Catch: Throwable -> L11
        goto L5
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void n0(String r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        b r11 = this.f9570l;     // Catch: Throwable -> L13
        if (r11 == null) goto L15;
        Map r12 = r11.f9576a;     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        if (r12.containsKey(r10) == false) goto L15;
        this.f9570l.f9576a.remove(r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
    }

    public final void o(Map r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.values().iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        AppInfo r13 = (AppInfo) r12.next();
        AppInfo r14 = D(r13.appPackageName);
        if (r14 == null) goto L6;
        if (r14.appVersionCode < r13.appVersionCode) goto L6;
        j.n("filterInstalledForUpdate:" + r14.appPackageName + "," + r14.appVersionCode + "," + r13.appVersionCode);
        r11.add(r13.appPackageName);
        goto L6
    L13:
        if (r11.isEmpty() == true) goto L15;
        j.n("filterInstalledForUpdate removeList:" + r11.size() + "," + r10.size());
    L15:
        Iterator r15 = r11.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        r10.remove((String) r15.next());
        goto L17
    }

    public ArrayList o0(List r10) {
        if (r10 != null) goto L4;
    L37:
        j.a("imput params error");
        return null;
    L4:
        if (r10.isEmpty() == true) goto L37;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L16;
        AppInfo r13 = (AppInfo) r12.next();
        if (r13 == null) goto L8;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r13.downloadId)) == false) goto L8;
        r11.add(Long.valueOf(r13.downloadId));
        goto L8
    L16:
        if (r11.size() <= 0) goto L25;
        long[] r14 = new long[r11.size()];
        int r15 = 0;
    L19:
        if (r15 >= r11.size()) goto L39;
        r14[r15] = ((Long) r11.get(r15)).longValue();
        r15 = r15 + 1;
        goto L19
    L39:
        com.bytedanceos.common.download.b.l().q(true, r14);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L25:
        ArrayList r16 = new ArrayList();
        StringBuilder r17 = new StringBuilder();
        Iterator r18 = r10.iterator();
    L27:
        if (r18.hasNext() == false) goto L35;
        AppInfo r19 = (AppInfo) r18.next();
        if (r19 == null) goto L27;
        r16.add(r19);
        this.f9561c.f9576a.remove(r19.appPackageName);
        this.f9559a.remove(r19.appPackageName);
        AppInfo r20 = (AppInfo) this.f9563e.f9576a.get(r19.appPackageName);
        if (r20 == null) goto L34;
        r20.downloadId = 0;
    L34:
        r17.append("[" + r19.appName + ",download_id:" + r19.downloadId + "]");
        j0(r19.appPackageName);
        goto L27
    L35:
        j.n("remove cache:" + r17.toString());
        EventBus.getDefault().post(new MyAppsEvent());
        f0();
        e0(r10);
        g0(r10);
        u0();
        return r16;
    }

    public void p(Map r12) {
        ArrayList r10 = new ArrayList();
        Iterator r13 = r12.entrySet().iterator();
        boolean r11 = false;
    L4:
        if (r13.hasNext() == false) goto L43;
        AppInfo r14 = (AppInfo) ((Map.Entry) r13.next()).getValue();
        if (this.f9559a.get(r14.appPackageName) == null) goto L7;
        if (r14.downloadStatus != 8) goto L4;
        if (TextUtils.equals(r14.notifyPkgName, BaseApplication.c().getPackageName()) == false) goto L4;
        if (r14.downloadFilePath == null) goto L15;
        if (new File(r14.downloadFilePath).exists() == true) goto L18;
        if (r14.downloadFilePath.endsWith(".apk") == false) goto L24;
        String r15 = r14.downloadFilePath.replace(".apk", "_bak.apk");
    L30:
        File r16 = new File(r15);
        if (r16.exists() == true) goto L34;
        r10.add(r14);
        r13.remove();
        j.n("delete invalid data," + r16.getName() + ",id =" + r14.downloadId);
        goto L4
    L34:
        if ((System.currentTimeMillis() - r16.lastModified()) > 259200000) goto L41;
        if (TextUtils.equals(r14.appPackageName, BaseApplication.c().getPackageName()) == false) goto L40;
        if (BaseApplication.c().getVersionCode() >= r14.appVersionCode) goto L41;
    L40:
        j.n("install app:" + r16.getName());
    L19:
        r11 = true;
    L41:
        r10.add(r14);
        r13.remove();
        j.n("delete invalid file," + r16.getName() + ",id =" + r14.downloadId + ",isDetele =" + r16.delete());
        goto L4
    L24:
        if (r14.downloadFilePath.endsWith(".patch") == false) goto L27;
        r15 = r14.downloadFilePath.replace(".patch", "_bak.patch");
        goto L30
    L27:
        if (r14.downloadFilePath.endsWith(".zip") == false) goto L29;
        r15 = r14.downloadFilePath.replace(".zip", "_bak.zip");
        goto L30
    L29:
        r15 = "";
        goto L30
    L18:
        j.e("file exist," + r14.appPackageName + ",id =" + r14.downloadId);
        goto L19
    L15:
        j.e("error data," + r14.appPackageName + ",id =" + r14.downloadId);
        goto L4
    L7:
        r10.add(r14);
        goto L4
    L43:
        if (r10.size() <= 0) goto L45;
        o0(r10);
    L45:
        if (r11 == false) goto L70;
        com.bytedanceos.common.toolbox.e.h0();
        return;
    }

    public void p0(AppInfo r10) {
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        o0(r11);
    }

    public void q(long r11) {
        if (this.f9559a.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList();
        LinkedHashMap r12 = new LinkedHashMap();
        Map r13 = this.f9559a;
        monitor-enter(r13);
        HashMap r14 = new HashMap(this.f9559a);     // Catch: Throwable -> L64
        monitor-exit(r13);     // Catch: Throwable -> L64
        Iterator r15 = r14.values().iterator();
        boolean r16 = false;
    L11:
        if (r15.hasNext() == false) goto L31;
        AppInfo r17 = (AppInfo) r15.next();
        AppInfo r18 = (AppInfo) this.f9561c.f9576a.get(r17.appPackageName);
        if (r18 != null) goto L14;
        int r19 = r17.downloadStatus;
        if (r19 == 1) goto L30;
        if (r19 == 16) goto L30;
        if (r17.isSystemApp() == true) goto L30;
        if (TextUtils.equals(r17.appPackageName, "com.bytedance.gms") == true) goto L28;
        r10.add(r17);
        goto L11
    L28:
        r10.add(r17);
        r16 = true;
    L30:
        r12.put(r17.appPackageName, r17);
        goto L11
    L14:
        r18.mTaskOwner = r17.mTaskOwner;
        r18.timeDownloadEnqueue = r17.timeDownloadEnqueue;
        if (r17.downloadStatus != 4) goto L11;
        if (BaseApplication.c().r() == true) goto L11;
        this.f9559a.put(r18.appPackageName, r18);
        goto L11
    L31:
        if (r16 == false) goto L52;
        Map r20 = this.f9561c.f9576a;
        monitor-enter(r20);
        Iterator r21 = this.f9561c.f9576a.values().iterator();     // Catch: Throwable -> L40
    L36:
        if (r21.hasNext() == false) goto L42;
        AppInfo r22 = (AppInfo) r21.next();     // Catch: Throwable -> L40
        if (r22.mIsNeedGms == false) goto L36;
        r10.add(r22);     // Catch: Throwable -> L40
        r12.remove(r22.appPackageName);     // Catch: Throwable -> L40
        goto L36
    L42:
        monitor-exit(r20);     // Catch: Throwable -> L40
        Iterator r23 = r12.entrySet().iterator();
    L45:
        if (r23.hasNext() == false) goto L52;
        AppInfo r24 = (AppInfo) ((Map.Entry) r23.next()).getValue();
        if (r24.mIsNeedGms == false) goto L45;
        r10.add(r24);
        r23.remove();
    L40:
        th = move-exception;
        throw th;
    L52:
        if (r10.size() <= 0) goto L59;
        StringBuilder r25 = new StringBuilder();
        Iterator r26 = r10.iterator();
    L55:
        if (r26.hasNext() == false) goto L57;
        AppInfo r27 = (AppInfo) r26.next();
        r25.append("[");
        r25.append(r27.appName);
        r25.append(",download_id:");
        r25.append(r27.downloadId);
        r25.append("], ");
        goto L55
    L57:
        j.n("[AppStatus][CommonCache] filterPendingTask. removeDownloadTask task =" + r25);
        o0(r10);
        j.a("delete task =" + r10.size());
    L59:
        if (r12.size() <= 0) goto L100;
        this.f9561c.f9576a.putAll(r12);
        if (R(false, true) == false) goto L101;
        l(r11);
        return;
    L101:
        return;
    L100:
        return;
    L64:
        th = move-exception;
        throw th;
    }

    public synchronized void q0(ArrayList r10, boolean r11) {
        monitor-enter(this);
        if (r11 == false) goto L7;
        this.f9564f.b(r10);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return;
    L7:
        Handler r12 = this.f9564f.f9578c;     // Catch: Throwable -> L5
        r12.sendMessage(r12.obtainMessage(409, r10));     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public Map r() {
        Map<String, AppInfo> r10 = DataBaseManager.MyAppsTable.getAllUpdateApps();
        o(r10);
        return r10;
    }

    public synchronized void r0(AppInfo r10) {
        monitor-enter(this);
        Handler r11 = this.f9565g.f9578c;     // Catch: Throwable -> L6
        r11.sendMessage(r11.obtainMessage(504, r10));     // Catch: Throwable -> L6
        EventBus.getDefault().post(new CollectEvent(4, r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public AppInfo s(String r10) {
        if (this.f9561c.f9576a.containsKey(r10) == false) goto L6;
        return (AppInfo) this.f9561c.f9576a.get(r10);
    L6:
        if (this.f9566h.f9576a.containsKey(r10) == false) goto L11;
        AppInfo r11 = (AppInfo) this.f9566h.f9576a.get(r10);
        if (r11 == null) goto L26;
        r11.appState = 4;
        return r11;
    L26:
        return r11;
    L11:
        if (this.f9563e.f9576a.containsKey(r10) == false) goto L21;
        AppInfo r12 = (AppInfo) this.f9563e.f9576a.get(r10);
        if (r12 == null) goto L28;
        r12.appState = 64;
        AppInfo r13 = (AppInfo) this.f9562d.f9576a.get(r10);
        if (r13 == null) goto L28;
        if (r13.appVersionCode < r12.appVersionCode) goto L28;
        r12.appState = 128;
    L28:
        return r12;
    L21:
        if (this.f9562d.f9576a.containsKey(r10) == true) goto L29;
        return null;
    L29:
        return (AppInfo) this.f9562d.f9576a.get(r10);
    }

    public abstract void s0(String r10);

    public AppInfo t(String r10) {
        return (AppInfo) this.f9561c.f9576a.get(r10);
    }

    public abstract void t0(AppInfo r10);

    public AppInfo u(String r10) {
        return (AppInfo) this.f9559a.get(r10);
    }

    public abstract void u0();

    public abstract List v(String r10);

    public void v0(String r10) {
        b0.n().H(r10, "LOADING", null, BaseApplication.c());
    }

    public long w(AppInfo r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        AppInfo r11 = (AppInfo) this.f9562d.f9576a.get(r10.appPackageName);
        if (r11 != null) goto L8;
    L10:
        AppInfo r12 = (AppInfo) this.f9561c.f9576a.get(r10.appPackageName);
        if (r12 != null) goto L15;
        return r10.appBytes;
    L15:
        if (r12.downloadStatus != 4) goto L20;
        long r13 = r12.downloadTotalBytes - r12.downloadCurrentBytes;
        if (r13 < 0) goto L19;
        return r13;
    L19:
        return r12.appBytes;
    L20:
        return 0;
    L8:
        if (r11.appVersionCode > r10.appVersionCode) goto L10;
        return 0;
    }

    public void w0(String r10) {
        b0.n().H(r10, "UNLOAD", null, BaseApplication.c());
    }

    public int x(String r10) {
        if (U(r10) == false) goto L7;
        return 64;
    L7:
        if (b0(r10) == false) goto L10;
        return 128;
    L10:
        return 32;
    }

    public synchronized void x0() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public long y(List r10) {
        ArrayList r11 = new ArrayList();
        if (r10 == null) goto L5;
        r11.addAll(r10);
    L6:
        Iterator r12 = r11.iterator();
        long r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L10;
        r13 = r13 + w((AppInfo) r12.next());
        goto L8
    L10:
        return r13;
    L5:
        r11.addAll(this.f9564f.f9576a.values());
        goto L6
    }

    public void y0() {
        Map<String, AppInfo> r10 = DataBaseManager.DownloadInfoTable.getAllDownloadTask(false);
        this.f9559a.clear();
        this.f9559a.putAll(r10);
        if (BaseApplication.c().r() == false) goto L5;
    L6:
        C0();
    L7:
        F0();
        return;
    L5:
        if (I() == false) goto L7;
        goto L6
    }

    public Map z() {
        Map<String, AppInfo> r10 = DataBaseManager.MyAppsTable.getAutoUpdateApps();
        o(r10);
        return r10;
    }

    public void z0() {
        if (this.f9561c.f9578c.hasMessages(100) == false) goto L5;
        return;
    L5:
        Message r10 = this.f9561c.f9578c.obtainMessage(100);
        this.f9561c.f9578c.sendMessageDelayed(r10, 200);
    }
}
