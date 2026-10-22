package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorDialogDetail;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorDialogDetail extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayAdapter<CharSequence> f99202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f99203b;

    public static final class a implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f99204a = null;

        static {
            f99204a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPerfMonitorDialogDetail f99205a;

        public b(AnchorPerfMonitorDialogDetail r100) {
            this.f99205a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnchorPerfMonitorDialogDetail r101 = this.f99205a;
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

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_anchor_apm_monitor_detail;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setBottomSheetSlideProcessor(a.f99204a);
        int r101 = b1.f158888a;
        b1.b(true, new AnchorPerfMonitorDialogDetail$initDialogUI$1(this));
        ImageView r102 = (ImageView) findViewById(R.id.back);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new b(this));
    L5:
        this.f99202a = new ArrayAdapter(getContext(), R.layout.ttlive_anchor_apm_monitor_item, this.f99203b);
        ListView r103 = (ListView) findViewById(R.id.list);
        if (r103 == null) goto L9;
        r103.setAdapter(this.f99202a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorPerfMonitorDialogDetail(Context r100, List<? extends CharSequence> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "records");
        super(r100, true, false);
        this.f99203b = r101;
    }
}
