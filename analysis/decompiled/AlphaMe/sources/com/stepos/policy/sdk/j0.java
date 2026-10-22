package com.stepos.policy.sdk;

import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* loaded from: classes.dex */
public final class j0 implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f12204a;

    public j0(PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f12204a = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, boolean z6) {
        this.f12204a.onPermissionClick(dialogInterface, z4, PolicySdkToolsUtils.INSTANCE.getVerifyType(z5, z6));
    }
}
