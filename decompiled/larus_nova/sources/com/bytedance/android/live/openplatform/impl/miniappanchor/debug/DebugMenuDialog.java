package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.live.datacontext.i;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/DebugMenuDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugMenuDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f84343c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<c> f84344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IQRCodeService.b f84345b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugMenuDialog f84346a;

        public a(DebugMenuDialog r100) {
            this.f84346a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DebugMenuDialog r101 = this.f84346a;
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
        return R.layout.ttlive_open_game_debug_menu_dialog;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f84344a.clear();
        LinkedList<c> r100 = this.f84344a;
        LinkedList r101 = new LinkedList();
        r101.add(new c(new com.bytedance.android.live.openplatform.impl.miniappanchor.debug.a(this)));
        r100.addAll(r101);
        RecyclerView r102 = (RecyclerView) findViewById(R.id.recyclerView);
        if (r102 == null) goto L8;
        RecyclerView.Adapter r103 = r102.getAdapter();
        if (r103 == null) goto L9;
        r103.notifyDataSetChanged();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L9;
        i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L9;
        Boolean r103 = r102.getValue();
        if (r103 == null) goto L9;
        r103.booleanValue();
    L9:
        RecyclerView r104 = (RecyclerView) findViewById(R.id.recyclerView);
        if (r104 == null) goto L12;
        r104.setAdapter(new DebugMenuAdapter(this.f84344a));
        r104.setLayoutManager(new LinearLayoutManager(r104.getContext(), 1, false));
        r104.addItemDecoration(new DividerItemDecoration(r104.getContext(), 1));
    L12:
        TextView r105 = (TextView) findViewById(R.id.cancel);
        if (r105 == null) goto L16;
        r105.setOnClickListener(new a(this));
        return;
    }

    public DebugMenuDialog(Context r100, IQRCodeService.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scanResultListener");
        super(r100);
        this.f84345b = r101;
        LinkedList<c> r102 = new LinkedList();
        r102.add(new c(new com.bytedance.android.live.openplatform.impl.miniappanchor.debug.a(this)));
        this.f84344a = r102;
    }
}
