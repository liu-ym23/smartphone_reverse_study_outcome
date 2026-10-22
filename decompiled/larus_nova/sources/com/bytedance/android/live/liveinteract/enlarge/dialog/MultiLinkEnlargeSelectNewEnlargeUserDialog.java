package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.enlarge.dialog.diff.MultiEnlargeGuestSelectedItemDecoration;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeSelectNewEnlargeUserDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeSelectNewEnlargeUserDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int H = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;
    public MultiTypeAdapter E;
    public List<MultiEnlargeGuestSelectViewBinder.b> F;
    public DataCenter G;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_multi_link_enlarge_select_new_enlarge_user;
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

    public MultiLinkEnlargeSelectNewEnlargeUserDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, false);
        this.C = "";
        this.D = new CompositeDisposable();
        this.F = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((TextView) findViewById(R.id.sure_btn)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectNewEnlargeUserDialog$initView$1(this)));
        MultiTypeAdapter r101 = new MultiTypeAdapter(this.F);
        this.E = r101;
        r101.z2(MultiEnlargeGuestSelectViewBinder.b.class, new MultiEnlargeGuestSelectViewBinder(new g(this)));
        SSGridLayoutManager r102 = new SSGridLayoutManager(getContext(), 4, 1);
        RecyclerView r103 = (RecyclerView) findViewById(R.id.guest_selected_rv);
        MultiTypeAdapter r104 = this.E;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L5:
        r103.setAdapter(r104);
        ((RecyclerView) findViewById(R.id.guest_selected_rv)).setLayoutManager(r102);
        ((RecyclerView) findViewById(R.id.guest_selected_rv)).addItemDecoration(new MultiEnlargeGuestSelectedItemDecoration());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r105 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.G);
        if (r105 == null) goto L38;
        List<ch0.e> r106 = r105.f().getValue();
        if (r106 == null) goto L28;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L11:
        if (r108.hasNext() == false) goto L15;
        Object r109 = r108.next();
        if (((ch0.e) r109).f23724a.isEnlarged() == true) goto L11;
        r107.add(r109);
        goto L11
    L15:
        List r110 = CollectionsKt.sortedWith(r107, new f());
        if (r110 == null) goto L28;
        List r111 = r110;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r113 = r111.iterator();
        int r114 = 0;
    L19:
        if (r113.hasNext() == false) goto L29;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        ch0.e r117 = (ch0.e) r115;
        if (r114 != 0) goto L26;
        MultiEnlargeGuestSelectViewBinder.b r118 = new MultiEnlargeGuestSelectViewBinder.b(true, r117.f23724a);
    L27:
        r112.add(r118);
        r114 = r116;
        goto L19
    L26:
        r118 = new MultiEnlargeGuestSelectViewBinder.b(false, r117.f23724a);
    L29:
        if (r112 == null) goto L31;
        this.F = r112;
    L31:
        MultiTypeAdapter r119 = this.E;
        if (r119 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L34:
        r119.f513437a = this.F;
        MultiTypeAdapter r120 = this.E;
        if (r120 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L37:
        r120.notifyDataSetChanged();
    L28:
        r112 = null;
    L38:
        CPositionContext r121 = CPositionContext.Companion.getContext();
        if (r121 == null) goto L56;
        m<EnlargeGuestInfo> r122 = r121.getEnlargeGuestInfo();
        if (r122 == null) goto L57;
        Observable<EnlargeGuestInfo> r123 = r122.a();
        if (r123 == null) goto L58;
        Disposable r124 = r123.subscribe(new h(this));
        if (r124 == null) goto L59;
        this.D.add(r124);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    }
}
