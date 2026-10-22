package com.bytedance.android.livesdk.chatroom.vs.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.ReplayByteCastHelper;
import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.v;

/* JADX INFO: loaded from: classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeResetPlayerView, type = PlayerViewControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/widget/landscape/VSRoomLandscapeResetPlayerViewWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRoomLandscapeResetPlayerViewWidget extends LiveWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f117872a;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSRoomLandscapeResetPlayerViewWidget f117873a;

        public a(VSRoomLandscapeResetPlayerViewWidget r100) {
            this.f117873a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            View r101 = this.f117873a.contentView;
            if (((Boolean) r100).booleanValue() == false) goto L7;
            Lazy r102 = ReplayByteCastHelper.f108206a;
            DataCenter r103 = this.f117873a.dataCenter;
            if (Intrinsics.areEqual(r.b().d(r103), Boolean.TRUE) == true) goto L7;
            int r104 = 0;
        L8:
            r101.setVisibility(r104);
            return;
        L7:
            r104 = 8;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSRoomLandscapeResetPlayerViewWidget f117874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VSPlayerViewControlContext f117875b;

        public b(VSRoomLandscapeResetPlayerViewWidget r100, VSPlayerViewControlContext r101) {
            this.f117874a = r100;
            this.f117875b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            View r101 = this.f117874a.contentView;
            if (((Boolean) r100).booleanValue() == true) goto L11;
            VSPlayerViewControlContext r102 = this.f117875b;
            if (r102 == null) goto L11;
            m<Boolean> r103 = r102.getPlayerViewIsInZoom();
            if (r103 == null) goto L11;
            if (r103.getValue().booleanValue() != true) goto L11;
            int r104 = 0;
        L12:
            r101.setVisibility(r104);
            return;
        L11:
            r104 = 8;
            goto L12
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f117876a = null;

        static {
            f117876a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ko1.c r101 = VSGestureViewManagerHelper.f117687a;
            if (r101 == null) goto L5;
            Boolean r102 = Boolean.valueOf(r101.b("restore_button"));
        L7:
            if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L10;
            f2.b(R.string.ttlive_vs_reset_player_view_tip, 0);
            return;
        L10:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_vs_reset_player_view;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        this.contentView.setVisibility(8);
        Disposable r100 = null;
        if (h.a(this.dataCenter).isReplay() == false) goto L7;
        this.contentView.getLayoutParams().height = s1.f(28.0f);
        v r101 = s.e().provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L12;
        VSPlayerViewControlContext r102 = r101.provideContext();
    L13:
        ViewGroup r103 = this.containerView;
        if (r103 == null) goto L16;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L18:
        if ((r104 instanceof ConstraintLayout.LayoutParams) == true) goto L20;
        r104 = null;
    L20:
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        if (r105 == null) goto L23;
        r105.horizontalBias = 0.0f;
    L23:
        if (r102 == null) goto L29;
        m<Boolean> r106 = r102.getPlayerViewIsInZoom();
        if (r106 == null) goto L29;
        Observable<Boolean> r107 = r106.a();
        if (r107 == null) goto L29;
        r100 = r107.subscribe(new a(this));
    L29:
        this.f117872a = r100;
        m<Boolean> r108 = r.b().castScreenMode(this.dataCenter);
        if (r108 == null) goto L34;
        Observable<Boolean> r109 = r108.a();
        if (r109 == null) goto L34;
        r109.subscribe(new b(this, r102));
    L34:
        this.contentView.setOnClickListener(c.f117876a);
        ko1.c r110 = VSGestureViewManagerHelper.f117687a;
        VSGestureViewManagerHelper.c(new AnonymousClass4(this));
        this.dataCenter.observe("data_has_change_screen_orientation", this);
        return;
    L16:
        r104 = null;
    L12:
        r102 = null;
        goto L13
    L7:
        IVSPlayerService r111 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r111 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r112 = r111.provideVSPlayerViewControlService(this.dataCenter);
        if (r112 == null) goto L12;
        r102 = r112.provideContext();
        goto L13
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        VSGestureViewManagerHelper.c(null);
        this.dataCenter.removeObserver(this);
        Disposable r100 = this.f117872a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f117872a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public VSRoomLandscapeResetPlayerViewWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r101.getKey(), "data_has_change_screen_orientation") == false) goto L11;
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.f82836e.cancel();
        MatchRoomLandScapeAnimUtil.u(0);
        MatchRoomLandScapeAnimUtil.A = 1.0f;
        MatchRoomLandScapeAnimUtil.B = 0.0f;
        MatchRoomLandScapeAnimUtil.C = 0.0f;
        MatchRoomLandScapeAnimUtil.r();
        ko1.c r103 = VSGestureViewManagerHelper.f117687a;
        if (r103 == null) goto L12;
        r103.b("rotate_to_portrait");
        return;
    L12:
        return;
    }
}
