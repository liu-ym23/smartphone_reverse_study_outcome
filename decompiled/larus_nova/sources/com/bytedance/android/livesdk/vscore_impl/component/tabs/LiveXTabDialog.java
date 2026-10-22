package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.matchroom.MatchLandFullShadowFrameLayout;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.utils.TabTraceMonitor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/tabs/LiveXTabDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveXTabDialog extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f159889h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DataCenter f159890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f159891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WidgetManager f159892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VSLandscapeTabsWidget f159893g;

    public static final class a {
        public static void a(LiveXTabDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "LiveXTabDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "LiveXTabDialog");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (PadConfigUtils.c() == true) goto L5;
        MatchRoomLandScapeAnimUtil.E.j("LiveXTabDialog");
    L5:
        VSLandscapeTabsWidget r100 = this.f159893g;
        if (r100 == null) goto L10;
        WidgetManager r101 = this.f159892f;
        if (r101 == null) goto L10;
        r101.unload(r100);
    L10:
        this.f159893g = null;
        this.f159892f = null;
        this.f159890d = null;
        MatchRoomLandScapeAnimUtil.E.j("LiveXTabDialog");
        super.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L20;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        if (PadConfigUtils.c() == true) goto L12;
        MatchRoomLandScapeAnimUtil.E.j("LiveXTabDialog");
    L12:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return s1.j(R.dimen.ttlive_tab_landscape_width);
    }

    public LiveXTabDialog() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L18;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L19;
        int r103 = s1.j(R.dimen.ttlive_tab_landscape_decor_width);
        r102.setDimAmount(0.0f);
        if (PadConfigUtils.c() == false) goto L16;
        int r104 = s1.j(R.dimen.ttlive_tab_pad_landscape_height);
        r102.setGravity(85);
        r102.setLayout(r103, r104);
        View r105 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L14:
        r102.clearFlags(67108864);
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r107 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r107.a();
        r107.a();
        r105.setSystemUiVisibility(1280);
        r107.a();
        r102.addFlags(Integer.MIN_VALUE);
        r102.setStatusBarColor(0);
        r105.setPadding(0, 0, 0, com.bytedance.android.annie.util.t.f40076a.e(getActivity()));
        return;
    L16:
        r102.setGravity(5);
        r102.setLayout(r103, -1);
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (PadConfigUtils.c() == false) goto L5;
    L13:
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L5:
        if (FoldScreenUtils.f() == true) goto L13;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_CommonRightDialogWithNotFullScreen);
        setAnimationType("right");
        setVertical(false);
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
        if (PadConfigUtils.c() == true) goto L5;
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y("LiveXTabDialog", this, -1);
    L5:
        super.onViewCreated(r100, r101);
        WidgetManager r103 = WidgetManager.of(this, getView());
        this.f159892f = r103;
        if (r103 == null) goto L8;
        r103.setDataCenter(this.f159890d);
    L8:
        VSLandscapeTabsWidget r104 = new VSLandscapeTabsWidget(this, this.f159891e);
        this.f159893g = r104;
        WidgetManager r105 = this.f159892f;
        if (r105 == null) goto L11;
        r105.load(R.id.ttlive_tabs_landscape_rootview, r104, false);
    L11:
        View r106 = getView();
        if (r106 == null) goto L14;
        MatchLandFullShadowFrameLayout r107 = (MatchLandFullShadowFrameLayout) r106.findViewById(R.id.ttlive_tabs_landscape_bg);
    L16:
        if (PadConfigUtils.c() == false) goto L19;
        if (r107 == null) goto L19;
        r107.setEnableShader(false);
    L19:
        if (r107 == null) goto L21;
        r107.setOnClickListener(new p(this));
    L21:
        int r108 = xu2.b.f565082a;
        LinkedHashMap r109 = new LinkedHashMap();
        Unit r110 = Unit.INSTANCE;
        xu2.c r111 = new xu2.c(r109);
        TabTraceMonitor.Event r112 = TabTraceMonitor.Event.HorizonTabDialogShow;
        r111.d(r112);
        Intrinsics.checkNotNullParameter(r112, "event");
        if (r111.f565086d == null) goto L24;
        int r113 = xu2.d.f565087a;
        xu2.d.d(r112, r111.f565083a, r111.f565084b, r111.f565085c, new HashMap(r111.f565086d));
        return;
    L24:
        int r114 = xu2.d.f565087a;
        xu2.d.d(r112, r111.f565083a, r111.f565084b, r111.f565085c, new HashMap());
        return;
    L14:
        r107 = null;
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_tabs_landscape_root_layout, r101, false);
    }
}
