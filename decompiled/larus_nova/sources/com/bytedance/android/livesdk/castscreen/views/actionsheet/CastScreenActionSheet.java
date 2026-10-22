package com.bytedance.android.livesdk.castscreen.views.actionsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rf1.b;
import rf1.c;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "<init>", "()V", "ActionSheetAdapter", "ActionSheetItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CastScreenActionSheet extends AdaptiveDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<? extends a> f104760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f104761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f104762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f104763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f104764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f104765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f104766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f104767l;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet$ActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet$ActionSheetItemViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetAdapter extends RecyclerView.Adapter<ActionSheetItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CastScreenActionSheet f104768a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ActionSheetAdapter f104769a;

            public a(ActionSheetAdapter r100, a r101) {
                this.f104769a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f104769a.f104768a.getClass();
                Dialog r101 = this.f104769a.f104768a.getDialog();
                if (r101 == null) goto L21;
                Handler r102 = DialogLancet.resolveDialogHandler(r101);
                if (r102 != null) goto L7;
            L9:
                DialogLancet.beforeDialogDismiss(r101);
                r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
            L18:
                DialogLancet.afterDialogDismiss(r101);
                return;
            L12:
                th = move-exception;
                DialogLancet.afterDialogDismiss(r101);
                throw th;
            L14:
                e = move-exception;
                d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
                Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
                if (r103 == null) goto L18;
                d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
                goto L18
            L7:
                if (Looper.myLooper() == r102.getLooper()) goto L9;
                r102.post(DialogLancet.createDismissRunnable(r101));
                return;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f104768a.f104760e).size();
        }

        public ActionSheetAdapter(CastScreenActionSheet r100) {
            Intrinsics.checkNotNullParameter(r100, "actionSheet");
            this.f104768a = r100;
        }

        public int y2(boolean r100) {
            if (r100 == false) goto L4;
            float r101 = s1.e(45.0f);
        L6:
            return (int) r101;
        L4:
            r101 = s1.e(56.0f);
            goto L6
        }

        public ActionSheetItemViewHolder A2(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewGroup");
            if (this.f104768a.isVertical() == false) goto L5;
        L8:
            TextView r102 = new TextView(r100.getContext());
            r102.setTextSize(14.0f);
            r102.setLayoutParams(new ViewGroup.LayoutParams(-1, y2(false)));
            a1.j(r102, 1);
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
            r102.setLayoutParams(new ViewGroup.LayoutParams(-1, y2(true)));
            a1.j(r102, 1);
            r102.setGravity(17);
            goto L10
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            z2((ActionSheetItemViewHolder) r100, r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            return A2(r100, r101);
        }

        public void z2(ActionSheetItemViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
            a r102 = (a) ListProtector.get(this.f104768a.f104760e, r101);
            r102.getClass();
            r100.f104770a.setOnClickListener(new a(this, r102));
            if (this.f104768a.isVertical() == false) goto L5;
        L12:
            View r103 = r100.f104770a;
            if (r103 == null) goto L17;
            TextView r104 = (TextView) r103;
            r104.setText(null);
            r104.setTextColor(s1.h(this.f104768a.f104761f));
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        L5:
            if (PadConfigUtils.c() == false) goto L7;
            PadConfigUtils.c();
            goto L12
        L7:
            View r105 = r100.f104770a;
            if (r105 == null) goto L11;
            TextView r106 = (TextView) r105;
            r106.setText(null);
            r106.setTextColor(s1.h(this.f104768a.f104761f));
            r105.setBackgroundDrawable(null);
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/views/actionsheet/CastScreenActionSheet$ActionSheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class ActionSheetItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f104770a;

        public ActionSheetItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f104770a = r100;
        }
    }

    public static class a {
        public a() {
        }
    }

    public ActionSheetAdapter S90() {
        return new ActionSheetAdapter(this);
    }

    public CastScreenActionSheet() {
        this.f104760e = new ArrayList();
        this.f104761f = R.color.ttlive_cast_screen_action_sheet_item_common;
    }

    public int getLayoutId() {
        if (PadConfigUtils.c() == false) goto L5;
        PadConfigUtils.c();
        return R.layout.ttlive_cast_screen_action_sheet_pad;
    L5:
        return R.layout.ttlive_cast_screen_action_sheet;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (PadConfigUtils.c() == false) goto L37;
        PadConfigUtils.c();
        View r101 = this.f104764i;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        Drawable r102 = s1.m(R.drawable.ttlive_bg_broadcast_more_action_pad);
    L11:
        r101.setBackgroundDrawable(r102);
        Dialog r103 = getDialog();
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L16;
        WindowManager.LayoutParams r105 = r104.getAttributes();
        r105.height = x1.d(getContext());
        r104.setAttributes(r105);
    L16:
        View r106 = this.f104763h;
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
        int r109 = s1.f(375.0f);
    L28:
        r108.width = r109;
        View r110 = this.f104763h;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L31:
        r110.setLayoutParams(r108);
        goto L32
    L27:
        r109 = s1.y();
    L32:
        View r111 = this.f104763h;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
    L35:
        a1.j(r111, GravityCompat.END);
        return;
    L10:
        r102 = s1.m(R.drawable.ttlive_bg_broadcast_more_action);
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
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L14;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(getLayoutId(), r101, false);
        this.f104762g = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L5:
        this.f104763h = r103.findViewById(R.id.vs_action_container);
        View r104 = this.f104762g;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L8:
        this.f104765j = (RecyclerView) r104.findViewById(R.id.vs_action_sheet_list);
        View r105 = this.f104762g;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L11:
        this.f104764i = r105.findViewById(R.id.vs_action_sheet_container);
        View r106 = this.f104762g;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L14:
        this.f104766k = r106.findViewById(R.id.vs_action_sheet_cancel);
        View r107 = this.f104762g;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L17:
        this.f104767l = r107.findViewById(R.id.vs_action_sheet_empty_view);
        if (isVertical() == false) goto L20;
    L29:
        View r108 = this.f104767l;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetEmptyView");
    L32:
        r108.setOnClickListener(new b(this));
        View r109 = this.f104766k;
        if (r109 == null) goto L35;
        r109.setOnClickListener(new c(this));
    L35:
        RecyclerView r110 = this.f104765j;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L38:
        r110.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView r111 = this.f104765j;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetListView");
    L41:
        r111.setAdapter(S90());
        View r112 = this.f104762g;
        if (r112 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mView");
    L44:
        return r112;
    L20:
        if (PadConfigUtils.c() == false) goto L22;
        PadConfigUtils.c();
        goto L29
    L22:
        Context r113 = getContext();
        Intrinsics.checkNotNull(r113);
        Drawable r114 = AppCompatResources.getDrawable(r113, R.drawable.ttlive_vs_actionsheet_bg);
        View r115 = this.f104764i;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L25:
        r115.setBackgroundDrawable(r114);
        View r116 = this.f104764i;
        if (r116 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mActionSheetContainer");
    L28:
        r116.setOnClickListener(new rf1.a(this));
        goto L29
    }
}
