package com.bytedance.android.shopping.anchorv4.launcher;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f167009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f167010b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f167009a, r101.f167009a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167010b, r101.f167010b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.f167009a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DialogFragment r104 = this.f167010b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPageModel(schemaParseModel=" + this.f167009a + ", fragment=" + this.f167010b + ")";
    }

    public b(c r100, AppCompatDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "schemaParseModel");
        this.f167009a = r100;
        this.f167010b = r101;
    }
}
