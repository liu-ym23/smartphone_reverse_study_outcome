package com.bytedance.android.livesdk.gift.platform.core;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r2;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/GiftTouchReceiveWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftTouchReceiveWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f130421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f130422b;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f130423a = null;

        static {
            f130423a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            i12.e r102 = i12.o.b();
            if (r102 == null) goto L5;
            Object r103 = com.bytedance.android.scope.m.f163449e.d(r102, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
        L6:
            com.bytedance.android.livesdk.gift.platform.core.scope.service.n r104 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r103;
            if (r104 == null) goto L11;
            r104.a();
            return false;
        L11:
            return false;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f130424a = null;

        static {
            f130424a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            i12.e r102 = i12.o.b();
            if (r102 == null) goto L5;
            Object r103 = com.bytedance.android.scope.m.f163449e.d(r102, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
        L6:
            com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r104 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r103;
            if (r104 == null) goto L11;
            r104.c();
            r104.a();
            return false;
        L11:
            return false;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c implements r2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftTouchReceiveWidget f130425a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onEnd() {
            ViewGroup r100 = this.f130425a.containerView;
            if (r100 == null) goto L6;
            r100.setOnTouchListener(null);
            return;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onStart() {
            GiftTouchReceiveWidget r100 = this.f130425a;
            ViewGroup r101 = r100.containerView;
            if (r101 == null) goto L6;
            r101.setOnTouchListener(r100.f130421a);
            return;
        }

        public c(GiftTouchReceiveWidget r100) {
            this.f130425a = r100;
        }
    }

    public static final class d implements r2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftTouchReceiveWidget f130426a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onEnd() {
            ViewGroup r100 = this.f130426a.containerView;
            if (r100 == null) goto L6;
            r100.setOnTouchListener(null);
            return;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r2
        public final void onStart() {
            GiftTouchReceiveWidget r100 = this.f130426a;
            ViewGroup r101 = r100.containerView;
            if (r101 == null) goto L6;
            r101.setOnTouchListener(r100.f130422b);
            return;
        }

        public d(GiftTouchReceiveWidget r100) {
            this.f130426a = r100;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_gift_touch_receive_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    public GiftTouchReceiveWidget() {
        this.f130421a = a.f130423a;
        this.f130422b = b.f130424a;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        i12.e r100 = i12.o.b();
        if (r100 == null) goto L5;
        Object r101 = com.bytedance.android.scope.m.f163449e.d(r100, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r102 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r101;
        if (r102 == null) goto L9;
        r102.f131647c = null;
    L9:
        i12.e r103 = i12.o.b();
        if (r103 == null) goto L12;
        Object r104 = com.bytedance.android.scope.m.f163449e.d(r103, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
    L13:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r105 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r104;
        if (r105 == null) goto L17;
        r105.f131498e = null;
        return;
    L17:
        return;
    L12:
        r104 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        i12.e r101 = i12.o.b();
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = com.bytedance.android.scope.m.f163449e.d(r101, com.bytedance.android.livesdk.gift.platform.core.scope.service.n.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.n r104 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.n) r103;
        if (r104 == null) goto L9;
        r104.f131647c = new c(this);
    L9:
        i12.e r105 = i12.o.b();
        if (r105 == null) goto L12;
        r102 = com.bytedance.android.scope.m.f163449e.d(r105, com.bytedance.android.livesdk.gift.platform.core.scope.service.d0.class);
    L12:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.d0 r106 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d0) r102;
        if (r106 == null) goto L16;
        r106.f131498e = new d(this);
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
