package com.bytedance.android.livesdk.chatroom.replay.cache.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayDialogUIStyle;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.o;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;
import zk1.h;
import zk1.l;
import zk1.m;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayListCacheWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayListCacheWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f108160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f108161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f108162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f108163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f108164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f108165f;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayListCacheWidget f108166a;

        public b(ReplayListCacheWidget r100) {
            this.f108166a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f108166a.f108163d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayListCacheWidget f108167a;

        public c(ReplayListCacheWidget r100) {
            this.f108167a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f108167a.f108163d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayListCacheWidget f108168a;

        public d(ReplayListCacheWidget r100) {
            this.f108168a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReplayListCacheWidget r101 = this.f108168a;
            ((LinearLayout) r101.contentView.findViewById(R.id.vs_cache_error_container)).setVisibility(8);
            r101.f108162c.b();
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayListCacheWidget f108169a;

        public e(ReplayListCacheWidget r100) {
            this.f108169a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f108169a.f108163d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayListCacheWidget f108170a;

        public f(ReplayListCacheWidget r100) {
            this.f108170a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f108170a.f108163d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public static boolean xq() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        return ((zk1.c) ReplayRoomFragmentScopeUtil.a(zk1.c.class)).i();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayDialogUIStyle r101 = ((zk1.c) ReplayRoomFragmentScopeUtil.a(zk1.c.class)).p();
        int r102 = zk1.b.f572569a[r101.ordinal()];
        if (r102 != 1) goto L5;
        return R.layout.ttlive_replay_list_cache_widget_pad_portrait_half;
    L5:
        if (r102 != 2) goto L7;
    L11:
        return R.layout.ttlive_replay_list_cache_widget;
    L7:
        if (r102 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        ImageView r101 = (ImageView) this.contentView.findViewById(R.id.vs_cache_close_iv);
        if (r101 == null) goto L5;
        r101.setOnClickListener(new b(this));
    L5:
        this.contentView.findViewById(R.id.vs_cache_empty_view).setOnClickListener(new c(this));
        ((TextView) this.contentView.findViewById(R.id.vs_cache_retry)).setOnClickListener(new d(this));
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) this.contentView.findViewById(R.id.vs_cache_load_progress_icon);
        if (r102 == null) goto L8;
        r102.b();
    L8:
        Integer r103 = this.f108165f;
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        if (r104 != 0) goto L18;
        int r105 = t.e();
        VideoViewParams r106 = (VideoViewParams) this.dataCenter.get("live_render_view_params", null);
        int r107 = (int) (((double) r105) * 0.7d);
        if (r106 == null) goto L16;
        r104 = (r105 - r106.f112570b) - r106.f112571c;
        goto L18
    L16:
        r104 = r107;
    L18:
        if (this.f108164e == false) goto L20;
        this.f108160a = r104;
    L23:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r108 = ReplayRoomFragmentScopeUtil.f117917a;
        int r109 = zk1.b.f572570b[((zk1.c) ReplayRoomFragmentScopeUtil.a(zk1.c.class)).p().ordinal()];
        if (r109 == 1) goto L31;
        if (r109 == 2) goto L30;
        if (r109 != 3) goto L29;
        Drawable r110 = new ColorDrawable(s1.h(R.color.ttlive_replay_panel_bg));
    L32:
        this.contentView.findViewById(R.id.vs_cache_content).setBackground(r110);
        zk1.c r111 = (zk1.c) ReplayRoomFragmentScopeUtil.a(zk1.c.class);
        View r112 = this.contentView.findViewById(R.id.vs_cache_content);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "view");
        int r113 = zk1.b.f572571c[r111.p().ordinal()];
        if (r113 == 1) goto L45;
        if (r113 == 2) goto L41;
        if (r113 != 3) goto L49;
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
        d0 r115 = r111.f495438a;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L40:
        r114.height = UtilityKotlinExtentionsKt.c(ReplayAdaptiveDialogUIState.q((ReplayAdaptiveDialogUIState) r115.c(ReplayAdaptiveDialogUIState.class)));
    L49:
        ((ReplayFadingEdgeRecyclerView) this.contentView.findViewById(R.id.vs_cache_rv)).setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        h r116 = this.f108162c;
        DataCenter r117 = this.dataCenter;
        if (r117 == null) goto L54;
        Episode r118 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.g(r117);
        if (r118 == null) goto L54;
        long r119 = r118.getId();
    L55:
        r116.f572584e = r119;
        this.f108162c.f572583d = this.context;
        ((ReplayFadingEdgeRecyclerView) this.contentView.findViewById(R.id.vs_cache_rv)).setAdapter(new ReplayCacheAdapter(this.f108162c));
        if (this.f108164e == true) goto L58;
        int r120 = (int) s1.e(50.0f);
        ((ReplayFadingEdgeRecyclerView) this.contentView.findViewById(R.id.vs_cache_rv)).setVerticalFadingEdgeEnabled(true);
        ((ReplayFadingEdgeRecyclerView) this.contentView.findViewById(R.id.vs_cache_rv)).setFadingEdgeLength(r120);
    L58:
        View r121 = this.contentView.findViewById(R.id.vs_cache_container);
        if (r121 == null) goto L62;
        r121.setOnClickListener(new f(this));
        return;
    L62:
        return;
    L54:
        r119 = 0;
        goto L55
    L41:
        ViewGroup.LayoutParams r122 = r112.getLayoutParams();
        d0 r123 = r111.f495438a;
        if (r123 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L44:
        r122.height = UtilityKotlinExtentionsKt.c(ReplayAdaptiveDialogUIState.q((ReplayAdaptiveDialogUIState) r123.c(ReplayAdaptiveDialogUIState.class)));
        goto L49
    L45:
        ViewGroup.LayoutParams r124 = r112.getLayoutParams();
        d0 r125 = r111.f495438a;
        if (r125 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L48:
        r124.height = Math.min(UtilityKotlinExtentionsKt.c(ReplayAdaptiveDialogUIState.q((ReplayAdaptiveDialogUIState) r125.c(ReplayAdaptiveDialogUIState.class))), UtilityKotlinExtentionsKt.c(480));
        goto L49
    L29:
        throw new NoWhenBranchMatchedException();
    L30:
        r110 = s1.m(R.drawable.ttlive_bg_more_many_icon_dialog_gradient);
        goto L32
    L31:
        r110 = s1.m(o.f118203d);
        goto L32
    L20:
        View r126 = this.contentView.findViewById(R.id.click_zone);
        if (r126 == null) goto L23;
        r126.setOnClickListener(new e(this));
        goto L23
    L11:
        r104 = 0;
        goto L12
    }

    public static final void wq(ReplayListCacheWidget r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        r102.put("vs_download_panel_type", r101);
        com.bytedance.android.livesdk.chatroom.replay.cache.c.b(r100.dataCenter, "download_panel_show", r102);
    }

    public ReplayListCacheWidget(l r100, boolean r101, Integer r102) {
        this.f108163d = r100;
        this.f108164e = r101;
        this.f108165f = r102;
        this.f108160a = s1.e(500.0f);
        this.f108161b = s1.e(500.0f);
        h r103 = new h(false);
        this.f108162c = r103;
        Intrinsics.checkNotNullParameter(this, "widget");
        r103.f572590k = this;
        r103.f572591l = new m(this);
    }
}
