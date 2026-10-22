package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.InteractAudienceContainerFragment;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceContainerFragmentV2;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.MultiLinkIntegrationPlayMethodFragment;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeFragment;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeWithPreApplyFragment;
import com.bytedance.android.live.liveinteract.videotalk.fragment.VideoRoomPreApplyFragment;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fe0.b;
import fe0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import vh7.f;
import yf0.g;

/* JADX INFO: loaded from: classes46.dex */
public class LinkDialog extends LiveDialogFragment implements g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f72073v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InteractDialogFragmentBaseContract$View f72075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f72076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f72077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f72078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f72079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ie0.a f72080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DataCenter f72081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LifecycleOwner f72082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Runnable> f72083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Stack<InteractDialogFragmentBaseContract$View> f72084n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f72085o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f72086p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f72087q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f72088r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f72089s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f72090t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Animation f72091u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataCenter f72092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f72093b;

        public final LinkDialog a() {
            LinkDialog r100 = new LinkDialog();
            r100.f72085o = this;
            r100.f72082l = this.f72093b;
            r100.f72081k = this.f72092a;
            return r100;
        }

        public final LinkDialog b(int r100) {
            LinkDialog r101 = new LinkDialog();
            r101.f72085o = this;
            r101.f72082l = this.f72093b;
            r101.f72081k = this.f72092a;
            r101.f72074d = r100;
            return r101;
        }

        public a(DataCenter r100, LifecycleOwner r101) {
            this.f72092a = r100;
            this.f72093b = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        if (this.f72084n.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f72084n.peek().U90() == null) goto L9;
        this.f72084n.peek().U90().performClick();
        return true;
    L9:
        if (this.f72084n.size() == 1) goto L11;
        return false;
    L11:
        if (this.f72090t == true) goto L21;
    L18:
        return true;
    L21:
        dismiss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L18;
        d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ViewGroup r100 = this.f72077g;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        ViewGroup r101 = this.f72078h;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r102 = this.f72086p;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f72084n.removeAllElements();
    }

    @Override // yf0.g
    public final int s9() {
        return this.f72084n.size();
    }

    public LinkDialog() {
        this.f72074d = 0;
        this.f72083m = new ArrayList();
        this.f72084n = new Stack();
        this.f72090t = true;
    }

    public final void T90() {
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
        T90();
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f72080j.f489457a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Lists.isEmpty(this.f72083m) == true) goto L8;
        Iterator r100 = ((ArrayList) this.f72083m).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Runnable) r100.next()).run();
    L8:
        ((ArrayList) this.f72083m).clear();
    }

    @Override // yf0.g
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.f72084n.isEmpty() == true) goto L10;
        this.f72090t = true;
        S90(new c(this));
        return;
    }

    @Override // yf0.g
    public final LifecycleOwner getLifecycleOwner() {
        return this.f72082l;
    }

    @Override // yf0.g
    public final void Rh(final InteractDialogFragmentBaseContract$View r100) {
        if (getDialog() == null) goto L8;
        if (r100 == null) goto L9;
        this.f72090t = true;
        S90(new fe0.d(this, r100));
        return;
    L9:
        return;
    }

    public final void S90(Runnable r100) {
        if (isResumed() == false) goto L5;
        r100.run();
        return;
    L5:
        ((ArrayList) this.f72083m).add(r100);
    }

    public final void U90(Fragment r100) {
        if (r100 == null) goto L9;
        if (this.f72084n.empty() == false) goto L6;
        return;
    L6:
        if (this.f72084n.peek().getView() == null) goto L15;
        this.f72084n.peek().getView().setVisibility(8);
        this.f72084n.peek().Z90();
        return;
    L15:
        return;
    L9:
        if (this.f72084n.empty() == false) goto L11;
        return;
    L11:
        if (this.f72084n.peek().getView() == null) goto L18;
        this.f72084n.peek().getView().setVisibility(0);
        this.f72084n.peek().Y90();
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Window r101 = getDialog().getWindow();
        if (r101 == null) goto L11;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L9:
        r102.setPadding(0, 0, 0, 0);
        r101.setLayout(-1, -1);
        r101.setGravity(80);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setSoftInputMode(48);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
        this.f72080j = new ie0.a();
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_in);
        this.f72091u = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_out);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        getChildFragmentManager().addOnBackStackChangedListener(new fe0.a(this));
        if (this.f72084n.empty() == false) goto L35;
        InteractDialogFragmentBaseContract$View r102 = this.f72075e;
        if (r102 == null) goto L7;
        Rh(r102);
        goto L35
    L7:
        int r103 = this.f72074d;
        if (r103 != 0) goto L10;
        DataCenter r104 = this.f72081k;
        AudienceTypeFragment r105 = new AudienceTypeFragment();
        r105.f76776g = r104;
        r105.f74347d = this;
        Rh(r105);
        goto L35
    L10:
        if (r103 != 15) goto L12;
        Rh(InteractAudienceContainerFragmentV2.aa0(this, this.f72081k));
        goto L35
    L12:
        if (r103 != 23) goto L14;
        int r106 = AudienceTypeWithPreApplyFragment.f76784k;
        DataCenter r107 = this.f72081k;
        IRoom r108 = m.i().getCurrentRoom();
        HashMap r109 = new HashMap();
        boolean r110 = true;
        if (r108 != null) goto L26;
        r109.put("dataCenter", this.f72081k);
        r109.put("getRoomFromRoomContext", "null");
        r108 = m.i().getCurrentRoom();
        boolean r111 = true;
    L27:
        if (r108 != null) goto L29;
        r109.put("getRoomFromService", "null");
        r108 = (IRoom) f.c(IRoom.class);
    L30:
        if (r110 == false) goto L32;
        com.bytedance.android.live.liveinteract.api.utils.g.s("LinkDialog.getCurrentRoom", r109);
    L32:
        AudienceTypeWithPreApplyFragment r112 = new AudienceTypeWithPreApplyFragment();
        AudienceTypeFragment r113 = new AudienceTypeFragment();
        r113.f76776g = r107;
        r113.f74347d = this;
        r112.f76785g = r113;
        VideoRoomPreApplyFragment r114 = new VideoRoomPreApplyFragment();
        r114.f74347d = this;
        r112.f76786h = r114;
        r112.f76787i = r107;
        r112.f76788j = r108;
        Rh(r112);
        goto L35
    L29:
        r110 = r111;
        goto L30
    L26:
        r111 = false;
        goto L27
    L14:
        if (r103 != 25) goto L16;
        int r115 = MultiLinkIntegrationPlayMethodFragment.f74558q;
        this.f72085o.getClass();
        DataCenter r116 = this.f72081k;
        this.f72085o.getClass();
        this.f72085o.getClass();
        this.f72085o.getClass();
        Rh(MultiLinkIntegrationPlayMethodFragment.a.a(this, null, r116, null, null, 0, false));
        goto L35
    L16:
        if (r103 != 8) goto L18;
        Rh(InteractAudienceContainerFragment.aa0(this, this.f72081k));
        goto L35
    L18:
        if (r103 != 9) goto L35;
        DataCenter r117 = this.f72081k;
        AudienceTypeFragment r118 = new AudienceTypeFragment();
        r118.f76776g = r117;
        r118.f74347d = this;
        Rh(r118);
    L35:
        e<String> r119 = b6.f65259t;
        String r120 = getString(R.string.ttlive_live_interact_title_pk);
        r119.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r119, r120);
        setBottomSheetSlideProcessor(new b());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_interact_dialog, r101, false);
        this.f72087q = r103;
        this.f72079i = (TextView) r103.findViewById(R.id.tv_title);
        this.f72077g = (ViewGroup) this.f72087q.findViewById(R.id.layout_left_view);
        this.f72078h = (ViewGroup) this.f72087q.findViewById(R.id.layout_right_view);
        this.f72076f = (ViewGroup) this.f72087q.findViewById(R.id.fragment_container);
        this.f72088r = this.f72087q.findViewById(R.id.view_shadow);
        View r104 = this.f72087q.findViewById(R.id.outside);
        this.f72089s = r104;
        r104.setAlpha(0.0f);
        this.f72089s.setOnClickListener(new fe0.e(this));
        return this.f72087q;
    }
}
