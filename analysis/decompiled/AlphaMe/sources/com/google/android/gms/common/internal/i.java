package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public final class i extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9812a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f9813b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9814c = 2;

    public i(Activity activity, Intent intent) {
        this.f9812a = intent;
        this.f9813b = activity;
    }

    @Override // com.google.android.gms.common.internal.k
    public final void a() {
        Intent intent = this.f9812a;
        if (intent != null) {
            this.f9813b.startActivityForResult(intent, this.f9814c);
        }
    }
}
