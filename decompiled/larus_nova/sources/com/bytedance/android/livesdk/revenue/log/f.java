package com.bytedance.android.livesdk.revenue.log;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final am2.b f157173a;

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void i() {
        this.f157173a.f4263i = 0;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void k() {
        this.f157173a.f4260f = 1;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void g() {
        this.f157173a.f4264j = 0;
    }

    public f() {
        this.f157173a = new am2.b();
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final am2.b a() {
        return this.f157173a;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void b(String r100) {
        this.f157173a.f4261g = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "connectionType");
        this.f157173a.f4255a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void d(long r100) {
        this.f157173a.f4257c = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void e(String r100) {
        am2.b r101 = this.f157173a;
        if (r100 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r100);
    L6:
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
    L9:
        r101.f4262h = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void f(String r100) {
        am2.b r101 = this.f157173a;
        if (r100 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r100);
    L6:
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
    L9:
        r101.f4258d = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void h(boolean r100) {
        am2.b r101 = this.f157173a;
        r101.getClass();
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.f4256b = r102;
        return;
    L5:
        r102 = "0";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.log.b
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "inviteeList");
        this.f157173a.f4259e = r100;
    }
}
