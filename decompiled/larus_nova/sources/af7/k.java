package af7;

import android.app.Activity;
import android.view.Window;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.BackPressConfig;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PopupConfig;
import com.bytedance.sdk.xbridge.cn.ui.utils.NaviUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.setContainer")
public final class k extends bf7.a {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public k() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r210, CompletionBlock r211) {
        bf7.a.f r100 = (bf7.a.f) r210;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r211, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        ia.c r103 = com.bytedance.android.anniex.lite.utils.c.f(r110);
        boolean r104 = true;
        if (r103 != null) goto L8;
        bf7.a.d r105 = r100.getPageUI();
        if (r105 == null) goto L74;
        String r106 = r105.getTitle();
    L75:
        bf7.a.d r107 = r100.getPageUI();
        if (r107 == null) goto L78;
        String r108 = r107.getTitleColor();
    L79:
        bf7.a.d r109 = r100.getPageUI();
        if (r109 == null) goto L82;
        String r111 = r109.getNavBarColor();
    L83:
        bf7.a.d r112 = r100.getPageUI();
        if (r112 == null) goto L86;
        String r113 = r112.getStatusBarBgColor();
    L87:
        bf7.a.d r114 = r100.getPageUI();
        if (r114 == null) goto L90;
        String r115 = r114.getStatusFontMode();
    L91:
        bf7.a.c r116 = r100.getPageInteraction();
        if (r116 == null) goto L94;
        String r117 = r116.getNavBtnType();
    L95:
        bf7.a.c r118 = r100.getPageInteraction();
        if (r118 == null) goto L98;
        Number r119 = r118.getShouldFullScreen();
    L99:
        bf7.a.e r120 = r100.getPopupInteraction();
        if (r120 == null) goto L102;
        Number r121 = r120.getDisableMaskClickClose();
    L103:
        bf7.a.e r122 = r100.getPopupInteraction();
        if (r122 == null) goto L106;
        Number r123 = r122.getEnablePullDownClose();
    L107:
        bf7.a.e r124 = r100.getPopupInteraction();
        if (r124 == null) goto L110;
        Number r125 = r124.getEnableInterceptTouchEvent();
    L111:
        bf7.a.b r126 = r100.getCommonInteraction();
        if (r126 == null) goto L114;
        Number r127 = r126.getDisableBackPress();
    L115:
        int r128 = NaviUtils.f270248a;
        PageTitleBar r129 = new PageTitleBar(r106, com.bytedance.sdk.xbridge.cn.ui.utils.a.e(r108), com.bytedance.sdk.xbridge.cn.ui.utils.a.e(r111), r117);
        if (r119 == null) goto L118;
        Integer r130 = Integer.valueOf(r119.intValue());
    L119:
        Intrinsics.checkNotNullParameter(r129, "titleBar");
        ia.c r131 = com.bytedance.android.anniex.container.util.b.a(r110);
        if (r131 != null) goto L122;
        ia.c r132 = com.bytedance.android.anniex.container.util.b.b(r110);
        if (r132 != null) goto L143;
        if (r115 == null) goto L154;
        if (r102 == null) goto L152;
        Window r133 = r102.getWindow();
    L153:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.i(r102, r133, Intrinsics.areEqual("dark", r115));
        goto L154
    L152:
        r133 = null;
    L154:
        com.bytedance.sdk.xbridge.cn.ui.utils.a.f(r102, r113);
        IHostStyleUIDepend r134 = com.bytedance.sdk.xbridge.cn.utils.g.h(r110);
        if (r134 == null) goto L157;
        r134.setPageNaviStyle(r110, r102, r129);
    L157:
        NaviUtils.b(r102, r130, r115);
    L159:
        if (r121 == null) goto L161;
        Integer r135 = Integer.valueOf(r121.intValue());
    L162:
        if (r123 == null) goto L164;
        Integer r136 = Integer.valueOf(r123.intValue());
    L165:
        if (r125 == null) goto L167;
        Integer r137 = Integer.valueOf(r125.intValue());
    L168:
        NaviUtils.a(r110, r102, new PopupConfig(r135, r136, r137));
        if (r127 == null) goto L171;
        Integer r138 = Integer.valueOf(r127.intValue());
    L172:
        Integer r139 = new BackPressConfig(r138).getDisableBackPress();
        if (r139 == null) goto L187;
        int r140 = r139.intValue();
        ia.c r141 = com.bytedance.android.anniex.container.util.b.a(r110);
        if (r141 == null) goto L181;
        if (r140 == 1) goto L179;
        r104 = false;
    L179:
        r141.interceptBackPress(r104);
        goto L187
    L181:
        if ((r102 instanceof AbsBulletContainerActivity) == false) goto L187;
        AbsBulletContainerActivity r142 = (AbsBulletContainerActivity) r102;
        if (r140 != 1) goto L186;
        r104 = false;
    L186:
        r142.f248186z = r104;
    L187:
        CompletionBlock.DefaultImpls.onSuccess$default(r211, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(bf7.a.g.class)), null, 2, null);
        return;
    L171:
        r138 = null;
        goto L172
    L167:
        r137 = null;
        goto L168
    L164:
        r136 = null;
        goto L165
    L161:
        r135 = null;
        goto L162
    L143:
        if ((r132 instanceof ia.g) == false) goto L159;
        ia.g r143 = (ia.g) r132;
        if (r115 == null) goto L147;
        r143.setStatusFontMode(r115);
    L147:
        if (r113 == null) goto L159;
        r143.c(r113);
        goto L159
    L122:
        if ((r131 instanceof ia.h) == false) goto L133;
        ia.h r144 = (ia.h) r131;
        String r145 = r129.getTitle();
        if (r145 == null) goto L126;
        r144.setTitle(r145);
    L126:
        String r146 = r129.getTitleColor();
        if (r146 == null) goto L129;
        r144.p(r146);
    L129:
        String r147 = r129.getNavBarColor();
        if (r147 == null) goto L133;
        r144.e(r147);
    L133:
        if ((r131 instanceof ia.g) == false) goto L139;
        ia.g r148 = (ia.g) r131;
        if (r115 == null) goto L137;
        r148.setStatusFontMode(r115);
    L137:
        if (r113 == null) goto L139;
        r148.c(r113);
    L139:
        NaviUtils.b(r102, r130, r115);
        goto L159
    L118:
        r130 = null;
        goto L119
    L114:
        r127 = null;
        goto L115
    L110:
        r125 = null;
        goto L111
    L106:
        r123 = null;
        goto L107
    L102:
        r121 = null;
        goto L103
    L98:
        r119 = null;
        goto L99
    L94:
        r117 = null;
        goto L95
    L90:
        r115 = null;
        goto L91
    L86:
        r113 = null;
        goto L87
    L82:
        r111 = null;
        goto L83
    L78:
        r108 = null;
        goto L79
    L74:
        r106 = null;
        goto L75
    L8:
        if ((r103 instanceof ia.h) == false) goto L30;
        bf7.a.d r149 = r100.getPageUI();
        if (r149 == null) goto L14;
        String r150 = r149.getTitle();
        if (r150 == null) goto L14;
        ((ia.h) r103).setTitle(r150);
    L14:
        bf7.a.d r151 = r100.getPageUI();
        if (r151 == null) goto L19;
        String r152 = r151.getTitleColor();
        if (r152 == null) goto L19;
        ((ia.h) r103).p(r152);
    L19:
        bf7.a.d r153 = r100.getPageUI();
        if (r153 == null) goto L24;
        String r154 = r153.getNavBarColor();
        if (r154 == null) goto L24;
        ((ia.h) r103).e(r154);
    L24:
        bf7.a.c r155 = r100.getPageInteraction();
        if (r155 == null) goto L30;
        Number r156 = r155.getShouldFullScreen();
        if (r156 == null) goto L30;
        ((ia.h) r103).f(!Intrinsics.areEqual(r156, 1));
    L30:
        if ((r103 instanceof ia.g) == false) goto L46;
        bf7.a.d r157 = r100.getPageUI();
        if (r157 == null) goto L36;
        String r158 = r157.getStatusBarBgColor();
        if (r158 == null) goto L36;
        ((ia.g) r103).c(r158);
    L36:
        bf7.a.d r159 = r100.getPageUI();
        if (r159 == null) goto L41;
        String r160 = r159.getStatusFontMode();
        if (r160 == null) goto L41;
        ((ia.g) r103).setStatusFontMode(r160);
    L41:
        bf7.a.c r161 = r100.getPageInteraction();
        if (r161 == null) goto L46;
        Number r162 = r161.getShouldFullScreen();
        if (r162 == null) goto L46;
        ((ia.g) r103).n(Intrinsics.areEqual(r162, 1));
    L46:
        bf7.a.b r163 = r100.getCommonInteraction();
        if (r163 == null) goto L52;
        Number r164 = r163.getDisableBackPress();
        if (r164 == null) goto L52;
        r103.interceptBackPress(Intrinsics.areEqual(r164, 1));
    L52:
        if ((r103 instanceof ia.f) == false) goto L59;
        bf7.a.e r165 = r100.getPopupInteraction();
        if (r165 == null) goto L59;
        Number r166 = r165.getEnableInterceptTouchEvent();
        if (r166 == null) goto L59;
        ((ia.f) r103).m(Intrinsics.areEqual(r166, 1));
    L59:
        if ((r103 instanceof ua.d) == false) goto L70;
        bf7.a.e r167 = r100.getPopupInteraction();
        if (r167 == null) goto L65;
        Number r168 = r167.getDisableMaskClickClose();
        if (r168 == null) goto L65;
        ((ua.d) r103).f549232e.w(!Intrinsics.areEqual(r168, 1));
    L65:
        bf7.a.e r169 = r100.getPopupInteraction();
        if (r169 == null) goto L70;
        Number r170 = r169.getEnablePullDownClose();
        if (r170 == null) goto L70;
        ((ua.d) r103).f549232e.v(Intrinsics.areEqual(r170, 1));
    L70:
        CompletionBlock.DefaultImpls.onSuccess$default(r211, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(bf7.a.g.class)), null, 2, null);
    }
}
