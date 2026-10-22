package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t {
    public static final List<ExtendedToolbarButton> a(List<? extends ToolbarButton> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$extend");
        ArrayList r101 = new ArrayList();
        Iterator<? extends ToolbarButton> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().extended());
        goto L4
    L6:
        return r101;
    }
}
