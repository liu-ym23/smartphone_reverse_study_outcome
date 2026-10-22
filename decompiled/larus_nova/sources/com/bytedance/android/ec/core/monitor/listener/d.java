package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends ActionRateListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f45179k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f45180j;

    public static final class a {
    }

    static {
    }

    public d(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "fullFill");
        super("ec_product_detail", CheckPointType.ENTER_PAGE, r100);
        this.f45180j = r100;
    }

    public final void j(int r100, String r110) {
        switch(r100) {
            case -6: goto L9;
            case -5: goto L8;
            case -4: goto L7;
            case -3: goto L6;
            case -2: goto L5;
            case -1: goto L4;
            default: goto L3;
        };
    L3:
        String r101 = "";
    L10:
        Set<String> r102 = ECProcessMonitor.f45118a;
        String r103 = this.f45172g;
        String r104 = this.f45171f;
        if (r104 != null) goto L13;
        r104 = this.f45173h;
    L13:
        String r105 = r104;
        Integer r106 = Integer.valueOf(r100);
        if (r110 != null) goto L16;
    L25:
        String r107 = r101;
    L26:
        ECProcessMonitor.n(this, r103, r105, r106, r107, this.f45167b);
        this.f45180j.invoke();
        return;
    L16:
        if (r110.length() <= 0) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L22;
        r110 = null;
    L22:
        if (r110 == null) goto L25;
        r107 = r110;
        goto L26
    L18:
        r108 = false;
        goto L19
    L4:
        r101 = "反爬验证码弹窗";
        goto L10
    L5:
        r101 = "入参合法性检查失败";
        goto L10
    L6:
        r101 = "商详实例生成/打开失败";
        goto L10
    L7:
        r101 = "用户未登录";
        goto L10
    L8:
        r101 = "法务弹窗";
        goto L10
    L9:
        r101 = "页面曝光前用户主动退出商详";
        goto L10
    }
}
