package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeCancelOperateDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeCancelOperateDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int F = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;
    public DataCenter E;

    public static final class a {
    }

    public static final class b implements MultiLinkEnlargeSelectGuestDialog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiLinkEnlargeCancelOperateDialog f72772a;

        public b(MultiLinkEnlargeCancelOperateDialog r100) {
            this.f72772a = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeSelectGuestDialog.b
        public final void a(List<String> r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "selectedUserIdList");
            Intrinsics.checkNotNullParameter(r101, "unSelectedUserIdList");
            if (je0.d.D() == false) goto L14;
            k.f537953m2.getClass();
            if (k.a.a() == null) goto L9;
            k r102 = k.a.a();
            if (r102 == null) goto L25;
            r102.closeMultiEnlargePosition(this.f72772a.B, r101);
            return;
        L25:
            return;
        L9:
            com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
            if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L27;
            com.bytedance.android.live.liveinteract.voicechat.d r103 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
            if (r103 == null) goto L28;
            r103.closeMultiEnlargePosition(this.f72772a.B, r101);
            return;
        L28:
            return;
        L27:
            return;
        L14:
            com.bytedance.android.live.liveinteract.plantform.base.k.f75492n0.getClass();
            if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L19;
            com.bytedance.android.live.liveinteract.plantform.base.k r104 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
            if (r104 == null) goto L30;
            r104.closeMultiEnlargePosition(this.f72772a.B, r101);
            return;
        L30:
            return;
        L19:
            IVoiceChatAdminService.Companion.getClass();
            if (IVoiceChatAdminService.a.a() == null) goto L32;
            IVoiceChatAdminService r105 = IVoiceChatAdminService.a.a();
            if (r105 == null) goto L33;
            r105.closeMultiEnlargePosition(this.f72772a.B, r101);
            return;
        L33:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_multi_link_enlarge_cancel_operate;
    }

    public final void W0() {
        int r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList().size();
        CPositionContext r101 = CPositionContext.Companion.getContext();
        if (r101 == null) goto L9;
        m<EnlargeGuestInfo> r102 = r101.getEnlargeGuestInfo();
        if (r102 == null) goto L9;
        EnlargeGuestInfo r103 = r102.getValue();
        if (r103 == null) goto L9;
        long r104 = r103.getSourceUILayoutMaxMembers();
    L11:
        if (r100 <= r104) goto L18;
        int r105 = MultiLinkEnlargeSelectGuestDialog.F;
        Context r106 = getContext();
        DataCenter r107 = this.E;
        b r108 = new b(this);
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "selectedResultListener");
        MultiLinkEnlargeSelectGuestDialog r109 = new MultiLinkEnlargeSelectGuestDialog(r106);
        r109.B = r108;
        r109.E = r107;
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L16:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    L18:
        if (je0.d.D() == false) goto L29;
        k.f537953m2.getClass();
        if (k.a.a() == null) goto L24;
        k r110 = k.a.a();
        if (r110 == null) goto L45;
        r110.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L45:
        return;
    L24:
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L47;
        com.bytedance.android.live.liveinteract.voicechat.d r111 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r111 == null) goto L48;
        r111.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L48:
        return;
    L47:
        return;
    L29:
        com.bytedance.android.live.liveinteract.plantform.base.k.f75492n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L34;
        com.bytedance.android.live.liveinteract.plantform.base.k r112 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r112 == null) goto L50;
        r112.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L50:
        return;
    L34:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L52;
        IVoiceChatAdminService r113 = IVoiceChatAdminService.a.a();
        if (r113 == null) goto L53;
        r113.closeMultiEnlargePosition(this.B, new ArrayList());
        return;
    L53:
        return;
    L52:
        return;
    L9:
        r104 = 0;
        goto L11
    }

    public final void X0() {
        int r100 = MultiLinkEnlargeSelectNewEnlargeUserDialog.H;
        Context r101 = getContext();
        long r102 = this.B;
        String r103 = this.C;
        DataCenter r104 = this.E;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "targetUserId");
        MultiLinkEnlargeSelectNewEnlargeUserDialog r105 = new MultiLinkEnlargeSelectNewEnlargeUserDialog(r101);
        r105.B = r102;
        r105.C = r103;
        r105.G = r104;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.D.clear();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public MultiLinkEnlargeCancelOperateDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.C = "";
        this.D = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((TextView) findViewById(R.id.operate_changed_tv)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$1(this)));
        ((TextView) findViewById(R.id.operate_cancel_single_tv)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$2(this)));
        ((TextView) findViewById(R.id.operate_cancel_all_tv)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$3(this)));
        ((TextView) findViewById(R.id.operate_cancel_tv)).setOnClickListener(x0.a(new MultiLinkEnlargeCancelOperateDialog$initView$4(this)));
        Iterable r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((!((ILinkPlayerInfoBridge) r104).isEnlarged()) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        int r105 = r102.size();
        CPositionContext.a r106 = CPositionContext.Companion;
        CPositionContext r107 = r106.getContext();
        if (r107 == null) goto L15;
        m<EnlargeGuestInfo> r108 = r107.getEnlargeGuestInfo();
        if (r108 == null) goto L15;
        EnlargeGuestInfo r109 = r108.getValue();
        if (r109 == null) goto L15;
        long r110 = r109.getMaxMemberExceptEnlarge();
    L16:
        long r111 = r105;
        if (r111 < r110) goto L19;
        UtilityKotlinExtentionsKt.w(findViewById(R.id.operate_changed_tv));
        UtilityKotlinExtentionsKt.w(findViewById(R.id.operate_cancel_all_tv));
    L20:
        Integer r112 = je0.d.h();
        if (r112 != null) goto L24;
    L29:
        CPositionContext r113 = r106.getContext();
        if (r113 == null) goto L44;
        m<EnlargeGuestInfo> r114 = r113.getEnlargeGuestInfo();
        if (r114 == null) goto L45;
        Observable<EnlargeGuestInfo> r115 = r114.a();
        if (r115 == null) goto L46;
        Disposable r116 = r115.subscribe(new com.bytedance.android.live.liveinteract.enlarge.dialog.a(this));
        if (r116 == null) goto L47;
        this.D.add(r116);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L24:
        if (r112.intValue() != 26) goto L29;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() != 26) goto L29;
        if (r111 < r110) goto L29;
        UtilityKotlinExtentionsKt.t(findViewById(R.id.operate_cancel_all_tv));
        goto L29
    L19:
        UtilityKotlinExtentionsKt.w(findViewById(R.id.operate_cancel_single_tv));
        UtilityKotlinExtentionsKt.w(findViewById(R.id.operate_cancel_all_tv));
    L15:
        r110 = 0;
        goto L16
    }
}
