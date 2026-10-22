package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f136552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f136553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f136554c;

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void b() {
        this.f136552a = true;
        if (this.f136553b == false) goto L7;
        this.f136554c.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void c() {
        this.f136553b = true;
        if (this.f136552a == false) goto L6;
        this.f136554c.invoke();
        return;
    }

    public a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onRenderEndCallBack");
        this.f136554c = r100;
    }
}
