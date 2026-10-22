package ak2;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCouponV2;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements com.bytedance.android.livesdk.livecommerce.room.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3986a;

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void B() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void I(com.bytedance.android.livesdk.livecommerce.room.controller.business.q.b r100) {
        Intrinsics.checkNotNullParameter(r100, "loadFilter");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void J(com.bytedance.android.livesdk.livecommerce.room.controller.business.a.d r100) {
        Intrinsics.checkNotNullParameter(r100, "loadFilter");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final g F() {
        xd.g r100 = xd.g.f563267a;
        Intrinsics.checkNotNullParameter(r100, "id");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L7;
        return new g(((td.d) r101).F());
    L7:
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L11;
        Intrinsics.checkNotNullParameter(r100, "$this$live");
        return new g(((ILiveRoomViewHandler) r101).findViewGroupById(StartLivePreviewButton.INSTANCE));
    L11:
        throw new IllegalArgumentException("handler is not IECLiveRoomViewHandler or ILiveRoomViewHandler");
    }

    public j(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f3986a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void C(ShoppingCart r100) {
        xd.i r101 = xd.i.f563269a;
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        Object r102 = this.f3986a;
        if ((r102 instanceof td.d) == false) goto L6;
        ((td.d) r102).C(r100);
        return;
    L6:
        if ((r102 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r102).removeToolbarButton(r100, ControllerExtensionsKt.a(r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void D(EntryController.k r100) {
        Intrinsics.checkNotNullParameter(r100, "loadFilter");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L6;
        ((td.d) r101).D(r100);
        return;
    L6:
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r101).registerToolbarLoadFilter(NewToolbarButtonConstants.CommerceCart.INSTANCE, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void E(ShoppingCart r100) {
        xd.i r101 = xd.i.f563269a;
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        Object r102 = this.f3986a;
        if ((r102 instanceof td.d) == false) goto L6;
        ((td.d) r102).E(r100);
        return;
    L6:
        if ((r102 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r102).provideToolbarButton(r100, ControllerExtensionsKt.a(r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void G(EntryController.j r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L6;
        ((td.d) r101).G(r100);
        return;
    L6:
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r101).registerToolbarButtonView(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void H(ShortTouchLynxCoupon r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L6;
        ((td.d) r101).H(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void K(q r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L6;
        ((td.d) r101).c(r100);
        return;
    L6:
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r101).requestDismiss(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void M(q r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == true) goto L7;
        boolean r102 = r101 instanceof ILiveRoomViewHandler;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void N(ShortTouchLynxCouponV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "iconModel");
        Object r101 = this.f3986a;
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L6;
        ((ILiveRoomViewHandler) r101).loadIconModel(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void O(q r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Object r101 = this.f3986a;
        if ((r101 instanceof td.d) == false) goto L6;
        ((td.d) r101).a(r100);
        return;
    L6:
        if ((r101 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r101).requestShow(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.e
    public final void L(q r100, xd.k r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "constraint");
        Object r102 = this.f3986a;
        if ((r102 instanceof td.d) == false) goto L6;
        ((td.d) r102).b(r100, r101);
        return;
    L6:
        if ((r102 instanceof ILiveRoomViewHandler) == false) goto L10;
        ((ILiveRoomViewHandler) r102).provideWidget(r100, ControllerExtensionsKt.a(r101));
        return;
    }
}
