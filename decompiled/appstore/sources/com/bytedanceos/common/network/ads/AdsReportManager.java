package com.bytedanceos.common.network.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AdsReportRecordInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.network.FetchURLDataCallBack;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.k;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdsReportManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AdsReportManager f9839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f9840d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f9841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedHashMap f9842b;

    public static class AdsReportCacheMap extends LinkedHashMap<String, AdsReportRecordInfo> {
        private AdsReportCacheMap() {
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, AdsReportRecordInfo> r10) {
            if (size() <= 300) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ AdsReportCacheMap(a r10) {
            this();
        }
    }

    public class a implements FetchURLDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f9844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdsReportManager f9845c;

        public a(AdsReportManager r10, CountDownLatch r11, AtomicBoolean r12) {
            this.f9845c = r10;
            this.f9843a = r11;
            this.f9844b = r12;
        }

        @Override // com.bytedanceos.common.network.FetchURLDataCallBack
        public void OnFetchURLDataFailed(String r10, Throwable r11, String r12, Object r13) {
            if ((r13 instanceof AdsReportRecordInfo) == false) goto L5;
            AdsReportManager.d(this.f9845c, (AdsReportRecordInfo) r13);
        L5:
            this.f9844b.set(false);
            this.f9843a.countDown();
            j.a("[ads report:] failed:" + r13);
        }

        @Override // com.bytedanceos.common.network.FetchURLDataCallBack
        public void OnFetchURLDataSuccess(String r10, int r11, String r12, Object r13) {
            if ((r13 instanceof AdsReportRecordInfo) == false) goto L18;
            AdsReportRecordInfo r14 = (AdsReportRecordInfo) r13;
            int r15 = r14.mEventType;
            if (r15 != 5) goto L7;
        L10:
            Object r16 = AdsReportManager.a();
            monitor-enter(r16);
            AdsReportManager.b(this.f9845c).remove(r10);     // Catch: Throwable -> L15
            monitor-exit(r16);     // Catch: Throwable -> L15
        L14:
            AdsReportManager.c(this.f9845c, r14);
        L15:
            th = move-exception;
            throw th;
        L7:
            if (r15 == 6) goto L10;
            if (r15 != 7) goto L14;
        L18:
            this.f9843a.countDown();
        }
    }

    public final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdsReportManager f9846a;

        public b(AdsReportManager r10, Looper r11) {
            this.f9846a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 == 1) goto L22;
            if (r11 != 2) goto L6;
            int r12 = r10.arg1;
            if (r12 != 5) goto L15;
        L20:
            BaseApplication.c().h().addAdsReportScheduler(0);
        L21:
            j.n("[ads report:] send eventId:" + r10.arg1);
            return;
        L15:
            if (r12 == 6) goto L20;
            if (r12 == 7) goto L20;
            BaseApplication.c().h().addAdsReportScheduler(60000);
            goto L21
        L6:
            if (r11 != 3) goto L8;
            DataBaseManager.AdsReportRecordTable.deleteReportRecord((AdsReportRecordInfo) r10.obj);
            return;
        L8:
            if (r11 != 4) goto L33;
            DataBaseManager.AdsReportRecordTable.updateFailedReportRecord((AdsReportRecordInfo) r10.obj);
            return;
        L33:
            return;
        L22:
            Object r13 = r10.obj;
            if ((r13 instanceof AdsReportRecordInfo) == false) goto L28;
            AdsReportRecordInfo r14 = (AdsReportRecordInfo) r13;
            r14.mUrlMD5 = k.f(r14.mReportUrl);
            if (r14.mEventType >= 5) goto L27;
            DataBaseManager.AdsReportRecordTable.deleteReportRecord(r14);
        L27:
            DataBaseManager.AdsReportRecordTable.addReportRecord(r14);
            AdsReportManager.e(this.f9846a).removeMessages(2);
            Message r15 = AdsReportManager.e(this.f9846a).obtainMessage(2);
            r15.arg1 = r14.mEventType;
            AdsReportManager.e(this.f9846a).sendMessageDelayed(r15, 200);
        L28:
            j.n("[ads report:]save ads report:" + r10.obj);
        }
    }

    static {
        f9840d = new Object();
    }

    public AdsReportManager() {
        this.f9842b = new AdsReportCacheMap(null);
        HandlerThread r10 = new HandlerThread("[AdsReportManager]");
        r10.start();
        this.f9841a = new b(this, r10.getLooper());
    }

    public static /* synthetic */ Object a() {
        return f9840d;
    }

    public static /* synthetic */ LinkedHashMap b(AdsReportManager r10) {
        return r10.f9842b;
    }

    public static /* synthetic */ void c(AdsReportManager r10, AdsReportRecordInfo r11) {
        r10.f(r11);
    }

    public static /* synthetic */ void d(AdsReportManager r10, AdsReportRecordInfo r11) {
        r10.g(r11);
    }

    public static /* synthetic */ b e(AdsReportManager r10) {
        return r10.f9841a;
    }

    public static AdsReportManager h() {
        if (f9839c != null) goto L16;
        Object r10 = f9840d;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f9839c != null) goto L11;
        f9839c = new AdsReportManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L16:
        return f9839c;
    }

    public final void f(AdsReportRecordInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Message r11 = this.f9841a.obtainMessage(3);
        r11.obj = r10;
        this.f9841a.sendMessage(r11);
    }

    public final void g(AdsReportRecordInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Message r11 = this.f9841a.obtainMessage(4);
        r11.obj = r10;
        this.f9841a.sendMessage(r11);
    }

    public final void i(AppInfo r10, int r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.mJsonData) == true) goto L34;
        String r12 = e.X(r10.appDownloadUrl, "position");
        if (TextUtils.isEmpty(r12) == true) goto L31;
        r12 = "&position=" + r12;
    L31:
        JSONObject r13 = new JSONObject(r10.mJsonData);     // Catch: JSONException -> L19
        if (r11 != 3) goto L27;
        String r14 = r13.optString(ServerElements.ADS_CLICK);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r14) == true) goto L27;
        if (TextUtils.isEmpty(r10.traceId) == true) goto L22;
        if (TextUtils.isEmpty(e.X(r14, "trace_id")) == false) goto L22;
        r14 = r14 + "&trace_id=" + r10.traceId;     // Catch: JSONException -> L19
    L22:
        if (TextUtils.isEmpty(r12) == false) goto L24;
    L26:
        r13.put(ServerElements.ADS_CLICK, r14);     // Catch: JSONException -> L19
        goto L27
    L24:
        if (TextUtils.isEmpty(e.X(r14, "position")) == false) goto L26;
        r14 = r14 + r12;     // Catch: JSONException -> L19
    L27:
        j(r13, r11, r10.appPackageName);     // Catch: JSONException -> L19
        return;
    L19:
        e = move-exception;
        j.b(e.getMessage());
        return;
    }

    public final void j(JSONObject r10, int r11, String r12) {
        Object r13 = f9840d;
        monitor-enter(r13);
        if (r10 != null) goto L10;
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L10:
        if (r11 != 1) goto L12;
        String r14 = r10.optString(ServerElements.ADS_IMPRESSION);     // Catch: Throwable -> L7
    L17:
        if (TextUtils.isEmpty(r14) == false) goto L19;
    L35:
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L19:
        if (r11 >= 5) goto L24;
        if (this.f9842b.containsKey(r14) == true) goto L35;
    L24:
        if (TextUtils.isEmpty(r12) == false) goto L26;
        r12 = r10.optString("package");     // Catch: Throwable -> L7
    L26:
        AdsReportRecordInfo r15 = AdsReportRecordInfo.buildInstance(r12, r14, r11);     // Catch: Throwable -> L7
        if (r15 != null) goto L29;
    L33:
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L29:
        if (BaseApplication.c().b().U(r12) == false) goto L31;
        r15.setAppUpdate(true);     // Catch: Throwable -> L7
    L32:
        this.f9842b.put(r15.mReportUrl, r15);     // Catch: Throwable -> L7
        t(r15);     // Catch: Throwable -> L7
        goto L33
    L31:
        r15.setAppUpdate(false);     // Catch: Throwable -> L7
        goto L32
    L12:
        if (r11 == 3) goto L14;
        r14 = r10.optString(ServerElements.ADS_DOWNLOAD_REPORT);     // Catch: Throwable -> L7
        goto L17
    L14:
        r14 = r10.optString(ServerElements.ADS_CLICK);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void k(AppInfo r10) {
        i(r10, 1);
    }

    public final void l(BaseCell r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        Object r12 = f9840d;
        monitor-enter(r12);
        String r13 = r10.optStringParam("name");     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r13) == false) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L13:
        if (r11 != 2) goto L15;
        String r14 = r10.optStringParam(ServerElements.ADS_IMPRESSION);     // Catch: Throwable -> L10
    L20:
        if (TextUtils.isEmpty(r14) == false) goto L22;
    L29:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L22:
        if (this.f9842b.containsKey(r14) == true) goto L29;
        AdsReportRecordInfo r15 = AdsReportRecordInfo.buildInstance(r13, r14, r11);     // Catch: Throwable -> L10
        if (r15 == null) goto L27;
        this.f9842b.put(r15.mReportUrl, r15);     // Catch: Throwable -> L10
        t(r15);     // Catch: Throwable -> L10
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L15:
        if (r11 == 4) goto L17;
        r14 = null;
        goto L20
    L17:
        r14 = r10.optStringParam(ServerElements.ADS_CLICK);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void m(BaseCell r10) {
        l(r10, 2);
    }

    public void n() {
        LinkedHashMap r10 = this.f9842b;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public void o(AppInfo r10) {
        AppInfo r11 = BaseApplication.c().b().u(r10.appPackageName);
        if (r11 != null) goto L5;
    L6:
        r11 = DataBaseManager.DownloadInfoTable.queryDownloadTaskByPackage(r10.appPackageName);
    L7:
        if (r11 != null) goto L9;
        j.n("unkown download task," + r10.appPackageName);
        return;
    L9:
        i(r11, 6);
        return;
    L5:
        if (TextUtils.isEmpty(r11.mJsonData) == false) goto L7;
        goto L6
    }

    public void p(String r10) {
        AppInfo r11 = BaseApplication.c().b().u(r10);
        if (r11 != null) goto L5;
    L6:
        r11 = DataBaseManager.DownloadInfoTable.queryDownloadTaskByPackage(r10);
    L7:
        if (r11 != null) goto L10;
        j.n("unkown download task," + r10);
        return;
    L10:
        if (TextUtils.equals(r11.appSource, "local") == false) goto L12;
        i(r11, 7);
        return;
    L12:
        j.n(r10 + ",appState =" + r11.appState + ",appSource = " + r11.appState);
        return;
    L5:
        if (TextUtils.isEmpty(r11.mJsonData) == false) goto L7;
        goto L6
    }

    public void q(Object r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof AppInfo) == false) goto L8;
        i((AppInfo) r10, 3);
        return;
    L8:
        if ((r10 instanceof BaseCell) == false) goto L10;
        l((BaseCell) r10, 4);
        return;
    L10:
        j.n("unkown Object!" + r10);
    }

    public void r(String r10, String r11) {
        if (r11 == null) goto L14;
        if (r10 == null) goto L15;
        JSONObject r12 = new JSONObject();
        r12.put(ServerElements.ADS_CLICK, r11);     // Catch: JSONException -> L8
    L10:
        j(r12, 3, r10);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L15:
        return;
    }

    public void s(String r10, String r11) {
        if (r11 == null) goto L14;
        if (r10 == null) goto L15;
        JSONObject r12 = new JSONObject();
        r12.put(ServerElements.ADS_IMPRESSION, r11);     // Catch: JSONException -> L8
    L10:
        j(r12, 1, r10);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L15:
        return;
    }

    public final void t(AdsReportRecordInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Message r11 = this.f9841a.obtainMessage(1);
        r11.arg1 = r10.mEventType;
        r11.obj = r10;
        this.f9841a.sendMessage(r11);
    }

    public void u() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return;
    L5:
        long r10 = System.currentTimeMillis();
        ArrayList<AdsReportRecordInfo> r11 = DataBaseManager.AdsReportRecordTable.queryReportRecord();
        if (r11 != null) goto L8;
    L23:
        j.n("[ads report:] no record.");
        return;
    L8:
        if (r11.isEmpty() == true) goto L23;
        AtomicBoolean r12 = new AtomicBoolean(true);
        Iterator<AdsReportRecordInfo> r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        AdsReportRecordInfo r14 = r13.next();
        CountDownLatch r15 = new CountDownLatch(1);
        CommonAPIHelper.a0(r14, new a(this, r15, r12));
        r15.await(1, TimeUnit.MINUTES);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        r12.set(false);
        goto L12
    L19:
        if (r12.get() == true) goto L21;
        BaseApplication.c().h().addAdsReportScheduler(300000);
    L21:
        j.n("[ads report:] total time :" + (System.currentTimeMillis() - r10) + ", result:" + r12.get() + ", size:" + r11.size());
    }
}
