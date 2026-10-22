package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import com.bytedance.android.live.ktv.common.view.h;
import com.bytedance.android.live.ktv.common.view.viewholder.OpusPreviewViewHolder;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.i;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.view.OpusPreviewErrorView;
import com.bytedance.android.livesdk.message.model.KtvTypetv;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.x8;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusPreviewDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/i;", "Lcom/bytedance/android/livesdk/message/model/od;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewDialog extends BaseKtvDialogFragment implements i<od> {
    public final g A;
    public final k B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final KtvMvPlayer f146129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OpusPreviewErrorView f146130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f146131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f146132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function3<? super String, ? super Boolean, ? super Boolean, Unit> f146133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f146134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CommomKtvButton f146135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f146136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IMvPreviewViewHolder<od> f146137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Pair<Integer, od> f146138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IMvPreviewViewHolder<od> f146139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OpusPreviewViewModel f146140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<OpusPreviewViewHolder> f146141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.view.i f146142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super k, Boolean> f146143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f146144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function0<Unit> f146145w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final OpusPreviewDialog$previewListViewHolderProvider$1 f146146x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f146147y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f146148z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusPreviewDialog f146149a;

        public b(OpusPreviewDialog r100) {
            this.f146149a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            OpusPreviewDialog r101 = this.f146149a;
            r101.aa0((List) r100, KtvTypetv.KTVMVType_OFFICIAl.ordinal());
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusPreviewDialog f146150a;

        public c(OpusPreviewDialog r100) {
            this.f146150a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            OpusPreviewDialog r101 = this.f146150a;
            r101.aa0((ArrayList) r100, KtvTypetv.KTVMVType_PERSONAL.ordinal());
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusPreviewDialog f146151a;

        public d(OpusPreviewDialog r100) {
            this.f146151a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            od r101 = (od) r100;
            Iterator<OpusPreviewViewHolder> r102 = this.f146151a.f146141s.iterator();
        L4:
            if (r102.hasNext() == false) goto L15;
            OpusPreviewViewHolder r103 = r102.next();
            if (Intrinsics.areEqual(r101, r103.f70838g) == true) goto L7;
            r103.W3();
            goto L4
        L7:
            r103.itemView.performClick();
            OpusPreviewDialog r104 = this.f146151a;
            Function1<? super k, Boolean> r105 = r104.f146143u;
            if (r105 == null) goto L12;
            boolean r106 = r105.invoke(r104.B).booleanValue();
            boolean r107 = true;
            if (r106 != true) goto L12;
        L13:
            r103.X3(r107);
        L12:
            r107 = false;
            goto L13
        L15:
            OpusPreviewDialog r108 = this.f146151a;
            Pair<Integer, od> r109 = r108.f146138p;
            if (r109 == null) goto L18;
            od r110 = r109.getSecond();
        L19:
            r108.Y90(Intrinsics.areEqual(r101, r110));
            return;
        L18:
            r110 = null;
            goto L19
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final String S90() {
        return "MvCoverPreviewDialog";
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final View getContentView() {
        final Context r100 = getContext();
        View r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        this.f146140r = (OpusPreviewViewModel) ViewModelProviders.of(this, new OpusPreviewDialog$initViewModel$1(this)).get(OpusPreviewViewModel.class);
        LinearLayout r102 = new LinearLayout(r100);
        r102.setOrientation(1);
        r102.setGravity(17);
        r102.setBackgroundResource(R.drawable.preview_mv_dialog_bg);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(1);
        r103.setGravity(17);
        r103.setHorizontalGravity(17);
        TextView r104 = new TextView(r100);
        r104.setText(R.string.ttlive_mv_choose);
        r104.setTextColor(-16777216);
        r104.setTextSize(1, 16.0f);
        Unit r105 = Unit.INSTANCE;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.gravity = 17;
        r106.topMargin = s1.f(13.0f);
        r106.bottomMargin = s1.f(13.0f);
        r103.addView(r104, r106);
        View r107 = new View(r100);
        r107.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r103.addView(r107, new LinearLayout.LayoutParams(-1, 1));
        r102.addView(r103);
        FrameLayout r110 = new FrameLayout(r100);
        this.f146144v = r110;
        r110.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        OpusPreviewViewModel r108 = this.f146140r;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L8:
        final h r111 = new h(r100, r108);
        com.bytedance.android.live.ktv.common.view.i r112 = new com.bytedance.android.live.ktv.common.view.i(r100, r111.f70830d, this.f146146x, this, new OpusPreviewDialog$getContentView$$inlined$apply$lambda$1(r111, this, r100));
        this.f146142t = r112;
        Intrinsics.checkNotNullParameter(r112, "p");
        r111.f70829c.add(r112);
        ViewGroup r109 = r111.f70828b;
        if (r109 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("listContainer");
    L11:
        r109.addView(r112.f70823d);
        NestedScrollView r113 = r111.f70827a;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("previewContainer");
    L14:
        r113.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(550.0f)));
        FrameLayout r114 = this.f146144v;
        if (r114 == null) goto L17;
        r114.addView(r113);
    L17:
        Context r115 = getContext();
        if (r115 == null) goto L21;
        FrameLayout r116 = new FrameLayout(r115);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, s1.f(85.0f));
        r117.gravity = 80;
        r116.setLayoutParams(r117);
        r116.setBackgroundColor(-16777216);
        TextView r118 = new TextView(r115);
        r118.setText(s1.B(R.string.ttlive_ktv_preview));
        r118.setTextColor(-1);
        this.f146134l = r118;
        r118.setTextSize(1, 15.0f);
        int r119 = s1.f(5.0f);
        r118.setPadding(r119, r119, r119, r119);
        FrameLayout.LayoutParams r120 = new FrameLayout.LayoutParams(-2, -2);
        r120.gravity = 19;
        r120.leftMargin = s1.f(10.0f);
        r118.setLayoutParams(r120);
        r118.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.mv.opus.a(this));
        r116.addView(r118);
        CommomKtvButton r121 = new CommomKtvButton(r115);
        r121.setText(s1.B(R.string.ttlive_ktv_play_opus));
        this.f146135m = r121;
        r121.setTextSize(1, 15.0f);
        r121.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.mv.opus.b(this));
        FrameLayout.LayoutParams r122 = new FrameLayout.LayoutParams(s1.f(140.0f), s1.f(38.0f));
        r122.gravity = 21;
        r122.rightMargin = s1.f(10.0f);
        r116.addView(r121, r122);
        r101 = r116;
    L21:
        if (r101 == null) goto L23;
        r110.addView(r101);
    L23:
        r102.addView(r110);
        return r102;
    }

    public static View X90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void Y90(boolean r100) {
        if (this.f146148z != r100) goto L5;
        return;
    L5:
        View r101 = this.f146134l;
        float r102 = 1.0f;
        if (r101 == null) goto L11;
        if (r100 == false) goto L9;
        float r103 = 0.4f;
    L10:
        r101.setAlpha(r103);
        goto L11
    L9:
        r103 = 1.0f;
    L11:
        CommomKtvButton r104 = this.f146135m;
        if (r104 == null) goto L16;
        if (r100 == false) goto L15;
        r102 = 0.4f;
    L15:
        r104.setAlpha(r102);
    L16:
        this.f146148z = r100;
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        Dialog r111 = getDialog();
        boolean r100 = true;
        if (r111 == null) goto L18;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        int r102 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L16:
        r112.setLayout(r102, -1);
        goto L18
    L15:
        r102 = -1;
        goto L16
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r101 = false;
    L18:
        if (PadConfigUtils.c() == false) goto L85;
        Dialog r113 = getDialog();
        View r103 = null;
        if (r113 == null) goto L41;
        View r104 = r113.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r104 == null) goto L41;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = -2;
        r105.width = -1;
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L26;
        ViewGroup.LayoutParams r106 = null;
    L27:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L31;
        r107.setMargins(0, 0, 0, 0);
    L31:
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == true) goto L33;
        ViewGroup.LayoutParams r108 = null;
    L34:
        CoordinatorLayout.LayoutParams r109 = (CoordinatorLayout.LayoutParams) r108;
        if (r109 == null) goto L38;
        r109.gravity = 85;
    L38:
        if ((r104 instanceof RadiusLayout) == false) goto L40;
        ((RadiusLayout) r104).setMaxHeight(0);
    L40:
        r104.setLayoutParams(r105);
        goto L41
    L33:
        r108 = r105;
        goto L34
    L26:
        r106 = r105;
    L41:
        if (r113 == null) goto L46;
        Window r114 = r113.getWindow();
        if (r114 == null) goto L46;
        r114.setNavigationBarColor(s1.h(R.color.transparent));
    L46:
        if (s1.getResources().getConfiguration().orientation == 2) goto L49;
        r100 = false;
    L49:
        if (r100 == false) goto L79;
        if (r113 == null) goto L54;
        View r115 = r113.findViewById(R.id.ttlive_bottom_sheet_container);
        if (r115 == null) goto L54;
        r115.setFitsSystemWindows(false);
        r115.setPadding(0, 0, 0, 0);
    L54:
        if (r113 == null) goto L58;
        View r116 = r113.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r116 == null) goto L58;
        r116.setFitsSystemWindows(false);
        r116.setPadding(0, 0, 0, 0);
    L58:
        if (r113 == null) goto L64;
        Window r117 = r113.getWindow();
        if (r117 == null) goto L64;
        View r118 = X90(r117);
        if (r118 == null) goto L64;
        r118.setFitsSystemWindows(false);
        r118.setPadding(0, 0, 0, 0);
    L64:
        if (r113 == null) goto L68;
        Window r119 = r113.getWindow();
        if (r119 == null) goto L68;
        View r120 = X90(r119);
    L70:
        if ((r120 instanceof ViewGroup) == false) goto L73;
        r103 = r120;
    L73:
        ViewGroup r121 = (ViewGroup) r103;
        if (r121 == null) goto L78;
        View r122 = r121.getChildAt(0);
        if (r122 == null) goto L78;
        r122.setFitsSystemWindows(false);
        r122.setPadding(0, 0, 0, 0);
    L78:
        x8.b(r113);
    L68:
        r120 = null;
    L79:
        if (r113 == null) goto L85;
        Window r123 = r113.getWindow();
        if (r123 == null) goto L85;
        View r124 = X90(r123);
        if (r124 == null) goto L85;
        r124.invalidate();
    L85:
        Dialog r125 = getDialog();
        if (r125 == null) goto L91;
        Window r126 = r125.getWindow();
        if (r126 == null) goto L92;
        r126.setGravity(85);
        return;
    L92:
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

    public OpusPreviewDialog(g r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "opusServie");
        Intrinsics.checkNotNullParameter(r101, "songInfo");
        this.A = r100;
        this.B = r101;
        KtvMvPlayer r102 = new KtvMvPlayer(jc1.a.b(), null);
        r102.setLooping(true);
        r102.o().setIsMute(true);
        Unit r103 = Unit.INSTANCE;
        this.f146129g = r102;
        this.f146136n = r100.l(r101.f142333e, r101.f142334f);
        this.f146141s = new ArrayList();
        this.f146146x = new OpusPreviewDialog$previewListViewHolderProvider$1(this);
        this.f146147y = 3;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.i
    public final boolean G70(int r100, od r101) {
        od r102 = r101;
        Intrinsics.checkNotNullParameter(r102, "info");
        Pair<Integer, od> r103 = this.f146138p;
        if (r103 != null) goto L5;
    L13:
        return false;
    L5:
        if (r103.getFirst().intValue() != r100) goto L13;
        Pair<Integer, od> r104 = this.f146138p;
        if (r104 == null) goto L9;
        od r105 = r104.getSecond();
    L11:
        if (Intrinsics.areEqual(r105, r102) == false) goto L13;
        return true;
    L9:
        r105 = null;
        goto L11
    }

    public final void Z90(IMvPreviewViewHolder<od> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "vh");
        Pair<Integer, od> r102 = this.f146138p;
        if (r102 == null) goto L5;
        od r103 = r102.getSecond();
    L7:
        if (Intrinsics.areEqual(r103, this.f146136n.e().getValue()) == false) goto L9;
        return;
    L9:
        Function1<? super k, Boolean> r104 = this.f146143u;
        if (r104 == null) goto L14;
        boolean r105 = true;
        if (r104.invoke(this.B).booleanValue() != true) goto L14;
    L15:
        if (r103 == null) goto L19;
        this.A.e(this.B, r103.f(), r103.e(), r105);
        Function3<? super String, ? super Boolean, ? super Boolean, Unit> r106 = this.f146133k;
        if (r106 == null) goto L19;
        Unit r107 = r106.invoke(r103.f(), Boolean.valueOf(r103.g()), Boolean.valueOf(r101));
    L19:
        if (r105 == false) goto L29;
        dismiss();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L30;
        com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r105 = false;
        goto L15
    L5:
        r103 = null;
        goto L7
    }

    public final void aa0(List<od> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "infoList");
        if (r101 != KtvTypetv.KTVMVType_OFFICIAl.ordinal()) goto L23;
        od r102 = null;
        if ((!r100.isEmpty()) == false) goto L7;
        List<od> r103 = r100;
    L8:
        if (r103 != null) goto L10;
        return;
    L10:
        od r104 = this.f146136n.e().getValue();
        if (r104 != null) goto L13;
    L19:
        com.bytedance.android.live.ktv.common.view.i r105 = this.f146142t;
        if (r105 == null) goto L24;
        r105.b(r103.subList(0, Math.min(this.f146147y, r103.size())));
        return;
    L24:
        return;
    L13:
        if (r104.g() == false) goto L15;
        r102 = r104;
    L15:
        if (r102 == null) goto L19;
        if (r100.contains(r102) == true) goto L19;
        r103 = new ArrayList(r100);
        ListProtector.add(r103, 0, r102);
        ListProtector.remove(r103, CollectionsKt.getLastIndex(r103));
        goto L19
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        OpusPreviewViewModel r102 = this.f146140r;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L5:
        r102.getOfficialMvList().observe(this, new b(this));
        OpusPreviewViewModel r103 = this.f146140r;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L8:
        r103.getOpusMvList().observe(this, new c(this));
        this.f146136n.e().observe(this, new d(this));
        OpusPreviewViewModel r104 = this.f146140r;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L11:
        OpusPreviewViewModel.requestMvList$default(r104, true, false, new OpusPreviewDialog$getNewMvList$1(this), 2, null);
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.i
    public final void G80(int r100, od r101, IMvPreviewViewHolder<od> r102, Function0 r103) {
        od r104 = r101;
        Intrinsics.checkNotNullParameter(r104, "info");
        Intrinsics.checkNotNullParameter(r102, "vh");
        Intrinsics.checkNotNullParameter(r103, "unSelectedCb");
        Function0<Unit> r105 = this.f146145w;
        if (r105 == null) goto L5;
        Unit r106 = r105.invoke();
    L5:
        this.f146137o = r102;
        this.f146145w = r103;
        this.f146138p = new Pair(Integer.valueOf(r100), r104);
        Y90(Intrinsics.areEqual(r104, this.f146136n.e().getValue()));
    }
}
