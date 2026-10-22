package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "clipScreen")
public final class a2 extends b<b2, ClipScreenResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenCert f63282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f63283b;

    public a2(View r100) {
        this.f63283b = r100;
        this.f63282a = TokenCert.Companion.with("bpea-live_clipScreen_jsb_clip_screen_method");
    }

    public static ClipScreenResultModel j(boolean r100) {
        ClipScreenResultModel r101 = new ClipScreenResultModel();
        if (r100 == false) goto L5;
        ClipScreenResultModel.Code r102 = ClipScreenResultModel.Code.Success;
    L6:
        r101.b(r102);
        r101.c(new ClipScreenResultModel.a());
        return r101;
    L5:
        r102 = ClipScreenResultModel.Code.Failed;
        goto L6
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        b2 r102 = (b2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102.c() != null) goto L5;
    L20:
        finishWithResult(j(false));
        return;
    L5:
        if (r102.d() == null) goto L20;
        if (r102.b() == null) goto L20;
        if (r102.a() == null) goto L20;
        if (this.f63283b == null) goto L20;
        Context r103 = r101.getContext();
        TokenCert r104 = this.f63282a;
        if (Build.VERSION.SDK_INT < 29) goto L16;
    L19:
        k(r103, r102);
        return;
    L16:
        if (m60.c.d(r103, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}) == true) goto L19;
        Activity r105 = ContextUtil.contextToActivity(r103);
        SettingKey<Boolean> r106 = m60.i.f512260a;
        new m60.i.b(r105).b(new z1(this, r103, r102), null, r104, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
    }

    public final void k(Context r100, b2 r101) {
        UtilityKotlinExtentionsKt.i(0);
        String r102 = com.bytedance.android.livesdk.share.g.f158092a;
        View r103 = this.f63283b;
        Double r104 = r101.c();
        Intrinsics.checkNotNull(r104);
        int r105 = (int) UtilityKotlinExtentionsKt.h((float) r104.doubleValue());
        Double r106 = r101.d();
        Intrinsics.checkNotNull(r106);
        int r107 = (int) UtilityKotlinExtentionsKt.h((float) r106.doubleValue());
        Double r108 = r101.b();
        Intrinsics.checkNotNull(r108);
        int r109 = (int) UtilityKotlinExtentionsKt.h((float) r108.doubleValue());
        Double r110 = r101.a();
        Intrinsics.checkNotNull(r110);
        int r111 = (int) UtilityKotlinExtentionsKt.h((float) r110.doubleValue());
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("clip_screen_method", "name");
        Bitmap r112 = com.bytedance.android.livesdk.share.g.a(r103);     // Catch: Exception -> L13
        if (r112 != null) goto L6;
    L15:
        Uri r113 = null;
    L16:
        if (r113 == null) goto L21;
        ClipScreenResultModel r114 = j(true);
        ClipScreenResultModel.a r115 = r114.a();
        if (r115 == null) goto L20;
        r115.b(1);
        r115.a(r113.toString());
    L20:
        Unit r116 = Unit.INSTANCE;
        finishWithResult(r114);
        return;
    L21:
        finishWithResult(j(false));
        return;
    L6:
        if (r109 <= r112.getWidth()) goto L9;
        r109 = r112.getWidth();     // Catch: Exception -> L13
    L9:
        if (r111 <= r112.getHeight()) goto L11;
        r111 = r112.getHeight();     // Catch: Exception -> L13
    L11:
        r113 = com.bytedance.android.livesdk.share.g.c(r100, Bitmap.createBitmap(r112, r105, r107, r109, r111));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ALogger.d("ttlive_poster", "clipBitmapAndSave failure: " + e.getMessage());
        goto L15
    }
}
