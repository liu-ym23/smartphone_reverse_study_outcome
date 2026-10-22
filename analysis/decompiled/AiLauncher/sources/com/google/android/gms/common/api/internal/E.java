package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C1637c;

/* loaded from: classes2.dex */
public final class E implements ComponentCallbacks2C1637c.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1640f f19536a;

    public E(C1640f c1640f) {
        this.f19536a = c1640f;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C1637c.a
    public final void a(boolean z10) {
        C1640f c1640f = this.f19536a;
        c1640f.f19618n.sendMessage(c1640f.f19618n.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
