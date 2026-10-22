package com.bytedance.android.live.ktv.common.tuningpanel.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/view/TuningPanelDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningPanelDialog extends DialogFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f70584m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f70585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f70586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f70587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f70588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f70589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f70590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f70591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f70592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ac0.b f70593l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningPanelDialog f70594a;

        public b(TuningPanelDialog r100) {
            this.f70594a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            int[] r101 = new int[2];
            LinearLayout r102 = this.f70594a.f70587f;
            if (r102 == null) goto L5;
            r102.getLocationOnScreen(r101);
        L5:
            zb0.a r103 = this.f70594a.f70593l.f2538e;
            if (r103 == null) goto L9;
            r103.e(r101);
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningPanelDialog f70595a;

        public c(TuningPanelDialog r100) {
            this.f70595a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L12;
            return;
        L12:
            this.f70595a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L15;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuningPanelDialog f70596a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LinearLayout r100 = this.f70596a.f70587f;
            if (r100 == null) goto L7;
            ViewTreeObserver r101 = r100.getViewTreeObserver();
            if (r101 == null) goto L7;
            r101.removeOnGlobalLayoutListener(this);
        L7:
            TuningPanelDialog r102 = this.f70596a;
            zb0.a r103 = r102.f70593l.f2538e;
            if (r103 == null) goto L10;
            r103.b(r102.f70592k);
        L11:
            this.f70596a.f70592k = 0;
            return;
        L10:
            mb0.c r104 = mb0.d.f512759a;
            mb0.d.f("adjust_music", System.currentTimeMillis() - this.f70596a.f70592k);
            goto L11
        }

        public d(TuningPanelDialog r100) {
            this.f70596a = r100;
        }
    }

    static {
    }

    public TuningPanelDialog() {
        this(new ac0.b(false, null, null, null, null, null, null, null, null, false, 14335));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        zb0.a r100 = this.f70593l.f2538e;
        if (r100 == null) goto L5;
        r100.clearData();
    L5:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = this.f70593l.f2544k;
        if (r101 == null) goto L8;
        r101.o();
    L8:
        ec0.a r102 = this.f70593l.f2545l;
        if (r102 == null) goto L12;
        r102.clearData();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        zb0.a r100 = this.f70593l.f2538e;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public TuningPanelDialog(ac0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f70593l = r100;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L18;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        int r104 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L17:
        r102.setLayout(r104, -1);
        goto L18
    L16:
        r104 = -1;
        goto L17
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r103 = false;
    L18:
        Dialog r105 = getDialog();
        if (r105 == null) goto L29;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L30;
        View r107 = r106.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L27;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L27;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L27:
        r107.setPadding(0, 0, 0, 0);
        r106.setGravity(85);
        r106.setBackgroundDrawable(new ColorDrawable(0));
        r106.setSoftInputMode(48);
        return;
    L30:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f70592k = System.currentTimeMillis();
        setStyle(1, R.style.ttlive_live_interact_dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        r102.setOnShowListener(new b(this));
    L5:
        zb0.a r103 = this.f70593l.f2538e;
        if (r103 == null) goto L9;
        r103.a(this, new c(this));
    L9:
        if (this.f70592k == 0) goto L16;
        LinearLayout r104 = this.f70587f;
        if (r104 == null) goto L17;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L18;
        r105.addOnGlobalLayoutListener(new d(this));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_ktv_tuning_panel_layout, r101, false);
        this.f70585d = r103;
        if (this.f70593l.f2546m == false) goto L8;
        if (r103 == null) goto L8;
        TextView r104 = (TextView) r103.findViewById(R.id.text);
        if (r104 == null) goto L8;
        r104.setTextSize(16.0f);
    L8:
        View r105 = this.f70585d;
        FrameLayout r106 = null;
        if (r105 == null) goto L11;
        View r107 = r105.findViewById(R.id.outside);
    L12:
        this.f70586e = r107;
        View r108 = this.f70585d;
        if (r108 == null) goto L15;
        LinearLayout r109 = (LinearLayout) r108.findViewById(R.id.container_ll);
    L16:
        this.f70587f = r109;
        if (r109 == null) goto L19;
        KtvOrderSongThemeManager.c(r109, 250);
    L19:
        View r110 = this.f70585d;
        if (r110 == null) goto L22;
        FrameLayout r111 = (FrameLayout) r110.findViewById(R.id.title_area);
    L23:
        this.f70588g = r111;
        View r112 = this.f70585d;
        if (r112 == null) goto L26;
        View r113 = r112.findViewById(R.id.driver);
    L27:
        this.f70589h = r113;
        View r114 = this.f70585d;
        if (r114 == null) goto L30;
        FrameLayout r115 = (FrameLayout) r114.findViewById(R.id.adjust_content_container);
    L31:
        this.f70590i = r115;
        View r116 = this.f70585d;
        if (r116 == null) goto L34;
        r106 = (FrameLayout) r116.findViewById(R.id.adjust_panel_operate_area);
    L34:
        this.f70591j = r106;
        FrameLayout r117 = this.f70590i;
        if (getContext() == null) goto L42;
        if (r117 == null) goto L39;
        r117.removeAllViews();
    L39:
        if (r117 == null) goto L42;
        r117.addView(new com.bytedance.android.live.ktv.common.tuningpanel.view.a(this.f70593l, requireContext()));
    L42:
        if (this.f70593l.f2534a == false) goto L50;
        FrameLayout r118 = this.f70591j;
        if (getContext() == null) goto L50;
        if (r118 == null) goto L48;
        r118.removeAllViews();
    L48:
        if (r118 == null) goto L50;
        r118.addView(new TuningMusicControlContainer(this.f70593l, requireContext()));
    L50:
        View r119 = this.f70586e;
        if (r119 == null) goto L54;
        r119.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L54:
        return this.f70585d;
    L30:
        r115 = null;
        goto L31
    L26:
        r113 = null;
        goto L27
    L22:
        r111 = null;
        goto L23
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = null;
        goto L12
    }
}
