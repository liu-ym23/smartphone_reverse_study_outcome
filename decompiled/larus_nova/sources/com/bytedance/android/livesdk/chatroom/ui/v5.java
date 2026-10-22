package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.Bitmap;
import android.widget.PopupWindow;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f114267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PopupWindow f114268b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v5) == false) goto L10;
        v5 r101 = (v5) r100;
        if (Intrinsics.areEqual(this.f114267a, r101.f114267a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f114268b, r101.f114268b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Bitmap r100 = this.f114267a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PopupWindow r104 = this.f114268b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DialogInfo(bitmap=" + this.f114267a + ", dialog=" + this.f114268b + ")";
    }

    public v5(Bitmap r100, PopupWindow r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f114267a = r100;
        this.f114268b = r101;
    }
}
