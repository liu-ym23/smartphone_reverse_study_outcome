package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* renamed from: com.google.android.gms.common.internal.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1679u extends AbstractDialogInterfaceOnClickListenerC1681w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f19849a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f19850b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19851c;

    public C1679u(Intent intent, Activity activity, int i10) {
        this.f19849a = intent;
        this.f19850b = activity;
        this.f19851c = i10;
    }

    @Override // com.google.android.gms.common.internal.AbstractDialogInterfaceOnClickListenerC1681w
    public final void a() {
        Intent intent = this.f19849a;
        if (intent != null) {
            this.f19850b.startActivityForResult(intent, this.f19851c);
        }
    }
}
