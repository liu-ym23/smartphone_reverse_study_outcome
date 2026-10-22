package com.bytedance.android.live.livepkaudience.dialog;

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
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class RevLinkDialog extends LiveDialogFragment implements k0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f81774u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f81775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f81776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f81777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f81778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f81779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c0 f81780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DataCenter f81781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LifecycleOwner f81782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Runnable> f81783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Stack<RevInteractDialogFragmentBaseContract$View> f81784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f81785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f81786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f81787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f81788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f81789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f81790s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animation f81791t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataCenter f81792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f81793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Room f81794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f81795d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f81796e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f81797f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f81798g;

        public a(DataCenter r100, LifecycleOwner r101) {
            this.f81792a = r100;
            this.f81793b = r101;
        }

        public final RevLinkDialog a(String r100, int r101, Room r102, boolean r103) {
            this.f81795d = 0;
            this.f81798g = r100;
            this.f81796e = r101;
            this.f81794c = r102;
            this.f81797f = r103;
            RevLinkDialog r104 = new RevLinkDialog();
            r104.f81785n = this;
            r104.f81782k = this.f81793b;
            r104.f81781j = this.f81792a;
            r104.f81775d = 16;
            return r104;
        }
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        if (this.f81784m.isEmpty() == true) goto L15;
        this.f81784m.peek().getClass();
        if (this.f81784m.size() == 1) goto L7;
        return false;
    L7:
        if (this.f81790s == true) goto L17;
    L14:
        return true;
    L17:
        dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L14;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    L15:
        return false;
    }

    public RevLinkDialog() {
        this.f81775d = 0;
        this.f81783l = new ArrayList();
        this.f81784m = new Stack();
        this.f81790s = true;
    }

    public final void S90() {
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
        S90();
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
        this.f81780i.f81802a.clear();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        getFragmentManager();
        ViewGroup r100 = this.f81777f;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        ViewGroup r101 = this.f81778g;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r102 = this.f81786o;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f81784m.removeAllElements();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Lists.isEmpty(this.f81783l) == true) goto L8;
        Iterator r100 = ((ArrayList) this.f81783l).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Runnable) r100.next()).run();
    L8:
        ((ArrayList) this.f81783l).clear();
    }

    public final void T90(Fragment r100) {
        if (r100 == null) goto L9;
        if (this.f81784m.empty() == false) goto L6;
        return;
    L6:
        if (this.f81784m.peek().getView() == null) goto L15;
        this.f81784m.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.f81784m.empty() == false) goto L11;
        return;
    L11:
        if (this.f81784m.peek().getView() == null) goto L18;
        this.f81784m.peek().getView().setVisibility(0);
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
        this.f81780i = new c0();
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_in);
        this.f81791t = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_out);
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
        getChildFragmentManager().addOnBackStackChangedListener(new d0(this));
        if (this.f81784m.empty() == true) goto L5;
    L13:
        com.bytedance.android.livesdk.sharedpref.e<String> r102 = com.bytedance.android.livesdk.sharedpref.b.T;
        String r103 = getString(R.string.ttlive_live_interact_title_pk);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        setBottomSheetSlideProcessor(new e0());
        return;
    L5:
        if (this.f81775d != 16) goto L13;
        DataCenter r104 = this.f81781j;
        a r105 = this.f81785n;
        int r106 = r105.f81795d;
        String r107 = r105.f81798g;
        int r108 = r105.f81796e;
        Room r109 = r105.f81794c;
        boolean r110 = r105.f81797f;
        int r111 = PkAdminInviteFragment.f81625w;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r104, "dataCenter");
        Intrinsics.checkNotNullParameter(r107, "requestPage");
        final PkAdminInviteFragment r112 = new PkAdminInviteFragment();
        r112.f81771d = this;
        r112.f81634o = r104;
        r112.f81635p = r106;
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r112.f81636q = r107;
        r112.f81637r = r108;
        r112.f81638s = r109;
        r112.f81639t = r110;
        r112.f81630k = ((Boolean) r104.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (getDialog() == null) goto L13;
        this.f81790s = true;
        Runnable r113 = new g0(this, r112);
        if (isResumed() == false) goto L12;
        r113.run();
        goto L13
    L12:
        ((ArrayList) this.f81783l).add(r113);
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_pk_audience_interact_dialog, r101, false);
        this.f81787p = r103;
        this.f81779h = (TextView) r103.findViewById(R.id.tv_title);
        this.f81777f = (ViewGroup) this.f81787p.findViewById(R.id.layout_left_view);
        this.f81778g = (ViewGroup) this.f81787p.findViewById(R.id.layout_right_view);
        this.f81776e = (ViewGroup) this.f81787p.findViewById(R.id.fragment_container);
        this.f81788q = this.f81787p.findViewById(R.id.view_shadow);
        View r104 = this.f81787p.findViewById(R.id.outside);
        this.f81789r = r104;
        r104.setAlpha(0.0f);
        this.f81789r.setOnClickListener(new f0(this));
        return this.f81787p;
    }
}
