package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioControlAction f172608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f172609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f172610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAction f172611d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f172608a, r101.f172608a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172609b, r101.f172609b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172610c, r101.f172610c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172611d, r101.f172611d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        AudioControlAction r100 = this.f172608a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f172609b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f172610c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IAction r110 = this.f172611d;
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
        return "AudioControlParams(actionType=" + this.f172608a + ", sliceId=" + this.f172609b + ", audioInfo=" + this.f172610c + ", onStopAction=" + this.f172611d + ")";
    }

    public b(AudioControlAction r100, String r101, e r102, SlcCommonAction r103) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        this.f172608a = r100;
        this.f172609b = r101;
        this.f172610c = r102;
        this.f172611d = r103;
    }
}
