package com.stepos.policy.sdk;

import android.content.Context;
import android.view.View;

/* renamed from: com.stepos.policy.sdk.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0515n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12230a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12231b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f12232c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12233d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12234e;

    public /* synthetic */ ViewOnClickListenerC0515n(Context context, boolean z4, String str, String str2, int i4) {
        this.f12230a = i4;
        this.f12231b = context;
        this.f12232c = z4;
        this.f12233d = str;
        this.f12234e = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f12230a;
        boolean z4 = this.f12232c;
        Context context = this.f12231b;
        String str = this.f12234e;
        String str2 = this.f12233d;
        switch (i4) {
            case 0:
                PolicyManager.createReGrantDialogBuilder$lambda$6(context, z4, str2, str, view);
                break;
            case 1:
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$4(context, z4, str2, str, view);
                break;
            default:
                PolicyManager.showReGrantTwoPolicyDialog$lambda$5(context, z4, str2, str, view);
                break;
        }
    }
}
