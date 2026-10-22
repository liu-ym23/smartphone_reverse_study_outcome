package com.stepos.policy.sdk;

import android.content.Context;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2776c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Context f2777f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f2778g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f2779h;
    public /* synthetic */ String i;

    public /* synthetic */ a(int i) {
        this.f2776c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2776c) {
            case 0:
                PolicyManager.createReGrantDialogBuilder$lambda$6(this.f2777f, this.f2778g, this.f2779h, this.i, view);
                break;
            case 1:
                PolicyManager.showReGrantTwoPolicyDialogAndUploadRecord$lambda$4(this.f2777f, this.f2778g, this.f2779h, this.i, view);
                break;
            default:
                PolicyManager.showReGrantTwoPolicyDialog$lambda$5(this.f2777f, this.f2778g, this.f2779h, this.i, view);
                break;
        }
    }
}
