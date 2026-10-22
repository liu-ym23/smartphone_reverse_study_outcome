package com.bytedance.android.live.profile.ui.component.base;

import com.bytedance.android.live.profile.model.CompareOperation;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f86441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f86442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f86443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e<T> f86444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompareOperation f86445e;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.f86441a == r101.f86441a) goto L8;
        return false;
    L8:
        if (this.f86442b == r101.f86442b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f86443c, r101.f86443c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f86444d, r101.f86444d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f86445e, r101.f86445e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f86441a * 31) + this.f86442b) * 31;
        T r101 = this.f86443c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        e<T> r105 = this.f86444d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        CompareOperation r108 = this.f86445e;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadedViewInfo(type=" + this.f86441a + ", index=" + this.f86442b + ", data=" + this.f86443c + ", view=" + this.f86444d + ", operation=" + this.f86445e + ")";
    }

    public final int getType() {
        return this.f86441a;
    }

    public final void a(CompareOperation r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f86445e = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(int r100, int r101, b r102, e r103) {
        CompareOperation r104 = CompareOperation.Nothing;
        Intrinsics.checkNotNullParameter(r104, WikiFolderPushPlugin.OPT);
        this.f86441a = r100;
        this.f86442b = r101;
        this.f86443c = r102;
        this.f86444d = r103;
        this.f86445e = r104;
    }
}
