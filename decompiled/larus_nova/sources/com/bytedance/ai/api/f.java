package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f34012d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppletBottomSheetAction f34013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppletBottomSheetButtonRole f34014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppletBottomSheetCancelSource f34015c;

    public static final class a {
        public static f a(AppletBottomSheetCancelSource r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new f(AppletBottomSheetAction.CANCEL, null, r100, 2);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f34013a == r101.f34013a) goto L12;
        return false;
    L12:
        if (this.f34014b == r101.f34014b) goto L15;
        return false;
    L15:
        if (this.f34015c == r101.f34015c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f34013a.hashCode() * 31;
        AppletBottomSheetButtonRole r101 = this.f34014b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        AppletBottomSheetCancelSource r105 = this.f34015c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletBottomSheetResult(action=" + this.f34013a + ", role=" + this.f34014b + ", source=" + this.f34015c + ')';
    }

    public f(AppletBottomSheetAction r100, AppletBottomSheetButtonRole r101, AppletBottomSheetCancelSource r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f34013a = r100;
        this.f34014b = r101;
        this.f34015c = r102;
    }
}
