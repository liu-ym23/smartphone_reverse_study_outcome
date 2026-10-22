package com.bytedance.android.livesdk.room.placeholder.widget;

import android.view.View;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends AbsExternalWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f157808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IExternalWidget f157809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f157810c;

    public static final class a implements com.bytedance.android.live.room.api.panel.b {
        public a() {
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final int getUnionId() {
            return hashCode();
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final PanelName getPanelName() {
            return PanelName.RightCard;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final void a(Function1<? super Integer, Unit> r100, Function1<? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "continueAction");
            Intrinsics.checkNotNullParameter(r101, "stopAction");
            r100.invoke(0);
        }
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f157809b.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onHide() {
        this.f157809b.onHide();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        this.f157809b.onLoad();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onShow() {
        this.f157809b.onShow();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        this.f157809b.onUnload();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        this.f157809b.onViewDetached();
        this.f157810c.put("data_promotion_right_card_container_show", Boolean.FALSE);
        int r100 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r101 = com.bytedance.android.live.room.api.panel.d.c(this.f157810c, 2);
        if (r101 == null) goto L6;
        r101.notifyPanelClose(PanelName.RightCard, this.f157808a);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        this.f157809b.onViewWillDetach();
    }

    public final String toString() {
        return "RightCardWidgetWrapper(" + this.f157809b.getClass().getName() + ")[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f157809b.onViewAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        this.f157810c.put("data_promotion_right_card_container_show", Boolean.TRUE);
        this.f157809b.onViewWillAttach(r100);
        int r101 = com.bytedance.android.live.room.api.panel.d.f99047a;
        com.bytedance.android.live.room.api.panel.c r102 = com.bytedance.android.live.room.api.panel.d.c(this.f157810c, 2);
        if (r102 == null) goto L6;
        r102.notifyPanelOpen(PanelName.RightCard, this.f157808a);
        return;
    }

    public f(IExternalWidget r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f157809b = r100;
        this.f157810c = r101;
        this.f157808a = new a();
    }
}
