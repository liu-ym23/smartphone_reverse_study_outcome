package com.bytedance.android.livesdk.widget;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h1 implements com.bytedance.android.livesdk.pannel.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveBottomSheetDialog.l f161739a;

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean f(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return false;
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean a() {
        return this.f161739a.a();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean b() {
        return this.f161739a.b();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean c() {
        return this.f161739a.c();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean d() {
        return this.f161739a.d();
    }

    @Override // com.bytedance.android.livesdk.pannel.e
    public final boolean e() {
        return this.f161739a.e();
    }

    public h1(LiveBottomSheetDialog.l r100) {
        this.f161739a = r100;
    }
}
