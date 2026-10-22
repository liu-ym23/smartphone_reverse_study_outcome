package com.bytedance.android.gamecp.business.download;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.gamecp.business.DownloadDataContext;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.business.floatwindow.installguide.InstallGuideFloatWindowManager;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.setting.config.j2;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.utils.LiveBroadcastBaseClient;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.Keva;
import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.f2;

/* JADX INFO: loaded from: classes44.dex */
public final class DownloadListManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f52326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cu.a<p> f52327b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CompositeDisposable f52328c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f52329d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f52330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f52331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f52332g;

    public static final class a implements com.bytedance.android.gamecp.base.core.service.depend.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f52333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f52334b;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void passThrough(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onCancel() {
            AtomicBoolean r100 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, this.f52333a, 1007, 0, 0, null, 56);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.m
        public final void onDownloadStart() {
            ConcurrentHashMap<String, com.bytedance.android.gamecp.business.download.multichannel.b.a> r100 = com.bytedance.android.gamecp.business.download.multichannel.b.f52815a;
            p r101 = this.f52333a;
            String r102 = r101.f52866p0;
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            String r103 = r101.f52860m0;
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            Intrinsics.checkNotNullParameter(r102, "taskGroup");
            Intrinsics.checkNotNullParameter(r103, "packageName");
            DownloadInstallInfo r104 = ToolUtils.getInstalledAppInfo(r103, 0, "");
            if (r104.isInstall() == false) goto L11;
        L14:
            yr.c.e("DownloadClickResult", "onUpdateEvent");
            com.bytedance.android.gamecp.business.download.multichannel.b.a(com.bytedance.android.gamecp.business.download.multichannel.b.f52815a.remove(r102), null, "update", null);
        L15:
            yr.c.e("DownloadClickResult", this.f52333a.f52866p0 + ' ' + this.f52333a.f52880w0 + " onDownloadStart");
            return;
        L11:
            if (r104.isNeedUpgrade() == true) goto L14;
            yr.c.e("DownloadClickResult", "onDownloadEvent");
            com.bytedance.android.gamecp.business.download.multichannel.b.a(com.bytedance.android.gamecp.business.download.multichannel.b.f52815a.remove(r102), null, "download", null);
            goto L15
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onReady() {
            yr.c.e("DownloadClickResult", this.f52333a.f52866p0 + ' ' + this.f52333a.f52880w0 + " onReady");
            AtomicBoolean r100 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, this.f52333a, 1000, 0, 0, null, 56);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onUpdate() {
            yr.c.e("DownloadClickResult", this.f52333a.f52866p0 + ' ' + this.f52333a.f52880w0 + " onUpdate");
            AtomicBoolean r100 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, this.f52333a, 1006, 0, 0, null, 56);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onDownloaded(String r110) {
            yr.c.e("DownloadClickResult", this.f52333a.f52866p0 + ' ' + this.f52333a.f52880w0 + " downloadFinish");
            p r100 = this.f52333a;
            long r101 = r100.f52882x0 | 2;
            r100.f52882x0 = r101;
            if ((1 & r101) <= 0) goto L28;
            r100.f52882x0 = r101 & (-2);
            String r102 = r100.f52855k;
            if (r102 != null) goto L7;
        L24:
            AtomicBoolean r103 = DownloadListManager.f52326a;
            DownloadListManager.a(1, this.f52333a);
            com.bytedance.android.gamecp.common.utils.a1.a().putInt("live.pref.PREF_INSTALL_UPLOAD_" + this.f52333a.f52855k, 1).apply();
            DownloadListManager.e(this.f52334b, this.f52333a, 1004, 0, 0, r110, 24);
            p r111 = this.f52333a;
            DownloadListManager.f52331f = 100;
            if (DownloadListManager.f52330e == 0) goto L29;
            DownloadListManager.f(r111);
            DownloadListManager.f52330e = 0;
            DownloadListManager.f52331f = 0;
            return;
        L29:
            return;
        L7:
            if (r102.length() <= 0) goto L9;
            boolean r104 = true;
        L10:
            if (r104 == true) goto L13;
            r102 = null;
        L13:
            if (r102 == null) goto L24;
            AtomicBoolean r105 = DownloadListManager.f52326a;
            DownloadDataContext.a r106 = DownloadDataContext.Companion;
            Set<String> r107 = r106.a().getDownloadingGameId();
            if (r107 == null) goto L17;
            r107.remove(r102);
        L17:
            Set<String> r108 = r106.a().getDownloadedGameId();
            if (r108 == null) goto L24;
            if (r108.contains(r102) == true) goto L24;
            Set<String> r109 = r106.a().getDownloadedGameId();
            if (r109 == null) goto L24;
            r109.add(r102);
            goto L24
        L9:
            r104 = false;
            goto L10
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onError(int r100) {
            AtomicBoolean r101 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, this.f52333a, 1003, r100, 0, null, 48);
            if (r100 != 1006) goto L5;
            NotificationManager r102 = t0.f52932a;
            t0.g(this.f52333a, false);
        L5:
            NotificationManager r103 = t0.f52932a;
            t0.c("DownloadListManager onError: errorCode---" + r100);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstallFailed(int r100) {
            yr.c.e("DownloadListManager", "onInstallFailed failedCode:" + r100);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r100) {
            Intrinsics.checkNotNullParameter(r100, "installedFinishData");
            if (r100.f51409a == false) goto L6;
            yr.c.a("DownloadListManager", "安装完成来源为其他渠道，不上报");
            return;
        L6:
            yr.c.e("DownloadClickResult", this.f52333a.f52866p0 + ' ' + this.f52333a.f52880w0 + " onInstalled");
            p r101 = this.f52333a;
            long r102 = r101.f52882x0;
            if ((2 & r102) <= 0) goto L9;
            r101.f52882x0 = r102 & (-3);
            DownloadListManager.a(2, r101);
            com.bytedance.android.gamecp.common.utils.a1.a().remove("live.pref.PREF_INSTALL_UPLOAD_" + this.f52333a.f52855k).apply();
            DownloadListManager.e(this.f52334b, this.f52333a, 1005, 0, 0, null, 56);
        L9:
            InstallTipsManager r103 = (InstallTipsManager) DownloadListManager.f52329d.getValue();
            String r104 = this.f52333a.f52855k;
            r103.getClass();
            if (r104 != null) goto L12;
        L15:
            boolean r105 = true;
        L16:
            if (r105 == false) goto L19;
            return;
        L19:
            if (f2.f561308a.getValue().c() == false) goto L24;
            Set<String> r106 = ((Keva) r103.f52439c.getValue()).getStringSet("gamecp.install_fail_tips_new", new LinkedHashSet());
            yr.b.b(4, r103.f52438b, "安装完成的游戏：" + r104 + " 移除前->列表:" + r106);
            if (r106.contains(r104) == false) goto L25;
            boolean r107 = r106.remove(r104);
            ((Keva) r103.f52439c.getValue()).storeStringSet("gamecp.install_fail_tips_new", r106);
            yr.b.b(4, r103.f52438b, "安装完成的游戏：" + r104 + " 移除结果：" + r107 + " ,移除后->列表:" + r106);
            return;
        L25:
            return;
        L24:
            return;
        L12:
            if (r104.length() == 0) goto L15;
            r105 = false;
            goto L16
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onJumpInstall(int r100) {
            yr.c.e("DownloadListManager", "onJumpInstall jumpSource:" + r100);
            ConcurrentHashMap<String, com.bytedance.android.gamecp.business.download.multichannel.b.a> r101 = com.bytedance.android.gamecp.business.download.multichannel.b.f52815a;
            String r102 = this.f52333a.f52866p0;
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Intrinsics.checkNotNullParameter(r102, "taskGroup");
            Long r103 = null;
            if (r100 != 0) goto L8;
            yr.c.e("DownloadClickResult", "onJumpInstallEvent");
            com.bytedance.android.gamecp.business.download.multichannel.b.a(com.bytedance.android.gamecp.business.download.multichannel.b.f52815a.remove(r102), null, "install", null);
        L8:
            InstallTipsManager r104 = (InstallTipsManager) DownloadListManager.f52329d.getValue();
            Context r105 = this.f52334b;
            String r106 = this.f52333a.f52855k;
            r104.getClass();
            if (TextUtils.isEmpty(r106) == true) goto L27;
            LocalTestManager.a(new Class[]{uv.a.class});
            r104.f52437a = r105;
            LocalTestManager.a(new Class[]{uv.a.class});
            Lifecycle r107 = r104.a();
            if (r107 == null) goto L14;
            r107.removeObserver(r104);
        L14:
            Lifecycle r108 = r104.a();
            if (r108 == null) goto L18;
            r108.addObserver(r104);
        L18:
            if (f2.f561308a.getValue().c() == false) goto L23;
            Set<String> r109 = ((Keva) r104.f52439c.getValue()).getStringSet("gamecp.install_fail_tips_new", new LinkedHashSet());
            if (r109.contains(r106) == true) goto L27;
            r109.add(r106);
            ((Keva) r104.f52439c.getValue()).storeStringSet("gamecp.install_fail_tips_new", r109);
            yr.b.b(4, r104.f52438b, "下载未安装的游戏列表:" + r109);
            goto L27
        L23:
            Room r110 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r110 == null) goto L26;
            r103 = r110.getRoomId();
        L26:
            long r111 = System.currentTimeMillis();
            com.bytedance.android.gamecp.common.utils.a1.a().putString("gamecp.install_fail_tips", r103 + '_' + r106 + '_' + r111).apply();
        L27:
            boolean r112 = InstallGuideFloatWindowManager.f53171a;
            if (InstallGuideFloatWindowManager.g() == false) goto L38;
            InstallGuideFloatWindowManager.f53171a = true;
            long r113 = ((j2) InstallGuideFloatWindowManager.f53175e.getValue()).e();
            Disposable r114 = InstallGuideFloatWindowManager.f53172b;
            if (r114 != null) goto L33;
        L37:
            InstallGuideFloatWindowManager.f53172b = Observable.timer(r113, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.gamecp.business.floatwindow.installguide.k.f53207a);
            goto L38
        L33:
            if (r114.isDisposed() == true) goto L37;
            Disposable r115 = InstallGuideFloatWindowManager.f53172b;
            if (r115 == null) goto L37;
            r115.dispose();
        L38:
            NotificationManager r116 = t0.f52932a;
            p r117 = this.f52333a;
            Intrinsics.checkNotNullParameter(r117, "downloadInfo");
            t0.f52933b = r117;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
            Intrinsics.checkNotNullParameter(r100, "progressData");
            AtomicBoolean r101 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, this.f52333a, 1002, 0, 0, null, 56);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r110) {
            Intrinsics.checkNotNullParameter(r110, "progressData");
            p r100 = this.f52333a;
            r100.f52882x0 = 3;
            String r101 = r100.f52855k;
            if (r101 != null) goto L5;
        L17:
            long r102 = System.currentTimeMillis();
            p r103 = this.f52333a;
            if ((r102 - r103.G0.f52930n) <= 2000) goto L20;
            AtomicBoolean r104 = DownloadListManager.f52326a;
            DownloadListManager.e(this.f52334b, r103, 1008, 0, r110.f51437a, null, 40);
            this.f52333a.G0.f52930n = r102;
        L20:
            AtomicBoolean r105 = DownloadListManager.f52326a;
            p r106 = this.f52333a;
            int r111 = com.bytedance.android.gamecp.business.i0.h(r110);
            if (DownloadListManager.f52330e != 0) goto L23;
            DownloadListManager.f52330e = System.currentTimeMillis();
        L23:
            com.bytedance.android.gamecp.common.utils.rxutils.e.a(Observable.create(new t(r111)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(r106)), DownloadListManager.f52328c);
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r107 = true;
        L8:
            if (r107 == true) goto L11;
            r101 = null;
        L11:
            if (r101 == null) goto L17;
            AtomicBoolean r108 = DownloadListManager.f52326a;
            DownloadDataContext r109 = DownloadDataContext.Companion.a();
            Set<String> r112 = r109.getDownloadingGameId();
            if (r112 == null) goto L17;
            if (r112.contains(r101) == true) goto L17;
            r109.getDownloadingGameId().add(r101);
            goto L17
        L7:
            r107 = false;
            goto L8
        }

        public a(p r100, Context r101) {
            this.f52333a = r100;
            this.f52334b = r101;
        }
    }

    public static final class b implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f52335a;

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void a(JSONObject r100) {
        }

        public b(Context r100) {
            this.f52335a = r100;
        }

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void b(List<p> r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadList");
            DownloadListManager.f52327b.clear();
            Iterator<p> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L32;
            p r102 = r101.next();
            if (r102.f52880w0 == 6) goto L8;
        L10:
            LocalTestManager.a(new Class[]{uv.a.class});
            String r103 = r102.f52855k;
            if (r103 == null) goto L26;
            AtomicBoolean r104 = DownloadListManager.f52326a;
            DownloadDataContext r105 = DownloadDataContext.Companion.a();
            if (r102.f52880w0 != 1) goto L20;
            Set<String> r106 = r105.getDownloadingGameId();
            if (r106 == null) goto L20;
            if (r106.contains(r103) == true) goto L20;
            r105.getDownloadingGameId().add(r103);
        L20:
            if (r102.f52880w0 != 3) goto L26;
            Set<String> r107 = r105.getDownloadingGameId();
            if (r107 == null) goto L26;
            if (r107.contains(r103) == true) goto L26;
            r105.getDownloadedGameId().add(r103);
        L26:
            AtomicBoolean r108 = DownloadListManager.f52326a;
            DownloadListManager.b(this.f52335a, r102, true);
            String r109 = r102.f52866p0;
            if (r109 != null) goto L30;
            r109 = "";
        L30:
            if (DownloadListManager.c(r109) != null) goto L4;
            DownloadListManager.f52327b.add(r102);
            goto L4
        L8:
            if (com.bytedance.android.gamecp.common.utils.a1.b().getInt("live.pref.PREF_INSTALL_UPLOAD_" + r102.f52855k, 0) != 1) goto L10;
            DownloadListManager.a(2, r102);
            com.bytedance.android.gamecp.common.utils.a1.a().remove("live.pref.PREF_INSTALL_UPLOAD_" + r102.f52855k).apply();
            goto L10
        }
    }

    public DownloadListManager() {
    }

    static {
        f52326a = new AtomicBoolean(false);
        f52327b = new cu.a(new ArrayList());
        f52328c = new CompositeDisposable();
        f52329d = LazyKt.lazy(DownloadListManager$mInstallTipsManager$2.INSTANCE);
        f52332g = System.currentTimeMillis();
    }

    public static p c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "taskGroup");
        Iterator<p> r101 = f52327b.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        p r102 = r101.next();
        if (Intrinsics.areEqual(r102.f52866p0, r100) == false) goto L4;
    L10:
        return r102;
    L8:
        r102 = null;
        goto L10
    }

    public static void d(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f52326a.compareAndSet(false, true) == true) goto L7;
        return;
    L7:
        Logger.d("game-promote", "DownloadListManager init");
        y0 r101 = y0.f52963a;
        y0.d(r100, "", new b(r100));
    }

    public static void f(p r100) {
        HashMap r101 = new HashMap();
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        GamecpTracker.d(r101);
        r101.putAll(r100.f52837b);
        JSONObject r103 = new JSONObject();
        if ((!r101.isEmpty()) == false) goto L14;
        Iterator r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();
        String r106 = (String) r105.getKey();
        String r107 = (String) r105.getValue();
        if (r106.length() <= 0) goto L10;
        boolean r108 = true;
    L11:
        if (r108 == false) goto L6;
        if (r107 == null) goto L6;
        r103.put(r106, r107);
        goto L6
    L10:
        r108 = false;
    L14:
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        GamecpTracker.B("download_progress", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EventConstants.ExtraJson.DY_GAME_INFO, r103.toString()), TuplesKt.to("current_download_progress", String.valueOf(f52331f)), TuplesKt.to("current_download_time", String.valueOf((System.currentTimeMillis() - f52330e) / ((long) 1000)))}));
    }

    public static final void a(int r110, p r111) {
        String r100 = r111.f52849h;
        if (r100 != null) goto L5;
    L12:
        r100 = "0";
    L13:
        String r101 = r100;
        Lazy r102 = LiveBroadcastBaseClient.f57176a;
        GamePromoteApi r103 = (GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class);
        String r104 = r111.f52855k;
        String r105 = r111.f52836a0;
        int r106 = r111.f52859m;
        if (r106 != 2) goto L16;
        int r107 = 3;
    L17:
        String r108 = r111.f52851i;
        String r112 = r111.f52869r;
        Integer r109 = r111.N;
        if (r109 == null) goto L20;
        int r113 = r109.intValue();
    L21:
        String r114 = r111.f52863o;
        if (r114 != null) goto L24;
        String r115 = "";
    L25:
        String r116 = r111.T;
        if (r116 != null) goto L28;
        String r117 = "";
    L29:
        Observable r118 = GamePromoteApi.a.b(r103, r104, r105, r101, r110, r107, r108, r112, r113, r115, r117, r111.U, r111.f52860m0);
        if (r118 == null) goto L35;
        Disposable r119 = r118.subscribe(v.f52955a, new w(r110));
        if (r119 == null) goto L36;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r119, f52328c);
        return;
    L36:
        return;
    L35:
        return;
    L28:
        r117 = r116;
        goto L29
    L24:
        r115 = r114;
        goto L25
    L20:
        r113 = 0;
        goto L21
    L16:
        r107 = r106;
        goto L17
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r120 = true;
    L8:
        if (r120 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L13;
    L7:
        r120 = false;
        goto L8
    }

    public static void b(Context r100, p r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "originInfo");
        if (f52326a.get() == true) goto L5;
        return;
    L5:
        Iterator<p> r103 = f52327b.iterator();
    L6:
        int r104 = 0;
        if (r103.hasNext() == false) goto L16;
        p r105 = r103.next();
        p r106 = r105;
        if (TextUtils.isEmpty(r106.f52866p0) == false) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L6;
    L18:
        if (r105 == null) goto L20;
        return;
    L20:
        String r108 = r101.f52871s;
        if (r108 == null) goto L24;
        r104 = r108.length();
    L24:
        if (r104 != 0) goto L41;
        p r109 = new p();
        r109.Z = r101.Z;
        String r110 = r101.f52836a0;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f52836a0 = r110;
        String r111 = r101.f52838b0;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r109.f52838b0 = r111;
        String r112 = r101.f52840c0;
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r109.f52840c0 = r112;
        r109.f52854j0 = r101.f52854j0;
        r109.f52856k0 = r101.f52856k0;
        r109.f52860m0 = r101.f52860m0;
        r109.f52862n0 = r101.f52862n0;
        r109.f52864o0 = r101.f52864o0;
        r109.f52866p0 = r101.f52866p0;
        r109.f52871s = r101.f52871s;
        r109.f52878v0 = r101.f52878v0;
        String r113 = r101.T;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r109.T = r113;
    L33:
        if (Intrinsics.areEqual(r109, r101) == false) goto L36;
    L39:
        AtomicInteger r114 = DownloadInfoFactory.f52322a;
        r109.f52873t = Integer.valueOf(DownloadInfoFactory.f());
        y0.f52963a.h(r100, r109, new a(r109, r100), !r102);
        f52327b.add(r109);
        return;
    L36:
        if (TextUtils.isEmpty(r109.T) == false) goto L38;
        String r115 = r101.T;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r109.T = r115;
    L38:
        r109.f52880w0 = r101.f52880w0;
        r109.f52835a.addAll(r101.f52835a);
        r109.f52845f = r101.f52845f;
        r109.f52849h = r101.f52849h;
        r109.f52851i = r101.f52851i;
        r109.f52853j = r101.f52853j;
        r109.f52855k = r101.f52855k;
        r109.f52857l = r101.f52857l;
        r109.f52871s = r101.f52871s;
        r109.f52878v0 = r101.f52878v0;
        r109.f52859m = r101.f52859m;
        r109.f52869r = r101.f52869r;
        r109.P = r101.P;
        r109.f52861n = r101.f52861n;
        r109.f52875u = r101.f52875u;
        r109.f52877v = r101.f52877v;
        r109.f52863o = r101.f52863o;
        r109.f52881x = r101.f52881x;
        r109.f52879w = r101.f52879w;
        r109.f52886z0 = r101.f52886z0;
        r109.A0 = r101.A0;
        r109.D0 = r101.D0;
        r109.f52847g = r101.f52847g;
        r109.L = r101.L;
        r109.f52883y = r101.f52883y;
        r109.f52867q = r101.f52867q;
        r109.f52885z = r101.f52885z;
        r109.A = r101.A;
        r109.B = r101.B;
        r109.C = r101.C;
        r109.D = r101.D;
        r109.E = r101.E;
        r109.F = r101.F;
        String r116 = r101.H;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r109.H = r116;
        r109.I = r101.I;
        HashMap<String, String> r117 = r101.f52837b;
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r109.f52837b = r117;
        s r118 = r109.G0;
        s r119 = r101.G0;
        r118.f52928l = r119.f52928l;
        r118.f52929m = r119.f52929m;
        HashMap<String, String> r120 = r101.f52839c;
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r109.f52839c = r120;
        r109.f52870r0 = r101.f52870r0;
        r109.f52872s0 = r101.f52872s0;
        r109.N = r101.N;
        r109.Q = r101.Q;
        r109.U = r101.U;
        s r121 = r109.G0;
        s r122 = r101.G0;
        r121.f52918b = r122.f52918b;
        r121.f52924h = r122.f52924h;
        r121.f52922f = r122.f52922f;
        String r123 = r122.f52923g;
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r121.f52923g = r123;
        s r124 = r109.G0;
        s r125 = r101.G0;
        r124.f52925i = r125.f52925i;
        r124.f52926j = r125.f52926j;
        goto L39
    L41:
        AtomicInteger r126 = DownloadInfoFactory.f52322a;     // Catch: Exception -> L29
        String r127 = r101.f52871s;     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r127);     // Catch: Exception -> L29
        r109 = DownloadInfoFactory.i(new JSONObject(r127));     // Catch: Exception -> L29
        if (r109 != null) goto L33;
    L31:
        r109 = r101;
    L29:
        e = move-exception;
        yr.c.b("cloneDownloadInfo", "status: " + e.getMessage());
        goto L31
    L11:
        if (Intrinsics.areEqual(r106.f52866p0, r101.f52866p0) == false) goto L13;
        r107 = true;
        goto L14
    L16:
        r105 = null;
        goto L18
    }

    public static void e(Context r100, p r101, int r102, int r110, int r111, String r112, int r113) {
        if ((r113 & 8) == 0) goto L5;
        r110 = -2;
    L5:
        boolean r103 = false;
        if ((r113 & 16) == 0) goto L8;
        r111 = 0;
    L8:
        String r104 = "";
        if ((r113 & 32) == 0) goto L11;
        r112 = "";
    L11:
        LiveTracingMonitor.EventModule r114 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r115 = new JSONObject();
        Object r105 = null;
        Object r106 = null;
        String r107 = null;
        if (r101 == null) goto L14;
        Object r108 = r101.f52836a0;
    L15:
        r115.put(EventConstants.ExtraJson.GAME_NAME, r108);
        if (r101 == null) goto L18;
        Object r109 = r101.f52855k;
    L19:
        r115.put("game_id", r109);
        if (r101 == null) goto L22;
        Object r116 = r101.f52840c0;
    L23:
        r115.put("url", r116);
        if (r101 == null) goto L26;
        Object r117 = r101.f52866p0;
    L27:
        r115.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, r117);
        if (r101 == null) goto L30;
        Object r118 = r101.f52845f;
    L31:
        r115.put("page", r118);
        if (r101 == null) goto L34;
        Object r119 = Integer.valueOf(r101.f52884y0);
    L35:
        r115.put("is_risk", r119);
        if (r101 != null) goto L38;
    L40:
        int r120 = 0;
    L41:
        r115.put("gamecp_is_ad", r120);
        if (r101 == null) goto L44;
        Object r121 = Integer.valueOf(r101.f52859m);
    L45:
        r115.put("scene", r121);
        if (r110 == (-2)) goto L49;
        r115.put("error_code", r110);
    L49:
        if (r102 != 1001) goto L51;
        if (r101 == null) goto L78;
        r105 = Integer.valueOf(r101.f52880w0);
    L78:
        r115.put("cur_status", r105);
    L79:
        Unit r122 = Unit.INSTANCE;
        JSONObject r123 = new JSONObject();
        if (r102 != 1008) goto L82;
        r123.put("cur_progress", r111);
    L82:
        com.bytedance.android.gamecp.common.utils.t.c(r102, r115, r123);
        return;
    L51:
        if (r102 != 1004) goto L53;
        if (r100 == null) goto L71;
        if (r112 == null) goto L71;
        if (r112.length() != 0) goto L63;
        r103 = true;
    L63:
        if (r103 == true) goto L71;
        PackageInfo r124 = r100.getPackageManager().getPackageArchiveInfo(r112, 1);
        if (r124 == null) goto L70;
        ApplicationInfo r125 = r124.applicationInfo;
        if (r125 == null) goto L70;
        r104 = r125.packageName;
    L70:
        r104 = null;
    L71:
        if (r101 == null) goto L73;
        r107 = r101.f52860m0;
    L73:
        boolean r126 = TextUtils.equals(r104, r107);
        r115.put("is_pkg_name_same", r126 ? 1 : 0);
        if (r126 == true) goto L79;
        r115.put("file_pkg_name", r104);
        goto L79
    L53:
        if (r102 != 1005) goto L79;
        if (r101 == null) goto L57;
        r106 = r101.L;
    L57:
        r115.put("game_ad_show_type", r106);
        goto L79
    L44:
        r121 = null;
        goto L45
    L38:
        if (r101.b() != true) goto L40;
        r120 = 1;
        goto L41
    L34:
        r119 = null;
        goto L35
    L30:
        r118 = null;
        goto L31
    L26:
        r117 = null;
        goto L27
    L22:
        r116 = null;
        goto L23
    L18:
        r109 = null;
        goto L19
    L14:
        r108 = null;
        goto L15
    }
}
