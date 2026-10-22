package com.bytedance.ai.applet.login;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class LoginProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoginProcessor f34725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<f> f34726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, j> f34727c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f34728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CoroutineScope f34729e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/applet/login/LoginProcessor$RouteType;", "", "anniexHost", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAnniexHost", "()Ljava/lang/String;", "WEB", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RouteType extends Enum<RouteType> {
        public static final RouteType WEB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RouteType[] f34730a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34731b = null;
        private final String anniexHost;

        public static EnumEntries<RouteType> getEntries() {
            return f34731b;
        }

        static {
            RouteType r100 = new RouteType();
            WEB = r100;
            RouteType[] r101 = {r100};
            f34730a = r101;
            f34731b = EnumEntriesKt.enumEntries(r101);
        }

        public RouteType() {
            super("WEB", 0);
            this.anniexHost = "sslocal://webview";
        }

        public static RouteType[] values() {
            return (RouteType[]) f34730a.clone();
        }

        public final String getAnniexHost() {
            return this.anniexHost;
        }

        public static RouteType valueOf(String r100) {
            return (RouteType) r27.a.a(RouteType.class, r100);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34732a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f34733b = null;

        static {
            int[] r100 = new int[GrantingAction.values().length];
            r100[GrantingAction.DISMISSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r100[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r100[GrantingAction.AGREED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            f34732a = r100;
            int[] r101 = new int[LocalFinishReason.values().length];
            r101[LocalFinishReason.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r101[LocalFinishReason.USER_DISMISS_DIALOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r101[LocalFinishReason.USER_REJECTED_PRIVACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r101[LocalFinishReason.USER_REJECTED_LOGIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r101[LocalFinishReason.USER_REJECTED_COMBINED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r101[LocalFinishReason.BIZ_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r101[LocalFinishReason.TIMEOUT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            f34733b = r101;
        }
    }

    public LoginProcessor() {
    }

    static {
        f34725a = new LoginProcessor();
        f34726b = new WeakReference(null);
        f34727c = new LinkedHashMap();
        f34729e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static String c(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return "";
    L12:
        RouteType r103 = RouteType.WEB;
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r100, "url");
        String r104 = r103.getAnniexHost();
        if (r104.length() == 0) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L18;
        String r105 = null;
    L19:
        if (r105 == null) goto L22;
        r100 = r105;
    L22:
        com.bytedance.ai.utils.g.f37637a.i("LoginProcessor", "buildAnniexUrl: " + r100);
        return r100;
    L18:
        Uri.Builder r106 = UriProtector.parse(r104).buildUpon();
        r106.appendQueryParameter("url", r100);
        r105 = r106.build().toString();
        goto L19
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static j h(String r100) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        j r101 = (j) ((LinkedHashMap) f34727c).get(r100);
        if (r101 != null) goto L5;
        com.bytedance.ai.utils.g.f37637a.w("LoginProcessor", "getLoginContext failed for applet: " + r100);
    L5:
        return r101;
    }

    public static String k(AppletAuthTaskMonitor.Session r100) {
        if (r100 == null) goto L6;
        AppletAuthTaskMonitor.b r101 = r100.f37157a;
        if (r101 == null) goto L6;
        String r102 = r101.f37174b;
    L8:
        if (Intrinsics.areEqual(r102, "mcp") == false) goto L10;
        return "AIMcpGrantingManager.reportAuthTraceResultIfNeeded";
    L10:
        return "AppletPageLoginManager.finishLoginTask";
    L6:
        r102 = null;
        goto L8
    }

    public static void l(String r310, h r311) {
        Map<String, j> r100 = f34727c;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        j r102 = (j) r101.get(r310);
        if (r102 != null) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "transitionTo: Can not find loginContext: " + r310);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r311, "<set-?>");
        r102.f34766e = r311;
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        r103.i("LoginProcessor", "Applet [" + r310 + "] transitioned to " + r311);
        if ((r311 instanceof h.d) == false) goto L10;
        g(r310, "mcp-agree-card", r102);
        return;
    L10:
        if ((r311 instanceof h.b) == false) goto L13;
        g(r310, "mcp-login-card", r102);
        return;
    L13:
        if ((r311 instanceof h.e) == false) goto L18;
        AppletAuthTaskMonitor.Session r104 = r102.f34769h;
        if (r104 == null) goto L99;
        r104.b();
        return;
    L99:
        return;
    L18:
        if ((r311 instanceof h.a) == false) goto L101;
        LocalFinishReason r105 = ((h.a) r311).f34753a;
        r103.i("LoginProcessor", "finishLoginProcessing reason: " + r105.getDescription());
        j r106 = (j) r101.get(r310);
        if (r106 != null) goto L22;
        r103.e("LoginProcessor", "finishLoginProcessing: LoginContext not found for " + r310);
        return;
    L22:
        u2.c r107 = r106.f34762a;
        int[] r108 = a.f34733b;
        if (r108[r105.ordinal()] != 1) goto L25;
        String r109 = "1";
    L27:
        if (r106.f34768g == null) goto L29;
        String r110 = "doubao_apps_detail";
    L31:
        if (r106.f34765d == false) goto L33;
        String r111 = "phone";
    L34:
        com.bytedance.ai.monitor.b.b("doubao_apps_login_result", new n(r110, r111, r109, r107));
        String r112 = k(r106.f34769h);
        AppletAuthTaskMonitor.a r113 = r106.f34770i;
        if (r113 == null) goto L37;
    L46:
        AppletAuthTaskMonitor.Session r114 = r106.f34769h;
        if (r114 != null) goto L49;
    L52:
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r115 = r106.f34768g;
        if (r115 == null) goto L58;
        r103.d("LoginProcessor", "Invoking JSB callback for " + r310);
        if (r105 != LocalFinishReason.SUCCESS) goto L57;
        Intrinsics.checkNotNullParameter(AbsLoginWithDoubaoWidgetMethodIDL.b.class, "<this>");
        BaseModel r116 = k3.c.a(AbsLoginWithDoubaoWidgetMethodIDL.b.class);
        ((AbsLoginWithDoubaoWidgetMethodIDL.b) r116).setResult(true);
        r115.b((ResultModel) r116, "");
        goto L58
    L57:
        f3.h.a.a(r115, "Login failed or was cancelled. Reason: " + r105.getDescription(), null, null, 14);
    L58:
        u2.c r117 = r106.f34762a;
        r117.f548391f.getClass();
        f r118 = f34726b.get();
        if (r118 == null) goto L61;
        ComponentCallbacks2 r119 = r118.f34750f;
    L63:
        if ((r119 instanceof LifecycleOwner) == false) goto L65;
        LifecycleOwner r120 = (LifecycleOwner) r119;
    L66:
        if (r120 == null) goto L71;
        LifecycleCoroutineScope r121 = LifecycleOwnerKt.getLifecycleScope(r120);
        if (r121 == null) goto L71;
        BuildersKt.launch$default(r121, Dispatchers.getMain(), null, new LoginProcessor$finishLoginProcessing$2(null), 2, null);
    L71:
        switch(r108[r105.ordinal()]) {
            case 1: goto L88;
            case 2: goto L87;
            case 3: goto L90;
            case 4: goto L90;
            case 5: goto L90;
            case 6: goto L75;
            case 7: goto L74;
            default: goto L73;
        };
    L74:
        r103.d("LoginProcessor", "finishLoginProcessing: timeout");
        goto L90
    L75:
        if (r118 == null) goto L77;
        ComponentCallbacks2 r122 = r118.f34750f;
    L79:
        if ((r122 instanceof LifecycleOwner) == false) goto L81;
        LifecycleOwner r123 = (LifecycleOwner) r122;
    L82:
        if (r123 == null) goto L86;
        LifecycleCoroutineScope r124 = LifecycleOwnerKt.getLifecycleScope(r123);
        if (r124 == null) goto L86;
        BuildersKt.launch$default(r124, Dispatchers.getMain(), null, new LoginProcessor$finishLoginProcessing$3(null), 2, null);
    L86:
        McpGrantingManager r125 = McpGrantingManager.f34644a;
        GrantingAction r126 = GrantingAction.DISMISSED;
        r125.getClass();
        McpGrantingManager.i(r117, r126);
        goto L90
    L81:
        r123 = null;
        goto L82
    L77:
        r122 = null;
        goto L79
    L87:
        McpGrantingManager r127 = McpGrantingManager.f34644a;
        GrantingAction r128 = GrantingAction.DISMISSED;
        r127.getClass();
        McpGrantingManager.i(r117, r128);
        goto L90
    L88:
        McpGrantingManager r129 = McpGrantingManager.f34644a;
        GrantingAction r130 = GrantingAction.AGREED;
        r129.getClass();
        McpGrantingManager.i(r117, r130);
        goto L90
    L73:
        throw new NoWhenBranchMatchedException();
    L90:
        if (Intrinsics.areEqual(f34728d, r310) == false) goto L92;
        f34728d = null;
    L92:
        r100.remove(r310);
        CustomLoginNavigator r131 = CustomLoginNavigator.f34707a;
        Intrinsics.checkNotNullParameter(r310, IFlowAppIntentIDL.PARAM_APPLET_ID);
        if (CustomLoginNavigator.f34708b.remove(r310) != null) goto L95;
        r103.w("CustomLoginNavigator", "clearLaunchContext: launch context not found for appletId=" + r310);
    L95:
        CustomLoginNavigator.c(r310);
        return;
    L65:
        r120 = null;
        goto L66
    L61:
        r119 = null;
        goto L63
    L49:
        if (r113.f37165b != null) goto L51;
        r113 = AppletAuthTaskMonitor.a.a(r113, r112);
    L51:
        r114.d(r113);
        goto L52
    L37:
        switch(r108[r105.ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            default: goto L39;
        };
    L40:
        r113 = new AppletAuthTaskMonitor.a("timeout", null, "applet_auth_timeout", AppletAuthTaskMonitor.ErrorCode.TIMEOUT, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        goto L46
    L41:
        r113 = new AppletAuthTaskMonitor.a("failed", null, "exchange_code", AppletAuthTaskMonitor.ErrorCode.API_FAILED, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        goto L46
    L42:
        r113 = new AppletAuthTaskMonitor.a("user_refused", null, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        goto L46
    L43:
        r113 = new AppletAuthTaskMonitor.a("user_refused", null, "privacy_commit", AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        goto L46
    L44:
        r113 = new AppletAuthTaskMonitor.a("user_cancelled", null, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK);
        goto L46
    L45:
        r113 = new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510);
        goto L46
    L39:
        throw new NoWhenBranchMatchedException();
    L33:
        r111 = "other";
        goto L34
    L29:
        r110 = "chat";
        goto L31
    L25:
        r109 = "0";
        goto L27
    }

    public static final Object a(LoginProcessor r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof LoginProcessor$checkPrivacy$1) == false) goto L7;
        LoginProcessor$checkPrivacy$1 r103 = (LoginProcessor$checkPrivacy$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L22;
        if (r107 == 1) goto L17;
        if (r107 != 2) goto L16;
        String r108 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L20
    L41:
        boolean r109 = ((Boolean) r105).booleanValue();     // Catch: Exception -> L20
    L45:
        return Boxing.boxBoolean(r109);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r110 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L20
    L37:
        r109 = ((Boolean) r105).booleanValue();     // Catch: Exception -> L20
        goto L45
    L22:
        ResultKt.throwOnFailure(r105);
        Map<String, j> r111 = f34727c;
        j r112 = (j) ((LinkedHashMap) r111).get(r101);
        if (r112 == null) goto L28;
        u2.c r113 = r112.f34762a;
        if (r113 == null) goto L28;
        String r114 = r113.f548389d;
        if (r114 == null) goto L28;
    L29:
        LoginProcessor$checkPrivacy$request$1 r115 = new LoginProcessor$checkPrivacy$request$1(r101, r114, null);
        j r116 = (j) ((LinkedHashMap) r111).get(r101);     // Catch: Exception -> L20
        if (r116 == null) goto L38;
        AppletAuthTaskMonitor.Session r117 = r116.f34769h;     // Catch: Exception -> L20
        if (r117 == null) goto L38;
        LoginProcessor$checkPrivacy$2 r118 = new LoginProcessor$checkPrivacy$2(r115, null);     // Catch: Exception -> L20
        r103.L$0 = r101;     // Catch: Exception -> L20
        r103.label = 1;     // Catch: Exception -> L20
        r105 = r117.f(r118, r103);     // Catch: Exception -> L20
        if (r105 != r106) goto L37;
        return r106;
    L38:
        r103.L$0 = r101;     // Catch: Exception -> L20
        r103.label = 2;     // Catch: Exception -> L20
        r105 = r115.invoke(r103);     // Catch: Exception -> L20
        if (r105 != r106) goto L41;
        return r106;
    L28:
        r114 = "null";
    L20:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "checkPrivacy failed for appletId: " + r101 + ", " + e.getMessage());
        r109 = false;
    L7:
        r103 = new LoginProcessor$checkPrivacy$1(r100, r102);
        goto L8
    }

    public static final Object b(LoginProcessor r210, String r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof LoginProcessor$routeToLoginEntry$1) == false) goto L7;
        LoginProcessor$routeToLoginEntry$1 r100 = (LoginProcessor$routeToLoginEntry$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        LoginProcessor$routeToLoginEntry$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r110 = null;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        j r106 = (j) r102.L$1;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
        Object r108 = ((Result) r103).m9458unboximpl();     // Catch: Throwable -> L15
    L43:
        Object r109 = Result.m9449constructorimpl(Result.m9448boximpl(r108));     // Catch: Throwable -> L15
    L48:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L52;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "routeToLoginEntry: custom login navigation threw for " + r107, r111);
        r109 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r111)));
    L52:
        Object r112 = ((Result) r109).m9458unboximpl();
        if (Result.m9455isFailureimpl(r112) == false) goto L59;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "routeToLoginEntry: custom login navigation failed for " + r107, Result.m9452exceptionOrNullimpl(r112));
        String r113 = "failed";
        String r114 = null;
        String r115 = "open_login_page";
        AppletAuthTaskMonitor.ErrorCode r116 = AppletAuthTaskMonitor.ErrorCode.ROUTE_FAILED;
        Throwable r117 = Result.m9452exceptionOrNullimpl(r112);
        if (r117 == null) goto L57;
        r110 = r117.getMessage();
    L57:
        r106.f34770i = new AppletAuthTaskMonitor.a(r113, r114, r115, r116, r110, null, null, null, 482);
        l(r107, new h.a(LocalFinishReason.BIZ_FAILED));
    L59:
        return Unit.INSTANCE;
    L15:
        th = th;
        j r118 = r106;
        String r119 = r107;
    L47:
        Result.Companion r120 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r107 = r119;
        r106 = r118;
        goto L48
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        j r121 = (j) r102.L$1;
        String r122 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
        r118 = r121;
        r119 = r122;
    L60:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L46
        CustomLoginNavigator r124 = CustomLoginNavigator.f34707a;     // Catch: Throwable -> L46
        String r125 = r118.f34767f;     // Catch: Throwable -> L46
        u2.b r126 = r118.f34762a.f548391f;     // Catch: Throwable -> L46
        String r127 = r126.f548379a;     // Catch: Throwable -> L46
        String r128 = r126.f548382d;     // Catch: Throwable -> L46
        String r129 = r126.f548383e;     // Catch: Throwable -> L46
        r102.L$0 = r119;     // Catch: Throwable -> L46
        r102.L$1 = r118;     // Catch: Throwable -> L46
        r102.label = 2;     // Catch: Throwable -> L46
        r108 = r124.a(r119, r125, r127, r128, r129, r102);     // Catch: Throwable -> L46
        if (r108 == r104) goto L67;
        r107 = r119;
        r106 = r118;
        goto L43
    L67:
        return r104;
    L46:
        th = th;
        goto L47
    L20:
        ResultKt.throwOnFailure(r103);
        j r130 = (j) ((LinkedHashMap) f34727c).get(r211);
        if (r130 != null) goto L26;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "routeToLoginEntry: Can not find loginContext of " + r211);
        if (Intrinsics.areEqual(f34728d, r211) == false) goto L64;
        f34728d = null;
    L64:
        return Unit.INSTANCE;
    L26:
        CustomLoginNavigator r131 = CustomLoginNavigator.f34707a;
        String r132 = r130.f34763b.c();
        if (r132 != null) goto L29;
    L32:
        boolean r133 = true;
    L33:
        if (r133 == true) goto L35;
        com.bytedance.ai.utils.g.f37637a.i("LoginProcessor", "routeToLoginEntry: phone mask valid, show login dialog for " + r211);
        l(r211, h.b.f34754a);
        return Unit.INSTANCE;
    L35:
        com.bytedance.ai.utils.g.f37637a.i("LoginProcessor", "routeToLoginEntry: phone mask invalid, navigate to custom login page for " + r211);
        l(r211, h.e.f34757a);
        r102.L$0 = r211;
        r102.L$1 = r130;
        r102.label = 1;
        if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new LoginProcessor$dismissLoginDrawerIfNeeded$2(null), r102) == r104) goto L66;
        r118 = r130;
        r119 = r211;
        goto L60
    L66:
        return r104;
    L29:
        if (StringsKt.isBlank(r132) == true) goto L32;
        r133 = false;
    L7:
        r100 = new LoginProcessor$routeToLoginEntry$1(r210, r212);
        goto L8
    }

    public static void d(j r110, AppletAuthTaskMonitor.ErrorCode r111, String r112) {
        String r100 = "failed";
        String r101 = k(r110.f34769h);
        AppletAuthTaskMonitor.a r113 = new AppletAuthTaskMonitor.a(r100, r101, "login_panel_show", r111, r112, null, null, null, 480);
        r110.f34770i = r113;
        AppletAuthTaskMonitor.Session r114 = r110.f34769h;
        if (r114 == null) goto L6;
        r114.d(r113);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(String r310, String r311, j r312) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r100 = AppletRuntimeManager.f36749d;
        if (r100 == null) goto L5;
        Activity r110 = r100.currentActivity();
    L7:
        if (r110 != null) goto L13;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "Top activity is null");
        d(r312, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Current activity is null.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r101 = r312.f34768g;
        if (r101 == null) goto L88;
        f3.h.a.a(r101, "Current activity is null.", null, null, 14);
        return;
    L88:
        return;
    L13:
        if (f34726b.get() != null) goto L15;
        f34726b = new WeakReference(new f(r110));
    L15:
        f r111 = f34726b.get();
        if (r111 != null) goto L21;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "loadAddShowWidget: cannot get drawerContainer");
        d(r312, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Cannot get drawerContainer.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r102 = r312.f34768g;
        if (r102 == null) goto L89;
        f3.h.a.a(r102, "Cannot get drawerContainer.", null, null, 14);
        return;
    L89:
        return;
    L21:
        ViewGroup r103 = r111.f34747c;
        if (r103 != null) goto L28;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "loadAddShowWidget: cannot get drawerContent");
        d(r312, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Cannot get drawerContent.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r104 = r312.f34768g;
        if (r104 == null) goto L90;
        f3.h.a.a(r104, "Cannot get drawerContent.", null, null, 14);
        return;
    L90:
        return;
    L28:
        if (r312.f34768g == null) goto L30;
        String r105 = "doubao_apps_detail";
    L31:
        com.bytedance.ai.utils.l r106 = com.bytedance.ai.utils.l.f37675a;
        String r107 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_bottomSheet_Title_phoneNo_cn");
        if (r107 != null) goto L34;
        r107 = "申请获取并验证你的手机号";
    L34:
        String r108 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_bottomSheet_option_more");
        if (r108 != null) goto L37;
        r108 = "其他登录方式";
    L37:
        String r109 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_bottomSheet_option_notNow");
        if (r109 != null) goto L40;
        r109 = "暂不登录";
    L40:
        String r112 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_bottomSheet_optionDesc_linkedNo_cn");
        if (r112 != null) goto L43;
        r112 = "豆包绑定号码";
    L43:
        String r113 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_toast_agreeTerms");
        if (r113 != null) goto L46;
        r113 = "需同意相关服务协议和隐私政策";
    L46:
        String r114 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_chatCard_title_btn_agree");
        if (r114 != null) goto L49;
        r114 = "同意并继续";
    L49:
        String r115 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_chatCard_title_btn_notNow");
        if (r115 != null) goto L52;
        r115 = "暂不同意";
    L52:
        String r116 = com.bytedance.ai.utils.l.e(r106, "larus_appEntry_chatCard_title_agreePolicy");
        if (r116 != null) goto L56;
        r116 = "隐私协议提示";
    L56:
        if (Intrinsics.areEqual(r311, "mcp-login-card") == false) goto L59;
        String r117 = StringsKt.trimIndent("\n    {\n        \"type\": \"getPhoneNumber\",\n        \"currentPage\": \"" + r105 + "\",\n        \"brand\": {\n          \"name\": \"" + r312.f34762a.f548387b + "\",\n          \"logo\": \"" + r312.f34762a.f548388c + "\"\n        },\n        \"content\": {\n          \"title\": \"" + r107 + "\",\n          \"description\": \"" + r312.f34763b.b() + "\"\n        },\n        \"buttons\": {\n          \"primary\": {\n            \"text\": \"" + r312.f34763b.c() + "\",\n            \"loadingText\": \"登录中...\",\n            \"subtext\": \"" + r112 + "\"\n          },\n          \"other\": {\n            \"text\": \"" + r108 + "\"\n          },\n          \"secondary\": {\n            \"text\": \"" + r109 + "\"\n          }\n        },\n        \"agreement\": {\n          \"text\": [\n            {\n              \"text\": \"已阅读并同意" + r312.f34762a.f548387b + "的\"\n            },\n            {\n              \"text\": \"服务协议\",\n              \"url\": \"" + c(r312.f34763b.f()) + "\"\n            },\n            {\n              \"text\": \"和\"\n            },\n            {\n              \"text\": \"隐私政策\",\n              \"url\": \"" + c(r312.f34763b.e()) + "\"\n            }\n          ]\n        },\n        \"warningToast\": \"" + r113 + "\"\n      }\n                ");
    L61:
        String r118 = r117;
    L63:
        j r119 = (j) ((LinkedHashMap) f34727c).get(r310);
        if (r119 != null) goto L66;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "constructRenderContext: Can not find loginContext: " + r310);
        h5.k r120 = null;
    L74:
        if (r120 != null) goto L79;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "renderContext is null");
        d(r312, AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED, "Failed to build renderContext.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r121 = r312.f34768g;
        if (r121 == null) goto L91;
        f3.h.a.a(r121, "Failed to build renderContext.", null, null, 14);
        return;
    L91:
        return;
    L79:
        Activity r122 = r110;
        if ((r122 instanceof LifecycleOwner) == false) goto L82;
        LifecycleOwner r123 = (LifecycleOwner) r122;
    L83:
        if (r123 == null) goto L92;
        LifecycleCoroutineScope r124 = LifecycleOwnerKt.getLifecycleScope(r123);
        if (r124 == null) goto L93;
        BuildersKt.launch$default(r124, Dispatchers.getMain(), null, new LoginProcessor$loadAddShowWidget$1(r120, r310, r312, r111, r122, r311, null), 2, null);
        return;
    L93:
        return;
    L92:
        return;
    L82:
        r123 = null;
        goto L83
    L66:
        String r125 = r119.f34762a.f548391f.f548382d;
        if (StringsKt.isBlank(r125) == false) goto L69;
        r125 = "mocked_conversation_for_login";
    L69:
        String r210 = r125;
        if (IAISDKDebugService.f36186a.getDebugMode() != IAISDKDebugService.DebugMode.SCAN_PREVIEW) goto L72;
        String r211 = r119.f34762a.f548389d;
    L73:
        u2.b r126 = r119.f34762a.f548391f;
        String r212 = null;
        Object[] r127 = 0 == true ? 1 : 0;
        r120 = new h5.k(r126.f548379a, r210, r126.f548383e, r126.f548380b, r126.f548384f, new WidgetInfo(r310, "mcp-privacy-login-card", r118, null, null, null, null, r212, r212, null, "1", null, r127, r211, 7160, null), r103, new l(), 0, null, null, false, null, null, 61440);
        goto L74
    L72:
        r211 = null;
        goto L73
    L59:
        if (Intrinsics.areEqual(r311, "mcp-agree-card") == false) goto L62;
        r117 = StringsKt.trimIndent("\n{\n    \"type\": \"agreePrivacyAuthorization\",\n    \"currentPage\": \"" + r105 + "\",\n    \"brand\": {\n        \"name\": \"" + r312.f34762a.f548387b + "\",\n        \"logo\": \"" + r312.f34762a.f548388c + "\"\n    },\n    \"content\": {\n        \"title\": \"" + r116 + "\",\n        \"description\": \"" + r312.f34763b.d() + "\"\n    },\n    \"buttons\": {\n        \"primary\": {\n             \"text\": \"" + r114 + "\"\n        },\n        \"secondary\": {\n             \"text\": \"" + r115 + "\"\n        }\n    }\n}\n                ");
        goto L61
    L62:
        r118 = null;
        goto L63
    L30:
        r105 = "chat";
        goto L31
    L5:
        r110 = null;
        goto L7
    }

    public static void i(String r100, GrantingAction r101, OperationType r102) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "operationType");
        LinkedHashMap r103 = (LinkedHashMap) f34727c;
        j r104 = (j) r103.get(r100);
        if (r104 != null) goto L7;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "onDrawerDialogAction: Can not find loginContext of " + r100);
        return;
    L7:
        if (Intrinsics.areEqual(r100, f34728d) == true) goto L10;
        com.bytedance.ai.utils.g.f37637a.e("LoginProcessor", "onDrawerDialogAction: Received from non-active applet: " + r100);
        return;
    L10:
        h r105 = r104.f34766e;
        com.bytedance.ai.utils.g r106 = com.bytedance.ai.utils.g.f37637a;
        r106.i("LoginProcessor", "onDrawerDialogAction: appletId=" + r100 + ", action=" + r101 + ", operationType=" + r102 + ", currentState=" + r105);
        AppletAuthTaskMonitor.Session r107 = r104.f34769h;
        if (r107 == null) goto L13;
        r107.c();
    L13:
        int r108 = a.f34732a[r101.ordinal()];
        if (r108 != 1) goto L16;
        f34728d = null;
        l(r100, new h.a(LocalFinishReason.USER_DISMISS_DIALOG));
        return;
    L16:
        if (r108 == 2) goto L35;
        if (r108 != 3) goto L33;
        j r109 = (j) r103.get(r100);
        if (r109 != null) goto L22;
        r106.e("LoginProcessor", "handleDialogAgree: Can not find loginContext of " + r100);
        return;
    L22:
        r106.i("LoginProcessor", "handleDialogAgree: applet: " + r100 + ", currentState: " + r109.f34766e + ", opType: " + r102);
        h r110 = r109.f34766e;
        if ((r110 instanceof h.d) == false) goto L29;
        if (r109.f34764c == false) goto L27;
        l(r100, new h.a(LocalFinishReason.SUCCESS));
        return;
    L27:
        BuildersKt.launch$default(f34729e, null, null, new LoginProcessor$handleDialogAgree$1(r100, null), 3, null);
        return;
    L29:
        if ((r110 instanceof h.b) == false) goto L31;
        l(r100, h.e.f34757a);
        return;
    L31:
        r106.w("LoginProcessor", "handleDialogAgree called in unexpected state: " + r109.f34766e);
        return;
    L33:
        throw new NoWhenBranchMatchedException();
    L35:
        if ((r105 instanceof h.d) == false) goto L38;
        LocalFinishReason r111 = LocalFinishReason.USER_REJECTED_PRIVACY;
    L41:
        l(r100, new h.a(r111));
        return;
    L38:
        if ((r105 instanceof h.b) == false) goto L40;
        r111 = LocalFinishReason.USER_REJECTED_LOGIN;
        goto L41
    L40:
        r111 = LocalFinishReason.USER_REJECTED_LOGIN;
        goto L41
    }

    public static void j(String r100, boolean r101, AppletAuthTaskMonitor.a r102) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        r103.i("LoginProcessor", "postLoginResult: appletId=" + r100 + ", success=" + r101);
        LinkedHashMap r104 = (LinkedHashMap) f34727c;
        j r105 = (j) r104.get(r100);
        h r106 = null;
        if (r105 == null) goto L5;
        h r107 = r105.f34766e;
    L7:
        if ((r107 instanceof h.e) == true) goto L12;
        StringBuilder r108 = new StringBuilder("current state=");
        j r109 = (j) r104.get(r100);
        if (r109 == null) goto L11;
        r106 = r109.f34766e;
    L11:
        r108.append(r106);
        r103.w("LoginProcessor", r108.toString());
    L12:
        j r110 = (j) r104.get(r100);
        if (r110 == null) goto L17;
        AppletAuthTaskMonitor.Session r111 = r110.f34769h;
        if (r111 == null) goto L17;
        r111.c();
    L17:
        j r112 = (j) r104.get(r100);
        if (r112 == null) goto L20;
        r112.f34770i = r102;
    L20:
        if (r101 == false) goto L22;
        LocalFinishReason r113 = LocalFinishReason.SUCCESS;
    L23:
        l(r100, new h.a(r113));
        return;
    L22:
        r113 = LocalFinishReason.BIZ_FAILED;
        goto L23
    L5:
        r107 = null;
        goto L7
    }

    public static void e(u2.c r210, u2.j r211, f3.h r212, String r213, AppletAuthTaskMonitor.Session r214) {
        String r100 = r210.f548386a;
        String r101 = f34728d;
        if (r101 != null) goto L5;
    L12:
        f34728d = r100;
        f34727c.put(r100, new j(r210, r211, false, r213, r212, r214));
        com.bytedance.ai.utils.g.f37637a.i("LoginProcessor", "startLoginFlow for " + r100);
        BuildersKt.launch$default(f34729e, null, null, new LoginProcessor$startLoginFlow$1(r100, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r101, r100) == true) goto L12;
        com.bytedance.ai.utils.g.f37637a.w("LoginProcessor", "handleAgree Applet[" + r100 + "] clicked agree button, but lock is held by " + f34728d);
        if (r214 == null) goto L9;
        r214.d(new AppletAuthTaskMonitor.a("failed", k(r214), "login_context_check", AppletAuthTaskMonitor.ErrorCode.CONCURRENT_FLOW, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT));
    L9:
        if (r212 == null) goto L14;
        f3.h.a.a(r212, "Another login process is active.", null, null, 14);
        return;
    }

    public static void f(u2.c r210, u2.j r211, f3.h r212, String r213, AppletAuthTaskMonitor.Session r214) {
        String r100 = r210.f548386a;
        String r101 = f34728d;
        if (r101 != null) goto L5;
    L12:
        f34728d = r100;
        f34727c.put(r100, new j(r210, r211, true, r213, r212, r214));
        com.bytedance.ai.utils.g.f37637a.i("LoginProcessor", "startLoginFlow for " + r100);
        BuildersKt.launch$default(f34729e, null, null, new LoginProcessor$startPrivacyFlow$1(r100, null), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(r101, r100) == true) goto L12;
        com.bytedance.ai.utils.g.f37637a.w("LoginProcessor", "handlePrivacyAgree Applet[" + r100 + "] clicked agree button, but lock is held by " + f34728d);
        if (r214 == null) goto L9;
        r214.d(new AppletAuthTaskMonitor.a("failed", k(r214), "login_context_check", AppletAuthTaskMonitor.ErrorCode.CONCURRENT_FLOW, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT));
    L9:
        if (r212 == null) goto L14;
        f3.h.a.a(r212, "Another login process is active.", null, null, 14);
        return;
    }
}
