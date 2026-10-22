package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f35368d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubaoBottomSheetAction f35369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoubaoBottomSheetButtonRole f35370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoubaoBottomSheetCancelSource f35371c;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.bottomsheet.a$a, reason: collision with other inner class name */
    public static final class C0685a {
        public static a a(DoubaoBottomSheetCancelSource r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new a(DoubaoBottomSheetAction.CANCEL, null, r100, 2);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f35369a == r101.f35369a) goto L12;
        return false;
    L12:
        if (this.f35370b == r101.f35370b) goto L15;
        return false;
    L15:
        if (this.f35371c == r101.f35371c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f35369a.hashCode() * 31;
        DoubaoBottomSheetButtonRole r101 = this.f35370b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        DoubaoBottomSheetCancelSource r105 = this.f35371c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoubaoBottomSheetResult(action=" + this.f35369a + ", role=" + this.f35370b + ", source=" + this.f35371c + ')';
    }

    public a(DoubaoBottomSheetAction r100, DoubaoBottomSheetButtonRole r101, DoubaoBottomSheetCancelSource r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f35369a = r100;
        this.f35370b = r101;
        this.f35371c = r102;
    }
}
