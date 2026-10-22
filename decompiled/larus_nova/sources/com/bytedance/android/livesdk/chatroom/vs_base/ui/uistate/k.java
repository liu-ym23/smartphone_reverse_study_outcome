package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f118180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f118181b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f118180a, r101.f118180a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f118181b, r101.f118181b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f118180a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FrameLayout r104 = this.f118181b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReplayInteractionMasterViewUIStateResult(layoutView=" + this.f118180a + ", layerMasterView=" + this.f118181b + ")";
    }

    public k(View r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutView");
        Intrinsics.checkNotNullParameter(r101, "layerMasterView");
        this.f118180a = r100;
        this.f118181b = r101;
    }
}
