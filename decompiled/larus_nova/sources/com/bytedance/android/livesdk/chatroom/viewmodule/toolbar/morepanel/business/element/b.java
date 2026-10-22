package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends BaseElement<ip1.b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ElementType f116553c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "elementView");
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116553c;
    }

    public b(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116553c = ElementType.BottomSpace;
    }

    @Override // kp1.b
    public final void h(lp1.b r100) {
        Intrinsics.checkNotNullParameter((ip1.b) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final View j(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = new View(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(40)));
        return r101;
    }
}
