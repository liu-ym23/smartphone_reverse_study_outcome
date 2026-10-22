package com.stepos.policy.sdk;

import android.content.Context;
import android.view.View;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3941a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ a(Context context, boolean z10, String str, String str2, int i) {
        this.f3941a = i;
        this.b = context;
        this.c = z10;
        this.d = str;
        this.e = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3941a) {
            case 0:
                PolicyManager.createReGrantDialogBuilder$lambda$8(this.b, this.c, this.d, this.e, view);
                break;
            case 1:
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$6(this.b, this.c, this.d, this.e, view);
                break;
            default:
                PolicyManager.showReGrantTwoPolicyDialog$lambda$7(this.b, this.c, this.d, this.e, view);
                break;
        }
    }
}
