package com.stepos.policy.sdk;

import android.content.Context;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public final class L implements stepos.support.v7.app.S {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f12032a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f12033b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f12034c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12035d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f12036e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String[] f12037f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f12038g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.S f12039h;

    public L(boolean z4, Context context, String str, String str2, String str3, String[] strArr, String str4, stepos.support.v7.app.S s4) {
        this.f12032a = z4;
        this.f12033b = context;
        this.f12034c = str;
        this.f12035d = str2;
        this.f12036e = str3;
        this.f12037f = strArr;
        this.f12038g = str4;
        this.f12039h = s4;
    }

    @Override // stepos.support.v7.app.S
    public final void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5) {
        if (z5 && this.f12032a) {
            PolicyManager.autoUploadRecord(this.f12033b, this.f12034c, this.f12035d, this.f12036e, this.f12037f, this.f12038g, "2");
        }
        this.f12039h.onPermissionClick(dialogInterface, z4, z5);
    }
}
