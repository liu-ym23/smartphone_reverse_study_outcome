package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import java.util.Map;
import stepos.support.v7.app.P;

/* loaded from: classes3.dex */
public final class i implements PolicyPermissionDialogBuilder.OnThreeButtonClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3950a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String[] e;
    public final /* synthetic */ String f;
    public final /* synthetic */ PolicyPermissionDialogBuilder.OnPermissionClickListener g;
    public final /* synthetic */ P h;

    public i(Context context, String str, String str2, String str3, String[] strArr, String str4, PolicyPermissionDialogBuilder.OnPermissionClickListener onPermissionClickListener, P p) {
        this.f3950a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = strArr;
        this.f = str4;
        this.g = onPermissionClickListener;
        this.h = p;
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
    public final void onBasicOnlyClick(DialogInterface dialogInterface, boolean z10) {
        SocketHookUtil.recoveryPlatform();
        ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
        PolicyManager policyManager = PolicyManager.INSTANCE;
        Context context = this.f3950a;
        policyManager.saveReadClipboardStatus(context);
        policyManager.saveAgreeStatus(context, 1);
        PolicyManager.autoUploadRecord(this.f3950a, this.b, this.c, this.d, this.e, this.f, "1");
        this.h.onPermissionClick(dialogInterface, z10, true);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
    public final void onFullAgreeClick(DialogInterface dialogInterface, boolean z10, Map map) {
        SocketHookUtil.recoveryPlatform();
        ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
        PolicyManager policyManager = PolicyManager.INSTANCE;
        Context context = this.f3950a;
        policyManager.saveReadClipboardStatus(context);
        policyManager.saveAgreeStatus(context, 1);
        PolicyManager.autoUploadRecord(this.f3950a, this.b, this.c, this.d, this.e, this.f, "2");
        this.g.onPermissionClick(dialogInterface, z10, true);
    }

    @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnThreeButtonClickListener
    public final void onRejectClick(DialogInterface dialogInterface, boolean z10) {
        this.h.onPermissionClick(dialogInterface, z10, false);
    }
}
