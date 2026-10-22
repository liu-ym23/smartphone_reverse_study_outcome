package com.stepos.policy.sdk;

import android.content.Context;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7950b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f7951c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7952d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f7953e;

    public /* synthetic */ a(Context context, boolean z, String str, String str2, int i10) {
        this.f7949a = i10;
        this.f7950b = context;
        this.f7951c = z;
        this.f7952d = str;
        this.f7953e = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7949a) {
            case 0:
                PolicyManager.createReGrantDialogBuilder$lambda$8(this.f7950b, this.f7951c, this.f7952d, this.f7953e, view);
                break;
            default:
                PolicyManager.showReGrantTwoPolicyDialog$lambda$7(this.f7950b, this.f7951c, this.f7952d, this.f7953e, view);
                break;
        }
    }
}
