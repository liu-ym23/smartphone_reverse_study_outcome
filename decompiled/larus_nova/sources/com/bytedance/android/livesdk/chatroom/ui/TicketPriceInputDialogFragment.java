package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "RecommendPriceAdapter", "RecommendPriceTagViewHolder", "RecommendPriceViewHolder", "c", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketPriceInputDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f112553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f112554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f112555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f112556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f112557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f112558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f112559j;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f112560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TicketPriceInputDialogFragment f112561b;

        public static final class a {
        }

        static {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<String> r100 = this.f112560a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            List<String> r101 = this.f112560a;
            if (r101 == null) goto L5;
            String r102 = (String) ListProtector.get(r101, r100);
        L7:
            return !TextUtils.equals(r102, "recommend_price_tag") ? 1 : 0;
        L5:
            r102 = null;
            goto L7
        }

        public RecommendPriceAdapter(List<String> r100, TicketPriceInputDialogFragment r101) {
            this.f112560a = r100;
            this.f112561b = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
            String r102 = null;
            if ((r100 instanceof RecommendPriceViewHolder) == true) goto L5;
            r100 = null;
        L5:
            RecommendPriceViewHolder r103 = (RecommendPriceViewHolder) r100;
            if (r103 == null) goto L12;
            List<String> r104 = this.f112560a;
            if (r104 == null) goto L10;
            r102 = (String) ListProtector.get(r104, r101);
        L10:
            r103.f112562a.setText(r102);
            r103.itemView.setOnClickListener(r103);
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != 0) goto L6;
            return new RecommendPriceTagViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_recommend_ticket_price_tag_view_holder, r100, false));
        L6:
            return new RecommendPriceViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_recommend_ticket_price_view_holder, r100, false), this.f112561b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceTagViewHolder extends RecyclerView.ViewHolder {
        public RecommendPriceTagViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$RecommendPriceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecommendPriceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f112562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TicketPriceInputDialogFragment f112563b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r102 = new Pair[3];
            r102[0] = TuplesKt.to("enter_from_merge", "direct_shoot");
            r102[1] = TuplesKt.to("live_type", "video_live");
            CharSequence r103 = this.f112562a.getText();
            String r104 = null;
            if (r103 == null) goto L5;
            String r105 = r103.toString();
        L6:
            r102[2] = TuplesKt.to("price", r105);
            r101.sendLog("livesdk_paidlive_activity_price_filling_shortcut_panel_click", MapsKt.mapOf(r102), new Object[]{Room.class});
            TicketPriceInputDialogFragment r106 = this.f112563b;
            if (r106 == null) goto L13;
            CharSequence r107 = this.f112562a.getText();
            if (r107 == null) goto L11;
            r104 = r107.toString();
        L11:
            r106.T90(r104, true);
            return;
        L13:
            return;
        L5:
            r105 = null;
            goto L6
        }

        public RecommendPriceViewHolder(View r100, TicketPriceInputDialogFragment r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f112563b = r101;
            this.f112562a = (TextView) r100.findViewById(R.id.price);
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        void f(String r100, boolean r101);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/TicketPriceInputDialogFragment$c;", "", "", "initialValue", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "AmountList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("amount_list")
        private final List<String> AmountList;

        @SerializedName("initial_value")
        private final String initialValue;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.initialValue, r101.initialValue) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.AmountList, r101.AmountList) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.initialValue;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.AmountList;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TicketPriceMethodParams(initialValue=" + this.initialValue + ", AmountList=" + this.AmountList + ")";
        }

        public c() {
            this.initialValue = null;
            this.AmountList = null;
        }

        public final List<String> a() {
            return this.AmountList;
        }

        public final String b() {
            return this.initialValue;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TicketPriceInputDialogFragment f112564a;

        public d(TicketPriceInputDialogFragment r100) {
            this.f112564a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r100 = this.f112564a.f112555f;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.requestFocus();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        EditText r100 = this.f112555f;
        if (r100 == null) goto L6;
        r100.postDelayed(new d(this), 100);
        return;
    }

    public TicketPriceInputDialogFragment() {
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        setStyle(0, R.style.ttlive_dialog_fullscreen);
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(false);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setGravity(80);
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(3);
        r102.addFlags(32);
        r102.clearFlags(2);
        int r103 = Build.VERSION.SDK_INT;
        r102.clearFlags(67108864);
        View r104 = S90(r102);
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r105 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;
        r105.a();
        r105.a();
        r104.setSystemUiVisibility(1280);
        r105.a();
        r102.addFlags(Integer.MIN_VALUE);
        r102.setStatusBarColor(0);
        if (r103 < 23) goto L7;
        S90(r102).setSystemUiVisibility(S90(r102).getSystemUiVisibility() | 8192);
    L7:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        b r101 = this.f112559j;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.a();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void T90(String r100, boolean r101) {
        b r102 = this.f112559j;
        if (r102 == null) goto L6;
        r102.f(r100, r101);
    L6:
        if (this.f112555f != null) goto L8;
        i40.h.a("hide key board return, edit text view null");
    L16:
        dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L18;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L18:
        return;
    L8:
        com.bytedance.android.livesdk.utils.t2.a(getContext(), this.f112555f);
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_ticket_price_input_dialog_layout, r101, false);
        r103.setLayoutParams(new FrameLayout.LayoutParams(com.bytedance.android.live.core.utils.x1.h(), com.bytedance.android.live.core.utils.x1.g()));
        this.f112553d = r103.findViewById(R.id.empty_view);
        this.f112554e = r103.findViewById(R.id.input_finish);
        EditText r104 = (EditText) r103.findViewById(R.id.edit_text);
        this.f112555f = r104;
        String r105 = this.f112557h;
        if (r105 == null) goto L13;
        if (r104 == null) goto L6;
        r104.setText(r105);
    L6:
        EditText r106 = this.f112555f;
        if (r106 == null) goto L13;
        Editable r107 = r106.getText();
        if (r107 == null) goto L11;
        int r108 = r107.length();
    L12:
        r106.setSelection(r108);
        goto L13
    L11:
        r108 = 0;
    L13:
        EditText r109 = this.f112555f;
        if (r109 == null) goto L16;
        r109.setOnFocusChangeListener(new m9(this));
    L16:
        this.f112556g = (RecyclerView) r103.findViewById(R.id.recommend_price_list);
        View r110 = this.f112554e;
        if (r110 == null) goto L19;
        r110.setOnClickListener(new n9(this));
    L19:
        View r111 = this.f112553d;
        if (r111 == null) goto L22;
        r111.setOnClickListener(new o9(this));
    L22:
        RecyclerView r112 = this.f112556g;
        if (r112 == null) goto L25;
        r112.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L25:
        RecyclerView r113 = this.f112556g;
        if (r113 == null) goto L28;
        r113.setAdapter(new RecommendPriceAdapter(this.f112558i, this));
    L28:
        setCancelable(true);
        return r103;
    }
}
