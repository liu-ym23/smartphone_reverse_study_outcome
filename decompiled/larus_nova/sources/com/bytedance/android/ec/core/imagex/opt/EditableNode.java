package com.bytedance.android.ec.core.imagex.opt;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class EditableNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f44788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditableNode f44789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yl.e f44791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p0 f44792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.android.ec.core.imagex.opt.a> f44793f;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        String r100 = this.f44790c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        yl.e r104 = this.f44791d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        p0 r107 = this.f44792e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.android.ec.core.imagex.opt.a> r110 = this.f44793f;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EditableNode(pathNodeName=" + this.f44790c + ", match=" + this.f44791d + ", nodeType=" + this.f44792e + ", arrayMatch=" + this.f44793f + ")";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EditableNode) == false) goto L14;
        EditableNode r101 = (EditableNode) r100;
        if (Intrinsics.areEqual(this.f44790c, r101.f44790c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f44791d, r101.f44791d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44792e, r101.f44792e) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f44793f, r101.f44793f) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public EditableNode(String r100, yl.e r101, p0 r102, List<com.bytedance.android.ec.core.imagex.opt.a> r103) {
        Intrinsics.checkNotNullParameter(r100, "pathNodeName");
        Intrinsics.checkNotNullParameter(r102, "nodeType");
        Intrinsics.checkNotNullParameter(r103, "arrayMatch");
        this.f44790c = r100;
        this.f44791d = r101;
        this.f44792e = r102;
        this.f44793f = r103;
        this.f44788a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new EditableNode$nodeId$2(this));
    }
}
