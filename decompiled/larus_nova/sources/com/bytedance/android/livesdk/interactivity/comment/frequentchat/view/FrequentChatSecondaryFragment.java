package com.bytedance.android.livesdk.interactivity.comment.frequentchat.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.api.FrequentChatApi;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatSubPanelSource;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/view/FrequentChatSecondaryFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/input/AbsLiveInputSecondaryFragment;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatSecondaryFragment extends AbsLiveInputSecondaryFragment {
    public static final /* synthetic */ int D = 0;
    public final FrequentChatSubPanelSource A;
    public final long B;
    public final String C;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f134929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GradientEditText f134930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f134931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f134932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f134933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f134934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f134935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f134936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f134937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f134938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f134939n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f134940o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f134941p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f134942q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<String> f134943r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f134944s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f134945t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f134946u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f134947v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrequentChatSecondaryFragment$textWatcher$1 f134948w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f134949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g f134950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f134951z;

    public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134952a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC2127a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f134953a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TextView f134954b;

            public ViewOnClickListenerC2127a(a r100, TextView r101) {
                this.f134953a = r100;
                this.f134954b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                GradientEditText r101 = this.f134953a.f134952a.f134930e;
                if (r101 != null) goto L5;
                return;
            L5:
                int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a;
                com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.a(r101, this.f134954b.getText(), com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a, true);
                int r103 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
                com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_recommend_click", Boolean.valueOf(this.f134953a.f134952a.f134950y.k0()), null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f134952a.f134943r).size();
        }

        public a(FrequentChatSecondaryFragment r100) {
            this.f134952a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            TextView r102 = (TextView) r100.itemView.findViewById(R.id.recent_chat_content);
            r102.setText((CharSequence) ListProtector.get(this.f134952a.f134943r, r101));
            r100.itemView.setOnClickListener(new ViewOnClickListenerC2127a(this, r102));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new d(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_view_recent_frequent_chat_item, r100, false));
        }
    }

    public interface b {
        boolean F(String r100);

        boolean S();

        void g(long r100, String r101);

        void n(long r100, String r101);

        void p(boolean r100);
    }

    public static final class c {
    }

    public final class d extends RecyclerView.ViewHolder {
        public d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class e implements i40.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134955a;

        public e(FrequentChatSecondaryFragment r100) {
            this.f134955a = r100;
        }

        @Override // i40.c
        public final void X6(boolean r100, int r101) {
            View r102 = this.f134955a.f134935j;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r100 == false) goto L10;
            if (r101 >= ((s1.w() * 2) / 3)) goto L10;
            this.f134955a.f134944s = r101;
        L10:
            if (r102.isSelected() == false) goto L28;
            if (r100 == true) goto L31;
            FrequentChatSecondaryFragment r103 = this.f134955a;
            FrameLayout r104 = r103.f134938m;
            if (r104 == null) goto L19;
            int r105 = r103.f134944s;
            if (r105 > 0) goto L18;
            r105 = r103.f134950y.W();
        L18:
            a1.k(r104, r105);
        L19:
            FrameLayout r106 = r103.f134938m;
            if (r106 == null) goto L22;
            UtilityKotlinExtentionsKt.w(r106);
        L22:
            View r107 = r103.f134936k;
            if (r107 == null) goto L25;
            UtilityKotlinExtentionsKt.w(r107);
        L25:
            View r108 = r103.f134940o;
            if (r108 == null) goto L31;
            UtilityKotlinExtentionsKt.t(r108);
        L31:
            this.f134955a.ba0();
            return;
        L28:
            if (r100 == false) goto L30;
            this.f134955a.Z90();
            goto L31
        L30:
            this.f134955a.ca0();
            goto L31
        }
    }

    public static final class f implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f134956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134957b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f134958a;

            public a(f r100) {
                this.f134958a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L12:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            L19:
                return;
            L3:
                if (this.f134958a.f134957b.isAdded() == false) goto L15;
                FragmentActivity r100 = this.f134958a.f134957b.getActivity();     // Catch: Throwable -> L12
                if (r100 == null) goto L10;
                Window r101 = r100.getWindow();     // Catch: Throwable -> L12
                if (r101 == null) goto L10;
                r101.setSoftInputMode(48);     // Catch: Throwable -> L12
            L10:
                FrequentChatSecondaryFragment.Y90(this.f134958a.f134957b);     // Catch: Throwable -> L12
                this.f134958a.f134957b.ba0();     // Catch: Throwable -> L12
                return;
            }
        }

        public f(GradientEditText r100, FrequentChatSecondaryFragment r101) {
            this.f134956a = r100;
            this.f134957b = r101;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            r100.postDelayed(new a(this), 100);
            this.f134956a.setOnFocusChangeListener(null);
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f134959a;

        public g(GradientEditText r100) {
            this.f134959a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f134959a.requestFocus();     // Catch: Throwable -> L4 Exception -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            ALogger.e("InputPanelV3", e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134960a;

        public h(FrequentChatSecondaryFragment r100) {
            this.f134960a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GradientEditText r101 = this.f134960a.f134930e;     // Catch: Exception -> L7
            if (r101 == null) goto L5;
            r101.requestFocus();     // Catch: Exception -> L7
        L5:
            FrequentChatSecondaryFragment.Y90(this.f134960a);     // Catch: Exception -> L7
            this.f134960a.Z90();     // Catch: Exception -> L7
            this.f134960a.ba0();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            ALogger.e("InputPanelV3", e);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134961a;

        public i(FrequentChatSecondaryFragment r100) {
            this.f134961a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            FrequentChatSecondaryFragment r101 = this.f134961a;
            int r102 = FrequentChatSecondaryFragment.D;
            r101.Z90();
            this.f134961a.ba0();
        }
    }

    public static final class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134962a;

        public j(FrequentChatSecondaryFragment r100) {
            this.f134962a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100.isSelected() == false) goto L5;
            r100.setSelected(false);
            FrequentChatSecondaryFragment.Y90(this.f134962a);
            return;
        L5:
            r100.setSelected(true);
            FrequentChatSecondaryFragment r101 = this.f134962a;
            int r102 = FrequentChatSecondaryFragment.D;
            r101.da0();
        }
    }

    public static final class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134963a;

        public k(FrequentChatSecondaryFragment r100) {
            this.f134963a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View r101 = this.f134963a.f134935j;
            if (r101 != null) goto L5;
        L6:
            this.f134963a.da0();
            return;
        L5:
            if (r101.isSelected() != true) goto L6;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrequentChatSecondaryFragment f134964a;

        public AnonymousClass4(FrequentChatSecondaryFragment r100) {
            this.f134964a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (FrequentChatSecondaryFragment.V90(this.f134964a) == false) goto L16;
            Context r101 = this.f134964a.f134950y.getContext();
            if (r101 != null) goto L8;
            return;
        L8:
            if (this.f134964a.f134951z.S() == false) goto L10;
            return;
        L10:
            l r102 = new l(r101, new FrequentChatSecondaryFragment$onViewCreated$4$confirmDialog$1(this), new FrequentChatSecondaryFragment$onViewCreated$4$confirmDialog$2(this));
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r102);
        L15:
            int r103 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_cancel_popup_show", Boolean.valueOf(this.f134964a.f134950y.k0()), MapsKt.mapOf(TuplesKt.to("edit_status", FrequentChatSecondaryFragment.W90(this.f134964a))));
        L17:
            int r104 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.f134925a;
            com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.a.a("livesdk_common_comment_edit_panel_click", Boolean.valueOf(this.f134964a.f134950y.k0()), MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "cancel"), TuplesKt.to("edit_status", FrequentChatSecondaryFragment.W90(this.f134964a))}));
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L14:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            goto L15
        L16:
            FrequentChatSecondaryFragment.U90(this.f134964a);
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final int T90() {
        int r100 = this.f134946u;
        View r101 = this.f134936k;
        int r102 = 0;
        if (r101 != null) goto L5;
    L10:
        Integer r103 = 0;
    L11:
        if (r103 == null) goto L13;
        r102 = r103.intValue();
    L13:
        int r104 = r100 + r102;
        int r105 = this.f134944s;
        if (r105 > 0) goto L18;
        r105 = this.f134950y.W();
    L18:
        return r104 + r105;
    L5:
        if (r101.getVisibility() != 0) goto L10;
        View r106 = this.f134936k;
        if (r106 == null) goto L9;
        r103 = Integer.valueOf(r106.getHeight());
        goto L11
    L9:
        r103 = null;
        goto L11
    }

    public final void Z90() {
        FrameLayout r100 = this.f134938m;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r100);
    L5:
        View r101 = this.f134940o;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r101);
    L8:
        View r102 = this.f134936k;
        if (r102 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r102);
    L11:
        View r103 = this.f134935j;
        if (r103 == null) goto L15;
        r103.setSelected(false);
        return;
    }

    public final void ca0() {
        View r100 = this.f134940o;
        if (r100 == null) goto L9;
        int r101 = this.f134944s;
        if (r101 > 0) goto L8;
        r101 = this.f134950y.W();
    L8:
        a1.k(r100, r101);
    L9:
        View r102 = this.f134935j;
        if (r102 == null) goto L12;
        r102.setSelected(false);
    L12:
        View r103 = this.f134936k;
        if (r103 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r103);
    L15:
        FrameLayout r104 = this.f134938m;
        if (r104 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r104);
    L18:
        View r105 = this.f134940o;
        if (r105 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r105);
        return;
    }

    public final void da0() {
        Context r100 = this.f134950y.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        GradientEditText r101 = this.f134930e;
        if (r101 != null) goto L8;
        return;
    L8:
        t2.a(r100, r101);
    }

    public final void ba0() {
        xs2.b.a().post(new i1(T90(), true));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f134929d.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.A != FrequentChatSubPanelSource.ADD) goto L5;
        ca0();
        ba0();
    L8:
        MeasureLinearLayout r100 = this.f134950y.a0();
        if (r100 == null) goto L14;
        i40.b r101 = r100.getKeyBoardObservable();
        if (r101 == null) goto L15;
        r101.b(this.f134947v);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        Z90();
        GradientEditText r102 = this.f134930e;
        if (r102 == null) goto L8;
        r102.post(new g(r102));
        r102.setOnFocusChangeListener(new f(r102, this));
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment
    public final boolean S90() {
        return this.f134949x;
    }

    public static final void U90(FrequentChatSecondaryFragment r100) {
        MeasureLinearLayout r101 = r100.f134950y.a0();
        if (r101 == null) goto L9;
        i40.b r102 = r101.getKeyBoardObservable();
        if (r102 == null) goto L9;
        e r103 = r100.f134947v;
        List<i40.c> r104 = r102.f488134b;
        if (r104 == null) goto L9;
        ((ArrayList) r104).remove(r103);
    L9:
        r100.da0();
        r100.f134950y.G(InputDialogFragmentSwitchType.NONE, r100);
    }

    public static final boolean V90(FrequentChatSecondaryFragment r100) {
        GradientEditText r101 = r100.f134930e;
        if (r101 == null) goto L18;
        Editable r102 = r101.getText();
        if (r102 != null) goto L8;
        return false;
    L8:
        if ((!Intrinsics.areEqual(r100.C, r102.toString())) == true) goto L10;
        return false;
    L10:
        if (r100.A == FrequentChatSubPanelSource.EDIT) goto L12;
    L16:
        return true;
    L12:
        if (r102.length() != 0) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L16;
        return false;
    L14:
        r103 = false;
        goto L15
    L18:
        return false;
    }

    public static final String W90(FrequentChatSecondaryFragment r100) {
        FrequentChatSubPanelSource r101 = r100.A;
        int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.f134973c[r101.ordinal()];
        if (r102 != 1) goto L5;
        return SoloKtvContext.SOLO_PAGE_FIRST;
    L5:
        if (r102 != 2) goto L8;
        return "revise";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final void X90(final FrequentChatSecondaryFragment r100) {
        GradientEditText r101 = r100.f134930e;
        if (r101 == null) goto L24;
        Editable r102 = r101.getText();
        if (r102 == null) goto L25;
        final String r103 = r102.toString();
        if (r103 == null) goto L28;
        Context r104 = r100.f134950y.getContext();
        if (r104 != null) goto L13;
        return;
    L13:
        if (r100.f134951z.F(r103) == false) goto L19;
        n r105 = new n(r104, new FrequentChatSecondaryFragment$trySaveChatContent$1(r100), new FrequentChatSecondaryFragment$trySaveChatContent$2(r100, r103));
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L18:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        return;
    L19:
        r100.aa0(r103);
        return;
    L28:
        return;
    L25:
        return;
    }

    public static final void Y90(FrequentChatSecondaryFragment r100) {
        Context r101 = r100.f134950y.getContext();
        if (r101 == null) goto L10;
        GradientEditText r102 = r100.f134930e;
        if (r102 == null) goto L11;
        t2.b(r101, r102);
        return;
    L11:
        return;
    }

    public final void aa0(String r100) {
        FrequentChatSubPanelSource r101 = this.A;
        int r102 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.f134972b[r101.ordinal()];
        if (r102 != 1) goto L5;
        FrequentChatApi.f134874a.getClass();
        FrequentChatApi r103 = FrequentChatApi.a.a();
        if (r103 == null) goto L31;
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.a>> r104 = r103.addFrequentChat(this.f134950y.Z(), r100);
        if (r104 == null) goto L32;
        Observable<R> r105 = r104.compose(RxUtil.rxSchedulerHelper());
        if (r105 == 0) goto L33;
        Disposable r106 = r105.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.h(this, r100), new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.i(this));
        if (r106 == null) goto L34;
        RxUtilKt.c(r106, this.f134929d);
        this.f134951z.p(true);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        if (r102 != 2) goto L35;
        FrequentChatApi.f134874a.getClass();
        FrequentChatApi r107 = FrequentChatApi.a.a();
        if (r107 == null) goto L26;
        Observable<Response<Object>> r108 = r107.updateFrequentChat(this.f134950y.Z(), this.B, r100);
        if (r108 == null) goto L27;
        Observable<R> r109 = r108.compose(RxUtil.rxSchedulerHelper());
        if (r109 == 0) goto L28;
        Disposable r110 = r109.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.j(this, r100), new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.k(this));
        if (r110 == null) goto L29;
        RxUtilKt.c(r110, this.f134929d);
        this.f134951z.p(true);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FrequentChatSubPanelSource r102 = this.A;
        int r103 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.d.f134971a[r102.ordinal()];
        if (r103 != 1) goto L5;
        int r104 = R.string.frequent_chat_second_panel_add_title;
    L10:
        TextView r105 = this.f134932g;
        if (r105 == null) goto L14;
        r105.setText(s1.B(r104));
    L14:
        if (this.A != FrequentChatSubPanelSource.EDIT) goto L18;
        GradientEditText r106 = this.f134930e;
        if (r106 == null) goto L18;
        r106.setText(this.C);
        r106.setSelection(r106.length());
    L18:
        FrameLayout r107 = this.f134942q;
        if (r107 == null) goto L21;
        r107.setOnClickListener(new h(this));
    L21:
        GradientEditText r108 = this.f134930e;
        if (r108 == null) goto L24;
        r108.setOnClickListener(new i(this));
    L24:
        TextView r109 = this.f134934i;
        if (r109 == null) goto L27;
        r109.setOnClickListener(new AnonymousClass4(this));
    L27:
        View r110 = this.f134935j;
        if (r110 == null) goto L30;
        r110.setOnClickListener(new j(this));
    L30:
        View r111 = this.f134937l;
        if (r111 == null) goto L34;
        r111.setOnClickListener(new k(this));
        return;
    L34:
        return;
    L5:
        if (r103 != 2) goto L8;
        r104 = R.string.frequent_chat_second_panel_edit_title;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.ttlive_input_view_frequent_chat_second_panel, r111, false);
        FrameLayout r114 = (FrameLayout) r113.findViewById(R.id.edit_text_container);
        this.f134942q = r114;
        this.f134934i = (TextView) r113.findViewById(R.id.cancel);
        this.f134933h = (TextView) r113.findViewById(R.id.save);
        this.f134932g = (TextView) r113.findViewById(R.id.title);
        int r115 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a;
        Context r116 = this.f134950y.getContext();
        FrequentChatSecondaryFragment$textWatcher$1 r100 = this.f134948w;
        Intrinsics.checkNotNullParameter(r114, "inputContainer");
        GradientEditText r117 = ((IExpressionService) jc1.k.n(IExpressionService.class)).createEmojiEditText(r116, com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.d.f134928a);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -2);
        r101.gravity = 48;
        r117.setLayoutParams(r101);
        r117.setImeOptions(268435460);
        r117.setInputType(1);
        r117.setLineSpacing(s1.f(3.0f), r117.getLineSpacingMultiplier());
        r117.setTextAlignment(5);
        r117.setInputType(131072);
        r117.setSingleLine(false);
        r117.setTextColor(s1.h(R.color.ttlive_live_input_text_color));
        r117.setTextSize(1, 15.0f);
        r117.setPadding(0, 0, 0, 0);
        r117.setHorizontallyScrolling(false);
        r117.setOnEditorActionListener(com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.c.f134927a);
        Context r102 = null;
        r117.setBackground(null);
        Field r103 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L5
        r103.setAccessible(true);     // Catch: Exception -> L5
        r103.set(r117, Integer.valueOf(R.drawable.ttlive_edit_text_cursor_drawable_red));     // Catch: Exception -> L5
    L7:
        r117.addTextChangedListener(r100);
        r117.setHintTextColor(s1.h(R.color.ttlive_color_57_161823));
        r117.setHint(R.string.frequent_chat_edit_text_hint);
        r114.addView(r117);
        this.f134930e = r117;
        FrameLayout r118 = (FrameLayout) r113.findViewById(R.id.emoji_panel_container);
        this.f134938m = r118;
        Context r119 = this.f134950y.getContext();
        if (r119 == null) goto L11;
        r118.addView(((IExpressionService) jc1.k.n(IExpressionService.class)).createExpressionPanelV3(r119, new com.bytedance.android.livesdk.interactivity.api.expression.a(true, false, false, false, false, new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.e(this))));
    L11:
        this.f134935j = r113.findViewById(R.id.emoji_panel_entrance);
        this.f134937l = r113.findViewById(R.id.hide_keyboard_area);
        this.f134936k = r113.findViewById(R.id.emoji_panel_entrance_container);
        this.f134939n = r113.findViewById(R.id.bottom_area);
        this.f134940o = r113.findViewById(R.id.recommend_chat_container);
        RecyclerView r120 = (RecyclerView) r113.findViewById(R.id.recommend_chat_list);
        if (this.A != FrequentChatSubPanelSource.ADD) goto L27;
        if (r120 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r104 = this.f134950y;
        if (r104 == null) goto L18;
        r102 = r104.getContext();
    L18:
        r120.setLayoutManager(new LinearLayoutManager(r102, 1, false));
        r120.addItemDecoration(new SpaceItemDecoration(1, s1.f(12.0f), true));
        r120.setAdapter(new a(this));
        FrequentChatApi.f134874a.getClass();
        FrequentChatApi r121 = FrequentChatApi.a.a();
        if (r121 == null) goto L27;
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.e>> r122 = r121.getRecommendChat(this.f134950y.Z());
        if (r122 == null) goto L27;
        Observable<R> r123 = r122.compose(RxUtil.rxSchedulerHelper());
        if (r123 == 0) goto L27;
        Disposable r124 = r123.subscribe(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.f(this, r120), com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.g.f134977a);
        if (r124 == null) goto L27;
        RxUtilKt.c(r124, this.f134929d);
    L27:
        this.f134941p = r113.findViewById(R.id.recommend_chat_title);
        this.f134931f = r113;
        return r113;
    L5:
        e = move-exception;
        i40.h.b("V3 emoji key board mCursorDrawableRes", e);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.livesdk.interactivity.comment.frequentchat.view.FrequentChatSecondaryFragment$textWatcher$1] */
    public FrequentChatSecondaryFragment(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r100, b r101, FrequentChatSubPanelSource r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "originSource");
        Intrinsics.checkNotNullParameter(r104, "originContent");
        this.f134950y = r100;
        this.f134951z = r101;
        this.A = r102;
        this.B = r103;
        this.C = r104;
        this.f134929d = new CompositeDisposable();
        this.f134943r = new ArrayList();
        this.f134946u = UtilityKotlinExtentionsKt.i(144);
        this.f134947v = new e(this);
        this.f134948w = new FrequentChatSecondaryFragment$textWatcher$1(this);
        this.f134949x = true;
    }
}
