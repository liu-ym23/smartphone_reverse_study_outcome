package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends SingleLineScrollElement {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ElementType f116554f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f116554f;
    }

    public c(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(r100);
        this.f116554f = ElementType.Extend;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement, kp1.b
    public final /* bridge */ /* synthetic */ void h(lp1.b r100) {
        m((ip1.d) r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement
    public final void m(ip1.d r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super.m(r100);
        if (r100.f495264c < 2) goto L15;
        MoreMixSharePanelUtils r101 = MoreMixSharePanelUtils.INSTANCE;
        DataCenter r102 = this.f116549e.getDataCenter();
        boolean r103 = false;
        if (r102 == null) goto L7;
        r103 = z.e(r102, false);
    L7:
        DataCenter r104 = this.f116549e.getDataCenter();
        boolean r105 = true;
        if (r104 == null) goto L11;
        r105 = z.m(r104, true);
    L11:
        if (r101.isMoreMixShareMode(r103, r105) == false) goto L15;
        View r106 = this.f116543a;
        if (r106 == null) goto L19;
        a1.o(r106, UtilityKotlinExtentionsKt.i(16));
        return;
    L19:
        return;
    L15:
        View r107 = this.f116543a;
        if (r107 == null) goto L21;
        a1.o(r107, UtilityKotlinExtentionsKt.i(12));
        return;
    }
}
