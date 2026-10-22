package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.utils.LoadingViewInflateUtil;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.gx0;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class DouyinLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f112129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f112130b;

    public final void b() {
        LiveDoubleColorBallAnimationView r100 = this.f112129a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.b();
    }

    public final void c() {
        LiveDoubleColorBallAnimationView r100 = this.f112129a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.c();
    }

    public DouyinLoadingLayout(Context r100) {
        super(r100);
        a(r100, null);
    }

    public void setLoadingText(String r100) {
        if (this.f112130b != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        this.f112130b.setVisibility(8);
        return;
    L8:
        this.f112130b.setVisibility(0);
        this.f112130b.setText(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        LiveDoubleColorBallAnimationView r101 = this.f112129a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisibility(r100);
    }

    public void setLoadingText(int r100) {
        setLoadingText(com.bytedance.android.live.core.utils.s1.B(r100));
    }

    public DouyinLoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100, r101);
    }

    public final void a(Context r110, AttributeSet r111) {
        if (PerformanceTestSettings.TEST_DISABLE_DOUBLE_COLOR_BALL.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        boolean r100 = false;
        if (r111 == null) goto L11;
        r100 = r110.obtainStyledAttributes(r111, new int[]{R.attr.use_nita_inflate}).getBoolean(0, false);
        ALogger.i("LiveViewInflate", "DouyinLoadingLayout useNitaInflate=" + r100);
    L11:
        if (r100 == false) goto L30;
        Activity r101 = com.bytedance.android.live.core.utils.a.d();
        if (r101 == null) goto L30;
        Lazy r102 = LoadingViewInflateUtil.f114367a;
        Intrinsics.checkNotNullParameter("TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", "nitaTag");
        Intrinsics.checkNotNullParameter(r101, "activity");
        if (gx0.f120321a.getValue().getLoading() == false) goto L30;
        long r112 = System.currentTimeMillis();
        Lazy r103 = LoadingViewInflateUtil.f114368b;
        if (((IMiddlewareHostBusiness) r103.getValue()) != null) goto L20;
    L28:
        ALogger.w("LoadingViewInflateUtil", "hostBusiness is null or nitaInflaterEnabled is closed or activity is not LivePlayActivity");
        View r104 = LayoutInflater.from(r101).inflate(R.layout.ttlive_layout_douyin_loading_view, this, true);
    L29:
        ALogger.i("LoadingViewInflateUtil", "NitaInflate: enabled: " + ((Boolean) LoadingViewInflateUtil.f114367a.getValue()).booleanValue() + ", duration: " + (System.currentTimeMillis() - r112) + "ms");
    L31:
        if (r104 != null) goto L33;
        r104 = LayoutInflater.from(r110).inflate(R.layout.ttlive_layout_douyin_loading_view, this, true);
    L33:
        this.f112129a = (LiveDoubleColorBallAnimationView) r104.findViewById(R.id.double_loading_view);
        this.f112130b = (TextView) r104.findViewById(R.id.double_loading_text);
        return;
    L20:
        if (((Boolean) LoadingViewInflateUtil.f114367a.getValue()).booleanValue() == false) goto L28;
        if (Intrinsics.areEqual(r101.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L24;
    L27:
        IMiddlewareHostBusiness r105 = (IMiddlewareHostBusiness) r103.getValue();
        Intrinsics.checkNotNull(r105);
        Boolean r106 = Boolean.TRUE;
        r104 = r105.tryGetPreLoadLiveLayouts(R.layout.ttlive_layout_douyin_loading_view, "TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", r101, this, r106, r106, null);
        goto L29
    L24:
        if (Intrinsics.areEqual(r101.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L27;
        if (Intrinsics.areEqual(r101.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.multitask.LivePlayShadowActivity") == false) goto L28;
    L30:
        r104 = null;
        goto L31
    }
}
