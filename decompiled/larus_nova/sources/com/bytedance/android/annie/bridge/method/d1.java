package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.OpenResultModel;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "open")
public final class d1 extends e7.n<e7.n0, OpenResultModel> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f38644b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f38645c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHybridComponent f38646a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f38648b = null;

        static {
            int[] r100 = new int[OpenAPPTYPE.values().length];
            r100[OpenAPPTYPE.WEIXIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OpenAPPTYPE.QQ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f38647a = r100;
            int[] r101 = new int[OpenActionStatus.values().length];
            r101[OpenActionStatus.BEFORE_OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[OpenActionStatus.AFTER_OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f38648b = r101;
        }
    }

    static {
        f38644b = CollectionsKt.listOf(new String[]{"alwaysCloseAfterOpen", "alwaysCloseBeforeOpen", "onlyCloseAfterOpenSucceed"});
        f38645c = CollectionsKt.listOf(new String[]{"webcast_webview", "webcast_lynxview", "webcast_redirect"});
    }

    public final void l() {
        IHybridComponent r100 = this.f38646a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("hybridComponent");
        r100 = null;
    L5:
        AnnieFragmentManager.a(r100.containerId(), false, 6);
    }

    public d1(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        IHybridComponent r101 = (IHybridComponent) r100.c(IHybridComponent.class);
        if (r101 == null) goto L6;
        this.f38646a = r101;
        return;
    }

    public static void k(e7.n0 r100) {
        String r101 = r100.e();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if ((!r103) == false) goto L21;
        if (r100.d() == null) goto L15;
        List<String> r104 = f38644b;
        String r105 = r100.d();
        Intrinsics.checkNotNull(r105);
        if (r104.contains(r105) == true) goto L15;
    L16:
        if (r102 == false) goto L19;
        return;
    L19:
        throw new IllegalStateException("replaceType is not valid".toString());
    L15:
        r102 = true;
        goto L16
    L21:
        throw new IllegalStateException("url is null or empty".toString());
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L10
    }

    public static String m(e7.n0 r100) {
        Boolean r101 = r100.c();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r100.f(), r102) == false) goto L8;
        return null;
    L8:
        if (r100.d() != null) goto L10;
    L17:
        return "onlyCloseAfterOpenSucceed";
    L10:
        if (Intrinsics.areEqual(r100.d(), "onlyCloseAfterOpenSucceed") == true) goto L17;
        if (Intrinsics.areEqual(r100.d(), "alwaysCloseAfterOpen") == true) goto L20;
        return "alwaysCloseBeforeOpen";
    L20:
        return "alwaysCloseAfterOpen";
    }

    public final Uri j(e7.n0 r100) {
        String r101 = r100.e();
        Intrinsics.checkNotNull(r101);
        Uri r102 = UriProtector.parse(r101);
        if (CollectionsKt.contains(f38645c, r102.getHost()) == false) goto L17;
        Uri.Builder r103 = r102.buildUpon();
        IHybridComponent r104 = this.f38646a;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("hybridComponent");
        r104 = null;
    L7:
        r103.appendQueryParameter("_open_container_id", r104.containerId());
        if (Intrinsics.areEqual(r100.c(), Boolean.TRUE) == false) goto L13;
        if (Intrinsics.areEqual(m(r100), "onlyCloseAfterOpenSucceed") == false) goto L13;
        r103.appendQueryParameter("_close_after_open_success", "1");
    L13:
        if (r100.b() == null) goto L16;
        String r105 = UUID.randomUUID().toString();
        Lazy r106 = ContainerInitialPropsManager.f39126a;
        JsonObject r107 = r100.b();
        Intrinsics.checkNotNullParameter(r105, "key");
        ((HashMap) ContainerInitialPropsManager.f39126a.getValue()).put(r105, r107);
        r103.appendQueryParameter("__initialProps_data_key", r105);
    L16:
        return r103.build();
    L17:
        return r102;
    }

    public d1(IHybridComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridComponent");
        this.f38646a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e7.n0 r102 = (e7.n0) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = x8.a.f562881a;
        x8.a.d("Annie_OpenJSBMethod", "use open method, params: " + r102, false);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        k(r102);     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L10;
        x8.a.b("Annie_OpenJSBMethod", "Parameters invalid", false);
        OpenResultModel r107 = new OpenResultModel();
        r107.b(r106.getMessage());
        r107.a(OpenResultModel.Code.InvalidParam);
        finishWithResult(r107);
        return;
    L10:
        String r108 = null;
        o(OpenActionStatus.BEFORE_OPEN, r102, null);
        String r109 = r102.e();
        if (r109 == null) goto L19;
        if (StringsKt.startsWith$default(r109, "weixin", false, 2, null) == false) goto L16;
        n(OpenAPPTYPE.WEIXIN, r101);
        return;
    L16:
        if (StringsKt.startsWith$default(r109, "mqq", false, 2, null) == false) goto L19;
        n(OpenAPPTYPE.QQ, r101);
        return;
    L19:
        if (Intrinsics.areEqual(r102.f(), Boolean.TRUE) == false) goto L31;
        OpenActionStatus r110 = OpenActionStatus.AFTER_OPEN;
        String r111 = r102.e();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L26
        Intent r112 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r111));     // Catch: Throwable -> L26
        r112.addFlags(268435456);     // Catch: Throwable -> L26
        r112.addCategory("android.intent.category.BROWSABLE");     // Catch: Throwable -> L26
        Context r113 = r101.getContext();     // Catch: Throwable -> L26
        ResolveInfo r114 = r113.getPackageManager().resolveActivity(r112, 65536);     // Catch: Throwable -> L26
        if (r114 == null) goto L24;
        ActivityInfo r115 = r114.activityInfo;     // Catch: Throwable -> L26
        r112.setClassName(r115.packageName, r115.name);     // Catch: Throwable -> L26
        r113.startActivity(r112);     // Catch: Throwable -> L26
    L49:
    L30:
        o(r110, r102, r108);
        return;
    L24:
        r113.startActivity(r112);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Throwable r117 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r117 == null) goto L30;
        r108 = r117.getMessage();
        goto L30
    L31:
        OpenActionStatus r118 = OpenActionStatus.AFTER_OPEN;
        w9.a r119 = w9.a.f558719a;     // Catch: Throwable -> L41
        Context r120 = r101.getContext();     // Catch: Throwable -> L41
        Uri r121 = j(r102);     // Catch: Throwable -> L41
        View r122 = r101.f249269d;     // Catch: Throwable -> L41
        Map<String, Object> r123 = r102.a();     // Catch: Throwable -> L41
        if (r123 == null) goto L35;
        JSONObject r124 = new JSONObject(r123);     // Catch: Throwable -> L41
    L36:
        if (r119.j0(r120, r121, r122, r124) == true) goto L45;
        r108 = "not schema handler";
    L45:
        o(r118, r102, r108);
        return;
    L35:
        r124 = null;
    L41:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Throwable r126 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r126 == null) goto L45;
        r108 = r126.getMessage();
    L5:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void n(OpenAPPTYPE r100, CallContext r101) {
        int[] r102 = b.f38647a;
        int r103 = r102[r100.ordinal()];
        if (r103 == 1) goto L7;
        if (r103 == 2) goto L6;
        String r104 = "";
    L8:
        int r105 = r102[r100.ordinal()];
        if (r105 == 1) goto L13;
        if (r105 == 2) goto L12;
        String r106 = "";
    L15:
        if (Intrinsics.areEqual(r104, "") == false) goto L19;
        x8.a.b("Annie_OpenJSBMethod", "Parameters invalid", false);
        OpenResultModel r107 = new OpenResultModel();
        r107.b("Parameters invalid");
        r107.a(OpenResultModel.Code.InvalidParam);
        finishWithResult(r107);
        return;
    L19:
        if (ita.k.h(r101.getContext(), r104) == true) goto L21;
        int r108 = x8.a.f562881a;
        x8.a.b("Annie_OpenJSBMethod", r106.concat(" not installed"), false);
        OpenResultModel r109 = new OpenResultModel();
        r109.a(OpenResultModel.Code.Failed);
        r109.b(r106.concat(" not installed"));
        finishWithResult(r109);
    L21:
        Context r110 = r101.getContext();
        if (r110 != null) goto L24;
    L27:
        OpenResultModel r111 = new OpenResultModel();
        r111.a(OpenResultModel.Code.Success);
        r111.b("Success");
        finishWithResult(r111);
        return;
    L24:
        if (StringUtils.isEmpty(r104) == true) goto L27;
        Intent r112 = r110.getPackageManager().getLaunchIntentForPackage(r104);     // Catch: Exception -> L29
        r112.addFlags(268435456);     // Catch: Exception -> L29
        r110.startActivity(r112);     // Catch: Exception -> L29
        goto L27
    L12:
        r106 = Constants.SOURCE_QQ;
        goto L15
    L13:
        r106 = "weixin";
        goto L15
    L6:
        r104 = "com.tencent.mobileqq";
        goto L8
    L7:
        r104 = "com.tencent.mm";
        goto L8
    }

    public final void o(OpenActionStatus r100, e7.n0 r101, String r102) {
        int r103 = b.f38648b[r100.ordinal()];
        if (r103 == 1) goto L23;
        if (r103 != 2) goto L29;
        String r104 = m(r101);
        if (Intrinsics.areEqual(r104, "onlyCloseAfterOpenSucceed") == false) goto L17;
        if (r102 != null) goto L17;
        List<String> r105 = f38645c;
        String r106 = r101.e();
        Intrinsics.checkNotNull(r106);
        String r107 = UriProtector.parse(r106).getHost();
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        if (r105.contains(r107) == true) goto L17;
        l();
    L19:
        if (r102 != null) goto L21;
        finishWithSuccess();
        return;
    L21:
        finishWithFailure();
        return;
    L17:
        if (Intrinsics.areEqual(r104, "alwaysCloseAfterOpen") == false) goto L19;
        l();
        goto L19
    L29:
        return;
    L23:
        if (Intrinsics.areEqual(m(r101), "alwaysCloseBeforeOpen") == false) goto L28;
        l();
        return;
    }
}
