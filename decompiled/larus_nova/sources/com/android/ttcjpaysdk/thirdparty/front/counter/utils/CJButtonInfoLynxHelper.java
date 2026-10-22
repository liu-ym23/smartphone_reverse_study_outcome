package com.android.ttcjpaysdk.thirdparty.front.counter.utils;

import android.app.Activity;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxFullScreenDialog;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jh\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2(\u0010\u000e\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J \u0010\u0016\u001a\u00020\u00072\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/utils/CJButtonInfoLynxHelper;", "", "()V", "EVENT_NAME_KEY", "", "EVENT_ON_CANCEL_AND_LEAVE", "handleWithLynxIfNeeded", "", "activity", "Landroid/app/Activity;", "buttonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", ControlRule.KEY_EXTRA_DATA, "", "onReceiveEvent", "Lkotlin/Function2;", "", "onFallbackToNative", "Lkotlin/Function0;", "parseLynxPageInfo", "Lorg/json/JSONObject;", TemplateNodeType.RAW, "shouldFallbackToNative", "data", "shouldOpenLynx", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJButtonInfoLynxHelper {
    private static final String EVENT_NAME_KEY = "cjpay_event_name";
    private static final String EVENT_ON_CANCEL_AND_LEAVE = "on_cancel_and_leave";
    public static final CJButtonInfoLynxHelper INSTANCE = null;

    static {
        INSTANCE = new CJButtonInfoLynxHelper();
    }

    private CJButtonInfoLynxHelper() {
    }

    private final boolean shouldFallbackToNative(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L6;
        Object r101 = r100.get("cjpay_event_name");
        if (r101 == null) goto L6;
        String r102 = r101.toString();
    L8:
        return Intrinsics.areEqual(r102, "on_cancel_and_leave");
    L6:
        r102 = null;
        goto L8
    }

    public final JSONObject parseLynxPageInfo(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        return null;
    L27:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = null;
    L19:
        JSONObject r105 = (JSONObject) r104;
        if (r105 != null) goto L22;
        return null;
    L22:
        if (r105.length() <= 0) goto L24;
        r101 = true;
    L24:
        if (r101 == true) goto L26;
        return null;
    L26:
        return r105;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public final boolean shouldOpenLynx(CJPayButtonInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.use_lynx_style, "1") == true) goto L7;
        return false;
    L7:
        if (r100.lynx_url.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        return false;
    L12:
        if (r100.lynx_page_info.length() <= 0) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L21;
        return true;
    L21:
        return false;
    L14:
        r102 = false;
        goto L15
    L9:
        r101 = false;
        goto L10
    }

    public static final /* synthetic */ boolean access$shouldFallbackToNative(CJButtonInfoLynxHelper r100, Map r101) {
        return r100.shouldFallbackToNative(r101);
    }

    public final boolean handleWithLynxIfNeeded(Activity r110, CJPayButtonInfo r111, Map<String, ? extends Object> r112, final Function2<? super String, ? super Map<String, ? extends Object>, Unit> r113, final Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r113, "onReceiveEvent");
        Intrinsics.checkNotNullParameter(r114, "onFallbackToNative");
        String r100 = null;
        if (r111 == null) goto L5;
        String r101 = r111.lynx_page_info;
    L6:
        JSONObject r102 = parseLynxPageInfo(r101);
        if (shouldOpenLynx(r111) == false) goto L20;
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r110.isFinishing() == true) goto L23;
        JSONObject r103 = new JSONObject();
        r103.put("id", "bank_fail_retain_dialog");
        r103.put("lynx_page_info", r102);
        CJPayLynxFullScreenDialog.Companion r104 = CJPayLynxFullScreenDialog.Companion;
        if (r111 == null) goto L15;
        r100 = r111.lynx_url;
    L15:
        if (r100 != null) goto L17;
        String r105 = "";
    L18:
        r104.showDialog(r110, r105, KtSafeMethodExtensionKt.toAnyMap(r103), MapsKt.plus(r112, MapsKt.mapOf(TuplesKt.to(CJPayLynxFullScreenDialog.EXTRA_LISTEN_BACK_PRESSED, Boolean.TRUE))), new AnonymousClass1(r114, r113));
        return true;
    L17:
        r105 = r100;
        goto L18
    L23:
        return false;
    L20:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean handleWithLynxIfNeeded$default(CJButtonInfoLynxHelper r100, Activity r101, CJPayButtonInfo r102, Map r103, Function2 r110, Function0 r111, int r112, Object r113) {
        if ((r112 & 4) == 0) goto L6;
        r103 = MapsKt.emptyMap();
    L6:
        return r100.handleWithLynxIfNeeded(r101, r102, r103, r110, r111);
    }
}
