package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;

/* loaded from: classes.dex */
public final class E implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11997a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f11998b;

    public E(Context context, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f11997a = context;
        this.f11998b = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        if (z5) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f11997a;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
        }
        this.f11998b.onPermissionClick(dialogInterface, z4, z5);
    }
}
