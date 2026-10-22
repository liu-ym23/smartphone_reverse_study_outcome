package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends ActionRateListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f45176j;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.monitor.listener.a$a, reason: collision with other inner class name */
    public static final class C0807a {
    }

    static {
    }

    public a(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "fullFill");
        super(r100, "add_2_cart", r101);
        this.f45176j = r101;
    }

    public final void j(boolean r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("use_new_api", r100);
        r102.put("scene_type", r101);
        Unit r103 = Unit.INSTANCE;
        ActionRateListener.c(this, r102, null, false, 6);
    }

    public static void k(a r100, int r101, String r110, Integer r111, String r112, int r113) {
        String r102 = null;
        if ((r113 & 2) == 0) goto L6;
        r110 = null;
    L6:
        if ((r113 & 4) == 0) goto L9;
        r111 = null;
    L9:
        if ((r113 & 8) == 0) goto L11;
        r112 = null;
    L11:
        switch(r101) {
            case -7: goto L19;
            case -6: goto L18;
            case -5: goto L17;
            case -4: goto L16;
            case -3: goto L15;
            case -2: goto L14;
            case -1: goto L13;
            default: goto L12;
        };
    L12:
        String r114 = "";
    L20:
        Set<String> r103 = ECProcessMonitor.f45118a;
        String r104 = r100.f45172g;
        String r105 = r100.f45173h;
        Integer r106 = Integer.valueOf(r101);
        if (r110 != null) goto L23;
    L31:
        String r107 = r114;
    L32:
        JSONObject r108 = r100.f45167b;
        if (r111 == null) goto L35;
        r108.put("status_code_sku", r111.intValue());
    L35:
        if (r112 == null) goto L37;
        r108.put("status_message_sku", r112);
    L37:
        Unit r109 = Unit.INSTANCE;
        ECProcessMonitor.n(r100, r104, r105, r106, r107, r108);
        r100.f45176j.invoke();
        return;
    L23:
        if (r110.length() <= 0) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L28;
        r102 = r110;
    L28:
        if (r102 == null) goto L31;
        r107 = r102;
        goto L32
    L25:
        r115 = false;
        goto L26
    L13:
        r114 = "单sku加购common_skus接口请求失败";
        goto L20
    L14:
        r114 = "缺少必要参数如comboId/promotionId/productId，端上拦截";
        goto L20
    L15:
        r114 = "法务检查失败";
        goto L20
    L16:
        r114 = "置灰后无法点击";
        goto L20
    L17:
        r114 = "加购接口请求失败";
        goto L20
    L18:
        r114 = "当前选择数量为0";
        goto L20
    L19:
        r114 = "SkuInfo为空";
        goto L20
    }
}
