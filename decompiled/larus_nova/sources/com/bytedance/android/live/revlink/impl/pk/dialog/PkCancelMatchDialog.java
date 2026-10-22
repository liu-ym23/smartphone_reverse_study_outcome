package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkCancelMatchDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkCancelMatchDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f95376i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f95377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f95378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.f f95379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.n f95380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f95381h;

    public static final class a extends com.bytedance.android.live.revenuelink.connect.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkCancelMatchDialog f95382a;

        public a(PkCancelMatchDialog r100) {
            this.f95382a = r100;
        }

        public static void a(Dialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void q9(d11.c r100, long r101, ey.l r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            Dialog r103 = this.f95382a.getDialog();
            if (r103 == null) goto L6;
            a(r103);
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void wh(d11.c r100, Throwable r101, long r102, ey.l r103) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            Dialog r104 = this.f95382a.getDialog();
            if (r104 == null) goto L6;
            a(r104);
            return;
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkCancelMatchDialog f95383a;

        public b(PkCancelMatchDialog r100) {
            this.f95383a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            PkCancelMatchDialog r101 = this.f95383a;
            int r102 = PkCancelMatchDialog.f95376i;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L18;
            if (r104 == null) goto L21;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L9;
            View r106 = r105.getCurrentFocus();
        L10:
            if (r106 == null) goto L22;
            InputMethodManager r107 = (InputMethodManager) r104.getSystemService("input_method");
            if (r107 != null) goto L15;
            return;
        L15:
            if (r107.isActive() == false) goto L20;
            r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L9:
            r106 = null;
            goto L10
        L21:
            return;
        }
    }

    public PkCancelMatchDialog() {
        this.f95377d = new LinkedHashMap();
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        com.bytedance.android.live.revenuelink.connect.n r101 = null;
        if (r100 == null) goto L5;
        IRoom r102 = r100.getRoom();
    L6:
        this.f95378e = r102;
        this.f95379f = com.bytedance.android.live.revlink.impl.global.b.a();
        com.bytedance.android.live.revlink.impl.pk.service.b r103 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r103 == null) goto L9;
        r101 = r103.getLinkOutManagerFn();
    L9:
        this.f95380g = r101;
        this.f95381h = new a(this);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.revenuelink.connect.f r100 = this.f95379f;
        if (r100 == null) goto L6;
        r100.removeLinkOutListener(1, this.f95381h);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f95377d.clear();
    }

    public final View S90(int r100) {
        if (this.f95377d != null) goto L5;
        this.f95377d = new LinkedHashMap();
    L5:
        View r101 = this.f95377d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f95377d.put(Integer.valueOf(r100), r103);
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
        if (r101 == null) goto L13;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L14;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        r103.setPadding(0, 0, 0, 0);
        r102.setLayout(-1, -1);
        r102.setGravity(80);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(48);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
        com.bytedance.android.live.revenuelink.connect.f r101 = this.f95379f;
        if (r101 == null) goto L6;
        r101.addLinkOutListener(1, this.f95381h);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new b(this));
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    public static final void T90(PkCancelMatchDialog r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        w31.c r103 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r103 == null) goto L7;
        IRoom r104 = r103.k();
        if (r104 == null) goto L7;
        r102.put("invitee_id", String.valueOf(iz.a.a(r104.getOwner())));
    L7:
        r102.put("selection", r101);
        IPKLinkBizDataService r105 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r105 != null) goto L10;
    L12:
        r102.put("invite_mode", "routine_pk");
    L13:
        mz0.n r106 = new mz0.n();
        Map<String, String> r107 = r106.f516447a;
        Intrinsics.checkNotNullParameter(r107, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r107.putAll(r102);
        mz0.m r108 = new mz0.m();
        r108.b(LogCommon.ROOM);
        List<Object> r109 = r106.f516448b;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(r108.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_best_invite_recom_matching_selection", r106.f516447a, r106.f516448b);
        return;
    L10:
        if (r105.getIsInviteVote() != true) goto L12;
        r102.put("invite_mode", "vote");
        goto L13
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LinkCrossRoomDataHolder r102 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r102 != null) goto L5;
    L11:
        ((TextView) S90(R.id.title)).setText(R.string.ttlive_pk_cancel_random_title);
    L12:
        ((ImageView) S90(R.id.ttlive_close_icon)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.a(this));
        ((Button) S90(R.id.ttlive_end)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.b(this));
        ((Button) S90(R.id.ttlive_cancel)).setOnClickListener(new c(this));
        return;
    L5:
        if (r102.i() != 0) goto L11;
        ((TextView) S90(R.id.title)).setText(R.string.ttlive_pk_cancel_invite_title);
        IPKLinkBizDataService r103 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r103 == null) goto L12;
        if (r103.getIsInviteVote() != true) goto L12;
        ((TextView) S90(R.id.title)).setText(s1.B(R.string.ttlive_interact_async_vote_invite_cancel));
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_pk_cancel_match, r101, false);
    }
}
