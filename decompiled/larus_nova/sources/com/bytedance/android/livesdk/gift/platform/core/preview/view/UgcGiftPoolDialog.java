package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftPoolViewModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftPoolDialog;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftPoolDialog extends BaseUgcGiftDialog {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f131034r = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UgcGiftPoolViewModel f131035p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f f131036q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90() {
        RecyclerView r100 = this.f131007g;
        UgcGiftPoolViewModel r101 = this.f131035p;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        return new UgcGiftPoolAdapter(r100, r101);
    L6:
        return null;
    }

    public final void T90() {
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f r100 = this.f131036q;
        if (r100 != null) goto L5;
    L10:
        com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
        DialogInterface.OnDismissListener r101 = this.f131014n;
        if (r101 == null) goto L14;
        r101.onDismiss(null);
        return;
    L14:
        return;
    L5:
        if (com.bytedance.android.scope.l.b(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        com.bytedance.android.scope.l.c(r100);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L8:
        T90();
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L8;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public UgcGiftPoolDialog() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_ugc_pool_dialog);
        com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
        r101.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f r102 = new com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f(com.bytedance.android.scope.m.f163448d);
        Intrinsics.checkNotNullParameter(r102, "scope");
        String r103 = this.f131005e;
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.f131134f = r103;
        Integer r104 = Integer.valueOf(this.f131004d);
        r102.f131133e = r104;
        Object r105 = e33.k.f470908a;
        if (r104 != r105) goto L6;
        String r106 = "sourceFrom";
    L9:
        if (r106 != null) goto L19;
        com.bytedance.android.scope.l.a(r102);
        Unit r107 = Unit.INSTANCE;
        this.f131036q = r102;
        Intrinsics.checkNotNull(r102);
        UgcGiftPoolViewModel r108 = (UgcGiftPoolViewModel) r101.d(r102, UgcGiftPoolViewModel.class);
        this.f131035p = r108;
        if (r108 == null) goto L20;
        PropertyOwner r109 = r108.f131124b;
        if (r109 == null) goto L21;
        Observable r110 = RxUtilKt.h(r109);
        if (r110 == null) goto L22;
        r110.subscribe(new f(this));
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        throw new UninitializedPropertyAccessException(r106);
    L6:
        if (r102.f131134f != r105) goto L8;
        r106 = "clickFrom";
        goto L9
    L8:
        r106 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog, com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        TextView r102 = (TextView) r100.findViewById(R.id.sub_title);
        if (r102 == null) goto L5;
        r102.setVisibility(0);
        r102.setText((String) g.f131093b.getValue(null, g.f131092a[0]));
        Unit r103 = Unit.INSTANCE;
    L6:
        this.f131008h = r102;
        TextView r104 = (TextView) r100.findViewById(R.id.title);
        if (r104 == null) goto L9;
        r104.setText(getString(R.string.ttlive_interact_gift_pool_title));
        Unit r105 = Unit.INSTANCE;
    L9:
        View r106 = r100.findViewById(R.id.back);
        r106.setOnClickListener(new c(this));
        Unit r107 = Unit.INSTANCE;
        this.f131009i = r106;
        View r108 = r100.findViewById(R.id.close_view);
        r108.setOnClickListener(new d(this));
        this.f131010j = r108;
        View r109 = this.f131011k;
        if (r109 == null) goto L13;
        r109.setVisibility(8);
    L13:
        if (this.f131006f == null) goto L15;
        r100.postDelayed(new e(r100, this), 500);
    L15:
        RecyclerView r110 = this.f131007g;
        if (r110 == null) goto L19;
        r110.addOnScrollListener(new UgcGiftPoolDialog$initView$$inlined$run$lambda$4(this));
        return;
    L19:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
