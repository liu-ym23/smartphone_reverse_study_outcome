package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class K implements stepos.support.v7.app.S {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f12024a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12025b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12026c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12027d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12028e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f12029f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12030g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.S f12031h;

    public K(String str, Context context, String str2, String str3, String str4, String[] strArr, String str5, stepos.support.v7.app.S s4) {
        this.f12024a = str;
        this.f12025b = context;
        this.f12026c = str2;
        this.f12027d = str3;
        this.f12028e = str4;
        this.f12029f = strArr;
        this.f12030g = str5;
        this.f12031h = s4;
    }

    @Override // stepos.support.v7.app.S
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        if (z5) {
            if (Intrinsics.areEqual(this.f12024a, "1")) {
                SocketHookUtil.recoveryPlatform();
                ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                Context context = this.f12025b;
                policyManager.saveReadClipboardStatus(context);
                policyManager.saveAgreeStatus(context, 1);
            }
            PolicyManager.autoUploadRecord(this.f12025b, this.f12026c, this.f12027d, this.f12028e, this.f12029f, this.f12030g, this.f12024a);
        }
        this.f12031h.onPermissionClick(dialogInterface, z4, z5);
    }
}
