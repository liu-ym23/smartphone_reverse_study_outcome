package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.InterfaceC1642h;

/* renamed from: com.google.android.gms.common.internal.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1680v extends AbstractDialogInterfaceOnClickListenerC1681w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f19852a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1642h f19853b;

    public C1680v(Intent intent, InterfaceC1642h interfaceC1642h, int i10) {
        this.f19852a = intent;
        this.f19853b = interfaceC1642h;
    }

    @Override // com.google.android.gms.common.internal.AbstractDialogInterfaceOnClickListenerC1681w
    public final void a() {
        Intent intent = this.f19852a;
        if (intent != null) {
            this.f19853b.startActivityForResult(intent, 2);
        }
    }
}
