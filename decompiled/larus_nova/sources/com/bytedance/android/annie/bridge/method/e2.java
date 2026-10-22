package com.bytedance.android.annie.bridge.method;

import android.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.SetContainerResultModel;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setContainer")
public final class e2 extends com.bytedance.android.annie.bridge.d<com.bytedance.android.annie.bridge.s, SetContainerResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HybridFragment f38652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.annie.container.fragment.p f38653b;

    public e2(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        HybridFragment r101 = (HybridFragment) r100.c(HybridFragment.class);
        if (r101 == null) goto L5;
        this.f38652a = r101;
    L5:
        com.bytedance.android.annie.container.fragment.p r102 = (com.bytedance.android.annie.container.fragment.p) r100.c(com.bytedance.android.annie.container.fragment.p.class);
        if (r102 == null) goto L9;
        this.f38653b = r102;
    L9:
        if (this.f38652a != null) goto L12;
        this.f38652a = new AnnieFragment();
        return;
    }

    public e2(HybridFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f38652a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        com.bytedance.android.annie.bridge.s r101 = (com.bytedance.android.annie.bridge.s) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.annie.bridge.s.b r111 = r101.b();
        boolean r102 = false;
        HybridDialog r103 = null;
        if (r111 == null) goto L96;
        HybridFragment r104 = this.f38652a;
        if (r104 == null) goto L7;
        Fragment r105 = r104.getParentFragment();
    L9:
        if ((r105 instanceof BaseDialogFragment) == false) goto L12;
        SetContainerResultModel r106 = new SetContainerResultModel();
        r106.a(SetContainerResultModel.Code.Failed);
        r106.b("must use pageUI under fullscreen scene");
        finishWithResult(r106);
        return;
    L12:
        if (this.f38653b == null) goto L15;
        SetContainerResultModel r107 = new SetContainerResultModel();
        r107.a(SetContainerResultModel.Code.Failed);
        r107.b("must use pageUI under fullscreen scene");
        finishWithResult(r107);
        return;
    L15:
        if (r111.f() == null) goto L20;
        HybridFragment r108 = this.f38652a;
        if (r108 == null) goto L20;
        r108.setHybridTitle(r111.f());
    L20:
        if (r111.g() == null) goto L25;
        HybridFragment r109 = this.f38652a;
        if (r109 == null) goto L25;
        r109.setHybridTitleColor(r111.g());
    L25:
        if (r111.b() == null) goto L30;
        HybridFragment r112 = this.f38652a;
        if (r112 == null) goto L30;
        r112.setHybridNavBarColor(r111.b());
    L30:
        if (r111.c() == null) goto L35;
        HybridFragment r113 = this.f38652a;
        if (r113 == null) goto L35;
        r113.setHybridStatusBarBgColor(r111.c());
    L35:
        if (r111.e() == null) goto L40;
        HybridFragment r114 = this.f38652a;
        if (r114 == null) goto L40;
        r114.setHybridStatusFontMode(r111.e());
    L40:
        if ((r111.d() instanceof Number) == false) goto L71;
        Integer r115 = r111.d();
        if (r115 != null) goto L45;
    L58:
        Integer r116 = r111.d();
        if (r116 == null) goto L71;
        if (r116.intValue() != 0) goto L71;
        int r117 = com.bytedance.android.annie.util.u.f40077a;
        HybridFragment r118 = this.f38652a;
        if (r118 == null) goto L66;
        FragmentActivity r119 = r118.getActivity();
    L67:
        if (r119 == null) goto L71;
        r119.getWindow().clearFlags(1024);
        Intrinsics.checkNotNullParameter(r119, "activity");
        r119.getWindow().setStatusBarColor(r119.getResources().getColor(R.color.transparent));
        goto L71
    L66:
        r119 = null;
        goto L67
    L45:
        if (r115.intValue() != 1) goto L58;
        int r120 = com.bytedance.android.annie.util.u.f40077a;
        HybridFragment r121 = this.f38652a;
        if (r121 == null) goto L49;
        FragmentActivity r122 = r121.getActivity();
    L50:
        if (r122 == null) goto L53;
        r122.getWindow().setFlags(1024, 1024);
        Intrinsics.checkNotNullParameter(r122, "activity");
        r122.getWindow().setStatusBarColor(r122.getResources().getColor(R.color.transparent));
    L53:
        HybridFragment r123 = this.f38652a;
        if (r123 == null) goto L56;
        FragmentActivity r124 = r123.getActivity();
    L57:
        com.bytedance.android.annie.container.fragment.n.g(r124, "");
        goto L71
    L56:
        r124 = null;
        goto L57
    L49:
        r122 = null;
    L71:
        if (r111.a() == null) goto L96;
        Integer r125 = r111.a();
        if (r125 != null) goto L76;
    L84:
        Integer r126 = r111.a();
        if (r126 == null) goto L96;
        if (r126.intValue() != 0) goto L96;
        int r127 = com.bytedance.android.annie.util.u.f40077a;
        HybridFragment r128 = this.f38652a;
        if (r128 == null) goto L92;
        FragmentActivity r129 = r128.getActivity();
    L93:
        if (r129 == null) goto L96;
        com.bytedance.android.annie.util.u.a(r129.getWindow()).setSystemUiVisibility(0);
        goto L96
    L92:
        r129 = null;
        goto L93
    L76:
        if (r125.intValue() != 1) goto L84;
        int r130 = com.bytedance.android.annie.util.u.f40077a;
        HybridFragment r131 = this.f38652a;
        if (r131 == null) goto L80;
        FragmentActivity r132 = r131.getActivity();
    L81:
        if (r132 == null) goto L96;
        com.bytedance.android.annie.util.u.a(r132.getWindow()).setSystemUiVisibility(4098);
        goto L96
    L80:
        r132 = null;
        goto L81
    L7:
        r105 = null;
    L96:
        com.bytedance.android.annie.bridge.s.a r133 = r101.a();
        if (r133 != null) goto L99;
    L138:
        com.bytedance.android.annie.bridge.s.c r134 = r101.c();
        if (r134 == null) goto L200;
        HybridFragment r135 = this.f38652a;
        if (r135 == null) goto L143;
        Fragment r136 = r135.getParentFragment();
    L145:
        if ((r136 instanceof BaseDialogFragment) == true) goto L148;
        SetContainerResultModel r137 = new SetContainerResultModel();
        r137.a(SetContainerResultModel.Code.Failed);
        r137.b("must use popupInteraction under dialog scene");
        finishWithResult(r137);
        return;
    L148:
        if (this.f38653b != null) goto L151;
        SetContainerResultModel r138 = new SetContainerResultModel();
        r138.a(SetContainerResultModel.Code.Failed);
        r138.b("must use popupInteraction under dialog scene");
        finishWithResult(r138);
        return;
    L151:
        if ((r134.a() instanceof Number) == false) goto L177;
        HybridFragment r139 = this.f38652a;
        if (r139 == null) goto L155;
        Fragment r140 = r139.getParentFragment();
    L157:
        if ((r140 instanceof HybridDialog) == false) goto L159;
        HybridDialog r141 = (HybridDialog) r140;
    L160:
        if (r141 != null) goto L162;
    L166:
        Object r142 = this.f38653b;
        if ((r142 instanceof HybridDialog) == false) goto L169;
        HybridDialog r143 = (HybridDialog) r142;
    L170:
        if (r143 == null) goto L177;
        if (r134.a().intValue() == 1) goto L174;
        boolean r144 = true;
    L175:
        r143.U90(r144);
        goto L177
    L174:
        r144 = false;
        goto L175
    L169:
        r143 = null;
        goto L170
    L162:
        if (r134.a().intValue() == 1) goto L164;
        boolean r145 = true;
    L165:
        r141.U90(r145);
        goto L166
    L164:
        r145 = false;
        goto L165
    L159:
        r141 = null;
        goto L160
    L155:
        r140 = null;
    L177:
        if ((r134.b() instanceof Number) == false) goto L200;
        HybridFragment r146 = this.f38652a;
        if (r146 == null) goto L181;
        Fragment r147 = r146.getParentFragment();
    L183:
        if ((r147 instanceof HybridDialog) == false) goto L185;
        HybridDialog r148 = (HybridDialog) r147;
    L186:
        if (r148 != null) goto L188;
    L192:
        Object r149 = this.f38653b;
        if ((r149 instanceof HybridDialog) == false) goto L195;
        r103 = (HybridDialog) r149;
    L195:
        if (r103 == null) goto L200;
        if (r134.b().intValue() != 1) goto L199;
        r102 = true;
    L199:
        r103.Y90(r102);
        goto L200
    L188:
        if (r134.b().intValue() != 1) goto L190;
        boolean r150 = true;
    L191:
        r148.Y90(r150);
        goto L192
    L190:
        r150 = false;
        goto L191
    L185:
        r148 = null;
        goto L186
    L181:
        r147 = null;
        goto L183
    L143:
        r136 = null;
    L200:
        SetContainerResultModel r151 = new SetContainerResultModel();
        r151.a(SetContainerResultModel.Code.Success);
        finishWithResult(r151);
        return;
    L99:
        if ((r133.b() instanceof Boolean) == false) goto L107;
        HybridFragment r152 = this.f38652a;
        if (r152 == null) goto L103;
        r152.enableClose(!Intrinsics.areEqual(r133.b(), Boolean.TRUE));
    L103:
        com.bytedance.android.annie.container.fragment.p r153 = this.f38653b;
        if (r153 == null) goto L107;
        r153.enableClose(!Intrinsics.areEqual(r133.b(), Boolean.TRUE));
    L107:
        if ((r133.b() instanceof Number) == false) goto L123;
        HybridFragment r154 = this.f38652a;
        if (r154 != null) goto L111;
    L115:
        com.bytedance.android.annie.container.fragment.p r155 = this.f38653b;
        if (r155 == null) goto L123;
        if (((Number) r133.b()).intValue() == 1) goto L120;
        boolean r156 = true;
    L121:
        r155.enableClose(r156);
        goto L123
    L120:
        r156 = false;
        goto L121
    L111:
        if (((Number) r133.b()).intValue() == 1) goto L113;
        boolean r157 = true;
    L114:
        r154.enableClose(r157);
        goto L115
    L113:
        r157 = false;
    L123:
        if ((r133.a() instanceof Number) == false) goto L138;
        HybridFragment r158 = this.f38652a;
        if (r158 != null) goto L127;
    L131:
        com.bytedance.android.annie.container.fragment.p r159 = this.f38653b;
        if (r159 == null) goto L138;
        if (r133.a().intValue() == 1) goto L136;
        boolean r160 = true;
    L137:
        r159.setCloseByGesture(r160);
        goto L138
    L136:
        r160 = false;
        goto L137
    L127:
        if (r133.a().intValue() == 1) goto L129;
        boolean r161 = true;
    L130:
        r158.setCloseByGesture(r161);
        goto L131
    L129:
        r161 = false;
        goto L130
    }
}
