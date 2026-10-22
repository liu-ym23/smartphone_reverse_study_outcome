package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements t22.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinAnswerProcessor f138754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j42.a f138755b;

    @Override // t22.d
    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        long r101 = this.f138755b.f497341a.j();
        String r102 = this.f138755b.f497341a.h();
        if (r102 != null) goto L8;
        String r103 = "";
    L9:
        String r104 = String.valueOf(this.f138755b.f497341a.f());
        String r105 = this.f138755b.f497341a.i();
        if (r105 != null) goto L12;
        String r106 = "";
    L13:
        j42.b r107 = new j42.b(r101, r103, r104, r106);
        PinAnswerProcessor.u(this.f138754a, r100.toString(), r107, Long.valueOf(this.f138755b.f497341a.b()));
        return;
    L12:
        r106 = r105;
        goto L13
    L8:
        r103 = r102;
        goto L9
    }

    public f(PinAnswerProcessor r100, j42.a r101) {
        this.f138754a = r100;
        this.f138755b = r101;
    }
}
