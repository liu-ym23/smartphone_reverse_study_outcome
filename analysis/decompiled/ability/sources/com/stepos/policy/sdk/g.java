package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;

/* loaded from: classes3.dex */
public final class g implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3949a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String[] e;
    public final /* synthetic */ String f;
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener g;

    public g(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f3949a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = strArr;
        this.f = str4;
        this.g = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        String str = z11 ? "2" : "0";
        if (z11) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f3949a;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
            PolicyManager.autoUploadRecord(this.f3949a, this.b, this.c, this.d, this.e, this.f, str);
        }
        this.g.onPermissionClick(dialogInterface, z10, z11);
    }
}
