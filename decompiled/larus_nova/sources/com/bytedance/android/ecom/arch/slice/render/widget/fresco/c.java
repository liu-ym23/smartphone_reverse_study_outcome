package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import com.facebook.common.internal.Objects;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes44.dex */
public final class c<DH extends DraweeHierarchy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f50931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DH f50933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f50934d;

    public final boolean a() {
        h r100 = this.f50934d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f50945d != this.f50933c) goto L7;
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("controllerAttached", this.f50931a).add("holderAttached", this.f50932b).toString();
    }

    public c(@Nullable GenericDraweeHierarchy r100) {
        this.f50931a = false;
        this.f50932b = false;
        this.f50934d = null;
        if (r100 == null) goto L8;
        boolean r101 = a();
        boolean r102 = nq.a.f520084a;
        this.f50933c = r100;
        if (r101 == false) goto L9;
        this.f50934d.g(r100);
        return;
    L9:
        return;
    }
}
