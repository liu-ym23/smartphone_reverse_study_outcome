package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f38185a;

    public static final class a {
    }

    static {
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f38185a, ((d) r100).f38185a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<c> r100 = this.f38185a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LabelConfigListDsl(labelDslList=" + this.f38185a + ')';
    }

    public /* synthetic */ d(int r100) {
        this(CollectionsKt.emptyList());
    }

    public d(List<c> r100) {
        this.f38185a = r100;
    }
}
