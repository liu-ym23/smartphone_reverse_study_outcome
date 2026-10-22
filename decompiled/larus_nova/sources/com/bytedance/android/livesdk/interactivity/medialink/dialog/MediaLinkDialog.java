package com.bytedance.android.livesdk.interactivity.medialink.dialog;

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
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes9.dex */
public class MediaLinkDialog extends LiveDialogFragment implements t82.f {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f138058t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f138059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaInteractDialogFragmentBaseContract$View f138060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f138061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f138062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f138063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f138064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u82.i f138065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LifecycleOwner f138066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Runnable> f138067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Stack<MediaInteractDialogFragmentBaseContract$View> f138068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f138069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f138070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f138071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f138072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f138073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Animation f138074s;

    public final Room T90() {
        RoomContext.a r100 = RoomContext.Companion;
        r100.getClass();
        Room r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 != null) goto L5;
    L7:
        HashMap r103 = new HashMap();
        boolean r104 = true;
        if (r101 != null) goto L10;
        r103.put("roomContext", r102);
        r103.put("getRoomFromRoomContext", "null");
        r101 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        boolean r105 = true;
    L11:
        if (r101 != null) goto L13;
        r103.put("getRoomFromService", "null");
        r101 = new Room();
    L14:
        if (r104 == false) goto L16;
        com.bytedance.android.live.liveinteract.api.utils.g.s("MediaLinkDialog.getCurrentRoom", r103);
    L16:
        return r101;
    L13:
        r104 = r105;
        goto L14
    L10:
        r105 = false;
        goto L11
    L5:
        if (r102.getRoom() == null) goto L7;
        r101 = r102.getRoom().getValue();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        if (this.f138068m.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.f138068m.peek().U90() == null) goto L9;
        this.f138068m.peek().U90().performClick();
        return true;
    L9:
        if (this.f138068m.size() == 1) goto L11;
        return false;
    L11:
        if (this.f138073r == true) goto L21;
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
        ViewGroup r100 = this.f138062g;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        ViewGroup r101 = this.f138063h;
        if (r101 == null) goto L8;
        r101.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r102 = this.f138069n;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.f138068m.removeAllElements();
    }

    public MediaLinkDialog() {
        this.f138059d = 0;
        this.f138067l = new ArrayList();
        this.f138068m = new Stack();
        this.f138073r = true;
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
        this.f138065j.f549171a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (Lists.isEmpty(this.f138067l) == true) goto L8;
        Iterator r100 = ((ArrayList) this.f138067l).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((Runnable) r100.next()).run();
    L8:
        ((ArrayList) this.f138067l).clear();
    }

    @Override // t82.f
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.f138068m.isEmpty() == true) goto L10;
        this.f138073r = true;
        S90(new o(this));
        return;
    }

    @Override // t82.f
    public final LifecycleOwner getLifecycleOwner() {
        return this.f138066k;
    }

    @Override // t82.f
    public final void F4(final boolean r100) {
        this.f138073r = r100;
        setCancelable(r100);
        setBottomSheetSlideProcessor(new i(r100));
    }

    public final void S90(Runnable r100) {
        if (isResumed() == false) goto L5;
        r100.run();
        return;
    L5:
        ((ArrayList) this.f138067l).add(r100);
    }

    public final void V90(Fragment r100) {
        if (r100 == null) goto L9;
        if (this.f138068m.empty() == false) goto L6;
        return;
    L6:
        if (this.f138068m.peek().getView() == null) goto L15;
        this.f138068m.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.f138068m.empty() == false) goto L11;
        return;
    L11:
        if (this.f138068m.peek().getView() == null) goto L18;
        this.f138068m.peek().getView().setVisibility(0);
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
        this.f138065j = new u82.i();
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_in);
        this.f138074s = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_anchor_link_bottom_dialog_bg_out);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // t82.f
    public final void v20(final MediaInteractDialogFragmentBaseContract$View r100) {
        if (getDialog() == null) goto L8;
        if (r100 == null) goto L9;
        this.f138073r = true;
        S90(new m(this, r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        getChildFragmentManager().addOnBackStackChangedListener(new j(this));
        if (this.f138068m.empty() == false) goto L11;
        MediaInteractDialogFragmentBaseContract$View r102 = this.f138060e;
        if (r102 == null) goto L8;
        v20(r102);
        goto L11
    L8:
        if (this.f138059d != 10) goto L11;
        MediaAnchorInteractContainerFragment r103 = new MediaAnchorInteractContainerFragment();
        r103.f138106d = this;
        v20(r103);
    L11:
        setBottomSheetSlideProcessor(new k());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_fragment_media_interact_dialog, r101, false);
        this.f138070o = r103;
        this.f138064i = (TextView) r103.findViewById(R.id.tv_title);
        this.f138062g = (ViewGroup) this.f138070o.findViewById(R.id.layout_left_view);
        this.f138063h = (ViewGroup) this.f138070o.findViewById(R.id.layout_right_view);
        this.f138061f = (ViewGroup) this.f138070o.findViewById(R.id.fragment_container);
        this.f138071p = this.f138070o.findViewById(R.id.view_shadow);
        View r104 = this.f138070o.findViewById(R.id.outside);
        this.f138072q = r104;
        r104.setAlpha(0.0f);
        this.f138072q.setOnClickListener(new l(this));
        return this.f138070o;
    }
}
