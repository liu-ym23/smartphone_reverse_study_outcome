package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements kp1.b<ip1.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ElementType f116586a;

    @Override // kp1.b
    public final View c(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return null;
    }

    @Override // kp1.b
    public final View e() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116586a;
    }

    public x(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f116586a = ElementType.Unknown;
    }

    @Override // kp1.b
    public final void h(lp1.b r100) {
        Intrinsics.checkNotNullParameter((ip1.g) r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }
}
