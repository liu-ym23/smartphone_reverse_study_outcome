package com.bytedance.applet.aibridge.login;

import com.larus.login.api.TouristManager;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements tj9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f191184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<tj9.b> f191185b;

    @Override // tj9.b
    public final void onClose() {
        TouristManager r100 = TouristManager.f357001a;
        r100.p(this.f191184a);
        tj9.b r101 = this.f191185b.element;
        if (r101 == null) goto L6;
        r100.z(r101);
        return;
    }

    @Override // tj9.b
    public final void onOpen() {
        TouristManager.f357001a.v(this.f191184a);
    }

    public a(b r100, Ref.ObjectRef<tj9.b> r101) {
        this.f191184a = r100;
        this.f191185b = r101;
    }
}
