package com.bytedance.ai.monitor.auth;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.sva.sdk.data.ISmModel;
import d3.a0;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletAuthTaskMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureRandom f37154a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$ErrorCode;", "", "code", "", "errorName", "", "defaultMsg", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getErrorName", "()Ljava/lang/String;", "getDefaultMsg", "UNKNOWN", "CONTEXT_MISSING", "INVALID_STATE", "CONCURRENT_FLOW", "INVALID_PARAM", "TIMEOUT", "API_FAILED", "INVALID_RESPONSE", "USER_CANCELLED", "USER_REFUSED", "UI_RENDER_FAILED", "ROUTE_FAILED", "EMPTY_LOGIN_CODE", "INVALID_LOGIN_CODE", "AUTH_LINK_INVALID", "SYSTEM_PERMISSION_DENIED", "SYSTEM_PERMISSION_RESTRICTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorCode extends Enum<ErrorCode> {
        public static final ErrorCode API_FAILED = null;
        public static final ErrorCode AUTH_LINK_INVALID = null;
        public static final ErrorCode CONCURRENT_FLOW = null;
        public static final ErrorCode CONTEXT_MISSING = null;
        public static final ErrorCode EMPTY_LOGIN_CODE = null;
        public static final ErrorCode INVALID_LOGIN_CODE = null;
        public static final ErrorCode INVALID_PARAM = null;
        public static final ErrorCode INVALID_RESPONSE = null;
        public static final ErrorCode INVALID_STATE = null;
        public static final ErrorCode ROUTE_FAILED = null;
        public static final ErrorCode SYSTEM_PERMISSION_DENIED = null;
        public static final ErrorCode SYSTEM_PERMISSION_RESTRICTED = null;
        public static final ErrorCode TIMEOUT = null;
        public static final ErrorCode UI_RENDER_FAILED = null;
        public static final ErrorCode UNKNOWN = null;
        public static final ErrorCode USER_CANCELLED = null;
        public static final ErrorCode USER_REFUSED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ErrorCode[] f37155a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37156b = null;
        private final int code;
        private final String defaultMsg;
        private final String errorName;

        public static EnumEntries<ErrorCode> getEntries() {
            return f37156b;
        }

        static {
            ErrorCode r100 = new ErrorCode("UNKNOWN", 0, 1000, "UNKNOWN", IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
            UNKNOWN = r100;
            ErrorCode r101 = new ErrorCode("CONTEXT_MISSING", 1, 1001, "CONTEXT_MISSING", "context missing");
            CONTEXT_MISSING = r101;
            ErrorCode r102 = new ErrorCode("INVALID_STATE", 2, 1002, "INVALID_STATE", "invalid state");
            INVALID_STATE = r102;
            ErrorCode r103 = new ErrorCode("CONCURRENT_FLOW", 3, 1003, "CONCURRENT_FLOW", "concurrent auth flow");
            CONCURRENT_FLOW = r103;
            ErrorCode r104 = new ErrorCode("INVALID_PARAM", 4, 1004, "INVALID_PARAM", "invalid parameter");
            INVALID_PARAM = r104;
            ErrorCode r105 = new ErrorCode("TIMEOUT", 5, 1005, "TIMEOUT", "auth task timeout");
            TIMEOUT = r105;
            ErrorCode r106 = new ErrorCode("API_FAILED", 6, 1006, "API_FAILED", "api failed");
            API_FAILED = r106;
            ErrorCode r110 = new ErrorCode("INVALID_RESPONSE", 7, 1007, "INVALID_RESPONSE", "invalid response");
            INVALID_RESPONSE = r110;
            ErrorCode r107 = new ErrorCode("USER_CANCELLED", 8, 1008, "USER_CANCELLED", "user cancelled");
            USER_CANCELLED = r107;
            ErrorCode r108 = new ErrorCode("USER_REFUSED", 9, 1009, "USER_REFUSED", "user refused");
            USER_REFUSED = r108;
            ErrorCode r109 = new ErrorCode("UI_RENDER_FAILED", 10, 1010, "UI_RENDER_FAILED", "ui render failed");
            UI_RENDER_FAILED = r109;
            ErrorCode r111 = new ErrorCode("ROUTE_FAILED", 11, 1011, "ROUTE_FAILED", "route failed");
            ROUTE_FAILED = r111;
            ErrorCode r112 = new ErrorCode("EMPTY_LOGIN_CODE", 12, 1012, "EMPTY_LOGIN_CODE", "login code is empty");
            EMPTY_LOGIN_CODE = r112;
            ErrorCode r113 = new ErrorCode("INVALID_LOGIN_CODE", 13, 1013, "INVALID_LOGIN_CODE", "login code is invalid");
            INVALID_LOGIN_CODE = r113;
            ErrorCode r210 = new ErrorCode("AUTH_LINK_INVALID", 14, 1014, "AUTH_LINK_INVALID", "auth link is invalid");
            AUTH_LINK_INVALID = r210;
            ErrorCode r114 = new ErrorCode("SYSTEM_PERMISSION_DENIED", 15, 1015, "SYSTEM_PERMISSION_DENIED", "system permission denied");
            SYSTEM_PERMISSION_DENIED = r114;
            ErrorCode r115 = new ErrorCode("SYSTEM_PERMISSION_RESTRICTED", 16, 1016, "SYSTEM_PERMISSION_RESTRICTED", "system permission restricted");
            SYSTEM_PERMISSION_RESTRICTED = r115;
            ErrorCode[] r116 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115};
            f37155a = r116;
            f37156b = EnumEntriesKt.enumEntries(r116);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) f37155a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDefaultMsg() {
            return this.defaultMsg;
        }

        public final String getErrorName() {
            return this.errorName;
        }

        public static ErrorCode valueOf(String r100) {
            return (ErrorCode) r27.a.a(ErrorCode.class, r100);
        }

        public ErrorCode(String r100, int r101, int r102, String r103, String r104) {
            super(r100, r101);
            this.code = r102;
            this.errorName = r103;
            this.defaultMsg = r104;
        }
    }

    public static final class Session {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f37157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f37159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f37160d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f37161e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f37162f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f37163g;

        public final void b() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.f37161e != null) goto L6;
            this.f37161e = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L9
        L6:
            Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        public final void c() {
            monitor-enter(this);
            Long r100 = this.f37161e;     // Catch: Throwable -> L10
            if (r100 == null) goto L8;
            this.f37162f += System.currentTimeMillis() - r100.longValue();     // Catch: Throwable -> L10
            this.f37161e = null;     // Catch: Throwable -> L10
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L8:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final long e() {
            monitor-enter(this);
            long r100 = RangesKt.coerceAtLeast(this.f37163g, 0);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public final void a(long r100) {
            monitor-enter(this);
            this.f37163g += RangesKt.coerceAtLeast(r100, 0);     // Catch: Throwable -> L6
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void d(a r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            if (this.f37160d.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            c();
            SecureRandom r101 = AppletAuthTaskMonitor.f37154a;
            AppletAuthTaskMonitor.f(this, r100, System.currentTimeMillis(), false);
        }

        public final <T> Object f(Function1<? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
            if ((r101 instanceof AppletAuthTaskMonitor$Session$trackBackend$1) == false) goto L7;
            AppletAuthTaskMonitor$Session$trackBackend$1 r102 = (AppletAuthTaskMonitor$Session$trackBackend$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L18;
            if (r106 != 1) goto L17;
            long r107 = r102.J$0;
            ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
        L23:
            a(System.currentTimeMillis() - r107);
            return r104;
        L14:
            th = th;
        L27:
            a(System.currentTimeMillis() - r107);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r104);
            long r108 = System.currentTimeMillis();
            r102.J$0 = r108;     // Catch: Throwable -> L25
            r102.label = 1;     // Catch: Throwable -> L25
            r104 = r100.invoke(r102);     // Catch: Throwable -> L25
            if (r104 != r105) goto L22;
            return r105;
        L22:
            r107 = r108;
        L25:
            th = th;
            r107 = r108;
        L7:
            r102 = new AppletAuthTaskMonitor$Session$trackBackend$1(this, r101);
            goto L8
        }

        public final <T> Object g(Function1<? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
            if ((r101 instanceof AppletAuthTaskMonitor$Session$trackUserWait$1) == false) goto L7;
            AppletAuthTaskMonitor$Session$trackUserWait$1 r102 = (AppletAuthTaskMonitor$Session$trackUserWait$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L15;
            if (r106 != 1) goto L14;
            ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
        L19:
            c();
            return r104;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
            b();
            r102.label = 1;     // Catch: Throwable -> L21
            r104 = r100.invoke(r102);     // Catch: Throwable -> L21
            if (r104 != r105) goto L19;
            return r105;
        L21:
            th = move-exception;
            c();
            throw th;
        L7:
            r102 = new AppletAuthTaskMonitor$Session$trackUserWait$1(this, r101);
            goto L8
        }

        public Session(b r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "meta");
            Intrinsics.checkNotNullParameter(r101, "traceId");
            this.f37157a = r100;
            this.f37158b = r101;
            this.f37159c = r102;
            this.f37160d = new AtomicBoolean(false);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ErrorCode f37167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f37168e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f37169f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f37170g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f37171h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f37172i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37164a, r101.f37164a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37165b, r101.f37165b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37166c, r101.f37166c) == true) goto L18;
            return false;
        L18:
            if (this.f37167d == r101.f37167d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37168e, r101.f37168e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f37169f, r101.f37169f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f37170g, r101.f37170g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f37171h, r101.f37171h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f37172i, r101.f37172i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f37164a.hashCode() * 31;
            String r101 = this.f37165b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f37166c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            ErrorCode r108 = this.f37167d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f37168e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f37169f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f37170g;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f37171h;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            String r123 = this.f37172i;
            if (r123 == null) goto L35;
            r102 = r123.hashCode();
        L35:
            return r122 + r102;
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "FinishInfo(result=" + this.f37164a + ", detail=" + this.f37165b + ", stopStage=" + this.f37166c + ", errorCode=" + this.f37167d + ", errorMsg=" + this.f37168e + ", bridgeTraceId=" + this.f37169f + ", appletPermissionStatus=" + this.f37170g + ", systemPermissionStatus=" + this.f37171h + ", finalPermissionStatus=" + this.f37172i + ')';
        }

        public static a a(a r110, String r111) {
            String r100 = r110.f37164a;
            String r101 = r110.f37166c;
            ErrorCode r102 = r110.f37167d;
            String r103 = r110.f37168e;
            String r104 = r110.f37169f;
            String r105 = r110.f37170g;
            String r106 = r110.f37171h;
            String r107 = r110.f37172i;
            Intrinsics.checkNotNullParameter(r100, "result");
            return new a(r100, r111, r101, r102, r103, r104, r105, r106, r107);
        }

        public /* synthetic */ a(String r110, String r111, String r112, ErrorCode r113, String r114, String r115, String r210, String r211, int r212) {
            if ((r212 & 2) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r212 & 4) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r212 & 8) == 0) goto L13;
            ErrorCode r102 = null;
        L15:
            if ((r212 & 16) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r212 & 64) == 0) goto L21;
            String r116 = null;
        L23:
            if ((r212 & 128) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r212 & 256) == 0) goto L29;
            String r118 = null;
        L30:
            this(r110, r100, r101, r102, r103, null, r116, r117, r118);
            return;
        L29:
            r118 = r211;
            goto L30
        L25:
            r117 = r210;
            goto L27
        L21:
            r116 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public a(String r100, String r101, String r102, ErrorCode r103, String r104, String r105, String r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f37164a = r100;
            this.f37165b = r101;
            this.f37166c = r102;
            this.f37167d = r103;
            this.f37168e = r104;
            this.f37169f = r105;
            this.f37170g = r106;
            this.f37171h = r107;
            this.f37172i = r110;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f37176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f37177e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f37178f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f37179g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f37180h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f37181i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f37182j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f37183k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f37184l;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f37173a, r101.f37173a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37174b, r101.f37174b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37175c, r101.f37175c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f37176d, r101.f37176d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37177e, r101.f37177e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f37178f, r101.f37178f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f37179g, r101.f37179g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f37180h, r101.f37180h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f37181i, r101.f37181i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f37182j, r101.f37182j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f37183k, r101.f37183k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f37184l, r101.f37184l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f37173a.hashCode() * 31) + this.f37174b.hashCode()) * 31) + this.f37175c.hashCode()) * 31) + this.f37176d.hashCode()) * 31) + this.f37177e.hashCode()) * 31) + this.f37178f.hashCode()) * 31;
            String r101 = this.f37179g;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f37180h;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f37181i;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f37182j;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f37183k;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f37184l;
            if (r117 == null) goto L27;
            r102 = r117.hashCode();
        L27:
            return r116 + r102;
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Meta(domain=" + this.f37173a + ", scene=" + this.f37174b + ", subType=" + this.f37175c + ", detail=" + this.f37176d + ", appletId=" + this.f37177e + ", containerType=" + this.f37178f + ", widgetId=" + this.f37179g + ", pageId=" + this.f37180h + ", msgId=" + this.f37181i + ", cardId=" + this.f37182j + ", grantingName=" + this.f37183k + ", permissionKey=" + this.f37184l + ')';
        }

        public b(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r100, "domain");
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r102, "subType");
            Intrinsics.checkNotNullParameter(r103, "detail");
            Intrinsics.checkNotNullParameter(r104, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r105, "containerType");
            this.f37173a = r100;
            this.f37174b = r101;
            this.f37175c = r102;
            this.f37176d = r103;
            this.f37177e = r104;
            this.f37178f = r105;
            this.f37179g = r106;
            this.f37180h = r107;
            this.f37181i = r110;
            this.f37182j = r111;
            this.f37183k = r112;
            this.f37184l = r113;
        }

        public /* synthetic */ b(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, int r219) {
            if ((r219 & 64) == 0) goto L5;
            String r113 = null;
        L7:
            if ((r219 & 128) == 0) goto L9;
            String r114 = null;
        L11:
            if ((r219 & 256) == 0) goto L13;
            String r115 = null;
        L15:
            if ((r219 & 512) == 0) goto L17;
            String r116 = null;
        L19:
            if ((r219 & 1024) == 0) goto L21;
            String r117 = null;
        L23:
            if ((r219 & 2048) == 0) goto L25;
            String r118 = null;
        L26:
            this(r110, r111, r112, r210, r211, r212, r113, r114, r115, r116, r117, r118);
            return;
        L25:
            r118 = r218;
            goto L26
        L21:
            r117 = r217;
            goto L23
        L17:
            r116 = r216;
            goto L19
        L13:
            r115 = r215;
            goto L15
        L9:
            r114 = r214;
            goto L11
        L5:
            r113 = r213;
            goto L7
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37185a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f37185a = r100;
        }
    }

    public static final class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Session f37186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f37187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f37188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f37189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f37190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f37191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f37192g;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            SecureRandom r101 = AppletAuthTaskMonitor.f37154a;
            AppletAuthTaskMonitor.d(r100, this.f37186a, this.f37187b.f37165b);
            r100.f("result", this.f37187b.f37164a);
            r100.e("start_ts", this.f37186a.f37159c);
            r100.e("result_ts", this.f37188c);
            AppletAuthTaskMonitor.e(r100, "stop_stage", this.f37187b.f37166c);
            a r102 = this.f37187b;
            ErrorCode r103 = r102.f37167d;
            if (r103 == null) goto L8;
            r100.d("error_code", r103.getCode());
            r100.f(DyVerifyEventConstants.EventParam.ERROR_NAME, r103.getErrorName());
            String r104 = r102.f37168e;
            if (r104 != null) goto L7;
            r104 = r103.getDefaultMsg();
        L7:
            r100.f("error_msg", r104);
        L8:
            a r105 = this.f37187b;
            if (r105.f37167d != null) goto L11;
            AppletAuthTaskMonitor.e(r100, "error_msg", r105.f37168e);
        L11:
            r100.e("total_duration", this.f37189d);
            r100.e("technical_duration", this.f37190e);
            r100.e("backend_duration", this.f37191f);
            r100.e("user_wait_duration", this.f37192g);
            AppletAuthTaskMonitor.e(r100, "bridge_trace_id", this.f37187b.f37169f);
            AppletAuthTaskMonitor.e(r100, "applet_permission_status", this.f37187b.f37170g);
            AppletAuthTaskMonitor.e(r100, "system_permission_status", this.f37187b.f37171h);
            AppletAuthTaskMonitor.e(r100, "final_permission_status", this.f37187b.f37172i);
        }

        public d(Session r100, a r101, long r102, long r103, long r104, long r105, long r110) {
            this.f37186a = r100;
            this.f37187b = r101;
            this.f37188c = r102;
            this.f37189d = r103;
            this.f37190e = r104;
            this.f37191f = r105;
            this.f37192g = r110;
        }
    }

    public AppletAuthTaskMonitor() {
    }

    static {
        f37154a = new SecureRandom();
    }

    public static String a(long r110) {
        byte[] r100 = new byte[16];
        f37154a.nextBytes(r100);
        return "applet_authv1_" + r110 + '_' + ArraysKt.joinToString$default(r100, "", null, null, 0, null, new com.bytedance.ai.monitor.auth.a(), 30, null);
    }

    public static Session g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        long r101 = System.currentTimeMillis();
        Session r102 = new Session(r100, a(r101), r101);
        com.bytedance.ai.monitor.b.b("flow_applet_auth_task_start", new com.bytedance.ai.monitor.auth.b(r102));
        return r102;
    }

    public static void d(AppletMonitorableEvent r100, Session r101, String r102) {
        b r103 = r101.f37157a;
        r100.f(BindCardPayConfirmConstants.Key.TRACE_ID, r101.f37158b);
        r100.f("domain", r103.f37173a);
        r100.f("scene", r103.f37174b);
        r100.f("sub_type", r103.f37175c);
        if (r102 != null) goto L5;
        r102 = r103.f37176d;
    L5:
        r100.f("detail", r102);
        r100.f("applet_id", r103.f37177e);
        r100.f(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r103.f37178f);
        e(r100, "widget_id", r103.f37179g);
        e(r100, com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r103.f37180h);
        e(r100, "msg_id", r103.f37181i);
        e(r100, "card_id", r103.f37182j);
        e(r100, "granting_name", r103.f37183k);
        e(r100, "permission_key", r103.f37184l);
    }

    public static void e(AppletMonitorableEvent r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100.f(r101, r102);
        return;
    L11:
        return;
    L4:
        if (StringsKt.isBlank(r102) == true) goto L7;
        r103 = false;
        goto L8
    }

    public static void f(Session r110, a r111, long r112, boolean r113) {
        if (r113 == false) goto L5;
        long r100 = 0;
    L6:
        if (r113 == false) goto L8;
        long r114 = 0;
    L16:
        if (r113 == false) goto L18;
        long r115 = 0;
    L19:
        com.bytedance.ai.monitor.b.b("flow_applet_auth_task_result", new d(r110, r111, r112, r100, RangesKt.coerceAtLeast(r100 - r114, 0), r115, r114));
        return;
    L18:
        r115 = r110.e();
        goto L19
    L8:
        monitor-enter(r110);
        Long r101 = r110.f37161e;     // Catch: Throwable -> L21
        if (r101 == null) goto L12;
        long r102 = System.currentTimeMillis() - r101.longValue();     // Catch: Throwable -> L21
    L13:
        long r103 = RangesKt.coerceAtLeast(r110.f37162f + r102, 0);     // Catch: Throwable -> L21
        monitor-exit(r110);
        r114 = r103;
        goto L16
    L12:
        r102 = 0;
    L21:
        th = move-exception;
        throw th;
    L5:
        r100 = RangesKt.coerceAtLeast(r112 - r110.f37159c, 0);
        goto L6
    }

    public static /* synthetic */ b c(e3.d r100, String r101, String r102, String r110, String r111) {
        return b(r100, "login", r101, r102, r110, r111, null);
    }

    public static b b(e3.d r110, String r111, String r112, String r210, String r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "domain");
        Intrinsics.checkNotNullParameter(r112, "defaultScene");
        Intrinsics.checkNotNullParameter(r210, "subType");
        Intrinsics.checkNotNullParameter(r211, "detail");
        Intrinsics.checkNotNullParameter(r212, IFlowAppIntentIDL.PARAM_APPLET_ID);
        a0 r100 = r110.getContainerContext();
        if (r100 == null) goto L5;
        ContainerType r101 = r100.getContainerType();
    L6:
        if (r101 != null) goto L8;
        int r102 = -1;
    L10:
        if (r102 != 1) goto L12;
        String r103 = "widget_container";
    L16:
        String r113 = r103;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        a0 r104 = r110.getContainerContext();
        if (r104 == null) goto L19;
        ContainerType r114 = r104.getContainerType();
    L21:
        if (r114 != ContainerType.WIDGET) goto L25;
        String r105 = r104.getContainerId();
        if ((!StringsKt.isBlank(r105)) == false) goto L25;
        String r115 = r105;
    L26:
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        a0 r106 = r110.getContainerContext();
        if (r106 == null) goto L29;
        ContainerType r107 = r106.getContainerType();
    L31:
        if (r107 != ContainerType.PAGE) goto L35;
        String r108 = r106.getContainerId();
        if ((!StringsKt.isBlank(r108)) == false) goto L35;
    L37:
        return new b(r111, r112, r210, r211, r212, r113, r115, r108, null, null, null, r213, ISmModel.VERSION_0700);
    L35:
        r108 = null;
        goto L37
    L29:
        r107 = null;
    L25:
        r115 = null;
        goto L26
    L19:
        r114 = null;
        goto L21
    L12:
        if (r102 == 2) goto L14;
        r103 = "unknown";
        goto L16
    L14:
        r103 = "page_container";
        goto L16
    L8:
        r102 = c.f37185a[r101.ordinal()];
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
