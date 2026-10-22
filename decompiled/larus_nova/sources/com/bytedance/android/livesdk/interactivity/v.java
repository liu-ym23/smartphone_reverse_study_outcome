package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.publicscreen.AbsPublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v extends AbsExternalWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f141424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f141425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f141426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f141427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbsPublicScreenBottomWidget f141428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f141429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f141430g;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return this.f141428e.getView();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onLoad() {
        if (this.f141425b == false) goto L5;
        return;
    L5:
        int r100 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onLoad");
        this.f141428e.onLoad();
        this.f141425b = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onUnload() {
        if (this.f141427d == false) goto L5;
        return;
    L5:
        int r100 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onUnload");
        this.f141428e.onUnload();
        this.f141427d = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewDetached() {
        if (this.f141426c == false) goto L5;
        return;
    L5:
        int r100 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onViewDetached");
        this.f141428e.onViewDetached();
        this.f141426c = true;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillDetach() {
        if (this.f141426c == false) goto L5;
        return;
    L5:
        int r100 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onViewWillDetach");
        this.f141428e.onViewWillDetach();
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewAttached(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        int r101 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onViewAttached,current container height:" + r100.getHeight() + ",width:" + r100.getWidth());
        this.f141428e.onViewAttached(r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.AbsExternalWidget, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final void onViewWillAttach(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "viewContainerLayoutParam");
        int r101 = t.f141184a;
        ALogger.i("PSBottomWidget", this.f141428e.getBusinessName() + " onViewWillAttach");
        this.f141428e.onViewWillAttach(r100);
    }

    public v(AbsPublicScreenBottomWidget r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f141428e = r100;
        this.f141429f = r101;
        this.f141430g = r102;
    }
}
