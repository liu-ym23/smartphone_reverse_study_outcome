package com.bytedance.applet.aibridge.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.huawei.hms.hihealthlite.HuaweiHiHealthLite;
import com.huawei.hms.hihealthlite.LoginFreeAuthController;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import f2.k;
import f3.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nv3.c;
import nv3.d;
import nv3.e;
import nv3.f;
import nv3.g;
import nv3.l;
import nv3.m;
import nv3.s;
import nv3.t;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/health/HealthRequestFreeLoginMethod;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginResultModel;", "fail", "error", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "message", "", "Companion", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthRequestFreeLoginMethod extends AbsHealthRequestFreeLoginMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f191157b = null;

    public static final class a {
    }

    static {
        f191157b = SetsKt.setOf(new String[]{RomUtils.BRAND_HUAWEI, RomUtils.BRAND_HONOR});
    }

    public HealthRequestFreeLoginMethod() {
    }

    public final void b(h<AbsHealthRequestFreeLoginMethodIDL.b> r100, final f3.a r101, final String r102) {
        FLogger.f375446a.h("AISDK_JSB_HealthRequestFreeLoginMethod", new d(r101, r102));
        h.a.a(r100, r102, r101, null, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [nv3.e] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Runnable, nv3.h] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, nv3.b] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, nv3.c] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r210, ParamModel r211, final h r212) {
        AbsHealthRequestFreeLoginMethodIDL.a r100 = (AbsHealthRequestFreeLoginMethodIDL.a) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        if (f191157b.contains(r100.getHealthDeviceType()) == true) goto L5;
    L139:
        b(r212, f3.a.f475267h, "Invalid health authorization parameters");
        return;
    L5:
        if (r100.getScopes().isEmpty() == true) goto L139;
        List<String> r101 = r100.getScopes();
        boolean r102 = true;
        if ((r101 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        if (StringsKt.isBlank((String) r103.next()) == false) goto L13;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L139;
        if (StringsKt.isBlank(r100.getState()) == true) goto L139;
        if (StringsKt.isBlank(r100.getAppId()) == true) goto L139;
        Activity r105 = r210.getOwnerActivity();
        if (r105 != null) goto L27;
        r105 = k.b();
    L27:
        if (r105 != null) goto L29;
    L138:
        b(r212, f3.a.f475265f, "Current activity is unavailable");
        return;
    L29:
        if (r105.isFinishing() == true) goto L138;
        if (r105.isDestroyed() == true) goto L138;
        final ?? r110 = new nv3.b(r212);
        ?? r106 = new c(this, r212);
        String r107 = r100.getHealthDeviceType();
        Object r111 = null;
        if (Intrinsics.areEqual(r107, RomUtils.BRAND_HUAWEI) == false) goto L85;
        String r108 = r100.getScheme();
        String r109 = r100.getSecretKey();
        if (r108 != null) goto L38;
    L41:
        boolean r112 = true;
    L42:
        if (r112 == true) goto L84;
        if (r109 != null) goto L45;
    L48:
        if (r102 == true) goto L84;
        if (Build.VERSION.SDK_INT >= 23) goto L54;
        b(r212, f3.a.f475266g, "Huawei Health requires Android 6.0 or later");
    L156:
        return;
    L54:
        int r113 = m.f520838a;
        Intrinsics.checkNotNullParameter(r108, "value");
        if (m.a(UriProtector.parse(r108), "/healthKitHuawei") == true) goto L58;
        b(r212, f3.a.f475267h, "Invalid Huawei health callback URI");
        goto L156
    L58:
        if ((r105 instanceof FragmentActivity) == false) goto L60;
        FragmentActivity r114 = (FragmentActivity) r105;
    L61:
        if (r114 != null) goto L63;
        b(r212, f3.a.f475266g, "Huawei health requires a FragmentActivity");
        goto L156
    L63:
        b r115 = b.f191167a;
        t r116 = new t(r105.getTaskId());
        List r117 = CollectionsKt.toList(r100.getScopes());
        String r118 = r100.getState();
        String r119 = r100.getAppId();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r114, "activity");
        Intrinsics.checkNotNullParameter(r116, "source");
        Intrinsics.checkNotNullParameter(r117, ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        Intrinsics.checkNotNullParameter(r118, "state");
        Intrinsics.checkNotNullParameter(r119, "appId");
        Intrinsics.checkNotNullParameter(r108, "callbackUri");
        Intrinsics.checkNotNullParameter(r109, "secretKey");
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        Intrinsics.checkNotNullParameter(r106, "onFailure");
        final String r120 = UUID.randomUUID().toString();
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L70
        LoginFreeAuthController r122 = HuaweiHiHealthLite.getLoginFreeAuthController(r114.getApplicationContext());     // Catch: Throwable -> L70
        if (r122 == null) goto L67;
        Intent r123 = r122.requestLoginFreeAuthorizationIntent((String[]) r117.toArray(new String[0]), r120, r119, r108, r109);     // Catch: Throwable -> L70
    L68:
        Object r124 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L70
    L73:
        if (Result.m9455isFailureimpl(r124) == true) goto L76;
        r111 = r124;
    L76:
        Intent r125 = (Intent) r111;
        if (r125 != null) goto L80;
        r106.invoke(f3.a.f475266g, "Huawei health authorization is unavailable");
    L157:
        return;
    L80:
        Handler r126 = s.f520844a;
        Intrinsics.checkNotNullParameter(r120, "operationId");
        Intrinsics.checkNotNullParameter(r116, "source");
        Intrinsics.checkNotNullParameter(r118, "originalState");
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        Intrinsics.checkNotNullParameter(r106, "onFailure");
        if (s.b(new s.a(r120, r116, r118, r110, r106)) == true) goto L83;
        r106.invoke(f3.a.f475277r, "Huawei health operation is already in progress");
        goto L157
    L83:
        HealthAuthFragment.a r127 = HealthAuthFragment.f191151i;
        Function2 r128 = new nv3.k(r120);
        Function0 r129 = new l(r120);
        r127.getClass();
        HealthAuthFragment.a.a(r114, r125, r128, r129);
        goto L157
    L67:
        r123 = null;
    L70:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L60:
        r114 = null;
        goto L61
    L45:
        if (StringsKt.isBlank(r109) == true) goto L48;
        r102 = false;
    L84:
        b(r212, f3.a.f475267h, "Invalid Huawei health authorization parameters");
        return;
    L38:
        if (StringsKt.isBlank(r108) == true) goto L41;
        r112 = false;
        goto L42
    L85:
        boolean r131 = false;
        if (Intrinsics.areEqual(r107, RomUtils.BRAND_HONOR) == true) goto L88;
        return;
    L88:
        if ((r105 instanceof FragmentActivity) == false) goto L90;
        FragmentActivity r132 = (FragmentActivity) r105;
    L91:
        if (r132 != null) goto L93;
        b(r212, f3.a.f475266g, "Honor health requires a FragmentActivity");
        return;
    L93:
        com.bytedance.applet.aibridge.health.a r133 = com.bytedance.applet.aibridge.health.a.f191159a;
        List r134 = CollectionsKt.toList(r100.getScopes());
        final String r135 = r100.getState();
        String r136 = r100.getAppId();
        r133.getClass();
        Intrinsics.checkNotNullParameter(r132, "activity");
        Intrinsics.checkNotNullParameter(r134, ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        Intrinsics.checkNotNullParameter(r135, "state");
        Intrinsics.checkNotNullParameter(r136, "appId");
        Intrinsics.checkNotNullParameter(r110, "onSuccess");
        Intrinsics.checkNotNullParameter(r106, "onFailure");
        String r137 = UUID.randomUUID().toString();
        final com.bytedance.applet.aibridge.health.a.C2775a r138 = new com.bytedance.applet.aibridge.health.a.C2775a(r137, new e(r110, r135), r106);
        com.bytedance.applet.aibridge.health.a.C2775a r139 = com.bytedance.applet.aibridge.health.a.f191161c;
        if (r139 != null) goto L96;
        com.bytedance.applet.aibridge.health.a.C2775a r140 = null;
    L100:
        com.bytedance.applet.aibridge.health.a.f191161c = r138;
        ?? r141 = new nv3.h(r138);
        com.bytedance.applet.aibridge.health.a.f191162d = r141;
        com.bytedance.applet.aibridge.health.a.f191160b.postDelayed(r141, 300000);
        if (r140 == null) goto L105;
        Function2<f3.a, String, Unit> r142 = r140.f191165c;
        if (r142 == null) goto L105;
        r142.invoke(f3.a.f475274o, "Previous Honor health authorization was replaced by a new request");
    L105:
        boolean r143 = true;
    L106:
        if (r143 == true) goto L143;
        r106.invoke(f3.a.f475277r, "Honor health operation is already in progress");
        return;
    L143:
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L128
        SignInOptions r145 = SignInOptions.f276495j;     // Catch: Throwable -> L128
        HashSet r146 = new HashSet();     // Catch: Throwable -> L128
        HashSet r147 = new HashSet();     // Catch: Throwable -> L128
        r146.addAll(r145.f276506a);     // Catch: Throwable -> L128
        r147.addAll(r145.f276507b);     // Catch: Throwable -> L128
        List r148 = r134;     // Catch: Throwable -> L128
        ArrayList r149 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r148, 10));     // Catch: Throwable -> L128
        Iterator r150 = r148.iterator();     // Catch: Throwable -> L128
    L110:
        if (r150.hasNext() == false) goto L113;
        r149.add(new Scope((String) r150.next()));     // Catch: Throwable -> L128
        goto L110
    L113:
        if (r149.size() != 0) goto L117;
        r131 = true;
    L117:
        if ((!r131) == false) goto L126;
        Iterator r151 = r149.iterator();     // Catch: Throwable -> L128
    L120:
        if (r151.hasNext() == false) goto L126;
        Scope r152 = (Scope) r151.next();     // Catch: Throwable -> L128
        if (r152 == null) goto L120;
        if (r152.f276503a == null) goto L120;
        r146.add(r152);     // Catch: Throwable -> L128
    L126:
        Object r153 = Result.m9449constructorimpl(new iw7.b(r132, new SignInOptions(r146, r147, r136, "", "", true, true)));     // Catch: Throwable -> L128
    L131:
        if (Result.m9455isFailureimpl(r153) == true) goto L134;
        r111 = r153;
    L134:
        iw7.a r154 = (iw7.a) r111;
        if (r154 != null) goto L137;
        com.bytedance.applet.aibridge.health.a.b(r137, f3.a.f475266g, "Honor health sign-in is unavailable");
        return;
    L137:
        lw7.d r155 = r154.silentSignIn();
        r155.f(new f(r137));
        r155.e(new g(r137, r154, r132));
        return;
    L128:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r153 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L131
    L96:
        if ((SystemClock.elapsedRealtime() - r139.f191166d) >= 1000) goto L98;
        r143 = false;
        goto L106
    L98:
        r140 = com.bytedance.applet.aibridge.health.a.c(r139.f191163a);
        goto L100
    L90:
        r132 = null;
    L17:
        r104 = false;
        goto L18
    L9:
        if (r101.isEmpty() == false) goto L11;
        goto L11
    }
}
