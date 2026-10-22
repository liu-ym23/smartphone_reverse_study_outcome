package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o extends BaseElement<ip1.f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ElementType f116575c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "elementView");
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return Integer.valueOf(R.layout.ttlive_view_more_panel_element_simple_divider);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116575c;
    }

    public o(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116575c = ElementType.SimpleDivider;
    }

    @Override // kp1.b
    public final void h(lp1.b r100) {
        Intrinsics.checkNotNullParameter((ip1.f) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L5;
        int r101 = 336992291;
    L6:
        View r102 = this.f116543a;
        if (r102 == null) goto L10;
        r102.setBackgroundColor(r101);
        return;
    L10:
        return;
    L5:
        r101 = 352321535;
        goto L6
    }
}
