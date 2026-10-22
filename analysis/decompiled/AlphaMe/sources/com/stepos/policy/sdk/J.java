package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class J implements stepos.support.v7.app.S {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12017b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12018c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12019d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12020e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f12021f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12022g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.S f12023h;

    public /* synthetic */ J(Context context, String str, String str2, String str3, String[] strArr, String str4, stepos.support.v7.app.S s4, int i4) {
        this.f12016a = i4;
        this.f12017b = context;
        this.f12018c = str;
        this.f12019d = str2;
        this.f12020e = str3;
        this.f12021f = strArr;
        this.f12022g = str4;
        this.f12023h = s4;
    }

    @Override // stepos.support.v7.app.S
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        int i4 = this.f12016a;
        stepos.support.v7.app.S s4 = this.f12023h;
        switch (i4) {
            case 0:
                String str = z5 ? "2" : "0";
                if (z5) {
                    PolicyManager.autoUploadRecord(this.f12017b, this.f12018c, this.f12019d, this.f12020e, this.f12021f, this.f12022g, str);
                }
                s4.onPermissionClick(dialogInterface, z4, z5);
                break;
            case 1:
                String str2 = z5 ? "2" : "0";
                if (z5) {
                    PolicyManager.autoUploadRecord(this.f12017b, this.f12018c, this.f12019d, this.f12020e, this.f12021f, this.f12022g, str2);
                }
                s4.onPermissionClick(dialogInterface, z4, z5);
                break;
            default:
                String str3 = z5 ? "2" : "0";
                if (z5) {
                    PolicyManager.autoUploadRecord(this.f12017b, this.f12018c, this.f12019d, this.f12020e, this.f12021f, this.f12022g, str3);
                }
                s4.onPermissionClick(dialogInterface, z4, z5);
                break;
        }
    }
}
