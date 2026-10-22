package com.stepos.policy.sdk.util;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import stepos.support.v7.app.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ i f2798a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Context f2799b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f2800c;

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataOneCheckBox$lambda$2(this.f2798a, this.f2799b, this.f2800c, dialogInterface);
    }
}
