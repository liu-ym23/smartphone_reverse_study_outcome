package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.livesdk.gift.platform.core.model.s;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<s> f130103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130104b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f130103a, r101.f130103a) == true) goto L8;
        return false;
    L8:
        if (this.f130104b == r101.f130104b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Iterator<s> r100 = this.f130103a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f130104b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "CurrentPlugin(iterator=" + this.f130103a + ", currentPluginPipeline=" + this.f130104b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends s> r100, int r101) {
        this.f130103a = r100;
        this.f130104b = r101;
    }
}
