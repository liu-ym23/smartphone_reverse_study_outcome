package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.revenue.common.view.ScrollToTopSnapHelper;
import com.bytedance.android.live.liveinteract.revenue.fight.dialog.SelectDurationDecoration;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/SelfDisciplineDurationSelectDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelfDisciplineDurationSelectDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f79674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f79675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f79676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f79677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f79678e;

    public interface a {
        void q0(int r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelfDisciplineDurationSelectDialog f79679a;

        public b(SelfDisciplineDurationSelectDialog r100) {
            this.f79679a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SelfDisciplineDurationSelectDialog r101 = this.f79679a;
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
        return R.layout.ttlive_dialog_interact_video_talk_self_discipline_duation;
    }

    public static List M0() {
        ArrayList r100 = new ArrayList();
        r100.add(60);
        int r101 = 1;
    L4:
        if (r101 > 24) goto L6;
        r100.add(Integer.valueOf((r101 * 5) * 60));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f79674a = (TextView) findViewById(R.id.confirm_btn);
        this.f79675b = (TextView) findViewById(R.id.cancel_btn);
        this.f79676c = (RecyclerView) findViewById(R.id.time_list_rv);
        final LinearLayoutManager r101 = new LinearLayoutManager(getContext());
        RecyclerView r102 = this.f79676c;
        if (r102 == null) goto L5;
        r102.setLayoutManager(r101);
    L5:
        RecyclerView r103 = this.f79676c;
        if (r103 == null) goto L8;
        r103.setAdapter(new SelfDisciplineDurationAdapter(M0(), this.f79678e));
    L8:
        RecyclerView r104 = this.f79676c;
        if (r104 == null) goto L11;
        r104.addItemDecoration(new SelectDurationDecoration());
    L11:
        new ScrollToTopSnapHelper().attachToRecyclerView(this.f79676c);
        RecyclerView r105 = this.f79676c;
        if (r105 == null) goto L14;
        r105.addOnScrollListener(new AnonymousClass1(this, r101));
    L14:
        List r106 = M0();
        ArrayList r107 = (ArrayList) r106;
        int r108 = r107.indexOf(Integer.valueOf(this.f79678e));
        RecyclerView r109 = this.f79676c;
        if (r109 != null) goto L17;
    L20:
        TextView r110 = this.f79674a;
        if (r110 == null) goto L23;
        r110.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L23:
        TextView r111 = this.f79675b;
        if (r111 == null) goto L27;
        r111.setOnClickListener(new b(this));
        return;
    L27:
        return;
    L17:
        if (r108 != (-1)) goto L19;
        r108 = 1;
    L19:
        r109.scrollToPosition(r108);
        goto L20
    }

    public SelfDisciplineDurationSelectDialog(Context r100, SelfDisciplineManagerDialogV2 r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f79677d = r101;
        this.f79678e = r102;
    }
}
