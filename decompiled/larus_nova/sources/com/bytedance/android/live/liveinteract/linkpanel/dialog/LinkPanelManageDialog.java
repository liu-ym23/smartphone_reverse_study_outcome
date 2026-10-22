package com.bytedance.android.live.liveinteract.linkpanel.dialog;

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
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.AudioTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkGuestInviteFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkManagePanel;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.MultiLinkIntegrationPlayMethodFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.VideoTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.util.r;
import com.bytedance.android.live.liveinteract.linkpanel.util.s;
import com.bytedance.android.live.liveinteract.linkpanel.util.t;
import com.bytedance.android.live.liveinteract.linkpanel.util.u;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class LinkPanelManageDialog extends LiveDialogFragment implements yf0.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f74394v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f74395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f74396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f74397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f74398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f74399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f74400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.linkpanel.presenter.g f74401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DataCenter f74402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LifecycleOwner f74403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Runnable> f74404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Stack<InteractDialogFragmentBaseContract$View> f74405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f74406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ValueAnimator f74407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f74408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f74409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f74410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f74411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Animation f74412u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataCenter f74413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LifecycleOwner f74414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f74415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IRoom f74416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f74417e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f74418f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f74419g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public IRoom f74420h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f74421i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f74422j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f74423k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<k1> f74424l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f74425m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f74426n;

        public final LinkPanelManageDialog a(int r100) {
            LinkPanelManageDialog r101 = new LinkPanelManageDialog();
            r101.f74406o = this;
            r101.f74403l = this.f74414b;
            r101.f74402k = this.f74413a;
            r101.f74395d = r100;
            r101.f74396e = this.f74415c;
            return r101;
        }

        public a(DataCenter r100, LifecycleOwner r101, Runnable r102) {
            this.f74413a = r100;
            this.f74414b = r101;
            this.f74415c = r102;
        }
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        if (this.f74405n.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f74405n.peek().U90() == null) goto L9;
        this.f74405n.peek().U90().performClick();
        return true;
    L9:
        if (this.f74405n.size() == 1) goto L11;
        return false;
    L11:
        if (this.f74411t == true) goto L21;
    L18:
        return true;
    L21:
        dismiss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L18;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ViewGroup r100 = this.f74398g;
        if (r100 == null) goto L5;
        r100.removeAllViews();
        this.f74398g = null;
    L5:
        ViewGroup r101 = this.f74399h;
        if (r101 == null) goto L8;
        r101.removeAllViews();
        this.f74399h = null;
    L8:
        super.onDestroyView();
        ValueAnimator r102 = this.f74407p;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f74405n.removeAllElements();
        if (z.a() == null) goto L22;
        t61 r103 = z.a();
        if (r103 == null) goto L16;
        boolean r104 = u61.c(r103);
    L17:
        if (r104 == true) goto L19;
        return;
    L19:
        if (getHost() == null) goto L24;
        getChildFragmentManager().getFragments().clear();
        return;
    L24:
        return;
    L16:
        r104 = false;
        goto L17
    }

    @Override // yf0.g
    public final int s9() {
        return this.f74405n.size();
    }

    public LinkPanelManageDialog() {
        this.f74395d = 0;
        this.f74404m = new ArrayList();
        this.f74405n = new Stack();
        this.f74411t = true;
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
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final IRoom getCurrentRoom() {
        o r100 = m.i();
        if (r100 != null) goto L5;
    L9:
        IRoom r101 = null;
    L10:
        HashMap r102 = new HashMap();
        if (r101 != null) goto L13;
        r102.put("dataCenter", this.f74402k);
        r102.put("roomContext", r100);
        r102.put("getRoomFromRoomContext", "null");
        r101 = m.i().getCurrentRoom();
    L13:
        if (r101 != null) goto L16;
        r102.put("getRoomFromService", "null");
        return (IRoom) vh7.f.c(IRoom.class);
    L16:
        return r101;
    L5:
        if (r100.getRoom() == null) goto L9;
        if (r100.getRoom().getValue() == null) goto L9;
        r101 = r100.getRoom().getValue();
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L12;
        ih0.c r100 = u.f75061a;
        ALogger.i("MultiLinkSettingPanelReuseManager", "releaseSettingPanelContainerCard call");
        ih0.c r101 = u.f75061a;
        if (r101 == null) goto L7;
        r101.J();
    L7:
        ih0.c r102 = u.f75061a;
        if (r102 == null) goto L10;
        r102.release();
    L10:
        u.f75061a = null;
    L12:
        if (z.a() == null) goto L21;
        t61 r103 = z.a();
        if (r103 == null) goto L16;
        boolean r104 = u61.c(r103);
    L17:
        if (r104 == false) goto L21;
        Runnable r105 = this.f74396e;
        if (r105 == null) goto L21;
        r105.run();
        this.f74396e = null;
        goto L21
    L16:
        r104 = false;
    L21:
        this.f74401j.f75009a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Lists.isEmpty(this.f74404m) == true) goto L8;
        Iterator r100 = ((ArrayList) this.f74404m).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Runnable) r100.next()).run();
    L8:
        ((ArrayList) this.f74404m).clear();
    }

    @Override // yf0.g
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.f74405n.isEmpty() == true) goto L10;
        this.f74411t = true;
        S90(new d(this));
        return;
    }

    @Override // yf0.g
    public final LifecycleOwner getLifecycleOwner() {
        return this.f74403l;
    }

    @Override // yf0.g
    public final void Rh(final InteractDialogFragmentBaseContract$View r100) {
        if (getDialog() == null) goto L6;
        this.f74411t = true;
        S90(new h(this, r100));
        return;
    }

    public final void S90(Runnable r100) {
        if (isResumed() == false) goto L5;
        r100.run();
        return;
    L5:
        ((ArrayList) this.f74404m).add(r100);
    }

    public final void U90(Fragment r100) {
        if (r100 == null) goto L9;
        if (this.f74405n.empty() == false) goto L6;
        return;
    L6:
        if (this.f74405n.peek().getView() == null) goto L15;
        this.f74405n.peek().getView().setVisibility(8);
        this.f74405n.peek().Z90();
        return;
    L15:
        return;
    L9:
        if (this.f74405n.empty() == false) goto L11;
        return;
    L11:
        if (this.f74405n.peek().getView() == null) goto L18;
        this.f74405n.peek().getView().setVisibility(0);
        this.f74405n.peek().Y90();
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Window r101 = getDialog().getWindow();
        if (r101 == null) goto L13;
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
        int r104 = c1.f78742a;
        int r105 = s1.f(375.0f);
        if (e5.n() == false) goto L14;
        r101.setGravity(5);
        r101.setLayout(r105, -1);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
        this.f74401j = new com.bytedance.android.live.liveinteract.linkpanel.presenter.g();
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_in);
        this.f74412u = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_out);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        super.onViewCreated(r100, r110);
        getChildFragmentManager().addOnBackStackChangedListener(new f(this));
        if (this.f74405n.empty() == false) goto L29;
        int r101 = this.f74395d;
        DataContext r102 = null;
        if (r101 != 7) goto L7;
        DataCenter r103 = this.f74402k;
        a r111 = this.f74406o;
        int r104 = r111.f74417e;
        String r105 = r111.f74419g;
        int r112 = r111.f74418f;
        int r106 = LinkManagePanel.f74538w;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        Intrinsics.checkNotNullParameter(r105, "requestPage");
        LinkManagePanel r107 = new LinkManagePanel();
        r107.f74347d = this;
        r107.f74548p = r103;
        r107.f74546n = r104;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r107.f74547o = r105;
        r107.f74550r = r112;
        r107.f74545m = ((Boolean) r103.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        DataContext r108 = com.bytedance.live.datacontext.d.d(o.class);
        if ((r108 instanceof DataContext) == false) goto L28;
        r102 = r108;
    L28:
        r107.f74549q = r102;
        Rh(r107);
        goto L29
    L7:
        if (r101 == 17) goto L19;
        switch(r101) {
            case 24: goto L16;
            case 25: goto L14;
            case 26: goto L11;
            default: goto L29;
        };
    L14:
        int r109 = MultiLinkIntegrationPlayMethodFragment.f74558q;
        a r113 = this.f74406o;
        Rh(MultiLinkIntegrationPlayMethodFragment.a.a(this, r113.f74420h, this.f74402k, r113.f74424l, r113.f74425m, r113.f74426n, false));
        goto L29
    L11:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L13;
        DataCenter r114 = this.f74402k;
        IRoom r115 = this.f74406o.f74420h;
        DataContext r116 = com.bytedance.live.datacontext.d.d(o.class);
        a r117 = this.f74406o;
        String r118 = r117.f74419g;
        int r119 = r117.f74418f;
        SettingLynxContainerFragment.f74595r.getClass();
        Rh(SettingLynxContainerFragment.a.a(this, r114, r115, r116, r118, r119, false));
        goto L29
    L13:
        int r120 = AudioTalkSettingFragment.f74464w;
        Rh(AudioTalkSettingFragment.a.a(this, this.f74406o.f74420h, com.bytedance.live.datacontext.d.d(o.class), this.f74402k, this.f74406o.f74419g));
        goto L29
    L16:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L18;
        DataCenter r121 = this.f74402k;
        a r122 = this.f74406o;
        IRoom r123 = r122.f74420h;
        int r124 = r122.f74418f;
        SettingLynxContainerFragment.f74595r.getClass();
        Rh(SettingLynxContainerFragment.a.a(this, r121, r123, null, null, r124, false));
        goto L29
    L18:
        int r125 = VideoTalkSettingFragment.f74636z;
        a r126 = this.f74406o;
        Rh(VideoTalkSettingFragment.a.a(this, r126.f74420h, r126.f74421i, r126.f74422j, r126.f74418f, this.f74402k, r126.f74423k, false));
        goto L29
    L19:
        DataCenter r127 = this.f74402k;
        a r128 = this.f74406o;
        String r129 = r128.f74419g;
        int r130 = r128.f74418f;
        int r131 = LinkGuestInviteFragment.f74516p;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r127, "dataCenter");
        Intrinsics.checkNotNullParameter(r129, "requestPage");
        LinkGuestInviteFragment r132 = new LinkGuestInviteFragment();
        r132.f74347d = this;
        r132.f74523m = r127;
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r132.f74522l = r129;
        r132.f74525o = r130;
        DataContext r133 = com.bytedance.live.datacontext.d.d(o.class);
        if ((r133 instanceof DataContext) == false) goto L23;
        r102 = r133;
    L23:
        r132.f74524n = r102;
        Rh(r132);
    L29:
        com.bytedance.android.livesdk.sharedpref.e<String> r134 = b6.f65259t;
        String r135 = getString(R.string.ttlive_live_interact_title_pk);
        r134.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r134, r135);
        setBottomSheetSlideProcessor(new g());
        Context r136 = getContext();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L38;
        if (r136 == null) goto L39;
        a r137 = this.f74406o;
        if (r137 == null) goto L40;
        ih0.c r138 = u.f75061a;
        DataCenter r139 = this.f74402k;
        int r140 = r137.f74418f;
        Intrinsics.checkNotNullParameter(r136, PerfLog.PARAM_KEY_CONTEXT_ID);
        IInteractService r141 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r141 == null) goto L41;
        r141.composeMultiLinkDisposableCall(Observable.fromCallable(new r(r136, r139, r140)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s.f75059a, t.f75060a));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_interact_dialog, r101, false);
        this.f74408q = r103;
        this.f74400i = (TextView) r103.findViewById(R.id.tv_title);
        this.f74398g = (ViewGroup) this.f74408q.findViewById(R.id.layout_left_view);
        this.f74399h = (ViewGroup) this.f74408q.findViewById(R.id.layout_right_view);
        this.f74397f = (ViewGroup) this.f74408q.findViewById(R.id.fragment_container);
        this.f74409r = this.f74408q.findViewById(R.id.view_shadow);
        View r104 = this.f74408q.findViewById(R.id.outside);
        this.f74410s = r104;
        r104.setAlpha(0.0f);
        this.f74410s.setOnClickListener(new e(this));
        return this.f74408q;
    }
}
