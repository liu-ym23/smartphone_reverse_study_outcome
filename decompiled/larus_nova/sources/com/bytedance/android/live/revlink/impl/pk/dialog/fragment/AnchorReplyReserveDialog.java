package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/AnchorReplyReserveDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorReplyReserveDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f95606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f95607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f95608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f95609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f95610e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorReplyReserveDialog f95611a;

        public b(AnchorReplyReserveDialog r100) {
            this.f95611a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<Integer, Unit> r101 = this.f95611a.f95610e;
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke(0);
        L5:
            AnchorReplyReserveDialog.M0(this.f95611a, 1);
            AnchorReplyReserveDialog.N0(this.f95611a, "accept");
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorReplyReserveDialog f95612a;

        public c(AnchorReplyReserveDialog r100) {
            this.f95612a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<Integer, Unit> r101 = this.f95612a.f95610e;
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke(1);
        L5:
            AnchorReplyReserveDialog.M0(this.f95612a, 2);
            AnchorReplyReserveDialog.N0(this.f95612a, "reject");
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorReplyReserveDialog f95613a;

        public d(AnchorReplyReserveDialog r100) {
            this.f95613a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<Boolean, Unit> r101 = this.f95613a.f95609d;
            if (r101 == null) goto L5;
            Unit r102 = r101.invoke(Boolean.FALSE);
        L5:
            AnchorReplyReserveDialog.N0(this.f95613a, "cancel");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_fragment_interact_pk_reserve_chose_dialog;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f95606a.dispose();
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(false);
        TextView r101 = (TextView) findViewById(R.id.tv_title);
        if (r101 != null) goto L5;
    L12:
        View r102 = findViewById(R.id.tv_accept);
        if (r102 == null) goto L15;
        r102.setOnClickListener(new b(this));
    L15:
        View r103 = findViewById(R.id.tv_refuse);
        if (r103 == null) goto L18;
        r103.setOnClickListener(new c(this));
    L18:
        View r104 = findViewById(R.id.tv_cancel);
        if (r104 == null) goto L21;
        r104.setOnClickListener(new d(this));
    L21:
        O0("livesdk_pk_invited_popup_show", new LinkedHashMap());
        return;
    L5:
        if (this.f95608c.length() <= 6) goto L11;
        StringBuilder r105 = new StringBuilder();
        String r106 = this.f95608c;
        if (r106 == null) goto L10;
        r105.append(r106.substring(0, 6));
        r105.append("...");
        this.f95608c = r105.toString();
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        com.bytedance.live.kmp.util.c r107 = com.bytedance.live.kmp.util.c.f255167a;
        int r108 = w11.a.f557889a;
        r101.setText(com.bytedance.live.kmp.util.c.a(R.string.ttlive_pk_reserve_dilaog_title, new Object[]{this.f95608c}));
        goto L12
    }

    public static final void M0(AnchorReplyReserveDialog r110, int r111) {
        r110.getClass();
        r31.a r100 = r31.b.a(r31.a.f535859a);
        o r101 = r110.f95607b;
        Observable<ExtraResponse<Object, Extra>> r112 = r100.F(r111, r101.f95967a, r101.f95968b, r101.f95969c, r101.f95970d, r101.f95972f, r101.f95973g);
        if (r112 == null) goto L7;
        Disposable r113 = r112.subscribe(new com.bytedance.android.live.revlink.impl.pk.dialog.fragment.a(r110), com.bytedance.android.live.revlink.impl.pk.dialog.fragment.b.f95949a);
        if (r113 == null) goto L7;
        r110.f95606a.add(r113);
    L7:
        Function1<Boolean, Unit> r114 = r110.f95609d;
        if (r114 == null) goto L11;
        Unit r115 = r114.invoke(Boolean.FALSE);
        return;
    }

    public static final void N0(AnchorReplyReserveDialog r100, String r101) {
        r100.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("selection", r101);
        r100.O0("livesdk_pk_invited_popup_click", r102);
        Handler r103 = DialogLancet.resolveDialogHandler(r100);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r103.getLooper()) goto L7;
        r103.post(DialogLancet.createDismissRunnable(r100));
    }

    public final void O0(String r100, Map<String, String> r101) {
        com.bytedance.android.live.revenue.core.util.j.a r102 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r103 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r102.a(), yz0.k.class);
        if (r103 == null) goto L8;
        IRoom r104 = r103.getRoom();
        if (r104 == null) goto L8;
        String r105 = r104.getAnchorId();
        if (r105 == null) goto L8;
    L9:
        r101.put("anchor_id", r105);
        yz0.k r106 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r102.a(), yz0.k.class);
        if (r106 == null) goto L15;
        IRoom r107 = r106.getRoom();
        if (r107 == null) goto L15;
        String r108 = String.valueOf(r107.getId());
        if (r108 == null) goto L15;
    L16:
        r101.put("room_id", r108);
        r101.put("anchor_connect_status", "0");
        r101.put("request_id", "");
        r101.put("channel_id", "");
        r101.put("pk_id", "0");
        r101.put("source", "pk_invite_record");
        r101.put("inviter_room_status", "2");
        r101.put("inviter_id", this.f95607b.f95968b.toString());
        r101.put("inviter_room_id", String.valueOf(this.f95607b.f95969c));
        mz0.n r109 = new mz0.n();
        Map<String, String> r110 = r109.f516447a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r101, "map");
        r110.putAll(r101);
        mz0.m r111 = new mz0.m();
        r111.b(LogCommon.ROOM);
        List<Object> r112 = r109.f516448b;
        ArrayList r113 = (ArrayList) r112;
        r113.addAll(r111.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r115);
        ((mz0.i) ((f80.a) r115)).w3(r100, r109.f516447a, r109.f516448b);
        return;
    L15:
        r108 = "";
    L8:
        r105 = "";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorReplyReserveDialog(Context r100, o r101, String r102, Function1<? super Boolean, Unit> r103, Function1<? super Integer, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "replayParams");
        Intrinsics.checkNotNullParameter(r102, "userName");
        super(r100);
        this.f95607b = r101;
        this.f95608c = r102;
        this.f95609d = r103;
        this.f95610e = r104;
        this.f95606a = new CompositeDisposable();
    }
}
