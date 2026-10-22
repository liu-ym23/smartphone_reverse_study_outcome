package com.bytedance.apm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.NetQualityManager;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmAgent {
    private static final long CHECK_DISK_INTERVAL_MS = 3600000;
    private static final long CHILD_PROC_MAP_FILE_SIZE = 262144;
    public static boolean FAST_MODE = false;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final long MAIN_PROC_MAP_FILE_SIZE = 2097152;
    private static final long MAX_LOGS_SIZE = 1073741824;
    public static final String MSG_TIP_NOTHING_TO_DO_PLEASE_NOT_USE = "nothing to do, implementation code has been removed in version 5+";
    private static final long REMAINING_ROM_THRESHOLD = 1073741824;
    public static final String TAG_DEPRECATED = "Deprecated";
    private static final int WEED_OUT_FILE_NUM = 60;
    static AtomicLong atomicLong = null;
    public static boolean sDeepCopy = false;
    private static long sLastCheckDiskTime = -1;
    private static MappedByteBuffer sMappedByteBuffer;
    private static File sProcessLogsFolder;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.config.d f190180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190181b;

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.apm.config.d r100 = this.f190180a;     // Catch: Throwable -> L4
            jt3.a.d(new lt3.a(r100.f190459a, r100.f190460b, null, r100.f190461c, r100.f190462d, this.f190181b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(com.bytedance.apm.config.d r100, JSONObject r101) {
            this.f190180a = r100;
            this.f190181b = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class a0 implements Comparator<File> {
        public a0() {
        }

        @Override // java.util.Comparator
        public final int compare(File r100, File r101) {
            return Long.compare(r100.lastModified(), r101.lastModified());
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm.config.d f190182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190185d;

        public final void a() {
            com.bytedance.apm.config.d r100 = this.f190182a;
            String r101 = r100.f190459a;
            int r102 = r100.f190460b;
            JSONObject r103 = this.f190183b;
            JSONObject r104 = this.f190184c;
            JSONObject r105 = this.f190185d;
            boolean r106 = r100.f190464f;
            if (r105 != null) goto L15;
            r105 = new JSONObject();
        L15:
            r105.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L11
            r105.put("service", r101);     // Catch: JSONException -> L11
            r105.put("status", r102);     // Catch: JSONException -> L11
            if (r103 == null) goto L8;
            r105.put("category", r103);     // Catch: JSONException -> L11
        L8:
            if (r104 == null) goto L12;
            r105.put("metric", r104);     // Catch: JSONException -> L11
        L12:
            if (r105 == null) goto L17;
            ApmAgent.storeLogBypass("monitorEvent", r105.toString());
            return;
        L17:
            return;
        L11:
            r105 = null;
            goto L12
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

        public b(com.bytedance.apm.config.d r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            this.f190182a = r100;
            this.f190183b = r101;
            this.f190184c = r102;
            this.f190185d = r103;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class b0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190192g;

        @Override // java.lang.Runnable
        public final void run() {
            is3.d.a.f495609a.b(new js3.a(UploadTypeInf.API_ERROR, this.f190186a, this.f190187b, this.f190188c, this.f190189d, this.f190190e, this.f190191f, ApmAgent.access$000(this.f190192g, false)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190186a = r100;
            this.f190187b = r101;
            this.f190188c = r102;
            this.f190189d = r103;
            this.f190190e = r104;
            this.f190191f = r105;
            this.f190192g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f190194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190197e;

        @Override // java.lang.Runnable
        public final void run() {
            jt3.a.e(this.f190193a, this.f190194b, ApmAgent.access$000(this.f190195c, true), ApmAgent.access$000(this.f190196d, true), ApmAgent.access$000(this.f190197e, false));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104) {
            this.f190193a = r100;
            this.f190194b = r101;
            this.f190195c = r102;
            this.f190196d = r103;
            this.f190197e = r104;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190202e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190204g;

        public final void a() {
            JSONObject r100 = new js3.a(UploadTypeInf.API_ERROR, this.f190198a, this.f190199b, this.f190200c, this.f190201d, this.f190202e, this.f190203f, this.f190204g).a();
            if (r100 == null) goto L6;
            ApmAgent.storeLogBypass("monitorApiError", r100.toString());
            return;
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

        public c0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190198a = r100;
            this.f190199b = r101;
            this.f190200c = r102;
            this.f190201d = r103;
            this.f190202e = r104;
            this.f190203f = r105;
            this.f190204g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f190206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190209e;

        public final void a() {
            String r100 = this.f190205a;
            int r101 = this.f190206b;
            JSONObject r102 = this.f190207c;
            JSONObject r103 = this.f190208d;
            JSONObject r104 = this.f190209e;
            if (r104 != null) goto L15;
            r104 = new JSONObject();
        L15:
            r104.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L11
            r104.put("service", r100);     // Catch: JSONException -> L11
            r104.put("status", r101);     // Catch: JSONException -> L11
            if (r102 == null) goto L8;
            r104.put("category", r102);     // Catch: JSONException -> L11
        L8:
            if (r103 == null) goto L12;
            r104.put("metric", r103);     // Catch: JSONException -> L11
        L12:
            if (r104 == null) goto L17;
            ApmAgent.storeLogBypass("monitorStatusAndEvent", r104.toString());
            return;
        L17:
            return;
        L11:
            r104 = null;
            goto L12
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

        public d(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104) {
            this.f190205a = r100;
            this.f190206b = r101;
            this.f190207c = r102;
            this.f190208d = r103;
            this.f190209e = r104;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class d0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190214e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190216g;

        @Override // java.lang.Runnable
        public final void run() {
            is3.d.a.f495609a.b(new js3.a(UploadTypeInf.API_ALL, this.f190210a, this.f190211b, this.f190212c, this.f190213d, this.f190214e, this.f190215f, ApmAgent.access$000(this.f190216g, false)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190210a = r100;
            this.f190211b = r101;
            this.f190212c = r102;
            this.f190213d = r103;
            this.f190214e = r104;
            this.f190215f = r105;
            this.f190216g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f190218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190219c;

        public final void a() {
            String r100 = this.f190217a;
            int r101 = this.f190218b;
            JSONObject r102 = this.f190219c;
            if (r102 != null) goto L11;
            r102 = new JSONObject();
        L11:
            r102.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L7
            r102.put("service", r100);     // Catch: JSONException -> L7
            r102.put("status", r101);     // Catch: JSONException -> L7
        L8:
            if (r102 == null) goto L13;
            ApmAgent.storeLogBypass("monitorStatusRate", r102.toString());
            return;
        L13:
            return;
        L7:
            r102 = null;
            goto L8
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

        public e(String r100, int r101, JSONObject r102) {
            this.f190217a = r100;
            this.f190218b = r101;
            this.f190219c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class e0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190225f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190226g;

        public final void a() {
            JSONObject r100 = new js3.a(UploadTypeInf.API_ALL, this.f190220a, this.f190221b, this.f190222c, this.f190223d, this.f190224e, this.f190225f, this.f190226g).a();
            if (r100 == null) goto L6;
            ApmAgent.storeLogBypass("monitorSLA", r100.toString());
            return;
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

        public e0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190220a = r100;
            this.f190221b = r101;
            this.f190222c = r102;
            this.f190223d = r103;
            this.f190224e = r104;
            this.f190225f = r105;
            this.f190226g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190229c;

        public final void a() {
            String r100 = this.f190227a;
            JSONObject r101 = this.f190228b;
            JSONObject r102 = this.f190229c;
            if (r102 != null) goto L13;
            r102 = new JSONObject();
        L13:
            r102.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L9
            r102.put("service", r100);     // Catch: JSONException -> L9
            r102.put("status", 0);     // Catch: JSONException -> L9
            if (r101 == null) goto L10;
            r102.put("value", r101);     // Catch: JSONException -> L9
        L10:
            if (r102 == null) goto L15;
            ApmAgent.storeLogBypass("monitorDuration", r102.toString());
            return;
        L15:
            return;
        L9:
            r102 = null;
            goto L10
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

        public f(String r100, JSONObject r101, JSONObject r102) {
            this.f190227a = r100;
            this.f190228b = r101;
            this.f190229c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class f0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190233d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190234e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190235f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190236g;

        @Override // java.lang.Runnable
        public final void run() {
            is3.d.a.f495609a.b(new js3.a(UploadTypeInf.API_ERROR, this.f190230a, this.f190231b, this.f190232c, this.f190233d, this.f190234e, this.f190235f, ApmAgent.access$000(this.f190236g, false)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190230a = r100;
            this.f190231b = r101;
            this.f190232c = r102;
            this.f190233d = r103;
            this.f190234e = r104;
            this.f190235f = r105;
            this.f190236g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190239c;

        @Override // java.lang.Runnable
        public final void run() {
            jt3.a.d(new lt3.a(this.f190237a, 0, ApmAgent.access$000(this.f190238b, true), null, null, ApmAgent.access$000(this.f190239c, false)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(String r100, JSONObject r101, JSONObject r102) {
            this.f190237a = r100;
            this.f190238b = r101;
            this.f190239c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class g0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190246g;

        public final void a() {
            JSONObject r100 = new js3.a(UploadTypeInf.API_ERROR, this.f190240a, this.f190241b, this.f190242c, this.f190243d, this.f190244e, this.f190245f, this.f190246g).a();
            if (r100 == null) goto L6;
            ApmAgent.storeLogBypass("monitorApiError", r100.toString());
            return;
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

        public g0(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190240a = r100;
            this.f190241b = r101;
            this.f190242c = r102;
            this.f190243d = r103;
            this.f190244e = r104;
            this.f190245f = r105;
            this.f190246g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190249c;

        public final void a() {
            String r100 = this.f190247a;
            JSONObject r101 = this.f190248b;
            JSONObject r102 = this.f190249c;
            if (r102 != null) goto L13;
            r102 = new JSONObject();
        L13:
            r102.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L9
            r102.put("service", r100);     // Catch: JSONException -> L9
            r102.put("status", 0);     // Catch: JSONException -> L9
            if (r101 == null) goto L10;
            r102.put("value", r101);     // Catch: JSONException -> L9
        L10:
            if (r102 == null) goto L15;
            ApmAgent.storeLogBypass("monitorDuration", r102.toString());
            return;
        L15:
            return;
        L9:
            r102 = null;
            goto L10
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

        public h(String r100, JSONObject r101, JSONObject r102) {
            this.f190247a = r100;
            this.f190248b = r101;
            this.f190249c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class h0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190253d;

        public final void a() {
            String r100 = this.f190250a;
            JSONObject r101 = this.f190251b;
            JSONObject r102 = this.f190252c;
            JSONObject r103 = this.f190253d;
            if (r103 != null) goto L15;
            r103 = new JSONObject();
        L15:
            r103.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L11
            r103.put("service", r100);     // Catch: JSONException -> L11
            r103.put("status", 0);     // Catch: JSONException -> L11
            if (r101 == null) goto L8;
            r103.put("category", r101);     // Catch: JSONException -> L11
        L8:
            if (r102 == null) goto L12;
            r103.put("metric", r102);     // Catch: JSONException -> L11
        L12:
            if (r103 == null) goto L17;
            ApmAgent.storeLogBypass("monitorEvent", r103.toString());
            return;
        L17:
            return;
        L11:
            r103 = null;
            goto L12
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

        public h0(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            this.f190250a = r100;
            this.f190251b = r101;
            this.f190252c = r102;
            this.f190253d = r103;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f190255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190257d;

        public final void a() {
            String r100 = this.f190254a;
            int r101 = this.f190255b;
            JSONObject r102 = this.f190256c;
            JSONObject r103 = this.f190257d;
            if (r103 != null) goto L13;
            r103 = new JSONObject();
        L13:
            r103.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: JSONException -> L9
            r103.put("service", r100);     // Catch: JSONException -> L9
            r103.put("status", r101);     // Catch: JSONException -> L9
            if (r102 == null) goto L10;
            r103.put("value", r102);     // Catch: JSONException -> L9
        L10:
            if (r103 == null) goto L15;
            ApmAgent.storeLogBypass("monitorStatusAndDuration", r103.toString());
            return;
        L15:
            return;
        L9:
            r103 = null;
            goto L10
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

        public i(String r100, int r101, JSONObject r102, JSONObject r103) {
            this.f190254a = r100;
            this.f190255b = r101;
            this.f190256c = r102;
            this.f190257d = r103;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface i0 {
        void a();
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190259b;

        @Override // java.lang.Runnable
        public final void run() {
            is3.a.h().b(new js3.c(this.f190258a, this.f190259b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(String r100, JSONObject r101) {
            this.f190258a = r100;
            this.f190259b = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190266g;

        @Override // java.lang.Runnable
        public final void run() {
            is3.d.a.f495609a.b(new js3.a(UploadTypeInf.API_ALL, this.f190260a, this.f190261b, this.f190262c, this.f190263d, this.f190264e, this.f190265f, ApmAgent.access$000(this.f190266g, false)));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190260a = r100;
            this.f190261b = r101;
            this.f190262c = r102;
            this.f190263d = r103;
            this.f190264e = r104;
            this.f190265f = r105;
            this.f190266g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190268b;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = new js3.c(this.f190267a, this.f190268b).a();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ApmAgent.storeLogBypass("monitorExceptionLog", r100.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public l(String r100, JSONObject r101) {
            this.f190267a = r100;
            this.f190268b = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190270b;

        @Override // java.lang.Runnable
        public final void run() {
            jt3.a.b(this.f190269a, this.f190270b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public m(String r100, JSONObject r101) {
            this.f190269a = r100;
            this.f190270b = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190272b;

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = this.f190271a;     // Catch: Throwable -> L11
            JSONObject r101 = this.f190272b;     // Catch: Throwable -> L11
            if (r101 != null) goto L16;
            r101 = null;
        L8:
            if (r101 == null) goto L14;
            ApmAgent.storeLogBypass("monitorCommonLog", r101.toString());     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L16:
            r101.put(FrescoMonitorConst.LOG_TYPE, r100);     // Catch: JSONException -> L6 Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public n(String r100, JSONObject r101, boolean r102) {
            this.f190271a = r100;
            this.f190272b = r101;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190276d;

        @Override // java.lang.Runnable
        public final void run() {
            is3.a.h().b(new js3.f(this.f190273a, this.f190274b, this.f190275c, this.f190276d));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public o(String r100, String r101, JSONObject r102, JSONObject r103) {
            this.f190273a = r100;
            this.f190274b = r101;
            this.f190275c = r102;
            this.f190276d = r103;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190280d;

        public final void a() {
            String r100 = this.f190277a;
            String r101 = this.f190278b;
            JSONObject r102 = ApmAgent.access$000(this.f190279c, true);
            JSONObject r103 = this.f190280d;
            if (r103 == null) goto L11;
        L5:
            r103.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.UI_ACTION);     // Catch: JSONException -> L7
            r103.put("action", r100);     // Catch: JSONException -> L7
            r103.put("page", r101);     // Catch: JSONException -> L7
            r103.put(PerfLog.PARAM_KEY_CONTEXT_ID, r102);     // Catch: JSONException -> L7
        L8:
            if (r103 == null) goto L13;
            ApmAgent.storeLogBypass("monitorUIAction", r103.toString());
            return;
        L13:
            return;
        L7:
            r103 = null;
            goto L8
        L11:
            r103 = new JSONObject();     // Catch: JSONException -> L7
            goto L5
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

        public p(String r100, String r101, JSONObject r102, JSONObject r103) {
            this.f190277a = r100;
            this.f190278b = r101;
            this.f190279c = r102;
            this.f190280d = r103;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190285e;

        @Override // java.lang.Runnable
        public final void run() {
            js3.e r100 = new js3.e(this.f190281a, this.f190282b, this.f190283c, this.f190284d, this.f190285e);     // Catch: Throwable -> L4
            is3.a.h().b(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public q(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
            this.f190281a = r100;
            this.f190282b = r101;
            this.f190283c = r102;
            this.f190284d = r103;
            this.f190285e = r104;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190290e;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = new js3.e(this.f190286a, this.f190287b, ApmAgent.access$000(this.f190288c, true), ApmAgent.access$000(this.f190289d, true), this.f190290e).a();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ApmAgent.storeLogBypass("monitorPerformance", r100.toString());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public r(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
            this.f190286a = r100;
            this.f190287b = r101;
            this.f190288c = r102;
            this.f190289d = r103;
            this.f190290e = r104;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f190293c;

        @Override // java.lang.Runnable
        public final void run() {
            is3.a.h().b(new js3.d(this.f190291a, this.f190292b, this.f190293c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public s(String r100, String r101, float r102) {
            this.f190291a = r100;
            this.f190292b = r101;
            this.f190293c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f190296c;

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = this.f190294a;     // Catch: Throwable -> L9
            String r101 = this.f190295b;     // Catch: Throwable -> L9
            float r102 = this.f190296c;     // Catch: Throwable -> L9
            JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
            r103.put("type", r100);     // Catch: JSONException -> L5 Throwable -> L9
            r103.put("key", r101);     // Catch: JSONException -> L5 Throwable -> L9
            r103.put("value", r102);     // Catch: JSONException -> L5 Throwable -> L9
        L6:
            if (r103 == null) goto L12;
            ApmAgent.storeLogBypass("monitorDirectOnTimer", r103.toString());     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L5:
            r103 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public t(String r100, String r101, float r102) {
            this.f190294a = r100;
            this.f190295b = r101;
            this.f190296c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190297a;

        public final void a() {
            vr3.h r100 = vr3.h.c.f556862a;
            String r101 = this.f190297a;
            if (r100.f556842g == true) goto L5;
            return;
        L5:
            if (r100.f543333b == false) goto L7;
            return;
        L7:
            if (r100.f556852q == true) goto L25;
            Object r102 = r100.f556847l;
            monitor-enter(r102);
            ykc.a.a(com.bytedance.apm.d.getContext(), r100.f556855t, r100.f556843h);     // Catch: Throwable -> L17
            if (TextUtils.isEmpty(r100.f556845j) == false) goto L14;
            bt3.b.d.f20539a.a(r100);     // Catch: Throwable -> L17
        L14:
            r100.f556845j = r101;     // Catch: Throwable -> L17
            r100.j();     // Catch: Throwable -> L17
            monitor-exit(r102);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
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

        public u(String r100) {
            this.f190297a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f190301d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f190302e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f190303f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190304g;

        public final void a() {
            JSONObject r100 = new js3.a(UploadTypeInf.API_ALL, this.f190298a, this.f190299b, this.f190300c, this.f190301d, this.f190302e, this.f190303f, this.f190304g).a();
            if (r100 == null) goto L6;
            ApmAgent.storeLogBypass("monitorSLA", r100.toString());
            return;
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

        public v(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106) {
            this.f190298a = r100;
            this.f190299b = r101;
            this.f190300c = r102;
            this.f190301d = r103;
            this.f190302e = r104;
            this.f190303f = r105;
            this.f190304g = r106;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190305a;

        public final void a() {
            vr3.h r100 = vr3.h.c.f556862a;
            String r101 = this.f190305a;
            if (r100.f556842g == false) goto L22;
            Object r102 = r100.f556847l;
            monitor-enter(r102);
        L17:
            th = move-exception;
            throw th;
        L8:
            if (r101.equals(r100.f556845j) == true) goto L11;
            monitor-exit(r102);     // Catch: Throwable -> L17
            return;
        L11:
            r100.f556845j = null;     // Catch: Throwable -> L17
            bt3.b.d.f20539a.i(r100);     // Catch: Throwable -> L17
            PthreadHandlerThreadV2 r103 = ykc.a.f568293a;     // Catch: Throwable -> L17
            if (r103 == null) goto L14;
            r103.quit();     // Catch: Throwable -> L17
            ((vr3.h.a) ykc.a.f568295c).f556856a.j();     // Catch: Throwable -> L17
            ykc.a.f568293a = null;     // Catch: Throwable -> L17
            ykc.a.f568294b = null;     // Catch: Throwable -> L17
            ykc.a.f568295c = null;     // Catch: Throwable -> L17
        L14:
            r100.j();     // Catch: Throwable -> L17
            monitor-exit(r102);     // Catch: Throwable -> L17
            return;
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

        public w(String r100) {
            this.f190305a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190306a;

        public final void a() {
            vr3.k r100 = vr3.k.a.f556893a;
            String r101 = this.f190306a;
            if (r100.f556878g == true) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r101) == true) goto L22;
            vr3.k.b r102 = new vr3.k.b();
            r102.f556895b = SystemClock.uptimeMillis();
            long r103 = com.bytedance.apm.util.b.a();
            r102.f556896c = r103;
            r102.f556894a = r101;
            if (r103 <= 0) goto L23;
            LinkedList<vr3.k.b> r104 = r100.f556883l;
            monitor-enter(r104);
            r100.f556883l.push(r102);     // Catch: Throwable -> L15
            monitor-exit(r104);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L23:
            return;
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

        public x(String r100) {
            this.f190306a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f190307a;

        public final void a() {
            vr3.k r100 = vr3.k.a.f556893a;
            String r101 = this.f190307a;
            if (r100.f556878g == true) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r101) == false) goto L8;
            return;
        L8:
            if (r100.f556883l.size() == 0) goto L52;
            LinkedList<vr3.k.b> r102 = r100.f556883l;
            monitor-enter(r102);
            vr3.k.b r103 = r100.f556883l.pop();     // Catch: Throwable -> L34
            monitor-exit(r102);     // Catch: Throwable -> L34
            if (r103 != null) goto L15;
        L32:
            if (r103 == null) goto L8;
            av3.b.a("ProcessEnergyCollector", String.format("Unexpected scene, top: %s, cur:%s", new Object[]{r103.f556894a, r101}));
            goto L8
        L15:
            if (r103.f556894a.equals(r101) == false) goto L32;
            r103.f556897d = SystemClock.uptimeMillis();
            long r104 = com.bytedance.apm.util.b.a();
            r103.f556898e = r104;
            if (r104 <= 0) goto L50;
            Long r105 = r100.f556882k.get(r103.f556894a);
            if (r105 != null) goto L22;
        L24:
            LinkedList<vr3.k.b> r106 = r100.f556884m;
            monitor-enter(r106);
            r100.f556884m.add(r103);     // Catch: Throwable -> L29
            monitor-exit(r106);     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        L22:
            if ((r103.f556897d - r103.f556895b) >= r105.longValue()) goto L24;
            return;
        L50:
            return;
        L34:
            th = move-exception;
            throw th;
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

        public y(String r100) {
            this.f190307a = r100;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f190308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f190309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f190310c;

        @Override // java.lang.Runnable
        public final void run() {
            ApmAgent.reportLegacyMonitorLog(com.bytedance.apm.d.getContext(), this.f190308a, this.f190309b, this.f190310c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public z(long r100, long r101, boolean r102) {
            this.f190308a = r100;
            this.f190309b = r101;
            this.f190310c = r102;
        }
    }

    public ApmAgent() {
    }

    public static void addBlockFilter(Map<String, String> r100) {
    }

    public static void addFpsFilter(Map<String, String> r100) {
    }

    public static void monitorCommonLog(String r100, JSONObject r101) {
        com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorCommonLog(r100, r101);
    }

    public static void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorEvent(r100, r101, r102, r103);
    }

    public static void monitorImageSample(String r100, int r101, String r102, long r103, JSONObject r104) {
    }

    public static void reportLegacyMonitorLog(Context r100, long r101, long r102, boolean r103) {
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    private static JSONObject getCapacity() {
        JSONObject r100 = new JSONObject();
        r100.put("battery_percent", ykc.c.b(com.bytedance.apm.d.getContext()));     // Catch: JSONException -> L9
        JSONObject r101 = as3.b.a.f16095a.f();     // Catch: JSONException -> L9
        if (r101.length() != 0) goto L7;
        r100.put("more", "no-more-info");     // Catch: JSONException -> L9
    L12:
    L11:
        return r100;
    L7:
        r100.put("more", r101);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static JSONObject getGalvanicNow() {
        JSONObject r100 = new JSONObject();
        r100.put(IPerformanceManager.Battery.battery_current, ykc.c.c(com.bytedance.apm.d.getContext()));     // Catch: JSONException -> L5
        r100.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static boolean isConfigReady() {
        return ApmDelegate.g.f190592a.f190575f;
    }

    private static void reportFeedbackInfo() {
        ss3.i r100 = ss3.i.a.f543398a;     // Catch: JSONException -> L21
        if (r100.f543395c == false) goto L5;
    L7:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L21
        JSONObject r102 = ss3.f.a().b(true);     // Catch: JSONException -> L21
        r102.put("crash_section", com.bytedance.apm.d.i(System.currentTimeMillis()));     // Catch: JSONException -> L21
        r102.put("crash_type", "feedback");     // Catch: JSONException -> L21
        JSONObject r103 = com.bytedance.monitor.collector.c.e().b();     // Catch: JSONException -> L21
        Callable<JSONArray> r104 = com.bytedance.crash.util.a.f203405a;     // Catch: JSONException -> L21
        if (r104 != null) goto L27;
    L12:
        JSONArray r105 = null;
    L13:
        r103.put("activity_track", r105);     // Catch: JSONException -> L21
        ss3.e.b().getClass();     // Catch: JSONException -> L21
        r103.put("cpu_info", ss3.e.a());     // Catch: JSONException -> L21
        r103.put("memory_info", getMemInfo(ss3.c.a(com.bytedance.apm.d.getContext())));     // Catch: JSONException -> L21
        r103.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, ss3.i.a.f543398a.f543396d);     // Catch: JSONException -> L21
        String r106 = MethodCollector.getInstance().getEvilMethod(0, SystemClock.uptimeMillis());     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r103.put("evil_method", r106);     // Catch: JSONException -> L21
        r102.put("with_evil_method", "true");     // Catch: JSONException -> L21
    L16:
        com.bytedance.monitor.collector.c r107 = com.bytedance.monitor.collector.c.e();     // Catch: JSONException -> L21
        SystemClock.uptimeMillis();     // Catch: JSONException -> L21
        r107.getClass();     // Catch: JSONException -> L21
        if (TextUtils.isEmpty(null) == false) goto L20;
        r103.put(Scraps.BATTERY, getCapacity());     // Catch: JSONException -> L21
        r103.put(IPerformanceManager.Battery.battery_current, getGalvanicNow());     // Catch: JSONException -> L21
        r101.put("custom", r103);     // Catch: JSONException -> L21
        r101.put("filters", r102);     // Catch: JSONException -> L21
        r101.put("stack", "at feedback.*(a.java:-1)");     // Catch: JSONException -> L21
        r101.put("event_type", "serious_lag");     // Catch: JSONException -> L21
        js3.c r108 = new js3.c(UploadTypeInf.SERIOUS_BLOCK_MONITOR, r101);     // Catch: JSONException -> L21
        r108.f500212c = true;     // Catch: JSONException -> L21
        is3.a.h().b(r108);     // Catch: JSONException -> L21
        return;
    L20:
        throw null;
    L27:
        r105 = r104.call();     // Catch: Throwable -> L24
    L5:
        if (com.bytedance.apm.d.getContext() == null) goto L7;
        r100.b();     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private static void weedOutOldestLogFiles() {
        if (com.bytedance.apm.d.k() == true) goto L6;
        return;
    L6:
        if (sProcessLogsFolder.exists() == true) goto L8;
        return;
    L8:
        File[] r100 = sProcessLogsFolder.listFiles();
        Arrays.sort(r100, new a0());
        int r101 = 60;
        if (r100.length > 60) goto L12;
        r101 = r100.length;
    L12:
        int r102 = 0;
    L13:
        if (r102 >= r101) goto L15;
        r100[r102].delete();
        r102 = r102 + 1;
        goto L13
    }

    public static void addBatteryDataListener(i0 r100) {
        vr3.j r101 = vr3.j.b.f556877a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101.f556871n != null) goto L8;
        r101.f556871n = new ArrayList();
    L8:
        ((ArrayList) r101.f556871n).add(r100);
    }

    private static void addDebugMessage(JSONObject r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
        r101.put(KEY_DEBUG_UUID, com.bytedance.apm.d.h() + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L6
        r100.put(KEY_SELF_DEBUG_MESSAGE, r101);     // Catch: Exception -> L6
        return;
    }

    public static void configSceneMinDuration(HashMap<String, Long> r100) {
        vr3.k.a.f556893a.f556882k.putAll(r100);
    }

    private static JSONObject getExtraLog(JSONObject r100) {
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        if (r100.isNull("timestamp") == true) goto L11;
    L10:
        return r100;
    L11:
        r100.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static boolean getLogTypeSwitch(String r100) {
        return ApmDelegate.g.f190592a.b(r100);
    }

    private static JSONObject getMemInfo(ts3.b r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put("javaTotalMemory", r100.f547365a);
        r101.put("javaFreeMemory", r100.f547366b);
        r101.put("javaUsedMemory", r100.f547367c);
        r101.put("pssDalvik", r100.f547368d);
        r101.put("pssNative", r100.f547369e);
        r101.put("pssTotal", r100.f547370f);
        r101.put("graphics", r100.f547371g);
        r101.put("vmSize", r100.f547372h);
        return r101;
    }

    public static boolean getMetricsSwitch(String r100) {
        ApmDelegate r101 = ApmDelegate.g.f190592a;
        if (r101.f190575f == false) goto L8;
        SlardarConfigManagerImpl r102 = r101.f190574e;
        if (r102 == null) goto L8;
        return r102.getMetricTypeSwitch(r100);
    L8:
        return false;
    }

    public static boolean getServiceSwitch(String r100) {
        ApmDelegate r101 = ApmDelegate.g.f190592a;
        if (r101.f190575f == false) goto L8;
        SlardarConfigManagerImpl r102 = r101.f190574e;
        if (r102 == null) goto L8;
        return r102.getServiceSwitch(r100);
    L8:
        return false;
    }

    public static void monitorEvent(com.bytedance.apm.config.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (jt3.a.g(r100.f190459a, Boolean.TRUE) == false) goto L8;
        notifyNotSampled(r100.f190459a, null);
        return;
    L8:
        JSONObject r101 = getExtraLog(r100.f190463e);
        addDebugMessage(r101);
        bt3.b.d.f20539a.e(new a(r100, r101));
        if (com.bytedance.apm.d.f190515c == false) goto L12;
        JSONObject r102 = optDeepCopyJson(r100.f190461c, true);
        JSONObject r103 = optDeepCopyJson(r100.f190462d, true);
        JSONObject r104 = optDeepCopyJson(r101, true);
        bt3.c.a().b(new b(r100, r102, r103, r104));
        return;
    }

    private static JSONObject optShallowCopyJson(JSONObject r100) {
        if (FAST_MODE == false) goto L6;
        return com.bytedance.apm.util.j.g(r100);
    L6:
        return preProcessExtJson2(r100);
    }

    private static JSONObject preProcessExtJson(JSONObject r100) {
        JSONObject r101 = null;
        if (r100 != null) goto L19;
    L12:
        if (r101 != null) goto L15;
        r101 = new JSONObject();     // Catch: Exception -> L18
    L15:
        if (r101.isNull("timestamp") == false) goto L17;
        r101.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L18
    L18:
        return r100;
    L17:
        return r101;
    L19:
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L18
        if (r102 == null) goto L12;
        r101 = new JSONObject();     // Catch: Exception -> L18
    L10:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Exception -> L18
        r101.put(r103, r100.opt(r103));     // Catch: Exception -> L18
        goto L10
    }

    private static JSONObject preProcessExtJson2(JSONObject r100) {
        if (r100 != null) goto L6;
        r100 = new JSONObject();     // Catch: Exception -> L9
    L8:
        return r100;
    L6:
        if (r100.isNull("timestamp") == false) goto L8;
        r100.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        goto L8
    }

    public static int reportThreadCount(String r100) {
        return ss3.j.j(r100, true);
    L5:
        return 0;
    }

    public static void setReportMode(com.bytedance.apm.config.c r100) {
        ApmDelegate.g.f190592a.getClass();
    }

    public static void startBatteryCollect(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L17;
        Object r101 = vr3.b.C;
        vr3.b r102 = vr3.b.e.f556835a;
        if (((ConcurrentHashMap) r102.f556810g).isEmpty() == true) goto L18;
        if (r100 == null) goto L19;
        List<String> r103 = r102.f556817n;
        if (r103 != null) goto L11;
    L15:
        bt3.b.d.f20539a.b(new vr3.c(r102, r100));
        return;
    L11:
        if (((ArrayList) r103).isEmpty() == true) goto L15;
        if (((ArrayList) r102.f556817n).contains(r100) == false) goto L15;
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void startCollectCurrent(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L6;
        bt3.b.d.f20539a.e(new u(r100));
        return;
    }

    public static void startCpuMonitor(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L6;
        bt3.b.d.f20539a.e(new x(r100));
        return;
    }

    public static void startScene(String r100) {
        ss3.f.a().f543348a.add(r100);
        ou3.a.a().f526725a.add(r100);
    }

    public static void startTrafficStats(String r100) {
        String r101 = ws3.k.f561008x;
        ws3.k r102 = ws3.k.a.f561028a;
        monitor-enter(r102);
        bt3.b.d.f20539a.e(new ws3.i(r102, r100, false));     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void stopBatteryCollect(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L17;
        Object r101 = vr3.b.C;
        vr3.b r102 = vr3.b.e.f556835a;
        if (((ConcurrentHashMap) r102.f556810g).isEmpty() == true) goto L18;
        if (r100 == null) goto L19;
        List<String> r103 = r102.f556817n;
        if (r103 != null) goto L11;
    L15:
        bt3.b.d.f20539a.b(new vr3.d(r102, r100));
        return;
    L11:
        if (((ArrayList) r103).isEmpty() == true) goto L15;
        if (((ArrayList) r102.f556817n).contains(r100) == false) goto L15;
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void stopCollectCurrent(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L6;
        bt3.b.d.f20539a.e(new w(r100));
        return;
    }

    public static void stopCpuMonitor(String r100) {
        if (com.bytedance.apm.d.getContext() == null) goto L6;
        bt3.b.d.f20539a.e(new y(r100));
        return;
    }

    public static void stopScene(String r100) {
        ss3.f.a().f543348a.remove(r100);
        ou3.a.a().f526725a.remove(r100);
    }

    public static void stopTrafficStats(String r100) {
        String r101 = ws3.k.f561008x;
        ws3.k r102 = ws3.k.a.f561028a;
        monitor-enter(r102);
        bt3.b.d.f20539a.e(new ws3.j(r102, r100));     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ JSONObject access$000(JSONObject r100, boolean r101) {
        return optDeepCopyJson(r100, r101);
    }

    public static void addPerfTag(String r100, String r101) {
        ss3.f.a().f543349b.put(r100, r101);
        ou3.a.a().f526726b.put(r100, r101);
    }

    public static void com_bytedance_apm_ApmAgent__monitorCommonLog$___twin___(String r100, JSONObject r101) {
        monitorCommonLog(r100, r101, false);
    }

    public static void com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorCommonLog(String r100, JSONObject r101) {
        if (r101 != null) goto L7;
    L4:
        com_bytedance_apm_ApmAgent__monitorCommonLog$___twin___(r100, r101);
        return;
    L7:
        NetQualityManager.NetworkStatus r102 = NetQualityManager.f360092a;     // Catch: JSONException -> L6
        r101.put("network_quality", NetQualityManager.f360092a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void monitorExceptionLog(String r100, JSONObject r101) {
        JSONObject r102 = preProcessExtJson2(r101);
        bt3.b.d.f20539a.e(new j(r100, r102));
        if (com.bytedance.apm.d.f190515c == false) goto L6;
        bt3.c.a().b(new l(r100, r102));
        return;
    }

    public static void monitorPageLoad(JSONObject r100, JSONObject r101) {
        monitorPerformance(UploadTypeInf.PAGE_LOAD, UploadTypeInf.PAGE_LOAD, r100, r101, null);     // Catch: Exception -> L5
        return;
    }

    private static void notifyNotSampled(String r100, JSONObject r101) {
        if (com.bytedance.apm.d.j() == false) goto L8;
        if (r101 != null) goto L6;
        r101 = new JSONObject();
    L6:
        ls3.a.a(r100, r101, false);
        return;
    }

    private static JSONObject optDeepCopyJson(JSONObject r100, boolean r101) {
        if (FAST_MODE == true) goto L8;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new JSONObject(r100.toString());
    L17:
        return r100;
    L8:
        if (r101 == true) goto L10;
        return r100;
    L10:
        return com.bytedance.apm.util.j.g(r100);
    }

    public static void removePerfTag(String r100, String r101) {
        ss3.f.a().f543349b.remove(r100, r101);
        ou3.a.a().f526726b.remove(r100, r101);
    }

    public static void startTrafficStats(String r100, boolean r101) {
        String r102 = ws3.k.f561008x;
        ws3.k r103 = ws3.k.a.f561028a;
        monitor-enter(r103);
        bt3.b.d.f20539a.e(new ws3.i(r103, r100, r101));     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void storeLogBypass(String r110, String r111) {
        monitor-enter(ApmAgent.class);     // Catch: Throwable -> L40
        String r100 = com.bytedance.apm.d.c();     // Catch: Throwable -> L36
        long r101 = ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L36
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L36
        String r103 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L36
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L36
        r104.append(r110);     // Catch: Throwable -> L36
        r104.append("#");     // Catch: Throwable -> L36
        r104.append(r101);     // Catch: Throwable -> L36
        r104.append("#");     // Catch: Throwable -> L36
        r104.append(r102);     // Catch: Throwable -> L36
        r104.append("#");     // Catch: Throwable -> L36
        r104.append(r103);     // Catch: Throwable -> L36
        r104.append("\n");     // Catch: Throwable -> L36
        r104.append(r111);     // Catch: Throwable -> L36
        r104.append("\n");     // Catch: Throwable -> L36
        byte[] r105 = r104.toString().getBytes("UTF-8");     // Catch: Throwable -> L36
        String r106 = com.bytedance.apm.d.getContext().getExternalFilesDir(null).getAbsolutePath();     // Catch: Throwable -> L36
        if (sMappedByteBuffer != null) goto L18;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106 + "/logs");     // Catch: Throwable -> L36
        sProcessLogsFolder = new PolarisFileWrapper(r106 + "/logs/proc: " + r100);     // Catch: Throwable -> L36
        PolarisFileWrapper r108 = new PolarisFileWrapper(r106 + "/logs/proc: " + r100 + HTTP.URL_DEFAULT + r103);     // Catch: Throwable -> L36
        if (r107.exists() == true) goto L10;
        r107.mkdirs();     // Catch: Throwable -> L36
    L10:
        if (sProcessLogsFolder.exists() == true) goto L12;
        sProcessLogsFolder.mkdirs();     // Catch: Throwable -> L36
    L12:
        r108.createNewFile();     // Catch: Throwable -> L36
        FileChannel r112 = new RandomAccessFile(r108, "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r113 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.k() == false) goto L15;
        long r114 = 2097152;
    L16:
        sMappedByteBuffer = r112.map(r113, 0, r114);     // Catch: Throwable -> L36
        goto L18
    L15:
        r114 = 262144;
    L18:
        if (sMappedByteBuffer.remaining() >= r105.length) goto L24;
        sMappedByteBuffer.force();     // Catch: Throwable -> L36
        FileChannel r115 = new RandomAccessFile(new PolarisFileWrapper(r106 + "/logs/proc: " + r100 + HTTP.URL_DEFAULT + r103), "rw").getChannel();     // Catch: Throwable -> L36
        FileChannel.MapMode r116 = FileChannel.MapMode.READ_WRITE;     // Catch: Throwable -> L36
        if (com.bytedance.apm.d.k() == false) goto L22;
        long r117 = 2097152;
    L23:
        sMappedByteBuffer = r115.map(r116, 0, r117);     // Catch: Throwable -> L36
        goto L24
    L22:
        r117 = 262144;
    L24:
        sMappedByteBuffer.put(r105);     // Catch: Throwable -> L36
        if (sLastCheckDiskTime == (-1)) goto L29;
        if ((System.currentTimeMillis() - sLastCheckDiskTime) > 3600000) goto L29;
    L34:
        monitor-exit(ApmAgent.class);     // Catch: Throwable -> L36
        goto L45
    L39:
        return;
    L29:
        if (com.bytedance.apm.util.g.e(sProcessLogsFolder) <= 1073741824) goto L31;
    L32:
        weedOutOldestLogFiles();     // Catch: Throwable -> L36
    L33:
        sLastCheckDiskTime = System.currentTimeMillis();     // Catch: Throwable -> L36
        goto L34
    L31:
        if (com.bytedance.apm.util.g.c(com.bytedance.apm.d.getContext()).getFreeSpace() >= 1073741824) goto L33;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }

    public static void uploadMappingFile(String r100, ff7.e r110) {
        String r101 = com.bytedance.apm.d.f190519g.optString("aid");
        String r102 = com.bytedance.apm.d.f190519g.optString("update_version_code");
        String r103 = com.bytedance.apm.d.f190519g.optString("channel");
        String r104 = com.bytedance.apm.d.f190519g.optString("release_build");
        String r105 = com.bytedance.apm.d.f190519g.optString("device_id");
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L13:
        if (r110 == null) goto L16;
        r110.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L13;
        if (TextUtils.isEmpty(r103) == true) goto L13;
        if (TextUtils.isEmpty(r104) == true) goto L13;
        xs3.a.d(r101, r102, r103, r104, r100, r105, r110);
    }

    public static void feedbackReport(long r100, long r110, boolean r111) {
        bt3.b.d.f20539a.e(new z(r100, r110, r111));
    }

    public static void monitorCommonLog(String r100, JSONObject r101, boolean r102) {
        if (jt3.a.g(r100, Boolean.FALSE) == false) goto L6;
        notifyNotSampled(r100, r101);
        return;
    L6:
        JSONObject r103 = preProcessExtJson2(r101);
        addDebugMessage(r103);
        bt3.b.d.f20539a.e(new m(r100, r103));
        if (com.bytedance.apm.d.f190515c == false) goto L10;
        JSONObject r104 = optDeepCopyJson(r103, true);
        bt3.c.a().b(new n(r100, r104, r102));
        return;
    }

    public static void monitorDirectOnTimer(String r100, String r101, float r102) {
        bt3.b.d.f20539a.e(new s(r100, r101, r102));
        if (com.bytedance.apm.d.f190515c == false) goto L6;
        bt3.c.a().b(new t(r100, r101, r102));
        return;
    }

    public static void monitorDuration(String r100, JSONObject r101, JSONObject r110) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r101);
        return;
    L6:
        JSONObject r111 = preProcessExtJson2(r110);
        addDebugMessage(r111);
        if (sDeepCopy == false) goto L19;
        if (r101 == null) goto L12;
        Iterator<String> r102 = r101.keys();
        if (r102 == null) goto L12;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L24
    L15:
        if (r102.hasNext() == false) goto L18;
        String r104 = r102.next();     // Catch: Exception -> L24
        r103.put(r104, r101.opt(r104));     // Catch: Exception -> L24
    L18:
        JSONObject r105 = r103;
    L20:
        jt3.a.d(new lt3.a(r100, 0, r105, null, null, r111));
        if (com.bytedance.apm.d.f190515c == false) goto L29;
        bt3.c.a().b(new f(r100, optDeepCopyJson(r101, true), optDeepCopyJson(r111, true)));
        return;
    L29:
        return;
    L12:
        r105 = null;
    L19:
        r105 = r101;
        goto L20
    }

    public static void monitorStatusRate(String r100, int r101, JSONObject r102) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r102);
        return;
    L6:
        JSONObject r103 = preProcessExtJson2(r102);
        addDebugMessage(r103);
        jt3.a.e(r100, r101, null, null, r103);
        if (com.bytedance.apm.d.f190515c == false) goto L10;
        JSONObject r104 = optDeepCopyJson(r103, true);
        bt3.c.a().b(new e(r100, r101, r104));
        return;
    }

    public static void monitorUIAction(String r100, String r101, JSONObject r102) {
        monitorUIAction(r100, r101, r102, null);
    }

    public static void activeUploadAlog(long r100, long r101, String r110, IALogActiveUploadObserver r111) {
        activeUploadAlog("", r100, r101, r110, r111);
    }

    public static void com_bytedance_apm_ApmAgent__monitorEvent$___twin___(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r101);
        return;
    L6:
        JSONObject r104 = preProcessExtJson2(r103);
        addDebugMessage(r104);
        jt3.a.e(r100, 0, optDeepCopyJson(r101, true), optDeepCopyJson(r102, true), r104);
        if (com.bytedance.apm.d.f190515c == false) goto L10;
        JSONObject r105 = optDeepCopyJson(r101, true);
        JSONObject r106 = optDeepCopyJson(r102, true);
        JSONObject r107 = optDeepCopyJson(r104, true);
        bt3.c.a().b(new h0(r100, r105, r106, r107));
        return;
    }

    public static void com_bytedance_apm_ApmAgent_com_larus_home_impl_utils_CommonHook_monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        if (r101 != null) goto L7;
    L4:
        com_bytedance_apm_ApmAgent__monitorEvent$___twin___(r100, r101, r102, r103);
        return;
    L7:
        NetQualityManager.NetworkStatus r104 = NetQualityManager.f360092a;     // Catch: JSONException -> L6
        r101.put("network_quality", NetQualityManager.f360092a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void monitorDuration(String r100, JSONObject r101, JSONObject r102, long r103) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r101);
        return;
    L6:
        if (r102 != null) goto L15;
    L11:
        JSONObject r104 = optShallowCopyJson(r102);
        addDebugMessage(r104);
        bt3.b.d.f20539a.e(new g(r100, r101, r104));
        if (com.bytedance.apm.d.f190515c == false) goto L17;
        JSONObject r105 = optDeepCopyJson(r101, true);
        JSONObject r106 = optDeepCopyJson(r104, true);
        bt3.c.a().b(new h(r100, r105, r106));
        return;
    L17:
        return;
    L15:
        r102.put("timestamp", r103);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void monitorPerformance(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        monitorPerformance(r100, "", r101, r102, r103);
    }

    public static void monitorStatusAndDuration(String r100, int r110, JSONObject r111, JSONObject r112) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r111);
        return;
    L6:
        JSONObject r101 = optShallowCopyJson(r112);
        addDebugMessage(r101);
        jt3.a.d(new lt3.a(r100, r110, optDeepCopyJson(r111, true), null, null, optDeepCopyJson(r101, false)));
        if (com.bytedance.apm.d.f190515c == false) goto L10;
        JSONObject r113 = optDeepCopyJson(r111, true);
        JSONObject r114 = optDeepCopyJson(r112, true);
        bt3.c.a().b(new i(r100, r110, r113, r114));
        return;
    }

    public static void monitorUIAction(String r100, String r101, JSONObject r102, JSONObject r103) {
        if (sDeepCopy == false) goto L5;
        JSONObject r104 = preProcessExtJson(r103);     // Catch: Exception -> L10
    L6:
        bt3.b.d.f20539a.e(new o(r100, r101, r102, r104));     // Catch: Exception -> L10
        if (com.bytedance.apm.d.f190515c == false) goto L13;
        bt3.c.a().b(new p(r100, r101, r102, r104));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r104 = preProcessExtJson2(r103);     // Catch: Exception -> L10
    }

    public static void activeUploadAlog(String r100, long r101, long r110, String r111, IALogActiveUploadObserver r112) {
        activeUploadAlog(r100, r101, r110, r111, r112, null);
    }

    public static void monitorPerformance(String r100, String r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        if (sDeepCopy == false) goto L5;
        JSONObject r113 = preProcessExtJson(r112);     // Catch: Exception -> L10
    L6:
        bt3.b.d.f20539a.e(new q(r100, r101, r110, r111, r113));     // Catch: Exception -> L10
        if (com.bytedance.apm.d.f190515c == false) goto L13;
        bt3.c.a().b(new r(r100, r101, r110, r111, r113));     // Catch: Exception -> L10
        return;
    L13:
        return;
    L5:
        r113 = preProcessExtJson2(r112);     // Catch: Exception -> L10
    }

    public static void monitorStatusAndEvent(String r100, int r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        if (jt3.a.g(r100, Boolean.TRUE) == false) goto L6;
        notifyNotSampled(r100, r110);
        return;
    L6:
        JSONObject r113 = optShallowCopyJson(r112);
        addDebugMessage(r113);
        bt3.b.d.f20539a.e(new c(r100, r101, r110, r111, r113));
        if (com.bytedance.apm.d.f190515c == false) goto L10;
        JSONObject r102 = optDeepCopyJson(r110, true);
        JSONObject r103 = optDeepCopyJson(r111, true);
        JSONObject r104 = optDeepCopyJson(r113, true);
        bt3.c.a().b(new d(r100, r101, r102, r103, r104));
        return;
    }

    public static void activeUploadAlog(String r110, long r111, long r112, String r113, IALogActiveUploadObserver r114, tr3.f r115) {
        if (ApmDelegate.g.f190592a.f190581l == false) goto L5;
        bt3.b.d.f20539a.j(new com.bytedance.apm.internal.e(r110, r111, r112, r113, r114, r115));
        return;
    L5:
        if (r115 == null) goto L9;
        r115.a(false, tr3.c.a(false, 9, null, null));
        return;
    }

    public static void trafficStats(long r110, String r111, String r112, String r210, JSONObject r211, JSONObject r212) {
        ws3.d r100 = ws3.d.b.f560968a;
        if (r100.f560952a == false) goto L39;
        bt3.b.d.f20539a.e(new ws3.c(r112, r110, r111));
        String r113 = "";
        if (r100.f560953b == false) goto L23;
        if (r110 <= r100.f560964m) goto L23;
        Object[] r101 = new Object[6];
        r101[0] = Long.valueOf(r110);
        r101[1] = r111;
        r101[2] = r112;
        if (r210 != null) goto L12;
        String r102 = "";
    L13:
        r101[3] = r102;
        if (r211 != null) goto L16;
        String r103 = "";
    L17:
        r101[4] = r103;
        if (r212 != null) goto L20;
        String r104 = "";
    L21:
        r101[5] = r104;
        String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r101);
        goto L23
    L20:
        r104 = r212.toString();
        goto L21
    L16:
        r103 = r211.toString();
        goto L17
    L12:
        r102 = r210;
    L23:
        if (com.bytedance.apm.d.j() == false) goto L37;
        Object[] r105 = new Object[6];
        r105[0] = Long.valueOf(r110);
        r105[1] = r111;
        r105[2] = r112;
        if (r210 != null) goto L27;
        String r106 = "";
    L28:
        r105[3] = r106;
        if (r211 != null) goto L31;
        String r107 = "";
    L32:
        r105[4] = r107;
        if (r212 == null) goto L36;
        r113 = r212.toString();
    L36:
        r105[5] = r113;
        String.format("trafficBytes: %d, sourceId: %s, business: %s, scene: %s, extraStatus: %s, extraLog: %s", r105);
        goto L37
    L31:
        r107 = r211.toString();
        goto L32
    L27:
        r106 = r210;
    L37:
        r100.f560961j += r110;
        return;
    }

    public static void uploadMappingFile(String r100, String r101, String r110, String r111, String r112, ff7.e r113) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L13:
        if (r113 == null) goto L16;
        r113.onFail("Missing required parameters");
        return;
    L16:
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L13;
        if (TextUtils.isEmpty(r111) == true) goto L13;
        if (TextUtils.isEmpty(r112) == true) goto L13;
        uploadMappingFileInternal(r100, r101, r110, r111, r112, null, r113);
    }

    public static void monitorApiError(long r110, long r111, String r112, String r113, String r114, int r210, JSONObject r211) {
        JSONObject r115 = optShallowCopyJson(r211);
        bt3.b.d.f20539a.e(new b0(r110, r111, r112, r113, r114, r210, r115));
        if (com.bytedance.apm.d.f190515c == false) goto L6;
        bt3.c.a().b(new c0(r110, r111, r112, r113, r114, r210, r115));
        return;
    }

    public static void monitorSLA(long r110, long r111, String r112, String r113, String r114, int r210, JSONObject r211) {
        JSONObject r115 = optShallowCopyJson(r211);
        bt3.b.d.f20539a.e(new k(r110, r111, r112, r113, r114, r210, r115));
        if (com.bytedance.apm.d.f190515c == false) goto L6;
        bt3.c.a().b(new v(r110, r111, r112, r113, r114, r210, r115));
        return;
    }

    public static void uploadMappingFile(String r100, String r101, String r110, String r111, String r112, ff7.e r113, String r114) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L15:
        if (r113 == null) goto L18;
        r113.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L15;
        if (TextUtils.isEmpty(r111) == true) goto L15;
        if (TextUtils.isEmpty(r112) == true) goto L15;
        if (TextUtils.isEmpty(r114) == true) goto L15;
        xs3.a.b(r114);
        bt3.b.d.f20539a.j(new xs3.b(r101, r110, r111, r112, r100, r113));
    }

    private static void uploadMappingFileInternal(String r100, String r101, String r102, String r110, String r111, String r112, ff7.e r113) {
        List<String> r103 = fs3.a.f478655b;
        if (com.bytedance.apm.util.k.b(r103) == false) goto L13;
        if (r113 == null) goto L15;
        r113.onFail("need host");
        return;
    L15:
        return;
    L13:
        xs3.a.b(new URL((String) ListProtector.get(r103, 0)).getHost());     // Catch: MalformedURLException -> L9
        xs3.a.d(r101, r102, r110, r111, r100, r112, r113);     // Catch: MalformedURLException -> L9
        return;
    L10:
        if (r113 == null) goto L16;
        r113.onFail("MalformedURLException");
        return;
    }

    public static void uploadMappingFile(String r100, String r101, String r102, String r103, String r104, String r105, ff7.e r106) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L15:
        if (r106 == null) goto L18;
        r106.onFail("Missing required parameters");
        return;
    L18:
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        if (TextUtils.isEmpty(r103) == true) goto L15;
        if (TextUtils.isEmpty(r104) == true) goto L15;
        if (TextUtils.isEmpty(r105) == true) goto L15;
        uploadMappingFileInternal(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void monitorSLA(long r110, long r111, String r112, String r113, String r114, int r210, JSONObject r211, HttpRequestInfo r212) {
        JSONObject r115 = optShallowCopyJson(r211);
        Map<String, Map<String, Integer>> r100 = ht3.a.f487117a;
        if (r115 == null) goto L6;
        if (r212 == null) goto L6;
        r115.put("requestHeader", r212.requestHeaders);     // Catch: Throwable -> L10
        r115.put("responseHeader", r212.responseHeaders);     // Catch: Throwable -> L10
    L6:
        bt3.b.d.f20539a.e(new d0(r110, r111, r112, r113, r114, r210, r115));
        if (com.bytedance.apm.d.f190515c == false) goto L13;
        bt3.c.a().b(new e0(r110, r111, r112, r113, r114, r210, r115));
        return;
    }

    public static void uploadMappingFile(String r100, String r101, String r102, String r110, String r111, ff7.e r112, String r113, String r114) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L17:
        if (r112 == null) goto L20;
        r112.onFail("Missing required parameters");
        return;
    L20:
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (TextUtils.isEmpty(r110) == true) goto L17;
        if (TextUtils.isEmpty(r111) == true) goto L17;
        if (TextUtils.isEmpty(r114) == true) goto L17;
        if (TextUtils.isEmpty(r113) == true) goto L17;
        xs3.a.b(r113);
        xs3.a.d(r101, r102, r110, r111, r100, r114, r112);
    }

    public static void monitorApiError(long r110, long r111, String r112, String r113, String r114, int r210, JSONObject r211, HttpRequestInfo r212, Throwable r213) {
        JSONObject r115 = optShallowCopyJson(r211);
        Map<String, Map<String, Integer>> r100 = ht3.a.f487117a;
        if (r115 == null) goto L6;
        if (r213 == null) goto L6;
        r115.put("substatus", ht3.a.a(r213));     // Catch: Throwable -> L13
    L6:
        if (r115 == null) goto L9;
        if (r212 == null) goto L9;
        r115.put("requestHeader", r212.requestHeaders);     // Catch: Throwable -> L14
        r115.put("responseHeader", r212.responseHeaders);     // Catch: Throwable -> L14
    L9:
        bt3.b.d.f20539a.e(new f0(r110, r111, r112, r113, r114, r210, r115));
        if (com.bytedance.apm.d.f190515c == false) goto L19;
        bt3.c.a().b(new g0(r110, r111, r112, r113, r114, r210, r115));
        return;
    }
}
