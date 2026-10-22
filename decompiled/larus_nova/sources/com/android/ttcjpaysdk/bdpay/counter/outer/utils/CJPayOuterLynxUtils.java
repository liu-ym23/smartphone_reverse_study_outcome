package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import android.content.Context;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJLynxComponent;
import com.android.ttcjpaysdk.base.service.ICJPayH5Service;
import com.android.ttcjpaysdk.base.service.ICJPayHostService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JO\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOuterLynxUtils;", "", "()V", "TAG", "", "createLynxCard", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "schema", "initialData", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "success", "Lkotlin/Function1;", "Lcom/android/ttcjpaysdk/base/service/ICJLynxComponent;", "Lkotlin/ParameterName;", "name", "component", "isLynxAvailable", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterLynxUtils {
    public static final CJPayOuterLynxUtils INSTANCE = null;
    public static final String TAG = "CJPayOuterLynxUtils";

    static {
        INSTANCE = new CJPayOuterLynxUtils();
    }

    private CJPayOuterLynxUtils() {
    }

    public final boolean isLynxAvailable() {
        ICJPayHostService r100 = (ICJPayHostService) CJPayServiceManager.getInstance().getIService(ICJPayHostService.class);
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isLivePluginAvailable());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public final void createLynxCard(Context r100, String r101, Object r102, ViewGroup r103, Function1<? super ICJLynxComponent, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r104, "success");
        CJLogger.d(TAG, "创建 Lynx 卡片，Schema: " + r101);
        ICJPayH5Service r105 = (ICJPayH5Service) CJPayServiceManager.getInstance().getIService(ICJPayH5Service.class);
        ICJLynxComponent r106 = null;
        if (r105 == null) goto L16;
        ICJLynxComponent r107 = r105.createLynxComponent(r100, r101, r102, new CJPayOuterLynxUtils$createLynxCard$component$1());
        if (r107 == null) goto L16;
        String r108 = UriProtector.parse(r101).getHost();
        boolean r109 = false;
        if (r108 != null) goto L9;
    L11:
        if (r109 == false) goto L13;
        r107.reloadLongSchema();
    L13:
        if (r103 == null) goto L15;
        r103.removeAllViews();
        r103.addView(r107.getCJLynxView(), new ViewGroup.LayoutParams(-1, -2));
    L15:
        r106 = r107;
        goto L16
    L9:
        if (StringsKt.contains$default(r108, "webcast_redirect", false, 2, null) != true) goto L11;
        r109 = true;
    L16:
        if (r106 == null) goto L19;
        CJLogger.d(TAG, "ICJLynxComponent 创建成功");
        r104.invoke(r106);
        return;
    }

    public static /* synthetic */ void createLynxCard$default(CJPayOuterLynxUtils r100, Context r101, String r102, Object r103, ViewGroup r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = null;
    L5:
        r100.createLynxCard(r101, r102, r103, r110, r111);
    }
}
