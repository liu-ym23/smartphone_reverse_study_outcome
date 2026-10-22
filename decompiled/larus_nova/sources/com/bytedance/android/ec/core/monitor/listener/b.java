package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends ActionRateListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f45177j;

    public static final class a {
    }

    static {
    }

    public final void j(BuyNowNextPage r100) {
        Intrinsics.checkNotNullParameter(r100, "nextPage");
        JSONObject r101 = this.f45167b;
        r101.put("next_page", r100.getValue());
        Unit r102 = Unit.INSTANCE;
        ActionRateListener.c(this, r101, null, false, 6);
    }

    public b(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "fullFill");
        super(r100, "buy_now", r101);
        this.f45177j = r101;
    }

    public static void k(b r100, int r101, String r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if (r101 != (-4)) goto L8;
        String r112 = "懂车帝商品必须选择门店才能跳转提单";
    L18:
        Set<String> r102 = ECProcessMonitor.f45118a;
        String r103 = r100.f45172g;
        String r104 = r100.f45173h;
        Integer r105 = Integer.valueOf(r101);
        if (r110 != null) goto L21;
    L30:
        String r106 = r112;
    L31:
        JSONObject r107 = r100.f45167b;
        r107.put("log_id", null);
        Unit r108 = Unit.INSTANCE;
        ECProcessMonitor.n(r100, r103, r104, r105, r106, r107);
        r100.f45177j.invoke();
        return;
    L21:
        if (r110.length() <= 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == true) goto L27;
        r110 = null;
    L27:
        if (r110 == null) goto L30;
        r106 = r110;
        goto L31
    L23:
        r109 = false;
        goto L24
    L8:
        if (r101 != (-3)) goto L10;
        r112 = "法务检查失败";
        goto L18
    L10:
        if (r101 != (-2)) goto L12;
        r112 = "joinMemberUrl为空";
        goto L18
    L12:
        if (r101 == (-1)) goto L14;
        r112 = "";
        goto L18
    L14:
        r112 = "请下载抖音正式版体验";
        goto L18
    }
}
