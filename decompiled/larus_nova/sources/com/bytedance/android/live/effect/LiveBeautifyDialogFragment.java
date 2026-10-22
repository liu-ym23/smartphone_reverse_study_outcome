package com.bytedance.android.live.effect;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/LiveBeautifyDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautifyDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f66670j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f66671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f66673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f66674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f66675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f66676i;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautifyDialogFragment f66677a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LoadingStatusView r100 = (LoadingStatusView) this.f66677a.S90(R.id.status_view);
            if (r100 == null) goto L5;
            r100.reset();
        L5:
            View r101 = this.f66677a.S90(R.id.shadow_view);
            if (r101 == null) goto L9;
            r101.performClick();
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            TextView r100 = (TextView) this.f66677a.S90(R.id.tv_beauty_mode);
            if (r100 == null) goto L5;
            r100.setText((CharSequence) m90.b.F.c(this.f66677a.f66672e).second);
        L5:
            LoadingStatusView r101 = (LoadingStatusView) this.f66677a.S90(R.id.status_view);
            if (r101 == null) goto L9;
            r101.showLoading();
            return;
        }

        public b(LiveBeautifyDialogFragment r100) {
            this.f66677a = r100;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f66678a = null;

        static {
            f66678a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    static {
    }

    public LiveBeautifyDialogFragment() {
        this.f66671d = new LinkedHashMap();
        this.f66672e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f66673f = LazyKt.lazy(new LiveBeautifyDialogFragment$beautyModeManager$2(this));
        this.f66674g = "";
        this.f66675h = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a();
        LiveEffectSettings.LIVE_ANCHOR_BEAUTY_PANEL_UI_OPT.getValue().booleanValue();
        this.f66676i = new b(this);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f66671d.clear();
    }

    public final View S90(int r100) {
        if (this.f66671d != null) goto L5;
        this.f66671d = new LinkedHashMap();
    L5:
        View r101 = this.f66671d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f66671d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setLayout(-1, -1);
    L7:
        Dialog r103 = getDialog();
        if (r103 == null) goto L12;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L12;
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        r104.addFlags(Integer.MIN_VALUE);
    L12:
        Dialog r105 = getDialog();
        if (r105 == null) goto L18;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L18;
        r106.setStatusBarColor(0);
    L18:
        if (this.f66675h == false) goto L24;
        Dialog r107 = getDialog();
        if (r107 == null) goto L24;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L24;
        r108.setNavigationBarColor(-16777216);
    L24:
        Dialog r109 = getDialog();
        if (r109 == null) goto L30;
        View r110 = r109.findViewById(R.id.ttlive_touch_outside);
        if (r110 == null) goto L31;
        r110.setVisibility(8);
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f66672e != LiveEffectContextFactoryDelegate$Type.DEFAULT) goto L5;
        boolean r101 = true;
    L6:
        this.f66675h = r101;
        setStyle(1, R.style.ttlive_effect_live_sticker_dialog);
        setCancelable(true);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L5;
        r101.setCanceledOnTouchOutside(true);
    L5:
        r101.requestWindowFeature(1);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(3);
    L8:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        boolean r103 = true;
        if (r102 == null) goto L8;
        View r104 = r102.findViewById(R.id.dismiss_view_dialog_beauty);
        if (r104 == null) goto L8;
        r104.setFocusable(true);
        r104.setImportantForAccessibility(1);
        r104.setOnClickListener(new d(r104, this));
    L8:
        if (((com.bytedance.android.live.effect.sticker.presenter.n) this.f66673f.getValue()).c() == true) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == false) goto L36;
        ConstraintLayout r105 = (ConstraintLayout) S90(R.id.ll_beauty_mode);
        if (r105 == null) goto L18;
        r105.postDelayed(new e(this), 500);
    L18:
        if (((com.bytedance.android.live.effect.sticker.presenter.n) this.f66673f.getValue()).e() == false) goto L20;
        f2.c(((com.bytedance.android.live.effect.sticker.presenter.n) this.f66673f.getValue()).g() + "测试已结束", 0);
    L20:
        com.bytedance.android.live.effect.sticker.presenter.n.b.a((com.bytedance.android.live.effect.sticker.presenter.n) this.f66673f.getValue(), this.f66676i);
        TextView r106 = (TextView) S90(R.id.tv_beauty_mode);
        if (r106 == null) goto L23;
        r106.setText((CharSequence) m90.b.F.c(this.f66672e).second);
    L23:
        ConstraintLayout r107 = (ConstraintLayout) S90(R.id.ll_beauty_mode);
        if (r107 == null) goto L26;
        r107.setOnClickListener(new f(this));
    L26:
        View r108 = S90(R.id.shadow_view);
        if (r108 == null) goto L29;
        r108.setOnClickListener(new g(this));
    L29:
        Context r109 = getContext();
        if (r109 == null) goto L32;
        LiveDoubleColorBallAnimationView r110 = new LiveDoubleColorBallAnimationView(r109);
        int r111 = r110.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(r111, r111);
        r112.gravity = 17;
        r110.setLayoutParams(r112);
    L33:
        LoadingStatusView r113 = (LoadingStatusView) S90(R.id.status_view);
        if (r113 == null) goto L36;
        r113.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(r113.getContext()).setLoadingView(r110));
        goto L36
    L32:
        r110 = null;
    L36:
        setBottomSheetSlideProcessor(c.f66678a);
        return;
    L10:
        if (Intrinsics.areEqual(this.f66674g, "live_take_page") == false) goto L12;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_dialog_beautify, r101, false);
    }
}
