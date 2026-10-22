package com.bytedance.android.live.room.api.panel;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f99048e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelName f99049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f99050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ActionType f99051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f99052d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f99049a, r101.f99049a) == true) goto L8;
        return false;
    L8:
        if (this.f99050b == r101.f99050b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f99051c, r101.f99051c) == true) goto L12;
        return false;
    L12:
        if (this.f99052d == r101.f99052d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        PanelName r100 = this.f99049a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f99050b) * 31;
        ActionType r104 = this.f99051c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f99052d;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PanelInfo(panelName=" + this.f99049a + ", unionId=" + this.f99050b + ", actionType=" + this.f99051c.getType() + ", panelHeight=" + this.f99052d + ')';
    }

    public e(PanelName r100, int r101, ActionType r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "panelName");
        Intrinsics.checkNotNullParameter(r102, ReportConstant.COMMON_ACTION_TYPE);
        this.f99049a = r100;
        this.f99050b = r101;
        this.f99051c = r102;
        this.f99052d = r103;
    }
}
