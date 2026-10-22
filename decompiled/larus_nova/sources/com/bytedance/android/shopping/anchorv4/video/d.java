package com.bytedance.android.shopping.anchorv4.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f167577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f167580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f167581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f167582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f167583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f167584h;

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public boolean b() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public boolean g(boolean r100) {
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public Boolean j(Boolean r100, boolean r101) {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean a() {
        return this.f167584h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public Long d() {
        return this.f167577a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final String getScene() {
        return this.f167579c;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final Boolean k() {
        return this.f167581e;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final boolean l() {
        return this.f167583g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public boolean m() {
        return this.f167582f;
    }

    public void o(Long r100) {
        this.f167577a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.e
    public final void h(e r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        if (Intrinsics.areEqual(r100, this) == false) goto L7;
        if (r101 == false) goto L8;
        o(Long.valueOf(System.currentTimeMillis()));
        return;
    L8:
        return;
    }

    public void n(boolean r100, boolean r101) {
        this.f167580d.f(r100, r101, this);
        if (r101 == false) goto L6;
        this.f167578b = true;
        return;
    }

    public d(String r100, f r101, Boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 16) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 32) == 0) goto L11;
        r104 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "manager");
        this.f167579c = r100;
        this.f167580d = r101;
        this.f167581e = r102;
        this.f167582f = false;
        this.f167583g = r103;
        this.f167584h = r104;
    }
}
