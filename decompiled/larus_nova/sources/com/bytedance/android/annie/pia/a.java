package com.bytedance.android.annie.pia;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.annie.ng.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.ng.d.a f39721a;

    @Override // com.bytedance.android.annie.ng.j
    public final void onCallback() {
        c47.c r100 = b.f39722a;
        Application r101 = this.f39721a.f39660a;
        Intrinsics.checkNotNullParameter(r101, "application");
        Context r102 = r101.getApplicationContext();
        if (r102 != null) goto L5;
        Context r103 = c47.c.a.f22405a;
    L9:
        k47.b r104 = (k47.b) c47.b.b(k47.b.class);
        if (r104 == null) goto L13;
        r104.a(b.f39722a);
        return;
    L13:
        return;
    L5:
        if (c47.c.a.f22405a != null) goto L9;
        c47.c.a.f22405a = r102;
        goto L9
    }

    public a(com.bytedance.android.annie.ng.d.a r100) {
        this.f39721a = r100;
    }
}
