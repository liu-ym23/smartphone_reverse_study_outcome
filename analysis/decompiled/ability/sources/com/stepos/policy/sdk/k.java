package com.stepos.policy.sdk;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import com.stepos.ability.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import kotlin.jvm.internal.Ref$ObjectRef;
import stepos.support.v7.app.DialogInterfaceC1961j;

/* loaded from: classes3.dex */
public final class k implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f3952a;
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener b;

    public k(Ref$ObjectRef ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f3952a = ref$ObjectRef;
        this.b = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        try {
            DialogInterfaceC1961j dialogInterfaceC1961j = (DialogInterfaceC1961j) this.f3952a.f4920a;
            View viewFindViewById = dialogInterfaceC1961j != null ? dialogInterfaceC1961j.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
            kotlin.jvm.internal.k.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            this.b.onPermissionClick(dialogInterface, ((CheckBox) viewFindViewById).isChecked(), z11);
        } catch (Exception unused) {
        }
    }
}
