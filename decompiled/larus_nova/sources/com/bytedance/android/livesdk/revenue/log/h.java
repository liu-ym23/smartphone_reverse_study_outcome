package com.bytedance.android.livesdk.revenue.log;

import am2.m;
import com.bytedance.android.live.link.constants.UserListInviteType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f157175a;

    public final void g() {
        m r100 = this.f157175a;
        r100.getClass();
        r100.f4307f = "0";
    }

    public h() {
        this.f157175a = new m();
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final m a() {
        return this.f157175a;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "connectionTime");
        this.f157175a.f4305d = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final void c(long r100) {
        m r101 = this.f157175a;
        r101.getClass();
        r101.f4306e = UserListInviteType.a((int) r100, null);
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        this.f157175a.f4304c = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final void e(String r100) {
        m r101 = this.f157175a;
        if (r100 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r100);
    L6:
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
    L9:
        r101.f4302a = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.log.c
    public final void f(String r100) {
        m r101 = this.f157175a;
        if (r100 == null) goto L5;
        Long r102 = StringsKt.toLongOrNull(r100);
    L6:
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
    L9:
        r101.f4303b = r103;
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f157175a.f4309h = r100;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f157175a.f4308g = r100;
    }
}
