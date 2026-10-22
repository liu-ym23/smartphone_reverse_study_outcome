package com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayDialogUIStyle;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.k;
import com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayAdaptiveDialogFragment;", "ActionSheetAdapter", "ActionSheetItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayActionSheet extends ReplayAdaptiveDialogFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f118232s = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f118233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f118234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<? extends d> f118235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f118236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f118237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DataCenter f118238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f118239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f118240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f118241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f118242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f118243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f118244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f118245r;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetItemViewHolder;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReplayActionSheet f118246a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ActionSheetAdapter f118247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f118248b;

            public a(ActionSheetAdapter r100, d r101) {
                this.f118247a = r100;
                this.f118248b = r101;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                c r101 = this.f118247a.f118246a.f118234g;
                if (r101 == null) goto L13;
                r101.a(this.f118248b);
            L13:
                this.f118247a.f118246a.dismiss();     // Catch: Exception -> L8
                return;
            L8:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r102 = DialogFragmentLancet.sLastShowStack;
                if (r102 == null) goto L15;
                com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f118246a.f118235h.size();
        }

        public ActionSheetAdapter(ReplayActionSheet r100) {
            Intrinsics.checkNotNullParameter(r100, "actionSheet");
            this.f118246a = r100;
        }

        public ActionSheetItemViewHolder z2(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "viewGroup");
            TextView r101 = new TextView(r100.getContext());
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r102 = ReplayRoomFragmentScopeUtil.f117917a;
            ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).getClass();
            r101.setTextSize(16.0f);
            ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).getClass();
            r101.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.c(60)));
            k.a(r101, 1);
            r101.setGravity(17);
            return new ActionSheetItemViewHolder(r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            y2((ActionSheetItemViewHolder) r100, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return z2(r100);
        }

        public void y2(ActionSheetItemViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
            d r102 = (d) ListProtector.get(this.f118246a.f118235h, r101);
            r100.f118249a.setOnClickListener(new a(this, r102));
            View r103 = r100.f118249a;
            if (r103 == null) goto L21;
            TextView r104 = (TextView) r103;
            r104.setText(r102.f118250a);
            Integer r105 = null;
            if (r102.f118252c == false) goto L18;
            r104.setTextColor(s1.h(this.f118246a.f118237j));
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r106 = ReplayRoomFragmentScopeUtil.f117917a;
            ReplayDialogUIStyle r107 = ((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p();
            int r108 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.f118174c[r107.ordinal()];
            if (r108 != 1) goto L9;
        L16:
            if (r105 == null) goto L22;
            int r109 = r105.intValue();
            r103.setBackgroundDrawable(AppCompatResources.getDrawable(r104.getContext(), r109));
            return;
        L22:
            return;
        L9:
            if (r108 != 2) goto L11;
            r105 = Integer.valueOf(R.drawable.ttlive_bg_replay_resolution_action_sheet_item);
            goto L16
        L11:
            if (r108 == 3) goto L16;
            throw new NoWhenBranchMatchedException();
        L18:
            r104.setTextColor(s1.h(this.f118246a.f118236i));
            r103.setBackgroundDrawable(null);
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/actionsheet/ReplayActionSheet$ActionSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f118249a;

        public ActionSheetItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f118249a = r100;
        }
    }

    public interface a {
        void onDismiss();

        void onShow();
    }

    public static final class b {
        public static Drawable a(int r100) {
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L11;
            return s1.m(R.drawable.ttlive_bg_vs_action_sheet_480);
        L11:
            return s1.m(R.drawable.ttlive_bg_vs_action_sheet_600);
        L9:
            return s1.m(R.drawable.ttlive_bg_vs_action_sheet_480);
        }
    }

    public interface c {
        void a(d r100);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f118250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f118251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f118252c;

        public d() {
        }
    }

    static {
    }

    public ReplayActionSheet() {
        this(1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment
    public final String S90() {
        return "ReplayActionSheet[" + hashCode() + ']';
    }

    public ActionSheetAdapter T90() {
        return new ActionSheetAdapter(this);
    }

    public final boolean U90() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).i() == false) goto L5;
    L8:
        return true;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        PadConfigUtils.c();
        goto L8
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment, com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p() == ReplayDialogUIStyle.RightStyle) goto L7;
        return 0;
    L7:
        return UtilityKotlinExtentionsKt.c(250);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        a r100 = this.f118233f;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        a r100 = this.f118233f;
        if (r100 == null) goto L6;
        r100.onShow();
        return;
    }

    public ReplayActionSheet(int r100) {
        this.f118245r = r100;
        this.f118235h = new ArrayList();
        this.f118236i = R.color.ttlive_replay_action_sheet_item_common;
        this.f118237j = R.color.ttlive_replay_action_sheet_item_selected;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (PadConfigUtils.c() == false) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r103 = ReplayRoomFragmentScopeUtil.f117917a;
        int r104 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.f118172a[((com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class)).p().ordinal()];
        if (r104 == 1) goto L10;
        if (r104 == 2) goto L9;
        if (r104 != 3) goto L8;
        int r105 = R.layout.ttlive_replay_action_sheet;
    L11:
        View r106 = r100.inflate(r105, r101, false);
        this.f118239l = r106;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L14:
        this.f118240m = r106.findViewById(R.id.vs_action_container);
        View r107 = this.f118239l;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L17:
        this.f118242o = (RecyclerView) r107.findViewById(R.id.vs_action_sheet_list);
        View r108 = this.f118239l;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L20:
        this.f118241n = r108.findViewById(R.id.vs_action_sheet_container);
        View r109 = this.f118239l;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L23:
        this.f118243p = r109.findViewById(R.id.vs_action_sheet_cancel);
        View r110 = this.f118239l;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L26:
        this.f118244q = r110.findViewById(R.id.vs_action_sheet_empty_view);
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d r111 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class);
        int r112 = this.f118245r;
        int r113 = com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.c.f118173b[r111.p().ordinal()];
        ViewGroup.LayoutParams r114 = null;
        if (r113 == 1) goto L34;
        if (r113 == 2) goto L33;
        if (r113 != 3) goto L32;
        Drawable r115 = null;
    L36:
        if (r115 == null) goto L41;
        View r116 = this.f118241n;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L40:
        r116.setBackground(r115);
    L41:
        com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d r117 = (com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d) ReplayRoomFragmentScopeUtil.a(com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.d.class);
        View r118 = this.f118241n;
        if (r118 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L44:
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "view");
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L47;
        r119.width = r117.o();
        Unit r120 = Unit.INSTANCE;
        r114 = r119;
    L47:
        r118.setLayoutParams(r114);
        View r121 = this.f118244q;
        if (r121 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetEmptyView");
    L50:
        r121.setOnClickListener(new kr1.a(this));
        View r122 = this.f118243p;
        if (r122 == null) goto L53;
        r122.setOnClickListener(new kr1.b(this));
    L53:
        RecyclerView r123 = this.f118242o;
        if (r123 == null) goto L56;
        r123.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L56:
        RecyclerView r124 = this.f118242o;
        if (r124 == null) goto L59;
        r124.setAdapter(T90());
    L59:
        View r125 = this.f118239l;
        if (r125 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L62:
        return r125;
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r115 = b.a(r112);
        goto L36
    L34:
        r115 = s1.m(R.drawable.ttlive_bg_replay_action_sheet_pad);
        goto L36
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r105 = R.layout.ttlive_replay_action_sheet_landscape_layout;
        goto L11
    L10:
        r105 = R.layout.ttlive_replay_action_sheet_pad_portrait_full;
        goto L11
    }
}
