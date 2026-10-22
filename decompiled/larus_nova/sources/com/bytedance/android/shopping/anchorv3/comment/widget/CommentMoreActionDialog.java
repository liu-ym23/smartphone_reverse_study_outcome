package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.response.Action;
import com.bytedance.android.ec.model.response.MoreActions;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jd3.n;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "CloseReason", "MoreActionsAdapter", "MoreActionsViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentMoreActionDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f164653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f164654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CloseReason f164655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MoreActions f164656d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog$CloseReason;", "", UserProfileEvent.POSITION_NONE, "CLICK_ACTION", "CLICK_CANCEL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CloseReason extends Enum<CloseReason> {
        public static final CloseReason CLICK_ACTION = null;
        public static final CloseReason CLICK_CANCEL = null;
        public static final CloseReason NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CloseReason[] f164657a = null;

        static {
            CloseReason r100 = new CloseReason(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            CloseReason r101 = new CloseReason("CLICK_ACTION", 1);
            CLICK_ACTION = r101;
            CloseReason r102 = new CloseReason("CLICK_CANCEL", 2);
            CLICK_CANCEL = r102;
            f164657a = new CloseReason[]{r100, r101, r102};
        }

        public static CloseReason valueOf(String r100) {
            return (CloseReason) r27.a.a(CloseReason.class, r100);
        }

        public static CloseReason[] values() {
            return (CloseReason[]) f164657a.clone();
        }

        public CloseReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog$MoreActionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog$MoreActionsViewHolder;", "Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class MoreActionsAdapter extends RecyclerView.Adapter<MoreActionsViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Action> f164658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentMoreActionDialog f164659b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f164658a).size();
        }

        public MoreActionsAdapter(CommentMoreActionDialog r100) {
            this.f164659b = r100;
            this.f164658a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            MoreActionsViewHolder r102 = (MoreActionsViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 >= ((ArrayList) this.f164658a).size()) goto L13;
            Action r103 = (Action) CollectionsKt.getOrNull(this.f164658a, r101);
            if (r103 == null) goto L14;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "action");
            TextView r104 = r102.f164660a;
            if (r104 == null) goto L15;
            r104.setText(r103.getTitle());
            r104.setOnClickListener(new i(r102, r103));
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = th.a.c(r100.getContext(), R.layout.ec_comment_more_action_vh_layout, r100, false);
            return new MoreActionsViewHolder(this.f164659b, r102);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/CommentMoreActionDialog$MoreActionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class MoreActionsViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f164660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommentMoreActionDialog f164661b;

        public MoreActionsViewHolder(CommentMoreActionDialog r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f164661b = r100;
            super(r101);
            this.f164660a = (TextView) r101.findViewById(R.id.title_tv);
        }
    }

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentMoreActionDialog f164662a;

        public a(CommentMoreActionDialog r100) {
            this.f164662a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            CommentMoreActionDialog r101 = this.f164662a;
            if (r101.f164655c != CloseReason.CLICK_ACTION) goto L5;
            return;
        L5:
            n r102 = new n("comment_action_panel_close");
            Map<String, String> r103 = r101.f164656d.getTrackParams();
            if (r103 == null) goto L8;
            r102.f498389a.putAll(r103);
        L8:
            r102.post(null, null);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentMoreActionDialog f164663a;

        public b(CommentMoreActionDialog r100) {
            this.f164663a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentMoreActionDialog r101 = this.f164663a;
            r101.f164655c = CloseReason.CLICK_CANCEL;
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

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f164653a = (RecyclerView) findViewById(R.id.actions_rv);
        MoreActionsAdapter r101 = new MoreActionsAdapter(this);
        RecyclerView r102 = this.f164653a;
        if (r102 == null) goto L5;
        r102.setAdapter(r101);
    L5:
        RecyclerView r103 = this.f164653a;
        if (r103 == null) goto L8;
        final Context r104 = getContext();
        r103.setLayoutManager(new AnonymousClass1(r104));
    L8:
        List<Action> r105 = this.f164656d.getActions();
        if (r105 == null) goto L11;
        Intrinsics.checkNotNullParameter(r105, SlcCommonAction.KEY_ACTIONS);
        ((ArrayList) r101.f164658a).clear();
        ArrayList r106 = (ArrayList) r101.f164658a;
        r106.addAll(r105);
        r101.notifyDataSetChanged();
    L11:
        n r107 = new n("comment_action_panel_show");
        Map<String, String> r108 = this.f164656d.getTrackParams();
        if (r108 == null) goto L14;
        r107.f498389a.putAll(r108);
    L14:
        r107.post(null, null);
        setOnDismissListener(new a(this));
        TextView r109 = this.f164654b;
        if (r109 == null) goto L18;
        r109.setOnClickListener(new b(this));
        return;
    }

    public CommentMoreActionDialog(Context r100, MoreActions r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "moreAction");
        super(r100, R.style.comment_bottom_sheet_transparent_adjustNothing);
        this.f164656d = r101;
        setContentView(R.layout.ec_comment_more_actions_dialog);
        View r102 = findViewById(R.id.design_bottom_sheet);
        if (r102 == null) goto L5;
        r102.setBackgroundResource(R.color.transparent);
    L5:
        this.f164654b = (TextView) findViewById(R.id.cancel_tv);
        this.f164655c = CloseReason.NONE;
    }
}
