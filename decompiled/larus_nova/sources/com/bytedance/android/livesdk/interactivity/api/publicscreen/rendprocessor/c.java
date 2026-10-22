package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ak6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f133502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f133503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f133504c;

    @Override // ak6.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ak6.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        k.a r101 = this.f133502a;
        if (r101 == null) goto L6;
        r101.a(this.f133503b, new j(r100.f4074a, ((d) this.f133504c.element).f133506b));
        return;
    }

    public c(k.a r100, s r101, Ref.ObjectRef r102) {
        this.f133502a = r100;
        this.f133503b = r101;
        this.f133504c = r102;
    }
}
