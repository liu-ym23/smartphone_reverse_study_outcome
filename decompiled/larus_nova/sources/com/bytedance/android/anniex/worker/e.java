package com.bytedance.android.anniex.worker;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "仅用于告知JSB环境这是全局的端智能Worker")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41502a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f41502a, ((e) r100).f41502a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f41502a.hashCode();
    }

    public final String toString() {
        return "AnnieXWorkerTag(tag=" + this.f41502a + ')';
    }

    public e(int r100) {
        Intrinsics.checkNotNullParameter("AnnieXJSWorker", "tag");
        this.f41502a = "AnnieXJSWorker";
    }
}
