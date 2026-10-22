package com.bytedance.android.ec.window.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/window/base/view/ECWindowRemoteVideoView;", "Lcom/bytedance/android/ec/window/base/view/ECWindowVideoView;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoView;", "getVideoView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "", "coverUrl", "", "setCoverUrl", "Lcom/bytedance/android/ec/window/base/view/ECWindowVideoView$ScaleType;", "scaleType", "setScaleType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowRemoteVideoView extends ECWindowVideoView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECVideoView f49824d;

    public static final class a implements com.bytedance.android.shopping.widget.ecvideoplayer.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowRemoteVideoView f49825a;

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void E() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void g() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void h(int r100, int r101) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onError(Error r100) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onIdle() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onPaused() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onPlaying() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onRelease() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void onVideoSizeChanged(int r100, int r101) {
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.b
        public final void w() {
        }

        public a(ECWindowRemoteVideoView r100) {
            this.f49825a = r100;
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.e
        public final void T(int r100) {
            if (r100 != 0) goto L5;
            this.f49825a.getPlayNotificationView().setVisibility(0);
        L6:
            h r101 = this.f49825a.getAwemeVideoListener();
            if (r101 == null) goto L10;
            r101.T(r100);
            return;
        L10:
            return;
        L5:
            SimpleDraweeView r102 = this.f49825a.getPlayNotificationView();
            Integer[] r103 = com.bytedance.android.ec.window.base.common.uiext.b.f49223a;
            Intrinsics.checkNotNullParameter(r102, "$this$hideWithAnimations");
            com.bytedance.android.ec.window.base.common.uiext.b.a(r102, 1, 200, false);
            goto L6
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.e
        public final void U2(ECVideoPlayer r100) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r100, "player");
        }

        @Override // com.bytedance.android.shopping.widget.ecvideoplayer.e
        public final void m0(ECVideoPlayer r100) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r100, "player");
        }
    }

    @Override // com.bytedance.android.ec.window.base.view.ECWindowVideoView
    public SimpleDraweeView getCoverView() {
        return null;
    }

    @Override // com.bytedance.android.ec.window.base.view.ECWindowVideoView
    public /* bridge */ /* synthetic */ View getVideoView() {
        return getVideoView();
    }

    @Override // com.bytedance.android.ec.window.base.view.ECWindowVideoView
    public ECVideoView getVideoView() {
        return this.f49824d;
    }

    @Override // com.bytedance.android.ec.window.base.view.ECWindowVideoView
    public void setCoverUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "coverUrl");
        this.f49824d.setCoverUrl(r100);
    }

    @Override // com.bytedance.android.ec.window.base.view.ECWindowVideoView
    public void setScaleType(ECWindowVideoView.ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        int r101 = b.f49876a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f49824d.setScaleType(0);
        return;
    L5:
        if (r101 != 2) goto L11;
        this.f49824d.setScaleType(1);
        return;
    }

    public ECWindowRemoteVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        ECVideoView r102 = new ECVideoView(r100, null, 6, 0);
        r102.setOnVideoViewListener(new a(this));
        SimpleDraweeView r103 = r102.getCoverView();
        if (r103 == null) goto L5;
        r103.setBackgroundColor(ColorProtector.parseColor("#E8E8E9"));
    L5:
        Unit r104 = Unit.INSTANCE;
        this.f49824d = r102;
        addView(getVideoView(), new FrameLayout.LayoutParams(-1, -1));
        SimpleDraweeView r105 = getCoverView();
        if (r105 == null) goto L8;
        addView(r105, new FrameLayout.LayoutParams(-1, -1));
    L8:
        TypedArray r106 = getContext().obtainStyledAttributes(this.f49874c, new int[]{R.attr.paused_icon, R.attr.paused_icon_height, R.attr.paused_icon_width});
        float r107 = q.a(72);
        float r108 = r106.getDimension(2, r107);
        float r109 = r106.getDimension(1, r107);
        int r110 = r106.getInt(0, R.drawable.ec_shop_ic_inner_flow_ready_to_play);
        View r111 = this.f49873b;
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams((int) r108, (int) r109);
        r112.gravity = 17;
        addView(r111, r112);
        this.f49873b.setActualImageResource(r110);
        r106.recycle();
        setBackgroundColor(-16777216);
    }
}
