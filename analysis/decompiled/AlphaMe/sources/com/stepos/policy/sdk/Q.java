package com.stepos.policy.sdk;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import stepos.support.v7.app.DialogInterfaceC0865j;

/* loaded from: classes.dex */
public final class Q implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f12051a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f12052b;

    public Q(Ref.ObjectRef objectRef, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f12051a = objectRef;
        this.f12052b = onPermissionClickListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        Ref.ObjectRef objectRef = this.f12051a;
        try {
            DialogInterfaceC0865j dialogInterfaceC0865j = (DialogInterfaceC0865j) objectRef.element;
            View viewFindViewById = dialogInterfaceC0865j != null ? dialogInterfaceC0865j.findViewById(R.id.stepos_permission_dialog_checkbox_first) : null;
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.CheckBox");
            boolean zIsChecked = ((CheckBox) viewFindViewById).isChecked();
            DialogInterfaceC0865j dialogInterfaceC0865j2 = (DialogInterfaceC0865j) objectRef.element;
            View viewFindViewById2 = dialogInterfaceC0865j2 != null ? dialogInterfaceC0865j2.findViewById(R.id.stepos_permission_dialog_checkbox_second) : null;
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
            this.f12052b.onPermissionClick(dialogInterface, z5, zIsChecked, ((CheckBox) viewFindViewById2).isChecked());
        } catch (Exception unused) {
        }
    }
}
