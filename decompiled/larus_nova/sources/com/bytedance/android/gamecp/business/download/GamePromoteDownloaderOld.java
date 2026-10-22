package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.android.gamecp.business.DownloadDataContext;
import com.bytedance.android.gamecp.business.GamePromoteTrack;
import com.bytedance.android.gamecp.business.download.recovery.DisasterRecoveryManager;
import com.bytedance.android.gamecp.business.patch.GameApkMd5Manager;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GamePromoteDownloaderOld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f52417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> f52418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Runnable> f52419c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, p>> f52420d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, p> f52421e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GamePromoteDownloaderOld f52422f = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f52423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f52424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f52425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f52426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ p f52427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f52428f;

        public a(ConcurrentHashMap r100, String r101, p r102, ConcurrentHashMap r103, p r104, Context r105) {
            this.f52423a = r100;
            this.f52424b = r101;
            this.f52425c = r102;
            this.f52426d = r103;
            this.f52427e = r104;
            this.f52428f = r105;
        }

        public final void a() {
            ConcurrentHashMap<Integer, p> r100 = this.f52423a;
            if (r100 == null) goto L5;
            GamePromoteDownloaderOld.f52420d.put(this.f52424b, r100);
        L5:
            p r101 = this.f52425c;
            if (r101 == null) goto L8;
            GamePromoteDownloaderOld.f52421e.put(this.f52424b, r101);
        L8:
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r102 = this.f52426d;
            if (r102 == null) goto L11;
            GamePromoteDownloaderOld.f52418b.put(this.f52424b, r102);
        L11:
            ConcurrentHashMap r103 = this.f52426d;
            if (r103 == null) goto L14;
            com.bytedance.android.gamecp.base.core.service.depend.n r104 = (com.bytedance.android.gamecp.base.core.service.depend.n) r103.get(this.f52427e.f52873t);
        L15:
            if (r104 != null) goto L17;
            Lazy r105 = GamePromoteDownloaderOld.f52417a;
            Context r106 = this.f52428f;
            Intrinsics.checkNotNull(r106);
            GamePromoteDownloaderOld.i(r106, this.f52427e);
        L18:
            GamePromoteDownloaderOld.f52422f.a(this.f52428f, this.f52427e);
            return;
        L17:
            GamePromoteDownloaderOld.f52422f.h(this.f52428f, this.f52427e, r104, false);
            goto L18
        L14:
            r104 = null;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements com.bytedance.android.gamecp.base.core.service.depend.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f52429a;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onCancel() {
            StringBuilder r100 = new StringBuilder("onCancel: taskGroup:");
            p r101 = this.f52429a;
            if (r101 == null) goto L5;
            String r102 = r101.f52866p0;
        L6:
            r100.append(r102);
            r100.append(", token:");
            p r103 = this.f52429a;
            if (r103 == null) goto L9;
            Integer r104 = r103.f52873t;
        L10:
            r100.append(r104);
            yr.c.b("GamePromoteDownloader", r100.toString());
            String r105 = this.f52429a.f52866p0;
            if (r105 != null) goto L13;
            return;
        L13:
            if (r105.length() <= 0) goto L15;
            boolean r106 = true;
        L16:
            if (r106 != true) goto L41;
            LruCache<String, Triple<Integer, Object, Boolean>> r107 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 4, null, false, 12);
            String r108 = String.valueOf(this.f52429a.f52866p0);
            GamePromoteDownloaderOld.f52421e.remove(r108);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r109 = GamePromoteDownloaderOld.f52418b.get(r108);
            if (r109 == null) goto L30;
            ConcurrentHashMap<Integer, p> r110 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r111 = r109.entrySet().iterator();
        L21:
            if (r111.hasNext() == false) goto L30;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r112 = r111.next();
            if (r110 == null) goto L27;
            p r113 = r110.get(r112.getKey());
            if (r113 == null) goto L27;
            r113.f52880w0 = this.f52429a.f52880w0;
        L27:
            com.bytedance.android.gamecp.base.core.service.depend.n r114 = r112.getValue();
            if (r114 == null) goto L21;
            r114.onCancel();
        L30:
            ConcurrentHashMap<String, Runnable> r115 = GamePromoteDownloaderOld.f52419c;
            Runnable r116 = r115.get(r108);
            if (r116 == null) goto L33;
            DisasterRecoveryManager.f52893b.post(r116);
        L33:
            r115.remove(r108);
            return;
        L41:
            return;
        L15:
            r106 = false;
            goto L16
        L9:
            r104 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.m
        public final void onDownloadStart() {
            String r100 = this.f52429a.f52866p0;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 != true) goto L25;
            Lazy r102 = GamePromoteDownloaderOld.f52417a;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L26;
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r104 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r104 == null) goto L27;
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r105 = r104.entrySet().iterator();
        L15:
            if (r105.hasNext() == false) goto L28;
            com.bytedance.android.gamecp.base.core.service.depend.n r106 = r105.next().getValue();
            if ((r106 instanceof com.bytedance.android.gamecp.base.core.service.depend.m) == false) goto L15;
            ((com.bytedance.android.gamecp.base.core.service.depend.m) r106).onDownloadStart();
            goto L15
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L7:
            r101 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onReady() {
            String r100 = this.f52429a.f52866p0;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r102 = GamePromoteDownloaderOld.f52418b;
            if (r102.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r103 = r102.get(String.valueOf(this.f52429a.f52866p0));
            if (r103 == null) goto L32;
            LruCache<String, Triple<Integer, Object, Boolean>> r104 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 0, null, false, 12);
            ConcurrentHashMap<Integer, p> r105 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = r103.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r107 = r106.next();
            if (r105 == null) goto L21;
            p r108 = r105.get(r107.getKey());
            if (r108 == null) goto L21;
            p r109 = this.f52429a;
            r108.f52880w0 = r109.f52880w0;
            s r110 = r108.G0;
            s r111 = r109.G0;
            r110.f52919c = r111.f52919c;
            r110.f52920d = r111.f52920d;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r112 = r107.getValue();
            if (r112 == null) goto L15;
            r112.onReady();
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r101 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onUpdate() {
            String r100 = this.f52429a.f52866p0;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r102 = GamePromoteDownloaderOld.f52418b;
            if (r102.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            LruCache<String, Triple<Integer, Object, Boolean>> r103 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 7, null, false, 12);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r104 = r102.get(String.valueOf(this.f52429a.f52866p0));
            if (r104 == null) goto L32;
            ConcurrentHashMap<Integer, p> r105 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = r104.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r107 = r106.next();
            if (r105 == null) goto L21;
            p r108 = r105.get(r107.getKey());
            if (r108 == null) goto L21;
            r108.f52880w0 = this.f52429a.f52880w0;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r109 = r107.getValue();
            if (r109 == null) goto L15;
            r109.onUpdate();
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r101 = false;
            goto L8
        }

        public b(p r100) {
            this.f52429a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onDownloaded(String r100) {
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            LruCache<String, Triple<Integer, Object, Boolean>> r104 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 3, r100, false, 8);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L32;
            ConcurrentHashMap<Integer, p> r106 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r107 = r105.entrySet().iterator();
        L15:
            if (r107.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r107.next();
            if (r106 == null) goto L21;
            p r109 = r106.get(r108.getKey());
            if (r109 == null) goto L21;
            r109.f52880w0 = this.f52429a.f52880w0;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r110 = r108.getValue();
            if (r110 == null) goto L15;
            r110.onDownloaded(r100);
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onError(int r110) {
            String r100 = this.f52429a.f52866p0;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 != true) goto L59;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r102 = GamePromoteDownloaderOld.f52418b;
            if (r102.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L60;
            LruCache<String, Triple<Integer, Object, Boolean>> r103 = GameStatusCacheHelper.f52434a;
            Runnable r104 = null;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 5, null, false, 12);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r102.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L24;
            ConcurrentHashMap<Integer, p> r106 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r107 = r105.entrySet().iterator();
        L15:
            if (r107.hasNext() == false) goto L24;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r107.next();
            if (r106 == null) goto L21;
            p r109 = r106.get(r108.getKey());
            if (r109 == null) goto L21;
            p r111 = this.f52429a;
            r109.f52880w0 = r111.f52880w0;
            s r112 = r109.G0;
            s r113 = r111.G0;
            r112.f52921e = r113.f52921e;
            r112.f52919c = r113.f52919c;
            r112.f52920d = r113.f52920d;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r114 = r108.getValue();
            if (r114 == null) goto L15;
            r114.onError(r110);
        L24:
            Lazy r115 = DisasterRecoveryManager.f52892a;
            p r116 = this.f52429a;
            Lazy r117 = DisasterRecoveryManager.f52896e;
            if (((com.bytedance.android.gamecp.common.setting.config.j1) r117.getValue()).b() == false) goto L61;
            List<com.bytedance.android.gamecp.common.setting.config.q0> r118 = ((com.bytedance.android.gamecp.common.setting.config.j1) r117.getValue()).a();
            if (r118 != null) goto L29;
        L32:
            boolean r119 = true;
        L33:
            if (r119 == true) goto L62;
            if (r116 == null) goto L66;
            LocalTestManager.a(new Class[]{uv.a.class});
            String r120 = r116.f52840c0;
            if (r120 == null) goto L63;
            List r121 = StringsKt.split$default(r120, new String[]{"?"}, false, 0, 6, null);
            if (r121 == null) goto L64;
            String r122 = (String) CollectionsKt.getOrNull(r121, 0);
            if (r122 == null) goto L67;
            yr.c.a("DisasterRecoveryManager", "check error: " + r110 + ' ' + SystemClock.elapsedRealtime());
            ConcurrentHashMap<Integer, ConcurrentHashMap<String, Runnable>> r123 = DisasterRecoveryManager.f52894c;
            ConcurrentHashMap<String, Runnable> r124 = r123.get(Integer.valueOf(r110));
            if (r124 == null) goto L46;
            r104 = r124.get(r122);
        L46:
            if (r104 == null) goto L48;
            yr.c.a("DisasterRecoveryManager", "recovery tasking");
            return;
        L48:
            com.bytedance.android.gamecp.business.download.recovery.a r125 = new com.bytedance.android.gamecp.business.download.recovery.a(r110, r122, r116);
            ConcurrentHashMap<String, Runnable> r126 = r123.get(Integer.valueOf(r110));
            if (r126 != null) goto L51;
            r126 = new ConcurrentHashMap();
            r123.put(Integer.valueOf(r110), r126);
        L51:
            r126.put(r122, r125);
            DisasterRecoveryManager.f52893b.post(r125);
            return;
        L67:
            return;
        L64:
            return;
        L63:
            return;
        L66:
            return;
        L62:
            return;
        L29:
            if (r118.isEmpty() == true) goto L32;
            r119 = false;
            goto L33
        L61:
            return;
        L60:
            return;
        L59:
            return;
        L7:
            r101 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstallFailed(int r100) {
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L25;
            Lazy r103 = GamePromoteDownloaderOld.f52417a;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r104 = GamePromoteDownloaderOld.f52418b;
            if (r104.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L26;
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r104.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L27;
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = r105.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L28;
            com.bytedance.android.gamecp.base.core.service.depend.n r107 = r106.next().getValue();
            if (r107 == null) goto L15;
            r107.onInstallFailed(r100);
            goto L15
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r100) {
            Intrinsics.checkNotNullParameter(r100, "installedFinishData");
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            LruCache<String, Triple<Integer, Object, Boolean>> r104 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 6, r100, false, 8);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L32;
            ConcurrentHashMap<Integer, p> r106 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r107 = r105.entrySet().iterator();
        L15:
            if (r107.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r107.next();
            if (r106 == null) goto L21;
            p r109 = r106.get(r108.getKey());
            if (r109 == null) goto L21;
            r109.f52880w0 = this.f52429a.f52880w0;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r110 = r108.getValue();
            if (r110 == null) goto L15;
            r110.onInstalled(r100);
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onJumpInstall(int r100) {
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L25;
            Lazy r103 = GamePromoteDownloaderOld.f52417a;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r104 = GamePromoteDownloaderOld.f52418b;
            if (r104.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L26;
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r104.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L27;
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = r105.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L28;
            com.bytedance.android.gamecp.base.core.service.depend.n r107 = r106.next().getValue();
            if (r107 == null) goto L15;
            r107.onJumpInstall(r100);
            goto L15
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
            Intrinsics.checkNotNullParameter(r100, "progressData");
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            LruCache<String, Triple<Integer, Object, Boolean>> r104 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 2, r100, false, 8);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L32;
            ConcurrentHashMap<Integer, p> r106 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r107 = r105.entrySet().iterator();
        L15:
            if (r107.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r107.next();
            if (r106 == null) goto L21;
            p r109 = r106.get(r108.getKey());
            if (r109 == null) goto L21;
            p r110 = this.f52429a;
            r109.f52880w0 = r110.f52880w0;
            s r111 = r109.G0;
            s r112 = r110.G0;
            r111.f52919c = r112.f52919c;
            r111.f52920d = r112.f52920d;
            r111.f52926j = r100;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r113 = r108.getValue();
            if (r113 == null) goto L15;
            r113.onPause(r100);
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
            Intrinsics.checkNotNullParameter(r100, "progressData");
            String r101 = this.f52429a.f52866p0;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 != true) goto L30;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L31;
            LruCache<String, Triple<Integer, Object, Boolean>> r104 = GameStatusCacheHelper.f52434a;
            GameStatusCacheHelper.e(this.f52429a.f52855k, 1, r100, false, 8);
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r105 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r105 == null) goto L32;
            ConcurrentHashMap<Integer, p> r106 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r107 = r105.entrySet().iterator();
        L15:
            if (r107.hasNext() == false) goto L33;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r107.next();
            if (r106 == null) goto L21;
            p r109 = r106.get(r108.getKey());
            if (r109 == null) goto L21;
            p r110 = this.f52429a;
            r109.f52880w0 = r110.f52880w0;
            s r111 = r109.G0;
            s r112 = r110.G0;
            r111.f52919c = r112.f52919c;
            r111.f52920d = r112.f52920d;
            r111.f52926j = r100;
        L21:
            com.bytedance.android.gamecp.base.core.service.depend.n r113 = r108.getValue();
            if (r113 == null) goto L15;
            r113.onProgress(r100);
            goto L15
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L7:
            r102 = false;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void passThrough(int r110) {
            String r100 = this.f52429a.f52866p0;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 != true) goto L47;
            Lazy r102 = GamePromoteDownloaderOld.f52417a;
            ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r103 = GamePromoteDownloaderOld.f52418b;
            if (r103.containsKey(String.valueOf(this.f52429a.f52866p0)) == false) goto L48;
            ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r104 = r103.get(String.valueOf(this.f52429a.f52866p0));
            if (r104 == null) goto L49;
            ConcurrentHashMap<Integer, p> r105 = GamePromoteDownloaderOld.f52420d.get(String.valueOf(this.f52429a.f52866p0));
            Iterator<Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = r104.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L50;
            Map.Entry<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r107 = r106.next();
            if (r105 == null) goto L19;
            p r108 = r105.get(r107.getKey());
        L20:
            if (r108 == null) goto L24;
            s r109 = r108.G0;
            if (r109 == null) goto L24;
            r109.f52918b = this.f52429a.G0.f52918b;
        L24:
            s r111 = this.f52429a.G0;
            long r112 = r111.f52928l;
            if (r112 <= 0) goto L34;
            if (r108 == null) goto L30;
            s r113 = r108.G0;
            if (r113 == null) goto L30;
            r113.f52928l = r112;
        L30:
            if (r108 == null) goto L34;
            s r114 = r108.G0;
            if (r114 == null) goto L34;
            r114.f52926j = r111.f52926j;
        L34:
            if (r108 == null) goto L38;
            s r115 = r108.G0;
            if (r115 == null) goto L38;
            r115.f52929m = r111.f52929m;
        L38:
            com.bytedance.android.gamecp.base.core.service.depend.n r116 = r107.getValue();
            if (r116 == null) goto L15;
            r116.passThrough(r110);
            goto L15
        L19:
            r108 = null;
            goto L20
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L47:
            return;
        L7:
            r101 = false;
            goto L8
        }
    }

    public GamePromoteDownloaderOld() {
    }

    static {
        f52422f = new GamePromoteDownloaderOld();
        f52417a = LazyKt.lazy(GamePromoteDownloaderOld$mGameCenterStrategy$2.INSTANCE);
        f52418b = new ConcurrentHashMap();
        f52419c = new ConcurrentHashMap();
        f52420d = new ConcurrentHashMap();
        f52421e = new ConcurrentHashMap();
    }

    public static void l(p r100) {
        String r101 = r100.f52866p0;
        Integer r102 = r100.f52873t;
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, p>> r104 = f52420d;
        ConcurrentHashMap<Integer, p> r105 = r104.get(r101);
        if (r105 != null) goto L9;
        r105 = new ConcurrentHashMap();
        Intrinsics.checkNotNull(r101);
        r104.put(r101, r105);
    L9:
        r105.put(Integer.valueOf(r103), r100);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final p c(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        p r101 = f52421e.get(r100);
        if (r101 != null) goto L13;
        ConcurrentHashMap<Integer, p> r102 = f52420d.get(r100);
        if (r102 == null) goto L14;
        Collection<p> r103 = r102.values();
        if (r103 != null) goto L16;
        return null;
    L16:
        return (p) CollectionsKt.firstOrNull(r103);
    L14:
        return null;
    L13:
        return r101;
    }

    public static boolean e(Context r100, p r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        int r102 = com.bytedance.android.gamecp.business.i0.f56003a;
        if (com.bytedance.android.gamecp.business.i0.i(r101.Q) == true) goto L10;
        yr.c.b("GamePromoteDownloader", "error not support android");
        return false;
    L10:
        String r103 = r101.f52866p0;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L21;
        yr.c.b("GamePromoteDownloader", "error taskGroup is null or empty");
        return false;
    L21:
        if (r101.f52873t != null) goto L24;
        yr.c.b("GamePromoteDownloader", "error token is null");
        return false;
    L24:
        return true;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L25:
        yr.c.b("GamePromoteDownloader", "error params is null");
        return false;
    }

    public static void f(p r100, int r101) {
        LiveTracingMonitor.EventModule r102 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r103 = new JSONObject();
        String r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.f52836a0;
    L6:
        r103.put(EventConstants.ExtraJson.GAME_NAME, r105);
        if (r100 == null) goto L9;
        String r106 = r100.f52855k;
    L10:
        r103.put("game_id", r106);
        if (r100 == null) goto L13;
        String r107 = r100.f52840c0;
    L14:
        r103.put("url", r107);
        if (r100 == null) goto L17;
        String r108 = r100.f52866p0;
    L18:
        r103.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, r108);
        if (r100 == null) goto L21;
        String r109 = r100.f52845f;
    L22:
        r103.put("page", r109);
        if (r101 != 1001) goto L58;
        if (r100 == null) goto L26;
        Integer r110 = Integer.valueOf(r100.f52880w0);
    L27:
        r103.put("cur_status", r110);
        if (r100 == null) goto L34;
        String r111 = r100.f52840c0;
        if (r111 == null) goto L34;
        if (StringsKt.contains$default(r111, "append", false, 2, null) != true) goto L34;
        String r112 = "1";
    L35:
        r103.put("has_append", r112);
        if (Intrinsics.areEqual(r112, "0") == false) goto L58;
        bw.p r113 = com.bytedance.android.gamecp.host_api.a.b().getUserService();
        if (r113 == null) goto L44;
        hw.b r114 = r113.user();
        if (r114 == null) goto L44;
        String r115 = r114.getCurrentUserId();
        if (r115 == null) goto L44;
    L45:
        r103.put("no_channel_uid", r115);
        if (r100 == null) goto L48;
        String r116 = r100.f52864o0;
    L50:
        if (TextUtils.isEmpty(r116) == true) goto L58;
    L56:
        e = move-exception;
        yr.c.b("GamePromoteDownloader", String.valueOf(e.getMessage()));
        goto L58
    L52:
        if (r100 == null) goto L54;
        r104 = r100.f52864o0;     // Catch: Exception -> L56
    L54:
        r103.put("gamecp_no_attribution", new JSONObject(r104).optInt("gamecp_no_attribution", 0));     // Catch: Exception -> L56
        goto L58
    L48:
        r116 = null;
    L44:
        r115 = null;
    L34:
        r112 = "0";
        goto L35
    L26:
        r110 = null;
    L58:
        Unit r117 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(r101, r103);
        return;
    L21:
        r109 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public static void i(Context r100, p r101) {
        ConcurrentHashMap<String, p> r102 = f52421e;
        String r103 = r101.f52866p0;
        Intrinsics.checkNotNull(r103);
        p r104 = r102.get(r103);
        if (r104 == null) goto L5;
        k(r100, r104);
    L5:
        String r105 = r101.f52866p0;
        Intrinsics.checkNotNull(r105);
        r102.put(r105, r101);
        f(r101, 1030);
        ((g1) f52417a.getValue()).a(r100, r101, new b(r101));
        Lazy r106 = GameApkMd5Manager.f56195a;
        GameApkMd5Manager.b(r101.f52855k, r101.f52860m0, "tt_downloader_subscribe", null);
    }

    public static void k(Context r100, p r101) {
        StringBuilder r102 = new StringBuilder("unSubscribeInner: ");
        if (r101 == null) goto L5;
        String r103 = r101.f52836a0;
    L6:
        r102.append(r103);
        yr.c.e("GamePromoteDownloader", r102.toString());
        if (r100 == null) goto L16;
        if (r101 == null) goto L17;
        ConcurrentHashMap<String, p> r104 = f52421e;
        String r105 = r101.f52866p0;
        if (r104 == null) goto L15;
        TypeIntrinsics.asMutableMap(r104).remove(r105);
        f(r101, 1031);
        ((g1) f52417a.getValue()).c(r100, r101);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L17:
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void a(Context r100, p r101) {
        if (e(r100, r101) == true) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder("action: ");
        Intrinsics.checkNotNull(r101);
        r102.append(r101.f52836a0);
        yr.c.e("GamePromoteDownloader", r102.toString());
        String r103 = r101.f52866p0;
        if (r103 != null) goto L8;
    L63:
        Intrinsics.checkNotNull(r100);
        i(r100, r101);
        f(r101, 1001);
        int r104 = GamePromoteTrack.f51759a;
        GamePromoteTrack.k(r101);
        AtomicBoolean r105 = DownloadListManager.f52326a;
        DownloadListManager.b(r100, r101, false);
        ((g1) f52417a.getValue()).d(r100, r101);
        return;
    L8:
        if (r103.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 != true) goto L63;
        ConcurrentHashMap<String, p> r107 = f52421e;
        if (r107.containsKey(String.valueOf(r101.f52866p0)) == false) goto L63;
        p r108 = r107.get(String.valueOf(r101.f52866p0));
        if (r108 == null) goto L17;
        String r109 = r108.f52840c0;
    L19:
        if ((true ^ Intrinsics.areEqual(r109, r101.f52840c0)) == false) goto L21;
        k(r100, r108);
    L21:
        float r110 = 0.0f;
        if (r108 == null) goto L26;
        s r111 = r108.G0;
        if (r111 == null) goto L26;
        float r112 = r111.f52924h;
    L28:
        if (r112 <= 0) goto L35;
        s r113 = r101.G0;
        if (r108 == null) goto L34;
        s r114 = r108.G0;
        if (r114 == null) goto L34;
        r110 = r114.f52924h;
    L34:
        r113.f52924h = r110;
    L35:
        long r115 = 0;
        if (r108 == null) goto L40;
        s r116 = r108.G0;
        if (r116 == null) goto L40;
        long r117 = r116.f52928l;
    L42:
        if (r117 <= 0) goto L50;
        s r118 = r101.G0;
        if (r108 == null) goto L48;
        s r119 = r108.G0;
        if (r119 == null) goto L48;
        long r120 = r119.f52928l;
    L49:
        r118.f52928l = r120;
    L48:
        r120 = 0;
    L50:
        if (r108 == null) goto L54;
        s r121 = r108.G0;
        if (r121 == null) goto L54;
        long r122 = r121.f52929m;
    L56:
        if (r122 <= 0) goto L63;
        s r123 = r101.G0;
        if (r108 == null) goto L62;
        s r124 = r108.G0;
        if (r124 == null) goto L62;
        r115 = r124.f52929m;
    L62:
        r123.f52929m = r115;
    L54:
        r122 = 0;
    L40:
        r117 = 0;
    L26:
        r112 = 0.0f;
        goto L28
    L17:
        r109 = null;
        goto L19
    L10:
        r106 = false;
        goto L11
    }

    public final void b(Context r100, p r101) {
        if (e(r100, r101) == true) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder("cancelDownload: ");
        Intrinsics.checkNotNull(r101);
        r102.append(r101.f52836a0);
        yr.c.e("GamePromoteDownloader", r102.toString());
        g1 r103 = (g1) f52417a.getValue();
        Intrinsics.checkNotNull(r100);
        r103.b(r100, r101);
    }

    public final void g(Context r110, p r111) {
        if (e(r110, r111) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r111);
        String r100 = r111.f52866p0;
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        p r101 = f52421e.get(r100);
        String r102 = r100;
        a r103 = new a(f52420d.get(r100), r102, r101, f52418b.get(r100), r111, r110);
        f52419c.put(r100, r103);
        b(r110, r111);
    }

    public final void j(Context r100, p r101) {
        int r102 = com.bytedance.android.gamecp.business.i0.f56003a;
        String r103 = null;
        if (r101 == null) goto L5;
        Long r104 = r101.Q;
    L7:
        if (com.bytedance.android.gamecp.business.i0.i(r104) == true) goto L9;
        return;
    L9:
        StringBuilder r105 = new StringBuilder("unSubscribe: ");
        if (r101 == null) goto L12;
        String r106 = r101.f52836a0;
    L13:
        r105.append(r106);
        r105.append(' ');
        if (r101 == null) goto L16;
        Integer r107 = r101.f52873t;
    L17:
        r105.append(r107);
        yr.c.e("GamePromoteDownloader", r105.toString());
        if (r100 == null) goto L73;
        if (r101 == null) goto L73;
        String r108 = r101.f52866p0;
        boolean r109 = false;
        if (r108 != null) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r110 == true) goto L73;
        String r111 = r101.f52866p0;
        if (r111 != null) goto L32;
    L64:
        String r112 = r101.f52866p0;
        if (r112 != null) goto L67;
    L71:
        k(r100, r101);
        return;
    L67:
        if (r112.length() <= 0) goto L69;
        r109 = true;
    L69:
        if (r109 != true) goto L71;
        f52418b.remove(String.valueOf(r101.f52866p0));
        goto L71
    L32:
        if (r111.length() <= 0) goto L34;
        boolean r113 = true;
    L35:
        if (r113 != true) goto L64;
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r114 = f52418b;
        if (r114.containsKey(String.valueOf(r101.f52866p0)) == false) goto L64;
        ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r115 = r114.get(String.valueOf(r101.f52866p0));
        ConcurrentHashMap<Integer, p> r116 = f52420d.get(String.valueOf(r101.f52866p0));
        Integer r117 = r101.f52873t;
        if (r117 == null) goto L60;
        if (r115 != null) goto L42;
    L48:
        if (r116 == null) goto L60;
        Integer r118 = r101.f52873t;
        if (r118 == null) goto L52;
        int r119 = r118.intValue();
    L54:
        if (r116.containsKey(Integer.valueOf(r119)) != true) goto L60;
        Integer r120 = r101.f52873t;
        if (r120 == null) goto L58;
        int r121 = r120.intValue();
    L59:
        r116.remove(Integer.valueOf(r121));
        goto L60
    L58:
        r121 = 0;
        goto L59
    L52:
        r119 = 0;
        goto L54
    L42:
        if (r115.containsKey(Integer.valueOf(r117.intValue())) != true) goto L48;
        Integer r122 = r101.f52873t;
        if (r122 == null) goto L46;
        int r123 = r122.intValue();
    L47:
        r115.remove(Integer.valueOf(r123));
        goto L48
    L46:
        r123 = 0;
    L60:
        if (r115 == null) goto L64;
        if ((!r115.isEmpty()) != true) goto L64;
        return;
    L34:
        r113 = false;
        goto L35
    L23:
        if (r108.length() == 0) goto L26;
        r110 = false;
    L73:
        StringBuilder r124 = new StringBuilder("unSubscribe but error: ");
        if (r101 == null) goto L76;
        r103 = r101.f52866p0;
    L76:
        r124.append(r103);
        yr.c.b("GamePromoteDownloader", r124.toString());
        return;
    L16:
        r107 = null;
        goto L17
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L7
    }

    public final void d(Context r100, JSONObject r101, e1 r102) {
        Intrinsics.checkNotNullParameter(r101, "json");
        z0 r103 = new z0(r100, r101, r102);
        com.bytedance.android.gamecp.host_api.a.b().getHostSettingService().r();
        r103.run();
    }

    public final void h(Context r100, p r101, com.bytedance.android.gamecp.base.core.service.depend.n r102, boolean r103) {
        if (e(r100, r101) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        if (Intrinsics.areEqual("search", r101.f52845f) == false) goto L10;
        DownloadDataContext r104 = DownloadDataContext.Companion.a();
        String r105 = r101.f52855k;
        if (r105 == null) goto L10;
        r104.getSearchPageGameChannelPkgMap().put(r105, r101.f52835a);
    L10:
        yr.c.e("GamePromoteDownloader", "subscribe: " + r101.f52836a0 + ", token:" + r101.f52873t + ", page:" + r101.f52845f + " allChannelPkgList " + r101.f52835a);
        if (r102 != null) goto L14;
        yr.c.b("GamePromoteDownloader", "subscribe error: taskGroup:" + r101.f52866p0 + " listener is null");
        return;
    L14:
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n>> r106 = f52418b;
        String r107 = r101.f52866p0;
        if (r106 == null) goto L44;
        if (r106.containsKey(r107) == false) goto L41;
        ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r108 = r106.get(r101.f52866p0);
        if (r108 != null) goto L21;
        r108 = new ConcurrentHashMap();
    L21:
        Integer r109 = r101.f52873t;
        Intrinsics.checkNotNull(r109);
        if (r108.containsKey(r109) == true) goto L24;
        Integer r110 = r101.f52873t;
        Intrinsics.checkNotNull(r110);
        r108.put(r110, r102);
    L24:
        l(r101);
        if (r103 == false) goto L28;
        yr.c.b("GamePromoteDownloader", "subscribe completed : taskGroup:" + r101.f52866p0);
        return;
    L28:
        ConcurrentHashMap<String, p> r111 = f52421e;
        String r112 = r101.f52866p0;
        Intrinsics.checkNotNull(r112);
        p r113 = r111.get(r112);
        if (r113 == null) goto L39;
        k(r100, r113);
        s r114 = r113.G0;
        float r115 = r114.f52924h;
        if (r115 <= 0) goto L33;
        r101.G0.f52924h = r115;
    L33:
        long r116 = r114.f52928l;
        if (r116 <= 0) goto L36;
        r101.G0.f52928l = r116;
    L36:
        long r117 = r114.f52929m;
        if (r117 <= 0) goto L39;
        r101.G0.f52929m = r117;
    L39:
        Intrinsics.checkNotNull(r100);
        i(r100, r101);
        return;
    L41:
        ConcurrentHashMap<Integer, com.bytedance.android.gamecp.base.core.service.depend.n> r118 = new ConcurrentHashMap();
        Integer r119 = r101.f52873t;
        Intrinsics.checkNotNull(r119);
        r118.put(r119, r102);
        String r120 = r101.f52866p0;
        Intrinsics.checkNotNull(r120);
        r106.put(r120, r118);
        l(r101);
        Intrinsics.checkNotNull(r100);
        i(r100, r101);
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
