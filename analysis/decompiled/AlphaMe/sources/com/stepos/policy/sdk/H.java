package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class H implements stepos.support.v7.app.S {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f12010a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12011b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.S f12012c;

    public H(String str, Context context, stepos.support.v7.app.S s4) {
        this.f12010a = str;
        this.f12011b = context;
        this.f12012c = s4;
    }

    @Override // stepos.support.v7.app.S
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        if (z5 && Intrinsics.areEqual(this.f12010a, "2")) {
            SocketHookUtil.recoveryPlatform();
            ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.f12011b;
            policyManager.saveReadClipboardStatus(context);
            policyManager.saveAgreeStatus(context, 1);
        }
        this.f12012c.onPermissionClick(dialogInterface, z4, z5);
    }
}
