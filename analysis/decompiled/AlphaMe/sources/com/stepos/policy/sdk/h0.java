package com.stepos.policy.sdk;

import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;

/* loaded from: classes.dex */
public final class h0 implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f12191a;

    public h0(PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f12191a = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        this.f12191a.onPermissionClick(dialogInterface, z5, z4 ? "1" : "0");
    }
}
