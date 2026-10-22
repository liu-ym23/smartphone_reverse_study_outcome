package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d2<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f158928a = null;

    static {
        f158928a = new d2();
    }

    public d2() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        ExtendedToolbarButton r102 = (ExtendedToolbarButton) r100;
        ExtendedToolbarButton r103 = (ExtendedToolbarButton) r101;
        Intrinsics.checkNotNullParameter(r102, "icon1");
        Intrinsics.checkNotNullParameter(r103, "icon2");
        long r104 = r102.f115619a;
        long r105 = r103.f115619a;
        if (r104 >= r105) goto L5;
        return -1;
    L5:
        if (r104 <= r105) goto L7;
        return 1;
    L7:
        return 0;
    }
}
