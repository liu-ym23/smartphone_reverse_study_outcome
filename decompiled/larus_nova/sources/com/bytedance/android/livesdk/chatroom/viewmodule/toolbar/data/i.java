package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.live.core.setting.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class i implements g.b<a2> {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return "PlayTogetherFilter";
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.b
    public final boolean a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        List<? extends String> r101 = m.f65354a.getValue();
        ArrayList r102 = new ArrayList();
        if ((!r101.isEmpty()) == false) goto L11;
        Iterator<? extends String> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        ToolbarButton r104 = ToolbarButton.fromName(r103.next());
        if (r104 == null) goto L6;
        r102.add(r104);
    L11:
        return !CollectionsKt.contains(r102, r100);
    }
}
