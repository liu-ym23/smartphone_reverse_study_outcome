package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends ActionRateListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f45181k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f45182j;

    public static final class a {
    }

    static {
    }

    public final void k() {
        Set<String> r100 = ECProcessMonitor.f45118a;
        String r101 = this.f45172g;
        String r102 = this.f45173h;
        JSONObject r103 = this.f45167b;
        JSONObject r104 = this.f45168c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter("inner_start", "rateType");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "actionName");
        boolean r105 = this.f45166a;
        if (r103 == null) goto L5;
        JSONObject r106 = x0.a(r103);
    L6:
        r106.put("event_type", "rate");
        r106.put("page_name", r101);
        r106.put("action_name", r102);
        r106.put("rate_type", "inner_start");
        Unit r107 = Unit.INSTANCE;
        JSONObject r108 = r106;
        ECProcessMonitor.i(r105, 0, "ec_full_trade_process_monitor", r108, null, r104, ECProcessMonitor.r(r101, ""));
        this.f45169d = System.currentTimeMillis();
        return;
    L5:
        r106 = new JSONObject();
        goto L6
    }

    public e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "fullFill");
        super("ec_sku", CheckPointType.ENTER_PAGE, r100);
        this.f45182j = r100;
        this.f45170e = false;
    }

    public final void j(Integer r110, String r111) {
        if (r110 != null) goto L5;
    L7:
        if (r110 != null) goto L10;
    L12:
        if (r110 != null) goto L15;
    L17:
        if (r110 != null) goto L20;
    L22:
        if (r110 != null) goto L25;
    L27:
        String r100 = "";
    L28:
        Set<String> r101 = ECProcessMonitor.f45118a;
        String r102 = this.f45172g;
        String r103 = this.f45173h;
        if (r111 != null) goto L31;
    L40:
        String r104 = r100;
    L41:
        ECProcessMonitor.m(this, r102, r103, r110, r104, this.f45167b, this.f45168c);
        this.f45182j.invoke();
        return;
    L31:
        if (r111.length() <= 0) goto L33;
        boolean r105 = true;
    L34:
        if (r105 == true) goto L37;
        r111 = null;
    L37:
        if (r111 == null) goto L40;
        r104 = r111;
        goto L41
    L33:
        r105 = false;
        goto L34
    L25:
        if (r110.intValue() != (-1)) goto L27;
        r100 = "sku主接口请求出错";
        goto L28
    L20:
        if (r110.intValue() != (-5)) goto L22;
        r100 = "entrance_info解析出错";
        goto L28
    L15:
        if (r110.intValue() != (-4)) goto L17;
        r100 = "不支持加入购物车";
        goto L28
    L10:
        if (r110.intValue() != (-2)) goto L12;
        r100 = "入参合法性检查失败";
        goto L28
    L5:
        if (r110.intValue() != (-3)) goto L7;
        r100 = "法务检查失败";
        goto L28
    }
}
