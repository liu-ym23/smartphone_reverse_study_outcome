package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.bytedance.android.live.browser.jsbridge.base.AlertCheckDialogResultModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "alertCheckDialog")
public final class h0 extends w20.g<w20.l7, AlertCheckDialogResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f63407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f63408b;

    public h0() {
    }

    public static final void j(h0 r100) {
        r100.getClass();
        AlertCheckDialogResultModel r101 = new AlertCheckDialogResultModel();
        r101.a(AlertCheckDialogResultModel.Code.Success);
        AlertCheckDialogResultModel.a r102 = new AlertCheckDialogResultModel.a();
        r102.c(Boolean.FALSE);
        r102.a(Boolean.TRUE);
        r102.b(Boolean.valueOf(r100.f63407a));
        Unit r103 = Unit.INSTANCE;
        r101.b(r102);
        r100.finishWithResult(r101);
        r100.f63408b = true;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.l7 r112 = (w20.l7) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callcontext");
        boolean r100 = false;
        this.f63407a = false;
        this.f63408b = false;
        Context r113 = r111.getContext();
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r113 == null) goto L50;
        View r101 = LayoutInflater.from(r113).inflate(R.layout.ttlive_dialog_alert_with_radio, null);
        TextView r102 = (TextView) r101.findViewById(R.id.alert_dialog_title);
        TextView r103 = (TextView) r101.findViewById(R.id.alert_content);
        View r104 = r101.findViewById(R.id.alert_check_area);
        ToggleButton r105 = (ToggleButton) r101.findViewById(R.id.alert_check_toggle);
        TextView r106 = (TextView) r101.findViewById(R.id.alert_check_content);
        if (r112.f() == null) goto L16;
        String r107 = r112.f();
        if (r107 == null) goto L16;
        if (r107.length() <= 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 != true) goto L16;
        UtilityKotlinExtentionsKt.w(r102);
        r102.setText(r112.f());
        goto L16
    L12:
        r108 = false;
    L16:
        if (r112.d() == null) goto L26;
        String r109 = r112.d();
        if (r109 == null) goto L26;
        if (r109.length() <= 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 != true) goto L26;
        UtilityKotlinExtentionsKt.w(r103);
        r103.setText(r112.d());
        goto L26
    L22:
        r114 = false;
    L26:
        if (r112.b() == null) goto L39;
        String r115 = r112.b();
        if (r115 == null) goto L39;
        if (r115.length() <= 0) goto L32;
        boolean r116 = true;
    L33:
        if (r116 != true) goto L39;
        UtilityKotlinExtentionsKt.w(r104);
        r106.setText(r112.b());
        Boolean r117 = r112.e();
        if (r117 == null) goto L37;
        boolean r118 = r117.booleanValue();
    L38:
        this.f63407a = r118;
        r105.setChecked(r118);
        r105.setOnCheckedChangeListener(new d0(this, r101));
        goto L39
    L37:
        r118 = false;
        goto L38
    L32:
        r116 = false;
    L39:
        ArrayList r119 = new ArrayList();
        if (r112.a() == null) goto L48;
        String r120 = r112.a();
        if (r120 == null) goto L48;
        if (r120.length() <= 0) goto L46;
        r100 = true;
    L46:
        if (r100 != true) goto L48;
        lm3.c r121 = new lm3.c();
        r121.f509864b = r112.a();
        r121.f509865c = new e0(this);
        r119.add(r121);
    L48:
        lm3.c r122 = new lm3.c();
        r122.f509864b = r112.c();
        r122.f509865c = new f0(this);
        r119.add(r122);
        lm3.d.a r123 = new lm3.d.a(r113);
        r123.f509873d = r101;
        r123.f509874e = r119;
        r123.a().setOnDismissListener(new g0(this));
        return;
    }
}
