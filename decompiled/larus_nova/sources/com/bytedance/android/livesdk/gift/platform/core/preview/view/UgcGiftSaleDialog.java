package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftDialogViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleDialog;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSaleDialog extends BaseUgcGiftDialog {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f131055z = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f131056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f131057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Long f131058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f131059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f131060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f131061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f131062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f131063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public UgcGiftDialogViewModel f131064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g f131065y;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90() {
        RecyclerView r100 = this.f131007g;
        Context r101 = getContext();
        UgcGiftDialogViewModel r102 = this.f131064x;
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (r102 == null) goto L7;
        return new UgcGiftSaleAdapter(r101, r100, r102);
    L7:
        return null;
    }

    public UgcGiftSaleDialog() {
    }

    public final void T90(PanelOperationState r100) {
        UgcGiftDialogViewModel r101 = this.f131064x;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "state");
        r101.f131119c.a(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        DialogInterface.OnDismissListener r101 = this.f131014n;
        if (r101 == null) goto L6;
        r101.onDismiss(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
        r101.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g r102 = new com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g(com.bytedance.android.scope.m.f163448d);
        Intrinsics.checkNotNullParameter(r102, "scope");
        String r103 = this.f131005e;
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.f131138g = r103;
        r102.f131137f = this.f131058r;
        Integer r104 = Integer.valueOf(this.f131004d);
        r102.f131136e = r104;
        Object r105 = e33.k.f470908a;
        if (r104 != r105) goto L6;
        String r106 = "sourceFrom";
    L12:
        if (r106 != null) goto L25;
        com.bytedance.android.scope.l.a(r102);
        Unit r107 = Unit.INSTANCE;
        this.f131065y = r102;
        Intrinsics.checkNotNull(r102);
        UgcGiftDialogViewModel r108 = (UgcGiftDialogViewModel) r101.d(r102, UgcGiftDialogViewModel.class);
        this.f131064x = r108;
        if (r108 == null) goto L20;
        PropertyOwner r109 = r108.f131118b;
        if (r109 == null) goto L20;
        Observable r110 = RxUtilKt.h(r109);
        if (r110 == null) goto L20;
        r110.subscribe(new r(this));
    L20:
        View r111 = this.f131011k;
        if (r111 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r111);
        return;
    L26:
        return;
    L25:
        throw new UninitializedPropertyAccessException(r106);
    L6:
        if (r102.f131137f != r105) goto L9;
        r106 = "locationGiftId";
        goto L12
    L9:
        if (r102.f131138g != r105) goto L11;
        r106 = "clickFrom";
        goto L12
    L11:
        r106 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L16
        super.onDismiss(r100);     // Catch: Throwable -> L16
        View r101 = this.f131011k;     // Catch: Throwable -> L16
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r101);     // Catch: Throwable -> L16
    L5:
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g r102 = this.f131065y;     // Catch: Throwable -> L16
        if (r102 != null) goto L8;
    L13:
        com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();     // Catch: Throwable -> L16
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        if (com.bytedance.android.scope.l.b(r102) == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        com.bytedance.android.scope.l.c(r102);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog, com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = r100.findViewById(R.id.add_container);
        TextView r103 = null;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
        Unit r104 = Unit.INSTANCE;
    L6:
        this.f131056p = r102;
        View r105 = r100.findViewById(R.id.set_top_container);
        if (r105 == null) goto L9;
        r105.setVisibility(0);
        Unit r106 = Unit.INSTANCE;
    L10:
        this.f131059s = r105;
        View r107 = r100.findViewById(R.id.save_container);
        int r108 = 8;
        if (r107 == null) goto L13;
        r107.setVisibility(8);
        Unit r109 = Unit.INSTANCE;
    L14:
        this.f131057q = r107;
        View r110 = r100.findViewById(R.id.notice_container);
        if (r110 != null) goto L17;
        r110 = null;
    L22:
        this.f131060t = r110;
        View r111 = r100.findViewById(R.id.remind_dot);
        if (r111 != null) goto L25;
        r111 = null;
    L29:
        this.f131062v = r111;
        TextView r112 = (TextView) r100.findViewById(R.id.title);
        if (r112 == null) goto L32;
        r112.setText(getString(R.string.ttlive_interact_gift_config_title));
        Unit r113 = Unit.INSTANCE;
    L32:
        TextView r114 = (TextView) r100.findViewById(R.id.notice_text);
        if (r114 == null) goto L35;
        r114.setText((String) u.f131115b.getValue(null, u.f131114a[0]));
        Unit r115 = Unit.INSTANCE;
    L35:
        View r116 = r100.findViewById(R.id.notice_confirm);
        if (r116 == null) goto L38;
        r116.setOnClickListener(new l(this));
        Unit r117 = Unit.INSTANCE;
    L39:
        this.f131061u = r116;
        TextView r118 = (TextView) r100.findViewById(R.id.sub_title);
        if (r118 == null) goto L47;
        r118.setVisibility(0);
        Object[] r119 = new Object[1];
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r120 = this.f131013m;
        if (r120 == null) goto L45;
        String r121 = String.valueOf(r120.getItemCount());
        if (r121 == null) goto L45;
    L46:
        r119[0] = r121;
        r118.setText(getString(R.string.ttlive_interact_gift_config_sub_title, r119));
        Unit r122 = Unit.INSTANCE;
        r103 = r118;
    L45:
        r121 = "0";
    L47:
        this.f131008h = r103;
        View r123 = r100.findViewById(R.id.close_view);
        r123.setOnClickListener(new m(this));
        Unit r124 = Unit.INSTANCE;
        this.f131010j = r123;
        View r125 = r100.findViewById(R.id.back);
        r125.setOnClickListener(new n(this));
        this.f131009i = r125;
        View r126 = this.f131056p;
        if (r126 == null) goto L50;
        r126.setOnClickListener(new o(this));
    L50:
        View r127 = this.f131059s;
        if (r127 == null) goto L53;
        r127.setOnClickListener(new p(this));
    L53:
        View r128 = this.f131057q;
        if (r128 == null) goto L56;
        r128.setOnClickListener(new q(this));
    L56:
        T90(PanelOperationState.Remove);
        return;
    L38:
        r116 = null;
        goto L39
    L25:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.preview.j.f131001b.getValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.f131000a[0])).booleanValue() == false) goto L27;
        r108 = 0;
    L27:
        r111.setVisibility(r108);
        Unit r129 = Unit.INSTANCE;
        goto L29
    L17:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.preview.j.f131002c.getValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.f131000a[1])).booleanValue() == false) goto L19;
        int r130 = 0;
    L20:
        r110.setVisibility(r130);
        Unit r131 = Unit.INSTANCE;
        goto L22
    L19:
        r130 = 8;
        goto L20
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
