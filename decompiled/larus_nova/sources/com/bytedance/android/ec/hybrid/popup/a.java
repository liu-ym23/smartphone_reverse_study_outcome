package com.bytedance.android.ec.hybrid.popup;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f47592b;

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int c() {
        return this.f47592b.c();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean d() {
        return this.f47592b.d();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean e() {
        return this.f47592b.e();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int f() {
        return this.f47592b.f();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean g() {
        return this.f47592b.g();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final JSONObject getBcm() {
        return this.f47592b.getBcm();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final String getBtm() {
        return this.f47592b.getBtm();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public int getType() {
        return this.f47592b.getType();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final int h() {
        return this.f47592b.h();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean i() {
        return this.f47592b.i();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean j() {
        return this.f47592b.j();
    }

    @Override // com.bytedance.android.ec.hybrid.popup.f
    public final boolean k() {
        return this.f47592b.k();
    }

    public a(n r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "popupConfig");
        Intrinsics.checkNotNullParameter(r101, "schema");
        this.f47592b = r100;
        this.f47591a = r101;
    }
}
