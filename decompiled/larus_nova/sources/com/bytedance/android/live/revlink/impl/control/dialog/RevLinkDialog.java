package com.bytedance.android.live.revlink.impl.control.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKBeInviteFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkPrecisionMatchInviteFragment;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKAttentionFragment;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKCheckFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public class RevLinkDialog extends LinkCommonDialogFragment implements r {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f92317x = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f92318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RevInteractDialogFragmentBaseContract$View f92319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f92320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f92321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f92322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f92323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f92324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataCenter f92325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LifecycleOwner f92326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Runnable> f92327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Stack<RevInteractDialogFragmentBaseContract$View> f92328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f92329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f92330q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f92331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f92332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f92333t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f92334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public InteractPKBeInviteFragment f92335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Animation f92336w;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataCenter f92337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f92338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public IBaseUser f92339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IRoom f92340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f92341e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public i6 f92342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f92343g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f92344h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PkPrecisionMatchDataContext f92345i;

        public final RevLinkDialog a() {
            RevLinkDialog r100 = new RevLinkDialog();
            r100.f92329p = this;
            r100.f92326m = this.f92338b;
            r100.f92325l = this.f92337a;
            return r100;
        }

        public final RevLinkDialog b(int r100) {
            RevLinkDialog r101 = new RevLinkDialog();
            r101.f92329p = this;
            r101.f92326m = this.f92338b;
            r101.f92325l = this.f92337a;
            r101.f92318e = r100;
            return r101;
        }

        public a(DataCenter r100, LifecycleOwner r101) {
            this.f92344h = false;
            this.f92337a = r100;
            this.f92338b = r101;
        }
    }

    public final RevInteractDialogFragmentBaseContract$View T90() {
        if (this.f92328o.empty() == false) goto L6;
        return null;
    L6:
        return this.f92328o.peek();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final IRoom getCurrentRoom() {
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L5;
        IRoom r101 = r100.getRoom();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        return (IRoom) vh7.f.c(IRoom.class);
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        if (this.f92328o.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f92328o.peek().V90() == null) goto L9;
        this.f92328o.peek().V90().performClick();
        return true;
    L9:
        if (this.f92328o.size() == 1) goto L11;
        return false;
    L11:
        if (this.f92334u == true) goto L13;
    L26:
        return true;
    L13:
        if (this.f92318e != 1) goto L29;
        InteractPKBeInviteFragment r100 = this.f92335v;
        if (r100 == null) goto L29;
        IBaseUser r101 = r100.f95647m;
        if (r101 == null) goto L19;
        ((x31.f) r100.f92316f).g(2, r100.f95648n, r100.f95649o, r101);
    L19:
        ((x31.f) r100.f92316f).f();
    L29:
        dismiss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L26;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final int s9() {
        return this.f92328o.size();
    }

    public RevLinkDialog() {
        this.f92318e = 0;
        this.f92327n = new ArrayList();
        this.f92328o = new Stack();
        this.f92334u = true;
    }

    public final void U90() {
        Dialog r100 = getDialog();
        Context r101 = getContext();
        if (r100 == null) goto L15;
        if (r101 == null) goto L18;
        View r102 = getDialog().getCurrentFocus();
        if (r102 != null) goto L9;
        return;
    L9:
        InputMethodManager r103 = (InputMethodManager) r101.getSystemService("input_method");
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.isActive() == false) goto L17;
        r103.hideSoftInputFromWindow(r102.getWindowToken(), 0);
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        U90();
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f92324k.f92393a.clear();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        FragmentManager r100 = getFragmentManager();
        if (r100 != null) goto L6;
    L23:
        ViewGroup r101 = this.f92321h;
        if (r101 == null) goto L26;
        r101.removeAllViews();
    L26:
        ViewGroup r102 = this.f92322i;
        if (r102 == null) goto L29;
        r102.removeAllViews();
    L29:
        super.onDestroyView();
        ValueAnimator r103 = this.f92330q;
        if (r103 == null) goto L32;
        r103.cancel();
    L32:
        this.f92328o.removeAllElements();
        return;
    L6:
        if (r100.findFragmentByTag("random_pk_check_fragment") == null) goto L15;
        ((RandomPKCheckFragment) r100.findFragmentByTag("random_pk_check_fragment")).dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L15;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L15:
        if (r100.findFragmentByTag("randon_pk_attention_fragment") == null) goto L23;
        ((RandomPKAttentionFragment) r100.findFragmentByTag("randon_pk_attention_fragment")).dismiss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L23;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Lists.isEmpty(this.f92327n) == true) goto L8;
        Iterator r100 = ((ArrayList) this.f92327n).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Runnable) r100.next()).run();
    L8:
        ((ArrayList) this.f92327n).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void so() {
        if ((T90() instanceof AnchorInteractContainerFragment) == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r100 = this.f92331r.findViewById(R.id.title_container).getLayoutParams();
        r100.height = s1.f(106.0f);
        this.f92331r.findViewById(R.id.title_container).setBackgroundColor(0);
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.f92328o.isEmpty() == true) goto L10;
        this.f92334u = true;
        S90(new m(this));
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final LifecycleOwner getLifecycleOwner() {
        return this.f92326m;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void F4(final boolean r100) {
        this.f92334u = r100;
        setCancelable(r100);
        setBottomSheetSlideProcessor(new i(r100));
    }

    public final void S90(Runnable r100) {
        if (isResumed() == false) goto L5;
        r100.run();
        return;
    L5:
        ((ArrayList) this.f92327n).add(r100);
    }

    public final void V90(Fragment r100) {
        if (r100 == null) goto L9;
        if (this.f92328o.empty() == false) goto L6;
        return;
    L6:
        if (this.f92328o.peek().getView() == null) goto L15;
        this.f92328o.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.f92328o.empty() == false) goto L11;
        return;
    L11:
        if (this.f92328o.peek().getView() == null) goto L18;
        this.f92328o.peek().getView().setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f92324k = new h();
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_in);
        this.f92336w = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_out);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.r
    public final void zD(final RevInteractDialogFragmentBaseContract$View r100) {
        if (getDialog() == null) goto L8;
        if (r100 == null) goto L9;
        this.f92334u = true;
        S90(new n(this, r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        getChildFragmentManager().addOnBackStackChangedListener(new j(this));
        if (this.f92328o.empty() == false) goto L36;
        RevInteractDialogFragmentBaseContract$View r102 = this.f92319f;
        if (r102 == null) goto L7;
        zD(r102);
        goto L36
    L7:
        int r103 = this.f92318e;
        if (r103 == 1) goto L20;
        if (r103 != 10) goto L12;
        DataCenter r104 = this.f92325l;
        a r105 = this.f92329p;
        int r106 = r105.f92343g;
        boolean r107 = r105.f92344h;
        int r108 = AnchorInteractContainerFragment.S;
        zD(AnchorInteractContainerFragment.Companion.a(this, r104, r106, "", r107, ""));
        this.f92329p.f92344h = false;
        goto L36
    L12:
        if (r103 != 12) goto L14;
        int r109 = InteractPkPrecisionMatchInviteFragment.f95709x;
        zD(InteractPkPrecisionMatchInviteFragment.a.a(this, this.f92325l, 1, this.f92329p.f92345i));
        goto L36
    L14:
        if (r103 != 13) goto L36;
        int r110 = InteractPkPrecisionMatchInviteFragment.f95709x;
        zD(InteractPkPrecisionMatchInviteFragment.a.a(this, this.f92325l, 2, null));
        goto L36
    L20:
        if (TextUtils.isEmpty(this.f92329p.f92341e) == true) goto L22;
        a r111 = this.f92329p;
        r111.f92341e = getString(R.string.ttlive_live_interact_pk_invite);
    L22:
        i6 r112 = this.f92329p.f92342f;
        if (r112 == null) goto L36;
        if (j6.a(r112) == null) goto L36;
        if (j6.a(this.f92329p.f92342f).getInviteRoom() == null) goto L36;
        i6 r113 = this.f92329p.f92342f;
        InteractPKBeInviteFragment.T.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r113, "linkerMessage");
        InteractPKBeInviteFragment r114 = new InteractPKBeInviteFragment();
        r114.f92316f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.d(r114, j6.a(r113));
        r114.f92314d = this;
        r114.f95646l = getCurrentRoom().getOwner();
        r114.f95649o = getCurrentRoom().getId();
        r114.P = r113;
        if (r113 == null) goto L35;
        IBattleLinkerInviteMessageExtra r115 = j6.a(r113);
        Intrinsics.checkNotNull(r115);
        if (r115.getInviteRoom() == null) goto L34;
        IRoom r116 = r115.getInviteRoom();
        Intrinsics.checkNotNull(r116);
        r114.f95647m = r116.getOwner();
    L34:
        r114.f95648n = r113.getLinkerId();
        r114.f95656v = r115.getInviteRoom();
        r114.f95655u = r115.getTips();
        r114.f95657w = (int) r115.getInviteType();
        r114.f95658x = r115.getExtra();
        r114.f95659y = r115.getTagList();
        r114.L = r115;
    L35:
        this.f92335v = r114;
        zD(r114);
    L36:
        String r117 = getString(R.string.ttlive_live_interact_title_pk);
        KProperty[] r118 = l51.a.f507436a;
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        l51.a.H.setValue(null, l51.a.f507436a[33], r117);
        setBottomSheetSlideProcessor(new k());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_rev_interact_dialog, r101, false);
        this.f92331r = r103;
        this.f92323j = (TextView) r103.findViewById(R.id.tv_title);
        this.f92321h = (ViewGroup) this.f92331r.findViewById(R.id.layout_left_view);
        this.f92322i = (ViewGroup) this.f92331r.findViewById(R.id.layout_right_view);
        this.f92320g = (ViewGroup) this.f92331r.findViewById(R.id.fragment_container);
        this.f92332s = this.f92331r.findViewById(R.id.view_shadow);
        View r104 = this.f92331r.findViewById(R.id.outside);
        this.f92333t = r104;
        r104.setAlpha(0.0f);
        this.f92333t.setOnClickListener(new l(this));
        return this.f92331r;
    }
}
