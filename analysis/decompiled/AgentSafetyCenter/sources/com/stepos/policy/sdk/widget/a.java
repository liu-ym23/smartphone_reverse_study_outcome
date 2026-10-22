package com.stepos.policy.sdk.widget;

import android.view.View;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ u f2807c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ long f2808f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ View.OnClickListener f2809g;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PolicySDKLoadDataView.setDebounceClickListener$lambda$1(this.f2807c, this.f2808f, this.f2809g, view);
    }
}
