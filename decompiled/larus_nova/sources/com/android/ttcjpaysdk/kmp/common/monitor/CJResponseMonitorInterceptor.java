package com.android.ttcjpaysdk.kmp.common.monitor;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import com.android.ttcjpaysdk.kmp.base.http.CJHeader;
import com.android.ttcjpaysdk.kmp.base.http.CJInterceptor;
import com.android.ttcjpaysdk.kmp.base.http.CJRequest;
import com.android.ttcjpaysdk.kmp.base.http.CJResponse;
import com.android.ttcjpaysdk.kmp.base.tracker.IKmpCJTrackerService;
import com.android.ttcjpaysdk.kmp.common.utils.CJJsonUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import ouc.a;
import ouc.d0;
import ouc.i;
import ouc.k;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u001e\u0010\u0014\u001a\u00020\u000f2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/monitor/CJResponseMonitorInterceptor;", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor;", "apiInfoList", "", "Lcom/android/ttcjpaysdk/kmp/common/monitor/ApiInfo;", "eventName", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "intercept", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "chain", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchReport", "", "request", "Lcom/android/ttcjpaysdk/kmp/base/http/CJRequest;", "response", "logServerApiStatus", "report", "params", "", "", "extractPath", "url", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJResponseMonitorInterceptor implements CJInterceptor {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String EVENT_NAME_DEFAULT = "wallet_rd_biz_server_api_monitor";
    private static final String HEADER_LOG_ID = "x-tt-logid";
    private static final String HEADER_TRACE_ID = "x-tt-trace_id";
    private static final int STATUS_FAIL_BIZ = -1;
    private static final int STATUS_FAIL_NET_ERROR = -2;
    private static final int STATUS_SUCCESS = 0;
    private static final String TAG = "CJResponseMonitor";
    private static final CoroutineScope reportScope = null;
    private final List<ApiInfo> apiInfoList;
    private final String eventName;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/monitor/CJResponseMonitorInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_NAME_DEFAULT", "STATUS_SUCCESS", "", "STATUS_FAIL_BIZ", "STATUS_FAIL_NET_ERROR", "HEADER_TRACE_ID", "HEADER_LOG_ID", "reportScope", "Lkotlinx/coroutines/CoroutineScope;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.kmp.common.monitor.CJResponseMonitorInterceptor$intercept$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.android.ttcjpaysdk.kmp.common.monitor.CJResponseMonitorInterceptor", f = "CJResponseMonitorInterceptor.kt", i = {0}, l = {68}, m = "intercept", n = {"request"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CJResponseMonitorInterceptor this$0;

        public AnonymousClass1(CJResponseMonitorInterceptor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.intercept(null, this);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        reportScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    private final String extractPath(String r110) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L9;
        return "";
    L9:
        String r111 = StringsKt.substringBefore$default(r110, '?', null, 2, null);
        int r101 = StringsKt.indexOf$default(r111, "://", 0, false, 6, null);
        if (r101 < 0) goto L15;
        String r112 = r111.substring(r101 + 3);
        int r102 = StringsKt.indexOf$default(r112, '/', 0, false, 6, null);
        if (r102 >= 0) goto L17;
        return "";
    L17:
        return r112.substring(r102);
    L15:
        return r111;
    L5:
        r100 = false;
        goto L7
    }

    private final void report(Map<String, ? extends Object> r100) {
        b r101 = c.f528682a;
        IKmpCJTrackerService r102 = (IKmpCJTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJTrackerService.class));
        if (r102 != null) goto L6;
        CJLogger.INSTANCE.w(TAG, "IKmpCJTrackerService not found, skip report");
        return;
    L6:
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r104 = r100.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        Object r106 = r105.getKey();
        Object r107 = r105.getValue();
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r103.put(r106, r107);
        goto L8
    L13:
        CJJsonUtils r108 = CJJsonUtils.INSTANCE;
        a r109 = r108.getJsonInstance();
        i r110 = r108.toJsonElement(r103);
        r109.getClass();
        String r111 = r109.a(i.Companion.serializer(), r110);
        CJLogger.INSTANCE.i(TAG, "trackEvent " + this.eventName + ": " + r111);
        r102.trackEvent(this.eventName, r111);
    }

    public CJResponseMonitorInterceptor(List<ApiInfo> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "apiInfoList");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        this.apiInfoList = r100;
        this.eventName = r101;
    }

    private final void dispatchReport(CJRequest r100, CJResponse r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(BuildersKt.launch$default(reportScope, null, null, new CJResponseMonitorInterceptor$dispatchReport$1$1(this, r100, r101, null), 3, null));     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L15;
        CJLogger r105 = CJLogger.INSTANCE;
        String r106 = r104.getMessage();
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r105.e(TAG, "dispatchReport error: ".concat(r106));
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void logServerApiStatus(CJRequest r110, CJResponse r111) {
        if (this.apiInfoList.isEmpty() == false) goto L5;
        return;
    L5:
        String r112 = extractPath(r110.getUrl());
        int r100 = 0;
        if (r112.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Iterator<T> r102 = this.apiInfoList.iterator();
    L12:
        String r103 = null;
        if (r102.hasNext() == false) goto L17;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((ApiInfo) r104).getPath(), r112) == false) goto L12;
    L18:
        ApiInfo r105 = (ApiInfo) r104;
        if (r105 != null) goto L21;
        return;
    L21:
        LinkedHashMap r113 = new LinkedHashMap();
        r113.put("path", r105.getPath());
        r113.put("code", String.valueOf(r111.getCode()));
        r113.put("msg", r111.getMsg());
        String r106 = r111.getBody();
        if (r106.length() <= 0) goto L24;
        boolean r107 = true;
    L25:
        int r108 = -2;
        String r109 = "";
        if (r107 == true) goto L73;
    L62:
        Iterator<T> r114 = r111.getHeaders().iterator();
        String r115 = "";
    L64:
        if (r114.hasNext() == false) goto L71;
        CJHeader r116 = (CJHeader) r114.next();
        if (StringsKt.equals(r116.getName(), HEADER_TRACE_ID, true) == true) goto L67;
        if (StringsKt.equals(r116.getName(), "x-tt-logid", true) == false) goto L64;
        r115 = r116.getValue();
        goto L64
    L67:
        r109 = r116.getValue();
        goto L64
    L71:
        r113.put(BindCardPayConfirmConstants.Key.TRACE_ID, r109);
        r113.put("log_id", r115);
        r113.put("status", Integer.valueOf(r108));
        report(r113);
        return;
    L73:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L47
        d0 r118 = k.n(CJJsonUtils.INSTANCE.getJsonInstance().e(r106));     // Catch: Throwable -> L47
        Object r119 = r118.get("response");     // Catch: Throwable -> L47
        if ((r119 instanceof d0) == false) goto L30;
        d0 r120 = (d0) r119;     // Catch: Throwable -> L47
    L31:
        if (r120 == null) goto L34;
        r118 = r120;
    L34:
        i r121 = (i) r118.get("code");     // Catch: Throwable -> L47
        if (r121 == null) goto L37;
        String r122 = k.o(r121).a();     // Catch: Throwable -> L47
    L38:
        if (r122 != null) goto L40;
        r122 = "";
    L40:
        i r123 = (i) r118.get("msg");     // Catch: Throwable -> L47
        if (r123 == null) goto L43;
        r103 = k.o(r123).a();     // Catch: Throwable -> L47
    L43:
        if (r103 != null) goto L45;
        r103 = "";
    L45:
        Object r124 = Result.m9449constructorimpl(TuplesKt.to(r122, r103));     // Catch: Throwable -> L47
    L50:
        if (Result.m9456isSuccessimpl(r124) == false) goto L56;
        ResultKt.throwOnFailure(r124);
        Pair r125 = (Pair) r124;
        String r126 = (String) r125.component1();
        String r127 = (String) r125.component2();
        r113.put("code", r126);
        r113.put("msg", r127);
        if (Intrinsics.areEqual(r126, r105.getBizSuccessCode()) == true) goto L55;
        r100 = -1;
    L55:
        r108 = r100;
        goto L62
    L56:
        r113.put("msg", r106);
        CJLogger r128 = CJLogger.INSTANCE;
        StringBuilder r129 = new StringBuilder("parse body failed: ");
        Throwable r130 = Result.m9452exceptionOrNullimpl(r124);
        if (r130 == null) goto L60;
        String r131 = r130.getMessage();
        if (r131 == null) goto L60;
    L61:
        r129.append(r131);
        r128.e(TAG, r129.toString());
    L60:
        r131 = "";
        goto L61
    L37:
        r122 = null;
        goto L38
    L30:
        r120 = null;
    L47:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L24:
        r107 = false;
        goto L25
    L17:
        r104 = null;
        goto L18
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.kmp.base.http.CJInterceptor
    public Object intercept(CJInterceptor.Chain r100, Continuation<? super CJResponse> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        CJRequest r107 = (CJRequest) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        CJResponse r108 = (CJResponse) r104;
        dispatchReport(r107, r108);
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CJRequest r109 = r100.request();
        r102.L$0 = r109;
        r102.label = 1;
        Object r110 = r100.proceed(r109, r102);
        if (r110 != r105) goto L17;
        return r105;
    L17:
        r104 = r110;
        r107 = r109;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public static final /* synthetic */ void access$logServerApiStatus(CJResponseMonitorInterceptor r100, CJRequest r101, CJResponse r102) {
        r100.logServerApiStatus(r101, r102);
    }

    public /* synthetic */ CJResponseMonitorInterceptor(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = EVENT_NAME_DEFAULT;
    L5:
        this(r100, r101);
    }
}
