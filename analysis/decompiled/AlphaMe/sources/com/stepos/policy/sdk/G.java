package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;

/* loaded from: classes.dex */
public final class G implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12003a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12004b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12005c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12006d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String[] f12007e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f12008f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener f12009g;

    public G(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener) {
        this.f12003a = context;
        this.f12004b = str;
        this.f12005c = str2;
        this.f12006d = str3;
        this.f12007e = strArr;
        this.f12008f = str4;
        this.f12009g = onPermissionClickListener;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        String str = z5 ? "2" : "0";
        if (z5) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f12003a;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
            PolicyManager.autoUploadRecord(this.f12003a, this.f12004b, this.f12005c, this.f12006d, this.f12007e, this.f12008f, str);
        }
        this.f12009g.onPermissionClick(dialogInterface, z4, z5);
    }
}
