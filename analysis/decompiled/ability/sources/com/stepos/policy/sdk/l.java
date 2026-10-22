package com.stepos.policy.sdk;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import com.stepos.ability.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import kotlin.jvm.internal.Ref$ObjectRef;
import stepos.support.v7.app.DialogInterfaceC1961j;

/* loaded from: classes3.dex */
public final class l implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f3953a;
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener b;

    public l(Ref$ObjectRef ref$ObjectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f3953a = ref$ObjectRef;
        this.b = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        Ref$ObjectRef ref$ObjectRef = this.f3953a;
        try {
            DialogInterfaceC1961j dialogInterfaceC1961j = (DialogInterfaceC1961j) ref$ObjectRef.f4920a;
            View viewFindViewById = dialogInterfaceC1961j != null ? dialogInterfaceC1961j.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
            kotlin.jvm.internal.k.d(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
            DialogInterfaceC1961j dialogInterfaceC1961j2 = (DialogInterfaceC1961j) ref$ObjectRef.f4920a;
            View viewFindViewById2 = dialogInterfaceC1961j2 != null ? dialogInterfaceC1961j2.findViewById(R.id.stepos_permission_dialog_checkbox_second) : null;
            kotlin.jvm.internal.k.d(viewFindViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
            this.b.onPermissionClick(dialogInterface, z11, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
        } catch (Exception unused) {
        }
    }
}
