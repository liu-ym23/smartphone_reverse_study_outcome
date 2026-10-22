package com.bytedance.android.live.room.navi.tetris;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.m0;
import zg1.q3;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/AnchorRoomNavigatorTetris;", "Lcom/bytedance/android/live/room/navi/tetris/RoomNavigatorTetris;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorRoomNavigatorTetris extends RoomNavigatorTetris {
    public final long A;
    public final long B;
    public boolean C;
    public Activity D;
    public final CompositeDisposable E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup f99717v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public LivePopupWindow f99718w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f99719x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Disposable f99720y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Disposable f99721z;

    public final boolean W() {
        Activity r100 = this.D;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isFinishing() == true) goto L7;
        return true;
    }

    public AnchorRoomNavigatorTetris() {
        this.A = 30;
        this.B = 7;
        this.E = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        DataCenter r100 = ((d90.d) K()).f467480h;
        if (r100 != null) goto L5;
    L6:
        LiveMode r101 = LiveMode.VIDEO;
    L7:
        this.f99752s = ((d90.d) K()).f467480h;
        ViewGroup r102 = this.f99748o;
        if (r102 == null) goto L10;
        LiveTetris.Q(this, ((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(((d90.d) K()).f467480h), r102, true, null, 24);
    L10:
        int r103 = (int) UIUtils.dip2Px(s1.getContext(), 12.0f);
        UIUtils.updateLayoutMargin(this.f99748o, -3, -3, r103, -3);
        if (g81.a.f480368a.getValue().booleanValue() == false) goto L18;
        ImageView r104 = this.f99751r;
        if (r104 == null) goto L15;
        r104.setVisibility(0);
    L15:
        ImageView r105 = this.f99751r;
        if (r105 == null) goto L21;
        r105.setOnClickListener(new a(this));
    L21:
        V(K());
        Disposable r106 = xs2.b.a().b(q3.class).subscribe(new b(this));
        this.E.add(r106);
        return;
    L18:
        ImageView r107 = this.f99751r;
        if (r107 == null) goto L21;
        r107.setVisibility(8);
        goto L21
    L5:
        if (((LiveMode) r100.get("data_live_mode", LiveMode.VIDEO)) != null) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        this.E.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onStart() {
        super.onStart();
        if (g81.a.f480368a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (this.C == true) goto L14;
        this.C = true;
        if (yo0.f121705a.getValue().booleanValue() == false) goto L10;
        return;
    L10:
        if (SharedPrefHelper.b(((d90.d) K()).getContext()).f("live.pref.PREF_CLOSE_LIVE_POPUP", false) == true) goto L15;
        this.f99720y = Observable.timer(this.A, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.f99759a);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.b(R.layout.ttlive_portrait_interaction_row_one_for_anchor);
        this.f99719x = r101;
        ViewGroup r102 = null;
        if (r101 == null) goto L5;
        Context r103 = r101.getContext();
    L7:
        if ((r103 instanceof Activity) == false) goto L16;
        View r104 = this.f99719x;
        if (r104 == null) goto L11;
        Context r105 = r104.getContext();
    L12:
        if (r105 == null) goto L15;
        this.D = (Activity) r105;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L11:
        r105 = null;
    L16:
        View r106 = this.f99719x;
        if (r106 == null) goto L19;
        ViewGroup r107 = (ViewGroup) r106.findViewById(R.id.user_info_container);
    L20:
        this.f99748o = r107;
        View r108 = this.f99719x;
        if (r108 == null) goto L23;
        ViewGroup r109 = (ViewGroup) r108.findViewById(R.id.top_right_widget_container);
    L24:
        this.f99749p = r109;
        View r110 = this.f99719x;
        if (r110 == null) goto L27;
        ViewGroup r111 = (ViewGroup) r110.findViewById(R.id.top_right_watch_user_container_v1);
    L28:
        this.f99750q = r111;
        View r112 = this.f99719x;
        if (r112 == null) goto L31;
        ImageView r113 = (ImageView) r112.findViewById(R.id.close_in_top_container);
    L32:
        this.f99751r = r113;
        View r114 = this.f99719x;
        if (r114 == null) goto L35;
        r102 = (ViewGroup) r114.findViewById(R.id.top_right_trial_broadcast);
    L35:
        this.f99717v = r102;
        View r115 = this.f99719x;
        Intrinsics.checkNotNull(r115);
        return r115;
    L31:
        r113 = null;
        goto L32
    L27:
        r111 = null;
        goto L28
    L23:
        r109 = null;
        goto L24
    L19:
        r107 = null;
        goto L20
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void H(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        super.H(r100);
        Disposable r101 = this.f99720y;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Disposable r102 = this.f99721z;
        if (r102 == null) goto L9;
        r102.dispose();
        return;
    }

    @Override // com.bytedance.android.live.room.navi.tetris.RoomNavigatorTetris, o70.a
    public void onEvent(o70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super.onEvent(r100);
        if ((r100 instanceof m0) == false) goto L10;
        boolean r101 = ((m0) r100).f571878a;
        View r102 = L();
        if (r101 == false) goto L7;
        float r103 = 0.0f;
    L8:
        r102.setAlpha(r103);
        return;
    L7:
        r103 = 1.0f;
        goto L8
    }
}
