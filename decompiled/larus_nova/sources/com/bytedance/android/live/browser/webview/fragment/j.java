package com.bytedance.android.live.browser.webview.fragment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        ((j) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(null, null) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "DebugConsoleJsbMsg(consoleMsgTitle=null, consoleMsgTime=null, consoleMsgSubTitle=null, consoleMsgContent1=null, consoleMsgContent2=null)";
    }
}
