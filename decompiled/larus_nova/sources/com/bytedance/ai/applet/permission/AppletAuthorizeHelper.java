package com.bytedance.ai.applet.permission;

import android.content.Context;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletAuthorizeHelper implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Keva> f34919d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Applet f34922c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/permission/AppletAuthorizeHelper$AuthorizeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "extras", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthorizeException extends Exception {
        private final Map<String, Object> extras;

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public AuthorizeException(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "extras");
            super(r100);
            this.extras = r101;
        }

        public /* synthetic */ AuthorizeException(String r100, Map r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = MapsKt.emptyMap();
        L5:
            this(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34924a = null;

        static {
            int[] r100 = new int[GrantingAction.values().length];
            r100[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f34924a = r100;
        }
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    static {
        f34919d = LazyKt.lazy(new com.bytedance.ai.applet.permission.a());
    }

    public static String i(String r100) {
        switch(r100.hashCode()) {
            case -1750762604: goto L32;
            case -653473286: goto L28;
            case -21617665: goto L24;
            case 411225387: goto L20;
            case 421939912: goto L17;
            case 934308869: goto L13;
            case 1403059833: goto L9;
            case 2106603706: goto L6;
            default: goto L35;
        };
    L35:
        return "";
    L6:
        if (r100.equals("scope.userFuzzyLocation") == false) goto L35;
    L30:
        return "location";
    L9:
        if (r100.equals("scope.addPhoneContact") == false) goto L35;
        return "addPhoneContact";
    L13:
        if (r100.equals("scope.addPhoneCalendar") == false) goto L35;
        return "addPhoneCalendar";
    L17:
        if (r100.equals("scope.userLocationBackground") == false) goto L35;
    L20:
        if (r100.equals("scope.record") == false) goto L35;
        return "microphone";
    L24:
        if (r100.equals("scope.camera") == false) goto L35;
        return "camera";
    L28:
        if (r100.equals("scope.userLocation") == true) goto L30;
    L32:
        if (r100.equals("scope.bluetooth") == false) goto L35;
        return "bluetooth";
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public AppletAuthorizeHelper(String r100, int r101, Applet r102) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r102, ErrorType.MANIFEST);
        this.f34920a = r100;
        this.f34921b = r101;
        this.f34922c = r102;
    }

    public static final Object b(AppletAuthorizeHelper r100, String r101, GrantingAction r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof AppletAuthorizeHelper$postUserAction$1) == false) goto L7;
        AppletAuthorizeHelper$postUserAction$1 r102 = (AppletAuthorizeHelper$postUserAction$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        r110 = (GrantingAction) r102.L$1;
        r101 = (String) r102.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L14
        Object r106 = ((Result) r112).m9458unboximpl();     // Catch: Exception -> L14
    L32:
        boolean r107 = Result.m9456isSuccessimpl(r106);     // Catch: Exception -> L14
        if (r107 == true) goto L38;
        com.bytedance.ai.utils.g.f37637a.e("AppletAuthorizeHelper", "Failed to post user action '" + r110 + "' for scope '" + r101 + '\'');     // Catch: Exception -> L14
    L38:
        return Boxing.boxBoolean(r107);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        int r113 = b.f34924a[r110.ordinal()];
        if (r113 != 1) goto L21;
        GrantStatus r114 = GrantStatus.GRANTED;
    L29:
        UserAuthService r108 = UserAuthService.f36075a;     // Catch: Exception -> L14
        String r109 = r100.f34920a;     // Catch: Exception -> L14
        Integer r115 = Boxing.boxInt(u2.g.a(r114));     // Catch: Exception -> L14
        r102.L$0 = r101;     // Catch: Exception -> L14
        r102.L$1 = r110;     // Catch: Exception -> L14
        r102.label = 1;     // Catch: Exception -> L14
        r106 = UserAuthService.r(r109, r101, r115, r102);     // Catch: Exception -> L14
        if (r106 != r104) goto L32;
        return r104;
    L21:
        if (r113 != 2) goto L23;
    L27:
        r114 = GrantStatus.DENIED;
        goto L29
    L23:
        if (r113 == 3) goto L27;
        throw new NoWhenBranchMatchedException();
    L14:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AppletAuthorizeHelper", "Failed to post user action '" + r110 + "' for scope '" + r101 + '\'', e);
        r107 = false;
    L7:
        r102 = new AppletAuthorizeHelper$postUserAction$1(r100, r111);
        goto L8
    }

    public final <T> Object j(AppletAuthTaskMonitor.Session r100, AppletAuthTaskMonitor.Session r101, Function1<? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r110) {
        if ((r110 instanceof AppletAuthorizeHelper$trackPermissionStatusBackend$1) == false) goto L7;
        AppletAuthorizeHelper$trackPermissionStatusBackend$1 r103 = (AppletAuthorizeHelper$trackPermissionStatusBackend$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        long r107 = r103.J$0;
        AppletAuthTaskMonitor.Session r108 = (AppletAuthTaskMonitor.Session) r103.L$1;
        AppletAuthTaskMonitor.Session r109 = (AppletAuthTaskMonitor.Session) r103.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L23:
        long r112 = System.currentTimeMillis() - r107;
        r109.a(r112);
        if (r108 == null) goto L26;
        r108.a(r112);
    L26:
        return r111;
    L14:
        Throwable th10 = th;
    L29:
        long r113 = System.currentTimeMillis() - r107;
        r109.a(r113);
        if (r108 == null) goto L32;
        r108.a(r113);
    L32:
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        long r114 = System.currentTimeMillis();
        r103.L$0 = r100;     // Catch: Throwable -> L27
        r103.L$1 = r101;     // Catch: Throwable -> L27
        r103.J$0 = r114;     // Catch: Throwable -> L27
        r103.label = 1;     // Catch: Throwable -> L27
        r111 = r102.invoke(r103);     // Catch: Throwable -> L27
        if (r111 != r105) goto L22;
        return r105;
    L22:
        r109 = r100;
        r108 = r101;
        r107 = r114;
    L27:
        th = move-exception;
        th10 = th;
        r109 = r100;
        r108 = r101;
        r107 = r114;
    L7:
        r103 = new AppletAuthorizeHelper$trackPermissionStatusBackend$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r310, boolean r410, String r411, AppletAuthTaskMonitor.Session r412, AppletAuthTaskMonitor.Session r413, Continuation<? super f> r414) {
        if ((r414 instanceof AppletAuthorizeHelper$authorize$1) == false) goto L7;
        AppletAuthorizeHelper$authorize$1 r100 = (AppletAuthorizeHelper$authorize$1) r414;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AppletAuthorizeHelper$authorize$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r210 = "granted";
        String r110 = "AppletAuthorizeHelper";
        if (r105 == 0) goto L20;
        if (r105 != 1) goto L19;
        AppletAuthTaskMonitor.Session r106 = (AppletAuthTaskMonitor.Session) r102.L$3;
        AppletAuthTaskMonitor.Session r107 = (AppletAuthTaskMonitor.Session) r102.L$2;
        String r108 = (String) r102.L$1;
        String r109 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14 AuthorizeException -> L16
        AppletAuthTaskMonitor.Session r111 = r107;
        String r112 = r108;
        r110 = "AppletAuthorizeHelper";
        String r113 = ", scopeName=";
        int r114 = 2;
        boolean r115 = false;
    L141:
        Pair r116 = (Pair) r103;     // Catch: AuthorizeException -> L59 Exception -> L61
        boolean r117 = ((Boolean) r116.component1()).booleanValue();     // Catch: AuthorizeException -> L59 Exception -> L61
        boolean r118 = ((Boolean) r116.component2()).booleanValue();     // Catch: AuthorizeException -> L59 Exception -> L61
        if (this.f34921b != CastIntegerProtector.parseInt("2")) goto L41;
        String r311 = null;
    L42:
        r106.d(new AppletAuthTaskMonitor.a("success", r112, null, null, null, "granted", r311, "granted", 60));     // Catch: AuthorizeException -> L59 Exception -> L61
        Pair[] r119 = new Pair[r114];     // Catch: AuthorizeException -> L59 Exception -> L61
        String r120 = "already_granted";
        if (r117 == false) goto L46;
        Object r121 = "already_granted";
    L47:
        r119[r115 ? 1 : 0] = TuplesKt.to("applet_auth_status", r121);     // Catch: AuthorizeException -> L59 Exception -> L61
        if (r118 == true) goto L51;
        r120 = "approved";
    L51:
        r119[1] = TuplesKt.to("system_auth_status", r120);     // Catch: AuthorizeException -> L59 Exception -> L61
        Map r122 = MapsKt.mapOf(r119);     // Catch: AuthorizeException -> L59 Exception -> L61
        Map r123 = null;
    L148:
        return new f(true, null, r122, r114);
    L57:
        e = e;
    L64:
        String r211 = r112;
        r110 = r110;
    L88:
        com.bytedance.ai.utils.g.f37637a.w(r110, "Authorization failed: appletId=" + this.f34920a + r113 + r109 + ", reason=" + e.getMessage());
        String r124 = e.getMessage();
        int r125 = this.f34921b;
        if (r124 != null) goto L92;
        r124 = "";
    L92:
        if (StringsKt.startsWith$default(r124, "invalid_scope", r115, r114, r123) == false) goto L95;
        AppletAuthTaskMonitor.a r126 = new AppletAuthTaskMonitor.a("failed", r211, "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, r124, null, null, "refused", 224);
    L115:
        r106.d(r126);
        String r127 = e.getMessage();
        if (r127 != null) goto L119;
        r127 = "";
    L119:
        if (StringsKt.startsWith$default(r127, "invalid_scope", r115, r114, r123) == false) goto L122;
        AppletAuthTaskMonitor.a r128 = new AppletAuthTaskMonitor.a("failed", null, "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, r127, null, null, null, 482);
    L129:
        if (r111 == null) goto L132;
        r111.d(r128);
    L132:
        return new f(r115, e.getMessage(), e.getExtras());
    L122:
        if (StringsKt.startsWith$default(r127, "network_failure", r115, r114, r123) == false) goto L124;
        r128 = new AppletAuthTaskMonitor.a("failed", null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r127, null, null, null, 482);
        goto L129
    L124:
        AppletAuthTaskMonitor.ErrorCode r312 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        if (StringsKt.isBlank(r127) == false) goto L127;
        String r313 = r123;
    L128:
        r128 = new AppletAuthTaskMonitor.a("failed", null, "permission_context_check", r312, r313, null, null, null, 482);
        goto L129
    L127:
        r313 = r127;
        goto L128
    L95:
        if (StringsKt.startsWith$default(r124, "applet_permission_denied", r115, r114, r123) == false) goto L98;
        r126 = new AppletAuthTaskMonitor.a("user_refused", r211, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, r124, "refused", null, "refused", 160);
        goto L115
    L98:
        if (StringsKt.startsWith$default(r124, "applet_permission_cancelled", r115, r114, r123) == false) goto L101;
        r126 = new AppletAuthTaskMonitor.a("user_cancelled", r211, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, r124, "cancelled", null, "refused", 160);
        goto L115
    L101:
        if (StringsKt.startsWith$default(r124, "system_permission_denied", r115, r114, r123) == false) goto L108;
        AppletAuthTaskMonitor.ErrorCode r212 = AppletAuthTaskMonitor.ErrorCode.SYSTEM_PERMISSION_DENIED;
        if (r125 == CastIntegerProtector.parseInt("2")) goto L106;
        r210 = "refused";
    L106:
        r126 = new AppletAuthTaskMonitor.a("user_refused", r211, "system_permission", r212, r124, "granted", "refused", r210, 32);
        goto L115
    L108:
        if (StringsKt.startsWith$default(r124, "network_failure", r115, r114, r123) == false) goto L110;
        r126 = new AppletAuthTaskMonitor.a("failed", r211, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r124, null, null, "refused", 224);
        goto L115
    L110:
        AppletAuthTaskMonitor.ErrorCode r213 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        if (StringsKt.isBlank(r124) == false) goto L113;
        String r314 = r123;
    L114:
        r126 = new AppletAuthTaskMonitor.a("failed", r211, "permission_context_check", r213, r314, null, null, "refused", 224);
        goto L115
    L113:
        r314 = r124;
    L55:
        e = e;
    L63:
        String r129 = r112;
    L81:
        com.bytedance.ai.utils.g.f37637a.e(r110, "An unexpected error occurred during authorization: appletId=" + this.f34920a + r113 + r109, e);
        AppletAuthTaskMonitor.ErrorCode r130 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
        r106.d(new AppletAuthTaskMonitor.a("failed", r129, "permission_context_check", r130, e.getMessage(), null, null, null, 480));
        if (r111 == null) goto L147;
        r111.d(new AppletAuthTaskMonitor.a("failed", null, "permission_context_check", r130, e.getMessage(), null, null, null, 482));
    L147:
        return new f(r115, "Error: " + e.getMessage(), r123, 4);
    L46:
        r121 = "approved";
        goto L47
    L41:
        r311 = "granted";
    L59:
        e = e;
        r123 = null;
    L61:
        e = e;
        r123 = null;
        goto L63
    L16:
        e = e;
        r111 = r107;
        r211 = r108;
        r110 = "AppletAuthorizeHelper";
        r113 = ", scopeName=";
        r123 = null;
        r114 = 2;
        r115 = false;
    L14:
        e = e;
        r111 = r107;
        r129 = r108;
        r110 = "AppletAuthorizeHelper";
        r113 = ", scopeName=";
        r123 = null;
        r115 = false;
        goto L81
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r103);
        com.bytedance.ai.utils.g r131 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r132 = new StringBuilder("authorize enter: appletId=");
        r132.append(this.f34920a);
        r132.append(", appletType=");
        r132.append(this.f34921b);
        r132.append(", scopeName=");
        r132.append(r310);
        r132.append(", manifestAppletId=");
        r132.append(this.f34922c.K);
        r132.append(", manifestPermKeys=");
        Map<String, PermissionDetail> r133 = this.f34922c.W;
        if (r133 == null) goto L23;
        Set<String> r134 = r133.keySet();
    L24:
        r132.append(r134);
        r131.i("AppletAuthorizeHelper", r132.toString());
        if (r412 != null) goto L27;
        SecureRandom r135 = AppletAuthTaskMonitor.f37154a;
        AppletAuthTaskMonitor.Session r136 = AppletAuthTaskMonitor.g(new AppletAuthTaskMonitor.b("authorize", "native_api", "applet_scope", "AppletAuthorizeManager.authorize.call", this.f34920a, "native_container", null, null, null, null, null, r310, 1984));
    L145:
        r102.L$0 = r310;     // Catch: Exception -> L78 AuthorizeException -> L85
        r112 = r411;
        r102.L$1 = r112;     // Catch: Exception -> L74 AuthorizeException -> L76
        r111 = r413;
        r102.L$2 = r111;     // Catch: Exception -> L70 AuthorizeException -> L72
        r102.L$3 = r136;     // Catch: Exception -> L70 AuthorizeException -> L72
        r102.label = 1;     // Catch: Exception -> L70 AuthorizeException -> L72
        r113 = ", scopeName=";
        r114 = 2;
        r115 = false;
        r115 = false;
        r115 = false;
        r103 = f(r310, r410, r136, r411, r413, r102);     // Catch: Exception -> L65 AuthorizeException -> L67
        if (r103 != r104) goto L37;
        return r104;
    L37:
        r106 = r136;
        r109 = r310;
        goto L141
    L67:
        e = e;
        r123 = null;
    L87:
        r106 = r136;
        r211 = r112;
        r109 = r310;
    L65:
        e = e;
        r123 = null;
    L80:
        r106 = r136;
        r129 = r112;
        r109 = r310;
        goto L81
    L72:
        e = e;
    L73:
        r113 = r14;
        r123 = null;
        r114 = 2;
        r115 = false;
    L70:
        e = e;
    L71:
        r113 = r14;
        r123 = null;
        r115 = false;
        goto L80
    L76:
        e = e;
        r111 = r413;
    L74:
        e = e;
    L75:
        r111 = r413;
        goto L71
    L85:
        e = e;
        r112 = r411;
        r111 = r413;
        r113 = r14;
        r123 = null;
        r114 = 2;
        r115 = false;
    L78:
        e = e;
        r112 = r411;
        goto L75
    L27:
        r136 = r412;
        goto L145
    L23:
        r134 = null;
    L7:
        r100 = new AppletAuthorizeHelper$authorize$1(this, r414);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(String r310, boolean r311, AppletAuthTaskMonitor.Session r312, String r313, AppletAuthTaskMonitor.Session r314, Continuation<? super Pair<Boolean, Boolean>> r315) {
        String r100 = r310;
        if ((r315 instanceof AppletAuthorizeHelper$authorizeOrThrow$1) == false) goto L7;
        AppletAuthorizeHelper$authorizeOrThrow$1 r101 = (AppletAuthorizeHelper$authorizeOrThrow$1) r315;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AppletAuthorizeHelper$authorizeOrThrow$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        String r105 = null;
        Object[] r106 = 0;
        Object[] r107 = 0;
        Object[] r108 = 0;
        Object[] r109 = 0;
        Object[] r112 = 0;
        Object[] r113 = 0;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r114 = r110.I$0;
        String r115 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);
    L72:
        boolean r116 = ((Boolean) r103).booleanValue();
        com.bytedance.ai.utils.g.f37637a.d("AppletAuthorizeHelper", "Authorization flow completed successfully for scope '" + r115 + "'.");
        if (r114 == 0) goto L75;
        boolean r117 = true;
    L77:
        return TuplesKt.to(Boxing.boxBoolean(r117), Boxing.boxBoolean(r116));
    L75:
        r117 = false;
        goto L77
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r118 = r110.Z$0;
        AppletAuthTaskMonitor.Session r119 = (AppletAuthTaskMonitor.Session) r110.L$3;
        String r120 = (String) r110.L$2;
        AppletAuthTaskMonitor.Session r121 = (AppletAuthTaskMonitor.Session) r110.L$1;
        String r122 = (String) r110.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L78
        String r123 = r120;
        AppletAuthTaskMonitor.Session r124 = r121;
        boolean r125 = r118;
        r100 = r122;
    L41:
        AppletPermissionDetail r126 = (AppletPermissionDetail) r103;     // Catch: Exception -> L78
        Map<String, ScopePermissionInfo> r127 = r126.getScopesStatus();
        if (r127 == null) goto L45;
        ScopePermissionInfo r128 = r127.get(r100);
    L46:
        if (r128 == null) goto L53;
        Integer r129 = r128.getGrantStatus();
        int r130 = GrantStatus.GRANTED.getValue();
        if (r129 == null) goto L53;
        if (r129.intValue() != r130) goto L53;
        boolean r131 = true;
    L54:
        if (r131 == false) goto L56;
        String r132 = "granted";
    L57:
        String r210 = r132;
        if (r119 == null) goto L60;
        r119.d(new AppletAuthTaskMonitor.a("success", null, null, null, null, r210, null, r210, 190));
    L60:
        if (r128 == null) goto L67;
        Integer r133 = r128.getGrantStatus();
        int r134 = GrantStatus.GRANTED.getValue();
        if (r133 == null) goto L67;
        if (r133.intValue() != r134) goto L67;
        boolean r135 = true;
    L68:
        boolean r136 = r135;
        AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1 r137 = new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1(r135, r100, r125, this, r128, r124, r123, r126, null);
        r110.L$0 = r100;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.L$3 = null;
        r110.I$0 = r136 ? 1 : 0;
        r110.label = 2;
        r103 = CoroutineScopeKt.coroutineScope(r137, r110);
        if (r103 != r111) goto L71;
        return r111;
    L71:
        r115 = r100;
        r114 = r136 ? 1 : 0;
    L67:
        r135 = false;
        goto L68
    L56:
        r132 = "refused";
    L53:
        r131 = false;
        goto L54
    L45:
        r128 = null;
    L78:
        e = e;
    L82:
        if (r119 == null) goto L84;
        r119.d(new AppletAuthTaskMonitor.a("failed", null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, e.getMessage(), null, null, null, 482));
    L84:
        String r138 = e.getMessage();
        if (r138 != null) goto L87;
    L94:
        String r139 = "network_failure";
    L96:
        throw new AuthorizeException(r139, r105, 2, r105);
    L87:
        if ((!StringsKt.isBlank(r138)) == true) goto L90;
        r138 = r105;
    L90:
        if (r138 == null) goto L94;
        r139 = "network_failure:".concat(r138);
        if (r139 == null) goto L94;
    L18:
        ResultKt.throwOnFailure(r103);
        if (this.f34920a.length() != 0) goto L21;
        boolean r140 = true;
    L22:
        if (r140 == true) goto L102;
        Scope.Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Scope.access$getVALUES$cp().contains(r100) == false) goto L100;
        Map<String, PermissionDetail> r141 = this.f34922c.W;
        if (r141 != null) goto L28;
    L30:
        boolean r142 = false;
    L31:
        com.bytedance.ai.utils.g r143 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r144 = new StringBuilder("authorizeOrThrow check declaration: appletId=");
        r144.append(this.f34920a);
        r144.append(", scopeName=");
        r144.append(r100);
        r144.append(", hasDeclaredScope=");
        r144.append(r142);
        r144.append(", declaredKeys=");
        if (r141 == null) goto L34;
        Set<String> r145 = r141.keySet();
    L35:
        r144.append(r145);
        r144.append(", manifestAppletId=");
        r144.append(this.f34922c.K);
        r143.i("AppletAuthorizeHelper", r144.toString());
        if (r142 == false) goto L98;
        AppletAuthorizeHelper$authorizeOrThrow$targetAppletDetail$1 r146 = new AppletAuthorizeHelper$authorizeOrThrow$targetAppletDetail$1(this, r100, null);     // Catch: Exception -> L80
        r110.L$0 = r100;     // Catch: Exception -> L80
        r110.L$1 = r312;     // Catch: Exception -> L80
        r110.L$2 = r313;     // Catch: Exception -> L80
        r110.L$3 = r314;     // Catch: Exception -> L80
        r110.Z$0 = r311;     // Catch: Exception -> L80
        r110.label = 1;     // Catch: Exception -> L80
        r103 = j(r312, r314, r146, r110);     // Catch: Exception -> L80
        if (r103 != r111) goto L40;
        return r111;
    L40:
        r124 = r312;
        r119 = r314;
        r123 = r313;
        r125 = r311;
    L80:
        e = e;
        r119 = r314;
        goto L82
    L98:
        throw new AuthorizeException("invalid_scope:" + r100, r113 == true ? 1 : 0, 2, r112 == true ? 1 : 0);
    L34:
        r145 = null;
        goto L35
    L28:
        if (r141.containsKey(r100) != true) goto L30;
        r142 = true;
        goto L31
    L100:
        throw new AuthorizeException("invalid_scope:" + r100, r109 == true ? 1 : 0, 2, r108 == true ? 1 : 0);
    L102:
        throw new AuthorizeException("Error: appletId is null or empty", r107 == true ? 1 : 0, 2, r106 == true ? 1 : 0);
    L21:
        r140 = false;
    L7:
        r101 = new AppletAuthorizeHelper$authorizeOrThrow$1(this, r315);
        goto L8
    }

    public static /* synthetic */ Object e(AppletAuthorizeHelper r100, String r101, boolean r102, String r110, AppletAuthTaskMonitor.Session r111, AppletAuthTaskMonitor.Session r112, Continuation r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r114 & 4) == 0) goto L9;
        r110 = "AppletAuthorizeManager.authorize.callback";
    L9:
        String r104 = r110;
        if ((r114 & 8) == 0) goto L12;
        AppletAuthTaskMonitor.Session r105 = null;
    L14:
        if ((r114 & 16) == 0) goto L16;
        AppletAuthTaskMonitor.Session r106 = null;
    L18:
        return r100.c(r101, r103, r104, r105, r106, r113);
    L16:
        r106 = r112;
        goto L18
    L12:
        r105 = r111;
        goto L14
    L5:
        r103 = r102;
        goto L7
    }
}
