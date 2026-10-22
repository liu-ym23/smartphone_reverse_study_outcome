package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.adapter.KtvGroupUserListAdapter;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvGroupListDialogFragment;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvGroupListDialogFragment extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f143625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f143626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f143627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f143628d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvGroupListDialogFragment f143629a;

        public b(KtvGroupListDialogFragment r100) {
            this.f143629a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            KtvGroupListDialogFragment r101 = this.f143629a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvGroupListDialogFragment f143630a;

        public c(KtvGroupListDialogFragment r100) {
            this.f143630a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            KtvGroupListDialogFragment r101 = this.f143630a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvGroupListDialogFragment f143631a;

        public d(KtvGroupListDialogFragment r100) {
            this.f143631a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            if (this.f143631a.f143627c.isDisposed() == true) goto L6;
            this.f143631a.f143627c.dispose();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_ktv_group_list_dialog_fragment;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        long r101 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvGroupUser(String.valueOf(this.f143628d), 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.base.view.d(this, r101), new e(this, r101)), this.f143627c);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f143626b = (TextView) findViewById(R.id.ktv_group_title);
        TextView r102 = (TextView) findViewById(R.id.ktv_group_close);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new b(this));
        r102.setText("x");
    L5:
        View r103 = findViewById(R.id.close);
        if (r103 == null) goto L8;
        r103.setOnClickListener(new c(this));
    L8:
        RecyclerView r104 = (RecyclerView) findViewById(R.id.ktv_group_list);
        if (r104 == null) goto L11;
        r104.setAdapter(new KtvGroupUserListAdapter(r104.getContext()));
        r104.setLayoutManager(new LinearLayoutManager(r104.getContext(), 1, false));
        Unit r105 = Unit.INSTANCE;
    L12:
        this.f143625a = r104;
        setOnDismissListener(new d(this));
        return;
    L11:
        r104 = null;
        goto L12
    }

    public KtvGroupListDialogFragment(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f143628d = r101;
        this.f143627c = new CompositeDisposable();
    }
}
