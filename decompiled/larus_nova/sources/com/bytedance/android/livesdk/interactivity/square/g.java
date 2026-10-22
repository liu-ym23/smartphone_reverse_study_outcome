package com.bytedance.android.livesdk.interactivity.square;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublicScreenAreaPageType f141162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f141163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WidgetElement f141164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e f141165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f141166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f141167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f141168g;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void l2() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r100 = this.f141165d;
        if (r100 == null) goto L6;
        r100.l2();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void z5() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e r100 = this.f141165d;
        if (r100 == null) goto L6;
        r100.z5();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final String D5() {
        return this.f141167f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final PublicScreenAreaPageType getPageType() {
        return this.f141162a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void A5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        FrameLayout r101 = this.f141163b;
        if (r101 == null) goto L10;
        IPublicScreenService r102 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
        if (r102 == null) goto L7;
        Class<? extends LiveRecyclableWidget> r103 = r102.getSquareWidget();
    L8:
        if (r103 == null) goto L10;
        WidgetElement r104 = r100.b().P(r103, r101, false, null, true);
        this.f141164c = r104;
        this.f141165d = (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e) r104.f(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e.class);
        goto L10
    L7:
        r103 = null;
    L10:
        com.bytedance.android.livesdk.interactivity.api.h r105 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r105 == null) goto L24;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r106 = r105.getPublicScreenAreaStateManager();
        if (r106 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r107 = r106.getValue();
        if (r107 == null) goto L26;
        m<com.bytedance.android.livesdk.interactivity.api.base.d> r108 = r107.getState();
        if (r108 == null) goto L27;
        Observable<com.bytedance.android.livesdk.interactivity.api.base.d> r109 = r108.a();
        if (r109 == null) goto L28;
        Disposable r110 = r109.subscribe(new f(this));
        if (r110 == null) goto L29;
        RxUtilKt.c(r110, this.f141166e);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final View B5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        View r101 = LayoutInflater.from(r100.getActivity()).inflate(R.layout.ttlive_tetris_square_page, null, false);
        this.f141163b = (FrameLayout) r101.findViewById(R.id.square_tab_parent);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void C5(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        WidgetElement r101 = this.f141164c;
        if (r101 == null) goto L5;
        r100.b().S(r101);
    L5:
        this.f141164c = null;
        this.f141165d = null;
        this.f141166e.dispose();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c
    public final void setHeight(int r100) {
        FrameLayout r101 = this.f141163b;
        if (r101 == null) goto L6;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.height = r100;
        r101.setLayoutParams(r102);
        return;
    }

    public g(MiddlewareRoomContext r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f141168g = r101;
        this.f141162a = PublicScreenAreaPageType.Square;
        this.f141166e = new CompositeDisposable();
        this.f141167f = "广场";
    }
}
