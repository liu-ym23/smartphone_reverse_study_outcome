package com.bytedance.applet.aibridge.health;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import android.util.Base64;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.utils.logger.FLogger;
import e3.d;
import f2.k;
import f3.h;
import java.util.List;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import nv3.s;
import nv3.t;
import nv3.v;
import nv3.w;
import nv3.x;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/health/SyncHuaweiDataMethod;", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL$SyncHuaweiDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL$SyncHuaweiDataResultModel;", "fail", "error", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "message", "", "Companion", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncHuaweiDataMethod extends AbsSyncHuaweiDataMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f191158b = 0;

    public static final class a {
    }

    static {
    }

    public SyncHuaweiDataMethod() {
    }

    public final void b(h<AbsSyncHuaweiDataMethodIDL.b> r100, final f3.a r101, final String r102) {
        FLogger.f375446a.h("AISDK_JSB_SyncHuaweiDataMethod", new x(r101, r102));
        h.a.a(r100, r102, r101, null, 10);
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, nv3.v] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, nv3.w] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r210, ParamModel r211, final h r310) {
        AbsSyncHuaweiDataMethodIDL.a r100 = (AbsSyncHuaweiDataMethodIDL.a) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r310, "callback");
        if (StringsKt.isBlank(r100.getAppId()) == false) goto L5;
    L77:
        b(r310, f3.a.f475267h, "Invalid Huawei health sync parameters");
        return;
    L5:
        if (StringsKt.isBlank(r100.getSecretKey()) == true) goto L77;
        if (StringsKt.isBlank(r100.getScheme()) == true) goto L77;
        Activity r101 = r210.getOwnerActivity();
        if (r101 != null) goto L12;
        r101 = k.b();
    L12:
        if (r101 != null) goto L14;
    L76:
        b(r310, f3.a.f475265f, "Current activity is unavailable");
        return;
    L14:
        if (r101.isFinishing() == true) goto L76;
        if (r101.isDestroyed() == true) goto L76;
        b r102 = b.f191167a;
        t r103 = new t(r101.getTaskId());
        String r104 = r100.getAppId();
        String r105 = r100.getSecretKey();
        String r106 = r100.getScheme();
        ?? r107 = new v(r310);
        ?? r108 = new w(this, r310);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "appId");
        Intrinsics.checkNotNullParameter(r105, "secretKey");
        Intrinsics.checkNotNullParameter(r106, "callbackUri");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
        Intrinsics.checkNotNullParameter(r108, "onFailure");
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L21
        Object r110 = Result.m9449constructorimpl(r101.getPackageManager().getPackageInfo("com.huawei.health", 128).versionName);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r110) == false) goto L26;
        r110 = null;
    L26:
        String r111 = (String) r110;
        int r112 = 0;
        if (r111 != null) goto L29;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == true) goto L51;
        List r114 = StringsKt.split$default(r111, new char[]{'.'}, false, 0, 6, null);
        List r115 = StringsKt.split$default("13.1.3.300", new char[]{'.'}, false, 0, 6, null);
        int r116 = Math.max(r114.size(), r115.size());
        int r117 = 0;
    L36:
        if (r117 >= r116) goto L53;
        String r118 = (String) CollectionsKt.getOrNull(r114, r117);
        if (r118 == null) goto L42;
        Integer r119 = StringsKt.toIntOrNull(r118);
        if (r119 == null) goto L42;
        r112 = r119.intValue();
    L42:
        String r120 = (String) CollectionsKt.getOrNull(r115, r117);
        if (r120 == null) goto L47;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 == null) goto L47;
        int r122 = r121.intValue();
    L48:
        if (r112 != r122) goto L49;
        r117 = r117 + 1;
        r115 = r115;
        r112 = 0;
        goto L36
    L49:
        if (r112 <= r122) goto L51;
    L47:
        r122 = 0;
    L53:
        boolean r123 = true;
    L54:
        if (r123 == true) goto L79;
        r108.invoke(f3.a.f475266g, "Huawei Health 13.1.3.300 or later is required");
    L87:
        return;
    L79:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L59
        byte[] r125 = Base64.decode(r105, 0);     // Catch: Throwable -> L59
        Mac r126 = Mac.getInstance("HmacSHA256");     // Catch: Throwable -> L59
        r126.init(new SecretKeySpec(r125, "HmacSHA256"));     // Catch: Throwable -> L59
        Object r127 = Result.m9449constructorimpl(Base64.encodeToString(r126.doFinal((r104 + '_' + r105).getBytes(Charsets.UTF_8)), 2));     // Catch: Throwable -> L59
    L62:
        if (Result.m9455isFailureimpl(r127) == false) goto L64;
        Object r128 = null;
    L65:
        String r129 = (String) r128;
        if (r129 != null) goto L68;
        r108.invoke(f3.a.f475265f, "Failed to create Huawei health signature");
        goto L87
    L68:
        String r130 = UUID.randomUUID().toString();
        Intent r131 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse("huaweischeme://healthapp/router/sync").buildUpon().appendQueryParameter("appId", r104).appendQueryParameter("redirectUrl", r106).appendQueryParameter("signature", r129).build());
        Handler r132 = s.f520844a;
        Intrinsics.checkNotNullParameter(r130, "operationId");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r107, "onSuccess");
        Intrinsics.checkNotNullParameter(r108, "onFailure");
        if (s.b(new s.c(r130, r103, r107, r108)) == true) goto L83;
        r108.invoke(f3.a.f475277r, "Huawei health operation is already in progress");
        goto L87
    L83:
        r101.startActivity(r131);     // Catch: RuntimeException -> L73 ActivityNotFoundException -> L74
    L74:
        Handler r133 = s.f520844a;
        s.a(r130, f3.a.f475266g, "Huawei Health is unavailable");
    L73:
        Handler r134 = s.f520844a;
        s.a(r130, f3.a.f475265f, "Failed to open Huawei Health");
        goto L87
    L64:
        r128 = r127;
    L59:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L51:
        r123 = false;
        goto L54
    L29:
        if (StringsKt.isBlank(r111) == true) goto L32;
        r113 = false;
    L21:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
