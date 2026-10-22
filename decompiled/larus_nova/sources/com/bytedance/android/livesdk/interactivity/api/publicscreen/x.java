package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f133718a;

    public x() {
    }

    public abstract void p(l r100);

    public abstract void q();

    public final l o() {
        n r100 = this.f133718a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPublicScreenContext();
    }

    public final void n(PublicScreenConfig$ViewBinderType r100, j<? extends i, ? extends PSMessageViewHolder> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "viewBinder");
        n r102 = this.f133718a;
        if (r102 == null) goto L6;
        r102.addMessageViewBinder(r100, r101);
        return;
    }
}
