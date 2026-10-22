package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;
import stepos.support.v7.app.P;

/* loaded from: classes3.dex */
public final class j implements P {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3951a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String[] f;
    public final /* synthetic */ String g;
    public final /* synthetic */ P h;

    public /* synthetic */ j(Context context, String str, String str2, String str3, String[] strArr, String str4, P p, int i) {
        this.f3951a = i;
        this.b = context;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = strArr;
        this.g = str4;
        this.h = p;
    }

    @Override // stepos.support.v7.app.P
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        switch (this.f3951a) {
            case 0:
                String str = z11 ? "2" : "0";
                if (z11) {
                    PolicyManager.autoUploadRecord(this.b, this.c, this.d, this.e, this.f, this.g, str);
                }
                this.h.onPermissionClick(dialogInterface, z10, z11);
                break;
            case 1:
                String str2 = z11 ? "2" : "0";
                if (z11) {
                    PolicyManager.autoUploadRecord(this.b, this.c, this.d, this.e, this.f, this.g, str2);
                }
                this.h.onPermissionClick(dialogInterface, z10, z11);
                break;
            default:
                String str3 = z11 ? "2" : "0";
                if (z11) {
                    PolicyManager.autoUploadRecord(this.b, this.c, this.d, this.e, this.f, this.g, str3);
                }
                this.h.onPermissionClick(dialogInterface, z10, z11);
                break;
        }
    }
}
