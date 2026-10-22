package com.google.android.gms.common.internal;

import android.content.Intent;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9815a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.internal.g f9816b;

    public j(Intent intent, com.google.android.gms.common.api.internal.g gVar) {
        this.f9815a = intent;
        this.f9816b = gVar;
    }

    @Override // com.google.android.gms.common.internal.k
    public final void a() {
        Intent intent = this.f9815a;
        if (intent != null) {
            this.f9816b.startActivityForResult(intent, 2);
        }
    }
}
