package com.bytedance.android.livesdk.action.instance;

import android.app.Activity;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.w2;
import zg1.x2;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0005H\u0014J\u001e\u0010\u000b\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/action/instance/RechargeDialogAction;", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "Ljava/lang/Void;", "()V", AbsMethodDelegate.TAG_INVOKE, "", "params", "", "", "", "onTerminate", "openPayCancelRecoverDialog", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@ActionMethod("webcast_inroom_chargepanel")
public final class RechargeDialogAction extends BaseActionMethod<Void> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public RechargeDialogAction() {
    }

    private final void openPayCancelRecoverDialog(Map<String, Object> r100) {
        Activity r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.get("pre_order_id");
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        String r104 = "";
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        if (r100 == null) goto L14;
        Object r105 = r100.get("gs");
    L16:
        if ((r105 instanceof String) == true) goto L18;
        r105 = null;
    L18:
        String r106 = (String) r105;
        if (r106 == null) goto L22;
        r104 = r106;
    L22:
        IHostApp r107 = (IHostApp) k.f(IHostApp.class);
        if (r107 == null) goto L25;
        r101 = r107.getCurrentActivity();
    L25:
        w2 r108 = new w2(r103, r104);
        if (r101 == null) goto L29;
        ((IRechargeServiceExternal) k.n(IRechargeServiceExternal.class)).showPayCancelChargePanel(r101, r108);
        return;
    L29:
        return;
    L14:
        r105 = null;
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.get("enter_from");
    L7:
        if ((r101 instanceof String) == true) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        String r103 = "other";
        if (r102 != null) goto L12;
        r102 = "other";
    L12:
        if (r100 == null) goto L14;
        Object r104 = r100.get("click_type");
    L16:
        if ((r104 instanceof String) == true) goto L18;
        r104 = null;
    L18:
        String r105 = (String) r104;
        if (r105 != null) goto L21;
        r105 = "other";
    L21:
        if (r100 == null) goto L23;
        Object r106 = r100.get("charge_reason");
    L25:
        if ((r106 instanceof String) == true) goto L27;
        r106 = null;
    L27:
        String r107 = (String) r106;
        if (r107 == null) goto L32;
        r103 = r107;
    L32:
        if (Intrinsics.areEqual("pay_cancel_recover", r103) == false) goto L34;
        openPayCancelRecoverDialog(r100);
    L35:
        finishWithResult(null);
        return;
    L34:
        xs2.b.a().post(new x2(1, r102, r105, r103));
        goto L35
    L23:
        r106 = null;
        goto L25
    L14:
        r104 = null;
        goto L16
    L5:
        r101 = null;
        goto L7
    }
}
