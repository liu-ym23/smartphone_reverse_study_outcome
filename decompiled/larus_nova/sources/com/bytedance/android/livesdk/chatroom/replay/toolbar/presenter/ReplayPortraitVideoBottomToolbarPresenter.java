package com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.palette.graphics.Palette;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.replay.ui.e0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ToolbarBackgroundConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/presenter/ReplayPortraitVideoBottomToolbarPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/toolbar/presenter/ReplayPortraitBottomToolbarPresenter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPortraitVideoBottomToolbarPresenter extends ReplayPortraitBottomToolbarPresenter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f110143v = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewGroup f110144s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f110145t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f110146u;

    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter
    public final void n() {
    }

    static {
        new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter
    public final void m() {
        Iterator r100 = ((ArrayList) this.f110132i).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        ToolbarButton r101 = (ToolbarButton) r100.next();
        ExtendedToolbarButton.f115618h.getClass();
        ExtendedToolbarButton.b r102 = ExtendedToolbarButton.a.a(r101);
        View r103 = (View) ((HashMap) c()).get(r102);
        if (r103 == null) goto L4;
        Intrinsics.checkNotNullParameter(r101, "config");
        ViewGroup r104 = this.f110144s;
        if (r104 == null) goto L10;
        r104.removeView(r103);
    L10:
        b().C(r102, r103);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter, com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final void i() {
        super.i();
        ImageView r100 = this.f110145t;
        if (r100 == null) goto L5;
        r100.setBackground(null);
    L5:
        ImageView r101 = this.f110145t;
        if (r101 == null) goto L9;
        r101.setBackgroundColor(0);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter, com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.a
    public final void h(Object[] r100) {
        super.h(r100);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        e0 r102 = (e0) ReplayRoomFragmentScopeUtil.a(e0.class);
        ViewGroup r103 = this.f110146u;
        DataCenter r104 = this.f110154h;
        r102.getClass();
        Object r105 = null;
        if (r103 == null) goto L5;
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
    L7:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r106 = null;
    L9:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L12;
        int r108 = lr1.a.f510387b;
        lr1.a r109 = lr1.a.C6730a.a(r104);
        r107.leftMargin = s1.f(6.0f);
        r109.getClass();
        r107.rightMargin = s1.f(6 + 12.0f);
    L12:
        DataCenter r110 = this.f110154h;
        if (r110 == null) goto L17;
        Episode r111 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r110);
        if (r111 == null) goto L17;
        ToolbarBackgroundConfig r112 = r111.toolbarBackgroundConfig;
    L18:
        if (r112 == null) goto L20;
        Long r113 = Long.valueOf(r112.needSwitch);
    L21:
        if (r113 != null) goto L24;
    L42:
        if (r113 != null) goto L45;
    L54:
        if (r113 != null) goto L57;
        return;
    L57:
        if (r113.longValue() != 3) goto L86;
        py.k r114 = r112.background;
        if (r114 == null) goto L87;
        ImageView r115 = this.f110145t;
        if ((r115 instanceof HSImageView) == false) goto L66;
        HSImageView r116 = (HSImageView) r115;
        GenericDraweeHierarchy r117 = r116.getHierarchy();
        if (r117 == null) goto L65;
        r117.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
        r117.setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        HSImageView r118 = (HSImageView) this.f110145t;
        ImageLoader.bindImage(r118, r114, r118.getWidth(), ((HSImageView) this.f110145t).getHeight());
        Unit r119 = Unit.INSTANCE;
        r105 = r117;
    L65:
        r116.setHierarchy(r105);
        return;
    L66:
        int r120 = 0;
        if (r115 == null) goto L69;
        int r121 = r115.getWidth();
    L70:
        ImageView r122 = this.f110145t;
        if (r122 == null) goto L73;
        r120 = r122.getHeight();
    L73:
        ImageUtil.loadImage(r115, r114, r121, r120, null);
        return;
    L69:
        r121 = 0;
        goto L70
    L87:
        return;
    L86:
        return;
    L45:
        if (r113.longValue() != 2) goto L54;
        String r123 = r112.color;
        if (r123 == null) goto L83;
        ImageView r124 = this.f110145t;     // Catch: Exception -> L52
        if (r124 == null) goto L84;
        r124.setBackgroundColor(Color.parseColor(r123));     // Catch: Exception -> L52
        Unit r125 = Unit.INSTANCE;     // Catch: Exception -> L52
        return;
    L84:
        return;
    L52:
        e = move-exception;
        ALogger.e("VSPortraitVideoBottomToolbarWidget", e.getMessage());
        Unit r126 = Unit.INSTANCE;
        return;
    L83:
        return;
    L24:
        if (r113.longValue() != 1) goto L42;
        ReplayDataContext.a r127 = ReplayDataContext.Companion;
        DataCenter r128 = this.f110154h;
        r127.getClass();
        ReplayDataContext r129 = ReplayDataContext.a.b(r128);
        if (r129 == null) goto L28;
        com.bytedance.live.datacontext.n<Bitmap> r130 = r129.getVideoBackgroundBitmap();
    L29:
        if (r130 == null) goto L31;
        r105 = (Bitmap) r130.getValue();
    L31:
        if (r105 == null) goto L35;
        Bitmap r131 = r130.getValue();
        if (r131 == null) goto L77;
        new Palette.Builder(r131).generate(new p(this));
        return;
    L77:
        return;
    L35:
        ReplayDataContext r132 = ReplayDataContext.a.b(this.f110154h);
        if (r132 == null) goto L79;
        com.bytedance.live.datacontext.n<Bitmap> r133 = r132.getVideoBackgroundBitmap();
        if (r133 == null) goto L80;
        Observable<sh6.b<Bitmap>> r134 = r133.a();
        if (r134 == null) goto L81;
        r134.subscribe(new q(this));
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L28:
        r130 = null;
        goto L29
    L20:
        r113 = null;
    L17:
        r112 = null;
        goto L18
    L5:
        r106 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.presenter.ReplayPortraitBottomToolbarPresenter
    public final ViewGroup j(ToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return this.f110144s;
    }

    public ReplayPortraitVideoBottomToolbarPresenter(ViewGroup r100, ImageView r101, ViewGroup r102, View r103, FragmentActivity r104, LifecycleOwner r105, DataCenter r106) {
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "owner");
        super(r103, r104, r105, r106);
        this.f110144s = r100;
        this.f110145t = r101;
        this.f110146u = r102;
    }
}
