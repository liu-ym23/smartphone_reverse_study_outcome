package com.stepos.policy.sdk.util;

import android.content.Context;
import android.content.DialogInterface;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import stepos.support.v7.app.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ i f2791a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Context f2792b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f2793c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ String f2794d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ String f2795e;

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        PolicySdkToolsUtils.Companion.initWithdrawalCleanDataTwoCheckBox$lambda$5(this.f2791a, this.f2792b, this.f2793c, this.f2794d, this.f2795e, dialogInterface);
    }
}
