package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.enlarge.widget.MultiEnlargeSelectView;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeSelectEnlargePositionDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeSelectEnlargePositionDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int E = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_multi_enlarge_change_select;
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

    public MultiLinkEnlargeSelectEnlargePositionDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.C = "";
        this.D = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((TextView) findViewById(R.id.send_invite_btn)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$1(this)));
        ((MultiEnlargeSelectView) findViewById(R.id.first_enlarge_container)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$2(this)));
        ((MultiEnlargeSelectView) findViewById(R.id.second_enlarge_container)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectEnlargePositionDialog$initView$3(this)));
        i<ILinkPlayerInfoBridge> r101 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r101 == null) goto L14;
        Iterable r102 = r101.getOnlineUserList();
        if (r102 == null) goto L14;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((ILinkPlayerInfoBridge) r105).isEnlarged() == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        List r106 = CollectionsKt.sortedWith(r103, new b());
        if (r106 == null) goto L14;
    L16:
        if (r106.size() < 2) goto L18;
        ((MultiEnlargeSelectView) findViewById(R.id.first_enlarge_container)).R5((ILinkPlayerInfoBridge) ListProtector.get(r106, 0));
        ((MultiEnlargeSelectView) findViewById(R.id.first_enlarge_container)).S5(false);
        ((MultiEnlargeSelectView) findViewById(R.id.second_enlarge_container)).R5((ILinkPlayerInfoBridge) ListProtector.get(r106, 1));
        ((MultiEnlargeSelectView) findViewById(R.id.second_enlarge_container)).S5(false);
        ((MultiEnlargeSelectView) findViewById(R.id.first_enlarge_container)).S5(true);
    L18:
        CPositionContext r107 = CPositionContext.Companion.getContext();
        if (r107 == null) goto L33;
        m<EnlargeGuestInfo> r108 = r107.getEnlargeGuestInfo();
        if (r108 == null) goto L34;
        Observable<EnlargeGuestInfo> r109 = r108.a();
        if (r109 == null) goto L35;
        Disposable r110 = r109.subscribe(new c(this));
        if (r110 == null) goto L36;
        this.D.add(r110);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L14:
        r106 = new ArrayList();
        goto L16
    }
}
