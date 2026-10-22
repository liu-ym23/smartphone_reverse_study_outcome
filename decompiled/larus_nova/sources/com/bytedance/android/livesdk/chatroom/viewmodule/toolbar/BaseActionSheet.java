package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "<init>", "()V", "ActionSheetAdapter", "ActionSheetItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseActionSheet extends AdaptiveDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f115601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f115602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<d> f115603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f115604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f115605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f115606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f115607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f115608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView f115609m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f115610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f115611o;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetItemViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseActionSheet f115612a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f115612a.f115603g.size();
        }

        public ActionSheetAdapter(BaseActionSheet r100) {
            Intrinsics.checkNotNullParameter(r100, "actionSheet");
            this.f115612a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            ActionSheetItemViewHolder r102 = (ActionSheetItemViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "viewHolder");
            d r103 = (d) ListProtector.get(this.f115612a.f115603g, r101);
            r102.f115613a.setOnClickListener(new j(this, r103));
            if (this.f115612a.isVertical() == false) goto L5;
        L15:
            View r104 = r102.f115613a;
            if (r104 == null) goto L23;
            TextView r105 = (TextView) r104;
            r105.setText(r103.f115614a);
            if (r103.f115616c == false) goto L20;
            r105.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.f115612a.f115605i));
            return;
        L20:
            r105.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.f115612a.f115604h));
            return;
        L23:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L5:
            if (PadConfigUtils.c() == false) goto L7;
            PadConfigUtils.c();
            goto L15
        L7:
            View r106 = r102.f115613a;
            if (r106 == null) goto L14;
            TextView r107 = (TextView) r106;
            r107.setText(r103.f115614a);
            if (r103.f115616c == false) goto L12;
            r107.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.f115612a.f115605i));
            r106.setBackgroundDrawable(AppCompatResources.getDrawable(r107.getContext(), R.drawable.ttlive_bg_vs_action_sheet_item));
            return;
        L12:
            r107.setTextColor(com.bytedance.android.live.core.utils.s1.h(this.f115612a.f115604h));
            r106.setBackgroundDrawable(null);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewGroup");
            if (this.f115612a.isVertical() == false) goto L5;
        L8:
            TextView r102 = new TextView(r100.getContext());
            r102.setTextSize(14.0f);
            r102.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.bytedance.android.live.core.utils.s1.e(56.0f)));
            com.bytedance.android.live.core.utils.a1.j(r102, 1);
            r102.setGravity(17);
        L10:
            return new ActionSheetItemViewHolder(r102);
        L5:
            if (PadConfigUtils.c() == false) goto L7;
            PadConfigUtils.c();
            goto L8
        L7:
            r102 = new TextView(r100.getContext());
            r102.setTextSize(15.0f);
            r102.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) com.bytedance.android.live.core.utils.s1.e(45.0f)));
            com.bytedance.android.live.core.utils.a1.j(r102, 1);
            r102.setGravity(17);
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/BaseActionSheet$ActionSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActionSheetItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f115613a;

        public ActionSheetItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f115613a = r100;
        }
    }

    public interface a {
        void onDismiss();

        void onShow();
    }

    public static final class b {
    }

    public interface c {
        void a(d r100);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f115614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f115615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f115616c;

        public d() {
        }
    }

    static {
    }

    public BaseActionSheet() {
        this.f115603g = new ArrayList();
        this.f115604h = R.color.ttlive_vs_action_sheet_item_common;
        this.f115605i = R.color.ttlive_vs_action_sheet_item_selected;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        a r100 = this.f115601e;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        a r100 = this.f115601e;
        if (r100 == null) goto L6;
        r100.onShow();
        return;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (PadConfigUtils.c() == false) goto L37;
        PadConfigUtils.c();
        View r101 = this.f115608l;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        Drawable r102 = com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_bg_broadcast_more_action_pad);
    L11:
        r101.setBackgroundDrawable(r102);
        Dialog r103 = getDialog();
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L16;
        WindowManager.LayoutParams r105 = r104.getAttributes();
        r105.height = com.bytedance.android.live.core.utils.x1.d(getContext());
        r104.setAttributes(r105);
    L16:
        View r106 = this.f115607k;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L19:
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == true) goto L22;
        r107 = null;
    L22:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L32;
        r108.height = -1;
        if (PadConfigUtils.c() == false) goto L27;
        int r109 = com.bytedance.android.live.core.utils.s1.f(375.0f);
    L28:
        r108.width = r109;
        View r110 = this.f115607k;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L31:
        r110.setLayoutParams(r108);
        goto L32
    L27:
        r109 = com.bytedance.android.live.core.utils.s1.y();
    L32:
        View r111 = this.f115607k;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L35:
        com.bytedance.android.live.core.utils.a1.j(r111, GravityCompat.END);
        return;
    L10:
        r102 = com.bytedance.android.live.core.utils.s1.m(R.drawable.ttlive_bg_broadcast_more_action);
        goto L11
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
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (PadConfigUtils.c() == false) goto L5;
        PadConfigUtils.c();
        int r103 = R.layout.ttlive_vs_action_sheet_pad;
    L6:
        View r104 = r100.inflate(r103, r101, false);
        this.f115606j = r104;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L9:
        this.f115607k = r104.findViewById(R.id.vs_action_container);
        View r105 = this.f115606j;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L12:
        this.f115609m = (RecyclerView) r105.findViewById(R.id.vs_action_sheet_list);
        View r106 = this.f115606j;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L15:
        this.f115608l = r106.findViewById(R.id.vs_action_sheet_container);
        View r107 = this.f115606j;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L18:
        this.f115610n = r107.findViewById(R.id.vs_action_sheet_cancel);
        View r108 = this.f115606j;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L21:
        this.f115611o = r108.findViewById(R.id.vs_action_sheet_empty_view);
        if (isVertical() == false) goto L24;
    L33:
        View r109 = this.f115611o;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetEmptyView");
    L36:
        r109.setOnClickListener(new l(this));
        View r110 = this.f115610n;
        if (r110 == null) goto L39;
        r110.setOnClickListener(new m(this));
    L39:
        RecyclerView r111 = this.f115609m;
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L42:
        r111.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView r112 = this.f115609m;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L45:
        r112.setAdapter(new ActionSheetAdapter(this));
        View r113 = this.f115606j;
        if (r113 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L48:
        return r113;
    L24:
        if (PadConfigUtils.c() == false) goto L26;
        PadConfigUtils.c();
        goto L33
    L26:
        Context r114 = getContext();
        Intrinsics.checkNotNull(r114);
        Drawable r115 = AppCompatResources.getDrawable(r114, R.drawable.ttlive_vs_actionsheet_bg);
        View r116 = this.f115608l;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L29:
        r116.setBackgroundDrawable(r115);
        View r117 = this.f115608l;
        if (r117 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L32:
        r117.setOnClickListener(new k(this));
        goto L33
    L5:
        r103 = R.layout.ttlive_vs_action_sheet;
        goto L6
    }
}
