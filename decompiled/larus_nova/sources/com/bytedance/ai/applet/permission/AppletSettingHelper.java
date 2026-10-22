package com.bytedance.ai.applet.permission;

import android.content.Context;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.bridge.remote.model.ScopePermissionInfo;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletSettingHelper implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f34925b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34926a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public AppletSettingHelper(String r100) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        this.f34926a = r100;
    }

    public static Map b(AppletPermissionDetail r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Map<String, ScopePermissionInfo> r102 = r100.getScopesStatus();
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        Iterator<Map.Entry<String, ScopePermissionInfo>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L31;
        Map.Entry<String, ScopePermissionInfo> r104 = r103.next();
        String r105 = r104.getKey();
        ScopePermissionInfo r106 = r104.getValue();
        Boolean r107 = null;
        if (r106 == null) goto L11;
        Integer r108 = r106.getGrantStatus();
    L12:
        int r109 = GrantStatus.GRANTED.getValue();
        if (r108 != null) goto L16;
    L18:
        int r110 = GrantStatus.DENIED.getValue();
        if (r108 != null) goto L22;
    L23:
        int r111 = GrantStatus.REVOKED.getValue();
        if (r108 != null) goto L27;
    L29:
        if (r107 == null) goto L7;
        r101.put(r105, Boolean.valueOf(r107.booleanValue()));
        goto L7
    L27:
        if (r108.intValue() != r111) goto L29;
    L28:
        r107 = Boolean.FALSE;
        goto L29
    L22:
        if (r108.intValue() == r110) goto L28;
    L16:
        if (r108.intValue() != r109) goto L18;
        r107 = Boolean.TRUE;
        goto L29
    L11:
        r108 = null;
        goto L12
    L31:
        return r101;
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

    public final Object c(AppletAuthTaskMonitor.Session r210, Continuation<? super g> r211) {
        if ((r211 instanceof AppletSettingHelper$getSetting$1) == false) goto L7;
        AppletSettingHelper$getSetting$1 r100 = (AppletSettingHelper$getSetting$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = null;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        AppletAuthTaskMonitor.Session r106 = (AppletAuthTaskMonitor.Session) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
    L32:
        int r107 = g.f34949c;     // Catch: Exception -> L14
        Map r108 = b((AppletPermissionDetail) r102);     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r108, "authSetting");     // Catch: Exception -> L14
        g r109 = new g(null, r108);     // Catch: Exception -> L14
        r106.d(new AppletAuthTaskMonitor.a("success", null, null, null, null, null, null, null, 510));     // Catch: Exception -> L14
        return r109;
    L14:
        e = e;
        AppletAuthTaskMonitor.Session r110 = r106;
    L37:
        if ((e instanceof CronetIOException) == false) goto L40;
        Integer r111 = Integer.valueOf(((CronetIOException) e).getStatusCode());
    L43:
        if (r111 != null) goto L45;
    L47:
        String r112 = e.getMessage();
        if (r112 != null) goto L50;
    L55:
        String r113 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L56:
        com.bytedance.ai.utils.g.f37637a.e("AppletSettingHelper", "Failed to get setting for applet '" + this.f34926a + "', reason: " + r113, e);
        r110.d(new AppletAuthTaskMonitor.a("failed", null, "permission_status_check", AppletAuthTaskMonitor.ErrorCode.API_FAILED, r113, null, null, null, 482));
        int r114 = g.f34949c;
        Intrinsics.checkNotNullParameter(r113, "reason");
        return new g(r113, MapsKt.emptyMap());
    L50:
        if ((!StringsKt.isBlank(r112)) == false) goto L52;
        r105 = r112;
    L52:
        if (r105 == null) goto L55;
        r113 = r105;
        goto L56
    L45:
        if (r111.intValue() <= 0) goto L47;
        r113 = "server response code（" + r111 + "） is not 2xx";
        goto L56
    L40:
        if ((e instanceof HttpResponseException) == false) goto L42;
        r111 = Integer.valueOf(((HttpResponseException) e).getStatusCode());
        goto L43
    L42:
        r111 = null;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        if (this.f34926a.length() != 0) goto L21;
        boolean r115 = true;
    L22:
        if (r115 == false) goto L25;
        int r116 = g.f34949c;
        Intrinsics.checkNotNullParameter("appletId is null or empty", "reason");
        return new g("appletId is null or empty", MapsKt.emptyMap());
    L25:
        if (r210 != null) goto L27;
        SecureRandom r117 = AppletAuthTaskMonitor.f37154a;
        r110 = AppletAuthTaskMonitor.g(new AppletAuthTaskMonitor.b("authorize", "native_api", "permission_check", "AppletAuthorizeManager.getSetting.call", this.f34926a, "native_container", null, null, null, null, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_TAKE_SCREEN_SHOT_SYNC));
    L58:
        AppletSettingHelper$getSetting$detail$1 r118 = new AppletSettingHelper$getSetting$detail$1(this, null);     // Catch: Exception -> L35
        r100.L$0 = r110;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        r102 = r110.f(r118, r100);     // Catch: Exception -> L35
        if (r102 != r103) goto L31;
        return r103;
    L31:
        r106 = r110;
    L35:
        e = e;
        goto L37
    L27:
        r110 = r210;
        goto L58
    L21:
        r115 = false;
    L7:
        r100 = new AppletSettingHelper$getSetting$1(this, r211);
        goto L8
    }
}
