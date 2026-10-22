package com.bytedance.android.live.effect.sticker.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68491a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f68491a, ((a) r100).f68491a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f68491a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ClickSearchKeywordEvent(keyword=" + this.f68491a + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f68491a = r100;
    }
}
