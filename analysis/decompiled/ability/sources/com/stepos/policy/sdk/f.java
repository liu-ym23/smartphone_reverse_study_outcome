package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;

/* loaded from: classes3.dex */
public final class f implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3948a;
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener b;

    public f(Context context, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f3948a = context;
        this.b = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        if (z11) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f3948a;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
        }
        this.b.onPermissionClick(dialogInterface, z10, z11);
    }
}
